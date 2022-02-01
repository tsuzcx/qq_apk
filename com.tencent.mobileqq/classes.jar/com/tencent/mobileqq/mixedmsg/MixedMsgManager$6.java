package com.tencent.mobileqq.mixedmsg;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;

final class MixedMsgManager$6
  implements Runnable
{
  MixedMsgManager$6(MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    ((IPicHelper)QRoute.api(IPicHelper.class)).cachePicToDisk(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.6
 * JD-Core Version:    0.7.0.1
 */