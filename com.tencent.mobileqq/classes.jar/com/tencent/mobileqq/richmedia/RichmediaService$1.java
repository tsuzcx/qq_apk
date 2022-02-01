package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import bbfo;
import bbfr;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      bbfo localbbfo = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Bbfo;
      if (localbbfo != null) {
        try
        {
          bbfr.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localbbfo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          bbfr.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          bbfr.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      bbfr.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    bbfr.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */