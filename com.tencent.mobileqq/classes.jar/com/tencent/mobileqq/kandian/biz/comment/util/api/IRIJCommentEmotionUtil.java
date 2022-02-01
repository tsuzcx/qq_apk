package com.tencent.mobileqq.kandian.biz.comment.util.api;

import android.text.Spannable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentEmotionUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "decodeCommentEmotion", "", "iViewProxy", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/view/IViewProxy;", "ssb", "Landroid/text/Spannable;", "getCommentEmotionDataForWeb", "", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJCommentEmotionUtil
  extends QRouteApi
{
  public static final IRIJCommentEmotionUtil.Companion Companion = IRIJCommentEmotionUtil.Companion.a;
  @NotNull
  public static final String KEY_EMOTION_DATA = "key_emotion_data";
  
  public abstract void decodeCommentEmotion(@Nullable IViewProxy paramIViewProxy, @Nullable Spannable paramSpannable);
  
  @Nullable
  public abstract String getCommentEmotionDataForWeb();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEmotionUtil
 * JD-Core Version:    0.7.0.1
 */