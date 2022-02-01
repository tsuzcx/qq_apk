package com.tencent.mobileqq.kandian.biz.atlas;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.util.NumberUtil;
import org.jetbrains.annotations.NotNull;

class ReadInJoyAtlasCommentFragment$6
  extends TKDHippy2NativeEventSimpleReceiver
{
  ReadInJoyAtlasCommentFragment$6(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void closeComment()
  {
    this.a.onBackEvent();
  }
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    if (!TextUtils.isEmpty(paramString4)) {
      paramString2 = paramString4;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, paramString1, paramString2, paramString3, "onCommentLike", ReadInJoyAtlasCommentFragment.c(this.a));
  }
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, String paramString7)
  {
    if (TextUtils.isEmpty(paramString5))
    {
      paramString6 = "";
      paramString5 = paramString2;
      paramString2 = paramString6;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, paramString1, paramString5, paramString3, NumberUtil.a(paramString4), "onCommentSend", ReadInJoyAtlasCommentFragment.c(this.a), paramString2);
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2 = paramString3;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, paramString1, paramString2, "onCommentDelete", ReadInJoyAtlasCommentFragment.c(this.a), NumberUtil.a(paramString4, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment.6
 * JD-Core Version:    0.7.0.1
 */