package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;

public class CommentContentView
  extends TextBase
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private NativeCommentTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView;
  
  public CommentContentView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView = new NativeCommentTextView(paramVafContext.getContext());
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.setModel(paramReadinjoyCommentListBaseAdapter, paramView, paramInt);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.setTextSize(0, b * CommentProteusUtil.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.setTextColor(jdField_a_of_type_Int);
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 1059) && ((paramObject instanceof CommentViewItem)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView.setCommentModel((CommentViewItem)paramObject);
      return true;
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentContentView
 * JD-Core Version:    0.7.0.1
 */