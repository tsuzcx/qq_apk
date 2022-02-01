import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class rha
{
  public static int a()
  {
    return Aladdin.getConfig(277).getIntegerFromString("ugc_video_upload_main_switch", 0);
  }
  
  @VisibleForTesting
  static int a(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.status == UgcVideo.STATUS_IDLE) || (paramUgcVideo.status == UgcVideo.STATUS_PAUSE)) {}
    do
    {
      return 8;
      if (paramUgcVideo.status != UgcVideo.STATUS_UPLOADING) {
        break;
      }
      if (paramUgcVideo.uploadVideoStatus == UgcVideo.SUBSTATUS_COMPRESS_VIDEO) {
        return 1;
      }
    } while (paramUgcVideo.uploadVideoStatus != UgcVideo.SUBSTATUS_UPLOADING_VIDEO);
    return 6;
    if (paramUgcVideo.status == UgcVideo.STATUS_FINISH) {
      return 13;
    }
    if (paramUgcVideo.status == UgcVideo.STATUS_FAILED) {
      return 9;
    }
    return 0;
  }
  
  public static long a(@NotNull UgcVideo paramUgcVideo)
  {
    long l = paramUgcVideo.fileSize - paramUgcVideo.videoProgress * paramUgcVideo.fileSize / 100L;
    if (l < 0L) {
      return 0L;
    }
    return l;
  }
  
  public static long a(@NotNull List<UgcVideo> paramList)
  {
    if (paramList.isEmpty()) {
      return 0L;
    }
    paramList = paramList.iterator();
    for (long l = 0L; paramList.hasNext(); l = a((UgcVideo)paramList.next()) + l) {}
    return l;
  }
  
  public static String a()
  {
    String str = Aladdin.getConfig(284).getString("ugc_topic_detail_page_url", "");
    if (!str.isEmpty()) {
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "getViolaColumnDetailPageUrl decode fail. e : " + localUnsupportedEncodingException.toString());
        return "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3740&from_page=4&topicId=";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJUGC.RIJUgcUtils", 2, "getViolaColumnDetailPageUrl from aladdin fail.");
    }
    return "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3740&from_page=4&topicId=";
  }
  
  @NotNull
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "readinjoy_sp_key_mycolumn_entry";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "readinjoy_sp_key_myvideo_entry";
      }
    } while (paramInt != 3);
    return "readinjoy_sp_key_mysubscribe_entry";
  }
  
  @NotNull
  public static String a(int paramInt, Context paramContext)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(317);
    if (paramInt == 0) {
      return localAladdinConfig.getString("ugc_topic_forbid_submit_title", paramContext.getResources().getString(2131717728));
    }
    return localAladdinConfig.getString("ugc_topic_allow_submit_title", paramContext.getResources().getString(2131717726));
  }
  
  @NotNull
  private static String a(int paramInt, boolean paramBoolean)
  {
    String str = "";
    if (paramBoolean) {
      if (paramInt == 1) {
        str = "https://viola.qq.com/js/columnMyColumn.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnMyColumn&v_bid=3740";
      }
    }
    do
    {
      do
      {
        return str;
        if (paramInt == 2) {
          return "https://viola.qq.com/js/columnMyVideo.js?_rij_violaUrl=1&v_tid=2&hideNav=1&v_nav_immer=1&v_bundleName=columnMyVideo";
        }
      } while (paramInt != 3);
      return "https://viola.qq.com/js/columnMySub.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnMySub&v_bid=3740";
      if (paramInt == 1) {
        return "https://viola.qq.com/js/columnMyColumn.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=columnMyColumn&v_bid=3740";
      }
      if (paramInt == 2) {
        return "https://viola.qq.com/js/columnMyVideo.js?_rij_violaUrl=1&v_tid=6&hideNav=1&v_nav_immer=1&v_bundleName=columnMyVideo&v_bid=3740";
      }
    } while (paramInt != 3);
    return "https://viola.qq.com/js/columnMySub.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=columnMySub&v_bid=3740";
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L) {
      return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }) + "KB";
    }
    if (paramLong < 1073741824L) {
      return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }) + "MB";
    }
    return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }) + "GB";
  }
  
  public static String a(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_publish_create_text", paramContext.getResources().getString(2131717346));
  }
  
  @NotNull
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = a(paramInt);
    if ((str.isEmpty()) || (paramQQAppInterface == null)) {
      paramContext = "";
    }
    do
    {
      return paramContext;
      str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(str, "");
      if (str == null) {
        break;
      }
      paramContext = str;
    } while (!str.isEmpty());
    return a(paramInt, bkwm.m(paramQQAppInterface));
  }
  
  @NotNull
  public static String a(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length() - 1)) {
      return "";
    }
    return paramString.substring(i + 1).toLowerCase();
  }
  
  public static JSONArray a(@NotNull List<UgcVideo> paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("vid", String.valueOf(localUgcVideo.seqId));
        localJSONObject.put("status", a(localUgcVideo));
        localJSONObject.put("totalSize", a(localUgcVideo.fileSize));
        localJSONObject.put("duration", localUgcVideo.duration);
        localJSONObject.put("title", localUgcVideo.title);
        localJSONObject.put("coverUrl", localUgcVideo.coverUrl);
        localJSONObject.put("compressProgress", localDecimalFormat.format(localUgcVideo.compressProgress * 1.0F / 100.0F));
        localJSONObject.put("uploadingProgress", localDecimalFormat.format(localUgcVideo.videoProgress * 1.0F / 100.0F));
        localJSONObject.put("networkSpeed", localUgcVideo.uploadSpeed);
        localJSONObject.put("uploadSize", a(localUgcVideo.fileSize * localUgcVideo.videoProgress / 100L));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      QLog.i("RIJUGC.RIJUgcUtils", 1, "getUploadVideoListForViola exception, e=" + QLog.getStackTraceString(paramList));
    }
  }
  
  @NotNull
  public static pbg a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    return new pbg().a("uin", paramQQAppInterface.getCurrentAccountUin()).a("page_type", Integer.valueOf(paramInt1)).a("secret_flag", Integer.valueOf(paramInt2));
  }
  
  @NotNull
  public static pbg a(@Nullable QQAppInterface paramQQAppInterface, @NotNull UgcVideo paramUgcVideo)
  {
    String str = "";
    if (paramQQAppInterface != null) {
      str = paramQQAppInterface.getCurrentAccountUin();
    }
    return new pbg().a("uin", str).a("seqId", paramUgcVideo.seqId).a("file_size", Long.valueOf(paramUgcVideo.fileSize)).a("format", a(paramUgcVideo.filePath)).a("bit_rate", Long.valueOf(paramUgcVideo.bitrate)).a("heigth", Integer.valueOf(paramUgcVideo.height)).a("width", Integer.valueOf(paramUgcVideo.width)).a("video_duration", Integer.valueOf(paramUgcVideo.duration));
  }
  
  public static void a(Activity paramActivity, int paramInt1, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt2, @Nullable String paramString4, int paramInt3)
  {
    paramString1 = new ColumnInfo(paramInt1, paramString1, paramString2, paramString3, paramInt2);
    paramString2 = new Intent();
    paramString2.putExtra("key_column_info", paramString1);
    if (paramString4 != null)
    {
      paramString2.putExtra("arg_callback", paramString4);
      paramString2.putExtra("key_from", 3);
    }
    PublicFragmentActivity.a(paramActivity, paramString2, EditColumnFragment.class, paramInt3);
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramColumnInfo != null) {
      localIntent.putExtra("key_column_info", paramColumnInfo);
    }
    localIntent.putExtra("key_from", paramInt);
    if ((paramInt == 1) || (paramInt == 2)) {
      PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoFragment.class);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoTabFragment.class);
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (paramColumnInfo != null) {
      localIntent.putExtra("key_column_info", paramColumnInfo);
    }
    localIntent.putExtra("key_from", paramInt1);
    if (paramString != null) {
      localIntent.putExtra("arg_callback", paramString);
    }
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoFragment.class, paramInt2);
    }
    while ((paramInt1 != 3) && (paramInt1 != 4)) {
      return;
    }
    PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoTabFragment.class, paramInt2);
  }
  
  public static void a(Activity paramActivity, @Nullable String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramString != null)
    {
      localIntent.putExtra("arg_callback", paramString);
      localIntent.putExtra("key_from", 1);
    }
    PublicFragmentActivity.a(paramActivity, CreateColumnFragment.class, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from", paramInt);
    PublicFragmentActivity.a(paramContext, localIntent, CreateColumnFragment.class);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    String str = a(paramInt);
    if (str.isEmpty()) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(str, paramString);
    paramContext.apply();
  }
  
  public static void a(@NotNull Context paramContext, long paramLong, @NotNull rhe paramrhe, @Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = bfur.a(paramContext, 230).setMessage(paramContext.getResources().getString(2131717557, new Object[] { a(paramLong) })).setNegativeButton(paramContext.getResources().getString(2131717297), new rhc(paramrhe)).setPositiveButton(paramContext.getResources().getString(2131717446), new rhb(paramrhe));
    if (paramOnDismissListener != null) {
      paramContext.setOnDismissListener(new rhd(paramOnDismissListener));
    }
    paramContext.show();
  }
  
  public static void a(String paramString, UgcVideo paramUgcVideo)
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis() - paramUgcVideo.startUploadingTime;
    paramUgcVideo.uploadTotalCostTime += l2;
    if (paramUgcVideo.startUserWaitingTime > 0L)
    {
      l1 = System.currentTimeMillis() - paramUgcVideo.startUserWaitingTime;
      paramUgcVideo.userWaitingTotalCostTime += l1;
    }
    QLog.i("RIJUGC.RIJUgcUtils", 1, "calculateUploadingCost," + paramString + ", cost=" + l2 + ",totalCost=" + paramUgcVideo.uploadTotalCostTime + ", waitingCost=" + l1 + ", totalWaitingCost=" + paramUgcVideo.userWaitingTotalCostTime);
  }
  
  public static boolean a()
  {
    return (a() == 1) && (!bkwm.D());
  }
  
  public static boolean a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    while ((!l()) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  public static int b()
  {
    int i = Aladdin.getConfig(358).getIntegerFromString("jump_after_publish", 1);
    QLog.d("RIJUGC.RIJUgcUtils", 2, "getJumpFeedsTypeAfterPublishVideo | feedsType ：" + i);
    return i;
  }
  
  public static String b()
  {
    String str = Aladdin.getConfig(284).getString("ugc_my_video_list_page_url", "");
    if (!str.isEmpty()) {
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "getViolaMyVideoListPageUrl decode fail. e : " + localUnsupportedEncodingException.toString());
        return "https://viola.qq.com/js/columnAddVideo.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnAddVideo&v_bid=3740&colid=";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJUGC.RIJUgcUtils", 2, "getViolaMyVideoListPageUrl from aladdin fail.");
    }
    return "https://viola.qq.com/js/columnAddVideo.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnAddVideo&v_bid=3740&colid=";
  }
  
  @NotNull
  public static String b(int paramInt, Context paramContext)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(317);
    if (paramInt == 0) {
      return localAladdinConfig.getString("ugc_topic_forbid_submit_tips", paramContext.getResources().getString(2131717727));
    }
    return localAladdinConfig.getString("ugc_topic_allow_submit_tips", paramContext.getResources().getString(2131717725));
  }
  
  public static String b(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_topic_create_text", paramContext.getResources().getString(2131717303));
  }
  
  public static void b(@Nullable Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject1 = (ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290);
      Object localObject2 = new FrameLayout(paramActivity);
      ((FrameLayout)localObject2).setId(2131375939);
      ((ViewGroup)localObject1).addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = new SelectTopicFragment();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_rowKey", paramString);
      ((Bundle)localObject2).putInt("key_from", paramInt);
      ((Bundle)localObject2).putInt("fragment_view_id", 2131375939);
      ((Fragment)localObject1).setArguments((Bundle)localObject2);
      ((FragmentActivity)paramActivity).getSupportFragmentManager().beginTransaction().replace(2131375939, (Fragment)localObject1).commit();
    }
  }
  
  public static boolean b()
  {
    if (a() == 2) {
      return true;
    }
    if (a() == 1) {
      return bkwm.D();
    }
    return false;
  }
  
  public static int c()
  {
    int i = Aladdin.getConfig(354).getIntegerFromString("ugc_publish_restriction_textLength", 100);
    QLog.d("RIJUGC.RIJUgcUtils", 2, "getUgcPublishTextMaxLength | length " + i);
    return i;
  }
  
  public static String c(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_video_create_text", paramContext.getResources().getString(2131717464));
  }
  
  public static boolean c()
  {
    boolean bool = true;
    if (Aladdin.getConfig(358).getIntegerFromString("upload_with_topic", 0) == 1) {}
    for (;;)
    {
      QLog.d("RIJUGC.RIJUgcUtils", 2, "showDefaultSelectedColumn | show " + bool);
      return bool;
      bool = false;
    }
  }
  
  public static int d()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_topic_title_max_lengh", 12);
  }
  
  public static String d(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_and_remind_title", paramContext.getResources().getString(2131717457));
  }
  
  public static boolean d()
  {
    boolean bool = true;
    if (Aladdin.getConfig(354).getIntegerFromString("ugc_publish_function_gif", 1) != 0) {}
    for (;;)
    {
      QLog.d("RIJUGC.RIJUgcUtils", 2, "showUgcPublishGifSwitch | show " + bool);
      return bool;
      bool = false;
    }
  }
  
  public static int e()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_topic_brief_max_lengh", 60);
  }
  
  public static String e(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_and_remind_tips", paramContext.getResources().getString(2131717458));
  }
  
  public static boolean e()
  {
    boolean bool = false;
    if (Aladdin.getConfig(354).getIntegerFromString("ugc_publish_function_location", 0) != 0) {
      bool = true;
    }
    QLog.d("RIJUGC.RIJUgcUtils", 2, "showUgcPublishLocationSwitch | show " + bool);
    return bool;
  }
  
  public static int f()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_video_title_max_length", 36);
  }
  
  public static String f(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_title", paramContext.getResources().getString(2131717456));
  }
  
  public static boolean f()
  {
    boolean bool = false;
    if (Aladdin.getConfig(354).getIntegerFromString("ugc_publish_entrance_topic", 0) != 0) {
      bool = true;
    }
    QLog.d("RIJUGC.RIJUgcUtils", 2, "showUgcPublishTopicSwitch | show " + bool);
    return bool;
  }
  
  public static int g()
  {
    if (Aladdin.getConfig(295).getIntegerFromString("ugc_video_publish_show_public", 0) == 1) {
      return 0;
    }
    return 8;
  }
  
  public static String g(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_tips", paramContext.getResources().getString(2131717459));
  }
  
  public static boolean g()
  {
    boolean bool2 = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(277);
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (localAladdinConfig.getIntegerFromString("ugc_publish_create_entrance", 0) != 0) {
        bool1 = true;
      }
    }
    QLog.d("RIJUGC.RIJUgcUtils", 2, "showUgcPublishCreateEntrance | show " + bool1);
    return bool1;
  }
  
  public static int h()
  {
    int i = Aladdin.getConfig(295).getIntegerFromString("ugc_video_publish_public_default", 2);
    if (i == 1) {
      return UgcVideo.TYPE_PUBLIC_AND_REMIND;
    }
    if (i == 3) {
      return UgcVideo.TYPE_NO_PUBLIC;
    }
    return UgcVideo.TYPE_PUBLIC;
  }
  
  public static String h(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_private_title", paramContext.getResources().getString(2131717440));
  }
  
  public static boolean h()
  {
    boolean bool = true;
    if (b())
    {
      AladdinConfig localAladdinConfig = Aladdin.getConfig(277);
      int i;
      int j;
      if (localAladdinConfig.getIntegerFromString("ugc_upload_video_authority", 0) == 2)
      {
        i = 1;
        if (localAladdinConfig.getIntegerFromString("ugc_topic_create_entrance", 0) == 0) {
          break label89;
        }
        j = 1;
        label42:
        if ((!i()) || (i == 0) || (j == 0)) {
          break label94;
        }
      }
      for (;;)
      {
        QLog.d("RIJUGC.RIJUgcUtils", 2, "needShowCreateColumnEntry | showColumnCreateEntry " + bool);
        return bool;
        i = 0;
        break;
        label89:
        j = 0;
        break label42;
        label94:
        bool = false;
      }
    }
    return false;
  }
  
  public static int i()
  {
    return Aladdin.getConfig(283).getIntegerFromString("create_column_redirect", 2);
  }
  
  public static String i(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_private_tips", paramContext.getResources().getString(2131717441));
  }
  
  public static boolean i()
  {
    if (b()) {
      return j();
    }
    return false;
  }
  
  public static int j()
  {
    return Aladdin.getConfig(283).getIntegerFromString("upload_video_redirect", 2);
  }
  
  public static boolean j()
  {
    boolean bool2 = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(277);
    int i = localAladdinConfig.getIntegerFromString("ugc_video_upload_entrance", 0);
    int j = localAladdinConfig.getIntegerFromString("ugc_upload_video_authority", 0);
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    QLog.d("RIJUGC.RIJUgcUtils", 1, "showPublishVideoEntry | show " + bool1);
    return bool1;
  }
  
  public static boolean k()
  {
    boolean bool = false;
    if (Aladdin.getConfig(277).getIntegerFromString("ugc_upload_video_authority", 0) == 2) {
      bool = true;
    }
    QLog.d("RIJUGC.RIJUgcUtils", 1, "showVideoColumnPanel | show " + bool);
    return bool;
  }
  
  public static boolean l()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (Aladdin.getConfig(277).getIntegerFromString("add_to_column_entrance", 0) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean m()
  {
    return (b()) && (o());
  }
  
  public static boolean n()
  {
    return (bkwm.n(pay.a()) & 0x2) != 0;
  }
  
  public static boolean o()
  {
    return (g()) || (h()) || (j()) || (n());
  }
  
  public static boolean p()
  {
    return h();
  }
  
  public static boolean q()
  {
    return i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rha
 * JD-Core Version:    0.7.0.1
 */