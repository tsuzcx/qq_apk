package com.tencent.mobileqq.kandian.biz.share;

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
import com.tencent.biz.pubaccount.EncryptUinHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoShareUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.video.VideoStructMsgHelper;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoShareHelper
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private SparseArray<ShareAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private EncryptUinHandler jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  private ReadInJoyAtlasManager.AtlasCallbackImpl jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl = new VideoShareHelper.4(this);
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
  private VideoShareListener jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareListener;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  public VideoShareHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver, paramActivity);
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = "";
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    EncryptUinHandler localEncryptUinHandler = this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
    if (localEncryptUinHandler != null) {
      str = localEncryptUinHandler.a();
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.getShareUrl()))
    {
      localStringBuilder.append(paramAbsBaseArticleInfo.getShareUrl());
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append("&iid=");
        localStringBuilder.append(str);
      }
      localStringBuilder.append("&rowkey=");
      localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt1, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str1 = new VideoR5.Builder(null, paramAbsBaseArticleInfo.mSubscribeID, paramAbsBaseArticleInfo.mVideoVid, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b(), paramAbsBaseArticleInfo.mVideoDuration * 1000).e(paramAbsBaseArticleInfo.mAlgorithmID).c(paramAbsBaseArticleInfo.mStrategyId).a(this.jdField_b_of_type_Int).a().a();
    int i = 1;
    if ((paramInt1 != 1) && (paramInt1 != 11) && (paramInt1 != 6))
    {
      long l = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = ((int)this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b());
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (paramAbsBaseArticleInfo.getVideoDuration() * 1000);
      if (l == 0L) {
        paramInt1 = i;
      } else {
        paramInt1 = 2;
      }
      ((ReportInfo.VideoExtraRepoerData)localObject).c = paramInt1;
      VideoReporter.a(paramAbsBaseArticleInfo, this.jdField_b_of_type_Int, 26, -1L, (ReportInfo.VideoExtraRepoerData)localObject);
    }
    Object localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = paramAbsBaseArticleInfo.mSubscribeID;
    String str3 = Integer.toString(paramInt2);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      paramAbsBaseArticleInfo = "0";
    }
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, str2, "0X800740F", "0X800740F", 0, 0, "1", str3, paramAbsBaseArticleInfo, str1, false);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("network", GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext));
      ((JSONObject)localObject1).put("os", "1");
      ((JSONObject)localObject1).put("uin", String.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin()));
      ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      ((JSONObject)localObject1).put("source", "2");
      ((JSONObject)localObject1).put("version", VideoReporter.a);
      ((JSONObject)localObject1).put("vid", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getVideoVid());
      if (paramBoolean) {
        ((JSONObject)localObject1).put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        ((JSONObject)localObject1).put("sourcefrom", String.valueOf(paramInt1));
      }
      if (paramInt2 >= 0) {
        ((JSONObject)localObject1).put("share_unit", String.valueOf(paramInt2));
      }
      ((JSONObject)localObject1).put("type", 2);
      localObject1 = ((JSONObject)localObject1).toString();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shareReport:");
        localStringBuilder.append(localException.toString());
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, localStringBuilder.toString());
      }
      localObject2 = "";
    }
    Object localObject2 = new VideoR5.Builder((String)localObject2);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID), ((VideoR5.Builder)localObject2).a().a(), false);
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    boolean bool1;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.wechatShareUrl))
    {
      paramString = paramAbsBaseArticleInfo.wechatShareUrl;
      bool1 = true;
    }
    else
    {
      if (paramInt == 9)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&sourcefrom=2");
        paramString = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&sourcefrom=3");
        paramString = ((StringBuilder)localObject1).toString();
      }
      bool1 = false;
    }
    Object localObject1 = paramString;
    if (paramAbsBaseArticleInfo.qzoneShareUrl != null)
    {
      localObject1 = paramString;
      if (paramAbsBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
        localObject1 = paramAbsBaseArticleInfo.qzoneShareUrl;
      }
    }
    Object localObject2 = new StringBuilder();
    if (paramAbsBaseArticleInfo.mVideoPlayCount > 0)
    {
      ((StringBuilder)localObject2).append(VideoFeedsHelper.b(paramAbsBaseArticleInfo.mVideoPlayCount));
      ((StringBuilder)localObject2).append(" ");
    }
    paramString = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
    String str = paramAbsBaseArticleInfo.mTitle;
    localObject2 = ((StringBuilder)localObject2).toString();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    boolean bool2;
    if (paramInt == 9) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    VideoShareUtils.a(paramString, str, (String)localObject2, (String)localObject1, localBitmap, bool2, paramAbsBaseArticleInfo.innerUniqueID, bool1, null);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(VideoStructMsgHelper.a.a(paramAbsBaseArticleInfo));
    if ((paramString1 != null) && (paramString1.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString1);
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("uinname", paramString2);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 21);
      return;
    }
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, 21);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = HardCodeUtil.a(2131716122);
    localObject[2] = HardCodeUtil.a(2131716120);
    localObject[3] = HardCodeUtil.a(2131716119);
    localObject[4] = HardCodeUtil.a(2131716109);
    localObject[5] = HardCodeUtil.a(2131716118);
    localObject[6] = HardCodeUtil.a(2131716121);
    localObject[7] = HardCodeUtil.a(2131716123);
    localObject[8] = HardCodeUtil.a(2131716127);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#QQ看点#");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("【");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("】");
    paramString1 = localStringBuilder.toString();
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://service.weibo.com/share/share.php?");
        ((StringBuilder)localObject).append("title=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("%F0%9F%8E%AC");
        paramString1 = ((StringBuilder)localObject).toString();
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("&url=");
        ((StringBuilder)localObject).append(paramString3);
        paramString1 = ((StringBuilder)localObject).toString();
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString4 = new StringBuilder();
        paramString4.append(paramString1);
        paramString4.append("&pic=");
        paramString4.append(paramString3);
        paramString1 = paramString4.toString();
        paramString3 = new StringBuilder();
        paramString3.append(paramString1);
        paramString3.append("&_wv=3");
        paramString1 = paramString3.toString();
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString3.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719009, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        paramString1.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina end!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina empty title or share_url");
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719009, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this.jdField_a_of_type_AndroidAppActivity, a(), new VideoShareHelper.SheetItemClickProcessor(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setOnDismissListener(new VideoShareHelper.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setCancelListener(new VideoShareHelper.2(this));
    a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ReadInJoyShareHelperV2 localReadInJoyShareHelperV2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
    List[] arrayOfList = a(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null) {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
    } else {
      localObject = "";
    }
    localReadInJoyShareHelperV2.a(arrayOfList, 14, (String)localObject);
    c();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new VideoShareHelper.SendToReadInJoyShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new VideoShareHelper.SendToSpecialFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new VideoShareHelper.SendToFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new VideoShareHelper.SendToMoreFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new VideoShareHelper.SendToQzoneShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new VideoShareHelper.SendToWeChatShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new VideoShareHelper.SendToWeChatCircleShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new VideoShareHelper.SendToSinaShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new VideoShareHelper.OpenInQQBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new VideoShareHelper.OpenInSysBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new VideoShareHelper.SendToPcAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new VideoShareHelper.CopyLinkAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new VideoShareHelper.AddFavoriteAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new VideoShareHelper.ReportAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new VideoShareHelper.ReportDislikeAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new VideoShareHelper.ReportVideoPlayFeedbackAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new VideoShareHelper.AddVideoToTopic(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getVideoCoverURL(), null, null);
      URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
        return;
      }
      localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localURLDrawable != null)
      {
        localURLDrawable.setURLDrawableListener(new VideoShareHelper.3(this));
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      }
      return;
    }
    catch (Exception localException)
    {
      label103:
      break label103;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
    }
  }
  
  public EncryptUinHandler a()
  {
    return (EncryptUinHandler)a().getBusinessHandler(BusinessHandlerFactory.ENCRYPT_UIN_HANDLER);
  }
  
  public void a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null)
    {
      KandianFavoriteBroadcastReceiver localKandianFavoriteBroadcastReceiver = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver;
      if (localKandianFavoriteBroadcastReceiver != null)
      {
        localActivity.unregisterReceiver(localKandianFavoriteBroadcastReceiver);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver = null;
      }
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt, boolean paramBoolean)
  {
    a(paramAbsBaseArticleInfo, paramBundle, paramVideoPlayManager, paramVideoShareListener, paramInt, true, paramBoolean);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareListener = paramVideoShareListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_b_of_type_Int = paramInt;
    if (paramBoolean1) {
      a(paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler = a();
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.a();
    }
    if (!this.d)
    {
      this.d = true;
      b();
    }
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.c = true;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    ShareAction localShareAction = (ShareAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localShareAction == null)
    {
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("performActionClick error for can't find shareAction, newAction:");
      paramActionSheetItem.append(paramInt);
      QLog.e("Q.readinjoy.video.VideoShareHelper", 2, paramActionSheetItem.toString());
      return false;
    }
    int i = localShareAction.c();
    int j = localShareAction.a();
    int k = localShareAction.b();
    localShareAction.a(paramInt, localAbsBaseArticleInfo, a(localAbsBaseArticleInfo), paramActionSheetItem);
    a(paramInt, k, localAbsBaseArticleInfo);
    a(i, j, false);
    return true;
  }
  
  public List<Integer>[] a(boolean paramBoolean)
  {
    List localList = ReadInJoyShareHelperV2.a();
    if (!paramBoolean) {
      return new List[] { localList };
    }
    ArrayList localArrayList = new ArrayList();
    if (RIJUgcUtils.a(a(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.isForbidReprint)) {
      localArrayList.add(Integer.valueOf(134));
    } else {
      localArrayList.add(Integer.valueOf(6));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mDislikeInfos != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mDislikeInfos.isEmpty())) {
      localArrayList.add(Integer.valueOf(44));
    }
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(11));
    localArrayList.add(Integer.valueOf(161));
    return new List[] { localList, localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onItemClick, tag = ");
      boolean bool;
      if (paramAdapterView != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.append(bool);
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, paramView.toString());
    }
    if (paramAdapterView == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper
 * JD-Core Version:    0.7.0.1
 */