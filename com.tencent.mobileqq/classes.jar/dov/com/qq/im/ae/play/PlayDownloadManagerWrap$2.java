package dov.com.qq.im.ae.play;

import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import mqq.util.WeakReference;

class PlayDownloadManagerWrap$2
  implements Runnable
{
  PlayDownloadManagerWrap$2(PlayDownloadManagerWrap paramPlayDownloadManagerWrap, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    if (this.val$item.g == 0) {
      if ((PlayDownloadManagerWrap.access$200(this.this$0) != null) && (PlayDownloadManagerWrap.access$200(this.this$0).get() != null))
      {
        AEPlayShowGridAdapter.selectedMidMaterial = this.val$item;
        ((VideoStoryCapturePartManager)PlayDownloadManagerWrap.access$200(this.this$0).get()).a(393218, new Object[] { this.val$item });
      }
    }
    while (((this.val$item.g != 4) && (this.val$item.g != 5) && (this.val$item.g != 6) && (this.val$item.g != 7)) || (PlayDownloadManagerWrap.access$200(this.this$0) == null) || (PlayDownloadManagerWrap.access$200(this.this$0).get() == null)) {
      return;
    }
    ((VideoStoryCapturePartManager)PlayDownloadManagerWrap.access$200(this.this$0).get()).a(655361, new Object[] { this.val$item });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */