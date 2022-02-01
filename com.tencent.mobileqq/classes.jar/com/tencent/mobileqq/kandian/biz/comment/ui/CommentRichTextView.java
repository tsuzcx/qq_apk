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
  private static final int a = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private CommentViewItem c;
  private ExposedSubCommentViewItem d;
  private Context e;
  private ReadinjoyCommentListBaseAdapter f;
  private View g;
  private ColorDrawable h;
  private int i = -1;
  
  public CommentRichTextView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.e = paramVafContext.getContext();
  }
  
  private void a()
  {
    QLog.d("CommentRichTextView", 2, "showAnchorAniation");
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((CommentViewItem)localObject).c == null) {
        return;
      }
      if (!this.c.c.isAnchor) {
        return;
      }
      if (this.h == null) {
        this.h = new ColorDrawable(-15550475);
      }
      localObject = this.g;
      if (localObject == null) {
        return;
      }
      QLog.d("CommentRichTextView", 2, "showAnchorAniation start");
      this.c.c.isAnchor = false;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
      localValueAnimator.setDuration(2400L);
      localValueAnimator.setStartDelay(600L);
      localValueAnimator.addUpdateListener(new CommentRichTextView.2(this, (View)localObject));
      localValueAnimator.start();
    }
  }
  
  private void a(View paramView)
  {
    this.h.setAlpha(0);
    paramView.setBackgroundDrawable(this.h);
  }
  
  private void b()
  {
    this.mNative.setBackgroundResource(2130851361);
    this.f.a(this.c);
  }
  
  private void c()
  {
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((ExposedSubCommentViewItem)localObject1).a;
      localObject2 = this.d.b;
    }
    else
    {
      localObject1 = this.c;
      if (localObject1 != null) {
        localObject2 = ((CommentViewItem)localObject1).c;
      } else {
        localObject1 = null;
      }
    }
    if ((localObject2 != null) && (((BaseCommentData)localObject2).commentRptDataList != null))
    {
      RIJCommentRptDataUtil.PTSCommentModel localPTSCommentModel = new RIJCommentRptDataUtil.PTSCommentModel();
      localPTSCommentModel.b = ((CommentViewItem)localObject1).d;
      localPTSCommentModel.a = ((BaseCommentData)localObject2);
      this.mNative.setTag(2131444314, localPTSCommentModel);
    }
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView)
  {
    if ((paramView != null) && (this.e != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      this.f = paramReadinjoyCommentListBaseAdapter;
      this.g = paramView;
      a();
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    this.c = paramCommentViewItem;
    paramCommentViewItem = this.c;
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
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
    if (this.f != null)
    {
      if (this.mNative == null) {
        return;
      }
      if (this.mNative.isHyperLinkClick())
      {
        this.mNative.setHyperLinkClick(false);
        return;
      }
      int j = this.i;
      if (j == -1)
      {
        b();
        return;
      }
      paramView = (ReadInJoyCommentListAdapter)this.f;
      CommentViewItem localCommentViewItem = this.c;
      paramView.a(localCommentViewItem, CommentProteusUtil.a(localCommentViewItem, j), 2);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.e != null) && (this.f != null))
    {
      if (this.i == -1)
      {
        RIJTransMergeKanDianReport.a("0X800824B");
        setBackgroundColor(Color.parseColor("#EDEDED"));
        paramView = this.f;
        paramView.a(paramView.n(), this.mNative, this.c, new CommentRichTextView.1(this));
      }
      return true;
    }
    return false;
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt == 1059)
    {
      int j = 0;
      if ((paramObject instanceof CommentViewItem)) {
        a((CommentViewItem)paramObject);
      }
      for (;;)
      {
        j = 1;
        break;
        if (!(paramObject instanceof ExposedSubCommentViewItem)) {
          break;
        }
        this.d = ((ExposedSubCommentViewItem)paramObject);
      }
      c();
      if (j != 0) {
        return true;
      }
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentRichTextView
 * JD-Core Version:    0.7.0.1
 */