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
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rmg
  implements rwa, rxc
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private rvy jdField_a_of_type_Rvy;
  private rwc jdField_a_of_type_Rwc;
  private sel jdField_a_of_type_Sel;
  public boolean a;
  
  public rmg(Activity paramActivity, sel paramsel, rvy paramrvy, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sel = paramsel;
    this.jdField_a_of_type_Rvy = paramrvy;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new rmh(this, Looper.getMainLooper());
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramProteusItemView instanceof qbi)) && (paramProteusItemView.getNativeView() != null)) {
      ((ReadInJoyAdVideoGuide)((qbi)paramProteusItemView).getNativeView()).setVisibility(8);
    }
  }
  
  private void a(rwc paramrwc)
  {
    int i;
    if ((paramrwc != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131381109);
        if (((localObject instanceof pqk)) && (((pqk)localObject).a() == paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((localView instanceof ProteusItemView))) {
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
  
  private void a(rwc paramrwc, ProteusItemView paramProteusItemView)
  {
    Object localObject1 = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
    AdvertisementInfo localAdvertisementInfo;
    String str3;
    String str4;
    Object localObject2;
    if (((localObject1 instanceof qbi)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((qbi)localObject1).getNativeView();
      localAdvertisementInfo = (AdvertisementInfo)paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
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
    localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, (String)localObject2, (String)localObject3, (String)localObject1, tqa.d(localAdvertisementInfo), localAdvertisementInfo);
    localReadInJoyAdVideoGuide.setAdGuideClickListener(new rmi(this, localAdvertisementInfo, paramrwc));
    localReadInJoyAdVideoGuide.setVisibility(0);
    paramrwc = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_icon");
    if ((paramrwc != null) && (paramrwc.getNativeView() != null)) {
      paramrwc.getNativeView().setVisibility(8);
    }
    paramrwc = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((paramrwc != null) && (paramrwc.getNativeView() != null)) {
      paramrwc.getNativeView().setVisibility(8);
    }
    localReadInJoyAdVideoGuide.b();
    localAdvertisementInfo.isShowingGuide = true;
  }
  
  private void a(rwc paramrwc, ProteusItemView paramProteusItemView, Context paramContext)
  {
    if (paramrwc == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramProteusItemView.a();
      } while (localObject == null);
      paramProteusItemView = ((TemplateBean)localObject).findViewById("id_top_left_mask");
      localObject = ((TemplateBean)localObject).getStyleName();
      if (paramProteusItemView != null)
      {
        paramrwc.o = bhgr.a(paramContext, 8.0F);
        paramrwc.p = bhgr.a(paramContext, 8.0F);
        paramrwc.q = bhgr.a(paramContext, 8.0F);
        paramrwc.r = bhgr.a(paramContext, 8.0F);
      }
    } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
    paramrwc.q = 0;
    paramrwc.r = 0;
  }
  
  private void b(rwc paramrwc)
  {
    tpe.a.a(this.jdField_a_of_type_Rvy);
    int i;
    if (paramrwc != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramrwc.jdField_a_of_type_Int), Integer.valueOf(7));
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
        Object localObject = localView.getTag(2131381109);
        if ((!(localObject instanceof pqk)) || (((pqk)localObject).a() != paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
          break label175;
        }
        localObject = (AdvertisementInfo)paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localView instanceof ProteusItemView)) {
          a(paramrwc, (ProteusItemView)localView);
        }
      }
      this.jdField_a_of_type_Sel.notifyDataSetChanged();
      return;
      label175:
      i += 1;
    }
  }
  
  private void c(rwc paramrwc)
  {
    int i;
    if ((paramrwc != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
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
        localObject = localView.getTag(2131381109);
        if ((!(localObject instanceof pqk)) || (((pqk)localObject).a() != paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(localView instanceof ProteusItemView))) {
          break label151;
        }
        localObject = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
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
  
  public rwc a(AdvertisementInfo paramAdvertisementInfo, View paramView, pqk parampqk)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (parampqk == null)) {}
    while ((parampqk.a() != 6) && (parampqk.a() != 66) && (parampqk.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    rwc localrwc = sel.a(paramAdvertisementInfo);
    ViewBase localViewBase = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (localViewBase != null)
    {
      localrwc.jdField_a_of_type_AndroidViewView = localViewBase.getNativeView();
      if (localViewBase.getNativeView() != null) {
        localrwc.l = localViewBase.getNativeView().getWidth();
      }
    }
    localrwc.jdField_a_of_type_Int = parampqk.b;
    localrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    localrwc.b = true;
    localrwc.n = 1;
    a(localrwc, paramView, this.jdField_a_of_type_AndroidAppActivity);
    return localrwc;
  }
  
  public rwc a(boolean paramBoolean)
  {
    int i = 0;
    pqk localpqk;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localpqk = (pqk)((View)localObject1).getTag(2131381109);
        localObject2 = localpqk.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpqk.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpqk.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpqk.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!tpz.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Sel.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localpqk);; localObject1 = null)
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
    rwu localrwu = this.jdField_a_of_type_Rvy.a();
    if (localrwu != null) {
      localrwu.b(this);
    }
  }
  
  /* Error */
  public void a(Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    // Byte code:
    //   0: iload_2
    //   1: getstatic 397	nzq:ay	I
    //   4: if_icmpeq +24 -> 28
    //   7: iload_2
    //   8: getstatic 400	nzq:az	I
    //   11: if_icmpeq +17 -> 28
    //   14: iload_2
    //   15: getstatic 403	nzq:aA	I
    //   18: if_icmpeq +10 -> 28
    //   21: iload_2
    //   22: getstatic 406	nzq:aC	I
    //   25: if_icmpne +84 -> 109
    //   28: aload_3
    //   29: getfield 190	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   32: bipush 6
    //   34: if_icmpne +75 -> 109
    //   37: aload_0
    //   38: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   41: sipush 2086
    //   44: aload_3
    //   45: invokestatic 411	ubd:a	(Landroid/content/Context;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   48: ifeq +61 -> 109
    //   51: aload_3
    //   52: getfield 415	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mChannelID	J
    //   55: l2i
    //   56: istore 4
    //   58: aload_3
    //   59: iload_2
    //   60: invokevirtual 418	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:setClickPos	(I)V
    //   63: aload_0
    //   64: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   67: aload_3
    //   68: iload 4
    //   70: getstatic 421	nzq:S	I
    //   73: invokestatic 424	ubd:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   76: iload 4
    //   78: ifne +30 -> 108
    //   81: invokestatic 429	pfa:a	()Lpfa;
    //   84: aload_3
    //   85: getfield 432	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   88: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   91: invokevirtual 441	pfa:a	(JJ)V
    //   94: aload_0
    //   95: getfield 49	rmg:jdField_a_of_type_Sel	Lsel;
    //   98: ifnull +10 -> 108
    //   101: aload_0
    //   102: getfield 49	rmg:jdField_a_of_type_Sel	Lsel;
    //   105: invokevirtual 308	sel:notifyDataSetChanged	()V
    //   108: return
    //   109: iload_2
    //   110: getstatic 403	nzq:aA	I
    //   113: if_icmpne +66 -> 179
    //   116: aload_3
    //   117: invokestatic 195	tqa:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   120: ifeq +59 -> 179
    //   123: aload_0
    //   124: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   127: aload_3
    //   128: getfield 444	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mPopFormH5Url	Ljava/lang/String;
    //   131: aload_3
    //   132: getfield 447	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   135: aload_3
    //   136: getfield 450	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   139: invokestatic 453	ubd:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   142: new 455	tlx
    //   145: dup
    //   146: invokespecial 456	tlx:<init>	()V
    //   149: aload_0
    //   150: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   153: invokevirtual 459	tlx:a	(Landroid/content/Context;)Ltlx;
    //   156: getstatic 462	nzq:L	I
    //   159: invokevirtual 465	tlx:a	(I)Ltlx;
    //   162: getstatic 468	nzq:N	I
    //   165: invokevirtual 470	tlx:b	(I)Ltlx;
    //   168: aload_3
    //   169: invokevirtual 473	tlx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Ltlx;
    //   172: invokevirtual 476	tlx:a	()Ltlv;
    //   175: invokestatic 479	nzq:a	(Ltlv;)V
    //   178: return
    //   179: iload_2
    //   180: getstatic 482	nzq:aB	I
    //   183: if_icmpeq +38 -> 221
    //   186: aload_3
    //   187: getfield 485	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mImaxShowAdType	I
    //   190: sipush 1001
    //   193: if_icmpne +28 -> 221
    //   196: aload_0
    //   197: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   200: aload_3
    //   201: getfield 488	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   204: aload_3
    //   205: invokestatic 491	ubd:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   208: aload_0
    //   209: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   212: aload_3
    //   213: iconst_0
    //   214: getstatic 494	nzq:ai	I
    //   217: invokestatic 424	ubd:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   220: return
    //   221: new 455	tlx
    //   224: dup
    //   225: invokespecial 456	tlx:<init>	()V
    //   228: aload_1
    //   229: invokevirtual 459	tlx:a	(Landroid/content/Context;)Ltlx;
    //   232: getstatic 495	nzq:jdField_a_of_type_Int	I
    //   235: invokevirtual 465	tlx:a	(I)Ltlx;
    //   238: getstatic 468	nzq:N	I
    //   241: invokevirtual 470	tlx:b	(I)Ltlx;
    //   244: aload_3
    //   245: invokevirtual 473	tlx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Ltlx;
    //   248: iload_2
    //   249: invokevirtual 497	tlx:d	(I)Ltlx;
    //   252: invokevirtual 476	tlx:a	()Ltlv;
    //   255: invokestatic 479	nzq:a	(Ltlv;)V
    //   258: iload_2
    //   259: getstatic 482	nzq:aB	I
    //   262: if_icmpne +38 -> 300
    //   265: aload_0
    //   266: getfield 31	rmg:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   269: iload 4
    //   271: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: invokevirtual 501	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: pop
    //   278: aload_3
    //   279: iconst_0
    //   280: putfield 219	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isShowingGuide	Z
    //   283: aload_0
    //   284: iconst_0
    //   285: invokevirtual 503	rmg:a	(Z)Lrwc;
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull -182 -> 108
    //   293: aload_0
    //   294: aconst_null
    //   295: aload_1
    //   296: invokevirtual 506	rmg:a	(Lrwc;Lrwc;)V
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
    //   321: ldc_w 508
    //   324: invokevirtual 153	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: pop
    //   328: aload_0
    //   329: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   332: aload 7
    //   334: invokestatic 513	bhny:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   337: istore 5
    //   339: aload 7
    //   341: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifne +183 -> 527
    //   347: aload_0
    //   348: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   351: aload 7
    //   353: invokestatic 516	nzj:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   356: istore 6
    //   358: aload_3
    //   359: invokestatic 519	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   362: ifeq +109 -> 471
    //   365: iload 5
    //   367: ifne +8 -> 375
    //   370: iload 6
    //   372: ifeq +99 -> 471
    //   375: iload 5
    //   377: ifne +145 -> 522
    //   380: new 521	tlt
    //   383: dup
    //   384: iconst_0
    //   385: invokespecial 524	tlt:<init>	(Z)V
    //   388: astore_1
    //   389: aload_3
    //   390: iload_2
    //   391: aconst_null
    //   392: invokestatic 527	tqa:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   395: aload_0
    //   396: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   399: aload_3
    //   400: aconst_null
    //   401: aload_0
    //   402: getfield 26	rmg:jdField_a_of_type_Int	I
    //   405: iconst_1
    //   406: aload_1
    //   407: invokestatic 530	ubd:c	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lsel;IZLtlt;)Z
    //   410: pop
    //   411: invokestatic 429	pfa:a	()Lpfa;
    //   414: aload_3
    //   415: getfield 432	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   418: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   421: invokevirtual 441	pfa:a	(JJ)V
    //   424: aload_0
    //   425: getfield 49	rmg:jdField_a_of_type_Sel	Lsel;
    //   428: invokevirtual 308	sel:notifyDataSetChanged	()V
    //   431: return
    //   432: astore_1
    //   433: iconst_0
    //   434: istore 5
    //   436: ldc 39
    //   438: iconst_1
    //   439: new 221	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 532
    //   449: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_1
    //   453: invokevirtual 232	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   456: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: iconst_0
    //   466: istore 6
    //   468: goto -110 -> 358
    //   471: invokestatic 538	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   474: invokestatic 543	bhnv:b	(Landroid/content/Context;)I
    //   477: iconst_1
    //   478: if_icmpne +38 -> 516
    //   481: iconst_1
    //   482: istore 5
    //   484: aload_3
    //   485: iload_2
    //   486: aconst_null
    //   487: invokestatic 527	tqa:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   490: aload_0
    //   491: getfield 47	rmg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   494: aload_3
    //   495: aload_0
    //   496: getfield 49	rmg:jdField_a_of_type_Sel	Lsel;
    //   499: aload_0
    //   500: getfield 26	rmg:jdField_a_of_type_Int	I
    //   503: iload 5
    //   505: aconst_null
    //   506: invokestatic 546	ubd:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lsel;IZLtlt;)V
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
    //   0	533	0	this	rmg
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
  
  public void a(rvy paramrvy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Rvy = paramrvy;
    this.jdField_a_of_type_Rvy.a(this);
  }
  
  public void a(rwc paramrwc, int paramInt1, int paramInt2)
  {
    tpe.a.a(paramrwc, this.jdField_a_of_type_Rvy, this);
  }
  
  public void a(rwc paramrwc1, rwc paramrwc2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramrwc2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Rwc = paramrwc2;
    rxg.a().b();
    this.jdField_a_of_type_Rvy.b(2);
    this.jdField_a_of_type_Sel.jdField_a_of_type_Rwc = paramrwc2;
    this.jdField_a_of_type_Rvy.a(paramrwc2);
    if ((paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramrwc2.d);
      ((AdvertisementInfo)paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramrwc2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramrwc2.c + " playParams = " + paramrwc2.toString());
    }
  }
  
  public void a(rwc paramrwc, rwf paramrwf, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramrwc + " videoPlayerWrapper = " + paramrwf + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7) {
      b(paramrwc);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        c(paramrwc);
      }
      return;
      a(paramrwc);
    }
  }
  
  public boolean a(rwc paramrwc)
  {
    if ((paramrwc == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramrwc = paramrwc.jdField_a_of_type_AndroidViewView;
      } while (paramrwc == null);
      int i = paramrwc.getHeight();
      Rect localRect = new Rect();
      paramrwc.getLocalVisibleRect(localRect);
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
    this.jdField_a_of_type_Rvy.b(this);
    rwu localrwu = this.jdField_a_of_type_Rvy.a();
    if (localrwu != null) {
      localrwu.c(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmg
 * JD-Core Version:    0.7.0.1
 */