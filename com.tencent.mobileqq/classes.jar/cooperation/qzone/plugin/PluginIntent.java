package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import bfzt;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PluginIntent
  extends NewIntent
{
  bfzt a;
  public ArrayList<UPDATE_INFO> a;
  public ArrayList<UPDATE_INFO> b;
  
  public PluginIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public bfzt a()
  {
    return this.a;
  }
  
  public void a(bfzt parambfzt)
  {
    this.a = parambfzt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginIntent
 * JD-Core Version:    0.7.0.1
 */