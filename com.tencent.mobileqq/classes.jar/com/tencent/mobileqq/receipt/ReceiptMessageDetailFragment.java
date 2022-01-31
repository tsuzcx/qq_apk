package com.tencent.mobileqq.receipt;

import aael;
import aciy;
import acju;
import acmr;
import acms;
import adlq;
import adlr;
import adlv;
import adwz;
import ajjy;
import ajmm;
import ajrm;
import akbp;
import almt;
import alnt;
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
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.ClipboardManager;
import android.text.TextPaint;
import android.text.TextUtils;
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
import arxu;
import atdp;
import audb;
import auou;
import auov;
import auow;
import auox;
import auoy;
import auoz;
import aupa;
import aupb;
import aupd;
import aupe;
import aupf;
import aupg;
import aupw;
import auxm;
import awqx;
import awwx;
import axaf;
import axkd;
import axkk;
import axku;
import axte;
import axwd;
import azks;
import bblb;
import bbmy;
import bbna;
import bfcq;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import fv;
import java.util.List;
import mmj;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x984.oidb_0x984.ReadReportReq;
import tencent.im.oidb.cmd0x984.oidb_0x984.ReqBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq;
import tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.ReqBody;

public class ReceiptMessageDetailFragment
  extends IphoneTitleBarFragment
  implements acmr, acms, adlq, View.OnClickListener, bbna
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private adlv jdField_a_of_type_Adlv;
  private ajmm jdField_a_of_type_Ajmm;
  private Handler jdField_a_of_type_AndroidOsHandler = new auoy(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aupe jdField_a_of_type_Aupe;
  private bblb jdField_a_of_type_Bblb;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReceiptMessageDetailFragment.4(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private ajmm jdField_b_of_type_Ajmm;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ReceiptMessageDetailFragment.5(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  
  private int a()
  {
    return 0xFFFF & (int)this.jdField_b_of_type_Long;
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
  
  private adlv a(MessageForPtt paramMessageForPtt)
  {
    adlv localadlv = new adlv();
    localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = new BaseChatItemLayout(BaseApplicationImpl.getContext());
    BreathAnimationLayout localBreathAnimationLayout = new BreathAnimationLayout(BaseApplicationImpl.getContext());
    Object localObject1 = new PttAudioPlayView(getActivity(), 12);
    ((PttAudioPlayView)localObject1).setThemeColor(getActivity().getResources().getColorStateList(2131101278).getDefaultColor());
    ((PttAudioPlayView)localObject1).setId(2131307223);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).width = aciy.a(34.0F, getActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject2).height = aciy.a(34.0F, getActivity().getResources());
    ((PttAudioPlayView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new PttAudioWaveView(getActivity());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setProgressColor(getActivity().getResources().getColorStateList(2131101278).getDefaultColor());
    ((PttAudioWaveView)localObject2).setId(2131307224);
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).width = aciy.a(10.0F, getActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = aciy.a(41.0F, getActivity().getResources());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((PttAudioWaveView)localObject2).setOnClickListener(this);
    localObject3 = new TextView(getActivity());
    ((TextView)localObject3).setId(2131307225);
    ((TextView)localObject3).setTextColor(getActivity().getResources().getColorStateList(2131101278));
    VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(getActivity());
    localVoicePrintView.setId(2131307226);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new SyncParentPressedRelativeLayout(BaseApplicationImpl.getContext());
    ((RelativeLayout)localObject4).setId(2131307221);
    ((RelativeLayout)localObject4).addView((View)localObject2);
    ((RelativeLayout)localObject4).addView((View)localObject1);
    ((RelativeLayout)localObject4).addView((View)localObject3);
    ((RelativeLayout)localObject4).addView(localVoicePrintView);
    localBreathAnimationLayout.addView((View)localObject4);
    localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = localBreathAnimationLayout;
    localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)localObject1);
    localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
    localadlv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
    localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
    localadlv.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
    boolean bool;
    label597:
    int i;
    if (paramMessageForPtt.isSend())
    {
      ((RelativeLayout.LayoutParams)localadlv.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131307224);
      ((RelativeLayout.LayoutParams)localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131307223);
      ((RelativeLayout.LayoutParams)localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      if ((!paramMessageForPtt.isSendFromLocal()) || (paramMessageForPtt.fileSize != -2L)) {
        break label844;
      }
      if (!QLog.isColorLevel()) {
        break label856;
      }
      localObject1 = QQRecorder.a();
      if ((paramMessageForPtt.fileSize != -2L) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramMessageForPtt.getLocalFilePath()))) {
        break label838;
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
        a(localadlv, paramMessageForPtt, false, true);
        j = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "fileStatus = " + j + " url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
      }
      a(localadlv, paramMessageForPtt, j, a(paramMessageForPtt));
      audb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramMessageForPtt);
      axte.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramMessageForPtt);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramMessageForPtt = String.format(ajjy.a(2131647352), new Object[] { paramMessageForPtt.timeStr });
        localBreathAnimationLayout.setContentDescription(paramMessageForPtt);
        localadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt);
      }
      return localadlv;
      ((RelativeLayout.LayoutParams)localadlv.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131307224);
      ((RelativeLayout.LayoutParams)localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131307223);
      ((RelativeLayout.LayoutParams)localadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      break;
      label838:
      bool = false;
      break label597;
      label844:
      i = adlr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      continue;
      label856:
      i = 999;
    }
  }
  
  private ajmm a()
  {
    if (this.jdField_a_of_type_Ajmm == null) {
      this.jdField_a_of_type_Ajmm = new auow(this);
    }
    return this.jdField_a_of_type_Ajmm;
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
  
  private void a()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = new ETTextView(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    Resources localResources = getResources();
    int i = localResources.getDimensionPixelSize(2131166851);
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(i, i, i, 0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, localResources.getDimensionPixelSize(2131166854));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(localResources.getColor(2131101377));
    i = aciy.a(11.0F, localResources);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLineSpacing(i, 1.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838074);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).gravity = 0;
    this.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(new aupb(this, null));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localLayoutParams);
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
      aupw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "1");
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      aupw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "2");
      return;
    }
    if (paramInt1 >= paramInt2)
    {
      aupw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "3");
      return;
    }
    aupw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, "4");
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
        for (paramInt = 2131632796;; paramInt = 2131632798)
        {
          localButton.setText(paramInt);
          return;
        }
      }
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramInt = 2131632797;; paramInt = 2131632799)
      {
        localButton.setText(paramInt);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getString(2131632800), new Object[] { Integer.toString(paramInt) }));
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130838072), null);
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(aciy.a(5.0F, getResources()));
  }
  
  private void a(adlv paramadlv)
  {
    paramadlv.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramadlv.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = -1;
    int j = 0;
    double d3;
    if (!bool)
    {
      k = k - ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getContext()) - getResources().getDimensionPixelSize(2131167766) - aciy.a(45.0F, getResources()) + 1;
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
  
  private void a(MessageForPic paramMessageForPic)
  {
    d();
    arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = "ReceiptMessageDetailFragment.isReceipt";
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838078);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838061);
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
    localObject = axwd.a(paramMessageForPic, 1, null, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new auou(this, paramMessageForPic));
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "showPicMessage when drawable's status is succeeded");
      }
      a((URLDrawable)localObject);
      k();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new auov(this));
      ((URLDrawable)localObject).setAutoDownload(true);
      return;
      try
      {
        paramMessageForPic = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130847412);
        this.jdField_a_of_type_Bblb = new bblb(paramMessageForPic, (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 12.0F));
        this.jdField_a_of_type_Bblb.setLevel(0);
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
        paramMessageForPic = new RelativeLayout.LayoutParams(-2, -2);
        i = aciy.a(40.0F, BaseApplicationImpl.getContext().getResources());
        paramMessageForPic.width = i;
        paramMessageForPic.height = i;
        Rect localRect = new Rect(0, 0, i, i);
        this.jdField_a_of_type_Bblb.setBounds(localRect);
        paramMessageForPic.addRule(13);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bblb);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramMessageForPic);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
    this.jdField_a_of_type_Adlv = a(paramMessageForPtt);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.weight = 0.0F;
    localLayoutParams1.gravity = 16;
    this.jdField_a_of_type_Adlv.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout;
    a(paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_Adlv);
    q();
    this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setPadding(0, 0, 0, aciy.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
    this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setFocusable(false);
    if (AppSetting.jdField_c_of_type_Boolean) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, 2);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838073);
    paramMessageForPtt = new View(BaseApplicationImpl.getContext());
    View localView = new View(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramMessageForPtt, localLayoutParams2);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(localView, localLayoutParams2);
  }
  
  private void a(MessageForText paramMessageForText)
  {
    a();
    if (!TextUtils.isEmpty(paramMessageForText.sb)) {
      if (!TextUtils.isEmpty(paramMessageForText.sb2))
      {
        a(paramMessageForText.sb2);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          paramMessageForText = axku.e(paramMessageForText.msg);
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setContentDescription(paramMessageForText);
        }
      }
    }
    for (;;)
    {
      k();
      return;
      a(paramMessageForText.sb);
      break;
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText("");
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    int i = 0;
    if ((paramCharSequence instanceof axkd))
    {
      axkk[] arrayOfaxkk = (axkk[])((axkd)paramCharSequence).getSpans(0, paramCharSequence.length(), axkk.class);
      if (arrayOfaxkk.length > 0)
      {
        int j = arrayOfaxkk.length;
        while (i < j)
        {
          arrayOfaxkk[i].a((int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + 0.5F) + aciy.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
          i += 1;
        }
      }
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramCharSequence);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isAdded()) {}
    do
    {
      return;
      if ((paramBoolean1) && (!aciy.b()))
      {
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131493026, (ViewGroup)this.mContentView);
          this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131296824);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131296825));
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.addRule(11);
          localLayoutParams.addRule(12);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
            localLayoutParams.bottomMargin += aciy.a(45.0F, getResources());
          }
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (paramBoolean2) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131624458);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setSelected(paramBoolean2);
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131624457);
        }
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    boolean bool = auxm.a((int)paramDouble1, (int)paramDouble2);
    int i = axwd.jdField_c_of_type_Int;
    return ((bool) && (paramDouble1 <= paramInt1) && (paramDouble2 <= paramInt2)) || ((paramDouble1 < i) && (paramDouble2 < i));
  }
  
  private ajmm b()
  {
    if (this.jdField_b_of_type_Ajmm == null) {
      this.jdField_b_of_type_Ajmm = new auox(this);
    }
    return this.jdField_b_of_type_Ajmm;
  }
  
  private void b()
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
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt, null);
    k();
  }
  
  private void c()
  {
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131632792, 0).a(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(BaseApplicationImpl.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(true);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(ajjy.a(2131647355));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor("#f7f7f9"));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838073);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
  }
  
  private void e()
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
      ThreadManager.post(new ReceiptMessageDetailFragment.1(this), 8, null, false);
      return;
    }
  }
  
  private void f()
  {
    Object localObject = arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
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
  
  private void g()
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131308985));
    View localView = this.mContentView.findViewById(2131297793);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131303825);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localView.setTouchDelegate(new TouchDelegate(new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, aciy.a(45.0F, getResources())), this.jdField_a_of_type_AndroidWidgetButton));
    a(0, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
    localView.setVisibility(0);
  }
  
  private void h()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131632781, 0).a(this);
      return;
    }
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131632782, 0).a(this);
  }
  
  private void i()
  {
    this.mContentView.findViewById(2131300143).setVisibility(0);
    stopTitleProgress();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Aupe == null) {
      this.jdField_a_of_type_Aupe = new aupe(this);
    }
    aupw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long, 1035, this.jdField_a_of_type_Aupe);
  }
  
  private void k()
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
  
  private void l()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_group_code.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReqBody.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.jdField_c_of_type_Long);
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aupg(this), localReqBody.toByteArray(), "OidbSvc.0x986_0", 2438, 0);
  }
  
  private void m()
  {
    oidb_0x984.ReqBody localReqBody = new oidb_0x984.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x984.ReadReportReq localReadReportReq = new oidb_0x984.ReadReportReq();
    localReadReportReq.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReadReportReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReadReportReq.uint64_from_uin.set(this.jdField_c_of_type_Long);
    localReqBody.msg_read_report_req.set(localReadReportReq);
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aupa(this), localReqBody.toByteArray(), "OidbSvc.0x984_0", 2436, 0);
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void o()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_group_code.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReqBody.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.jdField_c_of_type_Long);
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aupf(this), localReqBody.toByteArray(), "OidbSvc.0x986_2", 2438, 2);
  }
  
  private void p()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localGetReadListReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localGetReadListReq.uint64_from_uin.set(this.jdField_c_of_type_Long);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new auoz(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void q()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Adlv.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(13);
  }
  
  private void r()
  {
    int i = this.jdField_d_of_type_Int + 1;
    this.jdField_d_of_type_Int = i;
    if (i < 3)
    {
      k();
      if (QLog.isDebugVersion()) {
        QLog.d("ReceiptMessageDetailFragment", 4, "resend read report, retry count: " + this.jdField_d_of_type_Int);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  private void s()
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
  
  protected void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    adlv localadlv = (adlv)paramacju;
    if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()))
    {
      paramacju = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacju = paramacju.getColorStateList(2131101282);
        if ((localadlv.jdField_a_of_type_AndroidWidgetTextView != null) && (paramacju != null)) {
          localadlv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacju);
        }
        if ((localadlv.jdField_b_of_type_AndroidWidgetTextView != null) && (paramacju != null)) {
          localadlv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacju);
        }
      }
    }
    for (;;)
    {
      return;
      paramacju = paramacju.getColorStateList(2131101278);
      break;
      if (paramalmt.jdField_b_of_type_Int == 0)
      {
        localadlv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localadlv.jdField_b_of_type_AndroidWidgetTextView != null) {
          localadlv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
      }
      while ((paramalmt.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadlv.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localadlv.jdField_a_of_type_Almt.jdField_a_of_type_Double) == 1))
      {
        float f2 = localadlv.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localadlv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        localadlv.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramalmt.jdField_d_of_type_Int);
        return;
        localadlv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
        if (localadlv.jdField_b_of_type_AndroidWidgetTextView != null) {
          localadlv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public void a(adlv paramadlv, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int i = 0;
    if (paramadlv.c != null)
    {
      paramadlv.c.setVisibility(8);
      paramadlv.c.setOnClickListener(null);
      paramadlv.d.setVisibility(8);
    }
    if (paramadlv.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramadlv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramadlv.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramadlv.e.setVisibility(8);
      paramadlv.f.setVisibility(8);
    }
    paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramadlv.jdField_a_of_type_Acmv);
    paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramadlv.jdField_a_of_type_Acmv);
    Object localObject2 = BaseApplicationImpl.getContext().getResources();
    int j = aciy.a(15.0F, (Resources)localObject2);
    switch (paramInt)
    {
    default: 
      paramInt = i;
      localObject1 = (axaf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
      i = paramInt;
      if (paramMessageForPtt.sttAbility == 1)
      {
        i = paramInt;
        if (((axaf)localObject1).a(paramMessageForPtt)) {
          i = 4;
        }
      }
      switch (i)
      {
      case 2: 
      case 3: 
      default: 
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
          paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
        }
        break;
      }
      break;
    }
    do
    {
      return;
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setPadding(aciy.a(10.0F, (Resources)localObject2), BaseChatItemLayout.l, aciy.a(10.0F, (Resources)localObject2), BaseChatItemLayout.m);
      if (paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramadlv);
      paramInt = 1;
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      ((RelativeLayout.LayoutParams)paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = j;
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      break;
      ((RelativeLayout.LayoutParams)paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = j;
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setPadding(aciy.a(40.0F, (Resources)localObject2), BaseChatItemLayout.l, aciy.a(40.0F, (Resources)localObject2), BaseChatItemLayout.m);
      if (paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      paramInt = i;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label792;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "get a amr file length = 0 return now");
      }
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setPadding(aciy.a(10.0F, (Resources)localObject2), BaseChatItemLayout.l, aciy.a(10.0F, (Resources)localObject2), BaseChatItemLayout.m);
    } while (paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label792:
    if (paramMessageForPtt.voiceLength > adlr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
      paramMessageForPtt.sttAbility = 0;
    }
    if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = adlr.a(paramMessageForPtt.voiceLength);
    }
    Object localObject3 = paramMessageForPtt.timeStr;
    paramadlv.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
    a(paramadlv);
    paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        localObject1 = ((azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
        }
      }
      else
      {
        label940:
        if ((paramInt != 2003) && (paramInt != 1003)) {
          break label2051;
        }
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
          paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
        if ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.voiceChangeFlag == 1) || (!paramMessageForPtt.expandStt)) {
          break label2221;
        }
        paramInt = 0;
        i = 2;
      }
    }
    for (;;)
    {
      label1006:
      int k = aciy.a(9.0F, (Resources)localObject2);
      int m = aciy.a(12.0F, (Resources)localObject2);
      int n = ((Resources)localObject2).getDrawable(2130843945).getIntrinsicHeight();
      int i1 = aciy.a(1.0F, (Resources)localObject2);
      j = aciy.a(3.0F, (Resources)localObject2);
      paramadlv.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.l, k, BaseChatItemLayout.m);
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, j, 0);
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(k, 0, k, 0);
      if (i == 2)
      {
        if (paramadlv.jdField_b_of_type_AndroidWidgetTextView != null) {
          break label2093;
        }
        ImageView localImageView1 = new ImageView(BaseApplicationImpl.getContext());
        localImageView1.setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i1);
        localImageView1.setLayoutParams(localLayoutParams1);
        localImageView1.setId(2131307241);
        TextView localTextView = new TextView(BaseApplicationImpl.getContext());
        if (!paramMessageForPtt.isSend()) {
          break label2081;
        }
        localObject1 = ((Resources)localObject2).getColorStateList(2131101282);
        label1194:
        if (localObject1 != null) {
          localTextView.setTextColor((ColorStateList)localObject1);
        }
        localTextView.setId(2131307240);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ImageView localImageView2 = new ImageView(BaseApplicationImpl.getContext());
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        localImageView2.setLayoutParams(localLayoutParams2);
        localImageView2.setImageResource(2130843945);
        localImageView2.setScaleType(ImageView.ScaleType.FIT_END);
        localLayoutParams1.addRule(3, 2131307221);
        localLayoutParams1.addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131307241);
        localLayoutParams2.addRule(3, 2131307241);
        localLayoutParams2.addRule(14);
        localLayoutParams2.addRule(6, 2131307240);
        localLayoutParams2.addRule(8, 2131307240);
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView1);
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView2);
        paramadlv.e = localImageView1;
        paramadlv.jdField_b_of_type_AndroidWidgetTextView = localTextView;
        paramadlv.f = localImageView2;
      }
      for (;;)
      {
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramadlv.jdField_a_of_type_Acmv);
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramadlv.jdField_a_of_type_Acmv);
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        localObject1 = (RelativeLayout.LayoutParams)paramadlv.e.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131307221);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131307221);
        localObject1 = (RelativeLayout.LayoutParams)paramadlv.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131307221);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131307221);
        i1 = aciy.a(22.0F, (Resources)localObject2);
        paramadlv.e.setPadding(k, 0, k, 0);
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, k, i1 + n);
        paramadlv.f.setPadding(0, 0, 0, m);
        localObject2 = paramMessageForPtt.sttText;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = getActivity().getString(2131653920);
        }
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        float f = 0.0F;
        if (i == 2)
        {
          localObject2 = paramMessageForPtt.sttText;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getActivity().getString(2131653920);
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getActivity());
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
          f = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject1);
        }
        i = (int)aciy.a((int)paramadlv.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject3), getActivity().getResources());
        i = adlr.a(getActivity(), paramMessageForPtt.voiceLength, f, k + i, j, false, false);
        localObject1 = (RelativeLayout.LayoutParams)paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = i;
        localObject2 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false, i + k, paramadlv);
        localObject3 = (RelativeLayout.LayoutParams)paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).width = (localObject2[0] + localObject2[1] + localObject2[2]);
        ((RelativeLayout.LayoutParams)localObject3).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramadlv);
        if (paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null)
        {
          i = localObject2[0];
          k = localObject2[1];
          ((RelativeLayout.LayoutParams)localObject3).width = (localObject2[2] + (i + k));
          ((RelativeLayout.LayoutParams)localObject3).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramadlv);
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject3).width + ", flagTimeContainer.getLeft()=" + paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
          }
          paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
        }
        if (paramMessageForPtt.voiceLength > 0) {
          paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject1).width - j, paramMessageForPtt.voiceLength);
        }
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
        if (paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
          paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
        }
        break;
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject1, null);
        break label940;
        localObject1 = ((azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label940;
        }
        paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject1, null);
        break label940;
        label2051:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          paramInt = 1;
          i = 1;
          break label1006;
        }
        paramInt = 4;
        i = 1;
        break label1006;
        label2081:
        localObject1 = ((Resources)localObject2).getColorStateList(2131101278);
        break label1194;
        label2093:
        paramadlv.e.setVisibility(0);
        paramadlv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramadlv.f.setVisibility(0);
      }
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      localObject1 = paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramadlv = ajjy.a(2131647354);; paramadlv = ajjy.a(2131647353))
      {
        ((ImageView)localObject1).setContentDescription(paramadlv);
        return;
      }
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839117, null);
      paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramadlv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      return;
      label2221:
      paramInt = 0;
      i = 1;
    }
  }
  
  protected void a(adlv paramadlv, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, 5, 0, paramBoolean2, new aupd(this));
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
      bool = atdp.a(getActivity().app.getCurrentAccountUin(), 1);
      localBundle.putBoolean("extra.OCR", bool);
      if (bool)
      {
        localObject = atdp.a(getActivity().app.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBundle.putString("extra.OCR_TEXT", (String)localObject);
        }
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramChatMessage.frienduin);
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      bfcq.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), adwz.a((MessageForPic)paramChatMessage), -1, -1);
      if (QLog.isColorLevel()) {
        QLog.i("ReceiptMessageDetailFragment", 2, "ReceiptMessageDetailFragment.enterImagePreview()");
      }
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.g;
    int i = j;
    if (awwx.a(paramChatMessage)) {
      i = j - aciy.a(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, i, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, i, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onStartSeek ");
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onSeekProgressUpdate, progress = " + paramFloat);
    }
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = paramFloat;
      if ((this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView == null) || (this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a())) {}
    }
    else
    {
      return;
    }
    int i = (int)(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onSeekProgressUpdate, offset = " + i);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, i);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju)
  {
    paramacju.jdField_a_of_type_Int = 1;
    paramacju.jdField_a_of_type_Almt = alnt.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, false);
    if (paramacju.jdField_a_of_type_Almt != null) {
      paramacju.jdField_a_of_type_Almt.a(paramacju.jdField_a_of_type_AndroidViewView, null);
    }
    if (paramacju.jdField_a_of_type_AndroidViewView != null)
    {
      paramacju.jdField_a_of_type_AndroidViewView.setMinimumWidth(aciy.a(65.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
      paramacju.jdField_a_of_type_AndroidViewView.setMinimumHeight(aciy.a(57.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
    }
    if (paramacju.jdField_a_of_type_Almt != null)
    {
      int j = paramChatMessage.vipBubbleDiyTextId;
      int i = j;
      if (j <= 0) {
        i = ajrm.b(paramChatMessage.vipBubbleID);
      }
      paramacju.jdField_a_of_type_Almt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), false, paramacju.jdField_a_of_type_AndroidViewView, fv.a(paramChatMessage), i);
    }
    if (paramacju.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramacju.jdField_a_of_type_AndroidViewView.getBackground();
      if (paramContext != null) {
        paramContext.setAlpha(255);
      }
    }
    if (paramacju.jdField_a_of_type_Almt != null) {
      a(paramacju, paramBaseChatItemLayout, paramChatMessage, paramacju.jdField_a_of_type_Almt);
    }
    paramChatMessage.mAnimFlag = false;
    if (paramacju.jdField_a_of_type_AndroidViewView != null)
    {
      paramBaseChatItemLayout.setBubbleView(paramacju.jdField_a_of_type_AndroidViewView);
      a(paramacju.jdField_a_of_type_AndroidViewView, paramChatMessage);
      paramacju.jdField_a_of_type_AndroidViewView.setTag(2131298155, paramacju.jdField_a_of_type_Almt);
      paramacju.jdField_a_of_type_AndroidViewView.setTag(2131298595, paramChatMessage);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "onPlayProgress , progress_time = " + paramLong + " , progress_ratio = " + paramFloat);
    }
    if ((this.jdField_a_of_type_Adlv != null) && (paramFloat > 0.0F))
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
      {
        this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForPtt)) {
          ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if ((paramView != null) && (this.jdField_a_of_type_Adlv != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null) && (this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = 0.0F;
        this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
        this.jdField_a_of_type_Adlv.a(false);
      }
      if (this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
  }
  
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
  
  public boolean a()
  {
    return isVisible();
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a();
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) && ((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq)));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    audb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = this.jdField_a_of_type_Adlv;
      if (paramAudioPlayer.a(paramXListView.getLocalFilePath(), paramInt2))
      {
        b(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, adlr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          }
          paramView.a(true);
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
  
  public void ab()
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().getWindow().addFlags(128);
    a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t());
  }
  
  public void ac()
  {
    if (getActivity() == null) {
      return;
    }
    if ((this.jdField_a_of_type_Adlv != null) && (this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) && (this.jdField_a_of_type_Float > 0.95D))
    {
      this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = 0.0F;
      this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
      if (this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
      this.jdField_a_of_type_Float = 0.0F;
    }
    a(this.jdField_a_of_type_Adlv, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, adlr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt), false);
    getActivity().setVolumeControlStream(3);
    getActivity().getWindow().clearFlags(128);
    a(false, false);
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
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
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131632804));
    startTitleProgress();
    setLeftViewName(2131632788);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131304262));
    e();
  }
  
  public void f(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().setVolumeControlStream(3);
    a(false, false);
  }
  
  public void g(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().setVolumeControlStream(paramInt);
  }
  
  public int getContentLayoutId()
  {
    return 2131493042;
  }
  
  public void h(int paramInt) {}
  
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
    if (!isAdded()) {}
    boolean bool;
    label75:
    int i;
    label220:
    do
    {
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
            case 2131296824: 
              paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t()) {
                break label681;
              }
              bool = true;
              paramView.d(bool);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
              a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t());
            }
          } while (!isResumed());
          BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t(), false, false);
          return;
          if (this.jdField_c_of_type_Boolean)
          {
            h();
            return;
          }
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReceiptMessageDetailFragment", 2, "user click bottom bar before fetched read count");
        return;
        s();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          i = 1;
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
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str, str, i, 0, "", "", paramView, "");
          return;
          i = 2;
          break;
          paramView = "pic";
          break label220;
          paramView = "msg";
          break label220;
          paramView = "ptt";
          break label220;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this, this);
      } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null);
      if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
        this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        awqx.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReady()));
    this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
    this.jdField_a_of_type_Adlv.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131629840, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167766));
      return;
    }
    paramView = (PttAudioWaveView)paramView.findViewById(2131307224);
    float f;
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null))
    {
      f = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress;
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "onClick, progress = " + f);
      }
      if (f == 1.0F)
      {
        paramView.setProgress(0.0F);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = 0.0F;
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "onClick, offset = " + i);
      }
      awqx.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, i)) {
        break;
      }
      bbmy.a(getActivity(), 1, 2131629839, 0).b(getActivity().getResources().getDimensionPixelSize(2131167766));
      return;
      i = (int)(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      label681:
      bool = false;
      break label75;
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_Ajmm != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Ajmm);
    }
    if (this.jdField_a_of_type_Ajmm != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b();
      ac();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment
 * JD-Core Version:    0.7.0.1
 */