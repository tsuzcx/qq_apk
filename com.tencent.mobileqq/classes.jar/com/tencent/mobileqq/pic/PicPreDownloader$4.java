package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;

class PicPreDownloader$4
  implements Runnable
{
  PicPreDownloader$4(PicPreDownloader paramPicPreDownloader, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    ((IMsgStructing)QRoute.api(IMsgStructing.class)).consumeStructMsgPicPre(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */