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
import com.tencent.mobileqq.vas.troopgift.AbsTroopGiftController;
import com.tencent.mobileqq.vas.troopgift.GiftControllerFactory;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class TroopGiftAnimationController
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  private static int x = -1;
  protected SpriteGLView a;
  protected TopGestureLayout b;
  protected ImageView c;
  protected ISpecifyRedPacketAnimMsg d;
  public TroopGiftAnimationController.OnCleanAnimationListener e;
  protected Handler f = new Handler(Looper.getMainLooper());
  protected Drawable g;
  protected Drawable h;
  protected int i;
  private long j;
  private ActionGlobalData k;
  private BaseChatPie l;
  private Activity m;
  private WindowManager n;
  private FrameSprite.OnFrameEndListener o;
  private AbsTroopGiftController p;
  private TextView q;
  private AlphaAnimation r;
  private MessageForDeliverGiftTips s;
  private Runnable t = new TroopGiftAnimationController.1(this);
  private TroopGiftAnimationController.ToAllGiftAnimationEndListener u = null;
  private TroopGiftCallback v = new TroopGiftAnimationController.2(this);
  private ImageButton.OnClickListener w = new TroopGiftAnimationController.3(this);
  
  public TroopGiftAnimationController(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.l = paramBaseChatPie;
    this.m = paramActivity;
  }
  
  public static int a(Activity paramActivity)
  {
    int i1 = x;
    if (i1 >= 0) {
      return i1;
    }
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      x = localRect.top;
    }
    else
    {
      x = 0;
    }
    return x;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
    }
    if (this.b == null)
    {
      if (paramBoolean) {
        this.b = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131626745, null));
      } else {
        this.b = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131626746, null));
      }
      this.b.setOnFlingGesture(this);
      this.a = ((SpriteGLView)this.b.findViewById(2131448099));
      if ((this.a instanceof TroopGiftToPersonalSurfaceView))
      {
        this.c = ((ImageView)this.b.findViewById(2131448097));
        try
        {
          this.c.setImageResource(2130849066);
        }
        catch (Exception localException)
        {
          QLog.e("TroopGiftAnimationController", 2, "mStopBtn setImage failed", localException);
        }
        this.c.setOnClickListener(this);
      }
    }
  }
  
  protected Drawable a(String paramString, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (FriendsManager)((AppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)((AppInterface)localObject1).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    int i3 = 0;
    int i1;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.s.frienduin))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i3;
    if (localObject2 != null)
    {
      i2 = i3;
      if (((FriendsManager)localObject2).n(paramString)) {
        i2 = 1;
      }
    }
    i3 = this.s.istroop;
    if (paramString.equals("80000000"))
    {
      paramString = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844765);
      return URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.g(this.s).d), paramString, paramString);
    }
    if (((i3 == 1010) || (i3 == 1001) || (i3 == 10002) || ((i1 != 0) && ((i2 == 0) || (paramString.equals(((AppInterface)localObject1).getCurrentAccountUin()))))) && (localObject2 != null) && (!((FriendsManager)localObject2).n(this.s.frienduin)))
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
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      ((TroopGiftAnimationController.OnCleanAnimationListener)localObject1).a();
      this.e = null;
      this.o = null;
    }
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject1 = this.s;
    Object localObject2;
    Object localObject3;
    StringBuilder localStringBuilder;
    if ((localObject1 != null) && (((MessageForDeliverGiftTips)localObject1).isToAll()))
    {
      if (this.i >= 4)
      {
        NearbyFlowerManager.a("cartoon", "clk_close", this.s.frienduin, "", "", "");
      }
      else
      {
        if (this.l != null) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.s.frienduin);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.s));
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.s.frienduin));
        ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
      }
    }
    else if ((this.s != null) && (this.i < 4))
    {
      if (this.l != null) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.s.frienduin);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.s));
      localObject3 = ((StringBuilder)localObject3).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.s.frienduin));
      ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt, ActionGlobalData paramActionGlobalData)
  {
    if (this.s == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "startSendGiftHeadAnimation");
    }
    if (this.a != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("创建头像时间 = ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.j);
        QLog.d("TroopGiftAnimationController", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "sendFlowerSurfaceView show");
      }
      Object localObject1 = this.a;
      if ((localObject1 instanceof TroopGiftToPersonalSurfaceView))
      {
        ((TroopGiftToPersonalSurfaceView)localObject1).a(new TroopGiftAnimationController.4(this));
        if ((!this.s.isToAll()) && (!TextUtils.isEmpty(this.s.animationBrief))) {
          a(this.s.animationBrief, this.s.giftCount, paramInt, paramActionGlobalData);
        }
      }
      else if ((localObject1 instanceof TroopGiftToAllSurfaceView))
      {
        this.u = new TroopGiftAnimationController.ToAllGiftAnimationEndListener(this);
        ((TroopGiftToAllSurfaceView)this.a).a(this.u);
        if (this.l != null) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        Object localObject2;
        Object localObject3;
        if (this.i >= 4)
        {
          localObject2 = this.s.frienduin;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.s));
          ((StringBuilder)localObject3).append("");
          NearbyFlowerManager.a("cartoon", "exp_cartoon", (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.s.frienduin);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(TroopGiftUtil.b(this.s));
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.s.frienduin));
          ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
        }
        if (this.s.showButton)
        {
          ((TroopGiftToAllSurfaceView)this.a).a(this.w);
          if (this.i >= 4)
          {
            paramActionGlobalData = this.s.frienduin;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(TroopGiftUtil.b(this.s));
            ((StringBuilder)localObject1).append("");
            NearbyFlowerManager.a("cartoon", "exp_inter", paramActionGlobalData, ((StringBuilder)localObject1).toString(), "", "");
          }
          else
          {
            paramActionGlobalData = new StringBuilder();
            paramActionGlobalData.append("");
            paramActionGlobalData.append(this.s.frienduin);
            paramActionGlobalData = paramActionGlobalData.toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(TroopGiftUtil.b(this.s));
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.s.frienduin));
            ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, paramActionGlobalData, (String)localObject2, (String)localObject1, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          if (this.s.resultType == 0) {
            paramInt = paramActionGlobalData.D;
          } else {
            paramInt = paramActionGlobalData.E;
          }
          ((TroopGiftToAllSurfaceView)this.a).a(this.s.resultText, paramInt, DisplayUtil.a(this.m, 16.0F));
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
      this.f.post(this.t);
      return;
    }
    this.f.postDelayed(this.t, paramLong);
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
    Object localObject = this.l;
    if ((localObject instanceof HotChatPie))
    {
      int i1 = ((HotChatPie)localObject).bR();
      if (i1 == 2)
      {
        if (QLog.isColorLevel())
        {
          paramMessageForDeliverGiftTips = new StringBuilder();
          paramMessageForDeliverGiftTips.append("playMaigcface return.Current hotchatTabMode:");
          paramMessageForDeliverGiftTips.append(i1);
          QLog.d("TroopGiftAnimationController", 2, paramMessageForDeliverGiftTips.toString());
        }
        return;
      }
    }
    this.s = paramMessageForDeliverGiftTips;
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find troopAnimationLayout");
      }
      return;
    }
    localObject = new Emoticon();
    ((Emoticon)localObject).epId = TroopGiftUtil.b(this.s);
    this.k = MagicfaceActionManager.a((Emoticon)localObject, 1, 2, paramMessageForDeliverGiftTips.animationType);
    if (this.k == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find actionGlobaData");
      }
      paramMessageForDeliverGiftTips = this.o;
      if (paramMessageForDeliverGiftTips != null)
      {
        paramMessageForDeliverGiftTips.a();
        this.o = null;
      }
      return;
    }
    if (this.n == null) {
      this.n = ((WindowManager)this.m.getSystemService("window"));
    }
    a(paramMessageForDeliverGiftTips.isToAll());
    this.a.setVisibility(0);
    ThreadManager.post(new TroopGiftAnimationController.6(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(ISpecifyRedPacketAnimMsg paramISpecifyRedPacketAnimMsg)
  {
    ISpecifyRedPacketAnimMsg localISpecifyRedPacketAnimMsg = this.d;
    if (localISpecifyRedPacketAnimMsg != null) {
      localISpecifyRedPacketAnimMsg.f();
    }
    this.d = paramISpecifyRedPacketAnimMsg;
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.o = paramOnFrameEndListener;
  }
  
  public void a(TroopGiftData paramTroopGiftData, Function0<Unit> paramFunction0)
  {
    paramFunction0 = new TroopGiftAnimationController.5(this, paramFunction0);
    this.p = GiftControllerFactory.a.a(paramTroopGiftData, paramFunction0, (BaseActivity)e());
    this.p.d();
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
      if ((paramActionGlobalData != null) && (!paramActionGlobalData.u))
      {
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length(), 18);
      }
      else
      {
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length() + ((String)localObject2).length(), 18);
        ((SpannableStringBuilder)localObject1).setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.m, 17.0F)), paramString.length(), paramString.length() + 1, 18);
        ((SpannableStringBuilder)localObject1).setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.m, 19.0F)), paramString.length() + 1, paramString.length() + ((String)localObject2).length(), 18);
      }
      if (this.r == null)
      {
        this.r = new AlphaAnimation(0.0F, 1.0F);
        this.r.setDuration(500L);
      }
      paramString = new RelativeLayout.LayoutParams(-2, (int)this.m.getResources().getDimension(2131298805));
      paramString.addRule(14);
      paramString.setMargins(DisplayUtil.a(this.m, 10.0F), paramInt2, DisplayUtil.a(this.m, 10.0F), 0);
      localObject2 = this.q;
      if (localObject2 == null)
      {
        this.q = new TextView(this.m);
        this.q.setSingleLine();
        this.q.setGravity(17);
        this.q.setTextSize(2, 15.0F);
        this.q.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.q.setBackgroundResource(2130844992);
        this.q.setTextColor(this.m.getResources().getColorStateList(2131168464));
        this.q.setPadding(DisplayUtil.a(this.m, 30.0F), this.q.getPaddingTop(), DisplayUtil.a(this.m, 30.0F), this.q.getPaddingBottom());
      }
      else
      {
        ((TextView)localObject2).setLayoutParams(paramString);
      }
      this.b.addView(this.q, paramString);
      if (paramActionGlobalData != null) {}
      try
      {
        if (paramActionGlobalData.v != null) {
          this.q.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(paramActionGlobalData.v)));
        } else {
          this.q.getBackground().setColorFilter(null);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parse detail strip bg clor failed. Color value is ");
          ((StringBuilder)localObject2).append(paramActionGlobalData.v);
          QLog.e(".troop.send_gift", 2, ((StringBuilder)localObject2).toString(), paramString);
        }
      }
      this.q.setVisibility(0);
      this.q.startAnimation(this.r);
      this.q.setText((CharSequence)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip Success");
      }
    }
  }
  
  public void b()
  {
    if (this.n == null) {
      this.n = ((WindowManager)this.m.getSystemService("window"));
    }
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((SpriteGLView)localObject1).o();
    }
    localObject1 = this.p;
    if (localObject1 != null) {
      ((AbsTroopGiftController)localObject1).j();
    }
    localObject1 = this.b;
    if (localObject1 != null)
    {
      try
      {
        ((TopGestureLayout)localObject1).removeAllViews();
        this.n.removeViewImmediate(this.b);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException);
        }
      }
      this.b = null;
      this.a = null;
      this.u = null;
      this.c = null;
      localObject2 = this.s;
      if (localObject2 != null)
      {
        ((MessageForDeliverGiftTips)localObject2).hasFetchButFailed = false;
        ReportController.b(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, (int)(System.currentTimeMillis() - this.j), this.s.frienduin, TroopGiftUtil.b(this.s), "", "");
      }
      localObject2 = this.o;
      if (localObject2 != null) {
        ((FrameSprite.OnFrameEndListener)localObject2).a();
      }
    }
    Object localObject2 = this.g;
    if ((localObject2 != null) && ((localObject2 instanceof FaceDrawable))) {
      ((FaceDrawable)localObject2).cancel();
    }
    localObject2 = this.h;
    if ((localObject2 != null) && ((localObject2 instanceof FaceDrawable)))
    {
      ((FaceDrawable)localObject2).cancel();
    }
    else
    {
      localObject2 = this.h;
      if ((localObject2 instanceof URLDrawable))
      {
        ((URLDrawable)localObject2).cancelDownload();
        ((URLDrawable)this.h).setDownloadListener(null);
        ((URLDrawable)this.h).setURLDrawableListener(null);
      }
    }
    localObject2 = this.d;
    if (localObject2 != null)
    {
      ((ISpecifyRedPacketAnimMsg)localObject2).f();
      this.d = null;
    }
  }
  
  public boolean c()
  {
    return this.a != null;
  }
  
  public void d()
  {
    b();
    this.f.removeCallbacksAndMessages(null);
  }
  
  public Activity e()
  {
    return this.m;
  }
  
  public void flingLToR()
  {
    BaseChatPie localBaseChatPie = this.l;
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)localBaseChatPie).bD();
    }
  }
  
  public void flingRToL() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131448097) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController
 * JD-Core Version:    0.7.0.1
 */