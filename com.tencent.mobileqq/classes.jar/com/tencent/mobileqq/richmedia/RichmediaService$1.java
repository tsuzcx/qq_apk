package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import azzf;
import azzi;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      azzf localazzf = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Azzf;
      if (localazzf != null) {
        try
        {
          azzi.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localazzf.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          azzi.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          azzi.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      azzi.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    azzi.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */