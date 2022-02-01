package cooperation.vip.qqbanner.info;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.util.QZLog;
import cooperation.vip.qqbanner.data.ImmersionData;
import java.io.File;

class VasADBannerImmersionInfo$ZipResourcesinfo
  extends VasADBannerConfigInfo.ResourceInfo
{
  private VasADBannerImmersionInfo$ZipResourcesinfo(VasADBannerImmersionInfo paramVasADBannerImmersionInfo) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (FileUtil.b(this.c)))
    {
      String str = ((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(this.a.a.d.hashCode()));
      Object localObject = new File(this.c);
      ((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).unzipFile(((File)localObject).getAbsolutePath(), str);
      if (((File)localObject).exists()) {
        FileUtil.a((File)localObject);
      }
      this.c = str;
      if (QZLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("zip success = pathDir = ");
        ((StringBuilder)localObject).append(str);
        QZLog.i("VasADBannerConfigInfo", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean a()
  {
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.a.a.d)))
    {
      String str = ((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(this.a.a.d.hashCode()));
      Object localObject = new File(str);
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).listFiles();
        if ((localObject != null) && (localObject.length > 0))
        {
          this.c = str;
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerImmersionInfo.ZipResourcesinfo
 * JD-Core Version:    0.7.0.1
 */