package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import android.text.Spannable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEmotionUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentEmotionUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentEmotionUtil;", "()V", "decodeCommentEmotion", "", "iViewProxy", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/view/IViewProxy;", "ssb", "Landroid/text/Spannable;", "getCommentEmotionDataForWeb", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentEmotionUtilImpl
  implements IRIJCommentEmotionUtil
{
  public void decodeCommentEmotion(@Nullable IViewProxy paramIViewProxy, @Nullable Spannable paramSpannable)
  {
    RIJEmotionUtil.a(paramIViewProxy, paramSpannable);
  }
  
  @NotNull
  public String getCommentEmotionDataForWeb()
  {
    Object localObject2 = RIJEmotionCacheManager.a();
    Object localObject1 = new JSONArray();
    try
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "emotionInfos");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RIJBaseEmotionInfo localRIJBaseEmotionInfo = (RIJBaseEmotionInfo)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("emotionName", localRIJBaseEmotionInfo.c);
        localJSONObject.put("emotionUrl", localRIJBaseEmotionInfo.b);
        ((JSONArray)localObject1).put(localJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label90:
      break label90;
    }
    localObject1 = ((JSONArray)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonArray.toString()");
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentEmotionUtilImpl
 * JD-Core Version:    0.7.0.1
 */