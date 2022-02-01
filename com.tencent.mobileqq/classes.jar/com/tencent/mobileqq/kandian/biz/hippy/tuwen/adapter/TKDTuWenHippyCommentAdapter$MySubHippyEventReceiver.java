package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;

class TKDTuWenHippyCommentAdapter$MySubHippyEventReceiver
  extends TKDHippy2NativeEventSimpleReceiver
{
  private TKDTuWenHippyCommentAdapter$MySubHippyEventReceiver(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  public void onClickLike(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString4))
    {
      boolean bool = "1".equals(paramString3);
      TKDTuWenHippyCommentAdapter.access$1000(this.this$0, paramString2, bool);
    }
  }
  
  public void onCreateComment(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    TKDTuWenHippyCommentAdapter.access$1100(this.this$0, paramString2, paramString6, paramString7);
  }
  
  public void onDeleteComment(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      TKDTuWenHippyCommentAdapter.access$1200(this.this$0, paramString2);
      return;
    }
    TKDTuWenHippyCommentAdapter.access$1300(this.this$0, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.MySubHippyEventReceiver
 * JD-Core Version:    0.7.0.1
 */