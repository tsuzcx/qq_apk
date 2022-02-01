package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.h;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class t
{
  static t.b a;
  static t.a b;
  
  static
  {
    l.a locala = l.a(WebView.c.b);
    a = (t.b)locala.excute("STR_CMD_GET_UPDATER", null);
    b = (t.a)locala.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
  }
  
  public static void a()
  {
    if (a != null)
    {
      Log.i("WCWebUpdater", "tryEmbedInstall");
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "4");
      a.a(XWalkEnvironment.getApplicationContext(), localHashMap);
      return;
    }
    Log.e("WCWebUpdater", "no sWebviewUpdater");
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    a(paramContext, paramHashMap, true);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      h.M();
      if (a != null)
      {
        Log.i("WCWebUpdater", "start check runtime update");
        a.a(paramContext, paramHashMap);
      }
      else
      {
        Log.e("WCWebUpdater", "no sWebviewUpdater");
      }
      if (paramBoolean)
      {
        if (b != null)
        {
          h.F();
          b.a(paramContext, paramHashMap);
        }
        else
        {
          Log.e("WCWebUpdater", "no sPluginUpdater");
        }
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.t
 * JD-Core Version:    0.7.0.1
 */