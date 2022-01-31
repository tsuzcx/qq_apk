package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import bgvs;
import bgvu;
import bgvw;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.io.File;

public class BaseLibManager$2
  implements Runnable
{
  public BaseLibManager$2(bgvs parambgvs, boolean paramBoolean, String paramString, bgvw parambgvw) {}
  
  public void run()
  {
    String str2 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str1 = StorageUtil.getPreference().getString("version", "1.14.0.00225");
    QMLog.i("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str1);
    boolean bool3;
    Object localObject1;
    boolean bool1;
    if (!bgvs.a(this.this$0))
    {
      bool3 = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label345;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label336;
      }
      localObject1 = this.jdField_a_of_type_JavaLangString;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      Object localObject2;
      if ("1.14.0.00225".equals(str1))
      {
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] current version is default:1.14.0.00225");
        bool2 = bool1;
        localObject2 = localObject1;
        label112:
        if (!this.jdField_a_of_type_Boolean) {
          break label305;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label327;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString;
        bool1 = true;
      }
      for (;;)
      {
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib current requestVersion is:" + (String)localObject1);
        bool1 = ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib((String)localObject1, bool3, bool1, new bgvu(this, str1, str2));
        bgvs.a(this.this$0, true);
        if (!bool1)
        {
          bgvs.b(this.this$0, false);
          this.jdField_a_of_type_Bgvw.a(0);
        }
        return;
        bool3 = false;
        break;
        Object localObject3 = bgvs.a().b(str2, str1);
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
        label305:
        if (bool2)
        {
          bool1 = bool2;
          localObject1 = "0.0.1";
        }
        else
        {
          bool1 = bool2;
          localObject1 = localObject2;
          continue;
          label327:
          localObject1 = localObject2;
          bool1 = true;
        }
      }
      label336:
      localObject1 = str1;
      bool1 = true;
      continue;
      label345:
      localObject1 = str1;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2
 * JD-Core Version:    0.7.0.1
 */