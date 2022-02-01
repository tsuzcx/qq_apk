package com.tencent.mobileqq.kandian.biz.feeds;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.TraceUtils;

class ReadInJoyProteusFamilyAdapter$2
  extends HandlerTask
{
  ReadInJoyProteusFamilyAdapter$2(ReadInJoyProteusFamilyAdapter paramReadInJoyProteusFamilyAdapter, String paramString, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(IBaseHandler paramIBaseHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyBaseAdapter.Viewtype ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    TraceUtils.traceBegin(localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.a(this.jdField_a_of_type_Int)) {
      if ((ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (ReadInJoyProteusFamilyAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter) != 56))
      {
        if ((paramIBaseHandler instanceof FrameworkHandler)) {}
      }
      else if ((paramIBaseHandler instanceof FrameworkHandler)) {
        return;
      }
    }
    if (paramIBaseHandler.a(this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaLangObject = paramIBaseHandler.a(this.b, null, this.jdField_a_of_type_AndroidViewViewGroup);
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyAdapter.2
 * JD-Core Version:    0.7.0.1
 */