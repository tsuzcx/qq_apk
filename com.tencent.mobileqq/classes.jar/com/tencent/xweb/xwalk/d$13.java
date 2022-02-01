package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.xwalk.core.XWalkEnvironment;

class d$13
  implements View.OnClickListener
{
  d$13(d paramd, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    String str = XWalkEnvironment.getPluginTestConfigUrl();
    if ((str != null) && (!str.isEmpty()))
    {
      if (XWalkEnvironment.setPluginTestConfigUrl("")) {
        this.a.setText("切换插件配置，当前使用正式版");
      } else {
        this.b.b("切换失败", true);
      }
    }
    else if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
      this.a.setText("切换插件配置，当前使用默认测试版");
    } else {
      this.b.b("切换失败", true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.13
 * JD-Core Version:    0.7.0.1
 */