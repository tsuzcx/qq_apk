package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.File;

class BaseLibManager$1
  implements Runnable
{
  BaseLibManager$1(BaseLibManager paramBaseLibManager, boolean paramBoolean, String paramString, BaseLibManager.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    String str2 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str1 = StorageUtil.getPreference().getString("version", "1.22.0.00008");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateBaseLib start. baseLibVersion=");
    ((StringBuilder)localObject1).append(str1);
    QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject1).toString());
    boolean bool3 = BaseLibManager.access$000(this.this$0);
    if (this.val$forceUpdate)
    {
      if (!TextUtils.isEmpty(this.val$localVersion)) {
        localObject2 = this.val$localVersion;
      } else {
        localObject2 = str1;
      }
      bool1 = true;
    }
    else
    {
      localObject2 = str1;
      bool1 = false;
    }
    boolean bool2;
    if ("1.22.0.00008".equals(str1))
    {
      QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] current version is default:1.22.0.00008");
      localObject1 = localObject2;
      bool2 = bool1;
    }
    else
    {
      Object localObject3 = BaseLibManager.g().getBaseLibDir(str2, str1);
      localObject1 = localObject2;
      bool2 = bool1;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = new File((String)localObject3);
        if (((File)localObject3).exists())
        {
          localObject1 = localObject2;
          bool2 = bool1;
          if (((File)localObject3).isDirectory()) {}
        }
        else
        {
          QMLog.i("miniapp-process_BaseLibManager", "baselib directory is not exist!");
          localObject1 = "0.0.1";
          bool2 = true;
        }
      }
    }
    if (this.val$forceUpdate)
    {
      if (!TextUtils.isEmpty(this.val$localVersion)) {
        localObject1 = this.val$localVersion;
      }
      bool2 = true;
    }
    else if (bool2)
    {
      localObject1 = "0.0.1";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[MiniEng] updateBaseLib current requestVersion is:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject2).toString());
    boolean bool1 = BaseLibManager.access$100(this.this$0, str2, str1, bool2, bool3 ^ true, (String)localObject1);
    BaseLibManager.access$002(this.this$0, true);
    if (!bool1)
    {
      BaseLibManager.access$202(this.this$0, false);
      this.val$listener.onUpdateResult(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */