import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class sig
  implements AdapterView.OnItemClickListener, qzv
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private SparseArray<sif> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private bjnw jdField_a_of_type_Bjnw;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private nzr jdField_a_of_type_Nzr;
  private ptj jdField_a_of_type_Ptj = new sik(this);
  private rah jdField_a_of_type_Rah;
  private sdc jdField_a_of_type_Sdc;
  private sdx jdField_a_of_type_Sdx;
  private slt jdField_a_of_type_Slt;
  private ugz jdField_a_of_type_Ugz;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public sig(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Ptj);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
    this.jdField_a_of_type_Rah = new rah(new rad());
    this.jdField_a_of_type_Rah.a(this);
  }
  
  private Intent a(Bundle paramBundle, String paramString, int paramInt)
  {
    paramString = (StructMsgForGeneralShare)bchh.a(paramBundle.getByteArray("STRUCT_MSG_BYTES"));
    if (paramString == null) {
      return new Intent();
    }
    if ((!TextUtils.isEmpty(paramString.mMsgBrief)) && (paramString.mMsgBrief.indexOf(amtj.a(2131715387)) == -1)) {
      paramString.mMsgBrief = (amtj.a(2131715382) + paramString.mMsgBrief);
    }
    uem.a(paramString);
    paramInt = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE", -1);
    String str1 = paramBundle.getString("VIDEO_THIRD_ICON");
    String str2 = paramBundle.getString("VIDEO_THIRD_ACTION");
    String str3 = paramBundle.getString("VIDEO_THIRD_NAME");
    String str4 = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    paramBundle = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    String str5 = uem.a(str4);
    paramString.mSourceAction = "web";
    long l;
    if (TextUtils.isEmpty(str4))
    {
      l = 0L;
      paramString.mSourceAppid = l;
      paramString.source_puin = str4;
      if (paramInt <= 1) {
        break label353;
      }
      if ((TextUtils.isEmpty(str4)) || (str4.equals("16888"))) {
        break label327;
      }
      paramString.mSourceUrl = str5;
      label196:
      if ((paramBundle != null) && (!"".equals(str3))) {
        paramString.mSourceThirdName = paramBundle;
      }
      label215:
      if ((str3 == null) || ("".equals(str3))) {
        break label362;
      }
      paramString.mSourceName = str3;
      label236:
      if ((str1 == null) || ("".equals(str1))) {
        break label370;
      }
    }
    label327:
    label353:
    label362:
    label370:
    for (paramString.mSourceIcon = str1;; paramString.mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png")
    {
      paramString.setFlag(0);
      paramBundle = new Bundle();
      paramBundle.putInt("forward_type", -3);
      paramBundle.putInt("structmsg_service_id", paramString.mMsgServiceID);
      paramBundle.putByteArray("stuctmsg_bytes", paramString.getBytes());
      paramString = new Intent();
      paramString.putExtras(paramBundle);
      return paramString;
      l = Long.valueOf(str4).longValue();
      break;
      if (!TextUtils.isEmpty(str2))
      {
        paramString.mSourceUrl = str2;
        break label196;
      }
      paramString.mSourceUrl = "";
      break label196;
      paramString.mSourceUrl = str5;
      break label215;
      paramString.mSourceName = paramBundle;
      break label236;
    }
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = pay.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_Nzr == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Nzr.a())
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.getShareUrl()))
      {
        localStringBuilder.append(paramBaseArticleInfo.getShareUrl());
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append("&iid=").append(str);
        }
      }
      return "";
    }
  }
  
  private void a(int paramInt1, int paramInt2, BaseArticleInfo paramBaseArticleInfo)
  {
    String str1 = new sie(null, paramBaseArticleInfo.mSubscribeID, paramBaseArticleInfo.mVideoVid, String.valueOf(paramBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_Sdc.a(), paramBaseArticleInfo.mVideoDuration * 1000).e(paramBaseArticleInfo.mAlgorithmID).c(paramBaseArticleInfo.mStrategyId).a(this.jdField_b_of_type_Int).a().a();
    Object localObject;
    String str2;
    if ((paramInt1 != 1) && (paramInt1 != 11) && (paramInt1 != 6))
    {
      long l = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      localObject = new rdz();
      ((rdz)localObject).d = ((int)this.jdField_a_of_type_Sdc.a());
      ((rdz)localObject).e = (paramBaseArticleInfo.getVideoDuration() * 1000);
      if (l == 0L)
      {
        paramInt1 = 1;
        ((rdz)localObject).c = paramInt1;
        ofe.a(paramBaseArticleInfo, this.jdField_b_of_type_Int, 26, -1L, (rdz)localObject);
      }
    }
    else
    {
      localObject = paramBaseArticleInfo.mSubscribeID;
      str2 = Integer.toString(paramInt2);
      if (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        break label222;
      }
    }
    label222:
    for (paramBaseArticleInfo = paramBaseArticleInfo.innerUniqueID;; paramBaseArticleInfo = "0")
    {
      odq.a(null, (String)localObject, "0X800740F", "0X800740F", 0, 0, "1", str2, paramBaseArticleInfo, str1, false);
      return;
      paramInt1 = 2;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
      return;
    }
    str = "";
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("network", ozb.a(this.jdField_a_of_type_AndroidContentContext));
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("uin", String.valueOf(pay.a()));
      ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("source", "2");
      ((JSONObject)localObject).put("version", ofe.a);
      ((JSONObject)localObject).put("vid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
      if (paramBoolean) {
        ((JSONObject)localObject).put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        ((JSONObject)localObject).put("sourcefrom", String.valueOf(paramInt1));
      }
      if (paramInt2 >= 0) {
        ((JSONObject)localObject).put("share_unit", String.valueOf(paramInt2));
      }
      ((JSONObject)localObject).put("type", 2);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareReport:" + localException.toString());
          localObject = str;
        }
      }
    }
    localObject = new sie((String)localObject);
    odq.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID), ((sie)localObject).a().a(), false);
  }
  
  private void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = false;
    boolean bool1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.wechatShareUrl))
    {
      paramString = paramBaseArticleInfo.wechatShareUrl;
      bool1 = true;
      if ((paramBaseArticleInfo.qzoneShareUrl == null) || (!paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com"))) {
        break label208;
      }
      paramString = paramBaseArticleInfo.qzoneShareUrl;
    }
    label208:
    for (;;)
    {
      Object localObject = new StringBuilder();
      if (paramBaseArticleInfo.mVideoPlayCount > 0) {
        ((StringBuilder)localObject).append(rwv.b(paramBaseArticleInfo.mVideoPlayCount)).append(" ");
      }
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = paramBaseArticleInfo.mTitle;
      localObject = ((StringBuilder)localObject).toString();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (paramInt == 9) {}
      for (;;)
      {
        off.a(localBaseActivity, str, (String)localObject, paramString, localBitmap, bool2, paramBaseArticleInfo.innerUniqueID, bool1, null);
        return;
        if (paramInt == 9)
        {
          paramString = paramString + "&sourcefrom=2";
          bool1 = false;
          break;
        }
        paramString = paramString + "&sourcefrom=3";
        bool1 = false;
        break;
        bool2 = false;
      }
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    paramBundle = a(paramBundle, paramString1, paramInt);
    if ((paramString1 == null) || (paramString1.length() < 5))
    {
      atky.a(this.jdField_a_of_type_AndroidAppActivity, paramBundle, 21);
      return;
    }
    paramBundle.setClass(this.jdField_a_of_type_AndroidAppActivity, DirectForwardActivity.class);
    paramBundle.putExtra("toUin", paramString1);
    paramBundle.putExtra("uinType", paramInt);
    paramBundle.putExtra("uinname", paramString2);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramBundle, 21);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = amtj.a(2131715401);
    localObject[2] = amtj.a(2131715399);
    localObject[3] = amtj.a(2131715396);
    localObject[4] = amtj.a(2131715372);
    localObject[5] = amtj.a(2131715392);
    localObject[6] = amtj.a(2131715400);
    localObject[7] = amtj.a(2131715403);
    localObject[8] = amtj.a(2131715407);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131718380, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
    }
    for (;;)
    {
      return;
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131718380, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
          paramString1.printStackTrace();
        }
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new sjb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new sjd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new six(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new siy(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new sja(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new sjf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new sje(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new sjc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new sio(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new sip(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new siz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new sin(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new sil(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new siq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new sir(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new siw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new sim(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ugz == null) {
      this.jdField_a_of_type_Ugz = new ugz(this.jdField_a_of_type_AndroidAppActivity, a(), new sjg(this));
    }
    this.jdField_a_of_type_Ugz.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_Ugz.a().setOnDismissListener(new sih(this));
    this.jdField_a_of_type_Ugz.a().setCancelListener(new sii(this));
    this.jdField_a_of_type_Ugz.a(a(), 14);
    d();
  }
  
  private void d()
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
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new sij(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null))
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Rah.a();
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, sdc paramsdc, sdx paramsdx, int paramInt)
  {
    a(paramBaseArticleInfo, paramBundle, paramsdc, paramsdx, paramInt, true);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, sdc paramsdc, sdx paramsdx, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_Sdx = paramsdx;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Sdc = paramsdc;
    this.jdField_b_of_type_Int = paramInt;
    if (paramBoolean) {
      c();
    }
    this.jdField_a_of_type_Nzr = ((nzr)a().getBusinessHandler(136));
    if (this.jdField_a_of_type_Nzr != null) {
      this.jdField_a_of_type_Nzr.a();
    }
    if (!this.d)
    {
      this.d = true;
      b();
    }
  }
  
  public void a(slt paramslt)
  {
    this.jdField_a_of_type_Slt = paramslt;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.c = true;
    BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    sif localsif = (sif)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localsif == null)
    {
      QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "performActionClick error for can't find shareAction, newAction:" + paramInt);
      return false;
    }
    int i = localsif.c();
    int j = localsif.a();
    int k = localsif.b();
    localsif.a(paramInt, localBaseArticleInfo, a(localBaseArticleInfo), paramActionSheetItem);
    a(paramInt, k, localBaseArticleInfo);
    a(i, j, false);
    return true;
  }
  
  public List<Integer>[] a()
  {
    List localList = ugz.a();
    ArrayList localArrayList = new ArrayList();
    if (rha.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isForbidReprint)) {
      localArrayList.add(Integer.valueOf(134));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mDislikeInfos != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mDislikeInfos.isEmpty())) {
        localArrayList.add(Integer.valueOf(44));
      }
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(161));
      return new List[] { localList, localArrayList };
      localArrayList.add(Integer.valueOf(6));
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (localObject == null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, bool);
      if (localObject == null) {}
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
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
 * Qualified Name:     sig
 * JD-Core Version:    0.7.0.1
 */