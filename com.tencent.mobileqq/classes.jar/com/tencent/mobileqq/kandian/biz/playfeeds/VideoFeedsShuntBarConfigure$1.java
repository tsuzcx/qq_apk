package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.util.SparseIntArray;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShuntBarConfigure$1
  implements Runnable
{
  VideoFeedsShuntBarConfigure$1(VideoFeedsShuntBarConfigure paramVideoFeedsShuntBarConfigure) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject2;
      while (i < VideoFeedsShuntBarConfigure.a(this.this$0).size())
      {
        int j = VideoFeedsShuntBarConfigure.a(this.this$0).keyAt(i);
        int k = VideoFeedsShuntBarConfigure.a(this.this$0).valueAt(i);
        if (k != 0)
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(VideoFeedsShuntBarConfigure.a(this.this$0));
          ((StringBuilder)localObject1).append(j);
          int m = ((Integer)RIJSPUtils.a(((StringBuilder)localObject1).toString(), Integer.valueOf(0))).intValue();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(VideoFeedsShuntBarConfigure.a(this.this$0));
          ((StringBuilder)localObject1).append(j);
          localObject1 = ((StringBuilder)localObject1).toString();
          k += m;
          RIJSPUtils.a((String)localObject1, Integer.valueOf(k));
          if (QLog.isColorLevel())
          {
            localObject1 = VideoFeedsShuntBarConfigure.a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("video_source_id: ");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(", has display counts: ");
            ((StringBuilder)localObject2).append(k);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
        }
        i += 1;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = VideoFeedsShuntBarConfigure.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("更新引流条配置出现错误: ");
        localStringBuilder.append(localException.getMessage());
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShuntBarConfigure.1
 * JD-Core Version:    0.7.0.1
 */