package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHandlerNameApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameMsgSayHelloRules
  extends GameMsgStrangerRules
{
  protected List<ChatMessage> a;
  protected int b;
  private boolean c = false;
  private String k;
  private String l;
  private int m;
  
  public GameMsgSayHelloRules(int paramInt1, AppInterface paramAppInterface, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, List<ChatMessage> paramList)
  {
    super(paramAppInterface, paramString1, paramInt2);
    QLog.i("GameMsgRules.Stranger", 1, "[GameMsgSayHelloRules]");
    this.m = paramInt1;
    this.a = paramList;
    this.b = paramInt3;
    this.k = paramString2;
    this.l = paramString3;
    d();
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.b != 0) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
      return;
    }
    if (paramMessageRecord.issend != 1)
    {
      this.d = false;
      return;
    }
    c();
  }
  
  public boolean b()
  {
    if (this.b != 0) {
      return true;
    }
    if (!this.d) {
      return true;
    }
    return super.b();
  }
  
  public void c()
  {
    if (this.b != 0) {
      return;
    }
    if (!this.d) {
      return;
    }
    super.c();
    this.d = false;
    e();
  }
  
  protected void d()
  {
    if (this.b != 0)
    {
      this.d = false;
      return;
    }
    Object localObject = this.a;
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      i = this.a.size() - 1;
    }
    while (i >= 0)
    {
      localObject = (ChatMessage)this.a.get(i);
      if ((localObject != null) && (!(localObject instanceof MessageForUniteGrayTip)) && (GameMsgUtil.a(((ChatMessage)localObject).time * 1000L)))
      {
        this.d = false;
        return;
      }
      i -= 1;
      continue;
      this.d = true;
      this.c = true;
    }
  }
  
  protected void e()
  {
    if ((this.c) && (this.h != null))
    {
      QLog.i("GameMsgRules.Stranger", 1, "ask server to push hello tips");
      ((GameCenterUnissoHandler)this.h.getBusinessHandler(((IGameMsgHandlerNameApi)QRoute.api(IGameMsgHandlerNameApi.class)).getGameMsgHandlerName())).a(this.m, 3, this.k, this.l, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgSayHelloRules
 * JD-Core Version:    0.7.0.1
 */