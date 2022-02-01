package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsShuntBarConfigure
{
  private static final String a = "VideoFeedsShuntBarConfigure";
  private SparseIntArray b = new SparseIntArray();
  private SparseIntArray c = new SparseIntArray();
  private QQAppInterface d;
  private String e;
  
  public VideoFeedsShuntBarConfigure(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.e = RIJQQAppInterfaceUtil.d();
  }
  
  public void a()
  {
    ThreadManagerV2.executeOnSubThread(new VideoFeedsShuntBarConfigure.1(this));
  }
  
  public boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    Object localObject = Integer.valueOf(0);
    if (paramECommerceEntranceInfo == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        boolean bool = ReadInJoyHelper.ag(this.d);
        if (!bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.e);
          localStringBuilder.append(paramECommerceEntranceInfo.n);
          RIJSPUtils.a(localStringBuilder.toString(), localObject);
        }
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.e);
          localStringBuilder.append(paramECommerceEntranceInfo.n);
          i = ((Integer)RIJSPUtils.b(localStringBuilder.toString(), localObject)).intValue();
          int k = this.b.get(paramECommerceEntranceInfo.n);
          int j = this.c.get(paramECommerceEntranceInfo.n);
          if ((i + j < paramECommerceEntranceInfo.m) && (k < paramECommerceEntranceInfo.l))
          {
            k += 1;
            j += 1;
            this.b.put(paramECommerceEntranceInfo.n, k);
            this.c.put(paramECommerceEntranceInfo.n, j);
            if (QLog.isColorLevel())
            {
              localObject = a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("video_source_id: ");
              localStringBuilder.append(paramECommerceEntranceInfo.n);
              localStringBuilder.append(", one_day_display_counts: ");
              localStringBuilder.append(paramECommerceEntranceInfo.m);
              localStringBuilder.append(", session_display_counts: ");
              localStringBuilder.append(paramECommerceEntranceInfo.l);
              localStringBuilder.append(", session_has_display_counts: ");
              localStringBuilder.append(k);
              localStringBuilder.append(", one_day_has_display_counts: ");
              localStringBuilder.append(i + j);
              QLog.d((String)localObject, 2, localStringBuilder.toString());
            }
            return true;
          }
          return false;
        }
      }
      catch (Exception paramECommerceEntranceInfo)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("解析引流条出现的条件出错: ");
          localStringBuilder.append(paramECommerceEntranceInfo.getMessage());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return false;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShuntBarConfigure
 * JD-Core Version:    0.7.0.1
 */