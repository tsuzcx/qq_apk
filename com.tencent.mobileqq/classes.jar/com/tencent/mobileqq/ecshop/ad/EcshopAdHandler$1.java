package com.tencent.mobileqq.ecshop.ad;

import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

class EcshopAdHandler$1
  implements Runnable
{
  EcshopAdHandler$1(EcshopAdHandler paramEcshopAdHandler) {}
  
  public void run()
  {
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(MobileQQ.getContext(), new InitGdtContextParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdHandler.1
 * JD-Core Version:    0.7.0.1
 */