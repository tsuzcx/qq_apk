package com.tencent.mobileqq.webview.swift.component;

import akon;
import akoo;
import akop;
import akoq;
import akor;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public class SwiftBrowserDebugHelper
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  private int jdField_a_of_type_Int = -1;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private int b = -1;
  
  private boolean a()
  {
    if (-1 == this.jdField_a_of_type_Int) {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSharedPreferences(EnvSwitchActivity.KEY_ENV_SWITCH, 4).getBoolean(EnvSwitchActivity.KEY_WEBVIEW_JSAPI_TRACE_SWITCH, false)) {
        break label53;
      }
    }
    label53:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      if (1 != this.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    if (-1 == this.b) {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSharedPreferences(EnvSwitchActivity.KEY_ENV_SWITCH, 4).getBoolean(EnvSwitchActivity.KEY_WEBVIEW_STATISTICS_SWITCH, false)) {
        break label53;
      }
    }
    label53:
    for (int i = 1;; i = 0)
    {
      this.b = i;
      if (1 != this.b) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (a())
    {
      Object localObject1 = new StringBuilder("页面地址:\r\n" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl() + "\r\n\r\n");
      ((StringBuilder)localObject1).append("白名单发布版本号:").append(AuthorizeConfig.a().a()).append("\r\n\r\n");
      ((StringBuilder)localObject1).append("JsAPI调用记录:\r\n");
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(((akor)((Iterator)localObject2).next()).toString());
        ((StringBuilder)localObject1).append("\r\n");
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 230);
      ((QQCustomDialog)localObject2).setContentView(2130968852);
      ((QQCustomDialog)localObject2).getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
      ((QQCustomDialog)localObject2).setTitle("JsAPI调用记录(仅支持非外发版本)");
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
      ((QQCustomDialog)localObject2).getMessageTextView().setMaxLines(20);
      ((QQCustomDialog)localObject2).getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
      ((QQCustomDialog)localObject2).setPositiveButton("Close", new akon(this));
      ((QQCustomDialog)localObject2).setNegativeButton("Copy", new akoo(this, (String)localObject1));
      ((QQCustomDialog)localObject2).show();
    }
  }
  
  public void a()
  {
    SwiftBrowserStatistics localSwiftBrowserStatistics;
    StringBuilder localStringBuilder;
    Object localObject2;
    if (b())
    {
      localSwiftBrowserStatistics = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
      localStringBuilder = new StringBuilder("页面地址:\r\n" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl() + "\r\n\r\n关键步骤耗时统计记录:\r\n");
      if (!localSwiftBrowserStatistics.s) {
        break label666;
      }
      localObject1 = "二次进入";
      localStringBuilder.append("加载模式:").append((String)localObject1).append("\r\n");
      if ((!localSwiftBrowserStatistics.s) && (SwiftBrowserStatistics.p))
      {
        localObject2 = localStringBuilder.append("是否完全预加载:");
        if (!SwiftBrowserStatistics.p) {
          break label686;
        }
        localObject1 = "是";
        label126:
        ((StringBuilder)localObject2).append((String)localObject1).append("\r\n");
      }
      localObject2 = "默认";
      localObject1 = localObject2;
      if (-1 != localSwiftBrowserStatistics.jdField_a_of_type_Int) {}
      switch (localSwiftBrowserStatistics.jdField_a_of_type_Int)
      {
      default: 
        localObject1 = localObject2;
        label198:
        localStringBuilder.append("页面模式:").append((String)localObject1).append("\r\n");
        localObject2 = localStringBuilder.append("是否命中WebView缓存:");
        if (localSwiftBrowserStatistics.q)
        {
          localObject1 = "是";
          label233:
          ((StringBuilder)localObject2).append((String)localObject1).append("\r\n");
          localObject2 = localStringBuilder.append("是否命中BrowserView缓存:");
          if (!localSwiftBrowserStatistics.r) {
            break label728;
          }
        }
        break;
      }
    }
    label666:
    label686:
    label728:
    for (Object localObject1 = "是";; localObject1 = "否")
    {
      ((StringBuilder)localObject2).append((String)localObject1).append("\r\n");
      if ((!localSwiftBrowserStatistics.s) && (SwiftBrowserStatistics.o))
      {
        localStringBuilder.append("预加载进程响应耗时:").append(SwiftBrowserStatistics.z).append("ms.\r\n");
        localStringBuilder.append("预加载默认处理耗时:").append(SwiftBrowserStatistics.A).append("ms.\r\n");
        localStringBuilder.append("预加载完全处理耗时:").append(SwiftBrowserStatistics.B).append("ms.\r\n");
        localStringBuilder.append("预加载X5环境处理耗时:").append(SwiftBrowserStatistics.C).append("ms.\r\n");
        localStringBuilder.append("预创建WebView处理耗时:").append(SwiftBrowserStatistics.D).append("ms.\r\n");
        localStringBuilder.append("预热WebView处理耗时:").append(SwiftBrowserStatistics.E).append("ms.\r\n");
        localStringBuilder.append("预创建BrowserView处理耗时:").append(SwiftBrowserStatistics.F).append("ms.\r\n");
      }
      localStringBuilder.append("点击响应打点:").append(localSwiftBrowserStatistics.c - localSwiftBrowserStatistics.b).append("ms.\r\n");
      localStringBuilder.append("终端处理打点:").append(localSwiftBrowserStatistics.n - localSwiftBrowserStatistics.b).append("ms.\r\n");
      localStringBuilder.append("资源加载打点:").append(localSwiftBrowserStatistics.G).append("ms.\r\n");
      localStringBuilder.append("主资源首行打点:").append(localSwiftBrowserStatistics.H).append("ms.\r\n");
      localStringBuilder.append("首屏可见打点:").append(localSwiftBrowserStatistics.I).append("ms.\r\n");
      localStringBuilder.append("首屏可交互打点:").append(localSwiftBrowserStatistics.J).append("ms.\r\n");
      localObject1 = localStringBuilder.toString();
      localObject2 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 230);
      ((QQCustomDialog)localObject2).setContentView(2130968852);
      ((QQCustomDialog)localObject2).getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
      ((QQCustomDialog)localObject2).setTitle("WebView耗时统计(仅支持非外发版本)");
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
      ((QQCustomDialog)localObject2).getMessageTextView().setMaxLines(20);
      ((QQCustomDialog)localObject2).getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
      ((QQCustomDialog)localObject2).setPositiveButton("Close", new akop(this));
      ((QQCustomDialog)localObject2).setNegativeButton("Copy", new akoq(this, (String)localObject1));
      ((QQCustomDialog)localObject2).show();
      return;
      if (SwiftBrowserStatistics.o)
      {
        localObject1 = "热启动";
        break;
      }
      localObject1 = "冷启动";
      break;
      localObject1 = "否";
      break label126;
      localObject1 = "Sonic首次加载";
      break label198;
      localObject1 = "Sonic模板变更";
      break label198;
      localObject1 = "Sonic数据更新";
      break label198;
      localObject1 = "Sonic完全缓存";
      break label198;
      localObject1 = "否";
      break label233;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (7 == paramInt)
    {
      c();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper
 * JD-Core Version:    0.7.0.1
 */