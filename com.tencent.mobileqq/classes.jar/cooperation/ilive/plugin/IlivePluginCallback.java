package cooperation.ilive.plugin;

public abstract interface IlivePluginCallback
{
  public abstract void onPluginActivityCreate();
  
  public abstract void onPluginLoginFail(int paramInt, String paramString);
  
  public abstract void onPluginLoginStart();
  
  public abstract void onPluginLoginSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.plugin.IlivePluginCallback
 * JD-Core Version:    0.7.0.1
 */