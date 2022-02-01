package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactBinedSearchEngine
  extends ContactSearchEngine
{
  private Comparator<IContactSearchModel> a;
  
  public PhoneContactBinedSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramSet);
    this.jdField_a_of_type_JavaUtilComparator = new PhoneContactBinedSearchEngine.1(this);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public Comparator<IContactSearchModel> a()
  {
    return this.jdField_a_of_type_JavaUtilComparator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.PhoneContactBinedSearchEngine
 * JD-Core Version:    0.7.0.1
 */