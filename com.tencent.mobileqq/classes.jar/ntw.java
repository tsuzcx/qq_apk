import android.annotation.TargetApi;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ntw
  implements Runnable
{
  public ntw(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.a.jdField_i_of_type_Boolean)
    {
      SLog.a(this.a.jdField_a_of_type_JavaLangString, "[%d]not attach! not schedule!", Integer.valueOf(this.a.jdField_i_of_type_Int));
      return;
    }
    int i = this.a.getCurrentPosition();
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(this.a.jdField_i_of_type_Int), Boolean.valueOf(this.a.isPlaying()), Integer.valueOf(this.a.l), Integer.valueOf(i));
    TrimTextureVideoView localTrimTextureVideoView;
    if (this.a.l != 0)
    {
      if (!this.a.isPlaying()) {
        break label216;
      }
      if (i == this.a.p)
      {
        localTrimTextureVideoView = this.a;
        localTrimTextureVideoView.q += 1;
        this.a.p = i;
      }
    }
    else
    {
      if ((!this.a.isPlaying()) || (this.a.l <= 0) || (i < this.a.l)) {
        break label264;
      }
      this.a.a(true);
    }
    for (;;)
    {
      SLog.b(this.a.jdField_a_of_type_JavaLangString, "schedule next!");
      this.a.postDelayed(this, 200L);
      return;
      this.a.q = 0;
      break;
      label216:
      if (i == this.a.n) {}
      for (this.a.o = 0;; localTrimTextureVideoView.o += 1)
      {
        this.a.n = i;
        break;
        localTrimTextureVideoView = this.a;
      }
      label264:
      if (this.a.jdField_a_of_type_Int == 5) {
        this.a.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntw
 * JD-Core Version:    0.7.0.1
 */