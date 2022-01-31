import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tcb
  extends GameCenterObserver
{
  public tcb(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (paramInt == 2)) {}
    for (;;)
    {
      return;
      if (Leba.b(this.a))
      {
        ArrayList localArrayList = new ArrayList();
        LebaUtil.a(localArrayList, LebaShowListManager.a().a(this.a.a));
        this.a.a(new tcc(this, localArrayList));
      }
      while (QLog.isColorLevel())
      {
        QLog.i("Q.lebatab.leba", 2, "onGameCenterMsgReceive, " + Leba.c(this.a));
        return;
        LebaShowListManager.a |= 0x2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcb
 * JD-Core Version:    0.7.0.1
 */