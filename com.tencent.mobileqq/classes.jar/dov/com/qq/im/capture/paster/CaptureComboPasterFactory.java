package dov.com.qq.im.capture.paster;

import android.support.annotation.NonNull;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.music.CaptureComboMusic;
import dov.com.qq.im.capture.text.CaptureComboText;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.List;

public class CaptureComboPasterFactory
{
  public static CaptureComboBase a(String paramString)
  {
    return new CaptureComboMusic(Integer.valueOf(paramString).intValue());
  }
  
  public static CaptureComboBase a(@NonNull String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    FacePackage localFacePackage = ((PasterDataManager)QIMManager.a(4)).a(paramString1);
    if ((localFacePackage instanceof NormalFacePackage)) {
      return new CaptureComboNormalPaster((NormalFacePackage)localFacePackage, paramString1, paramString2, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localFacePackage instanceof LocationFacePackage)) {
      return new CaptureComboLocationPaster((LocationFacePackage)localFacePackage, paramString1, paramString2, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static CaptureComboBase a(@NonNull String paramString, @NonNull List paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new CaptureComboText(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static CaptureComboBase b(String paramString)
  {
    return new CaptureComboPtvTemplate(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboPasterFactory
 * JD-Core Version:    0.7.0.1
 */