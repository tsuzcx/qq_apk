import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.groupvideo.GroupVideoWrapper;

public class jnq
  extends MessageObserver
{
  public jnq(QQServiceForAV paramQQServiceForAV) {}
  
  protected void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      new GroupVideoWrapper(localQQAppInterface).a(new jnr(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jnq
 * JD-Core Version:    0.7.0.1
 */