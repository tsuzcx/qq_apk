package com.tencent.mobileqq.now.recommend;

import com.tencent.mobileqq.now.netchannel.websso.IChannelListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class RecommendAnchorDataManager$1
  implements IChannelListener
{
  RecommendAnchorDataManager$1(RecommendAnchorDataManager paramRecommendAnchorDataManager, int paramInt, RecommendAnchorDataManager.RecommendAnchorDataCallback paramRecommendAnchorDataCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    RecommendAnchorDataManager.a(this.c, false);
    if (RecommendAnchorDataManager.a(this.c).size() == 0) {
      this.c.a(this.a, this.b, true);
    }
    if (QLog.isColorLevel())
    {
      String str = RecommendAnchorDataManager.b(this.c);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Focus cmd:1718 sub cmd:100 errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    RecommendAnchorDataManager.a(this.c, false);
    try
    {
      RecommendAnchorDataManager.a(this.c, 0);
      if ((this.c.a(this.a, paramArrayOfByte) == -1) && (RecommendAnchorDataManager.a(this.c).size() == 0)) {
        this.c.a(this.a, this.b, true);
      }
      this.b.a(RecommendAnchorDataManager.a(this.c));
      RecommendAnchorDataManager.a(this.c, System.currentTimeMillis());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        String str = RecommendAnchorDataManager.b(this.c);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Focus cmd:1718 sub cmd:100 Exception:");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendAnchorDataManager.1
 * JD-Core Version:    0.7.0.1
 */