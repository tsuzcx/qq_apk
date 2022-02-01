package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.qphone.base.util.QLog;

public class RIJChannelHelper
{
  public static int a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if ((paramChannelCoverInfo != null) && (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo != null) && (paramTabChannelCoverInfo.redPoint != null))
    {
      QLog.d("RIJChannelHelper", 2, new Object[] { "getRedDotType, info = ", paramTabChannelCoverInfo.toString() });
      if (paramTabChannelCoverInfo.redPoint.a)
      {
        long l = System.currentTimeMillis() / 1000L;
        if ((l >= paramTabChannelCoverInfo.redPoint.b) && (l <= paramTabChannelCoverInfo.redPoint.c)) {
          return paramTabChannelCoverInfo.redPoint.e;
        }
      }
      return -1;
    }
    if (paramTabChannelCoverInfo != null) {
      paramTabChannelCoverInfo = paramTabChannelCoverInfo.toString();
    } else {
      paramTabChannelCoverInfo = "";
    }
    QLog.d("RIJChannelHelper", 2, new Object[] { "getRedDotType, info is null or redPoint is null", paramTabChannelCoverInfo });
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper
 * JD-Core Version:    0.7.0.1
 */