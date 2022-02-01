package com.tencent.mobileqq.qqlive.filter;

import android.util.Log;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class QQLiveAEFilterProcess$1
  implements LightAssetListener
{
  QQLiveAEFilterProcess$1(QQLiveAEFilterProcess paramQQLiveAEFilterProcess) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnAssetProcessing: ");
    localStringBuilder.append(paramHashMap);
    Log.d("QQLiveAEFilterProcess", localStringBuilder.toString());
    if (QQLiveAEFilterProcess.a(this.a) != null) {
      QQLiveAEFilterProcess.a(this.a).OnAssetProcessing(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnLoadAssetError: ");
    localStringBuilder.append(paramInt);
    Log.d("QQLiveAEFilterProcess", localStringBuilder.toString());
    if (QQLiveAEFilterProcess.a(this.a) != null) {
      QQLiveAEFilterProcess.a(this.a).OnLoadAssetError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess.1
 * JD-Core Version:    0.7.0.1
 */