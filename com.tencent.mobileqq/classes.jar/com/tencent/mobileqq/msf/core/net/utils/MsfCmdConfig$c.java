package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MsfCmdConfig$c
  extends MsfCmdConfig.a
{
  private static final String e = "sp_del_time";
  private static final String f = "key_sp_delete_version";
  private boolean d = false;
  
  MsfCmdConfig$c(String paramString, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(null);
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  protected void a(int paramInt, List paramList)
  {
    int i;
    try
    {
      if (this.d)
      {
        localObject1 = BaseApplication.getContext().getSharedPreferences("sp_del_time", 0);
        i = ((SharedPreferences)localObject1).getInt("key_sp_delete_version", 0);
        if (i == paramInt) {
          break label387;
        }
        localObject1 = ((SharedPreferences)localObject1).edit();
        if (localObject1 != null)
        {
          ((SharedPreferences.Editor)localObject1).putInt("key_sp_delete_version", paramInt);
          ((SharedPreferences.Editor)localObject1).commit();
        }
        QLog.d("MsfCmdConfig", 1, "One Time Mode,just delete sp one times,localversion =" + i + ",version = " + paramInt);
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          Object localObject1;
          QLog.e("MsfCmdConfig", 1, "execute delete sp faild", localThrowable);
          continue;
          paramInt = 0;
          continue;
          MsfPullConfigUtil.showToastForSafeModeTest("执行删除sp指令，修复闪退");
        }
        localObject3 = new File(localThrowable).listFiles(new d(this, (Pair)localObject2));
      } while ((localObject3 == null) || (localObject3.length <= 0));
      j = localObject3.length;
      i = 0;
    }
    localObject1 = BaseApplication.getContext().getFilesDir().getAbsolutePath().replace("files", "shared_prefs");
    if (this.c)
    {
      paramInt = 4;
      QLog.d("MsfCmdConfig", 1, new Object[] { " The SharedPreferenceMode is ", Integer.valueOf(paramInt) });
      paramList = paramList.iterator();
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (paramList.hasNext())
      {
        localObject2 = (Pair)paramList.next();
        localObject3 = new File((String)localObject1 + File.separator + (String)((Pair)localObject2).first + ".xml");
        if ((!((File)localObject3).isFile()) || (!((File)localObject3).exists())) {
          break label450;
        }
        localObject4 = BaseApplication.getContext().getSharedPreferences((String)((Pair)localObject2).first, paramInt);
        localObject3 = ((SharedPreferences)localObject4).edit();
        if (localObject3 != null)
        {
          localObject4 = ((SharedPreferences)localObject4).getAll();
          localObject2 = Pattern.compile((String)((Pair)localObject2).second);
          localObject4 = ((Map)localObject4).entrySet().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Map.Entry)((Iterator)localObject4).next()).getKey();
            if (((Pattern)localObject2).matcher((CharSequence)localObject5).matches())
            {
              ((SharedPreferences.Editor)localObject3).remove((String)localObject5).commit();
              QLog.d("MsfCmdConfig", 1, new Object[] { localObject5, " has been removed" });
            }
          }
          label387:
          QLog.d("MsfCmdConfig", 1, "One Time Mode,don't delete sp one more times,localversion =" + i + ",version = " + paramInt);
        }
      }
      else
      {
        return;
      }
      label450:
      int j;
      while (i < j)
      {
        localObject4 = localObject3[i];
        if ((((File)localObject4).isFile()) && (((File)localObject4).exists()))
        {
          localObject4 = ((File)localObject4).getName();
          if (((String)localObject4).endsWith(".xml"))
          {
            localObject4 = ((String)localObject4).substring(0, ((String)localObject4).length() - 4);
            localObject5 = BaseApplication.getContext().getSharedPreferences((String)localObject4, paramInt);
            localObject4 = ((SharedPreferences)localObject5).edit();
            if (localObject4 != null)
            {
              Object localObject6 = ((SharedPreferences)localObject5).getAll();
              localObject5 = Pattern.compile((String)((Pair)localObject2).second);
              localObject6 = ((Map)localObject6).entrySet().iterator();
              while (((Iterator)localObject6).hasNext())
              {
                String str = (String)((Map.Entry)((Iterator)localObject6).next()).getKey();
                if (((Pattern)localObject5).matcher(str).matches())
                {
                  ((SharedPreferences.Editor)localObject4).remove(str).commit();
                  QLog.d("MsfCmdConfig", 1, new Object[] { str, " has been removed" });
                }
              }
            }
            MsfPullConfigUtil.showToastForSafeModeTest("执行删除sp指令，修复闪退");
          }
        }
        i += 1;
      }
    }
  }
  
  protected boolean a()
  {
    return ("rm_kv".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
  }
  
  protected boolean a(Pair paramPair)
  {
    if (TextUtils.isEmpty((CharSequence)paramPair.first)) {
      return false;
    }
    return !TextUtils.isEmpty((CharSequence)paramPair.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.c
 * JD-Core Version:    0.7.0.1
 */