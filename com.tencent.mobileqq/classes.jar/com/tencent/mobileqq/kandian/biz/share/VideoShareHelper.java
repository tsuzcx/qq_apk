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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
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
  private AbsBaseArticleInfo a;
  private ReadInJoyBaseAdapter b;
  private int c;
  private Activity d;
  private Context e;
  private Bundle f;
  private Bitmap g = null;
  private URLDrawable h = null;
  private VideoShareListener i;
  private VideoPlayManager j;
  private boolean k = true;
  private boolean l = false;
  private boolean m = false;
  private int n;
  private View o;
  private ActionSheet p;
  private KandianFavoriteBroadcastReceiver q;
  private HashSet<String> r = new HashSet();
  private ReadInJoyShareHelperV2 s;
  private EncryptUinHandler t;
  private SparseArray<ShareAction> u = new SparseArray();
  private boolean v = false;
  private ReadInJoyAtlasManager.AtlasCallbackImpl w = new VideoShareHelper.4(this);
  
  public VideoShareHelper(Activity paramActivity)
  {
    this.d = paramActivity;
    this.e = paramActivity;
    this.q = new KandianFavoriteBroadcastReceiver(this.w);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.d.registerReceiver(this.q, paramActivity);
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = "";
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    EncryptUinHandler localEncryptUinHandler = this.t;
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
    String str1 = new VideoR5.Builder(null, paramAbsBaseArticleInfo.mSubscribeID, paramAbsBaseArticleInfo.mVideoVid, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), this.j.f(), paramAbsBaseArticleInfo.mVideoDuration * 1000).e(paramAbsBaseArticleInfo.mAlgorithmID).c(paramAbsBaseArticleInfo.mStrategyId).a(this.n).b().a();
    int i1 = 1;
    if ((paramInt1 != 1) && (paramInt1 != 11) && (paramInt1 != 6))
    {
      long l1 = this.d.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = ((int)this.j.f());
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (paramAbsBaseArticleInfo.getVideoDuration() * 1000);
      if (l1 == 0L) {
        paramInt1 = i1;
      } else {
        paramInt1 = 2;
      }
      ((ReportInfo.VideoExtraRepoerData)localObject).c = paramInt1;
      VideoReporter.a(paramAbsBaseArticleInfo, this.n, 26, -1L, (ReportInfo.VideoExtraRepoerData)localObject);
    }
    Object localObject = paramAbsBaseArticleInfo.mSubscribeID;
    String str2 = Integer.toString(paramInt2);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      paramAbsBaseArticleInfo = "0";
    }
    PublicAccountReportUtils.a(null, (String)localObject, "0X800740F", "0X800740F", 0, 0, "1", str2, paramAbsBaseArticleInfo, str1, false);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("network", GalleryReportedUtils.a(this.e));
      ((JSONObject)localObject1).put("os", "1");
      ((JSONObject)localObject1).put("uin", String.valueOf(RIJQQAppInterfaceUtil.c()));
      ((JSONObject)localObject1).put("rowkey", this.a.innerUniqueID);
      ((JSONObject)localObject1).put("source", "2");
      ((JSONObject)localObject1).put("version", VideoReporter.a);
      ((JSONObject)localObject1).put("vid", this.a.getVideoVid());
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
    PublicAccountReportUtils.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(this.a.mArticleID), String.valueOf(this.a.mAlgorithmID), ((VideoR5.Builder)localObject2).b().a(), false);
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    this.k = false;
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
    paramString = (BaseActivity)this.d;
    String str = paramAbsBaseArticleInfo.mTitle;
    localObject2 = ((StringBuilder)localObject2).toString();
    Bitmap localBitmap = this.g;
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
      localIntent.setClass(this.d, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString1);
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("uinname", paramString2);
      this.d.startActivityForResult(localIntent, 21);
      return;
    }
    ForwardBaseOption.a(this.d, localIntent, 21);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.d;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = HardCodeUtil.a(2131913571);
    localObject[2] = HardCodeUtil.a(2131913569);
    localObject[3] = HardCodeUtil.a(2131913568);
    localObject[4] = HardCodeUtil.a(2131913558);
    localObject[5] = HardCodeUtil.a(2131913567);
    localObject[6] = HardCodeUtil.a(2131913570);
    localObject[7] = HardCodeUtil.a(2131913572);
    localObject[8] = HardCodeUtil.a(2131913576);
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
        QQToast.makeText(this.e, 0, 2131916544, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
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
    QQToast.makeText(this.e, 0, 2131916544, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.s == null) {
      this.s = new ReadInJoyShareHelperV2(this.d, e(), new VideoShareHelper.SheetItemClickProcessor(this));
    }
    this.s.a().setActionSheetTitle("biu出去让更多好友看到");
    this.s.a().setOnDismissListener(new VideoShareHelper.1(this));
    this.s.a().setCancelListener(new VideoShareHelper.2(this));
    a(this.a);
    ReadInJoyShareHelperV2 localReadInJoyShareHelperV2 = this.s;
    List[] arrayOfList = a(paramBoolean);
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
    } else {
      localObject = "";
    }
    localReadInJoyShareHelperV2.a(arrayOfList, 14, (String)localObject);
    d();
  }
  
  private void c()
  {
    this.u.put(13, new VideoShareHelper.SendToReadInJoyShareAction(this));
    this.u.put(72, new VideoShareHelper.SendToSpecialFriendShareAction(this));
    this.u.put(2, new VideoShareHelper.SendToFriendShareAction(this));
    this.u.put(73, new VideoShareHelper.SendToMoreFriendShareAction(this));
    this.u.put(3, new VideoShareHelper.SendToQzoneShareAction(this));
    this.u.put(9, new VideoShareHelper.SendToWeChatShareAction(this));
    this.u.put(10, new VideoShareHelper.SendToWeChatCircleShareAction(this));
    this.u.put(12, new VideoShareHelper.SendToSinaShareAction(this));
    this.u.put(5, new VideoShareHelper.OpenInQQBrowserShareAction(this));
    this.u.put(4, new VideoShareHelper.OpenInSysBrowserShareAction(this));
    this.u.put(26, new VideoShareHelper.SendToPcAction(this));
    this.u.put(1, new VideoShareHelper.CopyLinkAction(this));
    this.u.put(6, new VideoShareHelper.AddFavoriteAction(this));
    this.u.put(11, new VideoShareHelper.ReportAction(this));
    this.u.put(44, new VideoShareHelper.ReportDislikeAction(this));
    this.u.put(161, new VideoShareHelper.ReportVideoPlayFeedbackAction(this));
  }
  
  private void d()
  {
    this.g = null;
    this.h = null;
    try
    {
      this.h = URLDrawable.getDrawable(this.a.getVideoCoverURL(), null, null);
      URLDrawable localURLDrawable = this.h;
      if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && ((this.h.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.g = ((RegionDrawable)this.h.getCurrDrawable()).getBitmap();
        return;
      }
      localURLDrawable = this.h;
      if (localURLDrawable != null)
      {
        localURLDrawable.setURLDrawableListener(new VideoShareHelper.3(this));
        this.h.startDownload();
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
  
  private QQAppInterface e()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public EncryptUinHandler a()
  {
    return (EncryptUinHandler)e().getBusinessHandler(BusinessHandlerFactory.ENCRYPT_UIN_HANDLER);
  }
  
  public void a(View paramView, int paramInt)
  {
    this.o = paramView;
    this.c = paramInt;
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.b = paramReadInJoyBaseAdapter;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt, boolean paramBoolean)
  {
    a(paramAbsBaseArticleInfo, paramBundle, paramVideoPlayManager, paramVideoShareListener, paramInt, true, paramBoolean);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramAbsBaseArticleInfo;
    this.i = paramVideoShareListener;
    this.f = paramBundle;
    this.j = paramVideoPlayManager;
    this.n = paramInt;
    if (paramBoolean1) {
      b(paramBoolean2);
    }
    this.t = a();
    paramAbsBaseArticleInfo = this.t;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.b();
    }
    if (!this.v)
    {
      this.v = true;
      c();
    }
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.m = true;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    ShareAction localShareAction = (ShareAction)this.u.get(paramInt);
    if (localShareAction == null)
    {
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("performActionClick error for can't find shareAction, newAction:");
      paramActionSheetItem.append(paramInt);
      QLog.e("Q.readinjoy.video.VideoShareHelper", 2, paramActionSheetItem.toString());
      return false;
    }
    int i1 = localShareAction.c();
    int i2 = localShareAction.a();
    int i3 = localShareAction.b();
    localShareAction.a(paramInt, localAbsBaseArticleInfo, a(localAbsBaseArticleInfo), paramActionSheetItem);
    a(paramInt, i3, localAbsBaseArticleInfo);
    a(i1, i2, false);
    return true;
  }
  
  public List<Integer>[] a(boolean paramBoolean)
  {
    List localList = ReadInJoyShareHelperV2.i();
    if (!paramBoolean) {
      return new List[] { localList };
    }
    ArrayList localArrayList = new ArrayList();
    if (!RIJUgcUtils.a(e(), this.a.isForbidReprint)) {
      localArrayList.add(Integer.valueOf(6));
    }
    if ((this.a.mDislikeInfos != null) && (!this.a.mDislikeInfos.isEmpty())) {
      localArrayList.add(Integer.valueOf(44));
    }
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(11));
    localArrayList.add(Integer.valueOf(161));
    return new List[] { localList, localArrayList };
  }
  
  public void b()
  {
    Activity localActivity = this.d;
    if (localActivity != null)
    {
      KandianFavoriteBroadcastReceiver localKandianFavoriteBroadcastReceiver = this.q;
      if (localKandianFavoriteBroadcastReceiver != null)
      {
        localActivity.unregisterReceiver(localKandianFavoriteBroadcastReceiver);
        this.q = null;
      }
    }
    this.o = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper
 * JD-Core Version:    0.7.0.1
 */