package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePatchConfig
  extends Step
{
  @TargetApi(11)
  private void a(Context paramContext)
  {
    QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig start.");
    for (;;)
    {
      int i;
      try
      {
        paramContext.getSharedPreferences("hotpatch_preference", 4).edit().clear().commit();
        localObject1 = new File(PatchCommonUtil.getPatchPath(""));
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).listFiles();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              if ((localObject2 == null) || (!localObject2.exists())) {
                break label194;
              }
              localObject2.delete();
              break label194;
            }
          }
        }
        paramContext.getSharedPreferences("pref_safemode_not_exit", 4).edit().clear().commit();
        paramContext.getSharedPreferences("QQDetectAttack", 0).edit().clear().commit();
        return;
      }
      catch (Throwable paramContext)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("UpdatePatchConfig clearPatchConfig exception=");
        ((StringBuilder)localObject1).append(paramContext);
        QLog.d("PatchLogTag", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      label194:
      i += 1;
    }
  }
  
  protected boolean doStep()
  {
    Context localContext = BaseApplicationImpl.sApplication.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("sp_update_version", 0);
    String str = localSharedPreferences.getString("key_cur_version", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApkUtils.b(localContext));
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(ApkUtils.a(localContext));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdatePatchConfig oldVersion=");
    localStringBuilder.append(str);
    localStringBuilder.append(", curVersion=");
    localStringBuilder.append((String)localObject);
    QLog.d("PatchLogTag", 1, localStringBuilder.toString());
    if (!((String)localObject).equals(str))
    {
      a(localContext);
      localSharedPreferences.edit().putString("key_cur_version", (String)localObject).commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePatchConfig
 * JD-Core Version:    0.7.0.1
 */