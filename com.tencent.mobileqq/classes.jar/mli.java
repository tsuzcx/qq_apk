import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.qphone.base.util.QLog;

public class mli
  extends lfb
{
  public mli(VideoNetStateBar paramVideoNetStateBar) {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.i();
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onEnterRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mli
 * JD-Core Version:    0.7.0.1
 */