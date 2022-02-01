package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MsfCmdConfig$e
  extends MsfCmdConfig.a
{
  MsfCmdConfig$e(String paramString, List paramList, boolean paramBoolean)
  {
    super(null);
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean;
  }
  
  protected void a(int paramInt, List paramList)
  {
    Object localObject = BaseApplication.getContext();
    boolean bool1 = false;
    localObject = ((BaseApplication)localObject).getSharedPreferences("pref_safemode_not_exit", 0);
    if (paramInt > ((SharedPreferences)localObject).getInt("key_not_exit_version", 0))
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      localEditor.putInt("key_not_exit_version", paramInt);
      Iterator localIterator = paramList.iterator();
      localObject = null;
      List localList = null;
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if ("enable".equals(localPair.first))
        {
          bool1 = Boolean.parseBoolean((String)localPair.second);
        }
        else
        {
          boolean bool2 = "crashType".equals(localPair.first);
          paramList = "";
          if (bool2)
          {
            if (localPair.second != null) {
              paramList = (String)localPair.second;
            }
            localObject = paramList;
          }
          else if ("crashStack".equals(localPair.first))
          {
            if (localPair.second != null) {
              paramList = (String)localPair.second;
            }
            localList = paramList;
          }
        }
      }
      paramList = new StringBuilder();
      paramList.append("noExitEnable=");
      paramList.append(bool1);
      paramList.append(",noExitCrashType=");
      paramList.append((String)localObject);
      paramList.append(",noExitCrashStack=");
      paramList.append(localList);
      QLog.d("MsfCmdConfig", 1, paramList.toString());
      localEditor.putBoolean("key_not_exit_enable", bool1);
      localEditor.putString("key_not_exit_crash_type", (String)localObject);
      localEditor.putString("key_not_exit_crash_stack", localList);
      localEditor.commit();
    }
  }
  
  protected boolean a()
  {
    return ("not_exit".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
  }
  
  protected boolean a(Pair paramPair)
  {
    if ((!"enable".equals(paramPair.first)) && (!"crashType".equals(paramPair.first)) && (!"crashStack".equals(paramPair.first))) {
      return false;
    }
    return (!"enable".equals(paramPair.first)) || (!TextUtils.isEmpty((CharSequence)paramPair.second));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.e
 * JD-Core Version:    0.7.0.1
 */