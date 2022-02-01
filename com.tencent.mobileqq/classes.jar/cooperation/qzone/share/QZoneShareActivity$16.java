package cooperation.qzone.share;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import cooperation.qzone.QZoneShareData;

class QZoneShareActivity$16
  implements BusinessObserver
{
  QZoneShareActivity$16(QZoneShareActivity paramQZoneShareActivity, String paramString, QZoneShareData paramQZoneShareData) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 1) && ((paramObject instanceof OpenID)))
    {
      paramObject = (OpenID)paramObject;
      if ((paramObject.openID != null) && (!paramObject.openID.equals(this.val$shareOpenid)))
      {
        paramObject = this.this$0;
        paramObject.showOpenIdConfirmDialog(paramObject, this.val$shareData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.16
 * JD-Core Version:    0.7.0.1
 */