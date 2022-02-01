package com.tencent.mobileqq.startup.step;

import adbk;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ardl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePatchConfig
  extends Step
{
  @TargetApi(11)
  private void a(Context paramContext)
  {
    int i = 0;
    QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig start.");
    for (;;)
    {
      try
      {
        paramContext.getSharedPreferences("hotpatch_preference", 4).edit().clear().commit();
        Object localObject1 = new File(PatchCommonUtil.getPatchPath(""));
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).listFiles();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int j = localObject1.length;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              if ((localObject2 == null) || (!localObject2.exists())) {
                break label184;
              }
              localObject2.delete();
              break label184;
            }
          }
        }
        paramContext.getSharedPreferences("pref_safemode_not_exit", 4).edit().clear().commit();
        paramContext.getSharedPreferences("QQDetectAttack", 0).edit().clear().commit();
        return;
      }
      catch (Throwable paramContext)
      {
        QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig exception=" + paramContext);
        return;
      }
      label184:
      i += 1;
    }
  }
  
  protected boolean doStep()
  {
    Context localContext = BaseApplicationImpl.sApplication.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("sp_update_version", 0);
    String str1 = localSharedPreferences.getString("key_cur_version", "");
    String str2 = ardl.a(localContext) + "." + ardl.a(localContext);
    QLog.d("PatchLogTag", 1, "UpdatePatchConfig oldVersion=" + str1 + ", curVersion=" + str2);
    if (!str2.equals(str1))
    {
      a(localContext);
      localSharedPreferences.edit().putString("key_cur_version", str2).commit();
      adbk.a(localContext);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePatchConfig
 * JD-Core Version:    0.7.0.1
 */