package com.tencent.mobileqq.kandian.biz.atlas;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.atlas.favorite.api.IReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.atlas.AtlasModelImage;
import com.tencent.mobileqq.kandian.repo.atlas.AtlasModelImageList;
import com.tencent.mobileqq.kandian.repo.atlas.AtlasStackInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Client;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteReqBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.ReqBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Client;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqArticle;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqOption;
import tencent.im.oidb.cmd0xbe1.cmd0xbe1.ReqBody;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class ReadInJoyAtlasManager
  implements IReadInJoyAtlasManager
{
  public static final int ATLAS_TIP_DATA_ERROR = 1;
  public static final int ATLAS_TIP_DATA_NORMAL = 0;
  public static final int ATLAS_TIP_LOADING = 4;
  public static final int ATLAS_TIP_NET_ERROR = 2;
  public static final int ATLAS_TIP_NO_MORE_DATA = 3;
  public static final String CMD_OIDB_0X83E = "OidbSvc.0x83e";
  public static final String CMD_OIDB_0XAD6 = "OidbSvc.0xad6";
  public static final String CMD_OIDB_0XB3E = "OidbSvc.0xb3e";
  public static final String CMD_OIDB_0XB40 = "OidbSvc.0xb40";
  public static final String CMD_OIDB_0XB54 = "OidbSvc.0xb54";
  public static final String CMD_OIDB_0XB74 = "OidbSvc.0xb74";
  public static final String CMD_OIDB_0XBE0 = "OidbSvc.0xbe0";
  public static final String CMD_OIDB_0XBE1 = "OidbSvc.0xbe1";
  public static final String ERROR_TIPS_DATA_ERROR;
  public static final String ERROR_TIPS_NET_ERROR;
  public static final String ERROR_TIPS_NO_MORE_DATA;
  public static final int SERVICE_TYPE_0X83E = 0;
  public static final int SERVICE_TYPE_0XBE0 = 1;
  public static final int SERVICE_TYPE_0XBE0_NEW = 2;
  public static final int SERVICE_TYPE_0XBE1 = 1;
  public static final int SERVICE_TYPE_CHECK_FAVORITE_STATUS = 1;
  public static final int SERVICE_TYPE_GET_ATLAS = 1;
  public static final int SERVICE_TYPE_GET_ATLAS_RECOMMEND = 2;
  public static final int SERVICE_TYPE_GET_BIU_COUNT = 1;
  public static final int SERVICE_TYPE_GET_COMMENT_COUNT = 1;
  public static final int SERVICE_TYPE_GET_FAVORITE_LIST = 2;
  public static final int SERVICE_TYPE_LIKE_COUNT = 3;
  public static final String SP_KEY_FIRST_FAVORITE = "Key_First_ReadInJoy_Favorite";
  public static final String TAG;
  public static ReadInJoyAtlasManager sIns;
  static HashMap<Integer, String> sTips;
  private AtlasStackInfo mAtlasStackInfo = new AtlasStackInfo();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.atlas..");
    localStringBuilder.append(ReadInJoyAtlasManager.class.getSimpleName());
    TAG = localStringBuilder.toString();
    ERROR_TIPS_DATA_ERROR = HardCodeUtil.a(2131712844);
    ERROR_TIPS_NET_ERROR = HardCodeUtil.a(2131712758);
    ERROR_TIPS_NO_MORE_DATA = HardCodeUtil.a(2131712911);
    sTips = new HashMap();
    sTips.put(Integer.valueOf(1), ERROR_TIPS_DATA_ERROR);
    sTips.put(Integer.valueOf(2), ERROR_TIPS_NET_ERROR);
    sTips.put(Integer.valueOf(3), ERROR_TIPS_NO_MORE_DATA);
  }
  
  public static boolean checkIsLocalFirstDoFavorite(Context paramContext, boolean paramBoolean)
  {
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = true;
    if (RIJSPUtils.a(paramContext, "Key_First_ReadInJoy_Favorite", true) == null)
    {
      RIJSPUtils.a("Key_First_ReadInJoy_Favorite", Integer.valueOf(1), true);
      if (!paramBoolean)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 0, BaseApplicationImpl.getContext().getResources().getString(2131692227), 0).a();
        return true;
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  private void doFavorite(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<byte[]> paramArrayList)
  {
    new QfavBuilder(6).a("nLinkType", 0).b("sTitle", paramString2).b("sUrl", paramString6).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramString4).b("sBrief", paramString3).b("sPath", paramString5).b("sResUrl", paramString6).a("lCategory", 8L).b("sBizDataList", paramArrayList).b(paramActivity, paramString1, -1, null);
  }
  
  private ArrayDeque<String> getAvailableExposedRowKeys(String paramString)
  {
    ArrayDeque localArrayDeque = new ArrayDeque(this.mAtlasStackInfo.a());
    while ((!localArrayDeque.isEmpty()) && (!paramString.equals((String)localArrayDeque.peekLast()))) {
      localArrayDeque.pollLast();
    }
    return localArrayDeque;
  }
  
  public static String getErrorTips(int paramInt)
  {
    if (sTips.get(Integer.valueOf(paramInt)) == null) {
      return ERROR_TIPS_NET_ERROR;
    }
    return (String)sTips.get(Integer.valueOf(paramInt));
  }
  
  public static String getGalleryCoverImage(gallery.GalleryInfo paramGalleryInfo)
  {
    if ((paramGalleryInfo.bytes_summary_pic_url.has()) && (!TextUtils.isEmpty(paramGalleryInfo.bytes_summary_pic_url.get().toStringUtf8()))) {
      return paramGalleryInfo.bytes_summary_pic_url.get().toStringUtf8();
    }
    if ((paramGalleryInfo.rpt_msg_summary_pic.has()) && (paramGalleryInfo.rpt_msg_summary_pic.size() > 0)) {
      return ((gallery.PictureInfo)paramGalleryInfo.rpt_msg_summary_pic.get().get(0)).bytes_pic_url.get().toStringUtf8();
    }
    return null;
  }
  
  public static ReadInJoyAtlasManager getInstance()
  {
    if (sIns == null) {
      try
      {
        if (sIns == null) {
          sIns = new ReadInJoyAtlasManager();
        }
      }
      finally {}
    }
    return sIns;
  }
  
  public void atlasRequestUpVoteAction(String paramString, boolean paramBoolean, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("atlasRequestUpVoteAction, rowKey = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", callback = ");
      ((StringBuilder)localObject2).append(paramAtlasCallbackImpl);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = new oidb_cmd0x83e.ReqBody();
    ((oidb_cmd0x83e.ReqBody)localObject1).uint64_uin.set(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    ((oidb_cmd0x83e.ReqBody)localObject1).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString));
    Object localObject2 = ((oidb_cmd0x83e.ReqBody)localObject1).uint32_operation;
    if (!paramBoolean) {
      i = 3;
    }
    ((PBUInt32Field)localObject2).set(i);
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReadInJoyAtlasManager.3(this, paramAtlasCallbackImpl, paramString), ((oidb_cmd0x83e.ReqBody)localObject1).toByteArray(), "OidbSvc.0x83e", 2110, 0, null, 0L);
  }
  
  public List<AtlasModelImage> convertGalleryInfoToAtlas(gallery.GalleryInfo paramGalleryInfo)
  {
    if (paramGalleryInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String str = paramGalleryInfo.bytes_row_key.get().toStringUtf8();
    paramGalleryInfo = paramGalleryInfo.rpt_msg_pic_info.get().iterator();
    while (paramGalleryInfo.hasNext()) {
      localArrayList.add(new AtlasModelImage(str, (gallery.PictureInfo)paramGalleryInfo.next()));
    }
    return localArrayList;
  }
  
  public void dataFetched(AtlasModelImageList paramAtlasModelImageList)
  {
    this.mAtlasStackInfo.a(paramAtlasModelImageList, 2, false, false);
  }
  
  public void doDeleteFavorite(Activity paramActivity, String paramString1, int paramInt, String paramString2, ArrayList<String> paramArrayList)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    paramString2 = new ArrayList();
    paramString2.add(localKandianFavoriteBizData.toByteArray());
    new QfavBuilder(6).a("sCIDListToBeDelete", paramArrayList).b("sBizDataList", paramString2).a(paramActivity, paramString1, -1, null);
  }
  
  public void doFavorite(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    doFavorite(paramActivity, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, paramString6, paramBundle, false);
  }
  
  public void doFavorite(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, boolean paramBoolean)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    ArrayList localArrayList = new ArrayList();
    paramString2 = "";
    String str = paramString2;
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("videoDuration");
      localKandianFavoriteBizData.uint32_video_duration.set(paramInt);
      paramInt = paramBundle.getInt("picNum");
      localKandianFavoriteBizData.uint32_pic_num.set(paramInt);
      long l = paramBundle.getLong("publishAccountUin");
      localKandianFavoriteBizData.uint64_account_id.set(l);
      str = paramBundle.getString("publishAccountName");
      if (!TextUtils.isEmpty(str))
      {
        localKandianFavoriteBizData.bytes_account_name.set(ByteStringMicro.copyFromUtf8(str));
        paramString2 = str;
      }
      l = paramBundle.getLong("feedsId");
      localKandianFavoriteBizData.uint64_feeds_id.set(l);
      paramInt = paramBundle.getInt("feedsType");
      localKandianFavoriteBizData.uint32_feeds_type.set(paramInt);
      paramInt = paramBundle.getInt("videoType");
      localKandianFavoriteBizData.uint32_video_type.set(paramInt);
      str = paramString2;
    }
    localArrayList.add(localKandianFavoriteBizData.toByteArray());
    if (paramBoolean)
    {
      new QfavBuilder(6).a("nLinkType", 0).b("sTitle", paramString3).b("sUrl", paramString6).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", str).b("sBrief", paramString4).b("sPath", paramString5).b("sResUrl", paramString6).a("lCategory", 8L).b("sBizDataList", localArrayList).a(paramActivity, paramString1);
      return;
    }
    doFavorite(paramActivity, paramString1, paramString3, paramString4, str, paramString5, paramString6, localArrayList);
  }
  
  public void doFavoriteToast(Context paramContext, boolean paramBoolean, int paramInt)
  {
    paramContext = new QQToast(paramContext);
    paramContext.d(2000);
    if (paramBoolean)
    {
      paramContext.b(2);
      paramContext.a(QQToast.a(2));
      if (paramInt == 1) {
        paramContext.a(HardCodeUtil.a(2131713052));
      } else if (paramInt == 2) {
        paramContext.a(HardCodeUtil.a(2131713027));
      }
      paramContext.a();
      return;
    }
    paramContext.b(1);
    paramContext.a(QQToast.a(1));
    if (paramInt == 1) {
      paramContext.a(HardCodeUtil.a(2131712741));
    } else {
      paramContext.a(HardCodeUtil.a(2131712918));
    }
    paramContext.a();
  }
  
  public void enterGallery(AtlasModelImageList paramAtlasModelImageList, int paramInt)
  {
    this.mAtlasStackInfo.a(paramAtlasModelImageList, paramInt, true, true);
    this.mAtlasStackInfo.a(paramAtlasModelImageList.rowKey);
  }
  
  public void fetchAtlas0xb74(String paramString, boolean paramBoolean1, boolean paramBoolean2, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    fetchAtlas0xb74(localArrayList, paramBoolean1, paramBoolean2, paramAtlasCallbackImpl);
  }
  
  public void fetchAtlas0xb74(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void fetchAtlasBiuCount(String paramString, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fetchAtlasBiuCount, rowKey = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = new oidb_cmd0xb54.ReqBody();
    Object localObject2 = new oidb_cmd0xb54.Client();
    ((oidb_cmd0xb54.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    ((oidb_cmd0xb54.Client)localObject2).uint32_type.set(1);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0xb54.ReqOption();
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_biu_count.set(1);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_option.set((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0xb54.ReqArticle();
    ((oidb_cmd0xb54.ReqArticle)localObject2).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_req_article.set((MessageMicro)localObject2);
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReadInJoyAtlasManager.1(this, paramAtlasCallbackImpl, paramString), ((oidb_cmd0xb54.ReqBody)localObject1).toByteArray(), "OidbSvc.0xb54", 2900, 1, null, 0L);
  }
  
  public void getAtlasCommentCount(String paramString1, String paramString2, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAtlasCommentCount, rowKey = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", reqUrl = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", callback = ");
      ((StringBuilder)localObject2).append(paramAtlasCallback);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramAtlasCallback == null) {
        return;
      }
      localObject1 = new oidb_cmd0xad6.ReqBody();
      localObject2 = new oidb_cmd0xad6.Client();
      ((oidb_cmd0xad6.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
      ((oidb_cmd0xad6.Client)localObject2).uint32_type.set(1);
      oidb_cmd0xad6.ReqArticle localReqArticle = new oidb_cmd0xad6.ReqArticle();
      localReqArticle.bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString1));
      localReqArticle.bytes_url.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((oidb_cmd0xad6.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment_key_type.set(1);
      ((oidb_cmd0xad6.ReqBody)localObject1).msg_req_article.set(localReqArticle);
      ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReadInJoyAtlasManager.6(this, paramAtlasCallback), ((oidb_cmd0xad6.ReqBody)localObject1).toByteArray(), "OidbSvc.0xad6", 2774, 1, null, 0L);
    }
  }
  
  public void getAtlasFavoriteStatus(List<String> paramList, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAtlasFavoriteStatus, rowKeyList = ");
      ((StringBuilder)localObject2).append(paramList);
      ((StringBuilder)localObject2).append(", callback = ");
      ((StringBuilder)localObject2).append(paramAtlasCallback);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new oidb_0xb40.ReqBody();
    Object localObject2 = new oidb_0xb40.CheckFavoriteReqBody();
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        ((oidb_0xb40.CheckFavoriteReqBody)localObject2).rpt_bytes_rowkey.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    ((oidb_0xb40.ReqBody)localObject1).msg_check_favorite_req.set((MessageMicro)localObject2);
    paramList = new Bundle();
    ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new ReadInJoyAtlasManager.5(this, paramAtlasCallback), ((oidb_0xb40.ReqBody)localObject1).toByteArray(), "OidbSvc.0xb40", 2880, 1, paramList, 0L);
  }
  
  public JSONArray getCurrentRowKey()
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(this.mAtlasStackInfo.a());
    return localJSONArray;
  }
  
  public String getExposedRowKeys(String paramString)
  {
    Object localObject = getAvailableExposedRowKeys(paramString);
    paramString = new JSONArray();
    localObject = ((ArrayDeque)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.put((String)((Iterator)localObject).next());
    }
    return paramString.toString();
  }
  
  public JSONArray getExposedRowKeys()
  {
    Object localObject = this.mAtlasStackInfo.a();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((ArrayDeque)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localJSONArray.put((String)((Iterator)localObject).next());
    }
    return localJSONArray;
  }
  
  public int getNumber()
  {
    return this.mAtlasStackInfo.a().size();
  }
  
  public int getNumber(String paramString)
  {
    return getAvailableExposedRowKeys(paramString).size();
  }
  
  public int getReadCount()
  {
    return this.mAtlasStackInfo.a().size();
  }
  
  public void onDestroy()
  {
    this.mAtlasStackInfo.a();
  }
  
  public void recommendEnter(AtlasModelImageList paramAtlasModelImageList, boolean paramBoolean)
  {
    this.mAtlasStackInfo.a(paramAtlasModelImageList, 1, true, paramBoolean);
  }
  
  public void recommendFetched(AtlasModelImageList paramAtlasModelImageList)
  {
    this.mAtlasStackInfo.a(paramAtlasModelImageList, 1, false, false);
  }
  
  public void reportGalleryExposed0xbe1(ArrayList<String> paramArrayList, String paramString, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportGalleryExposed0xbe1, moreGalleryRowKeyList = ");
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append("nextGalleryRowKey = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", callback = ");
      localStringBuilder.append(paramAtlasCallbackImpl);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new cmd0xbe1.ReqBody();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i))) {
          ((cmd0xbe1.ReqBody)localObject).rpt_bytes_more_rowkey_list.add(ByteStringMicro.copyFromUtf8((String)paramArrayList.get(i)));
        }
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      ((cmd0xbe1.ReqBody)localObject).rpt_bytes_rowkey_list.add(ByteStringMicro.copyFromUtf8(paramString));
    }
    if ((!((cmd0xbe1.ReqBody)localObject).rpt_bytes_rowkey_list.has()) && (!((cmd0xbe1.ReqBody)localObject).rpt_bytes_more_rowkey_list.has())) {
      return;
    }
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReadInJoyAtlasManager.4(this, paramAtlasCallbackImpl), ((cmd0xbe1.ReqBody)localObject).toByteArray(), "OidbSvc.0xbe1", 3041, 1, null, 0L);
  }
  
  public void reportMoreGalleryExposed(ArrayList<String> paramArrayList, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    reportGalleryExposed0xbe1(paramArrayList, null, paramAtlasCallbackImpl);
  }
  
  public void reportNextGalleryExposed(String paramString, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl)
  {
    reportGalleryExposed0xbe1(null, paramString, paramAtlasCallbackImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager
 * JD-Core Version:    0.7.0.1
 */