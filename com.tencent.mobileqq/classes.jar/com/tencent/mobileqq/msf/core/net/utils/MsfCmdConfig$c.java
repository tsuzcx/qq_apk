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
  MsfCmdConfig$c(String paramString, List paramList, boolean paramBoolean)
  {
    super(null);
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean;
  }
  
  protected void a(int paramInt, List paramList)
  {
    String str1 = BaseApplication.getContext().getFilesDir().getAbsolutePath().replace("files", "shared_prefs");
    if (this.c)
    {
      paramInt = 4;
      QLog.d("MsfCmdConfig", 1, new Object[] { " The SharedPreferenceMode is ", Integer.valueOf(paramInt) });
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      Object localObject1 = (Pair)paramList.next();
      Object localObject2 = new File(str1 + File.separator + (String)((Pair)localObject1).first + ".xml");
      Object localObject3;
      Object localObject4;
      if ((((File)localObject2).isFile()) && (((File)localObject2).exists()))
      {
        localObject3 = BaseApplication.getContext().getSharedPreferences((String)((Pair)localObject1).first, paramInt);
        localObject2 = ((SharedPreferences)localObject3).edit();
        if (localObject2 != null)
        {
          localObject3 = ((SharedPreferences)localObject3).getAll();
          localObject1 = Pattern.compile((String)((Pair)localObject1).second);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Map.Entry)((Iterator)localObject3).next()).getKey();
              if (((Pattern)localObject1).matcher((CharSequence)localObject4).matches())
              {
                ((SharedPreferences.Editor)localObject2).remove((String)localObject4).commit();
                QLog.d("MsfCmdConfig", 1, new Object[] { localObject4, " has been removed" });
                continue;
                paramInt = 0;
                break;
              }
            }
          }
        }
        MsfPullConfigUtil.showToastForSafeModeTest("执行删除文件指令，修复闪退");
      }
      else
      {
        localObject2 = new File(str1).listFiles(new d(this, (Pair)localObject1));
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            localObject3 = localObject2[i];
            if ((((File)localObject3).isFile()) && (((File)localObject3).exists()))
            {
              localObject3 = ((File)localObject3).getName();
              if (((String)localObject3).endsWith(".xml"))
              {
                localObject3 = ((String)localObject3).substring(0, ((String)localObject3).length() - 4);
                localObject4 = BaseApplication.getContext().getSharedPreferences((String)localObject3, paramInt);
                localObject3 = ((SharedPreferences)localObject4).edit();
                if (localObject3 != null)
                {
                  Object localObject5 = ((SharedPreferences)localObject4).getAll();
                  localObject4 = Pattern.compile((String)((Pair)localObject1).second);
                  localObject5 = ((Map)localObject5).entrySet().iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    String str2 = (String)((Map.Entry)((Iterator)localObject5).next()).getKey();
                    if (((Pattern)localObject4).matcher(str2).matches())
                    {
                      ((SharedPreferences.Editor)localObject3).remove(str2).commit();
                      QLog.d("MsfCmdConfig", 1, new Object[] { str2, " has been removed" });
                    }
                  }
                }
                MsfPullConfigUtil.showToastForSafeModeTest("执行删除文件指令，修复闪退");
              }
            }
            i += 1;
          }
        }
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