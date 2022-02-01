package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentContentView;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentDotClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentDotClickListener$1$configClickListener$1(CommentViewItem paramCommentViewItem, Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, ViewBase paramViewBase) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if ((RIJCommentAdUtils.a(this.a)) && (this.a.c.advertisementInfo != null))
    {
      paramViewBase = this.b.getVirtualView().findViewBaseByName("id_comment_tail_3_dot");
      localObject = this.c.r;
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "idCommentTail3Dot");
      ((INegativeHelper)localObject).a(paramViewBase.getNativeView(), (AdvertisementInfo)this.a.c.advertisementInfo);
      return;
    }
    Object localObject = this.d;
    paramViewBase = (ViewBase)localObject;
    if (!(localObject instanceof CommentContentView)) {
      paramViewBase = null;
    }
    paramViewBase = (CommentContentView)paramViewBase;
    if (paramViewBase != null)
    {
      paramViewBase = paramViewBase.getNativeView();
      if (paramViewBase != null) {
        paramViewBase.setBackgroundColor(Color.parseColor("#DBE5EF"));
      }
    }
    paramViewBase = this.c;
    if (paramViewBase != null)
    {
      localObject = (Activity)paramViewBase.c;
      ViewBase localViewBase = this.d;
      Intrinsics.checkExpressionValueIsNotNull(localViewBase, "commentContentView");
      paramViewBase.a((Activity)localObject, localViewBase.getNativeView(), this.a, (BubblePopupWindow.OnDismissListener)new CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */