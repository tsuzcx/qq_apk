package cooperation.jtcode;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class JtcodeProxyActivity
  extends PluginProxyActivity
{
  public static Class a(String paramString)
  {
    if ("com.tencent.mobileqq.wlx.activity.BlankActivity".equals(paramString)) {
      return JtcodeTranslucentProxyActivity.class;
    }
    return JtcodeProxyActivity.class;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.jtcode.JtcodeProxyActivity
 * JD-Core Version:    0.7.0.1
 */