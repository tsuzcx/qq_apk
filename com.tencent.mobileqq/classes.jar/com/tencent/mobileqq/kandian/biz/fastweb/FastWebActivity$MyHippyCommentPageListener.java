package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.comment.HippyCommentPageListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$MyHippyCommentPageListener
  implements HippyCommentPageListener
{
  private final int jdField_a_of_type_Int;
  
  FastWebActivity$MyHippyCommentPageListener(FastWebActivity paramFastWebActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if (FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity) == null) {
      return;
    }
    if (paramBoolean)
    {
      QLog.d("FastWebActivity", 1, "hippy init success");
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).setTuWenHippyCallback(new FastWebActivity.TKDTuWenHippyCallback(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, null));
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).setOnOpenCommentEditListener(new FastWebActivity.MyOpenCommentEditListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, null));
      FastWebActivity.s(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).a(null);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).getTKDHippyEventDispatcher().register(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).getSubHippyEventReceiver());
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).getTKDHippyEventDispatcher().register(new FastWebActivity.MySubCommentHippyEventListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, null));
      return;
    }
    QLog.d("FastWebActivity", 1, "hippy init fail");
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).b(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity));
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).destroy();
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, null);
    FastWebActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, this.jdField_a_of_type_Int);
    FastWebActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.MyHippyCommentPageListener
 * JD-Core Version:    0.7.0.1
 */