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
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QfavMainQIPCModule("QfavMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = 0;
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return EIPCResult.createResult(100, localBundle);
    }
    long l;
    if ("getfavList".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = paramBundle.getParcelableArrayList("favfile_list");
      if (paramString != null) {
        paramInt = paramString.size();
      }
      l = paramBundle.getLong("reqTimestamp");
      localQQAppInterface.getFileManagerEngine().a().onGettedFileList(l, paramString, paramBundle);
      QLog.d("QfavMainQIPCModule", 1, "onCall ACTION_GET_FAVLIST 收到" + paramInt + "条收藏");
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      if ("refreshFavList".equals(paramString))
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        boolean bool = paramBundle.getBoolean("refresh_list_succ", false);
        paramBundle.putString("delete_favids", paramBundle.getString("refresh_deleted_list"));
        localQQAppInterface.getFileManagerEngine().a().onFileListRefreshed(bool, paramBundle);
        QLog.d("QfavMainQIPCModule", 1, "onCall ACTION_REFRESH_FAVLIST bSucc:" + bool);
      }
      else if ("ondownloadThumb".equals(paramString))
      {
        l = paramBundle.getLong("download_fav_id");
        paramString = paramBundle.getString("fav_thumb_path");
        paramInt = paramBundle.getInt("thumb_format");
        localQQAppInterface.getFileManagerEngine().a().onFileThumbUpdated(l, paramString, paramInt);
      }
      else if ("ondownloadFile".equals(paramString))
      {
        l = paramBundle.getLong("download_fav_id");
        paramString = paramBundle.getString("fav_save_path");
        localQQAppInterface.getFileManagerEngine().a().onFileDownloaded(l, paramString);
      }
      else if ("onAVChatting".equals(paramString))
      {
        localBundle.putBoolean("is_videochatting", localQQAppInterface.isVideoChatting());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavMainQIPCModule
 * JD-Core Version:    0.7.0.1
 */