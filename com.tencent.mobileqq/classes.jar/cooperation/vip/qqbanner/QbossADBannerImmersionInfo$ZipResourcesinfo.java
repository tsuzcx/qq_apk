package cooperation.vip.qqbanner;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;

class QbossADBannerImmersionInfo$ZipResourcesinfo
  extends QbossADBannerConfigInfo.ResourceInfo
{
  private QbossADBannerImmersionInfo$ZipResourcesinfo(QbossADBannerImmersionInfo paramQbossADBannerImmersionInfo) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (FileUtil.a(this.c)))
    {
      String str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.a.i.hashCode()));
      File localFile = new File(this.c);
      QzoneZipCacheHelper.unzipFile(localFile.getAbsolutePath(), str);
      if (localFile.exists()) {
        FileUtil.a(localFile);
      }
      this.c = str;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerConfigInfo", 2, "zip success = pathDir = " + str);
      }
    }
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.a.i))) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        return false;
        str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.a.i.hashCode()));
        localObject = new File(str);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).listFiles();
    } while ((localObject == null) || (localObject.length <= 0));
    this.c = str;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerImmersionInfo.ZipResourcesinfo
 * JD-Core Version:    0.7.0.1
 */