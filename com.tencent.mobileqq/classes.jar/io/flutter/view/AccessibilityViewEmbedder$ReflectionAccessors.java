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
    for (;;)
    {
      Method localMethod4;
      Object localObject4;
      Field localField;
      Object localObject3;
      try
      {
        localMethod2 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        try
        {
          localMethod3 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
          if (Build.VERSION.SDK_INT > 26) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          try
          {
            localObject1 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            try
            {
              Method localMethod1 = AccessibilityNodeInfo.class.getMethod("getChildId", new Class[] { Integer.TYPE });
              localMethod4 = null;
              localObject4 = localObject1;
              Object localObject1 = localMethod4;
              this.getSourceNodeId = localMethod2;
              this.getParentNodeId = localObject4;
              this.getRecordSourceNodeId = localMethod3;
              this.getChildId = localMethod1;
              this.childNodeIdsField = ((Field)localObject1);
              this.longArrayGetIndex = localObject5;
              return;
              localNoSuchMethodException1 = localNoSuchMethodException1;
              Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
              Method localMethod2 = null;
              continue;
              localNoSuchMethodException2 = localNoSuchMethodException2;
              Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
              Method localMethod3 = null;
              continue;
              localNoSuchMethodException3 = localNoSuchMethodException3;
              Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
              localField = null;
              continue;
            }
            catch (NoSuchMethodException localNoSuchMethodException5)
            {
              Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
              localObject3 = null;
              continue;
            }
          }
        }
      }
      try
      {
        localField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
        localField.setAccessible(true);
        localMethod4 = Class.forName("android.util.LongArray").getMethod("get", new Class[] { Integer.TYPE });
        localObject4 = null;
        localObject3 = null;
        localObject5 = localMethod4;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
        Object localObject2 = null;
        localObject3 = null;
        localObject4 = null;
      }
      catch (NullPointerException localNullPointerException)
      {
        break label218;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label218;
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        label218:
        break label218;
      }
    }
  }
  
  @Nullable
  private Long getChildId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
  {
    if ((this.getChildId == null) && ((this.childNodeIdsField == null) || (this.longArrayGetIndex == null))) {
      return null;
    }
    if (this.getChildId != null) {}
    for (;;)
    {
      try
      {
        paramAccessibilityNodeInfo = (Long)this.getChildId.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
        return paramAccessibilityNodeInfo;
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
        return null;
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
        continue;
      }
      try
      {
        long l = ((Long)this.longArrayGetIndex.invoke(this.childNodeIdsField.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
        return Long.valueOf(l);
      }
      catch (ArrayIndexOutOfBoundsException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        label115:
        break label115;
      }
    }
  }
  
  @Nullable
  private Long getParentNodeId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (this.getParentNodeId != null) {}
    try
    {
      long l = ((Long)this.getParentNodeId.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
      return Long.valueOf(l);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.w("AccessibilityBridge", localInvocationTargetException);
      return yoinkParentIdFromParcel(paramAccessibilityNodeInfo);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.w("AccessibilityBridge", localIllegalAccessException);
      }
    }
  }
  
  @Nullable
  private Long getRecordSourceNodeId(@NonNull AccessibilityRecord paramAccessibilityRecord)
  {
    if (this.getRecordSourceNodeId == null) {
      return null;
    }
    try
    {
      paramAccessibilityRecord = (Long)this.getRecordSourceNodeId.invoke(paramAccessibilityRecord, new Object[0]);
      return paramAccessibilityRecord;
    }
    catch (InvocationTargetException paramAccessibilityRecord)
    {
      Log.w("AccessibilityBridge", paramAccessibilityRecord);
      return null;
    }
    catch (IllegalAccessException paramAccessibilityRecord)
    {
      for (;;)
      {
        Log.w("AccessibilityBridge", paramAccessibilityRecord);
      }
    }
  }
  
  @Nullable
  private Long getSourceNodeId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (this.getSourceNodeId == null) {
      return null;
    }
    try
    {
      paramAccessibilityNodeInfo = (Long)this.getSourceNodeId.invoke(paramAccessibilityNodeInfo, new Object[0]);
      return paramAccessibilityNodeInfo;
    }
    catch (InvocationTargetException paramAccessibilityNodeInfo)
    {
      Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
      return null;
    }
    catch (IllegalAccessException paramAccessibilityNodeInfo)
    {
      for (;;)
      {
        Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
      }
    }
  }
  
  private static int getVirtualNodeId(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private static boolean isBitSet(long paramLong, int paramInt)
  {
    return (1L << paramInt & paramLong) != 0L;
  }
  
  @Nullable
  private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    Object localObject = null;
    if (Build.VERSION.SDK_INT < 26)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder.ReflectionAccessors
 * JD-Core Version:    0.7.0.1
 */