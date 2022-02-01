package dov.com.qq.im.ae.gif.giftext.fragment;

import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.Callback;
import java.util.List;

class AEGIFChunkPreviewFragment$1
  implements PngsCreateWorkingQueue.Callback
{
  AEGIFChunkPreviewFragment$1(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AEGIFChunkPreviewFragment.a(this.a, paramString);
    }
    ((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(paramInt)).c = paramString;
    ((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(paramInt)).a = 13;
    AEGIFChunkPreviewFragment.a(this.a).runOnUiThread(new AEGIFChunkPreviewFragment.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */