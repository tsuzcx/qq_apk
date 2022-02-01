package cooperation.qzone.share;

import com.tencent.mobileqq.widget.QQToast;

class QZoneShareActivity$5$2
  implements Runnable
{
  QZoneShareActivity$5$2(QZoneShareActivity.5 param5, String paramString, long paramLong) {}
  
  public void run()
  {
    this.this$1.this$0.hideProgressDialog();
    QZoneShareActivity localQZoneShareActivity = this.this$1.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$errMsg);
    localStringBuilder.append("(");
    localStringBuilder.append(this.val$retCode);
    localStringBuilder.append(")");
    QQToast.a(localQZoneShareActivity, 1, localStringBuilder.toString(), 1).a();
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.5.2
 * JD-Core Version:    0.7.0.1
 */