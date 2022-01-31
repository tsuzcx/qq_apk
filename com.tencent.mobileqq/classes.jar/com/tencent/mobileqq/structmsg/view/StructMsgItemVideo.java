package com.tencent.mobileqq.structmsg.view;

import aijv;
import aijy;
import aijz;
import aika;
import aikb;
import aikc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
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
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVideo
  extends AbsStructMsgElement
{
  public String A;
  public String B;
  public String C;
  String E = "";
  String F = "";
  String G = "";
  String H = "";
  public String I;
  public String J;
  public String K;
  public String L;
  public aikc a;
  protected View.OnClickListener a;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  private View.OnClickListener b = new aijv(this);
  public boolean b;
  public boolean c;
  boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public StructMsgItemVideo()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aijy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aika(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.jdField_a_of_type_Int = 11;
  }
  
  public StructMsgItemVideo(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aijy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aika(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.u = paramString1;
    this.k = paramInt1;
    this.w = paramString2;
    this.x = paramString3;
    this.y = paramString4;
    this.g = paramInt2;
    this.f = paramInt3;
    this.h = paramInt4;
    this.i = paramInt5;
    this.j = paramInt6;
    this.z = paramString5;
    this.A = paramString6;
    this.B = paramString7;
    this.jdField_a_of_type_Int = 11;
  }
  
  public StructMsgItemVideo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aijy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aika(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.u = paramString1;
    this.v = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.e = m;
      this.jdField_a_of_type_Int = 11;
      return;
      m = 0;
    }
  }
  
  private void a(Context paramContext)
  {
    if ((TextUtils.isEmpty(b())) || ((!b().startsWith("http://")) && (!b().startsWith("https://")))) {}
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", b());
        PublicAccountUtil.a(localIntent, b());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(b()));
      paramContext = CGILoader.a(b());
    } while (TextUtils.isEmpty(paramContext));
    ReportController.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.e == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130838594);
      }
      if (this.jdField_a_of_type_Aikc == null) {
        this.jdField_a_of_type_Aikc = new aikc(this);
      }
      ThreadManager.post(new aijz(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.v);
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
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (a())
    {
      localBundle.putBoolean("is_public_account_video_msg", true);
      this.jdField_a_of_type_Boolean = true;
      this.C = localBundle.getString("public_account_video_title");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4)) {}
    for (boolean bool1 = true; !this.jdField_a_of_type_Boolean; bool1 = false) {
      return b(paramContext, paramView, localBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_UIN") == null) {
        break label262;
      }
      this.z = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label282;
      }
    }
    Object localObject1;
    label262:
    label282:
    for (this.A = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.A = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.E = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.F = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.G = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.H = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label302;
      }
      if (paramView.getTag(2131362177) != null)
      {
        paramContext = paramView.getTag(2131362177);
        if ((paramContext instanceof StructMsgItemVideo.Holder))
        {
          paramContext = (StructMsgItemVideo.Holder)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.z = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label302:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131362177);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131437015));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int m;
    Object localObject3;
    label547:
    Object localObject4;
    label628:
    int n;
    int i1;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.b(true);
      paramBundle.d(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        paramBundle.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      if (this.h >= this.i)
      {
        paramBundle.f = PAVideoView.e;
        paramBundle.jdField_c_of_type_Boolean = true;
        paramBundle.g = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130840920);
        ((ImageView)localObject2).setVisibility(8);
        m = AIOUtils.a(62.0F, (Resources)localObject1);
        if (bool1) {
          m = AIOUtils.a(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(m, m);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          m = AIOUtils.a(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.jdField_d_of_type_Boolean) {
            break label1351;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = m;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131362177);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131362177);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131362177);
        if (!bool1) {
          break label1361;
        }
        m = AIOUtils.a(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1429;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend())) {
          break label1374;
        }
        n = AIOUtils.a(10.0F, (Resources)localObject1) + m;
        i1 = m;
      }
    }
    for (;;)
    {
      label680:
      ((LinearLayout)localObject3).setPadding(i1, m, n, m);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131362181);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setSingleLine(true);
      label753:
      Object localObject5;
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
          break label1406;
        }
        ((TextView)localObject1).setTextSize(1, 12.0F);
        label823:
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
        paramView.setTag(2131362177, localObject5);
        paramView.setTag(this);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (StructMsgItemVideo.Holder)localObject5);
        boolean bool2 = AIOVideoPlayController.a().a(paramContext, 2, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.w);
        }
        if ((bool2) && (this.k != 4)) {
          break label1418;
        }
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.b();
      }
      for (;;)
      {
        if (this.g > 0) {
          ((StructMsgItemVideo.Holder)localObject5).b.setText(ShortVideoUtils.a(this.g * 1000));
        }
        if (!TextUtils.isEmpty(this.I)) {
          paramView.setTag(2131361855, this.I);
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
        return paramView;
        paramBundle.g = false;
        paramBundle.jdField_c_of_type_Boolean = false;
        localObject3 = ShortVideoUtils.a(this.h, this.i);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
        break;
        if (!this.jdField_c_of_type_Boolean) {
          paramBundle.setRadiusTop(5.0F);
        }
        for (;;)
        {
          paramBundle.g = true;
          paramBundle.jdField_c_of_type_Boolean = false;
          paramBundle.b(true);
          paramBundle.d(false);
          if (this.h >= this.i) {
            break label1270;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1270:
        if (this.h > this.i)
        {
          paramBundle.f = PAVideoView.jdField_c_of_type_Int;
          break;
        }
        if ((this.h == this.i) && (this.h != 0) && (this.i != 0))
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
        label1351:
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = m;
        break label547;
        label1361:
        m = AIOUtils.a(12.0F, (Resources)localObject1);
        break label628;
        label1374:
        i1 = AIOUtils.a(10.0F, (Resources)localObject1) + m;
        n = m;
        break label680;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label753;
        label1406:
        ((TextView)localObject1).setTextSize(1, 14.0F);
        break label823;
        label1418:
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
      }
      label1429:
      n = m;
      i1 = m;
    }
  }
  
  public String a()
  {
    return "video";
  }
  
  public void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null)) {
      return;
    }
    Bundle localBundle;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
      if ((VideoVolumeControl.a(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.c())))
      {
        QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
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
        str = null;
      }
      localBundle = new Bundle();
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.z);
      if (this.k <= 1) {
        break label629;
      }
    }
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.H);
    label134:
    localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
    if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
    for (String str = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; str = paramStructMsgForGeneralShare.mCreateTime)
    {
      localBundle.putString("VIDEO_CREATE_TIME", str);
      localBundle.putString("VIDEO_TIME", String.valueOf(this.j));
      localBundle.putString("VIDEO_WIDTH", String.valueOf(this.h));
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.i));
      localBundle.putString("VIDEO_VID", this.x);
      localBundle.putString("VIDEO_COVER", this.u);
      localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
      localBundle.putString("VIDEO_ARTICLE_ID", this.B);
      localBundle.putString("VIDEO_TITLE", this.C);
      boolean bool = true;
      if ((this.k == 2) || (this.k == 3)) {
        bool = false;
      }
      localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.k);
      if (!bool)
      {
        localBundle.putString("VIDEO_THIRD_ICON", this.E);
        localBundle.putString("VIDEO_THIRD_NAME", this.F);
        localBundle.putString("VIDEO_THIRD_ACTION", this.G);
        if (this.k == 2)
        {
          ThirdVideoManager.a();
          localBundle.putString("VIDEO_THIRD_URL", ThirdVideoManager.a(this.x));
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.w, "" + this.k, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
      }
      localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
      localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
      localBundle.putBoolean("VIDEO_FROM_AIO", true);
      localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
      localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
      localBundle.putInt("VIDEO_FROM_TYPE", 0);
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.putExtras(localBundle);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
      ((Activity)paramContext).overridePendingTransition(2131034165, 2131034167);
      return;
      label629:
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.A);
      break label134;
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.u = paramObjectInput.readUTF();
    this.v = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.e = Integer.parseInt(str);
      if (this.jdField_a_of_type_Int >= 7)
      {
        this.w = paramObjectInput.readUTF();
        this.x = paramObjectInput.readUTF();
        this.g = paramObjectInput.readInt();
        this.h = paramObjectInput.readInt();
        this.i = paramObjectInput.readInt();
        this.j = paramObjectInput.readInt();
        this.y = paramObjectInput.readUTF();
        this.k = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 8) {
        this.B = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        this.I = paramObjectInput.readUTF();
        this.jdField_d_of_type_Boolean = "1".equals(paramObjectInput.readUTF());
      }
      if (this.jdField_a_of_type_Int >= 10) {
        this.f = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        this.J = paramObjectInput.readUTF();
        this.K = paramObjectInput.readUTF();
        this.L = paramObjectInput.readUTF();
      }
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.jdField_a_of_type_Int).append("\n");
        paramObjectInput.append("imgUrl:").append(this.u).append("\n");
        paramObjectInput.append("videoUrl:").append(this.v).append("\n");
        paramObjectInput.append("vInfo:").append(this.w).append("\n");
        paramObjectInput.append("tInfo:").append(this.x).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.g).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.h).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.i).append("\n");
        paramObjectInput.append("type:").append(this.k).append("\n");
        paramObjectInput.append("articleID").append(this.B).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.I).append("\n");
        paramObjectInput.append("jump2Web:").append(this.jdField_d_of_type_Boolean).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.f).append("\n");
        paramObjectInput.append("]:").append("\n");
        QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.e = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.u != null)
    {
      str = this.u;
      paramObjectOutput.writeUTF(str);
      if (this.v == null) {
        break label353;
      }
      str = this.v;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.e + "");
      if (this.jdField_a_of_type_Int >= 7)
      {
        if (this.w == null) {
          break label359;
        }
        str = this.w;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.x == null) {
          break label365;
        }
        str = this.x;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.g);
        paramObjectOutput.writeInt(this.h);
        paramObjectOutput.writeInt(this.i);
        paramObjectOutput.writeInt(this.j);
        if (this.y == null) {
          break label371;
        }
        str = this.y;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.k);
      }
      if (this.jdField_a_of_type_Int >= 8)
      {
        if (this.B == null) {
          break label377;
        }
        str = this.B;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        if (this.I == null) {
          break label383;
        }
        str = this.I;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.jdField_d_of_type_Boolean) {
          break label389;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 10) {
        paramObjectOutput.writeInt(this.f);
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        if (this.J == null) {
          break label396;
        }
        str = this.J;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.K == null) {
          break label402;
        }
        str = this.K;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.L == null) {
          break label408;
        }
      }
    }
    label389:
    label396:
    label402:
    label408:
    for (String str = this.L;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      label353:
      str = "";
      break label36;
      label359:
      str = "";
      break label92;
      label365:
      str = "";
      break label111;
      label371:
      str = "";
      break label170;
      label377:
      str = "";
      break label208;
      label383:
      str = "";
      break label236;
      str = "0";
      break label254;
      str = "";
      break label301;
      str = "";
      break label320;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.u)) {
      paramXmlSerializer.attribute(null, "cover", this.u);
    }
    if (!TextUtils.isEmpty(this.v)) {
      paramXmlSerializer.attribute(null, "src", this.v);
    }
    if (!TextUtils.isEmpty(this.w)) {
      paramXmlSerializer.attribute(null, "vInfo", this.w);
    }
    if (!TextUtils.isEmpty(this.x)) {
      paramXmlSerializer.attribute(null, "tInfo", this.x);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.f));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.g));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.h));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.i));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.j));
    if (!TextUtils.isEmpty(this.y)) {
      paramXmlSerializer.attribute(null, "summary", this.y);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.k));
    if (!TextUtils.isEmpty(this.B)) {
      paramXmlSerializer.attribute(null, "aID", this.B);
    }
    if (this.e == 1) {
      paramXmlSerializer.attribute(null, "load", this.e + "");
    }
    if (!TextUtils.isEmpty(this.I)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.I);
    }
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.J)) {
        paramXmlSerializer.attribute(null, "apurl", this.J);
      }
      if (!TextUtils.isEmpty(this.K)) {
        paramXmlSerializer.attribute(null, "rl", this.K);
      }
      if (!TextUtils.isEmpty(this.L)) {
        paramXmlSerializer.attribute(null, "disType", this.L);
      }
      paramXmlSerializer.endTag(null, "video");
      return;
    }
  }
  
  public boolean a()
  {
    return (this.k >= 1) && (this.k <= 100);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.u = paramStructMsgNode.a("cover");
    this.v = paramStructMsgNode.a("src");
    String str1 = paramStructMsgNode.a("load");
    this.w = paramStructMsgNode.a("vInfo");
    this.x = paramStructMsgNode.a("tInfo");
    String str2 = paramStructMsgNode.a("preTime");
    if (str2 != null) {}
    try
    {
      this.g = Integer.valueOf(str2).intValue();
      str2 = paramStructMsgNode.a("preWidth");
      if (str2 == null) {}
    }
    catch (Exception localRuntimeException)
    {
      try
      {
        for (;;)
        {
          this.h = Integer.valueOf(str2).intValue();
          label104:
          str2 = paramStructMsgNode.a("preHeight");
          if (str2 != null) {}
          try
          {
            this.i = Integer.valueOf(str2).intValue();
            label127:
            str2 = paramStructMsgNode.a("fullTime");
            if (str2 != null) {}
            try
            {
              this.j = Integer.valueOf(str2).intValue();
              label150:
              this.y = paramStructMsgNode.a("summary");
              if (!TextUtils.isEmpty(str1)) {}
              try
              {
                this.e = Integer.parseInt(str1);
                str1 = paramStructMsgNode.a("busiType");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (RuntimeException localRuntimeException)
              {
                try
                {
                  this.k = Integer.parseInt(str1);
                  label199:
                  this.B = paramStructMsgNode.a("aID");
                  this.I = paramStructMsgNode.a("jumpUrl");
                  this.jdField_d_of_type_Boolean = "1".equals(paramStructMsgNode.a("isJump2Web"));
                  str1 = paramStructMsgNode.a("preStartPosi");
                  if (!TextUtils.isEmpty(str1)) {}
                  try
                  {
                    this.f = Integer.valueOf(str1).intValue();
                    this.J = paramStructMsgNode.a("apurl");
                    this.K = paramStructMsgNode.a("rl");
                    this.L = paramStructMsgNode.a("disType");
                    return true;
                    localException8 = localException8;
                    try
                    {
                      this.g = ((int)Float.valueOf(str2).floatValue());
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.g);
                    }
                    catch (Exception localException3) {}
                    continue;
                    localRuntimeException = localRuntimeException;
                    this.e = 0;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      try
                      {
                        this.f = ((int)Float.valueOf(localRuntimeException).floatValue());
                        if (QLog.isColorLevel()) {
                          QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.f);
                        }
                      }
                      catch (Exception localException1) {}
                    }
                  }
                }
                catch (Exception localException2)
                {
                  break label199;
                }
              }
            }
            catch (Exception localException5)
            {
              break label150;
            }
          }
          catch (Exception localException6)
          {
            break label127;
          }
        }
      }
      catch (Exception localException7)
      {
        break label104;
      }
    }
  }
  
  protected View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1 = paramContext.getResources();
    int m;
    int n;
    label113:
    Drawable localDrawable;
    if (paramBundle.getBoolean("has_cnr"))
    {
      m = AIOUtils.a(12.0F, (Resources)localObject1);
      ((Resources)localObject1).getDisplayMetrics();
      n = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130842744);
        paramView.setTag(this);
        try
        {
          localObject2 = new RoundedColorDrawable(-16777216, n, n, m);
          if (TextUtils.isEmpty(this.u))
          {
            paramView.setBackgroundDrawable((Drawable)localObject2);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            paramView.setOnClickListener(this.b);
            paramView.setOnClickListener(this.b);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            return localObject1;
            paramView = new TitledImageView(paramContext);
            paramView.setId(2131361925);
            paramView.setContentDescription(((Resources)localObject1).getString(2131433075));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131437015));
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
        localURLDrawable = URLDrawable.getDrawable(this.u, n, n, localDrawable, localDrawable);
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new aikb(this, m, n, n));
        }
        if ((AbsDownloader.a(this.u)) || (!URLDrawableHelper.a(paramContext))) {
          break label402;
        }
        localURLDrawable.setAutoDownload(bool);
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1)) {
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
      m = 0;
      break;
      label402:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo
 * JD-Core Version:    0.7.0.1
 */