package com.tencent.mobileqq.nearby.now.view.viewmodel;

import afeh;
import afei;
import afej;
import afek;
import afel;
import afem;
import afen;
import afeo;
import afep;
import afeq;
import afes;
import afew;
import afex;
import afey;
import affa;
import affb;
import affc;
import affd;
import affe;
import afff;
import affg;
import affh;
import affi;
import affj;
import affk;
import affl;
import affm;
import affn;
import affo;
import affp;
import affq;
import affr;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.OnCloseListener;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_short_video_label.FeedInfo;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp;
import com.tencent.pb.now.ilive_short_video_label.VideoInfo;
import com.tencent.pb.now.ilive_short_video_label.VideoStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayOperationViewModel
{
  public static int a;
  private final long jdField_a_of_type_Long = 500L;
  private affp jdField_a_of_type_Affp = new affp(this, null);
  private affq jdField_a_of_type_Affq = new affq(this, null);
  private affr jdField_a_of_type_Affr = new affr(this, null);
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public QQAppInterface a;
  NowSmallVideoObserver jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver = new afen(this);
  public VideoData a;
  private StuffContainerView.OnCloseListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener;
  String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  public View b;
  String jdField_b_of_type_JavaLangString;
  public volatile boolean b;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int = 6;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 7;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private boolean q;
  
  static
  {
    jdField_a_of_type_Int = 2;
  }
  
  public PlayOperationViewModel(View paramView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = new VideoData();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new afeh(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new afew(this));
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(new affi(this));
    f();
    g();
  }
  
  private AnimatorSet a(View paramView)
  {
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet2.setDuration(200L);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }) });
    localAnimatorSet3.setDuration(350L);
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet1.playSequentially(new Animator[] { localAnimatorSet3, localAnimatorSet2 });
    return localAnimatorSet1;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    String[] arrayOfString = paramContext.getResources().getStringArray(2131296325);
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      localActionSheet.a(str, 1);
      localActionSheet.a(str, 1);
      localActionSheet.a(str, 1);
      i1 += 1;
    }
    localActionSheet.c(2131433029);
    localActionSheet.a(new afey(this, paramString1, arrayOfString, paramString2, paramContext, localActionSheet));
    localActionSheet.show();
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidViewView.findViewById(2131365002).setOnClickListener(new affj(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369189).setOnClickListener(new affk(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370615).setOnClickListener(new affl(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370622).setOnClickListener(new affm(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370590).setOnClickListener(new affn(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370593).setOnClickListener(new affo(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370596).setOnClickListener(new afei(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370599).setOnClickListener(new afej(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370602).setOnClickListener(new afek(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void e(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feeds_id", paramString);
      paramString = localJSONObject.toString();
      localSharedPreferences.edit().putString("nearby_now_delete_success_js_param", paramString).commit();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { a(this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)) });
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370590).setOnTouchListener(new affa(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370593).setOnTouchListener(new affb(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370596).setOnTouchListener(new affc(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370599).setOnTouchListener(new affd(this));
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView.findViewById(2131367537) == null) {
      return;
    }
    this.jdField_f_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370615).setPivotX(UITools.a(this.jdField_b_of_type_AndroidViewView.getContext(), 55.0F) / 2.0F);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370615).setPivotY(UITools.a(this.jdField_b_of_type_AndroidViewView.getContext(), 20.0F) / 2.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370615), "scaleY", new float[] { 0.52F, 1.0F, 0.72F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370615), "scaleX", new float[] { 0.52F, 1.0F, 0.72F, 1.0F });
    localObjectAnimator1.setDuration(800L);
    localObjectAnimator2.setDuration(800L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370621), "translationX", new float[] { 0.0F, UITools.a(this.jdField_b_of_type_AndroidViewView.getContext(), 55.0F) });
    localObjectAnimator3.setStartDelay(1500L);
    localObjectAnimator3.setDuration(800L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.addListener(new afff(this));
    localObjectAnimator3.addListener(new affg(this));
    localAnimatorSet.start();
    localObjectAnimator3.start();
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidViewView.findViewById(2131370619) == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).clearAnimation();
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370621).clearAnimation();
    int i1 = (int)UITools.a(this.jdField_b_of_type_AndroidViewView.getContext(), 20.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131367537), "translationY", new float[] { 0.0F, -i1 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370618), "translationY", new float[] { 0.0F, -i1 });
    Object localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370619), "translationY", new float[] { i1, 0.0F });
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370619).setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370615), "scaleX", new float[] { 1.0F, 0.75F, 0.5F, 0.2F, 0.0F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131370615), "scaleY", new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F });
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    ((AnimatorSet)localObject).addListener(new affh(this));
    ((AnimatorSet)localObject).setDuration(500L);
    ((AnimatorSet)localObject).setStartDelay(800L);
    ((AnimatorSet)localObject).start();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "initCommentsWidget:mVideoData=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "initCommentsWidget:mRoomid=" + this.jdField_h_of_type_Int + "isHasVideoLabel=" + this.m);
    }
    this.jdField_h_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_e_of_type_Long);
    c(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.f);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_i_of_type_Boolean)) {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370609).setVisibility(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ImageView localImageView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370612);
      localImageView.setVisibility(0);
      if (paramInt2 != 1) {
        break label63;
      }
      localImageView.setBackgroundDrawable(localImageView.getResources().getDrawable(2130842864));
    }
    while ((paramInt2 == 255) || (paramInt2 == 0))
    {
      localImageView.setVisibility(8);
      return;
      label63:
      localImageView.setBackgroundDrawable(localImageView.getResources().getDrawable(2130842862));
    }
    localImageView.setVisibility(0);
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370592)).setText("评论");
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370592)).setText(CommentsUtil.b(paramLong));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    ((RoundRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370616)).a(16);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370616).requestLayout();
    ((RoundRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370620)).a(16);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370620).requestLayout();
    d();
  }
  
  public void a(VideoData paramVideoData)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "updateShowInfo:mVideoData=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    }
    this.jdField_e_of_type_JavaLangString = paramVideoData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    if (paramVideoData.jdField_a_of_type_Int == 1)
    {
      a(false);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramVideoData.jdField_e_of_type_JavaLangString;
    if (paramVideoData.jdField_e_of_type_Long == paramVideoData.jdField_b_of_type_Long)
    {
      b(paramVideoData.i);
      d(paramVideoData.h);
      this.jdField_c_of_type_Long = paramVideoData.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = paramVideoData.jdField_a_of_type_Long;
      b(paramVideoData.jdField_c_of_type_Int);
      a(paramVideoData.jdField_d_of_type_Int, paramVideoData.jdField_e_of_type_Int);
      if (paramVideoData.jdField_a_of_type_Int != 1) {
        break label289;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 3) {
        break label377;
      }
      bool1 = true;
      label158:
      b(bool1);
      if (paramVideoData.jdField_a_of_type_Int != 1) {
        break label382;
      }
      bool1 = true;
      label173:
      e(bool1);
      if (paramVideoData.jdField_a_of_type_Int != 4) {
        break label387;
      }
      bool1 = true;
      label188:
      d(bool1);
      h(paramVideoData.jdField_a_of_type_Boolean);
      if (TextUtils.isEmpty(paramVideoData.jdField_e_of_type_JavaLangString)) {
        break label392;
      }
    }
    label387:
    label392:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      c(bool1);
      a(paramVideoData.jdField_g_of_type_Int);
      c();
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int == 4) && (this.p)) {}
      this.p = false;
      return;
      b(paramVideoData.f);
      d(paramVideoData.jdField_g_of_type_JavaLangString);
      this.jdField_c_of_type_Long = paramVideoData.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = paramVideoData.jdField_b_of_type_Long;
      break;
      label289:
      if (paramVideoData.jdField_e_of_type_Long == paramVideoData.jdField_b_of_type_Long)
      {
        if (paramVideoData.jdField_b_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {}
        for (bool1 = true;; bool1 = false)
        {
          g(bool1);
          f(paramVideoData.jdField_b_of_type_Boolean);
          d(paramVideoData.jdField_b_of_type_Int);
          break;
        }
      }
      if (paramVideoData.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {}
      for (bool1 = true;; bool1 = false)
      {
        g(bool1);
        break;
      }
      label377:
      bool1 = false;
      break label158;
      label382:
      bool1 = false;
      break label173;
      bool1 = false;
      break label188;
    }
  }
  
  public void a(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener = paramOnCloseListener;
  }
  
  public void a(ilive_short_video_label.GetShortVideoVideoLabelRsp paramGetShortVideoVideoLabelRsp)
  {
    if (paramGetShortVideoVideoLabelRsp == null) {
      return;
    }
    this.jdField_h_of_type_Int = paramGetShortVideoVideoLabelRsp.video_status.root_room_id.get();
    this.jdField_k_of_type_Int = paramGetShortVideoVideoLabelRsp.type.get();
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370603);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370602);
    localRoundRelativeLayout.a(10);
    localRoundRelativeLayout.requestLayout();
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      localRoundRelativeLayout.setVisibility(8);
      if (this.jdField_k_of_type_Int != 0) {
        break;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      this.m = bool;
      return;
      this.jdField_a_of_type_Affp.jdField_a_of_type_Int = paramGetShortVideoVideoLabelRsp.video_status.root_room_id.get();
      localTextView.setText("正在直播");
      localRoundRelativeLayout.setBackgroundResource(2130842867);
      localRoundRelativeLayout.setVisibility(0);
      break;
      this.jdField_a_of_type_Affr.jdField_a_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.feed_info.feed_id.get().toStringUtf8();
      this.jdField_a_of_type_Affr.jdField_b_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.feed_info.topic.get();
      this.jdField_a_of_type_Affr.jdField_c_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.feed_info.url.get();
      localTextView.setText(this.jdField_a_of_type_Affr.jdField_b_of_type_JavaLangString);
      localRoundRelativeLayout.setBackgroundResource(2130842869);
      localRoundRelativeLayout.setVisibility(0);
      break;
      this.jdField_a_of_type_Affq.jdField_a_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.video_info.url.get();
      this.jdField_a_of_type_Affq.jdField_b_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.video_info.cover_url.get();
      localTextView.setText("查看回放");
      localRoundRelativeLayout.setBackgroundResource(2130842870);
      localRoundRelativeLayout.setVisibility(0);
      break;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370614)).setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 8;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 1))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370587).setVisibility(8);
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370587);
    if (paramBoolean) {
      i1 = 0;
    }
    localView.setVisibility(i1);
  }
  
  public boolean a(long paramLong)
  {
    new NowShortVideoProtoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramLong, this.jdField_e_of_type_JavaLangString, new affe(this));
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver);
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    a(CommentsUtil.c(this.jdField_f_of_type_Int) + "次观看");
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "setCurrentAnchorUin,currentAnchorUin:" + paramLong);
    }
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void b(View paramView)
  {
    if (!this.m) {
      return;
    }
    new NowVideoReporter().h("video").i("playpage_label_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    switch (this.jdField_k_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 1: 
      localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("url", String.format("https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=12&bid=2&roomid=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Affp.jdField_a_of_type_Int) }));
      paramView.getContext().startActivity(localIntent);
      new NowVideoReporter().h("video").i("playpage_live_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", this.jdField_a_of_type_Affr.jdField_c_of_type_JavaLangString);
    paramView.getContext().startActivity(localIntent);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_b_of_type_AndroidViewView != null) {
      ImageLoader.a().a((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365002), paramString, this.jdField_b_of_type_AndroidViewView.getResources().getDrawable(2130842800), this.jdField_b_of_type_AndroidViewView.getResources().getDrawable(2130842800), null, true);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370589).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370589).setAlpha(1.0F);
  }
  
  public void c(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void c(View paramView)
  {
    if (!NetworkUtil.a(this.jdField_a_of_type_AndroidViewView.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), 1, "网络异常，请稍候重试", 1).a();
      return;
    }
    this.l = true;
    e();
    paramView = new NowShortVideoProtoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!this.jdField_d_of_type_Boolean)
    {
      localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
      ((LikeAniView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370588)).a(UITools.a(this.jdField_a_of_type_AndroidViewView.getContext()) / 2, UITools.b(this.jdField_a_of_type_AndroidViewView.getContext()) / 2);
      paramView.a(this.jdField_e_of_type_JavaLangString, new afel(this, localVideoData), null);
      return;
    }
    this.n = true;
    VideoData localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
    paramView.b(this.jdField_e_of_type_JavaLangString, new afem(this, localVideoData), null);
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void d(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (paramInt > 0)
    {
      if (this.jdField_j_of_type_Int == 1) {
        if (this.jdField_d_of_type_Boolean) {
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)).setImageResource(2130842881);
        }
      }
      for (;;)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370595)).setText(CommentsUtil.b(paramInt));
        return;
        ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)).setImageResource(2130842880);
        continue;
        if (this.jdField_d_of_type_Boolean) {
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)).setImageResource(2130842833);
        } else {
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)).setImageResource(2130842832);
        }
      }
    }
    if (this.jdField_j_of_type_Int == 1) {
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)).setImageResource(2130842880);
    }
    for (;;)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370595)).setText("点赞");
      return;
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370594)).setImageResource(2130842832);
    }
  }
  
  public void d(View paramView)
  {
    ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).d.put(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_e_of_type_Long + "", Integer.valueOf(1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&from=3");
    int i1 = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals("" + this.jdField_c_of_type_Long)) {
      i1 = 2;
    }
    ((StringBuilder)localObject).append("&mode=" + i1);
    localObject = "mqq://card/show_pslcard/?uin=" + this.jdField_c_of_type_Long + "&card_type=nearby" + ((StringBuilder)localObject).toString();
    paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject)));
    new NowVideoReporter().h("video").i("playpage_post_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369189)).setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370609);
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (!this.o)) {}
    View localView;
    Object localObject;
    label724:
    do
    {
      return;
      localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370610).findViewById(2131370611);
      if ((paramInt > 10) && (paramInt < 70))
      {
        float f1 = (paramInt - 10) / 60.0F;
        localObject = new ArgbEvaluator();
        paramInt = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-1), Integer.valueOf(-16777216))).intValue();
        int i1 = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-1), Integer.valueOf(-4473925))).intValue();
        int i2 = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-637534209), Integer.valueOf(-893603))).intValue();
        int i3 = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-893603), Integer.valueOf(-1))).intValue();
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369189)).setTextColor(paramInt);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370614)).setTextColor(i1);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367537)).setTextColor(i3);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370618)).setTextColor(i3);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370619)).setTextColor(i3);
        this.jdField_b_of_type_Int = i2;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370616).setBackgroundColor(i2);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).setBackgroundDrawable(null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370610).setBackgroundColor(Color.parseColor("#ffffff"));
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370610).getBackground().setAlpha((int)(255.0F * f1));
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370624).setAlpha(1.0F - f1);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370623).setAlpha(f1);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131370602).setVisibility(8);
          if (localView.getVisibility() != 0) {
            break;
          }
          localView.setVisibility(8);
          return;
          localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).getBackground();
          if (localObject != null)
          {
            ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, this.jdField_b_of_type_Int));
            ((Drawable)localObject).invalidateSelf();
          }
        }
      }
      if (paramInt <= 10)
      {
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369189)).setTextColor(Color.parseColor("#ffffff"));
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370614)).setTextColor(Color.parseColor("#b3ffffff"));
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367537)).setTextColor(-893603);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370618)).setTextColor(-893603);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370619)).setTextColor(-893603);
        this.jdField_b_of_type_Int = -637534209;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370616).setBackgroundColor(-637534209);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).setBackgroundDrawable(null);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370610).setBackgroundResource(2130842903);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370624).setAlpha(1.0F);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131370623).setAlpha(0.0F);
          if (localView.getVisibility() == 0) {
            localView.setVisibility(8);
          }
          localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370602);
          if (!this.m) {
            break label724;
          }
        }
        for (paramInt = 0;; paramInt = 8)
        {
          localView.setVisibility(paramInt);
          return;
          localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).getBackground();
          if (localObject == null) {
            break;
          }
          ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, this.jdField_b_of_type_Int));
          ((Drawable)localObject).invalidateSelf();
          break;
        }
      }
    } while (paramInt < 70);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369189)).setTextColor(Color.parseColor("#000000"));
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370614)).setTextColor(Color.parseColor("#bbbbbb"));
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367537)).setTextColor(-1);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370618)).setTextColor(-1);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370619)).setTextColor(-1);
    this.jdField_b_of_type_Int = -893603;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370616).setBackgroundColor(-893603);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).setBackgroundDrawable(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370610).setBackgroundColor(-1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370624).setAlpha(0.0F);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131370623).setAlpha(1.0F);
      if (localView.getVisibility() != 8) {
        break;
      }
      localView.setVisibility(0);
      return;
      localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131370617).getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, this.jdField_b_of_type_Int));
        ((Drawable)localObject).invalidateSelf();
      }
    }
  }
  
  public void e(View paramView) {}
  
  public void e(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370609);
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void f(View paramView)
  {
    Object localObject = new HashMap();
    paramView = "";
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int == 4) {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((ImageData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;; paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_c_of_type_JavaLangString)
    {
      ((Map)localObject).put("record_title", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j);
      ((Map)localObject).put("id", this.jdField_e_of_type_JavaLangString);
      ((Map)localObject).put("anchor_nick_name", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString);
      ((Map)localObject).put("feed_type", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int));
      ((Map)localObject).put("recorder_nick_name", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.h);
      ((Map)localObject).put("roomName", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j);
      ((Map)localObject).put("bNewQZone", Boolean.valueOf(false));
      ((Map)localObject).put("source", Integer.valueOf(6));
      ((Map)localObject).put("play_operatro_view_model", this);
      ((Map)localObject).put("anchor_uin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long));
      ((Map)localObject).put("record_uin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_Long));
      String str = "https://now.qq.com/h5/view_record.html?_wv=1&_bid=2424&from=6&feeds_id=" + this.jdField_e_of_type_JavaLangString;
      localObject = "一起来围观~";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString)) {
        localObject = "“「" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString + "」”分享的最新动态，快来围观~";
      }
      ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext(), "", str, "我在附近发现了有趣的动态~", (String)localObject, paramView, paramView, this.jdField_a_of_type_ComTencentImageURLDrawable, new afeo(this));
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370595).setSelected(this.jdField_d_of_type_Boolean);
  }
  
  public void g(View paramView)
  {
    paramView = new NowShortVideoProtoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_e_of_type_Boolean)
    {
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_e_of_type_Long, 11, false, new afep(this));
      return;
    }
    this.q = true;
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_e_of_type_Long, 11, true, new afeq(this));
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void h(View paramView)
  {
    new NowVideoReporter().h("video").i("playpage_more_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramView = ActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext());
    if (!this.jdField_g_of_type_Boolean) {
      paramView.a(2131432537, 1);
    }
    for (;;)
    {
      paramView.c(2131433029);
      paramView.a(new afes(this, paramView));
      paramView.a(new afex(this));
      paramView.show();
      this.jdField_b_of_type_Boolean = true;
      return;
      paramView.a("删除", 1);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "is follow? " + paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "is Mine? " + this.jdField_g_of_type_Boolean);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_g_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidViewView.findViewById(2131370615).setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370615).setVisibility(0);
    h();
  }
  
  public void i(View paramView)
  {
    new NowVideoReporter().h("video").i("playpage_com_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  public void j(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel
 * JD-Core Version:    0.7.0.1
 */