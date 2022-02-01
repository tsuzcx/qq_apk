package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Callback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class ReadInJoyFastWebBottomSocialViewNew$9
  implements RIJVideoRewardCoinManager.Callback
{
  ReadInJoyFastWebBottomSocialViewNew$9(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew) {}
  
  public void a(@NotNull String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    ReadInJoyFastWebBottomSocialViewNew.a(this.a, paramBoolean, paramString, paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRewardResult, success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,msg=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ,index=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ,sceneType=");
    localStringBuilder.append(paramInt2);
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.9
 * JD-Core Version:    0.7.0.1
 */