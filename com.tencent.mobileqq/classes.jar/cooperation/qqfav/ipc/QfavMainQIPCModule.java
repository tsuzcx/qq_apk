package cooperation.qqfav.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;

public class QfavMainQIPCModule
  extends QIPCModule
{
  private static volatile QfavMainQIPCModule a;
  
  private QfavMainQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QfavMainQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QfavMainQIPCModule("QfavMainQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  QQAppInterface b()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = b();
    if (localQQAppInterface == null) {
      return EIPCResult.createResult(100, localBundle);
    }
    boolean bool = "getfavList".equals(paramString);
    paramInt = 0;
    long l;
    if (bool)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = paramBundle.getParcelableArrayList("favfile_list");
      if (paramString != null) {
        paramInt = paramString.size();
      }
      l = paramBundle.getLong("reqTimestamp");
      localQQAppInterface.getFileManagerEngine().h().onGettedFileList(l, paramString, paramBundle);
      paramString = new StringBuilder();
      paramString.append("onCall ACTION_GET_FAVLIST 收到");
      paramString.append(paramInt);
      paramString.append("条收藏");
      QLog.d("QfavMainQIPCModule", 1, paramString.toString());
    }
    else if ("refreshFavList".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      bool = paramBundle.getBoolean("refresh_list_succ", false);
      paramBundle.putString("delete_favids", paramBundle.getString("refresh_deleted_list"));
      localQQAppInterface.getFileManagerEngine().h().onFileListRefreshed(bool, paramBundle);
      paramString = new StringBuilder();
      paramString.append("onCall ACTION_REFRESH_FAVLIST bSucc:");
      paramString.append(bool);
      QLog.d("QfavMainQIPCModule", 1, paramString.toString());
    }
    else if ("ondownloadThumb".equals(paramString))
    {
      l = paramBundle.getLong("download_fav_id");
      paramString = paramBundle.getString("fav_thumb_path");
      paramInt = paramBundle.getInt("thumb_format");
      localQQAppInterface.getFileManagerEngine().h().onFileThumbUpdated(l, paramString, paramInt);
    }
    else if ("ondownloadFile".equals(paramString))
    {
      l = paramBundle.getLong("download_fav_id");
      paramString = paramBundle.getString("fav_save_path");
      localQQAppInterface.getFileManagerEngine().h().onFileDownloaded(l, paramString);
    }
    else if ("onAVChatting".equals(paramString))
    {
      localBundle.putBoolean("is_videochatting", localQQAppInterface.isVideoChatting());
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavMainQIPCModule
 * JD-Core Version:    0.7.0.1
 */