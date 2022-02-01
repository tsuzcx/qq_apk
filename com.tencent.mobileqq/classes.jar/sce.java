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

public class sce
  implements rce
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private SparseArray<skd> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bkho jdField_a_of_type_Bkho;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new sdl(this, null);
  private nwm jdField_a_of_type_Nwm;
  private rcq jdField_a_of_type_Rcq;
  private sbv jdField_a_of_type_Sbv;
  private sdj jdField_a_of_type_Sdj;
  uai jdField_a_of_type_Uai;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
  public sce(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, sdj paramsdj, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Sdj = paramsdj;
    this.e = paramBoolean;
    this.jdField_a_of_type_Nwm = ((nwm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(136));
    if (this.jdField_a_of_type_Nwm != null) {
      this.jdField_a_of_type_Nwm.a();
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Rcq = new rcq(new rcm());
    this.jdField_a_of_type_Rcq.a(this);
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131695697, new Object[] { paramVideoInfo.jdField_c_of_type_JavaLangString }));
    if (paramVideoInfo.jdField_a_of_type_Int == 6)
    {
      localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
      localIntent.putExtra("app_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localAbsStructMsg = bcwd.a(localIntent.getExtras());
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
        localAbsStructMsg = bcwd.a(localIntent.getExtras());
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
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.jdField_k_of_type_JavaLangString);
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
        break label654;
      }
      ((Bundle)localObject).putInt("VIDEO_FEED_TYPE", paramVideoInfo.h);
      ((Bundle)localObject).putLong("VIDEO_FEED_ID", paramVideoInfo.jdField_d_of_type_Long);
      ((Bundle)localObject).putString("compatible_text", paramVideoInfo.jdField_c_of_type_JavaLangString + ": " + paramVideoInfo.jdField_f_of_type_JavaLangString);
      ((Bundle)localObject).putInt("req_type", 125);
      ((Bundle)localObject).putInt("PREVIEW_START_POSI", sfa.a(paramInt, paramVideoInfo.a()));
      localObject = (StructMsgForGeneralShare)bcwd.a((Bundle)localObject);
      if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf(anni.a(2131714878)) == -1)) {
        ((StructMsgForGeneralShare)localObject).mMsgBrief = (anni.a(2131714900) + ((StructMsgForGeneralShare)localObject).mMsgBrief);
      }
      txv.a((StructMsgForGeneralShare)localObject);
      if (TextUtils.isEmpty(paramVideoInfo.jdField_p_of_type_JavaLangString)) {
        break label666;
      }
      str1 = paramVideoInfo.jdField_p_of_type_JavaLangString;
      str2 = paramVideoInfo.jdField_o_of_type_JavaLangString;
      ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
      String str3 = paramVideoInfo.j;
      str4 = txv.a(str3);
      String str5 = paramVideoInfo.jdField_k_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str3)) {
        ((StructMsgForGeneralShare)localObject).mSourceAppid = Long.valueOf(str3).longValue();
      }
      ((StructMsgForGeneralShare)localObject).source_puin = paramVideoInfo.j;
      if (paramVideoInfo.jdField_a_of_type_Int <= 1) {
        break label721;
      }
      if ((TextUtils.isEmpty(str3)) || (str3.equals("16888"))) {
        break label694;
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
        break label730;
      }
    }
    label654:
    label666:
    label694:
    label721:
    label730:
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
      ((Bundle)localObject).putString("detail_url", b(paramVideoInfo.jdField_f_of_type_JavaLangString, paramVideoInfo));
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
    if (this.jdField_a_of_type_Nwm == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Nwm.a())
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
    rgi localrgi;
    if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6) && (!this.e))
    {
      localrgi = new rgi();
      localrgi.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      localrgi.e = (paramVideoInfo.a() * 1000);
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break label184;
      }
      localrgi.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
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
        och.a(localVideoInfo2, paramInt, 26, -1, localrgi, paramVideoInfo);
        return;
      }
      localVideoInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      paramVideoInfo = localVideoInfo2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) {
        paramVideoInfo = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      }
      och.b(localVideoInfo1, paramInt, 26, -1, localrgi, paramVideoInfo);
      return;
    }
  }
  
  private void a(int paramInt1, VideoInfo paramVideoInfo, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Boolean);
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramVideoInfo.y))
    {
      paramString = paramVideoInfo.y;
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
      if (paramVideoInfo.q > 0) {
        ((StringBuilder)localObject).append(ryx.b(paramVideoInfo.q)).append(" ");
      }
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = paramVideoInfo.jdField_c_of_type_JavaLangString;
      localObject = ((StringBuilder)localObject).toString();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (paramInt1 == 9) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        oci.a(localBaseActivity, str, (String)localObject, paramString, localBitmap, bool2, paramVideoInfo.g, bool1, new sdo(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt2, paramInt3, paramVideoInfo));
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
      paramVideoInfo.putString("forward_thumb", ShortVideoUtils.a(paramActivity.getIntent().getExtras().getString("thumbfile_md5"), "jpg"));
      paramString1 = new Intent();
      paramString1.putExtras(paramVideoInfo);
      aufz.a(paramActivity, paramString1);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 7) || ((paramVideoInfo.jdField_a_of_type_Int == 6) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))))
    {
      aufz.a(paramActivity, a(paramVideoInfo), 21);
      return;
    }
    paramVideoInfo = a(paramVideoInfo, paramInt1);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramVideoInfo);
    if (TextUtils.isEmpty(paramString1))
    {
      aufz.a(paramActivity, localIntent, 21);
      return;
    }
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt2);
    localIntent.putExtra("uinname", paramString2);
    aufz.a(paramActivity, localIntent, DirectForwardActivity.class, 21, -1, "");
  }
  
  private void a(VideoInfo paramVideoInfo, @NotNull String paramString1, int paramInt, String paramString2)
  {
    a(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramString1, paramInt, paramString2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Boolean);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", pfe.a(this.jdField_a_of_type_AndroidAppActivity));
      localJSONObject.put("os", "1");
      localJSONObject.put("source", this.jdField_a_of_type_Int + "");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localJSONObject.put("version", och.jdField_a_of_type_JavaLangString);
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
      paramString1 = localJSONObject.toString();
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoFeedsShareController", 2, "shareReport:" + paramString3.toString());
          paramString1 = str;
        }
      }
    }
    paramString1 = new skc(paramString1);
    paramString1.b(paramVideoInfo);
    oat.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramString1.a().a(), false);
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
    localObject[0] = anni.a(2131714902);
    localObject[1] = anni.a(2131714831);
    localObject[2] = anni.a(2131714865);
    localObject[3] = anni.a(2131714813);
    localObject[4] = anni.a(2131714860);
    localObject[5] = anni.a(2131714824);
    localObject[6] = anni.a(2131714882);
    localObject[7] = anni.a(2131714843);
    localObject[8] = anni.a(2131714836);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      a("shareMsgToSina empty title or share_url");
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131718007, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Boolean);
    a("shareMsgToSina installSinaWeibo:false");
    try
    {
      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
      paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1 + "%F0%9F%8E%AC";
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
      paramString3.putExtra("big_brother_source_key", pha.f(i));
      paramString2.startActivity(paramString3);
      a("shareMsgToSina start webview!");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131718007, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
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
    paramString4 = new skc(paramString4, paramString1, paramString5, paramString3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).a(paramString6);
    }
    paramString4.a(paramInt3).N(this.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      oat.a(null, paramString1, str1, str1, 0, 0, "0", paramString2, paramString3, paramString4.a().a(), false);
      return;
      paramString3 = "0";
    }
  }
  
  private static String b(String paramString, VideoInfo paramVideoInfo)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.contains("redpackid"))
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramVideoInfo.w))
        {
          str = paramString;
          if (paramVideoInfo.jdField_k_of_type_Boolean)
          {
            paramString = new StringBuilder(paramString);
            paramString.append("&").append("redpackid").append("=").append(paramVideoInfo.w);
            str = paramString.toString();
          }
        }
      }
    }
    return str;
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
        localJSONObject.put("network", pfe.a(paramContext));
        localJSONObject.put("os", "1");
        localJSONObject.put("source", paramInt1 + "");
        localJSONObject.put("uin", paramVideoInfo.j);
        localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        localJSONObject.put("version", och.jdField_a_of_type_JavaLangString);
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
      paramContext = new skc(paramContext);
      paramContext.b(paramVideoInfo);
      oat.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.g), String.valueOf(paramVideoInfo.jdField_f_of_type_Long), paramContext.a().a(), false);
      uam.a.a(paramBoolean2);
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
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new sde(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new scs(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new scv(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new sdg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new sdb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new sdb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new sct(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new scu(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new sdd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new scq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new sdi(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new sdh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new sdf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new scw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new sdc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new sda(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new scr(this));
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
        int i = ryx.b(this.jdField_a_of_type_AndroidAppActivity)[0];
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
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new scn(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void g()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this.jdField_a_of_type_AndroidAppActivity, null));
    Object localObject = new sco(this);
    this.jdField_a_of_type_Bkho.a((bkia)localObject);
    localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new scp(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new scg(this, localVideoInfo));
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
      this.jdField_a_of_type_Bkho.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Bkho.isShowing())
        {
          if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.c()))
          {
            this.jdField_a_of_type_Bkho.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Bkho.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Bkho.setOnShowListener(new sch(this));
          }
          this.jdField_a_of_type_Bkho.show();
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
    if (this.jdField_a_of_type_Uai == null) {
      this.jdField_a_of_type_Uai = new uai(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new sdk(this));
    }
    this.jdField_a_of_type_Uai.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_Uai.a().setCancelListener(new sck(this));
    this.jdField_a_of_type_Uai.a().setOnDismissListener(new scl(this));
    try
    {
      if (!this.jdField_a_of_type_Uai.a().isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.c())) {
          this.jdField_a_of_type_Uai.a().setOnShowListener(new scm(this));
        }
        this.jdField_a_of_type_Uai.a(a(), 3);
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
      if (this.jdField_a_of_type_Sdj != null) {
        this.jdField_a_of_type_Sdj.f();
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
    uam.a.a(bool);
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
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718111);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718071);
    String str3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718112);
    String str4 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718090);
    String str5 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690582);
    String str6 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
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
      localObject = bkho.b(this.jdField_a_of_type_AndroidAppActivity);
      ((bkho)localObject).c(str1);
      ((bkho)localObject).setOnDismissListener(new scf(this));
      if (paramMessageForShortVideo.videoFileStatus != 5001) {
        ((bkho)localObject).c(str3);
      }
      if (!bool1) {
        break label334;
      }
      ((bkho)localObject).c(str2);
      ((bkho)localObject).c(str4);
    }
    for (;;)
    {
      ((bkho)localObject).d(str5);
      if (!((bkho)localObject).isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.c()))
        {
          ((bkho)localObject).getWindow().setFlags(8, 8);
          if (VersionUtils.isJellyBean()) {
            ((bkho)localObject).getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          }
          ((bkho)localObject).setOnShowListener(new sci(this, (bkho)localObject));
        }
        ((bkho)localObject).show();
      }
      ((bkho)localObject).a(new scj(this, (bkho)localObject, str1, paramMessageForShortVideo, str3, bool1, str6, str2, str4));
      return;
      localObject = bkho.a(this.jdField_a_of_type_AndroidAppActivity);
      break;
      label334:
      ((bkho)localObject).a(str2, 7);
      ((bkho)localObject).a(str4, 7);
    }
  }
  
  public void a(sbv paramsbv)
  {
    this.jdField_a_of_type_Sbv = paramsbv;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
      return false;
    }
    b(paramInt);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (this.jdField_a_of_type_Sdj != null) {
      this.jdField_a_of_type_Sdj.a(localVideoInfo);
    }
    String str = a(localVideoInfo);
    skd localskd = (skd)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localskd == null) {
      return false;
    }
    int i = localskd.c();
    int j = localskd.a();
    int k = localskd.b();
    localskd.a(paramInt, localVideoInfo, str, paramActionSheetItem);
    a(paramInt, localVideoInfo);
    if ((localVideoInfo.jdField_a_of_type_Int == 0) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      paramActionSheetItem = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null)) {
        break label259;
      }
      paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      label161:
      if (localVideoInfo.B == null) {
        break label264;
      }
    }
    label259:
    label264:
    for (str = localVideoInfo.B;; str = "")
    {
      a(localVideoInfo.j, Integer.toString(k), localVideoInfo.g, paramActionSheetItem, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.a(), localVideoInfo.jdField_f_of_type_Long, localVideoInfo.jdField_p_of_type_Int, -1, paramInt, str, false);
      a(localVideoInfo, String.valueOf(pha.a()), localVideoInfo.g, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_Long, i, j, false);
      return true;
      paramActionSheetItem = null;
      break;
      paramInt = 0;
      break label161;
    }
  }
  
  public List<Integer>[] a()
  {
    List localList = uai.a();
    ArrayList localArrayList = new ArrayList();
    if (rjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_o_of_type_Boolean)) {
      localArrayList.add(Integer.valueOf(134));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(1));
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localVideoInfo.jdField_b_of_type_JavaUtilArrayList != null) && (localVideoInfo.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
          localArrayList.add(Integer.valueOf(44));
        }
      }
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(161));
      return new List[] { localList, localArrayList };
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
    if (this.jdField_a_of_type_Uai != null) {
      this.jdField_a_of_type_Uai.b();
    }
    this.jdField_a_of_type_Rcq.a();
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
 * Qualified Name:     sce
 * JD-Core Version:    0.7.0.1
 */