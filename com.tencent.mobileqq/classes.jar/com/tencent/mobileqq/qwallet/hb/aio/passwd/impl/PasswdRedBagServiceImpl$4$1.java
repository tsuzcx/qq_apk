package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import Wallet.BroadCastInfo;
import Wallet.GetBroadCastHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.observer.BusinessObserver;

class PasswdRedBagServiceImpl$4$1
  implements BusinessObserver
{
  PasswdRedBagServiceImpl$4$1(PasswdRedBagServiceImpl.4 param4) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 28)
    {
      paramBundle = (GetBroadCastHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (paramBundle == null) {
        return;
      }
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl.isFirstInAio = false;
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          BroadCastInfo localBroadCastInfo = (BroadCastInfo)paramBundle.sendlistIdiomInfoDict.get(str);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl.getPasswdRedBagInfoById(str) != null) && (localBroadCastInfo != null)) {
            if (localBroadCastInfo.isFinished == 1) {
              this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl.setPasswdRedBagFinish(str);
            } else {
              this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl.updateIdiomRedbagsLastword(str, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, localBroadCastInfo.idiomSeq, localBroadCastInfo.hbIdiom, localBroadCastInfo.hbIdiomLastPY, localBroadCastInfo.hbPoemRule);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.4.1
 * JD-Core Version:    0.7.0.1
 */