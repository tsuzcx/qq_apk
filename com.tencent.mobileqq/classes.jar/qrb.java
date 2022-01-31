import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class qrb
  extends npt
{
  private boolean jdField_a_of_type_Boolean;
  
  public qrb(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    qlp localqlp = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    if (VideoFeedsRecommendFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) {}
    for (int i = 3;; i = 2)
    {
      localqlp.d(i);
      if (VideoFeedsRecommendFragment.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(false);
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).size() > 0) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).b((VideoInfo)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).get(0));
      }
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, Bundle paramBundle)
  {
    if ((VideoFeedsRecommendFragment.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment)) || (TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString)))
    {
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
      }
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(false);
    }
    for (;;)
    {
      if ((paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList != null) && (paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList == null) {
          paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList.addAll(paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList);
      }
      if ((paramVideoInfo2.jdField_b_of_type_Long <= 0L) && (paramVideoInfo1.jdField_b_of_type_Long > 0L)) {
        paramVideoInfo2.jdField_b_of_type_Long = paramVideoInfo1.jdField_b_of_type_Long;
      }
      if ((paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null))
      {
        paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
      }
      if (paramVideoInfo1.r > 0) {
        paramVideoInfo2.r = paramVideoInfo1.r;
      }
      if (paramVideoInfo1.jdField_f_of_type_Long > 0L) {
        paramVideoInfo2.jdField_f_of_type_Long = paramVideoInfo1.jdField_f_of_type_Long;
      }
      if ((paramVideoInfo2.jdField_b_of_type_Int <= 0) && (paramVideoInfo1.jdField_b_of_type_Int > 0)) {
        paramVideoInfo2.jdField_b_of_type_Int = paramVideoInfo1.jdField_b_of_type_Int;
      }
      if ((paramVideoInfo2.jdField_c_of_type_Int <= 0) && (paramVideoInfo1.jdField_c_of_type_Int > 0)) {
        paramVideoInfo2.jdField_c_of_type_Int = paramVideoInfo1.jdField_c_of_type_Int;
      }
      if ((paramVideoInfo2.jdField_d_of_type_Int <= 0) && (paramVideoInfo1.jdField_d_of_type_Int > 0)) {
        paramVideoInfo2.jdField_d_of_type_Int = paramVideoInfo1.jdField_d_of_type_Int;
      }
      if ((paramVideoInfo2.s <= 0) && (paramVideoInfo1.s > 0)) {
        paramVideoInfo2.s = paramVideoInfo1.s;
      }
      if ((paramVideoInfo2.t <= 0) && (paramVideoInfo1.t > 0)) {
        paramVideoInfo2.t = paramVideoInfo1.t;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.i)) {
        paramVideoInfo2.i = paramVideoInfo1.i;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_k_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_k_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_k_of_type_JavaLangString = paramVideoInfo1.jdField_k_of_type_JavaLangString;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.j)) && (!TextUtils.isEmpty(paramVideoInfo1.j))) {
        paramVideoInfo2.j = paramVideoInfo1.j;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.g)) && (!TextUtils.isEmpty(paramVideoInfo1.g))) {
        paramVideoInfo2.g = paramVideoInfo1.g;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_JavaLangString)))
      {
        paramVideoInfo2.jdField_a_of_type_JavaLangString = paramVideoInfo1.jdField_a_of_type_JavaLangString;
        paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_f_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_f_of_type_JavaLangString = paramVideoInfo1.jdField_f_of_type_JavaLangString;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_d_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_d_of_type_JavaLangString = paramVideoInfo1.jdField_d_of_type_JavaLangString;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString))) {
        paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.E)) && (!TextUtils.isEmpty(paramVideoInfo1.E))) {
        paramVideoInfo2.E = paramVideoInfo1.E;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.D)) && (!TextUtils.isEmpty(paramVideoInfo1.D))) {
        paramVideoInfo2.D = paramVideoInfo1.D;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.G)) && (!TextUtils.isEmpty(paramVideoInfo1.G))) {
        paramVideoInfo2.G = paramVideoInfo1.G;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.G)) && (!TextUtils.isEmpty(paramVideoInfo1.G))) {
        paramVideoInfo2.G = paramVideoInfo1.G;
      }
      if ((TextUtils.isEmpty(paramVideoInfo2.h)) && (!TextUtils.isEmpty(paramVideoInfo1.h))) {
        paramVideoInfo2.h = paramVideoInfo1.h;
      }
      if (!paramVideoInfo2.jdField_b_of_type_Boolean) {
        paramVideoInfo2.jdField_k_of_type_Boolean = paramVideoInfo1.jdField_k_of_type_Boolean;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.jdField_b_of_type_JavaLangString)) {
        paramVideoInfo2.jdField_b_of_type_JavaLangString = paramVideoInfo1.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.L)) {
        paramVideoInfo2.L = paramVideoInfo1.L;
      }
      if (!TextUtils.isEmpty(paramVideoInfo1.M)) {
        paramVideoInfo2.M = paramVideoInfo1.M;
      }
      a("subscribeText", paramVideoInfo2.L);
      a("subscribeColor", paramVideoInfo2.M);
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(paramVideoInfo2.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd);
      }
      paramVideoInfo1 = (VideoInfo.ECommerceEntranceInfo)paramBundle.getParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO");
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a(paramVideoInfo1);
      }
      paramVideoInfo2.o = 0;
      qoi.a(paramVideoInfo2);
      return;
      paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
    }
  }
  
  private void a(String paramString)
  {
    VideoFeedsPlayActivity.a(ajya.a(2131716186) + paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    VideoFeedsPlayActivity.a(ajya.a(2131716157) + paramString1 + " : " + paramString2);
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
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramList.next();
      if (localVideoInfo.jdField_c_of_type_Boolean)
      {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).add(localVideoInfo);
        a("info.adType=" + localVideoInfo.l + ", info.title=" + localVideoInfo.jdField_c_of_type_JavaLangString + ", adInfo.aid=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e + ", adInfo.traceid=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h + " add to videoDataList");
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
        if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.jdField_k_of_type_JavaLangString))) {
          localVideoInfo.jdField_k_of_type_JavaLangString = bbcz.b(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), localVideoInfo.j, true);
        }
        qoi.a(localVideoInfo);
        localVideoInfo.o = VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
        localArrayList.add(localVideoInfo.g);
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).add(localVideoInfo);
        VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).add(localObject);
      }
    }
    ozb.a().a(localArrayList, VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment));
    a("hasNewVideo = " + bool);
    return bool;
  }
  
  /* Error */
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 189	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 326
    //   10: invokestatic 196	ajya:a	(I)Ljava/lang/String;
    //   13: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 328
    //   19: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 318	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayActivity:a	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   36: aload_2
    //   37: ldc_w 330
    //   40: iconst_0
    //   41: invokevirtual 334	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   44: invokestatic 337	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   52: astore 10
    //   54: aload_0
    //   55: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   58: invokestatic 339	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   61: ifne +13 -> 74
    //   64: aload_0
    //   65: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   68: invokestatic 26	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   71: ifeq +130 -> 201
    //   74: iconst_1
    //   75: istore 5
    //   77: aload 10
    //   79: iload 5
    //   81: invokestatic 341	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
    //   84: pop
    //   85: iload_1
    //   86: ifne +121 -> 207
    //   89: aload_0
    //   90: invokespecial 343	qrb:a	()V
    //   93: aload_0
    //   94: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   97: invokestatic 339	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   100: ifne +83 -> 183
    //   103: aload_0
    //   104: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   107: invokestatic 26	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   110: ifne +73 -> 183
    //   113: aload_0
    //   114: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   117: invokestatic 346	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmu;
    //   120: ifnull +1366 -> 1486
    //   123: aload_0
    //   124: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   127: invokestatic 346	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmu;
    //   130: invokevirtual 350	qmu:a	()Z
    //   133: ifeq +1353 -> 1486
    //   136: aload_0
    //   137: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   140: invokestatic 353	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   143: iconst_0
    //   144: invokevirtual 358	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:setScrollable	(Z)V
    //   147: aload_0
    //   148: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   151: invokestatic 361	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqqz;
    //   154: ifnull +29 -> 183
    //   157: aload_0
    //   158: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   161: invokestatic 361	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqqz;
    //   164: aload_0
    //   165: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   168: invokestatic 339	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   171: aload_0
    //   172: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   175: invokestatic 26	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   178: invokeinterface 366 3 0
    //   183: aload_0
    //   184: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   187: invokestatic 368	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)I
    //   190: pop
    //   191: aload_0
    //   192: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   195: iconst_0
    //   196: invokestatic 370	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
    //   199: pop
    //   200: return
    //   201: iconst_0
    //   202: istore 5
    //   204: goto -127 -> 77
    //   207: aload_2
    //   208: ldc_w 372
    //   211: iconst_0
    //   212: invokevirtual 334	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   215: ifne +977 -> 1192
    //   218: aload_0
    //   219: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   222: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   225: invokevirtual 46	java/util/ArrayList:size	()I
    //   228: istore_3
    //   229: aload_2
    //   230: ldc_w 374
    //   233: invokevirtual 378	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   236: astore 11
    //   238: aload_2
    //   239: ldc_w 380
    //   242: invokevirtual 384	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 12
    //   247: aload_0
    //   248: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   251: aload_2
    //   252: ldc_w 386
    //   255: aconst_null
    //   256: invokevirtual 389	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   259: invokestatic 392	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Ljava/lang/String;)Ljava/lang/String;
    //   262: pop
    //   263: new 189	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 394
    //   273: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 12
    //   278: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 396
    //   284: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   291: invokestatic 399	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/lang/String;
    //   294: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayActivity:a	(Ljava/lang/String;)V
    //   303: aload_0
    //   304: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   307: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   310: invokevirtual 46	java/util/ArrayList:size	()I
    //   313: ifle +567 -> 880
    //   316: aload_0
    //   317: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   320: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   323: iconst_0
    //   324: invokevirtual 50	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   327: checkcast 52	com/tencent/biz/pubaccount/VideoInfo
    //   330: astore 10
    //   332: aload_2
    //   333: ldc_w 401
    //   336: invokevirtual 169	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   339: checkcast 52	com/tencent/biz/pubaccount/VideoInfo
    //   342: astore 13
    //   344: aload 10
    //   346: ifnull +135 -> 481
    //   349: aload_0
    //   350: getfield 16	qrb:jdField_a_of_type_Boolean	Z
    //   353: ifne +128 -> 481
    //   356: aload 13
    //   358: ifnull +123 -> 481
    //   361: aload_0
    //   362: aload 10
    //   364: aload 13
    //   366: aload_2
    //   367: invokespecial 403	qrb:a	(Lcom/tencent/biz/pubaccount/VideoInfo;Lcom/tencent/biz/pubaccount/VideoInfo;Landroid/os/Bundle;)V
    //   370: aload 10
    //   372: aload 13
    //   374: invokevirtual 404	com/tencent/biz/pubaccount/VideoInfo:a	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
    //   377: aload_0
    //   378: iconst_1
    //   379: putfield 16	qrb:jdField_a_of_type_Boolean	Z
    //   382: iload_3
    //   383: iconst_1
    //   384: if_icmpne +73 -> 457
    //   387: aload_0
    //   388: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   391: invokestatic 361	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqqz;
    //   394: ifnull +63 -> 457
    //   397: new 189	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 405
    //   407: invokestatic 196	ajya:a	(I)Ljava/lang/String;
    //   410: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 10
    //   415: invokevirtual 407	com/tencent/biz/pubaccount/VideoInfo:b	()Ljava/lang/String;
    //   418: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayActivity:a	(Ljava/lang/String;)V
    //   427: aload_0
    //   428: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   431: invokestatic 410	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqte;
    //   434: ifnull +23 -> 457
    //   437: aload_0
    //   438: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   441: invokestatic 410	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqte;
    //   444: aload 10
    //   446: aload_0
    //   447: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   450: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   453: iconst_1
    //   454: invokevirtual 418	qte:a	(Lcom/tencent/biz/pubaccount/VideoInfo;Lqmp;Z)V
    //   457: aload_0
    //   458: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   461: invokestatic 22	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqlp;
    //   464: aload 10
    //   466: invokevirtual 56	qlp:b	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
    //   469: aload_0
    //   470: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   473: invokestatic 22	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqlp;
    //   476: aload 10
    //   478: invokevirtual 419	qlp:a	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
    //   481: aload_0
    //   482: aload 11
    //   484: invokespecial 322	qrb:a	(Ljava/util/List;)Z
    //   487: istore_1
    //   488: aload_0
    //   489: aload 11
    //   491: iload_1
    //   492: invokespecial 421	qrb:a	(Ljava/util/ArrayList;Z)V
    //   495: aload_0
    //   496: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   499: invokestatic 22	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqlp;
    //   502: iconst_3
    //   503: invokevirtual 31	qlp:d	(I)V
    //   506: aload_0
    //   507: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   510: invokestatic 339	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   513: ifne +19 -> 532
    //   516: iload_3
    //   517: iconst_1
    //   518: if_icmpne +14 -> 532
    //   521: iload_1
    //   522: ifeq +10 -> 532
    //   525: aload_0
    //   526: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   529: invokestatic 424	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)V
    //   532: aload_0
    //   533: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   536: aload 12
    //   538: invokestatic 426	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Ljava/lang/String;)Ljava/lang/String;
    //   541: pop
    //   542: aload_0
    //   543: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   546: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   549: invokevirtual 46	java/util/ArrayList:size	()I
    //   552: iload_3
    //   553: isub
    //   554: istore 4
    //   556: aload_0
    //   557: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   560: invokestatic 429	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqkp;
    //   563: ifnull +23 -> 586
    //   566: aload_0
    //   567: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   570: invokestatic 429	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqkp;
    //   573: iload_1
    //   574: iload 4
    //   576: aload_0
    //   577: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   580: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   583: invokevirtual 434	qkp:a	(ZILjava/util/ArrayList;)V
    //   586: iload 4
    //   588: ifle +144 -> 732
    //   591: aload_0
    //   592: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   595: invokestatic 353	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   598: invokevirtual 436	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:a	()I
    //   601: iflt +285 -> 886
    //   604: aload_0
    //   605: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   608: invokestatic 353	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   611: invokevirtual 436	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:a	()I
    //   614: iload_3
    //   615: if_icmpne +271 -> 886
    //   618: aload_0
    //   619: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   622: invokestatic 22	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqlp;
    //   625: iload_3
    //   626: invokevirtual 439	qlp:notifyItemChanged	(I)V
    //   629: iload 4
    //   631: iconst_1
    //   632: isub
    //   633: ifle +20 -> 653
    //   636: aload_0
    //   637: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   640: invokestatic 22	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqlp;
    //   643: iload_3
    //   644: iconst_1
    //   645: iadd
    //   646: iload 4
    //   648: iconst_1
    //   649: isub
    //   650: invokevirtual 443	qlp:notifyItemRangeInserted	(II)V
    //   653: invokestatic 448	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +13 -> 669
    //   659: ldc_w 450
    //   662: iconst_2
    //   663: ldc_w 452
    //   666: invokestatic 455	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: invokestatic 448	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq +60 -> 732
    //   675: ldc_w 450
    //   678: iconst_2
    //   679: new 189	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 457
    //   689: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: iload_3
    //   693: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: ldc_w 459
    //   699: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_0
    //   703: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   706: invokestatic 353	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   709: invokevirtual 436	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:a	()I
    //   712: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   715: ldc_w 461
    //   718: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: iload 4
    //   723: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 455	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: aload_0
    //   733: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   736: invokestatic 464	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lnps;
    //   739: ifnull -646 -> 93
    //   742: aload_0
    //   743: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   746: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   749: ifnull -656 -> 93
    //   752: aload_0
    //   753: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   756: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   759: invokevirtual 472	qnv:a	()Lqnu;
    //   762: ifnull -669 -> 93
    //   765: aload_0
    //   766: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   769: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   772: invokevirtual 472	qnv:a	()Lqnu;
    //   775: invokestatic 477	oar:a	(Lqnu;)Z
    //   778: ifne -685 -> 93
    //   781: aload_2
    //   782: ldc_w 479
    //   785: invokevirtual 378	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   788: astore 10
    //   790: iload_3
    //   791: iconst_1
    //   792: isub
    //   793: ifge +109 -> 902
    //   796: iconst_0
    //   797: istore_3
    //   798: aload 13
    //   800: ifnull +32 -> 832
    //   803: aload 13
    //   805: getfield 482	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo	Lcom/tencent/biz/pubaccount/VideoInfo$AdTagInfo;
    //   808: astore_2
    //   809: aload 10
    //   811: ifnull +21 -> 832
    //   814: aload_2
    //   815: ifnull +17 -> 832
    //   818: aload_2
    //   819: getfield 485	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo:jdField_a_of_type_Int	I
    //   822: ifne +10 -> 832
    //   825: aload 10
    //   827: iconst_0
    //   828: aload_2
    //   829: invokevirtual 488	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   832: aload 10
    //   834: ifnull -741 -> 93
    //   837: aload 10
    //   839: invokevirtual 490	java/util/ArrayList:isEmpty	()Z
    //   842: ifne -749 -> 93
    //   845: aload 10
    //   847: invokevirtual 491	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   850: astore_2
    //   851: aload_2
    //   852: invokeinterface 239 1 0
    //   857: ifeq +52 -> 909
    //   860: aload_2
    //   861: invokeinterface 243 1 0
    //   866: checkcast 484	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo
    //   869: iload_3
    //   870: putfield 492	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo:jdField_b_of_type_Int	I
    //   873: iload_3
    //   874: iconst_1
    //   875: iadd
    //   876: istore_3
    //   877: goto -26 -> 851
    //   880: aconst_null
    //   881: astore 10
    //   883: goto -551 -> 332
    //   886: aload_0
    //   887: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   890: invokestatic 22	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqlp;
    //   893: iload_3
    //   894: iload 4
    //   896: invokevirtual 443	qlp:notifyItemRangeInserted	(II)V
    //   899: goto -230 -> 669
    //   902: iload_3
    //   903: iconst_1
    //   904: isub
    //   905: istore_3
    //   906: goto -108 -> 798
    //   909: aload_0
    //   910: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   913: invokestatic 495	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)J
    //   916: lstore 8
    //   918: aload_0
    //   919: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   922: invokestatic 293	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   925: astore_2
    //   926: lload 8
    //   928: lstore 6
    //   930: lload 8
    //   932: lconst_0
    //   933: lcmp
    //   934: ifne +20 -> 954
    //   937: lload 8
    //   939: lstore 6
    //   941: aload_2
    //   942: ifnull +12 -> 954
    //   945: aload_2
    //   946: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   949: invokestatic 506	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   952: lstore 6
    //   954: aload_0
    //   955: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   958: invokestatic 509	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqtl;
    //   961: ifnull +226 -> 1187
    //   964: aload_0
    //   965: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   968: invokestatic 512	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/VideoInfo;
    //   971: ifnull +216 -> 1187
    //   974: aload_0
    //   975: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   978: invokestatic 509	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqtl;
    //   981: aload_0
    //   982: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   985: invokestatic 512	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/VideoInfo;
    //   988: getfield 113	com/tencent/biz/pubaccount/VideoInfo:g	Ljava/lang/String;
    //   991: invokevirtual 516	qtl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   994: astore_2
    //   995: aload_0
    //   996: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   999: iconst_1
    //   1000: invokestatic 370	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
    //   1003: pop
    //   1004: aload_0
    //   1005: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1008: invokestatic 464	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lnps;
    //   1011: aload_0
    //   1012: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1015: invokestatic 519	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqrb;
    //   1018: lload 6
    //   1020: aload_0
    //   1021: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1024: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   1027: iconst_0
    //   1028: invokevirtual 50	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1031: checkcast 52	com/tencent/biz/pubaccount/VideoInfo
    //   1034: aload_0
    //   1035: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1038: invokestatic 521	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)I
    //   1041: aload_0
    //   1042: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1045: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   1048: aload_0
    //   1049: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1052: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   1055: iconst_0
    //   1056: invokevirtual 50	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1059: checkcast 52	com/tencent/biz/pubaccount/VideoInfo
    //   1062: getfield 104	com/tencent/biz/pubaccount/VideoInfo:i	Ljava/lang/String;
    //   1065: aload_0
    //   1066: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1069: invokestatic 523	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)J
    //   1072: iconst_1
    //   1073: iconst_0
    //   1074: aload_0
    //   1075: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1078: invokestatic 525	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/lang/String;
    //   1081: aload_0
    //   1082: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1085: invokestatic 527	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/lang/String;
    //   1088: aconst_null
    //   1089: aload_0
    //   1090: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1093: invokestatic 301	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)I
    //   1096: aload_2
    //   1097: aload_0
    //   1098: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1101: invokestatic 530	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)[B
    //   1104: aload 10
    //   1106: aload_0
    //   1107: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1110: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   1113: invokevirtual 531	qnv:a	()I
    //   1116: aload_0
    //   1117: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1120: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   1123: invokevirtual 533	qnv:b	()I
    //   1126: iconst_0
    //   1127: new 42	java/util/ArrayList
    //   1130: dup
    //   1131: aload_0
    //   1132: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1135: invokestatic 535	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/HashSet;
    //   1138: invokespecial 538	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   1141: invokevirtual 543	nps:a	(Lnpt;JLcom/tencent/biz/pubaccount/VideoInfo;ILjava/util/ArrayList;Ljava/lang/String;JZILjava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/WeishiRedDotInfo;ILjava/lang/String;[BLjava/util/ArrayList;IIILjava/util/ArrayList;)V
    //   1144: goto -1051 -> 93
    //   1147: astore_2
    //   1148: invokestatic 448	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1151: ifeq -1058 -> 93
    //   1154: ldc_w 450
    //   1157: iconst_2
    //   1158: new 189	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1165: ldc_w 545
    //   1168: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: aload_2
    //   1172: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1175: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: invokestatic 455	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1184: goto -1091 -> 93
    //   1187: aconst_null
    //   1188: astore_2
    //   1189: goto -194 -> 995
    //   1192: aload_2
    //   1193: ldc_w 550
    //   1196: invokevirtual 378	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1199: astore_2
    //   1200: aload_2
    //   1201: ifnull +10 -> 1211
    //   1204: aload_2
    //   1205: invokevirtual 490	java/util/ArrayList:isEmpty	()Z
    //   1208: ifeq +20 -> 1228
    //   1211: invokestatic 448	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1214: ifeq -1014 -> 200
    //   1217: ldc_w 450
    //   1220: iconst_2
    //   1221: ldc_w 552
    //   1224: invokestatic 455	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: return
    //   1228: aload_0
    //   1229: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1232: invokestatic 40	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
    //   1235: invokevirtual 491	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1238: astore 10
    //   1240: aload 10
    //   1242: invokeinterface 239 1 0
    //   1247: ifeq +83 -> 1330
    //   1250: aload 10
    //   1252: invokeinterface 243 1 0
    //   1257: checkcast 52	com/tencent/biz/pubaccount/VideoInfo
    //   1260: astore 11
    //   1262: aload 11
    //   1264: getfield 482	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo	Lcom/tencent/biz/pubaccount/VideoInfo$AdTagInfo;
    //   1267: ifnull -27 -> 1240
    //   1270: aload 11
    //   1272: getfield 482	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo	Lcom/tencent/biz/pubaccount/VideoInfo$AdTagInfo;
    //   1275: getfield 553	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1278: astore 12
    //   1280: iconst_0
    //   1281: istore_3
    //   1282: iload_3
    //   1283: aload_2
    //   1284: invokevirtual 46	java/util/ArrayList:size	()I
    //   1287: if_icmpge -47 -> 1240
    //   1290: aload_2
    //   1291: iload_3
    //   1292: invokevirtual 50	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1295: checkcast 555	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   1298: astore 13
    //   1300: aload 13
    //   1302: getfield 558	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mRowKey	Ljava/lang/String;
    //   1305: aload 12
    //   1307: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1310: ifeq +13 -> 1323
    //   1313: aload 11
    //   1315: aload 13
    //   1317: putfield 566	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   1320: goto -80 -> 1240
    //   1323: iload_3
    //   1324: iconst_1
    //   1325: iadd
    //   1326: istore_3
    //   1327: goto -45 -> 1282
    //   1330: aload_0
    //   1331: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1334: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   1337: ifnull +69 -> 1406
    //   1340: aload_0
    //   1341: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1344: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1347: ifnull +59 -> 1406
    //   1350: aload_0
    //   1351: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1354: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1357: getfield 571	qmp:a	Lqql;
    //   1360: ifnull +46 -> 1406
    //   1363: aload_0
    //   1364: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1367: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1370: getfield 571	qmp:a	Lqql;
    //   1373: getfield 576	qql:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   1376: ifnull +30 -> 1406
    //   1379: aload_0
    //   1380: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1383: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1386: astore_2
    //   1387: aload_0
    //   1388: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1391: invokestatic 467	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqnv;
    //   1394: aload_2
    //   1395: aload_0
    //   1396: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1399: invokestatic 578	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:e	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   1402: invokevirtual 581	qnv:a	(Lqmp;Z)Z
    //   1405: pop
    //   1406: aload_0
    //   1407: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1410: invokestatic 584	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqsu;
    //   1413: ifnull -1320 -> 93
    //   1416: aload_0
    //   1417: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1420: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1423: ifnull -1330 -> 93
    //   1426: aload_0
    //   1427: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1430: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1433: getfield 571	qmp:a	Lqql;
    //   1436: ifnull -1343 -> 93
    //   1439: aload_0
    //   1440: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1443: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1446: getfield 571	qmp:a	Lqql;
    //   1449: getfield 576	qql:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   1452: ifnull -1359 -> 93
    //   1455: aload_0
    //   1456: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1459: invokestatic 413	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqmp;
    //   1462: astore_2
    //   1463: aload_0
    //   1464: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1467: invokestatic 584	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lqsu;
    //   1470: aload_2
    //   1471: aload_0
    //   1472: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1475: invokestatic 578	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:e	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
    //   1478: dconst_0
    //   1479: lconst_0
    //   1480: invokevirtual 589	qsu:a	(Lqmp;ZDJ)V
    //   1483: goto -1390 -> 93
    //   1486: aload_0
    //   1487: getfield 11	qrb:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
    //   1490: invokestatic 353	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   1493: iconst_1
    //   1494: invokevirtual 358	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:setScrollable	(Z)V
    //   1497: goto -1350 -> 147
    //   1500: astore_2
    //   1501: lload 8
    //   1503: lstore 6
    //   1505: goto -551 -> 954
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1508	0	this	qrb
    //   0	1508	1	paramBoolean	boolean
    //   0	1508	2	paramBundle	Bundle
    //   228	1099	3	i	int
    //   554	341	4	j	int
    //   75	128	5	bool	boolean
    //   928	576	6	l1	long
    //   916	586	8	l2	long
    //   52	1199	10	localObject1	Object
    //   236	1078	11	localObject2	Object
    //   245	1061	12	str	String
    //   342	974	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   732	790	1147	java/lang/Exception
    //   803	809	1147	java/lang/Exception
    //   818	832	1147	java/lang/Exception
    //   837	851	1147	java/lang/Exception
    //   851	873	1147	java/lang/Exception
    //   909	926	1147	java/lang/Exception
    //   954	995	1147	java/lang/Exception
    //   995	1144	1147	java/lang/Exception
    //   945	954	1500	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrb
 * JD-Core Version:    0.7.0.1
 */