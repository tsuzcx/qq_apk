package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyLinkMovementMethod;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import java.util.List;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String jdField_a_of_type_JavaLangString = "NativeExposeReplyCommentView";
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
  private CommentViewItem jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public NativeExposeReplyCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private SubCommentData a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if ((paramCommentViewItem != null) && ((paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)))
    {
      paramCommentViewItem = (CommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if ((paramCommentViewItem.subCommentList != null) && (paramCommentViewItem.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramCommentViewItem.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131560181, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366868));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366880));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366881));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377102));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377109));
    this.d = ((TextView)findViewById(2131377110));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376429));
    this.e = ((TextView)findViewById(2131376428));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366882);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377111);
  }
  
  private void a(int paramInt)
  {
    int k = 0;
    int j = 4;
    int i;
    if (paramInt > 1)
    {
      i = k;
      if (paramInt > 2)
      {
        j = 0;
        i = k;
      }
    }
    else
    {
      i = 4;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(i);
    this.jdField_b_of_type_AndroidViewView.setVisibility(j);
  }
  
  private void b()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)) {
      return;
    }
    if (((CommentData)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).subCommentNum < 3) {
      return;
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    localLinearLayout.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.jdField_a_of_type_AndroidContentContext, localLinearLayout));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    localLinearLayout.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.jdField_a_of_type_AndroidContentContext, localLinearLayout));
    this.d.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      if (!(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)) {
        return;
      }
      CommentData localCommentData = (CommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (!paramCommentViewItem.a())
      {
        setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem = paramCommentViewItem;
      setVisibility(0);
      Object localObject = paramCommentViewItem.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramCommentViewItem.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramCommentViewItem.b.get(i));
          this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        }
        else if (i == 1)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)paramCommentViewItem.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.d.setText((CharSequence)paramCommentViewItem.b.get(i));
          this.d.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.d.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        }
        i += 1;
      }
      if (localCommentData.subCommentNum > 2)
      {
        paramCommentViewItem = this.e;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131707108));
        ((StringBuilder)localObject).append(ReadInJoyHelper.a(localCommentData.subCommentNum, 99989500L, "9999万+", "0"));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131707107));
        paramCommentViewItem.setText(((StringBuilder)localObject).toString());
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      }
      b();
      a(localCommentData.subCommentNum);
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
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter != null)
    {
      CommentViewItem localCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
      if (localCommentViewItem == null) {
        return;
      }
      if (!(localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)) {
        return;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131377102: 
      case 2131377110: 
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130843066);
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
        localCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
        paramView.a(localCommentViewItem, a(localCommentViewItem, 1), 2);
        return;
      case 2131376429: 
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem, null, 1);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130843066);
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter;
      localCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
      paramView.a(localCommentViewItem, a(localCommentViewItem, 0), 2);
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAdapter(ReadInJoyCommentListAdapter paramReadInJoyCommentListAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListAdapter = paramReadInJoyCommentListAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */