package com.tencent.mobileqq.extendfriend;

import arhi;
import arhq;
import com.tencent.mobileqq.app.soso.LbsManagerService;

public class ExtendFriendManager$9
  implements Runnable
{
  public ExtendFriendManager$9(arhi paramarhi) {}
  
  public void run()
  {
    LbsManagerService.startLocation(new arhq(this, "extend_friend", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.9
 * JD-Core Version:    0.7.0.1
 */