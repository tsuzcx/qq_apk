package com.tencent.mobileqq.transfile.chatpic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

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
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString, -1L);
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
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadFileSizeLimit", 2, "getLimitC2C:" + C2C_FileSize_Limit);
      }
    }
    return C2C_FileSize_Limit;
  }
  
  public static long getLimitGroup()
  {
    if (GROUP_FileSize_Limit < 0L)
    {
      GROUP_FileSize_Limit = getLimit("SP_KEY_GROUP_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadFileSizeLimit", 2, "getLimitGroup:" + GROUP_FileSize_Limit);
      }
    }
    return GROUP_FileSize_Limit;
  }
  
  private static void setLimit(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("PicUploadFileSizeLimit", 2, "setLimit:" + paramString + " size:" + paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit
 * JD-Core Version:    0.7.0.1
 */