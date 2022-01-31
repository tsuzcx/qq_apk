package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
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
    Pair localPair = null;
    boolean bool = false;
    Object localObject = BaseApplication.getContext().getSharedPreferences("pref_safemode_not_exit", 0);
    SharedPreferences.Editor localEditor;
    if (paramInt > ((SharedPreferences)localObject).getInt("key_not_exit_version", 0))
    {
      localEditor = ((SharedPreferences)localObject).edit();
      localEditor.putInt("key_not_exit_version", paramInt);
      Iterator localIterator = paramList.iterator();
      localObject = null;
      paramList = localPair;
      if (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        if ("enable".equals(localPair.first)) {
          bool = Boolean.parseBoolean((String)localPair.second);
        }
      }
    }
    for (;;)
    {
      break;
      if ("crashType".equals(localPair.first))
      {
        if (localPair.second == null) {}
        for (localObject = "";; localObject = (String)localPair.second) {
          break;
        }
      }
      if ("crashStack".equals(localPair.first))
      {
        if (localPair.second == null) {}
        for (paramList = "";; paramList = (String)localPair.second) {
          break;
        }
        localEditor.putBoolean("key_not_exit_enable", bool);
        localEditor.putString("key_not_exit_crash_type", (String)localObject);
        localEditor.putString("key_not_exit_crash_stack", paramList);
        localEditor.commit();
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.d
 * JD-Core Version:    0.7.0.1
 */