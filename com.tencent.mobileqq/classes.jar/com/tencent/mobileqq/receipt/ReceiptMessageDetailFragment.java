package com.tencent.mobileqq.receipt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.ClipboardManager;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.SeekProgressListener;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakUtils;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x984.oidb_0x984.ReadReportReq;
import tencent.im.oidb.cmd0x984.oidb_0x984.ReqBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq;
import tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.ReqBody;

public class ReceiptMessageDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, MediaPlayerManager.Callback, MediaPlayerManager.Listener, PttAudioWaveView.SeekProgressListener, QQToast.IToastValidListener
{
  private ViewGroup A;
  private QQAppInterface B;
  private TextView C;
  private MessageForPtt D;
  private PttItemBuilder.Holder E;
  private ReceiptMessageDetailFragment.ReceiptMessageDownloadCallBack F;
  private MessageObserver G = null;
  private MessageObserver H = null;
  private Handler I = new ReceiptMessageDetailFragment.DetailHandler(this);
  private Runnable J = new ReceiptMessageDetailFragment.4(this);
  private Runnable K = new ReceiptMessageDetailFragment.5(this);
  float a = 0.0F;
  private long b;
  private long c;
  private long d;
  private long e;
  private String f;
  private long g;
  private int h;
  private int i = -1;
  private int j = -1;
  private SessionInfo k;
  private boolean l;
  private boolean m;
  private int n = 0;
  private int o;
  private boolean p = false;
  private MediaPlayerManager q;
  private ETTextView r;
  private URLImageView s;
  private RelativeLayout t;
  private Button u;
  private View v;
  private PhotoProgressDrawable w;
  private ImageView x;
  private View y;
  private TextView z;
  
  private long a(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  private Rect a(ImageView paramImageView)
  {
    Rect localRect = new Rect();
    if (paramImageView != null)
    {
      if (paramImageView.getDrawable() == null) {
        return localRect;
      }
      Object localObject = new float[9];
      paramImageView.getImageMatrix().getValues((float[])localObject);
      float f1 = localObject[0];
      float f2 = localObject[4];
      localObject = paramImageView.getDrawable();
      int i1 = ((Drawable)localObject).getIntrinsicWidth();
      int i2 = ((Drawable)localObject).getIntrinsicHeight();
      i1 = Math.round(i1 * f1);
      int i3 = Math.round(i2 * f2);
      localRect.right = i1;
      localRect.bottom = i3;
      i2 = paramImageView.getWidth();
      i3 = (paramImageView.getHeight() - i3) / 2;
      localRect.left = ((i2 - i1) / 2);
      localRect.top = i3;
    }
    return localRect;
  }
  
  private PttItemBuilder.Holder a(MessageForPtt paramMessageForPtt)
  {
    PttItemBuilder.Holder localHolder = new PttItemBuilder.Holder();
    localHolder.j = new BaseChatItemLayout(BaseApplicationImpl.getContext());
    BreathAnimationLayout localBreathAnimationLayout = new BreathAnimationLayout(BaseApplicationImpl.getContext());
    Object localObject1 = new PttAudioPlayView(getBaseActivity(), 12);
    ((PttAudioPlayView)localObject1).setThemeColor(getBaseActivity().getResources().getColorStateList(2131168016).getDefaultColor());
    ((PttAudioPlayView)localObject1).setId(2131442195);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.b(34.0F, getBaseActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.b(34.0F, getBaseActivity().getResources());
    ((PttAudioPlayView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new PttAudioWaveView(getBaseActivity());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setProgressColor(getBaseActivity().getResources().getColorStateList(2131168016).getDefaultColor());
    ((PttAudioWaveView)localObject2).setId(2131442196);
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.b(10.0F, getBaseActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.b(41.0F, getBaseActivity().getResources());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((PttAudioWaveView)localObject2).setOnClickListener(this);
    localObject3 = new TextView(getBaseActivity());
    ((TextView)localObject3).setId(2131442197);
    ((TextView)localObject3).setTextColor(getBaseActivity().getResources().getColorStateList(2131168016));
    VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(getBaseActivity());
    localVoicePrintView.setId(2131442198);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new SyncParentPressedRelativeLayout(BaseApplicationImpl.getContext());
    ((RelativeLayout)localObject4).setId(2131442193);
    ((RelativeLayout)localObject4).addView((View)localObject2);
    ((RelativeLayout)localObject4).addView((View)localObject1);
    ((RelativeLayout)localObject4).addView((View)localObject3);
    ((RelativeLayout)localObject4).addView(localVoicePrintView);
    localBreathAnimationLayout.addView((View)localObject4);
    localHolder.v = localBreathAnimationLayout;
    localHolder.s = ((PttAudioPlayView)localObject1);
    localHolder.u = ((PttAudioWaveView)localObject2);
    localHolder.d = ((TextView)localObject3);
    localHolder.c = localVoicePrintView;
    localHolder.B = ((RelativeLayout)localObject4);
    localHolder.c.setVisibility(4);
    if (paramMessageForPtt.isSend())
    {
      ((RelativeLayout.LayoutParams)localHolder.d.getLayoutParams()).addRule(1, 2131442196);
      ((RelativeLayout.LayoutParams)localHolder.u.getLayoutParams()).addRule(1, 2131442195);
      ((RelativeLayout.LayoutParams)localHolder.s.getLayoutParams()).addRule(1, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localHolder.d.getLayoutParams()).addRule(1, 2131442196);
      ((RelativeLayout.LayoutParams)localHolder.u.getLayoutParams()).addRule(1, 2131442195);
      ((RelativeLayout.LayoutParams)localHolder.s.getLayoutParams()).addRule(1, -1);
    }
    int i1;
    if ((paramMessageForPtt.isSendFromLocal()) && (paramMessageForPtt.fileSize == -2L))
    {
      i2 = 999;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        localObject1 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getLastRecorderPath();
        boolean bool;
        if ((paramMessageForPtt.fileSize == -2L) && (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(paramMessageForPtt.getLocalFilePath()))) {
          bool = true;
        } else {
          bool = false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isRecording: ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject1).toString());
        i1 = i2;
      }
    }
    else
    {
      i1 = PttItemBuilder.a(this.B, paramMessageForPtt);
    }
    int i2 = i1;
    if (i1 == -1)
    {
      a(localHolder, paramMessageForPtt, false, true);
      i2 = 2001;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fileStatus = ");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(" url ");
      ((StringBuilder)localObject1).append(paramMessageForPtt.url);
      ((StringBuilder)localObject1).append(" uniseq ");
      ((StringBuilder)localObject1).append(paramMessageForPtt.uniseq);
      QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject1).toString());
    }
    a(localHolder, paramMessageForPtt, i2, a(paramMessageForPtt));
    ((IPTTPreDownloader)this.B.getRuntimeService(IPTTPreDownloader.class)).onViewPTT(paramMessageForPtt);
    PttInfoCollector.reportPttItemBuilderType(this.B, i2, paramMessageForPtt);
    if (AppSetting.e)
    {
      paramMessageForPtt = String.format(HardCodeUtil.a(2131910633), new Object[] { paramMessageForPtt.timeStr });
      localBreathAnimationLayout.setContentDescription(paramMessageForPtt);
      localHolder.B.setContentDescription(paramMessageForPtt);
    }
    return localHolder;
  }
  
  private void a()
  {
    this.r = new ETTextView(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    Resources localResources = getResources();
    int i1 = localResources.getDimensionPixelSize(2131298897);
    this.A.setPadding(i1, i1, i1, 0);
    this.r.setTextSize(0, localResources.getDimensionPixelSize(2131298900));
    this.r.setTextColor(localResources.getColor(2131168172));
    i1 = AIOUtils.b(11.0F, localResources);
    this.r.setLineSpacing(i1, 1.0F);
    this.A.setBackgroundResource(2130838249);
    ((FrameLayout.LayoutParams)this.A.getLayoutParams()).gravity = 0;
    this.A.setOnLongClickListener(new ReceiptMessageDetailFragment.OnTextLongClickedListener(this, null));
    this.A.addView(this.r, localLayoutParams);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("markMessageRealRead, readCount: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" totalCount: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" fromFetchReadStatus:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.m) && (paramBoolean)) {
      return;
    }
    Object localObject = this.B.getMessageFacade().b(this.k.b, this.h, this.b);
    if (localObject == null)
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "get message fail from mark message read");
      return;
    }
    if ((paramInt1 == 0) && (this.m))
    {
      QLog.d("ReceiptMessageDetailFragment", 2, "read count is 0 when mark message read");
      return;
    }
    if (!this.m)
    {
      ReceiptMsgManager.a(this.B, (MessageRecord)localObject, "1");
      return;
    }
    if (this.h == 0)
    {
      ReceiptMsgManager.a(this.B, (MessageRecord)localObject, "2");
      return;
    }
    if (paramInt1 >= paramInt2)
    {
      ReceiptMsgManager.a(this.B, (MessageRecord)localObject, "3");
      return;
    }
    ReceiptMsgManager.a(this.B, (MessageRecord)localObject, "4");
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setReadMemberCount, count: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSucc: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!isAdded()) {
      return;
    }
    if (paramBoolean) {
      this.v.setVisibility(4);
    }
    if (this.k.a == 0)
    {
      if (paramInt > 0)
      {
        localObject = this.u;
        if (this.m) {
          paramInt = 2131896525;
        } else {
          paramInt = 2131896527;
        }
        ((Button)localObject).setText(paramInt);
        return;
      }
      localObject = this.u;
      if (this.m) {
        paramInt = 2131896526;
      } else {
        paramInt = 2131896528;
      }
      ((Button)localObject).setText(paramInt);
      return;
    }
    this.u.setText(String.format(getString(2131896529), new Object[] { Integer.toString(paramInt) }));
    this.u.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130838247), null);
    this.u.setCompoundDrawablePadding(AIOUtils.b(5.0F, getResources()));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i3 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    double d3 = paramURLDrawable.getIntrinsicWidth();
    double d1 = paramURLDrawable.getIntrinsicHeight();
    double d2 = localDisplayMetrics.density;
    Double.isNaN(d3);
    Double.isNaN(d2);
    d3 *= d2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d4 = d1 * d2;
    boolean bool = a(d3, d4, i3, i2);
    this.t.getLayoutParams().height = -1;
    this.t.getLayoutParams().width = -1;
    int i1 = 0;
    if (!bool)
    {
      i2 = i2 - ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getContext()) - getResources().getDimensionPixelSize(2131299920) - AIOUtils.b(45.0F, getResources()) + 1;
      d2 = 2.0D * d3;
      double d5 = i3;
      d1 = d2;
      if (d2 > d5) {
        d1 = d5;
      }
      d5 = d1 * d4 / d3;
      if (d4 >= 3.0D * d3) {
        i1 = 1;
      }
      if (i1 == 0)
      {
        d2 = i2;
        if (d5 > d2)
        {
          Double.isNaN(d2);
          Double.isNaN(d2);
          d1 = d1 * d2 / d2;
          i1 = i2;
          break label276;
        }
      }
      d2 = d5;
      i1 = i2;
    }
    else
    {
      d1 = d3;
      d2 = d4;
      i1 = 0;
    }
    label276:
    this.s.getLayoutParams().height = ((int)(d2 + 0.5D));
    this.s.getLayoutParams().width = ((int)(0.5D + d1));
    this.s.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("setImageViewSize, isSmall: ");
      paramURLDrawable.append(bool);
      paramURLDrawable.append(" size: ");
      paramURLDrawable.append(d3);
      paramURLDrawable.append(" / ");
      paramURLDrawable.append(d4);
      paramURLDrawable.append(" sizeToSet: ");
      paramURLDrawable.append(d1);
      paramURLDrawable.append(" / ");
      paramURLDrawable.append(d2);
      paramURLDrawable.append(" containerHeight: ");
      paramURLDrawable.append(i1);
      QLog.d("ReceiptMessageDetailFragment", 2, paramURLDrawable.toString());
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder)
  {
    paramHolder.d.setCompoundDrawablePadding(0);
    paramHolder.d.setCompoundDrawables(null, null, null, null);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    d();
    MultiMsgManager.a().a(this.k);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = "ReceiptMessageDetailFragment.isReceipt";
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.B.getApp().getResources().getDrawable(2130838253);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.B.getApp().getResources().getDrawable(2130838230);
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = getResources().getDisplayMetrics().heightPixels;
    if ((paramMessageForPic.width > i1) || (paramMessageForPic.height > i2))
    {
      long l2 = paramMessageForPic.height;
      for (long l1 = paramMessageForPic.width; l2 * l1 > 10000000L; l1 /= 2L) {
        l2 /= 2L;
      }
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)l2);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)l1);
    }
    localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(paramMessageForPic, 1, null, (URLDrawable.URLDrawableOptions)localObject);
    this.s.setImageDrawable((Drawable)localObject);
    this.s.setOnClickListener(new ReceiptMessageDetailFragment.2(this, paramMessageForPic));
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "showPicMessage when drawable's status is succeeded");
      }
      a((URLDrawable)localObject);
      m();
    }
    try
    {
      paramMessageForPic = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130850524);
    }
    catch (OutOfMemoryError paramMessageForPic)
    {
      label281:
      Rect localRect;
      break label281;
    }
    paramMessageForPic = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
    this.w = new PhotoProgressDrawable(paramMessageForPic, (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 12.0F));
    this.w.setLevel(0);
    this.x = new ImageView(BaseApplicationImpl.getContext());
    paramMessageForPic = new RelativeLayout.LayoutParams(-2, -2);
    i1 = AIOUtils.b(40.0F, BaseApplicationImpl.getContext().getResources());
    paramMessageForPic.width = i1;
    paramMessageForPic.height = i1;
    localRect = new Rect(0, 0, i1, i1);
    this.w.setBounds(localRect);
    paramMessageForPic.addRule(13);
    this.x.setImageDrawable(this.w);
    this.t.addView(this.x, paramMessageForPic);
    this.s.setURLDrawableDownListener(new ReceiptMessageDetailFragment.3(this));
    ((URLDrawable)localObject).setAutoDownload(true);
  }
  
  private void a(MessageForText paramMessageForText)
  {
    a();
    if (!android.text.TextUtils.isEmpty(paramMessageForText.sb))
    {
      if (!android.text.TextUtils.isEmpty(paramMessageForText.sb2)) {
        a(paramMessageForText.sb2);
      } else {
        a(paramMessageForText.sb);
      }
      if (AppSetting.e)
      {
        paramMessageForText = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramMessageForText.msg);
        this.r.setContentDescription(paramMessageForText);
      }
    }
    else
    {
      this.r.setText("");
    }
    m();
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQText))
    {
      Object localObject = (QQText)paramCharSequence;
      int i2 = paramCharSequence.length();
      int i1 = 0;
      localObject = (EmoticonSpan[])((QQText)localObject).getSpans(0, i2, EmoticonSpan.class);
      if (localObject.length > 0)
      {
        i2 = localObject.length;
        while (i1 < i2)
        {
          localObject[i1].setSize((int)(this.r.getTextSize() + 0.5F) + AIOUtils.b(2.0F, this.B.getApp().getResources()));
          i1 += 1;
        }
      }
    }
    this.r.setText(paramCharSequence);
  }
  
  private boolean a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    boolean bool = ((IPicUtil)QRoute.api(IPicUtil.class)).isLongPic((int)paramDouble1, (int)paramDouble2);
    int i1 = URLDrawableHelper.AIO_IMAGE_MAX_SIZE;
    double d1;
    if ((!bool) || (paramDouble1 > paramInt1) || (paramDouble2 > paramInt2)) {
      d1 = i1;
    }
    return (paramDouble1 < d1) && (paramDouble2 < d1);
  }
  
  private void b()
  {
    try
    {
      ((ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard")).setText(this.r.getText());
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReceiptMessageDetailFragment", 2, localException.toString());
      }
    }
  }
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    if (!isAdded()) {
      return;
    }
    this.q = ((MediaPlayerManager)this.B.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
    this.D = paramMessageForPtt;
    this.E = a(paramMessageForPtt);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.weight = 0.0F;
    localLayoutParams1.gravity = 16;
    Object localObject = this.E;
    ((PttItemBuilder.Holder)localObject).h = ((PttItemBuilder.Holder)localObject).v;
    a(paramMessageForPtt, this.B.getApp(), this.E.j, this.E);
    v();
    this.E.j.setPadding(0, 0, 0, AIOUtils.b(7.0F, this.B.getApp().getResources()));
    this.E.v.setFocusable(false);
    if (AppSetting.e) {
      ViewCompat.setImportantForAccessibility(this.E.v, 2);
    }
    this.A.setBackgroundResource(2130838248);
    paramMessageForPtt = new View(BaseApplicationImpl.getContext());
    localObject = new View(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    this.A.addView(paramMessageForPtt, localLayoutParams2);
    this.A.addView(this.E.j, localLayoutParams1);
    this.A.addView((View)localObject, localLayoutParams2);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isAdded()) {
      return;
    }
    if ((paramBoolean1) && (!DeviceInfoUtil.W()))
    {
      if (this.y == null)
      {
        LayoutInflater.from(this.B.getApp()).inflate(2131624136, (ViewGroup)this.mContentView);
        this.y = this.mContentView.findViewById(2131428098);
        this.z = ((TextView)this.mContentView.findViewById(2131428099));
        this.y.setOnClickListener(this);
        localObject = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        if (this.k.a != 0) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin += AIOUtils.b(45.0F, getResources());
        }
      }
      this.y.setVisibility(0);
      if (paramBoolean2) {
        this.z.setText(2131886587);
      } else {
        this.z.setText(2131886586);
      }
      this.y.setSelected(paramBoolean2);
      return;
    }
    Object localObject = this.y;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void c()
  {
    QQToast.makeText(this.B.getApp(), 1, 2131896521, 0).showByQueue(this);
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.B.getMultiMessageProxy().a(paramMessageForPtt, null);
    m();
  }
  
  private void d()
  {
    this.s = new URLImageView(BaseApplicationImpl.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.s.setAdjustViewBounds(true);
    if (AppSetting.e) {
      this.s.setContentDescription(HardCodeUtil.a(2131910636));
    }
    this.A.setBackgroundColor(Color.parseColor("#f7f7f9"));
    this.t = new RelativeLayout(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.t.addView(this.s, localLayoutParams);
    this.A.setBackgroundResource(2130838248);
    this.A.addView(this.t, localLayoutParams1);
  }
  
  private void g()
  {
    Bundle localBundle = getArguments();
    this.b = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_uni_seq", -1L);
    this.k = ((SessionInfo)localBundle.getParcelable("ReceiptMessageDetailFragment.extra_msg_session_info"));
    this.f = localBundle.getString("ReceiptMessageDetailFragment.extra_res_id");
    this.c = localBundle.getLong("ReceiptMessageDetailFragment.extra_shmsgseq", -1L);
    this.d = a(localBundle.getString("ReceiptMessageDetailFragment.extra_sender_uin"));
    this.e = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_uid", -1L);
    this.g = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_time", -1L);
    this.h = localBundle.getInt("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", -1);
    this.l = localBundle.getBoolean("ReceiptMessageDetailFragment.EXTRA_IS_READ", false);
    boolean bool;
    if (a(this.B.getCurrentAccountUin()) == this.d) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
    if ((this.b < 0L) || (this.k == null) || (this.d < 0L) || (this.e < 0L)) {
      QLog.d("ReceiptMessageDetailFragment", 1, "invalid msg seq or null session info");
    }
    ThreadManager.post(new ReceiptMessageDetailFragment.1(this), 8, null, false);
  }
  
  private void h()
  {
    Object localObject = MultiMsgManager.a().a(this.B, this.b);
    Message localMessage = this.I.obtainMessage(0);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (ChatMessage)((List)localObject).get(((List)localObject).size() - 1);
      ((ChatMessage)localObject).parse();
      localMessage.obj = localObject;
      if ((localObject instanceof MessageForText)) {
        localMessage.what = 1;
      } else if ((localObject instanceof MessageForPic)) {
        localMessage.what = 2;
      }
      if ((localObject instanceof MessageForPtt)) {
        localMessage.what = 3;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryLocalMessages, message is ");
        localStringBuilder.append(((ChatMessage)localObject).toString());
        QLog.d("ReceiptMessageDetailFragment", 2, localStringBuilder.toString());
      }
    }
    this.I.sendMessage(localMessage);
  }
  
  private void i()
  {
    if (!isAdded()) {
      return;
    }
    this.u = ((Button)this.mContentView.findViewById(2131444208));
    View localView = this.mContentView.findViewById(2131429638);
    this.v = this.mContentView.findViewById(2131437647);
    this.u.setOnClickListener(this);
    localView.setTouchDelegate(new TouchDelegate(new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, AIOUtils.b(45.0F, getResources())), this.u));
    a(0, false);
    if (this.k.a == 0) {
      this.u.setClickable(false);
    }
    localView.setVisibility(0);
  }
  
  private void j()
  {
    this.p = true;
    if (this.k.a == 0)
    {
      QQToast.makeText(this.B.getApp(), 1, 2131896511, 0).showByQueue(this);
      return;
    }
    QQToast.makeText(this.B.getApp(), 1, 2131896512, 0).showByQueue(this);
  }
  
  private void k()
  {
    this.mContentView.findViewById(2131432603).setVisibility(0);
    stopTitleProgress();
  }
  
  private void l()
  {
    if (this.F == null) {
      this.F = new ReceiptMessageDetailFragment.ReceiptMessageDownloadCallBack(this);
    }
    ReceiptMsgManager localReceiptMsgManager = ReceiptMsgManager.a();
    QQAppInterface localQQAppInterface = this.B;
    localReceiptMsgManager.a(localQQAppInterface, this.f, localQQAppInterface.getCurrentAccountUin(), this.k.b, this.k.b, this.k.a, this.b, 1035, this.F);
  }
  
  private void m()
  {
    if (this.m) {
      return;
    }
    if (this.l)
    {
      this.I.sendEmptyMessage(4);
      return;
    }
    ThreadManager.post(this.J, 8, null, false);
  }
  
  private void n()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.g);
    localReqBody.uint64_group_code.set(a(this.k.b));
    localReqBody.uint32_msg_seq.set((int)this.c);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.d);
    ProtoUtils.a(this.B, new ReceiptMessageDetailFragment.TroopSendReadReportCallback(this), localReqBody.toByteArray(), "OidbSvc.0x986_0", 2438, 0);
  }
  
  private void o()
  {
    oidb_0x984.ReqBody localReqBody = new oidb_0x984.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x984.ReadReportReq localReadReportReq = new oidb_0x984.ReadReportReq();
    localReadReportReq.uint32_msg_seq.set((int)this.c);
    localReadReportReq.uint64_conf_uin.set(a(this.k.b));
    localReadReportReq.uint64_from_uin.set(this.d);
    localReqBody.msg_read_report_req.set(localReadReportReq);
    ProtoUtils.a(this.B, new ReceiptMessageDetailFragment.DiscussionSendReadReportCallback(this), localReqBody.toByteArray(), "OidbSvc.0x984_0", 2436, 0);
  }
  
  private int p()
  {
    return 0xFFFF & (int)this.c;
  }
  
  private void q()
  {
    if ((this.k.a == 0) && (!this.m)) {
      return;
    }
    ThreadManager.post(this.K, 8, null, false);
  }
  
  private void r()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.g);
    localReqBody.uint64_group_code.set(a(this.k.b));
    localReqBody.uint32_msg_seq.set((int)this.c);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.d);
    ProtoUtils.a(this.B, new ReceiptMessageDetailFragment.TroopFetchReadStatusCallback(this), localReqBody.toByteArray(), "OidbSvc.0x986_2", 2438, 2);
  }
  
  private void s()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.c);
    localGetReadListReq.uint64_conf_uin.set(a(this.k.b));
    localGetReadListReq.uint64_from_uin.set(this.d);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    ProtoUtils.a(this.B, new ReceiptMessageDetailFragment.DiscussionFetchReadStatusCallback(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private MessageObserver t()
  {
    if (this.G == null) {
      this.G = new ReceiptMessageDetailFragment.6(this);
    }
    return this.G;
  }
  
  private MessageObserver u()
  {
    if (this.H == null) {
      this.H = new ReceiptMessageDetailFragment.7(this);
    }
    return this.H;
  }
  
  private void v()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.E.h.getLayoutParams();
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(13);
  }
  
  private void w()
  {
    int i1 = this.n + 1;
    this.n = i1;
    if (i1 < 3)
    {
      m();
      if (QLog.isDebugVersion())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resend read report, retry count: ");
        localStringBuilder.append(this.n);
        QLog.d("ReceiptMessageDetailFragment", 4, localStringBuilder.toString());
      }
    }
    else
    {
      this.I.sendEmptyMessage(5);
    }
  }
  
  private void x()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SESSION_INFO", this.k);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SENDER_UIN", this.d);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", this.c);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_IS_SENDER", this.m);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_UNISEQ", this.b);
    if (this.k.a == 1)
    {
      localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_TROOP_CODE", a(this.k.b));
      localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_TIME", this.g);
    }
    if (getBaseActivity() == null) {
      return;
    }
    PublicFragmentActivity.a(getBaseActivity(), localIntent, ReceiptMessageReadMemberListContainerFragment.class, 100);
  }
  
  public void a(int paramInt)
  {
    if (getBaseActivity() == null) {
      return;
    }
    getBaseActivity().setVolumeControlStream(3);
    b(false, false);
  }
  
  public void a(Context paramContext, ImageView paramImageView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    localObject = new int[2];
    paramImageView.getLocationOnScreen((int[])localObject);
    paramImageView = a(paramImageView);
    paramImageView.offset(localObject[0], localObject[1]);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
    localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", 0);
    if (paramSessionInfo.a == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.b);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.c);
    }
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    } else {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", true);
    localBundle.putBoolean("extra.IS_RECEIPT_MSG", true);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    localObject = paramChatMessage.selfuin;
    paramImageView = (ImageView)localObject;
    if (paramChatMessage.isMultiMsg) {}
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramImageView = (ImageView)localObject;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramImageView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramImageView)
    {
      for (;;)
      {
        boolean bool;
        paramImageView = (ImageView)localObject;
      }
    }
    localObject = (IOCRService)getBaseActivity().app.getRuntimeService(IOCRService.class, "");
    bool = ((IOCRService)localObject).isSupportOcr(getBaseActivity().app.getCurrentAccountUin(), 1);
    localBundle.putBoolean("extra.OCR", bool);
    if (bool)
    {
      localObject = ((IOCRService)localObject).getAIOText(getBaseActivity().app.getCurrentAccountUin());
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        localBundle.putString("extra.OCR_TEXT", (String)localObject);
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.a);
    localBundle.putString("uin", paramChatMessage.frienduin);
    localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
    PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1, -1);
    if (QLog.isColorLevel()) {
      QLog.i("ReceiptMessageDetailFragment", 2, "ReceiptMessageDetailFragment.enterImagePreview()");
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i2 = BaseChatItemLayout.k;
    int i1 = i2;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i1 = i2 - AIOUtils.b(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), i1, BaseChatItemLayout.getBubblePaddingAlignHead(), BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignHead(), i1, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0)
      {
        paramViewHolder.d.setTextColor(-16777216);
        if (paramViewHolder.f != null) {
          paramViewHolder.f.setTextColor(-16777216);
        }
      }
      else
      {
        paramViewHolder.d.setTextColor(paramBubbleInfo.l);
        if (paramViewHolder.f != null) {
          paramViewHolder.f.setTextColor(paramBubbleInfo.l);
        }
      }
      if ((paramBubbleInfo.p) && (((ChatBackgroundManager)this.B.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(BaseApplicationImpl.getContext(), this.k, paramViewHolder.d.getCurrentTextColor(), paramViewHolder.i.q * 10000.0D) == 1))
      {
        float f2 = paramViewHolder.d.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.d.setTextColor(-1);
        paramViewHolder.d.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.n);
      }
      return;
    }
    paramView = paramView.getResources();
    int i1;
    if (paramChatMessage.isSend()) {
      i1 = 2131168020;
    } else {
      i1 = 2131168016;
    }
    paramView = paramView.getColorStateList(i1);
    if ((paramViewHolder.d != null) && (paramView != null)) {
      paramViewHolder.d.setTextColor(paramView);
    }
    if ((paramViewHolder.f != null) && (paramView != null)) {
      paramViewHolder.f.setTextColor(paramView);
    }
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onStartSeek ");
    }
    MediaPlayerManager.a(this.B).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      paramPttAudioWaveView = new StringBuilder();
      paramPttAudioWaveView.append("onSeekProgressUpdate, progress = ");
      paramPttAudioWaveView.append(paramFloat);
      QLog.d("ReceiptMessageDetailFragment", 2, paramPttAudioWaveView.toString());
    }
    this.a = paramFloat;
    paramPttAudioWaveView = this.D;
    if (paramPttAudioWaveView != null)
    {
      paramPttAudioWaveView.playProgress = paramFloat;
      if ((this.E.s != null) && (!this.E.s.getPlayState())) {
        return;
      }
      int i1 = (int)(paramFloat * (this.D.voiceLength * 1000.0F));
      if (QLog.isColorLevel())
      {
        paramPttAudioWaveView = new StringBuilder();
        paramPttAudioWaveView.append("onSeekProgressUpdate, offset = ");
        paramPttAudioWaveView.append(i1);
        QLog.d("ReceiptMessageDetailFragment", 2, paramPttAudioWaveView.toString());
      }
      MediaPlayerManager.a(this.B).b(this.D, i1);
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fileStatus is:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",url is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.url);
      ((StringBuilder)localObject1).append(",uniseq is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.uniseq);
      ((StringBuilder)localObject1).append(",stt is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.sttAbility);
      ((StringBuilder)localObject1).append(",long is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.longPttVipFlag);
      QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject1).toString());
    }
    paramHolder.j.setUnread(false);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.B.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    if (paramHolder.w != null)
    {
      paramHolder.w.setVisibility(8);
      paramHolder.w.setOnClickListener(null);
      paramHolder.x.setVisibility(8);
    }
    if (paramHolder.f != null)
    {
      paramHolder.f.setVisibility(8);
      paramHolder.f.setOnClickListener(null);
      paramHolder.y.setVisibility(8);
      paramHolder.z.setVisibility(8);
    }
    paramHolder.j.setTailMessage(false, null, null);
    paramHolder.B.setOnTouchListener(paramHolder.D);
    paramHolder.B.setOnLongClickListener(paramHolder.D);
    localObject1 = BaseApplicationImpl.getContext().getResources();
    int i1 = AIOUtils.b(15.0F, (Resources)localObject1);
    if (paramInt != -1)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          break;
        case 2004: 
        case 2005: 
          paramHolder.d.setText("");
          paramHolder.d.setPadding(AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.o);
          if (paramHolder.c != null) {
            paramHolder.c.setVisibility(8);
          }
          a(paramHolder);
          paramHolder.v.setAnimating(false);
          ((RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams()).width = i1;
          paramHolder.u.setVisibility(4);
          paramInt = 1;
        }
        break;
      case 1001: 
      case 1002: 
      case 1003: 
      case 1004: 
      case 1005: 
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("voiceLength showPttItem builder");
          ((StringBuilder)localObject2).append(paramMessageForPtt.voiceLength);
          QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramMessageForPtt.voiceLength <= 1) {
          paramMessageForPtt.voiceLength = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
        }
        if (paramMessageForPtt.voiceLength <= 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "get a amr file length = 0 return now");
          }
          paramHolder.d.setText("");
          paramHolder.d.setPadding(AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.o);
          if (paramHolder.c != null) {
            paramHolder.c.setVisibility(8);
          }
          return;
        }
        if (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.B, "ConvertText_MaxPtt")) {
          paramMessageForPtt.sttAbility = 0;
        }
        if ((android.text.TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (android.text.TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
          paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
        }
        Object localObject3 = paramMessageForPtt.timeStr;
        paramHolder.d.setText((CharSequence)localObject3);
        a(paramHolder);
        paramHolder.v.setAnimating(false);
        paramHolder.B.setOnClickListener(this);
        if (paramMessageForPtt.isSend())
        {
          if (paramMessageForPtt.mRobotFlag == 1)
          {
            localObject2 = ((TroopRobotManager)this.B.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.B, paramMessageForPtt);
            if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
              paramHolder.j.setTailMessage(false, null, null);
            } else {
              paramHolder.j.setTailMessage(true, (CharSequence)localObject2, null);
            }
          }
        }
        else
        {
          localObject2 = ((TroopRobotManager)this.B.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.B, paramMessageForPtt);
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            paramHolder.j.setTailMessage(true, (CharSequence)localObject2, null);
          }
        }
        if ((paramInt != 2003) && (paramInt != 1003))
        {
          if ((paramInt != 1005) && (paramInt != 1004))
          {
            i1 = 1;
            paramInt = 4;
          }
          else
          {
            i1 = 1;
            paramInt = 1;
          }
        }
        else
        {
          if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
            paramHolder.j.setUnread(true);
          }
          if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
            i1 = 2;
          } else {
            i1 = 1;
          }
          paramInt = 0;
        }
        int i4 = AIOUtils.b(9.0F, (Resources)localObject1);
        int i5 = AIOUtils.b(12.0F, (Resources)localObject1);
        int i6 = ((Resources)localObject1).getDrawable(2130846265).getIntrinsicHeight();
        int i2 = AIOUtils.b(1.0F, (Resources)localObject1);
        int i3 = AIOUtils.b(3.0F, (Resources)localObject1);
        paramHolder.d.setPadding(0, BaseChatItemLayout.n, i4, BaseChatItemLayout.o);
        paramHolder.u.setPadding(0, 0, i3, 0);
        paramHolder.s.setPadding(i4, 0, i4, 0);
        if (i1 == 2)
        {
          if (paramHolder.f == null)
          {
            localObject2 = new ImageView(BaseApplicationImpl.getContext());
            ((ImageView)localObject2).setImageDrawable(new ColorDrawable(838860800));
            RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i2);
            ((ImageView)localObject2).setLayoutParams(localLayoutParams1);
            ((ImageView)localObject2).setId(2131442213);
            ETTextView localETTextView = new ETTextView(BaseApplicationImpl.getContext());
            if (paramMessageForPtt.isSend()) {
              i2 = 2131168020;
            } else {
              i2 = 2131168016;
            }
            Object localObject4 = ((Resources)localObject1).getColorStateList(i2);
            if (localObject4 != null) {
              localETTextView.setTextColor((ColorStateList)localObject4);
            }
            localETTextView.setId(2131442212);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ImageView localImageView = new ImageView(BaseApplicationImpl.getContext());
            RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            localImageView.setLayoutParams(localLayoutParams2);
            localImageView.setImageResource(2130846265);
            localImageView.setScaleType(ImageView.ScaleType.FIT_END);
            localLayoutParams1.addRule(3, 2131442193);
            localLayoutParams1.addRule(14);
            ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131442213);
            localLayoutParams2.addRule(3, 2131442213);
            localLayoutParams2.addRule(14);
            localLayoutParams2.addRule(6, 2131442212);
            localLayoutParams2.addRule(8, 2131442212);
            paramHolder.v.addView((View)localObject2);
            paramHolder.v.addView(localETTextView);
            paramHolder.v.addView(localImageView);
            paramHolder.y = ((ImageView)localObject2);
            paramHolder.f = localETTextView;
            paramHolder.z = localImageView;
          }
          else
          {
            paramHolder.y.setVisibility(0);
            paramHolder.f.setVisibility(0);
            paramHolder.z.setVisibility(0);
          }
          paramHolder.f.setOnClickListener(this);
          paramHolder.f.setOnTouchListener(paramHolder.D);
          paramHolder.f.setOnLongClickListener(paramHolder.D);
          paramHolder.f.setTextSize(0, this.k.r);
          paramHolder.g = new AIOSelectableDelegateProxy();
          paramHolder.g.a(paramHolder.f);
          paramHolder.g.a(paramHolder.j, paramHolder.j);
          paramHolder.g.b(paramMessageForPtt);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.y.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131442193);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131442193);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131442193);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131442193);
          i2 = AIOUtils.b(22.0F, (Resources)localObject1);
          paramHolder.y.setPadding(i4, 0, i4, 0);
          paramHolder.f.setPadding(i4, BaseChatItemLayout.n, i4, i2 + i6);
          paramHolder.z.setPadding(0, 0, 0, i5);
          localObject2 = paramMessageForPtt.sttText;
          localObject1 = localObject2;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getBaseActivity().getString(2131916817);
          }
          paramHolder.f.setText((CharSequence)localObject1);
        }
        float f1;
        if (i1 == 2)
        {
          localObject2 = paramMessageForPtt.sttText;
          localObject1 = localObject2;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getBaseActivity().getString(2131916817);
          }
          if (this.C == null) {
            this.C = new TextView(getBaseActivity());
          }
          this.C.setTextSize(0, this.k.r);
          f1 = this.C.getPaint().measureText((String)localObject1);
        }
        else
        {
          f1 = 0.0F;
        }
        i1 = (int)AIOUtils.a((int)paramHolder.d.getPaint().measureText((String)localObject3), getBaseActivity().getResources());
        i1 = PttItemBuilder.a(getBaseActivity(), paramMessageForPtt.voiceLength, f1, i4 + i1, i3, false, false);
        localObject1 = (RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = i1;
        localObject3 = VoicePrintUtils.a(this.B, false, false, i1 + i4, paramHolder);
        Object localObject2 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (localObject3[0] + localObject3[1] + localObject3[2]);
        ((RelativeLayout.LayoutParams)localObject2).height = VoicePrintUtils.a(this.B, false, paramHolder);
        if (paramHolder.c != null)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = (localObject3[0] + localObject3[1] + localObject3[2]);
          ((RelativeLayout.LayoutParams)localObject2).height = VoicePrintUtils.a(this.B, false, paramHolder);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("message seq=");
            ((StringBuilder)localObject3).append(paramMessageForPtt.uniseq);
            ((StringBuilder)localObject3).append(", VpLp.width=");
            ((StringBuilder)localObject3).append(((RelativeLayout.LayoutParams)localObject2).width);
            ((StringBuilder)localObject3).append(", flagTimeContainer.getLeft()=");
            ((StringBuilder)localObject3).append(paramHolder.B.getLeft());
            QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject3).toString());
          }
          paramHolder.c.setVisibility(4);
        }
        if (paramMessageForPtt.voiceLength > 0) {
          paramHolder.u.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject1).width - i3, paramMessageForPtt.voiceLength);
        }
        paramHolder.u.setVisibility(0);
        paramHolder.c.setVisibility(8);
        if (paramHolder.u != null) {
          paramHolder.u.setSeekListener(this);
        }
        break;
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams()).width = i1;
      paramHolder.u.setVisibility(4);
      paramHolder.d.setText("");
      paramHolder.d.setPadding(AIOUtils.b(40.0F, (Resources)localObject1), BaseChatItemLayout.n, AIOUtils.b(40.0F, (Resources)localObject1), BaseChatItemLayout.o);
      if (paramHolder.c != null) {
        paramHolder.c.setVisibility(8);
      }
      paramHolder.v.setAnimating(true);
    }
    paramInt = 0;
    i1 = paramInt;
    if (paramMessageForPtt.sttAbility == 1)
    {
      i1 = paramInt;
      if (((ISttManagerService)this.B.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) {
        i1 = 4;
      }
    }
    if (i1 != 1)
    {
      if (i1 != 4)
      {
        paramHolder.j.setFailedIconVisable(false, null);
        if (paramHolder.j.ah != null) {
          paramHolder.j.ah.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramHolder.j.setFailedIconResource(2130839590, null);
        paramHolder.j.ah.setBackgroundDrawable(null);
        ((Animatable)paramHolder.j.ah.getDrawable()).start();
      }
    }
    else
    {
      paramHolder.j.setFailedIconVisable(true, this);
      paramHolder.j.ah.setBackgroundDrawable(null);
      paramHolder = paramHolder.j.ah;
      if (paramMessageForPtt.isSendFromLocal()) {
        paramInt = 2131910635;
      } else {
        paramInt = 2131910634;
      }
      paramHolder.setContentDescription(HardCodeUtil.a(paramInt));
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ChatActivityFacade.a(this.B, this.k.b, paramMessageForPtt, false, 5, 0, paramBoolean2, new ReceiptMessageDetailFragment.PttDownloadCallBack(this));
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    paramViewHolder.k = 1;
    paramViewHolder.i = BubbleUtils.a(0, this.B, paramContext.getResources(), null, false);
    if (paramViewHolder.i != null) {
      paramViewHolder.i.a(paramViewHolder.h, null);
    }
    if (paramViewHolder.h != null)
    {
      paramViewHolder.h.setMinimumWidth(AIOUtils.b(BubbleInfo.c(), this.B.getApp().getResources()));
      paramViewHolder.h.setMinimumHeight(AIOUtils.b(57.0F, this.B.getApp().getResources()));
    }
    if (paramViewHolder.i != null)
    {
      int i2 = paramChatMessage.vipBubbleDiyTextId;
      int i1 = i2;
      if (i2 <= 0) {
        i1 = SVIPHandlerConstants.b(paramChatMessage.vipBubbleID);
      }
      paramViewHolder.i.a(this.B, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), false, paramViewHolder.h, FontManagerConstants.getSenderUin(paramChatMessage), i1);
    }
    if (paramViewHolder.h != null)
    {
      paramContext = paramViewHolder.h.getBackground();
      if (paramContext != null) {
        paramContext.setAlpha(255);
      }
    }
    if (paramViewHolder.i != null) {
      a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.i);
    }
    paramChatMessage.mAnimFlag = false;
    if (paramViewHolder.h != null)
    {
      paramBaseChatItemLayout.setBubbleView(paramViewHolder.h);
      a(paramViewHolder.h, paramChatMessage);
      paramViewHolder.h.setTag(2131430083, paramViewHolder.i);
      paramViewHolder.h.setTag(2131430627, paramChatMessage);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      paramXListView = new StringBuilder();
      paramXListView.append("onPlayProgress , progress_time = ");
      paramXListView.append(paramLong);
      paramXListView.append(" , progress_ratio = ");
      paramXListView.append(paramFloat);
      QLog.d("ReceiptMessageDetailFragment", 2, paramXListView.toString());
    }
    paramXListView = this.E;
    if ((paramXListView != null) && (paramFloat > 0.0F))
    {
      this.a = paramFloat;
      if (paramXListView.u != null)
      {
        this.E.u.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForPtt)) {
          ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = this.E;
      if ((paramXListView != null) && (this.D != null) && (paramXListView.u != null))
      {
        if (paramBoolean)
        {
          this.E.u.setProgress(0.0F);
          this.D.playProgress = 0.0F;
          this.E.u.setCanSupportSlide(false);
          this.E.a(false);
        }
        if (this.E.s != null) {
          this.E.s.setPlayState(false);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNearToEar, nearEear: ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" / speakerPhoneOn:");
      localStringBuilder.append(paramBoolean2);
      QLog.d("ReceiptMessageDetailFragment", 2, localStringBuilder.toString());
    }
    if (isResumed())
    {
      AudioPanelAioHelper.a(this.B.getApp(), paramBoolean2, false, false);
      b(true, paramBoolean2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("ReceiptMessageDetailFragment", 2, String.format("onHeadsetChanged, wiredHeadsetConnect: %b, btHeadsetConnect : %b, speakerPhoneOn : %b, callFromBoradcast : %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }));
    }
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioDeviceHelper.c(this.B.getApp());
      }
    }
    AudioPanelAioHelper.a(this.B.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    if (this.q.g())
    {
      if ((!paramBoolean1) && (!paramBoolean4)) {
        paramBoolean1 = bool1;
      } else {
        paramBoolean1 = false;
      }
      b(paramBoolean1, paramBoolean3);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = this.q.f();
    return (this.q.g()) && ((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq)));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    ((IPTTPreDownloader)this.B.getRuntimeService(IPTTPreDownloader.class)).onPlayPTT(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = this.E;
      paramAudioPlayerBase.a(16);
      if (paramAudioPlayerBase.c(paramXListView.getLocalFilePath(), paramInt2))
      {
        c(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, PttItemBuilder.a(this.B, paramXListView), true);
          if (paramView.s != null) {
            paramView.s.setPlayState(true);
          }
          if (paramView.u != null) {
            paramView.u.setCanSupportSlide(true);
          }
          paramView.a(true);
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("play failed player return false ");
        paramView.append(paramXListView.getLocalFilePath());
        QLog.d("ReceiptMessageDetailFragment", 2, paramView.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("play failed not ready ");
      paramView.append(paramXListView.getLocalFilePath());
      QLog.d("ReceiptMessageDetailFragment", 2, paramView.toString());
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (getBaseActivity() == null) {
      return;
    }
    getBaseActivity().setVolumeControlStream(paramInt);
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void c(int paramInt) {}
  
  public boolean canShowToast()
  {
    return isVisible();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131896533));
    startTitleProgress();
    setLeftViewName(2131896518);
    this.A = ((ViewGroup)this.mContentView.findViewById(2131438155));
    g();
  }
  
  public void e()
  {
    if (getBaseActivity() == null) {
      return;
    }
    getBaseActivity().getWindow().addFlags(128);
    b(true, AudioDeviceHelper.a(this.B));
  }
  
  public void f()
  {
    if (getBaseActivity() == null) {
      return;
    }
    PttItemBuilder.Holder localHolder = this.E;
    if ((localHolder != null) && (localHolder.u != null) && (this.a > 0.95D))
    {
      this.E.u.setProgress(0.0F);
      this.D.playProgress = 0.0F;
      this.E.u.setCanSupportSlide(false);
      if (this.E.s != null) {
        this.E.s.setPlayState(false);
      }
      this.a = 0.0F;
    }
    localHolder = this.E;
    MessageForPtt localMessageForPtt = this.D;
    a(localHolder, localMessageForPtt, PttItemBuilder.a(this.B, localMessageForPtt), false);
    getBaseActivity().setVolumeControlStream(3);
    getBaseActivity().getWindow().clearFlags(128);
    b(false, false);
  }
  
  protected int getContentLayoutId()
  {
    return 2131624156;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100) {
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", 0);
      if (paramInt1 > 0) {
        a(paramInt1, true);
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getBaseActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.B = ((QQAppInterface)getBaseActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onClick(View paramView)
  {
    if (isAdded())
    {
      int i1;
      Object localObject1;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131444208: 
        if (this.p)
        {
          j();
        }
        else if (this.v.getVisibility() != 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "user click bottom bar before fetched read count");
          }
        }
        else
        {
          x();
          if (this.k.a == 3000) {
            i1 = 1;
          } else {
            i1 = 2;
          }
          int i2 = this.o;
          if (i2 != 1) {
            if (i2 != 2) {
              if (i2 != 3) {
                localObject1 = "";
              }
            }
          }
          for (;;)
          {
            break;
            localObject1 = "ptt";
            continue;
            localObject1 = "pic";
            continue;
            localObject1 = "msg";
          }
          if (this.m) {
            localObject2 = "0x80083EA";
          } else {
            localObject2 = "0x80083EB";
          }
          ReportController.b(this.B, "CliOper", "", "", (String)localObject2, (String)localObject2, i1, 0, "", "", (String)localObject1, "");
        }
        break;
      case 2131442193: 
      case 2131442196: 
        this.q.a(this, this);
        localObject1 = this.D;
        if (localObject1 != null) {
          if (a((ChatMessage)localObject1))
          {
            this.q.a(true);
            this.E.s.setPlayState(false);
            ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          else if ((this.D != this.q.f()) && (this.D.isReady()))
          {
            this.E.s.setPlayState(true);
            this.E.u.setCanSupportSlide(true);
            if (this.B.isVideoChatting())
            {
              QQToast.makeText(this.B.getApp(), 1, 2131892896, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
            }
            else
            {
              localObject1 = (PttAudioWaveView)paramView.findViewById(2131442196);
              if (localObject1 != null)
              {
                localObject2 = this.D;
                if (localObject2 != null)
                {
                  float f1 = ((MessageForPtt)localObject2).playProgress;
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("onClick, progress = ");
                    ((StringBuilder)localObject2).append(f1);
                    QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject2).toString());
                  }
                  if (f1 == 1.0F)
                  {
                    ((PttAudioWaveView)localObject1).setProgress(0.0F);
                    this.D.playProgress = 0.0F;
                  }
                  else
                  {
                    i1 = (int)(f1 * (this.D.voiceLength * 1000.0F));
                    break label532;
                  }
                }
              }
              i1 = 0;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("onClick, offset = ");
                ((StringBuilder)localObject1).append(i1);
                QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject1).toString());
              }
              ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
              if (!MediaPlayerManager.a(this.B).b(this.D, i1)) {
                QQToast.makeText(getBaseActivity(), 1, 2131892895, 0).show(getBaseActivity().getResources().getDimensionPixelSize(2131299920));
              }
            }
          }
        }
        break;
      case 2131428098: 
        label532:
        AudioDeviceHelper.a(AudioDeviceHelper.a(this.B) ^ true, this.B);
        this.q.c();
        b(true, AudioDeviceHelper.a(this.B));
        if (isResumed()) {
          AudioPanelAioHelper.a(this.B.getApp(), AudioDeviceHelper.a(this.B), false, false);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MessageObserver localMessageObserver = this.H;
    if (localMessageObserver != null) {
      this.B.removeObserver(localMessageObserver);
    }
    localMessageObserver = this.G;
    if (localMessageObserver != null) {
      this.B.removeObserver(localMessageObserver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MediaPlayerManager localMediaPlayerManager = this.q;
    if (localMediaPlayerManager != null)
    {
      localMediaPlayerManager.b();
      f();
      this.q.a(true);
    }
  }
  
  public void onStop()
  {
    MessageForPtt localMessageForPtt = this.D;
    if ((localMessageForPtt != null) && (a(localMessageForPtt))) {
      this.q.a(true);
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment
 * JD-Core Version:    0.7.0.1
 */