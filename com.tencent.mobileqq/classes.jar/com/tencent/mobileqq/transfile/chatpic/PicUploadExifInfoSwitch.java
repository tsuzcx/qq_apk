package com.tencent.mobileqq.transfile.chatpic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PicUploadExifInfoSwitch
{
  public static int EXIF_Info_Switch = -1;
  public static final String SP_KEY_EXIF_INFO_SWITCH = "SP_KEY_EXIF_Info_Switch";
  public static final String SP_KEY_EXIF_INFO_SWITCH_VALUE = "SP_KEY_EXIF_Info_Switch_VALUE";
  public static final String TAG = "PicUploadExifInfoSwitch";
  
  public static boolean getSwitch()
  {
    if (ZhuoXusManager.a().j()) {
      return true;
    }
    if (EXIF_Info_Switch < 0) {
      EXIF_Info_Switch = BaseApplication.getContext().getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).getInt("SP_KEY_EXIF_Info_Switch_VALUE", 0);
    }
    return EXIF_Info_Switch == 1;
  }
  
  public static void setSwitch(int paramInt)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("SP_KEY_EXIF_Info_Switch_VALUE", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
    EXIF_Info_Switch = paramInt;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSwitch:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("PicUploadExifInfoSwitch", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch
 * JD-Core Version:    0.7.0.1
 */