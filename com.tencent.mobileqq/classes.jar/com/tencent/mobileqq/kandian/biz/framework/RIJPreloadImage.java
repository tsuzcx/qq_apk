package com.tencent.mobileqq.kandian.biz.framework;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
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
  private static int jdField_a_of_type_Int = 10;
  private static int b = 10;
  private long jdField_a_of_type_Long = 0L;
  
  private List<PreloadImgInfo> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    URL localURL;
    if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
      localURL = paramAbsBaseArticleInfo.mVideoCoverUrl;
    } else if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      localURL = paramAbsBaseArticleInfo.mSinglePicture;
    } else {
      localURL = RIJConvertString2URL.a(paramAbsBaseArticleInfo.mFirstPagePicUrl);
    }
    localArrayList.add(PreloadImgInfo.a(localURL, ReadInJoyDisplayUtils.g()));
    if ((paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0))
    {
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
      if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mVideoCoverUrl;
      } else if (paramAbsBaseArticleInfo.mSinglePicture != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSinglePicture;
      } else {
        paramAbsBaseArticleInfo = RIJConvertString2URL.a(paramAbsBaseArticleInfo.mFirstPagePicUrl);
      }
      localArrayList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo, ReadInJoyDisplayUtils.g()));
    }
    return localArrayList;
  }
  
  private void a(List<PreloadImgInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PreloadImgInfo localPreloadImgInfo = (PreloadImgInfo)paramList.next();
      if ((localPreloadImgInfo != null) && (localPreloadImgInfo.jdField_a_of_type_JavaNetURL != null))
      {
        if (TextUtils.equals("pubaccountimage", localPreloadImgInfo.jdField_a_of_type_JavaNetURL.getProtocol())) {
          localPreloadImgInfo.jdField_a_of_type_JavaNetURL = RIJConvertString2URL.a(localPreloadImgInfo.jdField_a_of_type_JavaNetURL.getFile(), false);
        }
        if (localPreloadImgInfo.jdField_a_of_type_JavaNetURL != null)
        {
          ImageRequest localImageRequest = new ImageRequest();
          RIJImageTypeOptHelper.a.a(localImageRequest, localPreloadImgInfo.jdField_a_of_type_JavaNetURL.toString());
          localImageRequest.jdField_a_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localImageRequest.jdField_b_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.second).intValue();
          localImageRequest.jdField_b_of_type_Boolean = true;
          ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, null);
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
        localArrayList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo[i], ReadInJoyDisplayUtils.a()));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cpu:");
      localStringBuilder.append(DeviceInfoUtil.b());
      localStringBuilder.append(" mem:");
      localStringBuilder.append(DeviceInfoUtil.a());
      localStringBuilder.append(" fre:");
      localStringBuilder.append(DeviceInfoUtil.b());
      QLog.d("RIJPreloadImage", 2, localStringBuilder.toString());
    }
    int i = DeviceInfoUtil.b();
    long l = DeviceInfoUtil.a();
    if ((i >= 4) && (l >= 1610612736.0D))
    {
      jdField_a_of_type_Int = 6;
      return;
    }
    jdField_a_of_type_Int = 4;
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
    if (!NetworkUtil.isWifiConnected(paramRIJDataManager.a().a())) {
      return;
    }
    Object localObject = new ArrayList(paramRIJDataManager.a());
    ThreadManager.post(new RIJPreloadImage.1(this, this.jdField_a_of_type_Long, (List)localObject, paramInt1, paramInt2, paramRIJDataManager, l), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!PreloadManager.a().a()) {
      return;
    }
    PreloadManager.a().e();
    int i = paramReadInJoyBaseAdapter.a();
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
      if ((localObject instanceof BaseArticleInfo))
      {
        localObject = (AbsBaseArticleInfo)localObject;
        if ((!RIJFeedsType.a(((AbsBaseArticleInfo)localObject).mArticleContentUrl, ((AbsBaseArticleInfo)localObject).mChannelID, (AbsBaseArticleInfo)localObject)) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!paramReadInJoyBaseAdapter.a(i, ((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().a((String)localObject);
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  @VisibleForTesting
  void a(List<PreloadImgInfo> paramList, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    paramInt = paramRIJDataManager.a().a().getItemViewType(paramInt);
    if (paramInt == 4)
    {
      if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mVideoCoverUrl;
      } else if (paramAbsBaseArticleInfo.mSinglePicture != null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSinglePicture;
      } else {
        paramAbsBaseArticleInfo = RIJConvertString2URL.a(paramAbsBaseArticleInfo.mFirstPagePicUrl);
      }
      paramList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo, ReadInJoyDisplayUtils.f()));
      return;
    }
    if ((paramInt != 70) && (paramInt != 46))
    {
      if ((paramInt != 3) && (paramInt != 14) && (paramInt != 105))
      {
        if ((paramInt != 2) && (paramInt != 6) && (paramInt != 66) && (paramInt != 115))
        {
          if ((paramInt == 1) || (paramInt == 5) || (paramInt == 104) || (paramInt == 106)) {
            paramList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo.mSinglePicture, ReadInJoyDisplayUtils.a()));
          }
        }
        else {
          paramList.add(PreloadImgInfo.a(paramAbsBaseArticleInfo.mSinglePicture, ReadInJoyDisplayUtils.e()));
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
    ((IImageManager)QRoute.api(IImageManager.class)).resume();
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "resume image onScrollStateChanged idle");
    }
    if (paramBoolean)
    {
      a(paramInt2, jdField_a_of_type_Int, paramRIJDataManager);
    }
    else
    {
      int i = jdField_a_of_type_Int;
      a(paramInt2 - i, i, paramRIJDataManager);
    }
    if ((paramInt1 - paramInt2 < jdField_b_of_type_Int) && (paramPrefetchListener != null)) {
      paramPrefetchListener.a();
    }
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
        int i = paramReadInJoyBaseAdapter.a(paramInt1);
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
      if (!ReadInJoyHelper.D(RIJQQAppInterfaceUtil.b())) {
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
      ReadInJoyLogicEngine.a().a().a(localArrayList);
    }
  }
  
  public void d(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!RIJWebArticleUtil.a.a()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage
 * JD-Core Version:    0.7.0.1
 */