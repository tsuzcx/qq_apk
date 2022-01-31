package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import avrc;
import avrf;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      avrc localavrc = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Avrc;
      if (localavrc != null) {
        try
        {
          avrf.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localavrc.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          avrf.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          avrf.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      avrf.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    avrf.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */