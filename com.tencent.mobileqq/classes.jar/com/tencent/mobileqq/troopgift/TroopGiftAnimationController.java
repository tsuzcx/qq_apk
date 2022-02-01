package com.tencent.mobileqq.troopgift;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
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
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
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
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class TroopGiftAnimationController
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  private static int b;
  protected int a;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected Drawable a;
  protected Handler a;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected TopGestureLayout a;
  protected SpecifyRedPacketAnimMsg a;
  private MessageForDeliverGiftTips jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  private FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = new TroopGiftAnimationController.3(this);
  protected SpriteGLView a;
  private TroopGiftCallback jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback = new TroopGiftAnimationController.2(this);
  public TroopGiftAnimationController.OnCleanAnimationListener a;
  private TroopGiftAnimationController.ToAllGiftAnimationEndListener jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener = null;
  protected TroopGiftPAGAnimationController a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TroopGiftAnimationController.1(this);
  protected Drawable b;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public TroopGiftAnimationController(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(Activity paramActivity)
  {
    if (jdField_b_of_type_Int >= 0) {
      return jdField_b_of_type_Int;
    }
    Rect localRect;
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    }
    for (jdField_b_of_type_Int = localRect.top;; jdField_b_of_type_Int = 0) {
      return jdField_b_of_type_Int;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      if (!paramBoolean) {
        break label109;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560827, null));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = ((SpriteGLView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131380033));
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView)) {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131380031));
      }
      try
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847544);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        return;
        label109:
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560828, null));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TroopGiftAnimationController", 2, "mStopBtn setImage failed", localException);
        }
      }
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  protected Drawable a(String paramString, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (FriendsManager)((AppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)((AppInterface)localObject1).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    int i;
    int j;
    label76:
    int k;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin)))
    {
      i = 1;
      if ((localObject2 == null) || (!((FriendsManager)localObject2).b(paramString))) {
        break label132;
      }
      j = 1;
      k = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.istroop;
      if (!paramString.equals("80000000")) {
        break label138;
      }
      paramString = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843891);
      paramOnLoadingStateChangeListener = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips).jdField_b_of_type_Int), paramString, paramString);
    }
    label132:
    label138:
    do
    {
      return paramOnLoadingStateChangeListener;
      i = 0;
      break;
      j = 0;
      break label76;
      if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!paramString.equals(((AppInterface)localObject1).getCurrentAccountUin()))))) || (localObject2 == null) || (((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin))) {
        break label255;
      }
      localObject1 = FaceDrawable.getStrangerFaceDrawable((AppInterface)localObject1, 200, paramString, 3, paramOnLoadingStateChangeListener, true);
      paramOnLoadingStateChangeListener = (FaceDrawable.OnLoadingStateChangeListener)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAnimationController", 2, "getFaceDrawable, uin = " + paramString);
    return localObject1;
    label255:
    localObject2 = FaceDrawable.getDefaultDrawable(1, 3);
    return FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, String.valueOf(paramString), 3, (Drawable)localObject2, (Drawable)localObject2, paramOnLoadingStateChangeListener);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {}
      for (str = "0";; str = "1")
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {}
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
      ((TroopGiftToPersonalSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(new TroopGiftAnimationController.4(this));
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
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener = new TroopGiftAnimationController.ToAllGiftAnimationEndListener(this);
        ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener);
        String str;
        label218:
        AppInterface localAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
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
  
  public void a(SpecifyRedPacketAnimMsg paramSpecifyRedPacketAnimMsg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg = paramSpecifyRedPacketAnimMsg;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "play TroopGiftAnimation Start,packageId:" + TroopGiftUtil.b(paramMessageForDeliverGiftTips));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof HotChatPie))
    {
      int i = ((HotChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).k();
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
    ThreadManager.post(new TroopGiftAnimationController.6(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
  }
  
  public void a(TroopGiftData paramTroopGiftData, Function0<Unit> paramFunction0)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController = new TroopGiftPAGAnimationController(a());
    }
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a(paramTroopGiftData, new TroopGiftAnimationController.5(this, paramFunction0));
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    }
    catch (Exception paramTroopGiftData)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a());
          paramTroopGiftData = new WindowManager.LayoutParams(-1, -1, 2, 8, -2);
          if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
            this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
          }
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a(), paramTroopGiftData);
          return;
          paramTroopGiftData = paramTroopGiftData;
          paramTroopGiftData.printStackTrace();
        }
      }
      catch (Exception paramTroopGiftData)
      {
        for (;;)
        {
          paramTroopGiftData.printStackTrace();
        }
      }
    }
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
        paramString = new RelativeLayout.LayoutParams(-2, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298135));
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
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130844134);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131167374));
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
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController != null) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
          this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = null;
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener = null;
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
            ((FaceDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).cancel();
          }
          if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (!(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable instanceof FaceDrawable))) {
            break;
          }
          ((FaceDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).cancel();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.a();
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg = null;
          }
          return;
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.e(".troop.send_gift", 2, "closePAGAnimation exception ", localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException2);
            continue;
            if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
            {
              ((URLDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).cancelDownload();
              ((URLDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).setDownloadListener(null);
              ((URLDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).setURLDrawableListener(null);
            }
          }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).bm();
    }
  }
  
  public void flingRToL() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController
 * JD-Core Version:    0.7.0.1
 */