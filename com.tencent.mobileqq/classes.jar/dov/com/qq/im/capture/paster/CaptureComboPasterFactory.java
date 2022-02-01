package dov.com.qq.im.capture.paster;

import android.support.annotation.NonNull;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.music.CaptureComboMusic;
import dov.com.qq.im.capture.text.CaptureComboText;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.List;

public class CaptureComboPasterFactory
{
  public static CaptureComboBase a(String paramString)
  {
    return new CaptureComboMusic(Integer.valueOf(paramString).intValue());
  }
  
  public static CaptureComboBase a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    FacePackage localFacePackage = ((PasterDataManager)QIMManager.a(4)).a(paramString2);
    if ((localFacePackage instanceof NormalFacePackage)) {
      return new CaptureComboNormalPaster((NormalFacePackage)localFacePackage, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localFacePackage instanceof LocationFacePackage)) {
      return new CaptureComboLocationPaster((LocationFacePackage)localFacePackage, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localFacePackage instanceof InfomationFacePackage)) {
      return new CaptureComboInformationPaster((InfomationFacePackage)localFacePackage, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static CaptureComboBase a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new CaptureComboText(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static CaptureComboBase b(String paramString)
  {
    return new CaptureComboPtvTemplate(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboPasterFactory
 * JD-Core Version:    0.7.0.1
 */