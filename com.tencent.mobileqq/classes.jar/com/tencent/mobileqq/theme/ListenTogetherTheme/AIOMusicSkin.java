package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ApngQueuePlayer;
import com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AIOMusicSkin
  extends SkinDrawable
{
  private static AIOMusicSkin jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private ChatFragment jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
  private QuickUpdateListener jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQuickUpdateListener = new AIOMusicSkin.3(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AIOMusicSkin.5(this);
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  public static AIOMusicSkin a()
  {
    if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin == null) {
          jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin = new AIOMusicSkin();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin;
  }
  
  private void a(int paramInt, boolean paramBoolean, ApngQueuePlayer paramApngQueuePlayer)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramApngQueuePlayer.a();
        return;
      }
      if (paramBoolean) {
        paramApngQueuePlayer.a(a("pause.png"), 1);
      }
      paramApngQueuePlayer.a(a("pausing.png"), 0);
      return;
    }
    if (paramBoolean) {
      paramApngQueuePlayer.a(a("play.png"), 1);
    }
    paramApngQueuePlayer.a(a("playing.png"), 0);
  }
  
  private void a(View paramView)
  {
    a(paramView, true);
  }
  
  private void a(View paramView1, View paramView2)
  {
    View localView = paramView1.findViewById(2131368875);
    if (paramView2 != null) {
      a(localView, a(paramView2.getContext(), 2130850177));
    }
    b(paramView1, 2131372306, 2130850227);
    a(paramView1, 2131368874, 2131167158);
    a(paramView1, 2131378784, 2131167053);
    a(paramView1, 2131369240, 2131167053);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView = paramView.getRootView();
    b(paramView, 2131376636, 2130850433);
    b(paramView, 2131369563, 2130850447, 2130850451);
    b(paramView, 2131369202, 2130850447, 2130850451);
    d(paramView);
    Object localObject = paramView.findViewById(2131368874);
    if (localObject != null) {
      a((View)localObject, a(((View)localObject).getContext(), 2130850178));
    }
    c(paramView);
    a(paramView, (View)localObject);
    b(paramView);
    if (paramBoolean) {
      b(paramView.getContext());
    }
    if ((n_()) && (localObject != null))
    {
      localObject = b(((View)localObject).getContext(), 2130850371);
      paramView = paramView.findViewById(2131362288);
      if (paramView != null) {
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
      if (paramView != null)
      {
        paramView = paramView.a();
        if (paramView != null) {
          paramView.x();
        }
      }
    }
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession)
  {
    b(true);
    if ((paramListenTogetherSession.jdField_b_of_type_Int != this.jdField_c_of_type_Int) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(null);
      this.jdField_c_of_type_Int = paramListenTogetherSession.jdField_b_of_type_Int;
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 1, 0, "", "", "", "");
    }
    a();
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131363684);
    int j = 8;
    int i;
    if (localView != null)
    {
      if (n_()) {
        i = 8;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
    localView = paramView.findViewById(2131380356);
    paramView = paramView.findViewById(2131368875);
    if ((localView != null) && (paramView != null) && (paramView.getVisibility() == 0))
    {
      if (n_()) {
        i = j;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    if ((paramListenTogetherSession != null) && (paramListenTogetherSession.jdField_b_of_type_Int == 0)) {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 2, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(null);
      b(false);
      ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.2(this));
    }
  }
  
  private static boolean b(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getContext();
    boolean bool = false;
    if (localObject == null)
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: context is null");
      return false;
    }
    MusicThemeCallback localMusicThemeCallback = MusicThemeCallback.sInstance;
    localObject = localMusicThemeCallback.getDir((Context)localObject, localMusicThemeCallback.getScid(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isThemeExists: path empty, id=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("AIOMusicSkin", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    int i = ThemeUtil.getFileNumInFile(new File((String)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isThemeExists: fileNum = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", id=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("AIOMusicSkin", 1, ((StringBuilder)localObject).toString());
    if (i > 1) {
      bool = true;
    }
    return bool;
  }
  
  private void c(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131367417);
    if ((localTextView != null) && (!SimpleUIUtil.a()))
    {
      int i = localTextView.getPaddingTop();
      int j = localTextView.getPaddingLeft();
      int k = localTextView.getPaddingRight();
      int m = localTextView.getPaddingBottom();
      a(paramView, 2131367417, 2130850326, 2130850327, 2130850323);
      localTextView.setPadding(j, i, k, m);
    }
  }
  
  private void d()
  {
    SkinDrawable.IVasSkinChangeCallback localIVasSkinChangeCallback;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      localIVasSkinChangeCallback = null;
    } else {
      localIVasSkinChangeCallback = (SkinDrawable.IVasSkinChangeCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localIVasSkinChangeCallback != null) {
      localIVasSkinChangeCallback.k();
    }
  }
  
  private void d(View paramView)
  {
    View localView = paramView.findViewById(2131376636);
    if (localView != null)
    {
      if (this.jdField_a_of_type_Int == 1) {
        a(localView, 2131369211, 2130850184, 2130850185);
      } else {
        a(localView, 2131369211, 2130850168, 2130850171);
      }
      a(localView, 2131369216, 2130850464, 2130850465);
    }
    if (n_())
    {
      a(paramView, 2131374080, 2130850287, 2130850288);
      a(paramView, 2131374070, 2130850244, 2130850245);
      a(paramView, 2131374083, 2130850293, 2130850294);
      a(paramView, 2131374062, 2130850225, 2130850226);
      a(paramView, 2131374052, 2130850215, 2130850216);
      a(paramView, 2131374075, 2130850264, 2130850265);
      a(paramView, 2131374059, 2130838081, 2130838082);
      a(paramView, 2131374063, 2130838109, 2130838111);
      a(paramView, 2131374073, 2130838122, 2130838123);
      a(paramView, 2131374046, 2130850195, 2130850196);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
    if ((paramView != null) && (paramView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a().a.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a());
    }
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int)) != null) && (n_()))
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        this.jdField_c_of_type_Boolean = true;
        a((String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int)));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        return;
      }
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
    boolean bool = true;
    if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131371652);
      if (localImageView == null)
      {
        QLog.e("AIOMusicSkin", 1, "updateAnim: null view");
        return;
      }
      if ((n_()) && (this.jdField_c_of_type_Boolean) && (!a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateAnim: last=");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append(" cur=");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("AIOMusicSkin", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_b_of_type_Int == paramInt) {
          bool = false;
        }
        this.jdField_b_of_type_Int = paramInt;
        localImageView.setVisibility(0);
        ApngQueuePlayer localApngQueuePlayer = (ApngQueuePlayer)localImageView.getTag();
        localObject = localApngQueuePlayer;
        if (localApngQueuePlayer == null)
        {
          localObject = new ApngQueuePlayer(localImageView);
          localImageView.setTag(localObject);
        }
        a(paramInt, bool, (ApngQueuePlayer)localObject);
        return;
      }
      localImageView.setVisibility(8);
      return;
    }
    QLog.e("AIOMusicSkin", 1, "updateAnim: null root");
  }
  
  public void a(Context paramContext)
  {
    if (this.e)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
      if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
      {
        this.e = false;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131371632);
        if (localObject == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
        TextView localTextView = new TextView(paramContext);
        localTextView.setPadding(20, 0, 20, 0);
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setContentView(localTextView);
        localTextView.setText(paramContext.getResources().getString(2131693653));
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setAnimationStyle(2131756209);
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setSoftInputMode(1);
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setInputMethodMode(2);
        paramContext = new int[2];
        ((View)localObject).getLocationOnScreen(paramContext);
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setKeepAbove(true);
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.showAtLocation((View)localObject, paramContext[0] + ((View)localObject).getWidth() / 2, paramContext[1] + ((View)localObject).getHeight());
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.getContentView().setOnClickListener(new AIOMusicSkin.1(this));
        ListenTogetherUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", false, false);
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5B9", 1, 0, "", "", "", "");
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("setMusicBarSkin uin:");
      paramContext.append(this.jdField_b_of_type_JavaLangString);
      paramContext.append("  type:");
      paramContext.append(this.jdField_a_of_type_Int);
      paramContext.append(" mIsUserSkin:");
      paramContext.append(this.jdField_a_of_type_Boolean);
      QLog.i("AIOMusicSkin", 2, paramContext.toString());
    }
    paramContext = new StringBuilder();
    paramContext.append("setMusicBarSkin mIsUserSkin:");
    paramContext.append(this.jdField_a_of_type_Boolean);
    paramContext.append(" mIsShowSkin:");
    paramContext.append(this.jdField_c_of_type_Boolean);
    QLog.i("AIOMusicSkin", 1, paramContext.toString());
    if (paramView == null) {
      return;
    }
    paramContext = paramView.getRootView();
    b(paramContext, 2131370162, 2130850632, 2130850633);
    a(paramContext, 2131374756, 2130844799, 2130844800);
    a(paramContext, 2131371632, 2130844793, 2130844794);
    a(paramContext, 2131371650, 2131167038);
    a(paramContext, 2131371653, 2131167036);
    a(paramContext, 2131371649, 2131167038);
    paramView = (CircleProgress)paramContext.findViewById(2131371647);
    if (paramView != null)
    {
      ColorStateList localColorStateList = a(paramContext.getContext(), 2131167037);
      paramView.setBgAndProgressColor(100, a(paramContext.getContext(), 2131167039).getDefaultColor(), 100, localColorStateList.getDefaultColor());
    }
    paramContext = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString);
    if (paramContext != null)
    {
      a(paramContext.h);
      return;
    }
    a(3);
  }
  
  public void a(ChatFragment paramChatFragment, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment = paramChatFragment;
    if (paramInt == 1)
    {
      paramChatFragment = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
      if ((paramChatFragment != null) && ((paramChatFragment.a() instanceof BaseTroopChatPie)) && (((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a()).v())) {
        return;
      }
    }
    a(paramString, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.jdField_a_of_type_Boolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.getBaseActivity());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {
      c(a(paramString));
    } else {
      c(true);
    }
    paramString = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(paramInt, paramString);
    if ((paramString != null) && (paramString.jdField_b_of_type_Int > 0) && (paramString.h != 3) && (paramString.i == 2) && (!a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int))) {
      a(paramString);
    } else {
      b(paramString);
    }
    if (paramString != null)
    {
      if (b()) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BE", paramInt, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateState, session:");
      localStringBuilder.append(paramString);
      QLog.d("AIOMusicSkin", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).edit().putBoolean("music_skin_enabled", paramBoolean).commit();
    paramString = new StringBuilder();
    paramString.append("setEnabled old: ");
    paramString.append(this.jdField_b_of_type_Boolean);
    paramString.append(" new: ");
    paramString.append(paramBoolean);
    QLog.d("AIOMusicSkin", 1, paramString.toString());
    c(paramBoolean);
    if (!paramBoolean) {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BC", 0, 0, "", "", "", "");
    }
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean a(ChatFragment paramChatFragment, int paramInt)
  {
    boolean bool = true;
    if (paramChatFragment == null) {
      return true;
    }
    if ((paramInt == 1) && ((paramChatFragment.a() instanceof BaseTroopChatPie)))
    {
      if (!((BaseTroopChatPie)paramChatFragment.a()).v())
      {
        if (SimpleUIUtil.a()) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return SimpleUIUtil.a();
  }
  
  public boolean a(String paramString)
  {
    if (this.d) {
      return true;
    }
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).getBoolean("music_skin_enabled", true);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void b(Context paramContext)
  {
    ChatFragment localChatFragment = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
    if ((localChatFragment != null) && (localChatFragment.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)) {
        return;
      }
      if (!n_())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a();
        return;
      }
      this.f = true;
      paramContext = a(paramContext, 2131167114);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(paramContext.getDefaultColor());
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAIOSkin uin:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("  type:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" mIsUserSkin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" mIsShowSkin:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" enable:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("AIOMusicSkin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAIOSkin mIsUserSkin:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(" mIsShowSkin:");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    QLog.i("AIOMusicSkin", 1, ((StringBuilder)localObject).toString());
    if ((this.jdField_c_of_type_Boolean) && (n_()) && (!a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
      if ((localObject != null) && (!paramContext.equals(((ChatFragment)localObject).jdField_a_of_type_AndroidContentContext))) {
        return;
      }
      a(paramView);
      if ((this.jdField_c_of_type_Boolean) && (n_()) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        a(paramContext);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      d();
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int > 0;
  }
  
  public void c()
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment = null;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leave uin:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("  type:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.i("AIOMusicSkin", 2, ((StringBuilder)localObject).toString());
    }
    QLog.i("AIOMusicSkin", 1, "leave");
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject != null)
    {
      ((BubblePopupWindow)localObject).dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BF", 0, 0, String.valueOf((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L), "", "", "");
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      d();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.4(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin
 * JD-Core Version:    0.7.0.1
 */