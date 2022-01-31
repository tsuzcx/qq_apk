package com.tencent.mobileqq.troopgift;

import ajuw;
import ajuz;
import ajva;
import ajvb;
import ajvd;
import ajvk;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftAnimationController
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private ajvk jdField_a_of_type_Ajvk;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Drawable a;
  public Handler a;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public TopGestureLayout a;
  private MessageForDeliverGiftTips jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  private FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = new ajva(this);
  public SpriteGLView a;
  private TroopGiftCallback jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback = new ajuz(this);
  public TroopGiftAnimationController.OnCleanAnimationListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ajuw(this);
  public Drawable b;
  
  public TroopGiftAnimationController(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      if (!paramBoolean) {
        break label100;
      }
    }
    label100:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2130969956, null));; this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2130969957, null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = ((SpriteGLView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131368582));
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView))
      {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131368583));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      return;
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Drawable a(String paramString, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (FriendsManager)((AppInterface)localObject1).getManager(50);
    HotChatManager localHotChatManager = (HotChatManager)((AppInterface)localObject1).getManager(59);
    int i;
    int j;
    label74:
    int k;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin)))
    {
      i = 1;
      if ((localObject2 == null) || (!((FriendsManager)localObject2).b(paramString))) {
        break label130;
      }
      j = 1;
      k = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.istroop;
      if (!paramString.equals("80000000")) {
        break label136;
      }
      paramString = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841252);
      paramOnLoadingStateChangeListener = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips).b), paramString, paramString);
    }
    label130:
    label136:
    do
    {
      return paramOnLoadingStateChangeListener;
      i = 0;
      break;
      j = 0;
      break label74;
      if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!paramString.equals(((AppInterface)localObject1).getCurrentAccountUin()))))) || (localObject2 == null) || (((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin))) {
        break label252;
      }
      localObject1 = FaceDrawable.a((AppInterface)localObject1, 200, paramString, 3, paramOnLoadingStateChangeListener, true);
      paramOnLoadingStateChangeListener = (FaceDrawable.OnLoadingStateChangeListener)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAnimationController", 2, "getFaceDrawable, uin = " + paramString);
    return localObject1;
    label252:
    localObject2 = FaceDrawable.a(1, 3);
    return FaceDrawable.a((AppInterface)localObject1, 1, String.valueOf(paramString), 3, (Drawable)localObject2, (Drawable)localObject2, paramOnLoadingStateChangeListener);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
    }
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll())) {
      if (this.jdField_a_of_type_Int >= 4) {
        NearbyFlowerManager.a("cartoon", "clk_close", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "", "", "");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) || (this.jdField_a_of_type_Int >= 4))
    {
      b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
      for (str = "0";; str = "1")
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (String str = "0";; str = "1")
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, ActionGlobalData paramActionGlobalData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "startSendGiftHeadAnimation");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "创建头像时间 = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "sendFlowerSurfaceView show");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView))
    {
      ((TroopGiftToPersonalSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(new ajvb(this));
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief))) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.giftCount, paramInt, paramActionGlobalData);
      }
    }
    label155:
    while (QLog.isColorLevel())
    {
      QLog.d("TroopGiftAnimationController", 2, "endstartSendGiftHeadAnimation");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView))
      {
        this.jdField_a_of_type_Ajvk = new ajvk(this);
        ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_Ajvk);
        String str;
        label218:
        AppInterface localAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          str = "0";
          localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (this.jdField_a_of_type_Int < 4) {
            break label375;
          }
          NearbyFlowerManager.a("cartoon", "exp_cartoon", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips) + "", "", "");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton)
          {
            ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener);
            if (this.jdField_a_of_type_Int >= 4)
            {
              NearbyFlowerManager.a("cartoon", "exp_inter", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips) + "", "", "");
              break;
              str = "1";
              break label218;
              label375:
              ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
              continue;
            }
            ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultType != 0) {
          break label647;
        }
      }
    }
    label647:
    for (paramInt = paramActionGlobalData.m;; paramInt = paramActionGlobalData.n)
    {
      ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultText, paramInt, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
      break label155;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "play TroopGiftAnimation Start,packageId:" + TroopGiftUtil.b(paramMessageForDeliverGiftTips));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof HotChatPie))
    {
      int i = ((HotChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).i();
      if (i == 2) {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGiftAnimationController", 2, "playMaigcface return.Current hotchatTabMode:" + i);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGiftAnimationController", 2, "find troopAnimationLayout");
      return;
      Emoticon localEmoticon = new Emoticon();
      localEmoticon.epId = TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a(localEmoticon, 1, 2, paramMessageForDeliverGiftTips.animationType);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find actionGlobaData");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener == null);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
    return;
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
    }
    a(paramMessageForDeliverGiftTips.isToAll());
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setVisibility(0);
    ThreadManager.post(new ajvd(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return;
      String str = "×" + paramInt1;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      if ((paramActionGlobalData == null) || (paramActionGlobalData.e))
      {
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length() + str.length(), 18);
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 17.0F)), paramString.length(), paramString.length() + 1, 18);
        AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 19.0F));
        paramInt1 = paramString.length();
        int i = paramString.length();
        localSpannableStringBuilder.setSpan(localAbsoluteSizeSpan, paramInt1 + 1, str.length() + i, 18);
        label203:
        if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
        }
        paramString = new RelativeLayout.LayoutParams(-2, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559210));
        paramString.addRule(14);
        paramString.setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), paramInt2, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), 0);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          break label552;
        }
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841483);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131492969));
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingTop(), DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingBottom());
        label419:
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramString);
        if (paramActionGlobalData == null) {
          break label563;
        }
      }
      try
      {
        if (paramActionGlobalData.g != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(paramActionGlobalData.g)));
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip Success");
          return;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length(), 18);
          break label203;
          label552:
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
          break label419;
          label563:
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(null);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift", 2, "parse detail strip bg clor failed. Color value is " + paramActionGlobalData.g, paramString);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_Ajvk = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = false;
        ReportController.b(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FaceDrawable))) {
        ((FaceDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
      }
      if ((this.b != null) && ((this.b instanceof FaceDrawable))) {
        ((FaceDrawable)this.b).a();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException);
        }
      }
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bb();
    }
  }
  
  public void flingRToL() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController
 * JD-Core Version:    0.7.0.1
 */