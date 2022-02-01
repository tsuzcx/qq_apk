package cooperation.qqcircle.helpers;

import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.io.File;
import mqq.app.MobileQQ;

class QCircleSkinHelper$2
  implements RFWDownloader.RFWDownloadListener
{
  QCircleSkinHelper$2(QCircleSkinHelper paramQCircleSkinHelper, String paramString1, QCircleSkinHelper.SkinDownLoadLister paramSkinDownLoadLister, String paramString2) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    QCircleSkinHelper localQCircleSkinHelper = this.this$0;
    String str = this.val$url;
    Object localObject;
    if (paramBoolean) {
      localObject = "0";
    } else {
      localObject = "-1";
    }
    QCircleSkinHelper.access$400(localQCircleSkinHelper, str, (String)localObject, (float)(System.currentTimeMillis() - QCircleSkinHelper.access$300(this.this$0)) / 1000.0F);
    if (paramBoolean)
    {
      localObject = this.val$skinDownLoadLister;
      if (localObject != null) {
        ((QCircleSkinHelper.SkinDownLoadLister)localObject).onRspCallback(true, paramString);
      }
      localObject = new File(this.val$oldSkinPath);
      if ((new File(paramString).exists()) && ((!((File)localObject).exists()) || (((File)localObject).delete()))) {
        SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_skin_package_path", paramString);
      }
    }
    else
    {
      localObject = this.val$skinDownLoadLister;
      if (localObject != null) {
        ((QCircleSkinHelper.SkinDownLoadLister)localObject).onRspCallback(false, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleSkinHelper.2
 * JD-Core Version:    0.7.0.1
 */