package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;

class MatchingStateHandler$1
  implements Runnable
{
  MatchingStateHandler$1(MatchingStateHandler paramMatchingStateHandler) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.a(100, null);
      if (this.this$0.a.d != null)
      {
        String str;
        if ((this.this$0.b != null) && (this.this$0.b.g != null)) {
          str = this.this$0.b.g;
        } else {
          str = "";
        }
        this.this$0.a.d.a(0, this.this$0.b, str, "");
      }
      MatchingStateHandler.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */