package cooperation.qzone.share;

import ajyc;
import android.text.TextUtils;
import bcpw;
import bhlq;
import bhun;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class QZoneShareActivity$7$1
  implements Runnable
{
  QZoneShareActivity$7$1(QZoneShareActivity.7 param7, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.b)
    {
      bcpw.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0, 4, 2131718309, 0).a();
      return;
    }
    this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.g();
    String str1 = bhun.b(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.a());
    try
    {
      l1 = Long.parseLong(QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0).f);
      l2 = l1;
      if (l1 <= 0L) {
        l2 = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.app.getLongAccountUin();
      }
      if (l2 <= 0L)
      {
        l1 = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.app.getLongAccountUin();
        Object localObject = QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0).a;
        if (localObject != null)
        {
          Iterator localIterator = ((ArrayList)localObject).iterator();
          String str2;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str2 = (String)localIterator.next();
          } while ((TextUtils.isEmpty(str2)) || (str2.startsWith("http://")) || (str2.startsWith("https://")));
          i = 0;
          if (i != 0)
          {
            localObject = new NewIntent(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0, bhlq.class);
            ((NewIntent)localObject).putExtra("reason", str1);
            ((NewIntent)localObject).putExtra("uin", l1);
            ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0));
            BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
            QLog.e("QZoneShare", 1, "startShare()");
            if (QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0).b != 1) {
              break label378;
            }
            QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0, this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0, QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0), true);
            this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.setResult(-1, this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.getIntent());
            this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0.finish();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
        continue;
        ThreadManager.postImmediately(new QZoneShareActivity.7.1.1(this, localException, str1), null, false);
        continue;
        label378:
        bcpw.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$7.this$0, 5, ajyc.a(2131712331), 0).a();
        continue;
        int i = 1;
        continue;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.7.1
 * JD-Core Version:    0.7.0.1
 */