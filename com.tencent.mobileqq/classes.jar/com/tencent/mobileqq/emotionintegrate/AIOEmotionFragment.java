package com.tencent.mobileqq.emotionintegrate;

import abju;
import aciy;
import acjg;
import adkt;
import advs;
import advu;
import advv;
import adwz;
import ajhn;
import ajjy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anfi;
import anfj;
import anht;
import anjd;
import anla;
import anmq;
import anmr;
import anms;
import anmt;
import anmu;
import anmv;
import anmx;
import annd;
import anne;
import annf;
import anng;
import annh;
import annj;
import annk;
import annm;
import annn;
import anno;
import annp;
import aphp;
import arfx;
import arnz;
import awqx;
import awrn;
import awur;
import axoa;
import axwd;
import bahv;
import bahx;
import baig;
import bbmy;
import befq;
import behj;
import behk;
import beii;
import beij;
import bejs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.contact.newfriend.connections.TriangleView;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import kvx;
import mnf;
import mng;
import mqq.app.AppRuntime;
import xbq;
import xhd;

public class AIOEmotionFragment
  extends AIOEmotionBaseFragment
  implements acjg, advu, Handler.Callback, View.OnClickListener, annh, annj, annk, behj, behk, beii, beij, bejs
{
  public static anla a;
  public static annd a;
  private static int jdField_c_of_type_Int;
  private float jdField_a_of_type_Float = 1.0F;
  private ajhn jdField_a_of_type_Ajhn = new anmv(this);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anmx jdField_a_of_type_Anmx;
  anne jdField_a_of_type_Anne;
  private anng jdField_a_of_type_Anng;
  public bahv a;
  public final befq a;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  public SessionInfo a;
  PttAudioPlayView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView;
  PttAudioWaveView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
  TriangleView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView;
  public Emoticon a;
  EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  private WeakReference<URLDrawable> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Long, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<URLDrawable> jdField_a_of_type_JavaUtilList = new ArrayList();
  xhd jdField_a_of_type_Xhd;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public anla b;
  private boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  
  public AIOEmotionFragment()
  {
    this.jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(paramInt1);
    awur localawur = new awur(paramInt1, 1, 1, aciy.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localawur);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.postInvalidate();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<bahx> paramArrayList)
  {
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(paramInt1);
    localbahx.jdField_b_of_type_Int = paramInt2;
    localbahx.jdField_c_of_type_Int = paramInt3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    paramArrayList.add(localbahx);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<bahx> paramArrayList, int paramInt4)
  {
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(paramInt1);
    localbahx.jdField_b_of_type_Int = paramInt2;
    localbahx.jdField_c_of_type_Int = paramInt3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localbahx.e = paramInt4;
    paramArrayList.add(localbahx);
  }
  
  private void a(int paramInt, annd paramannd)
  {
    paramannd = paramannd.a();
    float f2;
    if (paramannd != null)
    {
      f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "updateEmotionOcr scale=" + f2 + "originalScale=" + f2);
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Anne.a(paramInt))) {
        break label560;
      }
    }
    label529:
    label560:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Anne.a(paramInt))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramannd.modifyWord))
      {
        paramannd = paramannd.modifyWord;
        if (!TextUtils.isEmpty(paramannd)) {
          break label529;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101346));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626466));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
        if ((b()) && (baig.G(this.jdField_a_of_type_AndroidContentContext, a().c())))
        {
          baig.x(this.jdField_a_of_type_AndroidContentContext, a().c(), false);
          paramannd = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramannd.setOrientation(1);
          paramannd.setGravity(1);
          Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838581));
          paramannd.addView((View)localObject);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = (-aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.topMargin = aciy.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
          ((TextView)localObject).setTextSize(14.0F);
          ((TextView)localObject).setGravity(17);
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626478));
          ((TextView)localObject).setBackgroundResource(2130838583);
          paramannd.addView((View)localObject);
          paramInt = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
          paramannd = new PopupWindow(paramannd, -2, -2);
          paramannd.setBackgroundDrawable(new ColorDrawable(0));
          paramannd.setOutsideTouchable(true);
          paramannd.setFocusable(true);
          ((TextView)localObject).measure(0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.post(new AIOEmotionFragment.2(this, paramannd, (TextView)localObject));
        }
        return;
        paramannd = paramannd.ocrWord;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099738));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramannd);
      }
    }
  }
  
  public static void a(Context paramContext, anht paramanht, Rect paramRect)
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
    jdField_a_of_type_Annd = new annm(paramanht);
    localIntent.putExtra("from_chat_history", false);
    localIntent.putExtra("public_fragment_window_feature", 1);
    abju.a(localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
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
        jdField_a_of_type_Annd = new anno(paramMessageRecord);
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
        abju.a((Activity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 38);
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
      abju.a((Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
      label375:
      bool = false;
    }
  }
  
  private void a(anht paramanht)
  {
    label60:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2))
    {
      i = 1;
      if ((i == 0) || (paramanht == null)) {
        break label311;
      }
      a("0X800997E");
      if ((!(paramanht instanceof anla)) || (!((anla)paramanht).c())) {
        break label255;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new anms(this));
      paramanht = paramanht.a(getActivity(), getResources().getDisplayMetrics().density);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramanht);
      paramanht = null;
      localObject = annf.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject != null) {
        paramanht = ((EmoticonPackage)localObject).name;
      }
      localObject = a();
      if (localObject == null) {
        break label320;
      }
      if (TextUtils.isEmpty(paramanht)) {
        break label278;
      }
      if (paramanht.length() <= 11) {
        break label267;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramanht.substring(0, 10) + "...");
      label198:
      if (!((arnz)((QQAppInterface)localObject).getManager(14)).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) {
        break label320;
      }
    }
    label267:
    label278:
    label311:
    label320:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634229));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        return;
        i = 0;
        break;
        label255:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label60;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramanht);
        break label198;
        a((QQAppInterface)localObject, 4);
        break label198;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634228));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      return;
    }
  }
  
  private void a(anno paramanno)
  {
    a("0X800A7E6");
    paramanno = (MessageForPic)paramanno.a;
    int i = paramanno.picExtraData.from;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    if (!TextUtils.isEmpty(paramanno.picExtraData.source))
    {
      if (paramanno.picExtraData.source.length() > 11) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramanno.picExtraData.source.substring(0, 10) + "...");
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new anmr(this, i, paramanno));
      if (i != 1) {
        break label294;
      }
      if (!((arnz)a().getManager(14)).b(paramanno.picExtraData.emojiPkgId)) {
        break label327;
      }
    }
    label294:
    label327:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624355));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        paramanno = adkt.a(paramanno);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = axwd.a;
        localURLDrawableOptions.mGifRoundCorner = this.jdField_d_of_type_Int;
        localURLDrawableOptions.mPlayGifImage = true;
        paramanno = URLDrawable.getDrawable(paramanno, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramanno);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramanno.picExtraData.source);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624356));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624357));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Anmx == null) {
      this.jdField_a_of_type_Anmx = new anmx(this);
    }
    if ((this.jdField_b_of_type_Anla == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null))
    {
      QLog.d("AIOEmotionFragment", 1, "error in json downloading");
      return;
    }
    this.jdField_a_of_type_Anmx.a(paramInt, paramQQAppInterface, getActivity(), this.jdField_b_of_type_Anla, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    anfi.a().a(this.jdField_a_of_type_Anmx);
    ((anfj)paramQQAppInterface.getManager(43)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, anfj.jdField_c_of_type_Int);
  }
  
  private boolean a(anla paramanla)
  {
    if ((paramanla == null) || (!paramanla.c())) {}
    while (paramanla.a() == null) {
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setMaxTopBottomPadding(4);
    localLayoutParams.width = aciy.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramanla.a(), aciy.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramanla.b());
    a(paramanla.c(), paramanla.d());
    return true;
  }
  
  private boolean b()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Anne.a(this.jdField_b_of_type_Int))) && (f != ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Anne.a(this.jdField_b_of_type_Int))).floatValue())) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if ((localObject instanceof ImageView))
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        int i;
        if ((localObject instanceof arfx))
        {
          i = aciy.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_Float = f;
          localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f / 2.0F) + aciy.a(5.0F, getResources()));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, new Object[] { "updateEmotionNameLayout scale:", Float.valueOf(f), " topMargin:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
          }
          if (i <= 0) {
            break label226;
          }
        }
        label226:
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
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
        if (((((MediaPlayerManager)localObject).a() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).b())) {
          ((MediaPlayerManager)localObject).a(true);
        }
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this.jdField_a_of_type_AndroidContentContext, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Anla != null)
    {
      localObject2 = anjd.o.replace("[epId]", this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      localObject1 = a();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Boolean = ((QQAppInterface)localObject1).t();
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((QQAppInterface)localObject1);
        if (((localMediaPlayerManager.a() instanceof MessageForPtt)) && (localMediaPlayerManager.b())) {
          localMediaPlayerManager.a(true);
        }
      }
      bool1 = kvx.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool2);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a((String)localObject2)) {
        break label335;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject2 = (URLDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null) {
          anla.a((URLDrawable)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
    }
    label335:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        arnz.a((QQAppInterface)localObject1, "0X800A935", -1, this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131624365, 0).a();
      }
      localObject2 = new HashMap();
      if (bool1) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ((HashMap)localObject2).put("playResult", localObject1);
        ((HashMap)localObject2).put("playType", "2");
        awrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool1, 0L, 0L, (HashMap)localObject2, null);
        return;
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      h();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
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
    annd localannd = (annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (localannd.a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    if (localannd.c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (localannd.a() == null) {
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
    return paramLayoutInflater.inflate(2131492990, paramViewGroup, false);
  }
  
  protected void a()
  {
    Object localObject1 = (annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    Object localObject2;
    int i;
    if ((localObject1 instanceof anno))
    {
      localObject2 = ((anno)localObject1).a;
      if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).picExtraData != null)) {
        if ((((MessageForPic)localObject2).picExtraData.isZhitu()) && (!((MessageRecord)localObject2).isSend())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bahv == null)
      {
        this.jdField_a_of_type_Bahv = new bahv(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Bahv.a(this.jdField_a_of_type_AndroidContentContext.getString(2131627280));
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      a(2131627265, 2130839587, 48, (ArrayList)localObject2);
      a(2131627268, 2130839591, 49, (ArrayList)localObject2);
      if (!((annd)localObject1).a()) {
        a(2131627277, 2130839599, 53, (ArrayList)localObject2);
      }
      if (i != 0) {
        a(2131655027, 2130842024, 66, (ArrayList)localObject2);
      }
      if (!getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
        a(2131626482, 2130839589, 65, localArrayList, 2);
      }
      if (getActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
        a(2131627281, 2130839601, 54, localArrayList, 3);
      }
      this.jdField_a_of_type_Bahv.a(new anmq(this));
      localObject1 = (List[])new ArrayList[] { localObject2, localArrayList };
      this.jdField_a_of_type_Bahv.a((List[])localObject1);
      this.jdField_a_of_type_Bahv.a();
      return;
      i = 0;
      continue;
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
    QLog.d("AIOEmotionFragment", 1, "getView onScrollStart:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " hasScrolled: " + this.jdField_b_of_type_Boolean);
    this.jdField_c_of_type_Boolean = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Befq.removeMessages(1001);
      this.jdField_a_of_type_Befq.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_Xhd.a(paramInt / 100);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Anng instanceof annp)) {
      ((annp)this.jdField_a_of_type_Anng).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Anne, paramLong, this);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    h();
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    QLog.e("AIOEmotionFragment", 2, "AudioPlayer on onError, errorCode = " + paramInt);
    h();
  }
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Anne.a(paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public void a(List<annd> paramList, annd paramannd)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_Befq.post(new AIOEmotionFragment.8(this, paramList, paramannd));
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Anne.notifyDataSetChanged();
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xhd.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return;
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131629659), 0).a();
    }
  }
  
  public boolean a()
  {
    return jdField_c_of_type_Int == 0;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a("0X8009980");
    if (this.jdField_a_of_type_Anng.a()) {
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
    Object localObject = this.jdField_a_of_type_Anne.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()));
    }
    localObject = this.jdField_a_of_type_Befq.obtainMessage(1002);
    ((Message)localObject).arg1 = 4;
    this.jdField_a_of_type_Befq.sendMessage((Message)localObject);
  }
  
  public void b(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onScaleEnd scale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_Befq.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Anne.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
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
      this.jdField_a_of_type_Befq.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      break;
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
    QLog.d("AIOEmotionFragment", 1, "getView onScrollEnd:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " selectPos: " + i + " hasScrolled: " + this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a() == this.jdField_a_of_type_Float) {}
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Befq.removeMessages(1001);
      this.jdField_a_of_type_Befq.obtainMessage(1001, i, paramInt).sendToTarget();
      return;
    }
  }
  
  protected void b(View paramView)
  {
    Intent localIntent = getActivity().getIntent();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    d();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131301286));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Anne);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScaleChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165934));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131311553));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131297459);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131299824));
    this.jdField_a_of_type_ComTencentWidgetDragView.a();
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setDragChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296711));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131296712));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299493));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299491));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131300030);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299492));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299494));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a().addObserver(this.jdField_a_of_type_Ajhn);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302816));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296707));
    this.jdField_a_of_type_Xhd = new xhd();
    this.jdField_a_of_type_Xhd.a(super.getActivity(), this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131296710));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297317));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131306072));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297318));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)paramView.findViewById(2131297319));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)paramView.findViewById(2131297321));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setShowProgressLine(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPttPauseOrStopDrawable(2130838036);
    a(anla.jdField_a_of_type_Int, anla.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    advs.a().a(this);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 6.0F));
    if ((getActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.jdField_a_of_type_Anng != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, " initData dataSource=" + this.jdField_a_of_type_Anng);
      }
      this.jdField_a_of_type_Anng.a(this, jdField_a_of_type_Annd, false);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void c()
  {
    this.jdField_a_of_type_Befq.post(new AIOEmotionFragment.10(this));
  }
  
  public void c(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onDoubleTap currScale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_Befq.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Anne.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
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
      this.jdField_a_of_type_Befq.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(localLong, Float.valueOf(f));
      break;
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.d("AIOEmotionFragment", 1, "error runtime");
    }
    MessageRecord localMessageRecord;
    byte[] arrayOfByte;
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
            localObject2 = (annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
          } while (!(localObject2 instanceof anno));
          localMessageRecord = ((anno)localObject2).a;
          int i;
          if ((localMessageRecord instanceof MessageForMarketFace)) {
            i = 0;
          }
          switch (paramInt)
          {
          default: 
            return;
          case 48: 
            a("0X8009982");
            if ((localMessageRecord instanceof MessageForPic)) {
              adkt.a((QQAppInterface)localObject1, ((MessageForPic)localMessageRecord).senderuin, ((MessageForPic)localMessageRecord).md5, "0X8009F3E", "");
            }
            if (i == 0) {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_Anla == null))
              {
                localObject1 = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
                  break;
                }
              }
            }
          case 49: 
            for (boolean bool = true;; bool = false)
            {
              QLog.d("AIOEmotionFragment", 1, bool);
              return;
              i = 1;
              break;
              a("0X8009981");
              if ((localMessageRecord instanceof MessageForPic)) {
                adkt.a((QQAppInterface)localObject1, ((MessageForPic)localMessageRecord).senderuin, ((MessageForPic)localMessageRecord).md5, "0X8009F3D", "");
              }
              if (i == 0)
              {
                if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_Anla == null))
                {
                  localObject1 = new StringBuilder().append("error mEmoticon, ");
                  if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                  for (bool = true;; bool = false)
                  {
                    QLog.d("AIOEmotionFragment", 1, bool);
                    return;
                  }
                }
                jdField_a_of_type_Anla = this.jdField_b_of_type_Anla;
                ((arnz)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new anmt(this, (QQAppInterface)localObject1));
                return;
              }
              localObject1 = adkt.a((MessageForPic)localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
              ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
              aphp.a(super.getActivity(), (Intent)localObject1, 1);
              return;
            }
            ((arnz)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new anmu(this, (QQAppInterface)localObject1));
            return;
            localObject2 = axwd.a(axwd.a((MessageForPic)localMessageRecord, 1), -1, -1, null, null, false);
            ((URLDrawable)localObject2).setTag(localMessageRecord);
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            adwz.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)localObject1, (URLDrawable)localObject2, localMessageRecord.frienduin, getActivity().getResources().getDimensionPixelSize(2131167766), null, ((MessageForPic)localMessageRecord).picExtraData);
            return;
          case 53: 
            a("0X8009983");
            localObject1 = axoa.a(axwd.a((MessageForPic)localMessageRecord, 1).toString());
          }
        } while (localObject1 == null);
        adwz.a(getActivity(), (File)localObject1, Utils.Crc64String(((File)localObject1).getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          awqx.b(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
          ChatHistoryActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localMessageRecord.uniseq);
          return;
        }
        if (getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          awqx.b(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", paramInt, 0, "", "", "", "");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          advv.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, localMessageRecord.time, localMessageRecord.shmsgseq, localMessageRecord.istroop, true);
          return;
        }
        if (!mnf.a(localMessageRecord)) {
          break label967;
        }
        localObject2 = mnf.a(localMessageRecord);
        if ((((mng)localObject2).jdField_a_of_type_JavaLangString != null) || (((mng)localObject2).jdField_a_of_type_Int == 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
      return;
      arrayOfByte = ((mng)localObject2).a();
    } while ((arrayOfByte == null) || (((mng)localObject2).jdField_a_of_type_Int == 2));
    Object localObject2 = URLEncoder.encode(Base64.encodeToString(arrayOfByte, 2));
    mnf.a().a(localMessageRecord.frienduin, (String)localObject2, localMessageRecord);
    xbq.a((QQAppInterface)localObject1, localMessageRecord.frienduin, (String)localObject2, ((QQAppInterface)localObject1).getCurrentAccountUin(), mnf.a().a(localMessageRecord.frienduin, (String)localObject2));
    return;
    label967:
    localObject2 = localMessageRecord.senderuin;
    xbq.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject2, localMessageRecord.frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin(), xbq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void d()
  {
    if (jdField_a_of_type_Annd == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if (jdField_c_of_type_Int == 0) {
      this.jdField_a_of_type_Anng = new annp(getActivity().getIntent(), (anno)jdField_a_of_type_Annd, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Anne = new anne(getActivity(), this.jdField_a_of_type_Befq, jdField_a_of_type_Annd);
      return;
      if (jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_Anng = new annn(a(), (annm)jdField_a_of_type_Annd);
      }
    }
  }
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if ((this.jdField_b_of_type_Anla != null) && (this.jdField_b_of_type_Anla.c()))
    {
      String str = anjd.o.replace("[epId]", this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (paramAudioPlayer.a().equalsIgnoreCase(str))
      {
        float f = paramInt / paramAudioPlayer.a();
        this.jdField_a_of_type_Befq.post(new AIOEmotionFragment.9(this, f));
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    int j;
    label139:
    Object localObject;
    label264:
    label276:
    float f2;
    anht localanht;
    anla localanla;
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
        this.jdField_b_of_type_Anla = null;
        if (j == -1) {
          break label264;
        }
      }
      for (localObject = this.jdField_a_of_type_Anne.a(j);; localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem())
      {
        localObject = (annd)localObject;
        if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Anne.a(j))) {
          break;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label276;
        }
        if ((i != 0) && (c())) {
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
      if ((((annd)localObject).a()) && (j != -1))
      {
        f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
        localanht = ((annd)localObject).a();
        if (localanht != null) {
          if ((localanht instanceof anla))
          {
            localanla = (anla)localanht;
            if (localanla.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Anne.a(j))) {
                break label857;
              }
            }
          }
        }
      }
      break;
    }
    label857:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Anne.a(j))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_b_of_type_Anla = localanla;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localanla.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localanla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
      QLog.d("AIOEmotionFragment", 1, "getView emotion name:" + localanla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      if (a(localanla))
      {
        paramMessage = (Drawable)paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((URLDrawable)paramMessage);
        }
      }
      b();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      a(localanht);
      while (((localObject instanceof anno)) && (!((annd)localObject).a()) && (!((annp)this.jdField_a_of_type_Anng).a((annd)localObject)))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Xhd.a();
        this.jdField_a_of_type_Xhd.a(0);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(false);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(false);
        ((annp)this.jdField_a_of_type_Anng).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Befq, (annd)localObject, this);
        return true;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        if (((annd)localObject).c()) {
          a((anno)localObject);
        }
        a(j, (annd)localObject);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Xhd.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return true;
      j = paramMessage.arg1;
      if (j == 0)
      {
        paramMessage = (annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131654133));
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
    this.jdField_a_of_type_Befq.removeMessages(1001);
    this.jdField_a_of_type_Befq.obtainMessage(1001, -1, 1).sendToTarget();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131296712) || (paramView.getId() == 2131296711)) {
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {}
    }
    do
    {
      do
      {
        do
        {
          CustomEmotionData localCustomEmotionData;
          do
          {
            return;
            localCustomEmotionData = ((annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem()).a();
          } while (localCustomEmotionData == null);
          if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {}
          for (paramView = localCustomEmotionData.modifyWord;; paramView = localCustomEmotionData.ocrWord)
          {
            Intent localIntent = new Intent(getActivity(), EditActivity.class);
            localIntent.putExtra("title", 2131626470);
            localIntent.putExtra("limit", 30);
            localIntent.putExtra("action", 105);
            localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
            localIntent.putExtra("key_input_tip", getResources().getString(2131626471));
            localIntent.putExtra("current", paramView);
            localIntent.putExtra("canPostNull", false);
            localIntent.putExtra("multiLine", false);
            awqx.b(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.jdField_a_of_type_Anng.a(), 0, "", "", "", "");
            localIntent.setFlags(268435456);
            startActivityForResult(localIntent, 2);
            return;
          }
        } while ((paramView.getId() != 2131297319) && (paramView.getId() != 2131297321));
        if (!c()) {
          break;
        }
        g();
      } while ((this.jdField_b_of_type_Anla == null) || (this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null));
      arnz.a(a(), "0X800A9E1", -1, this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      return;
      f();
    } while ((this.jdField_b_of_type_Anla == null) || (this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null));
    arnz.a(a(), "0X800A9E0", -1, this.jdField_b_of_type_Anla.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (jdField_a_of_type_Annd == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (jdField_a_of_type_Annd == null) {}
    try
    {
      jdField_a_of_type_Annd = annd.a(paramBundle);
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
    if ((jdField_a_of_type_Annd != null) && (jdField_a_of_type_Annd.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      i = 2;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Anmx != null)
    {
      anfi.a().b(this.jdField_a_of_type_Anmx);
      this.jdField_a_of_type_Anmx = null;
    }
    a().removeObserver(this.jdField_a_of_type_Ajhn);
    if (this.jdField_a_of_type_Anng != null) {
      this.jdField_a_of_type_Anng.a();
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((URLDrawable)localIterator.next()).setTag(null);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    advs.a().b(this);
  }
  
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
    if (jdField_a_of_type_Annd != null)
    {
      QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
      jdField_a_of_type_Annd.a(paramBundle, jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */