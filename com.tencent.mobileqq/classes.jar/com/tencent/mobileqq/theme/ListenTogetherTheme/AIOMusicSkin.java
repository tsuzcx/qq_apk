package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
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
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.ApngQueuePlayer;
import com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback;
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
    if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin == null) {
        jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin = new AIOMusicSkin();
      }
      return jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin;
    }
    finally {}
  }
  
  private void a(View paramView)
  {
    a(paramView, true);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    label74:
    label203:
    do
    {
      do
      {
        return;
        paramView = paramView.getRootView();
        b(paramView, 2131377159, 2130850507);
        b(paramView, 2131369878, 2130850521, 2130850525);
        b(paramView, 2131369487, 2130850521, 2130850525);
        Object localObject1 = paramView.findViewById(2131377159);
        Object localObject2;
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Int == 1)
          {
            a((View)localObject1, 2131369496, 2130850257, 2130850258);
            a((View)localObject1, 2131369501, 2130850538, 2130850539);
          }
        }
        else
        {
          if (!m_()) {
            break label520;
          }
          a(paramView, 2131374542, 2130850360, 2130850361);
          a(paramView, 2131374532, 2130850317, 2130850318);
          a(paramView, 2131374545, 2130850366, 2130850367);
          a(paramView, 2131374524, 2130850298, 2130850299);
          a(paramView, 2131374514, 2130850288, 2130850289);
          a(paramView, 2131374537, 2130850337, 2130850338);
          a(paramView, 2131374521, 2130838245, 2130838246);
          a(paramView, 2131374525, 2130838284, 2130838286);
          a(paramView, 2131374535, 2130838297, 2130838298);
          a(paramView, 2131374508, 2130850268, 2130850269);
          localObject1 = paramView.findViewById(2131369141);
          if (localObject1 != null) {
            a((View)localObject1, a(((View)localObject1).getContext(), 2130850251));
          }
          localObject2 = (TextView)paramView.findViewById(2131367663);
          if ((localObject2 != null) && (!SimpleUIUtil.a()))
          {
            i = ((TextView)localObject2).getPaddingTop();
            int j = ((TextView)localObject2).getPaddingLeft();
            int k = ((TextView)localObject2).getPaddingRight();
            int m = ((TextView)localObject2).getPaddingBottom();
            a(paramView, 2131367663, 2130850399, 2130850400, 2130850396);
            ((TextView)localObject2).setPadding(j, i, k, m);
          }
          localObject2 = paramView.findViewById(2131369142);
          if (localObject1 != null) {
            a((View)localObject2, a(((View)localObject1).getContext(), 2130850250));
          }
          b(paramView, 2131372729, 2130850300);
          a(paramView, 2131369141, 2131167133);
          a(paramView, 2131379432, 2131167030);
          a(paramView, 2131369525, 2131167030);
          localObject2 = paramView.findViewById(2131363753);
          if (localObject2 != null)
          {
            if (!m_()) {
              break label560;
            }
            i = 8;
            ((View)localObject2).setVisibility(i);
          }
          localObject2 = paramView.findViewById(2131381097);
          View localView = paramView.findViewById(2131369142);
          if ((localObject2 != null) && (localView != null) && (localView.getVisibility() == 0)) {
            if (!m_()) {
              break label565;
            }
          }
        }
        for (int i = 8;; i = 0)
        {
          ((View)localObject2).setVisibility(i);
          if (paramBoolean) {
            b(paramView.getContext());
          }
          if ((!m_()) || (localObject1 == null)) {
            break label570;
          }
          localObject1 = b(((View)localObject1).getContext(), 2130850444);
          paramView = paramView.findViewById(2131362327);
          if (paramView == null) {
            break;
          }
          paramView.setBackgroundDrawable((Drawable)localObject1);
          return;
          a((View)localObject1, 2131369496, 2130850241, 2130850244);
          break label74;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a() == null)) {
            break label203;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a().a.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a());
          break label203;
          i = 0;
          break label394;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a();
    } while (paramView == null);
    label394:
    label560:
    label565:
    label570:
    paramView.Q();
    label520:
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getContext();
    if (localObject == null)
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: context is null");
      return false;
    }
    MusicThemeCallback localMusicThemeCallback = MusicThemeCallback.sInstance;
    localObject = localMusicThemeCallback.getDir((Context)localObject, localMusicThemeCallback.getScid(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: path empty, id=" + paramInt);
      return false;
    }
    int i = ThemeUtil.getFileNumInFile(new File((String)localObject));
    QLog.e("AIOMusicSkin", 1, "isThemeExists: fileNum = " + i + ", id=" + paramInt);
    if (i > 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (SkinDrawable.IVasSkinChangeCallback localIVasSkinChangeCallback = null;; localIVasSkinChangeCallback = (SkinDrawable.IVasSkinChangeCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (localIVasSkinChangeCallback != null) {
        localIVasSkinChangeCallback.k();
      }
      return;
    }
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int)) != null) && (m_()))
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null))
    {
      QLog.e("AIOMusicSkin", 1, "updateAnim: null root");
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131372055);
    if (localImageView == null)
    {
      QLog.e("AIOMusicSkin", 1, "updateAnim: null view");
      return;
    }
    if ((!m_()) || (!this.jdField_c_of_type_Boolean) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)))
    {
      localImageView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOMusicSkin", 2, "updateAnim: last=" + this.jdField_b_of_type_Int + " cur=" + paramInt);
    }
    if (this.jdField_b_of_type_Int != paramInt) {}
    ApngQueuePlayer localApngQueuePlayer1;
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = paramInt;
      localImageView.setVisibility(0);
      ApngQueuePlayer localApngQueuePlayer2 = (ApngQueuePlayer)localImageView.getTag();
      localApngQueuePlayer1 = localApngQueuePlayer2;
      if (localApngQueuePlayer2 == null)
      {
        localApngQueuePlayer1 = new ApngQueuePlayer(localImageView);
        localImageView.setTag(localApngQueuePlayer1);
      }
      switch (paramInt)
      {
      default: 
        localApngQueuePlayer1.a();
        return;
      }
    }
    if (i != 0) {
      localApngQueuePlayer1.a(a("play.png"), 1);
    }
    localApngQueuePlayer1.a(a("playing.png"), 0);
    return;
    if (i != 0) {
      localApngQueuePlayer1.a(a("pause.png"), 1);
    }
    localApngQueuePlayer1.a(a("pausing.png"), 0);
  }
  
  public void a(Context paramContext)
  {
    View localView;
    if ((this.e) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      this.e = false;
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131372032);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(20, 0, 20, 0);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(localTextView);
    localTextView.setText(paramContext.getResources().getString(2131693700));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(2131755862);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    paramContext = new int[2];
    localView.getLocationOnScreen(paramContext);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.d(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(localView, paramContext[0] + localView.getWidth() / 2, paramContext[1] + localView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a().setOnClickListener(new AIOMusicSkin.1(this));
    ListenTogetherUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", false, false);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5B9", 1, 0, "", "", "", "");
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "setMusicBarSkin uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean);
    }
    QLog.i("AIOMusicSkin", 1, "setMusicBarSkin mIsUserSkin:" + this.jdField_a_of_type_Boolean + " mIsShowSkin:" + this.jdField_c_of_type_Boolean);
    if (paramView == null) {
      return;
    }
    paramContext = paramView.getRootView();
    b(paramContext, 2131370502, 2130850706, 2130850707);
    a(paramContext, 2131375241, 2130844923, 2130844924);
    a(paramContext, 2131372032, 2130844917, 2130844918);
    a(paramContext, 2131372053, 2131167015);
    a(paramContext, 2131372056, 2131167013);
    a(paramContext, 2131372050, 2131167015);
    paramView = (CircleProgress)paramContext.findViewById(2131372048);
    if (paramView != null)
    {
      ColorStateList localColorStateList = a(paramContext.getContext(), 2131167014);
      paramView.setBgAndProgressColor(100, a(paramContext.getContext(), 2131167016).getDefaultColor(), 100, localColorStateList.getDefaultColor());
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
    if ((paramInt == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a() instanceof BaseTroopChatPie)) && (((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a()).G())) {
      return;
    }
    a(paramString, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.jdField_a_of_type_Boolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.getActivity());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      c(a(paramString));
      paramString = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(paramInt, paramString);
      if ((paramString == null) || (paramString.jdField_b_of_type_Int <= 0) || (paramString.h == 3) || (paramString.i != 2) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int))) {
        break label236;
      }
      b(true);
      if ((paramString.jdField_b_of_type_Int != this.jdField_c_of_type_Int) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        a(null);
        this.jdField_c_of_type_Int = paramString.jdField_b_of_type_Int;
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 1, 0, "", "", "", "");
      }
      a();
      label154:
      if (paramString != null) {
        if (!b()) {
          break label309;
        }
      }
    }
    label309:
    for (paramInt = 1;; paramInt = 2)
    {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BE", paramInt, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("AIOMusicSkin", 2, "updateState, session:" + paramString);
      }
      return;
      c(true);
      break;
      label236:
      if ((paramString != null) && (paramString.jdField_b_of_type_Int == 0)) {
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 2, 0, "", "", "", "");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
      a(null);
      b(false);
      ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.2(this));
      break label154;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).edit().putBoolean("music_skin_enabled", paramBoolean).commit();
    QLog.d("AIOMusicSkin", 1, "setEnabled old: " + this.jdField_b_of_type_Boolean + " new: " + paramBoolean);
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
    if (paramChatFragment == null) {
      return true;
    }
    if ((paramInt == 1) && ((paramChatFragment.a() instanceof BaseTroopChatPie)))
    {
      if ((((BaseTroopChatPie)paramChatFragment.a()).G()) || (SimpleUIUtil.a())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int))) {
      return;
    }
    if (!m_())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a();
      return;
    }
    this.f = true;
    paramContext = a(paramContext, 2131167091);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(paramContext.getDefaultColor());
  }
  
  public void b(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "setAIOSkin uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean + " mIsShowSkin:" + this.jdField_c_of_type_Boolean + " enable:" + this.jdField_b_of_type_Boolean);
    }
    QLog.i("AIOMusicSkin", 1, "setAIOSkin mIsUserSkin:" + this.jdField_a_of_type_Boolean + " mIsShowSkin:" + this.jdField_c_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) || (!m_()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (!paramContext.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_AndroidContentContext)))) {}
    do
    {
      return;
      a(paramView);
    } while ((!this.jdField_c_of_type_Boolean) || (!m_()) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    a(paramContext);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    GlobalImageCache.a.evictAll();
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString);
      b(false);
    }
    for (;;)
    {
      a();
      return;
      a(paramString);
      b(true);
      this.jdField_c_of_type_Boolean = true;
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
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "leave uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int);
    }
    QLog.i("AIOMusicSkin", 1, "leave");
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin
 * JD-Core Version:    0.7.0.1
 */