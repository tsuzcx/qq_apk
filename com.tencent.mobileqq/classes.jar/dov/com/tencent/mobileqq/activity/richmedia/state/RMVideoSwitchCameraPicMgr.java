package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import java.io.File;

public class RMVideoSwitchCameraPicMgr
{
  private RMVideoSwitchCameraPicMgr.PicSwitchOption jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$PicSwitchOption = new RMVideoSwitchCameraPicMgr.PicSwitchOption(this, null);
  RMVideoSwitchCameraPicMgr.ViewBitmapSource jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$ViewBitmapSource = null;
  
  private String a()
  {
    String str = "shortvideo_cover_pic";
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$PicSwitchOption.b) {
      str = "ptv_cover_pic";
    }
    return GloableValue.a + File.separator + str + ".jpg";
  }
  
  private String b()
  {
    return GloableValue.a + File.separator + "player_cover_pic" + ".jpg";
  }
  
  private native Bitmap getPreprocessBitmap(int[] paramArrayOfInt);
  
  public Bitmap a()
  {
    Object localObject = null;
    String str = b();
    if (new File(str).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = 4;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public Bitmap a(boolean paramBoolean)
  {
    Object localObject = null;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$PicSwitchOption.b = paramBoolean;
    String str = a();
    if (new File(str).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = 2;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr
 * JD-Core Version:    0.7.0.1
 */