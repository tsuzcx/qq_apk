package cooperation.qzone.share;

import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class QZoneShareActivity$4$2
  implements Runnable
{
  QZoneShareActivity$4$2(QZoneShareActivity.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      this.this$1.this$0.hideProgressDialog();
      bfur.a(this.this$1.this$0, 233, this.this$1.this$0.getString(2131718383), this.val$finalErrMsg, new QZoneShareActivity.4.2.1(this), null).show();
      return;
    }
    this.this$1.this$0.hideProgressDialog();
    QZoneShareActivity.access$600(this.this$1.this$0);
    QQToast.a(this.this$1.this$0, 1, 2131693817, 1).a();
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */