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
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.Loader;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IXAGlobal;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class TroopGiftAnimationController
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  private static int b = -1;
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
  private MessageForDeliverGiftTips jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  protected ISpecifyRedPacketAnimMsg a;
  private FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = new TroopGiftAnimationController.3(this);
  protected SpriteGLView a;
  private TroopGiftCallback jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback = new TroopGiftAnimationController.2(this);
  public TroopGiftAnimationController.OnCleanAnimationListener a;
  private TroopGiftAnimationController.ToAllGiftAnimationEndListener jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener = null;
  protected TroopGiftPAGAnimationController a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TroopGiftAnimationController.1(this);
  protected Drawable b;
  
  public TroopGiftAnimationController(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(Activity paramActivity)
  {
    int i = jdField_b_of_type_Int;
    if (i >= 0) {
      return i;
    }
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      jdField_b_of_type_Int = localRect.top;
    }
    else
    {
      jdField_b_of_type_Int = 0;
    }
    return jdField_b_of_type_Int;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560700, null));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560701, null));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = ((SpriteGLView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131379362));
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView))
      {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131379360));
        try
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847412);
        }
        catch (Exception localException)
        {
          QLog.e("TroopGiftAnimationController", 2, "mStopBtn setImage failed", localException);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
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
    int k = 0;
    int i;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (localObject2 != null)
    {
      j = k;
      if (((FriendsManager)localObject2).b(paramString)) {
        j = 1;
      }
    }
    k = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.istroop;
    if (paramString.equals("80000000"))
    {
      paramString = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843811);
      return URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips).jdField_b_of_type_Int), paramString, paramString);
    }
    if (((k == 1010) || (k == 1001) || (k == 10002) || ((i != 0) && ((j == 0) || (paramString.equals(((AppInterface)localObject1).getCurrentAccountUin()))))) && (localObject2 != null) && (!((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin)))
    {
      paramOnLoadingStateChangeListener = FaceDrawable.getStrangerFaceDrawable((AppInterface)localObject1, 200, paramString, 3, paramOnLoadingStateChangeListener, true);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFaceDrawable, uin = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("TroopGiftAnimationController", 2, ((StringBuilder)localObject1).toString());
      }
      return paramOnLoadingStateChangeListener;
    }
    localObject2 = FaceDrawable.getDefaultDrawable(1, 3);
    return FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, String.valueOf(paramString), 3, (Drawable)localObject2, (Drawable)localObject2, paramOnLoadingStateChangeListener);
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener;
    if (localObject1 != null)
    {
      ((TroopGiftAnimationController.OnCleanAnimationListener)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
    }
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
    Object localObject2;
    Object localObject3;
    StringBuilder localStringBuilder;
    if ((localObject1 != null) && (((MessageForDeliverGiftTips)localObject1).isToAll()))
    {
      if (this.jdField_a_of_type_Int >= 4)
      {
        NearbyFlowerManager.a("cartoon", "clk_close", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "", "", "");
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
        ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null) && (this.jdField_a_of_type_Int < 4))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
      localObject3 = ((StringBuilder)localObject3).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
      ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, ActionGlobalData paramActionGlobalData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "startSendGiftHeadAnimation");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("创建头像时间 = ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        QLog.d("TroopGiftAnimationController", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "sendFlowerSurfaceView show");
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
      if ((localObject1 instanceof TroopGiftToPersonalSurfaceView))
      {
        ((TroopGiftToPersonalSurfaceView)localObject1).a(new TroopGiftAnimationController.4(this));
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief))) {
          a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.giftCount, paramInt, paramActionGlobalData);
        }
      }
      else if ((localObject1 instanceof TroopGiftToAllSurfaceView))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener = new TroopGiftAnimationController.ToAllGiftAnimationEndListener(this);
        ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        Object localObject2;
        Object localObject3;
        if (this.jdField_a_of_type_Int >= 4)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
          ((StringBuilder)localObject3).append("");
          NearbyFlowerManager.a("cartoon", "exp_cartoon", (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
          ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton)
        {
          ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener);
          if (this.jdField_a_of_type_Int >= 4)
          {
            paramActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
            ((StringBuilder)localObject1).append("");
            NearbyFlowerManager.a("cartoon", "exp_inter", paramActionGlobalData, ((StringBuilder)localObject1).toString(), "", "");
          }
          else
          {
            paramActionGlobalData = new StringBuilder();
            paramActionGlobalData.append("");
            paramActionGlobalData.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
            paramActionGlobalData = paramActionGlobalData.toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
            ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, paramActionGlobalData, (String)localObject2, (String)localObject1, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultType == 0) {
            paramInt = paramActionGlobalData.m;
          } else {
            paramInt = paramActionGlobalData.n;
          }
          ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultText, paramInt, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "endstartSendGiftHeadAnimation");
      }
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("play TroopGiftAnimation Start,packageId:");
      ((StringBuilder)localObject).append(TroopGiftUtil.b(paramMessageForDeliverGiftTips));
      QLog.d("TroopGiftAnimationController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject instanceof HotChatPie))
    {
      int i = ((HotChatPie)localObject).g();
      if (i == 2)
      {
        if (QLog.isColorLevel())
        {
          paramMessageForDeliverGiftTips = new StringBuilder();
          paramMessageForDeliverGiftTips.append("playMaigcface return.Current hotchatTabMode:");
          paramMessageForDeliverGiftTips.append(i);
          QLog.d("TroopGiftAnimationController", 2, paramMessageForDeliverGiftTips.toString());
        }
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find troopAnimationLayout");
      }
      return;
    }
    localObject = new Emoticon();
    ((Emoticon)localObject).epId = TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a((Emoticon)localObject, 1, 2, paramMessageForDeliverGiftTips.animationType);
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find actionGlobaData");
      }
      paramMessageForDeliverGiftTips = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
      if (paramMessageForDeliverGiftTips != null)
      {
        paramMessageForDeliverGiftTips.a();
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
    }
    a(paramMessageForDeliverGiftTips.isToAll());
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setVisibility(0);
    ThreadManager.post(new TroopGiftAnimationController.6(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(ISpecifyRedPacketAnimMsg paramISpecifyRedPacketAnimMsg)
  {
    ISpecifyRedPacketAnimMsg localISpecifyRedPacketAnimMsg = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyISpecifyRedPacketAnimMsg;
    if (localISpecifyRedPacketAnimMsg != null) {
      localISpecifyRedPacketAnimMsg.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyISpecifyRedPacketAnimMsg = paramISpecifyRedPacketAnimMsg;
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
  }
  
  public void a(TroopGiftData paramTroopGiftData, Function0<Unit> paramFunction0)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController == null) && ((a() instanceof BaseActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController = new TroopGiftPAGAnimationController((BaseActivity)a());
    }
    paramFunction0 = new TroopGiftAnimationController.5(this, paramFunction0);
    boolean bool = PagViewProxy.a.a().a();
    XAApi.c().registerGlobalRule("$IS_PAG_INIT", Boolean.valueOf(bool));
    if (paramTroopGiftData.isCommonGift()) {
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a(paramTroopGiftData, paramFunction0);
    } else if (paramTroopGiftData.isStaffGift()) {
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.d(paramTroopGiftData, paramFunction0);
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    }
    catch (Exception paramFunction0)
    {
      paramFunction0.printStackTrace();
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a());
    }
    catch (Exception paramFunction0)
    {
      paramFunction0.printStackTrace();
    }
    paramFunction0 = new WindowManager.LayoutParams(-1, -1, 2, 8, -2);
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
    }
    if ((paramTroopGiftData.isGiftValid()) && (bool)) {
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a(), paramFunction0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt1 <= 0) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("×");
      ((StringBuilder)localObject1).append(paramInt1);
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new SpannableStringBuilder(paramString);
      if ((paramActionGlobalData != null) && (!paramActionGlobalData.e))
      {
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length(), 18);
      }
      else
      {
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length() + ((String)localObject2).length(), 18);
        ((SpannableStringBuilder)localObject1).setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 17.0F)), paramString.length(), paramString.length() + 1, 18);
        ((SpannableStringBuilder)localObject1).setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 19.0F)), paramString.length() + 1, paramString.length() + ((String)localObject2).length(), 18);
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
      }
      paramString = new RelativeLayout.LayoutParams(-2, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298129));
      paramString.addRule(14);
      paramString.setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), paramInt2, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), 0);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130844037);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131167394));
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingTop(), DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingBottom());
      }
      else
      {
        ((TextView)localObject2).setLayoutParams(paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramString);
      if (paramActionGlobalData != null) {}
      try
      {
        if (paramActionGlobalData.g != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(paramActionGlobalData.g)));
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(null);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parse detail strip bg clor failed. Color value is ");
          ((StringBuilder)localObject2).append(paramActionGlobalData.g);
          QLog.e(".troop.send_gift", 2, ((StringBuilder)localObject2).toString(), paramString);
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip Success");
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
    if (localObject1 != null) {
      ((SpriteGLView)localObject1).n();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController;
    if (localObject1 != null) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(((TroopGiftPAGAnimationController)localObject1).a());
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closePAGAnimation exception ", localException1);
        }
      }
    }
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null)
    {
      try
      {
        localTopGestureLayout.removeAllViews();
        this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$ToAllGiftAnimationEndListener = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
      if (localObject2 != null)
      {
        ((MessageForDeliverGiftTips)localObject2).hasFetchButFailed = false;
        ReportController.b(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), "", "");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
      if (localObject2 != null) {
        ((FrameSprite.OnFrameEndListener)localObject2).a();
      }
    }
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localObject2 != null) && ((localObject2 instanceof FaceDrawable))) {
      ((FaceDrawable)localObject2).cancel();
    }
    localObject2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if ((localObject2 != null) && ((localObject2 instanceof FaceDrawable)))
    {
      ((FaceDrawable)localObject2).cancel();
    }
    else
    {
      localObject2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if ((localObject2 instanceof URLDrawable))
      {
        ((URLDrawable)localObject2).cancelDownload();
        ((URLDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).setDownloadListener(null);
        ((URLDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).setURLDrawableListener(null);
      }
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyISpecifyRedPacketAnimMsg;
    if (localObject2 != null)
    {
      ((ISpecifyRedPacketAnimMsg)localObject2).a();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyISpecifyRedPacketAnimMsg = null;
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void flingLToR()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)localBaseChatPie).as();
    }
  }
  
  public void flingRToL() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379360) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController
 * JD-Core Version:    0.7.0.1
 */