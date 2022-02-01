package cooperation.qzone.share;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class QZoneShareActivity$4$2
  implements Runnable
{
  QZoneShareActivity$4$2(QZoneShareActivity.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    long l = this.val$finalErrCode;
    if ((l != -100070004L) && (l != -1000710003L))
    {
      this.this$1.this$0.hideProgressDialog();
      QZoneShareActivity.access$600(this.this$1.this$0);
      QQToast.a(this.this$1.this$0, 1, 2131694174, 1).a();
      this.this$1.this$0.finish();
      return;
    }
    this.this$1.this$0.hideProgressDialog();
    DialogUtil.a(this.this$1.this$0, 233, this.this$1.this$0.getString(2131719012), this.val$finalErrMsg, new QZoneShareActivity.4.2.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */