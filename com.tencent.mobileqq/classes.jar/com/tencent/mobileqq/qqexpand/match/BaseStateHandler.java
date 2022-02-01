package com.tencent.mobileqq.qqexpand.match;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class BaseStateHandler
{
  LimitChatProtoStateMachine a;
  MatchInfo b = new MatchInfo();
  private int c = -1;
  
  BaseStateHandler(LimitChatProtoStateMachine paramLimitChatProtoStateMachine, int paramInt)
  {
    this.a = paramLimitChatProtoStateMachine;
    this.b.a();
    this.c = paramInt;
  }
  
  void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateHandlerType : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" cancelMatch in wrong state!!");
    QLog.i("ExtendFriendLimitChat", 2, localStringBuilder.toString());
  }
  
  void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateHandlerType : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" requestMatch in wrong state!! id:");
    localStringBuilder.append(paramInt);
    QLog.i("ExtendFriendLimitChat", 2, localStringBuilder.toString());
  }
  
  public void a(MatchInfo paramMatchInfo)
  {
    this.b.a = paramMatchInfo.a;
    this.b.b = paramMatchInfo.b;
    this.b.c = paramMatchInfo.c;
    this.b.d = paramMatchInfo.d;
    this.b.e = paramMatchInfo.e;
    this.b.f = paramMatchInfo.f;
    this.b.h = paramMatchInfo.h;
    this.b.i = paramMatchInfo.i;
    this.b.j = paramMatchInfo.j;
    this.b.k = paramMatchInfo.k;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId UIN IS EMPTY");
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId algorithmId IS EMPTY");
      str = "0";
    }
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.1(this, paramString1, str));
  }
  
  protected void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.a.c.getMsgCache().b(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateHandlerType : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" onCScancelMatchMsg in wrong state!! ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendLimitChat", 2, localStringBuilder.toString());
  }
  
  void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    paramMatchInfo = new StringBuilder();
    paramMatchInfo.append("StateHandlerType : ");
    paramMatchInfo.append(this.c);
    paramMatchInfo.append(" onCSRequestMsg in wrong state!!");
    QLog.i("ExtendFriendLimitChat", 2, paramMatchInfo.toString());
  }
  
  void a(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    paramMatchInfo = new StringBuilder();
    paramMatchInfo.append("StateHandlerType : ");
    paramMatchInfo.append(this.c);
    paramMatchInfo.append(" onPushMsg in wrong state!!");
    QLog.i("ExtendFriendLimitChat", 2, paramMatchInfo.toString());
  }
  
  public void b()
  {
    this.b.a();
  }
  
  public void b(MatchInfo paramMatchInfo)
  {
    this.b.a();
    if (paramMatchInfo != null) {
      a(paramMatchInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.BaseStateHandler
 * JD-Core Version:    0.7.0.1
 */