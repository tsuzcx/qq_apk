package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.managers.TempMsgManager.OnTempMsgSettingChangeListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import java.util.HashMap;
import java.util.Map;

public class NewTempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements TempMsgManager.OnTempMsgSettingChangeListener
{
  QQAppInterface a;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private QFormSimpleItem e;
  private QFormSimpleItem f;
  private QFormSimpleItem g;
  private QFormSimpleItem h;
  private QFormSimpleItem i;
  private CompoundButton.OnCheckedChangeListener j;
  private CompoundButton.OnCheckedChangeListener k;
  private CompoundButton.OnCheckedChangeListener l;
  private Map<Short, String> m = new HashMap();
  private Map<Integer, String> n = new HashMap();
  private Map<Integer, View> o = new HashMap();
  private final View.OnClickListener p = new NewTempMsgSettingFragment.4(this);
  private final View.OnClickListener q = new NewTempMsgSettingFragment.5(this);
  
  private String a(String paramString, Map<String, Boolean> paramMap1, Map<String, Boolean> paramMap2)
  {
    paramMap1 = (Boolean)paramMap1.get(paramString);
    paramString = (Boolean)paramMap2.get(paramString);
    if (paramMap1 != null)
    {
      if (paramString == null) {
        return "";
      }
      int i1 = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(paramString.booleanValue(), paramMap1.booleanValue());
      paramString = (String)this.n.get(Integer.valueOf(i1));
      if (paramString != null) {
        return paramString;
      }
      return "";
    }
    return "";
  }
  
  private String a(short paramShort)
  {
    if (!this.m.containsKey(Short.valueOf(paramShort))) {
      return "";
    }
    return (String)this.m.get(Short.valueOf(paramShort));
  }
  
  private void a()
  {
    this.o.put(Integer.valueOf(1000), this.e);
    this.o.put(Integer.valueOf(1006), this.f);
    this.o.put(Integer.valueOf(1005), this.g);
    this.o.put(Integer.valueOf(1024), this.h);
  }
  
  private void b()
  {
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return;
      }
      int i1 = getActivity().getIntent().getIntExtra("uinType", 0);
      ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)this.a.getRuntimeService(ITempMsgBoxManager.class, "");
      if (this.o.containsKey(Integer.valueOf(i1)))
      {
        if (!localITempMsgBoxManager.configContains(i1)) {
          return;
        }
        this.p.onClick((View)this.o.get(Integer.valueOf(i1)));
      }
    }
  }
  
  private void c()
  {
    this.m.put(Short.valueOf((short)-23308), getString(2131917160));
    this.m.put(Short.valueOf((short)-23310), getString(2131917143));
    this.m.put(Short.valueOf((short)-23309), getString(2131917142));
    this.m.put(Short.valueOf((short)-20457), getString(2131917141));
    this.n.put(Integer.valueOf(0), getString(2131917153));
    this.n.put(Integer.valueOf(1), getString(2131917152));
    this.n.put(Integer.valueOf(2), getString(2131917154));
  }
  
  private void d()
  {
    this.e = ((QFormSimpleItem)this.mContentView.findViewById(2131439257));
    this.f = ((QFormSimpleItem)this.mContentView.findViewById(2131439255));
    this.g = ((QFormSimpleItem)this.mContentView.findViewById(2131439254));
    this.h = ((QFormSimpleItem)this.mContentView.findViewById(2131439253));
    this.i = ((QFormSimpleItem)this.mContentView.findViewById(2131439256));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131446966));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131446965));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131446964));
    e();
    Object localObject = (TempMsgManager)this.a.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
    ((TempMsgManager)localObject).a(this);
    Map localMap = ((TempMsgManager)localObject).b();
    localObject = ((TempMsgManager)localObject).a();
    this.e.setRightText(a("temp_msg_setting_troop_", localMap, (Map)localObject));
    this.f.setRightText(a("temp_msg_setting_contact_", localMap, (Map)localObject));
    this.g.setRightText(a("temp_msg_setting_consult_", localMap, (Map)localObject));
    this.h.setRightText(a("temp_msg_setting_company_", localMap, (Map)localObject));
    this.b.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
    this.c.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
    this.d.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
    this.e.setTag(Short.valueOf((short)-23308));
    this.f.setTag(Short.valueOf((short)-23310));
    this.g.setTag(Short.valueOf((short)-23309));
    this.h.setTag(Short.valueOf((short)-20457));
    this.e.setOnClickListener(this.p);
    this.f.setOnClickListener(this.p);
    this.g.setOnClickListener(this.p);
    this.h.setOnClickListener(this.p);
    this.i.setOnClickListener(this.q);
    if (AppSetting.e)
    {
      this.e.setContentDescription(getString(2131917160));
      this.f.setContentDescription(getString(2131917143));
      this.g.setContentDescription(getString(2131917142));
      this.h.setContentDescription(getString(2131917141));
      this.b.setContentDescription(getString(2131917160));
      this.c.setContentDescription(getString(2131917143));
      this.d.setContentDescription(getString(2131917142));
    }
    this.j = new NewTempMsgSettingFragment.1(this);
    this.b.setOnCheckedChangeListener(this.j);
    this.k = new NewTempMsgSettingFragment.2(this);
    this.c.setOnCheckedChangeListener(this.k);
    this.l = new NewTempMsgSettingFragment.3(this);
    this.d.setOnCheckedChangeListener(this.l);
  }
  
  private void e()
  {
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)this.a.getRuntimeService(ITempMsgBoxManager.class, "");
    if (localITempMsgBoxManager.configContains(1000)) {
      this.b.setVisibility(8);
    } else {
      this.e.setVisibility(8);
    }
    if (localITempMsgBoxManager.configContains(1006)) {
      this.c.setVisibility(8);
    } else {
      this.f.setVisibility(8);
    }
    if (localITempMsgBoxManager.configContains(1005)) {
      this.d.setVisibility(8);
    } else {
      this.g.setVisibility(8);
    }
    if (!localITempMsgBoxManager.configContains(1024)) {
      this.h.setVisibility(8);
    }
    if (!localITempMsgBoxManager.configContains(10007)) {
      this.i.setVisibility(8);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      return;
    }
    int i1 = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(paramBoolean2, paramBoolean3);
    if ((paramShort != -20457) && (paramShort != -20455))
    {
      switch (paramShort)
      {
      default: 
        switch (paramShort)
        {
        default: 
          return;
        }
      case -23308: 
        this.b.setOnCheckedChangeListener(null);
        this.b.setChecked(paramBoolean2);
        this.b.setOnCheckedChangeListener(this.j);
        this.e.setRightText((CharSequence)this.n.get(Integer.valueOf(i1)));
        return;
      case -23309: 
        this.d.setOnCheckedChangeListener(null);
        this.d.setChecked(paramBoolean2);
        this.d.setOnCheckedChangeListener(this.l);
        this.g.setRightText((CharSequence)this.n.get(Integer.valueOf(i1)));
        return;
      }
      this.c.setOnCheckedChangeListener(null);
      this.c.setChecked(paramBoolean2);
      this.c.setOnCheckedChangeListener(this.k);
      this.f.setRightText((CharSequence)this.n.get(Integer.valueOf(i1)));
      return;
    }
    this.h.setRightText((CharSequence)this.n.get(Integer.valueOf(i1)));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    c();
    d();
    a();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627828;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131917156));
    return localView;
  }
  
  public void onDestroy()
  {
    ((TempMsgManager)this.a.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(null);
    this.a = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */