package io.flutter.view;

import android.graphics.Rect;
import android.opengl.Matrix;
import androidx.annotation.NonNull;
import io.flutter.util.Predicate;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class AccessibilityBridge$SemanticsNode
{
  final AccessibilityBridge accessibilityBridge;
  private int actions;
  private float bottom;
  private List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
  private List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
  private int currentValueLength;
  private List<AccessibilityBridge.CustomAccessibilityAction> customAccessibilityActions;
  private String decreasedValue;
  private int flags;
  private boolean globalGeometryDirty = true;
  private Rect globalRect;
  private float[] globalTransform;
  private boolean hadPreviousConfig = false;
  private String hint;
  private int id = -1;
  private String increasedValue;
  private float[] inverseTransform;
  private boolean inverseTransformDirty = true;
  private String label;
  private float left;
  private int maxValueLength;
  private AccessibilityBridge.CustomAccessibilityAction onLongPressOverride;
  private AccessibilityBridge.CustomAccessibilityAction onTapOverride;
  private SemanticsNode parent;
  private int platformViewId;
  private int previousActions;
  private int previousFlags;
  private String previousLabel;
  private float previousScrollExtentMax;
  private float previousScrollExtentMin;
  private float previousScrollPosition;
  private int previousTextSelectionBase;
  private int previousTextSelectionExtent;
  private String previousValue;
  private float right;
  private int scrollChildren;
  private float scrollExtentMax;
  private float scrollExtentMin;
  private int scrollIndex;
  private float scrollPosition;
  private AccessibilityBridge.TextDirection textDirection;
  private int textSelectionBase;
  private int textSelectionExtent;
  private float top;
  private float[] transform;
  private String value;
  
  AccessibilityBridge$SemanticsNode(@NonNull AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityBridge = paramAccessibilityBridge;
  }
  
  private void collectRoutes(List<SemanticsNode> paramList)
  {
    if (hasFlag(AccessibilityBridge.Flag.SCOPES_ROUTE)) {
      paramList.add(this);
    }
    Iterator localIterator = this.childrenInTraversalOrder.iterator();
    while (localIterator.hasNext()) {
      ((SemanticsNode)localIterator.next()).collectRoutes(paramList);
    }
  }
  
  private boolean didChangeLabel()
  {
    if ((this.label == null) && (this.previousLabel == null)) {}
    while ((this.label != null) && (this.previousLabel != null) && (this.label.equals(this.previousLabel))) {
      return false;
    }
    return true;
  }
  
  private boolean didScroll()
  {
    return (!Float.isNaN(this.scrollPosition)) && (!Float.isNaN(this.previousScrollPosition)) && (this.previousScrollPosition != this.scrollPosition);
  }
  
  private void ensureInverseTransform()
  {
    if (!this.inverseTransformDirty) {}
    do
    {
      return;
      this.inverseTransformDirty = false;
      if (this.inverseTransform == null) {
        this.inverseTransform = new float[16];
      }
    } while (Matrix.invertM(this.inverseTransform, 0, this.transform, 0));
    Arrays.fill(this.inverseTransform, 0.0F);
  }
  
  private SemanticsNode getAncestor(Predicate<SemanticsNode> paramPredicate)
  {
    for (SemanticsNode localSemanticsNode = this.parent; localSemanticsNode != null; localSemanticsNode = localSemanticsNode.parent) {
      if (paramPredicate.test(localSemanticsNode)) {
        return localSemanticsNode;
      }
    }
    return null;
  }
  
  private Rect getGlobalRect()
  {
    return this.globalRect;
  }
  
  private String getRouteName()
  {
    if ((hasFlag(AccessibilityBridge.Flag.NAMES_ROUTE)) && (this.label != null) && (!this.label.isEmpty())) {
      return this.label;
    }
    Iterator localIterator = this.childrenInTraversalOrder.iterator();
    while (localIterator.hasNext())
    {
      String str = ((SemanticsNode)localIterator.next()).getRouteName();
      if ((str != null) && (!str.isEmpty())) {
        return str;
      }
    }
    return null;
  }
  
  private String getValueLabelHint()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.value;
    arrayOfString[1] = this.label;
    arrayOfString[2] = this.hint;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      if ((str != null) && (str.length() > 0))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(str);
      }
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private boolean hadAction(@NonNull AccessibilityBridge.Action paramAction)
  {
    return (this.previousActions & paramAction.value) != 0;
  }
  
  private boolean hadFlag(@NonNull AccessibilityBridge.Flag paramFlag)
  {
    return (this.previousFlags & paramFlag.value) != 0;
  }
  
  private boolean hasAction(@NonNull AccessibilityBridge.Action paramAction)
  {
    return (this.actions & paramAction.value) != 0;
  }
  
  private boolean hasFlag(@NonNull AccessibilityBridge.Flag paramFlag)
  {
    return (this.flags & paramFlag.value) != 0;
  }
  
  private SemanticsNode hitTest(float[] paramArrayOfFloat)
  {
    float f2 = paramArrayOfFloat[3];
    float f1 = paramArrayOfFloat[0] / f2;
    f2 = paramArrayOfFloat[1] / f2;
    SemanticsNode localSemanticsNode;
    if ((f1 < this.left) || (f1 >= this.right) || (f2 < this.top) || (f2 >= this.bottom))
    {
      localSemanticsNode = null;
      return localSemanticsNode;
    }
    float[] arrayOfFloat = new float[4];
    Iterator localIterator = this.childrenInHitTestOrder.iterator();
    do
    {
      do
      {
        localSemanticsNode = this;
        if (!localIterator.hasNext()) {
          break;
        }
        localSemanticsNode = (SemanticsNode)localIterator.next();
      } while (localSemanticsNode.hasFlag(AccessibilityBridge.Flag.IS_HIDDEN));
      localSemanticsNode.ensureInverseTransform();
      Matrix.multiplyMV(arrayOfFloat, 0, localSemanticsNode.inverseTransform, 0, paramArrayOfFloat, 0);
      localSemanticsNode = localSemanticsNode.hitTest(arrayOfFloat);
    } while (localSemanticsNode == null);
    return localSemanticsNode;
  }
  
  private boolean isFocusable()
  {
    if (hasFlag(AccessibilityBridge.Flag.SCOPES_ROUTE)) {}
    do
    {
      return false;
      if (hasFlag(AccessibilityBridge.Flag.IS_FOCUSABLE)) {
        return true;
      }
    } while (((((AccessibilityBridge.Action.SCROLL_RIGHT.value | AccessibilityBridge.Action.SCROLL_LEFT.value | AccessibilityBridge.Action.SCROLL_UP.value | AccessibilityBridge.Action.SCROLL_DOWN.value) ^ 0xFFFFFFFF) & this.actions) == 0) && (this.flags == 0) && ((this.label == null) || (this.label.isEmpty())) && ((this.value == null) || (this.value.isEmpty())) && ((this.hint == null) || (this.hint.isEmpty())));
    return true;
  }
  
  private void log(@NonNull String paramString, boolean paramBoolean) {}
  
  private float max(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.max(paramFloat1, Math.max(paramFloat2, Math.max(paramFloat3, paramFloat4)));
  }
  
  private float min(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
  }
  
  private static boolean nullableHasAncestor(SemanticsNode paramSemanticsNode, Predicate<SemanticsNode> paramPredicate)
  {
    return (paramSemanticsNode != null) && (paramSemanticsNode.getAncestor(paramPredicate) != null);
  }
  
  private void transformPoint(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.multiplyMV(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat3, 0);
    float f = paramArrayOfFloat1[3];
    paramArrayOfFloat1[0] /= f;
    paramArrayOfFloat1[1] /= f;
    paramArrayOfFloat1[2] /= f;
    paramArrayOfFloat1[3] = 0.0F;
  }
  
  private void updateRecursively(float[] paramArrayOfFloat, Set<SemanticsNode> paramSet, boolean paramBoolean)
  {
    paramSet.add(this);
    if (this.globalGeometryDirty) {
      paramBoolean = true;
    }
    if (paramBoolean)
    {
      if (this.globalTransform == null) {
        this.globalTransform = new float[16];
      }
      Matrix.multiplyMM(this.globalTransform, 0, paramArrayOfFloat, 0, this.transform, 0);
      paramArrayOfFloat = new float[4];
      paramArrayOfFloat[2] = 0.0F;
      paramArrayOfFloat[3] = 1.0F;
      float[] arrayOfFloat1 = new float[4];
      float[] arrayOfFloat2 = new float[4];
      float[] arrayOfFloat3 = new float[4];
      float[] arrayOfFloat4 = new float[4];
      paramArrayOfFloat[0] = this.left;
      paramArrayOfFloat[1] = this.top;
      transformPoint(arrayOfFloat1, this.globalTransform, paramArrayOfFloat);
      paramArrayOfFloat[0] = this.right;
      paramArrayOfFloat[1] = this.top;
      transformPoint(arrayOfFloat2, this.globalTransform, paramArrayOfFloat);
      paramArrayOfFloat[0] = this.right;
      paramArrayOfFloat[1] = this.bottom;
      transformPoint(arrayOfFloat3, this.globalTransform, paramArrayOfFloat);
      paramArrayOfFloat[0] = this.left;
      paramArrayOfFloat[1] = this.bottom;
      transformPoint(arrayOfFloat4, this.globalTransform, paramArrayOfFloat);
      if (this.globalRect == null) {
        this.globalRect = new Rect();
      }
      this.globalRect.set(Math.round(min(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(min(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(max(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(max(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
      this.globalGeometryDirty = false;
    }
    paramArrayOfFloat = this.childrenInTraversalOrder.iterator();
    while (paramArrayOfFloat.hasNext()) {
      ((SemanticsNode)paramArrayOfFloat.next()).updateRecursively(this.globalTransform, paramSet, paramBoolean);
    }
  }
  
  private void updateWith(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    this.hadPreviousConfig = true;
    this.previousValue = this.value;
    this.previousLabel = this.label;
    this.previousFlags = this.flags;
    this.previousActions = this.actions;
    this.previousTextSelectionBase = this.textSelectionBase;
    this.previousTextSelectionExtent = this.textSelectionExtent;
    this.previousScrollPosition = this.scrollPosition;
    this.previousScrollExtentMax = this.scrollExtentMax;
    this.previousScrollExtentMin = this.scrollExtentMin;
    this.flags = paramByteBuffer.getInt();
    this.actions = paramByteBuffer.getInt();
    this.maxValueLength = paramByteBuffer.getInt();
    this.currentValueLength = paramByteBuffer.getInt();
    this.textSelectionBase = paramByteBuffer.getInt();
    this.textSelectionExtent = paramByteBuffer.getInt();
    this.platformViewId = paramByteBuffer.getInt();
    this.scrollChildren = paramByteBuffer.getInt();
    this.scrollIndex = paramByteBuffer.getInt();
    this.scrollPosition = paramByteBuffer.getFloat();
    this.scrollExtentMax = paramByteBuffer.getFloat();
    this.scrollExtentMin = paramByteBuffer.getFloat();
    int i = paramByteBuffer.getInt();
    String str;
    if (i == -1)
    {
      str = null;
      this.label = str;
      i = paramByteBuffer.getInt();
      if (i != -1) {
        break label357;
      }
      str = null;
      label205:
      this.value = str;
      i = paramByteBuffer.getInt();
      if (i != -1) {
        break label365;
      }
      str = null;
      label224:
      this.increasedValue = str;
      i = paramByteBuffer.getInt();
      if (i != -1) {
        break label373;
      }
      str = null;
      label243:
      this.decreasedValue = str;
      i = paramByteBuffer.getInt();
      if (i != -1) {
        break label381;
      }
    }
    label357:
    label365:
    label373:
    label381:
    for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
    {
      this.hint = paramArrayOfString;
      this.textDirection = AccessibilityBridge.TextDirection.fromInt(paramByteBuffer.getInt());
      this.left = paramByteBuffer.getFloat();
      this.top = paramByteBuffer.getFloat();
      this.right = paramByteBuffer.getFloat();
      this.bottom = paramByteBuffer.getFloat();
      if (this.transform == null) {
        this.transform = new float[16];
      }
      i = 0;
      while (i < 16)
      {
        this.transform[i] = paramByteBuffer.getFloat();
        i += 1;
      }
      str = paramArrayOfString[i];
      break;
      str = paramArrayOfString[i];
      break label205;
      str = paramArrayOfString[i];
      break label224;
      str = paramArrayOfString[i];
      break label243;
    }
    this.inverseTransformDirty = true;
    this.globalGeometryDirty = true;
    int j = paramByteBuffer.getInt();
    this.childrenInTraversalOrder.clear();
    this.childrenInHitTestOrder.clear();
    i = 0;
    while (i < j)
    {
      paramArrayOfString = AccessibilityBridge.access$6000(this.accessibilityBridge, paramByteBuffer.getInt());
      paramArrayOfString.parent = this;
      this.childrenInTraversalOrder.add(paramArrayOfString);
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      paramArrayOfString = AccessibilityBridge.access$6000(this.accessibilityBridge, paramByteBuffer.getInt());
      paramArrayOfString.parent = this;
      this.childrenInHitTestOrder.add(paramArrayOfString);
      i += 1;
    }
    j = paramByteBuffer.getInt();
    if (j == 0)
    {
      this.customAccessibilityActions = null;
      return;
    }
    if (this.customAccessibilityActions == null)
    {
      this.customAccessibilityActions = new ArrayList(j);
      i = 0;
      label547:
      if (i >= j) {
        break label613;
      }
      paramArrayOfString = AccessibilityBridge.access$6100(this.accessibilityBridge, paramByteBuffer.getInt());
      if (AccessibilityBridge.CustomAccessibilityAction.access$3900(paramArrayOfString) != AccessibilityBridge.Action.TAP.value) {
        break label615;
      }
      this.onTapOverride = paramArrayOfString;
    }
    for (;;)
    {
      this.customAccessibilityActions.add(paramArrayOfString);
      i += 1;
      break label547;
      this.customAccessibilityActions.clear();
      i = 0;
      break label547;
      label613:
      break;
      label615:
      if (AccessibilityBridge.CustomAccessibilityAction.access$3900(paramArrayOfString) == AccessibilityBridge.Action.LONG_PRESS.value) {
        this.onLongPressOverride = paramArrayOfString;
      } else {
        this.customAccessibilityActions.add(paramArrayOfString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.SemanticsNode
 * JD-Core Version:    0.7.0.1
 */