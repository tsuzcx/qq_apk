package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SimpleUIChoiceView;
import com.tencent.mobileqq.activity.SimpleUIChoiceView.OnModeSelectListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdVerifyFragment;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ModeChoiceViewContainer
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, SimpleUIChoiceView.OnModeSelectListener, ModeRadioGroup.OnCheckChangeListener, ModeSwitchManager.OnModeChangeResultCallback
{
  private static HashMap<String, Boolean> q = new HashMap();
  private QQAppInterface a;
  private QBaseActivity b;
  private View c;
  private ModeRadioGroup d;
  private View e;
  private SimpleUIChoiceView f;
  private FormSwitchSimpleItem g;
  private int h = -1;
  private int i = -1;
  private boolean j = false;
  private boolean k = false;
  private FormSimpleItem l;
  private FormSwitchSimpleItem m;
  private AlphabeticFontHandler n;
  private QQCustomDialog o;
  private ModeChoiceViewContainer.DarkModeUpdateListener p;
  private final AlphabeticFontSwitchObserver r = new ModeChoiceViewContainer.1(this);
  private KidModeObserver s = new ModeChoiceViewContainer.2(this);
  private CompoundButton.OnCheckedChangeListener t = new ModeChoiceViewContainer.3(this);
  
  public ModeChoiceViewContainer(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    this.a = paramQQAppInterface;
    this.b = paramQBaseActivity;
    b();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.f.a(paramInt, paramBoolean);
    this.e.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      a(2131892157, 1);
      a(paramCompoundButton, paramBoolean1 ^ true);
      return;
    }
    if (paramCompoundButton == this.g.getSwitch())
    {
      if (a(this.g))
      {
        a(paramCompoundButton, paramBoolean1 ^ true);
        return;
      }
      Object localObject1 = new ModeChoiceViewContainer.4(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
      if (paramBoolean1)
      {
        Object localObject2 = ThemeUtil.getUinThemePreferences(this.a);
        if (((SharedPreferences)localObject2).getBoolean("key_simple_should_show_switch_dialog", true))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject1 = new ModeChoiceViewContainer.5(this, (Runnable)localObject1);
          localObject2 = this.b;
          this.o = DialogUtil.a((Activity)localObject2, ((QBaseActivity)localObject2).getResources().getString(2131916383), 0, 2131916381, (DialogInterface.OnClickListener)localObject1, null);
          this.o.setOnDismissListener(new ModeChoiceViewContainer.WeakRefSimpleUIDismissListener(this, paramCompoundButton));
          this.o.show();
        }
        else
        {
          ((Runnable)localObject1).run();
        }
      }
      else
      {
        ((Runnable)localObject1).run();
      }
      if (paramBoolean1) {
        paramCompoundButton = "0X800A0FC";
      } else {
        paramCompoundButton = "0X800A0FD";
      }
      ReportController.b(this.a, "dc00898", "", "", paramCompoundButton, paramCompoundButton, SimpleUIUtil.i(), 0, "0", "0", "", "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    FormSwitchSimpleItem localFormSwitchSimpleItem = this.m;
    if (localFormSwitchSimpleItem != null) {
      localFormSwitchSimpleItem.setChecked(paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.getRightText();
    if (paramFormSwitchSimpleItem == null) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean)
    {
      paramFormSwitchSimpleItem.setVisibility(0);
      localDrawable = this.b.getResources().getDrawable(2130839590);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i1 = AIOUtils.b(19.0F, this.b.getResources());
      localDrawable.setBounds(0, 0, i1, i1);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, localDrawable, null);
      ((Animatable)localDrawable).start();
    }
    else
    {
      localDrawable = (Drawable)paramFormSwitchSimpleItem.getTag();
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      paramFormSwitchSimpleItem.setTag(null);
      paramFormSwitchSimpleItem.setVisibility(8);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, null, null);
    }
    this.g.getSwitch().setEnabled(paramBoolean ^ true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ModeChoiceViewContainer", 2, "handleModeSelectRadioByRequest");
    }
    if ((StudyModeManager.i()) && (this.d != null))
    {
      int i1 = ModeConstantsKt.a(paramBoolean1, paramBoolean2);
      this.d.a(i1, false, false);
    }
    a(paramBoolean1, SimpleUIUtil.i());
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    if (q.containsKey(paramAppInterface)) {
      return ((Boolean)q.get(paramAppInterface)).booleanValue();
    }
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_qq_mode_upper");
    localExpEntityInfo.h();
    boolean bool = localExpEntityInfo.f();
    q.put(paramAppInterface, Boolean.valueOf(bool));
    return bool;
  }
  
  private boolean a(FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.getRightText();
    if (paramFormSwitchSimpleItem == null) {
      return false;
    }
    return (paramFormSwitchSimpleItem.getTag() instanceof Animatable);
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true, false);
  }
  
  private void h(int paramInt1, int paramInt2)
  {
    int i1;
    if (a(this.a)) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    String str = c(paramInt2);
    if (paramInt1 == 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B86D", "0X800B86D", i1, 0, str, "", "", "");
      return;
    }
    if (paramInt1 == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B86C", "0X800B86C", i1, 0, str, "", "", "");
      return;
    }
    if (paramInt1 == 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B86B", "0X800B86B", i1, 0, str, "", "", "");
    }
  }
  
  private boolean h(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpToKidModelVerify action=");
      localStringBuilder.append(paramInt);
      QLog.i("ModeChoiceViewContainer", 1, localStringBuilder.toString());
      return false;
    }
    this.k = true;
    this.j = false;
    int i1 = StudyModeManager.e();
    int i2 = StudyModeManager.b();
    int i3 = StudyModeManager.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpToKidModelVerify action=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",bindBindPhone=");
    localStringBuilder.append(i1);
    localStringBuilder.append(",kidModeNeedVerifyPhone=");
    localStringBuilder.append(i2);
    localStringBuilder.append(",kidModePasswordState=");
    localStringBuilder.append(i3);
    QLog.i("ModeChoiceViewContainer", 1, localStringBuilder.toString());
    if (i3 == 1)
    {
      if ((i1 != -1) && (i2 != -1))
      {
        if ((i1 == 0) && (i2 == 1))
        {
          d(paramInt);
          return true;
        }
        f(paramInt);
        return true;
      }
      k();
      return false;
    }
    if (i3 == 3)
    {
      f(paramInt);
      return true;
    }
    if (i3 == 2)
    {
      e(paramInt);
      this.j = true;
      return true;
    }
    l();
    return false;
  }
  
  private void i()
  {
    ModeSwitchManager localModeSwitchManager = (ModeSwitchManager)this.a.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    localModeSwitchManager.a(this);
    TextView localTextView = (TextView)this.c.findViewById(2131438795);
    View localView = this.e.findViewById(2131432003);
    this.e.findViewById(2131430940);
    if (StudyModeManager.i())
    {
      this.g.setVisibility(8);
      localTextView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setOnCheckChangeListener(this);
      localView.setVisibility(8);
    }
    else
    {
      this.g.setVisibility(0);
      localTextView.setVisibility(8);
      this.d.setVisibility(8);
      localView.setVisibility(0);
    }
    boolean bool = SimpleUIUtil.e();
    this.g.getRightText().setVisibility(8);
    this.f = new SimpleUIChoiceView();
    this.f.a(this.e, this.b, this.a);
    this.f.a(this);
    this.f.a(this);
    a(bool, SimpleUIUtil.i());
    if (StudyModeManager.h())
    {
      this.l.setVisibility(0);
      a(this.n.a());
      this.d.setPadding(0, 0, 0, ViewUtils.dpToPx(2.0F));
    }
    else
    {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      this.d.setPadding(0, 0, 0, ViewUtils.dpToPx(18.0F));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ModeChoiceViewContainer", 2, new Object[] { "[KidMode] configSwitch: ", Boolean.valueOf(StudyModeManager.h()), " isSwitch: ", Boolean.valueOf(localModeSwitchManager.c()), " manager TargetType: ", Integer.valueOf(localModeSwitchManager.a()) });
    }
    if ((StudyModeManager.i()) && (localModeSwitchManager.c()))
    {
      this.d.a(false);
      this.f.a(false);
      if ((ModeConstantsKt.a() == 1) && (localModeSwitchManager.a() == 1))
      {
        this.f.b(localModeSwitchManager.b(), true);
        this.e.setTag(Boolean.valueOf(true));
        this.d.a(localModeSwitchManager.a(), false, false);
      }
      else
      {
        this.d.a(localModeSwitchManager.a(), false, true);
      }
    }
    else
    {
      ((SimpleUIHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a();
      if (StudyModeManager.i())
      {
        int i1 = ModeConstantsKt.a();
        this.d.a(i1, false, false);
      }
      else
      {
        a(this.g.getSwitch(), bool);
      }
    }
    this.m.setOnCheckedChangeListener(new ModeChoiceViewContainer.6(this));
    this.l.setOnClickListener(this);
  }
  
  private void j()
  {
    ThreadManager.getUIHandler().post(new ModeChoiceViewContainer.7(this));
  }
  
  private void k()
  {
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.a(3);
    }
    KidModeServlet.a(this.a);
  }
  
  private void l()
  {
    KidModeServlet.b(this.a);
  }
  
  private void m()
  {
    if (!h(1)) {
      a(2131892157, 1);
    }
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(this.b.getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnActivityResult REQ_ENTER_STUDY_MODEL resultCode=");
      paramIntent.append(paramInt2);
      paramIntent.append(",lastTargetMode=");
      paramIntent.append(this.i);
      paramIntent.append(",lastOldMode=");
      paramIntent.append(this.h);
      paramIntent.append(",isJumpToStudyPwdVerify=");
      paramIntent.append(this.j);
      QLog.i("ModeChoiceViewContainer", 1, paramIntent.toString());
      paramInt1 = this.i;
      if (paramInt1 != -1)
      {
        if (this.h == -1) {
          return;
        }
        if (paramInt2 != -1)
        {
          a(2131916382, 1);
          b("verify cancel", this.h);
          return;
        }
        if ((paramInt1 == 2) && (!this.j))
        {
          KidModeAdvanceSettingFragment.a(this.b);
          return;
        }
        g(this.i);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (ModeSwitchManager)this.a.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    boolean bool = ((ModeSwitchManager)localObject).c();
    localObject = ((ModeSwitchManager)localObject).a(this.b, paramInt1, paramInt2, paramBoolean1);
    StringBuilder localStringBuilder;
    if (((ModeSwitchManager.SwitchingStatus)localObject).a())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeMode switchingStatus.isSwitching : true , mode : ");
        localStringBuilder.append(((ModeSwitchManager.SwitchingStatus)localObject).b());
        QLog.d("ModeChoiceViewContainer", 2, localStringBuilder.toString());
      }
      if (paramBoolean2)
      {
        a(paramInt2, true);
        this.d.a(false);
        this.f.a(false);
      }
      this.d.a(((ModeSwitchManager.SwitchingStatus)localObject).b(), false, true ^ paramBoolean2);
      if (bool) {
        QQToast.makeText(BaseApplication.getContext(), 0, 2131916388, 0).show();
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeMode switchingStatus.isSwitching : false , mode : ");
        localStringBuilder.append(((ModeSwitchManager.SwitchingStatus)localObject).c());
        QLog.d("ModeChoiceViewContainer", 2, localStringBuilder.toString());
      }
      this.d.a(((ModeSwitchManager.SwitchingStatus)localObject).c(), false, false);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.c = View.inflate(paramContext, 2131627814, null);
    this.d = ((ModeRadioGroup)this.c.findViewById(2131434290));
    this.e = this.c.findViewById(2131446022);
    this.g = ((FormSwitchSimpleItem)this.c.findViewById(2131446023));
    this.l = ((FormSimpleItem)this.c.findViewById(2131436791));
    this.m = ((FormSwitchSimpleItem)this.c.findViewById(2131436792));
    i();
    e();
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.t);
  }
  
  public void a(ModeChoiceViewContainer.DarkModeUpdateListener paramDarkModeUpdateListener)
  {
    this.p = paramDarkModeUpdateListener;
  }
  
  void a(String paramString, int paramInt)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt, paramString, 0).show(this.b.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ModeChoiceViewContainer", 1, new Object[] { "checkNeedShowSimpleUIChoice switch: ", Boolean.valueOf(paramBoolean), " bPref: ", Integer.valueOf(paramInt) });
    }
    View localView = this.e;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    a(paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    boolean bool1 = true;
    if (!bool3)
    {
      QBaseActivity localQBaseActivity = this.b;
      int i1;
      if (paramBoolean) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      QQToast.makeText(localQBaseActivity, i1, paramString, 0).show();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onModeChangeComplete isSuccess : ");
      paramString.append(paramBoolean);
      paramString.append(", curType : ");
      paramString.append(paramInt1);
      paramString.append(", oldType : ");
      paramString.append(paramInt2);
      QLog.d("ModeChoiceViewContainer", 2, paramString.toString());
    }
    this.f.a(true);
    this.d.a(true);
    this.d.a(paramInt1);
    if (paramBoolean)
    {
      this.d.a(paramInt1, false, false);
      if (paramInt1 == 1) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      a(paramBoolean, SimpleUIUtil.i());
      QZoneHelper.killQZoneProcess();
      if (paramInt1 != 2)
      {
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.d.setPadding(0, 0, 0, ViewUtils.dpToPx(18.0F));
        return;
      }
      this.l.setVisibility(0);
      this.d.setPadding(0, 0, 0, ViewUtils.dpToPx(2.0F));
      KidModeUtils.b("SETTING", this.a);
      a(this.n.a());
      return;
    }
    this.d.a(paramInt2, false, false);
    if (paramInt2 == 1) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    }
    a(paramBoolean, SimpleUIUtil.i());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if (paramBoolean3)
    {
      paramBoolean2 = this.g.getSwitch().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          a(this.b.getResources().getString(2131916385, new Object[] { HardCodeUtil.a(2131903223) }), 2);
        }
      }
      else
      {
        a(this.g.getSwitch(), SimpleUIUtil.e());
        int i1;
        if (paramBoolean2) {
          i1 = 2131903221;
        } else {
          i1 = 2131903222;
        }
        Object localObject1 = HardCodeUtil.a(i1);
        Object localObject2 = this.b.getResources().getString(2131916384, new Object[] { localObject1 });
        if (1 == paramInt)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131903218));
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131903219));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = localObject2;
          if (6 == paramInt)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131903217));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        a((String)localObject1, 1);
      }
    }
    else if (!paramBoolean1)
    {
      a(2131916382, 1);
    }
    a(false, this.g);
    a(SimpleUIUtil.e(), SimpleUIUtil.i());
    if (paramBoolean1) {
      QZoneHelper.killQZoneProcess();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s onReqGetSimpleUISwitch suc=%b [%b,%d]", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if (paramBoolean1)
    {
      if (!this.a.getCurrentAccountUin().equals(paramString)) {
        return;
      }
      if (a(this.g)) {
        return;
      }
      if (f()) {
        return;
      }
      a(paramBoolean2, paramBoolean3);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.f.a(paramMotionEvent);
  }
  
  protected void b()
  {
    this.n = ((AlphabeticFontHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER));
    this.a.addObserver(this.r);
    this.a.registObserver(this.s);
    a(this.b);
    l();
  }
  
  protected void b(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      a(2131892157, 1);
      QQToast.makeText(BaseApplication.getContext(), 1, 2131892157, 0).show(this.b.getTitleBarHeight());
      return;
    }
    if (f()) {
      return;
    }
    if (StudyModeManager.i()) {
      a(1, paramInt, false, true);
    } else if (!((SimpleUIHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.g.getSwitch().isChecked(), paramInt, false)) {
      a(2131916388, 0);
    } else {
      a(paramInt, true);
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A3D6", "0X800A3D6", paramInt + 1, 0, "0", "0", "", "");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onModeChangeStart curType : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", oldType : ");
      localStringBuilder.append(paramInt2);
      QLog.d("ModeChoiceViewContainer", 2, localStringBuilder.toString());
    }
    this.d.a(false);
    this.f.a(false);
  }
  
  protected void b(String paramString, int paramInt)
  {
    Object localObject = this.d;
    boolean bool = false;
    ((ModeRadioGroup)localObject).a(paramInt, false, false);
    if (paramInt == 1) {
      bool = true;
    }
    a(bool, SimpleUIUtil.i());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleChangeKidModeSwitchFailed tagPrefix=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",oldType=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("ModeChoiceViewContainer", 1, ((StringBuilder)localObject).toString());
  }
  
  protected String c(int paramInt)
  {
    if (paramInt == 0) {
      return "1";
    }
    if (paramInt == 1) {
      return "3";
    }
    if (paramInt == 2) {
      return "4";
    }
    return "";
  }
  
  public void c()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).setOnDismissListener(null);
      if (this.o.isShowing()) {
        this.o.cancel();
      }
    }
    localObject = this.f;
    if (localObject != null) {
      ((SimpleUIChoiceView)localObject).b();
    }
    localObject = (ModeSwitchManager)this.a.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    ((ModeSwitchManager)localObject).b(this);
    ((ModeSwitchManager)localObject).d();
    this.a.removeObserver(this.r);
    this.a.unRegistObserver(this.s);
    if (this.k) {
      KidModeServlet.a(this.a, null);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectModeRecover curType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", oldType : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ModeChoiceViewContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    boolean bool = true;
    ((SimpleUIChoiceView)localObject).a(true);
    this.d.a(true);
    this.d.a(paramInt2, false, false);
    this.d.a(paramInt1);
    if (paramInt2 != 1) {
      bool = false;
    }
    a(bool, SimpleUIUtil.i());
  }
  
  public void d()
  {
    this.d.a();
  }
  
  protected void d(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ExtraTargetAction", paramInt);
    localIntent.putExtra("FIRST_TIME_RES", -1);
    if (paramInt == 1)
    {
      PublicFragmentActivity.a(this.b, localIntent, KidModeVerifyFragment.class);
      return;
    }
    PublicFragmentActivity.a(this.b, localIntent, KidModeVerifyFragment.class, 2);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onModeSwitching curType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", oldType : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ModeChoiceViewContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d;
    boolean bool = true;
    ((ModeRadioGroup)localObject).a(paramInt1, false, true);
    this.d.a(false);
    this.f.a(false);
    if (paramInt2 != 1) {
      bool = false;
    }
    a(bool, SimpleUIUtil.i());
  }
  
  protected void e()
  {
    int i1;
    if (a(this.a)) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B807", "0X800B807", i1, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X800B808", "0X800B808", i1, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X800B809", "0X800B809", i1, 0, "", "", "", "");
  }
  
  protected void e(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ExtraTargetAction", paramInt);
    if (paramInt == 1)
    {
      QPublicFragmentActivity.start(this.b, localIntent, StudyPwdVerifyFragment.class);
      return;
    }
    QPublicFragmentActivity.startForResult(this.b, localIntent, StudyPwdVerifyFragment.class, 2);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onModeCheckedChanged curType : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", oldType : ");
    localStringBuilder.append(paramInt2);
    QLog.i("ModeChoiceViewContainer", 1, localStringBuilder.toString());
    h(paramInt1, paramInt2);
    if ((paramInt2 != 2) && (paramInt1 != 2))
    {
      g(paramInt1);
      return;
    }
    f(paramInt1, paramInt2);
  }
  
  protected void f(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ExtraTargetAction", paramInt);
    if (paramInt == 1)
    {
      QPublicFragmentActivity.start(this.b, localIntent, StudyPwdSetFragment.class);
      return;
    }
    QPublicFragmentActivity.startForResult(this.b, localIntent, StudyPwdSetFragment.class, 2);
  }
  
  protected void f(int paramInt1, int paramInt2)
  {
    this.h = paramInt2;
    this.i = paramInt1;
    int i1 = 2;
    if (paramInt1 == 2) {
      paramInt1 = i1;
    } else {
      paramInt1 = 3;
    }
    if (!h(paramInt1))
    {
      a(2131892157, 1);
      b("handleChangeKidModeSwitch failed", paramInt2);
    }
  }
  
  public boolean f()
  {
    Object localObject = this.e.getTag();
    return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
  }
  
  public void g()
  {
    ModeChoiceViewContainer.DarkModeUpdateListener localDarkModeUpdateListener = this.p;
    if (localDarkModeUpdateListener != null) {
      localDarkModeUpdateListener.b();
    }
  }
  
  protected void g(int paramInt)
  {
    int i2 = 1;
    if (paramInt != 1) {
      i2 = 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(this.a, false, null);
    int i3 = SimpleUIUtil.i();
    int i1 = i3;
    if (i2 != 0) {
      if (bool)
      {
        i1 = SimpleUIUtil.d;
      }
      else
      {
        i1 = i3;
        if (ThemeUtil.isNowThemeIsNight(this.a, false, SimpleUIUtil.a(i3))) {
          i1 = SimpleUIUtil.j();
        }
      }
    }
    if (i2 != 0)
    {
      String str = SimpleUIUtil.a(i1);
      if (!DarkModeManager.b(this.b, str, new ModeChoiceViewContainer.8(this, paramInt, i1))) {
        g(paramInt, i1);
      }
    }
    else
    {
      g(paramInt, i1);
    }
  }
  
  public View h()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436791)
    {
      m();
      int i1;
      if (a(this.a)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800BD9C", "0X800BD9C", i1, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s urldrawable onFileDownloaded", new Object[] { "SimpleUILog" }));
    }
    j();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s urldrawable onLoadFialed", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ModeChoiceViewContainer", 2, String.format("%s urldrawable onLoadSuccessed", new Object[] { "SimpleUILog" }));
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer
 * JD-Core Version:    0.7.0.1
 */