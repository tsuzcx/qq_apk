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
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new ReceiptMessageDetailFragment.DetailHandler(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private PttItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private ReceiptMessageDetailFragment.ReceiptMessageDownloadCallBack jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$ReceiptMessageDownloadCallBack;
  private PhotoProgressDrawable jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReceiptMessageDetailFragment.4(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private MessageObserver jdField_b_of_type_ComTencentMobileqqAppMessageObserver = null;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ReceiptMessageDetailFragment.5(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
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
      int i = ((Drawable)localObject).getIntrinsicWidth();
      int j = ((Drawable)localObject).getIntrinsicHeight();
      i = Math.round(i * f1);
      int k = Math.round(j * f2);
      localRect.right = i;
      localRect.bottom = k;
      j = paramImageView.getWidth();
      k = (paramImageView.getHeight() - k) / 2;
      localRect.left = ((j - i) / 2);
      localRect.top = k;
    }
    return localRect;
  }
  
  private PttItemBuilder.Holder a(MessageForPtt paramMessageForPtt)
  {
    PttItemBuilder.Holder localHolder = new PttItemBuilder.Holder();
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = new BaseChatItemLayout(BaseApplicationImpl.getContext());
    BreathAnimationLayout localBreathAnimationLayout = new BreathAnimationLayout(BaseApplicationImpl.getContext());
    Object localObject1 = new PttAudioPlayView(getBaseActivity(), 12);
    ((PttAudioPlayView)localObject1).setThemeColor(getBaseActivity().getResources().getColorStateList(2131167075).getDefaultColor());
    ((PttAudioPlayView)localObject1).setId(2131374100);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.b(34.0F, getBaseActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.b(34.0F, getBaseActivity().getResources());
    ((PttAudioPlayView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new PttAudioWaveView(getBaseActivity());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setProgressColor(getBaseActivity().getResources().getColorStateList(2131167075).getDefaultColor());
    ((PttAudioWaveView)localObject2).setId(2131374101);
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.b(10.0F, getBaseActivity().getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.b(41.0F, getBaseActivity().getResources());
    ((PttAudioWaveView)localObject2).setShouldDisallowInterceptTouch(true);
    ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((PttAudioWaveView)localObject2).setOnClickListener(this);
    localObject3 = new TextView(getBaseActivity());
    ((TextView)localObject3).setId(2131374102);
    ((TextView)localObject3).setTextColor(getBaseActivity().getResources().getColorStateList(2131167075));
    VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(getBaseActivity());
    localVoicePrintView.setId(2131374103);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject4 = new SyncParentPressedRelativeLayout(BaseApplicationImpl.getContext());
    ((RelativeLayout)localObject4).setId(2131374098);
    ((RelativeLayout)localObject4).addView((View)localObject2);
    ((RelativeLayout)localObject4).addView((View)localObject1);
    ((RelativeLayout)localObject4).addView((View)localObject3);
    ((RelativeLayout)localObject4).addView(localVoicePrintView);
    localBreathAnimationLayout.addView((View)localObject4);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = localBreathAnimationLayout;
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)localObject1);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
    localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
    if (paramMessageForPtt.isSend())
    {
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374101);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374100);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374101);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374100);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
    }
    int i;
    if ((paramMessageForPtt.isSendFromLocal()) && (paramMessageForPtt.fileSize == -2L))
    {
      j = 999;
      i = j;
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
        i = j;
      }
    }
    else
    {
      i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
    }
    int j = i;
    if (i == -1)
    {
      a(localHolder, paramMessageForPtt, false, true);
      j = 2001;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fileStatus = ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(" url ");
      ((StringBuilder)localObject1).append(paramMessageForPtt.url);
      ((StringBuilder)localObject1).append(" uniseq ");
      ((StringBuilder)localObject1).append(paramMessageForPtt.uniseq);
      QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject1).toString());
    }
    a(localHolder, paramMessageForPtt, j, a(paramMessageForPtt));
    ((IPTTPreDownloader)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onViewPTT(paramMessageForPtt);
    PttInfoCollector.reportPttItemBuilderType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramMessageForPtt);
    if (AppSetting.d)
    {
      paramMessageForPtt = String.format(HardCodeUtil.a(2131713072), new Object[] { paramMessageForPtt.timeStr });
      localBreathAnimationLayout.setContentDescription(paramMessageForPtt);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt);
    }
    return localHolder;
  }
  
  private MessageObserver a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ReceiptMessageDetailFragment.6(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = new ETTextView(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    Resources localResources = getResources();
    int i = localResources.getDimensionPixelSize(2131298198);
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(i, i, i, 0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, localResources.getDimensionPixelSize(2131298201));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(localResources.getColor(2131167187));
    i = AIOUtils.b(11.0F, localResources);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLineSpacing(i, 1.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838197);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).gravity = 0;
    this.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(new ReceiptMessageDetailFragment.OnTextLongClickedListener(this, null));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localLayoutParams);
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
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (localObject == null)
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
      ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, "1");
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, "2");
      return;
    }
    if (paramInt1 >= paramInt2)
    {
      ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, "3");
      return;
    }
    ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, "4");
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
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      if (paramInt > 0)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetButton;
        if (this.jdField_b_of_type_Boolean) {
          paramInt = 2131698578;
        } else {
          paramInt = 2131698580;
        }
        ((Button)localObject).setText(paramInt);
        return;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      if (this.jdField_b_of_type_Boolean) {
        paramInt = 2131698579;
      } else {
        paramInt = 2131698581;
      }
      ((Button)localObject).setText(paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getString(2131698582), new Object[] { Integer.toString(paramInt) }));
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130838195), null);
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(AIOUtils.b(5.0F, getResources()));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int k = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    double d3 = paramURLDrawable.getIntrinsicWidth();
    double d1 = paramURLDrawable.getIntrinsicHeight();
    double d2 = localDisplayMetrics.density;
    Double.isNaN(d3);
    Double.isNaN(d2);
    d3 *= d2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d4 = d1 * d2;
    boolean bool = a(d3, d4, k, j);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = -1;
    int i = 0;
    if (!bool)
    {
      j = j - ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getContext()) - getResources().getDimensionPixelSize(2131299168) - AIOUtils.b(45.0F, getResources()) + 1;
      d2 = 2.0D * d3;
      double d5 = k;
      d1 = d2;
      if (d2 > d5) {
        d1 = d5;
      }
      d5 = d1 * d4 / d3;
      if (d4 >= 3.0D * d3) {
        i = 1;
      }
      if (i == 0)
      {
        d2 = j;
        if (d5 > d2)
        {
          Double.isNaN(d2);
          Double.isNaN(d2);
          d1 = d1 * d2 / d2;
          i = j;
          break label276;
        }
      }
      d2 = d5;
      i = j;
    }
    else
    {
      d1 = d3;
      d2 = d4;
      i = 0;
    }
    label276:
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = ((int)(d2 + 0.5D));
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = ((int)(0.5D + d1));
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
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
      paramURLDrawable.append(i);
      QLog.d("ReceiptMessageDetailFragment", 2, paramURLDrawable.toString());
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    f();
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = "ReceiptMessageDetailFragment.isReceipt";
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838201);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838184);
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
    localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(paramMessageForPic, 1, null, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new ReceiptMessageDetailFragment.2(this, paramMessageForPic));
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
      paramMessageForPic = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130848857);
    }
    catch (OutOfMemoryError paramMessageForPic)
    {
      label281:
      Rect localRect;
      break label281;
    }
    paramMessageForPic = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = new PhotoProgressDrawable(paramMessageForPic, (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    paramMessageForPic = new RelativeLayout.LayoutParams(-2, -2);
    i = AIOUtils.b(40.0F, BaseApplicationImpl.getContext().getResources());
    paramMessageForPic.width = i;
    paramMessageForPic.height = i;
    localRect = new Rect(0, 0, i, i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(localRect);
    paramMessageForPic.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramMessageForPic);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new ReceiptMessageDetailFragment.3(this));
    ((URLDrawable)localObject).setAutoDownload(true);
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder = a(paramMessageForPtt);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.weight = 0.0F;
    localLayoutParams1.gravity = 16;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
    ((PttItemBuilder.Holder)localObject).jdField_a_of_type_AndroidViewView = ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout;
    a(paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder);
    s();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setPadding(0, 0, 0, AIOUtils.b(7.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setFocusable(false);
    if (AppSetting.d) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, 2);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838196);
    paramMessageForPtt = new View(BaseApplicationImpl.getContext());
    localObject = new View(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramMessageForPtt, localLayoutParams2);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, localLayoutParams2);
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
      if (AppSetting.d)
      {
        paramMessageForText = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramMessageForText.msg);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setContentDescription(paramMessageForText);
      }
    }
    else
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText("");
    }
    m();
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQText))
    {
      Object localObject = (QQText)paramCharSequence;
      int j = paramCharSequence.length();
      int i = 0;
      localObject = (EmoticonSpan[])((QQText)localObject).getSpans(0, j, EmoticonSpan.class);
      if (localObject.length > 0)
      {
        j = localObject.length;
        while (i < j)
        {
          localObject[i].setSize((int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + 0.5F) + AIOUtils.b(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
          i += 1;
        }
      }
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramCharSequence);
  }
  
  private boolean a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    boolean bool = ((IPicUtil)QRoute.api(IPicUtil.class)).isLongPic((int)paramDouble1, (int)paramDouble2);
    int i = URLDrawableHelper.AIO_IMAGE_MAX_SIZE;
    double d1;
    if ((!bool) || (paramDouble1 > paramInt1) || (paramDouble2 > paramInt2)) {
      d1 = i;
    }
    return (paramDouble1 < d1) && (paramDouble2 < d1);
  }
  
  private MessageObserver b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver == null) {
      this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new ReceiptMessageDetailFragment.7(this);
    }
    return this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver;
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
      if (QLog.isColorLevel()) {
        QLog.e("ReceiptMessageDetailFragment", 2, localException.toString());
      }
    }
  }
  
  private void b(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(paramMessageForPtt, null);
    m();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isAdded()) {
      return;
    }
    if ((paramBoolean1) && (!DeviceInfoUtil.j()))
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131558578, (ViewGroup)this.mContentView);
        this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131362489);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131362490));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin += AIOUtils.b(45.0F, getResources());
        }
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689946);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689945);
      }
      this.jdField_b_of_type_AndroidViewView.setSelected(paramBoolean2);
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void c()
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131698574, 0).a(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(BaseApplicationImpl.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(true);
    if (AppSetting.d) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(HardCodeUtil.a(2131713075));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor("#f7f7f9"));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(BaseApplicationImpl.getContext());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838196);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
  }
  
  private void g()
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
    boolean bool;
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == this.jdField_c_of_type_Long) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    if ((this.jdField_a_of_type_Long < 0L) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_c_of_type_Long < 0L) || (this.jdField_d_of_type_Long < 0L)) {
      QLog.d("ReceiptMessageDetailFragment", 1, "invalid msg seq or null session info");
    }
    ThreadManager.post(new ReceiptMessageDetailFragment.1(this), 8, null, false);
  }
  
  private void h()
  {
    Object localObject = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
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
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void i()
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131376008));
    View localView = this.mContentView.findViewById(2131363715);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131370380);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localView.setTouchDelegate(new TouchDelegate(new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, AIOUtils.b(45.0F, getResources())), this.jdField_a_of_type_AndroidWidgetButton));
    a(0, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
    localView.setVisibility(0);
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131698564, 0).a(this);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131698565, 0).a(this);
  }
  
  private void k()
  {
    this.mContentView.findViewById(2131366304).setVisibility(0);
    stopTitleProgress();
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$ReceiptMessageDownloadCallBack == null) {
      this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$ReceiptMessageDownloadCallBack = new ReceiptMessageDetailFragment.ReceiptMessageDownloadCallBack(this);
    }
    ReceiptMsgManager localReceiptMsgManager = ReceiptMsgManager.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localReceiptMsgManager.a(localQQAppInterface, this.jdField_a_of_type_JavaLangString, localQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long, 1035, this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment$ReceiptMessageDownloadCallBack);
  }
  
  private void m()
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
  
  private void n()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_group_code.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReqBody.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.jdField_c_of_type_Long);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReceiptMessageDetailFragment.TroopSendReadReportCallback(this), localReqBody.toByteArray(), "OidbSvc.0x986_0", 2438, 0);
  }
  
  private void o()
  {
    oidb_0x984.ReqBody localReqBody = new oidb_0x984.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x984.ReadReportReq localReadReportReq = new oidb_0x984.ReadReportReq();
    localReadReportReq.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReadReportReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReadReportReq.uint64_from_uin.set(this.jdField_c_of_type_Long);
    localReqBody.msg_read_report_req.set(localReadReportReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReceiptMessageDetailFragment.DiscussionSendReadReportCallback(this), localReqBody.toByteArray(), "OidbSvc.0x984_0", 2436, 0);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void q()
  {
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_group_code.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localReqBody.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_start_uin.set(0L);
    localReqBody.uint64_from_uin.set(this.jdField_c_of_type_Long);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReceiptMessageDetailFragment.TroopFetchReadStatusCallback(this), localReqBody.toByteArray(), "OidbSvc.0x986_2", 2438, 2);
  }
  
  private void r()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.jdField_b_of_type_Long);
    localGetReadListReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localGetReadListReq.uint64_from_uin.set(this.jdField_c_of_type_Long);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReceiptMessageDetailFragment.DiscussionFetchReadStatusCallback(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void s()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(13);
  }
  
  private void t()
  {
    int i = this.jdField_d_of_type_Int + 1;
    this.jdField_d_of_type_Int = i;
    if (i < 3)
    {
      m();
      if (QLog.isDebugVersion())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resend read report, retry count: ");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        QLog.d("ReceiptMessageDetailFragment", 4, localStringBuilder.toString());
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
  }
  
  private void u()
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
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.jdField_b_of_type_JavaLangString);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
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
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramChatMessage.frienduin);
    localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
    PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1, -1);
    if (QLog.isColorLevel()) {
      QLog.i("ReceiptMessageDetailFragment", 2, "ReceiptMessageDetailFragment.enterImagePreview()");
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.h;
    int i = j;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i = j - AIOUtils.b(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, i, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, i, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        }
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        if (paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        }
      }
      if ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double * 10000.0D) == 1))
      {
        float f2 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.jdField_d_of_type_Int);
      }
      return;
    }
    paramView = paramView.getResources();
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131167079;
    } else {
      i = 2131167075;
    }
    paramView = paramView.getColorStateList(i);
    if ((paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
    }
    if ((paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramView != null)) {
      paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
    }
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
    if (QLog.isColorLevel())
    {
      paramPttAudioWaveView = new StringBuilder();
      paramPttAudioWaveView.append("onSeekProgressUpdate, progress = ");
      paramPttAudioWaveView.append(paramFloat);
      QLog.d("ReceiptMessageDetailFragment", 2, paramPttAudioWaveView.toString());
    }
    this.jdField_a_of_type_Float = paramFloat;
    paramPttAudioWaveView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    if (paramPttAudioWaveView != null)
    {
      paramPttAudioWaveView.playProgress = paramFloat;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.b())) {
        return;
      }
      int i = (int)(paramFloat * (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000.0F));
      if (QLog.isColorLevel())
      {
        paramPttAudioWaveView = new StringBuilder();
        paramPttAudioWaveView.append("onSeekProgressUpdate, offset = ");
        paramPttAudioWaveView.append(i);
        QLog.d("ReceiptMessageDetailFragment", 2, paramPttAudioWaveView.toString());
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, i);
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
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    if (paramHolder.c != null)
    {
      paramHolder.c.setVisibility(8);
      paramHolder.c.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
    }
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramHolder.e.setVisibility(8);
      paramHolder.f.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    localObject1 = BaseApplicationImpl.getContext().getResources();
    int i = AIOUtils.b(15.0F, (Resources)localObject1);
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
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.m, AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.n);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
          }
          a(paramHolder);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
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
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.m, AIOUtils.b(10.0F, (Resources)localObject1), BaseChatItemLayout.n);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
          }
          return;
        }
        if (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
          paramMessageForPtt.sttAbility = 0;
        }
        if ((android.text.TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (android.text.TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
          paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
        }
        Object localObject3 = paramMessageForPtt.timeStr;
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        a(paramHolder);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        if (paramMessageForPtt.isSend())
        {
          if (paramMessageForPtt.mRobotFlag == 1)
          {
            localObject2 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
            if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
            } else {
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
            }
          }
        }
        else
        {
          localObject2 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
          }
        }
        if ((paramInt != 2003) && (paramInt != 1003))
        {
          if ((paramInt != 1005) && (paramInt != 1004))
          {
            i = 1;
            paramInt = 4;
          }
          else
          {
            i = 1;
            paramInt = 1;
          }
        }
        else
        {
          if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true);
          }
          if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
            i = 2;
          } else {
            i = 1;
          }
          paramInt = 0;
        }
        int m = AIOUtils.b(9.0F, (Resources)localObject1);
        int n = AIOUtils.b(12.0F, (Resources)localObject1);
        int i1 = ((Resources)localObject1).getDrawable(2130844831).getIntrinsicHeight();
        int j = AIOUtils.b(1.0F, (Resources)localObject1);
        int k = AIOUtils.b(3.0F, (Resources)localObject1);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, m, BaseChatItemLayout.n);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, k, 0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(m, 0, m, 0);
        if (i == 2)
        {
          if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null)
          {
            localObject2 = new ImageView(BaseApplicationImpl.getContext());
            ((ImageView)localObject2).setImageDrawable(new ColorDrawable(838860800));
            RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, j);
            ((ImageView)localObject2).setLayoutParams(localLayoutParams1);
            ((ImageView)localObject2).setId(2131374118);
            ETTextView localETTextView = new ETTextView(BaseApplicationImpl.getContext());
            if (paramMessageForPtt.isSend()) {
              j = 2131167079;
            } else {
              j = 2131167075;
            }
            Object localObject4 = ((Resources)localObject1).getColorStateList(j);
            if (localObject4 != null) {
              localETTextView.setTextColor((ColorStateList)localObject4);
            }
            localETTextView.setId(2131374117);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ImageView localImageView = new ImageView(BaseApplicationImpl.getContext());
            RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            localImageView.setLayoutParams(localLayoutParams2);
            localImageView.setImageResource(2130844831);
            localImageView.setScaleType(ImageView.ScaleType.FIT_END);
            localLayoutParams1.addRule(3, 2131374098);
            localLayoutParams1.addRule(14);
            ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131374118);
            localLayoutParams2.addRule(3, 2131374118);
            localLayoutParams2.addRule(14);
            localLayoutParams2.addRule(6, 2131374117);
            localLayoutParams2.addRule(8, 2131374117);
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject2);
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localETTextView);
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
            paramHolder.e = ((ImageView)localObject2);
            paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
            paramHolder.f = localImageView;
          }
          else
          {
            paramHolder.e.setVisibility(0);
            paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
            paramHolder.f.setVisibility(0);
          }
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramMessageForPtt);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131374098);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131374098);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131374098);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131374098);
          j = AIOUtils.b(22.0F, (Resources)localObject1);
          paramHolder.e.setPadding(m, 0, m, 0);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(m, BaseChatItemLayout.m, m, j + i1);
          paramHolder.f.setPadding(0, 0, 0, n);
          localObject2 = paramMessageForPtt.sttText;
          localObject1 = localObject2;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getBaseActivity().getString(2131719265);
          }
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText((CharSequence)localObject1);
        }
        float f;
        if (i == 2)
        {
          localObject2 = paramMessageForPtt.sttText;
          localObject1 = localObject2;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getBaseActivity().getString(2131719265);
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getBaseActivity());
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
          f = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject1);
        }
        else
        {
          f = 0.0F;
        }
        i = (int)AIOUtils.a((int)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject3), getBaseActivity().getResources());
        i = PttItemBuilder.a(getBaseActivity(), paramMessageForPtt.voiceLength, f, m + i, k, false, false);
        localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = i;
        localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false, i + m, paramHolder);
        Object localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (localObject3[0] + localObject3[1] + localObject3[2]);
        ((RelativeLayout.LayoutParams)localObject2).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramHolder);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = (localObject3[0] + localObject3[1] + localObject3[2]);
          ((RelativeLayout.LayoutParams)localObject2).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramHolder);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("message seq=");
            ((StringBuilder)localObject3).append(paramMessageForPtt.uniseq);
            ((StringBuilder)localObject3).append(", VpLp.width=");
            ((StringBuilder)localObject3).append(((RelativeLayout.LayoutParams)localObject2).width);
            ((StringBuilder)localObject3).append(", flagTimeContainer.getLeft()=");
            ((StringBuilder)localObject3).append(paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
            QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject3).toString());
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
        }
        if (paramMessageForPtt.voiceLength > 0) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject1).width - k, paramMessageForPtt.voiceLength);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
        }
        break;
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(40.0F, (Resources)localObject1), BaseChatItemLayout.m, AIOUtils.b(40.0F, (Resources)localObject1), BaseChatItemLayout.n);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    }
    paramInt = 0;
    i = paramInt;
    if (paramMessageForPtt.sttAbility == 1)
    {
      i = paramInt;
      if (((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) {
        i = 4;
      }
    }
    if (i != 1)
    {
      if (i != 4)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839406, null);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      }
    }
    else
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      paramHolder = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView;
      if (paramMessageForPtt.isSendFromLocal()) {
        paramInt = 2131713074;
      } else {
        paramInt = 2131713073;
      }
      paramHolder.setContentDescription(HardCodeUtil.a(paramInt));
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, 5, 0, paramBoolean2, new ReceiptMessageDetailFragment.PttDownloadCallBack(this));
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
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.b(65.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.b(57.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()));
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
    {
      int j = paramChatMessage.vipBubbleDiyTextId;
      int i = j;
      if (j <= 0) {
        i = SVIPHandlerConstants.b(paramChatMessage.vipBubbleID);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), false, paramViewHolder.jdField_a_of_type_AndroidViewView, FontManagerConstants.getSenderUin(paramChatMessage), i);
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
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131364116, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131364568, paramChatMessage);
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
    paramXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
    if ((paramXListView != null) && (paramFloat > 0.0F))
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
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
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
      if ((paramXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null))
      {
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = 0.0F;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.a(false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
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
      AudioPanelAioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean2, false, false);
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
        paramBoolean4 = AudioDeviceHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      }
    }
    AudioPanelAioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a())
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
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a();
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) && ((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq)));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    ((IPTTPreDownloader)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onPlayPTT(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
      paramAudioPlayerBase.a(16);
      if (paramAudioPlayerBase.b(paramXListView.getLocalFilePath(), paramInt2))
      {
        b(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
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
  
  public void d()
  {
    if (getBaseActivity() == null) {
      return;
    }
    getBaseActivity().getWindow().addFlags(128);
    b(true, AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131698586));
    startTitleProgress();
    setLeftViewName(2131698571);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131370826));
    g();
  }
  
  public void e()
  {
    if (getBaseActivity() == null) {
      return;
    }
    PttItemBuilder.Holder localHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
    if ((localHolder != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) && (this.jdField_a_of_type_Float > 0.95D))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = 0.0F;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
      this.jdField_a_of_type_Float = 0.0F;
    }
    localHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder;
    MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    a(localHolder, localMessageForPtt, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), false);
    getBaseActivity().setVolumeControlStream(3);
    getBaseActivity().getWindow().clearFlags(128);
    b(false, false);
  }
  
  public boolean e()
  {
    return isVisible();
  }
  
  protected int getContentLayoutId()
  {
    return 2131558596;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onClick(View paramView)
  {
    if (isAdded())
    {
      int i;
      Object localObject1;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131376008: 
        if (this.jdField_c_of_type_Boolean)
        {
          j();
        }
        else if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMessageDetailFragment", 2, "user click bottom bar before fetched read count");
          }
        }
        else
        {
          u();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
            i = 1;
          } else {
            i = 2;
          }
          int j = this.jdField_e_of_type_Int;
          if (j != 1) {
            if (j != 2) {
              if (j != 3) {
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
          if (this.jdField_b_of_type_Boolean) {
            localObject2 = "0x80083EA";
          } else {
            localObject2 = "0x80083EB";
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject2, (String)localObject2, i, 0, "", "", (String)localObject1, "");
        }
        break;
      case 2131374098: 
      case 2131374101: 
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this, this);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
        if (localObject1 != null) {
          if (a((ChatMessage)localObject1))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
            ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReady()))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131695163, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
            }
            else
            {
              localObject1 = (PttAudioWaveView)paramView.findViewById(2131374101);
              if (localObject1 != null)
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
                if (localObject2 != null)
                {
                  float f = ((MessageForPtt)localObject2).playProgress;
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("onClick, progress = ");
                    ((StringBuilder)localObject2).append(f);
                    QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject2).toString());
                  }
                  if (f == 1.0F)
                  {
                    ((PttAudioWaveView)localObject1).setProgress(0.0F);
                    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.playProgress = 0.0F;
                  }
                  else
                  {
                    i = (int)(f * (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000.0F));
                    break label532;
                  }
                }
              }
              i = 0;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("onClick, offset = ");
                ((StringBuilder)localObject1).append(i);
                QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject1).toString());
              }
              ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
              if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, i)) {
                QQToast.a(getBaseActivity(), 1, 2131695162, 0).b(getBaseActivity().getResources().getDimensionPixelSize(2131299168));
              }
            }
          }
        }
        break;
      case 2131362489: 
        label532:
        AudioDeviceHelper.a(AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) ^ true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
        b(true, AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (isResumed()) {
          AudioPanelAioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false, false);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MessageObserver localMessageObserver = this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver;
    if (localMessageObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localMessageObserver);
    }
    localMessageObserver = this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
    if (localMessageObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localMessageObserver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MediaPlayerManager localMediaPlayerManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
    if (localMediaPlayerManager != null)
    {
      localMediaPlayerManager.b();
      e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void onStop()
  {
    MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    if ((localMessageForPtt != null) && (a(localMessageForPtt))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment
 * JD-Core Version:    0.7.0.1
 */