package com.tencent.qqmini.sdk.widget;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;

class AuthDialog$8$1
  implements Runnable
{
  AuthDialog$8$1(AuthDialog.8 param8, INTERFACE.StSubscribeMessage paramStSubscribeMessage) {}
  
  public void run()
  {
    if (this.a != null) {
      if ((AuthDialog.access$1100(this.b.a) != 3) && (AuthDialog.access$1100(this.b.a) != 4))
      {
        if (AuthDialog.access$1100(this.b.a) == 5)
        {
          AuthDialog.access$1202(this.b.a, this.a);
          AuthDialog.access$1400(this.b.a);
        }
      }
      else
      {
        AuthDialog.access$1202(this.b.a, this.a);
        AuthDialog.access$1300(this.b.a);
      }
    }
    this.b.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDialog.8.1
 * JD-Core Version:    0.7.0.1
 */