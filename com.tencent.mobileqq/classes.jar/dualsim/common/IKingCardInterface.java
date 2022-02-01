package dualsim.common;

import android.content.Context;

public abstract interface IKingCardInterface
{
  public abstract IKcActivationInterface generateActivationInterface(Context paramContext);
  
  public abstract IKcActivationViewer generateActivationView(Context paramContext);
  
  public abstract String getGuid();
  
  public abstract OrderCheckResult getResult();
  
  public abstract void registerOnChangeListener(IKingCardInterface.OnChangeListener paramOnChangeListener);
  
  public abstract void unRegisterOnChangeListener(IKingCardInterface.OnChangeListener paramOnChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dualsim.common.IKingCardInterface
 * JD-Core Version:    0.7.0.1
 */