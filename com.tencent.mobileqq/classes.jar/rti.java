import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rti
  implements sde, seg
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private sdc jdField_a_of_type_Sdc;
  private sdg jdField_a_of_type_Sdg;
  private slt jdField_a_of_type_Slt;
  public boolean a;
  
  public rti(Activity paramActivity, slt paramslt, sdc paramsdc, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Slt = paramslt;
    this.jdField_a_of_type_Sdc = paramsdc;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new rtj(this, Looper.getMainLooper());
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramProteusItemView instanceof qhg)) && (paramProteusItemView.getNativeView() != null)) {
      ((ReadInJoyAdVideoGuide)((qhg)paramProteusItemView).getNativeView()).setVisibility(8);
    }
  }
  
  private void a(sdg paramsdg)
  {
    int i;
    if ((paramsdg != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131380831);
        if (((localObject instanceof pwe)) && (((pwe)localObject).a() == paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((localView instanceof ProteusItemView))) {
          a((ProteusItemView)localView);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(sdg paramsdg, ProteusItemView paramProteusItemView)
  {
    Object localObject1 = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
    AdvertisementInfo localAdvertisementInfo;
    String str3;
    String str4;
    Object localObject2;
    if (((localObject1 instanceof qhg)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((qhg)localObject1).getNativeView();
      localAdvertisementInfo = (AdvertisementInfo)paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      localObject1 = "";
      str3 = "";
      str4 = "";
      localObject2 = str3;
    }
    try
    {
      String str2 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
      localObject3 = str4;
      String str1 = str3;
      localObject2 = str3;
      localObject1 = str2;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
      {
        localObject2 = str3;
        localObject1 = str2;
        JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
        localObject3 = str4;
        str1 = str3;
        if (localJSONArray != null)
        {
          localObject3 = str4;
          str1 = str3;
          localObject2 = str3;
          localObject1 = str2;
          if (localJSONArray.length() > 0)
          {
            localObject2 = str3;
            localObject1 = str2;
            localObject3 = localJSONArray.getJSONObject(0);
            localObject2 = str3;
            localObject1 = str2;
            str1 = ((JSONObject)localObject3).optString("thirdIcon");
            localObject2 = str1;
            localObject1 = str2;
            localObject3 = ((JSONObject)localObject3).optString("thirdName");
          }
        }
      }
      localObject1 = str2;
      localObject2 = str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RecommendADVideoFeedsManager", 1, "showGuideView, e=" + localJSONException.getMessage());
        Object localObject3 = "";
      }
    }
    localReadInJoyAdVideoGuide.setBtnInfo(localAdvertisementInfo.mAdBtnTxt);
    localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, (String)localObject2, (String)localObject3, (String)localObject1, twr.d(localAdvertisementInfo), localAdvertisementInfo);
    localReadInJoyAdVideoGuide.setAdGuideClickListener(new rtk(this, localAdvertisementInfo, paramsdg));
    localReadInJoyAdVideoGuide.setVisibility(0);
    paramsdg = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_icon");
    if ((paramsdg != null) && (paramsdg.getNativeView() != null)) {
      paramsdg.getNativeView().setVisibility(8);
    }
    paramsdg = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((paramsdg != null) && (paramsdg.getNativeView() != null)) {
      paramsdg.getNativeView().setVisibility(8);
    }
    localReadInJoyAdVideoGuide.b();
    localAdvertisementInfo.isShowingGuide = true;
  }
  
  private void a(sdg paramsdg, ProteusItemView paramProteusItemView, Context paramContext)
  {
    if (paramsdg == null) {}
    do
    {
      return;
      paramProteusItemView = paramProteusItemView.a();
    } while ((paramProteusItemView == null) || (paramProteusItemView.findViewById("id_top_left_mask") == null));
    paramsdg.o = DisplayUtil.dip2px(paramContext, 8.0F);
    paramsdg.p = DisplayUtil.dip2px(paramContext, 8.0F);
    paramsdg.q = DisplayUtil.dip2px(paramContext, 8.0F);
    paramsdg.r = DisplayUtil.dip2px(paramContext, 8.0F);
  }
  
  private void b(sdg paramsdg)
  {
    tvy.a.a(this.jdField_a_of_type_Sdc);
    int i;
    if (paramsdg != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramsdg.jdField_a_of_type_Int), Integer.valueOf(7));
      if (QLog.isColorLevel()) {
        QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131380831);
        if ((!(localObject instanceof pwe)) || (((pwe)localObject).a() != paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
          break label175;
        }
        localObject = (AdvertisementInfo)paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localView instanceof ProteusItemView)) {
          a(paramsdg, (ProteusItemView)localView);
        }
      }
      this.jdField_a_of_type_Slt.notifyDataSetChanged();
      return;
      label175:
      i += 1;
    }
  }
  
  private void c(sdg paramsdg)
  {
    int i;
    if ((paramsdg != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      View localView;
      Object localObject;
      boolean bool;
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        localObject = localView.getTag(2131380831);
        if ((!(localObject instanceof pwe)) || (((pwe)localObject).a() != paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(localView instanceof ProteusItemView))) {
          break label151;
        }
        localObject = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
      }
      else
      {
        return;
      }
      new Handler(Looper.getMainLooper()).postDelayed(new RecommendADVideoFeedsManager.2(this, (ViewBase)localObject, bool, localView), 300L);
      return;
      label151:
      i += 1;
    }
  }
  
  public sdg a(AdvertisementInfo paramAdvertisementInfo, View paramView, pwe parampwe)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (parampwe == null)) {}
    while ((parampwe.a() != 6) && (parampwe.a() != 66) && (parampwe.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    sdg localsdg = slt.a(paramAdvertisementInfo);
    ViewBase localViewBase = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (localViewBase != null)
    {
      localsdg.jdField_a_of_type_AndroidViewView = localViewBase.getNativeView();
      if (localViewBase.getNativeView() != null) {
        localsdg.l = localViewBase.getNativeView().getWidth();
      }
    }
    localsdg.jdField_a_of_type_Int = parampwe.b;
    localsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    localsdg.b = true;
    localsdg.n = 1;
    a(localsdg, paramView, this.jdField_a_of_type_AndroidAppActivity);
    return localsdg;
  }
  
  public sdg a(boolean paramBoolean)
  {
    int i = 0;
    pwe localpwe;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localpwe = (pwe)((View)localObject1).getTag(2131380831);
        localObject2 = localpwe.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpwe.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpwe.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpwe.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!twq.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Slt.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localpwe);; localObject1 = null)
    {
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnCreate");
    }
    sdy localsdy = this.jdField_a_of_type_Sdc.a();
    if (localsdy != null) {
      localsdy.b(this);
    }
  }
  
  /* Error */
  public void a(Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    // Byte code:
    //   0: iload_2
    //   1: getstatic 387	obb:az	I
    //   4: if_icmpeq +24 -> 28
    //   7: iload_2
    //   8: getstatic 390	obb:aA	I
    //   11: if_icmpeq +17 -> 28
    //   14: iload_2
    //   15: getstatic 393	obb:aB	I
    //   18: if_icmpeq +10 -> 28
    //   21: iload_2
    //   22: getstatic 396	obb:aD	I
    //   25: if_icmpne +84 -> 109
    //   28: aload_3
    //   29: getfield 190	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   32: bipush 6
    //   34: if_icmpne +75 -> 109
    //   37: aload_0
    //   38: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   41: sipush 2086
    //   44: aload_3
    //   45: invokestatic 401	uhs:a	(Landroid/content/Context;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   48: ifeq +61 -> 109
    //   51: aload_3
    //   52: getfield 405	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mChannelID	J
    //   55: l2i
    //   56: istore 4
    //   58: aload_3
    //   59: iload_2
    //   60: invokevirtual 408	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:setClickPos	(I)V
    //   63: aload_0
    //   64: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   67: aload_3
    //   68: iload 4
    //   70: getstatic 411	obb:S	I
    //   73: invokestatic 414	uhs:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   76: iload 4
    //   78: ifne +30 -> 108
    //   81: invokestatic 419	pkm:a	()Lpkm;
    //   84: aload_3
    //   85: getfield 422	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   88: invokestatic 428	java/lang/System:currentTimeMillis	()J
    //   91: invokevirtual 431	pkm:a	(JJ)V
    //   94: aload_0
    //   95: getfield 49	rti:jdField_a_of_type_Slt	Lslt;
    //   98: ifnull +10 -> 108
    //   101: aload_0
    //   102: getfield 49	rti:jdField_a_of_type_Slt	Lslt;
    //   105: invokevirtual 298	slt:notifyDataSetChanged	()V
    //   108: return
    //   109: iload_2
    //   110: getstatic 393	obb:aB	I
    //   113: if_icmpne +66 -> 179
    //   116: aload_3
    //   117: invokestatic 195	twr:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   120: ifeq +59 -> 179
    //   123: aload_0
    //   124: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   127: aload_3
    //   128: getfield 434	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mPopFormH5Url	Ljava/lang/String;
    //   131: aload_3
    //   132: getfield 437	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   135: aload_3
    //   136: getfield 440	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   139: invokestatic 443	uhs:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   142: new 445	trn
    //   145: dup
    //   146: invokespecial 446	trn:<init>	()V
    //   149: aload_0
    //   150: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   153: invokevirtual 449	trn:a	(Landroid/content/Context;)Ltrn;
    //   156: getstatic 452	obb:L	I
    //   159: invokevirtual 455	trn:a	(I)Ltrn;
    //   162: getstatic 458	obb:N	I
    //   165: invokevirtual 460	trn:b	(I)Ltrn;
    //   168: aload_3
    //   169: invokevirtual 463	trn:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Ltrn;
    //   172: invokevirtual 466	trn:a	()Ltrl;
    //   175: invokestatic 469	obb:a	(Ltrl;)V
    //   178: return
    //   179: iload_2
    //   180: getstatic 472	obb:aC	I
    //   183: if_icmpeq +38 -> 221
    //   186: aload_3
    //   187: getfield 475	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mImaxShowAdType	I
    //   190: sipush 1001
    //   193: if_icmpne +28 -> 221
    //   196: aload_0
    //   197: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   200: aload_3
    //   201: getfield 478	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   204: aload_3
    //   205: invokestatic 481	uhs:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   208: aload_0
    //   209: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   212: aload_3
    //   213: iconst_0
    //   214: getstatic 484	obb:ai	I
    //   217: invokestatic 414	uhs:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   220: return
    //   221: new 445	trn
    //   224: dup
    //   225: invokespecial 446	trn:<init>	()V
    //   228: aload_1
    //   229: invokevirtual 449	trn:a	(Landroid/content/Context;)Ltrn;
    //   232: getstatic 485	obb:jdField_a_of_type_Int	I
    //   235: invokevirtual 455	trn:a	(I)Ltrn;
    //   238: getstatic 458	obb:N	I
    //   241: invokevirtual 460	trn:b	(I)Ltrn;
    //   244: aload_3
    //   245: invokevirtual 463	trn:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Ltrn;
    //   248: iload_2
    //   249: invokevirtual 487	trn:d	(I)Ltrn;
    //   252: invokevirtual 466	trn:a	()Ltrl;
    //   255: invokestatic 469	obb:a	(Ltrl;)V
    //   258: iload_2
    //   259: getstatic 472	obb:aC	I
    //   262: if_icmpne +38 -> 300
    //   265: aload_0
    //   266: getfield 31	rti:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   269: iload 4
    //   271: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: invokevirtual 491	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: pop
    //   278: aload_3
    //   279: iconst_0
    //   280: putfield 219	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isShowingGuide	Z
    //   283: aload_0
    //   284: iconst_0
    //   285: invokevirtual 493	rti:a	(Z)Lsdg;
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull -182 -> 108
    //   293: aload_0
    //   294: aconst_null
    //   295: aload_1
    //   296: invokevirtual 496	rti:a	(Lsdg;Lsdg;)V
    //   299: return
    //   300: new 140	org/json/JSONObject
    //   303: dup
    //   304: aload_3
    //   305: getfield 144	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   308: invokespecial 147	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   311: astore_1
    //   312: aload_1
    //   313: ldc 149
    //   315: invokevirtual 153	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore 7
    //   320: aload_1
    //   321: ldc_w 498
    //   324: invokevirtual 153	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: pop
    //   328: aload_0
    //   329: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   332: aload 7
    //   334: invokestatic 503	bfwv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   337: istore 5
    //   339: aload 7
    //   341: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifne +183 -> 527
    //   347: aload_0
    //   348: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   351: aload 7
    //   353: invokestatic 506	oau:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   356: istore 6
    //   358: aload_3
    //   359: invokestatic 509	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   362: ifeq +109 -> 471
    //   365: iload 5
    //   367: ifne +8 -> 375
    //   370: iload 6
    //   372: ifeq +99 -> 471
    //   375: iload 5
    //   377: ifne +145 -> 522
    //   380: new 511	trj
    //   383: dup
    //   384: iconst_0
    //   385: invokespecial 514	trj:<init>	(Z)V
    //   388: astore_1
    //   389: aload_3
    //   390: iload_2
    //   391: aconst_null
    //   392: invokestatic 517	twr:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   395: aload_0
    //   396: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   399: aload_3
    //   400: aconst_null
    //   401: aload_0
    //   402: getfield 26	rti:jdField_a_of_type_Int	I
    //   405: iconst_1
    //   406: aload_1
    //   407: invokestatic 520	uhs:c	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lslt;IZLtrj;)Z
    //   410: pop
    //   411: invokestatic 419	pkm:a	()Lpkm;
    //   414: aload_3
    //   415: getfield 422	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   418: invokestatic 428	java/lang/System:currentTimeMillis	()J
    //   421: invokevirtual 431	pkm:a	(JJ)V
    //   424: aload_0
    //   425: getfield 49	rti:jdField_a_of_type_Slt	Lslt;
    //   428: invokevirtual 298	slt:notifyDataSetChanged	()V
    //   431: return
    //   432: astore_1
    //   433: iconst_0
    //   434: istore 5
    //   436: ldc 39
    //   438: iconst_1
    //   439: new 221	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 522
    //   449: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_1
    //   453: invokevirtual 232	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   456: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: iconst_0
    //   466: istore 6
    //   468: goto -110 -> 358
    //   471: invokestatic 528	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   474: invokestatic 534	com/tencent/mobileqq/utils/NetworkUtil:getNetworkType	(Landroid/content/Context;)I
    //   477: iconst_1
    //   478: if_icmpne +38 -> 516
    //   481: iconst_1
    //   482: istore 5
    //   484: aload_3
    //   485: iload_2
    //   486: aconst_null
    //   487: invokestatic 517	twr:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   490: aload_0
    //   491: getfield 47	rti:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   494: aload_3
    //   495: aload_0
    //   496: getfield 49	rti:jdField_a_of_type_Slt	Lslt;
    //   499: aload_0
    //   500: getfield 26	rti:jdField_a_of_type_Int	I
    //   503: iload 5
    //   505: aconst_null
    //   506: invokestatic 537	uhs:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lslt;IZLtrj;)V
    //   509: goto -98 -> 411
    //   512: astore_1
    //   513: goto -77 -> 436
    //   516: iconst_0
    //   517: istore 5
    //   519: goto -35 -> 484
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -135 -> 389
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -172 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	rti
    //   0	533	1	paramContext	Context
    //   0	533	2	paramInt1	int
    //   0	533	3	paramAdvertisementInfo	AdvertisementInfo
    //   0	533	4	paramInt2	int
    //   337	181	5	bool1	boolean
    //   356	173	6	bool2	boolean
    //   318	34	7	str	String
    // Exception table:
    //   from	to	target	type
    //   300	339	432	org/json/JSONException
    //   339	358	512	org/json/JSONException
  }
  
  public void a(sdc paramsdc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Sdc = paramsdc;
    this.jdField_a_of_type_Sdc.a(this);
  }
  
  public void a(sdg paramsdg, int paramInt1, int paramInt2)
  {
    tvy.a.a(paramsdg, this.jdField_a_of_type_Sdc, this);
  }
  
  public void a(sdg paramsdg1, sdg paramsdg2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramsdg2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Sdg = paramsdg2;
    sek.a().b();
    this.jdField_a_of_type_Sdc.b(2);
    this.jdField_a_of_type_Sdc.a(paramsdg2);
    if ((paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramsdg2.d);
      ((AdvertisementInfo)paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramsdg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramsdg2.c + " playParams = " + paramsdg2.toString());
    }
  }
  
  public void a(sdg paramsdg, sdj paramsdj, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramsdg + " videoPlayerWrapper = " + paramsdj + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7) {
      b(paramsdg);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        c(paramsdg);
      }
      return;
      a(paramsdg);
    }
  }
  
  public boolean a(sdg paramsdg)
  {
    if ((paramsdg == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramsdg = paramsdg.jdField_a_of_type_AndroidViewView;
      } while (paramsdg == null);
      int i = paramsdg.getHeight();
      Rect localRect = new Rect();
      paramsdg.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) && (d <= 0.800000011920929D));
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnResume");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnPause");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager destroy");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_Sdc.b(this);
    sdy localsdy = this.jdField_a_of_type_Sdc.a();
    if (localsdy != null) {
      localsdy.c(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rti
 * JD-Core Version:    0.7.0.1
 */