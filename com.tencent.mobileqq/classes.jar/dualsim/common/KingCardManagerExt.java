package dualsim.common;

import android.content.Context;
import tmsdk.common.KcSdkShellManager;

public class KingCardManagerExt
  implements IKingCardInterface
{
  private static KingCardManagerExt sInstance;
  
  public static IKingCardInterface getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new KingCardManagerExt();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public IKcActivationInterface generateActivationInterface(Context paramContext)
  {
    try
    {
      IKingCardInterface localIKingCardInterface = KcSdkShellManager.getInstance().getKingCardInterface();
      if (localIKingCardInterface != null)
      {
        paramContext = localIKingCardInterface.generateActivationInterface(paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  public IKcActivationViewer generateActivationView(Context paramContext)
  {
    try
    {
      IKingCardInterface localIKingCardInterface = KcSdkShellManager.getInstance().getKingCardInterface();
      if (localIKingCardInterface != null)
      {
        paramContext = localIKingCardInterface.generateActivationView(paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  public String getGuid()
  {
    try
    {
      Object localObject = KcSdkShellManager.getInstance().getKingCardInterface();
      if (localObject != null)
      {
        localObject = ((IKingCardInterface)localObject).getGuid();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      label20:
      break label20;
    }
    return "";
  }
  
  public OrderCheckResult getResult()
  {
    try
    {
      Object localObject = KcSdkShellManager.getInstance().getKingCardInterface();
      if (localObject != null)
      {
        localObject = ((IKingCardInterface)localObject).getResult();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      label20:
      break label20;
    }
    return null;
  }
  
  public void registerOnChangeListener(IKingCardInterface.OnChangeListener paramOnChangeListener)
  {
    try
    {
      IKingCardInterface localIKingCardInterface = KcSdkShellManager.getInstance().getKingCardInterface();
      if (localIKingCardInterface == null) {
        return;
      }
      localIKingCardInterface.registerOnChangeListener(paramOnChangeListener);
      return;
    }
    catch (Throwable paramOnChangeListener) {}
  }
  
  public void unRegisterOnChangeListener(IKingCardInterface.OnChangeListener paramOnChangeListener)
  {
    try
    {
      IKingCardInterface localIKingCardInterface = KcSdkShellManager.getInstance().getKingCardInterface();
      if (localIKingCardInterface == null) {
        return;
      }
      localIKingCardInterface.unRegisterOnChangeListener(paramOnChangeListener);
      return;
    }
    catch (Throwable paramOnChangeListener) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dualsim.common.KingCardManagerExt
 * JD-Core Version:    0.7.0.1
 */