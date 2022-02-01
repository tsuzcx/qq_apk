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
    QMLog.i("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str1);
    boolean bool3;
    Object localObject1;
    boolean bool1;
    if (!BaseLibManager.access$000(this.this$0))
    {
      bool3 = true;
      if (!this.val$forceUpdate) {
        break label327;
      }
      if (TextUtils.isEmpty(this.val$localVersion)) {
        break label318;
      }
      localObject1 = this.val$localVersion;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      Object localObject2;
      if ("1.22.0.00008".equals(str1))
      {
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] current version is default:1.22.0.00008");
        bool2 = bool1;
        localObject2 = localObject1;
        label112:
        if (!this.val$forceUpdate) {
          break label291;
        }
        if (TextUtils.isEmpty(this.val$localVersion)) {
          break label309;
        }
        localObject1 = this.val$localVersion;
        bool2 = true;
      }
      for (;;)
      {
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib current requestVersion is:" + (String)localObject1);
        bool1 = BaseLibManager.access$100(this.this$0, str2, str1, bool2, bool3, (String)localObject1);
        BaseLibManager.access$002(this.this$0, true);
        if (!bool1)
        {
          BaseLibManager.access$202(this.this$0, false);
          this.val$listener.onUpdateResult(0);
        }
        return;
        bool3 = false;
        break;
        Object localObject3 = BaseLibManager.g().getBaseLibDir(str2, str1);
        localObject2 = localObject1;
        bool2 = bool1;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label112;
        }
        localObject3 = new File((String)localObject3);
        if (((File)localObject3).exists())
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (((File)localObject3).isDirectory()) {
            break label112;
          }
        }
        QMLog.i("miniapp-process_BaseLibManager", "baselib directory is not exist!");
        localObject2 = "0.0.1";
        bool2 = true;
        break label112;
        label291:
        if (bool2)
        {
          localObject1 = "0.0.1";
        }
        else
        {
          localObject1 = localObject2;
          continue;
          label309:
          localObject1 = localObject2;
          bool2 = true;
        }
      }
      label318:
      localObject1 = str1;
      bool1 = true;
      continue;
      label327:
      localObject1 = str1;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */