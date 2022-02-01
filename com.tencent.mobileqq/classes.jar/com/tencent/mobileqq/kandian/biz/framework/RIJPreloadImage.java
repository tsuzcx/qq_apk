package com.tencent.mobileqq.kandian.biz.framework;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticlePreloadUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RIJPreloadImage
{
  private static int a = 10;
  private static int b = 10;
  private long c = 0L;
  private int d = 0;
  
  private List<PreloadImgInfo> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    URL localURL;
    if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
      localURL = paramAbsBaseArticleInfo.mVideoCoverUrl;
    } else if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      localURL = paramAbsBaseArticleInfo.mSinglePicture;
    } else {
      localURL = RIJConvertString2URL.b(paramAbsBaseArticleInfo.mFirstPagePicUrl);
    }
    localArrayList.add(PreloadImgInfo.a(localURL, ReadInJoyDisplayUtils.h()));
    if ((paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0))
    {
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
      if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mVideoCoverUrl;
      } else if (paramAbsBaseArticleInfo.mSinglePicture != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSinglePicture;
      } else {
        paramAbsBaseArticleInfo = RIJConvertString2URL.b(paramAbsBaseArticleInfo.mFirstPagePicUrl);
      }
      localArrayList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo, ReadInJoyDisplayUtils.h()));
    }
    return localArrayList;
  }
  
  private void a(List<PreloadImgInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PreloadImgInfo localPreloadImgInfo = (PreloadImgInfo)paramList.next();
      if ((localPreloadImgInfo != null) && (localPreloadImgInfo.a != null))
      {
        if (TextUtils.equals("pubaccountimage", localPreloadImgInfo.a.getProtocol())) {
          localPreloadImgInfo.a = RIJConvertString2URL.a(localPreloadImgInfo.a.getFile(), false);
        }
        if (localPreloadImgInfo.a != null)
        {
          ImageRequest localImageRequest = new ImageRequest();
          RIJImageTypeOptHelper.a.a(localImageRequest, localPreloadImgInfo.a.toString());
          localImageRequest.b = ((Integer)localPreloadImgInfo.b.first).intValue();
          localImageRequest.c = ((Integer)localPreloadImgInfo.b.second).intValue();
          localImageRequest.e = true;
          ImageManager.get().loadImage(localImageRequest, null);
        }
      }
    }
  }
  
  private List<PreloadImgInfo> b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAbsBaseArticleInfo.mPictures != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mPictures;
      int j = paramAbsBaseArticleInfo.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo[i], ReadInJoyDisplayUtils.b()));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int a()
  {
    return a;
  }
  
  public void a(int paramInt1, int paramInt2, RIJDataManager paramRIJDataManager)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadImg start:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("RIJPreloadImage", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(paramRIJDataManager.a().A())) {
      return;
    }
    Object localObject = new ArrayList(paramRIJDataManager.b());
    ThreadManager.post(new RIJPreloadImage.1(this, this.c, (List)localObject, paramInt1, paramInt2, paramRIJDataManager, l), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!PreloadManager.a().f()) {
      return;
    }
    PreloadManager.a().h();
    int i = paramReadInJoyBaseAdapter.c();
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
      if ((localObject instanceof BaseArticleInfo))
      {
        localObject = (AbsBaseArticleInfo)localObject;
        if ((!RIJFeedsType.a(((AbsBaseArticleInfo)localObject).mArticleContentUrl, ((AbsBaseArticleInfo)localObject).mChannelID, (AbsBaseArticleInfo)localObject)) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!paramReadInJoyBaseAdapter.b(i, ((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().b((String)localObject);
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  @VisibleForTesting
  void a(List<PreloadImgInfo> paramList, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    paramInt = paramRIJDataManager.a().v().getItemViewType(paramInt);
    if (paramInt == 4)
    {
      if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mVideoCoverUrl;
      } else if (paramAbsBaseArticleInfo.mSinglePicture != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSinglePicture;
      } else {
        paramAbsBaseArticleInfo = RIJConvertString2URL.b(paramAbsBaseArticleInfo.mFirstPagePicUrl);
      }
      paramList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo, ReadInJoyDisplayUtils.g()));
      return;
    }
    if ((paramInt != 70) && (paramInt != 46))
    {
      if ((paramInt != 3) && (paramInt != 14) && (paramInt != 105))
      {
        if ((paramInt != 2) && (paramInt != 6) && (paramInt != 66) && (paramInt != 115))
        {
          if ((paramInt == 1) || (paramInt == 5) || (paramInt == 104) || (paramInt == 106)) {
            paramList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo.mSinglePicture, ReadInJoyDisplayUtils.b()));
          }
        }
        else {
          paramList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo.mSinglePicture, ReadInJoyDisplayUtils.f()));
        }
      }
      else {
        paramList.addAll(b(paramAbsBaseArticleInfo));
      }
    }
    else {
      paramList.addAll(a(paramAbsBaseArticleInfo));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, PrefetchListener paramPrefetchListener, RIJDataManager paramRIJDataManager)
  {
    ImageManager.get().resume();
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "resume image onScrollStateChanged idle");
    }
    if (paramBoolean)
    {
      a(paramInt2, a, paramRIJDataManager);
    }
    else
    {
      int i = a;
      a(paramInt2 - i, i, paramRIJDataManager);
    }
    if ((paramInt1 - paramInt2 <= this.d) && (paramPrefetchListener != null)) {
      paramPrefetchListener.a();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cpu:");
      localStringBuilder.append(DeviceInfoUtil.h());
      localStringBuilder.append(" mem:");
      localStringBuilder.append(DeviceInfoUtil.a());
      localStringBuilder.append(" fre:");
      localStringBuilder.append(DeviceInfoUtil.k());
      QLog.d("RIJPreloadImage", 2, localStringBuilder.toString());
    }
    int i = DeviceInfoUtil.h();
    long l = DeviceInfoUtil.a();
    if ((i >= 4) && (l >= 1610612736.0D))
    {
      a = 6;
      return;
    }
    a = 4;
  }
  
  public void b(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).canPreload()) {
      return;
    }
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).cancelNotDownloadTask();
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
      if (localObject != null)
      {
        localObject = (AbsBaseArticleInfo)localObject;
        int i = paramReadInJoyBaseAdapter.c(paramInt1);
        if ((i == 8) || (i == 7)) {
          ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).addTask(String.valueOf(((AbsBaseArticleInfo)localObject).innerUniqueID));
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void c(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (FeedsSPUtils.a(RIJQQAppInterfaceUtil.b()))
    {
      if (!ReadInJoyHelper.ap(RIJQQAppInterfaceUtil.b())) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
        if (localObject != null)
        {
          localObject = (AbsBaseArticleInfo)localObject;
          if (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) {
            localArrayList.add(localObject);
          }
        }
        paramInt1 += 1;
      }
      ReadInJoyLogicEngine.a().d().a(localArrayList);
    }
  }
  
  public void d(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!RIJWebArticleUtil.a.b()) {
      return;
    }
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
      if (localObject != null)
      {
        RIJWebArticlePreloadUtil localRIJWebArticlePreloadUtil = RIJWebArticlePreloadUtil.a;
        localObject = (AbsBaseArticleInfo)localObject;
        localRIJWebArticlePreloadUtil.a((AbsBaseArticleInfo)localObject);
        DataPreloadModule.INSTANCE.preloadArticle((AbsBaseArticleInfo)localObject);
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage
 * JD-Core Version:    0.7.0.1
 */