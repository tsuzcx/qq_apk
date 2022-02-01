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
    String str4 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str3 = StorageUtil.getPreference().getString("version", "1.18.0.00132");
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "updateBaseLib start. baseLibVersion=" + str3);
    boolean bool3;
    String str1;
    boolean bool1;
    if (!BaseLibManager.access$100(this.this$0))
    {
      bool3 = true;
      if (!this.val$forceUpdate) {
        break label331;
      }
      if (TextUtils.isEmpty(this.val$localVersion)) {
        break label322;
      }
      str1 = this.val$localVersion;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      String str2;
      if ("1.18.0.00132".equals(str3))
      {
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] current version is default:1.18.0.00132");
        bool2 = bool1;
        str2 = str1;
        label114:
        if (!this.val$forceUpdate) {
          break label302;
        }
        if (TextUtils.isEmpty(this.val$localVersion)) {
          break label317;
        }
        str2 = this.val$localVersion;
        bool1 = true;
      }
      for (;;)
      {
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] updateBaseLib current requestVersion is:" + str2);
        bool1 = MiniAppCmdUtil.getInstance().updateBaseLib(str2, bool3, bool1, new BaseLibManager.2.1(this, str4, str3));
        BaseLibManager.access$102(this.this$0, true);
        if (!bool1)
        {
          BaseLibManager.access$302(this.this$0, false);
          this.val$listener.onUpdateResult(0);
        }
        return;
        bool3 = false;
        break;
        Object localObject = BaseLibManager.g().getBaseLibDir(str4, str3);
        str2 = str1;
        bool2 = bool1;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label114;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists())
        {
          str2 = str1;
          bool2 = bool1;
          if (((File)localObject).isDirectory()) {
            break label114;
          }
        }
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "baselib directory is not exist!");
        str2 = "0.0.1";
        bool2 = true;
        break label114;
        label302:
        bool1 = bool2;
        if (bool2)
        {
          str2 = "0.0.1";
          bool1 = bool2;
          continue;
          label317:
          bool1 = true;
        }
      }
      label322:
      str1 = str3;
      bool1 = true;
      continue;
      label331:
      str1 = str3;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.2
 * JD-Core Version:    0.7.0.1
 */