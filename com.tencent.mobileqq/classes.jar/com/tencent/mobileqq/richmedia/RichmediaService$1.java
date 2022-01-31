package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import avra;
import avrd;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      avra localavra = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Avra;
      if (localavra != null) {
        try
        {
          avrd.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localavra.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          avrd.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          avrd.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      avrd.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    avrd.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */