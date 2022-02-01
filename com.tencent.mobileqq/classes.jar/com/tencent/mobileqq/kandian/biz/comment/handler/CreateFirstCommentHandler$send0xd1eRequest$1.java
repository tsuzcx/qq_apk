package com.tencent.mobileqq.kandian.biz.comment.handler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/handler/CreateFirstCommentHandler$send0xd1eRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CreateFirstCommentHandler$send0xd1eRequest$1
  extends ProtoUtils.TroopProtocolObserver
{
  public boolean onError(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    this.a.a(paramInt, paramBundle);
    CreateFirstCommentHandler.a(this.a, paramInt, paramString);
    paramBundle = this.a;
    oidb_0xd1e.FirstCommentCreateRsp localFirstCommentCreateRsp = CreateFirstCommentHandler.b(paramBundle, null);
    if (paramString == null) {
      paramString = "Empty error message.";
    }
    paramBundle.a(localFirstCommentCreateRsp, paramInt, paramString);
    return true;
  }
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    this.a.a(paramInt, paramBundle);
    CreateFirstCommentHandler.a(this.a, paramInt, null);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      CreateFirstCommentHandler.a(this.a, paramArrayOfByte);
      return;
    }
    paramBundle = this.a;
    paramBundle.a(CreateFirstCommentHandler.b(paramBundle, paramArrayOfByte), paramInt, "Empty error message.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.CreateFirstCommentHandler.send0xd1eRequest.1
 * JD-Core Version:    0.7.0.1
 */