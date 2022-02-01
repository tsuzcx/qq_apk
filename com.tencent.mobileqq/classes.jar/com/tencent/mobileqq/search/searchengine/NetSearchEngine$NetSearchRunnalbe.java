package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.CountDownLatch;

class NetSearchEngine$NetSearchRunnalbe
  implements Runnable
{
  private int jdField_a_of_type_Int;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NetSearchEngine.NetSearchRunnalbe.1(this);
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private String jdField_a_of_type_JavaLangString;
  public CountDownLatch a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public NetSearchEngine$NetSearchRunnalbe(NetSearchEngine paramNetSearchEngine, String paramString, int[] paramArrayOfInt, int paramInt, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
    NetSearchEngine.a(this.this$0).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void run()
  {
    NetSearchEngine.a(this.this$0).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_Int);
    if (NetSearchEngine.a(this.this$0) == 12)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 1);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe
 * JD-Core Version:    0.7.0.1
 */