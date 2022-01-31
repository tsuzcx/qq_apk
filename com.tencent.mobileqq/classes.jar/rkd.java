import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class rkd
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private bhuf jdField_a_of_type_Bhuf;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private nnp jdField_a_of_type_Nnp;
  private pen jdField_a_of_type_Pen = new rkl(this);
  private rjg jdField_a_of_type_Rjg;
  private rko jdField_a_of_type_Rko;
  private rqj jdField_a_of_type_Rqj;
  private syq jdField_a_of_type_Syq;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public rkd(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Pen);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
  }
  
  private Intent a(Bundle paramBundle)
  {
    Object localObject = (StructMsgForGeneralShare)azvd.a(paramBundle.getByteArray("STRUCT_MSG_BYTES"));
    if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf(alud.a(2131716767)) == -1)) {
      ((StructMsgForGeneralShare)localObject).mMsgBrief = (alud.a(2131716762) + ((StructMsgForGeneralShare)localObject).mMsgBrief);
    }
    swn.a((StructMsgForGeneralShare)localObject);
    int i = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE", -1);
    String str1 = paramBundle.getString("VIDEO_THIRD_ICON");
    String str2 = paramBundle.getString("VIDEO_THIRD_ACTION");
    String str3 = paramBundle.getString("VIDEO_THIRD_NAME");
    String str4 = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    paramBundle = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    String str5 = swn.a(str4);
    ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
    long l;
    if (TextUtils.isEmpty(str4))
    {
      l = 0L;
      ((StructMsgForGeneralShare)localObject).mSourceAppid = l;
      ((StructMsgForGeneralShare)localObject).source_puin = str4;
      if (i <= 1) {
        break label359;
      }
      if ((TextUtils.isEmpty(str4)) || (str4.equals("16888"))) {
        break label331;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str5;
      label192:
      if ((paramBundle != null) && (!"".equals(str3))) {
        ((StructMsgForGeneralShare)localObject).mSourceThirdName = paramBundle;
      }
      label212:
      if ((str3 == null) || ("".equals(str3))) {
        break label369;
      }
      ((StructMsgForGeneralShare)localObject).mSourceName = str3;
      label234:
      if ((str1 == null) || ("".equals(str1))) {
        break label378;
      }
    }
    label331:
    label359:
    label369:
    label378:
    for (((StructMsgForGeneralShare)localObject).mSourceIcon = str1;; ((StructMsgForGeneralShare)localObject).mSourceIcon = "http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png")
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramBundle = new Bundle();
      paramBundle.putInt("forward_type", -3);
      paramBundle.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramBundle.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle);
      return localObject;
      l = Long.valueOf(str4).longValue();
      break;
      if (!TextUtils.isEmpty(str2))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
        break label192;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break label192;
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str5;
      break label212;
      ((StructMsgForGeneralShare)localObject).mSourceName = paramBundle;
      break label234;
    }
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = ors.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = a(paramBundle);
    aryv.a(this.jdField_a_of_type_AndroidAppActivity, paramBundle, 21);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = alud.a(2131716781);
    localObject[2] = alud.a(2131716779);
    localObject[3] = alud.a(2131716776);
    localObject[4] = alud.a(2131716752);
    localObject[5] = alud.a(2131716772);
    localObject[6] = alud.a(2131716780);
    localObject[7] = alud.a(2131716783);
    localObject[8] = alud.a(2131716787);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131720031, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    for (;;)
    {
      return;
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
        paramString3.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start webview!");
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina end!");
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = paramString1;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131720031, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramString1.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Syq == null) {
      this.jdField_a_of_type_Syq = new syq(this.jdField_a_of_type_AndroidAppActivity, a(), new rkm(this), new rkn(this));
    }
    this.jdField_a_of_type_Syq.a.setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_Syq.a.setOnDismissListener(new rke(this));
    this.jdField_a_of_type_Syq.a.setCancelListener(new rkf(this));
    this.jdField_a_of_type_Syq.a(a());
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverURL(), null, null);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new rkk(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, rjg paramrjg, rko paramrko, int paramInt)
  {
    a(paramBaseArticleInfo, paramBundle, paramrjg, paramrko, paramInt, true);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, rjg paramrjg, rko paramrko, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_Rko = paramrko;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Rjg = paramrjg;
    this.jdField_b_of_type_Int = paramInt;
    if (paramBoolean) {
      b();
    }
    this.jdField_a_of_type_Nnp = ((nnp)a().a(136));
    this.jdField_a_of_type_Nnp.a();
  }
  
  public void a(rqj paramrqj)
  {
    this.jdField_a_of_type_Rqj = paramrqj;
  }
  
  public boolean a(int paramInt)
  {
    this.c = true;
    BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    Object localObject1 = new StringBuilder();
    Object localObject3 = this.jdField_a_of_type_Nnp.a();
    if (!TextUtils.isEmpty(localBaseArticleInfo.getShareUrl()))
    {
      ((StringBuilder)localObject1).append(localBaseArticleInfo.getShareUrl());
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((StringBuilder)localObject1).append("&iid=").append((String)localObject3);
      }
    }
    Object localObject5 = ((StringBuilder)localObject1).toString();
    int i;
    label355:
    Object localObject6;
    if (paramInt == 1)
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverBiuActivity.class);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.busiType == 6) {
        ((Intent)localObject1).putExtra("feedsType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType);
      }
      ((Intent)localObject1).putExtra("ARG_VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      ((Intent)localObject1).putExtra("biu_src", 2);
      ((Intent)localObject1).putExtra("arg_from_type", 8);
      ((Intent)localObject1).putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 102);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      i = 3;
      localObject3 = new ron(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, String.valueOf(localBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_Rjg.a(), localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).c(localBaseArticleInfo.mStrategyId).a(this.jdField_b_of_type_Int).a().a();
      if ((paramInt != 14) && (paramInt != 20) && (paramInt != 12))
      {
        long l = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
        localObject1 = new qlw();
        ((qlw)localObject1).d = ((int)this.jdField_a_of_type_Rjg.a());
        ((qlw)localObject1).e = (localBaseArticleInfo.getVideoDuration() * 1000);
        if (l != 0L) {
          break label2191;
        }
        paramInt = 1;
        ((qlw)localObject1).c = paramInt;
        ntd.a(localBaseArticleInfo, this.jdField_b_of_type_Int, 26, -1L, (qlw)localObject1);
      }
      localObject5 = localBaseArticleInfo.mSubscribeID;
      localObject6 = Integer.toString(i);
      if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
        break label2196;
      }
    }
    label1229:
    label1256:
    String str1;
    label1410:
    label2186:
    label2191:
    label2196:
    for (localObject1 = localBaseArticleInfo.innerUniqueID;; str1 = "0")
    {
      for (;;)
      {
        Object localObject4;
        for (;;)
        {
          for (;;)
          {
            nrt.a(null, (String)localObject5, "0X800740F", "0X800740F", 0, 0, "1", (String)localObject6, (String)localObject1, (String)localObject3, false);
            return true;
            if (paramInt == 13)
            {
              this.jdField_a_of_type_Syq.d((String)localObject5 + "&sourcefrom=6");
              i = 3;
              break;
            }
            if (paramInt == 14)
            {
              this.jdField_a_of_type_Syq.c((String)localObject5 + "&sourcefrom=6");
              i = 3;
              break;
            }
            if (paramInt == 20)
            {
              this.jdField_a_of_type_Boolean = false;
              localObject1 = null;
              try
              {
                localObject3 = URLEncoder.encode((String)localObject5, "UTF-8");
                if (!TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin()))
                {
                  localObject1 = localBaseArticleInfo.getSubscribeUin();
                  localObject1 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + (String)localObject1 + "&uin_type=0&url=" + (String)localObject3 + "&type=4&key=" + localBaseArticleInfo.getInnerUniqueID();
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "click jubao btn, reportUrl:" + (String)localObject1);
                  }
                  localObject3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                  ((Intent)localObject3).putExtra("url", (String)localObject1);
                  ((Intent)localObject3).putExtra("hide_more_button", true);
                  this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject3);
                  i = 3;
                }
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                for (;;)
                {
                  localObject4 = localObject1;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "encode url failed, because UTF-8 is unknown");
                    localObject4 = localObject1;
                    continue;
                    if (!TextUtils.isEmpty(localBaseArticleInfo.thirdUin)) {
                      localObject1 = localBaseArticleInfo.thirdUin;
                    } else {
                      localObject1 = "0";
                    }
                  }
                }
              }
            }
          }
          if (paramInt == 2)
          {
            this.jdField_a_of_type_Boolean = false;
            a(this.jdField_a_of_type_AndroidOsBundle);
            i = 0;
            break;
          }
          if (paramInt == 7)
          {
            this.jdField_a_of_type_Syq.a((String)localObject5 + "&sourcefrom=6");
            i = 3;
            break;
          }
          if (paramInt == 8)
          {
            this.jdField_a_of_type_Boolean = false;
            localObject1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject5 + "&sourcefrom=6"));
            ((Intent)localObject1).putExtra("big_brother_source_key", ors.f(0));
            ((Intent)localObject1).putExtra("normal", true);
            try
            {
              this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
              i = 3;
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              for (;;)
              {
                ybk.a(1, 2131695733);
              }
            }
          }
        }
        Object localObject2;
        if (paramInt == 3)
        {
          this.jdField_a_of_type_Boolean = false;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("title", localBaseArticleInfo.mTitle);
          ((Bundle)localObject4).putString("desc", localBaseArticleInfo.mSummary);
          ((Bundle)localObject4).putString("detail_url", (String)localObject5 + "&sourcefrom=1");
          localObject5 = new ArrayList(1);
          if (localBaseArticleInfo.getVideoCoverURL() == null) {}
          for (localObject2 = null;; localObject2 = localBaseArticleInfo.getVideoCoverURL().getFile())
          {
            ((ArrayList)localObject5).add(localObject2);
            ((Bundle)localObject4).putStringArrayList("image_url", (ArrayList)localObject5);
            ((Bundle)localObject4).putLong("req_share_id", 0L);
            bjev.a(a(), this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject4, null);
            i = 1;
            break;
          }
        }
        Object localObject7;
        if (paramInt == 12)
        {
          if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, alud.a(2131716761), 0).a();
            return true;
          }
          rdm.a(a(), this.jdField_a_of_type_AndroidAppActivity);
          int j = 6;
          localObject5 = (String)localObject5 + "&sourcefrom=6";
          localObject2 = rdm.a(localBaseArticleInfo);
          localObject4 = rdm.a(localBaseArticleInfo);
          localObject6 = new Bundle();
          ((Bundle)localObject6).putInt("videoDuration", localBaseArticleInfo.getVideoDuration());
          ((Bundle)localObject6).putLong("publishAccountUin", ((Long)localObject4).longValue());
          ((Bundle)localObject6).putString("publishAccountName", (String)localObject2);
          ((Bundle)localObject6).putLong("feedsId", localBaseArticleInfo.mFeedId);
          ((Bundle)localObject6).putInt("feedsType", localBaseArticleInfo.mFeedType);
          Activity localActivity;
          String str2;
          String str3;
          String str4;
          if (localBaseArticleInfo.busiType == 6)
          {
            i = 1;
            ((Bundle)localObject6).putInt("videoType", i);
            localObject2 = a();
            if (localObject2 == null) {
              break label1345;
            }
            localObject2 = ((QQAppInterface)localObject2).c();
            localObject7 = pej.a();
            localActivity = this.jdField_a_of_type_AndroidAppActivity;
            str2 = localBaseArticleInfo.getInnerUniqueID();
            str3 = localBaseArticleInfo.mTitle;
            str4 = localBaseArticleInfo.mSummary;
            if (localBaseArticleInfo.getVideoCoverURL() != null) {
              break label1352;
            }
          }
          label1345:
          label1352:
          for (localObject4 = "";; localObject4 = localBaseArticleInfo.getVideoCoverURL().getPath())
          {
            ((pej)localObject7).a(localActivity, (String)localObject2, 2, str2, str3, str4, (String)localObject4, (String)localObject5, (Bundle)localObject6);
            this.jdField_a_of_type_JavaUtilHashSet.add(localBaseArticleInfo.getInnerUniqueID());
            i = j;
            break;
            i = 2;
            break label1229;
            localObject2 = "";
            break label1256;
          }
        }
        if ((paramInt == 4) || (paramInt == 5))
        {
          this.jdField_a_of_type_Boolean = false;
          if (paramInt == 4)
          {
            localObject2 = (String)localObject5 + "&sourcefrom=2";
            i = 2;
            localObject6 = new StringBuilder();
            if (localBaseArticleInfo.mVideoPlayCount > 0) {
              ((StringBuilder)localObject6).append(rdm.b(localBaseArticleInfo.mVideoPlayCount)).append(" ");
            }
            localObject4 = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
            localObject5 = localBaseArticleInfo.mTitle;
            localObject6 = ((StringBuilder)localObject6).toString();
            localObject7 = this.jdField_a_of_type_AndroidGraphicsBitmap;
            if (paramInt != 4) {
              break label1536;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            nte.a((BaseActivity)localObject4, (String)localObject5, (String)localObject6, (String)localObject2, (Bitmap)localObject7, bool, localBaseArticleInfo.innerUniqueID, null);
            break;
            localObject2 = (String)localObject5 + "&sourcefrom=3";
            i = 4;
            break label1410;
          }
        }
        if (paramInt == 6)
        {
          this.jdField_a_of_type_Boolean = false;
          localObject4 = localBaseArticleInfo.mTitle;
          localObject5 = (String)localObject5 + "&sourcefrom=4";
          if (localBaseArticleInfo.getVideoCoverURL() == null) {}
          for (localObject2 = "";; localObject2 = localBaseArticleInfo.getVideoCoverURL().getFile())
          {
            a((String)localObject4, "", (String)localObject5, (String)localObject2);
            i = 5;
            break;
          }
        }
        if (paramInt == 15)
        {
          this.jdField_a_of_type_Boolean = false;
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("channel_id", this.jdField_b_of_type_Int);
            ((JSONObject)localObject2).put("source", 1);
            if ((localBaseArticleInfo.mDislikeInfos != null) && (localBaseArticleInfo.mDislikeInfos.size() > 0))
            {
              this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this.jdField_a_of_type_AndroidAppActivity, null));
              localObject4 = new rkg(this);
              this.jdField_a_of_type_Bhuf.a((bhun)localObject4);
              localObject4 = new ReadInJoyDisLikeDialogView(this.jdField_a_of_type_AndroidContentContext);
              ((ReadInJoyDisLikeDialogView)localObject4).setOnUninterestConfirmListener(new rkh(this, localBaseArticleInfo, (JSONObject)localObject2));
              ((ReadInJoyDisLikeDialogView)localObject4).setUninterestData(localBaseArticleInfo.mDislikeInfos);
              this.jdField_a_of_type_Bhuf.a((View)localObject4, null);
              try
              {
                if (!this.jdField_a_of_type_Bhuf.isShowing())
                {
                  if ((bhtb.g()) && (!ShortVideoUtils.c()))
                  {
                    this.jdField_a_of_type_Bhuf.getWindow().setFlags(8, 8);
                    this.jdField_a_of_type_Bhuf.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
                    this.jdField_a_of_type_Bhuf.setOnShowListener(new rkj(this));
                  }
                  this.jdField_a_of_type_Bhuf.show();
                  nrt.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new ron(ntd.a(null, null, null, null, (JSONObject)localObject2)).h(localBaseArticleInfo.innerUniqueID).a().a(), false);
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "dislikeSheet.show exception=" + localException);
                  }
                }
              }
              i = 3;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "文章ID为：" + localBaseArticleInfo.mArticleID + "的负反馈数据为空!");
              }
            }
          }
        }
      }
      if (paramInt == 24)
      {
        if (localBaseArticleInfo.busiType == 6)
        {
          if (TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin())) {
            break label2186;
          }
          str1 = oqu.g + bdfr.encodeToString(localBaseArticleInfo.getSubscribeUin().getBytes(), 2);
          ors.a(this.jdField_a_of_type_AndroidContentContext, str1);
          i = 3;
          break;
        }
        if ((TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin())) || (localBaseArticleInfo.getSubscribeUin().equals("16888"))) {
          break label2186;
        }
        str1 = oqu.k + bdfr.encodeToString(localBaseArticleInfo.getSubscribeUin().getBytes(), 2);
        ors.a(this.jdField_a_of_type_AndroidContentContext, str1);
        i = 3;
        break;
      }
      if (paramInt == 122)
      {
        roi.a(this.jdField_a_of_type_AndroidAppActivity, localBaseArticleInfo, this.jdField_a_of_type_Rjg.a(localBaseArticleInfo.getInnerUniqueID()), 3, 1);
        roi.a(localBaseArticleInfo.getInnerUniqueID(), 3, 1);
      }
      i = 3;
      break;
      paramInt = 2;
      break label355;
    }
  }
  
  public List<Integer>[] a()
  {
    List localList = syq.a();
    ArrayList localArrayList = new ArrayList();
    if (bkbq.d()) {
      localArrayList.add(Integer.valueOf(24));
    }
    localArrayList.add(Integer.valueOf(12));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mDislikeInfos != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mDislikeInfos.isEmpty())) {
      localArrayList.add(Integer.valueOf(15));
    }
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(14));
    localArrayList.add(Integer.valueOf(20));
    localArrayList.add(Integer.valueOf(122));
    return new List[] { localList, localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, bool);
      if (paramAdapterView == null) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkd
 * JD-Core Version:    0.7.0.1
 */