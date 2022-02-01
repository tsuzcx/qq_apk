package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.CommentAnchor;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import java.util.List;

class ReadInJoyCommentListFragment$4
  implements ReadInJoyCommentDataManager.OnCommentListLoadListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  ReadInJoyCommentListFragment$4(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyCommentListFragment", 1, "onCommentListLoad anchor");
    if (!paramBoolean1) {
      return;
    }
    paramList = ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment).a().a();
    if (paramList != null)
    {
      if (!TextUtils.isEmpty(paramList.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.f();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(true, paramList.a, paramList.b);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.f();
      }
      paramList.a(false);
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramInt == 1001) {
      QRUtils.a(1, 2131717799);
    }
    if (paramInt == 1003) {
      QRUtils.a(1, 2131717809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.4
 * JD-Core Version:    0.7.0.1
 */