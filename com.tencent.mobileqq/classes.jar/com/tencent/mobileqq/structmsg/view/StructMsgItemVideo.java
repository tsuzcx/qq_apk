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
  protected View.OnClickListener a;
  private URLDrawableDownListener.Adapter a;
  public StructMsgItemVideo.UIHandler a;
  public boolean a;
  public String ac = null;
  public String ad = null;
  public String ae = null;
  public String af = null;
  public String ag = null;
  public String ah;
  public String ai;
  public String aj;
  public String ak;
  String al = "";
  String am = "";
  String as = "";
  String at = "";
  String au;
  String av;
  String aw;
  public String ax;
  public String ay = "";
  private View.OnClickListener b;
  public boolean b;
  public long c;
  public boolean c;
  boolean d;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public int u;
  public int v = 0;
  
  public StructMsgItemVideo()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$UIHandler = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new StructMsgItemVideo.1(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemVideo.2(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemVideo.4(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.jdField_a_of_type_Int = 18;
  }
  
  public StructMsgItemVideo(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$UIHandler = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new StructMsgItemVideo.1(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemVideo.2(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemVideo.4(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.ac = paramString1;
    this.v = paramInt1;
    this.ae = paramString2;
    this.af = paramString3;
    this.ag = paramString4;
    this.q = paramInt2;
    this.p = paramInt3;
    this.r = paramInt4;
    this.s = paramInt5;
    this.t = paramInt6;
    this.ah = paramString5;
    this.ai = paramString6;
    this.aj = paramString7;
    this.jdField_c_of_type_Long = paramLong;
    this.u = paramInt7;
    this.jdField_a_of_type_Int = 18;
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
    paramJSONObject.videoInfo.coverUrl = new PictureUrl(this.ac, this.r, this.s);
    paramJSONObject.videoInfo.originVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.videoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.videoRemark = new VideoInfo.VideoRemark();
    if ("0".equals(str4)) {
      paramJSONObject.videoInfo.videoRemark.orgwebsite = 0;
    } else {
      paramJSONObject.videoInfo.videoRemark.orgwebsite = 1;
    }
    paramJSONObject.videoInfo.width = this.r;
    paramJSONObject.videoInfo.height = this.s;
    paramJSONObject.videoInfo.videoId = str2;
    paramJSONObject.videoInfo.videoTime = this.t;
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
  
  private void a()
  {
    try
    {
      if (!((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(this.Y))
      {
        IEcshopAdHandler.ReportInfo localReportInfo = new IEcshopAdHandler.ReportInfo();
        localReportInfo.jdField_a_of_type_Int = 3;
        localReportInfo.f = 1;
        localReportInfo = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam(localReportInfo, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
        ((IEcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(localReportInfo, null);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(Context paramContext)
  {
    if (!TextUtils.isEmpty(b()))
    {
      if ((!b().startsWith("http://")) && (!b().startsWith("https://"))) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", b());
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, b());
      paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
      paramContext.extra().putAll(localIntent.getExtras());
      QRoute.startUri(paramContext, null);
      if (!TextUtils.isEmpty(b()))
      {
        paramContext = CGILoader.a(b());
        if (!TextUtils.isEmpty(paramContext)) {
          ReportController.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
        }
      }
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.o == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839399);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$UIHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$UIHandler = new StructMsgItemVideo.UIHandler(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.ad);
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
    if (!TextUtils.isEmpty(b()))
    {
      paramContext = CGILoader.a(b());
      if (!TextUtils.isEmpty(paramContext)) {
        ReportController.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
      }
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl;
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
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
      return null;
    }
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    if (a())
    {
      paramBundle.putBoolean("is_public_account_video_msg", true);
      this.jdField_a_of_type_Boolean = true;
      this.ak = paramBundle.getString("public_account_video_title");
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4) ^ true;
    if (!this.jdField_a_of_type_Boolean) {
      return b(paramContext, paramView, paramBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN") != null) {
        this.ah = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      } else {
        this.ah = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      }
      if (paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME") != null) {
        this.ai = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      } else {
        this.ai = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName);
      }
      this.al = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.am = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.as = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.at = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
    }
    Object localObject1 = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      if (paramView.getTag(2131377982) != null)
      {
        paramContext = paramView.getTag(2131377982);
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
    localPAVideoView.setId(2131377982);
    localPAVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localPAVideoView.setContentDescription(((Resources)localObject1).getText(2131719258));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int j;
    if (bool1)
    {
      localPAVideoView.setRadius(15.0F);
      localPAVideoView.b(true);
      localPAVideoView.d(true);
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
        localPAVideoView.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      i = this.r;
      j = this.s;
      if (i >= j)
      {
        localPAVideoView.f = PAVideoView.e;
        localPAVideoView.jdField_c_of_type_Boolean = true;
        localPAVideoView.i = true;
      }
      else
      {
        localPAVideoView.i = false;
        localPAVideoView.jdField_c_of_type_Boolean = false;
        localObject3 = ShortVideoUtils.adjustSize(i, j);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
      }
    }
    else
    {
      if (!this.jdField_c_of_type_Boolean) {
        localPAVideoView.setRadiusTop(5.0F);
      } else {
        localPAVideoView.setRadius(5.0F);
      }
      localPAVideoView.i = true;
      localPAVideoView.jdField_c_of_type_Boolean = false;
      localPAVideoView.b(true);
      localPAVideoView.d(false);
      i = this.r;
      j = this.s;
      if (i < j) {
        localPAVideoView.f = PAVideoView.jdField_d_of_type_Int;
      } else if (i > j) {
        localPAVideoView.f = PAVideoView.jdField_c_of_type_Int;
      } else if ((i == j) && (i != 0) && (j != 0))
      {
        if (bool1) {
          localPAVideoView.f = PAVideoView.e;
        } else {
          localPAVideoView.f = PAVideoView.jdField_d_of_type_Int;
        }
      }
      else {
        localPAVideoView.f = PAVideoView.jdField_c_of_type_Int;
      }
    }
    paramView.addView(localPAVideoView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(paramContext);
    ((ImageView)localObject2).setImageResource(2130843373);
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
      if (localPAVideoView.jdField_d_of_type_Boolean) {
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
      } else {
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
      }
    }
    paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new LinearLayout(paramContext);
    ((LinearLayout)localObject3).setHorizontalGravity(0);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131377982);
    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131377982);
    ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131377982);
    if (bool1) {
      i = AIOUtils.b(7.0F, (Resources)localObject1);
    } else {
      i = AIOUtils.b(12.0F, (Resources)localObject1);
    }
    int k;
    if (bool1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend()))
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
    ((TextView)localObject4).setId(2131377981);
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
    ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = localPAVideoView;
    ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
    ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    ((StructMsgItemVideo.Holder)localObject5).b = ((TextView)localObject1);
    ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
    paramView.setTag(2131377982, localObject5);
    paramView.setTag(this);
    ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (StructMsgItemVideo.Holder)localObject5);
    boolean bool2 = b(paramContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
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
      paramContext.append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq);
      paramContext.append("\n, autoPlay = ");
      paramContext.append(bool2);
      paramContext.append(", vid = ");
      paramContext.append(this.ae);
      QLog.d("structmsg.StructMsgItemVideo", 2, paramContext.toString());
    }
    if ((bool2) && (this.v != 4)) {
      ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.f();
    } else {
      ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
    }
    if (this.q > 0) {
      ((StructMsgItemVideo.Holder)localObject5).b.setText(ShortVideoUtils.stringForTime(this.q * 1000));
    }
    if (!TextUtils.isEmpty(this.au)) {
      paramView.setTag(2131377989, this.au);
    }
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) && (!AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message, "0X800B375")))
    {
      paramContext = ((IVideoR5BuilderFactory)QRoute.api(IVideoR5BuilderFactory.class)).create(null, null, this.ae, this.aj).a(this.aj).a(bool2).b(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isStructMsgJumpForUG(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg)).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B375", "0X800B375", 0, 0, "", "", "", paramContext, false);
      AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message, "0X800B375");
    }
    return paramView;
  }
  
  public String a()
  {
    return "video";
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    Bundle localBundle;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramStructMsgForGeneralShare != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
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
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.ah);
        if (this.v > 1) {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.at);
        } else {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.ai);
        }
        localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl)) {
          localBundle.putString("RED_PACKET_ID", Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl).getQueryParameter("redpackid"));
        }
        bool1 = TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime);
        bool2 = false;
        if ((!bool1) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {
          localObject1 = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));
        } else {
          localObject1 = paramStructMsgForGeneralShare.mCreateTime;
        }
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject1);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.t));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.r));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.s));
        localBundle.putString("VIDEO_VID", this.af);
        localBundle.putString("VIDEO_COVER", this.ac);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.aj);
        localBundle.putString("VIDEO_TITLE", this.ak);
        int i = this.v;
        if ((i != 2) && (i != 3)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.v);
        if (b())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.u);
          localBundle.putLong("VIDEO_FEED_ID", this.jdField_c_of_type_Long);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.al);
          localBundle.putString("VIDEO_THIRD_NAME", this.am);
          localBundle.putString("VIDEO_THIRD_ACTION", this.as);
          if (this.v == 2) {
            localBundle.putString("VIDEO_THIRD_URL", ((IThirdVideoManager)QRoute.api(IThirdVideoManager.class)).getUrlByVid(this.af));
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin;
          String str = this.ae;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.v);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X8006830", "0X8006830", 0, 0, str, (String)localObject2, localStringBuilder.toString(), "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 33);
        localObject1 = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(HardCodeUtil.a(2131716548)))) && (((AladdinConfig)localObject1).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (((IReadInJoyFloatingWindowHelper)QRoute.api(IReadInJoyFloatingWindowHelper.class)).openFloatLayerVideo(paramContext, this.aj, localBundle))) {
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
          ((Activity)paramContext).overridePendingTransition(2130772065, 2130772067);
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
          paramContext.overridePendingTransition(2130772065, 2130772067);
        }
      }
      return;
      QQToast.a(paramContext, 2131695889, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
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
    this.ac = paramObjectInput.readUTF();
    this.ad = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.o = Integer.parseInt(str);
    }
    catch (RuntimeException localRuntimeException)
    {
      label50:
      break label50;
    }
    this.o = 0;
    if (this.jdField_a_of_type_Int >= 7)
    {
      this.ae = paramObjectInput.readUTF();
      this.af = paramObjectInput.readUTF();
      this.q = paramObjectInput.readInt();
      this.r = paramObjectInput.readInt();
      this.s = paramObjectInput.readInt();
      this.t = paramObjectInput.readInt();
      this.ag = paramObjectInput.readUTF();
      this.v = paramObjectInput.readInt();
    }
    if (this.jdField_a_of_type_Int >= 8) {
      this.aj = paramObjectInput.readUTF();
    }
    if (this.jdField_a_of_type_Int >= 9)
    {
      this.au = paramObjectInput.readUTF();
      this.jdField_d_of_type_Boolean = "1".equals(paramObjectInput.readUTF());
    }
    if (this.jdField_a_of_type_Int >= 10) {
      this.p = paramObjectInput.readInt();
    }
    if (this.jdField_a_of_type_Int >= 11)
    {
      this.av = paramObjectInput.readUTF();
      this.aw = paramObjectInput.readUTF();
      this.ax = paramObjectInput.readUTF();
    }
    if ((this.jdField_a_of_type_Int >= 12) && (b()))
    {
      this.u = paramObjectInput.readInt();
      this.jdField_c_of_type_Long = paramObjectInput.readLong();
    }
    if (this.jdField_a_of_type_Int >= 13)
    {
      this.q = paramObjectInput.readUTF();
      this.B = paramObjectInput.readUTF();
      this.jdField_c_of_type_Int = paramObjectInput.readInt();
      this.r = paramObjectInput.readUTF();
      this.s = paramObjectInput.readUTF();
      this.t = paramObjectInput.readUTF();
      this.u = paramObjectInput.readUTF();
      this.v = paramObjectInput.readUTF();
      this.jdField_d_of_type_Int = paramObjectInput.readInt();
      this.w = paramObjectInput.readUTF();
      this.x = paramObjectInput.readUTF();
      this.y = paramObjectInput.readUTF();
      this.z = paramObjectInput.readUTF();
      this.A = paramObjectInput.readUTF();
      this.e = paramObjectInput.readInt();
      this.C = paramObjectInput.readUTF();
      this.D = paramObjectInput.readUTF();
      this.E = paramObjectInput.readUTF();
      this.F = paramObjectInput.readUTF();
      this.G = paramObjectInput.readUTF();
      this.H = paramObjectInput.readUTF();
      this.I = paramObjectInput.readUTF();
      this.J = paramObjectInput.readUTF();
      this.N = paramObjectInput.readUTF();
      this.O = paramObjectInput.readUTF();
    }
    if (this.jdField_a_of_type_Int >= 14) {
      this.f = paramObjectInput.readInt();
    }
    if (this.jdField_a_of_type_Int >= 15)
    {
      this.g = paramObjectInput.readInt();
      this.h = paramObjectInput.readInt();
    }
    if (this.jdField_a_of_type_Int >= 16)
    {
      this.P = paramObjectInput.readUTF();
      this.Q = paramObjectInput.readUTF();
      this.R = paramObjectInput.readUTF();
      this.i = paramObjectInput.readInt();
      this.j = paramObjectInput.readInt();
      this.k = paramObjectInput.readInt();
      this.l = paramObjectInput.readInt();
      this.S = paramObjectInput.readUTF();
      this.T = paramObjectInput.readUTF();
      this.U = paramObjectInput.readUTF();
      this.V = paramObjectInput.readUTF();
    }
    if (this.jdField_a_of_type_Int >= 17) {
      this.W = paramObjectInput.readUTF();
    }
    if (this.jdField_a_of_type_Int >= 18)
    {
      this.X = paramObjectInput.readUTF();
      this.Y = paramObjectInput.readUTF();
      this.ay = paramObjectInput.readUTF();
    }
    if (QLog.isColorLevel())
    {
      paramObjectInput = new StringBuilder();
      paramObjectInput.append("readExternal[:");
      paramObjectInput.append("\n");
      paramObjectInput.append("mVersion:");
      paramObjectInput.append(this.jdField_a_of_type_Int);
      paramObjectInput.append("\n");
      paramObjectInput.append("imgUrl:");
      paramObjectInput.append(this.ac);
      paramObjectInput.append("\n");
      paramObjectInput.append("videoUrl:");
      paramObjectInput.append(this.ad);
      paramObjectInput.append("\n");
      paramObjectInput.append("vInfo:");
      paramObjectInput.append(this.ae);
      paramObjectInput.append("\n");
      paramObjectInput.append("tInfo:");
      paramObjectInput.append(this.af);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewVideoTime:");
      paramObjectInput.append(this.q);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewVideoWidth:");
      paramObjectInput.append(this.r);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewVideoHeight:");
      paramObjectInput.append(this.s);
      paramObjectInput.append("\n");
      paramObjectInput.append("type:");
      paramObjectInput.append(this.v);
      paramObjectInput.append("\n");
      paramObjectInput.append("articleID:");
      paramObjectInput.append(this.aj);
      paramObjectInput.append("\n");
      paramObjectInput.append("jumpUrl:");
      paramObjectInput.append(this.au);
      paramObjectInput.append("\n");
      paramObjectInput.append("jump2Web:");
      paramObjectInput.append(this.jdField_d_of_type_Boolean);
      paramObjectInput.append("\n");
      paramObjectInput.append("previewStartPosi:");
      paramObjectInput.append(this.p);
      paramObjectInput.append("\n");
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        paramObjectInput.append("feedId:");
        paramObjectInput.append(this.jdField_c_of_type_Long);
        paramObjectInput.append("\n");
        paramObjectInput.append("feedType:");
        paramObjectInput.append(this.u);
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
    Object localObject = this.ac;
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    localObject = this.ad;
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append("");
    paramObjectOutput.writeUTF(((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int >= 7)
    {
      localObject = this.ae;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.af;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.q);
      paramObjectOutput.writeInt(this.r);
      paramObjectOutput.writeInt(this.s);
      paramObjectOutput.writeInt(this.t);
      localObject = this.ag;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.v);
    }
    if (this.jdField_a_of_type_Int >= 8)
    {
      localObject = this.aj;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    int i = this.jdField_a_of_type_Int;
    String str = "0";
    if (i >= 9)
    {
      localObject = this.au;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_d_of_type_Boolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.jdField_a_of_type_Int >= 10) {
      paramObjectOutput.writeInt(this.p);
    }
    if (this.jdField_a_of_type_Int >= 11)
    {
      localObject = this.av;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.aw;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.ax;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if ((this.jdField_a_of_type_Int >= 12) && (b()))
    {
      paramObjectOutput.writeInt(this.u);
      paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
    }
    if (this.jdField_a_of_type_Int >= 13)
    {
      if (this.q != null) {
        localObject = this.q;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.B != null) {
        localObject = this.B;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
      if (this.r == null) {
        localObject = "0";
      } else {
        localObject = this.r;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.s == null) {
        localObject = str;
      } else {
        localObject = this.s;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.t == null) {
        localObject = "";
      } else {
        localObject = this.t;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.u == null) {
        localObject = "";
      } else {
        localObject = this.u;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.v == null) {
        localObject = "";
      } else {
        localObject = this.v;
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
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
      if (this.z == null) {
        localObject = "";
      } else {
        localObject = this.z;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.A == null) {
        localObject = "";
      } else {
        localObject = this.A;
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.e);
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
      if (this.F == null) {
        localObject = "";
      } else {
        localObject = this.F;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.G == null) {
        localObject = "";
      } else {
        localObject = this.G;
      }
      paramObjectOutput.writeUTF((String)localObject);
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
    }
    if (this.jdField_a_of_type_Int >= 14) {
      paramObjectOutput.writeInt(this.f);
    }
    if (this.jdField_a_of_type_Int >= 15)
    {
      paramObjectOutput.writeInt(this.g);
      paramObjectOutput.writeInt(this.h);
    }
    if (this.jdField_a_of_type_Int >= 16)
    {
      if (this.P == null) {
        localObject = "";
      } else {
        localObject = this.P;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.Q == null) {
        localObject = "";
      } else {
        localObject = this.Q;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.R == null) {
        localObject = "";
      } else {
        localObject = this.R;
      }
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.i);
      paramObjectOutput.writeInt(this.j);
      paramObjectOutput.writeInt(this.k);
      paramObjectOutput.writeInt(this.l);
      if (this.S == null) {
        localObject = "";
      } else {
        localObject = this.S;
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
      if (this.V == null) {
        localObject = "";
      } else {
        localObject = this.V;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.jdField_a_of_type_Int >= 17)
    {
      if (this.W == null) {
        localObject = "";
      } else {
        localObject = this.W;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
    if (this.jdField_a_of_type_Int >= 18)
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
      str = this.ay;
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
    if (!TextUtils.isEmpty(this.ac)) {
      paramXmlSerializer.attribute(null, "cover", this.ac);
    }
    if (!TextUtils.isEmpty(this.ad)) {
      paramXmlSerializer.attribute(null, "src", this.ad);
    }
    if (!TextUtils.isEmpty(this.ae)) {
      paramXmlSerializer.attribute(null, "vInfo", this.ae);
    }
    if (!TextUtils.isEmpty(this.af)) {
      paramXmlSerializer.attribute(null, "tInfo", this.af);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.r));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.s));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.t));
    if (!TextUtils.isEmpty(this.ag)) {
      paramXmlSerializer.attribute(null, "summary", this.ag);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.v));
    if (!TextUtils.isEmpty(this.aj)) {
      paramXmlSerializer.attribute(null, "aID", this.aj);
    }
    Object localObject;
    if (this.o == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("");
      paramXmlSerializer.attribute(null, "load", ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.au)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.au);
    }
    if (this.jdField_d_of_type_Boolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    paramXmlSerializer.attribute(null, "isJump2Web", (String)localObject);
    if (!TextUtils.isEmpty(this.av)) {
      paramXmlSerializer.attribute(null, "apurl", this.av);
    }
    if (!TextUtils.isEmpty(this.aw)) {
      paramXmlSerializer.attribute(null, "rl", this.aw);
    }
    if (!TextUtils.isEmpty(this.ax)) {
      paramXmlSerializer.attribute(null, "disType", this.ax);
    }
    long l = this.jdField_c_of_type_Long;
    if (l != 0L) {
      paramXmlSerializer.attribute(null, "feedId", String.valueOf(l));
    }
    int i = this.u;
    if (i != 0) {
      paramXmlSerializer.attribute(null, "feedType", String.valueOf(i));
    }
    if (this.jdField_c_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.jdField_c_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.r)) {
      paramXmlSerializer.attribute(null, "advertiser_id", this.r);
    }
    if (!TextUtils.isEmpty(this.s)) {
      paramXmlSerializer.attribute(null, "aid", this.s);
    }
    if (!TextUtils.isEmpty(this.t)) {
      paramXmlSerializer.attribute(null, "app_download_schema", this.t);
    }
    if (!TextUtils.isEmpty(this.u)) {
      paramXmlSerializer.attribute(null, "canvas_json", this.u);
    }
    if (!TextUtils.isEmpty(this.v)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.v);
    }
    if (this.jdField_d_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.jdField_d_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.w)) {
      paramXmlSerializer.attribute(null, "effect_url", this.w);
    }
    if (!TextUtils.isEmpty(this.x)) {
      paramXmlSerializer.attribute(null, "landing_page", this.x);
    }
    if (!TextUtils.isEmpty(this.y)) {
      paramXmlSerializer.attribute(null, "landing_page_report_url", this.y);
    }
    if (!TextUtils.isEmpty(this.z)) {
      paramXmlSerializer.attribute(null, "noco_id", this.z);
    }
    if (!TextUtils.isEmpty(this.A)) {
      paramXmlSerializer.attribute(null, "product_id", this.A);
    }
    if (!TextUtils.isEmpty(this.q)) {
      paramXmlSerializer.attribute(null, "apurl", this.q);
    }
    if (this.e != 0) {
      paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.e));
    }
    if (this.f != 0) {
      paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.f));
    }
    if (!TextUtils.isEmpty(this.B)) {
      paramXmlSerializer.attribute(null, "rl", this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      paramXmlSerializer.attribute(null, "subordinate_product_id", this.C);
    }
    if (!TextUtils.isEmpty(this.D)) {
      paramXmlSerializer.attribute(null, "traceid", this.D);
    }
    if (!TextUtils.isEmpty(this.E)) {
      paramXmlSerializer.attribute(null, "via", this.E);
    }
    if (!TextUtils.isEmpty(this.F)) {
      paramXmlSerializer.attribute(null, "video_url", this.F);
    }
    if (!TextUtils.isEmpty(this.G)) {
      paramXmlSerializer.attribute(null, "appname", this.G);
    }
    if (!TextUtils.isEmpty(this.H)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.H);
    }
    if (!TextUtils.isEmpty(this.I)) {
      paramXmlSerializer.attribute(null, "pkg_name", this.I);
    }
    if (!TextUtils.isEmpty(this.J)) {
      paramXmlSerializer.attribute(null, "pkgurl", this.J);
    }
    if (!TextUtils.isEmpty(this.N)) {
      paramXmlSerializer.attribute(null, "corporate_image_name", this.N);
    }
    if (!TextUtils.isEmpty(this.O)) {
      paramXmlSerializer.attribute(null, "corporate_logo", this.O);
    }
    if (this.g != 0) {
      paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.g));
    }
    if (this.h != 0) {
      paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.h));
    }
    if (!TextUtils.isEmpty(this.P)) {
      paramXmlSerializer.attribute(null, "negative_feedback_url", this.P);
    }
    if (!TextUtils.isEmpty(this.Q)) {
      paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Q);
    }
    if (!TextUtils.isEmpty(this.R)) {
      paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.R);
    }
    if (this.i != 0) {
      paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.i));
    }
    if (this.j != 0) {
      paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.j));
    }
    if (this.k != 0) {
      paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.k));
    }
    if (this.l != 0) {
      paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.l));
    }
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "universal_link", this.S);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "sdk_data", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "tencent_video_id", this.U);
    }
    if (!TextUtils.isEmpty(this.V)) {
      paramXmlSerializer.attribute(null, "view_id", this.V);
    }
    if (!TextUtils.isEmpty(this.W)) {
      paramXmlSerializer.attribute(null, "qgg_ext", this.W);
    }
    if (!TextUtils.isEmpty(this.X)) {
      paramXmlSerializer.attribute(null, "adInfo", this.X);
    }
    if (!TextUtils.isEmpty(this.Y)) {
      paramXmlSerializer.attribute(null, "is_report_click", this.Y);
    }
    if (!TextUtils.isEmpty(this.ay)) {
      paramXmlSerializer.attribute(null, "noAutoPlay", this.ay);
    }
    paramXmlSerializer.endTag(null, "video");
  }
  
  public boolean a()
  {
    int i = this.v;
    return (i >= 1) && (i <= 100);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ac = paramStructMsgNode.a("cover");
    this.ad = paramStructMsgNode.a("src");
    Object localObject1 = paramStructMsgNode.a("load");
    this.ae = paramStructMsgNode.a("vInfo");
    this.af = paramStructMsgNode.a("tInfo");
    Object localObject2 = paramStructMsgNode.a("preTime");
    if (localObject2 != null) {}
    label141:
    try
    {
      this.q = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException10)
    {
      label84:
      break label84;
    }
    try
    {
      this.q = ((int)Float.valueOf((String)localObject2).floatValue());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fromXml parse previewVideoTimeStr: previewVideoTime = ");
        ((StringBuilder)localObject2).append(this.q);
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
      this.r = Integer.valueOf((String)localObject2).intValue();
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
      this.s = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException7)
    {
      break label193;
    }
    localObject2 = paramStructMsgNode.a("fullTime");
    if (localObject2 != null) {}
    try
    {
      this.t = Integer.valueOf((String)localObject2).intValue();
    }
    catch (Exception localException8)
    {
      break label219;
    }
    this.ag = paramStructMsgNode.a("summary");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.o = Integer.parseInt((String)localObject1);
    }
    catch (RuntimeException localRuntimeException)
    {
      break label248;
    }
    this.o = 0;
    localObject1 = paramStructMsgNode.a("busiType");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.v = Integer.parseInt((String)localObject1);
    }
    catch (Exception localException1)
    {
      break label279;
    }
    this.aj = paramStructMsgNode.a("aID");
    this.au = paramStructMsgNode.a("jumpUrl");
    this.jdField_d_of_type_Boolean = "1".equals(paramStructMsgNode.a("isJump2Web"));
    localObject1 = paramStructMsgNode.a("preStartPosi");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    label404:
    try
    {
      this.p = Integer.valueOf((String)localObject1).intValue();
    }
    catch (Exception localException9)
    {
      label347:
      break label347;
    }
    try
    {
      this.p = ((int)Float.valueOf((String)localObject1).floatValue());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fromXml parse previewStartPosiStr: previewStartPosi = ");
        ((StringBuilder)localObject1).append(this.p);
        QLog.d("structmsg.StructMsgItemVideo", 2, ((StringBuilder)localObject1).toString());
      }
    }
    catch (Exception localException2)
    {
      break label404;
    }
    this.av = paramStructMsgNode.a("apurl");
    this.aw = paramStructMsgNode.a("rl");
    this.ax = paramStructMsgNode.a("disType");
    localObject1 = paramStructMsgNode.a("feedId");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.jdField_c_of_type_Long = Long.parseLong((String)localObject1);
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
      this.u = Integer.parseInt((String)localObject1);
    }
    catch (Exception localException4)
    {
      label505:
      break label505;
    }
    if (QLog.isColorLevel()) {
      QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
    }
    if (this.jdField_a_of_type_Int >= 13)
    {
      localObject1 = paramStructMsgNode.a("action_type");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.jdField_c_of_type_Int = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label556:
      break label556;
    }
    this.jdField_c_of_type_Int = 0;
    localObject1 = paramStructMsgNode.a("dest_type");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.jdField_d_of_type_Int = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label587:
      break label587;
    }
    this.jdField_d_of_type_Int = 0;
    localObject1 = paramStructMsgNode.a("product_type");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.e = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      label618:
      break label618;
    }
    this.e = 0;
    this.r = paramStructMsgNode.a("advertiser_id");
    this.s = paramStructMsgNode.a("aid");
    this.t = paramStructMsgNode.a("app_download_schema");
    this.u = paramStructMsgNode.a("canvas_json");
    this.v = paramStructMsgNode.a("customized_invoke_url");
    this.w = paramStructMsgNode.a("effect_url");
    this.x = paramStructMsgNode.a("landing_page");
    this.y = paramStructMsgNode.a("landing_page_report_url");
    this.z = paramStructMsgNode.a("noco_id");
    this.A = paramStructMsgNode.a("product_id");
    this.C = paramStructMsgNode.a("subordinate_product_id");
    this.D = paramStructMsgNode.a("traceid");
    this.E = paramStructMsgNode.a("via");
    this.F = paramStructMsgNode.a("video_url");
    this.G = paramStructMsgNode.a("appname");
    this.H = paramStructMsgNode.a("customized_invoke_url");
    this.I = paramStructMsgNode.a("pkg_name");
    this.J = paramStructMsgNode.a("pkgurl");
    this.B = paramStructMsgNode.a("rl");
    this.q = paramStructMsgNode.a("apurl");
    this.N = paramStructMsgNode.a("corporate_image_name");
    this.O = paramStructMsgNode.a("corporate_logo");
    if (this.jdField_a_of_type_Int >= 14)
    {
      localObject1 = paramStructMsgNode.a("mini_program_type");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.f = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      label900:
      label965:
      break label900;
    }
    this.f = 0;
    if ((paramStructMsgNode.a != null) && (paramStructMsgNode.a.a != null))
    {
      localObject1 = paramStructMsgNode.a.a;
      if (this.jdField_a_of_type_Int >= 15)
      {
        localObject2 = ((StructMsgNode)localObject1).a("tab_id");
        if (StringUtil.a((String)localObject2)) {}
      }
    }
    try
    {
      this.g = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException5)
    {
      break label965;
    }
    this.g = 0;
    localObject2 = ((StructMsgNode)localObject1).a("is_hidden");
    if (!StringUtil.a((String)localObject2)) {}
    label1069:
    try
    {
      this.h = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      label996:
      break label996;
    }
    this.h = 0;
    if (this.jdField_a_of_type_Int >= 16)
    {
      this.P = ((StructMsgNode)localObject1).a("negative_feedback_url");
      this.Q = ((StructMsgNode)localObject1).a("sdk_exposure_monitor_url");
      this.R = ((StructMsgNode)localObject1).a("sdk_click_monitor_url");
      localObject2 = ((StructMsgNode)localObject1).a("media_duration");
      if (StringUtil.a((String)localObject2)) {}
    }
    try
    {
      this.i = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException7)
    {
      break label1069;
    }
    this.i = 0;
    localObject2 = ((StructMsgNode)localObject1).a("video_file_size");
    if (!StringUtil.a((String)localObject2)) {}
    try
    {
      this.j = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException8)
    {
      label1100:
      break label1100;
    }
    this.j = 0;
    localObject2 = ((StructMsgNode)localObject1).a("app_score_num");
    if (!StringUtil.a((String)localObject2)) {}
    label1162:
    try
    {
      this.k = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException9)
    {
      label1131:
      break label1131;
    }
    this.k = 0;
    localObject2 = ((StructMsgNode)localObject1).a("download_num");
    if (!StringUtil.a((String)localObject2)) {}
    try
    {
      this.l = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException10)
    {
      break label1162;
    }
    this.l = 0;
    this.S = ((StructMsgNode)localObject1).a("universal_link");
    this.T = ((StructMsgNode)localObject1).a("sdk_data");
    this.U = ((StructMsgNode)localObject1).a("tencent_video_id");
    this.V = ((StructMsgNode)localObject1).a("view_id");
    if (this.jdField_a_of_type_Int >= 17) {
      this.W = ((StructMsgNode)localObject1).a("qgg_ext");
    }
    if (this.jdField_a_of_type_Int >= 18)
    {
      this.X = ((StructMsgNode)localObject1).a("adInfo");
      this.Y = ((StructMsgNode)localObject1).a("is_report_click");
    }
    if (this.jdField_a_of_type_Int >= 18) {
      this.ay = paramStructMsgNode.a("noAutoPlay");
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
      i = AIOUtils.b(12.0F, (Resources)localObject1);
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
      localTitledImageView.setId(2131368633);
      localTitledImageView.setContentDescription(((Resources)localObject1).getString(2131694551));
      localTitledImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localTitledImageView.setContentDescription(((Resources)localObject1).getText(2131719258));
      paramView = localTitledImageView;
    }
    localTitledImageView.setImageResource(2130845585);
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
    if (TextUtils.isEmpty(this.ac)) {
      localTitledImageView.setBackgroundDrawable((Drawable)localObject1);
    }
    try
    {
      localObject2 = URLDrawable.getDrawable(this.ac, j, j, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label311;
      }
      if (paramBundle.getBoolean("has_cnr")) {
        ((URLDrawable)localObject2).setDecodeHandler(new StructMsgItemVideo.CornerDecoder(this, i, j, j));
      }
      if (AbsDownloader.hasFile(this.ac)) {
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
      localTitledImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      localTitledImageView.setBackgroundDrawable((Drawable)localObject2);
      break label311;
      localTitledImageView.setBackgroundDrawable((Drawable)localObject1);
    }
    label311:
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localTitledImageView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localTitledImageView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    localTitledImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    localTitledImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localTitledImageView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localTitledImageView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return paramView;
  }
  
  public boolean b()
  {
    return this.v == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo
 * JD-Core Version:    0.7.0.1
 */