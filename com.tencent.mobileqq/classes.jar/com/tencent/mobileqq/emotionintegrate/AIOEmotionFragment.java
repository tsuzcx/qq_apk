package com.tencent.mobileqq.emotionintegrate;

import aber;
import abkk;
import afez;
import agej;
import agfs;
import aghe;
import ahng;
import aibo;
import aibq;
import aibr;
import aicv;
import aitv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anwy;
import anzj;
import askc;
import askd;
import asmu;
import asos;
import asre;
import astq;
import astr;
import asts;
import astt;
import astu;
import astv;
import astw;
import astx;
import astz;
import asug;
import asuh;
import asui;
import asuj;
import asuk;
import asum;
import asun;
import asup;
import asuq;
import asur;
import asus;
import auxu;
import awxl;
import axfj;
import bdll;
import bdmc;
import bdor;
import beqz;
import beyq;
import bhrt;
import bhsi;
import blhq;
import bljn;
import bljo;
import blkl;
import blkm;
import bllw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioDeviceManager;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.CommonAudioPlayer;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lfm;
import mqq.app.AppRuntime;
import nlj;
import nlk;

public class AIOEmotionFragment
  extends AIOEmotionBaseFragment
  implements agfs, aghe, aibq, Handler.Callback, View.OnClickListener, asuk, asum, asun, bljn, bljo, blkl, blkm, bllw
{
  public static asre a;
  public static asug a;
  private static int jdField_c_of_type_Int;
  private float jdField_a_of_type_Float = 1.0F;
  abkk jdField_a_of_type_Abkk;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anwy jdField_a_of_type_Anwy = new astx(this);
  private astz jdField_a_of_type_Astz;
  asuh jdField_a_of_type_Asuh;
  private asuj jdField_a_of_type_Asuj;
  public final blhq a;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer;
  public SessionInfo a;
  PttAudioPlayView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView;
  PttAudioWaveView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
  TriangleView jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView;
  public Emoticon a;
  EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  public ShareActionSheet a;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  private WeakReference<URLDrawable> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Long, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<URLDrawable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public asre b;
  private boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  protected View d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  
  public AIOEmotionFragment()
  {
    this.jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(paramInt1);
    bdor localbdor = new bdor(paramInt1, 1, 1, agej.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localbdor);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.postInvalidate();
  }
  
  private void a(int paramInt, asug paramasug)
  {
    paramasug = paramasug.a();
    float f2;
    if (paramasug != null)
    {
      f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "updateEmotionOcr scale=" + f2 + "originalScale=" + f2);
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Asuh.a(paramInt))) {
        break label559;
      }
    }
    label528:
    label559:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Asuh.a(paramInt))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramasug.modifyWord))
      {
        paramasug = paramasug.modifyWord;
        if (!TextUtils.isEmpty(paramasug)) {
          break label528;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167084));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691751));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
        if ((b()) && (bhsi.F(this.jdField_a_of_type_AndroidContentContext, a().c())))
        {
          bhsi.x(this.jdField_a_of_type_AndroidContentContext, a().c(), false);
          paramasug = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramasug.setOrientation(1);
          paramasug.setGravity(1);
          Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838922));
          paramasug.addView((View)localObject);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = (-agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.topMargin = agej.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167302));
          ((TextView)localObject).setTextSize(14.0F);
          ((TextView)localObject).setGravity(17);
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691763));
          ((TextView)localObject).setBackgroundResource(2130838924);
          paramasug.addView((View)localObject);
          paramInt = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
          paramasug = new PopupWindow(paramasug, -2, -2);
          paramasug.setBackgroundDrawable(new ColorDrawable(0));
          paramasug.setOutsideTouchable(true);
          paramasug.setFocusable(true);
          ((TextView)localObject).measure(0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.post(new AIOEmotionFragment.3(this, paramasug, (TextView)localObject));
        }
        return;
        paramasug = paramasug.ocrWord;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165343));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramasug);
      }
    }
  }
  
  public static void a(Context paramContext, asmu paramasmu, Rect paramRect)
  {
    Intent localIntent = new Intent();
    if (paramRect != null)
    {
      paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
      paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
      localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    }
    e();
    if (QLog.isColorLevel()) {
      QLog.i("AIOEmotionFragment", 2, "enterEmotionPreview, type: FAV");
    }
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_Asug = new asup(paramasmu);
    localIntent.putExtra("from_chat_history", false);
    localIntent.putExtra("public_fragment_window_feature", 1);
    afez.a(localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect)
  {
    a(paramContext, paramMessageRecord, paramSessionInfo, paramRect, true, true);
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    jdField_c_of_type_Int = 0;
    boolean bool;
    if (((paramContext instanceof ChatHistoryActivity)) || ((paramContext instanceof ChatHistory))) {
      bool = true;
    }
    for (;;)
    {
      e();
      if (paramRect != null)
      {
        paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
        paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("enterEmotionPreview, type:");
        if (MessageForMarketFace.class.isInstance(paramMessageRecord))
        {
          localObject = "Emotion";
          label90:
          QLog.i("AIOEmotionFragment", 2, (String)localObject);
        }
      }
      else
      {
        jdField_a_of_type_Asug = new asur(paramMessageRecord);
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_info", paramSessionInfo);
        ((Intent)localObject).putExtra("from_chat_history", bool);
        ((Intent)localObject).putExtra("hide_emo_position", paramBoolean1);
        ((Intent)localObject).putExtra("need_reload_data", paramBoolean2);
        ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
        if (paramRect != null) {
          ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
        }
        if (!(paramContext instanceof ChatHistory)) {
          break label304;
        }
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistory.class.getName());
      }
      for (;;)
      {
        if ((paramContext instanceof ChatHistoryActivity)) {
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistoryActivity.class.getName());
        }
        if ((!ChatHistoryActivity.a(paramContext, (Intent)localObject)) || (!(paramContext instanceof Activity))) {
          break label364;
        }
        afez.a((Activity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 38);
        return;
        if ((!(paramContext instanceof PublicFragmentActivity)) || (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment))) {
          break label375;
        }
        bool = true;
        break;
        localObject = "GIF";
        break label90;
        label304:
        if (((paramContext instanceof MultiForwardActivity)) && (paramMessageRecord.isMultiMsg) && (((MultiForwardActivity)paramContext).getIntent() != null))
        {
          ((Intent)localObject).putExtra("key_multi_forward_seq", ((MultiForwardActivity)paramContext).getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
          ((Intent)localObject).putExtra("key_is_multi_forward_msg", true);
        }
      }
      label364:
      afez.a((Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
      label375:
      bool = false;
    }
  }
  
  private void a(asmu paramasmu)
  {
    label60:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2))
    {
      i = 1;
      if ((i == 0) || (paramasmu == null)) {
        break label314;
      }
      a("0X800997E");
      if ((!(paramasmu instanceof asre)) || (!((asre)paramasmu).c())) {
        break label258;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new astu(this));
      paramasmu = paramasmu.a(getActivity(), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramasmu);
      paramasmu = null;
      localObject = asui.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject != null) {
        paramasmu = ((EmoticonPackage)localObject).name;
      }
      localObject = a();
      if (localObject == null) {
        break label323;
      }
      if (TextUtils.isEmpty(paramasmu)) {
        break label281;
      }
      if (paramasmu.length() <= 11) {
        break label270;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramasmu.substring(0, 10) + "...");
      label201:
      if (!((axfj)((QQAppInterface)localObject).getManager(14)).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) {
        break label323;
      }
    }
    label258:
    label270:
    label281:
    label314:
    label323:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131698942));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        return;
        i = 0;
        break;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label60;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramasmu);
        break label201;
        a((QQAppInterface)localObject, 4);
        break label201;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131698941));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      return;
    }
  }
  
  private void a(asur paramasur)
  {
    a("0X800A7E6");
    paramasur = (MessageForPic)paramasur.a;
    int i = paramasur.picExtraData.from;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    if (!TextUtils.isEmpty(paramasur.picExtraData.source))
    {
      if (paramasur.picExtraData.source.length() > 11) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramasur.picExtraData.source.substring(0, 10) + "...");
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new asts(this, i, paramasur));
      if (i != 1) {
        break label294;
      }
      if (!((axfj)a().getManager(14)).b(paramasur.picExtraData.emojiPkgId)) {
        break label327;
      }
    }
    label294:
    label327:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689853));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        paramasur = ahng.a(paramasur);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = beyq.a;
        localURLDrawableOptions.mGifRoundCorner = this.jdField_d_of_type_Int;
        localURLDrawableOptions.mPlayGifImage = true;
        paramasur = URLDrawable.getDrawable(paramasur, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramasur);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramasur.picExtraData.source);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689854));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689855));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Astz == null) {
      this.jdField_a_of_type_Astz = new astz(this);
    }
    if ((this.jdField_b_of_type_Asre == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null))
    {
      QLog.d("AIOEmotionFragment", 1, "error in json downloading");
      if (paramInt == 32) {}
      a(false);
      return;
    }
    this.jdField_a_of_type_Astz.a(paramInt, paramQQAppInterface, getActivity(), this.jdField_b_of_type_Asre, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    askc.a().a(this.jdField_a_of_type_Astz);
    ((askd)paramQQAppInterface.getManager(43)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, askd.jdField_c_of_type_Int);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 9);
      localBundle.putBoolean("forward_emotion_from_preview", true);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  private boolean a(asre paramasre)
  {
    if ((paramasre == null) || (!paramasre.c())) {}
    while (paramasre.a() == null) {
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setMaxTopBottomPadding(4);
    localLayoutParams.width = agej.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramasre.a(), agej.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramasre.b());
    a(paramasre.c(), paramasre.d());
    return true;
  }
  
  private void b(asur paramasur)
  {
    Object localObject = (MessageForPic)paramasur.a;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691706));
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setClickable(true);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new astt(this, paramasur));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692516));
    paramasur = ahng.a((MessageForPic)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = this.jdField_d_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    paramasur = URLDrawable.getDrawable(paramasur, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramasur);
  }
  
  private boolean b()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Asuh.a(this.jdField_b_of_type_Int))) && (f != ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Asuh.a(this.jdField_b_of_type_Int))).floatValue())) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if ((localObject instanceof ImageView))
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        int i;
        if ((localObject instanceof awxl))
        {
          i = agej.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_Float = f;
          localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f / 2.0F) + agej.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, new Object[] { "updateEmotionNameLayout scale:", Float.valueOf(f), " topMargin:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
          }
          if (i <= 0) {
            break label229;
          }
        }
        label229:
        for (boolean bool = true;; bool = false)
        {
          return bool;
          i = ((Drawable)localObject).getIntrinsicHeight();
          break;
        }
      }
    }
    return false;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a();
  }
  
  private static void e()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = MediaPlayerManager.a((QQAppInterface)localObject);
        if (((((MediaPlayerManager)localObject).a() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).a())) {
          ((MediaPlayerManager)localObject).a(true);
        }
      }
      return;
    }
  }
  
  private void f()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer = new CommonAudioPlayer(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.l();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(this);
      localObject1 = a();
      if (localObject1 != null) {
        AudioDeviceManager.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.c();
    Object localObject2;
    if (this.jdField_b_of_type_Asre != null)
    {
      localObject2 = asos.o.replace("[epId]", this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      this.jdField_b_of_type_Boolean = false;
      localObject1 = a();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Boolean = ((QQAppInterface)localObject1).z();
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((QQAppInterface)localObject1);
        if (localMediaPlayerManager.a()) {
          localMediaPlayerManager.a(true);
        }
      }
      boolean bool3 = lfm.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a((String)localObject2)) {
        break label409;
      }
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = AudioHelper.b(BaseApplicationImpl.getContext());
        }
      }
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool3, bool1);
      if ((bool3) || (bool1)) {
        break label396;
      }
      bool1 = true;
      a(bool1, this.jdField_a_of_type_Boolean);
      localObject2 = getActivity();
      if (localObject2 != null) {
        ((Activity)localObject2).getWindow().addFlags(128);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject2 = (URLDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null) {
          asre.a((URLDrawable)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
    }
    label396:
    label409:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        axfj.a((QQAppInterface)localObject1, "0X800A935", -1, this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
      localObject2 = new HashMap();
      if (bool1) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ((HashMap)localObject2).put("playResult", localObject1);
        ((HashMap)localObject2).put("playType", "2");
        bdmc.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool1, 0L, 0L, (HashMap)localObject2, null);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.c();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
    a(false, false);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().clearFlags(128);
    }
  }
  
  public void F()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      localFragmentActivity.finish();
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void G()
  {
    asug localasug = (asug)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (localasug.a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    if (localasug.c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (localasug.a() == null) {
        break label119;
      }
    }
    label119:
    for (int i = 0;; i = 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(i);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
    }
  }
  
  public void H() {}
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131558600, paramViewGroup, false);
  }
  
  protected void a()
  {
    boolean bool = false;
    Object localObject1 = (asug)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    Object localObject2;
    int i;
    if ((localObject1 instanceof asur))
    {
      localObject2 = ((asur)localObject1).a;
      if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).picExtraData != null)) {
        if ((((MessageForPic)localObject2).picExtraData.isZhitu()) && (!((MessageRecord)localObject2).isSend())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
      {
        localObject2 = new ShareActionSheetV2.Param();
        ((ShareActionSheetV2.Param)localObject2).context = this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131692536));
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      bhrt.a(2, (ArrayList)localObject2);
      bhrt.a(48, localArrayList);
      if (!getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
        bhrt.a(65, localArrayList);
      }
      if (!((asug)localObject1).a()) {
        bhrt.a(39, localArrayList);
      }
      if (getActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
        bhrt.a(54, localArrayList);
      }
      if (i != 0) {
        bhrt.a(66, localArrayList);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new astq(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, localArrayList);
      if (getActivity() != null) {
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
      }
      localObject2 = a();
      if (((localObject1 instanceof asur)) && (localObject2 != null))
      {
        localObject1 = ((asur)localObject1).a;
        if ((localObject1 instanceof MessageForMarketFace)) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_b_of_type_Asre != null))
            {
              jdField_a_of_type_Asre = this.jdField_b_of_type_Asre;
              ((axfj)((QQAppInterface)localObject2).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new astr(this, (QQAppInterface)localObject2));
              return;
              i = 0;
              break;
              i = 1;
              continue;
            }
            localObject1 = new StringBuilder().append("error mEmoticon, ");
            if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
              bool = true;
            }
            QLog.d("AIOEmotionFragment", 1, bool);
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        return;
        localObject1 = ahng.b((MessageForPic)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject2, this.jdField_a_of_type_AndroidContentContext);
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
        ((Intent)localObject1).putExtra("key_new_img_shareactionsheet", 1);
        ((Intent)localObject1).putExtra("k_dataline", true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject1);
      }
      i = 0;
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_AndroidViewView.setAlpha(paramFloat);
    if (paramFloat < 0.9F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("AIOEmotionFragment", 1, "getView onScrollStart:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " hasScrolled: " + this.jdField_c_of_type_Boolean);
    this.jdField_d_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Blhq.removeMessages(1001);
      this.jdField_a_of_type_Blhq.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_Abkk.a(paramInt / 100);
  }
  
  public void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.d("AIOEmotionFragment", 1, "error runtime");
    }
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("AIOEmotionFragment", 1, "handleClickMenuItem, action:" + paramInt);
            }
            localObject2 = (asug)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
          } while (!(localObject2 instanceof asur));
          localObject2 = ((asur)localObject2).a;
          int i;
          if ((localObject2 instanceof MessageForMarketFace)) {
            i = 0;
          }
          boolean bool;
          switch (paramInt)
          {
          default: 
            return;
          case 2: 
          case 73: 
            a("0X8009981");
            if ((localObject2 instanceof MessageForPic)) {
              ahng.a((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3D", "");
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_Asre == null))
              {
                paramActionSheetItem = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                  i = 1;
                  break;
                }
              }
              jdField_a_of_type_Asre = this.jdField_b_of_type_Asre;
              ((axfj)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new astv(this, (QQAppInterface)localObject1));
              return;
            }
            paramActionSheetItem = ahng.b((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
            paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            auxu.a(super.getActivity(), paramActionSheetItem, 1, 100500, "biz_src_jc_gif");
            return;
          case 72: 
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("key_req", ForwardRecentActivity.f);
            ((Bundle)localObject3).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
            ((Bundle)localObject3).putString("key_direct_show_uin", paramActionSheetItem.uin);
            if (i == 0)
            {
              if (this.jdField_b_of_type_Asre == null)
              {
                QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
                return;
              }
              jdField_a_of_type_Asre = this.jdField_b_of_type_Asre;
              paramActionSheetItem = new Intent();
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("forward_type", 9);
              ((Bundle)localObject1).putBoolean("forward_emotion_from_preview", true);
              paramActionSheetItem.putExtras((Bundle)localObject1);
              paramActionSheetItem.putExtras((Bundle)localObject3);
              auxu.a(super.getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gif");
              return;
            }
            ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
            paramActionSheetItem = ahng.b((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
            paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            paramActionSheetItem.putExtras((Bundle)localObject3);
            auxu.a(super.getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, 100500, "biz_src_jc_gif");
            return;
          case 48: 
            a("0X8009982");
            if ((localObject2 instanceof MessageForPic)) {
              ahng.a((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3E", "");
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_Asre == null))
              {
                paramActionSheetItem = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                }
              }
              ((axfj)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new astw(this, (QQAppInterface)localObject1));
              asos.a((QQAppInterface)localObject1, 2, null, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
              return;
            }
            paramActionSheetItem = beyq.a(beyq.a((MessageForPic)localObject2, 1), -1, -1, null, null, false);
            paramActionSheetItem.setTag(localObject2);
            this.jdField_a_of_type_JavaUtilList.add(paramActionSheetItem);
            aicv.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)localObject1, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, getActivity().getResources().getDimensionPixelSize(2131299011), null, ((MessageForPic)localObject2).picExtraData);
            asos.a((QQAppInterface)localObject1, 2, ((MessageForPic)localObject2).md5, null);
            new aitv().c((QQAppInterface)localObject1, null, (MessageForPic)localObject2);
            return;
          case 39: 
            a("0X8009983");
            paramActionSheetItem = beqz.a(beyq.a((MessageForPic)localObject2, 1).toString());
          }
        } while (paramActionSheetItem == null);
        aicv.a(getActivity(), paramActionSheetItem, Utils.Crc64String(paramActionSheetItem.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          bdll.b(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
          ChatHistoryActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((MessageRecord)localObject2).uniseq);
          return;
        }
        if (getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          bdll.b(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", paramInt, 0, "", "", "", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          aibr.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramActionSheetItem, ((MessageRecord)localObject2).time, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).istroop, true);
          return;
        }
        if (!nlj.a((MessageRecord)localObject2)) {
          break label1243;
        }
        paramActionSheetItem = nlj.a((MessageRecord)localObject2);
        if ((paramActionSheetItem.jdField_a_of_type_JavaLangString != null) || (paramActionSheetItem.jdField_a_of_type_Int == 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
      return;
      localObject3 = paramActionSheetItem.a();
    } while ((localObject3 == null) || (paramActionSheetItem.jdField_a_of_type_Int == 2));
    paramActionSheetItem = URLEncoder.encode(Base64.encodeToString((byte[])localObject3, 2));
    nlj.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem, (MessageRecord)localObject2);
    aber.a((QQAppInterface)localObject1, ((MessageRecord)localObject2).frienduin, paramActionSheetItem, ((QQAppInterface)localObject1).getCurrentAccountUin(), nlj.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem));
    return;
    label1243:
    paramActionSheetItem = ((MessageRecord)localObject2).senderuin;
    aber.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin(), aber.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Asuj instanceof asus)) {
      ((asus)this.jdField_a_of_type_Asuj).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Asuh, paramLong, this);
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    h();
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    QLog.e("AIOEmotionFragment", 2, "AudioPlayer on onError, errorCode = " + paramInt);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131689868, 0).a();
    h();
  }
  
  public void a(List<asug> paramList, asug paramasug)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_Blhq.post(new AIOEmotionFragment.10(this, paramList, paramasug));
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Asuh.notifyDataSetChanged();
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Abkk.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694455), 0).a();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!agej.b())) {
      if (this.jdField_d_of_type_AndroidViewView == null)
      {
        localFragmentActivity = getActivity();
        if (localFragmentActivity != null) {}
      }
    }
    while (this.jdField_d_of_type_AndroidViewView == null)
    {
      FragmentActivity localFragmentActivity;
      return;
      ((LayoutInflater)localFragmentActivity.getSystemService("layout_inflater")).inflate(2131558641, this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      this.jdField_d_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362485);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362486));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362484));
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131365992);
      this.jdField_d_of_type_AndroidViewView.bringToFront();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131689946);
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130849969);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131689945);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130849968);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(BaseApplicationImpl.getContext());
      }
    }
    BaseChatPie.b(getActivity(), paramBoolean3, paramBoolean1, paramBoolean4);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a()) && (!paramBoolean1) && (!paramBoolean4)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(paramBoolean1, paramBoolean3);
      return;
    }
  }
  
  public boolean a()
  {
    return jdField_c_of_type_Int == 0;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a("0X8009980");
    if (this.jdField_a_of_type_Asuj.a()) {
      a();
    }
    return false;
  }
  
  public int[] a()
  {
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if (localObject == null) {
      return null;
    }
    localObject = ((ImageView)localObject).getDrawable();
    if (localObject == null) {
      return null;
    }
    return new int[] { (int)(((Drawable)localObject).getIntrinsicWidth() * this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()), (int)(((Drawable)localObject).getIntrinsicHeight() * this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()) };
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Asuh.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()));
    }
    localObject = this.jdField_a_of_type_Blhq.obtainMessage(1002);
    ((Message)localObject).arg1 = 4;
    this.jdField_a_of_type_Blhq.sendMessage((Message)localObject);
  }
  
  public void b(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onScaleEnd scale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Asuh.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong))
    {
      f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(localLong)).floatValue();
      if (paramFloat <= f) {
        break label124;
      }
    }
    label124:
    for (int i = 4;; i = 0)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_Blhq.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      break;
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
    QLog.d("AIOEmotionFragment", 1, "getView onScrollEnd:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " selectPos: " + i + " hasScrolled: " + this.jdField_c_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a() == this.jdField_a_of_type_Float) {}
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Blhq.removeMessages(1001);
      this.jdField_a_of_type_Blhq.obtainMessage(1001, i, paramInt).sendToTarget();
      return;
    }
  }
  
  protected void b(View paramView)
  {
    Intent localIntent = getActivity().getIntent();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    d();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131367342));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Asuh);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScaleChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297091));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378956));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363243);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131365768));
    this.jdField_a_of_type_ComTencentWidgetDragView.a();
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setDragChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362363));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362364));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365430));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365428));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365992);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365429));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365431));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a().addObserver(this.jdField_a_of_type_Anwy);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369056));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362356));
    this.jdField_a_of_type_Abkk = new abkk();
    this.jdField_a_of_type_Abkk.a(super.getActivity(), this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362362));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363024));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131372797));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363025));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)paramView.findViewById(2131363026));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)paramView.findViewById(2131363029));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setShowProgressLine(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPttPauseOrStopDrawable(2130838205);
    a(asre.jdField_a_of_type_Int, asre.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372238));
    aibo.a().a(this);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 6.0F));
    if ((getActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.jdField_a_of_type_Asuj != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, " initData dataSource=" + this.jdField_a_of_type_Asuj);
      }
      this.jdField_a_of_type_Asuj.a(this, jdField_a_of_type_Asug, false);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void c()
  {
    this.jdField_a_of_type_Blhq.post(new AIOEmotionFragment.12(this));
  }
  
  public void c(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onDoubleTap currScale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Asuh.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong))
    {
      f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(localLong)).floatValue();
      if (paramFloat <= f) {
        break label138;
      }
    }
    label138:
    for (int i = 0;; i = 4)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_Blhq.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(localLong, Float.valueOf(f));
      break;
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = lfm.a(BaseApplicationImpl.getContext());
    boolean bool = AudioHelper.a(BaseApplicationImpl.getContext());
    BaseChatPie.b(getActivity(), paramBoolean2, paramBoolean1, bool);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a()) && (!paramBoolean1) && (!bool)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void d()
  {
    if (jdField_a_of_type_Asug == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if (jdField_c_of_type_Int == 0) {
      this.jdField_a_of_type_Asuj = new asus(getActivity().getIntent(), (asur)jdField_a_of_type_Asug, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Asuh = new asuh(getActivity(), this.jdField_a_of_type_Blhq, jdField_a_of_type_Asug);
      return;
      if (jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_Asuj = new asuq(a(), (asup)jdField_a_of_type_Asug);
      }
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if ((this.jdField_b_of_type_Asre != null) && (this.jdField_b_of_type_Asre.c()))
    {
      String str1 = asos.o.replace("[epId]", this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      String str2 = paramAudioPlayerBase.a();
      this.jdField_a_of_type_Blhq.post(new AIOEmotionFragment.11(this, str2, str1, paramInt, paramAudioPlayerBase));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    int j;
    label139:
    Object localObject;
    label273:
    label285:
    float f2;
    asmu localasmu;
    asre localasre;
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 1001: 
      do
      {
        do
        {
          return true;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
        paramMessage = (String)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("AIOEmotionFragment", 2, "update album name:" + paramMessage);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
        return true;
        j = paramMessage.arg1;
        i = paramMessage.arg2;
      } while ((j == this.jdField_b_of_type_Int) && (i == 0));
      if (j != this.jdField_b_of_type_Int)
      {
        i = 1;
        this.jdField_b_of_type_Int = j;
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
        this.jdField_b_of_type_Asre = null;
        if (j == -1) {
          break label273;
        }
      }
      for (localObject = this.jdField_a_of_type_Asuh.a(j);; localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem())
      {
        localObject = (asug)localObject;
        if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Asuh.a(j))) {
          break;
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label285;
        }
        if ((i != 0) && (c()))
        {
          QLog.d("AIOEmotionFragment", 2, "MSG_UPDATE_EMOTION_UI stopAudio");
          g();
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        return true;
        i = 0;
        break label139;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((((asug)localObject).a()) && (j != -1))
      {
        f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
        localasmu = ((asug)localObject).a();
        if (localasmu != null) {
          if ((localasmu instanceof asre))
          {
            localasre = (asre)localasmu;
            if (localasre.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Asuh.a(j))) {
                break label883;
              }
            }
          }
        }
      }
      break;
    }
    label883:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Asuh.a(j))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_b_of_type_Asre = localasre;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localasre.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localasre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
      QLog.d("AIOEmotionFragment", 1, "getView emotion name:" + localasre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      if (a(localasre))
      {
        paramMessage = (Drawable)paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((URLDrawable)paramMessage);
        }
      }
      b();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      a(localasmu);
      while (((localObject instanceof asur)) && (!((asug)localObject).a()) && (!((asus)this.jdField_a_of_type_Asuj).a((asug)localObject)))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Abkk.a();
        this.jdField_a_of_type_Abkk.a(0);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(false);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(false);
        ((asus)this.jdField_a_of_type_Asuj).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Blhq, (asug)localObject, this);
        return true;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        if (((asug)localObject).c()) {
          a((asur)localObject);
        }
        if (((asug)localObject).d()) {
          b((asur)localObject);
        }
        a(j, (asug)localObject);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Abkk.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return true;
      j = paramMessage.arg1;
      if (j == 0)
      {
        paramMessage = (asug)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
        if (paramMessage.a())
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return true;
        }
        if (paramMessage.a() != null) {}
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(i);
          return true;
          i = 4;
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(j);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(j);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(j);
      return true;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131718523));
      paramIntent = new Bundle(paramIntent.getExtras());
      localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.a() != null) {
        ForwardUtils.a(super.a(), super.getActivity(), this.jdField_a_of_type_AndroidContentContext, localIntent, ThreadManager.getUIHandler());
      }
    }
    while ((paramInt2 != -1) || (paramInt1 != 2))
    {
      Intent localIntent;
      return;
    }
    this.jdField_a_of_type_Blhq.removeMessages(1001);
    this.jdField_a_of_type_Blhq.obtainMessage(1001, -1, 1).sendToTarget();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if ((paramView.getId() == 2131362364) || (paramView.getId() == 2131362363)) {
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {}
    }
    Object localObject;
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          CustomEmotionData localCustomEmotionData = ((asug)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem()).a();
          if (localCustomEmotionData != null)
          {
            if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {}
            for (localObject = localCustomEmotionData.modifyWord;; localObject = localCustomEmotionData.ocrWord)
            {
              Intent localIntent = new Intent(getActivity(), EditActivity.class);
              localIntent.putExtra("title", 2131691755);
              localIntent.putExtra("limit", 30);
              localIntent.putExtra("action", 105);
              localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
              localIntent.putExtra("key_input_tip", getResources().getString(2131691756));
              localIntent.putExtra("current", (String)localObject);
              localIntent.putExtra("canPostNull", false);
              localIntent.putExtra("multiLine", false);
              bdll.b(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.jdField_a_of_type_Asuj.a(), 0, "", "", "", "");
              startActivityForResult(localIntent, 2);
              break;
            }
            if ((paramView.getId() != 2131363026) && (paramView.getId() != 2131363029)) {
              break;
            }
            if (c())
            {
              g();
              if ((this.jdField_b_of_type_Asre != null) && (this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)) {
                axfj.a(a(), "0X800A9E1", -1, this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
              }
            }
            else
            {
              f();
              if ((this.jdField_b_of_type_Asre != null) && (this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)) {
                axfj.a(a(), "0X800A9E0", -1, this.jdField_b_of_type_Asre.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
              }
            }
          }
        }
      } while (paramView.getId() != 2131362485);
      localObject = a();
    } while (localObject == null);
    boolean bool3 = lfm.a(BaseApplicationImpl.getContext());
    boolean bool4 = AudioHelper.a(BaseApplicationImpl.getContext());
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = true;
      label414:
      this.jdField_a_of_type_Boolean = bool1;
      ((QQAppInterface)localObject).d(bool1);
      bool1 = c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(1, this.jdField_a_of_type_Boolean);
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool3, bool4);
      if ((bool3) || (bool4) || (!bool1)) {
        break label490;
      }
    }
    label490:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(bool1, this.jdField_a_of_type_Boolean);
      break;
      bool1 = false;
      break label414;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (jdField_a_of_type_Asug == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (jdField_a_of_type_Asug == null) {}
    try
    {
      jdField_a_of_type_Asug = asug.a(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("AIOEmotionFragment", 1, "onCreate exception:", paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 1, "onCreateView");
    }
    if ((jdField_a_of_type_Asug != null) && (jdField_a_of_type_Asug.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 2;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Blhq.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Astz != null)
    {
      askc.a().b(this.jdField_a_of_type_Astz);
      this.jdField_a_of_type_Astz = null;
    }
    a().removeObserver(this.jdField_a_of_type_Anwy);
    if (this.jdField_a_of_type_Asuj != null) {
      this.jdField_a_of_type_Asuj.a();
    }
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.c();
      }
      localObject = a();
      if (localObject != null) {
        AudioDeviceManager.a((QQAppInterface)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.k();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    aibo.a().b(this);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Asuh.a(paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    super.onPause();
    if (c()) {
      g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (jdField_a_of_type_Asug != null)
    {
      QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
      jdField_a_of_type_Asug.a(paramBundle, jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */