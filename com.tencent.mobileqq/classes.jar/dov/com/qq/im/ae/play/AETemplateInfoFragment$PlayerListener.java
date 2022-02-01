package dov.com.qq.im.ae.play;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import java.lang.ref.WeakReference;

class AETemplateInfoFragment$PlayerListener
  implements IVideoShelfPlayerListener
{
  private WeakReference<AETemplateInfoFragment> mRef;
  
  public AETemplateInfoFragment$PlayerListener(AETemplateInfoFragment paramAETemplateInfoFragment)
  {
    this.mRef = new WeakReference(paramAETemplateInfoFragment);
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onCompletion()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onCompletion");
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AETemplateInfoFragment)this.mRef.get()).onPlayComplete();
    }
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onError errCode=" + paramInt + ", msg=" + paramString);
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      AETemplateInfoFragment.access$600((AETemplateInfoFragment)this.mRef.get());
    }
    return true;
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer) {}
  
  public void onUpdateRate(long paramLong)
  {
    if ((this.mRef != null) && (this.mRef.get() != null)) {
      ((AETemplateInfoFragment)this.mRef.get()).onUpdateRate(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment.PlayerListener
 * JD-Core Version:    0.7.0.1
 */