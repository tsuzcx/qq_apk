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
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AIOMusicSkin
  extends SkinDrawable
{
  private static AIOMusicSkin a;
  private String b = "";
  private int g = 0;
  private int h;
  private ChatFragment i;
  private boolean j = false;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private BubblePopupWindow n;
  private ConcurrentHashMap<Integer, String> o = new ConcurrentHashMap();
  private long p = 0L;
  private boolean q = false;
  private QuickUpdateListener r = new AIOMusicSkin.3(this);
  private Runnable s = new AIOMusicSkin.5(this);
  
  public static AIOMusicSkin a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AIOMusicSkin();
        }
      }
      finally {}
    }
    return a;
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
        paramApngQueuePlayer.a(c("pause.png"), 1);
      }
      paramApngQueuePlayer.a(c("pausing.png"), 0);
      return;
    }
    if (paramBoolean) {
      paramApngQueuePlayer.a(c("play.png"), 1);
    }
    paramApngQueuePlayer.a(c("playing.png"), 0);
  }
  
  private void a(View paramView)
  {
    a(paramView, true);
  }
  
  private void a(View paramView1, View paramView2)
  {
    View localView = paramView1.findViewById(2131435809);
    if (paramView2 != null) {
      a(localView, a(paramView2.getContext(), 2130851968));
    }
    b(paramView1, 2131439817, 2130852018);
    a(paramView1, 2131435808, 2131168141);
    a(paramView1, 2131447463, 2131167990);
    a(paramView1, 2131436218, 2131167990);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView = paramView.getRootView();
    b(paramView, 2131444897, 2130852228);
    b(paramView, 2131436666, 2130852243, 2130852247);
    b(paramView, 2131436180, 2130852243, 2130852247);
    d(paramView);
    Object localObject = paramView.findViewById(2131435808);
    if (localObject != null) {
      a((View)localObject, a(((View)localObject).getContext(), 2130851969));
    }
    c(paramView);
    a(paramView, (View)localObject);
    b(paramView);
    if (paramBoolean) {
      b(paramView.getContext());
    }
    if ((du_()) && (localObject != null))
    {
      localObject = b(((View)localObject).getContext(), 2130852162);
      paramView = paramView.findViewById(2131427887);
      if (paramView != null) {
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      paramView = this.i;
      if (paramView != null)
      {
        paramView = paramView.k();
        if (paramView != null) {
          paramView.R();
        }
      }
    }
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession)
  {
    b(true);
    if ((paramListenTogetherSession.f != this.k) || (TextUtils.isEmpty(this.c)))
    {
      b(null);
      this.k = paramListenTogetherSession.f;
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 1, 0, "", "", "", "");
    }
    d();
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131429599);
    int i2 = 8;
    int i1;
    if (localView != null)
    {
      if (du_()) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      localView.setVisibility(i1);
    }
    localView = paramView.findViewById(2131449300);
    paramView = paramView.findViewById(2131435809);
    if ((localView != null) && (paramView != null) && (paramView.getVisibility() == 0))
    {
      if (du_()) {
        i1 = i2;
      } else {
        i1 = 0;
      }
      localView.setVisibility(i1);
    }
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    if ((paramListenTogetherSession != null) && (paramListenTogetherSession.f == 0)) {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 2, 0, "", "", "", "");
    }
    if (this.d)
    {
      b(null);
      b(false);
      ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.2(this));
    }
  }
  
  private void c(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131433920);
    if ((localTextView != null) && (!SimpleUIUtil.e()))
    {
      int i1 = localTextView.getPaddingTop();
      int i2 = localTextView.getPaddingLeft();
      int i3 = localTextView.getPaddingRight();
      int i4 = localTextView.getPaddingBottom();
      a(paramView, 2131433920, 2130852117, 2130852118, 2130852114);
      localTextView.setPadding(i2, i1, i3, i4);
    }
  }
  
  private static boolean c(int paramInt)
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
    int i1 = ThemeUtil.getFileNumInFile(new File((String)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isThemeExists: fileNum = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(", id=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("AIOMusicSkin", 1, ((StringBuilder)localObject).toString());
    if (i1 > 1) {
      bool = true;
    }
    return bool;
  }
  
  private void d(View paramView)
  {
    View localView = paramView.findViewById(2131444897);
    if (localView != null)
    {
      if (this.g == 1) {
        a(localView, 2131436189, 2130851975, 2130851976);
      } else {
        a(localView, 2131436189, 2130851959, 2130851962);
      }
      a(localView, 2131436194, 2130852260, 2130852261);
    }
    if (du_())
    {
      a(paramView, 2131442175, 2130852078, 2130852079);
      a(paramView, 2131442165, 2130852035, 2130852036);
      a(paramView, 2131442178, 2130852084, 2130852085);
      a(paramView, 2131442157, 2130852016, 2130852017);
      a(paramView, 2131442147, 2130852006, 2130852007);
      a(paramView, 2131442170, 2130852055, 2130852056);
      a(paramView, 2131442154, 2130838124, 2130838125);
      a(paramView, 2131442158, 2130838152, 2130838154);
      a(paramView, 2131442168, 2130838165, 2130838166);
      a(paramView, 2131442141, 2130851986, 2130851987);
      return;
    }
    paramView = this.i;
    if ((paramView != null) && (paramView.k() != null)) {
      this.i.k().W.a(this.i.k());
    }
  }
  
  private void g()
  {
    SkinDrawable.IVasSkinChangeCallback localIVasSkinChangeCallback;
    if (this.f == null) {
      localIVasSkinChangeCallback = null;
    } else {
      localIVasSkinChangeCallback = (SkinDrawable.IVasSkinChangeCallback)this.f.get();
    }
    if (localIVasSkinChangeCallback != null) {
      localIVasSkinChangeCallback.m();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.i;
    boolean bool = true;
    if ((localObject != null) && (((ChatFragment)localObject).h != null))
    {
      ImageView localImageView = (ImageView)this.i.h.findViewById(2131439073);
      if (localImageView == null)
      {
        QLog.e("AIOMusicSkin", 1, "updateAnim: null view");
        return;
      }
      if ((du_()) && (this.j) && (!a(this.i, this.g)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateAnim: last=");
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(" cur=");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("AIOMusicSkin", 2, ((StringBuilder)localObject).toString());
        }
        if (this.h == paramInt) {
          bool = false;
        }
        this.h = paramInt;
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
    if (this.m)
    {
      Object localObject = this.i;
      if ((localObject != null) && (((ChatFragment)localObject).h != null))
      {
        this.m = false;
        localObject = this.i.h.findViewById(2131439051);
        if (localObject == null) {
          return;
        }
        this.n = new BubblePopupWindow(-2, -2);
        TextView localTextView = new TextView(paramContext);
        localTextView.setPadding(20, 0, 20, 0);
        this.n.setContentView(localTextView);
        localTextView.setText(paramContext.getResources().getString(2131891228));
        this.n.setAnimationStyle(2131953359);
        this.n.setSoftInputMode(1);
        this.n.setInputMethodMode(2);
        paramContext = new int[2];
        ((View)localObject).getLocationOnScreen(paramContext);
        this.n.setKeepAbove(true);
        this.n.showAtLocation((View)localObject, paramContext[0] + ((View)localObject).getWidth() / 2, paramContext[1] + ((View)localObject).getHeight());
        this.n.getContentView().setOnClickListener(new AIOMusicSkin.1(this));
        ListenTogetherUtils.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", false, false);
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
      paramContext.append(this.b);
      paramContext.append("  type:");
      paramContext.append(this.g);
      paramContext.append(" mIsUserSkin:");
      paramContext.append(this.d);
      QLog.i("AIOMusicSkin", 2, paramContext.toString());
    }
    paramContext = new StringBuilder();
    paramContext.append("setMusicBarSkin mIsUserSkin:");
    paramContext.append(this.d);
    paramContext.append(" mIsShowSkin:");
    paramContext.append(this.j);
    QLog.i("AIOMusicSkin", 1, paramContext.toString());
    if (paramView == null) {
      return;
    }
    paramContext = paramView.getRootView();
    b(paramContext, 2131437326, 2130852430, 2130852431);
    a(paramContext, 2131442946, 2130846233, 2130846234);
    a(paramContext, 2131439051, 2130846227, 2130846228);
    a(paramContext, 2131439071, 2131167974);
    a(paramContext, 2131439074, 2131167972);
    a(paramContext, 2131439070, 2131167974);
    paramView = (CircleProgress)paramContext.findViewById(2131439067);
    if (paramView != null)
    {
      ColorStateList localColorStateList = c(paramContext.getContext(), 2131167973);
      paramView.setBgAndProgressColor(100, c(paramContext.getContext(), 2131167975).getDefaultColor(), 100, localColorStateList.getDefaultColor());
    }
    paramContext = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).e(this.g, this.b);
    if (paramContext != null)
    {
      a(paramContext.p);
      return;
    }
    a(3);
  }
  
  public void a(ChatFragment paramChatFragment, String paramString, int paramInt)
  {
    this.i = paramChatFragment;
    if (paramInt == 1)
    {
      paramChatFragment = this.i;
      if ((paramChatFragment != null) && ((paramChatFragment.k() instanceof BaseTroopChatPie)) && (((BaseTroopChatPie)this.i.k()).bG())) {
        return;
      }
    }
    a(paramString, paramInt);
    if ((this.i != null) && (this.d)) {
      b(this.i.getBaseActivity());
    }
    this.p = System.currentTimeMillis();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b = paramString;
    this.g = paramInt;
    if (paramInt == 1) {
      c(a(paramString));
    } else {
      c(true);
    }
    paramString = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).e(paramInt, paramString);
    if ((paramString != null) && (paramString.f > 0) && (paramString.p != 3) && (paramString.q == 2) && (!a(this.i, this.g))) {
      a(paramString);
    } else {
      b(paramString);
    }
    if (paramString != null)
    {
      if (c()) {
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
    paramString.append(this.e);
    paramString.append(" new: ");
    paramString.append(paramBoolean);
    QLog.d("AIOMusicSkin", 1, paramString.toString());
    c(paramBoolean);
    if (!paramBoolean) {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BC", 0, 0, "", "", "", "");
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(ChatFragment paramChatFragment, int paramInt)
  {
    boolean bool = true;
    if (paramChatFragment == null) {
      return true;
    }
    if ((paramInt == 1) && ((paramChatFragment.k() instanceof BaseTroopChatPie)))
    {
      if (!((BaseTroopChatPie)paramChatFragment.k()).bG())
      {
        if (SimpleUIUtil.e()) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return SimpleUIUtil.e();
  }
  
  public boolean a(String paramString)
  {
    if (this.l) {
      return true;
    }
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).getBoolean("music_skin_enabled", true);
  }
  
  public void b(Context paramContext)
  {
    ChatFragment localChatFragment = this.i;
    if (localChatFragment != null)
    {
      if (a(localChatFragment, this.g)) {
        return;
      }
      if (!du_())
      {
        this.i.e();
        return;
      }
      this.q = true;
      this.i.q().setBackgroundColor(paramContext.getResources().getColor(2131168092));
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAIOSkin uin:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("  type:");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" mIsUserSkin:");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" mIsShowSkin:");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(" enable:");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("AIOMusicSkin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAIOSkin mIsUserSkin:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" mIsShowSkin:");
    ((StringBuilder)localObject).append(this.j);
    QLog.i("AIOMusicSkin", 1, ((StringBuilder)localObject).toString());
    if ((this.j) && (du_()) && (!a(this.i, this.g)))
    {
      localObject = this.i;
      if ((localObject != null) && (!paramContext.equals(((ChatFragment)localObject).e))) {
        return;
      }
      a(paramView);
      if ((this.j) && (du_()) && (!TextUtils.isEmpty(this.c))) {
        a(paramContext);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.d)
    {
      this.d = paramBoolean;
      g();
    }
  }
  
  public boolean b()
  {
    return this.l;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.e)
    {
      this.e = paramBoolean;
      g();
    }
  }
  
  public boolean c()
  {
    return this.k > 0;
  }
  
  public void d()
  {
    if (a(this.i, this.g)) {
      return;
    }
    if ((this.o.get(Integer.valueOf(this.k)) != null) && (du_()))
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        this.j = true;
        b((String)this.o.get(Integer.valueOf(this.k)));
        a(this.i.h);
        a(this.i.e, this.i.h);
        return;
      }
      ThreadManager.getSubThreadHandler().post(this.s);
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.s);
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.4(this, paramBoolean));
  }
  
  public void e()
  {
    this.o.clear();
  }
  
  public void f()
  {
    this.q = false;
    this.i = null;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leave uin:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("  type:");
      ((StringBuilder)localObject).append(this.g);
      QLog.i("AIOMusicSkin", 2, ((StringBuilder)localObject).toString());
    }
    QLog.i("AIOMusicSkin", 1, "leave");
    Object localObject = this.n;
    if (localObject != null)
    {
      ((BubblePopupWindow)localObject).dismiss();
      this.n = null;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BF", 0, 0, String.valueOf((System.currentTimeMillis() - this.p) / 1000L), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin
 * JD-Core Version:    0.7.0.1
 */