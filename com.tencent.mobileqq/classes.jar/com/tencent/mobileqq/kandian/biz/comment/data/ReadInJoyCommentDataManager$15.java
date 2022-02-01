package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentDataManager$15
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  ReadInJoyCommentDataManager$15(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, String paramString, SubCommentData paramSubCommentData) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    if (paramCreateCommentResult.jdField_a_of_type_Long != -1L) {
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager).b(paramCreateCommentResult.jdField_a_of_type_Long, new Pair(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentData));
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.15
 * JD-Core Version:    0.7.0.1
 */