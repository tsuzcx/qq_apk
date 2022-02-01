package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.util.ValueJudgeUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class VideoFeedsRecommendFragment$PlayRecommendObserver
  extends VideoPlayRecommendObserver
{
  private boolean jdField_a_of_type_Boolean = false;
  
  public VideoFeedsRecommendFragment$PlayRecommendObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    VideoFeedsAdapter localVideoFeedsAdapter = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
    int i;
    if (VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment)) {
      i = 3;
    } else {
      i = 2;
    }
    localVideoFeedsAdapter.e(i);
    if (VideoFeedsRecommendFragment.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment)) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).b(false);
    }
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).size() > 0) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a((VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).get(0));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).size() - paramInt1;
    if (paramInt1 > 0)
    {
      if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a() >= 0) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a() == paramInt2))
      {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).notifyItemChanged(paramInt2);
        int i = paramInt1 - 1;
        if (i > 0) {
          VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).notifyItemRangeInserted(paramInt2 + 1, i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendFragment", 2, "notifyItemChanged: ");
        }
      }
      else
      {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).notifyItemRangeInserted(paramInt2, paramInt1);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyItemChanged: footerPosition=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", currentPosition=");
        localStringBuilder.append(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a());
        localStringBuilder.append(", newVideoSize=");
        localStringBuilder.append(paramInt1);
        QLog.d("VideoFeedsRecommendFragment", 2, localStringBuilder.toString());
      }
    }
    SoftAdExpoStatManager.a().b(paramInt1);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("VALUE_REQUEST_GAME_DATA", false))
    {
      c(paramBundle);
      return;
    }
    b(paramBundle);
  }
  
  private void a(Bundle paramBundle, int paramInt, VideoInfo paramVideoInfo)
  {
    for (;;)
    {
      try
      {
        if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a() != null))
        {
          ArrayList localArrayList1 = paramBundle.getParcelableArrayList("value_msg_kd_tag_info");
          paramInt = Math.max(paramInt - 1, 0);
          a(paramVideoInfo, localArrayList1);
          if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
          {
            paramBundle = localArrayList1.iterator();
            if (paramBundle.hasNext())
            {
              ((VideoInfo.AdTagInfo)paramBundle.next()).jdField_b_of_type_Int = paramInt;
              paramInt += 1;
              continue;
            }
            long l2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            paramBundle = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            long l1 = l2;
            if (l2 == 0L)
            {
              l1 = l2;
              if (paramBundle != null) {
                try
                {
                  l1 = Long.parseLong(paramBundle.getCurrentAccountUin());
                }
                catch (Exception paramBundle)
                {
                  QLog.e("VideoFeedsRecommendFragment", 2, paramBundle, new Object[0]);
                  l1 = l2;
                }
              }
            }
            if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) == null)) {
              break label492;
            }
            paramBundle = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).g);
            VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, true);
            paramVideoInfo = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            PlayRecommendObserver localPlayRecommendObserver = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            VideoInfo localVideoInfo = (VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).get(0);
            int i = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            ArrayList localArrayList2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            String str1 = ((VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).get(0)).i;
            l2 = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            String str2 = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            String str3 = VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            int j = VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            byte[] arrayOfByte = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
            int k = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a();
            int m = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).b();
            ArrayList localArrayList3 = new ArrayList(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
            if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) == null) {
              paramInt = 0;
            } else {
              paramInt = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).jdField_c_of_type_Int;
            }
            paramVideoInfo.a(localPlayRecommendObserver, l1, localVideoInfo, i, localArrayList2, str1, l2, true, 0, str2, str3, null, j, paramBundle, arrayOfByte, localArrayList1, k, m, 0, localArrayList3, paramInt);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          paramVideoInfo = new StringBuilder();
          paramVideoInfo.append("onGetRecommend: to get game ad info error,e=");
          paramVideoInfo.append(paramBundle.getMessage());
          QLog.d("VideoFeedsRecommendFragment", 2, paramVideoInfo.toString());
        }
      }
      return;
      label492:
      paramBundle = null;
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2)
  {
    if ((paramVideoInfo1 != null) && (!this.jdField_a_of_type_Boolean) && (paramVideoInfo2 != null))
    {
      a(paramVideoInfo1, paramVideoInfo2, paramBundle);
      paramVideoInfo1.a(paramVideoInfo2);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt == 1) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null))
      {
        paramBundle = new StringBuilder();
        paramBundle.append(HardCodeUtil.a(2131715900));
        paramBundle.append(paramVideoInfo1.e());
        VideoFeedsPlayActivity.a(paramBundle.toString());
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
      }
      VideoFeedsDiversionHandler.a.a(paramVideoInfo1);
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(paramVideoInfo1);
      ThreadManager.excute(new VideoFeedsRecommendFragment.PlayRecommendObserver.1(this, paramVideoInfo1), 16, null, true);
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(paramVideoInfo1);
      }
    }
  }
  
  private void a(@Nullable VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)) {
      ReadInJoyCommentDataManager.a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, paramVideoInfo.m);
    }
  }
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, Bundle paramBundle)
  {
    if ((!VideoFeedsRecommendFragment.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString)))
    {
      paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
    }
    else
    {
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
      }
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).b(false);
    }
    if ((paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList != null) && (paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if (paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList == null) {
        paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList.addAll(paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList);
    }
    paramVideoInfo2.jdField_b_of_type_Long = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_b_of_type_Long, paramVideoInfo1.jdField_b_of_type_Long);
    if ((paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null))
    {
      paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
    }
    paramVideoInfo2.jdField_p_of_type_Int = paramVideoInfo1.jdField_p_of_type_Int;
    paramVideoInfo2.jdField_f_of_type_Long = paramVideoInfo1.jdField_f_of_type_Long;
    paramVideoInfo2.jdField_b_of_type_Int = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_b_of_type_Int, paramVideoInfo1.jdField_b_of_type_Int);
    paramVideoInfo2.jdField_c_of_type_Int = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_c_of_type_Int, paramVideoInfo1.jdField_c_of_type_Int);
    paramVideoInfo2.jdField_d_of_type_Int = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_d_of_type_Int, paramVideoInfo1.jdField_d_of_type_Int);
    paramVideoInfo2.q = ValueJudgeUtil.a.a(paramVideoInfo2.q, paramVideoInfo1.q);
    paramVideoInfo2.jdField_r_of_type_Int = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_r_of_type_Int, paramVideoInfo1.jdField_r_of_type_Int);
    paramVideoInfo2.i = paramVideoInfo1.i;
    paramVideoInfo2.jdField_k_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_k_of_type_JavaLangString, paramVideoInfo1.jdField_k_of_type_JavaLangString);
    paramVideoInfo2.j = ValueJudgeUtil.a.a(paramVideoInfo2.j, paramVideoInfo1.j);
    paramVideoInfo2.g = ValueJudgeUtil.a.a(paramVideoInfo2.g, paramVideoInfo1.g);
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_JavaLangString)))
    {
      paramVideoInfo2.jdField_a_of_type_JavaLangString = paramVideoInfo1.jdField_a_of_type_JavaLangString;
      paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
    }
    paramVideoInfo2.jdField_f_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_f_of_type_JavaLangString, paramVideoInfo1.jdField_f_of_type_JavaLangString);
    paramVideoInfo2.jdField_d_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_d_of_type_JavaLangString, paramVideoInfo1.jdField_d_of_type_JavaLangString);
    paramVideoInfo2.jdField_c_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_c_of_type_JavaLangString, paramVideoInfo1.jdField_c_of_type_JavaLangString);
    paramVideoInfo2.jdField_p_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_p_of_type_JavaLangString, paramVideoInfo1.jdField_p_of_type_JavaLangString);
    paramVideoInfo2.o = ValueJudgeUtil.a.a(paramVideoInfo2.o, paramVideoInfo1.o);
    paramVideoInfo2.jdField_r_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo2.jdField_r_of_type_JavaLangString, paramVideoInfo1.jdField_r_of_type_JavaLangString);
    paramVideoInfo2.h = ValueJudgeUtil.a.a(paramVideoInfo2.h, paramVideoInfo1.h);
    if (!paramVideoInfo2.jdField_b_of_type_Boolean) {
      paramVideoInfo2.jdField_p_of_type_Boolean = paramVideoInfo1.jdField_p_of_type_Boolean;
    }
    paramVideoInfo2.jdField_b_of_type_JavaLangString = ValueJudgeUtil.a.a(paramVideoInfo1.jdField_b_of_type_JavaLangString, paramVideoInfo2.jdField_b_of_type_JavaLangString);
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd);
    }
    paramVideoInfo1 = (VideoInfo.ECommerceEntranceInfo)paramBundle.getParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO");
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(paramVideoInfo1);
    }
    paramVideoInfo2.jdField_k_of_type_Int = 0;
    VideoFeedsHelper.a(paramVideoInfo2);
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo.AdTagInfo> paramArrayList)
  {
    if (paramVideoInfo != null)
    {
      paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo;
      if ((paramArrayList != null) && (paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_Int == 0)) {
        paramArrayList.add(0, paramVideoInfo);
      }
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayRecommendObserver() logRecommendVideoInfo");
    localStringBuilder.append(paramString);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
  }
  
  private void a(ArrayList<AdvertisementInfo> paramArrayList)
  {
    Iterator localIterator = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).iterator();
    label120:
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo != null) && (paramArrayList != null))
      {
        String str = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo.jdField_a_of_type_JavaLangString;
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayList.size()) {
            break label120;
          }
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.get(i);
          if (localAdvertisementInfo.mRowKey.equals(str))
          {
            ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).setAdvertisementInfo(localVideoInfo, localAdvertisementInfo);
            VideoFeedsDiversionHandler.a.a(localVideoInfo);
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(ArrayList<VideoInfo> paramArrayList, boolean paramBoolean)
  {
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    } else {
      i = 0;
    }
    if ((1 == VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).size() - i) && (paramBoolean) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).get(1) != null))
    {
      paramArrayList = (VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).get(1);
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, paramArrayList);
    }
  }
  
  private boolean a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    if (paramList == null)
    {
      a("articleList为空");
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("articleList.size()=: ");
    ((StringBuilder)localObject1).append(paramList.size());
    a(((StringBuilder)localObject1).toString());
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject1).next();
      Object localObject2;
      if (localVideoInfo.jdField_r_of_type_Boolean)
      {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).add(localVideoInfo);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("info.adType=");
        ((StringBuilder)localObject2).append(localVideoInfo.t);
        ((StringBuilder)localObject2).append(", info.title=");
        ((StringBuilder)localObject2).append(localVideoInfo.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", adInfo.aid=");
        ((StringBuilder)localObject2).append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.e);
        ((StringBuilder)localObject2).append(", adInfo.traceid=");
        ((StringBuilder)localObject2).append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.h);
        ((StringBuilder)localObject2).append(" add to videoDataList");
        a(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localVideoInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(localVideoInfo.g);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).contains(localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("info.vid=");
          ((StringBuilder)localObject2).append(localVideoInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(", info.title=");
          ((StringBuilder)localObject2).append(localVideoInfo.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(", info.articleID=");
          ((StringBuilder)localObject2).append(localVideoInfo.g);
          ((StringBuilder)localObject2).append(" has exist");
          a(((StringBuilder)localObject2).toString());
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("info.vid=");
        localStringBuilder.append(localVideoInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(", info.title=");
        localStringBuilder.append(localVideoInfo.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(", info.articleID=");
        localStringBuilder.append(localVideoInfo.g);
        localStringBuilder.append(" add to videoDataList");
        a(localStringBuilder.toString());
        if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.jdField_k_of_type_JavaLangString))) {
          localVideoInfo.jdField_k_of_type_JavaLangString = ContactUtils.a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), localVideoInfo.j, true);
        }
        VideoFeedsHelper.a(localVideoInfo);
        localVideoInfo.jdField_k_of_type_Int = VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
        localArrayList.add(localVideoInfo.g);
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).add(localVideoInfo);
        VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).add(localObject2);
        a(localVideoInfo);
      }
      bool = true;
    }
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
    }
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, paramList);
    VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, paramList);
    paramList = new StringBuilder();
    paramList.append("hasNewVideo = ");
    paramList.append(bool);
    a(paramList.toString());
    return bool;
  }
  
  private void b(Bundle paramBundle)
  {
    int i = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).size();
    if (i == 1) {
      SoftAdExpoStatManager.a().a(-1);
    }
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    String str = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    VideoInfo localVideoInfo = null;
    VideoFeedsRecommendFragment.a((VideoFeedsRecommendFragment)localObject, paramBundle.getString("VALUE_COOKIE", null));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoPlayRecommendObserver() reqArticleID = ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", mLastRequestArticleID = ");
    ((StringBuilder)localObject).append(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
    VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).size() > 0) {
      localVideoInfo = (VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).get(0);
    }
    localObject = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    a((VideoInfo)localObject);
    a(paramBundle, i, localVideoInfo, (VideoInfo)localObject);
    boolean bool = a(localArrayList);
    a(localArrayList, bool);
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).e(3);
    if ((!VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment)) && (i == 1) && (bool)) {
      VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
    }
    VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, str);
    int j = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).size();
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(bool, j - i, VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
    }
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a();
    }
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotTimeStrategy()) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotMixStrategy()) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null)) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).e();
    }
    a(i, i);
    a(paramBundle, i, (VideoInfo)localObject);
  }
  
  private void c(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelableArrayList("value_msg_game_ad_info");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      a(paramBundle);
      if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a.a != null))
      {
        if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
          VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
        }
        if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
          VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), 0.0D, 0L);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "get gameAdComData isEmpty");
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131715964));
    ((StringBuilder)localObject).append("isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
    VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, paramBundle.getBoolean("VALUE_USER_IN_BLACK", false));
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if ((!VideoFeedsRecommendFragment.a((VideoFeedsRecommendFragment)localObject)) && (!VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment))) {
      bool = false;
    } else {
      bool = true;
    }
    VideoFeedsRecommendFragment.c((VideoFeedsRecommendFragment)localObject, bool);
    boolean bool = paramBundle.getBoolean("VALUE_REQUEST_GAME_DATA", false);
    if (paramBoolean) {
      a(paramBundle);
    } else {
      a();
    }
    if (!bool) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
    }
    if ((!VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment)) && (!VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment)))
    {
      if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).b())) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).setScrollable(false);
      } else {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).setScrollable(true);
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
      }
    }
    VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.PlayRecommendObserver
 * JD-Core Version:    0.7.0.1
 */