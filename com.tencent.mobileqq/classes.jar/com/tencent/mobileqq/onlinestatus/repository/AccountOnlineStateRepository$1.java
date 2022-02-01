package com.tencent.mobileqq.onlinestatus.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusResult;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.relation.api.ICardHandler.AutoReplyInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AccountOnlineStateRepository$1
  implements ICardHandler.AutoReplyInterface
{
  AccountOnlineStateRepository$1(AccountOnlineStateRepository paramAccountOnlineStateRepository) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetAutoReplyList, isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AccountOnlineStateRepository", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(true, true));
      return;
    }
    AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(false, -2));
  }
  
  public void a(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateRepository", 2, String.format("onGetAutoReplyList, isSuccess: %s, selectId: %s, replyList: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
    }
    AccountOnlineStateRepository.a(this.a).a(paramBoolean, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository.1
 * JD-Core Version:    0.7.0.1
 */