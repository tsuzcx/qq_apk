import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.qphone.base.util.QLog;

public class sna
  extends PstnObserver
{
  public sna(Conversation paramConversation) {}
  
  public void a(Boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    PstnManager localPstnManager = (PstnManager)this.a.a.getManager(142);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onPstnGrayFlag|isSuccess:" + paramBoolean + " lastPstnGrayFlag:" + this.a.f + " grayFlag:" + paramInt + " mIsChatList:" + this.a.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sna
 * JD-Core Version:    0.7.0.1
 */