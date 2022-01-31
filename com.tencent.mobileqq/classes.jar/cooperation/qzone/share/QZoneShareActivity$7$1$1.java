package cooperation.qzone.share;

import bjao;
import bjns;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

class QZoneShareActivity$7$1$1
  implements Runnable
{
  QZoneShareActivity$7$1$1(QZoneShareActivity.7.1 param1, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7$1.a.this$0.app.getAccount();
    String str = ((TicketManager)this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7$1.a.this$0.app.getManager(2)).getSkey((String)localObject);
    if (new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).equals(bjao.a(this.jdField_a_of_type_JavaUtilArrayList, (String)localObject, str, "1"))) {
      QLog.e("QZoneShare", 1, "imageChangeError!");
    }
    try
    {
      l1 = Long.parseLong(QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7$1.a.this$0).f);
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7$1.a.this$0.app.getLongAccountUin();
      }
      localObject = new NewIntent(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7$1.a.this$0, bjns.class);
      ((NewIntent)localObject).putExtra("reason", this.jdField_a_of_type_JavaLangString);
      ((NewIntent)localObject).putExtra("uin", l2);
      ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7$1.a.this$0));
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
      QLog.e("QZoneShare", 1, "startShare()");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.7.1.1
 * JD-Core Version:    0.7.0.1
 */