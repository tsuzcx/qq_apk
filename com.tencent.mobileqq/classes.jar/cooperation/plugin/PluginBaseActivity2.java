package cooperation.plugin;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.b) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131166957));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity2
 * JD-Core Version:    0.7.0.1
 */