package com.tencent.mobileqq.kandian.biz.ad;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import com.dataline.util.DatalineMathUtil;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.CommentAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.IReadInJoyArticleBottomVideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.comment.RIJMedalUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.RIJRequestDataForComment;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeData;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeManager;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AdReqInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.PhoneInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqAdvertisePara;

public class RIJCommentAdUtils
{
  public static int a = 86400;
  public static int b = 10;
  private static final Set<RIJCommentAdUtils.CommentAdPosData> c = new HashSet();
  private static AladdinConfig d;
  private static AladdinConfig e;
  
  private static int a(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
      }
      else {
        return paramReadInJoyCommentDataManager.p();
      }
    }
    return paramReadInJoyCommentDataManager.q();
  }
  
  public static int a(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    paramReadInJoyCommentListView = paramReadInJoyCommentListView.getAdapter();
    boolean bool = paramReadInJoyCommentListView instanceof HeaderViewListAdapter;
    int k = 0;
    int i = 0;
    int j = k;
    if (bool)
    {
      paramReadInJoyCommentListView = ((HeaderViewListAdapter)paramReadInJoyCommentListView).getWrappedAdapter();
      j = k;
      if ((paramReadInJoyCommentListView instanceof FastWebMergeAdapter))
      {
        paramReadInJoyCommentListView = ((FastWebMergeAdapter)paramReadInJoyCommentListView).a().iterator();
        for (;;)
        {
          j = i;
          if (!paramReadInJoyCommentListView.hasNext()) {
            break;
          }
          BaseAdapter localBaseAdapter = (BaseAdapter)paramReadInJoyCommentListView.next();
          if ((localBaseAdapter instanceof WebFastAdapter)) {
            i = localBaseAdapter.getCount();
          }
        }
      }
    }
    return j;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = ReadInJoyCommentDataManager.b(paramString);
    if (paramString == null) {
      return 0;
    }
    return a(paramString, paramInt);
  }
  
  public static long a(Container paramContainer, AdvertisementInfo paramAdvertisementInfo)
  {
    paramContainer = b(paramContainer, paramAdvertisementInfo);
    if (paramContainer != null) {
      return paramContainer.a();
    }
    return 0L;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new JSONArray(paramString);
    if (paramString.length() == 0) {
      return "";
    }
    paramString = paramString.getJSONObject(0);
    if (paramString == null) {
      return "";
    }
    return a(paramString.optJSONArray("index_attr"));
  }
  
  private static String a(JSONArray paramJSONArray)
  {
    String str = "";
    if (paramJSONArray == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject != null)
      {
        ((StringBuilder)localObject).append(localJSONObject.optString("id"));
        ((StringBuilder)localObject).append(",");
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    paramJSONArray = str;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONArray = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    }
    return paramJSONArray;
  }
  
  private static ArrayList<ListAdExposeData> a(List<CommentViewItem> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)paramList.get(i);
        if (c(localCommentViewItem))
        {
          ListAdExposeData localListAdExposeData = new ListAdExposeData();
          localListAdExposeData.a = (i + paramInt);
          localListAdExposeData.f = ((AdvertisementInfo)localCommentViewItem.c.advertisementInfo);
          localArrayList.add(localListAdExposeData);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static ArrayList<AdvertisementInfo> a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 195	tencent/im/oidb/cmd0x885/oidb_0x885$RspBody
    //   3: dup
    //   4: invokespecial 196	tencent/im/oidb/cmd0x885/oidb_0x885$RspBody:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: invokevirtual 200	tencent/im/oidb/cmd0x885/oidb_0x885$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: pop
    //   16: aload 6
    //   18: getfield 204	tencent/im/oidb/cmd0x885/oidb_0x885$RspBody:rpt_msg_pos_ad_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   21: invokevirtual 209	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   24: ifeq +255 -> 279
    //   27: aload 6
    //   29: getfield 204	tencent/im/oidb/cmd0x885/oidb_0x885$RspBody:rpt_msg_pos_ad_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   32: invokevirtual 211	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   35: invokeinterface 213 1 0
    //   40: ifne +239 -> 279
    //   43: aload 6
    //   45: getfield 204	tencent/im/oidb/cmd0x885/oidb_0x885$RspBody:rpt_msg_pos_ad_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   48: invokevirtual 211	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   51: astore 6
    //   53: new 125	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: ldc 215
    //   64: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_0
    //   69: aload 6
    //   71: invokeinterface 155 1 0
    //   76: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc 220
    //   82: iconst_2
    //   83: aload_0
    //   84: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: new 151	java/util/ArrayList
    //   93: dup
    //   94: aload 6
    //   96: invokeinterface 155 1 0
    //   101: invokespecial 228	java/util/ArrayList:<init>	(I)V
    //   104: astore_0
    //   105: aload 6
    //   107: invokeinterface 59 1 0
    //   112: astore 7
    //   114: aload_0
    //   115: astore 6
    //   117: aload 7
    //   119: invokeinterface 65 1 0
    //   124: ifeq +169 -> 293
    //   127: aload 7
    //   129: invokeinterface 69 1 0
    //   134: checkcast 230	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo
    //   137: astore 6
    //   139: aload 6
    //   141: getfield 233	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo:rpt_msg_ad_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 209	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   147: ifeq -33 -> 114
    //   150: aload 6
    //   152: getfield 233	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo:rpt_msg_ad_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   155: invokevirtual 234	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   158: ifne -44 -> 114
    //   161: aload 6
    //   163: getfield 233	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo:rpt_msg_ad_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   166: iconst_0
    //   167: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   170: checkcast 239	tencent/im/oidb/cmd0x885/oidb_0x885$AdInfo
    //   173: astore 9
    //   175: aload 9
    //   177: getfield 243	tencent/im/oidb/cmd0x885/oidb_0x885$AdInfo:bytes_rowkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 248	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   183: invokevirtual 253	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   186: astore 8
    //   188: aload 9
    //   190: invokestatic 258	com/tencent/biz/pubaccount/readinjoyAd/ad/atlas/ReadInJoyAdAtlasUtil:a	(Ltencent/im/oidb/cmd0x885/oidb_0x885$AdInfo;)Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   193: astore 9
    //   195: aload 6
    //   197: getfield 262	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo:enum_pos_layout	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   200: invokevirtual 266	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   203: istore_1
    //   204: aload 6
    //   206: getfield 270	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo:uint64_pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   209: invokevirtual 274	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   212: lstore_2
    //   213: aload 6
    //   215: getfield 277	tencent/im/oidb/cmd0x885/oidb_0x885$PosAdInfo:is_auto_play	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   218: invokevirtual 274	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   221: lstore 4
    //   223: aload 9
    //   225: lconst_0
    //   226: putfield 281	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdFetchTime	J
    //   229: aload 9
    //   231: iload_1
    //   232: putfield 284	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosLayout	I
    //   235: aload 9
    //   237: lload_2
    //   238: putfield 287	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   241: aload 9
    //   243: lload 4
    //   245: putfield 290	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mADVideoAutoPlay	J
    //   248: aload 9
    //   250: aload 8
    //   252: putfield 294	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mRowKey	Ljava/lang/String;
    //   255: aload 9
    //   257: ldc2_w 295
    //   260: putfield 299	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mChannelID	J
    //   263: aload_0
    //   264: aload 9
    //   266: aload 8
    //   268: invokestatic 302	com/tencent/mobileqq/kandian/biz/ad/RIJCommentAdUtils:a	(Ljava/util/ArrayList;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Ljava/lang/String;)V
    //   271: goto -157 -> 114
    //   274: astore 6
    //   276: goto +9 -> 285
    //   279: aconst_null
    //   280: areturn
    //   281: astore 6
    //   283: aconst_null
    //   284: astore_0
    //   285: aload 6
    //   287: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   290: aload_0
    //   291: astore 6
    //   293: aload 6
    //   295: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramArrayOfByte	byte[]
    //   203	29	1	i	int
    //   212	26	2	l1	long
    //   221	23	4	l2	long
    //   7	207	6	localObject1	Object
    //   274	1	6	localException1	Exception
    //   281	5	6	localException2	Exception
    //   291	3	6	arrayOfByte	byte[]
    //   112	16	7	localIterator	Iterator
    //   186	81	8	str	String
    //   173	92	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   105	114	274	java/lang/Exception
    //   117	271	274	java/lang/Exception
    //   9	105	281	java/lang/Exception
  }
  
  public static JSONObject a(CommentViewItem paramCommentViewItem, boolean paramBoolean)
  {
    if (!b(paramCommentViewItem)) {
      return null;
    }
    BaseCommentData localBaseCommentData = paramCommentViewItem.c;
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localBaseCommentData.advertisementInfo;
    CommentAdParams localCommentAdParams = localAdvertisementInfo.mCommentAdParams;
    if (localCommentAdParams == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject, localBaseCommentData, localAdvertisementInfo);
    a(localJSONObject, localBaseCommentData.isAd, localCommentAdParams.c, localAdvertisementInfo);
    b(localJSONObject, localBaseCommentData, localAdvertisementInfo);
    a(localJSONObject, localCommentAdParams, localAdvertisementInfo, paramCommentViewItem);
    if ((paramCommentViewItem.b()) && (paramBoolean)) {
      localJSONObject.put("comment_model", paramCommentViewItem);
    }
    localJSONObject.put("comment", localAdvertisementInfo.mAdTxt);
    localJSONObject.put("commentModel", paramCommentViewItem);
    paramCommentViewItem = new StringBuilder();
    paramCommentViewItem.append("comment data json str : ");
    paramCommentViewItem.append(localJSONObject);
    QLog.d("RIJCommentAdUtils", 2, paramCommentViewItem.toString());
    return localJSONObject;
  }
  
  public static oidb_cmd0xc46.ReqAdvertisePara a(RIJCommentAdUtils.CommentAdUtilParams paramCommentAdUtilParams)
  {
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).a = "ce2d9f";
    Object localObject2 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject2 != null) {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject2).a;
    } else {
      localObject1 = null;
    }
    oidb_cmd0xc46.ReqAdvertisePara localReqAdvertisePara = new oidb_cmd0xc46.ReqAdvertisePara();
    localReqAdvertisePara.uint64_channel_id.set(95555552L, true);
    localReqAdvertisePara.uint64_last_time.set(0L);
    oidb_cmd0xc46.PhoneInfo localPhoneInfo = new oidb_cmd0xc46.PhoneInfo();
    a(localPhoneInfo, (GdtDeviceInfoHelper.Result)localObject2);
    localObject2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getGdtIMEI();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localPhoneInfo.string_imei.set((String)localObject2);
    }
    int i = PublicAccountAdUtil.a();
    localPhoneInfo.uint32_conn.set(i);
    i = 0;
    try
    {
      int j = DeviceInfoUtil.X();
      i = j;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("carrier obtain fail ");
      localStringBuilder.append(localException.toString());
      QLog.d("RIJCommentAdUtils", 1, localStringBuilder.toString());
    }
    localPhoneInfo.uint32_carrier.set(i);
    String str = DeviceInfoUtil.g();
    localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
    str = DeviceInfoUtil.e();
    localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
    i = AppSetting.d();
    localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    str = DatalineMathUtil.a(DatalineMathUtil.a());
    localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
    localPhoneInfo.uint32_os_type.set(2);
    localPhoneInfo.uint64_func_flag.set(1L);
    localPhoneInfo.bytes_ads_context.set(ByteStringMicro.copyFromUtf8(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdCookie()));
    localPhoneInfo.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    localPhoneInfo.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    a(localPhoneInfo, (qq_ad_get.QQAdGet.DeviceInfo)localObject1);
    localPhoneInfo.bytes_wx_ver.set(ByteStringMicro.copyFrom(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getWxVersionName(BaseApplication.getContext()).getBytes()));
    localReqAdvertisePara.msg_phone_info.set(localPhoneInfo, true);
    paramCommentAdUtilParams = b(paramCommentAdUtilParams);
    if (paramCommentAdUtilParams != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ad request params: ");
      ((StringBuilder)localObject1).append(paramCommentAdUtilParams.toString());
      QLog.d("RIJCommentAdUtils", 1, ((StringBuilder)localObject1).toString());
      localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(paramCommentAdUtilParams.toString()));
    }
    paramCommentAdUtilParams = new oidb_cmd0xc46.AdReqInfo();
    paramCommentAdUtilParams.uint64_ad_channel_id.set(95555552);
    localReqAdvertisePara.msg_ad_req_info.set(paramCommentAdUtilParams);
    return localReqAdvertisePara;
  }
  
  public static void a(int paramInt, AdvertisementInfo paramAdvertisementInfo, IReadInJoyArticleBottomVideoView paramIReadInJoyArticleBottomVideoView)
  {
    if (paramIReadInJoyArticleBottomVideoView == null) {
      return;
    }
    c.add(new RIJCommentAdUtils.CommentAdPosData(paramAdvertisementInfo, paramInt, paramIReadInJoyArticleBottomVideoView));
  }
  
  public static void a(Context paramContext, long paramLong, AdvertisementInfo paramAdvertisementInfo)
  {
    if (!a(paramContext, paramAdvertisementInfo)) {
      return;
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramAdvertisementInfo))
    {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(paramContext, paramAdvertisementInfo.mPopFormH5Url, paramAdvertisementInfo.mAdRl, paramAdvertisementInfo.mAdTraceId);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(42).b(38).a(paramAdvertisementInfo));
      return;
    }
    AdJumpParams localAdJumpParams = new AdJumpParams();
    if (paramAdvertisementInfo.clickPos == 8) {
      localAdJumpParams.c = true;
    }
    localAdJumpParams.d = paramLong;
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)paramContext, paramAdvertisementInfo, null, (int)paramAdvertisementInfo.mChannelID, true, localAdJumpParams);
  }
  
  public static void a(Context paramContext, Container paramContainer, CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (!a(paramCommentViewItem)) {
      return;
    }
    paramCommentViewItem = paramCommentViewItem.c;
    if (!(paramCommentViewItem.advertisementInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramCommentViewItem = (AdvertisementInfo)paramCommentViewItem.advertisementInfo;
    paramCommentViewItem.setClickPos(paramInt);
    a(paramContext, a(paramContainer, paramCommentViewItem), paramCommentViewItem);
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(15).b(1).a(paramAdvertisementInfo).c(4000));
  }
  
  public static void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem, int paramInt, View paramView)
  {
    if ((paramReadinjoyCommentListBaseAdapter != null) && (paramCommentViewItem != null) && (paramView != null) && (c(paramCommentViewItem)))
    {
      paramReadinjoyCommentListBaseAdapter = (AdvertisementInfo)paramCommentViewItem.c.advertisementInfo;
      Object localObject = ((IContainer)paramView).getVirtualView().findViewBaseByName(c(paramReadinjoyCommentListBaseAdapter));
      if ((localObject instanceof IReadInJoyArticleBottomVideoView))
      {
        paramCommentViewItem = (IRIJAdUIService)QRoute.api(IRIJAdUIService.class);
        localObject = (IReadInJoyArticleBottomVideoView)localObject;
        paramCommentViewItem.setVideoData((IReadInJoyArticleBottomVideoView)localObject, paramReadinjoyCommentListBaseAdapter);
        a(paramInt, paramReadinjoyCommentListBaseAdapter, (IReadInJoyArticleBottomVideoView)localObject);
      }
      paramView.setTag(2131449867, paramReadinjoyCommentListBaseAdapter);
    }
  }
  
  public static void a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAd) && ((paramBaseCommentData.advertisementInfo instanceof AdvertisementInfo))) {
      a((AdvertisementInfo)paramBaseCommentData.advertisementInfo);
    }
  }
  
  public static void a(ListAdExposeManager paramListAdExposeManager, int paramInt, List<CommentViewItem> paramList)
  {
    if (paramListAdExposeManager == null) {
      return;
    }
    if (paramInt == 0) {
      paramListAdExposeManager.a();
    }
    paramList = a(paramList, paramInt);
    if (!paramList.isEmpty()) {
      paramListAdExposeManager.a(paramList);
    }
  }
  
  public static void a(ReadInJoyCommentListView paramReadInJoyCommentListView, ListAdExposeManager paramListAdExposeManager)
  {
    paramReadInJoyCommentListView.setOnScrollListener(new RIJCommentAdUtils.1(paramReadInJoyCommentListView, paramListAdExposeManager));
  }
  
  private static void a(ArrayList<AdvertisementInfo> paramArrayList, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if (paramAdvertisementInfo.mSoftAdType == 1)
    {
      String str = paramAdvertisementInfo.mAdExt;
      try
      {
        paramString = new GameAdComData(paramString, new JSONObject(str));
        if ((TextUtils.isEmpty(paramString.t)) || (TextUtils.isEmpty(paramString.e))) {
          return;
        }
        paramAdvertisementInfo.gameAdComData = paramString;
        paramArrayList.add(paramAdvertisementInfo);
        return;
      }
      catch (Exception paramArrayList)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("RIJCommentAdUtils", 2, paramArrayList.getMessage());
    }
    else
    {
      if (paramAdvertisementInfo.mAdPosID <= 0L) {
        paramAdvertisementInfo.mAdPosID = 1L;
      }
      paramArrayList.add(paramAdvertisementInfo);
    }
  }
  
  private static void a(JSONObject paramJSONObject, CommentAdParams paramCommentAdParams, AdvertisementInfo paramAdvertisementInfo, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentAdParams.b) {
      paramJSONObject.put("like_commentModel", paramCommentViewItem);
    }
    if (paramCommentAdParams.d) {
      paramJSONObject.put("article_model", paramAdvertisementInfo);
    }
    if (j()) {
      paramCommentAdParams = "#19979797";
    } else {
      paramCommentAdParams = "#00000000";
    }
    paramJSONObject.put("background_color", paramCommentAdParams);
  }
  
  private static void a(JSONObject paramJSONObject, BaseCommentData paramBaseCommentData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramJSONObject.put("style_ID", "ReadInJoy_comment_ad_cell");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCommentDataJson | isStar ");
    ((StringBuilder)localObject).append(paramBaseCommentData.isStar());
    ((StringBuilder)localObject).append(" isApproved ");
    ((StringBuilder)localObject).append(paramBaseCommentData.isApproved());
    QLog.d("RIJCommentAdUtils", 2, ((StringBuilder)localObject).toString());
    if (paramBaseCommentData.isStar()) {
      paramJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
    }
    if (paramBaseCommentData.isApproved()) {
      paramJSONObject.put("rij_comment_v", "rij_comment_v");
    }
    if (paramBaseCommentData.isAuthorReply()) {
      paramJSONObject.put("author_header_flag_one", HardCodeUtil.a(2131900393));
    }
    if (!TextUtils.isEmpty(paramBaseCommentData.userTitle)) {
      paramJSONObject.put("comment_describe", paramBaseCommentData.userTitle);
    }
    localObject = paramAdvertisementInfo.mAdCorporateImageName;
    paramAdvertisementInfo = (AdvertisementInfo)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramAdvertisementInfo = ReadInJoyCommentUtils.a(paramBaseCommentData.nickName, 10);
    }
    localObject = paramAdvertisementInfo;
    if (TextUtils.isEmpty(paramAdvertisementInfo)) {
      localObject = HardCodeUtil.a(2131907018);
    }
    paramJSONObject.put("nickname", localObject);
    if (((paramBaseCommentData instanceof CommentData)) && (paramBaseCommentData.isAwesome())) {
      paramJSONObject.put("awsome_postmark_img", "awsome_postmark");
    }
    paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
  }
  
  private static void a(JSONObject paramJSONObject, boolean paramBoolean, int paramInt, AdvertisementInfo paramAdvertisementInfo)
  {
    String str2 = "url_big_image";
    if (paramBoolean)
    {
      paramBoolean = b(paramAdvertisementInfo);
      if (paramBoolean) {
        str1 = paramAdvertisementInfo.mAdVideoUrl;
      } else {
        str1 = paramAdvertisementInfo.mAdImg;
      }
      String str3;
      if (paramInt == 1)
      {
        if (paramBoolean) {
          str2 = "url_big_video";
        }
        str3 = "id_comment_cell_big_ad_container";
      }
      else
      {
        if (paramBoolean) {
          str2 = "url_small_video";
        } else {
          str2 = "url_small_image";
        }
        str3 = "id_comment_cell_small_ad_container";
      }
      paramJSONObject.put(str3, new JSONObject());
    }
    else
    {
      str1 = "";
    }
    paramJSONObject.put(str2, str1);
    str1 = HardCodeUtil.a(2131910240);
    try
    {
      str2 = new JSONObject(paramAdvertisementInfo.mAdExtInfo).optString("AdsIconText");
      paramBoolean = TextUtils.isEmpty(str2);
      paramAdvertisementInfo = str1;
      if (!paramBoolean) {
        paramAdvertisementInfo = str2;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      for (;;)
      {
        paramAdvertisementInfo = str1;
      }
    }
    paramJSONObject.put("ad_tag_text", paramAdvertisementInfo);
  }
  
  private static void a(oidb_cmd0xc46.PhoneInfo paramPhoneInfo, GdtDeviceInfoHelper.Result paramResult)
  {
    if (paramResult == null) {
      return;
    }
    paramResult = paramResult.a;
    if ((paramResult != null) && (paramResult.muid != null) && (paramResult.muid_type != null))
    {
      paramPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(paramResult.muid.get()));
      paramPhoneInfo.uint32_muid_type.set(paramResult.muid_type.get());
    }
  }
  
  private static void a(oidb_cmd0xc46.PhoneInfo paramPhoneInfo, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    if (paramDeviceInfo != null)
    {
      if (paramDeviceInfo.qadid.has()) {
        paramPhoneInfo.string_qadid.set(paramDeviceInfo.qadid.get());
      }
      if (paramDeviceInfo.md5_android_id.has()) {
        paramPhoneInfo.string_androidid.set(paramDeviceInfo.md5_android_id.get());
      }
      if (paramDeviceInfo.md5_mac.has()) {
        paramPhoneInfo.string_mac.set(paramDeviceInfo.md5_mac.get());
      }
      if (paramDeviceInfo.aid_ticket.has()) {
        paramPhoneInfo.string_oaid.set(paramDeviceInfo.aid_ticket.get());
      }
      if (paramDeviceInfo.taid_ticket.has()) {
        paramPhoneInfo.string_taid.set(paramDeviceInfo.taid_ticket.get());
      }
      if (paramDeviceInfo.client_ipv4.has()) {
        paramPhoneInfo.string_client_ipv4.set(paramDeviceInfo.client_ipv4.get());
      }
      if (QLog.isColorLevel())
      {
        paramDeviceInfo = new StringBuilder();
        paramDeviceInfo.append("makeReqAdvertisePara: deviceInfo: ma=");
        paramDeviceInfo.append(paramPhoneInfo.string_androidid.get());
        paramDeviceInfo.append(", mm=");
        paramDeviceInfo.append(paramPhoneInfo.string_mac.get());
        paramDeviceInfo.append(", oa=");
        paramDeviceInfo.append(paramPhoneInfo.string_oaid.get());
        paramDeviceInfo.append(", ta=");
        paramDeviceInfo.append(paramPhoneInfo.string_taid.get());
        QLog.i("RIJCommentAdUtils", 2, paramDeviceInfo.toString());
      }
    }
  }
  
  public static boolean a()
  {
    return b("kd_comment_ad_show");
  }
  
  private static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isTelephoneType(paramAdvertisementInfo))
    {
      ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).requestTelephoneInfoAndCall(paramContext, paramAdvertisementInfo);
      return false;
    }
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getGameType(paramAdvertisementInfo) != 1;
  }
  
  public static boolean a(CommentViewItem paramCommentViewItem)
  {
    return (paramCommentViewItem != null) && (paramCommentViewItem.c != null) && (paramCommentViewItem.c.isAd);
  }
  
  public static IReadInJoyArticleBottomVideoView b(Container paramContainer, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramContainer != null)
    {
      if (paramAdvertisementInfo == null) {
        return null;
      }
      paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_ad_comment_small_video");
      if ((paramContainer instanceof IReadInJoyArticleBottomVideoView)) {
        return (IReadInJoyArticleBottomVideoView)paramContainer;
      }
    }
    return null;
  }
  
  private static JSONObject b(RIJCommentAdUtils.CommentAdUtilParams paramCommentAdUtilParams)
  {
    try
    {
      RIJRequestDataForComment localRIJRequestDataForComment = paramCommentAdUtilParams.d;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("adPosType", paramCommentAdUtilParams.a);
      localJSONObject.put("adStartPos", paramCommentAdUtilParams.b);
      localJSONObject.put("adCommentPageSize", localRIJRequestDataForComment.c);
      paramCommentAdUtilParams = paramCommentAdUtilParams.c;
      if ((paramCommentAdUtilParams != null) && (paramCommentAdUtilParams.a()))
      {
        localJSONObject.put("MaterialId", paramCommentAdUtilParams.a);
        localJSONObject.put("RepeatedReqFlag", paramCommentAdUtilParams.b);
        localJSONObject.put("KdPos", paramCommentAdUtilParams.c);
        localJSONObject.put("adPosId", paramCommentAdUtilParams.d);
      }
      localJSONObject.put("adRequestFlag", 0);
      localJSONObject.put("commentAdsFlag", 1);
      if (b()) {
        localJSONObject.put("archieveCommentAdLimit", 1);
      }
      localJSONObject.put("tags", localRIJRequestDataForComment.g);
      if (!TextUtils.isEmpty(localRIJRequestDataForComment.h)) {
        localJSONObject.put("union_chann", localRIJRequestDataForComment.h);
      }
      localJSONObject.put("puin", localRIJRequestDataForComment.i);
      localJSONObject.put("rowkey", localRIJRequestDataForComment.k);
      localJSONObject.put("vid", localRIJRequestDataForComment.j);
      localJSONObject.put("comment_scene", String.valueOf(localRIJRequestDataForComment.l));
      return localJSONObject;
    }
    catch (JSONException paramCommentAdUtilParams)
    {
      paramCommentAdUtilParams.printStackTrace();
    }
    return null;
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RIJCommentAdUtils.CommentAdPosData)localIterator.next();
      int i = ((RIJCommentAdUtils.CommentAdPosData)localObject).c;
      localObject = (IReadInJoyArticleBottomVideoView)((RIJCommentAdUtils.CommentAdPosData)localObject).a.get();
      if (localObject != null) {
        if ((i >= paramInt1) && (i <= paramInt2)) {
          ((IReadInJoyArticleBottomVideoView)localObject).b();
        } else {
          ((IReadInJoyArticleBottomVideoView)localObject).a(false);
        }
      }
    }
  }
  
  private static void b(JSONObject paramJSONObject, BaseCommentData paramBaseCommentData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = paramAdvertisementInfo.mAdCorporateLogo;
    if (TextUtils.isEmpty(paramAdvertisementInfo))
    {
      paramAdvertisementInfo = "default_comment_avatar";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAdvertisementInfo);
      localStringBuilder.append(" . ");
      paramAdvertisementInfo = localStringBuilder.toString();
    }
    paramJSONObject.put("avator_url", paramAdvertisementInfo);
    if (paramBaseCommentData.medalInfo != null) {
      RIJMedalUtils.a(paramJSONObject, paramBaseCommentData.medalInfo);
    }
  }
  
  public static boolean b()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = d();
    if ((l2 != 0L) && (l1 - l2 >= a * 1000L))
    {
      c();
      e();
      return true;
    }
    return f() >= b;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdViewId));
  }
  
  private static boolean b(CommentViewItem paramCommentViewItem)
  {
    BaseCommentData localBaseCommentData = paramCommentViewItem.c;
    return (localBaseCommentData != null) && (localBaseCommentData.commentContent != null) && (paramCommentViewItem.e != null) && ((localBaseCommentData.advertisementInfo instanceof AdvertisementInfo));
  }
  
  private static boolean b(String paramString)
  {
    if (d == null) {
      d = Aladdin.get(502);
    }
    if (e == null) {
      e = Aladdin.getConfig(516);
    }
    if (paramString.equals("kd_comment_ad_show")) {
      return d.getIntegerFromString(paramString, 0) == 1;
    }
    return e.getIntegerFromString(paramString, 0) == 1;
  }
  
  private static String c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return "";
    }
    CommentAdParams localCommentAdParams = paramAdvertisementInfo.mCommentAdParams;
    boolean bool = b(paramAdvertisementInfo);
    int i;
    if (localCommentAdParams != null) {
      i = localCommentAdParams.c;
    } else {
      i = 1;
    }
    if (i == 1)
    {
      if (bool) {
        return "id_ad_comment_big_video";
      }
      return "id_ad_comment_big_img";
    }
    if (bool) {
      return "id_ad_comment_small_video";
    }
    return "id_ad_comment_small_img";
  }
  
  public static void c()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = BaseApplication.getContext().getSharedPreferences("comment_ad_tag", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append('_');
    localStringBuilder.append("comment_ad_first_show_time");
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), l);
    ((SharedPreferences.Editor)localObject).apply();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current uni won't show today : ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" at time: ");
      ((StringBuilder)localObject).append(l);
      QLog.d("RIJCommentAdUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean c(CommentViewItem paramCommentViewItem)
  {
    paramCommentViewItem = paramCommentViewItem.c;
    return (paramCommentViewItem != null) && (paramCommentViewItem.isAd) && ((paramCommentViewItem.advertisementInfo instanceof AdvertisementInfo));
  }
  
  public static long d()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("comment_ad_tag", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append('_');
    localStringBuilder.append("comment_ad_first_show_time");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static void e()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("comment_ad_tag", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append('_');
    localStringBuilder.append("comment_ad_exposure_count");
    localEditor.putInt(localStringBuilder.toString(), 0);
    localEditor.apply();
  }
  
  public static int f()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("comment_ad_tag", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append('_');
    localStringBuilder.append("comment_ad_exposure_count");
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void g() {}
  
  public static void h()
  {
    c.clear();
  }
  
  private static boolean j()
  {
    return b("kd_comment_ad_background");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils
 * JD-Core Version:    0.7.0.1
 */