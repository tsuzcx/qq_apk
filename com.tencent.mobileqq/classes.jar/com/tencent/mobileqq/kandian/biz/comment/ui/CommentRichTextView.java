package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText;
import com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ExposedSubCommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil.PTSCommentModel;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.qphone.base.util.QLog;

public class CommentRichTextView
  extends RichNativeText
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
  private CommentViewItem jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
  private ExposedSubCommentViewItem jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataExposedSubCommentViewItem;
  private int c = -1;
  
  public CommentRichTextView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
  }
  
  private void a()
  {
    QLog.d("CommentRichTextView", 2, "showAnchorAniation");
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
      QLog.d("CommentRichTextView", 2, "showAnchorAniation start");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor = false;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
      localValueAnimator.setDuration(2400L);
      localValueAnimator.setStartDelay(600L);
      localValueAnimator.addUpdateListener(new CommentRichTextView.2(this, (View)localObject));
      localValueAnimator.start();
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  private void b()
  {
    this.mNative.setBackgroundResource(2130849656);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataExposedSubCommentViewItem;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((ExposedSubCommentViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataExposedSubCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentData;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
      if (localObject1 != null) {
        localObject2 = ((CommentViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      } else {
        localObject1 = null;
      }
    }
    if ((localObject2 != null) && (((BaseCommentData)localObject2).commentRptDataList != null))
    {
      RIJCommentRptDataUtil.PTSCommentModel localPTSCommentModel = new RIJCommentRptDataUtil.PTSCommentModel();
      localPTSCommentModel.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((CommentViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      localPTSCommentModel.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData = ((BaseCommentData)localObject2);
      this.mNative.setTag(2131376111, localPTSCommentModel);
    }
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
      this.jdField_a_of_type_AndroidViewView = paramView;
      a();
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem = paramCommentViewItem;
    paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
    if ((paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null))
    {
      if (this.mNative == null) {
        return;
      }
      this.mNative.setOnClickListener(this);
      this.mNative.setOnLongClickListener(this);
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter != null)
    {
      if (this.mNative == null) {
        return;
      }
      if (this.mNative.isHyperLinkClick())
      {
        this.mNative.setHyperLinkClick(false);
        return;
      }
      int i = this.c;
      if (i == -1)
      {
        b();
        return;
      }
      paramView = (ReadInJoyCommentListAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
      CommentViewItem localCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
      paramView.a(localCommentViewItem, CommentProteusUtil.a(localCommentViewItem, i), 2);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter != null))
    {
      if (this.c == -1)
      {
        RIJTransMergeKanDianReport.a("0X800824B");
        setBackgroundColor(Color.parseColor("#EDEDED"));
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
        paramView.a(paramView.a(), this.mNative, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem, new CommentRichTextView.1(this));
      }
      return true;
    }
    return false;
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt == 1059)
    {
      int i = 0;
      if ((paramObject instanceof CommentViewItem)) {
        a((CommentViewItem)paramObject);
      }
      for (;;)
      {
        i = 1;
        break;
        if (!(paramObject instanceof ExposedSubCommentViewItem)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataExposedSubCommentViewItem = ((ExposedSubCommentViewItem)paramObject);
      }
      c();
      if (i != 0) {
        return true;
      }
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentRichTextView
 * JD-Core Version:    0.7.0.1
 */