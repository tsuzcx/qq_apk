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

public class sfx
  implements spi, sql
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private spg jdField_a_of_type_Spg;
  private spk jdField_a_of_type_Spk;
  private szd jdField_a_of_type_Szd;
  public boolean a;
  
  public sfx(Activity paramActivity, szd paramszd, spg paramspg, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Szd = paramszd;
    this.jdField_a_of_type_Spg = paramspg;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new sfy(this, Looper.getMainLooper());
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramProteusItemView instanceof qtj)) && (paramProteusItemView.getNativeView() != null)) {
      ((ReadInJoyAdVideoGuide)((qtj)paramProteusItemView).getNativeView()).setVisibility(8);
    }
  }
  
  private void a(spk paramspk)
  {
    int i;
    if ((paramspk != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131381183);
        if (((localObject instanceof qhk)) && (((qhk)localObject).a() == paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((localView instanceof ProteusItemView))) {
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
  
  private void a(spk paramspk, ProteusItemView paramProteusItemView)
  {
    Object localObject1 = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
    AdvertisementInfo localAdvertisementInfo;
    String str3;
    String str4;
    Object localObject2;
    if (((localObject1 instanceof qtj)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((qtj)localObject1).getNativeView();
      localAdvertisementInfo = (AdvertisementInfo)paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
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
    localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, (String)localObject2, (String)localObject3, (String)localObject1, uks.d(localAdvertisementInfo), localAdvertisementInfo);
    localReadInJoyAdVideoGuide.setAdGuideClickListener(new sfz(this, localAdvertisementInfo, paramspk));
    localReadInJoyAdVideoGuide.setVisibility(0);
    paramspk = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_icon");
    if ((paramspk != null) && (paramspk.getNativeView() != null)) {
      paramspk.getNativeView().setVisibility(8);
    }
    paramspk = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((paramspk != null) && (paramspk.getNativeView() != null)) {
      paramspk.getNativeView().setVisibility(8);
    }
    localReadInJoyAdVideoGuide.b();
    localAdvertisementInfo.isShowingGuide = true;
  }
  
  private void a(spk paramspk, ProteusItemView paramProteusItemView, Context paramContext)
  {
    if (paramspk == null) {}
    do
    {
      return;
      paramProteusItemView = paramProteusItemView.a();
    } while ((paramProteusItemView == null) || (paramProteusItemView.findViewById("id_top_left_mask") == null));
    paramspk.o = DisplayUtil.dip2px(paramContext, 8.0F);
    paramspk.p = DisplayUtil.dip2px(paramContext, 8.0F);
    paramspk.q = DisplayUtil.dip2px(paramContext, 8.0F);
    paramspk.r = DisplayUtil.dip2px(paramContext, 8.0F);
  }
  
  private void b(spk paramspk)
  {
    ujz.a.a(this.jdField_a_of_type_Spg);
    int i;
    if (paramspk != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramspk.jdField_a_of_type_Int), Integer.valueOf(7));
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
        Object localObject = localView.getTag(2131381183);
        if ((!(localObject instanceof qhk)) || (((qhk)localObject).a() != paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
          break label175;
        }
        localObject = (AdvertisementInfo)paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localView instanceof ProteusItemView)) {
          a(paramspk, (ProteusItemView)localView);
        }
      }
      this.jdField_a_of_type_Szd.notifyDataSetChanged();
      return;
      label175:
      i += 1;
    }
  }
  
  private void c(spk paramspk)
  {
    int i;
    if ((paramspk != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
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
        localObject = localView.getTag(2131381183);
        if ((!(localObject instanceof qhk)) || (((qhk)localObject).a() != paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(localView instanceof ProteusItemView))) {
          break label151;
        }
        localObject = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
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
  
  public spk a(AdvertisementInfo paramAdvertisementInfo, View paramView, qhk paramqhk)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (paramqhk == null)) {}
    while ((paramqhk.a() != 6) && (paramqhk.a() != 66) && (paramqhk.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    spk localspk = szd.a(paramAdvertisementInfo);
    ViewBase localViewBase = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (localViewBase != null)
    {
      localspk.jdField_a_of_type_AndroidViewView = localViewBase.getNativeView();
      if (localViewBase.getNativeView() != null) {
        localspk.l = localViewBase.getNativeView().getWidth();
      }
    }
    localspk.jdField_a_of_type_Int = paramqhk.b;
    localspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    localspk.b = true;
    localspk.n = 1;
    a(localspk, paramView, this.jdField_a_of_type_AndroidAppActivity);
    return localspk;
  }
  
  public spk a(boolean paramBoolean)
  {
    int i = 0;
    qhk localqhk;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localqhk = (qhk)((View)localObject1).getTag(2131381183);
        localObject2 = localqhk.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localqhk.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localqhk.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localqhk.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!ukr.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Szd.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localqhk);; localObject1 = null)
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
    sqd localsqd = this.jdField_a_of_type_Spg.a();
    if (localsqd != null) {
      localsqd.b(this);
    }
  }
  
  /* Error */
  public void a(Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    // Byte code:
    //   0: iload_2
    //   1: bipush 15
    //   3: if_icmpeq +22 -> 25
    //   6: iload_2
    //   7: bipush 16
    //   9: if_icmpeq +16 -> 25
    //   12: iload_2
    //   13: bipush 17
    //   15: if_icmpeq +10 -> 25
    //   18: iload_2
    //   19: sipush 1000
    //   22: if_icmpne +86 -> 108
    //   25: aload_3
    //   26: getfield 190	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   29: bipush 6
    //   31: if_icmpne +77 -> 108
    //   34: aload_0
    //   35: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   38: sipush 2086
    //   41: aload_3
    //   42: invokestatic 387	uvp:a	(Landroid/content/Context;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   45: ifeq +63 -> 108
    //   48: aload_3
    //   49: getfield 391	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mChannelID	J
    //   52: l2i
    //   53: istore 4
    //   55: aload_3
    //   56: iload_2
    //   57: invokevirtual 394	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:setClickPos	(I)V
    //   60: aload_0
    //   61: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   64: aload_3
    //   65: iload 4
    //   67: bipush 11
    //   69: getstatic 400	com/tencent/biz/pubaccount/NativeAd/report/JumpMode:MINIGAME	Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;
    //   72: invokestatic 403	uvp:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;IILcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;)V
    //   75: iload 4
    //   77: ifne +30 -> 107
    //   80: invokestatic 408	pvj:a	()Lpvj;
    //   83: aload_3
    //   84: getfield 411	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   87: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   90: invokevirtual 420	pvj:a	(JJ)V
    //   93: aload_0
    //   94: getfield 49	sfx:jdField_a_of_type_Szd	Lszd;
    //   97: ifnull +10 -> 107
    //   100: aload_0
    //   101: getfield 49	sfx:jdField_a_of_type_Szd	Lszd;
    //   104: invokevirtual 298	szd:notifyDataSetChanged	()V
    //   107: return
    //   108: iload_2
    //   109: bipush 17
    //   111: if_icmpne +69 -> 180
    //   114: aload_3
    //   115: invokestatic 195	uks:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   118: ifeq +62 -> 180
    //   121: aload_0
    //   122: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   125: aload_3
    //   126: getfield 423	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mPopFormH5Url	Ljava/lang/String;
    //   129: aload_3
    //   130: getfield 426	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   133: aload_3
    //   134: getfield 429	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   137: invokestatic 432	uvp:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   140: new 434	ufy
    //   143: dup
    //   144: invokespecial 435	ufy:<init>	()V
    //   147: aload_0
    //   148: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   151: invokevirtual 438	ufy:a	(Landroid/content/Context;)Lufy;
    //   154: bipush 42
    //   156: invokevirtual 441	ufy:a	(I)Lufy;
    //   159: getstatic 444	com/tencent/biz/pubaccount/NativeAd/report/JumpMode:ANDROID_ORDER	Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;
    //   162: invokevirtual 447	ufy:a	(Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;)Lufy;
    //   165: iconst_3
    //   166: invokevirtual 449	ufy:b	(I)Lufy;
    //   169: aload_3
    //   170: invokevirtual 452	ufy:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lufy;
    //   173: invokevirtual 455	ufy:a	()Lufw;
    //   176: invokestatic 460	ois:a	(Lufw;)V
    //   179: return
    //   180: iload_2
    //   181: bipush 21
    //   183: if_icmpeq +40 -> 223
    //   186: aload_3
    //   187: getfield 463	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mImaxShowAdType	I
    //   190: sipush 1001
    //   193: if_icmpne +30 -> 223
    //   196: aload_0
    //   197: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   200: aload_3
    //   201: getfield 466	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   204: aload_3
    //   205: invokestatic 469	uvp:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   208: aload_0
    //   209: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   212: aload_3
    //   213: iconst_0
    //   214: bipush 29
    //   216: getstatic 472	com/tencent/biz/pubaccount/NativeAd/report/JumpMode:IMAX_MIDDLE	Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;
    //   219: invokestatic 403	uvp:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;IILcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;)V
    //   222: return
    //   223: new 434	ufy
    //   226: dup
    //   227: invokespecial 435	ufy:<init>	()V
    //   230: aload_1
    //   231: invokevirtual 438	ufy:a	(Landroid/content/Context;)Lufy;
    //   234: iconst_1
    //   235: invokevirtual 441	ufy:a	(I)Lufy;
    //   238: iconst_3
    //   239: invokevirtual 449	ufy:b	(I)Lufy;
    //   242: getstatic 475	com/tencent/biz/pubaccount/NativeAd/report/JumpMode:UNKNOWN	Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;
    //   245: invokevirtual 447	ufy:a	(Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;)Lufy;
    //   248: aload_3
    //   249: invokevirtual 452	ufy:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lufy;
    //   252: iload_2
    //   253: invokevirtual 477	ufy:d	(I)Lufy;
    //   256: invokevirtual 455	ufy:a	()Lufw;
    //   259: invokestatic 460	ois:a	(Lufw;)V
    //   262: iload_2
    //   263: bipush 21
    //   265: if_icmpne +43 -> 308
    //   268: aload_0
    //   269: getfield 31	sfx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   272: iload 4
    //   274: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokevirtual 481	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: aload_3
    //   282: iconst_0
    //   283: putfield 219	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isShowingGuide	Z
    //   286: aload_3
    //   287: iconst_1
    //   288: putfield 484	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isClickReplay	Z
    //   291: aload_0
    //   292: iconst_0
    //   293: invokevirtual 486	sfx:a	(Z)Lspk;
    //   296: astore_1
    //   297: aload_1
    //   298: ifnull -191 -> 107
    //   301: aload_0
    //   302: aconst_null
    //   303: aload_1
    //   304: invokevirtual 489	sfx:a	(Lspk;Lspk;)V
    //   307: return
    //   308: new 140	org/json/JSONObject
    //   311: dup
    //   312: aload_3
    //   313: getfield 144	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   316: invokespecial 147	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   319: astore_1
    //   320: aload_1
    //   321: ldc 149
    //   323: invokevirtual 153	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: astore 7
    //   328: aload_1
    //   329: ldc_w 491
    //   332: invokevirtual 153	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: pop
    //   336: aload_0
    //   337: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   340: aload 7
    //   342: invokestatic 496	bhfn:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   345: istore 5
    //   347: aload 7
    //   349: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne +184 -> 536
    //   355: aload_0
    //   356: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   359: aload 7
    //   361: invokestatic 499	oil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   364: istore 6
    //   366: aload_3
    //   367: invokestatic 502	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   370: ifeq +109 -> 479
    //   373: iload 5
    //   375: ifne +8 -> 383
    //   378: iload 6
    //   380: ifeq +99 -> 479
    //   383: iload 5
    //   385: ifne +146 -> 531
    //   388: new 504	ufu
    //   391: dup
    //   392: iconst_0
    //   393: invokespecial 507	ufu:<init>	(Z)V
    //   396: astore_1
    //   397: aload_3
    //   398: iload_2
    //   399: aconst_null
    //   400: invokestatic 510	uks:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   403: aload_0
    //   404: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   407: aload_3
    //   408: aconst_null
    //   409: aload_0
    //   410: getfield 26	sfx:jdField_a_of_type_Int	I
    //   413: iconst_1
    //   414: aload_1
    //   415: invokestatic 513	uvp:d	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lszd;IZLufu;)Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;
    //   418: pop
    //   419: invokestatic 408	pvj:a	()Lpvj;
    //   422: aload_3
    //   423: getfield 411	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   426: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   429: invokevirtual 420	pvj:a	(JJ)V
    //   432: aload_0
    //   433: getfield 49	sfx:jdField_a_of_type_Szd	Lszd;
    //   436: invokevirtual 298	szd:notifyDataSetChanged	()V
    //   439: return
    //   440: astore_1
    //   441: iconst_0
    //   442: istore 5
    //   444: ldc 39
    //   446: iconst_1
    //   447: new 221	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 515
    //   457: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_1
    //   461: invokevirtual 232	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   464: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: iconst_0
    //   474: istore 6
    //   476: goto -110 -> 366
    //   479: invokestatic 521	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   482: invokestatic 527	com/tencent/mobileqq/utils/NetworkUtil:getNetworkType	(Landroid/content/Context;)I
    //   485: iconst_1
    //   486: if_icmpne +39 -> 525
    //   489: iconst_1
    //   490: istore 5
    //   492: aload_3
    //   493: iload_2
    //   494: aconst_null
    //   495: invokestatic 510	uks:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   498: aload_0
    //   499: getfield 47	sfx:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   502: aload_3
    //   503: aload_0
    //   504: getfield 49	sfx:jdField_a_of_type_Szd	Lszd;
    //   507: aload_0
    //   508: getfield 26	sfx:jdField_a_of_type_Int	I
    //   511: iload 5
    //   513: aconst_null
    //   514: invokestatic 530	uvp:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lszd;IZLufu;)Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;
    //   517: pop
    //   518: goto -99 -> 419
    //   521: astore_1
    //   522: goto -78 -> 444
    //   525: iconst_0
    //   526: istore 5
    //   528: goto -36 -> 492
    //   531: aconst_null
    //   532: astore_1
    //   533: goto -136 -> 397
    //   536: iconst_0
    //   537: istore 6
    //   539: goto -173 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	this	sfx
    //   0	542	1	paramContext	Context
    //   0	542	2	paramInt1	int
    //   0	542	3	paramAdvertisementInfo	AdvertisementInfo
    //   0	542	4	paramInt2	int
    //   345	182	5	bool1	boolean
    //   364	174	6	bool2	boolean
    //   326	34	7	str	String
    // Exception table:
    //   from	to	target	type
    //   308	347	440	org/json/JSONException
    //   347	366	521	org/json/JSONException
  }
  
  public void a(spg paramspg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Spg = paramspg;
    this.jdField_a_of_type_Spg.a(this);
  }
  
  public void a(spk paramspk, int paramInt1, int paramInt2)
  {
    ujz.a.a(paramspk, this.jdField_a_of_type_Spg, this);
  }
  
  public void a(spk paramspk1, spk paramspk2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramspk2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Spk = paramspk2;
    sqp.a().b();
    this.jdField_a_of_type_Spg.b(2);
    this.jdField_a_of_type_Spg.a(paramspk2);
    if ((paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramspk2.d);
      ((AdvertisementInfo)paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramspk2.c + " playParams = " + paramspk2.toString());
    }
  }
  
  public void a(spk paramspk, spn paramspn, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramspk + " videoPlayerWrapper = " + paramspn + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7) {
      b(paramspk);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        c(paramspk);
      }
      return;
      a(paramspk);
    }
  }
  
  public boolean a(spk paramspk)
  {
    if ((paramspk == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramspk = paramspk.jdField_a_of_type_AndroidViewView;
      } while (paramspk == null);
      int i = paramspk.getHeight();
      Rect localRect = new Rect();
      paramspk.getLocalVisibleRect(localRect);
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
    this.jdField_a_of_type_Spg.b(this);
    sqd localsqd = this.jdField_a_of_type_Spg.a();
    if (localsqd != null) {
      localsqd.c(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfx
 * JD-Core Version:    0.7.0.1
 */