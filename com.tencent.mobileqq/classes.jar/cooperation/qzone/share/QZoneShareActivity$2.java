package cooperation.qzone.share;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class QZoneShareActivity$2
  implements QQPermissionCallback
{
  QZoneShareActivity$2(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.this$0);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneShareActivity.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.2
 * JD-Core Version:    0.7.0.1
 */