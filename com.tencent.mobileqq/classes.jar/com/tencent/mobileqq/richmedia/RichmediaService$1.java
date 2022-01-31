package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import axja;
import axjd;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      axja localaxja = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Axja;
      if (localaxja != null) {
        try
        {
          axjd.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localaxja.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          axjd.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          axjd.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      axjd.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    axjd.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */