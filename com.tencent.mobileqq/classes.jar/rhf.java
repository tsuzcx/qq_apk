import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class rhf
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bhpy jdField_a_of_type_Bhpy;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new rhx(this, null);
  private nnp jdField_a_of_type_Nnp;
  private rgx jdField_a_of_type_Rgx;
  private rhs jdField_a_of_type_Rhs;
  syq jdField_a_of_type_Syq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
  public rhf(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, rhs paramrhs, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Rhs = paramrhs;
    this.e = paramBoolean;
    this.jdField_a_of_type_Nnp = ((nnp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(136));
    this.jdField_a_of_type_Nnp.a();
    this.jdField_c_of_type_Int = paramInt2;
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696873, new Object[] { paramVideoInfo.jdField_c_of_type_JavaLangString }));
    if (paramVideoInfo.jdField_a_of_type_Int == 6)
    {
      localIntent.putExtra("struct_share_key_source_icon", "http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
      localIntent.putExtra("app_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localAbsStructMsg = azqu.a(localIntent.getExtras());
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
        localAbsStructMsg = azqu.a(localIntent.getExtras());
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
    ((Bundle)localObject).putString("ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
    if ((paramVideoInfo.jdField_f_of_type_JavaLangString != null) && (!paramVideoInfo.jdField_f_of_type_JavaLangString.contains("&sourcefrom=0"))) {
      paramVideoInfo.jdField_f_of_type_JavaLangString += "&sourcefrom=0";
    }
    ((Bundle)localObject).putString("detail_url", b(paramVideoInfo.jdField_f_of_type_JavaLangString, paramVideoInfo));
    ((Bundle)localObject).putString("video_url", paramVideoInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("req_create_time", paramVideoInfo.e);
    ((Bundle)localObject).putString("brief_key", paramVideoInfo.jdField_c_of_type_JavaLangString);
    label420:
    String str2;
    String str4;
    if (paramVideoInfo.jdField_a_of_type_Int == 6)
    {
      ((Bundle)localObject).putInt("VIDEO_FEED_TYPE", paramVideoInfo.jdField_g_of_type_Int);
      ((Bundle)localObject).putLong("VIDEO_FEED_ID", paramVideoInfo.jdField_d_of_type_Long);
      ((Bundle)localObject).putString("compatible_text", paramVideoInfo.jdField_c_of_type_JavaLangString + ": " + paramVideoInfo.jdField_f_of_type_JavaLangString);
      ((Bundle)localObject).putInt("req_type", 125);
      ((Bundle)localObject).putInt("PREVIEW_START_POSI", rjm.a(paramInt, paramVideoInfo.a()));
      localObject = (StructMsgForGeneralShare)azqu.a((Bundle)localObject);
      if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf(alpo.a(2131716589)) == -1)) {
        ((StructMsgForGeneralShare)localObject).mMsgBrief = (alpo.a(2131716611) + ((StructMsgForGeneralShare)localObject).mMsgBrief);
      }
      swn.a((StructMsgForGeneralShare)localObject);
      if (TextUtils.isEmpty(paramVideoInfo.n)) {
        break label631;
      }
      str1 = paramVideoInfo.n;
      str2 = paramVideoInfo.m;
      ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
      String str3 = paramVideoInfo.j;
      str4 = swn.a(str3);
      String str5 = paramVideoInfo.jdField_k_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str3)) {
        ((StructMsgForGeneralShare)localObject).mSourceAppid = Long.valueOf(str3).longValue();
      }
      ((StructMsgForGeneralShare)localObject).source_puin = paramVideoInfo.j;
      if (paramVideoInfo.jdField_a_of_type_Int <= 1) {
        break label686;
      }
      if ((TextUtils.isEmpty(str3)) || (str3.equals("16888"))) {
        break label659;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      label512:
      if ((str5 != null) && (!"".equals(str5))) {
        ((StructMsgForGeneralShare)localObject).mSourceThirdName = str5;
      }
      label534:
      if ((str5 != null) && (!"".equals(str5))) {
        ((StructMsgForGeneralShare)localObject).mSourceName = str5;
      }
      if ((str1 == null) || ("".equals(str1))) {
        break label695;
      }
    }
    label659:
    label686:
    label695:
    for (((StructMsgForGeneralShare)localObject).mSourceIcon = str1;; ((StructMsgForGeneralShare)localObject).mSourceIcon = "http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png")
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramVideoInfo = new Bundle();
      paramVideoInfo.putInt("forward_type", -3);
      paramVideoInfo.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramVideoInfo.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      return paramVideoInfo;
      ((Bundle)localObject).putInt("req_type", 140);
      break;
      label631:
      if (TextUtils.isEmpty(paramVideoInfo.j)) {
        break label420;
      }
      str1 = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null));
      break label420;
      if (!TextUtils.isEmpty(str2))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
        break label512;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break label512;
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      break label534;
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, Activity paramActivity, int paramInt)
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
      localIntent = new Intent();
      localIntent.putExtras(paramVideoInfo);
      arum.a(paramActivity, localIntent);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 7) || ((paramVideoInfo.jdField_a_of_type_Int == 6) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))))
    {
      arum.a(paramActivity, a(paramVideoInfo), 21);
      return;
    }
    paramVideoInfo = a(paramVideoInfo, paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramVideoInfo);
    arum.a(paramActivity, localIntent, 21);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", opn.a(this.jdField_a_of_type_AndroidAppActivity));
      localJSONObject.put("os", "1");
      localJSONObject.put("source", this.jdField_a_of_type_Int + "");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localJSONObject.put("version", ntd.jdField_a_of_type_JavaLangString);
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
    paramString1 = new ron(paramString1);
    paramString1.a(paramVideoInfo);
    nrt.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramString1.a().a(), false);
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
    localObject[0] = alpo.a(2131716613);
    localObject[1] = alpo.a(2131716542);
    localObject[2] = alpo.a(2131716576);
    localObject[3] = alpo.a(2131716524);
    localObject[4] = alpo.a(2131716571);
    localObject[5] = alpo.a(2131716535);
    localObject[6] = alpo.a(2131716593);
    localObject[7] = alpo.a(2131716554);
    localObject[8] = alpo.a(2131716547);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      a("shareMsgToSina empty title or share_url");
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131720019, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
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
      paramString3.putExtra("big_brother_source_key", ors.f(i));
      paramString2.startActivity(paramString3);
      a("shareMsgToSina start webview!");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131720019, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
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
    paramString4 = new ron(paramString4, paramString1, paramString5, paramString3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).a(paramString6);
    }
    paramString4.a(paramInt3).N(this.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      nrt.a(null, paramString1, str1, str1, 0, 0, "0", paramString2, paramString3, paramString4.a().a(), false);
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
        if (!TextUtils.isEmpty(paramVideoInfo.u))
        {
          str = paramString;
          if (paramVideoInfo.jdField_k_of_type_Boolean)
          {
            paramString = new StringBuilder(paramString);
            paramString.append("&").append("redpackid").append("=").append(paramVideoInfo.u);
            str = paramString.toString();
          }
        }
      }
    }
    return str;
  }
  
  private static void b(Context paramContext, int paramInt1, int paramInt2, VideoInfo paramVideoInfo, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", opn.a(paramContext));
        localJSONObject.put("os", "1");
        localJSONObject.put("source", paramInt1 + "");
        localJSONObject.put("uin", paramVideoInfo.j);
        localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        localJSONObject.put("version", ntd.jdField_a_of_type_JavaLangString);
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
      paramContext = new ron(paramContext);
      paramContext.a(paramVideoInfo);
      nrt.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.jdField_g_of_type_JavaLangString), String.valueOf(paramVideoInfo.jdField_f_of_type_Long), paramContext.a().a(), false);
      return;
      paramInt1 = 1;
    }
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    a(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Boolean);
  }
  
  private void e()
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
        int i = rdm.b(this.jdField_a_of_type_AndroidAppActivity)[0];
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
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new rho(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void f()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(this.jdField_a_of_type_AndroidAppActivity, null));
    Object localObject = new rhp(this);
    this.jdField_a_of_type_Bhpy.a((bhqg)localObject);
    localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new rhq(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new rhh(this, localVideoInfo));
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
      this.jdField_a_of_type_Bhpy.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Bhpy.isShowing())
        {
          if ((bhou.g()) && (!ShortVideoUtils.c()))
          {
            this.jdField_a_of_type_Bhpy.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Bhpy.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Bhpy.setOnShowListener(new rhi(this));
          }
          this.jdField_a_of_type_Bhpy.show();
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
    if (this.jdField_a_of_type_Syq == null) {
      this.jdField_a_of_type_Syq = new syq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new rhr(this), new rht(this));
    }
    this.jdField_a_of_type_Syq.a.setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_Syq.a.setCancelListener(new rhl(this));
    this.jdField_a_of_type_Syq.a.setOnDismissListener(new rhm(this));
    try
    {
      if (!this.jdField_a_of_type_Syq.a.isShowing())
      {
        if ((bhou.g()) && (!ShortVideoUtils.c()))
        {
          this.jdField_a_of_type_Syq.a.getWindow().setFlags(8, 8);
          this.jdField_a_of_type_Syq.a.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          this.jdField_a_of_type_Syq.a.setOnShowListener(new rhn(this));
        }
        if (this.jdField_a_of_type_Rgx != null) {
          this.jdField_a_of_type_Syq.a(a(), this.jdField_a_of_type_Rgx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
        }
        for (;;)
        {
          e();
          return;
          this.jdField_a_of_type_Syq.a(a());
        }
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
      if (this.jdField_a_of_type_Rhs != null) {
        this.jdField_a_of_type_Rhs.f();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.h == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        f();
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
        break label49;
      }
    }
    label49:
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
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131720137);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131720095);
    String str3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131720138);
    String str4 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131720115);
    String str5 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690648);
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
      localObject = bhpy.b(this.jdField_a_of_type_AndroidAppActivity);
      ((bhpy)localObject).c(str1);
      ((bhpy)localObject).setOnDismissListener(new rhg(this));
      if (paramMessageForShortVideo.videoFileStatus != 5001) {
        ((bhpy)localObject).c(str3);
      }
      if (!bool1) {
        break label334;
      }
      ((bhpy)localObject).c(str2);
      ((bhpy)localObject).c(str4);
    }
    for (;;)
    {
      ((bhpy)localObject).d(str5);
      if (!((bhpy)localObject).isShowing())
      {
        if ((bhou.g()) && (!ShortVideoUtils.c()))
        {
          ((bhpy)localObject).getWindow().setFlags(8, 8);
          if (bhou.g()) {
            ((bhpy)localObject).getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          }
          ((bhpy)localObject).setOnShowListener(new rhj(this, (bhpy)localObject));
        }
        ((bhpy)localObject).show();
      }
      ((bhpy)localObject).a(new rhk(this, (bhpy)localObject, str1, paramMessageForShortVideo, str3, bool1, str6, str2, str4));
      return;
      localObject = bhpy.a(this.jdField_a_of_type_AndroidAppActivity);
      break;
      label334:
      ((bhpy)localObject).a(str2, 7);
      ((bhpy)localObject).a(str4, 7);
    }
  }
  
  public void a(rgx paramrgx)
  {
    this.jdField_a_of_type_Rgx = paramrgx;
  }
  
  public List<Integer>[] a()
  {
    List localList = syq.a();
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {
      localArrayList.add(Integer.valueOf(24));
    }
    if (this.jdField_a_of_type_Int == 12) {
      localArrayList.add(Integer.valueOf(22));
    }
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(14));
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localVideoInfo.jdField_b_of_type_JavaUtilArrayList != null) && (localVideoInfo.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
    localArrayList.add(Integer.valueOf(20));
    localArrayList.add(Integer.valueOf(122));
    return new List[] { localList, localArrayList };
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
    if (this.jdField_a_of_type_Syq != null) {
      this.jdField_a_of_type_Syq.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhf
 * JD-Core Version:    0.7.0.1
 */