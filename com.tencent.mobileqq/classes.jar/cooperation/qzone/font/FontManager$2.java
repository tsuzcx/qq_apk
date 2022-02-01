package cooperation.qzone.font;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FontManager$2
  implements EIPCResultCallback
{
  FontManager$2(FontManager paramFontManager) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "startFontSoDownload download so success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.2
 * JD-Core Version:    0.7.0.1
 */