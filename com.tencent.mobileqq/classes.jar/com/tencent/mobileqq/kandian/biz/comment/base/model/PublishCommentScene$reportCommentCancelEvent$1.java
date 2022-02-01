package com.tencent.mobileqq.kandian.biz.comment.base.model;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishCommentScene$reportCommentCancelEvent$1
  implements Runnable
{
  PublishCommentScene$reportCommentCancelEvent$1(PublishCommentScene paramPublishCommentScene, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    PublicAccountReportUtils.a(null, "", (String)this.a.element, (String)this.a.element, 0, 0, String.valueOf(PublishCommentScene.a(this.this$0)), "", "", PublishCommentScene.a(this.this$0, null, 1, null).toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.PublishCommentScene.reportCommentCancelEvent.1
 * JD-Core Version:    0.7.0.1
 */