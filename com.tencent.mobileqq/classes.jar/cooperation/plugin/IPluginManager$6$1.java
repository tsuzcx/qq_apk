package cooperation.plugin;

import com.tencent.mobileqq.qshadow.interfaces.IPluginOpenListener;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;

class IPluginManager$6$1
  implements IPluginOpenListener
{
  IPluginManager$6$1(IPluginManager.6 param6, IPluginManager.PluginParams paramPluginParams) {}
  
  public void a(boolean paramBoolean, QShadowLoadInfo paramQShadowLoadInfo)
  {
    PluginReporter.a(this.a, paramQShadowLoadInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6.1
 * JD-Core Version:    0.7.0.1
 */