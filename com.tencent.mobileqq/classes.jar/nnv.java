import android.annotation.TargetApi;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nnv
  implements Runnable
{
  public nnv(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.a.jdField_i_of_type_Boolean)
    {
      SLog.a(this.a.a, "[%d]not attach! not schedule!", Integer.valueOf(this.a.jdField_i_of_type_Int));
      return;
    }
    int i = this.a.getCurrentPosition();
    SLog.b(this.a.a, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", new Object[] { Integer.valueOf(this.a.jdField_i_of_type_Int), Boolean.valueOf(this.a.isPlaying()), Integer.valueOf(this.a.l), Integer.valueOf(i), Integer.valueOf(this.a.q), Integer.valueOf(this.a.o) });
    if ((this.a.isPlaying()) && (i == this.a.p) && (this.a.q > 0))
    {
      if (this.a.q > 1)
      {
        SLog.e(this.a.a, "[%d]Position not change for %d times, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.a.jdField_i_of_type_Int), Integer.valueOf(this.a.q) });
        this.a.a(true);
        return;
      }
      this.a.postDelayed(this, 250L);
      return;
    }
    if ((!this.a.isPlaying()) && (i != this.a.n))
    {
      if (this.a.o > 1)
      {
        SLog.e(this.a.a, "[%d]Position change for %d times, but is pause, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.a.jdField_i_of_type_Int), Integer.valueOf(this.a.o) });
        this.a.a(true);
        return;
      }
      this.a.postDelayed(this, 250L);
      return;
    }
    SLog.b(this.a.a, "[%d] CheckNeedRestart good for now", Integer.valueOf(this.a.jdField_i_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnv
 * JD-Core Version:    0.7.0.1
 */