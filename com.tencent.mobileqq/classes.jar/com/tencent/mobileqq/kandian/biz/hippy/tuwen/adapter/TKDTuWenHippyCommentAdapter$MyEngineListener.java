package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TKDTuWenHippyCommentAdapter$MyEngineListener
  implements HippyQQEngine.HippyQQEngineListener
{
  private final WeakReference<TKDTuWenHippyCommentAdapter> adapterWeakReference;
  
  private TKDTuWenHippyCommentAdapter$MyEngineListener(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter)
  {
    this.adapterWeakReference = new WeakReference(paramTKDTuWenHippyCommentAdapter);
  }
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: initHippy error statusCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString);
    QLog.d("TKDTuWenHippyCommentAdapter", 1, localStringBuilder.toString());
    paramString = (TKDTuWenHippyCommentAdapter)this.adapterWeakReference.get();
    if (paramString != null) {
      TKDTuWenHippyCommentAdapter.access$1600(paramString, false);
    }
  }
  
  public void onSuccess()
  {
    QLog.d("TKDTuWenHippyCommentAdapter", 1, "Hippy: initHippy success");
    TKDTuWenHippyCommentAdapter localTKDTuWenHippyCommentAdapter = (TKDTuWenHippyCommentAdapter)this.adapterWeakReference.get();
    if (localTKDTuWenHippyCommentAdapter != null) {
      TKDTuWenHippyCommentAdapter.access$1700(localTKDTuWenHippyCommentAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.MyEngineListener
 * JD-Core Version:    0.7.0.1
 */