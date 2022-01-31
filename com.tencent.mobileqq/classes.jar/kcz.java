import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.qphone.base.util.QLog;

public class kcz
  extends GAudioUIObserver
{
  public kcz(VideoNetStateBar paramVideoNetStateBar) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreateRoomSuc-->GroupID=" + paramLong);
    }
    this.a.i();
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcz
 * JD-Core Version:    0.7.0.1
 */