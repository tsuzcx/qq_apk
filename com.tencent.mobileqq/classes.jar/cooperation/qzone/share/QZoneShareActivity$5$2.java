package cooperation.qzone.share;

import com.tencent.mobileqq.widget.QQToast;

class QZoneShareActivity$5$2
  implements Runnable
{
  QZoneShareActivity$5$2(QZoneShareActivity.5 param5, String paramString, long paramLong) {}
  
  public void run()
  {
    this.this$1.this$0.hideProgressDialog();
    QQToast.a(this.this$1.this$0, 1, this.val$errMsg + "(" + this.val$retCode + ")", 1).a();
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.5.2
 * JD-Core Version:    0.7.0.1
 */