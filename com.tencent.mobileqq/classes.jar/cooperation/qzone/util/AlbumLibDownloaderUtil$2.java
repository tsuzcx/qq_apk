package cooperation.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import java.io.File;

class AlbumLibDownloaderUtil$2
  implements ModuleDownloadListener
{
  AlbumLibDownloaderUtil$2(AlbumLibDownloaderUtil paramAlbumLibDownloaderUtil) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("pictureMarkerSo.zip")) {
      return;
    }
    Object localObject = AlbumLibDownloaderUtil.mAlbumDir.getPath();
    paramString = new File(((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(paramString));
    if (paramString.exists())
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.unzip(paramString, (File)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil.2
 * JD-Core Version:    0.7.0.1
 */