package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;
import java.util.Set;

public class TroopBatchAddFrdsMultipleSearchEngine
  extends ContactSearchEngine
{
  private Comparator<IContactSearchModel> d = new TroopBatchAddFrdsMultipleSearchEngine.1(this);
  
  public TroopBatchAddFrdsMultipleSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramSet);
  }
  
  private boolean c(String paramString)
  {
    return ((IFriendDataService)this.b.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString);
  }
  
  private boolean d(String paramString)
  {
    return ((IAddFriendServiceApi)this.b.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, false);
  }
  
  public Comparator<IContactSearchModel> f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsMultipleSearchEngine
 * JD-Core Version:    0.7.0.1
 */