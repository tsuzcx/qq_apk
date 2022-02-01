package dualsim.common;

public abstract interface IKcActivationInterface
{
  public abstract void clearCallback();
  
  public abstract String getActivationUrl();
  
  public abstract boolean onJsConfirm(String paramString1, String paramString2);
  
  public abstract void setCallback(IKcActivationInterface.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dualsim.common.IKcActivationInterface
 * JD-Core Version:    0.7.0.1
 */