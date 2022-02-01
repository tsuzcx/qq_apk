import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class sab
  implements qzv
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private SparseArray<sif> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private apkn jdField_a_of_type_Apkn;
  private bjnw jdField_a_of_type_Bjnw;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new sbk(this, null);
  private nzr jdField_a_of_type_Nzr;
  private rah jdField_a_of_type_Rah;
  private sbi jdField_a_of_type_Sbi;
  ugz jdField_a_of_type_Ugz;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
  public sab(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, sbi paramsbi, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Sbi = paramsbi;
    this.e = paramBoolean;
    this.jdField_a_of_type_Nzr = ((nzr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(136));
    if (this.jdField_a_of_type_Nzr != null) {
      this.jdField_a_of_type_Nzr.a();
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Rah = new rah(new rad());
    this.jdField_a_of_type_Rah.a(this);
    e();
  }
  
  public static Intent a(VideoInfo paramVideoInfo)
  {
    AbsStructMsg localAbsStructMsg = null;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("detail_url", paramVideoInfo.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131695880, new Object[] { paramVideoInfo.jdField_c_of_type_JavaLangString }));
    if (paramVideoInfo.jdField_a_of_type_Int == 6)
    {
      localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
      localIntent.putExtra("app_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localAbsStructMsg = bchh.a(localIntent.getExtras());
      localAbsStructMsg.mMsgServiceID = 83;
    }
    for (;;)
    {
      if (localAbsStructMsg != null) {
        localIntent.putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
      }
      return localIntent;
      if (paramVideoInfo.jdField_a_of_type_Int == 7)
      {
        localIntent.putExtra("app_name", "QQ搜索");
        localIntent.putExtra("desc", paramVideoInfo.jdField_d_of_type_JavaLangString);
        localAbsStructMsg = bchh.a(localIntent.getExtras());
        localAbsStructMsg.mMsgServiceID = 1;
      }
    }
  }
  
  public static Bundle a(VideoInfo paramVideoInfo, int paramInt)
  {
    String str1 = null;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("TINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramVideoInfo.jdField_d_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramVideoInfo.jdField_b_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramVideoInfo.jdField_c_of_type_Int);
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramVideoInfo.jdField_d_of_type_Int);
    ((Bundle)localObject).putString("source_puin", paramVideoInfo.j);
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.j);
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.k);
    ((Bundle)localObject).putInt("TYPE", paramVideoInfo.jdField_a_of_type_Int);
    ((Bundle)localObject).putString("ARTICLE_ID", paramVideoInfo.g);
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
    label292:
    String str2;
    label391:
    String str4;
    if ((paramVideoInfo.m != null) && (paramVideoInfo.m.contains("kandianshare.html5.qq.com")))
    {
      ((Bundle)localObject).putString("detail_url", paramVideoInfo.m);
      ((Bundle)localObject).putString("video_url", paramVideoInfo.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putString("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
      ((Bundle)localObject).putString("req_create_time", paramVideoInfo.e);
      ((Bundle)localObject).putString("brief_key", paramVideoInfo.jdField_c_of_type_JavaLangString);
      if (paramVideoInfo.jdField_a_of_type_Int != 6) {
        break label650;
      }
      ((Bundle)localObject).putInt("VIDEO_FEED_TYPE", paramVideoInfo.h);
      ((Bundle)localObject).putLong("VIDEO_FEED_ID", paramVideoInfo.jdField_d_of_type_Long);
      ((Bundle)localObject).putString("compatible_text", paramVideoInfo.jdField_c_of_type_JavaLangString + ": " + paramVideoInfo.jdField_f_of_type_JavaLangString);
      ((Bundle)localObject).putInt("req_type", 125);
      ((Bundle)localObject).putInt("PREVIEW_START_POSI", sdi.a(paramInt, paramVideoInfo.a()));
      localObject = (StructMsgForGeneralShare)bchh.a((Bundle)localObject);
      if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf(amtj.a(2131715221)) == -1)) {
        ((StructMsgForGeneralShare)localObject).mMsgBrief = (amtj.a(2131715243) + ((StructMsgForGeneralShare)localObject).mMsgBrief);
      }
      uem.a((StructMsgForGeneralShare)localObject);
      if (TextUtils.isEmpty(paramVideoInfo.p)) {
        break label662;
      }
      str1 = paramVideoInfo.p;
      str2 = paramVideoInfo.o;
      ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
      String str3 = paramVideoInfo.j;
      str4 = uem.a(str3);
      String str5 = paramVideoInfo.k;
      if (!TextUtils.isEmpty(str3)) {
        ((StructMsgForGeneralShare)localObject).mSourceAppid = Long.valueOf(str3).longValue();
      }
      ((StructMsgForGeneralShare)localObject).source_puin = paramVideoInfo.j;
      if (paramVideoInfo.jdField_a_of_type_Int <= 1) {
        break label717;
      }
      if ((TextUtils.isEmpty(str3)) || (str3.equals("16888"))) {
        break label690;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      label483:
      if ((str5 != null) && (!"".equals(str5))) {
        ((StructMsgForGeneralShare)localObject).mSourceThirdName = str5;
      }
      label505:
      if ((str5 != null) && (!"".equals(str5))) {
        ((StructMsgForGeneralShare)localObject).mSourceName = str5;
      }
      if ((str1 == null) || ("".equals(str1))) {
        break label726;
      }
    }
    label650:
    label662:
    label690:
    label717:
    label726:
    for (((StructMsgForGeneralShare)localObject).mSourceIcon = str1;; ((StructMsgForGeneralShare)localObject).mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png")
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramVideoInfo = new Bundle();
      paramVideoInfo.putInt("forward_type", -3);
      paramVideoInfo.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramVideoInfo.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      return paramVideoInfo;
      if ((paramVideoInfo.jdField_f_of_type_JavaLangString != null) && (!paramVideoInfo.jdField_f_of_type_JavaLangString.contains("&sourcefrom=0"))) {
        paramVideoInfo.jdField_f_of_type_JavaLangString += "&sourcefrom=0";
      }
      ((Bundle)localObject).putString("detail_url", paramVideoInfo.jdField_f_of_type_JavaLangString);
      break;
      ((Bundle)localObject).putInt("req_type", 140);
      break label292;
      if (TextUtils.isEmpty(paramVideoInfo.j)) {
        break label391;
      }
      str1 = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null));
      break label391;
      if (!TextUtils.isEmpty(str2))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
        break label483;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break label483;
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      break label505;
    }
  }
  
  @NotNull
  private String a(VideoInfo paramVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_Nzr == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Nzr.a())
    {
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))
      {
        localStringBuilder.append(paramVideoInfo.jdField_f_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append("&iid=").append(str);
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    VideoInfo localVideoInfo2 = null;
    VideoInfo localVideoInfo1 = null;
    rdz localrdz;
    if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6) && (!this.e))
    {
      localrdz = new rdz();
      localrdz.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      localrdz.e = (paramVideoInfo.a() * 1000);
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break label184;
      }
      localrdz.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    }
    label184:
    for (paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; paramInt = -1)
    {
      if (this.jdField_c_of_type_Int == 1)
      {
        localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        paramVideoInfo = localVideoInfo1;
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) {
          paramVideoInfo = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
        }
        ofe.a(localVideoInfo2, paramInt, 26, -1, localrdz, paramVideoInfo);
        return;
      }
      localVideoInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      paramVideoInfo = localVideoInfo2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) {
        paramVideoInfo = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      }
      ofe.b(localVideoInfo1, paramInt, 26, -1, localrdz, paramVideoInfo);
      return;
    }
  }
  
  private void a(int paramInt1, VideoInfo paramVideoInfo, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramVideoInfo.v))
    {
      paramString = paramVideoInfo.v;
      bool1 = true;
      if ((paramVideoInfo.n == null) || (!paramVideoInfo.n.contains("kandianshare.html5.qq.com"))) {
        break label234;
      }
      paramString = paramVideoInfo.n;
    }
    label234:
    for (;;)
    {
      Object localObject = new StringBuilder();
      if (paramVideoInfo.r > 0) {
        ((StringBuilder)localObject).append(rwv.b(paramVideoInfo.r)).append(" ");
      }
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = paramVideoInfo.jdField_c_of_type_JavaLangString;
      localObject = ((StringBuilder)localObject).toString();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (paramInt1 == 9) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        off.a(localBaseActivity, str, (String)localObject, paramString, localBitmap, bool2, paramVideoInfo.g, bool1, new sbn(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt2, paramInt3, paramVideoInfo));
        return;
        if (paramInt1 == 9)
        {
          paramString = paramString + "&sourcefrom=2";
          break;
        }
        paramString = paramString + "&sourcefrom=3";
        break;
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, @NotNull String paramString1, int paramInt2, String paramString2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (paramVideoInfo.jdField_a_of_type_Int == 0)
    {
      paramVideoInfo = paramActivity.getIntent().getExtras();
      paramVideoInfo.putInt("forward_type", 21);
      paramVideoInfo.putBoolean("forward_need_sendmsg", true);
      paramVideoInfo.putString("forward_thumb", ShortVideoUtils.getShortVideoThumbPicPath(paramActivity.getIntent().getExtras().getString("thumbfile_md5"), "jpg"));
      paramString1 = new Intent();
      paramString1.putExtras(paramVideoInfo);
      atky.a(paramActivity, paramString1);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 7) || ((paramVideoInfo.jdField_a_of_type_Int == 6) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))))
    {
      atky.a(paramActivity, a(paramVideoInfo), 21);
      return;
    }
    paramVideoInfo = a(paramVideoInfo, paramInt1);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramVideoInfo);
    if (TextUtils.isEmpty(paramString1))
    {
      atky.a(paramActivity, localIntent, 21);
      return;
    }
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt2);
    localIntent.putExtra("uinname", paramString2);
    atky.a(paramActivity, localIntent, DirectForwardActivity.class, 21, -1, "");
  }
  
  private void a(VideoInfo paramVideoInfo, @NotNull String paramString1, int paramInt, String paramString2)
  {
    a(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramString1, paramInt, paramString2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", ozb.a(this.jdField_a_of_type_AndroidAppActivity));
      localJSONObject.put("os", "1");
      localJSONObject.put("source", this.jdField_a_of_type_Int + "");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localJSONObject.put("version", ofe.jdField_a_of_type_JavaLangString);
      localJSONObject.put("vid", paramString3);
      if (paramBoolean) {
        localJSONObject.put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        localJSONObject.put("sourcefrom", paramInt1 + "");
      }
      if (paramInt2 >= 0) {
        localJSONObject.put("share_unit", paramInt2 + "");
      }
      localJSONObject.put("show", this.jdField_b_of_type_Int);
      localJSONObject.put("type", 1);
      paramVideoInfo = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramVideoInfo = str;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoFeedsShareController", 2, "shareReport:" + paramString1.toString());
          paramVideoInfo = str;
        }
      }
    }
    paramVideoInfo = new sie(paramVideoInfo);
    odq.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramVideoInfo.a().a(), false);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = 0;
    a("shareMsgToSina start!");
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = amtj.a(2131715245);
    localObject[1] = amtj.a(2131715174);
    localObject[2] = amtj.a(2131715208);
    localObject[3] = amtj.a(2131715156);
    localObject[4] = amtj.a(2131715203);
    localObject[5] = amtj.a(2131715167);
    localObject[6] = amtj.a(2131715225);
    localObject[7] = amtj.a(2131715186);
    localObject[8] = amtj.a(2131715179);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      a("shareMsgToSina empty title or share_url");
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131718380, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
    a("shareMsgToSina installSinaWeibo:false");
    try
    {
      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
      paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1 + "%F0%9F%8E%AC";
      paramString3 = URLEncoder.encode(paramString3, "UTF-8");
      paramString1 = paramString1 + "&url=" + paramString3;
      paramString3 = URLEncoder.encode(paramString4, "UTF-8");
      paramString1 = paramString1 + "&pic=" + paramString3;
      paramString1 = paramString1 + "&_wv=3";
      paramString3 = new Intent(paramString2, QQBrowserActivity.class);
      paramString3.putExtra("url", paramString1);
      if (this.e) {
        i = 40677;
      }
      paramString3.putExtra("big_brother_source_key", pay.f(i));
      paramString2.startActivity(paramString3);
      a("shareMsgToSina start webview!");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131718380, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
      paramString1.printStackTrace();
      return;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, String paramString6, boolean paramBoolean)
  {
    String str2 = "0X800740F";
    String str1 = str2;
    if (!paramBoolean) {
      if (this.jdField_a_of_type_Int != 9)
      {
        str1 = str2;
        if (this.jdField_a_of_type_Int != 12) {}
      }
      else
      {
        str1 = "0X800929A";
      }
    }
    paramString4 = new sie(paramString4, paramString1, paramString5, paramString3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).a(paramString6);
    }
    paramString4.a(paramInt3).M(this.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      odq.a(null, paramString1, str1, str1, 0, 0, "0", paramString2, paramString3, paramString4.a().a(), false);
      return;
      paramString3 = "0";
    }
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
  }
  
  private static void b(Context paramContext, int paramInt1, int paramInt2, VideoInfo paramVideoInfo, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", ozb.a(paramContext));
        localJSONObject.put("os", "1");
        localJSONObject.put("source", paramInt1 + "");
        localJSONObject.put("uin", paramVideoInfo.j);
        localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        localJSONObject.put("version", ofe.jdField_a_of_type_JavaLangString);
        localJSONObject.put("vid", paramVideoInfo.jdField_a_of_type_JavaLangString);
        if (paramBoolean1) {
          localJSONObject.put("cancel", String.valueOf(1));
        }
        if (paramInt3 >= 0) {
          localJSONObject.put("sourcefrom", paramInt3 + "");
        }
        if (paramInt4 < 0) {
          continue;
        }
        localJSONObject.put("share_unit", paramInt4 + "");
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        paramContext = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsShareController", 2, "shareReport:" + localException.toString());
        paramContext = str;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        paramInt1 = 0;
        continue;
      }
      localJSONObject.put("result", paramInt1);
      localJSONObject.put("show", paramInt2);
      paramContext = localJSONObject.toString();
      paramContext = new sie(paramContext);
      odq.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.g), String.valueOf(paramVideoInfo.jdField_f_of_type_Long), paramContext.a().a(), false);
      uhd.a.a(paramBoolean2);
      return;
      paramInt1 = 1;
    }
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    a(paramVideoInfo, "", 0, "");
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new sbd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new saq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new sau(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new sbf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new sba(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new sba(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new sar(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new sas(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new sbc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new sao(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new sbh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new sbg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new sbe(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new sav(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new sbb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new saz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new sap(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(70, new san(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(82, new sat(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {}
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i = rwv.b(this.jdField_a_of_type_AndroidAppActivity)[0];
        int j = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity);
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        a("initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new sak(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void g()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this.jdField_a_of_type_AndroidAppActivity, null));
    Object localObject = new sal(this);
    this.jdField_a_of_type_Bjnw.a((bjoi)localObject);
    localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new sam(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new sad(this, localVideoInfo));
    ArrayList localArrayList = new ArrayList();
    if ((localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.size() > 0))
    {
      Iterator localIterator = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.iterator();
      if (localIterator.hasNext())
      {
        VideoAdInfo.NegFeedback localNegFeedback = (VideoAdInfo.NegFeedback)localIterator.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_JavaLangString = localNegFeedback.jdField_a_of_type_JavaLangString;
        localDislikeInfo.jdField_a_of_type_Long = ((int)localNegFeedback.jdField_a_of_type_Long);
        if (TextUtils.isEmpty(localVideoInfo.j)) {}
        for (localDislikeInfo.jdField_b_of_type_JavaLangString = "";; localDislikeInfo.jdField_b_of_type_JavaLangString = localVideoInfo.j)
        {
          localArrayList.add(localDislikeInfo);
          break;
        }
      }
    }
    if (localArrayList.size() == 0) {}
    for (;;)
    {
      return;
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(localArrayList);
      this.jdField_a_of_type_Bjnw.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Bjnw.isShowing())
        {
          if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()))
          {
            this.jdField_a_of_type_Bjnw.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Bjnw.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Bjnw.setOnShowListener(new sae(this));
          }
          this.jdField_a_of_type_Bjnw.show();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    if (this.jdField_a_of_type_Ugz == null) {
      this.jdField_a_of_type_Ugz = new ugz(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new sbj(this));
    }
    this.jdField_a_of_type_Ugz.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_Ugz.a().setCancelListener(new sah(this));
    this.jdField_a_of_type_Ugz.a().setOnDismissListener(new sai(this));
    try
    {
      if (!this.jdField_a_of_type_Ugz.a().isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList())) {
          this.jdField_a_of_type_Ugz.a().setOnShowListener(new saj(this));
        }
        this.jdField_a_of_type_Ugz.a(a(), 3);
        f();
      }
      return;
    }
    catch (Exception localException)
    {
      a("actionSheet.show exception=" + localException);
    }
  }
  
  public void a(int paramInt)
  {
    a("doOnShareButtonPressed()");
    this.jdField_b_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sbi != null) {
        this.jdField_a_of_type_Sbi.e();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        g();
      } else {
        a();
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramInt2 != -1) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false) {
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramIntent, 0, -1, false, bool);
    return;
    b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramIntent, 1, -1, false, bool);
    return;
    uhd.a.a(bool);
  }
  
  public void a(apkn paramapkn)
  {
    this.jdField_a_of_type_Apkn = paramapkn;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  @TargetApi(11)
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718485);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718445);
    String str3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718486);
    String str4 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718464);
    String str5 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690620);
    String str6 = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    boolean bool2 = false;
    Object localObject = new File(str6);
    long l = ((File)localObject).length();
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (l >= paramMessageForShortVideo.videoFileSize) {
        bool1 = true;
      }
    }
    if (ImmersiveUtils.isSupporImmersive() == -1)
    {
      localObject = bjnw.b(this.jdField_a_of_type_AndroidAppActivity);
      ((bjnw)localObject).c(str1);
      ((bjnw)localObject).setOnDismissListener(new sac(this));
      if (paramMessageForShortVideo.videoFileStatus != 5001) {
        ((bjnw)localObject).c(str3);
      }
      if (!bool1) {
        break label334;
      }
      ((bjnw)localObject).c(str2);
      ((bjnw)localObject).c(str4);
    }
    for (;;)
    {
      ((bjnw)localObject).d(str5);
      if (!((bjnw)localObject).isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          ((bjnw)localObject).getWindow().setFlags(8, 8);
          if (VersionUtils.isJellyBean()) {
            ((bjnw)localObject).getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          }
          ((bjnw)localObject).setOnShowListener(new saf(this, (bjnw)localObject));
        }
        ((bjnw)localObject).show();
      }
      ((bjnw)localObject).a(new sag(this, (bjnw)localObject, str1, paramMessageForShortVideo, str3, bool1, str6, str2, str4));
      return;
      localObject = bjnw.a(this.jdField_a_of_type_AndroidAppActivity);
      break;
      label334:
      ((bjnw)localObject).a(str2, 7);
      ((bjnw)localObject).a(str4, 7);
    }
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
      return false;
    }
    b(paramInt);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (this.jdField_a_of_type_Sbi != null) {
      this.jdField_a_of_type_Sbi.a(localVideoInfo);
    }
    String str = a(localVideoInfo);
    sif localsif = (sif)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localsif == null) {
      return false;
    }
    int i = localsif.c();
    int j = localsif.a();
    int k = localsif.b();
    localsif.a(paramInt, localVideoInfo, str, paramActionSheetItem);
    a(paramInt, localVideoInfo);
    if ((localVideoInfo.jdField_a_of_type_Int == 0) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      paramActionSheetItem = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null)) {
        break label259;
      }
      paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      label161:
      if (localVideoInfo.y == null) {
        break label264;
      }
    }
    label259:
    label264:
    for (str = localVideoInfo.y;; str = "")
    {
      a(localVideoInfo.j, Integer.toString(k), localVideoInfo.g, paramActionSheetItem, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.a(), localVideoInfo.jdField_f_of_type_Long, localVideoInfo.q, -1, paramInt, str, false);
      a(localVideoInfo, String.valueOf(pay.a()), localVideoInfo.g, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_Long, i, j, false);
      return true;
      paramActionSheetItem = null;
      break;
      paramInt = 0;
      break label161;
    }
  }
  
  public List<Integer>[] a()
  {
    List localList = ugz.a();
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Apkn != null) && (this.jdField_a_of_type_Apkn.a()))
    {
      if (this.jdField_a_of_type_Apkn.c())
      {
        localArrayList.add(0, Integer.valueOf(82));
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： open sheet delete colorNote");
      }
    }
    else
    {
      if (!rha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l)) {
        break label206;
      }
      localArrayList.add(Integer.valueOf(134));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(1));
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localVideoInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          localArrayList.add(Integer.valueOf(44));
        }
      }
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(161));
      return new List[] { localList, localArrayList };
      localArrayList.add(0, Integer.valueOf(70));
      QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： open sheet add colorNote");
      break;
      label206:
      localArrayList.add(Integer.valueOf(6));
    }
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void c()
  {
    this.d = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ugz != null) {
      this.jdField_a_of_type_Ugz.b();
    }
    this.jdField_a_of_type_Rah.a();
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString, 0).a();
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sab
 * JD-Core Version:    0.7.0.1
 */