package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NativeCommentTextView
  extends ReadInJoyYAFolderTextView
  implements View.OnClickListener, View.OnLongClickListener, IView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
  private CommentViewItem jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
  private int b = -1;
  
  public NativeCommentTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public NativeCommentTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  private void b()
  {
    QLog.d("NativeCommentTextView", 2, "showAnchorAniation");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
    if (localObject != null)
    {
      if (((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor) {
        return;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        return;
      }
      QLog.d("NativeCommentTextView", 2, "showAnchorAniation start");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor = false;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
      localValueAnimator.setDuration(2400L);
      localValueAnimator.setStartDelay(600L);
      localValueAnimator.addUpdateListener(new NativeCommentTextView.1(this, (View)localObject));
      localValueAnimator.start();
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    if (paramView == null) {
      return;
    }
    int i = this.b;
    if (i == -1)
    {
      setBackgroundResource(2130849656);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
      return;
    }
    paramView = (ReadInJoyCommentListAdapter)paramView;
    CommentViewItem localCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
    paramView.a(localCommentViewItem, CommentProteusUtil.a(localCommentViewItem, i), 2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter != null))
    {
      if (this.b == -1)
      {
        setBackgroundColor(Color.parseColor("#EDEDED"));
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
        paramView.a(paramView.a(), this, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem, new NativeCommentTextView.2(this));
      }
      return true;
    }
    return false;
  }
  
  public void setCommentModel(CommentViewItem paramCommentViewItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem = paramCommentViewItem;
    paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      setShouldCallClick(true);
      setMaxLines(100);
      setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_JavaLangCharSequence);
      setSpanText("");
      setOnClickListener(this);
      setOnLongClickListener(this);
      b();
    }
  }
  
  public void setModel(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
      this.jdField_a_of_type_AndroidViewView = paramView;
      b();
    }
  }
  
  public void setModel(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView, int paramInt)
  {
    if ((paramView != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      this.b = paramInt;
      CommentViewItem localCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
      if ((localCommentViewItem != null) && (localCommentViewItem.c != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.c.size() > paramInt)) {
        setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.c.get(paramInt));
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
      this.jdField_a_of_type_AndroidViewView = paramView;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeCommentTextView
 * JD-Core Version:    0.7.0.1
 */