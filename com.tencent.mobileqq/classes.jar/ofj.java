import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView.JustLogPlayProgressListener;
import com.tencent.qphone.base.util.QLog;

public class ofj
  extends NeoVideoFilterPlayView.JustLogPlayProgressListener
{
  public ofj(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void a()
  {
    super.a();
    this.a.l();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onPlayFrame");
    }
    super.a(paramLong);
    try
    {
      this.a.a(1000L * paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofj
 * JD-Core Version:    0.7.0.1
 */