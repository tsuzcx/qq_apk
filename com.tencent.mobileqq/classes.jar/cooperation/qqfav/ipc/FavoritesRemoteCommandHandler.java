package cooperation.qqfav.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FavoritesRemoteCommandHandler
  implements FavoritesRemoteCommand.IRemoteCommandHandler
{
  public boolean a(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return true;
          }
          paramBundle.putBoolean("isVideoChatting", ((QQAppInterface)localObject1).isVideoChatting());
          return true;
        }
        localObject2 = paramBundle.getString("configKey");
        paramBundle.putString("configInfo", ((IFMConfig)QRoute.api(IFMConfig.class)).getConfigValue(((QQAppInterface)localObject1).getApp().getBaseContext(), (String)localObject2));
        return true;
      }
      l = paramBundle.getLong("previewSize", -1L);
      localObject2 = paramBundle.getString("previewName");
      Intent localIntent = new Intent(((QQAppInterface)localObject1).getApplication().getBaseContext(), FilePreviewActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("offline_file_type", 0);
      localIntent.putExtra("offline_file_name", (String)localObject2);
      localIntent.putExtra("offline_file_size", l);
      ((QQAppInterface)localObject1).getFileManagerDataCenter().a(new QfavFilePreviewController(paramBundle));
      QLog.i("FavoritesRemoteCommandHandler", 1, "open zip favorite,open new activity");
      ((QQAppInterface)localObject1).getApplication().getBaseContext().startActivity(localIntent);
      return true;
    }
    localObject1 = paramBundle.getString("installAppName");
    paramBundle = paramBundle.getString("installAppUrl");
    long l = 0L;
    try
    {
      localObject2 = new URL(paramBundle);
      try
      {
        paramInt = ((URL)localObject2).openConnection().getContentLength();
        l = paramInt;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      localBundle = new Bundle();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    Bundle localBundle;
    localBundle.putLong("_filesize_from_dlg", l);
    localBundle.putString("_filename_from_dlg", (String)localObject1);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_qfav");
    ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(paramBundle, localBundle);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.ipc.FavoritesRemoteCommandHandler
 * JD-Core Version:    0.7.0.1
 */