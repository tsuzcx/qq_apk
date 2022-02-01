package cooperation.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PluginIphoneTitleBarActivity$1
  implements View.OnClickListener
{
  PluginIphoneTitleBarActivity$1(PluginIphoneTitleBarActivity paramPluginIphoneTitleBarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity.1
 * JD-Core Version:    0.7.0.1
 */