package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import axnj;
import axnm;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      axnj localaxnj = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Axnj;
      if (localaxnj != null) {
        try
        {
          axnm.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localaxnj.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          axnm.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          axnm.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      axnm.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    axnm.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */