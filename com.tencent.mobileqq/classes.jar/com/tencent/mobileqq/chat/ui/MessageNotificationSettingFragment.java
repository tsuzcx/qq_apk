package com.tencent.mobileqq.chat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingCallback;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MessageNotificationSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, MessageNotificationSettingManager.RingCallback
{
  private FriendListObserver a;
  private QQAppInterface b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSimpleItem e;
  private FormSwitchItem f;
  private FriendListHandler g;
  private String h;
  private int i;
  private ITroopSettingHandler j;
  private TroopSettingObserver k;
  private FriendsManager l;
  private MessageNotificationSettingManager m;
  private TroopManager n;
  
  private void a()
  {
    Object localObject = getBaseActivity().getIntent();
    if (localObject != null)
    {
      this.h = ((Intent)localObject).getStringExtra("uin");
      this.i = ((Intent)localObject).getIntExtra("uintype", -1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" mUin: ");
      ((StringBuilder)localObject).append(this.h);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mUinType: ");
      localStringBuilder.append(this.i);
      QLog.e("MessageNotificationSettingFragment", 2, new Object[] { "initData . ", localObject, localStringBuilder.toString() });
    }
    if (!TextUtils.isEmpty(this.h)) {
      i1 = this.i;
    }
    this.m.d(this.h, this.i);
    int i1 = this.i;
    if (i1 == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 1, 0, "", "", "", "");
      return;
    }
    if (i1 == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 2, 0, "", "", "", "");
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramActivity, paramIntent, MessageNotificationSettingFragment.class);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, String[] paramArrayOfString, boolean[] paramArrayOfBoolean, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131889169, 1);
      this.f.setOnCheckedChangeListener(null);
      this.f.setChecked(true ^ paramCompoundButton.isChecked());
      this.f.setOnCheckedChangeListener(this);
      return;
    }
    if (paramBoolean2)
    {
      this.j.a(this.h, this.b.getCurrentUin(), paramInt1, 4096, paramInt2);
      if (paramBoolean1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3CD", "0X800A3CD", paramInt1, 0, "", "", "", "");
      return;
    }
    this.g.setMessageNotificationSetting(3, paramArrayOfString, paramArrayOfBoolean);
    if (paramBoolean1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3CA", "0X800A3CA", paramInt1, 0, "", "", "", "");
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 4096) ^ true;
    }
    return true;
  }
  
  private void b()
  {
    this.a = new MessageNotificationSettingFragment.1(this);
    this.b.addObserver(this.a);
    this.k = new MessageNotificationSettingFragment.2(this);
    this.b.addObserver(this.k);
    this.m.a(this);
  }
  
  private void b(CompoundButton paramCompoundButton, boolean paramBoolean1, String[] paramArrayOfString, boolean[] paramArrayOfBoolean, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131889169, 1);
      this.d.setOnCheckedChangeListener(null);
      this.d.setChecked(true ^ paramCompoundButton.isChecked());
      this.d.setOnCheckedChangeListener(this);
      return;
    }
    if (paramBoolean1) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(8);
    }
    if (paramBoolean2)
    {
      this.j.a(this.h, this.b.getCurrentUin(), paramInt1, 2048, paramInt2);
      if (paramBoolean1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3CC", "0X800A3CC", paramInt1, 0, "", "", "", "");
      return;
    }
    this.g.setMessageNotificationSetting(2, paramArrayOfString, paramArrayOfBoolean);
    if (paramBoolean1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3C9", "0X800A3C9", paramInt1, 0, "", "", "", "");
  }
  
  private boolean b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 2048) ^ true;
    }
    return true;
  }
  
  private void c()
  {
    setTitle(getString(2131892201));
    this.c = ((FormSwitchItem)b(2131445689));
    this.d = ((FormSwitchItem)b(2131445690));
    this.e = ((FormSimpleItem)b(2131445691));
    this.f = ((FormSwitchItem)b(2131445692));
    int i1 = this.i;
    if (i1 == 0) {
      e();
    } else if (i1 == 1) {
      d();
    }
    this.c.setOnCheckedChangeListener(this);
    this.d.setOnCheckedChangeListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnCheckedChangeListener(this);
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.f.setVisibility(8);
      this.d.setBgType(3);
    }
    i1 = this.i;
    if (i1 == 0)
    {
      VasWebviewUtil.a(this.b.getCurrentAccountUin(), "bell", "C2C_show", "", 1, 0, 0, "", "", "");
      return;
    }
    if (i1 == 1) {
      VasWebviewUtil.a(this.b.getCurrentAccountUin(), "bell", "group_show", "", 1, 0, 0, "", "", "");
    }
  }
  
  private void c(CompoundButton paramCompoundButton, boolean paramBoolean1, String[] paramArrayOfString, boolean[] paramArrayOfBoolean, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131889169, 1);
      this.c.setOnCheckedChangeListener(null);
      this.c.setChecked(true ^ paramCompoundButton.isChecked());
      this.c.setOnCheckedChangeListener(this);
      return;
    }
    if (paramBoolean2)
    {
      this.j.a(this.h, this.b.getCurrentUin(), paramInt1, 1024, paramInt2);
      if (paramBoolean1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3CB", "0X800A3CB", paramInt1, 0, "", "", "", "");
      return;
    }
    this.g.setMessageNotificationSetting(1, paramArrayOfString, paramArrayOfBoolean);
    if (paramBoolean1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3C8", "0X800A3C8", paramInt1, 0, "", "", "", "");
  }
  
  private boolean c(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 1024) ^ true;
    }
    return true;
  }
  
  private void d()
  {
    TroopInfo localTroopInfo = this.n.f(this.h);
    if (localTroopInfo == null)
    {
      QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " troopInfo: ", localTroopInfo });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "initViews: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(localTroopInfo.cmdUinFlagEx2) });
    }
    this.c.setChecked(c(localTroopInfo));
    this.d.setChecked(b(localTroopInfo));
    this.f.setChecked(a(localTroopInfo));
    if (b(localTroopInfo))
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }
  
  private void e()
  {
    Object localObject1 = this.l;
    Object localObject2 = this.h;
    boolean bool2 = true;
    localObject1 = ((FriendsManager)localObject1).d((String)localObject2, true);
    if (localObject1 == null)
    {
      QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " extensionInfo: ", localObject1 });
      return;
    }
    localObject2 = this.c;
    boolean bool1;
    if (((ExtensionInfo)localObject1).messageEnablePreviewNew == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool1);
    localObject2 = this.d;
    if (((ExtensionInfo)localObject1).messageEnableSoundNew == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool1);
    localObject2 = this.f;
    if (((ExtensionInfo)localObject1).messageEnableVibrateNew == 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool1);
    if (((ExtensionInfo)localObject1).messageEnableSoundNew == 0)
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.m.a(this.e, paramInt, this.h, this.i);
  }
  
  protected final <T extends View> T b(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected int getContentLayoutId()
  {
    return 2131624876;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445691)
    {
      int i2 = this.i;
      int i1 = 1;
      if (i2 == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 1, 0, "", "", "", "");
        VasWebviewUtil.a(this.b.getCurrentAccountUin(), "bell", "C2C_click", "", 1, 0, 0, "", "", "");
      }
      else if (i2 == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 3, 0, "", "", "", "");
        VasWebviewUtil.a(this.b.getCurrentAccountUin(), "bell", "group_click", "", 1, 0, 0, "", "", "");
      }
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      String str2 = IndividuationUrlHelper.a("specialCareRingUrl");
      if (this.i != 1) {
        i1 = 0;
      }
      String str1;
      if (i1 != 0) {
        str1 = "3";
      } else {
        str1 = "2";
      }
      localIntent.putExtra("url", str2.replace("[uid]", this.h).replace("[lType]", str1));
      startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.removeObserver(this.a);
    this.b.removeObserver(this.k);
    this.m.b(this);
  }
  
  public void onResume()
  {
    super.onResume();
    int i3 = this.i;
    int i2 = 0;
    int i1 = 0;
    Object localObject;
    if (i3 == 0)
    {
      localObject = this.l.d(this.h, false);
      if (localObject == null) {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
      } else {
        i1 = ((ExtensionInfo)localObject).friendRingId;
      }
      this.m.a(this.e, i1, this.h, this.i);
      return;
    }
    if (i3 == 1)
    {
      localObject = this.n.f(this.h);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " troopInfo: ", localObject });
        i1 = i2;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "onResume: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(((TroopInfo)localObject).cmdUinFlagEx2) });
        }
        i1 = (int)((TroopInfo)localObject).udwCmdUinRingtoneID;
      }
      this.m.a(this.e, i1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = getBaseActivity().app;
    this.g = ((FriendListHandler)this.b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.j = ((ITroopSettingHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER));
    this.l = ((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.n = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER));
    this.m = MessageNotificationSettingManager.a(this.b);
    a();
    c();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment
 * JD-Core Version:    0.7.0.1
 */