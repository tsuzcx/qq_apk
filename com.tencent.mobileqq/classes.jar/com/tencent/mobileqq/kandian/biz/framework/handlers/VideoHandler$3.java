package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class VideoHandler$3
  implements VideoPreDownloadMgr.PreDownloadController
{
  VideoHandler$3(VideoHandler paramVideoHandler) {}
  
  private void a(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList != null) && (paramInt >= 0))
    {
      if (paramInt >= this.a.c()) {
        return;
      }
      if ((this.a.a() != 0) && (this.a.a() != 40677)) {
        i = 1;
      } else {
        i = 0;
      }
      int m = VideoPreloadStrategyConoller.a().a("video_channel", paramInt);
      int j = i + paramInt;
      int k;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this.a.c()) {
          break;
        }
        k = i;
        if (j >= paramInt + 10) {
          break;
        }
        k = this.a.a(j).intValue();
        if (!a(k))
        {
          k = i;
        }
        else
        {
          Object localObject1 = VideoHandler.a(this.a, j);
          if (localObject1 == null)
          {
            k = i;
          }
          else
          {
            if ((k != 46) && (k != 70))
            {
              paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((AbsBaseArticleInfo)localObject1).mVideoVid, ((AbsBaseArticleInfo)localObject1).innerUniqueID, ((AbsBaseArticleInfo)localObject1).busiType, ((AbsBaseArticleInfo)localObject1).getVideoDuration()));
              k = i + 1;
              i = k;
              if (((AbsBaseArticleInfo)localObject1).busiType == 5)
              {
                i = k;
                if ((localObject1 instanceof AdvertisementInfo))
                {
                  Object localObject2 = (AdvertisementInfo)localObject1;
                  i = k;
                  if (((AdvertisementInfo)localObject2).mImaxShowAdType == 1001)
                  {
                    localObject2 = ((AdvertisementInfo)localObject2).mImaxVideoUrl;
                    i = k;
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      localObject1 = new VideoPreDownloadMgr.VideoPreDownloadParam((String)localObject2, "", ((AbsBaseArticleInfo)localObject1).busiType, ((AbsBaseArticleInfo)localObject1).getVideoDuration());
                      ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject1).a = true;
                      paramList.add(localObject1);
                      i = k + 1;
                    }
                  }
                }
              }
            }
            else
            {
              paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((AbsBaseArticleInfo)localObject1).mVideoVid, ((AbsBaseArticleInfo)localObject1).innerUniqueID, ((AbsBaseArticleInfo)localObject1).busiType, ((AbsBaseArticleInfo)localObject1).getVideoDuration()));
              paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((AbsBaseArticleInfo)((AbsBaseArticleInfo)localObject1).mSubArticleList.get(0)).mVideoVid, ((AbsBaseArticleInfo)((AbsBaseArticleInfo)localObject1).mSubArticleList.get(0)).innerUniqueID, ((AbsBaseArticleInfo)((AbsBaseArticleInfo)localObject1).mSubArticleList.get(0)).busiType, ((AbsBaseArticleInfo)((AbsBaseArticleInfo)localObject1).mSubArticleList.get(0)).getVideoDuration()));
              i += 2;
            }
            k = i;
            if (i >= m)
            {
              k = i;
              break;
            }
          }
        }
        j += 1;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("scroll to next = ");
        paramList.append(paramBoolean);
        paramList.append(" preDownload to forward = ");
        paramList.append(k);
        QLog.d("VideoHandler", 2, paramList.toString());
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 6) || (paramInt == 66) || (paramInt == 115) || (paramInt == 148) || (paramInt == 46) || (paramInt == 70);
  }
  
  private void b(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramInt < 0) {
        return;
      }
      int m = VideoPreloadStrategyConoller.a().a();
      int j = paramInt - 1;
      int k;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j <= 0) {
          break;
        }
        k = i;
        if (j <= paramInt - 10) {
          break;
        }
        k = i;
        if (j >= this.a.c()) {
          break;
        }
        k = this.a.a(j).intValue();
        if (!a(k))
        {
          k = i;
        }
        else
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = VideoHandler.a(this.a, j);
          if (localAbsBaseArticleInfo == null)
          {
            k = i;
          }
          else
          {
            if ((k != 46) && (k != 70))
            {
              paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localAbsBaseArticleInfo.mVideoVid, localAbsBaseArticleInfo.innerUniqueID, localAbsBaseArticleInfo.busiType, localAbsBaseArticleInfo.getVideoDuration()));
              i += 1;
            }
            else
            {
              paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localAbsBaseArticleInfo.mVideoVid, localAbsBaseArticleInfo.innerUniqueID, localAbsBaseArticleInfo.busiType, localAbsBaseArticleInfo.getVideoDuration()));
              paramList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((AbsBaseArticleInfo)localAbsBaseArticleInfo.mSubArticleList.get(0)).mVideoVid, ((AbsBaseArticleInfo)localAbsBaseArticleInfo.mSubArticleList.get(0)).innerUniqueID, ((AbsBaseArticleInfo)localAbsBaseArticleInfo.mSubArticleList.get(0)).busiType, ((AbsBaseArticleInfo)localAbsBaseArticleInfo.mSubArticleList.get(0)).getVideoDuration()));
              i += 2;
            }
            k = i;
            if (i >= m)
            {
              k = i;
              break;
            }
          }
        }
        j -= 1;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("scroll to next = ");
        paramList.append(paramBoolean);
        paramList.append(" preDownload to backward = ");
        paramList.append(k);
        QLog.d("VideoHandler", 2, paramList.toString());
      }
    }
  }
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramInt, paramBoolean);
    b(localArrayList, paramInt, paramBoolean);
    return localArrayList;
  }
  
  public boolean a()
  {
    Object localObject = VideoHandler.a(this.a);
    if (localObject != null) {
      localObject = ((VideoPlayParam)localObject).a();
    } else {
      localObject = "";
    }
    return VideoPreloadStrategyConoller.a().a(this.a.a.a((String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.3
 * JD-Core Version:    0.7.0.1
 */