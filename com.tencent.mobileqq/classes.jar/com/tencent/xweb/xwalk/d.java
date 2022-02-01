package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.wxa.su.a.a;
import com.tencent.luggage.wxa.su.g;
import com.tencent.luggage.wxa.su.k;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.b;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.v;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class d
  implements com.tencent.xweb.internal.d
{
  ScrollView a = null;
  TextView b = null;
  TextView c = null;
  TextView d = null;
  Button e = null;
  String f = "tools";
  private Context g;
  private com.tencent.xweb.WebView h;
  private String i = "";
  private View j;
  private boolean k = false;
  private final String l = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
  private final String m = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
  private final String n = "当前Light Mode[%d,%d]（点击切换）";
  private final String o = "当前未知Mode[%d,%d]（点击切换）";
  private View.OnClickListener p = new d.40(this);
  
  public d(com.tencent.xweb.WebView paramWebView)
  {
    this.g = paramWebView.getContext();
    this.h = paramWebView;
    j();
    g();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return 3;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == 2) {
        return 1;
      }
      if (paramInt2 == 1) {
        return 2;
      }
      if (paramInt2 == 0) {
        return 1;
      }
    }
    return 4;
  }
  
  static String a(Context paramContext, WebView.c paramc, String paramString)
  {
    XWalkEnvironment.init(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = new StringBuilder();
    paramContext.append("\n   default core type ");
    paramContext.append(paramc);
    localStringBuilder.append(paramContext.toString());
    if (XWalkEnvironment.isIaDevice())
    {
      localStringBuilder.append(", is prefer WV_KIND_SYS because of this is x86 device");
      return localStringBuilder.toString();
    }
    if (com.tencent.xweb.a.b(paramString) != WebView.c.a)
    {
      paramContext = com.tencent.xweb.a.b(paramString);
      paramc = new StringBuilder();
      paramc.append("\n   has command type ");
      paramc.append(paramContext);
      localStringBuilder.append(paramc.toString());
    }
    paramc = WebView.c.b;
    paramContext = new StringBuilder();
    paramContext.append("\n   has compile type ");
    paramContext.append(paramc);
    localStringBuilder.append(paramContext.toString());
    int i1;
    if (v.a().a(paramString, true) != WebView.c.a)
    {
      paramc = v.a().b(paramString);
      paramContext = new StringBuilder();
      paramContext.append("\n   has abtest type ");
      paramContext.append(paramc);
      localStringBuilder.append(paramContext.toString());
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (v.a().a(paramString, false) != WebView.c.a)
    {
      paramc = v.a().b(paramString);
      paramContext = new StringBuilder();
      paramContext.append("\n   has hardcode type ");
      paramContext.append(paramc);
      localStringBuilder.append(paramContext.toString());
      i1 = 1;
    }
    paramContext = paramc;
    if (i1 == 0)
    {
      paramContext = paramc;
      if (paramc == WebView.c.b)
      {
        paramContext = paramc;
        if (XWalkEnvironment.getXWebInitArgs("isgpversion", false))
        {
          paramContext = WebView.c.d;
          paramc = new StringBuilder();
          paramc.append("\n   is prefer ");
          paramc.append(paramContext);
          paramc.append(" because of gp version");
          localStringBuilder.append(paramc.toString());
        }
      }
    }
    paramc = paramContext;
    if (paramContext == WebView.c.b)
    {
      paramc = paramContext;
      if (!XWalkEnvironment.hasAvailableVersion())
      {
        paramc = WebView.c.c;
        paramContext = new StringBuilder();
        paramContext.append("\n   is prefer ");
        paramContext.append(paramc);
        paramContext.append(" because of xwalk is not available");
        localStringBuilder.append(paramContext.toString());
      }
    }
    com.tencent.xweb.internal.h.a(paramc, paramString);
    paramContext = paramc;
    if (com.tencent.xweb.internal.h.a().g())
    {
      paramContext = WebView.c.d;
      paramc = new StringBuilder();
      paramc.append("\n   is prefer ");
      paramc.append(paramContext);
      paramc.append(" because of LoadUrlWatchDog");
      localStringBuilder.append(paramc.toString());
    }
    if (com.tencent.xweb.internal.b.a(paramContext))
    {
      paramc = new StringBuilder();
      paramc.append("\n   will not use ");
      paramc.append(paramContext);
      paramc.append(" because of CrashWatchDog hit");
      localStringBuilder.append(paramc.toString());
    }
    paramc = paramContext;
    if (paramContext == WebView.c.c)
    {
      paramc = paramContext;
      if (!com.tencent.luggage.wxa.st.c.a())
      {
        localStringBuilder.append("\n   x5 sdk is not compiled switch to xweb");
        paramc = WebView.c.b;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("module: ");
    paramContext.append(paramString);
    paramContext.append(" core type is ");
    paramContext.append(paramc);
    localStringBuilder.insert(0, paramContext.toString());
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if ("FullScreenVideo".equals(paramString)) {
      return "xweb_fullscreen_video.js";
    }
    if ("XFilesPPTReader".equals(paramString)) {
      return "xfiles_ppt_reader.zip";
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      if (paramBoolean) {
        return "xfiles_pdf_reader_arm64.zip";
      }
      return "xfiles_pdf_reader_arm.zip";
    }
    if ("XFilesWordReader".equals(paramString))
    {
      if (paramBoolean) {
        return "xfiles_word_reader_arm64.zip";
      }
      return "xfiles_word_reader_arm.zip";
    }
    if ("XFilesExcelReader".equals(paramString)) {
      return "xfiles_excel_reader.zip";
    }
    if ("XFilesOfficeReader".equals(paramString))
    {
      if (paramBoolean) {
        return "xfiles_office_reader_arm64.zip";
      }
      return "xfiles_office_reader_arm.zip";
    }
    return "";
  }
  
  public static void a(Context paramContext)
  {
    Scheduler.c = true;
    k localk = new k();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    localk.a(paramContext, localHashMap);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ValueCallback<Boolean> paramValueCallback)
  {
    com.tencent.luggage.wxa.ss.h localh = new com.tencent.luggage.wxa.ss.h(Environment.getExternalStorageDirectory().getPath());
    if (localh.g() == null)
    {
      Toast.makeText(paramContext, "请确认应用权限，在权限管理打开应用的读写存储权限", 0).show();
      paramValueCallback.onReceiveValue(Boolean.valueOf(false));
      return;
    }
    g localg = com.tencent.luggage.wxa.su.h.a(paramString);
    if (localg == null)
    {
      Toast.makeText(paramContext, "找不到对应插件", 0).show();
      paramValueCallback.onReceiveValue(Boolean.valueOf(false));
      return;
    }
    paramString = a(paramString, paramBoolean2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localh.a());
    localStringBuilder.append("/apkxwebtest/");
    localStringBuilder.append(paramString);
    new d.42(paramContext, localg, paramInt, paramBoolean1, paramString, localStringBuilder.toString(), paramBoolean3, paramValueCallback).execute(new Void[0]);
  }
  
  public static void a(Context paramContext, String paramString, f.a parama, boolean paramBoolean, ValueCallback<Integer> paramValueCallback)
  {
    k localk = new k();
    localk.a(paramString, new d.41(paramContext, paramString, localk, paramBoolean, parama, paramValueCallback));
    paramString = new HashMap();
    paramString.put("UpdaterCheckType", "1");
    localk.a(paramContext, paramString);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, ValueCallback<Boolean> paramValueCallback)
  {
    a(paramContext, paramString, -1, paramBoolean1, paramBoolean2, false, paramValueCallback);
  }
  
  private void a(Button paramButton)
  {
    int i1 = this.h.getSettings().b();
    int i2 = this.h.getSettings().c();
    int i3 = a(i1, i2);
    if (i3 == 1)
    {
      paramButton.setText(String.format("当前Dark Mode强制智能反色[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
      return;
    }
    if (i3 == 2)
    {
      paramButton.setText(String.format("当前Dark Mode不强制智能反色[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
      return;
    }
    if (i3 == 3)
    {
      paramButton.setText(String.format("当前Light Mode[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
      return;
    }
    if (i3 == 4) {
      paramButton.setText(String.format("当前未知Mode[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
    }
  }
  
  public static void a(IWebView paramIWebView)
  {
    if (paramIWebView != null) {
      try
      {
        if (v.a().f())
        {
          b(paramIWebView);
          return;
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString, f.a parama)
  {
    if (v.a() == null) {
      return;
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      localObject = new String[1];
      localObject[0] = paramString;
      paramString = (String)localObject;
    }
    else
    {
      paramString = f.a;
    }
    Object localObject = v.a().a(paramString, parama);
    e.a(paramString);
    if ((this.j != null) && (b() != null) && (!((String)localObject).isEmpty()))
    {
      paramString = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("格式:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("强制使用");
      localStringBuilder.append(parama.name());
      localStringBuilder.append("打开");
      Toast.makeText(paramString, localStringBuilder.toString(), 0).show();
      paramString = (TextView)this.j.findViewById(2131447138);
      if (paramString != null) {
        paramString.setText(m());
      }
    }
  }
  
  private void a(String paramString, f.b paramb)
  {
    if (v.a() == null) {
      return;
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = new String[] { paramString };
    }
    else
    {
      paramString = new String[6];
      paramString[0] = "doc";
      paramString[1] = "docx";
      paramString[2] = "xls";
      paramString[3] = "xlsx";
      paramString[4] = "ppt";
      paramString[5] = "pptx";
    }
    String str = v.a().a(paramString, paramb);
    e.a(paramString);
    if ((this.j != null) && (b() != null) && (!str.isEmpty()))
    {
      paramString = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("格式:");
      localStringBuilder.append(str);
      localStringBuilder.append("强制OfficeReader状态：");
      localStringBuilder.append(paramb.toString());
      Toast.makeText(paramString, localStringBuilder.toString(), 0).show();
      paramString = (TextView)this.j.findViewById(2131447138);
      if (paramString != null) {
        paramString.setText(m());
      }
    }
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.trim();
      int i1 = paramString1.lastIndexOf("ticket");
      if (i1 >= 0)
      {
        if (i1 >= paramString1.length()) {
          return false;
        }
        paramString1 = paramString1.substring(0, i1);
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("@check_permission@");
        localStringBuilder.append(str);
        return com.tencent.xweb.util.b.a(localStringBuilder.toString(), paramString2, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAE4s7oy+BvW5kzf5PwtVqDdZb2rVQS7GDf\naJWwtkD95ILDQAtHM9Nv5apLYQnUbXkjTldOUpjK7MimTkf/qXjQfk8hF2A0Mf7L\nHbDPr7kD9DOuQlG53SWOuKQVEwwsjN1l");
      }
    }
    return false;
  }
  
  protected static void b(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i1 = Process.myPid();
    int i2 = Process.myUid();
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.uid == i2) && (localRunningAppProcessInfo.pid != i1))
      {
        String str = localRunningAppProcessInfo.processName;
        if ((str == null) || (!str.contains("com.tencent.mm")) || (localRunningAppProcessInfo.processName.contains("tools")) || (localRunningAppProcessInfo.processName.contains("appbrand")) || (localRunningAppProcessInfo.processName.contains("support")) || (localRunningAppProcessInfo.processName.contains("sandbox"))) {
          Process.killProcess(localRunningAppProcessInfo.pid);
        }
      }
    }
    Process.killProcess(i1);
  }
  
  private void b(Button paramButton)
  {
    l();
    a(paramButton);
  }
  
  public static void b(IWebView paramIWebView)
  {
    if (paramIWebView != null) {
      try
      {
        if (v.a().f())
        {
          paramIWebView.evaluateJavascript("if (!window.showFPS) {\n    window.showFPS = (function () {\n        var requestAnimationFrame =\n            window.requestAnimationFrame || //Chromium  \n            window.webkitRequestAnimationFrame || //Webkit \n            window.mozRequestAnimationFrame || //Mozilla Geko \n            window.oRequestAnimationFrame || //Opera Presto \n            window.msRequestAnimationFrame || //IE Trident? \n            function (callback) { //Fallback function \n                window.setTimeout(callback, 1000 / 60);\n            };\n        var e, pe, pid, fps, last, offset, step, appendFps, curSeconds;\n        fps = 0;\n        curSeconds = 0;\n        last = Date.now();\n        step = function () {\n            offset = Date.now() - last;\n            fps += 1;\n            if (offset >= 1000) {\n                last += offset;\n                if (curSeconds % 3 == 0) {\n                    addFpsElement();\n                }\n                ++curSeconds;\n                appendFps(fps);\n                fps = 0;\n            }\n            requestAnimationFrame(step);\n        };\n\n        addFpsElement = function () {\n                var fpsview = document.getElementById(\"fpsview\");\n                if (!fpsview) {\n                    var div = document.createElement('div');\n                    div.innerHTML = \"<div style=\\\"z-index: 9999; position: fixed ! important; right: 50px; top: 10px; font-size:36px\\\" id=\\\"fpsview\\\"> </div>\";\n                    document.body.appendChild(div);\n                }\n            }\n            //显示fps;\n        appendFps = function (fps) {\n            if (!e) e = document.createElement('span');\n            e.innerHTML = \"fps: \" + fps;\n            if (!pe) {\n                pe = document.getElementById(\"fpsview\");\n                if (pe) pe.appendChild(e);\n            }\n        };\n        return {\n            go: function () {\n                step();\n            }\n        }\n    })();\n\n    console.log(\"show fps start\");\n    window.showFPS.go();\n\n}", new d.50());
          return;
        }
      }
      finally {}
    }
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if ((paramString.contains("debugxweb.qq.com")) || (paramString.contains("debugmm.qq.com")) || (paramString.contains("public.debugxweb.qq.com"))) {
      bool = true;
    }
    if (bool)
    {
      com.tencent.xweb.util.h.a(223L, 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("this url contians debug piece, url =  ");
      localStringBuilder.append(paramString);
      Log.e("WebDebugPage", localStringBuilder.toString());
    }
    return bool;
  }
  
  private void c(String paramString)
  {
    if (v.a() == null) {
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      paramString = new String[2];
      paramString[0] = "ppt";
      paramString[1] = "pptx";
    }
    else if ("XFilesPDFReader".equals(paramString))
    {
      paramString = new String[1];
      paramString[0] = "pdf";
    }
    else if ("XFilesWordReader".equals(paramString))
    {
      paramString = new String[2];
      paramString[0] = "doc";
      paramString[1] = "docx";
    }
    else if ("XFilesExcelReader".equals(paramString))
    {
      paramString = new String[2];
      paramString[0] = "xls";
      paramString[1] = "xlsx";
    }
    else
    {
      if (!"XFilesOfficeReader".equals(paramString)) {
        return;
      }
      paramString = new String[6];
      paramString[0] = "doc";
      paramString[1] = "docx";
      paramString[2] = "xls";
      paramString[3] = "xlsx";
      paramString[4] = "ppt";
      paramString[5] = "pptx";
    }
    String str = v.a().a(paramString, f.a.b);
    e.a(paramString);
    if ((this.j != null) && (b() != null) && (!str.isEmpty()))
    {
      paramString = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("格式:");
      localStringBuilder.append(str);
      localStringBuilder.append("强制使用");
      localStringBuilder.append(f.a.b.name());
      localStringBuilder.append("打开");
      Toast.makeText(paramString, localStringBuilder.toString(), 0).show();
      paramString = (TextView)this.j.findViewById(2131447138);
      if (paramString != null) {
        paramString.setText(m());
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.c == null) {
      return;
    }
    String str = a(paramBoolean);
    this.c.setText(str);
  }
  
  private boolean c(String paramString, boolean paramBoolean)
  {
    if ((!paramString.contains("debugxweb.qq.com")) && (!paramBoolean)) {
      return false;
    }
    Uri localUri = Uri.parse(paramString);
    paramString = localUri.getQueryParameterNames();
    if ((paramString != null) && (paramString.size() != 0))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        paramString = (String)localIterator.next();
        int i1;
        if (paramString != null)
        {
          switch (paramString.hashCode())
          {
          default: 
            break;
          case 1112413629: 
            if (paramString.equals("set_force_use_office_reader")) {
              i1 = 10;
            }
            break;
          case 1098980480: 
            if (paramString.equals("check_files")) {
              i1 = 5;
            }
            break;
          case 603805332: 
            if (paramString.equals("load_local_xwalk")) {
              i1 = 0;
            }
            break;
          case 368659514: 
            if (paramString.equals("clear_commands")) {
              i1 = 1;
            }
            break;
          case 208243139: 
            if (paramString.equals("recheck_cmds")) {
              i1 = 8;
            }
            break;
          case -83404669: 
            if (paramString.equals("debug_process")) {
              i1 = 3;
            }
            break;
          case -939528941: 
            if (paramString.equals("revert_to_apk")) {
              i1 = 6;
            }
            break;
          case -1004318384: 
            if (paramString.equals("set_force_filereader")) {
              i1 = 9;
            }
            break;
          case -1302829141: 
            if (paramString.equals("wait_debugger")) {
              i1 = 2;
            }
            break;
          case -1479708147: 
            if (paramString.equals("set_config_peroid")) {
              i1 = 7;
            }
            break;
          case -1534940989: 
            if (paramString.equals("clear_all_plugin")) {
              i1 = 11;
            }
            break;
          case -1688684924: 
            if (paramString.equals("set_apkver")) {
              i1 = 4;
            }
            break;
          }
          i1 = -1;
          paramString = "";
          switch (i1)
          {
          default: 
            break;
          case 11: 
            n();
            break;
          }
        }
        try
        {
          localObject1 = localUri.getQueryParameter("set_force_filereader");
          paramString = (String)localObject1;
        }
        catch (Exception localException1)
        {
          Object localObject1;
          label471:
          Object localObject2;
          break label471;
        }
        localObject2 = paramString.split("_");
        if (paramString.length() < 2)
        {
          b("强制设置OfficeReader失败，参数错误", true);
        }
        else
        {
          paramString = localObject2[(localObject2.length - 1)];
          if ("yes".equalsIgnoreCase(paramString))
          {
            paramString = f.b.b;
          }
          else if ("no".equalsIgnoreCase(paramString))
          {
            paramString = f.b.c;
          }
          else
          {
            if (!"none".equalsIgnoreCase(paramString)) {
              break label752;
            }
            paramString = f.b.a;
          }
          if ((localObject2.length == 2) && ("all".equalsIgnoreCase(localObject2[0])))
          {
            localObject1 = new String[6];
            localObject1[0] = "doc";
            localObject1[1] = "docx";
            localObject1[2] = "xls";
            localObject1[3] = "xlsx";
            localObject1[4] = "ppt";
            localObject1[5] = "pptx";
          }
          else
          {
            localObject1 = new String[localObject2.length - 1];
            i1 = 0;
            while (i1 < localObject2.length - 1)
            {
              localObject1[i1] = localObject2[i1];
              i1 += 1;
            }
          }
          localObject1 = v.a().a((String[])localObject1, paramString);
          if (!((String)localObject1).isEmpty())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("格式:");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("强制OfficeReader状态：");
            ((StringBuilder)localObject2).append(paramString.toString());
            b(((StringBuilder)localObject2).toString(), true);
          }
          else
          {
            b("强制设置OfficeReader失败", true);
            continue;
            label752:
            b("强制设置OfficeReader失败，类型错误", true);
          }
        }
        try
        {
          localObject1 = localUri.getQueryParameter("set_force_filereader");
          paramString = (String)localObject1;
        }
        catch (Exception localException2)
        {
          label776:
          label1022:
          break label776;
        }
        localObject2 = paramString.split("_");
        if (paramString.length() < 2)
        {
          b("强制设置文件预览方式失败，参数错误", true);
        }
        else
        {
          paramString = localObject2[(localObject2.length - 1)];
          if ("xweb".equalsIgnoreCase(paramString))
          {
            paramString = f.a.b;
          }
          else if ("x5".equalsIgnoreCase(paramString))
          {
            paramString = f.a.c;
          }
          else
          {
            if (!"none".equalsIgnoreCase(paramString)) {
              break label1022;
            }
            paramString = f.a.a;
          }
          if ((localObject2.length == 2) && ("all".equalsIgnoreCase(localObject2[0])))
          {
            localObject1 = f.a;
          }
          else
          {
            localObject1 = new String[localObject2.length - 1];
            i1 = 0;
            while (i1 < localObject2.length - 1)
            {
              localObject1[i1] = localObject2[i1];
              i1 += 1;
            }
          }
          localObject1 = v.a().a((String[])localObject1, paramString);
          if (!((String)localObject1).isEmpty())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("格式:");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("强制使用");
            ((StringBuilder)localObject2).append(paramString.name());
            ((StringBuilder)localObject2).append("打开");
            b(((StringBuilder)localObject2).toString(), true);
          }
          else
          {
            b("强制设置文件预览方式失败", true);
            continue;
            b("强制设置文件预览方式失败，类型错误", true);
            continue;
            l.a(WebView.c.b).excute("STR_CMD_SET_RECHECK_COMMAND", null);
            a("重新跑了一遍命令配置 点击空白处退出重启进程", true, true);
            continue;
            paramString = localUri.getQueryParameter("set_config_peroid");
            try
            {
              com.tencent.xweb.a.a(Integer.parseInt(paramString));
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("设置配置拉取周期为:");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append("分钟");
              a(((StringBuilder)localObject1).toString(), true, false);
            }
            catch (Exception paramString)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("设置配置拉取周期失败:");
              ((StringBuilder)localObject1).append(paramString.getMessage());
              b(((StringBuilder)localObject1).toString(), true);
            }
            continue;
            paramString = localUri.getQueryParameter("revert_to_apk");
            try
            {
              i1 = p.a(XWalkEnvironment.getApplicationContext(), Integer.parseInt(paramString));
              paramString = new StringBuilder();
              paramString.append("版本号回滚到:");
              paramString.append(i1);
              paramString.append(" 点击空白处退出重启进程");
              a(paramString.toString(), true, true);
            }
            catch (Exception paramString)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("版本号回滚到失败:");
              ((StringBuilder)localObject1).append(paramString.getMessage());
              b(((StringBuilder)localObject1).toString(), true);
            }
            continue;
            p.a(true);
            continue;
            paramString = localUri.getQueryParameter("set_apkver");
            try
            {
              i1 = Integer.parseInt(paramString);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("1.0.");
              ((StringBuilder)localObject1).append(paramString);
              XWalkEnvironment.setAvailableVersion(i1, ((StringBuilder)localObject1).toString(), XWalkEnvironment.getRuntimeAbi());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("版本号设置到:");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" 点击空白处退出重启进程");
              a(((StringBuilder)localObject1).toString(), true, true);
            }
            catch (Exception paramString)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("设置版本号失败:");
              ((StringBuilder)localObject1).append(paramString.getMessage());
              b(((StringBuilder)localObject1).toString(), true);
            }
            continue;
            paramString = localUri.getQueryParameter("debug_process");
            v.a().a(paramString);
            continue;
            paramBoolean = localUri.getBooleanQueryParameter("wait_debugger", false);
            v.a().a(paramBoolean);
            continue;
            com.tencent.xweb.a.a(null, "0");
            continue;
            b(false);
          }
        }
      }
      return true;
    }
    else
    {
      k();
      return true;
    }
  }
  
  private void d(String paramString)
  {
    com.tencent.luggage.wxa.ss.h localh = new com.tencent.luggage.wxa.ss.h(paramString);
    if (localh.b())
    {
      String[] arrayOfString = localh.f();
      if (arrayOfString != null)
      {
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("//");
          localStringBuilder.append(arrayOfString[i1]);
          d(localStringBuilder.toString());
          i1 += 1;
        }
      }
    }
    localh.e();
  }
  
  private void g()
  {
    if (!v.a().h()) {
      return;
    }
    if (this.e != null) {
      return;
    }
    this.e = new Button(b());
    this.e.setText("保存页面");
    this.e.setOnClickListener(new d.1(this));
    this.h.getTopView().addView(this.e);
  }
  
  private void h()
  {
    if (this.d != null) {
      return;
    }
    ScrollView localScrollView = new ScrollView(b());
    this.d = new TextView(b());
    this.d.setTextColor(-16777216);
    this.d.setBackgroundColor(-1);
    localScrollView.addView(this.d);
    this.d.setOnClickListener(new d.12(this));
    i();
    this.h.getTopView().addView(localScrollView);
  }
  
  private void i()
  {
    if (this.d == null) {
      return;
    }
    Object localObject4 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("\n\n");
    ((StringBuilder)localObject1).append(this.h.getAbstractInfo());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.c.b)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("\n xwebsdk is = 201201 apk ver is ");
      ((StringBuilder)localObject1).append(XWalkEnvironment.getAvailableVersion());
      ((StringBuilder)localObject1).append(" des ");
      ((StringBuilder)localObject1).append(XWalkEnvironment.getAvailableVersionDetail());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    int i1;
    if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {
      i1 = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;
    } else {
      i1 = 0;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("\n\n current js engine: =  ");
    ((StringBuilder)localObject2).append(JsRuntime.a());
    ((StringBuilder)localObject2).append("\n prefered js engine =  ");
    ((StringBuilder)localObject2).append(JsRuntime.a(JsRuntime.JsRuntimeType.a, "appbrand", b()));
    ((StringBuilder)localObject2).append("\n user id(uin) = ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getUserId());
    ((StringBuilder)localObject2).append("\n local gray value = ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getGrayValue());
    ((StringBuilder)localObject2).append("\n local gray device rd value = ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getDeviceRd());
    ((StringBuilder)localObject2).append("\n today gray value = ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getTodayGrayValue());
    ((StringBuilder)localObject2).append("\n config url = ");
    ((StringBuilder)localObject2).append((String)localObject4);
    ((StringBuilder)localObject2).append("\n config period(minutes) = ");
    ((StringBuilder)localObject2).append(Scheduler.p() / 60000L);
    ((StringBuilder)localObject2).append("\n\n apilevel = ");
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject2).append("\n apilevel = ");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append("\n sys webversion = ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.safeGetChromiunVersion());
    ((StringBuilder)localObject2).append("\n device is  ");
    ((StringBuilder)localObject2).append(Build.BRAND);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(Build.MODEL);
    ((StringBuilder)localObject2).append("\n usertype is ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getUserType());
    ((StringBuilder)localObject2).append("\n runtime abi is ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getRuntimeAbi());
    ((StringBuilder)localObject2).append("\n device abi is ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getDeviceAbi());
    ((StringBuilder)localObject2).append("\n installed ver for arm32 is ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a"));
    ((StringBuilder)localObject2).append("\n installed ver for arm64 is ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.getInstalledNewstVersion("arm64-v8a"));
    ((StringBuilder)localObject2).append("\n should embed =  ");
    ((StringBuilder)localObject2).append(false);
    ((StringBuilder)localObject2).append("\n embed lib md5 match =  ");
    ((StringBuilder)localObject2).append(true);
    ((StringBuilder)localObject2).append("\n embed config ver =  ");
    ((StringBuilder)localObject2).append(0);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(0);
    ((StringBuilder)localObject2).append("\n embed try installed ver =  ");
    ((StringBuilder)localObject2).append(XWalkUpdater.getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi()));
    ((StringBuilder)localObject2).append("\n current useragent: ");
    ((StringBuilder)localObject2).append(this.h.getSettings().a());
    ((StringBuilder)localObject2).append("\n current clientversion: 0x");
    ((StringBuilder)localObject2).append(Integer.toHexString(XWalkEnvironment.getAppClientVersion()));
    ((StringBuilder)localObject2).append("\n current app infos dump : ");
    ((StringBuilder)localObject2).append(XWalkEnvironment.dumpAppInfo());
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("\n\n ------dump module prefer webview core start:------\n");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    try
    {
      localObject4 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append(a(this.g, WebView.c.c, "tools"));
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append("\n");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject1 = localObject2;
      localObject4 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append(a(this.g, WebView.c.b, "toolsmp"));
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append("\n");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject1 = localObject2;
      localObject4 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append(a(this.g, WebView.c.a, "mm"));
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append("\n");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject1 = localObject2;
      localObject4 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append(a(this.g, WebView.c.b, "appbrand"));
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append("\n");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject1 = localObject2;
      localObject4 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append(a(this.g, WebView.c.b, "support"));
      localObject1 = localObject2;
      ((StringBuilder)localObject4).append("\n");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(localException1.getMessage());
      ((StringBuilder)localObject4).append("\n");
      localObject1 = ((StringBuilder)localObject4).toString();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("------dump module prefer webview core end------");
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("\n");
    ((StringBuilder)localObject3).append(XWebCoreScheduler.z().f());
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("\n");
    ((StringBuilder)localObject3).append(com.tencent.xweb.xwalk.updater.i.y().f());
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = com.tencent.luggage.wxa.su.h.b().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (g)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        localObject4 = com.tencent.luggage.wxa.su.a.a(((g)localObject4).a());
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append("\n");
        ((StringBuilder)localObject5).append(((Scheduler)localObject4).f());
        localObject1 = ((StringBuilder)localObject5).toString();
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("\n current update match gap backward(update speed) is ");
    ((StringBuilder)localObject3).append(Scheduler.a(Scheduler.b(false).d(false)));
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("\n current update match gap forward(提前更新) is ");
    ((StringBuilder)localObject3).append(Scheduler.a(Scheduler.b(false).d(true)));
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append("\n plugin current update match gap backward(update speed) is ");
    localObject4 = "";
    ((StringBuilder)localObject1).append(Scheduler.a(new a.a("").d(false)));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("\n plugin current update match gap forward(提前更新) is ");
    ((StringBuilder)localObject3).append(Scheduler.a(new a.a("").d(true)));
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject5 = com.tencent.xweb.a.g();
    localObject1 = localObject3;
    if (localObject5 != null)
    {
      localObject1 = localObject3;
      if (!((String)localObject5).isEmpty())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append("\n\n ------dump commands start:------\n");
        ((StringBuilder)localObject1).append((String)localObject5);
        ((StringBuilder)localObject1).append("\n ------dump commands end------");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("\n\n ------plugin info start:------");
    ((StringBuilder)localObject3).append("\n plugin config url = ");
    ((StringBuilder)localObject3).append(XWalkEnvironment.getPluginConfigUrl());
    ((StringBuilder)localObject3).append("\n plugin config period(minutes) = ");
    ((StringBuilder)localObject3).append(XWalkEnvironment.getPluginUpdatePeriod() / 60000);
    ((StringBuilder)localObject3).append("\n\n plugin version:");
    localObject5 = com.tencent.luggage.wxa.su.h.b().iterator();
    Object localObject6;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (g)((Iterator)localObject5).next();
      if (localObject6 != null)
      {
        ((StringBuilder)localObject3).append("\n ");
        ((StringBuilder)localObject3).append(((g)localObject6).a());
        ((StringBuilder)localObject3).append(" = ");
        ((StringBuilder)localObject3).append(((g)localObject6).a(true));
      }
    }
    ((StringBuilder)localObject3).append("\n\n plugin commands:");
    localObject5 = com.tencent.xweb.b.n();
    if ((localObject5 != null) && (!((String)localObject5).isEmpty()))
    {
      ((StringBuilder)localObject3).append("\n");
      ((StringBuilder)localObject3).append((String)localObject5);
    }
    else
    {
      ((StringBuilder)localObject3).append("\n null\n");
    }
    ((StringBuilder)localObject3).append("\n xfiles setting:");
    if (v.a() != null)
    {
      ((StringBuilder)localObject3).append("\n disable cache = ");
      ((StringBuilder)localObject3).append(v.a().j());
      ((StringBuilder)localObject3).append("\n disable crash detect = ");
      ((StringBuilder)localObject3).append(v.a().k());
    }
    ((StringBuilder)localObject3).append(m());
    ((StringBuilder)localObject3).append("\n\n ------plugin info end:------");
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append(((StringBuilder)localObject3).toString());
    localObject5 = ((StringBuilder)localObject5).toString();
    localObject1 = localObject4;
    try
    {
      localObject6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      localObject3 = localObject4;
      localObject1 = localObject4;
      if (Scheduler.b(false).h())
      {
        localObject1 = localObject4;
        localObject7 = ((SimpleDateFormat)localObject6).format(new Date(Scheduler.b(false).r().k));
        localObject1 = localObject4;
        localObject3 = new StringBuilder();
        localObject1 = localObject4;
        ((StringBuilder)localObject3).append("");
        localObject1 = localObject4;
        ((StringBuilder)localObject3).append("going to update to apk ver = ");
        localObject1 = localObject4;
        ((StringBuilder)localObject3).append(Scheduler.b(false).r().l);
        localObject1 = localObject4;
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n update time is = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject7);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n is patch update = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().f);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n can use cellular = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().q);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n updateHourStart = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().v);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n updateHourEnd = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().w);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n versionId = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().u);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n update time is = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject7);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n try count = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().o);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n try use shared core count = ");
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(Scheduler.b(false).r().p);
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append("\n");
        localObject1 = localObject3;
        localObject3 = ((StringBuilder)localObject4).toString();
      }
      localObject1 = localObject3;
      localObject4 = new Date(Scheduler.b(false).r().b);
      localObject1 = localObject3;
      Object localObject7 = new StringBuilder();
      localObject1 = localObject3;
      ((StringBuilder)localObject7).append((String)localObject3);
      localObject1 = localObject3;
      ((StringBuilder)localObject7).append(" last fetch config time = ");
      localObject1 = localObject3;
      ((StringBuilder)localObject7).append(((SimpleDateFormat)localObject6).format((Date)localObject4));
      localObject1 = localObject3;
      localObject3 = ((StringBuilder)localObject7).toString();
      localObject1 = localObject3;
      localObject4 = new StringBuilder();
      localObject1 = localObject3;
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject1 = localObject3;
      ((StringBuilder)localObject4).append(" last fetch config abi = ");
      localObject1 = localObject3;
      ((StringBuilder)localObject4).append(Scheduler.b(false).r().c);
      localObject1 = localObject3;
      localObject3 = ((StringBuilder)localObject4).toString();
    }
    catch (Exception localException2)
    {
      label2488:
      break label2488;
    }
    localObject3 = localObject1;
    localObject1 = localObject5;
    if (localObject3 != null)
    {
      localObject1 = localObject5;
      if (!((String)localObject3).isEmpty())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject5);
        ((StringBuilder)localObject1).append("\n\n ------dump schedule updateInfo start:------\n");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append("\n ------dump schedule updateInfo end------");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject4 = XWalkEnvironment.getXWalkInitializeLog();
    localObject3 = localObject1;
    if (localObject4 != null)
    {
      localObject3 = localObject1;
      if (!((String)localObject4).isEmpty())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("\n\n ------dump xweb log------\n");
        ((StringBuilder)localObject3).append((String)localObject4);
        localObject3 = ((StringBuilder)localObject3).toString();
      }
    }
    this.d.setText((CharSequence)localObject3);
  }
  
  private void j()
  {
    if ((!v.a().g()) && ((!v.a().i()) || (this.h.getWebCoreType() != WebView.c.c))) {
      return;
    }
    if (this.c != null) {
      return;
    }
    this.c = new TextView(b());
    this.c.setOnLongClickListener(new d.23(this));
    c(false);
    this.h.getTopView().addView(this.c);
  }
  
  private boolean k()
  {
    b(this.h);
    Object localObject1 = this.j;
    if (localObject1 != null)
    {
      ((View)localObject1).setVisibility(0);
      return true;
    }
    this.j = ((LayoutInflater)b().getSystemService("layout_inflater")).inflate(2131624676, this.h.getTopView(), true).findViewById(2131449843);
    ((Button)this.j.findViewById(2131430146)).setOnClickListener(new d.34(this));
    localObject1 = (CheckBox)this.j.findViewById(2131430701);
    ((CheckBox)localObject1).setChecked(v.a().g());
    ((CheckBox)localObject1).setOnCheckedChangeListener(new d.45(this));
    ((TextView)this.j.findViewById(2131430683)).setOnClickListener(new d.52(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.j.findViewById(2131448967);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).setText(((StringBuilder)localObject2).toString());
      ((EditText)localObject1).addTextChangedListener(new d.53(this, (EditText)localObject1));
    }
    ((Spinner)this.j.findViewById(2131445563)).setOnItemSelectedListener(new d.54(this));
    ((RadioGroup)this.j.findViewById(2131450082)).setOnCheckedChangeListener(new d.55(this));
    int i1 = d.51.b[v.a().l().ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 == 5) {
              ((RadioButton)this.j.findViewById(2131449292)).setChecked(true);
            }
          }
          else {
            ((RadioButton)this.j.findViewById(2131449293)).setChecked(true);
          }
        }
        else {
          ((RadioButton)this.j.findViewById(2131449296)).setChecked(true);
        }
      }
      else {
        ((RadioButton)this.j.findViewById(2131449295)).setChecked(true);
      }
    }
    else {
      ((RadioButton)this.j.findViewById(2131449291)).setChecked(true);
    }
    ((RadioGroup)this.j.findViewById(2131449294)).setOnCheckedChangeListener(new d.2(this));
    ((Button)this.j.findViewById(2131430164)).setOnClickListener(new d.3(this));
    localObject1 = (Button)this.j.findViewById(2131429854);
    a(v.a().e(), (Button)localObject1, false);
    ((Button)localObject1).setOnClickListener(new d.4(this, (Button)localObject1));
    ((Button)this.j.findViewById(2131430140)).setOnClickListener(new d.5(this));
    ((Button)this.j.findViewById(2131430180)).setOnClickListener(new d.6(this));
    ((Button)this.j.findViewById(2131430170)).setOnClickListener(new d.7(this));
    localObject1 = (Button)this.j.findViewById(2131430149);
    if ((this.h.isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportForceDarkMode())) {
      ((Button)localObject1).setVisibility(0);
    } else {
      ((Button)localObject1).setVisibility(8);
    }
    a((Button)localObject1);
    ((Button)localObject1).setOnClickListener(new d.8(this, (Button)localObject1));
    Button localButton = (Button)this.j.findViewById(2131430147);
    localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("(当前为");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    String str = ((StringBuilder)localObject2).toString();
    if (v.a().m())
    {
      localObject1 = new StringBuilder();
      localObject2 = "使用正式版config";
    }
    else
    {
      localObject1 = new StringBuilder();
      localObject2 = "使用测试config";
    }
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(str);
    localButton.setText(((StringBuilder)localObject1).toString());
    localButton.setOnClickListener(new d.9(this, localButton));
    ((Button)this.j.findViewById(2131430193)).setOnClickListener(new d.10(this));
    localObject1 = (LinearLayout)this.j.findViewById(2131440437);
    ((LinearLayout)localObject1).setVisibility(8);
    localObject2 = (Button)this.j.findViewById(2131430177);
    ((Button)localObject2).setText("插件设置");
    ((Button)localObject2).setOnClickListener(new d.11(this, (LinearLayout)localObject1));
    localObject1 = (Button)this.j.findViewById(2131430176);
    localObject2 = XWalkEnvironment.getPluginTestConfigUrl();
    if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
    {
      if (((String)localObject2).equalsIgnoreCase("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
        ((Button)localObject1).setText("切换插件配置，当前使用默认测试版");
      } else {
        ((Button)localObject1).setText("切换插件配置, 当前使用自定义测试版");
      }
    }
    else {
      ((Button)localObject1).setText("切换插件配置，当前使用正式版");
    }
    ((Button)localObject1).setOnClickListener(new d.13(this, (Button)localObject1));
    ((Button)this.j.findViewById(2131430194)).setOnClickListener(new d.14(this));
    ((Button)this.j.findViewById(2131430141)).setOnClickListener(new d.15(this));
    ((Spinner)this.j.findViewById(2131446242)).setOnItemSelectedListener(new d.16(this));
    ((Button)this.j.findViewById(2131430172)).setOnClickListener(new d.17(this));
    ((Button)this.j.findViewById(2131430173)).setOnClickListener(new d.18(this));
    ((Button)this.j.findViewById(2131430195)).setOnClickListener(new d.19(this));
    ((Button)this.j.findViewById(2131430144)).setOnClickListener(new d.20(this));
    localObject1 = (CheckBox)this.j.findViewById(2131430699);
    ((CheckBox)localObject1).setChecked(v.a().j());
    ((CheckBox)localObject1).setOnCheckedChangeListener(new d.21(this));
    localObject1 = (CheckBox)this.j.findViewById(2131430700);
    ((CheckBox)localObject1).setChecked(v.a().k());
    ((CheckBox)localObject1).setOnCheckedChangeListener(new d.22(this));
    ((TextView)this.j.findViewById(2131447138)).setText(m());
    localObject1 = (EditText)this.j.findViewById(2131432353);
    ((Button)this.j.findViewById(2131430158)).setOnClickListener(new d.24(this, (EditText)localObject1));
    ((Button)this.j.findViewById(2131430157)).setOnClickListener(new d.25(this, (EditText)localObject1));
    ((Button)this.j.findViewById(2131430156)).setOnClickListener(new d.26(this, (EditText)localObject1));
    localObject1 = (EditText)this.j.findViewById(2131432355);
    ((Button)this.j.findViewById(2131430198)).setOnClickListener(new d.27(this, (EditText)localObject1));
    ((Button)this.j.findViewById(2131430196)).setOnClickListener(new d.28(this, (EditText)localObject1));
    ((Button)this.j.findViewById(2131430197)).setOnClickListener(new d.29(this, (EditText)localObject1));
    localObject1 = (TextView)this.j.findViewById(2131448908);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a(true));
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append(XWalkInitializer.getXWalkInitializeLog());
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    ((LinearLayout)this.j.findViewById(2131431214)).setVisibility(8);
    ((Button)this.j.findViewById(2131430139)).setOnClickListener(new d.30(this));
    ((Button)this.j.findViewById(2131430138)).setOnClickListener(new d.31(this));
    ((Button)this.j.findViewById(2131430137)).setOnClickListener(new d.32(this));
    ((Button)this.j.findViewById(2131430136)).setOnClickListener(new d.33(this));
    ((Button)this.j.findViewById(2131430130)).setOnClickListener(new d.35(this));
    ((Button)this.j.findViewById(2131430185)).setOnClickListener(new d.36(this));
    localObject1 = (Button)this.j.findViewById(2131430171);
    ((Button)localObject1).setOnClickListener(new d.37(this));
    ((Button)this.j.findViewById(2131430187)).setOnClickListener(new d.38(this));
    ((Button)localObject1).setOnLongClickListener(new d.39(this));
    ((Button)this.j.findViewById(2131430174)).setOnClickListener(this.p);
    return true;
  }
  
  private void l()
  {
    int i1 = this.h.getSettings().b();
    int i2 = this.h.getSettings().c();
    if (i1 == 0)
    {
      this.h.getSettings().d(2);
      this.h.getSettings().e(2);
      return;
    }
    if (i1 == 2)
    {
      if (i2 == 2)
      {
        this.h.getSettings().e(1);
        return;
      }
      if (i2 == 1)
      {
        this.h.getSettings().d(0);
        return;
      }
      if (i2 == 0)
      {
        this.h.getSettings().d(0);
        return;
      }
    }
    this.h.getSettings().d(2);
    this.h.getSettings().e(2);
  }
  
  private String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = f.a;
    int i3 = arrayOfString.length;
    int i2 = 0;
    int i1 = 0;
    String str;
    while (i1 < i3)
    {
      str = arrayOfString[i1];
      localStringBuilder.append("\n ");
      localStringBuilder.append(str);
      localStringBuilder.append(": force-");
      localStringBuilder.append(v.a().c(str));
      localStringBuilder.append("  cmd-tools-");
      localStringBuilder.append(com.tencent.xweb.b.e(str, "tools"));
      localStringBuilder.append("  cmd-appbrand-");
      localStringBuilder.append(com.tencent.xweb.b.e(str, "appbrand"));
      i1 += 1;
    }
    localStringBuilder.append("\n\n use office reader:");
    arrayOfString = f.a;
    i3 = arrayOfString.length;
    i1 = i2;
    while (i1 < i3)
    {
      str = arrayOfString[i1];
      if (!"pdf".equals(str))
      {
        localStringBuilder.append("\n ");
        localStringBuilder.append(str);
        localStringBuilder.append(": force-");
        localStringBuilder.append(v.a().d(str));
        localStringBuilder.append("  cmd-tools-");
        localStringBuilder.append(com.tencent.xweb.b.d(str, "tools"));
        localStringBuilder.append("  cmd-appbrand-");
        localStringBuilder.append(com.tencent.xweb.b.d(str, "appbrand"));
        localStringBuilder.append("  cmd-mm-");
        localStringBuilder.append(com.tencent.xweb.b.d(str, "mm"));
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void n()
  {
    Object localObject = com.tencent.luggage.wxa.su.h.b();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((g)((Iterator)localObject).next()).b(-1, true);
    }
    localObject = XWalkEnvironment.getPluginBaseDir();
    if (((String)localObject).isEmpty()) {
      return;
    }
    com.tencent.xweb.util.c.b((String)localObject);
    b("所有插件清理完成", true);
  }
  
  private void o()
  {
    Object localObject1 = new Date();
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
    Object localObject3 = Environment.getExternalStorageDirectory().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append("/xweb_dump/");
    localStringBuilder.append(((SimpleDateFormat)localObject2).format((Date)localObject1));
    localObject1 = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("/main.html");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("/resource");
    localObject3 = ((StringBuilder)localObject3).toString();
    this.h.savePage((String)localObject2, (String)localObject3, 1);
    new Thread(new d.49(this, (String)localObject1)).start();
  }
  
  String a(boolean paramBoolean)
  {
    String str = this.h.getVersionInfo();
    Object localObject;
    if (!paramBoolean)
    {
      int i1 = str.indexOf(",apkversion");
      localObject = str;
      if (i1 > 0) {
        return str.substring(0, i1);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(com.tencent.luggage.wxa.su.h.c());
      ((StringBuilder)localObject).append(" current process is ");
      ((StringBuilder)localObject).append(XWalkEnvironment.getProcessName());
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public void a()
  {
    if (!v.a().e()) {
      return;
    }
    a(true, null, false);
  }
  
  void a(WebView.c paramc)
  {
    int i1 = d.51.a[paramc.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return;
          }
          ((RadioButton)this.j.findViewById(2131427363)).setChecked(true);
          return;
        }
        ((RadioButton)this.j.findViewById(2131427364)).setChecked(true);
        return;
      }
      ((RadioButton)this.j.findViewById(2131427365)).setChecked(true);
      return;
    }
    ((RadioButton)this.j.findViewById(2131427366)).setChecked(true);
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new d.b(paramString1, paramString2);
    try
    {
      Object localObject2 = new com.tencent.luggage.wxa.ss.h(XWalkEnvironment.getDownloadZipDir(((d.b)localObject1).apkVer));
      if (((com.tencent.luggage.wxa.ss.h)localObject2).d()) {
        ((com.tencent.luggage.wxa.ss.h)localObject2).e();
      }
      paramString1 = com.tencent.luggage.wxa.ss.i.b(paramString1);
      localObject2 = com.tencent.luggage.wxa.ss.i.c(((com.tencent.luggage.wxa.ss.h)localObject2).i());
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        i1 = paramString1.read(arrayOfByte);
        if (i1 == -1) {
          break;
        }
        ((OutputStream)localObject2).write(arrayOfByte, 0, i1);
      }
      ((OutputStream)localObject2).flush();
      paramString1.close();
      ((OutputStream)localObject2).close();
    }
    catch (Exception paramString1)
    {
      break label226;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString1 = XWalkUpdater.onHandleFile((XWalkUpdater.UpdateConfig)localObject1);
    int i1 = paramString1.intValue();
    if (i1 == 0)
    {
      paramString1 = new StringBuilder();
      paramString1.append("安装");
      paramString1.append(paramString2);
      paramString1.append("成功");
      b(paramString1.toString(), paramBoolean);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("安装");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("失败,错误码=");
    ((StringBuilder)localObject1).append(paramString1);
    b(((StringBuilder)localObject1).toString(), true);
    return;
    label226:
    b("安装失败", true);
    paramString2 = new StringBuilder();
    paramString2.append("install local apk failed : ");
    paramString2.append(paramString1.getMessage());
    Log.e("WebDebugPage", paramString2.toString());
  }
  
  void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      try
      {
        localObject = new AlertDialog.Builder(b());
        ((AlertDialog.Builder)localObject).setMessage(paramString);
        ((AlertDialog.Builder)localObject).create();
        ((AlertDialog.Builder)localObject).setCancelable(true);
        if (paramBoolean2) {
          ((AlertDialog.Builder)localObject).setOnCancelListener(new d.48(this));
        }
        ((AlertDialog.Builder)localObject).show();
        return;
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show alert failed may be in abtets exe ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        Log.i("WebDebugPage", ((StringBuilder)localObject).toString());
        return;
      }
    }
    Log.e("WebDebugPage", paramString);
  }
  
  public void a(boolean paramBoolean1, Button paramButton, boolean paramBoolean2)
  {
    try
    {
      XWalkPreferences.setValue("remote-debugging", paramBoolean1);
    }
    catch (Exception localException2)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 19) {
          android.webkit.WebView.setWebContentsDebuggingEnabled(paramBoolean1);
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            com.tencent.luggage.wxa.st.c.a(paramBoolean1);
            label23:
            if ((paramBoolean2) && (this.h.getX5WebViewExtension() != null)) {
              if (paramBoolean1) {
                this.h.loadUrl("http://debugx5.qq.com/?inspector=true");
              } else {
                this.h.loadUrl("http://debugx5.qq.com/?inspector=false");
              }
            }
            if (paramButton != null)
            {
              if (paramBoolean1)
              {
                paramButton.setText("关闭远程调试模式(当前已打开)");
                return;
              }
              paramButton.setText("打开远程调试模式(当前已关闭)");
            }
            return;
            localException1 = localException1;
            continue;
            localException2 = localException2;
          }
        }
        catch (Exception localException3)
        {
          break label23;
        }
      }
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: ldc_w 590
    //   10: invokevirtual 555	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   13: ifne +13 -> 26
    //   16: aload_1
    //   17: ldc_w 588
    //   20: invokevirtual 555	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +2214 -> 2237
    //   26: ldc2_w 1701
    //   29: iconst_1
    //   30: invokestatic 599	com/tencent/xweb/util/h:a	(JI)V
    //   33: aload_1
    //   34: invokestatic 630	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   37: astore 9
    //   39: aload 9
    //   41: invokevirtual 634	android/net/Uri:getQueryParameterNames	()Ljava/util/Set;
    //   44: astore 8
    //   46: aload 8
    //   48: ifnull +2189 -> 2237
    //   51: aload 8
    //   53: invokeinterface 639 1 0
    //   58: ifle +2179 -> 2237
    //   61: aload 8
    //   63: invokeinterface 640 1 0
    //   68: astore 10
    //   70: iconst_0
    //   71: istore 6
    //   73: iconst_0
    //   74: istore 5
    //   76: aload 10
    //   78: invokeinterface 534 1 0
    //   83: ifeq +2147 -> 2230
    //   86: aload 10
    //   88: invokeinterface 538 1 0
    //   93: checkcast 213	java/lang/String
    //   96: astore 8
    //   98: aload 8
    //   100: ifnull +2127 -> 2227
    //   103: aload 8
    //   105: invokevirtual 643	java/lang/String:hashCode	()I
    //   108: lookupswitch	default:+180->288, -1767214708:+518->626, -1556996002:+501->609, -1045985412:+484->592, -974615216:+467->575, -873960692:+451->559, -748036674:+434->542, -677737752:+418->526, -338505561:+401->509, -108592348:+384->492, -82035977:+368->476, 273273929:+351->459, 293074704:+334->442, 386281809:+317->425, 624401059:+301->409, 684429537:+284->392, 801125523:+267->375, 989541982:+250->358, 1217859436:+233->341, 1473208405:+217->325, 1874228874:+200->308, 2135256815:+183->291
    //   289: aconst_null
    //   290: fadd
    //   291: aload 8
    //   293: ldc_w 1704
    //   296: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +343 -> 642
    //   302: bipush 18
    //   304: istore_2
    //   305: goto +339 -> 644
    //   308: aload 8
    //   310: ldc_w 1706
    //   313: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +326 -> 642
    //   319: bipush 8
    //   321: istore_2
    //   322: goto +322 -> 644
    //   325: aload 8
    //   327: ldc_w 1708
    //   330: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifeq +309 -> 642
    //   336: iconst_5
    //   337: istore_2
    //   338: goto +306 -> 644
    //   341: aload 8
    //   343: ldc_w 1710
    //   346: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   349: ifeq +293 -> 642
    //   352: bipush 15
    //   354: istore_2
    //   355: goto +289 -> 644
    //   358: aload 8
    //   360: ldc_w 1712
    //   363: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +276 -> 642
    //   369: bipush 13
    //   371: istore_2
    //   372: goto +272 -> 644
    //   375: aload 8
    //   377: ldc_w 1714
    //   380: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifeq +259 -> 642
    //   386: bipush 14
    //   388: istore_2
    //   389: goto +255 -> 644
    //   392: aload 8
    //   394: ldc_w 1716
    //   397: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   400: ifeq +242 -> 642
    //   403: bipush 19
    //   405: istore_2
    //   406: goto +238 -> 644
    //   409: aload 8
    //   411: ldc_w 1718
    //   414: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifeq +225 -> 642
    //   420: iconst_3
    //   421: istore_2
    //   422: goto +222 -> 644
    //   425: aload 8
    //   427: ldc_w 1720
    //   430: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +209 -> 642
    //   436: bipush 11
    //   438: istore_2
    //   439: goto +205 -> 644
    //   442: aload 8
    //   444: ldc_w 1722
    //   447: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   450: ifeq +192 -> 642
    //   453: bipush 12
    //   455: istore_2
    //   456: goto +188 -> 644
    //   459: aload 8
    //   461: ldc_w 1724
    //   464: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +175 -> 642
    //   470: bipush 17
    //   472: istore_2
    //   473: goto +171 -> 644
    //   476: aload 8
    //   478: ldc_w 1726
    //   481: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   484: ifeq +158 -> 642
    //   487: iconst_1
    //   488: istore_2
    //   489: goto +155 -> 644
    //   492: aload 8
    //   494: ldc_w 1728
    //   497: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq +142 -> 642
    //   503: bipush 7
    //   505: istore_2
    //   506: goto +138 -> 644
    //   509: aload 8
    //   511: ldc_w 1730
    //   514: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +125 -> 642
    //   520: bipush 6
    //   522: istore_2
    //   523: goto +121 -> 644
    //   526: aload 8
    //   528: ldc_w 1732
    //   531: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +108 -> 642
    //   537: iconst_0
    //   538: istore_2
    //   539: goto +105 -> 644
    //   542: aload 8
    //   544: ldc_w 1734
    //   547: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   550: ifeq +92 -> 642
    //   553: bipush 9
    //   555: istore_2
    //   556: goto +88 -> 644
    //   559: aload 8
    //   561: ldc_w 470
    //   564: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +75 -> 642
    //   570: iconst_2
    //   571: istore_2
    //   572: goto +72 -> 644
    //   575: aload 8
    //   577: ldc_w 1736
    //   580: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   583: ifeq +59 -> 642
    //   586: bipush 10
    //   588: istore_2
    //   589: goto +55 -> 644
    //   592: aload 8
    //   594: ldc_w 1738
    //   597: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   600: ifeq +42 -> 642
    //   603: bipush 16
    //   605: istore_2
    //   606: goto +38 -> 644
    //   609: aload 8
    //   611: ldc_w 1740
    //   614: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   617: ifeq +25 -> 642
    //   620: bipush 20
    //   622: istore_2
    //   623: goto +21 -> 644
    //   626: aload 8
    //   628: ldc_w 1742
    //   631: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifeq +8 -> 642
    //   637: iconst_4
    //   638: istore_2
    //   639: goto +5 -> 644
    //   642: iconst_m1
    //   643: istore_2
    //   644: iload_2
    //   645: tableswitch	default:+99 -> 744, 0:+1412->2057, 1:+1383->2028, 2:+1324->1969, 3:+1280->1925, 4:+1225->1870, 5:+1217->1862, 6:+1196->1841, 7:+1133->1778, 8:+1060->1705, 9:+850->1495, 10:+843->1488, 11:+771->1416, 12:+675->1320, 13:+654->1299, 14:+618->1263, 15:+543->1188, 16:+525->1170, 17:+500->1145, 18:+375->1020, 19:+309->954, 20:+102->747
    //   745: iconst_2
    //   746: <illegal opcode>
    //   747: aload 9
    //   749: ldc_w 1740
    //   752: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   755: astore 8
    //   757: goto +7 -> 764
    //   760: ldc 38
    //   762: astore 8
    //   764: ldc_w 702
    //   767: aload 8
    //   769: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   772: ifeq +21 -> 793
    //   775: aload_0
    //   776: ldc_w 1744
    //   779: iconst_1
    //   780: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   783: aload_0
    //   784: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   787: invokestatic 1746	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;)V
    //   790: goto +1437 -> 2227
    //   793: ldc 211
    //   795: aload 8
    //   797: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   800: ifeq +18 -> 818
    //   803: aload_0
    //   804: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   807: ldc 211
    //   809: aconst_null
    //   810: iconst_0
    //   811: aconst_null
    //   812: invokestatic 1748	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/xweb/f$a;ZLandroid/webkit/ValueCallback;)V
    //   815: goto +1412 -> 2227
    //   818: ldc 225
    //   820: aload 8
    //   822: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   825: ifeq +18 -> 843
    //   828: aload_0
    //   829: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   832: ldc 225
    //   834: aconst_null
    //   835: iconst_0
    //   836: aconst_null
    //   837: invokestatic 1748	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/xweb/f$a;ZLandroid/webkit/ValueCallback;)V
    //   840: goto +1387 -> 2227
    //   843: ldc 221
    //   845: aload 8
    //   847: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   850: ifeq +18 -> 868
    //   853: aload_0
    //   854: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   857: ldc 221
    //   859: aconst_null
    //   860: iconst_0
    //   861: aconst_null
    //   862: invokestatic 1748	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/xweb/f$a;ZLandroid/webkit/ValueCallback;)V
    //   865: goto +1362 -> 2227
    //   868: ldc 231
    //   870: aload 8
    //   872: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   875: ifeq +18 -> 893
    //   878: aload_0
    //   879: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   882: ldc 231
    //   884: aconst_null
    //   885: iconst_0
    //   886: aconst_null
    //   887: invokestatic 1748	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/xweb/f$a;ZLandroid/webkit/ValueCallback;)V
    //   890: goto +1337 -> 2227
    //   893: ldc 237
    //   895: aload 8
    //   897: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   900: ifeq +18 -> 918
    //   903: aload_0
    //   904: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   907: ldc 237
    //   909: aconst_null
    //   910: iconst_0
    //   911: aconst_null
    //   912: invokestatic 1748	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/xweb/f$a;ZLandroid/webkit/ValueCallback;)V
    //   915: goto +1312 -> 2227
    //   918: ldc 241
    //   920: aload 8
    //   922: invokevirtual 689	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   925: ifeq +18 -> 943
    //   928: aload_0
    //   929: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   932: ldc 241
    //   934: aconst_null
    //   935: iconst_0
    //   936: aconst_null
    //   937: invokestatic 1748	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/xweb/f$a;ZLandroid/webkit/ValueCallback;)V
    //   940: goto +1287 -> 2227
    //   943: aload_0
    //   944: ldc_w 1750
    //   947: iconst_1
    //   948: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   951: goto +1276 -> 2227
    //   954: aload 9
    //   956: ldc_w 1716
    //   959: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   962: astore 8
    //   964: aload 8
    //   966: invokestatic 1753	org/xwalk/core/XWalkEnvironment:setPluginTestConfigUrl	(Ljava/lang/String;)Z
    //   969: pop
    //   970: new 104	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   977: astore 11
    //   979: aload 11
    //   981: ldc_w 1755
    //   984: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 11
    //   990: aload 8
    //   992: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_0
    //   997: aload 11
    //   999: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: iconst_1
    //   1003: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1006: goto +1221 -> 2227
    //   1009: aload_0
    //   1010: ldc_w 1757
    //   1013: iconst_1
    //   1014: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1017: goto +1210 -> 2227
    //   1020: aload 9
    //   1022: ldc_w 1704
    //   1025: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1028: astore 8
    //   1030: aload 8
    //   1032: invokestatic 1760	org/xwalk/core/XWalkEnvironment:isValidConfigHost	(Ljava/lang/String;)Z
    //   1035: ifne +51 -> 1086
    //   1038: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1041: invokevirtual 1762	com/tencent/xweb/v:n	()Z
    //   1044: ifne +42 -> 1086
    //   1047: new 104	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1054: astore 11
    //   1056: aload 11
    //   1058: ldc_w 1764
    //   1061: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 11
    //   1067: aload 8
    //   1069: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload_0
    //   1074: aload 11
    //   1076: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: iconst_1
    //   1080: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1083: goto +1144 -> 2227
    //   1086: aload_0
    //   1087: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   1090: aload 8
    //   1092: invokestatic 1768	org/xwalk/core/XWalkEnvironment:setTestDownLoadUrl	(Landroid/content/Context;Ljava/lang/String;)V
    //   1095: new 104	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1102: astore 11
    //   1104: aload 11
    //   1106: ldc_w 1770
    //   1109: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 11
    //   1115: aload 8
    //   1117: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: pop
    //   1121: aload_0
    //   1122: aload 11
    //   1124: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: iconst_1
    //   1128: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1131: goto +1096 -> 2227
    //   1134: aload_0
    //   1135: ldc_w 1772
    //   1138: iconst_1
    //   1139: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1142: goto +1085 -> 2227
    //   1145: aload_0
    //   1146: ldc_w 1774
    //   1149: iconst_1
    //   1150: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1153: iconst_0
    //   1154: invokestatic 1053	com/tencent/xweb/xwalk/updater/Scheduler:b	(Z)Lcom/tencent/xweb/xwalk/updater/XWebCoreScheduler;
    //   1157: invokevirtual 1776	com/tencent/xweb/xwalk/updater/XWebCoreScheduler:e	()V
    //   1160: iconst_1
    //   1161: invokestatic 1053	com/tencent/xweb/xwalk/updater/Scheduler:b	(Z)Lcom/tencent/xweb/xwalk/updater/XWebCoreScheduler;
    //   1164: invokevirtual 1776	com/tencent/xweb/xwalk/updater/XWebCoreScheduler:e	()V
    //   1167: goto +1060 -> 2227
    //   1170: aload_0
    //   1171: ldc_w 1778
    //   1174: iconst_1
    //   1175: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1178: invokestatic 1779	com/tencent/xweb/xwalk/updater/Scheduler:l	()V
    //   1181: lconst_0
    //   1182: invokestatic 1781	com/tencent/luggage/wxa/su/k:a	(J)V
    //   1185: goto +1042 -> 2227
    //   1188: getstatic 1785	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1191: astore 8
    //   1193: aload_0
    //   1194: getfield 87	com/tencent/xweb/xwalk/d:g	Landroid/content/Context;
    //   1197: astore 11
    //   1199: ldc_w 1787
    //   1202: ldc_w 1789
    //   1205: iconst_2
    //   1206: anewarray 1791	java/lang/Class
    //   1209: dup
    //   1210: iconst_0
    //   1211: ldc_w 505
    //   1214: aastore
    //   1215: dup
    //   1216: iconst_1
    //   1217: aload 8
    //   1219: aastore
    //   1220: iconst_2
    //   1221: anewarray 4	java/lang/Object
    //   1224: dup
    //   1225: iconst_0
    //   1226: aload 11
    //   1228: aastore
    //   1229: dup
    //   1230: iconst_1
    //   1231: iconst_4
    //   1232: invokestatic 368	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1235: aastore
    //   1236: invokestatic 1796	com/tencent/xweb/util/g:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1239: pop
    //   1240: aload_0
    //   1241: ldc_w 1798
    //   1244: iconst_1
    //   1245: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1248: new 1800	com/tencent/xweb/xwalk/d$a
    //   1251: dup
    //   1252: aload_0
    //   1253: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   1256: invokespecial 1801	com/tencent/xweb/xwalk/d$a:<init>	(Landroid/content/Context;)V
    //   1259: pop
    //   1260: goto +967 -> 2227
    //   1263: aload_0
    //   1264: ldc_w 1803
    //   1267: iconst_1
    //   1268: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1271: ldc2_w 1804
    //   1274: invokestatic 1808	org/xwalk/core/XWalkEnvironment:setConfigFetchPeriod	(J)V
    //   1277: invokestatic 755	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   1280: aconst_null
    //   1281: invokestatic 1811	com/tencent/xweb/t:a	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   1284: new 1800	com/tencent/xweb/xwalk/d$a
    //   1287: dup
    //   1288: aload_0
    //   1289: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   1292: invokespecial 1801	com/tencent/xweb/xwalk/d$a:<init>	(Landroid/content/Context;)V
    //   1295: pop
    //   1296: goto +931 -> 2227
    //   1299: aload_0
    //   1300: ldc_w 1813
    //   1303: iconst_1
    //   1304: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1307: aload_0
    //   1308: invokevirtual 1815	com/tencent/xweb/xwalk/d:d	()V
    //   1311: invokestatic 755	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   1314: invokestatic 1746	com/tencent/xweb/xwalk/d:a	(Landroid/content/Context;)V
    //   1317: goto +910 -> 2227
    //   1320: aload 9
    //   1322: ldc_w 1722
    //   1325: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: invokestatic 741	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1331: istore_2
    //   1332: iload_2
    //   1333: putstatic 1818	org/xwalk/core/XWalkEnvironment:sNDeviceRd	I
    //   1336: invokestatic 1822	org/xwalk/core/XWalkEnvironment:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   1339: invokeinterface 1828 1 0
    //   1344: ldc_w 1829
    //   1347: iload_2
    //   1348: invokeinterface 1835 3 0
    //   1353: invokeinterface 1838 1 0
    //   1358: pop
    //   1359: iload_2
    //   1360: invokestatic 1841	org/xwalk/core/XWalkEnvironment:setGrayValueForTest	(I)V
    //   1363: new 104	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1370: astore 8
    //   1372: aload 8
    //   1374: ldc_w 1843
    //   1377: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: pop
    //   1381: aload 8
    //   1383: iload_2
    //   1384: sipush 10000
    //   1387: irem
    //   1388: invokevirtual 765	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: aload_0
    //   1393: aload 8
    //   1395: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1398: iconst_1
    //   1399: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1402: goto +80 -> 1482
    //   1405: aload_0
    //   1406: ldc_w 1845
    //   1409: iconst_1
    //   1410: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1413: goto +69 -> 1482
    //   1416: aload 9
    //   1418: ldc_w 1720
    //   1421: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1424: invokestatic 741	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1427: istore_2
    //   1428: iload_2
    //   1429: invokestatic 1841	org/xwalk/core/XWalkEnvironment:setGrayValueForTest	(I)V
    //   1432: new 104	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1439: astore 8
    //   1441: aload 8
    //   1443: ldc_w 1847
    //   1446: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: aload 8
    //   1452: iload_2
    //   1453: sipush 10000
    //   1456: irem
    //   1457: invokevirtual 765	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload_0
    //   1462: aload 8
    //   1464: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: iconst_1
    //   1468: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1471: goto +11 -> 1482
    //   1474: aload_0
    //   1475: ldc_w 1849
    //   1478: iconst_1
    //   1479: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1482: iconst_1
    //   1483: istore 5
    //   1485: goto -1409 -> 76
    //   1488: aload_0
    //   1489: invokespecial 1851	com/tencent/xweb/xwalk/d:h	()V
    //   1492: goto +735 -> 2227
    //   1495: aload 9
    //   1497: ldc_w 1734
    //   1500: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1503: invokestatic 1853	com/tencent/xweb/WebView$c:valueOf	(Ljava/lang/String;)Lcom/tencent/xweb/WebView$c;
    //   1506: astore 8
    //   1508: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1511: ldc_w 557
    //   1514: aload 8
    //   1516: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   1519: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1522: ldc_w 559
    //   1525: aload 8
    //   1527: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   1530: getstatic 1573	com/tencent/xweb/xwalk/d$51:a	[I
    //   1533: aload 8
    //   1535: invokevirtual 1574	com/tencent/xweb/WebView$c:ordinal	()I
    //   1538: iaload
    //   1539: istore_2
    //   1540: iload_2
    //   1541: iconst_1
    //   1542: if_icmpeq +112 -> 1654
    //   1545: iload_2
    //   1546: iconst_2
    //   1547: if_icmpeq +59 -> 1606
    //   1550: iload_2
    //   1551: iconst_3
    //   1552: if_icmpeq +6 -> 1558
    //   1555: goto +672 -> 2227
    //   1558: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1561: getstatic 1858	com/tencent/xweb/JsRuntime$JsRuntimeType:i	Lcom/tencent/xweb/JsRuntime$JsRuntimeType;
    //   1564: invokevirtual 1861	com/tencent/xweb/v:a	(Lcom/tencent/xweb/JsRuntime$JsRuntimeType;)V
    //   1567: new 104	java/lang/StringBuilder
    //   1570: dup
    //   1571: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1574: astore 11
    //   1576: aload 11
    //   1578: ldc_w 1863
    //   1581: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: aload 11
    //   1587: aload 8
    //   1589: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload_0
    //   1594: aload 11
    //   1596: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: iconst_1
    //   1600: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1603: goto +624 -> 2227
    //   1606: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1609: getstatic 1865	com/tencent/xweb/JsRuntime$JsRuntimeType:f	Lcom/tencent/xweb/JsRuntime$JsRuntimeType;
    //   1612: invokevirtual 1861	com/tencent/xweb/v:a	(Lcom/tencent/xweb/JsRuntime$JsRuntimeType;)V
    //   1615: new 104	java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1622: astore 11
    //   1624: aload 11
    //   1626: ldc_w 1863
    //   1629: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload 11
    //   1635: aload 8
    //   1637: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1640: pop
    //   1641: aload_0
    //   1642: aload 11
    //   1644: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1647: iconst_1
    //   1648: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1651: goto +576 -> 2227
    //   1654: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1657: getstatic 1858	com/tencent/xweb/JsRuntime$JsRuntimeType:i	Lcom/tencent/xweb/JsRuntime$JsRuntimeType;
    //   1660: invokevirtual 1861	com/tencent/xweb/v:a	(Lcom/tencent/xweb/JsRuntime$JsRuntimeType;)V
    //   1663: new 104	java/lang/StringBuilder
    //   1666: dup
    //   1667: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1670: astore 11
    //   1672: aload 11
    //   1674: ldc_w 1863
    //   1677: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: aload 11
    //   1683: aload 8
    //   1685: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1688: pop
    //   1689: aload_0
    //   1690: aload 11
    //   1692: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1695: iconst_1
    //   1696: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1699: goto +528 -> 2227
    //   1702: goto +525 -> 2227
    //   1705: aload 9
    //   1707: ldc_w 1706
    //   1710: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1713: invokestatic 1853	com/tencent/xweb/WebView$c:valueOf	(Ljava/lang/String;)Lcom/tencent/xweb/WebView$c;
    //   1716: astore 8
    //   1718: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1721: ldc 54
    //   1723: aload 8
    //   1725: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   1728: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1731: ldc_w 1020
    //   1734: aload 8
    //   1736: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   1739: new 104	java/lang/StringBuilder
    //   1742: dup
    //   1743: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1746: astore 11
    //   1748: aload 11
    //   1750: ldc_w 1867
    //   1753: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: pop
    //   1757: aload 11
    //   1759: aload 8
    //   1761: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: aload_0
    //   1766: aload 11
    //   1768: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: iconst_1
    //   1772: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1775: goto -1699 -> 76
    //   1778: aload 9
    //   1780: ldc_w 1728
    //   1783: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1786: invokestatic 1853	com/tencent/xweb/WebView$c:valueOf	(Ljava/lang/String;)Lcom/tencent/xweb/WebView$c;
    //   1789: astore 8
    //   1791: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1794: ldc_w 1022
    //   1797: aload 8
    //   1799: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   1802: new 104	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1809: astore 11
    //   1811: aload 11
    //   1813: ldc_w 1869
    //   1816: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: pop
    //   1820: aload 11
    //   1822: aload 8
    //   1824: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1827: pop
    //   1828: aload_0
    //   1829: aload 11
    //   1831: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1834: iconst_1
    //   1835: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1838: goto -1762 -> 76
    //   1841: aload 9
    //   1843: ldc_w 1730
    //   1846: iconst_0
    //   1847: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   1850: istore 5
    //   1852: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1855: iload 5
    //   1857: invokevirtual 1871	com/tencent/xweb/v:d	(Z)V
    //   1860: iconst_1
    //   1861: ireturn
    //   1862: invokestatic 755	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   1865: invokestatic 1872	com/tencent/xweb/xwalk/p:a	(Landroid/content/Context;)V
    //   1868: iconst_1
    //   1869: ireturn
    //   1870: aload 9
    //   1872: ldc_w 1742
    //   1875: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1878: astore_1
    //   1879: aload_1
    //   1880: ldc_w 1874
    //   1883: invokestatic 1879	com/tencent/xweb/util/a:a	(Ljava/lang/String;)Ljavax/crypto/SecretKey;
    //   1886: invokestatic 1882	com/tencent/xweb/util/a:a	(Ljava/lang/String;Ljavax/crypto/SecretKey;)Ljava/lang/String;
    //   1889: astore_1
    //   1890: aload_1
    //   1891: invokestatic 465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1894: ifeq +13 -> 1907
    //   1897: aload_0
    //   1898: ldc_w 1884
    //   1901: iconst_1
    //   1902: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1905: iconst_1
    //   1906: ireturn
    //   1907: aload_0
    //   1908: aload_1
    //   1909: invokevirtual 1886	com/tencent/xweb/xwalk/d:a	(Ljava/lang/String;)Z
    //   1912: pop
    //   1913: iconst_1
    //   1914: ireturn
    //   1915: aload_0
    //   1916: ldc_w 1884
    //   1919: iconst_1
    //   1920: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1923: iconst_1
    //   1924: ireturn
    //   1925: aload 9
    //   1927: ldc_w 1718
    //   1930: iconst_0
    //   1931: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   1934: istore 5
    //   1936: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   1939: iload 5
    //   1941: invokevirtual 1888	com/tencent/xweb/v:f	(Z)V
    //   1944: iload 5
    //   1946: ifeq +13 -> 1959
    //   1949: aload_0
    //   1950: ldc_w 1890
    //   1953: iconst_1
    //   1954: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1957: iconst_1
    //   1958: ireturn
    //   1959: aload_0
    //   1960: ldc_w 1892
    //   1963: iconst_1
    //   1964: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   1967: iconst_1
    //   1968: ireturn
    //   1969: aload 9
    //   1971: ldc_w 470
    //   1974: invokevirtual 673	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1977: astore 8
    //   1979: aload 9
    //   1981: invokevirtual 1893	android/net/Uri:toString	()Ljava/lang/String;
    //   1984: aload 8
    //   1986: invokestatic 1895	com/tencent/xweb/xwalk/d:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1989: istore 6
    //   1991: iload 6
    //   1993: ifne +23 -> 2016
    //   1996: aload_0
    //   1997: ldc_w 1897
    //   2000: iconst_1
    //   2001: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   2004: ldc_w 603
    //   2007: ldc_w 1899
    //   2010: invokestatic 608	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2013: goto -1937 -> 76
    //   2016: ldc_w 603
    //   2019: ldc_w 1901
    //   2022: invokestatic 1671	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2025: goto -1949 -> 76
    //   2028: aload 9
    //   2030: ldc_w 1726
    //   2033: iconst_0
    //   2034: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   2037: istore 5
    //   2039: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2042: iload 5
    //   2044: invokevirtual 1902	com/tencent/xweb/v:c	(Z)V
    //   2047: aload_0
    //   2048: iload 5
    //   2050: aconst_null
    //   2051: iconst_1
    //   2052: invokevirtual 1310	com/tencent/xweb/xwalk/d:a	(ZLandroid/widget/Button;Z)V
    //   2055: iconst_1
    //   2056: ireturn
    //   2057: aload 9
    //   2059: ldc_w 1732
    //   2062: iconst_0
    //   2063: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   2066: ifeq +82 -> 2148
    //   2069: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2072: ldc 54
    //   2074: getstatic 170	com/tencent/xweb/WebView$c:c	Lcom/tencent/xweb/WebView$c;
    //   2077: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2080: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2083: ldc_w 557
    //   2086: getstatic 170	com/tencent/xweb/WebView$c:c	Lcom/tencent/xweb/WebView$c;
    //   2089: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2092: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2095: ldc_w 559
    //   2098: getstatic 170	com/tencent/xweb/WebView$c:c	Lcom/tencent/xweb/WebView$c;
    //   2101: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2104: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2107: ldc_w 1022
    //   2110: getstatic 170	com/tencent/xweb/WebView$c:c	Lcom/tencent/xweb/WebView$c;
    //   2113: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2116: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2119: ldc_w 1020
    //   2122: getstatic 170	com/tencent/xweb/WebView$c:c	Lcom/tencent/xweb/WebView$c;
    //   2125: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2128: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2131: getstatic 1865	com/tencent/xweb/JsRuntime$JsRuntimeType:f	Lcom/tencent/xweb/JsRuntime$JsRuntimeType;
    //   2134: invokevirtual 1861	com/tencent/xweb/v:a	(Lcom/tencent/xweb/JsRuntime$JsRuntimeType;)V
    //   2137: aload_0
    //   2138: ldc_w 1904
    //   2141: iconst_1
    //   2142: iconst_1
    //   2143: invokevirtual 738	com/tencent/xweb/xwalk/d:a	(Ljava/lang/String;ZZ)V
    //   2146: iconst_1
    //   2147: ireturn
    //   2148: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2151: ldc 54
    //   2153: getstatic 134	com/tencent/xweb/WebView$c:a	Lcom/tencent/xweb/WebView$c;
    //   2156: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2159: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2162: ldc_w 557
    //   2165: getstatic 134	com/tencent/xweb/WebView$c:a	Lcom/tencent/xweb/WebView$c;
    //   2168: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2171: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2174: ldc_w 559
    //   2177: getstatic 134	com/tencent/xweb/WebView$c:a	Lcom/tencent/xweb/WebView$c;
    //   2180: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2183: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2186: ldc_w 1022
    //   2189: getstatic 134	com/tencent/xweb/WebView$c:a	Lcom/tencent/xweb/WebView$c;
    //   2192: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2195: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2198: ldc_w 1020
    //   2201: getstatic 134	com/tencent/xweb/WebView$c:a	Lcom/tencent/xweb/WebView$c;
    //   2204: invokevirtual 1856	com/tencent/xweb/v:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   2207: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2210: getstatic 893	com/tencent/xweb/JsRuntime$JsRuntimeType:a	Lcom/tencent/xweb/JsRuntime$JsRuntimeType;
    //   2213: invokevirtual 1861	com/tencent/xweb/v:a	(Lcom/tencent/xweb/JsRuntime$JsRuntimeType;)V
    //   2216: aload_0
    //   2217: ldc_w 1906
    //   2220: iconst_1
    //   2221: iconst_1
    //   2222: invokevirtual 738	com/tencent/xweb/xwalk/d:a	(Ljava/lang/String;ZZ)V
    //   2225: iconst_1
    //   2226: ireturn
    //   2227: goto -2151 -> 76
    //   2230: iload 6
    //   2232: istore 7
    //   2234: goto +9 -> 2243
    //   2237: iconst_0
    //   2238: istore 7
    //   2240: iconst_0
    //   2241: istore 5
    //   2243: aload_1
    //   2244: ldc_w 592
    //   2247: invokevirtual 555	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2250: ifeq +89 -> 2339
    //   2253: aload_1
    //   2254: invokestatic 630	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2257: invokevirtual 634	android/net/Uri:getQueryParameterNames	()Ljava/util/Set;
    //   2260: astore_1
    //   2261: aload_1
    //   2262: ifnull +75 -> 2337
    //   2265: aload_1
    //   2266: invokeinterface 639 1 0
    //   2271: ifle +66 -> 2337
    //   2274: aload_1
    //   2275: invokeinterface 640 1 0
    //   2280: astore_1
    //   2281: aload_1
    //   2282: invokeinterface 534 1 0
    //   2287: ifeq +50 -> 2337
    //   2290: aload_1
    //   2291: invokeinterface 538 1 0
    //   2296: checkcast 213	java/lang/String
    //   2299: astore 8
    //   2301: aload 8
    //   2303: ifnull -22 -> 2281
    //   2306: aload 8
    //   2308: invokevirtual 643	java/lang/String:hashCode	()I
    //   2311: ldc_w 1907
    //   2314: if_icmpeq +6 -> 2320
    //   2317: goto +17 -> 2334
    //   2320: aload 8
    //   2322: ldc_w 1909
    //   2325: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2328: ifeq +6 -> 2334
    //   2331: goto -50 -> 2281
    //   2334: goto -53 -> 2281
    //   2337: iconst_1
    //   2338: ireturn
    //   2339: invokestatic 1912	org/xwalk/core/XWalkEnvironment:initTurnOnKVLog	()V
    //   2342: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2345: invokevirtual 1762	com/tencent/xweb/v:n	()Z
    //   2348: ifne +17 -> 2365
    //   2351: iload 7
    //   2353: ifeq +6 -> 2359
    //   2356: goto +9 -> 2365
    //   2359: iconst_0
    //   2360: istore 4
    //   2362: goto +6 -> 2368
    //   2365: iconst_1
    //   2366: istore 4
    //   2368: aload_1
    //   2369: ldc_w 588
    //   2372: invokevirtual 555	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2375: ifne +20 -> 2395
    //   2378: iload 7
    //   2380: ifeq +6 -> 2386
    //   2383: goto +12 -> 2395
    //   2386: iconst_0
    //   2387: istore_2
    //   2388: iload 5
    //   2390: istore 6
    //   2392: goto +694 -> 3086
    //   2395: aload_1
    //   2396: invokestatic 630	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2399: astore 8
    //   2401: aload 8
    //   2403: invokevirtual 634	android/net/Uri:getQueryParameterNames	()Ljava/util/Set;
    //   2406: astore 9
    //   2408: aload 9
    //   2410: ifnull +723 -> 3133
    //   2413: aload 9
    //   2415: invokeinterface 639 1 0
    //   2420: ifne +6 -> 2426
    //   2423: goto +710 -> 3133
    //   2426: aload 9
    //   2428: invokeinterface 640 1 0
    //   2433: astore 9
    //   2435: iconst_0
    //   2436: istore_3
    //   2437: iload_3
    //   2438: istore_2
    //   2439: iload 5
    //   2441: istore 6
    //   2443: aload 9
    //   2445: invokeinterface 534 1 0
    //   2450: ifeq +636 -> 3086
    //   2453: aload 9
    //   2455: invokeinterface 538 1 0
    //   2460: checkcast 213	java/lang/String
    //   2463: astore 10
    //   2465: iload 5
    //   2467: istore 6
    //   2469: aload 10
    //   2471: ifnull +344 -> 2815
    //   2474: aload 10
    //   2476: invokevirtual 643	java/lang/String:hashCode	()I
    //   2479: lookupswitch	default:+89->2568, -1270583121:+239->2718, -1258153200:+223->2702, -997333991:+206->2685, -844092179:+189->2668, -604633792:+173->2652, -82035977:+157->2636, 176290201:+140->2619, 184008721:+124->2603, 724449292:+108->2587, 971862549:+92->2571
    //   2569: nop
    //   2570: goto +6410 -> 8980
    //   2573: ldc_w 1914
    //   2576: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2579: ifeq +156 -> 2735
    //   2582: iconst_3
    //   2583: istore_2
    //   2584: goto +153 -> 2737
    //   2587: aload 10
    //   2589: ldc_w 1916
    //   2592: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2595: ifeq +140 -> 2735
    //   2598: iconst_1
    //   2599: istore_2
    //   2600: goto +137 -> 2737
    //   2603: aload 10
    //   2605: ldc_w 1918
    //   2608: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2611: ifeq +124 -> 2735
    //   2614: iconst_4
    //   2615: istore_2
    //   2616: goto +121 -> 2737
    //   2619: aload 10
    //   2621: ldc_w 1920
    //   2624: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2627: ifeq +108 -> 2735
    //   2630: bipush 6
    //   2632: istore_2
    //   2633: goto +104 -> 2737
    //   2636: aload 10
    //   2638: ldc_w 1726
    //   2641: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2644: ifeq +91 -> 2735
    //   2647: iconst_0
    //   2648: istore_2
    //   2649: goto +88 -> 2737
    //   2652: aload 10
    //   2654: ldc_w 1922
    //   2657: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2660: ifeq +75 -> 2735
    //   2663: iconst_2
    //   2664: istore_2
    //   2665: goto +72 -> 2737
    //   2668: aload 10
    //   2670: ldc_w 1924
    //   2673: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2676: ifeq +59 -> 2735
    //   2679: bipush 7
    //   2681: istore_2
    //   2682: goto +55 -> 2737
    //   2685: aload 10
    //   2687: ldc_w 1926
    //   2690: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2693: ifeq +42 -> 2735
    //   2696: bipush 9
    //   2698: istore_2
    //   2699: goto +38 -> 2737
    //   2702: aload 10
    //   2704: ldc_w 1928
    //   2707: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2710: ifeq +25 -> 2735
    //   2713: iconst_5
    //   2714: istore_2
    //   2715: goto +22 -> 2737
    //   2718: aload 10
    //   2720: ldc_w 1930
    //   2723: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2726: ifeq +9 -> 2735
    //   2729: bipush 8
    //   2731: istore_2
    //   2732: goto +5 -> 2737
    //   2735: iconst_m1
    //   2736: istore_2
    //   2737: iload_2
    //   2738: tableswitch	default:+54 -> 2792, 0:+315->3053, 1:+269->3007, 2:+264->3002, 3:+206->2944, 4:+139->2877, 5:+117->2855, 6:+95->2833, 7:+84->2822, 8:+67->2805, 9:+61->2799
    //   2793: iconst_2
    //   2794: istore 6
    //   2796: goto +19 -> 2815
    //   2799: invokestatic 1932	com/tencent/xweb/xwalk/p:b	()V
    //   2802: goto +10 -> 2812
    //   2805: aload_0
    //   2806: invokevirtual 416	com/tencent/xweb/xwalk/d:b	()Landroid/content/Context;
    //   2809: invokestatic 1935	org/xwalk/core/XWalkEnvironment:clearAllVersion	(Landroid/content/Context;)V
    //   2812: iconst_1
    //   2813: istore 6
    //   2815: iload 6
    //   2817: istore 5
    //   2819: goto +264 -> 3083
    //   2822: invokestatic 1936	com/tencent/xweb/xwalk/p:f	()Z
    //   2825: pop
    //   2826: iload 5
    //   2828: istore 6
    //   2830: goto -15 -> 2815
    //   2833: invokestatic 755	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   2836: iconst_1
    //   2837: invokestatic 1939	com/tencent/xweb/xwalk/p:a	(Landroid/content/Context;Z)V
    //   2840: aload_0
    //   2841: ldc_w 1941
    //   2844: iconst_1
    //   2845: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   2848: iload 5
    //   2850: istore 6
    //   2852: goto -37 -> 2815
    //   2855: invokestatic 755	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   2858: iconst_1
    //   2859: invokestatic 1944	com/tencent/xweb/ad:a	(Landroid/content/Context;Z)V
    //   2862: aload_0
    //   2863: ldc_w 1946
    //   2866: iconst_1
    //   2867: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   2870: iload 5
    //   2872: istore 6
    //   2874: goto -59 -> 2815
    //   2877: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2880: invokevirtual 809	com/tencent/xweb/v:h	()Z
    //   2883: iconst_1
    //   2884: ixor
    //   2885: istore 6
    //   2887: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2890: iload 6
    //   2892: invokevirtual 1948	com/tencent/xweb/v:g	(Z)V
    //   2895: iload 6
    //   2897: ifeq +22 -> 2919
    //   2900: aload_0
    //   2901: invokespecial 93	com/tencent/xweb/xwalk/d:g	()V
    //   2904: aload_0
    //   2905: getfield 50	com/tencent/xweb/xwalk/d:e	Landroid/widget/Button;
    //   2908: iconst_0
    //   2909: invokevirtual 1334	android/widget/Button:setVisibility	(I)V
    //   2912: iload 5
    //   2914: istore 6
    //   2916: goto -101 -> 2815
    //   2919: aload_0
    //   2920: getfield 50	com/tencent/xweb/xwalk/d:e	Landroid/widget/Button;
    //   2923: astore 10
    //   2925: iload 5
    //   2927: istore 6
    //   2929: aload 10
    //   2931: ifnull -116 -> 2815
    //   2934: aload 10
    //   2936: bipush 8
    //   2938: invokevirtual 1334	android/widget/Button:setVisibility	(I)V
    //   2941: goto +142 -> 3083
    //   2944: aload 8
    //   2946: ldc_w 1914
    //   2949: iconst_0
    //   2950: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   2953: istore 6
    //   2955: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   2958: iload 6
    //   2960: invokevirtual 1949	com/tencent/xweb/v:b	(Z)V
    //   2963: new 104	java/lang/StringBuilder
    //   2966: dup
    //   2967: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2970: astore 10
    //   2972: aload 10
    //   2974: ldc_w 1951
    //   2977: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2980: pop
    //   2981: aload 10
    //   2983: iload 6
    //   2985: invokevirtual 982	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2988: pop
    //   2989: aload_0
    //   2990: aload 10
    //   2992: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2995: iconst_1
    //   2996: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   2999: goto +84 -> 3083
    //   3002: iconst_1
    //   3003: istore_3
    //   3004: goto +76 -> 3080
    //   3007: aload 8
    //   3009: ldc_w 1916
    //   3012: iconst_0
    //   3013: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   3016: istore 5
    //   3018: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   3021: iload 5
    //   3023: invokevirtual 1953	com/tencent/xweb/v:j	(Z)V
    //   3026: iload 5
    //   3028: ifeq +14 -> 3042
    //   3031: aload_0
    //   3032: ldc_w 1353
    //   3035: iconst_1
    //   3036: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   3039: goto +41 -> 3080
    //   3042: aload_0
    //   3043: ldc_w 1955
    //   3046: iconst_1
    //   3047: invokevirtual 684	com/tencent/xweb/xwalk/d:b	(Ljava/lang/String;Z)V
    //   3050: goto +30 -> 3080
    //   3053: aload 8
    //   3055: ldc_w 1726
    //   3058: iconst_0
    //   3059: invokevirtual 789	android/net/Uri:getBooleanQueryParameter	(Ljava/lang/String;Z)Z
    //   3062: istore 5
    //   3064: invokestatic 145	com/tencent/xweb/v:a	()Lcom/tencent/xweb/v;
    //   3067: iload 5
    //   3069: invokevirtual 1902	com/tencent/xweb/v:c	(Z)V
    //   3072: aload_0
    //   3073: iload 5
    //   3075: aconst_null
    //   3076: iconst_1
    //   3077: invokevirtual 1310	com/tencent/xweb/xwalk/d:a	(ZLandroid/widget/Button;Z)V
    //   3080: iconst_1
    //   3081: istore 5
    //   3083: goto -646 -> 2437
    //   3086: iload 6
    //   3088: istore 5
    //   3090: iload 4
    //   3092: ifeq +30 -> 3122
    //   3095: aload_0
    //   3096: aload_1
    //   3097: iload 7
    //   3099: invokespecial 1957	com/tencent/xweb/xwalk/d:c	(Ljava/lang/String;Z)Z
    //   3102: ifne +17 -> 3119
    //   3105: iload 6
    //   3107: ifeq +6 -> 3113
    //   3110: goto +9 -> 3119
    //   3113: iconst_0
    //   3114: istore 5
    //   3116: goto +6 -> 3122
    //   3119: iconst_1
    //   3120: istore 5
    //   3122: iload_2
    //   3123: ifeq +7 -> 3130
    //   3126: aload_0
    //   3127: invokevirtual 1958	com/tencent/xweb/xwalk/d:e	()V
    //   3130: iload 5
    //   3132: ireturn
    //   3133: iload 4
    //   3135: ifeq +8 -> 3143
    //   3138: aload_0
    //   3139: invokespecial 622	com/tencent/xweb/xwalk/d:k	()Z
    //   3142: pop
    //   3143: iconst_1
    //   3144: ireturn
    //   3145: astore 8
    //   3147: goto -2387 -> 760
    //   3150: astore 8
    //   3152: goto -2143 -> 1009
    //   3155: astore 8
    //   3157: goto -2023 -> 1134
    //   3160: astore 8
    //   3162: goto -1757 -> 1405
    //   3165: astore 8
    //   3167: goto -1693 -> 1474
    //   3170: astore 8
    //   3172: goto -1470 -> 1702
    //   3175: astore 8
    //   3177: goto -950 -> 2227
    //   3180: astore 8
    //   3182: goto -3106 -> 76
    //   3185: astore_1
    //   3186: goto -1271 -> 1915
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3189	0	this	d
    //   0	3189	1	paramString	String
    //   304	2819	2	i1	int
    //   2436	568	3	i2	int
    //   2360	774	4	i3	int
    //   74	3057	5	bool1	boolean
    //   71	3035	6	bool2	boolean
    //   2232	866	7	bool3	boolean
    //   44	3010	8	localObject1	Object
    //   3145	1	8	localException1	Exception
    //   3150	1	8	localException2	Exception
    //   3155	1	8	localException3	Exception
    //   3160	1	8	localException4	Exception
    //   3165	1	8	localException5	Exception
    //   3170	1	8	localException6	Exception
    //   3175	1	8	localException7	Exception
    //   3180	1	8	localException8	Exception
    //   37	2417	9	localObject2	Object
    //   68	2923	10	localObject3	Object
    //   977	853	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   747	757	3145	java/lang/Exception
    //   954	964	3150	java/lang/Exception
    //   1020	1030	3155	java/lang/Exception
    //   1320	1359	3160	java/lang/Exception
    //   1416	1428	3165	java/lang/Exception
    //   1495	1540	3170	java/lang/Exception
    //   1558	1603	3175	java/lang/Exception
    //   1606	1651	3175	java/lang/Exception
    //   1654	1699	3175	java/lang/Exception
    //   1705	1775	3180	java/lang/Exception
    //   1778	1838	3180	java/lang/Exception
    //   1879	1905	3185	java/lang/Throwable
    //   1907	1913	3185	java/lang/Throwable
  }
  
  public Context b()
  {
    return this.g;
  }
  
  void b(String paramString1, String paramString2)
  {
    u.a(paramString1, paramString2);
    paramString1 = paramString2.split("\\.");
    if (paramString1.length == 2)
    {
      paramString2 = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(paramString1[0]);
      localStringBuilder.append("/main.html");
      paramString2.loadUrl(localStringBuilder.toString());
    }
    this.j.setVisibility(8);
  }
  
  void b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        localObject = new AlertDialog.Builder(b());
        ((AlertDialog.Builder)localObject).setMessage(paramString);
        ((AlertDialog.Builder)localObject).create().show();
        return;
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show alert failed may be in abtets exe ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        Log.i("WebDebugPage", ((StringBuilder)localObject).toString());
        return;
      }
    }
    Log.e("WebDebugPage", paramString);
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject1 = new com.tencent.luggage.wxa.ss.h(Environment.getExternalStorageDirectory());
    if (((com.tencent.luggage.wxa.ss.h)localObject1).g() == null)
    {
      b("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    localObject1.toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((com.tencent.luggage.wxa.ss.h)localObject1).a());
    ((StringBuilder)localObject2).append("/apkxwebtest");
    localObject1 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject1 = new com.tencent.luggage.wxa.ss.h((String)localObject1);
      localObject2 = ((com.tencent.luggage.wxa.ss.h)localObject1).g();
      if ((localObject2 != null) && (localObject2.length != 0))
      {
        int i1 = 0;
        while (i1 < localObject2.length)
        {
          if (localObject2[i1].h().endsWith(".zip"))
          {
            localObject1 = localObject2[i1].i();
            localObject2 = localObject2[i1].h();
            if (paramBoolean)
            {
              AlertDialog.Builder localBuilder = new AlertDialog.Builder(b()).setTitle("提示");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("确定加载:");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append("?");
              localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new d.44(this, (String)localObject1, (String)localObject2, paramBoolean)).setNegativeButton("取消", new d.43(this)).show();
              return;
            }
            a((String)localObject1, (String)localObject2, paramBoolean);
            return;
          }
          i1 += 1;
        }
        b("apkxwebtest目录下没有.zip文件", true);
        return;
      }
      b("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    catch (Exception localException)
    {
      label276:
      break label276;
    }
    b("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
  }
  
  void c()
  {
    int i1 = 1;
    this.k = true;
    if (this.f.equals("all"))
    {
      String[] arrayOfString = b().getResources().getStringArray(2130968689);
      WebView.c localc = v.a().b(arrayOfString[0]);
      while (i1 < arrayOfString.length)
      {
        if (v.a().b(arrayOfString[i1]) != localc)
        {
          ((RadioButton)this.j.findViewById(2131427363)).setChecked(false);
          ((RadioButton)this.j.findViewById(2131427366)).setChecked(false);
          ((RadioButton)this.j.findViewById(2131427365)).setChecked(false);
          ((RadioButton)this.j.findViewById(2131427364)).setChecked(false);
          this.k = false;
          return;
        }
        i1 += 1;
      }
      a(localc);
    }
    else
    {
      a(v.a().b(this.f));
    }
    this.k = false;
  }
  
  void d()
  {
    Scheduler.c = true;
    Scheduler.l();
    new d.c(this, b()).a(null);
  }
  
  void e()
  {
    b(b());
  }
  
  void f()
  {
    Object localObject1 = new com.tencent.luggage.wxa.ss.h(Environment.getExternalStorageDirectory());
    if (((com.tencent.luggage.wxa.ss.h)localObject1).g() == null)
    {
      b("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    localObject1.toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((com.tencent.luggage.wxa.ss.h)localObject1).a());
    ((StringBuilder)localObject2).append("/xweb_dump");
    localObject1 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject2 = new com.tencent.luggage.wxa.ss.h((String)localObject1);
      Object localObject3 = ((com.tencent.luggage.wxa.ss.h)localObject2).g();
      if ((localObject3 != null) && (localObject3.length != 0))
      {
        int i1 = 0;
        while (i1 < localObject3.length)
        {
          if (localObject3[i1].h().endsWith(".zip"))
          {
            localObject2 = localObject3[i1].i();
            localObject3 = localObject3[i1].h();
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(b()).setTitle("提示");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("确定加载:");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append("?");
            localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new d.47(this, (String)localObject1, (String)localObject2)).setNegativeButton("取消", new d.46(this)).show();
            return;
          }
          i1 += 1;
        }
        b("web_dump目录下没有.zip文件", true);
        return;
      }
      b("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    catch (Exception localException)
    {
      label257:
      break label257;
    }
    b("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */