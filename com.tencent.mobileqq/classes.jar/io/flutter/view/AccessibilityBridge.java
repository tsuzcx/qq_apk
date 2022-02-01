package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccessibilityBridge
  extends AccessibilityNodeProvider
{
  private static final int ACTION_SHOW_ON_SCREEN = 16908342;
  private static int FIRST_RESOURCE_ID = 267386881;
  private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
  private static final int ROOT_NODE_ID = 0;
  private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0F;
  private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0F;
  private static final String TAG = "AccessibilityBridge";
  @NonNull
  private final AccessibilityChannel accessibilityChannel;
  private int accessibilityFeatureFlags = 0;
  @Nullable
  private AccessibilityBridge.SemanticsNode accessibilityFocusedSemanticsNode;
  @NonNull
  private final AccessibilityManager accessibilityManager;
  private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler = new AccessibilityBridge.1(this);
  private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityBridge.2(this);
  @NonNull
  private final AccessibilityViewEmbedder accessibilityViewEmbedder;
  private final ContentObserver animationScaleObserver = new AccessibilityBridge.3(this, new Handler());
  @NonNull
  private final ContentResolver contentResolver;
  @NonNull
  private final Map<Integer, AccessibilityBridge.CustomAccessibilityAction> customAccessibilityActions = new HashMap();
  private Integer embeddedAccessibilityFocusedNodeId;
  private Integer embeddedInputFocusedNodeId;
  @NonNull
  private final List<Integer> flutterNavigationStack = new ArrayList();
  @NonNull
  private final Map<Integer, AccessibilityBridge.SemanticsNode> flutterSemanticsTree = new HashMap();
  @Nullable
  private AccessibilityBridge.SemanticsNode hoveredObject;
  @Nullable
  private AccessibilityBridge.SemanticsNode inputFocusedSemanticsNode;
  @Nullable
  private AccessibilityBridge.SemanticsNode lastInputFocusedSemanticsNode;
  @NonNull
  private Integer lastLeftFrameInset = Integer.valueOf(0);
  @Nullable
  private AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
  @NonNull
  private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
  private int previousRouteId = 0;
  @NonNull
  private final View rootAccessibilityView;
  @TargetApi(19)
  @RequiresApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
  
  public AccessibilityBridge(@NonNull View paramView, @NonNull AccessibilityChannel paramAccessibilityChannel, @NonNull AccessibilityManager paramAccessibilityManager, @NonNull ContentResolver paramContentResolver, PlatformViewsAccessibilityDelegate paramPlatformViewsAccessibilityDelegate)
  {
    this.rootAccessibilityView = paramView;
    this.accessibilityChannel = paramAccessibilityChannel;
    this.accessibilityManager = paramAccessibilityManager;
    this.contentResolver = paramContentResolver;
    this.platformViewsAccessibilityDelegate = paramPlatformViewsAccessibilityDelegate;
    this.accessibilityStateChangeListener.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.touchExplorationStateChangeListener = new AccessibilityBridge.4(this, paramAccessibilityManager);
      this.touchExplorationStateChangeListener.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.animationScaleObserver.onChange(false);
        paramAccessibilityChannel = Settings.Global.getUriFor("transition_animation_scale");
        this.contentResolver.registerContentObserver(paramAccessibilityChannel, false, this.animationScaleObserver);
      }
      if (paramPlatformViewsAccessibilityDelegate != null) {
        paramPlatformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
      }
      this.accessibilityViewEmbedder = new AccessibilityViewEmbedder(paramView, 65536);
      return;
      this.touchExplorationStateChangeListener = null;
    }
  }
  
  private AccessibilityEvent createTextChangedEvent(int paramInt, String paramString1, String paramString2)
  {
    AccessibilityEvent localAccessibilityEvent = obtainAccessibilityEvent(paramInt, 16);
    localAccessibilityEvent.setBeforeText(paramString1);
    localAccessibilityEvent.getText().add(paramString2);
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= paramString1.length()) || (paramInt >= paramString2.length()) || (paramString1.charAt(paramInt) != paramString2.charAt(paramInt)))
      {
        if ((paramInt < paramString1.length()) || (paramInt < paramString2.length())) {
          break;
        }
        return null;
      }
      paramInt += 1;
    }
    localAccessibilityEvent.setFromIndex(paramInt);
    int j = paramString1.length() - 1;
    int i = paramString2.length() - 1;
    for (;;)
    {
      if ((j < paramInt) || (i < paramInt) || (paramString1.charAt(j) != paramString2.charAt(i)))
      {
        localAccessibilityEvent.setRemovedCount(j - paramInt + 1);
        localAccessibilityEvent.setAddedCount(i - paramInt + 1);
        return localAccessibilityEvent;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  private AccessibilityBridge.CustomAccessibilityAction getOrCreateAccessibilityAction(int paramInt)
  {
    AccessibilityBridge.CustomAccessibilityAction localCustomAccessibilityAction2 = (AccessibilityBridge.CustomAccessibilityAction)this.customAccessibilityActions.get(Integer.valueOf(paramInt));
    AccessibilityBridge.CustomAccessibilityAction localCustomAccessibilityAction1 = localCustomAccessibilityAction2;
    if (localCustomAccessibilityAction2 == null)
    {
      localCustomAccessibilityAction1 = new AccessibilityBridge.CustomAccessibilityAction();
      AccessibilityBridge.CustomAccessibilityAction.access$3602(localCustomAccessibilityAction1, paramInt);
      AccessibilityBridge.CustomAccessibilityAction.access$3102(localCustomAccessibilityAction1, FIRST_RESOURCE_ID + paramInt);
      this.customAccessibilityActions.put(Integer.valueOf(paramInt), localCustomAccessibilityAction1);
    }
    return localCustomAccessibilityAction1;
  }
  
  private AccessibilityBridge.SemanticsNode getOrCreateSemanticsNode(int paramInt)
  {
    AccessibilityBridge.SemanticsNode localSemanticsNode2 = (AccessibilityBridge.SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(paramInt));
    AccessibilityBridge.SemanticsNode localSemanticsNode1 = localSemanticsNode2;
    if (localSemanticsNode2 == null)
    {
      localSemanticsNode1 = new AccessibilityBridge.SemanticsNode(this);
      AccessibilityBridge.SemanticsNode.access$1602(localSemanticsNode1, paramInt);
      this.flutterSemanticsTree.put(Integer.valueOf(paramInt), localSemanticsNode1);
    }
    return localSemanticsNode1;
  }
  
  private AccessibilityBridge.SemanticsNode getRootSemanticsNode()
  {
    return (AccessibilityBridge.SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(0));
  }
  
  private void handleTouchExploration(float paramFloat1, float paramFloat2)
  {
    if (this.flutterSemanticsTree.isEmpty()) {}
    AccessibilityBridge.SemanticsNode localSemanticsNode;
    do
    {
      return;
      localSemanticsNode = AccessibilityBridge.SemanticsNode.access$3700(getRootSemanticsNode(), new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    } while (localSemanticsNode == this.hoveredObject);
    if (localSemanticsNode != null) {
      sendAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600(localSemanticsNode), 128);
    }
    if (this.hoveredObject != null) {
      sendAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600(this.hoveredObject), 256);
    }
    this.hoveredObject = localSemanticsNode;
  }
  
  private AccessibilityEvent obtainAccessibilityEvent(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityEvent.setSource(this.rootAccessibilityView, paramInt1);
    return localAccessibilityEvent;
  }
  
  private void onTouchExplorationExit()
  {
    if (this.hoveredObject != null)
    {
      sendAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600(this.hoveredObject), 256);
      this.hoveredObject = null;
    }
  }
  
  @TargetApi(18)
  @RequiresApi(18)
  private boolean performCursorMoveAction(@NonNull AccessibilityBridge.SemanticsNode paramSemanticsNode, int paramInt, @NonNull Bundle paramBundle, boolean paramBoolean)
  {
    int i = paramBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    boolean bool = paramBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    switch (i)
    {
    }
    do
    {
      do
      {
        return false;
        if ((paramBoolean) && (AccessibilityBridge.SemanticsNode.access$2100(paramSemanticsNode, AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_WORD)))
        {
          this.accessibilityChannel.dispatchSemanticsAction(paramInt, AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(bool));
          return true;
        }
      } while ((paramBoolean) || (!AccessibilityBridge.SemanticsNode.access$2100(paramSemanticsNode, AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_WORD)));
      this.accessibilityChannel.dispatchSemanticsAction(paramInt, AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(bool));
      return true;
      if ((paramBoolean) && (AccessibilityBridge.SemanticsNode.access$2100(paramSemanticsNode, AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)))
      {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt, AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(bool));
        return true;
      }
    } while ((paramBoolean) || (!AccessibilityBridge.SemanticsNode.access$2100(paramSemanticsNode, AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)));
    this.accessibilityChannel.dispatchSemanticsAction(paramInt, AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(bool));
    return true;
  }
  
  private void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    if (!this.accessibilityManager.isEnabled()) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.rootAccessibilityView.sendAccessibilityEvent(paramInt2);
      return;
    }
    sendAccessibilityEvent(obtainAccessibilityEvent(paramInt1, paramInt2));
  }
  
  private void sendAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    if (!this.accessibilityManager.isEnabled()) {
      return;
    }
    this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, paramAccessibilityEvent);
  }
  
  private void sendLatestAccessibilityFlagsToFlutter()
  {
    this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
  }
  
  private void sendWindowChangeEvent(@NonNull AccessibilityBridge.SemanticsNode paramSemanticsNode)
  {
    AccessibilityEvent localAccessibilityEvent = obtainAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600(paramSemanticsNode), 32);
    paramSemanticsNode = AccessibilityBridge.SemanticsNode.access$5900(paramSemanticsNode);
    localAccessibilityEvent.getText().add(paramSemanticsNode);
    sendAccessibilityEvent(localAccessibilityEvent);
  }
  
  private void sendWindowContentChangeEvent(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = obtainAccessibilityEvent(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    sendAccessibilityEvent(localAccessibilityEvent);
  }
  
  private boolean shouldSetCollectionInfo(AccessibilityBridge.SemanticsNode paramSemanticsNode)
  {
    return (AccessibilityBridge.SemanticsNode.access$1200(paramSemanticsNode) > 0) && ((AccessibilityBridge.SemanticsNode.access$1300(this.accessibilityFocusedSemanticsNode, new _..Lambda.AccessibilityBridge.JBDpWWlF54eN0gel8Jn1hY7yOmE(paramSemanticsNode))) || (!AccessibilityBridge.SemanticsNode.access$1300(this.accessibilityFocusedSemanticsNode, _..Lambda.AccessibilityBridge._xgAbWhyKyeHrMGUVUYzbSFEeBY.INSTANCE)));
  }
  
  private void willRemoveSemanticsNode(AccessibilityBridge.SemanticsNode paramSemanticsNode)
  {
    AccessibilityBridge.SemanticsNode.access$2502(paramSemanticsNode, null);
    if (this.accessibilityFocusedSemanticsNode == paramSemanticsNode)
    {
      sendAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode), 65536);
      this.accessibilityFocusedSemanticsNode = null;
    }
    if (this.inputFocusedSemanticsNode == paramSemanticsNode) {
      this.inputFocusedSemanticsNode = null;
    }
    if (this.hoveredObject == paramSemanticsNode) {
      this.hoveredObject = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt >= 65536) {
      localObject1 = this.accessibilityViewEmbedder.createAccessibilityNodeInfo(paramInt);
    }
    do
    {
      return localObject1;
      if (paramInt != -1) {
        break;
      }
      localObject2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject2);
      localObject1 = localObject2;
    } while (!this.flutterSemanticsTree.containsKey(Integer.valueOf(0)));
    ((AccessibilityNodeInfo)localObject2).addChild(this.rootAccessibilityView, 0);
    return localObject2;
    Object localObject1 = (AccessibilityBridge.SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      return null;
    }
    Object localObject3;
    if (AccessibilityBridge.SemanticsNode.access$1400((AccessibilityBridge.SemanticsNode)localObject1) != -1)
    {
      localObject2 = this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(AccessibilityBridge.SemanticsNode.access$1400((AccessibilityBridge.SemanticsNode)localObject1)));
      localObject3 = AccessibilityBridge.SemanticsNode.access$1500((AccessibilityBridge.SemanticsNode)localObject1);
      return this.accessibilityViewEmbedder.getRootNode((View)localObject2, AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject1), (Rect)localObject3);
    }
    Object localObject2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    if (Build.VERSION.SDK_INT >= 18) {
      ((AccessibilityNodeInfo)localObject2).setViewIdResourceName("");
    }
    ((AccessibilityNodeInfo)localObject2).setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    ((AccessibilityNodeInfo)localObject2).setClassName("android.view.View");
    ((AccessibilityNodeInfo)localObject2).setSource(this.rootAccessibilityView, paramInt);
    ((AccessibilityNodeInfo)localObject2).setFocusable(AccessibilityBridge.SemanticsNode.access$1700((AccessibilityBridge.SemanticsNode)localObject1));
    boolean bool1;
    label273:
    int j;
    label432:
    int i;
    label539:
    label759:
    Object localObject4;
    label819:
    label857:
    boolean bool4;
    if (this.inputFocusedSemanticsNode != null)
    {
      if (AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode) == paramInt)
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setFocused(bool1);
      }
    }
    else
    {
      if (this.accessibilityFocusedSemanticsNode != null)
      {
        if (AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode) != paramInt) {
          break label1474;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setAccessibilityFocused(bool1);
      }
      if (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_TEXT_FIELD))
      {
        ((AccessibilityNodeInfo)localObject2).setPassword(AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_OBSCURED));
        if (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_READ_ONLY)) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.EditText");
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          ((AccessibilityNodeInfo)localObject2).setEditable(AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_READ_ONLY) ^ true);
          if ((AccessibilityBridge.SemanticsNode.access$1900((AccessibilityBridge.SemanticsNode)localObject1) != -1) && (AccessibilityBridge.SemanticsNode.access$2000((AccessibilityBridge.SemanticsNode)localObject1) != -1)) {
            ((AccessibilityNodeInfo)localObject2).setTextSelection(AccessibilityBridge.SemanticsNode.access$1900((AccessibilityBridge.SemanticsNode)localObject1), AccessibilityBridge.SemanticsNode.access$2000((AccessibilityBridge.SemanticsNode)localObject1));
          }
          if ((Build.VERSION.SDK_INT > 18) && (this.accessibilityFocusedSemanticsNode != null) && (AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode) == paramInt)) {
            ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
          }
        }
        if (!AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
          break label1480;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(256);
        j = 1;
        i = j;
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER))
        {
          ((AccessibilityNodeInfo)localObject2).addAction(512);
          i = j | 0x1;
        }
        j = i;
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_WORD))
        {
          ((AccessibilityNodeInfo)localObject2).addAction(256);
          j = i | 0x2;
        }
        i = j;
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_WORD))
        {
          ((AccessibilityNodeInfo)localObject2).addAction(512);
          i = j | 0x2;
        }
        ((AccessibilityNodeInfo)localObject2).setMovementGranularities(i);
        if ((Build.VERSION.SDK_INT >= 21) && (AccessibilityBridge.SemanticsNode.access$2200((AccessibilityBridge.SemanticsNode)localObject1) >= 0))
        {
          if (AccessibilityBridge.SemanticsNode.access$2300((AccessibilityBridge.SemanticsNode)localObject1) != null) {
            break label1485;
          }
          i = 0;
          AccessibilityBridge.SemanticsNode.access$2400((AccessibilityBridge.SemanticsNode)localObject1);
          AccessibilityBridge.SemanticsNode.access$2200((AccessibilityBridge.SemanticsNode)localObject1);
          ((AccessibilityNodeInfo)localObject2).setMaxTextLength(i - AccessibilityBridge.SemanticsNode.access$2400((AccessibilityBridge.SemanticsNode)localObject1) + AccessibilityBridge.SemanticsNode.access$2200((AccessibilityBridge.SemanticsNode)localObject1));
        }
      }
      if (Build.VERSION.SDK_INT > 18)
      {
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SET_SELECTION)) {
          ((AccessibilityNodeInfo)localObject2).addAction(131072);
        }
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.COPY)) {
          ((AccessibilityNodeInfo)localObject2).addAction(16384);
        }
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.CUT)) {
          ((AccessibilityNodeInfo)localObject2).addAction(65536);
        }
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.PASTE)) {
          ((AccessibilityNodeInfo)localObject2).addAction(32768);
        }
      }
      if ((AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_BUTTON)) || (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_LINK))) {
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Button");
      }
      if (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_IMAGE)) {
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ImageView");
      }
      if ((Build.VERSION.SDK_INT > 18) && (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.DISMISS)))
      {
        ((AccessibilityNodeInfo)localObject2).setDismissable(true);
        ((AccessibilityNodeInfo)localObject2).addAction(1048576);
      }
      if (AccessibilityBridge.SemanticsNode.access$2500((AccessibilityBridge.SemanticsNode)localObject1) == null) {
        break label1497;
      }
      ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView, AccessibilityBridge.SemanticsNode.access$1600(AccessibilityBridge.SemanticsNode.access$2500((AccessibilityBridge.SemanticsNode)localObject1)));
      localObject3 = AccessibilityBridge.SemanticsNode.access$1500((AccessibilityBridge.SemanticsNode)localObject1);
      if (AccessibilityBridge.SemanticsNode.access$2500((AccessibilityBridge.SemanticsNode)localObject1) == null) {
        break label1509;
      }
      localObject4 = AccessibilityBridge.SemanticsNode.access$1500(AccessibilityBridge.SemanticsNode.access$2500((AccessibilityBridge.SemanticsNode)localObject1));
      Rect localRect = new Rect((Rect)localObject3);
      localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
      ((AccessibilityNodeInfo)localObject2).setBoundsInParent(localRect);
      ((AccessibilityNodeInfo)localObject2).setBoundsInScreen((Rect)localObject3);
      ((AccessibilityNodeInfo)localObject2).setVisibleToUser(true);
      if ((AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.HAS_ENABLED_STATE)) && (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_ENABLED))) {
        break label1519;
      }
      bool1 = true;
      ((AccessibilityNodeInfo)localObject2).setEnabled(bool1);
      if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.TAP))
      {
        if ((Build.VERSION.SDK_INT < 21) || (AccessibilityBridge.SemanticsNode.access$2600((AccessibilityBridge.SemanticsNode)localObject1) == null)) {
          break label1525;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, AccessibilityBridge.CustomAccessibilityAction.access$2700(AccessibilityBridge.SemanticsNode.access$2600((AccessibilityBridge.SemanticsNode)localObject1))));
        ((AccessibilityNodeInfo)localObject2).setClickable(true);
      }
      label919:
      if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.LONG_PRESS))
      {
        if ((Build.VERSION.SDK_INT < 21) || (AccessibilityBridge.SemanticsNode.access$2800((AccessibilityBridge.SemanticsNode)localObject1) == null)) {
          break label1541;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, AccessibilityBridge.CustomAccessibilityAction.access$2700(AccessibilityBridge.SemanticsNode.access$2800((AccessibilityBridge.SemanticsNode)localObject1))));
        ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
      }
      label974:
      if ((AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_LEFT)) || (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_UP)) || (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_RIGHT)) || (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_DOWN)))
      {
        ((AccessibilityNodeInfo)localObject2).setScrollable(true);
        if (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING))
        {
          if ((!AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_LEFT)) && (!AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_RIGHT))) {
            break label1557;
          }
          if ((Build.VERSION.SDK_INT <= 19) || (!shouldSetCollectionInfo((AccessibilityBridge.SemanticsNode)localObject1))) {
            break label1603;
          }
          ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, AccessibilityBridge.SemanticsNode.access$1200((AccessibilityBridge.SemanticsNode)localObject1), false));
        }
        if ((AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_LEFT)) || (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_UP))) {
          ((AccessibilityNodeInfo)localObject2).addAction(4096);
        }
        if ((AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_RIGHT)) || (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.SCROLL_DOWN))) {
          ((AccessibilityNodeInfo)localObject2).addAction(8192);
        }
      }
      label1089:
      if ((AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.INCREASE)) || (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.DECREASE)))
      {
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.SeekBar");
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.INCREASE)) {
          ((AccessibilityNodeInfo)localObject2).addAction(4096);
        }
        if (AccessibilityBridge.SemanticsNode.access$2100((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Action.DECREASE)) {
          ((AccessibilityNodeInfo)localObject2).addAction(8192);
        }
      }
      if ((AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_LIVE_REGION)) && (Build.VERSION.SDK_INT > 18)) {
        ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
      }
      boolean bool3 = AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.HAS_CHECKED_STATE);
      bool4 = AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.HAS_TOGGLED_STATE);
      if (!bool3)
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
      ((AccessibilityNodeInfo)localObject2).setCheckable(bool1);
      if (!bool3) {
        break label1625;
      }
      ((AccessibilityNodeInfo)localObject2).setChecked(AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_CHECKED));
      ((AccessibilityNodeInfo)localObject2).setContentDescription(AccessibilityBridge.SemanticsNode.access$2900((AccessibilityBridge.SemanticsNode)localObject1));
      if (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
        break label1614;
      }
      ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.RadioButton");
      label1333:
      ((AccessibilityNodeInfo)localObject2).setSelected(AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_SELECTED));
      if (Build.VERSION.SDK_INT >= 28) {
        ((AccessibilityNodeInfo)localObject2).setHeading(AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_HEADER));
      }
      if ((this.accessibilityFocusedSemanticsNode == null) || (AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode) != paramInt)) {
        break label1688;
      }
      ((AccessibilityNodeInfo)localObject2).addAction(128);
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT < 21) || (AccessibilityBridge.SemanticsNode.access$3000((AccessibilityBridge.SemanticsNode)localObject1) == null)) {
        break label1698;
      }
      localObject3 = AccessibilityBridge.SemanticsNode.access$3000((AccessibilityBridge.SemanticsNode)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AccessibilityBridge.CustomAccessibilityAction)((Iterator)localObject3).next();
        ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(AccessibilityBridge.CustomAccessibilityAction.access$3100((AccessibilityBridge.CustomAccessibilityAction)localObject4), AccessibilityBridge.CustomAccessibilityAction.access$3200((AccessibilityBridge.CustomAccessibilityAction)localObject4)));
      }
      bool1 = false;
      break;
      label1474:
      bool1 = false;
      break label273;
      label1480:
      j = 0;
      break label432;
      label1485:
      i = AccessibilityBridge.SemanticsNode.access$2300((AccessibilityBridge.SemanticsNode)localObject1).length();
      break label539;
      label1497:
      ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView);
      break label759;
      label1509:
      ((AccessibilityNodeInfo)localObject2).setBoundsInParent((Rect)localObject3);
      break label819;
      label1519:
      bool1 = false;
      break label857;
      label1525:
      ((AccessibilityNodeInfo)localObject2).addAction(16);
      ((AccessibilityNodeInfo)localObject2).setClickable(true);
      break label919;
      label1541:
      ((AccessibilityNodeInfo)localObject2).addAction(32);
      ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
      break label974;
      label1557:
      if ((Build.VERSION.SDK_INT > 18) && (shouldSetCollectionInfo((AccessibilityBridge.SemanticsNode)localObject1)))
      {
        ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(AccessibilityBridge.SemanticsNode.access$1200((AccessibilityBridge.SemanticsNode)localObject1), 0, false));
        break label1089;
      }
      ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ScrollView");
      break label1089;
      label1603:
      ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.HorizontalScrollView");
      break label1089;
      label1614:
      ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.CheckBox");
      break label1333;
      label1625:
      if (bool4)
      {
        ((AccessibilityNodeInfo)localObject2).setChecked(AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.IS_TOGGLED));
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Switch");
        ((AccessibilityNodeInfo)localObject2).setContentDescription(AccessibilityBridge.SemanticsNode.access$2900((AccessibilityBridge.SemanticsNode)localObject1));
        break label1333;
      }
      if (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject1, AccessibilityBridge.Flag.SCOPES_ROUTE)) {
        break label1333;
      }
      ((AccessibilityNodeInfo)localObject2).setText(AccessibilityBridge.SemanticsNode.access$2900((AccessibilityBridge.SemanticsNode)localObject1));
      break label1333;
      label1688:
      ((AccessibilityNodeInfo)localObject2).addAction(64);
    }
    label1698:
    localObject1 = AccessibilityBridge.SemanticsNode.access$3300((AccessibilityBridge.SemanticsNode)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (AccessibilityBridge.SemanticsNode)((Iterator)localObject1).next();
      if (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject3, AccessibilityBridge.Flag.IS_HIDDEN)) {
        ((AccessibilityNodeInfo)localObject2).addChild(this.rootAccessibilityView, AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject3));
      }
    }
    return localObject2;
  }
  
  public boolean externalViewRequestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(paramView1, paramView2, paramAccessibilityEvent)) {}
    do
    {
      return false;
      paramView1 = this.accessibilityViewEmbedder.getRecordFlutterId(paramView1, paramAccessibilityEvent);
    } while (paramView1 == null);
    int i = paramAccessibilityEvent.getEventType();
    if (i != 8) {
      if (i != 128) {
        if (i != 32768) {
          if (i == 65536) {}
        }
      }
    }
    for (;;)
    {
      return true;
      this.embeddedInputFocusedNodeId = null;
      this.embeddedAccessibilityFocusedNodeId = null;
      continue;
      this.embeddedAccessibilityFocusedNodeId = paramView1;
      this.accessibilityFocusedSemanticsNode = null;
      continue;
      this.hoveredObject = null;
      continue;
      this.embeddedInputFocusedNodeId = paramView1;
      this.inputFocusedSemanticsNode = null;
    }
  }
  
  public AccessibilityNodeInfo findFocus(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return null;
      if (this.inputFocusedSemanticsNode != null) {
        return createAccessibilityNodeInfo(AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode));
      }
      if (this.embeddedInputFocusedNodeId != null) {
        return createAccessibilityNodeInfo(this.embeddedInputFocusedNodeId.intValue());
      }
      if (this.accessibilityFocusedSemanticsNode != null) {
        return createAccessibilityNodeInfo(AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode));
      }
    } while (this.embeddedAccessibilityFocusedNodeId == null);
    return createAccessibilityNodeInfo(this.embeddedAccessibilityFocusedNodeId.intValue());
  }
  
  public boolean isAccessibilityEnabled()
  {
    return this.accessibilityManager.isEnabled();
  }
  
  public boolean isTouchExplorationEnabled()
  {
    return this.accessibilityManager.isTouchExplorationEnabled();
  }
  
  public boolean onAccessibilityHoverEvent(MotionEvent paramMotionEvent)
  {
    if (!this.accessibilityManager.isTouchExplorationEnabled()) {}
    while (this.flutterSemanticsTree.isEmpty()) {
      return false;
    }
    Object localObject = AccessibilityBridge.SemanticsNode.access$3700(getRootSemanticsNode(), new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if (AccessibilityBridge.SemanticsNode.access$1400((AccessibilityBridge.SemanticsNode)localObject) != -1) {
      return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject), paramMotionEvent);
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      handleTouchExploration(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      onTouchExplorationExit();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unexpected accessibility hover event: ");
    ((StringBuilder)localObject).append(paramMotionEvent);
    Log.d("flutter", ((StringBuilder)localObject).toString());
    return false;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, @Nullable Bundle paramBundle)
  {
    int i = 0;
    if (paramInt1 >= 65536)
    {
      boolean bool = this.accessibilityViewEmbedder.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.embeddedAccessibilityFocusedNodeId = null;
      }
      return bool;
    }
    AccessibilityBridge.SemanticsNode localSemanticsNode = (AccessibilityBridge.SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(paramInt1));
    if (localSemanticsNode == null) {
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = FIRST_RESOURCE_ID;
      paramBundle = (AccessibilityBridge.CustomAccessibilityAction)this.customAccessibilityActions.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.CUSTOM_ACTION, Integer.valueOf(AccessibilityBridge.CustomAccessibilityAction.access$3600(paramBundle)));
        return true;
      }
      break;
    case 16908342: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.SHOW_ON_SCREEN);
      return true;
    case 1048576: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.DISMISS);
      return true;
    case 131072: 
      if (Build.VERSION.SDK_INT < 18) {
        return false;
      }
      HashMap localHashMap = new HashMap();
      paramInt2 = i;
      if (paramBundle != null)
      {
        paramInt2 = i;
        if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT"))
        {
          paramInt2 = i;
          if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 != 0)
      {
        localHashMap.put("base", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
        localHashMap.put("extent", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
      }
      for (;;)
      {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.SET_SELECTION, localHashMap);
        return true;
        localHashMap.put("base", Integer.valueOf(AccessibilityBridge.SemanticsNode.access$2000(localSemanticsNode)));
        localHashMap.put("extent", Integer.valueOf(AccessibilityBridge.SemanticsNode.access$2000(localSemanticsNode)));
      }
    case 65536: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.CUT);
      return true;
    case 32768: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.PASTE);
      return true;
    case 16384: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.COPY);
      return true;
    case 8192: 
      if (AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.SCROLL_DOWN)) {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.SCROLL_DOWN);
      }
      for (;;)
      {
        return true;
        if (AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.SCROLL_RIGHT))
        {
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.SCROLL_RIGHT);
        }
        else
        {
          if (!AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.DECREASE)) {
            break;
          }
          AccessibilityBridge.SemanticsNode.access$2302(localSemanticsNode, AccessibilityBridge.SemanticsNode.access$3500(localSemanticsNode));
          sendAccessibilityEvent(paramInt1, 4);
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.DECREASE);
        }
      }
      return false;
    case 4096: 
      if (AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.SCROLL_UP)) {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.SCROLL_UP);
      }
      for (;;)
      {
        return true;
        if (AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.SCROLL_LEFT))
        {
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.SCROLL_LEFT);
        }
        else
        {
          if (!AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.INCREASE)) {
            break;
          }
          AccessibilityBridge.SemanticsNode.access$2302(localSemanticsNode, AccessibilityBridge.SemanticsNode.access$3400(localSemanticsNode));
          sendAccessibilityEvent(paramInt1, 4);
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.INCREASE);
        }
      }
      return false;
    case 512: 
      if (Build.VERSION.SDK_INT < 18) {
        return false;
      }
      return performCursorMoveAction(localSemanticsNode, paramInt1, paramBundle, false);
    case 256: 
      if (Build.VERSION.SDK_INT < 18) {
        return false;
      }
      return performCursorMoveAction(localSemanticsNode, paramInt1, paramBundle, true);
    case 128: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.DID_LOSE_ACCESSIBILITY_FOCUS);
      sendAccessibilityEvent(paramInt1, 65536);
      this.accessibilityFocusedSemanticsNode = null;
      this.embeddedAccessibilityFocusedNodeId = null;
      return true;
    case 64: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.DID_GAIN_ACCESSIBILITY_FOCUS);
      sendAccessibilityEvent(paramInt1, 32768);
      if (this.accessibilityFocusedSemanticsNode == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.accessibilityFocusedSemanticsNode = localSemanticsNode;
      if ((AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.INCREASE)) || (AccessibilityBridge.SemanticsNode.access$2100(localSemanticsNode, AccessibilityBridge.Action.DECREASE))) {
        sendAccessibilityEvent(paramInt1, 4);
      }
      return true;
    case 32: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.LONG_PRESS);
      return true;
    case 16: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, AccessibilityBridge.Action.TAP);
      return true;
    }
    return false;
  }
  
  public void release()
  {
    if (this.platformViewsAccessibilityDelegate != null) {
      this.platformViewsAccessibilityDelegate.detachAccessibiltyBridge();
    }
    setOnAccessibilityChangeListener(null);
    this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
    if (Build.VERSION.SDK_INT >= 19) {
      this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
    }
    this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
  }
  
  public void reset()
  {
    this.flutterSemanticsTree.clear();
    if (this.accessibilityFocusedSemanticsNode != null) {
      sendAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode), 65536);
    }
    this.accessibilityFocusedSemanticsNode = null;
    this.hoveredObject = null;
    sendWindowContentChangeEvent(0);
  }
  
  public void setOnAccessibilityChangeListener(@Nullable AccessibilityBridge.OnAccessibilityChangeListener paramOnAccessibilityChangeListener)
  {
    this.onAccessibilityChangeListener = paramOnAccessibilityChangeListener;
  }
  
  void updateCustomAccessibilityActions(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    if (paramByteBuffer.hasRemaining())
    {
      AccessibilityBridge.CustomAccessibilityAction localCustomAccessibilityAction = getOrCreateAccessibilityAction(paramByteBuffer.getInt());
      AccessibilityBridge.CustomAccessibilityAction.access$3802(localCustomAccessibilityAction, paramByteBuffer.getInt());
      int i = paramByteBuffer.getInt();
      if (i == -1)
      {
        str = null;
        label40:
        AccessibilityBridge.CustomAccessibilityAction.access$3202(localCustomAccessibilityAction, str);
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label80;
        }
      }
      label80:
      for (String str = null;; str = paramArrayOfString[i])
      {
        AccessibilityBridge.CustomAccessibilityAction.access$2702(localCustomAccessibilityAction, str);
        break;
        str = paramArrayOfString[i];
        break label40;
      }
    }
  }
  
  void updateSemantics(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    Object localObject1 = new ArrayList();
    while (paramByteBuffer.hasRemaining())
    {
      localObject2 = getOrCreateSemanticsNode(paramByteBuffer.getInt());
      AccessibilityBridge.SemanticsNode.access$3900((AccessibilityBridge.SemanticsNode)localObject2, paramByteBuffer, paramArrayOfString);
      if (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_HIDDEN))
      {
        if (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_FOCUSED)) {
          this.inputFocusedSemanticsNode = ((AccessibilityBridge.SemanticsNode)localObject2);
        }
        if (AccessibilityBridge.SemanticsNode.access$4000((AccessibilityBridge.SemanticsNode)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
    }
    Object localObject2 = new HashSet();
    paramByteBuffer = getRootSemanticsNode();
    ArrayList localArrayList = new ArrayList();
    if (paramByteBuffer != null)
    {
      paramArrayOfString = new float[16];
      Matrix.setIdentityM(paramArrayOfString, 0);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject3 = this.rootAccessibilityView.getRootWindowInsets();
        if (localObject3 != null)
        {
          if (!this.lastLeftFrameInset.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
          {
            AccessibilityBridge.SemanticsNode.access$4102(paramByteBuffer, true);
            AccessibilityBridge.SemanticsNode.access$4202(paramByteBuffer, true);
          }
          this.lastLeftFrameInset = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
          Matrix.translateM(paramArrayOfString, 0, this.lastLeftFrameInset.intValue(), 0.0F, 0.0F);
        }
      }
      AccessibilityBridge.SemanticsNode.access$4300(paramByteBuffer, paramArrayOfString, (Set)localObject2, false);
      AccessibilityBridge.SemanticsNode.access$4400(paramByteBuffer, localArrayList);
    }
    Object localObject3 = localArrayList.iterator();
    paramByteBuffer = null;
    while (((Iterator)localObject3).hasNext())
    {
      paramArrayOfString = (AccessibilityBridge.SemanticsNode)((Iterator)localObject3).next();
      if (!this.flutterNavigationStack.contains(Integer.valueOf(AccessibilityBridge.SemanticsNode.access$1600(paramArrayOfString)))) {
        paramByteBuffer = paramArrayOfString;
      }
    }
    paramArrayOfString = paramByteBuffer;
    if (paramByteBuffer == null)
    {
      paramArrayOfString = paramByteBuffer;
      if (localArrayList.size() > 0) {
        paramArrayOfString = (AccessibilityBridge.SemanticsNode)localArrayList.get(localArrayList.size() - 1);
      }
    }
    if ((paramArrayOfString != null) && (AccessibilityBridge.SemanticsNode.access$1600(paramArrayOfString) != this.previousRouteId))
    {
      this.previousRouteId = AccessibilityBridge.SemanticsNode.access$1600(paramArrayOfString);
      sendWindowChangeEvent(paramArrayOfString);
    }
    this.flutterNavigationStack.clear();
    paramByteBuffer = localArrayList.iterator();
    while (paramByteBuffer.hasNext())
    {
      paramArrayOfString = (AccessibilityBridge.SemanticsNode)paramByteBuffer.next();
      this.flutterNavigationStack.add(Integer.valueOf(AccessibilityBridge.SemanticsNode.access$1600(paramArrayOfString)));
    }
    paramByteBuffer = this.flutterSemanticsTree.entrySet().iterator();
    while (paramByteBuffer.hasNext())
    {
      paramArrayOfString = (AccessibilityBridge.SemanticsNode)((Map.Entry)paramByteBuffer.next()).getValue();
      if (!((Set)localObject2).contains(paramArrayOfString))
      {
        willRemoveSemanticsNode(paramArrayOfString);
        paramByteBuffer.remove();
      }
    }
    sendWindowContentChangeEvent(0);
    localObject1 = ((ArrayList)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AccessibilityBridge.SemanticsNode)((Iterator)localObject1).next();
      if (AccessibilityBridge.SemanticsNode.access$4500((AccessibilityBridge.SemanticsNode)localObject2))
      {
        paramByteBuffer = obtainAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2), 4096);
        float f2 = AccessibilityBridge.SemanticsNode.access$4600((AccessibilityBridge.SemanticsNode)localObject2);
        float f3 = AccessibilityBridge.SemanticsNode.access$4700((AccessibilityBridge.SemanticsNode)localObject2);
        float f1 = f2;
        if (Float.isInfinite(AccessibilityBridge.SemanticsNode.access$4700((AccessibilityBridge.SemanticsNode)localObject2)))
        {
          f1 = f2;
          if (f2 > 70000.0F) {
            f1 = 70000.0F;
          }
          f3 = 100000.0F;
        }
        if (Float.isInfinite(AccessibilityBridge.SemanticsNode.access$4800((AccessibilityBridge.SemanticsNode)localObject2)))
        {
          f3 += 100000.0F;
          f2 = f1;
          if (f1 < -70000.0F) {
            f2 = -70000.0F;
          }
          f1 = f2 + 100000.0F;
          f2 = f3;
          if ((!AccessibilityBridge.SemanticsNode.access$4900((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Action.SCROLL_UP)) && (!AccessibilityBridge.SemanticsNode.access$4900((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Action.SCROLL_DOWN))) {
            break label732;
          }
          paramByteBuffer.setScrollY((int)f1);
          paramByteBuffer.setMaxScrollY((int)f2);
        }
        label732:
        for (;;)
        {
          label635:
          if (AccessibilityBridge.SemanticsNode.access$1200((AccessibilityBridge.SemanticsNode)localObject2) > 0)
          {
            paramByteBuffer.setItemCount(AccessibilityBridge.SemanticsNode.access$1200((AccessibilityBridge.SemanticsNode)localObject2));
            paramByteBuffer.setFromIndex(AccessibilityBridge.SemanticsNode.access$5000((AccessibilityBridge.SemanticsNode)localObject2));
            paramArrayOfString = AccessibilityBridge.SemanticsNode.access$5100((AccessibilityBridge.SemanticsNode)localObject2).iterator();
            int i = 0;
            for (;;)
            {
              if (paramArrayOfString.hasNext()) {
                if (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)paramArrayOfString.next(), AccessibilityBridge.Flag.IS_HIDDEN))
                {
                  i += 1;
                  continue;
                  f2 = f3 - AccessibilityBridge.SemanticsNode.access$4800((AccessibilityBridge.SemanticsNode)localObject2);
                  f1 -= AccessibilityBridge.SemanticsNode.access$4800((AccessibilityBridge.SemanticsNode)localObject2);
                  break;
                  if ((!AccessibilityBridge.SemanticsNode.access$4900((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Action.SCROLL_LEFT)) && (!AccessibilityBridge.SemanticsNode.access$4900((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Action.SCROLL_RIGHT))) {
                    break label635;
                  }
                  paramByteBuffer.setScrollX((int)f1);
                  paramByteBuffer.setMaxScrollX((int)f2);
                  break label635;
                }
              }
            }
            paramByteBuffer.setToIndex(AccessibilityBridge.SemanticsNode.access$5000((AccessibilityBridge.SemanticsNode)localObject2) + i - 1);
          }
        }
        sendAccessibilityEvent(paramByteBuffer);
      }
      if (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_LIVE_REGION)) {
        if (AccessibilityBridge.SemanticsNode.access$5200((AccessibilityBridge.SemanticsNode)localObject2) == null)
        {
          paramByteBuffer = "";
          label812:
          if (AccessibilityBridge.SemanticsNode.access$5300((AccessibilityBridge.SemanticsNode)localObject2) != null) {
            break label1206;
          }
          paramArrayOfString = "";
          label824:
          if ((!paramByteBuffer.equals(paramArrayOfString)) || (!AccessibilityBridge.SemanticsNode.access$5400((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_LIVE_REGION))) {
            sendWindowContentChangeEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2));
          }
          label852:
          if ((this.accessibilityFocusedSemanticsNode != null) && (AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode) == AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2)) && (!AccessibilityBridge.SemanticsNode.access$5400((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_SELECTED)) && (AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_SELECTED)))
          {
            paramByteBuffer = obtainAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2), 4);
            paramByteBuffer.getText().add(AccessibilityBridge.SemanticsNode.access$5200((AccessibilityBridge.SemanticsNode)localObject2));
            sendAccessibilityEvent(paramByteBuffer);
          }
          if ((this.inputFocusedSemanticsNode == null) || (AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode) != AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2)) || ((this.lastInputFocusedSemanticsNode != null) && (AccessibilityBridge.SemanticsNode.access$1600(this.lastInputFocusedSemanticsNode) == AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode)))) {
            break label1268;
          }
          this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
          sendAccessibilityEvent(obtainAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2), 8));
          label996:
          if ((this.inputFocusedSemanticsNode == null) || (AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode) != AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2)) || (!AccessibilityBridge.SemanticsNode.access$5400((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_TEXT_FIELD)) || (!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_TEXT_FIELD)) || ((this.accessibilityFocusedSemanticsNode != null) && (AccessibilityBridge.SemanticsNode.access$1600(this.accessibilityFocusedSemanticsNode) != AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode)))) {
            break label1281;
          }
          if (AccessibilityBridge.SemanticsNode.access$5600((AccessibilityBridge.SemanticsNode)localObject2) == null) {
            break label1283;
          }
          paramByteBuffer = AccessibilityBridge.SemanticsNode.access$5600((AccessibilityBridge.SemanticsNode)localObject2);
          label1078:
          if (AccessibilityBridge.SemanticsNode.access$2300((AccessibilityBridge.SemanticsNode)localObject2) == null) {
            break label1290;
          }
        }
      }
      label1281:
      label1283:
      label1290:
      for (paramArrayOfString = AccessibilityBridge.SemanticsNode.access$2300((AccessibilityBridge.SemanticsNode)localObject2);; paramArrayOfString = "")
      {
        paramByteBuffer = createTextChangedEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2), paramByteBuffer, paramArrayOfString);
        if (paramByteBuffer != null) {
          sendAccessibilityEvent(paramByteBuffer);
        }
        if ((AccessibilityBridge.SemanticsNode.access$5700((AccessibilityBridge.SemanticsNode)localObject2) == AccessibilityBridge.SemanticsNode.access$1900((AccessibilityBridge.SemanticsNode)localObject2)) && (AccessibilityBridge.SemanticsNode.access$5800((AccessibilityBridge.SemanticsNode)localObject2) == AccessibilityBridge.SemanticsNode.access$2000((AccessibilityBridge.SemanticsNode)localObject2))) {
          break;
        }
        paramByteBuffer = obtainAccessibilityEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2), 8192);
        paramByteBuffer.getText().add(paramArrayOfString);
        paramByteBuffer.setFromIndex(AccessibilityBridge.SemanticsNode.access$1900((AccessibilityBridge.SemanticsNode)localObject2));
        paramByteBuffer.setToIndex(AccessibilityBridge.SemanticsNode.access$2000((AccessibilityBridge.SemanticsNode)localObject2));
        paramByteBuffer.setItemCount(paramArrayOfString.length());
        sendAccessibilityEvent(paramByteBuffer);
        break;
        paramByteBuffer = AccessibilityBridge.SemanticsNode.access$5200((AccessibilityBridge.SemanticsNode)localObject2);
        break label812;
        label1206:
        paramArrayOfString = AccessibilityBridge.SemanticsNode.access$5200((AccessibilityBridge.SemanticsNode)localObject2);
        break label824;
        if ((!AccessibilityBridge.SemanticsNode.access$1800((AccessibilityBridge.SemanticsNode)localObject2, AccessibilityBridge.Flag.IS_TEXT_FIELD)) || (!AccessibilityBridge.SemanticsNode.access$5500((AccessibilityBridge.SemanticsNode)localObject2)) || (this.inputFocusedSemanticsNode == null) || (AccessibilityBridge.SemanticsNode.access$1600(this.inputFocusedSemanticsNode) != AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2))) {
          break label852;
        }
        sendWindowContentChangeEvent(AccessibilityBridge.SemanticsNode.access$1600((AccessibilityBridge.SemanticsNode)localObject2));
        break label852;
        label1268:
        if (this.inputFocusedSemanticsNode != null) {
          break label996;
        }
        this.lastInputFocusedSemanticsNode = null;
        break label996;
        break;
        paramByteBuffer = "";
        break label1078;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge
 * JD-Core Version:    0.7.0.1
 */