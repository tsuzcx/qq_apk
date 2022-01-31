package com.tencent.mobileqq.emotionintegrate;

import abtq;
import actj;
import actp;
import acts;
import advs;
import aegp;
import aegr;
import aegs;
import aehw;
import ajvo;
import ajya;
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
import anvw;
import anvx;
import anyh;
import anzr;
import aobp;
import aodf;
import aodg;
import aodh;
import aodi;
import aodj;
import aodk;
import aodl;
import aodn;
import aodt;
import aodu;
import aodv;
import aodw;
import aodx;
import aodz;
import aoea;
import aoec;
import aoed;
import aoee;
import aoef;
import aqbe;
import ascb;
import askf;
import axqy;
import axrn;
import axuv;
import ayoi;
import aywm;
import bbjk;
import bbjs;
import bbkb;
import bcql;
import bcvf;
import bcvh;
import bcvv;
import bfob;
import bfpu;
import bfpv;
import bfqt;
import bfqu;
import bfsd;
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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
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
import lgh;
import mqq.app.AppRuntime;
import myb;
import myc;
import xkn;
import xqa;

public class AIOEmotionFragment
  extends AIOEmotionBaseFragment
  implements actp, acts, aegr, Handler.Callback, View.OnClickListener, aodx, aodz, aoea, bfpu, bfpv, bfqt, bfqu, bfsd
{
  public static aobp a;
  public static aodt a;
  private static int jdField_c_of_type_Int;
  private float jdField_a_of_type_Float = 1.0F;
  private ajvo jdField_a_of_type_Ajvo = new aodl(this);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aodn jdField_a_of_type_Aodn;
  aodu jdField_a_of_type_Aodu;
  private aodw jdField_a_of_type_Aodw;
  public bcvf a;
  public final bfob a;
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
  xqa jdField_a_of_type_Xqa;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public aobp b;
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
    this.jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(paramInt1);
    axuv localaxuv = new axuv(paramInt1, 1, 1, actj.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localaxuv);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.postInvalidate();
  }
  
  private void a(int paramInt, aodt paramaodt)
  {
    paramaodt = paramaodt.a();
    float f2;
    if (paramaodt != null)
    {
      f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "updateEmotionOcr scale=" + f2 + "originalScale=" + f2);
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Aodu.a(paramInt))) {
        break label559;
      }
    }
    label528:
    label559:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aodu.a(paramInt))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramaodt.modifyWord))
      {
        paramaodt = paramaodt.modifyWord;
        if (!TextUtils.isEmpty(paramaodt)) {
          break label528;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166941));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692052));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
        if ((b()) && (bbkb.G(this.jdField_a_of_type_AndroidContentContext, a().c())))
        {
          bbkb.x(this.jdField_a_of_type_AndroidContentContext, a().c(), false);
          paramaodt = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramaodt.setOrientation(1);
          paramaodt.setGravity(1);
          Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838588));
          paramaodt.addView((View)localObject);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = (-actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.topMargin = actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
          ((TextView)localObject).setTextSize(14.0F);
          ((TextView)localObject).setGravity(17);
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692064));
          ((TextView)localObject).setBackgroundResource(2130838590);
          paramaodt.addView((View)localObject);
          paramInt = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
          paramaodt = new PopupWindow(paramaodt, -2, -2);
          paramaodt.setBackgroundDrawable(new ColorDrawable(0));
          paramaodt.setOutsideTouchable(true);
          paramaodt.setFocusable(true);
          ((TextView)localObject).measure(0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.post(new AIOEmotionFragment.3(this, paramaodt, (TextView)localObject));
        }
        return;
        paramaodt = paramaodt.ocrWord;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165275));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaodt);
      }
    }
  }
  
  public static void a(Context paramContext, anyh paramanyh, Rect paramRect)
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
    jdField_a_of_type_Aodt = new aoec(paramanyh);
    localIntent.putExtra("from_chat_history", false);
    localIntent.putExtra("public_fragment_window_feature", 1);
    abtq.a(localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
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
        jdField_a_of_type_Aodt = new aoee(paramMessageRecord);
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
        abtq.a((Activity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 38);
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
      abtq.a((Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
      label375:
      bool = false;
    }
  }
  
  private void a(anyh paramanyh)
  {
    label60:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2))
    {
      i = 1;
      if ((i == 0) || (paramanyh == null)) {
        break label311;
      }
      a("0X800997E");
      if ((!(paramanyh instanceof aobp)) || (!((aobp)paramanyh).c())) {
        break label255;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new aodi(this));
      paramanyh = paramanyh.a(getActivity(), getResources().getDisplayMetrics().density);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramanyh);
      paramanyh = null;
      localObject = aodv.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject != null) {
        paramanyh = ((EmoticonPackage)localObject).name;
      }
      localObject = a();
      if (localObject == null) {
        break label320;
      }
      if (TextUtils.isEmpty(paramanyh)) {
        break label278;
      }
      if (paramanyh.length() <= 11) {
        break label267;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramanyh.substring(0, 10) + "...");
      label198:
      if (!((askf)((QQAppInterface)localObject).getManager(14)).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) {
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131700028));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        return;
        i = 0;
        break;
        label255:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label60;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramanyh);
        break label198;
        a((QQAppInterface)localObject, 4);
        break label198;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131700027));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      return;
    }
  }
  
  private void a(aoee paramaoee)
  {
    a("0X800A7E6");
    paramaoee = (MessageForPic)paramaoee.a;
    int i = paramaoee.picExtraData.from;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    if (!TextUtils.isEmpty(paramaoee.picExtraData.source))
    {
      if (paramaoee.picExtraData.source.length() > 11) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramaoee.picExtraData.source.substring(0, 10) + "...");
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new aodh(this, i, paramaoee));
      if (i != 1) {
        break label294;
      }
      if (!((askf)a().getManager(14)).b(paramaoee.picExtraData.emojiPkgId)) {
        break label327;
      }
    }
    label294:
    label327:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689902));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        paramaoee = advs.a(paramaoee);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = aywm.a;
        localURLDrawableOptions.mGifRoundCorner = this.jdField_d_of_type_Int;
        localURLDrawableOptions.mPlayGifImage = true;
        paramaoee = URLDrawable.getDrawable(paramaoee, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramaoee);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramaoee.picExtraData.source);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689903));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689904));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aodn == null) {
      this.jdField_a_of_type_Aodn = new aodn(this);
    }
    if ((this.jdField_b_of_type_Aobp == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null))
    {
      QLog.d("AIOEmotionFragment", 1, "error in json downloading");
      if (paramInt == 32) {}
      a(false);
      return;
    }
    this.jdField_a_of_type_Aodn.a(paramInt, paramQQAppInterface, getActivity(), this.jdField_b_of_type_Aobp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    anvw.a().a(this.jdField_a_of_type_Aodn);
    ((anvx)paramQQAppInterface.getManager(43)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, anvx.jdField_c_of_type_Int);
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
      this.jdField_a_of_type_Bcvf.a(localIntent);
    }
    this.jdField_a_of_type_Bcvf.a();
  }
  
  private boolean a(aobp paramaobp)
  {
    if ((paramaobp == null) || (!paramaobp.c())) {}
    while (paramaobp.a() == null) {
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setMaxTopBottomPadding(4);
    localLayoutParams.width = actj.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramaobp.a(), actj.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramaobp.b());
    a(paramaobp.c(), paramaobp.d());
    return true;
  }
  
  private boolean b()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Aodu.a(this.jdField_b_of_type_Int))) && (f != ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aodu.a(this.jdField_b_of_type_Int))).floatValue())) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if ((localObject instanceof ImageView))
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        int i;
        if ((localObject instanceof ascb))
        {
          i = actj.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_Float = f;
          localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f / 2.0F) + actj.a(5.0F, getResources()));
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
        if (((((MediaPlayerManager)localObject).a() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).a())) {
          ((MediaPlayerManager)localObject).a(true);
        }
      }
      return;
    }
  }
  
  private void f()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this.jdField_a_of_type_AndroidContentContext, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Aobp != null)
    {
      localObject2 = anzr.o.replace("[epId]", this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      this.jdField_b_of_type_Boolean = false;
      localObject1 = a();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Boolean = ((QQAppInterface)localObject1).t();
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((QQAppInterface)localObject1);
        if (localMediaPlayerManager.a()) {
          localMediaPlayerManager.a(true);
        }
      }
      boolean bool3 = lgh.a(BaseApplicationImpl.getContext());
      boolean bool4 = AudioHelper.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool3);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool4);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a((String)localObject2)) {
        break label398;
      }
      if (localObject1 != null) {
        AudioDeviceManager.a((QQAppInterface)localObject1).b();
      }
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool3, bool4);
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (!bool4) {
          bool1 = true;
        }
      }
      a(bool1, this.jdField_a_of_type_Boolean);
      localObject2 = getActivity();
      if (localObject2 != null) {
        ((Activity)localObject2).getWindow().addFlags(128);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject2 = (URLDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null) {
          aobp.a((URLDrawable)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
    }
    label398:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        askf.a((QQAppInterface)localObject1, "0X800A935", -1, this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
      localObject2 = new HashMap();
      if (bool1) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ((HashMap)localObject2).put("playResult", localObject1);
        ((HashMap)localObject2).put("playType", "2");
        axrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool1, 0L, 0L, (HashMap)localObject2, null);
        return;
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
    a(false, false);
    Object localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).getWindow().clearFlags(128);
    }
    localObject = a();
    if (localObject != null) {
      AudioDeviceManager.a((QQAppInterface)localObject).c();
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
    aodt localaodt = (aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (localaodt.a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    if (localaodt.c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (localaodt.a() == null) {
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
  
  public int a()
  {
    return 31;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131558542, paramViewGroup, false);
  }
  
  protected void a()
  {
    boolean bool = false;
    Object localObject1 = (aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    Object localObject2;
    int i;
    if ((localObject1 instanceof aoee))
    {
      localObject2 = ((aoee)localObject1).a;
      if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).picExtraData != null)) {
        if ((((MessageForPic)localObject2).picExtraData.isZhitu()) && (!((MessageRecord)localObject2).isSend())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bcvf == null)
      {
        localObject2 = new bcvv();
        ((bcvv)localObject2).jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_Bcvf = bcvh.a((bcvv)localObject2);
        this.jdField_a_of_type_Bcvf.a(this.jdField_a_of_type_AndroidContentContext.getString(2131692919));
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      bbjk.a(2, (ArrayList)localObject2);
      bbjk.a(48, localArrayList);
      if (!getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
        bbjk.a(65, localArrayList);
      }
      if (!((aodt)localObject1).a()) {
        bbjk.a(39, localArrayList);
      }
      if (getActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
        bbjk.a(54, localArrayList);
      }
      if (i != 0) {
        bbjk.a(66, localArrayList);
      }
      this.jdField_a_of_type_Bcvf.a(new aodf(this));
      this.jdField_a_of_type_Bcvf.a((List)localObject2, localArrayList);
      if (getActivity() != null) {
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
      }
      localObject2 = a();
      if (((localObject1 instanceof aoee)) && (localObject2 != null))
      {
        localObject1 = ((aoee)localObject1).a;
        if ((localObject1 instanceof MessageForMarketFace)) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_b_of_type_Aobp != null))
            {
              jdField_a_of_type_Aobp = this.jdField_b_of_type_Aobp;
              ((askf)((QQAppInterface)localObject2).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new aodg(this, (QQAppInterface)localObject2));
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
        this.jdField_a_of_type_Bcvf.a();
        return;
        localObject1 = advs.a((MessageForPic)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject2, this.jdField_a_of_type_AndroidContentContext);
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
        ((Intent)localObject1).putExtra("key_new_img_shareactionsheet", 1);
        ((Intent)localObject1).putExtra("k_dataline", true);
        this.jdField_a_of_type_Bcvf.a((Intent)localObject1);
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
      this.jdField_a_of_type_Bfob.removeMessages(1001);
      this.jdField_a_of_type_Bfob.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
  
  public void a(int paramInt, bbjs parambbjs)
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
            localObject2 = (aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
          } while (!(localObject2 instanceof aoee));
          localObject2 = ((aoee)localObject2).a;
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
              advs.a((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3D", "");
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_Aobp == null))
              {
                parambbjs = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                  i = 1;
                  break;
                }
              }
              jdField_a_of_type_Aobp = this.jdField_b_of_type_Aobp;
              ((askf)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new aodj(this, (QQAppInterface)localObject1));
              return;
            }
            parambbjs = advs.a((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
            parambbjs.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            aqbe.a(super.getActivity(), parambbjs, 1, 100500, "biz_src_jc_gif");
            return;
          case 72: 
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("key_req", ForwardRecentActivity.f);
            ((Bundle)localObject3).putInt("key_direct_show_uin_type", parambbjs.f);
            ((Bundle)localObject3).putString("key_direct_show_uin", parambbjs.c);
            if (i == 0)
            {
              if (this.jdField_b_of_type_Aobp == null)
              {
                QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
                return;
              }
              jdField_a_of_type_Aobp = this.jdField_b_of_type_Aobp;
              parambbjs = new Intent();
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("forward_type", 9);
              ((Bundle)localObject1).putBoolean("forward_emotion_from_preview", true);
              parambbjs.putExtras((Bundle)localObject1);
              parambbjs.putExtras((Bundle)localObject3);
              aqbe.a(super.getActivity(), parambbjs, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gif");
              return;
            }
            ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
            parambbjs = advs.a((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
            parambbjs.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            parambbjs.putExtras((Bundle)localObject3);
            aqbe.a(super.getActivity(), parambbjs, ForwardRecentTranslucentActivity.class, 1, 100500, "biz_src_jc_gif");
            return;
          case 48: 
            a("0X8009982");
            if ((localObject2 instanceof MessageForPic)) {
              advs.a((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3E", "");
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_Aobp == null))
              {
                parambbjs = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                }
              }
              ((askf)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new aodk(this, (QQAppInterface)localObject1));
              return;
            }
            parambbjs = aywm.a(aywm.a((MessageForPic)localObject2, 1), -1, -1, null, null, false);
            parambbjs.setTag(localObject2);
            this.jdField_a_of_type_JavaUtilList.add(parambbjs);
            aehw.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)localObject1, parambbjs, ((MessageRecord)localObject2).frienduin, getActivity().getResources().getDimensionPixelSize(2131298865), null, ((MessageForPic)localObject2).picExtraData);
            return;
          case 39: 
            a("0X8009983");
            parambbjs = ayoi.a(aywm.a((MessageForPic)localObject2, 1).toString());
          }
        } while (parambbjs == null);
        aehw.a(getActivity(), parambbjs, Utils.Crc64String(parambbjs.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          axqy.b(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
          ChatHistoryActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((MessageRecord)localObject2).uniseq);
          return;
        }
        if (getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          axqy.b(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", paramInt, 0, "", "", "", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          parambbjs = (bbjs)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            parambbjs = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          aegs.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, parambbjs, ((MessageRecord)localObject2).time, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).istroop, true);
          return;
        }
        if (!myb.a((MessageRecord)localObject2)) {
          break label1196;
        }
        parambbjs = myb.a((MessageRecord)localObject2);
        if ((parambbjs.jdField_a_of_type_JavaLangString != null) || (parambbjs.jdField_a_of_type_Int == 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
      return;
      localObject3 = parambbjs.a();
    } while ((localObject3 == null) || (parambbjs.jdField_a_of_type_Int == 2));
    parambbjs = URLEncoder.encode(Base64.encodeToString((byte[])localObject3, 2));
    myb.a().a(((MessageRecord)localObject2).frienduin, parambbjs, (MessageRecord)localObject2);
    xkn.a((QQAppInterface)localObject1, ((MessageRecord)localObject2).frienduin, parambbjs, ((QQAppInterface)localObject1).getCurrentAccountUin(), myb.a().a(((MessageRecord)localObject2).frienduin, parambbjs));
    return;
    label1196:
    parambbjs = ((MessageRecord)localObject2).senderuin;
    xkn.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, parambbjs, ((MessageRecord)localObject2).frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin(), xkn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_Xqa.a(paramInt / 100);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    switch (paramInt)
    {
    }
    label582:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ((this.jdField_b_of_type_Boolean != paramBoolean) || (paramBoolean == this.jdField_a_of_type_Boolean))
            {
              bool1 = lgh.a(BaseApplicationImpl.getContext());
              bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
              this.jdField_b_of_type_Boolean = paramBoolean;
              if (QLog.isColorLevel()) {
                QLog.d("AIOEmotionFragment", 2, "onAudioDeviceStatusChanged .DEVICE_TYPE_EAR_SPEAKER | currentSpeaker = " + this.jdField_a_of_type_Boolean + " | mNearToEar = " + this.jdField_b_of_type_Boolean + " | wiredHeadsetConnected = " + bool1 + " | btHeadsetConnect = " + bool2);
              }
              paramBoolean = c();
              if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
              {
                this.jdField_a_of_type_Boolean = false;
                if (paramBoolean)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - MediaPlayerManager.jdField_a_of_type_Int);
                  BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool1, bool2);
                }
              }
              while ((!bool1) && (!bool2) && (paramBoolean))
              {
                a(true, this.jdField_a_of_type_Boolean);
                return;
                if (this.jdField_b_of_type_Boolean)
                {
                  if (paramBoolean)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_Boolean, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - MediaPlayerManager.jdField_a_of_type_Int);
                    BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool1, bool2);
                  }
                }
                else if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
                {
                  if (a() != null) {
                    this.jdField_a_of_type_Boolean = a().t();
                  }
                  if (paramBoolean)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - MediaPlayerManager.jdField_a_of_type_Int);
                    BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool1, bool2);
                  }
                }
              }
            }
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null);
        bool1 = c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramBoolean);
        if (bool1)
        {
          if ((!paramBoolean) && (!AudioHelper.a(BaseApplicationImpl.getContext()))) {}
          for (bool1 = bool3;; bool1 = false)
          {
            BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, paramBoolean, AudioHelper.a(BaseApplicationImpl.getContext()));
            a(bool1, this.jdField_a_of_type_Boolean);
            QLog.d("AIOEmotionFragment", 2, "onAudioDeviceStatusChanged.DEVICE_TYPE_WIRED_HEADSET visiable is " + bool1);
            return;
          }
        }
        QLog.d("AIOEmotionFragment", 2, "onAudioDeviceStatusChanged.DEVICE_TYPE_WIRED_HEADSET isAudioPlaying is false");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null);
      bool2 = c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d(paramBoolean);
      if (bool2)
      {
        bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool2);
        BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, lgh.a(BaseApplicationImpl.getContext()), bool2);
        if ((lgh.a(BaseApplicationImpl.getContext())) || (bool2)) {
          break label582;
        }
      }
      for (;;)
      {
        a(bool1, this.jdField_a_of_type_Boolean);
        if (paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
        return;
        bool1 = false;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null);
    bool1 = c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c(paramBoolean);
    if (bool1)
    {
      bool1 = AudioHelper.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, lgh.a(BaseApplicationImpl.getContext()), bool1);
      if ((lgh.a(BaseApplicationImpl.getContext())) || (bool1)) {
        break label681;
      }
    }
    label681:
    for (bool1 = bool2;; bool1 = false)
    {
      a(bool1, this.jdField_a_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Aodw instanceof aoef)) {
      ((aoef)this.jdField_a_of_type_Aodw).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Aodu, paramLong, this);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    h();
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    QLog.e("AIOEmotionFragment", 2, "AudioPlayer on onError, errorCode = " + paramInt);
    bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131689912, 0).a();
    h();
  }
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Aodu.a(paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public void a(List<aodt> paramList, aodt paramaodt)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_Bfob.post(new AIOEmotionFragment.9(this, paramList, paramaodt));
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aodu.notifyDataSetChanged();
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xqa.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return;
      bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131695341), 0).a();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!actj.b())) {
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
      ((LayoutInflater)localFragmentActivity.getSystemService("layout_inflater")).inflate(2131558579, this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      this.jdField_d_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362364);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362365));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362363));
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131365625);
      this.jdField_d_of_type_AndroidViewView.bringToFront();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690010);
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130848903);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690009);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130848902);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a()
  {
    return jdField_c_of_type_Int == 0;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a("0X8009980");
    if (this.jdField_a_of_type_Aodw.a()) {
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
    Object localObject = this.jdField_a_of_type_Aodu.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()));
    }
    localObject = this.jdField_a_of_type_Bfob.obtainMessage(1002);
    ((Message)localObject).arg1 = 4;
    this.jdField_a_of_type_Bfob.sendMessage((Message)localObject);
  }
  
  public void b(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onScaleEnd scale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_Bfob.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Aodu.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
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
      this.jdField_a_of_type_Bfob.sendMessage(localMessage);
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
      this.jdField_a_of_type_Bfob.removeMessages(1001);
      this.jdField_a_of_type_Bfob.obtainMessage(1001, i, paramInt).sendToTarget();
      return;
    }
  }
  
  protected void b(View paramView)
  {
    Intent localIntent = getActivity().getIntent();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    d();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131366897));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Aodu);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScaleChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297009));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377369));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362998);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131365403));
    this.jdField_a_of_type_ComTencentWidgetDragView.a();
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setDragChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362251));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362252));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365060));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365058));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365625);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365059));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365061));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a().addObserver(this.jdField_a_of_type_Ajvo);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368441));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362247));
    this.jdField_a_of_type_Xqa = new xqa();
    this.jdField_a_of_type_Xqa.a(super.getActivity(), this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362250));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362856));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131371769));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362857));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)paramView.findViewById(2131362858));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)paramView.findViewById(2131362860));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setShowProgressLine(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPttPauseOrStopDrawable(2130838044);
    a(aobp.jdField_a_of_type_Int, aobp.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371222));
    aegp.a().a(this);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 6.0F));
    if ((getActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.jdField_a_of_type_Aodw != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, " initData dataSource=" + this.jdField_a_of_type_Aodw);
      }
      this.jdField_a_of_type_Aodw.a(this, jdField_a_of_type_Aodt, false);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void c()
  {
    this.jdField_a_of_type_Bfob.post(new AIOEmotionFragment.11(this));
  }
  
  public void c(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onDoubleTap currScale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_Bfob.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Aodu.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
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
      this.jdField_a_of_type_Bfob.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(localLong, Float.valueOf(f));
      break;
    }
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void d()
  {
    if (jdField_a_of_type_Aodt == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if (jdField_c_of_type_Int == 0) {
      this.jdField_a_of_type_Aodw = new aoef(getActivity().getIntent(), (aoee)jdField_a_of_type_Aodt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aodu = new aodu(getActivity(), this.jdField_a_of_type_Bfob, jdField_a_of_type_Aodt);
      return;
      if (jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_Aodw = new aoed(a(), (aoec)jdField_a_of_type_Aodt);
      }
    }
  }
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if ((this.jdField_b_of_type_Aobp != null) && (this.jdField_b_of_type_Aobp.c()))
    {
      String str1 = anzr.o.replace("[epId]", this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      String str2 = paramAudioPlayer.a();
      this.jdField_a_of_type_Bfob.post(new AIOEmotionFragment.10(this, str2, str1, paramInt, paramAudioPlayer));
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
    anyh localanyh;
    aobp localaobp;
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
        this.jdField_b_of_type_Aobp = null;
        if (j == -1) {
          break label273;
        }
      }
      for (localObject = this.jdField_a_of_type_Aodu.a(j);; localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem())
      {
        localObject = (aodt)localObject;
        if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Aodu.a(j))) {
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
      if ((((aodt)localObject).a()) && (j != -1))
      {
        f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
        localanyh = ((aodt)localObject).a();
        if (localanyh != null) {
          if ((localanyh instanceof aobp))
          {
            localaobp = (aobp)localanyh;
            if (localaobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_Aodu.a(j))) {
                break label866;
              }
            }
          }
        }
      }
      break;
    }
    label866:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aodu.a(j))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_b_of_type_Aobp = localaobp;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localaobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localaobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
      QLog.d("AIOEmotionFragment", 1, "getView emotion name:" + localaobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      if (a(localaobp))
      {
        paramMessage = (Drawable)paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((URLDrawable)paramMessage);
        }
      }
      b();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      a(localanyh);
      while (((localObject instanceof aoee)) && (!((aodt)localObject).a()) && (!((aoef)this.jdField_a_of_type_Aodw).a((aodt)localObject)))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Xqa.a();
        this.jdField_a_of_type_Xqa.a(0);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(false);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(false);
        ((aoef)this.jdField_a_of_type_Aodw).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Bfob, (aodt)localObject, this);
        return true;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        if (((aodt)localObject).c()) {
          a((aoee)localObject);
        }
        a(j, (aodt)localObject);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Xqa.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return true;
      j = paramMessage.arg1;
      if (j == 0)
      {
        paramMessage = (aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131720034));
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
    this.jdField_a_of_type_Bfob.removeMessages(1001);
    this.jdField_a_of_type_Bfob.obtainMessage(1001, -1, 1).sendToTarget();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if ((paramView.getId() == 2131362252) || (paramView.getId() == 2131362251)) {
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {}
    }
    label352:
    do
    {
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
              localCustomEmotionData = ((aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem()).a();
            } while (localCustomEmotionData == null);
            if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {}
            for (paramView = localCustomEmotionData.modifyWord;; paramView = localCustomEmotionData.ocrWord)
            {
              Intent localIntent = new Intent(getActivity(), EditActivity.class);
              localIntent.putExtra("title", 2131692056);
              localIntent.putExtra("limit", 30);
              localIntent.putExtra("action", 105);
              localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
              localIntent.putExtra("key_input_tip", getResources().getString(2131692057));
              localIntent.putExtra("current", paramView);
              localIntent.putExtra("canPostNull", false);
              localIntent.putExtra("multiLine", false);
              axqy.b(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.jdField_a_of_type_Aodw.a(), 0, "", "", "", "");
              startActivityForResult(localIntent, 2);
              return;
            }
            if ((paramView.getId() != 2131362858) && (paramView.getId() != 2131362860)) {
              break label352;
            }
            if (!c()) {
              break;
            }
            g();
          } while ((this.jdField_b_of_type_Aobp == null) || (this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null));
          askf.a(a(), "0X800A9E1", -1, this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
          return;
          f();
        } while ((this.jdField_b_of_type_Aobp == null) || (this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null));
        askf.a(a(), "0X800A9E0", -1, this.jdField_b_of_type_Aobp.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        return;
      } while (paramView.getId() != 2131362364);
      paramView = a();
    } while (paramView == null);
    boolean bool3 = lgh.a(BaseApplicationImpl.getContext());
    boolean bool4 = AudioHelper.a(BaseApplicationImpl.getContext());
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      paramView.d(bool1);
      bool1 = c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - MediaPlayerManager.jdField_a_of_type_Int);
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool3, bool4);
      if ((bool3) || (bool4) || (!bool1)) {
        break label481;
      }
    }
    label481:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(bool1, this.jdField_a_of_type_Boolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (jdField_a_of_type_Aodt == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (jdField_a_of_type_Aodt == null) {}
    try
    {
      jdField_a_of_type_Aodt = aodt.a(paramBundle);
      paramBundle = a();
      if (paramBundle != null) {
        AudioDeviceManager.a(paramBundle).a(this);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.d("AIOEmotionFragment", 1, "onCreate exception:", paramBundle);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 1, "onCreateView");
    }
    if ((jdField_a_of_type_Aodt != null) && (jdField_a_of_type_Aodt.a())) {}
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
    this.jdField_a_of_type_Bfob.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Aodn != null)
    {
      anvw.a().b(this.jdField_a_of_type_Aodn);
      this.jdField_a_of_type_Aodn = null;
    }
    a().removeObserver(this.jdField_a_of_type_Ajvo);
    if (this.jdField_a_of_type_Aodw != null) {
      this.jdField_a_of_type_Aodw.a();
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    Object localObject = a();
    if (localObject != null) {
      AudioDeviceManager.a((QQAppInterface)localObject).b(this);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    aegp.a().b(this);
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
    if (jdField_a_of_type_Aodt != null)
    {
      QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
      jdField_a_of_type_Aodt.a(paramBundle, jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */