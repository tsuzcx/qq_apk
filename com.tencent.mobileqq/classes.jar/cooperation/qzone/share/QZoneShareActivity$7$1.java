package cooperation.qzone.share;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.widget.QzoneEmotionUtils;
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
    if (this.val$currentCount > this.val$maxWordCnt)
    {
      QQToast.makeText(this.this$1.this$0, 4, 2131915206, 0).show();
      return;
    }
    this.this$1.this$0.hideKeyboardAndEmo();
    String str1 = QzoneEmotionUtils.splash2Emo(this.this$1.this$0.getEditText());
    try
    {
      l2 = Long.parseLong(QZoneShareActivity.access$300(this.this$1.this$0).shareUin);
    }
    catch (Exception localException)
    {
      long l2;
      label76:
      long l1;
      Object localObject;
      Iterator localIterator;
      int i;
      break label76;
    }
    l2 = 0L;
    l1 = l2;
    if (l2 <= 0L) {
      l1 = this.this$1.this$0.app.getLongAccountUin();
    }
    l2 = l1;
    if (l1 <= 0L) {
      l2 = this.this$1.this$0.app.getLongAccountUin();
    }
    localObject = QZoneShareActivity.access$300(this.this$1.this$0).mImageUrls;
    if (localObject != null)
    {
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str2)) && (!str2.startsWith("http://")) && (!str2.startsWith("https://")))
        {
          i = 0;
          break label211;
        }
      }
    }
    i = 1;
    label211:
    if (i != 0)
    {
      localObject = new NewIntent(this.this$1.this$0, QzoneShareServlet.class);
      ((NewIntent)localObject).putExtra("reason", str1);
      ((NewIntent)localObject).putExtra("uin", l2);
      ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.access$300(this.this$1.this$0));
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
      QLog.e("QZoneShare", 1, "startShare()");
    }
    else
    {
      ThreadManager.postImmediately(new QZoneShareActivity.7.1.1(this, (ArrayList)localObject, str1), null, false);
    }
    if (QZoneShareActivity.access$300(this.this$1.this$0).from == 1)
    {
      QZoneShareActivity.access$800(this.this$1.this$0, this.this$1.this$0, QZoneShareActivity.access$300(this.this$1.this$0), true);
    }
    else
    {
      QZoneShareActivity.access$900(this.this$1.this$0);
      QQToast.makeText(this.this$1.this$0, 5, HardCodeUtil.a(2131909883), 0).show();
    }
    this.this$1.this$0.setResult(-1, this.this$1.this$0.getIntent());
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.7.1
 * JD-Core Version:    0.7.0.1
 */