package com.tencent.open.agent;

import java.util.ArrayList;

class OpenSdkFriendService$GetFriendListCallback$1
  implements Runnable
{
  OpenSdkFriendService$GetFriendListCallback$1(OpenSdkFriendService.GetFriendListCallback paramGetFriendListCallback, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    if ("action_invite".equals(this.c.b.j))
    {
      this.c.b.a(this.a);
      this.c.b.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback.1
 * JD-Core Version:    0.7.0.1
 */