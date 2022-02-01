package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public class SwiftBrowserDebugHelper
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  private static boolean e = false;
  private final ArrayList<SwiftBrowserDebugHelper.JsApiInvokeRecord> a = new ArrayList(10);
  private int c = -1;
  private int d = -1;
  
  private boolean c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e()
  {
    if (c())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("页面地址:\r\n");
      ((StringBuilder)localObject1).append(this.b.a().getUrl());
      ((StringBuilder)localObject1).append("\r\n\r\n");
      localObject1 = new StringBuilder(((StringBuilder)localObject1).toString());
      ((StringBuilder)localObject1).append("白名单发布版本号:");
      ((StringBuilder)localObject1).append(AuthorizeConfig.a().b());
      ((StringBuilder)localObject1).append("\r\n\r\n");
      ((StringBuilder)localObject1).append("JsAPI调用记录:\r\n");
      Object localObject2 = this.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(((SwiftBrowserDebugHelper.JsApiInvokeRecord)((Iterator)localObject2).next()).toString());
        ((StringBuilder)localObject1).append("\r\n");
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = DialogUtil.a(this.b.b(), 230);
      ((QQCustomDialog)localObject2).setContentView(((IWebviewApi)QRoute.api(IWebviewApi.class)).getWebViewDialogMultiLineLayout());
      ((QQCustomDialog)localObject2).getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
      ((QQCustomDialog)localObject2).setTitle(2131912000);
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
      ((QQCustomDialog)localObject2).getMessageTextView().setMaxLines(20);
      ((QQCustomDialog)localObject2).getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
      ((QQCustomDialog)localObject2).setPositiveButton("Close", new SwiftBrowserDebugHelper.1(this));
      ((QQCustomDialog)localObject2).setNegativeButton("Copy", new SwiftBrowserDebugHelper.2(this, (String)localObject1));
      ((QQCustomDialog)localObject2).show();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (7 == paramInt)
    {
      e();
      b();
    }
  }
  
  public void b()
  {
    if (d())
    {
      SwiftBrowserStatistics localSwiftBrowserStatistics = (SwiftBrowserStatistics)this.b.d().a(-2);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("页面地址:\r\n");
      ((StringBuilder)localObject1).append(this.b.a().getUrl());
      ((StringBuilder)localObject1).append("\r\n\r\n关键步骤耗时统计记录:\r\n");
      StringBuilder localStringBuilder = new StringBuilder(((StringBuilder)localObject1).toString());
      Object localObject3 = this.b.b().getResources();
      int i;
      if (localSwiftBrowserStatistics.aH) {
        i = 2131912003;
      }
      for (;;)
      {
        localObject1 = ((Resources)localObject3).getString(i);
        break;
        if (SwiftBrowserStatistics.aD) {
          i = 2131911999;
        } else {
          i = 2131911996;
        }
      }
      localStringBuilder.append("加载模式:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\r\n");
      boolean bool = localSwiftBrowserStatistics.aH;
      Object localObject2 = "是";
      if ((!bool) && (SwiftBrowserStatistics.aE))
      {
        localStringBuilder.append("是否完全预加载:");
        if (SwiftBrowserStatistics.aE) {
          localObject1 = "是";
        } else {
          localObject1 = "否";
        }
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\r\n");
      }
      localObject3 = ((Resources)localObject3).getString(2131912002);
      localObject1 = localObject3;
      if (-1 != localSwiftBrowserStatistics.an)
      {
        i = localSwiftBrowserStatistics.an;
        if (i != 200)
        {
          if (i != 304)
          {
            if (i != 1000)
            {
              if (i != 2000) {
                localObject1 = localObject3;
              } else {
                localObject1 = "Sonic模板变更";
              }
            }
            else {
              localObject1 = "Sonic首次加载";
            }
          }
          else {
            localObject1 = "Sonic完全缓存";
          }
        }
        else {
          localObject1 = "Sonic数据更新";
        }
      }
      localStringBuilder.append("页面模式:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\r\n");
      localStringBuilder.append("是否命中WebView缓存:");
      if (localSwiftBrowserStatistics.aF) {
        localObject1 = "是";
      } else {
        localObject1 = "否";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\r\n");
      localStringBuilder.append("是否命中BrowserView缓存:");
      if (localSwiftBrowserStatistics.aG) {
        localObject1 = localObject2;
      } else {
        localObject1 = "否";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\r\n");
      if ((!localSwiftBrowserStatistics.aH) && (SwiftBrowserStatistics.aD))
      {
        localStringBuilder.append("预加载进程响应耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.ac);
        localStringBuilder.append("ms.\r\n");
        localStringBuilder.append("预加载默认处理耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.ad);
        localStringBuilder.append("ms.\r\n");
        localStringBuilder.append("预加载完全处理耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.ae);
        localStringBuilder.append("ms.\r\n");
        localStringBuilder.append("预加载X5环境处理耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.af);
        localStringBuilder.append("ms.\r\n");
        localStringBuilder.append("预创建WebView处理耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.ag);
        localStringBuilder.append("ms.\r\n");
        localStringBuilder.append("预热WebView处理耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.ah);
        localStringBuilder.append("ms.\r\n");
        localStringBuilder.append("预创建BrowserView处理耗时:");
        localStringBuilder.append(SwiftBrowserStatistics.ai);
        localStringBuilder.append("ms.\r\n");
      }
      localStringBuilder.append("点击响应打点:");
      localStringBuilder.append(localSwiftBrowserStatistics.d - localSwiftBrowserStatistics.c);
      localStringBuilder.append("ms.\r\n");
      localStringBuilder.append("终端处理打点:");
      localStringBuilder.append(localSwiftBrowserStatistics.u - localSwiftBrowserStatistics.c);
      localStringBuilder.append("ms.\r\n");
      localStringBuilder.append("资源加载打点:");
      localStringBuilder.append(localSwiftBrowserStatistics.aj);
      localStringBuilder.append("ms.\r\n");
      localStringBuilder.append("主资源首行打点:");
      localStringBuilder.append(localSwiftBrowserStatistics.ak);
      localStringBuilder.append("ms.\r\n");
      localStringBuilder.append("首屏可见打点:");
      localStringBuilder.append(localSwiftBrowserStatistics.al);
      localStringBuilder.append("ms.\r\n");
      localStringBuilder.append("首屏可交互打点:");
      localStringBuilder.append(localSwiftBrowserStatistics.am);
      localStringBuilder.append("ms.\r\n");
      localObject1 = localStringBuilder.toString();
      localObject2 = DialogUtil.a(this.b.b(), 230);
      ((QQCustomDialog)localObject2).setContentView(((IWebviewApi)QRoute.api(IWebviewApi.class)).getWebViewDialogMultiLineLayout());
      ((QQCustomDialog)localObject2).getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
      ((QQCustomDialog)localObject2).setTitle(2131911995);
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
      ((QQCustomDialog)localObject2).getMessageTextView().setMaxLines(20);
      ((QQCustomDialog)localObject2).getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
      ((QQCustomDialog)localObject2).setPositiveButton("Close", new SwiftBrowserDebugHelper.3(this));
      ((QQCustomDialog)localObject2).setNegativeButton("Copy", new SwiftBrowserDebugHelper.4(this, (String)localObject1));
      ((QQCustomDialog)localObject2).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper
 * JD-Core Version:    0.7.0.1
 */