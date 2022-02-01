package com.tencent.mobileqq.transfile.chatpic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import audj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class PicUploadExifInfoSwitch
{
  public static int EXIF_Info_Switch = -1;
  public static final String SP_KEY_EXIF_INFO_SWITCH = "SP_KEY_EXIF_Info_Switch";
  public static final String SP_KEY_EXIF_INFO_SWITCH_VALUE = "SP_KEY_EXIF_Info_Switch_VALUE";
  public static final String TAG = "PicUploadExifInfoSwitch";
  
  public static boolean getSwitch()
  {
    if (audj.a().g()) {}
    do
    {
      return true;
      if (EXIF_Info_Switch < 0) {
        EXIF_Info_Switch = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).getInt("SP_KEY_EXIF_Info_Switch_VALUE", 0);
      }
    } while (EXIF_Info_Switch == 1);
    return false;
  }
  
  public static void setSwitch(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).edit();
    localEditor.putInt("SP_KEY_EXIF_Info_Switch_VALUE", paramInt);
    localEditor.commit();
    EXIF_Info_Switch = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PicUploadExifInfoSwitch", 2, "setSwitch:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch
 * JD-Core Version:    0.7.0.1
 */