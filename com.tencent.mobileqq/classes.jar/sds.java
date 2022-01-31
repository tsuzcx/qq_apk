import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.util.GalleryShareHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class sds
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bcqf jdField_a_of_type_Bcqf;
  private bfpc jdField_a_of_type_Bfpc;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList<DislikeInfo> a;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private ozf jdField_a_of_type_Ozf = new sdv(this);
  private qzx jdField_a_of_type_Qzx;
  private sgv jdField_a_of_type_Sgv;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k = "";
  
  public sds(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
    }
  }
  
  public sds(Activity paramActivity, boolean paramBoolean)
  {
    this(paramActivity);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Ozf);
      paramActivity = new IntentFilter();
      paramActivity.addAction("com.tencent.process.fav");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = old.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt1, paramInt2, paramBoolean);
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("pattern", this.jdField_e_of_type_Int);
      nol.a(null, "", "0X8009545", "0X8009545", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long), ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, Boolean paramBoolean1)
  {
    paramBoolean1 = old.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt1, paramInt2, paramBoolean, paramBoolean1);
    nol.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long), paramBoolean1, false);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    Intent localIntent = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", paramArticleInfo);
    localIntent.putExtra("biu_src", 17);
    localIntent.putExtra("biu_rowkey", paramArticleInfo.innerUniqueID);
    localIntent.putExtra("arg_from_type", 1);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131719487), 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareToFriendparams is Empty");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putString("title", paramString1);
      localBundle.putString("desc", paramString2);
      localBundle.putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      localBundle.putStringArrayList("image_url", paramString1);
      localBundle.putLong("req_share_id", 0L);
    } while (bgzl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localBundle, null));
    wij.a(1, 2131689512);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString5)))
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131719487), 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareToFriendparams is Empty");
      }
      return;
    }
    String str = paramString4;
    if (!TextUtils.isEmpty(paramString4)) {
      str = paramString4 + "&source=9";
    }
    paramString4 = paramString5;
    if (onh.a(paramString5)) {
      paramString4 = onh.a(paramString5, 260, 520, 1);
    }
    paramString5 = new Intent();
    paramString5.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    paramString5.putExtra("key_flag_from_plugin", true);
    paramString5.putExtra("pluginName", "web_share");
    paramString5.putExtra("title", paramString1);
    paramString5.putExtra("desc", paramString2);
    paramString5.putExtra("detail_url", paramString3);
    paramString5.putExtra("shareQQType", 13);
    paramString5.putExtra("forward_type", 1001);
    paramString5.putExtra("pkg_name", "com.tencent.mobileqq");
    paramString5.putExtra("image_url_remote", paramString4);
    paramString5.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696698, new Object[] { paramString1 }));
    paramString5.putExtra("req_type", 1);
    paramString5.putExtra("k_back", true);
    paramString5.putExtra("new_share_service_id", "83");
    paramString1 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString1 = "";
    }
    paramString5.putExtra("app_name", paramString1);
    paramString1 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString1 = "";
    }
    paramString5.putExtra("struct_share_key_source_icon", paramString1);
    paramString5.putExtra("struct_share_key_source_action", "web");
    if (TextUtils.isEmpty(paramString7)) {}
    for (paramString1 = "";; paramString1 = paramString7.trim())
    {
      paramString5.putExtra("struct_share_key_source_url", paramString1);
      paramString5.putExtra("readinjoy_gallery", str);
      paramString5.putExtra("stuctmsg_bytes", axva.a(paramString5.getExtras()).getBytes());
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString5, 1001);
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str3 = old.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt1, paramInt2, paramBoolean);
    try
    {
      JSONObject localJSONObject = new JSONObject(str3);
      str1 = str3;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        paramInt1 = old.a(onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
        localJSONObject.put("article_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
        localJSONObject.put("card_type", paramInt1 + "");
        localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
        str1 = localJSONObject.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str1;
        localJSONException.printStackTrace();
        String str2 = str3;
      }
    }
    nol.a(null, "", "0X8009A79", "0X8009A79", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long), str1, false);
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "shareMsgToSina start!");
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    paramString2 = "#QQ看点#【" + paramString1 + "】" + paramString2;
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidAppActivity, localActivity.getResources().getDimensionPixelSize(2131298865));
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_Bcqf.dismiss();
      }
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719487, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Bcqf.isShowing())
      {
        this.jdField_a_of_type_Bcqf.c(2131694100);
        this.jdField_a_of_type_Bcqf.show();
      }
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
      }
      paramString1 = paramString2;
      try
      {
        if (paramString2.length() > 30)
        {
          paramString1 = paramString2.substring(0, 30);
          paramString1 = paramString1 + "...";
        }
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
        paramString2 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString2;
        paramString2 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString2;
        paramString1 = paramString1 + "&_wv=3";
        paramString2 = new Intent(localActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        localActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("GalleryShareHelper", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719487, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          paramString1.printStackTrace();
          if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
            this.jdField_a_of_type_Bcqf.dismiss();
          }
        }
      }
      finally
      {
        if ((this.jdField_a_of_type_Bcqf == null) || (!this.jdField_a_of_type_Bcqf.isShowing())) {
          break;
        }
        this.jdField_a_of_type_Bcqf.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.d("GalleryShareHelper", 2, "shareMsgToSina end!");
  }
  
  public bbjq a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.i = paramArticleInfo.innerUniqueID;
    this.jdField_a_of_type_JavaLangString = onh.e(this.i);
    this.jdField_c_of_type_JavaLangString = paramArticleInfo.mTitle;
    this.jdField_a_of_type_JavaUtilArrayList = paramArticleInfo.mDislikeInfos;
    this.jdField_a_of_type_Long = paramArticleInfo.mArticleID;
    this.jdField_b_of_type_JavaLangString = ajya.a(2131705006);
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Long = paramArticleInfo.mStrategyId;
    if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1))
    {
      this.f = paramArticleInfo.mSubscribeName;
      this.g = (omj.k + Base64.encodeToString(this.k.getBytes(), 0));
      this.h = ("https://s.p.qq.com/pub/get_face_https?img_type=3&uin=" + paramArticleInfo.mSubscribeID);
      if (TextUtils.isEmpty(this.i)) {
        break label348;
      }
      this.jdField_e_of_type_JavaLangString = ("mqqapi://readinjoy/openatlas?src_type=internal&version=1&rowkey=" + this.i);
      label199:
      if ((paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length > 0))
      {
        if (paramArticleInfo.mPictures[0] == null) {
          break label357;
        }
        this.jdField_d_of_type_JavaLangString = paramArticleInfo.mPictures[0].getFile();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sgv == null) {
        this.jdField_a_of_type_Sgv = new sgv(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, new sdw(this));
      }
      this.jdField_a_of_type_Sgv.a.a("biu出去让更多好友看到");
      this.jdField_a_of_type_Sgv.a.a(new sdt(this));
      return this.jdField_a_of_type_Sgv.a(a());
      this.f = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131699357);
      this.g = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
      this.h = "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
      break;
      label348:
      this.jdField_e_of_type_JavaLangString = "";
      break label199;
      label357:
      if (paramArticleInfo.mSinglePicture != null) {
        this.jdField_d_of_type_JavaLangString = paramArticleInfo.mSinglePicture.getFile();
      }
    }
  }
  
  public qat a(ArrayList<DislikeInfo> paramArrayList)
  {
    qat localqat = new qat();
    if (!TextUtils.isEmpty(this.i)) {
      localqat.jdField_a_of_type_JavaLangString = this.i;
    }
    localqat.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localqat.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    return localqat;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    if (this.jdField_a_of_type_Sgv != null) {
      this.jdField_a_of_type_Sgv.b();
    }
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    if (this.jdField_a_of_type_Qzx != null) {
      this.jdField_a_of_type_Qzx = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, shc paramshc)
  {
    int i1 = 0;
    int n = 0;
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        int m;
        if (!WXShareHelper.a().a()) {
          m = 2131720917;
        }
        for (;;)
        {
          if (m != -1) {
            wij.a(0, m);
          }
          String str;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GalleryShareHelper", 2, "title=" + paramString1 + ", description=" + paramString2 + ", shareUrl=" + paramString3 + ", action=" + paramBoolean);
            }
            return;
            if (WXShareHelper.a().b()) {
              break label266;
            }
            m = 2131720918;
            break;
            str = String.valueOf(System.currentTimeMillis());
            paramshc = new sdu(this, str, paramshc);
            WXShareHelper.a().a(paramshc);
            if (!paramBoolean) {
              break label182;
            }
            WxShareHelperFromReadInjoy.a().a(str, paramString1, paramBitmap, paramString2, paramString3, this.i);
          }
          label182:
          if (bhvy.t(onh.a()) == 1)
          {
            paramshc = WXShareHelper.a();
            if (paramBoolean) {}
            for (m = n;; m = 1)
            {
              paramshc.b(str, paramString1, paramBitmap, paramString2, paramString3, m);
              break;
            }
          }
          paramshc = WxShareHelperFromReadInjoy.a();
          if (paramBoolean) {}
          for (m = i1;; m = 1)
          {
            paramshc.a(str, paramString1, paramBitmap, paramString2, paramString3, m);
            break;
          }
          label266:
          m = -1;
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, shc paramshc)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GalleryShareHelper.3(this, paramString, paramBoolean, new HashMap(1), paramshc), 8, null, false);
  }
  
  public void a(qzx paramqzx)
  {
    this.jdField_a_of_type_Qzx = paramqzx;
  }
  
  public List<Integer>[] a()
  {
    List localList = sgv.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(15));
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(14));
    localArrayList.add(Integer.valueOf(20));
    Collections.sort(localArrayList);
    return new List[] { localList, localArrayList };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sds
 * JD-Core Version:    0.7.0.1
 */