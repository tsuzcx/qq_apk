package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import android.text.Spannable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEmotionUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentEmotionUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentEmotionUtil;", "()V", "decodeCommentEmotion", "", "iViewProxy", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/view/IViewProxy;", "ssb", "Landroid/text/Spannable;", "getCommentEmotionDataForWeb", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentEmotionUtilImpl
  implements IRIJCommentEmotionUtil
{
  public void decodeCommentEmotion(@Nullable IViewProxy paramIViewProxy, @Nullable Spannable paramSpannable)
  {
    this.$$delegate_0.decodeCommentEmotion(paramIViewProxy, paramSpannable);
  }
  
  @Nullable
  public String getCommentEmotionDataForWeb()
  {
    return this.$$delegate_0.getCommentEmotionDataForWeb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentEmotionUtilImpl
 * JD-Core Version:    0.7.0.1
 */