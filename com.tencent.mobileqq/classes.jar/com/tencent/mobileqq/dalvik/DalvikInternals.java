package com.tencent.mobileqq.dalvik;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.SoLoadUtil;
import java.util.Locale;

public class DalvikInternals
{
  public static boolean a(Context paramContext)
  {
    if ((Build.CPU_ABI.toLowerCase(Locale.US).contains("x86")) || (SoLoadUtil.a()))
    {
      Log.d("qq_la", "x86");
      return SoLoadUtil.a(paramContext, "qq_la", 0, false, false);
    }
    Log.d("qq_la", "arm");
    return SoLoadUtilNew.loadSoByName(paramContext, "qq_la");
  }
  
  public static native long find(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, int paramInt7, int paramInt8, int paramInt9, long paramLong3);
  
  public static native int preverify(long[] paramArrayOfLong);
  
  public static native int replace(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.DalvikInternals
 * JD-Core Version:    0.7.0.1
 */