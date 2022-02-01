package com.tencent.mobileqq.kandian.repo.feeds.pts;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class ReadInJoyProteusFamilyUtil$3
  implements WtTicketPromise
{
  ReadInJoyProteusFamilyUtil$3(TicketManager paramTicketManager, QQAppInterface paramQQAppInterface) {}
  
  public void Done(Ticket paramTicket)
  {
    int i;
    if (paramTicket == null) {
      i = 1;
    } else if ((paramTicket != null) && (paramTicket._pskey_map == null)) {
      i = 2;
    } else if ((paramTicket != null) && (paramTicket._pskey_map != null) && (paramTicket._pskey_map.get("m.tencent.com") == null)) {
      i = 3;
    } else {
      i = 0;
    }
    paramTicket = ReadInJoyProteusFamilyUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPskeyFromServerAndRetry get pskey from server : Done, result: ");
    localStringBuilder.append(i);
    QLog.i(paramTicket, 1, localStringBuilder.toString());
    ReadInJoyProteusFamilyUtil.a(this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "m.tencent.com"));
    if ((!TextUtils.isEmpty(ReadInJoyProteusFamilyUtil.b())) && (ReadInJoyProteusFamilyUtil.b().length() > 0)) {
      QLog.i(ReadInJoyProteusFamilyUtil.a(), 1, "getPskeyFromServerAndRetry get pskey from server success!");
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    String str = ReadInJoyProteusFamilyUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPskeyFromServerAndRetry get pskey from server : Failed, ");
    localStringBuilder.append(paramErrMsg);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    String str = ReadInJoyProteusFamilyUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPskeyFromServerAndRetry get pskey from server : Timeout, ");
    localStringBuilder.append(paramErrMsg);
    QLog.i(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil.3
 * JD-Core Version:    0.7.0.1
 */