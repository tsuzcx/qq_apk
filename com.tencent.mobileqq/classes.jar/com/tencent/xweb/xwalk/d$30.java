package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.v;
import org.xwalk.core.XWalkEnvironment;

class d$30
  implements View.OnClickListener
{
  d$30(d paramd) {}
  
  public void onClick(View paramView)
  {
    XWalkEnvironment.setGrayValueForTest(1);
    if (!XWalkEnvironment.hasAvailableVersion())
    {
      if (XWalkEnvironment.isIaDevice()) {
        this.a.a("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
      } else {
        this.a.a("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
      }
    }
    else
    {
      v.a().a("tools", WebView.c.b);
      v.a().a("toolsmp", WebView.c.b);
      v.a().a("appbrand", WebView.c.b);
      v.a().a("support", WebView.c.b);
      v.a().a("mm", WebView.c.b);
      this.a.a("已使用XWeb，点任意位置重启进程生效\n", true, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.30
 * JD-Core Version:    0.7.0.1
 */