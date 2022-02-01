package com.tencent.mobileqq.kandian.biz.framework;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.TraceUtils;

class ReadInJoyBaseAdapter$1
  extends HandlerTask
{
  ReadInJoyBaseAdapter$1(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, String paramString, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(IBaseHandler paramIBaseHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyBaseAdapter.Viewtype ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    TraceUtils.traceBegin(localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(this.jdField_a_of_type_Int)) {
      if ((ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.c != 56))
      {
        if ((paramIBaseHandler instanceof FrameworkHandler)) {}
      }
      else if ((paramIBaseHandler instanceof FrameworkHandler)) {
        return;
      }
    }
    if (paramIBaseHandler.a(this.jdField_a_of_type_Int))
    {
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangObject = paramIBaseHandler.a(this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
      long l2 = System.currentTimeMillis();
      if (FluencyOptUtils.a.a()) {
        ThreadManager.excute(new ReadInJoyBaseAdapter.1.1(this, l2 - l1, paramIBaseHandler), 128, null, true);
      }
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */