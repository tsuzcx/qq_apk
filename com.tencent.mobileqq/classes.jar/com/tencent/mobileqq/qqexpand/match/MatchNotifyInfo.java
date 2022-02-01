package com.tencent.mobileqq.qqexpand.match;

public class MatchNotifyInfo
{
  public String a;
  public String b;
  public boolean c = true;
  public int d = -1;
  public int e;
  public long f;
  public int g;
  public int h;
  public String i;
  public long j;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{SenderUin: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    localStringBuilder.append("{SenderNickName: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    localStringBuilder.append("{bEnter: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    localStringBuilder.append("{leaveChatType: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    localStringBuilder.append("{leftChatTime: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    localStringBuilder.append("{timeStamp: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    localStringBuilder.append("{matchExpired: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    localStringBuilder.append("{c2cExpiredTime: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    localStringBuilder.append("{tipsWording: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("}");
    localStringBuilder.append("{readyTs: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.MatchNotifyInfo
 * JD-Core Version:    0.7.0.1
 */