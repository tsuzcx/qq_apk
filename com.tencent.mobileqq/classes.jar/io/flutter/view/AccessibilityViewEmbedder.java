package io.flutter.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@Keep
class AccessibilityViewEmbedder
{
  private static final String TAG = "AccessibilityBridge";
  private final Map<View, Rect> embeddedViewToDisplayBounds;
  private final SparseArray<AccessibilityViewEmbedder.ViewAndId> flutterIdToOrigin = new SparseArray();
  private int nextFlutterId;
  private final Map<AccessibilityViewEmbedder.ViewAndId, Integer> originToFlutterId;
  private final AccessibilityViewEmbedder.ReflectionAccessors reflectionAccessors = new AccessibilityViewEmbedder.ReflectionAccessors(null);
  private final View rootAccessibilityView;
  
  AccessibilityViewEmbedder(@NonNull View paramView, int paramInt)
  {
    this.rootAccessibilityView = paramView;
    this.nextFlutterId = paramInt;
    this.originToFlutterId = new HashMap();
    this.embeddedViewToDisplayBounds = new HashMap();
  }
  
  private void addChildrenToFlutterNode(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull View paramView, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    int i = 0;
    while (i < paramAccessibilityNodeInfo1.getChildCount())
    {
      Object localObject = AccessibilityViewEmbedder.ReflectionAccessors.access$500(this.reflectionAccessors, paramAccessibilityNodeInfo1, i);
      if (localObject == null)
      {
        i += 1;
      }
      else
      {
        int k = AccessibilityViewEmbedder.ReflectionAccessors.access$200(((Long)localObject).longValue());
        localObject = new AccessibilityViewEmbedder.ViewAndId(paramView, k, null);
        int j;
        if (this.originToFlutterId.containsKey(localObject)) {
          j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
        }
        for (;;)
        {
          paramAccessibilityNodeInfo2.addChild(this.rootAccessibilityView, j);
          break;
          j = this.nextFlutterId;
          this.nextFlutterId = (j + 1);
          cacheVirtualIdMappings(paramView, k, j);
        }
      }
    }
  }
  
  private void cacheVirtualIdMappings(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    paramView = new AccessibilityViewEmbedder.ViewAndId(paramView, paramInt1, null);
    this.originToFlutterId.put(paramView, Integer.valueOf(paramInt2));
    this.flutterIdToOrigin.put(paramInt2, paramView);
  }
  
  @NonNull
  private AccessibilityNodeInfo convertToFlutterNode(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, @NonNull View paramView)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    localAccessibilityNodeInfo.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityNodeInfo.setSource(this.rootAccessibilityView, paramInt);
    localAccessibilityNodeInfo.setClassName(paramAccessibilityNodeInfo.getClassName());
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(paramView);
    copyAccessibilityFields(paramAccessibilityNodeInfo, localAccessibilityNodeInfo);
    setFlutterNodesTranslateBounds(paramAccessibilityNodeInfo, localRect, localAccessibilityNodeInfo);
    addChildrenToFlutterNode(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    setFlutterNodeParent(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    return localAccessibilityNodeInfo;
  }
  
  private void copyAccessibilityFields(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    paramAccessibilityNodeInfo2.setAccessibilityFocused(paramAccessibilityNodeInfo1.isAccessibilityFocused());
    paramAccessibilityNodeInfo2.setCheckable(paramAccessibilityNodeInfo1.isCheckable());
    paramAccessibilityNodeInfo2.setChecked(paramAccessibilityNodeInfo1.isChecked());
    paramAccessibilityNodeInfo2.setContentDescription(paramAccessibilityNodeInfo1.getContentDescription());
    paramAccessibilityNodeInfo2.setEnabled(paramAccessibilityNodeInfo1.isEnabled());
    paramAccessibilityNodeInfo2.setClickable(paramAccessibilityNodeInfo1.isClickable());
    paramAccessibilityNodeInfo2.setFocusable(paramAccessibilityNodeInfo1.isFocusable());
    paramAccessibilityNodeInfo2.setFocused(paramAccessibilityNodeInfo1.isFocused());
    paramAccessibilityNodeInfo2.setLongClickable(paramAccessibilityNodeInfo1.isLongClickable());
    paramAccessibilityNodeInfo2.setMovementGranularities(paramAccessibilityNodeInfo1.getMovementGranularities());
    paramAccessibilityNodeInfo2.setPassword(paramAccessibilityNodeInfo1.isPassword());
    paramAccessibilityNodeInfo2.setScrollable(paramAccessibilityNodeInfo1.isScrollable());
    paramAccessibilityNodeInfo2.setSelected(paramAccessibilityNodeInfo1.isSelected());
    paramAccessibilityNodeInfo2.setText(paramAccessibilityNodeInfo1.getText());
    paramAccessibilityNodeInfo2.setVisibleToUser(paramAccessibilityNodeInfo1.isVisibleToUser());
    if (Build.VERSION.SDK_INT >= 18) {
      paramAccessibilityNodeInfo2.setEditable(paramAccessibilityNodeInfo1.isEditable());
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAccessibilityNodeInfo2.setCanOpenPopup(paramAccessibilityNodeInfo1.canOpenPopup());
      paramAccessibilityNodeInfo2.setCollectionInfo(paramAccessibilityNodeInfo1.getCollectionInfo());
      paramAccessibilityNodeInfo2.setCollectionItemInfo(paramAccessibilityNodeInfo1.getCollectionItemInfo());
      paramAccessibilityNodeInfo2.setContentInvalid(paramAccessibilityNodeInfo1.isContentInvalid());
      paramAccessibilityNodeInfo2.setDismissable(paramAccessibilityNodeInfo1.isDismissable());
      paramAccessibilityNodeInfo2.setInputType(paramAccessibilityNodeInfo1.getInputType());
      paramAccessibilityNodeInfo2.setLiveRegion(paramAccessibilityNodeInfo1.getLiveRegion());
      paramAccessibilityNodeInfo2.setMultiLine(paramAccessibilityNodeInfo1.isMultiLine());
      paramAccessibilityNodeInfo2.setRangeInfo(paramAccessibilityNodeInfo1.getRangeInfo());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramAccessibilityNodeInfo2.setError(paramAccessibilityNodeInfo1.getError());
      paramAccessibilityNodeInfo2.setMaxTextLength(paramAccessibilityNodeInfo1.getMaxTextLength());
    }
    if (Build.VERSION.SDK_INT >= 23) {
      paramAccessibilityNodeInfo2.setContextClickable(paramAccessibilityNodeInfo1.isContextClickable());
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramAccessibilityNodeInfo2.setDrawingOrder(paramAccessibilityNodeInfo1.getDrawingOrder());
      paramAccessibilityNodeInfo2.setImportantForAccessibility(paramAccessibilityNodeInfo1.isImportantForAccessibility());
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramAccessibilityNodeInfo2.setAvailableExtraData(paramAccessibilityNodeInfo1.getAvailableExtraData());
      paramAccessibilityNodeInfo2.setHintText(paramAccessibilityNodeInfo1.getHintText());
      paramAccessibilityNodeInfo2.setShowingHintText(paramAccessibilityNodeInfo1.isShowingHintText());
    }
  }
  
  private void setFlutterNodeParent(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull View paramView, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    paramAccessibilityNodeInfo1 = AccessibilityViewEmbedder.ReflectionAccessors.access$300(this.reflectionAccessors, paramAccessibilityNodeInfo1);
    if (paramAccessibilityNodeInfo1 == null) {}
    do
    {
      return;
      int i = AccessibilityViewEmbedder.ReflectionAccessors.access$200(paramAccessibilityNodeInfo1.longValue());
      paramAccessibilityNodeInfo1 = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.ViewAndId(paramView, i, null));
    } while (paramAccessibilityNodeInfo1 == null);
    paramAccessibilityNodeInfo2.setParent(this.rootAccessibilityView, paramAccessibilityNodeInfo1.intValue());
  }
  
  private void setFlutterNodesTranslateBounds(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull Rect paramRect, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    Rect localRect = new Rect();
    paramAccessibilityNodeInfo1.getBoundsInParent(localRect);
    paramAccessibilityNodeInfo2.setBoundsInParent(localRect);
    localRect = new Rect();
    paramAccessibilityNodeInfo1.getBoundsInScreen(localRect);
    localRect.offset(paramRect.left, paramRect.top);
    paramAccessibilityNodeInfo2.setBoundsInScreen(localRect);
  }
  
  @Nullable
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    AccessibilityViewEmbedder.ViewAndId localViewAndId = (AccessibilityViewEmbedder.ViewAndId)this.flutterIdToOrigin.get(paramInt);
    if (localViewAndId == null) {
      return null;
    }
    if (!this.embeddedViewToDisplayBounds.containsKey(localViewAndId.view)) {
      return null;
    }
    if (localViewAndId.view.getAccessibilityNodeProvider() == null) {
      return null;
    }
    AccessibilityNodeInfo localAccessibilityNodeInfo = localViewAndId.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(localViewAndId.id);
    if (localAccessibilityNodeInfo == null) {
      return null;
    }
    return convertToFlutterNode(localAccessibilityNodeInfo, paramInt, localViewAndId.view);
  }
  
  @Nullable
  public Integer getRecordFlutterId(@NonNull View paramView, @NonNull AccessibilityRecord paramAccessibilityRecord)
  {
    paramAccessibilityRecord = AccessibilityViewEmbedder.ReflectionAccessors.access$600(this.reflectionAccessors, paramAccessibilityRecord);
    if (paramAccessibilityRecord == null) {
      return null;
    }
    int i = AccessibilityViewEmbedder.ReflectionAccessors.access$200(paramAccessibilityRecord.longValue());
    return (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.ViewAndId(paramView, i, null));
  }
  
  public AccessibilityNodeInfo getRootNode(@NonNull View paramView, int paramInt, @NonNull Rect paramRect)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = paramView.createAccessibilityNodeInfo();
    Long localLong = AccessibilityViewEmbedder.ReflectionAccessors.access$100(this.reflectionAccessors, localAccessibilityNodeInfo);
    if (localLong == null) {
      return null;
    }
    this.embeddedViewToDisplayBounds.put(paramView, paramRect);
    cacheVirtualIdMappings(paramView, AccessibilityViewEmbedder.ReflectionAccessors.access$200(localLong.longValue()), paramInt);
    return convertToFlutterNode(localAccessibilityNodeInfo, paramInt, paramView);
  }
  
  public boolean onAccessibilityHoverEvent(int paramInt, @NonNull MotionEvent paramMotionEvent)
  {
    AccessibilityViewEmbedder.ViewAndId localViewAndId = (AccessibilityViewEmbedder.ViewAndId)this.flutterIdToOrigin.get(paramInt);
    paramInt = 0;
    if (localViewAndId == null) {
      return false;
    }
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(localViewAndId.view);
    int i = paramMotionEvent.getPointerCount();
    MotionEvent.PointerProperties[] arrayOfPointerProperties = new MotionEvent.PointerProperties[i];
    MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[i];
    while (paramInt < paramMotionEvent.getPointerCount())
    {
      arrayOfPointerProperties[paramInt] = new MotionEvent.PointerProperties();
      paramMotionEvent.getPointerProperties(paramInt, arrayOfPointerProperties[paramInt]);
      MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
      paramMotionEvent.getPointerCoords(paramInt, localPointerCoords);
      arrayOfPointerCoords[paramInt] = new MotionEvent.PointerCoords(localPointerCoords);
      localPointerCoords = arrayOfPointerCoords[paramInt];
      localPointerCoords.x -= localRect.left;
      localPointerCoords = arrayOfPointerCoords[paramInt];
      localPointerCoords.y -= localRect.top;
      paramInt += 1;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), paramMotionEvent.getPointerCount(), arrayOfPointerProperties, arrayOfPointerCoords, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
    return localViewAndId.view.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, @Nullable Bundle paramBundle)
  {
    AccessibilityViewEmbedder.ViewAndId localViewAndId = (AccessibilityViewEmbedder.ViewAndId)this.flutterIdToOrigin.get(paramInt1);
    if (localViewAndId == null) {
      return false;
    }
    AccessibilityNodeProvider localAccessibilityNodeProvider = localViewAndId.view.getAccessibilityNodeProvider();
    if (localAccessibilityNodeProvider == null) {
      return false;
    }
    return localAccessibilityNodeProvider.performAction(localViewAndId.id, paramInt2, paramBundle);
  }
  
  public View platformViewOfNode(int paramInt)
  {
    AccessibilityViewEmbedder.ViewAndId localViewAndId = (AccessibilityViewEmbedder.ViewAndId)this.flutterIdToOrigin.get(paramInt);
    if (localViewAndId == null) {
      return null;
    }
    return localViewAndId.view;
  }
  
  public boolean requestSendAccessibilityEvent(@NonNull View paramView1, @NonNull View paramView2, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramAccessibilityEvent);
    Object localObject = AccessibilityViewEmbedder.ReflectionAccessors.access$600(this.reflectionAccessors, paramAccessibilityEvent);
    if (localObject == null) {
      return false;
    }
    int i = AccessibilityViewEmbedder.ReflectionAccessors.access$200(((Long)localObject).longValue());
    Integer localInteger = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.ViewAndId(paramView1, i, null));
    localObject = localInteger;
    int j;
    if (localInteger == null)
    {
      j = this.nextFlutterId;
      this.nextFlutterId = (j + 1);
      localObject = Integer.valueOf(j);
      cacheVirtualIdMappings(paramView1, i, ((Integer)localObject).intValue());
    }
    localAccessibilityEvent.setSource(this.rootAccessibilityView, ((Integer)localObject).intValue());
    localAccessibilityEvent.setClassName(paramAccessibilityEvent.getClassName());
    localAccessibilityEvent.setPackageName(paramAccessibilityEvent.getPackageName());
    i = 0;
    for (;;)
    {
      if (i >= localAccessibilityEvent.getRecordCount()) {
        break label239;
      }
      paramAccessibilityEvent = localAccessibilityEvent.getRecord(i);
      localObject = AccessibilityViewEmbedder.ReflectionAccessors.access$600(this.reflectionAccessors, paramAccessibilityEvent);
      if (localObject == null) {
        break;
      }
      localObject = new AccessibilityViewEmbedder.ViewAndId(paramView1, AccessibilityViewEmbedder.ReflectionAccessors.access$200(((Long)localObject).longValue()), null);
      if (!this.originToFlutterId.containsKey(localObject)) {
        break;
      }
      j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
      paramAccessibilityEvent.setSource(this.rootAccessibilityView, j);
      i += 1;
    }
    label239:
    return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(paramView2, localAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder
 * JD-Core Version:    0.7.0.1
 */