package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.TKDTuWen2HippyEventSimpleReceiver;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule$MyTKDTuWen2HippyEventReceiver;", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/receiver/tuwen/TKDTuWen2HippyEventSimpleReceiver;", "(Lcom/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule;)V", "onDeleteMainComment", "", "mainCommentId", "", "onDeleteSubComment", "subCommentId", "onInsertSubComment", "repliedCommentId", "subCommentData", "onLikeMainCommentChanged", "like", "", "onOpenCommentPublisher", "sendCommentReadTime", "time", "", "updateFollowUI", "followUin", "followStatus", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class TKDCommentBizModule$MyTKDTuWen2HippyEventReceiver
  extends TKDTuWen2HippyEventSimpleReceiver
{
  public void onDeleteMainComment(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDeleteMainComment commentId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("commentId", paramString);
    this.this$0.sendEventToJs("@comment:deleteLevel1Comment", (HippyMap)localObject);
  }
  
  public void onDeleteSubComment(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDeleteSubComment:mainCommentId=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(',');
    ((StringBuilder)localObject).append("subCommentId=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("commentId", paramString1);
    ((HippyMap)localObject).pushString("subCommentId", paramString2);
    this.this$0.sendEventToJs("@comment:deleteLevel2Comment", (HippyMap)localObject);
  }
  
  public void onInsertSubComment(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInsertSubComment:mainCommentId=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(',');
    ((StringBuilder)localObject).append("repliedCommentId=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", subCommentData=");
    ((StringBuilder)localObject).append(paramString3);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty((CharSequence)paramString3)) {
      return;
    }
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("commentId", paramString1);
    ((HippyMap)localObject).pushString("repliedCommentId", paramString2);
    try
    {
      ((HippyMap)localObject).pushString("subComment", paramString3);
      this.this$0.sendEventToJs("@comment:insertLevel2Comment", (HippyMap)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("TKDCommentBizModule", 1, (Throwable)paramString1, new Object[0]);
    }
  }
  
  public void onLikeMainCommentChanged(@Nullable String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLikeMainCommentChanged commentId=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", like=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("commentId", paramString);
    ((HippyMap)localObject).pushBoolean("isLike", paramBoolean);
    this.this$0.sendEventToJs("@comment:toggleLevel1PraiseStatus", (HippyMap)localObject);
  }
  
  public void onOpenCommentPublisher()
  {
    QLog.d("TKDCommentBizModule", 1, "onOpenCommentPublisher");
    HippyMap localHippyMap = new HippyMap();
    this.this$0.sendEventToJs("@comment:openPublisher", localHippyMap);
  }
  
  public void sendCommentReadTime(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendCommentReadTime:time=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = new HippyMap();
    ((HippyMap)localObject).pushLong("readTime", paramLong);
    this.this$0.sendEventToJs("@comment:reportCommentReadTime", (HippyMap)localObject);
  }
  
  public void updateFollowUI(long paramLong, int paramInt)
  {
    QLog.d("TKDCommentBizModule", 1, "updateFollowUI");
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushLong("followUin", paramLong);
    localHippyMap.pushInt("followStatus", paramInt);
    this.this$0.sendEventToJs("@comment:updateFollowUI", localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.MyTKDTuWen2HippyEventReceiver
 * JD-Core Version:    0.7.0.1
 */