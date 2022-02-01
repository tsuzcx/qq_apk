package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildAVPriorityManager
{
  public static void a(String paramString)
  {
    AVBizModuleFactory.getModuleByName(paramString).abandonAVFocus();
    AVBizModuleFactory.removeModuleByName(paramString);
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      paramString = AVBizModuleFactory.getModuleByName(paramString).getFocusBusiness();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramString.containsValue((String)paramList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString, IModule.FocusChangeListener paramFocusChangeListener)
  {
    IModule localIModule = AVBizModuleFactory.getModuleByName(paramString);
    paramString = localIModule.requestAVFocus();
    if (!"true".equals(paramString))
    {
      localIModule.abandonAVFocus();
      AVBizModuleFactory.removeModuleByName("频道通话");
      paramAppRuntime = paramAppRuntime.getApplicationContext();
      int i = paramAppRuntime.getResources().getDimensionPixelSize(2131299920);
      QQToast.makeText(paramAppRuntime, String.format(paramAppRuntime.getString(2131887170), new Object[] { paramString }), 1).show(i);
      return false;
    }
    localIModule.setListener(paramFocusChangeListener);
    return true;
  }
  
  public static boolean b(String paramString)
  {
    HashMap localHashMap = AVBizModuleFactory.getModuleByName(paramString).getFocusBusiness();
    if ((localHashMap != null) && (!localHashMap.isEmpty())) {
      return localHashMap.containsValue(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildAVPriorityManager
 * JD-Core Version:    0.7.0.1
 */