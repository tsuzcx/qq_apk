package com.tencent.mobileqq.extendfriend;

import aslo;
import aslw;
import com.tencent.mobileqq.app.soso.LbsManagerService;

public class ExtendFriendManager$9
  implements Runnable
{
  public ExtendFriendManager$9(aslo paramaslo) {}
  
  public void run()
  {
    LbsManagerService.startLocation(new aslw(this, "extend_friend", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.9
 * JD-Core Version:    0.7.0.1
 */