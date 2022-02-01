package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentDataManager$16
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  ReadInJoyCommentDataManager$16(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, String paramString, BaseCommentData paramBaseCommentData) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    if (paramCreateCommentResult.jdField_a_of_type_Long != -1L) {
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager).b(paramCreateCommentResult.jdField_a_of_type_Long, new Pair(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData));
    }
    if (paramCreateCommentResult.b) {
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager, paramCreateCommentResult);
    } else {
      ReadInJoyCommentDataManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager, paramCreateCommentResult);
    }
    if (!paramCreateCommentResult.jdField_a_of_type_Boolean) {
      RIJCommentNetworkHelper.a(paramCreateCommentResult.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.16
 * JD-Core Version:    0.7.0.1
 */