package com.tencent.mobileqq.transfile.chatpic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class PicUploadFileSizeLimit
{
  public static long C2C_FileSize_Limit = -1L;
  public static long GROUP_FileSize_Limit = -1L;
  public static final String SP_KEY_C2C_PIC_SIZE_LIMIT = "SP_KEY_C2C_PIC_SIZE_LIMIT";
  public static final String SP_KEY_GROUP_PIC_SIZE_LIMIT = "SP_KEY_GROUP_PIC_SIZE_LIMIT";
  public static final String SP_KEY_PIC_SIZE_LIMIT = "SP_KEY_PIC_SIZE_LIMIT";
  public static final String TAG = "PicUploadFileSizeLimit";
  
  private static long getLimit(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4);
    long l;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString, -1L);
    } else {
      l = -1L;
    }
    if (l < 0L) {
      return paramLong;
    }
    return l;
  }
  
  public static long getLimitC2C()
  {
    if (C2C_FileSize_Limit < 0L)
    {
      C2C_FileSize_Limit = getLimit("SP_KEY_C2C_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLimitC2C:");
        localStringBuilder.append(C2C_FileSize_Limit);
        QLog.d("PicUploadFileSizeLimit", 2, localStringBuilder.toString());
      }
    }
    return C2C_FileSize_Limit;
  }
  
  public static long getLimitGroup()
  {
    if (GROUP_FileSize_Limit < 0L)
    {
      GROUP_FileSize_Limit = getLimit("SP_KEY_GROUP_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLimitGroup:");
        localStringBuilder.append(GROUP_FileSize_Limit);
        QLog.d("PicUploadFileSizeLimit", 2, localStringBuilder.toString());
      }
    }
    return GROUP_FileSize_Limit;
  }
  
  private static void setLimit(String paramString, long paramLong)
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4).edit();
    ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setLimit:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" size:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("PicUploadFileSizeLimit", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void setLimitC2C(long paramLong)
  {
    setLimit("SP_KEY_C2C_PIC_SIZE_LIMIT", paramLong);
    if (paramLong > 0L) {
      C2C_FileSize_Limit = paramLong;
    }
  }
  
  public static void setLimitGroup(long paramLong)
  {
    setLimit("SP_KEY_GROUP_PIC_SIZE_LIMIT", paramLong);
    if (paramLong > 0L) {
      GROUP_FileSize_Limit = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit
 * JD-Core Version:    0.7.0.1
 */