package cooperation.gmersdk_warper;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class GMEAVEngineWalper$1
  extends TMG_Downloader.TMG_Downloader_DownloadEvent
{
  GMEAVEngineWalper$1(GMEAVEngineWalper paramGMEAVEngineWalper) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      ThreadManager.getUIHandler().post(new GMEAVEngineWalper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.1
 * JD-Core Version:    0.7.0.1
 */