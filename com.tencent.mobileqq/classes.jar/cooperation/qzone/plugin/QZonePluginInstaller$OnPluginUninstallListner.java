package cooperation.qzone.plugin;

abstract interface QZonePluginInstaller$OnPluginUninstallListner
{
  public abstract void onUnInstallBegin(PluginRecord paramPluginRecord);
  
  public abstract void onUnInstallFinish(boolean paramBoolean, PluginRecord paramPluginRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginInstaller.OnPluginUninstallListner
 * JD-Core Version:    0.7.0.1
 */