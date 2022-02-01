package com.tencent.mobileqq.servlet;

public class GameCenterManagerImp$UnreadData
{
  public long a = 0L;
  public boolean b = false;
  public String c = "";
  public String d = "";
  public boolean e = false;
  public boolean f = false;
  public int g = 0;
  
  public GameCenterManagerImp$UnreadData(GameCenterManagerImp paramGameCenterManagerImp) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mUnread=");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mNewMsg=");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mText=");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mIconPath=");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mRedPoint=");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mTab=");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mType=");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp.UnreadData
 * JD-Core Version:    0.7.0.1
 */