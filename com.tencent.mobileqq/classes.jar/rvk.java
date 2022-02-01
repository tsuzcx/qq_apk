import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rvk
  implements sew
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private seu jdField_a_of_type_Seu;
  private sey jdField_a_of_type_Sey;
  private snh jdField_a_of_type_Snh;
  public boolean a;
  
  public rvk(Activity paramActivity, snh paramsnh, seu paramseu, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Snh = paramsnh;
    this.jdField_a_of_type_Seu = paramseu;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new rvl(this, Looper.getMainLooper());
  }
  
  /* Error */
  private void a(android.content.Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    // Byte code:
    //   0: iload_2
    //   1: getstatic 74	nxw:ay	I
    //   4: if_icmpeq +24 -> 28
    //   7: iload_2
    //   8: getstatic 77	nxw:az	I
    //   11: if_icmpeq +17 -> 28
    //   14: iload_2
    //   15: getstatic 80	nxw:aA	I
    //   18: if_icmpeq +10 -> 28
    //   21: iload_2
    //   22: getstatic 83	nxw:aC	I
    //   25: if_icmpne +84 -> 109
    //   28: aload_3
    //   29: getfield 88	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   32: bipush 6
    //   34: if_icmpne +75 -> 109
    //   37: aload_0
    //   38: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   41: sipush 2086
    //   44: aload_3
    //   45: invokestatic 93	ubb:a	(Landroid/content/Context;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   48: ifeq +61 -> 109
    //   51: aload_3
    //   52: getfield 97	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mChannelID	J
    //   55: l2i
    //   56: istore 4
    //   58: aload_3
    //   59: iload_2
    //   60: invokevirtual 101	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:setClickPos	(I)V
    //   63: aload_0
    //   64: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   67: aload_3
    //   68: iload 4
    //   70: getstatic 104	nxw:S	I
    //   73: invokestatic 107	ubb:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   76: iload 4
    //   78: ifne +30 -> 108
    //   81: invokestatic 112	pmh:a	()Lpmh;
    //   84: aload_3
    //   85: getfield 115	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   88: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   91: invokevirtual 124	pmh:a	(JJ)V
    //   94: aload_0
    //   95: getfield 47	rvk:jdField_a_of_type_Snh	Lsnh;
    //   98: ifnull +10 -> 108
    //   101: aload_0
    //   102: getfield 47	rvk:jdField_a_of_type_Snh	Lsnh;
    //   105: invokevirtual 129	snh:notifyDataSetChanged	()V
    //   108: return
    //   109: iload_2
    //   110: getstatic 80	nxw:aA	I
    //   113: if_icmpne +66 -> 179
    //   116: aload_3
    //   117: invokestatic 134	oqj:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   120: ifeq +59 -> 179
    //   123: aload_0
    //   124: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   127: aload_3
    //   128: getfield 138	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mPopFormH5Url	Ljava/lang/String;
    //   131: aload_3
    //   132: getfield 141	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   135: aload_3
    //   136: getfield 144	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   139: invokestatic 147	ubb:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   142: new 149	omp
    //   145: dup
    //   146: invokespecial 150	omp:<init>	()V
    //   149: aload_0
    //   150: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   153: invokevirtual 153	omp:a	(Landroid/content/Context;)Lomp;
    //   156: getstatic 156	nxw:L	I
    //   159: invokevirtual 159	omp:a	(I)Lomp;
    //   162: getstatic 162	nxw:N	I
    //   165: invokevirtual 165	omp:b	(I)Lomp;
    //   168: aload_3
    //   169: invokevirtual 168	omp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lomp;
    //   172: invokevirtual 171	omp:a	()Lomn;
    //   175: invokestatic 174	nxw:a	(Lomn;)V
    //   178: return
    //   179: iload_2
    //   180: getstatic 177	nxw:aB	I
    //   183: if_icmpeq +38 -> 221
    //   186: aload_3
    //   187: getfield 180	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mImaxShowAdType	I
    //   190: sipush 1001
    //   193: if_icmpne +28 -> 221
    //   196: aload_0
    //   197: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   200: aload_3
    //   201: getfield 183	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   204: aload_3
    //   205: invokestatic 186	ubb:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   208: aload_0
    //   209: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   212: aload_3
    //   213: iconst_0
    //   214: getstatic 189	nxw:ai	I
    //   217: invokestatic 107	ubb:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   220: return
    //   221: new 149	omp
    //   224: dup
    //   225: invokespecial 150	omp:<init>	()V
    //   228: aload_1
    //   229: invokevirtual 153	omp:a	(Landroid/content/Context;)Lomp;
    //   232: getstatic 190	nxw:jdField_a_of_type_Int	I
    //   235: invokevirtual 159	omp:a	(I)Lomp;
    //   238: getstatic 162	nxw:N	I
    //   241: invokevirtual 165	omp:b	(I)Lomp;
    //   244: aload_3
    //   245: invokevirtual 168	omp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lomp;
    //   248: iload_2
    //   249: invokevirtual 192	omp:d	(I)Lomp;
    //   252: invokevirtual 171	omp:a	()Lomn;
    //   255: invokestatic 174	nxw:a	(Lomn;)V
    //   258: iload_2
    //   259: getstatic 177	nxw:aB	I
    //   262: if_icmpne +38 -> 300
    //   265: aload_0
    //   266: getfield 29	rvk:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   269: iload 4
    //   271: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: invokevirtual 202	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: pop
    //   278: aload_3
    //   279: iconst_0
    //   280: putfield 205	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isShowingGuide	Z
    //   283: aload_0
    //   284: iconst_0
    //   285: invokevirtual 208	rvk:a	(Z)Lsey;
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull -182 -> 108
    //   293: aload_0
    //   294: aconst_null
    //   295: aload_1
    //   296: invokevirtual 211	rvk:a	(Lsey;Lsey;)V
    //   299: return
    //   300: new 213	org/json/JSONObject
    //   303: dup
    //   304: aload_3
    //   305: getfield 216	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   308: invokespecial 219	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   311: astore_1
    //   312: aload_1
    //   313: ldc 221
    //   315: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore 7
    //   320: aload_1
    //   321: ldc 227
    //   323: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: pop
    //   327: aload_0
    //   328: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   331: aload 7
    //   333: invokestatic 232	bgnw:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   336: istore 5
    //   338: aload 7
    //   340: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   343: ifne +183 -> 526
    //   346: aload_0
    //   347: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   350: aload 7
    //   352: invokestatic 241	nxp:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   355: istore 6
    //   357: aload_3
    //   358: invokestatic 245	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   361: ifeq +109 -> 470
    //   364: iload 5
    //   366: ifne +8 -> 374
    //   369: iload 6
    //   371: ifeq +99 -> 470
    //   374: iload 5
    //   376: ifne +145 -> 521
    //   379: new 247	oml
    //   382: dup
    //   383: iconst_0
    //   384: invokespecial 250	oml:<init>	(Z)V
    //   387: astore_1
    //   388: aload_3
    //   389: iload_2
    //   390: aconst_null
    //   391: invokestatic 253	oqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   394: aload_0
    //   395: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   398: aload_3
    //   399: aconst_null
    //   400: aload_0
    //   401: getfield 24	rvk:jdField_a_of_type_Int	I
    //   404: iconst_1
    //   405: aload_1
    //   406: invokestatic 257	ubb:c	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lsnh;IZLoml;)Z
    //   409: pop
    //   410: invokestatic 112	pmh:a	()Lpmh;
    //   413: aload_3
    //   414: getfield 115	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   417: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   420: invokevirtual 124	pmh:a	(JJ)V
    //   423: aload_0
    //   424: getfield 47	rvk:jdField_a_of_type_Snh	Lsnh;
    //   427: invokevirtual 129	snh:notifyDataSetChanged	()V
    //   430: return
    //   431: astore_1
    //   432: iconst_0
    //   433: istore 5
    //   435: ldc 37
    //   437: iconst_1
    //   438: new 259	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 262
    //   448: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_1
    //   452: invokevirtual 270	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: iconst_0
    //   465: istore 6
    //   467: goto -110 -> 357
    //   470: invokestatic 282	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   473: invokestatic 287	bgnt:b	(Landroid/content/Context;)I
    //   476: iconst_1
    //   477: if_icmpne +38 -> 515
    //   480: iconst_1
    //   481: istore 5
    //   483: aload_3
    //   484: iload_2
    //   485: aconst_null
    //   486: invokestatic 253	oqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   489: aload_0
    //   490: getfield 45	rvk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   493: aload_3
    //   494: aload_0
    //   495: getfield 47	rvk:jdField_a_of_type_Snh	Lsnh;
    //   498: aload_0
    //   499: getfield 24	rvk:jdField_a_of_type_Int	I
    //   502: iload 5
    //   504: aconst_null
    //   505: invokestatic 290	ubb:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lsnh;IZLoml;)V
    //   508: goto -98 -> 410
    //   511: astore_1
    //   512: goto -77 -> 435
    //   515: iconst_0
    //   516: istore 5
    //   518: goto -35 -> 483
    //   521: aconst_null
    //   522: astore_1
    //   523: goto -135 -> 388
    //   526: iconst_0
    //   527: istore 6
    //   529: goto -172 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	rvk
    //   0	532	1	paramContext	android.content.Context
    //   0	532	2	paramInt1	int
    //   0	532	3	paramAdvertisementInfo	AdvertisementInfo
    //   0	532	4	paramInt2	int
    //   336	181	5	bool1	boolean
    //   355	173	6	bool2	boolean
    //   318	33	7	str	String
    // Exception table:
    //   from	to	target	type
    //   300	338	431	org/json/JSONException
    //   338	357	511	org/json/JSONException
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramProteusItemView instanceof qiw)) && (paramProteusItemView.getNativeView() != null)) {
      ((ReadInJoyAdVideoGuide)((qiw)paramProteusItemView).getNativeView()).setVisibility(8);
    }
  }
  
  private void a(sey paramsey)
  {
    int i;
    if ((paramsey != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131380929);
        if (((localObject instanceof pya)) && (((pya)localObject).a() == paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((localView instanceof ProteusItemView))) {
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
  
  private void a(sey paramsey, ProteusItemView paramProteusItemView)
  {
    Object localObject1 = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
    AdvertisementInfo localAdvertisementInfo;
    String str3;
    String str4;
    Object localObject2;
    if (((localObject1 instanceof qiw)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((qiw)localObject1).getNativeView();
      localAdvertisementInfo = (AdvertisementInfo)paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
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
    localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, (String)localObject2, (String)localObject3, (String)localObject1, oqj.d(localAdvertisementInfo));
    localReadInJoyAdVideoGuide.setAdGuideClickListener(new rvm(this, localAdvertisementInfo, paramsey));
    localReadInJoyAdVideoGuide.setVisibility(0);
    paramsey = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_icon");
    if ((paramsey != null) && (paramsey.getNativeView() != null)) {
      paramsey.getNativeView().setVisibility(8);
    }
    paramsey = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((paramsey != null) && (paramsey.getNativeView() != null)) {
      paramsey.getNativeView().setVisibility(8);
    }
    localAdvertisementInfo.isShowingGuide = true;
  }
  
  private void b(sey paramsey)
  {
    int i;
    if (paramsey != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramsey.jdField_a_of_type_Int), Integer.valueOf(7));
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
        Object localObject = localView.getTag(2131380929);
        if ((!(localObject instanceof pya)) || (((pya)localObject).a() != paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
          break label208;
        }
        localObject = (AdvertisementInfo)paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((!(localView instanceof ProteusItemView)) || (!((AdvertisementInfo)localObject).mShowAdButton)) {
          break label174;
        }
        a(paramsey, (ProteusItemView)localView);
      }
      for (;;)
      {
        this.jdField_a_of_type_Snh.notifyDataSetChanged();
        return;
        label174:
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3001, 250L);
        }
      }
      label208:
      i += 1;
    }
  }
  
  private void c(sey paramsey)
  {
    int i;
    if ((paramsey != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
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
        localObject = localView.getTag(2131380929);
        if ((!(localObject instanceof pya)) || (((pya)localObject).a() != paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(localView instanceof ProteusItemView))) {
          break label153;
        }
        localObject = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
      }
      else
      {
        return;
      }
      new Handler(Looper.getMainLooper()).postDelayed(new RecommendADVideoFeedsManager.2(this, (ViewBase)localObject, bool, localView), 300L);
      return;
      label153:
      i += 1;
    }
  }
  
  public sey a(AdvertisementInfo paramAdvertisementInfo, View paramView, pya parampya)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (parampya == null)) {}
    while ((parampya.a() != 6) && (parampya.a() != 66) && (parampya.a() != 115)) {
      return null;
    }
    Object localObject = (ProteusItemView)paramView;
    paramView = snh.a(paramAdvertisementInfo);
    localObject = ((ProteusItemView)localObject).a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (localObject != null)
    {
      paramView.jdField_a_of_type_AndroidViewView = ((ViewBase)localObject).getNativeView();
      if (((ViewBase)localObject).getNativeView() != null) {
        paramView.l = ((ViewBase)localObject).getNativeView().getWidth();
      }
    }
    paramView.jdField_a_of_type_Int = parampya.b;
    paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    paramView.b = true;
    paramView.n = 1;
    return paramView;
  }
  
  public sey a(boolean paramBoolean)
  {
    int i = 0;
    pya localpya;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localpya = (pya)((View)localObject1).getTag(2131380929);
        localObject2 = localpya.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpya.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpya.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpya.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!oqi.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Snh.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localpya);; localObject1 = null)
    {
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnResume");
    }
  }
  
  public void a(seu paramseu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Seu = paramseu;
    this.jdField_a_of_type_Seu.a(this);
  }
  
  public void a(sey paramsey1, sey paramsey2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramsey2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Sey = paramsey2;
    sgc.a().b();
    this.jdField_a_of_type_Seu.b(2);
    this.jdField_a_of_type_Snh.jdField_a_of_type_Sey = paramsey2;
    this.jdField_a_of_type_Seu.a(paramsey2);
    if ((paramsey2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramsey2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramsey2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramsey2.d);
      ((AdvertisementInfo)paramsey2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramsey2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramsey2.c + " playParams = " + paramsey2.toString());
    }
  }
  
  public void a(sey paramsey, sfb paramsfb, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramsey + " videoPlayerWrapper = " + paramsfb + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7) {
      b(paramsey);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        c(paramsey);
      }
      return;
      a(paramsey);
    }
  }
  
  public boolean a(sey paramsey)
  {
    if ((paramsey == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramsey = paramsey.jdField_a_of_type_AndroidViewView;
      } while (paramsey == null);
      int i = paramsey.getHeight();
      Rect localRect = new Rect();
      paramsey.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) && (d <= 0.800000011920929D));
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnPause");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager destroy");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_Seu.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvk
 * JD-Core Version:    0.7.0.1
 */