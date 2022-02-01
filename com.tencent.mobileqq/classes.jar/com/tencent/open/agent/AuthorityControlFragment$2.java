package com.tencent.open.agent;

import android.os.Message;
import java.util.List;
import mqq.os.MqqHandler;

class AuthorityControlFragment$2
  extends MqqHandler
{
  AuthorityControlFragment$2(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (List)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.size() > 0)) {
        AuthorityControlFragment.a(this.a, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment.2
 * JD-Core Version:    0.7.0.1
 */