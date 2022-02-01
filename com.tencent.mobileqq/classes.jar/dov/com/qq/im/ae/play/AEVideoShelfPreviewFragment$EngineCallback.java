package dov.com.qq.im.ae.play;

import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import java.lang.ref.WeakReference;

class AEVideoShelfPreviewFragment$EngineCallback
  implements VideoShelfEngine.Callback
{
  private WeakReference<AEVideoShelfPreviewFragment> mRef;
  
  public AEVideoShelfPreviewFragment$EngineCallback(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment)
  {
    this.mRef = new WeakReference(paramAEVideoShelfPreviewFragment);
  }
  
  public void onCancelCompleted()
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      AEVideoShelfPreviewFragment.access$1600((AEVideoShelfPreviewFragment)this.mRef.get());
    }
  }
  
  public void onCompleted()
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AEVideoShelfPreviewFragment)this.mRef.get()).onCompletion();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      AEVideoShelfPreviewFragment.access$1500((AEVideoShelfPreviewFragment)this.mRef.get(), paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      AEVideoShelfPreviewFragment.access$1400((AEVideoShelfPreviewFragment)this.mRef.get(), paramInt);
    }
  }
  
  public void onStartGenerate()
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      AEVideoShelfPreviewFragment.access$1300((AEVideoShelfPreviewFragment)this.mRef.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.EngineCallback
 * JD-Core Version:    0.7.0.1
 */