package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.remote.ToServiceMsg;

class RIJCommentInLikeFeedMasterDeliverHandler$1
  implements Runnable
{
  RIJCommentInLikeFeedMasterDeliverHandler$1(RIJCommentInLikeFeedMasterDeliverHandler paramRIJCommentInLikeFeedMasterDeliverHandler, ToServiceMsg paramToServiceMsg, int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("up_master_deliver_uuid").toString(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedMasterDeliverHandler.1
 * JD-Core Version:    0.7.0.1
 */