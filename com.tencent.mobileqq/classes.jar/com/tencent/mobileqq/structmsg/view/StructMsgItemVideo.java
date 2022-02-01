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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
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
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.model.WeishiFeedCommInfo;
import cooperation.qzone.model.WeishiFeedInfo;
import cooperation.qzone.model.WeishiUserInfo;
import cooperation.readinjoy.ReadInjoyFloatingWindowHelper;
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
  String ax;
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
  
  public StructMsgItemVideo(String paramString1, String paramString2, boolean paramBoolean)
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
    this.ad = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.o = i;
      this.jdField_a_of_type_Int = 18;
      return;
      i = 0;
    }
  }
  
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
    if ("0".equals(str4)) {}
    for (paramJSONObject.videoInfo.videoRemark.orgwebsite = 0;; paramJSONObject.videoInfo.videoRemark.orgwebsite = 1)
    {
      paramJSONObject.videoInfo.width = this.r;
      paramJSONObject.videoInfo.height = this.s;
      paramJSONObject.videoInfo.videoId = str2;
      paramJSONObject.videoInfo.videoTime = this.t;
      paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramJSONObject);
      paramJSONObject = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
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
  }
  
  private void a()
  {
    try
    {
      if (!EcShopAssistantManager.b(this.Y))
      {
        EcshopAdHandler.ReportInfo localReportInfo = new EcshopAdHandler.ReportInfo();
        localReportInfo.jdField_a_of_type_Int = 3;
        localReportInfo.f = 1;
        localReportInfo = EcshopAdHandler.a(localReportInfo, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
        ((EcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(localReportInfo, null);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(Context paramContext)
  {
    if ((TextUtils.isEmpty(b())) || ((!b().startsWith("http://")) && (!b().startsWith("https://")))) {}
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", b());
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, b());
        paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
        paramContext.extra().putAll(localIntent.getExtras());
        QRoute.startUri(paramContext, null);
      } while (TextUtils.isEmpty(b()));
      paramContext = CGILoader.a(b());
    } while (TextUtils.isEmpty(paramContext));
    ReportController.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.o == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839543);
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
    boolean bool3 = RIJAladdinUtils.h();
    if ((bool2) && (bool3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structmsg.StructMsgItemVideo", 2, "canAutoPlay(): oldAutoPlay:" + bool2 + ", enableAutoPlay:" + bool3 + ", autoPlay:" + bool1);
      }
      return bool1;
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
      return null;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (a())
    {
      localBundle.putBoolean("is_public_account_video_msg", true);
      this.jdField_a_of_type_Boolean = true;
      this.ak = localBundle.getString("public_account_video_title");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4)) {}
    for (boolean bool1 = true; !this.jdField_a_of_type_Boolean; bool1 = false) {
      return b(paramContext, paramView, localBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_UIN") == null) {
        break label271;
      }
      this.ah = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label291;
      }
    }
    Object localObject1;
    label271:
    label291:
    for (this.ai = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.ai = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.al = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.am = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.as = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.at = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label311;
      }
      if (paramView.getTag(2131378571) != null)
      {
        paramContext = paramView.getTag(2131378571);
        if ((paramContext instanceof StructMsgItemVideo.Holder))
        {
          paramContext = (StructMsgItemVideo.Holder)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.ah = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label311:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131378571);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131719540));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int i;
    Object localObject3;
    label549:
    Object localObject4;
    label630:
    int j;
    int k;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.b(true);
      paramBundle.d(true);
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
        paramBundle.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      if (this.r >= this.s)
      {
        paramBundle.f = PAVideoView.e;
        paramBundle.jdField_c_of_type_Boolean = true;
        paramBundle.i = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130843459);
        ((ImageView)localObject2).setVisibility(8);
        i = AIOUtils.a(62.0F, (Resources)localObject1);
        if (bool1) {
          i = AIOUtils.a(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          i = AIOUtils.a(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.jdField_d_of_type_Boolean) {
            break label1465;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131378571);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131378571);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131378571);
        if (!bool1) {
          break label1475;
        }
        i = AIOUtils.a(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1543;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend())) {
          break label1488;
        }
        j = AIOUtils.a(10.0F, (Resources)localObject1) + i;
        k = i;
      }
    }
    for (;;)
    {
      label675:
      ((LinearLayout)localObject3).setPadding(k, i, j, i);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131378570);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setSingleLine(true);
      label748:
      Object localObject5;
      label818:
      boolean bool2;
      if (bool1)
      {
        ((TextView)localObject4).setTextSize(1, 14.0F);
        localObject5 = new LinearLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject5).rightMargin = AIOUtils.a(7.0F, (Resources)localObject1);
        ((LinearLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setSingleLine(true);
        if (!bool1) {
          break label1520;
        }
        ((TextView)localObject1).setTextSize(1, 12.0F);
        ((TextView)localObject1).setTextColor(-1);
        localObject5 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject5).gravity = 85;
        ((LinearLayout.LayoutParams)localObject5).weight = 0.0F;
        ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new StructMsgItemVideo.Holder();
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramBundle;
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        ((StructMsgItemVideo.Holder)localObject5).b = ((TextView)localObject1);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
        paramView.setTag(2131378571, localObject5);
        paramView.setTag(this);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (StructMsgItemVideo.Holder)localObject5);
        bool2 = b(paramContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.ae);
        }
        if ((bool2) && (this.v != 4)) {
          break label1532;
        }
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
      }
      for (;;)
      {
        if (this.q > 0) {
          ((StructMsgItemVideo.Holder)localObject5).b.setText(ShortVideoUtils.stringForTime(this.q * 1000));
        }
        if (!TextUtils.isEmpty(this.au)) {
          paramView.setTag(2131378578, this.au);
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) && (!AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message, "0X800B375")))
        {
          paramContext = new VideoR5.Builder(null, null, this.ae, this.aj).i(this.aj).l(bool2).m(ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg)).a().a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B375", "0X800B375", 0, 0, "", "", "", paramContext, false);
          AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message, "0X800B375");
        }
        return paramView;
        paramBundle.i = false;
        paramBundle.jdField_c_of_type_Boolean = false;
        localObject3 = ShortVideoUtils.adjustSize(this.r, this.s);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
        break;
        if (!this.jdField_c_of_type_Boolean) {
          paramBundle.setRadiusTop(5.0F);
        }
        for (;;)
        {
          paramBundle.i = true;
          paramBundle.jdField_c_of_type_Boolean = false;
          paramBundle.b(true);
          paramBundle.d(false);
          if (this.r >= this.s) {
            break label1384;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1384:
        if (this.r > this.s)
        {
          paramBundle.f = PAVideoView.jdField_c_of_type_Int;
          break;
        }
        if ((this.r == this.s) && (this.r != 0) && (this.s != 0))
        {
          if (bool1)
          {
            paramBundle.f = PAVideoView.e;
            break;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
        }
        paramBundle.f = PAVideoView.jdField_c_of_type_Int;
        break;
        label1465:
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
        break label549;
        label1475:
        i = AIOUtils.a(12.0F, (Resources)localObject1);
        break label630;
        label1488:
        k = AIOUtils.a(10.0F, (Resources)localObject1) + i;
        j = i;
        break label675;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label748;
        label1520:
        ((TextView)localObject1).setTextSize(1, 14.0F);
        break label818;
        label1532:
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.f();
      }
      label1543:
      j = i;
      k = i;
    }
  }
  
  public String a()
  {
    return "video";
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null)) {}
    label163:
    label835:
    label859:
    do
    {
      return;
      Bundle localBundle;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
        if ((VideoVolumeControl.a(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.isVideoChatting())))
        {
          QQToast.a(paramContext, 2131695877, 1).b(paramContext.getResources().getDimensionPixelSize(2131299166));
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("structmsg.StructMsgItemVideo", 2, "enterFullScreenActivity():", localException);
          }
          localObject = null;
        }
        if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mQzoneExtraMsg))
        {
          a((QQAppInterface)localObject, paramContext, paramStructMsgForGeneralShare.mQzoneExtraMsg);
          return;
        }
        localBundle = new Bundle();
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.ah);
        if (this.v <= 1) {
          break label835;
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.at);
      localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl)) {
        localBundle.putString("RED_PACKET_ID", Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl).getQueryParameter("redpackid"));
      }
      if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
      for (Object localObject = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; localObject = paramStructMsgForGeneralShare.mCreateTime)
      {
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.t));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.r));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.s));
        localBundle.putString("VIDEO_VID", this.af);
        localBundle.putString("VIDEO_COVER", this.ac);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.aj);
        localBundle.putString("VIDEO_TITLE", this.ak);
        boolean bool1 = true;
        if ((this.v == 2) || (this.v == 3)) {
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
          if (this.v == 2)
          {
            ThirdVideoManager.a();
            localBundle.putString("VIDEO_THIRD_URL", ThirdVideoManager.a(this.af));
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.ae, "" + this.v, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 33);
        localObject = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(HardCodeUtil.a(2131716895)))) && (((AladdinConfig)localObject).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (ReadInjoyFloatingWindowHelper.a(paramContext, this.aj, localBundle))) {
          break;
        }
        bool1 = false;
        try
        {
          boolean bool2 = MultiVideoConfigHandler.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          bool1 = bool2;
        }
        catch (Exception paramStructMsgForGeneralShare)
        {
          break label789;
        }
        if (!bool1) {
          break label859;
        }
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        MultiVideoHelper.a(paramContext, paramStructMsgForGeneralShare);
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).overridePendingTransition(2130772043, 2130772045);
        return;
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.ai);
        break label163;
      }
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.addFlags(536870912);
      paramStructMsgForGeneralShare.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    label789:
    ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
    ((Activity)paramContext).overridePendingTransition(2130772043, 2130772045);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = new JSONObject(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.optInt("enterVideoLayer") == 1))
      {
        QLog.d("structmsg.StructMsgItemVideo", 2, "[enterQzoneFullScreen] rays, qzShareMsg=" + paramQQAppInterface.toString());
        paramQQAppInterface = a(paramQQAppInterface);
        BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
      }
      return;
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
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.jdField_a_of_type_Int).append("\n");
        paramObjectInput.append("imgUrl:").append(this.ac).append("\n");
        paramObjectInput.append("videoUrl:").append(this.ad).append("\n");
        paramObjectInput.append("vInfo:").append(this.ae).append("\n");
        paramObjectInput.append("tInfo:").append(this.af).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.q).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.r).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.s).append("\n");
        paramObjectInput.append("type:").append(this.v).append("\n");
        paramObjectInput.append("articleID:").append(this.aj).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.au).append("\n");
        paramObjectInput.append("jump2Web:").append(this.jdField_d_of_type_Boolean).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.p).append("\n");
        if ((this.jdField_a_of_type_Int >= 12) && (b()))
        {
          paramObjectInput.append("feedId:").append(this.jdField_c_of_type_Long).append("\n");
          paramObjectInput.append("feedType:").append(this.u).append("\n");
        }
        paramObjectInput.append("]:").append("\n");
        QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.o = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ac != null)
    {
      str = this.ac;
      paramObjectOutput.writeUTF(str);
      if (this.ad == null) {
        break label1108;
      }
      str = this.ad;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.o + "");
      if (this.jdField_a_of_type_Int >= 7)
      {
        if (this.ae == null) {
          break label1114;
        }
        str = this.ae;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.af == null) {
          break label1120;
        }
        str = this.af;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.q);
        paramObjectOutput.writeInt(this.r);
        paramObjectOutput.writeInt(this.s);
        paramObjectOutput.writeInt(this.t);
        if (this.ag == null) {
          break label1126;
        }
        str = this.ag;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.v);
      }
      if (this.jdField_a_of_type_Int >= 8)
      {
        if (this.aj == null) {
          break label1132;
        }
        str = this.aj;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        if (this.au == null) {
          break label1138;
        }
        str = this.au;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.jdField_d_of_type_Boolean) {
          break label1144;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 10) {
        paramObjectOutput.writeInt(this.p);
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        if (this.av == null) {
          break label1150;
        }
        str = this.av;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.aw == null) {
          break label1156;
        }
        str = this.aw;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.ax == null) {
          break label1162;
        }
        str = this.ax;
        label339:
        paramObjectOutput.writeUTF(str);
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        paramObjectOutput.writeInt(this.u);
        paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        if (this.q == null) {
          break label1168;
        }
        str = this.q;
        label403:
        paramObjectOutput.writeUTF(str);
        if (this.B == null) {
          break label1174;
        }
        str = this.B;
        label422:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.r != null) {
          break label1180;
        }
        str = "0";
        label449:
        paramObjectOutput.writeUTF(str);
        if (this.s != null) {
          break label1188;
        }
        str = "0";
        label466:
        paramObjectOutput.writeUTF(str);
        if (this.t != null) {
          break label1196;
        }
        str = "";
        label483:
        paramObjectOutput.writeUTF(str);
        if (this.u != null) {
          break label1204;
        }
        str = "";
        label500:
        paramObjectOutput.writeUTF(str);
        if (this.v != null) {
          break label1212;
        }
        str = "";
        label517:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label1220;
        }
        str = "";
        label544:
        paramObjectOutput.writeUTF(str);
        if (this.x != null) {
          break label1228;
        }
        str = "";
        label561:
        paramObjectOutput.writeUTF(str);
        if (this.y != null) {
          break label1236;
        }
        str = "";
        label578:
        paramObjectOutput.writeUTF(str);
        if (this.z != null) {
          break label1244;
        }
        str = "";
        label595:
        paramObjectOutput.writeUTF(str);
        if (this.A != null) {
          break label1252;
        }
        str = "";
        label612:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.e);
        if (this.C != null) {
          break label1260;
        }
        str = "";
        label639:
        paramObjectOutput.writeUTF(str);
        if (this.D != null) {
          break label1268;
        }
        str = "";
        label656:
        paramObjectOutput.writeUTF(str);
        if (this.E != null) {
          break label1276;
        }
        str = "";
        label673:
        paramObjectOutput.writeUTF(str);
        if (this.F != null) {
          break label1284;
        }
        str = "";
        label690:
        paramObjectOutput.writeUTF(str);
        if (this.G != null) {
          break label1292;
        }
        str = "";
        label707:
        paramObjectOutput.writeUTF(str);
        if (this.H != null) {
          break label1300;
        }
        str = "";
        label724:
        paramObjectOutput.writeUTF(str);
        if (this.I != null) {
          break label1308;
        }
        str = "";
        label741:
        paramObjectOutput.writeUTF(str);
        if (this.J != null) {
          break label1316;
        }
        str = "";
        label758:
        paramObjectOutput.writeUTF(str);
        if (this.N != null) {
          break label1324;
        }
        str = "";
        label775:
        paramObjectOutput.writeUTF(str);
        if (this.O != null) {
          break label1332;
        }
        str = "";
        label792:
        paramObjectOutput.writeUTF(str);
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
        if (this.P != null) {
          break label1340;
        }
        str = "";
        label866:
        paramObjectOutput.writeUTF(str);
        if (this.Q != null) {
          break label1348;
        }
        str = "";
        label883:
        paramObjectOutput.writeUTF(str);
        if (this.R != null) {
          break label1356;
        }
        str = "";
        label900:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.i);
        paramObjectOutput.writeInt(this.j);
        paramObjectOutput.writeInt(this.k);
        paramObjectOutput.writeInt(this.l);
        if (this.S != null) {
          break label1364;
        }
        str = "";
        label957:
        paramObjectOutput.writeUTF(str);
        if (this.T != null) {
          break label1372;
        }
        str = "";
        label974:
        paramObjectOutput.writeUTF(str);
        if (this.U != null) {
          break label1380;
        }
        str = "";
        label991:
        paramObjectOutput.writeUTF(str);
        if (this.V != null) {
          break label1388;
        }
        str = "";
        label1008:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 17)
      {
        if (this.W != null) {
          break label1396;
        }
        str = "";
        label1034:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 18)
      {
        if (this.X != null) {
          break label1404;
        }
        str = "";
        label1060:
        paramObjectOutput.writeUTF(str);
        if (this.Y != null) {
          break label1412;
        }
        str = "";
        label1077:
        paramObjectOutput.writeUTF(str);
        if (this.ay != null) {
          break label1420;
        }
      }
    }
    label1156:
    label1162:
    label1420:
    for (String str = "";; str = this.ay)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      label1108:
      str = "";
      break label36;
      label1114:
      str = "";
      break label92;
      label1120:
      str = "";
      break label111;
      label1126:
      str = "";
      break label170;
      label1132:
      str = "";
      break label208;
      label1138:
      str = "";
      break label236;
      label1144:
      str = "0";
      break label254;
      label1150:
      str = "";
      break label301;
      str = "";
      break label320;
      str = "";
      break label339;
      label1168:
      str = "";
      break label403;
      label1174:
      str = "";
      break label422;
      label1180:
      str = this.r;
      break label449;
      label1188:
      str = this.s;
      break label466;
      label1196:
      str = this.t;
      break label483;
      label1204:
      str = this.u;
      break label500;
      label1212:
      str = this.v;
      break label517;
      label1220:
      str = this.w;
      break label544;
      label1228:
      str = this.x;
      break label561;
      label1236:
      str = this.y;
      break label578;
      label1244:
      str = this.z;
      break label595;
      label1252:
      str = this.A;
      break label612;
      label1260:
      str = this.C;
      break label639;
      label1268:
      str = this.D;
      break label656;
      label1276:
      str = this.E;
      break label673;
      str = this.F;
      break label690;
      label1292:
      str = this.G;
      break label707;
      label1300:
      str = this.H;
      break label724;
      label1308:
      str = this.I;
      break label741;
      label1316:
      str = this.J;
      break label758;
      label1324:
      str = this.N;
      break label775;
      label1332:
      str = this.O;
      break label792;
      label1340:
      str = this.P;
      break label866;
      label1348:
      str = this.Q;
      break label883;
      label1356:
      str = this.R;
      break label900;
      label1364:
      str = this.S;
      break label957;
      label1372:
      str = this.T;
      break label974;
      label1380:
      str = this.U;
      break label991;
      label1388:
      str = this.V;
      break label1008;
      label1396:
      str = this.W;
      break label1034;
      label1404:
      str = this.X;
      break label1060;
      str = this.Y;
      break label1077;
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
    if (this.o == 1) {
      paramXmlSerializer.attribute(null, "load", this.o + "");
    }
    if (!TextUtils.isEmpty(this.au)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.au);
    }
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.av)) {
        paramXmlSerializer.attribute(null, "apurl", this.av);
      }
      if (!TextUtils.isEmpty(this.aw)) {
        paramXmlSerializer.attribute(null, "rl", this.aw);
      }
      if (!TextUtils.isEmpty(this.ax)) {
        paramXmlSerializer.attribute(null, "disType", this.ax);
      }
      if (this.jdField_c_of_type_Long != 0L) {
        paramXmlSerializer.attribute(null, "feedId", String.valueOf(this.jdField_c_of_type_Long));
      }
      if (this.u != 0) {
        paramXmlSerializer.attribute(null, "feedType", String.valueOf(this.u));
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
      return;
    }
  }
  
  public boolean a()
  {
    return (this.v >= 1) && (this.v <= 100);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      this.ac = paramStructMsgNode.a("cover");
      this.ad = paramStructMsgNode.a("src");
      Object localObject = paramStructMsgNode.a("load");
      this.ae = paramStructMsgNode.a("vInfo");
      this.af = paramStructMsgNode.a("tInfo");
      String str = paramStructMsgNode.a("preTime");
      if (str != null) {}
      try
      {
        this.q = Integer.valueOf(str).intValue();
        label81:
        str = paramStructMsgNode.a("preWidth");
        if (str == null) {}
      }
      catch (Exception localNumberFormatException9)
      {
        try
        {
          this.r = Integer.valueOf(str).intValue();
          label104:
          str = paramStructMsgNode.a("preHeight");
          if (str != null) {}
          try
          {
            this.s = Integer.valueOf(str).intValue();
            label127:
            str = paramStructMsgNode.a("fullTime");
            if (str != null) {}
            try
            {
              this.t = Integer.valueOf(str).intValue();
              label150:
              this.ag = paramStructMsgNode.a("summary");
              if (!TextUtils.isEmpty((CharSequence)localObject)) {}
              try
              {
                this.o = Integer.parseInt((String)localObject);
                label176:
                localObject = paramStructMsgNode.a("busiType");
                if (TextUtils.isEmpty((CharSequence)localObject)) {}
              }
              catch (RuntimeException localNumberFormatException9)
              {
                try
                {
                  this.v = Integer.parseInt((String)localObject);
                  label199:
                  this.aj = paramStructMsgNode.a("aID");
                  this.au = paramStructMsgNode.a("jumpUrl");
                  this.jdField_d_of_type_Boolean = "1".equals(paramStructMsgNode.a("isJump2Web"));
                  localObject = paramStructMsgNode.a("preStartPosi");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {}
                  try
                  {
                    this.p = Integer.valueOf((String)localObject).intValue();
                    this.av = paramStructMsgNode.a("apurl");
                    this.aw = paramStructMsgNode.a("rl");
                    this.ax = paramStructMsgNode.a("disType");
                    localObject = paramStructMsgNode.a("feedId");
                    if (TextUtils.isEmpty((CharSequence)localObject)) {}
                  }
                  catch (Exception localNumberFormatException9)
                  {
                    try
                    {
                      this.jdField_c_of_type_Long = Long.parseLong((String)localObject);
                      localObject = paramStructMsgNode.a("feedType");
                      if (TextUtils.isEmpty((CharSequence)localObject)) {}
                    }
                    catch (Exception localNumberFormatException9)
                    {
                      try
                      {
                        this.u = Integer.parseInt((String)localObject);
                        if (this.jdField_a_of_type_Int >= 13)
                        {
                          localObject = paramStructMsgNode.a("action_type");
                          if (TextUtils.isEmpty((CharSequence)localObject)) {}
                        }
                      }
                      catch (Exception localNumberFormatException9)
                      {
                        try
                        {
                          this.jdField_c_of_type_Int = Integer.parseInt((String)localObject);
                          localObject = paramStructMsgNode.a("dest_type");
                          if (TextUtils.isEmpty((CharSequence)localObject)) {}
                        }
                        catch (NumberFormatException localNumberFormatException9)
                        {
                          try
                          {
                            this.jdField_d_of_type_Int = Integer.parseInt((String)localObject);
                            localObject = paramStructMsgNode.a("product_type");
                            if (TextUtils.isEmpty((CharSequence)localObject)) {}
                          }
                          catch (NumberFormatException localNumberFormatException9)
                          {
                            try
                            {
                              this.e = Integer.parseInt((String)localObject);
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
                                localObject = paramStructMsgNode.a("mini_program_type");
                                if (TextUtils.isEmpty((CharSequence)localObject)) {}
                              }
                            }
                            catch (NumberFormatException localNumberFormatException9)
                            {
                              try
                              {
                                this.f = Integer.parseInt((String)localObject);
                                if ((paramStructMsgNode.a != null) && (paramStructMsgNode.a.a != null))
                                {
                                  localObject = paramStructMsgNode.a.a;
                                  if (this.jdField_a_of_type_Int >= 15)
                                  {
                                    str = ((StructMsgNode)localObject).a("tab_id");
                                    if (StringUtil.a(str)) {}
                                  }
                                }
                              }
                              catch (NumberFormatException localNumberFormatException9)
                              {
                                try
                                {
                                  this.g = Integer.parseInt(str);
                                  str = ((StructMsgNode)localObject).a("is_hidden");
                                  if (StringUtil.a(str)) {}
                                }
                                catch (NumberFormatException localNumberFormatException9)
                                {
                                  try
                                  {
                                    this.h = Integer.parseInt(str);
                                    if (this.jdField_a_of_type_Int >= 16)
                                    {
                                      this.P = ((StructMsgNode)localObject).a("negative_feedback_url");
                                      this.Q = ((StructMsgNode)localObject).a("sdk_exposure_monitor_url");
                                      this.R = ((StructMsgNode)localObject).a("sdk_click_monitor_url");
                                      str = ((StructMsgNode)localObject).a("media_duration");
                                      if (StringUtil.a(str)) {}
                                    }
                                  }
                                  catch (NumberFormatException localNumberFormatException9)
                                  {
                                    try
                                    {
                                      this.i = Integer.parseInt(str);
                                      str = ((StructMsgNode)localObject).a("video_file_size");
                                      if (StringUtil.a(str)) {}
                                    }
                                    catch (NumberFormatException localNumberFormatException9)
                                    {
                                      try
                                      {
                                        this.j = Integer.parseInt(str);
                                        str = ((StructMsgNode)localObject).a("app_score_num");
                                        if (StringUtil.a(str)) {}
                                      }
                                      catch (NumberFormatException localNumberFormatException9)
                                      {
                                        try
                                        {
                                          this.k = Integer.parseInt(str);
                                          str = ((StructMsgNode)localObject).a("download_num");
                                          if (StringUtil.a(str)) {}
                                        }
                                        catch (NumberFormatException localNumberFormatException9)
                                        {
                                          try
                                          {
                                            for (;;)
                                            {
                                              for (;;)
                                              {
                                                this.l = Integer.parseInt(str);
                                                this.S = ((StructMsgNode)localObject).a("universal_link");
                                                this.T = ((StructMsgNode)localObject).a("sdk_data");
                                                this.U = ((StructMsgNode)localObject).a("tencent_video_id");
                                                this.V = ((StructMsgNode)localObject).a("view_id");
                                                if (this.jdField_a_of_type_Int >= 17) {
                                                  this.W = ((StructMsgNode)localObject).a("qgg_ext");
                                                }
                                                if (this.jdField_a_of_type_Int >= 18)
                                                {
                                                  this.X = ((StructMsgNode)localObject).a("adInfo");
                                                  this.Y = ((StructMsgNode)localObject).a("is_report_click");
                                                }
                                                if (this.jdField_a_of_type_Int < 18) {
                                                  break;
                                                }
                                                this.ay = paramStructMsgNode.a("noAutoPlay");
                                                return true;
                                                localException10 = localException10;
                                                try
                                                {
                                                  this.q = ((int)Float.valueOf(str).floatValue());
                                                  if (!QLog.isColorLevel()) {
                                                    break label81;
                                                  }
                                                  QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.q);
                                                }
                                                catch (Exception localException5) {}
                                              }
                                              break label81;
                                              localRuntimeException = localRuntimeException;
                                              this.o = 0;
                                              break label176;
                                              localException6 = localException6;
                                              try
                                              {
                                                this.p = ((int)Float.valueOf(localRuntimeException).floatValue());
                                                if (!QLog.isColorLevel()) {
                                                  continue;
                                                }
                                                QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.p);
                                              }
                                              catch (Exception localException1) {}
                                              continue;
                                              localException2 = localException2;
                                              if (QLog.isColorLevel())
                                              {
                                                QLog.d("structmsg.StructMsgItemVideo", 2, "error while feedIdStr to feedId Long!");
                                                continue;
                                                localException3 = localException3;
                                                if (QLog.isColorLevel())
                                                {
                                                  QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
                                                  continue;
                                                  localNumberFormatException1 = localNumberFormatException1;
                                                  this.jdField_c_of_type_Int = 0;
                                                  continue;
                                                  localNumberFormatException2 = localNumberFormatException2;
                                                  this.jdField_d_of_type_Int = 0;
                                                  continue;
                                                  localNumberFormatException3 = localNumberFormatException3;
                                                  this.e = 0;
                                                  continue;
                                                  localNumberFormatException4 = localNumberFormatException4;
                                                  this.f = 0;
                                                  continue;
                                                  localNumberFormatException5 = localNumberFormatException5;
                                                  this.g = 0;
                                                  continue;
                                                  localNumberFormatException6 = localNumberFormatException6;
                                                  this.h = 0;
                                                  continue;
                                                  localNumberFormatException7 = localNumberFormatException7;
                                                  this.i = 0;
                                                  continue;
                                                  localNumberFormatException8 = localNumberFormatException8;
                                                  this.j = 0;
                                                }
                                              }
                                            }
                                            localNumberFormatException9 = localNumberFormatException9;
                                            this.k = 0;
                                          }
                                          catch (NumberFormatException localNumberFormatException10)
                                          {
                                            for (;;)
                                            {
                                              this.l = 0;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                catch (Exception localException4)
                {
                  break label199;
                }
              }
            }
            catch (Exception localException7)
            {
              break label150;
            }
          }
          catch (Exception localException8)
          {
            break label127;
          }
        }
        catch (Exception localException9)
        {
          break label104;
        }
      }
    }
  }
  
  protected View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1 = paramContext.getResources();
    int i;
    int j;
    label113:
    Drawable localDrawable;
    if (paramBundle.getBoolean("has_cnr"))
    {
      i = AIOUtils.a(12.0F, (Resources)localObject1);
      ((Resources)localObject1).getDisplayMetrics();
      j = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130845712);
        paramView.setTag(this);
        try
        {
          localObject2 = new RoundedColorDrawable(-16777216, j, j, i);
          if (TextUtils.isEmpty(this.ac))
          {
            paramView.setBackgroundDrawable((Drawable)localObject2);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            return localObject1;
            paramView = new TitledImageView(paramContext);
            paramView.setId(2131368907);
            paramView.setContentDescription(((Resources)localObject1).getString(2131694583));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131719540));
            localObject1 = paramView;
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localDrawable = null;
          }
        }
      }
    }
    for (;;)
    {
      URLDrawable localURLDrawable;
      try
      {
        localURLDrawable = URLDrawable.getDrawable(this.ac, j, j, localDrawable, localDrawable);
        if (localURLDrawable == null) {
          break label113;
        }
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new StructMsgItemVideo.CornerDecoder(this, i, j, j));
        }
        if ((AbsDownloader.hasFile(this.ac)) || (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))) {
          break label402;
        }
        localURLDrawable.setAutoDownload(bool);
        if (localURLDrawable.getStatus() != 1) {
          break label379;
        }
        paramView.setBackgroundDrawable(localURLDrawable);
      }
      catch (Throwable paramContext)
      {
        paramView.setBackgroundDrawable(localDrawable);
      }
      break label113;
      label379:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundDrawable(localURLDrawable);
      break label113;
      i = 0;
      break;
      label402:
      bool = true;
    }
  }
  
  public boolean b()
  {
    return this.v == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo
 * JD-Core Version:    0.7.0.1
 */