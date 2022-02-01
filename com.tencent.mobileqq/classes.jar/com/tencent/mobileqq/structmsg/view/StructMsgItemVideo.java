package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoyConfig;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IMultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5Builder;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianAIOVideoAutoPlayAladdinConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.model.WeishiFeedCommInfo;
import cooperation.qzone.model.WeishiFeedInfo;
import cooperation.qzone.model.WeishiUserInfo;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVideo
  extends AbsStructMsgElement
{
  public String aA = null;
  public String aB = null;
  public int aC = 0;
  public int aD = 0;
  public int aE = 0;
  public int aF = 0;
  public int aG = 0;
  public String aM;
  public String aN;
  public String aO;
  public int aP;
  public long aQ;
  public int aR = 0;
  public String aS;
  String aT = "";
  String aU = "";
  String aV = "";
  String aW = "";
  public boolean aX = false;
  public boolean aY = true;
  String aZ;
  public String au = null;
  public String av = null;
  public int aw = 0;
  public StructMsgItemVideo.UIHandler ax = null;
  public boolean ay = false;
  public String az = null;
  boolean ba = false;
  String bb;
  String bc;
  public String bd;
  public String be = "";
  protected View.OnClickListener bf = new StructMsgItemVideo.4(this);
  private View.OnClickListener bg = new StructMsgItemVideo.1(this);
  private URLDrawableDownListener.Adapter bh = new StructMsgItemVideo.2(this);
  
  public StructMsgItemVideo()
  {
    this.b = "video";
    this.a = 18;
  }
  
  public StructMsgItemVideo(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.b = "video";
    this.au = paramString1;
    this.aR = paramInt1;
    this.az = paramString2;
    this.aA = paramString3;
    this.aB = paramString4;
    this.aD = paramInt2;
    this.aC = paramInt3;
    this.aE = paramInt4;
    this.aF = paramInt5;
    this.aG = paramInt6;
    this.aM = paramString5;
    this.aN = paramString6;
    this.aO = paramString7;
    this.aQ = paramLong;
    this.aP = paramInt7;
    this.a = 18;
  }
  
  public StructMsgItemVideo(String paramString1, String paramString2, boolean paramBoolean) {}
  
  private Intent a(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.getLong("uin");
    String str1 = paramJSONObject.getString("ugcKey");
    Object localObject = paramJSONObject.getString("videoUrl");
    String str2 = paramJSONObject.getString("videoID");
    String str3 = paramJSONObject.getString("nickname");
    String str4 = paramJSONObject.getString("isTXVideo");
    int i = paramJSONObject.getInt("appid");
    paramJSONObject = new WeishiFeedInfo();
    paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
    paramJSONObject.feedCommInfo = new WeishiFeedCommInfo(i, str1, null, null, null);
    paramJSONObject.videoInfo = new VideoInfo();
    paramJSONObject.videoInfo.coverUrl = new PictureUrl(this.au, this.aE, this.aF);
    paramJSONObject.videoInfo.originVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.videoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.videoRemark = new VideoInfo.VideoRemark();
    if ("0".equals(str4)) {
      paramJSONObject.videoInfo.videoRemark.orgwebsite = 0;
    } else {
      paramJSONObject.videoInfo.videoRemark.orgwebsite = 1;
    }
    paramJSONObject.videoInfo.width = this.aE;
    paramJSONObject.videoInfo.height = this.aF;
    paramJSONObject.videoInfo.videoId = str2;
    paramJSONObject.videoInfo.videoTime = this.aG;
    paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramJSONObject);
    paramJSONObject = QZoneHelper.getQzoneVerticalVideoDownloadActivityIntent(BaseApplicationImpl.getContext());
    paramJSONObject.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    paramJSONObject.setFlags(268435456);
    paramJSONObject.putExtra("key_weishi_entrance_type", 2);
    paramJSONObject.putParcelableArrayListExtra("key_videolist", (ArrayList)localObject);
    paramJSONObject.putExtra("key_current_feeduin", String.valueOf(l));
    paramJSONObject.putExtra("key_weishi_feeds_id", str1);
    paramJSONObject.putExtra("key_weishi_feed_appid", i);
    paramJSONObject.putExtra("key_weishi_entrance_type", 22);
    return paramJSONObject;
  }
  
  private void a(Context paramContext)
  {
    if (!TextUtils.isEmpty(e()))
    {
      if ((!e().startsWith("http://")) && (!e().startsWith("https://"))) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", e());
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, e());
      paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
      paramContext.extra().putAll(localIntent.getExtras());
      QRoute.startUri(paramContext, null);
      if (!TextUtils.isEmpty(e()))
      {
        paramContext = CGILoader.b(e());
        if (!TextUtils.isEmpty(paramContext)) {
          ReportController.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
        }
      }
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.aw == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839583);
      }
      if (this.ax == null) {
        this.ax = new StructMsgItemVideo.UIHandler(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.av);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    paramContext.startActivity(paramString);
    if (!TextUtils.isEmpty(e()))
    {
      paramContext = CGILoader.b(e());
      if (!TextUtils.isEmpty(paramContext)) {
        ReportController.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
      }
    }
  }
  
  private static boolean b(Context paramContext, int paramInt)
  {
    boolean bool2 = AIOVideoPlayController.a().a(paramContext, 3, paramInt);
    boolean bool3 = RIJKanDianAIOVideoAutoPlayAladdinConfig.a();
    boolean bool1;
    if ((bool2) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("canAutoPlay(): oldAutoPlay:");
      paramContext.append(bool2);
      paramContext.append(", enableAutoPlay:");
      paramContext.append(bool3);
      paramContext.append(", autoPlay:");
      paramContext.append(bool1);
      QLog.d("structmsg.StructMsgItemVideo", 2, paramContext.toString());
    }
    return bool1;
  }
  
  private String e()
  {
    return this.as.mMsgUrl;
  }
  
  private void f()
  {
    try
    {
      if (!((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(this.ak))
      {
        IEcshopAdHandler.ReportInfo localReportInfo = new IEcshopAdHandler.ReportInfo();
        localReportInfo.a = 3;
        localReportInfo.r = 1;
        localReportInfo = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam(localReportInfo, this.as.message);
        ((IEcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(localReportInfo, null);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.as == null) {
      return null;
    }
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    if (c())
    {
      paramBundle.putBoolean("is_public_account_video_msg", true);
      this.ay = true;
      this.aS = paramBundle.getString("public_account_video_title");
    }
    boolean bool1 = this.as.hasFlag(4) ^ true;
    if (!this.ay) {
      return b(paramContext, paramView, paramBundle);
    }
    if ((this.as instanceof StructMsgForGeneralShare))
    {
      if (paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN") != null) {
        this.aM = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      } else {
        this.aM = String.valueOf(((StructMsgForGeneralShare)this.as).source_puin);
      }
      if (paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME") != null) {
        this.aN = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      } else {
        this.aN = String.valueOf(((StructMsgForGeneralShare)this.as).mSourceName);
      }
      this.aT = ((StructMsgForGeneralShare)this.as).mSourceIcon;
      this.aU = ((StructMsgForGeneralShare)this.as).mSourceName;
      this.aV = ((StructMsgForGeneralShare)this.as).mSourceUrl;
      this.aW = ((StructMsgForGeneralShare)this.as).mSourceThirdName;
    }
    Object localObject1 = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      if (paramView.getTag(2131446469) != null)
      {
        paramContext = paramView.getTag(2131446469);
        if ((paramContext instanceof StructMsgItemVideo.Holder))
        {
          paramContext = (StructMsgItemVideo.Holder)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
    }
    paramView = new RelativeLayout(paramContext);
    PAVideoView localPAVideoView = new PAVideoView(paramContext);
    localPAVideoView.setId(2131446469);
    localPAVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localPAVideoView.setContentDescription(((Resources)localObject1).getText(2131916810));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int j;
    if (bool1)
    {
      localPAVideoView.setRadius(15.0F);
      localPAVideoView.a(true);
      localPAVideoView.c(true);
      if (this.as.message != null) {
        localPAVideoView.v = this.as.message.isSend();
      }
      i = this.aE;
      j = this.aF;
      if (i >= j)
      {
        localPAVideoView.D = PAVideoView.C;
        localPAVideoView.E = true;
        localPAVideoView.F = true;
      }
      else
      {
        localPAVideoView.F = false;
        localPAVideoView.E = false;
        localObject3 = ShortVideoUtils.adjustSize(i, j);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
      }
    }
    else
    {
      if (!this.aY) {
        localPAVideoView.setRadiusTop(5.0F);
      } else {
        localPAVideoView.setRadius(5.0F);
      }
      localPAVideoView.F = true;
      localPAVideoView.E = false;
      localPAVideoView.a(true);
      localPAVideoView.c(false);
      i = this.aE;
      j = this.aF;
      if (i < j) {
        localPAVideoView.D = PAVideoView.B;
      } else if (i > j) {
        localPAVideoView.D = PAVideoView.A;
      } else if ((i == j) && (i != 0) && (j != 0))
      {
        if (bool1) {
          localPAVideoView.D = PAVideoView.C;
        } else {
          localPAVideoView.D = PAVideoView.B;
        }
      }
      else {
        localPAVideoView.D = PAVideoView.A;
      }
    }
    paramView.addView(localPAVideoView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(paramContext);
    ((ImageView)localObject2).setImageResource(2130844327);
    ((ImageView)localObject2).setVisibility(8);
    int i = AIOUtils.b(62.0F, (Resources)localObject1);
    if (bool1) {
      i = AIOUtils.b(50.0F, (Resources)localObject1);
    }
    Object localObject3 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13);
    if (bool1)
    {
      i = AIOUtils.b(10.0F, (Resources)localObject1) / 2;
      if (localPAVideoView.v) {
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
      } else {
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
      }
    }
    paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new LinearLayout(paramContext);
    ((LinearLayout)localObject3).setHorizontalGravity(0);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131446469);
    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131446469);
    ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131446469);
    if (bool1) {
      i = AIOUtils.b(7.0F, (Resources)localObject1);
    } else {
      i = AIOUtils.b(12.0F, (Resources)localObject1);
    }
    int k;
    if (bool1)
    {
      if ((this.as.message != null) && (this.as.message.isSend()))
      {
        k = AIOUtils.b(10.0F, (Resources)localObject1) + i;
        j = i;
      }
      else
      {
        j = AIOUtils.b(10.0F, (Resources)localObject1) + i;
        k = i;
      }
    }
    else
    {
      j = i;
      k = j;
    }
    ((LinearLayout)localObject3).setPadding(j, i, k, i);
    paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject4 = new TextView(paramContext);
    ((TextView)localObject4).setId(2131446468);
    ((TextView)localObject4).setTextColor(-1);
    ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject4).setSingleLine(true);
    if (bool1) {
      ((TextView)localObject4).setTextSize(1, 14.0F);
    } else {
      ((TextView)localObject4).setTextSize(1, 19.0F);
    }
    Object localObject5 = new LinearLayout.LayoutParams(0, -2);
    ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject5).rightMargin = AIOUtils.b(7.0F, (Resources)localObject1);
    ((LinearLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setSingleLine(true);
    if (bool1) {
      ((TextView)localObject1).setTextSize(1, 12.0F);
    } else {
      ((TextView)localObject1).setTextSize(1, 14.0F);
    }
    ((TextView)localObject1).setTextColor(-1);
    localObject5 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject5).gravity = 85;
    ((LinearLayout.LayoutParams)localObject5).weight = 0.0F;
    ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
    localObject5 = new StructMsgItemVideo.Holder();
    ((StructMsgItemVideo.Holder)localObject5).a = localPAVideoView;
    ((StructMsgItemVideo.Holder)localObject5).c = ((TextView)localObject4);
    ((StructMsgItemVideo.Holder)localObject5).d = ((ImageView)localObject2);
    ((StructMsgItemVideo.Holder)localObject5).e = ((TextView)localObject1);
    ((StructMsgItemVideo.Holder)localObject5).b = ((View)localObject3);
    paramView.setTag(2131446469, localObject5);
    paramView.setTag(this);
    ((StructMsgItemVideo.Holder)localObject5).a.a(this, (StructMsgItemVideo.Holder)localObject5);
    boolean bool2 = b(paramContext, this.as.uinType);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("createView(): convertView=");
      paramContext.append(paramView);
      paramContext.append(", args = ");
      paramContext.append(paramBundle.toString());
      paramContext.append("\n, hasHeadIcon = ");
      paramContext.append(bool1);
      paramContext.append(", uniseq=");
      paramContext.append(this.as.uniseq);
      paramContext.append("\n, autoPlay = ");
      paramContext.append(bool2);
      paramContext.append(", vid = ");
      paramContext.append(this.az);
      QLog.d("structmsg.StructMsgItemVideo", 2, paramContext.toString());
    }
    if ((bool2) && (this.aR != 4)) {
      ((StructMsgItemVideo.Holder)localObject5).a.h();
    } else {
      ((StructMsgItemVideo.Holder)localObject5).a.e();
    }
    if (this.aD > 0) {
      ((StructMsgItemVideo.Holder)localObject5).e.setText(ShortVideoUtils.stringForTime(this.aD * 1000));
    }
    if (!TextUtils.isEmpty(this.aZ)) {
      paramView.setTag(2131446476, this.aZ);
    }
    paramView.setOnClickListener(this.bf);
    if (this.ar != null)
    {
      paramView.setOnLongClickListener((View.OnLongClickListener)this.ar.get());
      paramView.setOnTouchListener((View.OnTouchListener)this.ar.get());
    }
    if ((this.as.message != null) && (!AIOSingleReporter.a().a(this.as.message, "0X800B375")))
    {
      paramContext = ((IVideoR5BuilderFactory)QRoute.api(IVideoR5BuilderFactory.class)).create(null, null, this.az, this.aO).a(this.aO).a(bool2).b(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isStructMsgJumpForUG(this.as)).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B375", "0X800B375", 0, 0, "", "", "", paramContext, false);
      AIOSingleReporter.a().b(this.as.message, "0X800B375");
    }
    return paramView;
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    Bundle localBundle;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramStructMsgForGeneralShare != null))
    {
      if (this.as == null) {
        return;
      }
      Object localObject1;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("structmsg.StructMsgItemVideo", 2, "enterFullScreenActivity():", localException);
        }
        localObject1 = null;
      }
      if ((!((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).isInPhoneCall(paramContext)) && ((localObject1 == null) || (!((QQAppInterface)localObject1).isVideoChatting())))
      {
        if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mQzoneExtraMsg))
        {
          a((QQAppInterface)localObject1, paramContext, paramStructMsgForGeneralShare.mQzoneExtraMsg);
          return;
        }
        localBundle = new Bundle();
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.aM);
        if (this.aR > 1) {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.aW);
        } else {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.aN);
        }
        localBundle.putString("VIDEO_H5_URL", this.as.mMsgUrl);
        if (!TextUtils.isEmpty(this.as.mMsgUrl)) {
          localBundle.putString("RED_PACKET_ID", Uri.parse(this.as.mMsgUrl).getQueryParameter("redpackid"));
        }
        bool1 = TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime);
        bool2 = false;
        if ((!bool1) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {
          localObject1 = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));
        } else {
          localObject1 = paramStructMsgForGeneralShare.mCreateTime;
        }
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject1);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.aG));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.aE));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.aF));
        localBundle.putString("VIDEO_VID", this.aA);
        localBundle.putString("VIDEO_COVER", this.au);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.aO);
        localBundle.putString("VIDEO_TITLE", this.aS);
        int i = this.aR;
        if ((i != 2) && (i != 3)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.aR);
        if (d())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.aP);
          localBundle.putLong("VIDEO_FEED_ID", this.aQ);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.aT);
          localBundle.putString("VIDEO_THIRD_NAME", this.aU);
          localBundle.putString("VIDEO_THIRD_ACTION", this.aV);
          if (this.aR == 2) {
            localBundle.putString("VIDEO_THIRD_URL", ((IThirdVideoManager)QRoute.api(IThirdVideoManager.class)).getUrlByVid(this.aA));
          }
        }
        if (this.as.message != null)
        {
          localObject1 = this.as.message.frienduin;
          String str = this.az;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.aR);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.as.msgId);
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X8006830", "0X8006830", 0, 0, str, (String)localObject2, localStringBuilder.toString(), "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.as.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 33);
        localObject1 = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(HardCodeUtil.a(2131914011)))) && (((AladdinConfig)localObject1).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (((IReadInJoyFloatingWindowHelper)QRoute.api(IReadInJoyFloatingWindowHelper.class)).openFloatLayerVideo(paramContext, this.aO, localBundle))) {
          return;
        }
      }
    }
    try
    {
      bool1 = ((IReadInJoyConfig)QRoute.api(IReadInJoyConfig.class)).isEnterMultiMode(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
      if (bool1)
      {
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        ((IMultiVideoHelper)QRoute.api(IMultiVideoHelper.class)).start(paramContext, paramStructMsgForGeneralShare);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772090, 2130772092);
        }
      }
      else
      {
        paramStructMsgForGeneralShare = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getVideoFeedsPlayActivityIntent(paramContext);
        paramStructMsgForGeneralShare.addFlags(536870912);
        paramStructMsgForGeneralShare.putExtras(localBundle);
        if ((paramContext instanceof Activity))
        {
          paramContext = (Activity)paramContext;
          paramContext.startActivityForResult(paramStructMsgForGeneralShare, 13005);
          paramContext.overridePendingTransition(2130772090, 2130772092);
        }
      }
      return;
      QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    catch (Exception paramStructMsgForGeneralShare)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = new JSONObject(paramString);
      if (paramQQAppInterface.optInt("enterVideoLayer") == 1)
      {
        paramContext = new StringBuilder();
        paramContext.append("[enterQzoneFullScreen] rays, qzShareMsg=");
        paramContext.append(paramQQAppInterface.toString());
        QLog.d("structmsg.StructMsgItemVideo", 2, paramContext.toString());
        paramQQAppInterface = a(paramQQAppInterface);
        BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("structmsg.StructMsgItemVideo", 1, "[enterQzoneFullScreen] rays", paramQQAppInterface);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readUTF();
    this.av = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.aw = Integer.parseInt(str);
    }
    catch (RuntimeException localRuntimeException)
    {
      label50:
      break label50;
    }
    this.aw = 0;
    if (this.a >= 7)
    {
      this.az = paramObjectInput.readUTF();
      this.aA = paramObjectInput.readUTF();
      this.aD = paramObjectInput.readInt();
      this.aE = paramObjectInput.readInt();
      this.aF = paramObjectInput.readInt();
      this.aG = paramObjectInput.readInt();
      this.aB = paramObjectInput.readUTF();
      this.aR = paramObjectInput.readInt();
    }
    if (this.a >= 8) {
      this.aO = paramObjectInput.readUTF();
    }
    if (this.a >= 9)
    {
      this.aZ = paramObjectInput.readUTF();
      this.ba = "1".equals(paramObjectInput.readUTF());
    }
    if (this.a >= 10) {
      this.aC = paramObjectInput.readInt();
    }
    if (this.a >= 11)
    {
      this.bb = paramObjectInput.readUTF();
      this.bc = paramObjectInput.readUTF();
      this.bd = paramObjectInput.readUTF();
    }
    if ((this.a >= 12) && (d()))
    {
      this.aP = paramObjectInput.readInt();
      this.aQ = paramObjectInput.readLong();
    }
    if (this.a >= 13)
    {
      this.s = paramObjectInput.readUTF();
      this.G = paramObjectInput.readUTF();
      this.t = paramObjectInput.readInt();
      this.u = paramObjectInput.readUTF();
      this.v = paramObjectInput.readUTF();
      this.w = paramObjectInput.readUTF();
      this.x = paramObjectInput.readUTF();
      this.y = paramObjectInput.readUTF();
      this.z = paramObjectInput.readInt();
      this.A = paramObjectInput.readUTF();
      this.B = paramObjectInput.readUTF();
      this.C = paramObjectInput.readUTF();
      this.D = paramObjectInput.readUTF();
      this.E = paramObjectInput.readUTF();
      this.F = paramObjectInput.readInt();
      this.H = paramObjectInput.readUTF();
      this.I = paramObjectInput.readUTF();
      this.J = paramObjectInput.readUTF();
      this.K = paramObjectInput.readUTF();
      this.L = paramObjectInput.readUTF();
      this.M = paramObjectInput.readUTF();
      this.N = paramObjectInput.readUTF();
      this.O = paramObjectInput.readUTF();
      this.T = paramObjectInput.readUTF();
      this.U = paramObjectInput.readUTF();
    }
    if (this.a >= 14) {
      this.P = paramObjectInput.readInt();
    }
    if (this.a >= 15)
    {
      this.V = paramObjectInput.readInt();
      this.W = paramObjectInput.readInt();
    }
    if (this.a >= 16)
    {
      this.X = paramObjectInput.readUTF();
      this.Y = paramObjectInput.readUTF();
      this.Z = paramObjectInput.readUTF();
      this.aa = paramObjectInput.readInt();
      this.ab = paramObjectInput.readInt();
      this.ac = paramObjectInput.readInt();
      this.ad = paramObjectInput.readInt();
      this.ae = paramObjectInput.readUTF();
      this.af = paramObjectInput.readUTF();
      this.ag = paramObjectInput.readUTF();
      this.ah = paramObjectInput.readUTF();
    }
    if (this.a >= 17) {
      this.ai = paramObjectInput.readUTF();
    }
    if (this.a >= 18)
    {
      this.aj = paramObjectInput.readUTF();
      this.ak = paramObjectInput.readUTF();
      this.be = paramObjectInput.readUTF();
    }
    if (QLog.isColorLevel())
    {
      paramObjectInput = new StringBuilder();
      paramObjectInput.append("readExternal[:");
      paramObjectInput.append("\n");
      paramObjectInput.append("mVersion:");
      paramObjectInput.append(this.a);
      paramObjectInput.append("\n");
      paramObjectInput.append("imgUrl:");
      paramObjectInput.append(this.au);
      paramObjectInput.append("\n");
      paramObjectInput.append("videoUrl:");
      paramObjectInput.append(this.av);
      paramObjectInput.append("\n");
      paramObjectInput.append("vInfo:");
      paramObjectInput.append(this.az);
      paramObjectInput.append("\n");
      paramObjectInput.append("tInfo:");
      paramObjectInput.append(this.aA);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewVideoTime:");
      paramObjectInput.append(this.aD);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewVideoWidth:");
      paramObjectInput.append(this.aE);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewVideoHeight:");
      paramObjectInput.append(this.aF);
      paramObjectInput.append("\n");
      paramObjectInput.append("type:");
      paramObjectInput.append(this.aR);
      paramObjectInput.append("\n");
      paramObjectInput.append("articleID:");
      paramObjectInput.append(this.aO);
      paramObjectInput.append("\n");
      paramObjectInput.append("jumpUrl:");
      paramObjectInput.append(this.aZ);
      paramObjectInput.append("\n");
      paramObjectInput.append("jump2Web:");
      paramObjectInput.append(this.ba);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewStartPosi:");
      paramObjectInput.append(this.aC);
      paramObjectInput.append("\n");
      if ((this.a >= 12) && (d()))
      {
        paramObjectInput.append("feedId:");
        paramObjectInput.append(this.aQ);
        paramObjectInput.append("\n");
        paramObjectInput.append("feedType:");
        paramObjectInput.append(this.aP);
        paramObjectInput.append("\n");
      }
      paramObjectInput.append("]:");
      paramObjectInput.append("\n");
      QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.au;
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    localObject = this.av;
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.aw);
    ((StringBuilder)localObject).append("");
    paramObjectOutput.writeUTF(((StringBuilder)localObject).toString());
    if (this.a >= 7)
    {
      localObject = this.az;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.aA;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.aD);
      paramObjectOutput.writeInt(this.aE);
      paramObjectOutput.writeInt(this.aF);
      paramObjectOutput.writeInt(this.aG);
      localObject = this.aB;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.aR);
    }
    if (this.a >= 8)
    {
      localObject = this.aO;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    int i = this.a;
    String str = "0";
    if (i >= 9)
    {
      localObject = this.aZ;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.ba) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.a >= 10) {
      paramObjectOutput.writeInt(this.aC);
    }
    if (this.a >= 11)
    {
      localObject = this.bb;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.bc;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.bd;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if ((this.a >= 12) && (d()))
    {
      paramObjectOutput.writeInt(this.aP);
      paramObjectOutput.writeLong(this.aQ);
    }
    if (this.a >= 13)
    {
      if (this.s != null) {
        localObject = this.s;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.G != null) {
        localObject = this.G;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.t);
      if (this.u == null) {
        localObject = "0";
      } else {
        localObject = this.u;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.v == null) {
        localObject = str;
      } else {
        localObject = this.v;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.w == null) {
        localObject = "";
      } else {
        localObject = this.w;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.x == null) {
        localObject = "";
      } else {
        localObject = this.x;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.y == null) {
        localObject = "";
      } else {
        localObject = this.y;
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.z);
      if (this.A == null) {
        localObject = "";
      } else {
        localObject = this.A;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.B == null) {
        localObject = "";
      } else {
        localObject = this.B;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.C == null) {
        localObject = "";
      } else {
        localObject = this.C;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.D == null) {
        localObject = "";
      } else {
        localObject = this.D;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.E == null) {
        localObject = "";
      } else {
        localObject = this.E;
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.F);
      if (this.H == null) {
        localObject = "";
      } else {
        localObject = this.H;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.I == null) {
        localObject = "";
      } else {
        localObject = this.I;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.J == null) {
        localObject = "";
      } else {
        localObject = this.J;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.K == null) {
        localObject = "";
      } else {
        localObject = this.K;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.L == null) {
        localObject = "";
      } else {
        localObject = this.L;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.M == null) {
        localObject = "";
      } else {
        localObject = this.M;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.N == null) {
        localObject = "";
      } else {
        localObject = this.N;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.O == null) {
        localObject = "";
      } else {
        localObject = this.O;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.T == null) {
        localObject = "";
      } else {
        localObject = this.T;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.U == null) {
        localObject = "";
      } else {
        localObject = this.U;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.a >= 14) {
      paramObjectOutput.writeInt(this.P);
    }
    if (this.a >= 15)
    {
      paramObjectOutput.writeInt(this.V);
      paramObjectOutput.writeInt(this.W);
    }
    if (this.a >= 16)
    {
      if (this.X == null) {
        localObject = "";
      } else {
        localObject = this.X;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.Y == null) {
        localObject = "";
      } else {
        localObject = this.Y;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.Z == null) {
        localObject = "";
      } else {
        localObject = this.Z;
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.aa);
      paramObjectOutput.writeInt(this.ab);
      paramObjectOutput.writeInt(this.ac);
      paramObjectOutput.writeInt(this.ad);
      if (this.ae == null) {
        localObject = "";
      } else {
        localObject = this.ae;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.af == null) {
        localObject = "";
      } else {
        localObject = this.af;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.ag == null) {
        localObject = "";
      } else {
        localObject = this.ag;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.ah == null) {
        localObject = "";
      } else {
        localObject = this.ah;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.a >= 17)
    {
      if (this.ai == null) {
        localObject = "";
      } else {
        localObject = this.ai;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.a >= 18)
    {
      if (this.aj == null) {
        localObject = "";
      } else {
        localObject = this.aj;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.ak == null) {
        localObject = "";
      } else {
        localObject = this.ak;
      }
      paramObjectOutput.writeUTF((String)localObject);
      str = this.be;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.au)) {
      paramXmlSerializer.attribute(null, "cover", this.au);
    }
    if (!TextUtils.isEmpty(this.av)) {
      paramXmlSerializer.attribute(null, "src", this.av);
    }
    if (!TextUtils.isEmpty(this.az)) {
      paramXmlSerializer.attribute(null, "vInfo", this.az);
    }
    if (!TextUtils.isEmpty(this.aA)) {
      paramXmlSerializer.attribute(null, "tInfo", this.aA);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.aC));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.aD));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.aE));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.aF));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.aG));
    if (!TextUtils.isEmpty(this.aB)) {
      paramXmlSerializer.attribute(null, "summary", this.aB);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.aR));
    if (!TextUtils.isEmpty(this.aO)) {
      paramXmlSerializer.attribute(null, "aID", this.aO);
    }
    Object localObject;
    if (this.aw == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.aw);
      ((StringBuilder)localObject).append("");
      paramXmlSerializer.attribute(null, "load", ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.aZ)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.aZ);
    }
    if (this.ba) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    paramXmlSerializer.attribute(null, "isJump2Web", (String)localObject);
    if (!TextUtils.isEmpty(this.bb)) {
      paramXmlSerializer.attribute(null, "apurl", this.bb);
    }
    if (!TextUtils.isEmpty(this.bc)) {
      paramXmlSerializer.attribute(null, "rl", this.bc);
    }
    if (!TextUtils.isEmpty(this.bd)) {
      paramXmlSerializer.attribute(null, "disType", this.bd);
    }
    long l = this.aQ;
    if (l != 0L) {
      paramXmlSerializer.attribute(null, "feedId", String.valueOf(l));
    }
    int i = this.aP;
    if (i != 0) {
      paramXmlSerializer.attribute(null, "feedType", String.valueOf(i));
    }
    if (this.t != 0) {
      paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.t));
    }
    if (!TextUtils.isEmpty(this.u)) {
      paramXmlSerializer.attribute(null, "advertiser_id", this.u);
    }
    if (!TextUtils.isEmpty(this.v)) {
      paramXmlSerializer.attribute(null, "aid", this.v);
    }
    if (!TextUtils.isEmpty(this.w)) {
      paramXmlSerializer.attribute(null, "app_download_schema", this.w);
    }
    if (!TextUtils.isEmpty(this.x)) {
      paramXmlSerializer.attribute(null, "canvas_json", this.x);
    }
    if (!TextUtils.isEmpty(this.y)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.y);
    }
    if (this.z != 0) {
      paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.z));
    }
    if (!TextUtils.isEmpty(this.A)) {
      paramXmlSerializer.attribute(null, "effect_url", this.A);
    }
    if (!TextUtils.isEmpty(this.B)) {
      paramXmlSerializer.attribute(null, "landing_page", this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      paramXmlSerializer.attribute(null, "landing_page_report_url", this.C);
    }
    if (!TextUtils.isEmpty(this.D)) {
      paramXmlSerializer.attribute(null, "noco_id", this.D);
    }
    if (!TextUtils.isEmpty(this.E)) {
      paramXmlSerializer.attribute(null, "product_id", this.E);
    }
    if (!TextUtils.isEmpty(this.s)) {
      paramXmlSerializer.attribute(null, "apurl", this.s);
    }
    if (this.F != 0) {
      paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.F));
    }
    if (this.P != 0) {
      paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.P));
    }
    if (!TextUtils.isEmpty(this.G)) {
      paramXmlSerializer.attribute(null, "rl", this.G);
    }
    if (!TextUtils.isEmpty(this.H)) {
      paramXmlSerializer.attribute(null, "subordinate_product_id", this.H);
    }
    if (!TextUtils.isEmpty(this.I)) {
      paramXmlSerializer.attribute(null, "traceid", this.I);
    }
    if (!TextUtils.isEmpty(this.J)) {
      paramXmlSerializer.attribute(null, "via", this.J);
    }
    if (!TextUtils.isEmpty(this.K)) {
      paramXmlSerializer.attribute(null, "video_url", this.K);
    }
    if (!TextUtils.isEmpty(this.L)) {
      paramXmlSerializer.attribute(null, "appname", this.L);
    }
    if (!TextUtils.isEmpty(this.M)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.M);
    }
    if (!TextUtils.isEmpty(this.N)) {
      paramXmlSerializer.attribute(null, "pkg_name", this.N);
    }
    if (!TextUtils.isEmpty(this.O)) {
      paramXmlSerializer.attribute(null, "pkgurl", this.O);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "corporate_image_name", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "corporate_logo", this.U);
    }
    if (this.V != 0) {
      paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.V));
    }
    if (this.W != 0) {
      paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.W));
    }
    if (!TextUtils.isEmpty(this.X)) {
      paramXmlSerializer.attribute(null, "negative_feedback_url", this.X);
    }
    if (!TextUtils.isEmpty(this.Y)) {
      paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Y);
    }
    if (!TextUtils.isEmpty(this.Z)) {
      paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Z);
    }
    if (this.aa != 0) {
      paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.aa));
    }
    if (this.ab != 0) {
      paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.ab));
    }
    if (this.ac != 0) {
      paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.ac));
    }
    if (this.ad != 0) {
      paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.ad));
    }
    if (!TextUtils.isEmpty(this.ae)) {
      paramXmlSerializer.attribute(null, "universal_link", this.ae);
    }
    if (!TextUtils.isEmpty(this.af)) {
      paramXmlSerializer.attribute(null, "sdk_data", this.af);
    }
    if (!TextUtils.isEmpty(this.ag)) {
      paramXmlSerializer.attribute(null, "tencent_video_id", this.ag);
    }
    if (!TextUtils.isEmpty(this.ah)) {
      paramXmlSerializer.attribute(null, "view_id", this.ah);
    }
    if (!TextUtils.isEmpty(this.ai)) {
      paramXmlSerializer.attribute(null, "qgg_ext", this.ai);
    }
    if (!TextUtils.isEmpty(this.aj)) {
      paramXmlSerializer.attribute(null, "adInfo", this.aj);
    }
    if (!TextUtils.isEmpty(this.ak)) {
      paramXmlSerializer.attribute(null, "is_report_click", this.ak);
    }
    if (!TextUtils.isEmpty(this.be)) {
      paramXmlSerializer.attribute(null, "noAutoPlay", this.be);
    }
    paramXmlSerializer.endTag(null, "video");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.au = paramStructMsgNode.a("cover");
    this.av = paramStructMsgNode.a("src");
    Object localObject1 = paramStructMsgNode.a("load");
    this.az = paramStructMsgNode.a("vInfo");
    this.aA = paramStructMsgNode.a("tInfo");
    Object localObject2 = paramStructMsgNode.a("preTime");
    if (localObject2 != null) {}
    label141:
    try
    {
      this.aD = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException10)
    {
      label84:
      break label84;
    }
    try
    {
      this.aD = ((int)Float.valueOf((String)localObject2).floatValue());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fromXml parse previewVideoTimeStr: previewVideoTime = ");
        ((StringBuilder)localObject2).append(this.aD);
        QLog.d("structmsg.StructMsgItemVideo", 2, ((StringBuilder)localObject2).toString());
      }
    }
    catch (Exception localException5)
    {
      break label141;
    }
    localObject2 = paramStructMsgNode.a("preWidth");
    if (localObject2 != null) {}
    label279:
    try
    {
      this.aE = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException6)
    {
      label167:
      label193:
      label219:
      label248:
      break label167;
    }
    localObject2 = paramStructMsgNode.a("preHeight");
    if (localObject2 != null) {}
    try
    {
      this.aF = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException7)
    {
      break label193;
    }
    localObject2 = paramStructMsgNode.a("fullTime");
    if (localObject2 != null) {}
    try
    {
      this.aG = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException8)
    {
      break label219;
    }
    this.aB = paramStructMsgNode.a("summary");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.aw = Integer.parseInt((String)localObject1);
    }
    catch (RuntimeException localRuntimeException)
    {
      break label248;
    }
    this.aw = 0;
    localObject1 = paramStructMsgNode.a("busiType");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.aR = Integer.parseInt((String)localObject1);
    }
    catch (Exception localException1)
    {
      break label279;
    }
    this.aO = paramStructMsgNode.a("aID");
    this.aZ = paramStructMsgNode.a("jumpUrl");
    this.ba = "1".equals(paramStructMsgNode.a("isJump2Web"));
    localObject1 = paramStructMsgNode.a("preStartPosi");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    label404:
    try
    {
      this.aC = Integer.valueOf((String)localObject1).intValue();
    }
    catch (Exception localException9)
    {
      label347:
      break label347;
    }
    try
    {
      this.aC = ((int)Float.valueOf((String)localObject1).floatValue());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fromXml parse previewStartPosiStr: previewStartPosi = ");
        ((StringBuilder)localObject1).append(this.aC);
        QLog.d("structmsg.StructMsgItemVideo", 2, ((StringBuilder)localObject1).toString());
      }
    }
    catch (Exception localException2)
    {
      break label404;
    }
    this.bb = paramStructMsgNode.a("apurl");
    this.bc = paramStructMsgNode.a("rl");
    this.bd = paramStructMsgNode.a("disType");
    localObject1 = paramStructMsgNode.a("feedId");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.aQ = Long.parseLong((String)localObject1);
    }
    catch (Exception localException3)
    {
      label463:
      break label463;
    }
    if (QLog.isColorLevel()) {
      QLog.d("structmsg.StructMsgItemVideo", 2, "error while feedIdStr to feedId Long!");
    }
    localObject1 = paramStructMsgNode.a("feedType");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.aP = Integer.parseInt((String)localObject1);
    }
    catch (Exception localException4)
    {
      label505:
      break label505;
    }
    if (QLog.isColorLevel()) {
      QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
    }
    if (this.a >= 13)
    {
      localObject1 = paramStructMsgNode.a("action_type");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.t = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label556:
      break label556;
    }
    this.t = 0;
    localObject1 = paramStructMsgNode.a("dest_type");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.z = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label587:
      break label587;
    }
    this.z = 0;
    localObject1 = paramStructMsgNode.a("product_type");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.F = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      label618:
      break label618;
    }
    this.F = 0;
    this.u = paramStructMsgNode.a("advertiser_id");
    this.v = paramStructMsgNode.a("aid");
    this.w = paramStructMsgNode.a("app_download_schema");
    this.x = paramStructMsgNode.a("canvas_json");
    this.y = paramStructMsgNode.a("customized_invoke_url");
    this.A = paramStructMsgNode.a("effect_url");
    this.B = paramStructMsgNode.a("landing_page");
    this.C = paramStructMsgNode.a("landing_page_report_url");
    this.D = paramStructMsgNode.a("noco_id");
    this.E = paramStructMsgNode.a("product_id");
    this.H = paramStructMsgNode.a("subordinate_product_id");
    this.I = paramStructMsgNode.a("traceid");
    this.J = paramStructMsgNode.a("via");
    this.K = paramStructMsgNode.a("video_url");
    this.L = paramStructMsgNode.a("appname");
    this.M = paramStructMsgNode.a("customized_invoke_url");
    this.N = paramStructMsgNode.a("pkg_name");
    this.O = paramStructMsgNode.a("pkgurl");
    this.G = paramStructMsgNode.a("rl");
    this.s = paramStructMsgNode.a("apurl");
    this.T = paramStructMsgNode.a("corporate_image_name");
    this.U = paramStructMsgNode.a("corporate_logo");
    if (this.a >= 14)
    {
      localObject1 = paramStructMsgNode.a("mini_program_type");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.P = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      label900:
      label965:
      break label900;
    }
    this.P = 0;
    if ((paramStructMsgNode.e != null) && (paramStructMsgNode.e.e != null))
    {
      localObject1 = paramStructMsgNode.e.e;
      if (this.a >= 15)
      {
        localObject2 = ((StructMsgNode)localObject1).a("tab_id");
        if (StringUtil.isEmpty((String)localObject2)) {}
      }
    }
    try
    {
      this.V = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException5)
    {
      break label965;
    }
    this.V = 0;
    localObject2 = ((StructMsgNode)localObject1).a("is_hidden");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    label1069:
    try
    {
      this.W = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      label996:
      break label996;
    }
    this.W = 0;
    if (this.a >= 16)
    {
      this.X = ((StructMsgNode)localObject1).a("negative_feedback_url");
      this.Y = ((StructMsgNode)localObject1).a("sdk_exposure_monitor_url");
      this.Z = ((StructMsgNode)localObject1).a("sdk_click_monitor_url");
      localObject2 = ((StructMsgNode)localObject1).a("media_duration");
      if (StringUtil.isEmpty((String)localObject2)) {}
    }
    try
    {
      this.aa = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException7)
    {
      break label1069;
    }
    this.aa = 0;
    localObject2 = ((StructMsgNode)localObject1).a("video_file_size");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    try
    {
      this.ab = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException8)
    {
      label1100:
      break label1100;
    }
    this.ab = 0;
    localObject2 = ((StructMsgNode)localObject1).a("app_score_num");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    label1162:
    try
    {
      this.ac = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException9)
    {
      label1131:
      break label1131;
    }
    this.ac = 0;
    localObject2 = ((StructMsgNode)localObject1).a("download_num");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    try
    {
      this.ad = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException10)
    {
      break label1162;
    }
    this.ad = 0;
    this.ae = ((StructMsgNode)localObject1).a("universal_link");
    this.af = ((StructMsgNode)localObject1).a("sdk_data");
    this.ag = ((StructMsgNode)localObject1).a("tencent_video_id");
    this.ah = ((StructMsgNode)localObject1).a("view_id");
    if (this.a >= 17) {
      this.ai = ((StructMsgNode)localObject1).a("qgg_ext");
    }
    if (this.a >= 18)
    {
      this.aj = ((StructMsgNode)localObject1).a("adInfo");
      this.ak = ((StructMsgNode)localObject1).a("is_report_click");
    }
    if (this.a >= 18) {
      this.be = paramStructMsgNode.a("noAutoPlay");
    }
    return true;
  }
  
  protected View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramContext.getResources();
    boolean bool2 = paramBundle.getBoolean("has_cnr");
    bool1 = false;
    int i;
    if (bool2) {
      i = AIOUtils.b(URLDrawableHelper.getRoundCorner(), (Resources)localObject1);
    } else {
      i = 0;
    }
    ((Resources)localObject1).getDisplayMetrics();
    int j = paramBundle.getInt("v_height");
    TitledImageView localTitledImageView;
    if ((paramView != null) && ((paramView instanceof TitledImageView)))
    {
      localTitledImageView = (TitledImageView)paramView;
    }
    else
    {
      localTitledImageView = new TitledImageView(paramContext);
      localTitledImageView.setId(2131435545);
      localTitledImageView.setContentDescription(((Resources)localObject1).getString(2131892235));
      localTitledImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localTitledImageView.setContentDescription(((Resources)localObject1).getText(2131916810));
      paramView = localTitledImageView;
    }
    localTitledImageView.setImageResource(2130847049);
    localTitledImageView.setTag(this);
    localObject1 = null;
    try
    {
      localObject2 = new RoundedColorDrawable(-16777216, j, j, i);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2;
      label168:
      break label168;
    }
    if (TextUtils.isEmpty(this.au)) {
      localTitledImageView.setBackgroundDrawable((Drawable)localObject1);
    }
    try
    {
      localObject2 = URLDrawable.getDrawable(this.au, j, j, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label311;
      }
      if (paramBundle.getBoolean("has_cnr")) {
        ((URLDrawable)localObject2).setDecodeHandler(new StructMsgItemVideo.CornerDecoder(this, i, j, j));
      }
      if (AbsDownloader.hasFile(this.au)) {
        break label414;
      }
      if (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        continue;
        bool1 = true;
      }
    }
    ((URLDrawable)localObject2).setAutoDownload(bool1);
    if (((URLDrawable)localObject2).getStatus() == 1)
    {
      localTitledImageView.setBackgroundDrawable((Drawable)localObject2);
    }
    else
    {
      localTitledImageView.setURLDrawableDownListener(this.bh);
      localTitledImageView.setBackgroundDrawable((Drawable)localObject2);
      break label311;
      localTitledImageView.setBackgroundDrawable((Drawable)localObject1);
    }
    label311:
    if (this.ar != null)
    {
      localTitledImageView.setOnLongClickListener((View.OnLongClickListener)this.ar.get());
      localTitledImageView.setOnTouchListener((View.OnTouchListener)this.ar.get());
    }
    localTitledImageView.setOnClickListener(this.bg);
    localTitledImageView.setOnClickListener(this.bg);
    if (this.ar != null)
    {
      localTitledImageView.setOnLongClickListener((View.OnLongClickListener)this.ar.get());
      localTitledImageView.setOnTouchListener((View.OnTouchListener)this.ar.get());
    }
    return paramView;
  }
  
  public String b()
  {
    return "video";
  }
  
  public boolean c()
  {
    int i = this.aR;
    return (i >= 1) && (i <= 100);
  }
  
  public boolean d()
  {
    return this.aR == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo
 * JD-Core Version:    0.7.0.1
 */