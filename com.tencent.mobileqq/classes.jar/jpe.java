import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.groupvideo.GroupVideoWrapper;

public class jpe
  extends MessageObserver
{
  public jpe(QQServiceForAV paramQQServiceForAV) {}
  
  protected void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      new GroupVideoWrapper(localQQAppInterface).a(new jpf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jpe
 * JD-Core Version:    0.7.0.1
 */