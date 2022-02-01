package dov.com.qq.im.ae.camera.ui;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

class VideoStoryPiecesPart$5
  implements AEMaterialDownloader.MaterialDownloadListener
{
  VideoStoryPiecesPart$5(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    AEQLog.a("VideoStoryPiecesPart", "entry dynamics: onDownloadFinish" + paramInt);
    ThreadManager.getUIHandler().post(new VideoStoryPiecesPart.5.1(this, paramInt));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.5
 * JD-Core Version:    0.7.0.1
 */