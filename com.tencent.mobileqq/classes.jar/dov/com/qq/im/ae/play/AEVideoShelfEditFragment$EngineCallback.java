package dov.com.qq.im.ae.play;

import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import java.lang.ref.WeakReference;

class AEVideoShelfEditFragment$EngineCallback
  implements VideoShelfEngine.Callback
{
  private WeakReference<AEVideoShelfEditFragment> mRef;
  
  public AEVideoShelfEditFragment$EngineCallback(AEVideoShelfEditFragment paramAEVideoShelfEditFragment)
  {
    this.mRef = new WeakReference(paramAEVideoShelfEditFragment);
  }
  
  public void onCancelCompleted()
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onCancelCompleted();
    }
  }
  
  public void onCompleted()
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onCompleted();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onError(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onProgress(paramInt);
    }
  }
  
  public void onStartGenerate()
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onStartGenerate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.EngineCallback
 * JD-Core Version:    0.7.0.1
 */