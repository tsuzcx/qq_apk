package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

class MsfCmdConfig$f
  extends MsfCmdConfig.a
{
  MsfCmdConfig$f(String paramString, List paramList, boolean paramBoolean)
  {
    super(null);
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean;
  }
  
  protected void a(int paramInt, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      if ("enable".equals(localPair.first)) {
        BaseApplication.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", Boolean.parseBoolean((String)localPair.second)).commit();
      }
    }
  }
  
  protected boolean a()
  {
    return ("test_flag".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
  }
  
  protected boolean a(Pair paramPair)
  {
    if (!"enable".equals(paramPair.first)) {
      return false;
    }
    return !TextUtils.isEmpty((CharSequence)paramPair.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.f
 * JD-Core Version:    0.7.0.1
 */