package com.tencent.mobileqq.mini.apkg;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BaseLibManager$2
  implements Runnable
{
  BaseLibManager$2(BaseLibManager paramBaseLibManager, boolean paramBoolean, String paramString, BaseLibManager.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    String str2 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str1 = StorageUtil.getPreference().getString("version", "1.22.0.00008");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateBaseLib start. baseLibVersion=");
    ((StringBuilder)localObject1).append(str1);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject1).toString());
    boolean bool3 = BaseLibManager.access$100(this.this$0);
    boolean bool2;
    if (this.val$forceUpdate)
    {
      if (!TextUtils.isEmpty(this.val$localVersion)) {
        localObject2 = this.val$localVersion;
      } else {
        localObject2 = str1;
      }
      bool2 = true;
    }
    else
    {
      localObject2 = str1;
      bool2 = false;
    }
    if ("1.22.0.00008".equals(str1))
    {
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] current version is default:1.22.0.00008");
      localObject1 = localObject2;
      bool1 = bool2;
    }
    else
    {
      Object localObject3 = BaseLibManager.g().getBaseLibDir(str2, str1);
      localObject1 = localObject2;
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = new File((String)localObject3);
        if (((File)localObject3).exists())
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (((File)localObject3).isDirectory()) {}
        }
        else
        {
          QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "baselib directory is not exist!");
          localObject1 = "0.0.1";
          bool1 = true;
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
    else
    {
      bool2 = bool1;
      if (bool1)
      {
        localObject1 = "0.0.1";
        bool2 = bool1;
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[MiniEng] updateBaseLib current requestVersion is:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject2).toString());
    boolean bool1 = MiniAppCmdUtil.getInstance().updateBaseLib((String)localObject1, bool3 ^ true, bool2, new BaseLibManager.2.1(this, str2, str1));
    BaseLibManager.access$102(this.this$0, true);
    if (!bool1)
    {
      BaseLibManager.access$302(this.this$0, false);
      this.val$listener.onUpdateResult(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.2
 * JD-Core Version:    0.7.0.1
 */