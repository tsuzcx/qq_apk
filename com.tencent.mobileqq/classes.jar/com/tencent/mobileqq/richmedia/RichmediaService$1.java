package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;
import bbed;
import bbeg;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      bbed localbbed = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_Bbed;
      if (localbbed != null) {
        try
        {
          bbeg.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localbbed.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          bbeg.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          bbeg.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      bbeg.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    bbeg.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */