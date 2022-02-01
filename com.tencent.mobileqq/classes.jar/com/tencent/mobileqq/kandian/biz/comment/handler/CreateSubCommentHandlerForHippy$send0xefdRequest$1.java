package com.tencent.mobileqq.kandian.biz.comment.handler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/handler/CreateSubCommentHandlerForHippy$send0xefdRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CreateSubCommentHandlerForHippy$send0xefdRequest$1
  extends ProtoUtils.TroopProtocolObserver
{
  public boolean onError(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    this.a.a(paramInt, paramBundle);
    paramBundle = this.a;
    if (paramString == null) {
      paramString = "Empty error message.";
    }
    paramBundle.a(paramInt, paramString);
    return true;
  }
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    this.a.a(paramInt, paramBundle);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      this.a.a(paramArrayOfByte);
      return;
    }
    this.a.a(paramInt, "Empty error message.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.CreateSubCommentHandlerForHippy.send0xefdRequest.1
 * JD-Core Version:    0.7.0.1
 */