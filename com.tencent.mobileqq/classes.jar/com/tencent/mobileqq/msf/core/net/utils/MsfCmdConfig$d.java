package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MsfCmdConfig$d
  extends MsfCmdConfig.a
{
  MsfCmdConfig$d(String paramString, List paramList, boolean paramBoolean)
  {
    super(null);
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean;
  }
  
  protected void a(int paramInt, List paramList)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("not_restart_control_file", 4);
    boolean bool1 = false;
    if (paramInt > ((SharedPreferences)localObject).getInt("key_not_restart_version", 0))
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      localEditor.putInt("key_not_restart_version", paramInt);
      Iterator localIterator = paramList.iterator();
      paramList = null;
      localObject = paramList;
      paramInt = 2147483647;
      int i = 100;
      List localList = paramList;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label290;
        }
        Pair localPair = (Pair)localIterator.next();
        if ("enable".equals(localPair.first))
        {
          bool1 = Boolean.parseBoolean((String)localPair.second);
        }
        else if ("maxCrashNum".equals(localPair.first))
        {
          if (localPair.second == null) {
            paramInt = 2147483647;
          } else {
            paramInt = Integer.parseInt((String)localPair.second);
          }
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
            localList = paramList;
          }
          else if ("crashStack".equals(localPair.first))
          {
            if (localPair.second != null) {
              paramList = (String)localPair.second;
            }
            localObject = paramList;
          }
          else if ("delayMill".equals(localPair.first))
          {
            if (localPair.second == null)
            {
              paramList = localList;
              break;
            }
            i = Integer.parseInt((String)localPair.second);
          }
        }
      }
      label290:
      paramList = new StringBuilder();
      paramList.append("enable=");
      paramList.append(bool1);
      paramList.append(",maxCrashNum=");
      paramList.append(paramInt);
      paramList.append(",crashType=");
      paramList.append(localList);
      paramList.append(",crashStack=");
      paramList.append((String)localObject);
      paramList.append(",delayMill=");
      paramList.append(i);
      QLog.d("MsfCmdConfig", 1, paramList.toString());
      localEditor.putBoolean("key_not_restart_enable", bool1);
      localEditor.putInt("key_not_restart_max_crash", paramInt);
      localEditor.putString("key_not_restart_crash_type", localList);
      localEditor.putString("key_not_restart_crash_stack", (String)localObject);
      localEditor.putInt("key_not_restart_delay_mill", i);
      localEditor.commit();
    }
  }
  
  protected boolean a()
  {
    return ("not_auto_restart".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
  }
  
  protected boolean a(Pair paramPair)
  {
    if ((!"enable".equals(paramPair.first)) && (!"maxCrashNum".equals(paramPair.first)) && (!"crashType".equals(paramPair.first)) && (!"crashStack".equals(paramPair.first)) && (!"delayMill".equals(paramPair.first))) {
      return false;
    }
    return (!"enable".equals(paramPair.first)) || (!TextUtils.isEmpty((CharSequence)paramPair.second));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.d
 * JD-Core Version:    0.7.0.1
 */