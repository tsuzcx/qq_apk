package cooperation.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import java.io.File;

class AlbumLibDownloaderUtil$3
  implements ModuleDownloadListener
{
  AlbumLibDownloaderUtil$3(AlbumLibDownloaderUtil paramAlbumLibDownloaderUtil) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("libandroidndkbeauty.so")) {
      return;
    }
    Object localObject = AlbumLibDownloaderUtil.mAlbumDir.getPath();
    paramString = new File(((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(paramString));
    if (paramString.exists()) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AlbumLibDownloaderUtil.mAlbumDir.getPath());
        localStringBuilder.append("/libandroidndkbeauty.zip");
        AlbumLibDownloaderUtil.access$100(paramString, new File(localStringBuilder.toString()));
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new File((String)localObject);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    if (!this.this$0.vertifySoIsOK(AlbumLibDownloaderUtil.BEAUTY_SO_LIB_NAME, false))
    {
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "unzip beauty so" });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AlbumLibDownloaderUtil.mAlbumDir.getPath());
      ((StringBuilder)localObject).append("/libandroidndkbeauty.zip");
      FileUtils.unzip(new File(((StringBuilder)localObject).toString()), paramString);
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "unzip beauty so finish" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil.3
 * JD-Core Version:    0.7.0.1
 */