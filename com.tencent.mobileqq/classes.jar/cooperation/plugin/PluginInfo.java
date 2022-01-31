package cooperation.plugin;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;

public class PluginInfo
  extends PluginBaseInfo
  implements Cloneable
{
  int a;
  
  public PluginInfo a()
  {
    return (PluginInfo)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginInfo
 * JD-Core Version:    0.7.0.1
 */