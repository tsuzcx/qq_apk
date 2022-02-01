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
  protected int a;
  private String a;
  protected List<ChatMessage> a;
  private boolean b = false;
  private String c;
  
  public GameMsgSayHelloRules(AppInterface paramAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, List<ChatMessage> paramList)
  {
    super(paramAppInterface, paramString1, paramInt1);
    QLog.i("GameMsgRules.Stranger", 1, "[GameMsgSayHelloRules]");
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
      return;
    }
    if (paramMessageRecord.issend != 1)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    b();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return true;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    super.b();
    this.jdField_a_of_type_Boolean = false;
    d();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    while (i >= 0)
    {
      localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (!(localObject instanceof MessageForUniteGrayTip)) && (GameMsgUtil.a(((ChatMessage)localObject).time * 1000L)))
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      i -= 1;
      continue;
      this.jdField_a_of_type_Boolean = true;
      this.b = true;
    }
  }
  
  protected void d()
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      QLog.i("GameMsgRules.Stranger", 1, "ask server to push hello tips");
      ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((IGameMsgHandlerNameApi)QRoute.api(IGameMsgHandlerNameApi.class)).getGameMsgHandlerName())).a(3, this.jdField_a_of_type_JavaLangString, this.c, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgSayHelloRules
 * JD-Core Version:    0.7.0.1
 */