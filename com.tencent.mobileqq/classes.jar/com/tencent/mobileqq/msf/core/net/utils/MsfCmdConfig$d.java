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
    Object localObject1 = null;
    boolean bool = false;
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("not_restart_control_file", 4);
    SharedPreferences.Editor localEditor;
    int i;
    int j;
    if (paramInt > ((SharedPreferences)localObject2).getInt("key_not_restart_version", 0))
    {
      localEditor = ((SharedPreferences)localObject2).edit();
      localEditor.putInt("key_not_restart_version", paramInt);
      Iterator localIterator = paramList.iterator();
      paramList = null;
      i = 100;
      paramInt = 2147483647;
      if (localIterator.hasNext())
      {
        localObject2 = (Pair)localIterator.next();
        if ("enable".equals(((Pair)localObject2).first))
        {
          bool = Boolean.parseBoolean((String)((Pair)localObject2).second);
          j = i;
          localObject2 = localObject1;
          i = paramInt;
          paramInt = j;
          localObject1 = paramList;
          paramList = (List)localObject2;
        }
      }
    }
    for (;;)
    {
      j = i;
      localObject2 = localObject1;
      localObject1 = paramList;
      paramList = (List)localObject2;
      i = paramInt;
      paramInt = j;
      break;
      if ("maxCrashNum".equals(((Pair)localObject2).first))
      {
        if (((Pair)localObject2).second == null) {}
        for (paramInt = 2147483647;; paramInt = Integer.parseInt((String)((Pair)localObject2).second))
        {
          j = paramInt;
          localObject2 = paramList;
          paramList = (List)localObject1;
          localObject1 = localObject2;
          paramInt = i;
          i = j;
          break;
        }
      }
      if ("crashType".equals(((Pair)localObject2).first))
      {
        if (((Pair)localObject2).second == null) {}
        for (paramList = "";; paramList = (String)((Pair)localObject2).second)
        {
          j = paramInt;
          localObject2 = paramList;
          paramList = (List)localObject1;
          localObject1 = localObject2;
          paramInt = i;
          i = j;
          break;
        }
      }
      if ("crashStack".equals(((Pair)localObject2).first))
      {
        if (((Pair)localObject2).second == null) {}
        for (localObject1 = "";; localObject1 = (String)((Pair)localObject2).second)
        {
          localObject2 = paramList;
          j = paramInt;
          paramList = (List)localObject1;
          localObject1 = localObject2;
          paramInt = i;
          i = j;
          break;
        }
      }
      if ("delayMill".equals(((Pair)localObject2).first))
      {
        if (((Pair)localObject2).second == null) {}
        for (i = 100;; i = Integer.parseInt((String)((Pair)localObject2).second))
        {
          j = paramInt;
          localObject2 = paramList;
          paramInt = i;
          paramList = (List)localObject1;
          localObject1 = localObject2;
          i = j;
          break;
        }
        QLog.d("MsfCmdConfig", 1, "enable=" + bool + ",maxCrashNum=" + paramInt + ",crashType=" + paramList + ",crashStack=" + (String)localObject1 + ",delayMill=" + i);
        localEditor.putBoolean("key_not_restart_enable", bool);
        localEditor.putInt("key_not_restart_max_crash", paramInt);
        localEditor.putString("key_not_restart_crash_type", paramList);
        localEditor.putString("key_not_restart_crash_stack", (String)localObject1);
        localEditor.putInt("key_not_restart_delay_mill", i);
        localEditor.commit();
        return;
      }
      localObject2 = paramList;
      j = paramInt;
      paramList = (List)localObject1;
      localObject1 = localObject2;
      paramInt = i;
      i = j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.d
 * JD-Core Version:    0.7.0.1
 */