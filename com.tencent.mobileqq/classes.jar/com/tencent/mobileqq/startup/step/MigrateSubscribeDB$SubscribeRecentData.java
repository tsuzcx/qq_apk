package com.tencent.mobileqq.startup.step;

class MigrateSubscribeDB$SubscribeRecentData
{
  String a;
  String b;
  String c;
  long d;
  long e;
  long f;
  String g;
  String h;
  String i;
  int j;
  
  private MigrateSubscribeDB$SubscribeRecentData(MigrateSubscribeDB paramMigrateSubscribeDB) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSubscribeID: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" | mSubscribeName: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" | mLastMsg: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" | mLastMsgTime: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" | mLastMsgID: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" | mLastReorderTime: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" | mDraft: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" | mDraftTime: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" | mSubscribeHeadUrl: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" | mUnreadCount: ");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB.SubscribeRecentData
 * JD-Core Version:    0.7.0.1
 */