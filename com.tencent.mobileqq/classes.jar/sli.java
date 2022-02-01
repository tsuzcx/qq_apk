import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.PlayRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class sli
  extends omw
{
  private boolean a;
  
  public sli(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    shl localshl = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    if (VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) {}
    for (int i = 3;; i = 2)
    {
      localshl.c(i);
      if (VideoFeedsRecommendFragment.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(false);
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size() > 0) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a((VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(0));
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size() - paramInt1;
    if (paramInt1 > 0)
    {
      if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a() < 0) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a() != paramInt2)) {
        break label157;
      }
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).notifyItemChanged(paramInt2);
      if (paramInt1 - 1 > 0) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).notifyItemRangeInserted(paramInt2 + 1, paramInt1 - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "notifyItemChanged: ");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "notifyItemChanged: footerPosition=" + paramInt2 + ", currentPosition=" + VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a() + ", newVideoSize=" + paramInt1);
      }
      olx.a().b(paramInt1);
      return;
      label157:
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).notifyItemRangeInserted(paramInt2, paramInt1);
    }
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
        if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a() == null)) {
          return;
        }
        localArrayList1 = paramBundle.getParcelableArrayList("value_msg_kd_tag_info");
        paramInt = Math.max(paramInt - 1, 0);
        a(paramVideoInfo, localArrayList1);
        if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
          return;
        }
        paramBundle = localArrayList1.iterator();
        if (paramBundle.hasNext())
        {
          ((VideoInfo.AdTagInfo)paramBundle.next()).jdField_b_of_type_Int = paramInt;
          paramInt += 1;
          continue;
        }
        l2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
        paramBundle = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = l2;
          if (paramBundle == null) {}
        }
      }
      catch (Exception paramBundle)
      {
        ArrayList localArrayList1;
        long l2;
        long l1;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VideoFeedsRecommendFragment", 2, "onGetRecommend: to get game ad info error,e=" + paramBundle.getMessage());
        return;
        paramBundle = null;
        continue;
        paramInt = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).jdField_c_of_type_Int;
        continue;
      }
      try
      {
        l1 = Long.parseLong(paramBundle.getCurrentAccountUin());
        if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null))
        {
          paramBundle = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).g);
          VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, true);
          paramVideoInfo = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          sli localsli = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          VideoInfo localVideoInfo = (VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(0);
          int i = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          ArrayList localArrayList2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          String str1 = ((VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(0)).jdField_i_of_type_JavaLangString;
          l2 = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          String str2 = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          String str3 = VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          int j = VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          byte[] arrayOfByte = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
          int k = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a();
          int m = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).b();
          ArrayList localArrayList3 = new ArrayList(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
          if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
            continue;
          }
          paramInt = 0;
          paramVideoInfo.a(localsli, l1, localVideoInfo, i, localArrayList2, str1, l2, true, 0, str2, str3, null, j, paramBundle, arrayOfByte, localArrayList1, k, m, 0, localArrayList3, paramInt);
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("VideoFeedsRecommendFragment", 2, paramBundle, new Object[0]);
        l1 = l2;
      }
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2)
  {
    if ((paramVideoInfo1 != null) && (!this.jdField_a_of_type_Boolean) && (paramVideoInfo2 != null))
    {
      a(paramVideoInfo1, paramVideoInfo2, paramBundle);
      paramVideoInfo1.a(paramVideoInfo2);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt == 1) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null)) {
        VideoFeedsPlayActivity.a(anvx.a(2131715511) + paramVideoInfo1.b());
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
      }
      sii.a.a(paramVideoInfo1);
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(paramVideoInfo1);
      ThreadManager.excute(new VideoFeedsRecommendFragment.PlayRecommendObserver.1(this, paramVideoInfo1), 16, null, true);
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(paramVideoInfo1);
      }
    }
  }
  
  private void a(@Nullable VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
      pdv.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramVideoInfo.n);
    }
  }
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, Bundle paramBundle)
  {
    if ((VideoFeedsRecommendFragment.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) || (TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString)))
    {
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
      }
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(false);
    }
    for (;;)
    {
      if ((paramVideoInfo1.jdField_a_of_type_JavaUtilArrayList != null) && (paramVideoInfo1.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramVideoInfo2.jdField_a_of_type_JavaUtilArrayList == null) {
          paramVideoInfo2.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        paramVideoInfo2.jdField_a_of_type_JavaUtilArrayList.addAll(paramVideoInfo1.jdField_a_of_type_JavaUtilArrayList);
      }
      paramVideoInfo2.jdField_b_of_type_Long = uwp.a.a(paramVideoInfo2.jdField_b_of_type_Long, paramVideoInfo1.jdField_b_of_type_Long);
      if ((paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null))
      {
        paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
      }
      paramVideoInfo2.jdField_q_of_type_Int = paramVideoInfo1.jdField_q_of_type_Int;
      paramVideoInfo2.jdField_f_of_type_Long = paramVideoInfo1.jdField_f_of_type_Long;
      paramVideoInfo2.jdField_b_of_type_Int = uwp.a.a(paramVideoInfo2.jdField_b_of_type_Int, paramVideoInfo1.jdField_b_of_type_Int);
      paramVideoInfo2.jdField_c_of_type_Int = uwp.a.a(paramVideoInfo2.jdField_c_of_type_Int, paramVideoInfo1.jdField_c_of_type_Int);
      paramVideoInfo2.jdField_d_of_type_Int = uwp.a.a(paramVideoInfo2.jdField_d_of_type_Int, paramVideoInfo1.jdField_d_of_type_Int);
      paramVideoInfo2.jdField_r_of_type_Int = uwp.a.a(paramVideoInfo2.jdField_r_of_type_Int, paramVideoInfo1.jdField_r_of_type_Int);
      paramVideoInfo2.s = uwp.a.a(paramVideoInfo2.s, paramVideoInfo1.s);
      paramVideoInfo2.jdField_i_of_type_JavaLangString = paramVideoInfo1.jdField_i_of_type_JavaLangString;
      paramVideoInfo2.k = uwp.a.a(paramVideoInfo2.k, paramVideoInfo1.k);
      paramVideoInfo2.j = uwp.a.a(paramVideoInfo2.j, paramVideoInfo1.j);
      paramVideoInfo2.g = uwp.a.a(paramVideoInfo2.g, paramVideoInfo1.g);
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_JavaLangString)))
      {
        paramVideoInfo2.jdField_a_of_type_JavaLangString = paramVideoInfo1.jdField_a_of_type_JavaLangString;
        paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
      }
      paramVideoInfo2.jdField_f_of_type_JavaLangString = uwp.a.a(paramVideoInfo2.jdField_f_of_type_JavaLangString, paramVideoInfo1.jdField_f_of_type_JavaLangString);
      paramVideoInfo2.jdField_d_of_type_JavaLangString = uwp.a.a(paramVideoInfo2.jdField_d_of_type_JavaLangString, paramVideoInfo1.jdField_d_of_type_JavaLangString);
      paramVideoInfo2.jdField_c_of_type_JavaLangString = uwp.a.a(paramVideoInfo2.jdField_c_of_type_JavaLangString, paramVideoInfo1.jdField_c_of_type_JavaLangString);
      paramVideoInfo2.p = uwp.a.a(paramVideoInfo2.p, paramVideoInfo1.p);
      paramVideoInfo2.o = uwp.a.a(paramVideoInfo2.o, paramVideoInfo1.o);
      paramVideoInfo2.jdField_r_of_type_JavaLangString = uwp.a.a(paramVideoInfo2.jdField_r_of_type_JavaLangString, paramVideoInfo1.jdField_r_of_type_JavaLangString);
      paramVideoInfo2.h = uwp.a.a(paramVideoInfo2.h, paramVideoInfo1.h);
      if (!paramVideoInfo2.jdField_b_of_type_Boolean) {
        paramVideoInfo2.jdField_q_of_type_Boolean = paramVideoInfo1.jdField_q_of_type_Boolean;
      }
      paramVideoInfo2.jdField_b_of_type_JavaLangString = uwp.a.a(paramVideoInfo1.jdField_b_of_type_JavaLangString, paramVideoInfo2.jdField_b_of_type_JavaLangString);
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(paramVideoInfo2.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd);
      }
      paramVideoInfo1 = (VideoInfo.ECommerceEntranceInfo)paramBundle.getParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO");
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(paramVideoInfo1);
      }
      paramVideoInfo2.l = 0;
      six.a(paramVideoInfo2);
      return;
      paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo.AdTagInfo> paramArrayList)
  {
    if (paramVideoInfo != null)
    {
      paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo;
      if ((paramArrayList != null) && (paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_Int == 0)) {
        paramArrayList.add(0, paramVideoInfo);
      }
    }
  }
  
  private void a(String paramString)
  {
    VideoFeedsPlayActivity.a("VideoPlayRecommendObserver() logRecommendVideoInfo" + paramString);
  }
  
  private void a(ArrayList<AdvertisementInfo> paramArrayList)
  {
    Iterator localIterator = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).iterator();
    label109:
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramArrayList != null))
      {
        String str = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.jdField_a_of_type_JavaLangString;
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayList.size()) {
            break label109;
          }
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.get(i);
          if (localAdvertisementInfo.mRowKey.equals(str))
          {
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
            sii.a.a(localVideoInfo);
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(ArrayList<VideoInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
      if ((1 == VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size() - i) && (paramBoolean) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(1) != null))
      {
        paramArrayList = (VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(1);
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, paramArrayList);
      }
      return;
    }
  }
  
  private boolean a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      a("articleList为空");
      return false;
    }
    a("articleList.size()=: " + paramList.size());
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if (localVideoInfo.jdField_c_of_type_Boolean)
      {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).add(localVideoInfo);
        a("info.adType=" + localVideoInfo.jdField_i_of_type_Int + ", info.title=" + localVideoInfo.jdField_c_of_type_JavaLangString + ", adInfo.aid=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e + ", adInfo.traceid=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h + " add to videoDataList");
      }
      for (;;)
      {
        bool = true;
        break;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localVideoInfo.jdField_a_of_type_JavaLangString).append(" ").append(localVideoInfo.g);
        localObject = ((StringBuilder)localObject).toString();
        if (VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).contains(localObject))
        {
          a("info.vid=" + localVideoInfo.jdField_a_of_type_JavaLangString + ", info.title=" + localVideoInfo.jdField_c_of_type_JavaLangString + ", info.articleID=" + localVideoInfo.g + " has exist");
          break;
        }
        a("info.vid=" + localVideoInfo.jdField_a_of_type_JavaLangString + ", info.title=" + localVideoInfo.jdField_c_of_type_JavaLangString + ", info.articleID=" + localVideoInfo.g + " add to videoDataList");
        if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
          localVideoInfo.k = ContactUtils.getBuddyName(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), localVideoInfo.j, true);
        }
        six.a(localVideoInfo);
        localVideoInfo.l = VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
        localArrayList.add(localVideoInfo.g);
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).add(localVideoInfo);
        VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).add(localObject);
        a(localVideoInfo);
      }
    }
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
    }
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, paramList);
    VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, paramList);
    a("hasNewVideo = " + bool);
    return bool;
  }
  
  private void b(Bundle paramBundle)
  {
    int i = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size();
    if (i == 1) {
      olx.a().a(-1);
    }
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    String str = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, paramBundle.getString("VALUE_COOKIE", null));
    VideoFeedsPlayActivity.a("VideoPlayRecommendObserver() reqArticleID = " + str + ", mLastRequestArticleID = " + VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size() > 0) {}
    for (VideoInfo localVideoInfo1 = (VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(0);; localVideoInfo1 = null)
    {
      VideoInfo localVideoInfo2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
      a(localVideoInfo2);
      a(paramBundle, i, localVideoInfo1, localVideoInfo2);
      boolean bool = a(localArrayList);
      a(localArrayList, bool);
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).c(3);
      if ((!VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) && (i == 1) && (bool)) {
        VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
      }
      VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, str);
      int j = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size();
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(bool, j - i, VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a();
      }
      if ((uls.c()) && (uls.b()) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null)) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).e();
      }
      a(i, i);
      a(paramBundle, i, localVideoInfo2);
      return;
    }
  }
  
  private void c(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelableArrayList("value_msg_game_ad_info");
    if ((paramBundle == null) || (paramBundle.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "get gameAdComData isEmpty");
      }
    }
    do
    {
      do
      {
        return;
        a(paramBundle);
      } while ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a.a == null));
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
      }
    } while (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) == null);
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), 0.0D, 0L);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    VideoFeedsPlayActivity.a(anvx.a(2131715575) + "isSuccess = " + paramBoolean);
    VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, paramBundle.getBoolean("VALUE_USER_IN_BLACK", false));
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
    boolean bool;
    if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) || (VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)))
    {
      bool = true;
      VideoFeedsRecommendFragment.c(localVideoFeedsRecommendFragment, bool);
      bool = paramBundle.getBoolean("VALUE_REQUEST_GAME_DATA", false);
      if (!paramBoolean) {
        break label217;
      }
      a(paramBundle);
      label100:
      if (!bool) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
      }
      if ((!VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) && (!VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)))
      {
        if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) == null) || (!VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).b())) {
          break label224;
        }
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).setScrollable(false);
      }
    }
    for (;;)
    {
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
      }
      VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment, false);
      return;
      bool = false;
      break;
      label217:
      a();
      break label100;
      label224:
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).setScrollable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sli
 * JD-Core Version:    0.7.0.1
 */