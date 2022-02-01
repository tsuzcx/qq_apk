package dov.com.tencent.mobileqq.activity.shortvideo;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoPlayActivity$13
  implements Runnable
{
  ShortVideoPlayActivity$13(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    this.this$0.a.serial();
    this.this$0.app.getMessageFacade().updateMsgContentByUniseq(this.this$0.a.frienduin, this.this$0.a.istroop, this.this$0.a.uniseq, this.this$0.a.msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.13
 * JD-Core Version:    0.7.0.1
 */