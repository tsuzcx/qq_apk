import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stGlobalConfig;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.4;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class snf
{
  public static SparseArray<String> a;
  public static String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static int a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).a() == null) || (((QQAppInterface)localObject).a().a() == null)) {
        return 0;
      }
      return ((QQAppInterface)localObject).a().a().a(ajsd.aP, 1008);
    }
    return 0;
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  private static Bitmap a(URL paramURL, ImageView paramImageView)
  {
    if ((paramURL != null) && (paramImageView.getWidth() > 0))
    {
      rph localrph = new rph();
      localrph.jdField_a_of_type_JavaNetURL = paramURL;
      localrph.jdField_a_of_type_Int = paramImageView.getWidth();
      localrph.b = paramImageView.getHeight();
      paramURL = bbcw.a(localrph.a());
      if (paramURL != null) {
        return paramURL.a();
      }
    }
    return null;
  }
  
  public static WSRedDotPushMsg a()
  {
    Object localObject = a();
    if (a((otm)localObject))
    {
      localObject = ((otm)localObject).a();
      snb.d("WSPushLog", "WSRedDotPushMsg = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return WSRedDotPushMsg.getInstance((String)localObject);
      }
    }
    return null;
  }
  
  public static WSRedDotPushMsg a(MessageForStructing paramMessageForStructing)
  {
    if (a(paramMessageForStructing))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg;
      if ((paramMessageForStructing != null) && (!TextUtils.isEmpty(paramMessageForStructing.mMsgActionData))) {
        return WSRedDotPushMsg.getInstance(paramMessageForStructing.mMsgActionData);
      }
    }
    return null;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return localObject;
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    String str = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "";
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str2 = "";
    if ((paramstSimpleMetaFeed == null) || (TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "";
    }
    String str1;
    if ((paramstSimpleMetaFeed.imgReplacements != null) && (paramstSimpleMetaFeed.imgReplacements.size() > 0)) {
      str1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0)).img;
    }
    while (TextUtils.isEmpty(str1))
    {
      return "";
      str1 = str2;
      if (paramstSimpleMetaFeed.images != null)
      {
        str1 = str2;
        if (paramstSimpleMetaFeed.images.size() > 0) {
          str1 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(0)).url;
        }
      }
    }
    if (ImageUtil.isJpgFile(str1)) {
      return "jpg";
    }
    if (ImageUtil.isPngFile(str1)) {
      return "png";
    }
    if (ImageUtil.isWebpFile(str1)) {
      return "webp";
    }
    return "";
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    String str2 = "";
    String str1;
    if ((paramstSimpleMetaFeed.imgReplacements != null) && (paramstSimpleMetaFeed.imgReplacements.size() > 0) && (Build.VERSION.SDK_INT > 17)) {
      if ((!paramBoolean) && (paramstSimpleMetaFeed.imgReplacements.size() > 1)) {
        str1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(1)).img;
      }
    }
    while (!TextUtils.isEmpty(str1))
    {
      return str1;
      str1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0)).img;
      continue;
      str1 = str2;
      if (paramstSimpleMetaFeed.images != null)
      {
        str1 = str2;
        if (paramstSimpleMetaFeed.images.size() > 0) {
          if ((!paramBoolean) && (paramstSimpleMetaFeed.images.size() > 1)) {
            str1 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(1)).url;
          } else {
            str1 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(0)).url;
          }
        }
      }
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        if (paramString.contains("@{uid:"))
        {
          str1 = paramString;
          if (paramString.contains(",nick:"))
          {
            str1 = paramString;
            if (paramString.contains("}"))
            {
              int i = paramString.indexOf("@{uid:");
              int j = paramString.indexOf(",nick:");
              int k = paramString.indexOf("}");
              str1 = paramString.substring(i, k + 1);
              String str2 = paramString.substring(j + 6, k) + " ";
              str1 = a(paramString.replace(str1, "@" + URLDecoder.decode(str2)));
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static URL a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new URL(paramString);
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static otm a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).getManager(274) instanceof otm)) {
        return (otm)((QQAppInterface)localObject).getManager(274);
      }
    }
    return null;
  }
  
  public static void a()
  {
    otm localotm = a();
    if (localotm != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = localotm.c();
      localstSimpleMetaFeed.feed_desc = localotm.d();
      localotm.a(localstSimpleMetaFeed);
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramString);
  }
  
  private static void a(Context paramContext)
  {
    if (paramContext != null) {}
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    if ((paramContext != null) && (paramKandianUrlImageView != null))
    {
      Bitmap localBitmap = a(paramURL, paramKandianUrlImageView);
      if (localBitmap != null)
      {
        paramKandianUrlImageView.setImageBitmap(localBitmap);
        paramContext = "";
        if (paramURL != null) {
          paramContext = paramURL.toString();
        }
        skq.b(1, paramContext);
      }
    }
    else
    {
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130841259);
    if (paramURL == null)
    {
      paramKandianUrlImageView.setImageDrawable(paramContext);
      return;
    }
    paramKandianUrlImageView.setIsRecyclerView(true);
    paramKandianUrlImageView.a(paramContext).a(paramURL);
    paramKandianUrlImageView.setPublicAccountImageDownListener(new sng(paramKandianUrlImageView));
  }
  
  public static void a(Context paramContext, RoundImageView paramRoundImageView, String paramString)
  {
    if ((paramContext != null) && (paramRoundImageView != null))
    {
      paramString = a(paramString);
      paramContext = paramContext.getResources().getDrawable(2130839736);
      if (paramString == null) {
        paramRoundImageView.setImageDrawable(paramContext);
      }
    }
    else
    {
      return;
    }
    paramContext = new rph();
    paramContext.jdField_a_of_type_JavaNetURL = paramString;
    rpg.a().a(paramContext, new snh(paramRoundImageView));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, snk paramsnk)
  {
    if (paramsnk == null) {
      throw new RuntimeException("downloadOpenWeishiGoH5 must not be null!");
    }
    if (vzw.a(paramContext))
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        snb.c("815", "走打开shemeUrl:" + paramString1);
        paramsnk.a(paramString1, paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        snb.c("815", "走打开h5Url:" + paramString2);
        paramsnk.b(paramString2, paramInt);
        return;
      }
      snb.c("815", "走打开兜底:" + paramString1);
      paramsnk.a("weishi://main", paramInt);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      snb.c("815", "走跳转h5Url:" + paramString2);
      paramsnk.b(paramString2, paramInt);
      return;
    }
    snb.c("815", "走下载，shemeUrl:" + paramString1);
    paramsnk.c(paramString1, paramInt);
  }
  
  public static void a(Context paramContext, ArrayList<stSimpleMetaFeed> paramArrayList, int paramInt1, String paramString, stGlobalConfig paramstGlobalConfig, int paramInt2)
  {
    a(paramContext, paramArrayList, paramInt1, paramString, paramstGlobalConfig, null, paramInt2);
  }
  
  public static void a(Context paramContext, ArrayList<stSimpleMetaFeed> paramArrayList, int paramInt1, String paramString, stGlobalConfig paramstGlobalConfig, WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent(paramContext, QzoneVerticalVideoDownloadActivity.class);
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    try
    {
      localBundle.putLong("key_current_feeduin", Long.parseLong(paramString));
      localBundle.putInt("key_request_from", 5);
      localBundle.putInt("key_weishi_scene_type", paramInt2);
      localBundle.putSerializable("key_video_weishi_public_account_feed", paramArrayList);
      localBundle.putInt("key_current_item_position", paramInt1);
      localBundle.putInt("start_param_pos", paramInt1);
      if (paramWSRedDotPushMsg != null) {
        localBundle.putParcelable("key_weishi_push_msg_data", paramWSRedDotPushMsg);
      }
      localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
      localIntent.putExtra("launch_time", System.currentTimeMillis());
      localIntent.putExtra("key_video_weishi_public_account_global_config", paramstGlobalConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      paramContext.startActivity(localIntent);
      sjq.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        snb.b("openVerticalVideoLayerPage parseLong posterId : " + paramString);
      }
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(paramDrawable1);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable2;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramImageView.setImageDrawable(paramDrawable1);
    paramDrawable1.setURLDrawableListener(new sni(paramString2, paramImageView, paramString1));
    paramDrawable1.startDownload();
    if (1 != paramDrawable1.getStatus())
    {
      paramDrawable1.restartDownload();
      return;
    }
    snb.a("815", "onLoad ~~~~~~" + paramString2);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramstSimpleMetaFeed.imgReplacements != null)
    {
      localObject1 = localObject2;
      if (paramstSimpleMetaFeed.imgReplacements.size() > 0)
      {
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT > 17) {
          localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0)).img;
        }
      }
    }
    localObject2 = a((String)localObject1);
    if (localObject2 != null)
    {
      snb.b("WeishiUtils", "使用webp图片资源：" + (String)localObject1);
      a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, (URL)localObject2);
      return;
    }
    localObject2 = localObject1;
    if (paramstSimpleMetaFeed.images != null)
    {
      localObject2 = localObject1;
      if (paramstSimpleMetaFeed.images.size() > 0)
      {
        localObject2 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(0)).url;
        snb.b("WeishiUtils", "使用服务器默认的图片格式资源：" + (String)localObject2);
      }
    }
    paramstSimpleMetaFeed = a((String)localObject2);
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString)
  {
    if ((paramKandianUrlImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = a(paramString);
      paramKandianUrlImageView.a(BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130841344)).a(paramString);
    }
  }
  
  public static void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (paramAppInfo != null)
    {
      snb.b("WSRedDotLog", "saveRedDotAppInfo appInfo = " + paramAppInfo.iNewFlag.get());
      snb.b("WSRedDotLog", "saveRedDotAppInfo hasWsRedDot = " + paramBoolean);
      LocalMultiProcConfig.putBooleanAsync("wsRedDot", paramBoolean);
    }
  }
  
  public static void a(String paramString)
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    if (localContext == null) {
      return;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)localContext.getSystemService("clipboard");
    if ((localClipboardManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = b(paramString);
      ClipData localClipData = ClipData.newPlainText("", paramString);
      snb.d("WeishiUtils", "Clipboard copyScheme: " + paramString + ", clip: " + localClipData);
      if (localClipData != null) {
        localClipboardManager.setPrimaryClip(localClipData);
      }
    }
    a(localContext);
  }
  
  public static void a(List<stSimpleMetaFeed> paramList)
  {
    if (!bbfj.h(BaseApplication.getContext())) {}
    while ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    snb.b("PreloadCoverImgLog", "preloadImg size = " + paramList.size());
    ThreadManager.post(new WeishiUtils.4(new ArrayList(paramList)), 5, null, true);
  }
  
  public static boolean a()
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      bool = localQQAppInterface.a.b();
    }
    return bool;
  }
  
  public static boolean a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if ((paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo))
    {
      paramWSRedDotPushMsg = (WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo;
      if (paramWSRedDotPushMsg.mWSPushPreloadModel != null) {
        return paramWSRedDotPushMsg.mWSPushPreloadModel.jdField_a_of_type_Boolean;
      }
    }
    return false;
  }
  
  private static boolean a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {}
    do
    {
      return false;
      snb.d("WSPushLog", "isMsgFromWeishiPush structMsg.frienduin: " + paramMessageForStructing.frienduin);
    } while ((!TextUtils.equals(ajsd.aP, paramMessageForStructing.frienduin)) || (paramMessageForStructing.issend != 0));
    return true;
  }
  
  public static boolean a(otm paramotm)
  {
    if (paramotm == null) {
      return false;
    }
    return a(paramotm.a());
  }
  
  public static String b()
  {
    Object localObject = a();
    if (!a((otm)localObject)) {
      return "";
    }
    localObject = ((otm)localObject).a();
    if ((localObject != null) && (((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mArticleIds)))
    {
      localObject = ((MessageForStructing)localObject).structingMsg.mArticleIds.split("\\|");
      if (localObject.length > 0) {
        return localObject[0];
      }
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    return paramString + "&idx=" + sjy.a().e();
  }
  
  public static String c()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String d()
  {
    String str = "unknown";
    if (AppNetConnInfo.isWifiConn()) {
      str = "Wi-Fi";
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return str;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return "unknown";
    case 1: 
      return "2G";
    case 2: 
      return "3G";
    case 3: 
      return "4G";
    }
    return "5G";
  }
  
  public static String e()
  {
    try
    {
      Object localObject = (WifiManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getBSSID();
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      snb.d("WeishiUtils", "getWifiBssid : " + localException.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     snf
 * JD-Core Version:    0.7.0.1
 */