package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PluginIntent
  extends NewIntent
{
  public ArrayList<UPDATE_INFO> module_update_infos;
  PluginIntent.OnResultListner onResultListner;
  public ArrayList<UPDATE_INFO> update_infos;
  
  public PluginIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public PluginIntent.OnResultListner getResultListner()
  {
    return this.onResultListner;
  }
  
  public void setResultListner(PluginIntent.OnResultListner paramOnResultListner)
  {
    this.onResultListner = paramOnResultListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginIntent
 * JD-Core Version:    0.7.0.1
 */