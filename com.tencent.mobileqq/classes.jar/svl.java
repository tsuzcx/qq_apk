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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
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

public class svl
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bepp jdField_a_of_type_Bepp;
  private bhpy jdField_a_of_type_Bhpy;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList<DislikeInfo> a;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private pen jdField_a_of_type_Pen = new svo(this);
  private rpu jdField_a_of_type_Rpu;
  private syq jdField_a_of_type_Syq;
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
  
  public svl(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
    }
  }
  
  public svl(Activity paramActivity, boolean paramBoolean)
  {
    this(paramActivity);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Pen);
      paramActivity = new IntentFilter();
      paramActivity.addAction("com.tencent.process.fav");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = opn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt1, paramInt2, paramBoolean);
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("pattern", this.jdField_e_of_type_Int);
      nrt.a(null, "", "0X8009545", "0X8009545", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long), ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, Boolean paramBoolean1)
  {
    paramBoolean1 = opn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt1, paramInt2, paramBoolean, paramBoolean1);
    nrt.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long), paramBoolean1, false);
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
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131720019), 0).a();
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
    } while (bjao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localBundle, null));
    xxb.a(1, 2131689512);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString5)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131720019), 0).a();
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
    if (ors.a(paramString5)) {
      paramString4 = ors.a(paramString5, 260, 520, 1);
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
    paramString5.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696873, new Object[] { paramString1 }));
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
      paramString5.putExtra("stuctmsg_bytes", azqu.a(paramString5.getExtras()).getBytes());
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString5, 1001);
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str3 = opn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt1, paramInt2, paramBoolean);
    try
    {
      JSONObject localJSONObject = new JSONObject(str3);
      str1 = str3;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        paramInt1 = opn.a(ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
    nrt.a(null, "", "0X8009A79", "0X8009A79", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long), str1, false);
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "shareMsgToSina start!");
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    paramString2 = "#QQ看点#【" + paramString1 + "】" + paramString2;
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidAppActivity, localActivity.getResources().getDimensionPixelSize(2131298914));
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        this.jdField_a_of_type_Bepp.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131720019, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Bepp.isShowing())
      {
        this.jdField_a_of_type_Bepp.c(2131694217);
        this.jdField_a_of_type_Bepp.show();
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131720019, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramString1.printStackTrace();
          if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
            this.jdField_a_of_type_Bepp.dismiss();
          }
        }
      }
      finally
      {
        if ((this.jdField_a_of_type_Bepp == null) || (!this.jdField_a_of_type_Bepp.isShowing())) {
          break;
        }
        this.jdField_a_of_type_Bepp.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.d("GalleryShareHelper", 2, "shareMsgToSina end!");
  }
  
  public ShareActionSheetBuilder a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.i = paramArticleInfo.innerUniqueID;
    this.jdField_a_of_type_JavaLangString = ors.e(this.i);
    this.jdField_c_of_type_JavaLangString = paramArticleInfo.mTitle;
    this.jdField_a_of_type_JavaUtilArrayList = paramArticleInfo.mDislikeInfos;
    this.jdField_a_of_type_Long = paramArticleInfo.mArticleID;
    this.jdField_b_of_type_JavaLangString = alpo.a(2131705378);
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Long = paramArticleInfo.mStrategyId;
    if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1))
    {
      this.f = paramArticleInfo.mSubscribeName;
      this.g = (oqu.k + Base64.encodeToString(this.k.getBytes(), 0));
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
      if (this.jdField_a_of_type_Syq == null) {
        this.jdField_a_of_type_Syq = new syq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, new svp(this));
      }
      this.jdField_a_of_type_Syq.a.setActionSheetTitle("biu出去让更多好友看到");
      this.jdField_a_of_type_Syq.a.setCancelListener(new svm(this));
      return this.jdField_a_of_type_Syq.a(a());
      this.f = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131699703);
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
  
  public qkq a(ArrayList<DislikeInfo> paramArrayList)
  {
    qkq localqkq = new qkq();
    if (!TextUtils.isEmpty(this.i)) {
      localqkq.jdField_a_of_type_JavaLangString = this.i;
    }
    localqkq.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localqkq.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    return localqkq;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
    if (this.jdField_a_of_type_Syq != null) {
      this.jdField_a_of_type_Syq.b();
    }
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    if (this.jdField_a_of_type_Rpu != null) {
      this.jdField_a_of_type_Rpu = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, syx paramsyx)
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
          m = 2131721478;
        }
        for (;;)
        {
          if (m != -1) {
            xxb.a(0, m);
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
            m = 2131721479;
            break;
            str = String.valueOf(System.currentTimeMillis());
            paramsyx = new svn(this, str, paramsyx);
            WXShareHelper.a().a(paramsyx);
            if (!paramBoolean) {
              break label182;
            }
            WxShareHelperFromReadInjoy.a().a(str, paramString1, paramBitmap, paramString2, paramString3, this.i);
          }
          label182:
          if (bjxj.t(ors.a()) == 1)
          {
            paramsyx = WXShareHelper.a();
            if (paramBoolean) {}
            for (m = n;; m = 1)
            {
              paramsyx.b(str, paramString1, paramBitmap, paramString2, paramString3, m);
              break;
            }
          }
          paramsyx = WxShareHelperFromReadInjoy.a();
          if (paramBoolean) {}
          for (m = i1;; m = 1)
          {
            paramsyx.a(str, paramString1, paramBitmap, paramString2, paramString3, m);
            break;
          }
          label266:
          m = -1;
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, syx paramsyx)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GalleryShareHelper.3(this, paramString, paramBoolean, new HashMap(1), paramsyx), 8, null, false);
  }
  
  public void a(rpu paramrpu)
  {
    this.jdField_a_of_type_Rpu = paramrpu;
  }
  
  public List<Integer>[] a()
  {
    List localList = syq.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svl
 * JD-Core Version:    0.7.0.1
 */