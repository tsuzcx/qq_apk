import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public final class lks
  implements Runnable
{
  public lks(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {
      return;
    }
    if (NetworkUtil.a(this.a.getApp()))
    {
      ReadInJoyUtils.e(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "handConversationToShow is wifi");
      }
    }
    if (!ReadInJoyHelper.s(this.a))
    {
      ReadInJoyUtils.b(this.a);
      ReadInJoyHelper.e(this.a);
    }
    if (ReadInJoyHelper.o(this.a))
    {
      ReadInJoyHelper.k(this.a, false);
      ((KandianMergeManager)this.a.getManager(161)).i();
      return;
    }
    ((KandianMergeManager)this.a.getManager(161)).h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lks
 * JD-Core Version:    0.7.0.1
 */