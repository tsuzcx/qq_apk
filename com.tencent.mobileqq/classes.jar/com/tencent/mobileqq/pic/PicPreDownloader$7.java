package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;

class PicPreDownloader$7
  implements Runnable
{
  PicPreDownloader$7(PicPreDownloader paramPicPreDownloader, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    ((IMsgStructing)QRoute.api(IMsgStructing.class)).consumeStructMsgPicPre(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.7
 * JD-Core Version:    0.7.0.1
 */