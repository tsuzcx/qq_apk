package cooperation.plugin;

import Override;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class PluginBaseActivity2
  extends BasePluginActivity
{
  public SystemBarCompact a;
  public boolean a;
  public boolean b = true;
  
  public PluginBaseActivity2()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.b) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131167048));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity2
 * JD-Core Version:    0.7.0.1
 */