package io.flutter.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AccessibilityViewEmbedder$ReflectionAccessors
{
  @Nullable
  private final Field childNodeIdsField;
  @Nullable
  private final Method getChildId;
  @Nullable
  private final Method getParentNodeId;
  @Nullable
  private final Method getRecordSourceNodeId;
  @Nullable
  private final Method getSourceNodeId;
  @Nullable
  private final Method longArrayGetIndex;
  
  @SuppressLint({"PrivateApi"})
  private AccessibilityViewEmbedder$ReflectionAccessors()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    try
    {
      localMethod1 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Method localMethod1;
      label24:
      label50:
      break label24;
    }
    Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
    localMethod1 = null;
    try
    {
      localMethod2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      Method localMethod2;
      break label50;
    }
    Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
    localMethod2 = null;
    if (Build.VERSION.SDK_INT <= 26) {}
    try
    {
      localObject1 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      Object localObject1;
      label84:
      break label84;
    }
    Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
    localObject1 = null;
    try
    {
      localObject2 = AccessibilityNodeInfo.class.getMethod("getChildId", new Class[] { Integer.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException4)
    {
      label115:
      break label115;
    }
    Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
    localObject2 = null;
    localObject3 = localObject1;
    localObject1 = localObject2;
    localObject2 = localObject3;
    try
    {
      localField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
      localField.setAccessible(true);
      localObject1 = Class.forName("android.util.LongArray").getMethod("get", new Class[] { Integer.TYPE });
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (NoSuchFieldException|ClassNotFoundException|NoSuchMethodException|NullPointerException localNoSuchFieldException)
    {
      Field localField;
      label179:
      Object localObject4;
      break label179;
    }
    Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
    localObject1 = null;
    localObject4 = null;
    localField = null;
    localObject3 = localObject2;
    localObject2 = localObject4;
    this.getSourceNodeId = localMethod1;
    this.getParentNodeId = localObject3;
    this.getRecordSourceNodeId = localMethod2;
    this.getChildId = ((Method)localObject1);
    this.childNodeIdsField = localField;
    this.longArrayGetIndex = ((Method)localObject2);
  }
  
  @Nullable
  private Long getChildId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
  {
    if ((this.getChildId == null) && ((this.childNodeIdsField == null) || (this.longArrayGetIndex == null))) {
      return null;
    }
    Method localMethod = this.getChildId;
    if (localMethod != null) {}
    try
    {
      paramAccessibilityNodeInfo = (Long)localMethod.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
      return paramAccessibilityNodeInfo;
    }
    catch (InvocationTargetException paramAccessibilityNodeInfo)
    {
      break label104;
      try
      {
        long l = ((Long)this.longArrayGetIndex.invoke(this.childNodeIdsField.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
        return Long.valueOf(l);
      }
      catch (ArrayIndexOutOfBoundsException paramAccessibilityNodeInfo) {}
    }
    catch (IllegalAccessException paramAccessibilityNodeInfo) {}
    label104:
    Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
    return null;
  }
  
  @Nullable
  private Long getParentNodeId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    Method localMethod = this.getParentNodeId;
    if (localMethod != null)
    {
      try
      {
        long l = ((Long)localMethod.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
        return Long.valueOf(l);
      }
      catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}
      Log.w("AccessibilityBridge", localIllegalAccessException);
    }
    return yoinkParentIdFromParcel(paramAccessibilityNodeInfo);
  }
  
  @Nullable
  private Long getRecordSourceNodeId(@NonNull AccessibilityRecord paramAccessibilityRecord)
  {
    Method localMethod = this.getRecordSourceNodeId;
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramAccessibilityRecord = (Long)localMethod.invoke(paramAccessibilityRecord, new Object[0]);
      return paramAccessibilityRecord;
    }
    catch (InvocationTargetException paramAccessibilityRecord) {}catch (IllegalAccessException paramAccessibilityRecord) {}
    Log.w("AccessibilityBridge", paramAccessibilityRecord);
    return null;
  }
  
  @Nullable
  private Long getSourceNodeId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    Method localMethod = this.getSourceNodeId;
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramAccessibilityNodeInfo = (Long)localMethod.invoke(paramAccessibilityNodeInfo, new Object[0]);
      return paramAccessibilityNodeInfo;
    }
    catch (InvocationTargetException paramAccessibilityNodeInfo) {}catch (IllegalAccessException paramAccessibilityNodeInfo) {}
    Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
    return null;
  }
  
  private static int getVirtualNodeId(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private static boolean isBitSet(long paramLong, int paramInt)
  {
    return (paramLong & 1L << paramInt) != 0L;
  }
  
  @Nullable
  private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (i < 26)
    {
      Log.w("AccessibilityBridge", "Unexpected Android version. Unable to find the parent ID.");
      return null;
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAccessibilityNodeInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    long l = localParcel.readLong();
    if (isBitSet(l, 0)) {
      localParcel.readInt();
    }
    if (isBitSet(l, 1)) {
      localParcel.readLong();
    }
    if (isBitSet(l, 2)) {
      localParcel.readInt();
    }
    paramAccessibilityNodeInfo = localObject;
    if (isBitSet(l, 3)) {
      paramAccessibilityNodeInfo = Long.valueOf(localParcel.readLong());
    }
    localParcel.recycle();
    return paramAccessibilityNodeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder.ReflectionAccessors
 * JD-Core Version:    0.7.0.1
 */