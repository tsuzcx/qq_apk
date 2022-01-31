package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import mqq.manager.Manager;

public class DatingProxyManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StrangerHdHeadUrlFetcher jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher;
  private VoteEventMgr jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public DatingProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public StrangerHdHeadUrlFetcher a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher = new StrangerHdHeadUrlFetcher(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      StrangerHdHeadUrlFetcher localStrangerHdHeadUrlFetcher = this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher;
      return localStrangerHdHeadUrlFetcher;
    }
  }
  
  public VoteEventMgr a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr = new VoteEventMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      VoteEventMgr localVoteEventMgr = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr;
      return localVoteEventMgr;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.a();
      this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingProxyManager
 * JD-Core Version:    0.7.0.1
 */