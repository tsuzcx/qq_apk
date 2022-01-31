package cooperation.qzone.plugin;

import android.content.Context;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class PluginIntent
  extends NewIntent
{
  PluginIntent.OnResultListner a;
  public ArrayList a;
  public ArrayList b;
  
  public PluginIntent(Context paramContext, Class paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public PluginIntent.OnResultListner a()
  {
    return this.a;
  }
  
  public void a(PluginIntent.OnResultListner paramOnResultListner)
  {
    this.a = paramOnResultListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginIntent
 * JD-Core Version:    0.7.0.1
 */