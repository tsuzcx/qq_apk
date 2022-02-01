package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class InitHwEngineValue
{
  @ConfigInject(configPath="Foundation/Transfile/src/main/resources/Inject_InitHwEngineConfig.yml", version=1)
  public static ArrayList<Class<? extends IHwEngineValue>> getEngineValue = new ArrayList();
  public int localId;
  public boolean switchIpv6;
  
  static
  {
    getEngineValue.add(InitHwEngineImp.class);
  }
  
  public InitHwEngineValue()
  {
    try
    {
      IHwEngineValue localIHwEngineValue = (IHwEngineValue)((Class)getEngineValue.get(0)).newInstance();
      this.localId = localIHwEngineValue.getLocaleId();
      this.switchIpv6 = localIHwEngineValue.getIpv6Switch();
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      localIndexOutOfBoundsException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.InitHwEngineValue
 * JD-Core Version:    0.7.0.1
 */