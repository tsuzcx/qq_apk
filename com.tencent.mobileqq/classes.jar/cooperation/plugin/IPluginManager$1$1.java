package cooperation.plugin;

import com.tencent.mobileqq.qshadow.interfaces.IPluginOpenListener;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;

class IPluginManager$1$1
  implements IPluginOpenListener
{
  IPluginManager$1$1(IPluginManager.1 param1, IPluginManager.PluginParams paramPluginParams) {}
  
  public void a(boolean paramBoolean, QShadowLoadInfo paramQShadowLoadInfo)
  {
    PluginReporter.a(this.a, paramQShadowLoadInfo, paramBoolean);
    if (this.b.a != null) {
      this.b.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.1.1
 * JD-Core Version:    0.7.0.1
 */