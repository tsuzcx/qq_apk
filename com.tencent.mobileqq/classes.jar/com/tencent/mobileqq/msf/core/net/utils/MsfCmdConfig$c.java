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
    Object localObject1 = this;
    try
    {
      if (((c)localObject1).d)
      {
        Object localObject2 = BaseApplication.getContext().getSharedPreferences("sp_del_time", 0);
        i = ((SharedPreferences)localObject2).getInt("key_sp_delete_version", 0);
        if (i != paramInt)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          if (localObject2 != null)
          {
            ((SharedPreferences.Editor)localObject2).putInt("key_sp_delete_version", paramInt);
            ((SharedPreferences.Editor)localObject2).commit();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("One Time Mode,just delete sp one times,localversion =");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",version = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d("MsfCmdConfig", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("One Time Mode,don't delete sp one more times,localversion =");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",version = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d("MsfCmdConfig", 1, ((StringBuilder)localObject2).toString());
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      QLog.e("MsfCmdConfig", 1, "execute delete sp faild", localThrowable);
      Object localObject3 = BaseApplication.getContext().getFilesDir().getAbsolutePath().replace("files", "shared_prefs");
      if (((c)localObject1).c) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
      QLog.d("MsfCmdConfig", 1, new Object[] { " The SharedPreferenceMode is ", Integer.valueOf(paramInt) });
      Iterator localIterator1 = paramList.iterator();
      for (paramList = (List)localObject3; localIterator1.hasNext(); paramList = (List)localObject1)
      {
        localObject3 = (Pair)localIterator1.next();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramList);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append((String)((Pair)localObject3).first);
        ((StringBuilder)localObject1).append(".xml");
        localObject1 = new File(((StringBuilder)localObject1).toString());
        Object localObject4;
        Object localObject5;
        if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
        {
          localObject4 = BaseApplication.getContext().getSharedPreferences((String)((Pair)localObject3).first, paramInt);
          localObject1 = ((SharedPreferences)localObject4).edit();
          if (localObject1 != null)
          {
            localObject4 = ((SharedPreferences)localObject4).getAll();
            localObject3 = Pattern.compile((String)((Pair)localObject3).second);
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (String)((Map.Entry)((Iterator)localObject4).next()).getKey();
              if (((Pattern)localObject3).matcher((CharSequence)localObject5).matches())
              {
                ((SharedPreferences.Editor)localObject1).remove((String)localObject5).commit();
                QLog.d("MsfCmdConfig", 1, new Object[] { localObject5, " has been removed" });
              }
            }
          }
          MsfPullConfigUtil.showToastForSafeModeTest("执行删除sp指令，修复闪退");
          localObject1 = paramList;
        }
        else
        {
          localObject4 = new File(paramList).listFiles(new e(this, (Pair)localObject3));
          localObject1 = paramList;
          if (localObject4 != null)
          {
            localObject1 = paramList;
            if (localObject4.length > 0)
            {
              int j = localObject4.length;
              i = 0;
              for (;;)
              {
                localObject1 = paramList;
                if (i >= j) {
                  break;
                }
                localObject1 = localObject4[i];
                if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
                {
                  localObject1 = ((File)localObject1).getName();
                  if (((String)localObject1).endsWith(".xml"))
                  {
                    localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 4);
                    Object localObject6 = BaseApplication.getContext().getSharedPreferences((String)localObject1, paramInt);
                    localObject5 = ((SharedPreferences)localObject6).edit();
                    localObject1 = paramList;
                    if (localObject5 != null)
                    {
                      localObject1 = ((SharedPreferences)localObject6).getAll();
                      localObject6 = Pattern.compile((String)((Pair)localObject3).second);
                      Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
                      for (;;)
                      {
                        localObject1 = paramList;
                        if (!localIterator2.hasNext()) {
                          break;
                        }
                        localObject1 = (String)((Map.Entry)localIterator2.next()).getKey();
                        if (((Pattern)localObject6).matcher((CharSequence)localObject1).matches())
                        {
                          ((SharedPreferences.Editor)localObject5).remove((String)localObject1).commit();
                          QLog.d("MsfCmdConfig", 1, new Object[] { localObject1, " has been removed" });
                        }
                      }
                    }
                    paramList = (List)localObject1;
                    MsfPullConfigUtil.showToastForSafeModeTest("执行删除sp指令，修复闪退");
                  }
                }
                i += 1;
              }
            }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.c
 * JD-Core Version:    0.7.0.1
 */