package cooperation.plugin;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;

public class PluginBaseActivity
  extends BasePluginActivity
{
  public boolean t = true;
  
  protected String a()
  {
    return getString(2131625011);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public int g()
  {
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity
 * JD-Core Version:    0.7.0.1
 */