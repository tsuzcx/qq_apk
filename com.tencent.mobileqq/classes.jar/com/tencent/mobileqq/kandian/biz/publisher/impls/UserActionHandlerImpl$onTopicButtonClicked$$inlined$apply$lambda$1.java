package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.os.Bundle;
import com.tencent.tkd.weibo.bean.EditObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "bundle", "Landroid/os/Bundle;", "invoke", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$onTopicButtonClicked$tweetTopicView$1$1"}, k=3, mv={1, 1, 16})
final class UserActionHandlerImpl$onTopicButtonClicked$$inlined$apply$lambda$1
  extends Lambda
  implements Function2<EditObject, Bundle, Unit>
{
  UserActionHandlerImpl$onTopicButtonClicked$$inlined$apply$lambda$1(Bundle paramBundle, Function2 paramFunction2)
  {
    super(2);
  }
  
  public final void invoke(@Nullable EditObject paramEditObject, @Nullable Bundle paramBundle)
  {
    this.$callback$inlined.invoke(paramEditObject, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl.onTopicButtonClicked..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */