package com.tencent.mobileqq.receipt;

import ahdv;
import ahdw;
import ahdx;
import ahdy;
import ahdz;
import ahea;
import aheb;
import ahec;
import ahee;
import ahef;
import aheg;
import ahei;
import ahej;
import ahek;
import ahel;
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
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.ClipboardManager;
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
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  implements View.OnClickListener, MediaPlayerManager.Callback, MediaPlayerManager.Listener, QQToast.IToastValidListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ahej jdField_a_of_type_Ahej;
  private Handler jdField_a_of_type_AndroidOsHandler = new ahec(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private PttItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private PhotoProgressDrawable jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ahdy(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private MessageObserver jdField_b_of_type_ComTencentMobileqqAppMessageObserver;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ahdz(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private TextView g;
  
  public static int a(Context paramContext, int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    int i = Math.min(60, Math.max(1, paramInt1));
    int j;
    float f1;
    if (i > 40)
    {
      i += 40;
      j = AIOUtils.a(i + 20, paramContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label173;
      }
      i = BaseChatItemLayout.jdField_e_of_type_Int - BaseChatItemLayout.i - BaseChatItemLayout.j - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i) {
        break label176;
      }
      f1 = i;
    }
    label173:
    label176:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int k = AIOUtils.a(f2, paramContext.getResources());
        paramInt2 = j + k;
        paramInt1 = paramInt2;
        if (paramInt2 > i) {
          paramInt1 = i;
        }
        return Math.max(paramInt1, (int)f1) - k;
        i *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return j;
    }
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
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
    if ((paramImageView == null) || (paramImageView.getDrawable() == null)) {
      return localRect;
    }
    Object localObject = new float[9];
    paramImageView.getImageMatrix().getValues((float[])localObject);
    float f1 = localObject[0];
    float f2 = localObject[4];
    localObject = paramImageView.getDrawable();
    int i = ((Drawable)localObject).getIntrinsicWidth();
    int j = ((Drawable)localObject).getIntrinsicHeight();
    i = Math.round(f1 * i);
    int k = Math.round(f2 * j);
    localRect.right = i;
    localRect.bottom = k;
    j = paramImageView.getWidth();
    k = (paramImageView.getHeight() - k) / 2;
    localRect.left = ((j - i) / 2);
    localRect.top = k;
    return localRect;
  }
  
  private PttItemBuilder.Holder a(MessageForPtt paramMessageForPtt)
  {
    PttItemBuilder.Holder localHolder = new PttItemBuilder.Holder();
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = new BaseChatItemLayout(BaseApplicationImpl.getContext());
    BreathAnimationLayout localBreathAnimationLayout = new BreathAnimationLayout(BaseApplicationImpl.getContext());
    Object localObject1 = new ImageView(BaseApplicationImpl.getContext());
    ((ImageView)localObject1).setId(2131362000);
    TextView localTextView = new TextView(BaseApplicationImpl.getContext());
    localTextView.setId(2131361999);
    localTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColorStateList(2131494227));
    VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(BaseApplicationImpl.getContext());
    localVoicePrintView.setId(2131362001);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new SyncParentPressedRelativeLayout(BaseApplicationImpl.getContext());
    ((RelativeLayout)localObject2).setId(2131362002);
    ((RelativeLayout)localObject2).addView((View)localObject1);
    ((RelativeLayout)localObject2).addView(localTextView);
    ((RelativeLayout)localObject2).addView(localVoicePrintView);
    localBreathAnimationLayout.addView((View)localObject2);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = localBreathAnimationLayout;
    localHolder.c = localTextView;
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
    localHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    boolean bool;
    label414:
    int i;
    if (paramMessageForPtt.isSend())
    {
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131361999);
      ((RelativeLayout.LayoutParams)localHolder.c.getLayoutParams()).addRule(1, 2131362001);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      if ((!paramMessageForPtt.isSendFromLocal()) || (paramMessageForPtt.fileSize != -2L)) {
        break label658;
      }
      if (!QLog.isColorLevel()) {
        break label670;
      }
      localObject1 = QQRecorder.a();
      if ((paramMessageForPtt.fileSize != -2L) || (android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramMessageForPtt.getLocalFilePath()))) {
        break label652;
      }
      bool = true;
      QLog.d("ReceiptMessageDetailFragment", 2, "isRecording: " + bool);
      i = 999;
    }
    for (;;)
    {
      int j = i;
      if (i == -1)
      {
        a(localHolder, paramMessageForPtt, false, true);
        j = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "fileStatus = " + j + " url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
      }
      a(localHolder, paramMessageForPtt, j, a(paramMessageForPtt));
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramMessageForPtt);
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramMessageForPtt);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        paramMessageForPtt = String.format("语音%s秒，按钮，双击播放语音", new Object[] { paramMessageForPtt.timeStr });
        localBreathAnimationLayout.setContentDescription(paramMessageForPtt);
        localHolder.jdField_a_of_type_AndroidViewViewGroup.setContentDescription(paramMessageForPtt);
      }
      return localHolder;
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131361999);
      ((RelativeLayout.LayoutParams)localHolder.c.getLayoutParams()).addRule(1, 2131362000);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
      break;
      label652:
      bool = false;
      break label414;
      label658:
      i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      continue;
      label670:
      i = 999;
    }
  }
  
  private MessageObserver a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ahea(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "markMessageRealRead, readCount: " + paramInt1 + " totalCount: " + paramInt2 + " fromFetchReadStatus:" + paramBoolean);
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean)) {
      return;
    }
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (localMessageRecord == null)
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "get message fail from mark message read");
      return;
    }
    if ((paramInt1 == 0) && (this.jdField_b_of_type_Boolean))
    {
      QLog.d("ReceiptMessageDetailFragment", 2, "read count is 0 when mark message read");
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "1");
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "2");
      return;
    }
    if (paramInt1 >= paramInt2)
    {
      ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "3");
      return;
    }
    ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "4");
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "setReadMemberCount, count: " + paramInt + " isSucc: " + paramBoolean);
    }
    if (!isAdded()) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      if (paramInt > 0)
      {
        localButton = this.jdField_a_of_type_AndroidWidgetButton;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramInt = 2131438988;; paramInt = 2131438990)
        {
          localButton.setText(paramInt);
          return;
        }
      }
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramInt = 2131438989;; paramInt = 2131438991)
      {
        localButton.setText(paramInt);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getString(2131438987), new Object[] { Integer.toString(paramInt) }));
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130837741), null);
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(AIOUtils.a(5.0F, getResources()));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int k = localDisplayMetrics.heightPixels;
    double d2 = paramURLDrawable.getIntrinsicWidth();
    double d1 = paramURLDrawable.getIntrinsicHeight();
    float f = localDisplayMetrics.density;
    double d4 = d2 * f;
    double d5 = d1 * f;
    boolean bool = a(d4, d5, i, k);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = -1;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = -1;
    int j = 0;
    double d3;
    if (!bool)
    {
      k = k - ImmersiveUtils.a(BaseApplicationImpl.getContext()) - getResources().getDimensionPixelSize(2131558448) - AIOUtils.a(45.0F, getResources()) + 1;
      d2 = 2.0D * d4;
      d1 = d2;
      if (d2 > i) {
        d1 = i;
      }
      double d6 = d1 * d5 / d4;
      if (d5 >= 3.0D * d4)
      {
        i = 1;
        j = k;
        d2 = d6;
        d3 = d1;
        if (i == 0)
        {
          j = k;
          d2 = d6;
          d3 = d1;
          if (d6 > k)
          {
            d2 = k;
            d3 = d1 * d2 / k;
            j = k;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = ((int)(0.5D + d2));
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = ((int)(0.5D + d3));
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "setImageViewSize, isSmall: " + bool + " size: " + d4 + " / " + d5 + " sizeToSet: " + d3 + " / " + d2 + " containerHeight: " + j);
      }
      return;
      i = 0;
      break;
      d2 = d5;
      d3 = d4;
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder)
  {
    paramHolder.c.setCompoundDrawablePadding(0);
    paramHolder.c.setCompoundDrawables(null, null, null, null);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    e();
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = "ReceiptMessageDetailFragment.isReceipt";
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130837747);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130837730);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    if ((paramMessageForPic.width > i) || (paramMessageForPic.height > j))
    {
      long l2 = paramMessageForPic.height;
      for (long l1 = paramMessageForPic.width; l2 * l1 > 10000000L; l1 /= 2L) {
        l2 /= 2L;
      }
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)l2);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)l1);
    }
    localObject = URLDrawableHelper.a(paramMessageForPic, 1, null, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new ahdw(this, paramMessageForPic));
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "showPicMessage when drawable's status is succeeded");
      }
      a((URLDrawable)localObject);
      p();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new ahdx(this));
      ((URLDrawable)localObject).setAutoDownload(true);
      return;
      try
      {
        paramMessageForPic = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844974);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = new PhotoProgressDrawable(paramMessageForPic, (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 12.0F));
        this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
        paramMessageForPic = new RelativeLayout.LayoutParams(-2, -2);
        i = AIOUtils.a(40.0F, BaseApplicationImpl.getContext().getResources());
        paramMessageForPic.width = i;
        paramMessageForPic.height = i;
        Rect localRect = new Rect(0, 0, i, i);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(localRect);
        paramMessageForPic.addRule(13);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramMessageForPic);
      }
      catch (OutOfMemoryError paramMessageForPic)
      {
        for (;;)
        {
          paramMessageForPic = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
        }
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(23));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder = a(paramMessageForPtt);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.weight = 0.0F;
    localLayoutParams1.gravity = 16;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout;
    a(paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder);
    v();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setPadding(0, 0, 0, AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setFocusable(false);
    if (AppSetting.jdField_b_of_type_Boolean) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, 2);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837742);
    paramMessageForPtt = new View(BaseApplicationImpl.getContext());
    View localView = new View(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramMessageForPtt, localLayoutParams2);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(localView, localLayoutParams2);
  }
  
  private void a(MessageForText paramMessageForText)
  {
    b();
    if (!android.text.TextUtils.isEmpty(paramMessageForText.sb)) {
      if (!android.text.TextUtils.isEmpty(paramMessageForText.sb2))
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramMessageForText.sb2);
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          paramMessageForText = com.tencent.mobileqq.text.TextUtils.d(paramMessageForText.msg);
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setContentDescription(paramMessageForText);
        }
      }
    }
    for (;;)
    {
      p();
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramMessageForText.sb);
      break;
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText("");
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isAdded()) {}
    do
    {
      return;
      if ((paramBoolean1) && (!AIOUtils.b()))
      {
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2130968660, (ViewGroup)this.jdField_e_of_type_AndroidViewView);
          this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131363053);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131363055));
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.addRule(11);
          localLayoutParams.addRule(12);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
            localLayoutParams.bottomMargin += AIOUtils.a(45.0F, getResources());
          }
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (paramBoolean2) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433376);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setSelected(paramBoolean2);
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433377);
        }
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    boolean bool = PhotoUtils.a((int)paramDouble1, (int)paramDouble2);
    int i = URLDrawableHelper.jdField_c_of_type_Int;
    return ((bool) && (paramDouble1 <= paramInt1) && (paramDouble2 <= paramInt2)) || ((paramDouble1 < i) && (paramDouble2 < i));
  }
  
  private int b()
  {
    return 0xFFFF & (int)this.jdField_b_of_type_Long;
  }
  
  private MessageObserver b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver == null) {
      this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new aheb(this);
    }
    return this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = new ETTextView(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    Resources localResources = getResources();
    int i = localResources.getDimensionPixelSize(2131559452);
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(i, i, i, 0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, localResources.getDimensionPixelSize(2131559453));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(localResources.getColor(2131494300));
    i = AIOUtils.a(11.0F, localResources);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLineSpacing(i, 1.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837743);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).gravity = 0;
    this.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(new aheg(this, null));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localLayoutParams);
  }
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt, null);
    p();
  }
  
  private void c()
  {
    try
    {
      ((ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReceiptMessageDetailFragment", 2, localException.toString());
    }
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void d()
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131439007, 0).a(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(BaseApplicationImpl.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(true);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription("图片");
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor("#f7f7f9"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837742);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
  }
  
  private void f()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_Long = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_uni_seq", -1L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localBundle.getParcelable("ReceiptMessageDetailFragment.extra_msg_session_info"));
    this.jdField_a_of_type_JavaLangString = localBundle.getString("ReceiptMessageDetailFragment.extra_res_id");
    this.jdField_b_of_type_Long = localBundle.getLong("ReceiptMessageDetailFragment.extra_shmsgseq", -1L);
    this.jdField_c_of_type_Long = a(localBundle.getString("ReceiptMessageDetailFragment.extra_sender_uin"));
    this.jdField_d_of_type_Long = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_uid", -1L);
    this.jdField_e_of_type_Long = localBundle.getLong("ReceiptMessageDetailFragment.extra_msg_time", -1L);
    this.jdField_a_of_type_Int = localBundle.getInt("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", -1);
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("ReceiptMessageDetailFragment.EXTRA_IS_READ", false);
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == this.jdField_c_of_type_Long) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if ((this.jdField_a_of_type_Long < 0L) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_c_of_type_Long < 0L) || (this.jdField_d_of_type_Long < 0L)) {
        QLog.d("ReceiptMessageDetailFragment", 1, "invalid msg seq or null session info");
      }
      ThreadManager.post(new ahdv(this), 8, null, false);
      return;
    }
  }
  
  private void g()
  {
    Object localObject = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (ChatMessage)((List)localObject).get(((List)localObject).size() - 1);
      ((ChatMessage)localObject).parse();
      localMessage.obj = localObject;
      if (!(localObject instanceof MessageForText)) {
        break label133;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      if ((localObject instanceof MessageForPtt)) {
        localMessage.what = 3;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "queryLocalMessages, message is " + ((ChatMessage)localObject).toString());
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      label133:
      if ((localObject instanceof MessageForPic)) {
        localMessage.what = 2;
      }
    }
  }
  
  private void h()
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_e_of_type_AndroidViewView.findViewById(2131363111));
    View localView = this.jdField_e_of_type_AndroidViewView.findViewById(2131363109);
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131363110);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localView.setTouchDelegate(new TouchDelegate(new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, AIOUtils.a(45.0F, getResources())), this.jdField_a_of_type_AndroidWidgetButton));
    a(0, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
    localView.setVisibility(0);
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131438997, 0).a(this);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131438996, 0).a(this);
  }
  
  private void n()
  {
    this.jdField_e_of_type_AndroidViewView.findViewById(2131363112).setVisibility(0);
    h();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Ahej == null) {
      this.jdField_a_of_type_Ahej = new ahej(this);
    }
    ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long, 1035, this.jdField_a_of_type_Ahej);
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void q()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_group_code.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReqBody.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.jdField_c_of_type_Long);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ahel(this), localReqBody.toByteArray(), "OidbSvc.0x986_0", 2438, 0);
  }
  
  private void r()
  {
    oidb_0x984.ReqBody localReqBody = new oidb_0x984.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x984.ReadReportReq localReadReportReq = new oidb_0x984.ReadReportReq();
    localReadReportReq.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReadReportReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReadReportReq.uint64_from_uin.set(this.jdField_c_of_type_Long);
    localReqBody.msg_read_report_req.set(localReadReportReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ahef(this), localReqBody.toByteArray(), "OidbSvc.0x984_0", 2436, 0);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void t()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_group_code.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReqBody.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.jdField_c_of_type_Long);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ahek(this), localReqBody.toByteArray(), "OidbSvc.0x986_2", 2438, 2);
  }
  
  private void u()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localGetReadListReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localGetReadListReq.uint64_from_uin.set(this.jdField_c_of_type_Long);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ahee(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void v()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(13);
  }
  
  private void w()
  {
    int i = this.jdField_d_of_type_Int + 1;
    this.jdField_d_of_type_Int = i;
    if (i < 3)
    {
      p();
      if (QLog.isDebugVersion()) {
        QLog.d("ReceiptMessageDetailFragment", 4, "resend read report, retry count: " + this.jdField_d_of_type_Int);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  private void x()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SENDER_UIN", this.jdField_c_of_type_Long);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", this.jdField_b_of_type_Long);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_IS_SENDER", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_UNISEQ", this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_TROOP_CODE", a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_TIME", this.jdField_e_of_type_Long);
    }
    if (getActivity() == null) {
      return;
    }
    PublicFragmentActivity.a(getActivity(), localIntent, ReceiptMessageReadMemberListContainerFragment.class, 100);
  }
  
  public void S()
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().getWindow().addFlags(128);
    a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u());
  }
  
  public void T()
  {
    if (getActivity() == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt), false);
    getActivity().setVolumeControlStream(3);
    getActivity().getWindow().clearFlags(128);
    a(false, false);
  }
  
  protected int a()
  {
    return 2130968670;
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
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.jdField_b_of_type_JavaLangString);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
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
      bool = OCRManager.a(paramChatMessage.selfuin, 1);
      localBundle.putBoolean("extra.OCR", bool);
      if (bool)
      {
        localObject = OCRManager.a(paramChatMessage.selfuin);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
          localBundle.putString("extra.OCR_TEXT", (String)localObject);
        }
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramChatMessage.frienduin);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1);
      if (QLog.isColorLevel()) {
        QLog.i("ReceiptMessageDetailFragment", 2, "ReceiptMessageDetailFragment.enterImagePreview()");
      }
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(getString(2131438978));
    g();
    b(2131439005);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_e_of_type_AndroidViewView.findViewById(2131363108));
    f();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.g;
    int i = j;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i = j - AIOUtils.a(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, i, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, i, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramViewHolder = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramViewHolder.getColorStateList(2131494230);
        if ((localHolder.c != null) && (paramViewHolder != null)) {
          localHolder.c.setTextColor(paramViewHolder);
        }
        if ((localHolder.jdField_d_of_type_AndroidWidgetTextView != null) && (paramViewHolder != null)) {
          localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
      }
    }
    for (;;)
    {
      return;
      paramViewHolder = paramViewHolder.getColorStateList(2131494227);
      break;
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        localHolder.c.setTextColor(-16777216);
        if (localHolder.jdField_d_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
      }
      while ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder.c.getCurrentTextColor(), 10000.0D * localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) == 1))
      {
        float f2 = localHolder.c.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localHolder.c.setTextColor(-1);
        localHolder.c.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.jdField_d_of_type_Int);
        return;
        localHolder.c.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        if (localHolder.jdField_d_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int j = 0;
    int i = 0;
    if (paramHolder.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
      paramHolder.e.setVisibility(8);
    }
    if (paramHolder.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramHolder.f.setVisibility(8);
      paramHolder.g.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject3 = BaseApplicationImpl.getContext().getResources();
    switch (paramInt)
    {
    default: 
      localObject1 = (SttManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
      paramInt = i;
      if (paramMessageForPtt.sttAbility == 1)
      {
        paramInt = i;
        if (((SttManager)localObject1).a(paramMessageForPtt)) {
          paramInt = 4;
        }
      }
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
        break;
      }
      break;
    }
    do
    {
      return;
      paramHolder.c.setText("");
      paramHolder.c.setPadding(AIOUtils.a(10.0F, (Resources)localObject3), BaseChatItemLayout.l, AIOUtils.a(10.0F, (Resources)localObject3), BaseChatItemLayout.m);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramHolder);
      i = 1;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      if (c(paramMessageForPtt))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843924);
        break;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845764);
      break;
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.c.setText("");
      paramHolder.c.setPadding(AIOUtils.a(40.0F, (Resources)localObject3), BaseChatItemLayout.l, AIOUtils.a(40.0F, (Resources)localObject3), BaseChatItemLayout.m);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label805;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "get a amr file length = 0 return now");
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.c.setText("");
      paramHolder.c.setPadding(AIOUtils.a(10.0F, (Resources)localObject3), BaseChatItemLayout.l, AIOUtils.a(10.0F, (Resources)localObject3), BaseChatItemLayout.m);
    } while (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label805:
    if (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
      paramMessageForPtt.sttAbility = 0;
    }
    if ((android.text.TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (android.text.TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
    }
    localObject1 = paramMessageForPtt.timeStr;
    paramHolder.c.setText((CharSequence)localObject1);
    a(paramHolder);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    label953:
    label1002:
    int k;
    label1093:
    int m;
    int n;
    if (paramMessageForPtt.isSend()) {
      if (paramBoolean)
      {
        i = 2131034206;
        if (c(paramMessageForPtt)) {
          i = 2131034351;
        }
        localObject1 = (AnimationDrawable)((Resources)localObject3).getDrawable(i);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        ((AnimationDrawable)localObject1).start();
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject1 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1384;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
        }
        k = 1;
        if ((paramInt != 2003) && (paramInt != 1003)) {
          break label1526;
        }
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
        i = k;
        paramInt = j;
        if (paramMessageForPtt.sttAbility == 2)
        {
          i = k;
          paramInt = j;
          if (paramMessageForPtt.voiceChangeFlag != 1)
          {
            i = k;
            paramInt = j;
            if (paramMessageForPtt.expandStt)
            {
              i = 2;
              paramInt = j;
            }
          }
        }
        j = AIOUtils.a(9.0F, (Resources)localObject3);
        k = AIOUtils.a(12.0F, (Resources)localObject3);
        m = ((Resources)localObject3).getDrawable(2130842205).getIntrinsicHeight();
        n = AIOUtils.a(1.0F, (Resources)localObject3);
        if (i != 1) {
          break label1590;
        }
        i = a(BaseApplicationImpl.getContext(), paramMessageForPtt.voiceLength, null, null, 0);
        if (!paramMessageForPtt.isSend()) {
          break label1558;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, j, 0);
        paramHolder.c.setPadding(0, BaseChatItemLayout.l, BaseChatItemLayout.q, BaseChatItemLayout.m);
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false, i + j, paramHolder);
      i = paramInt;
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
        break;
      }
      localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
      i = localObject1[0];
      j = localObject1[1];
      ((RelativeLayout.LayoutParams)localObject2).width = (localObject1[2] + (i + j));
      ((RelativeLayout.LayoutParams)localObject2).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramHolder);
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject2).width + ", flagTimeContainer.getLeft()=" + paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLeft());
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
      i = paramInt;
      break;
      if (c(paramMessageForPtt))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843926);
        break label953;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845772);
      break label953;
      label1384:
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject1, null);
      break label1002;
      if (paramBoolean)
      {
        i = 2131034416;
        if (c(paramMessageForPtt)) {
          i = 2131034349;
        }
        localObject1 = (AnimationDrawable)((Resources)localObject3).getDrawable(i);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        ((AnimationDrawable)localObject1).start();
      }
      for (;;)
      {
        localObject1 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject1, null);
        break;
        if (c(paramMessageForPtt)) {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843924);
        } else {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845764);
        }
      }
      label1526:
      if ((paramInt == 1005) || (paramInt == 1004))
      {
        paramInt = 1;
        i = k;
        break label1093;
      }
      paramInt = 4;
      i = k;
      break label1093;
      label1558:
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(j, 0, 0, 0);
      paramHolder.c.setPadding(BaseChatItemLayout.q, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
    }
    label1590:
    if (paramHolder.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      localObject2 = new ImageView(BaseApplicationImpl.getContext());
      ((ImageView)localObject2).setImageDrawable(new ColorDrawable(838860800));
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, n);
      ((ImageView)localObject2).setLayoutParams(localLayoutParams1);
      ((ImageView)localObject2).setId(2131362006);
      TextView localTextView = new TextView(BaseApplicationImpl.getContext());
      if (paramMessageForPtt.isSend())
      {
        localObject1 = ((Resources)localObject3).getColorStateList(2131494230);
        if (localObject1 != null) {
          localTextView.setTextColor((ColorStateList)localObject1);
        }
        localTextView.setId(2131362005);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ImageView localImageView = new ImageView(BaseApplicationImpl.getContext());
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        localImageView.setLayoutParams(localLayoutParams2);
        localImageView.setImageResource(2130842205);
        localImageView.setScaleType(ImageView.ScaleType.FIT_END);
        localLayoutParams1.addRule(3, 2131362002);
        localLayoutParams1.addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131362006);
        localLayoutParams2.addRule(3, 2131362006);
        localLayoutParams2.addRule(14);
        localLayoutParams2.addRule(6, 2131362005);
        localLayoutParams2.addRule(8, 2131362005);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject2);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
        paramHolder.f = ((ImageView)localObject2);
        paramHolder.jdField_d_of_type_AndroidWidgetTextView = localTextView;
        paramHolder.g = localImageView;
        label1874:
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        localObject2 = paramMessageForPtt.sttText;
        localObject1 = localObject2;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = BaseApplicationImpl.getContext().getString(2131433790);
        }
        if (this.g == null) {
          this.g = new TextView(BaseApplicationImpl.getContext());
        }
        this.g.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        i = a(BaseApplicationImpl.getContext(), paramMessageForPtt.voiceLength, (String)localObject1, this.g.getPaint(), 0);
        localObject2 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false, i + j, paramHolder);
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        i = AIOUtils.a(22.0F, (Resources)localObject3) + m;
        if (!paramMessageForPtt.isSend()) {
          break label2261;
        }
        localObject1 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131362002);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362002);
        localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131362002);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362002);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, j, 0);
        paramHolder.c.setPadding(0, BaseChatItemLayout.l, BaseChatItemLayout.q, BaseChatItemLayout.m);
        paramHolder.f.setPadding(j, 0, j, 0);
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, j, i);
        paramHolder.g.setPadding(0, 0, 0, k);
      }
    }
    for (;;)
    {
      label1680:
      localObject3 = paramMessageForPtt.sttText;
      localObject1 = localObject3;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = BaseApplicationImpl.getContext().getString(2131433790);
      }
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localObject1 = localObject2;
      break;
      localObject1 = ((Resources)localObject3).getColorStateList(2131494227);
      break label1680;
      paramHolder.f.setVisibility(0);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramHolder.g.setVisibility(0);
      break label1874;
      label2261:
      localObject1 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131362002);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362002);
      localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131362002);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362002);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(j, 0, 0, 0);
      paramHolder.c.setPadding(BaseChatItemLayout.q, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
      paramHolder.f.setPadding(j, 0, j, 0);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, j, i);
      paramHolder.g.setPadding(0, 0, 0, k);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView;
    if (paramMessageForPtt.isSendFromLocal()) {}
    for (paramHolder = "重新发送语音消息";; paramHolder = "重新拉取语音消息")
    {
      ((ImageView)localObject1).setContentDescription(paramHolder);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130838600, null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.getDrawable()).start();
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, 5, 0, paramBoolean2, new ahei(this));
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_Int = 1;
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, false);
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
    }
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
    {
      int j = paramChatMessage.vipBubbleDiyTextId;
      int i = j;
      if (j <= 0) {
        i = SVIPHandler.b(paramChatMessage.vipBubbleID);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), false, paramViewHolder.jdField_a_of_type_AndroidViewView, FontManager.a(paramChatMessage), i);
    }
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
      if (paramContext != null) {
        paramContext.setAlpha(255);
      }
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
      a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
    }
    paramChatMessage.mAnimFlag = false;
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramBaseChatItemLayout.setBubbleView(paramViewHolder.jdField_a_of_type_AndroidViewView);
      a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362293, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362294, paramChatMessage);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, String.format("onHeadsetChanged, wiredHeadsetConnect: %b, btHeadsetConnect : %b, speakerPhoneOn : %b, callFromBoradcast : %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }));
    }
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      }
    }
    BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label123;
      }
    }
    label123:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      a(paramBoolean1, paramBoolean3);
      return;
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
      if (paramAudioPlayer.a(paramXListView.getLocalFilePath()))
      {
        b(paramXListView);
        if (paramView != null) {
          a(paramView, paramXListView, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onNearToEar, nearEear: " + paramBoolean1 + " / speakerPhoneOn:" + paramBoolean2);
    }
    if (isResumed())
    {
      BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean2, false, false);
      a(true, paramBoolean2);
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void c(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().setVolumeControlStream(3);
    a(false, false);
  }
  
  public void d(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().setVolumeControlStream(paramInt);
  }
  
  public void e(int paramInt) {}
  
  public boolean e()
  {
    return isVisible();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramInt1 = paramIntent.getIntExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", 0);
    } while (paramInt1 <= 0);
    a(paramInt1, true);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (!isAdded()) {}
    label117:
    do
    {
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131362002: 
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this, this);
            if (!a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt)) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
            return;
          case 2131363111: 
            if (this.jdField_c_of_type_Boolean)
            {
              i();
              return;
            }
            if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4) {
              break label117;
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReceiptMessageDetailFragment", 2, "user click bottom bar before fetched read count");
        return;
        x();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          paramView = "";
          switch (this.jdField_e_of_type_Int)
          {
          default: 
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
          }
        }
        for (String str = "0x80083EA";; str = "0x80083EB")
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str, str, i, 0, "", "", paramView, "");
          return;
          i = 2;
          break;
          paramView = "pic";
          break label168;
          paramView = "msg";
          break label168;
          paramView = "ptt";
          break label168;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReady()));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131433788, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt));
    label168:
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131433789, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
    return;
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.e(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
      a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u());
      if (!isResumed()) {
        break;
      }
      BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u(), false, false);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b();
      T();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void onStop()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null) && (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment
 * JD-Core Version:    0.7.0.1
 */