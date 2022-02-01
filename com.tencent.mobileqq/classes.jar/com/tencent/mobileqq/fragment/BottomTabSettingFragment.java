package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.event.QCircleTabConfigChangeEvent;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BottomTabSettingFragment
  extends QIphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  protected LinearLayout a;
  protected Map<String, Integer> b = new HashMap();
  protected String c;
  private QQAppInterface d;
  private Map<String, Integer> e = new HashMap();
  private int f;
  private int g;
  private ListView w;
  private final HashMap<Integer, String> x = new HashMap();
  private BottomTabSettingFragment.BottomTabListAdapter y;
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          v();
          str = "NEW_WORLD";
          break label44;
        }
      }
      else
      {
        u();
        str = "RIJ";
        break label44;
      }
    }
    else {
      t();
    }
    String str = "none";
    label44:
    this.g = paramInt;
    Object localObject = this.y;
    if (localObject != null) {
      ((BottomTabSettingFragment.BottomTabListAdapter)localObject).notifyDataSetChanged();
    }
    localObject = c(str);
    if (localObject != null) {
      ThreadManager.excute(new -..Lambda.BottomTabSettingFragment.xTi5tpOt0BfS0t8QteSZwcI2niA(this, (HashMap)localObject), 160, null, true);
    }
    f(str);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[BottomTabSettingFragment][initSwitchItem] isGetTabSwitchCache: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("BottomTabSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (FormSwitchItem)this.t.findViewById(paramInt1);
    Boolean localBoolean = b(paramString);
    if (localBoolean == null)
    {
      ((FormSwitchItem)localObject).setVisibility(8);
      return;
    }
    ((FormSwitchItem)localObject).setVisibility(0);
    ((FormSwitchItem)localObject).setContentDescription(this.d.getApplicationContext().getString(paramInt2));
    ((FormSwitchItem)localObject).setChecked(localBoolean.booleanValue());
    a(paramString, localBoolean.booleanValue(), false);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new -..Lambda.BottomTabSettingFragment.ILL7rGKstX2703fW6eUAgb3JKJQ(this, paramString));
  }
  
  private boolean a(String paramString)
  {
    paramString = (Integer)this.e.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.intValue() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Boolean b(String paramString)
  {
    StringBuilder localStringBuilder;
    if ((this.e == null) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[BottomTabSettingFragment][isSwitchHide] tabResultMap : ");
      localStringBuilder.append(null);
      QLog.d("BottomTabSettingFragment", 2, localStringBuilder.toString());
    }
    paramString = (Integer)this.e.get(paramString);
    if ((paramString != null) && ((paramString.intValue() == 3) || (paramString.intValue() == 2)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[BottomTabSettingFragment][isSwitchHide] value : ");
        localStringBuilder.append(paramString);
        QLog.d("BottomTabSettingFragment", 2, localStringBuilder.toString());
      }
      if (paramString.intValue() == 2) {
        return Boolean.valueOf(true);
      }
      if (paramString.intValue() == 3) {
        return Boolean.valueOf(false);
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[BottomTabSettingFragment][isSwitchHide] value : ");
      localStringBuilder.append(paramString);
      QLog.d("BottomTabSettingFragment", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  private HashMap<String, Boolean> c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("RIJ", Boolean.valueOf(paramString.equals("RIJ")));
    if (b("NEW_WORLD") != null) {
      localHashMap.put("NEW_WORLD", Boolean.valueOf(paramString.equals("NEW_WORLD")));
    }
    return localHashMap;
  }
  
  private void c(boolean paramBoolean)
  {
    if (StudyModeManager.h()) {
      localObject = "qqcircle_show_entrance_on_main_tab_on_children_mode";
    } else {
      localObject = "qqcircle_show_entrance_on_main_tab";
    }
    String str2 = "1";
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    QCircleSetCircleSwitchRequest localQCircleSetCircleSwitchRequest = new QCircleSetCircleSwitchRequest("qqcircle", (String)localObject, str1);
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    if (paramBoolean) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localQzoneConfig.updateOneConfig("qqcircle", (String)localObject, str1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toggleQCircleTab:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.w("BottomTabSettingFragment", 1, ((StringBuilder)localObject).toString());
    VSNetworkHelper.getInstance().sendRequest(localQCircleSetCircleSwitchRequest, new -..Lambda.BottomTabSettingFragment.YbUA1pGDzQUAHDUBL3iSqvXNUhU(paramBoolean));
  }
  
  private void d(String paramString)
  {
    int i;
    if (paramString.equals("none")) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE85", "0X800BE85", i, 0, "", "", "", "");
    if (paramString.equals("NEW_WORLD")) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE89", "0X800BE89", i, 0, "", "", "", "");
    if (paramString.equals("RIJ")) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE87", "0X800BE87", i, 0, "", "", "", "");
  }
  
  private void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private String e(String paramString)
  {
    if (paramString.equals("NEW_WORLD")) {
      return "0X800BE8A";
    }
    if (paramString.equals("RIJ")) {
      return "0X800BE88";
    }
    return "0X800BE86";
  }
  
  private void f(String paramString)
  {
    paramString = e(paramString);
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
  }
  
  private void p()
  {
    a("GUILD", 2131434475, 2131896636);
    this.a = ((LinearLayout)this.t.findViewById(2131429634));
    if (!f()) {
      return;
    }
    q();
    this.g = r();
    this.f = this.g;
    this.w = ((ListView)this.t.findViewById(2131429699));
    this.y = new BottomTabSettingFragment.BottomTabListAdapter(this);
    this.w.setAdapter(this.y);
  }
  
  private void q()
  {
    this.x.put(Integer.valueOf(0), getResources().getString(2131887609));
    if (b("RIJ") != null) {
      this.x.put(Integer.valueOf(1), getResources().getString(2131891080));
    }
    if (b("NEW_WORLD") != null) {
      this.x.put(Integer.valueOf(2), QCircleConfigHelper.bo());
    }
  }
  
  private int r()
  {
    String str = "NEW_WORLD";
    boolean bool1 = a("NEW_WORLD");
    boolean bool2 = a("RIJ");
    int i;
    if (bool1)
    {
      i = 2;
    }
    else if (bool2)
    {
      i = 1;
      str = "RIJ";
    }
    else
    {
      i = 0;
      str = "none";
    }
    d(str);
    return i;
  }
  
  private void s()
  {
    if (this.f != this.g)
    {
      SimpleEventBus localSimpleEventBus = SimpleEventBus.getInstance();
      boolean bool;
      if (this.g == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localSimpleEventBus.dispatchEvent(new QCircleTabConfigChangeEvent(bool));
    }
  }
  
  private void t()
  {
    d(false);
    if (b("NEW_WORLD") != null) {
      c(false);
    }
    ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "no_display_clk", 0, 0, "", "", "", "");
  }
  
  private void u()
  {
    if (b("NEW_WORLD") != null) {
      c(false);
    }
    d(true);
    ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "kandian_clk", 0, 0, "", "", "", "");
  }
  
  private void v()
  {
    d(false);
    c(true);
    ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "littleworld_clk", 0, 0, "", "", "", "");
  }
  
  protected int a()
  {
    return 2131626844;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(getResources().getText(2131887613));
    p();
    paramViewGroup = BaseApplicationImpl.getApplication().getRuntime();
    if (e()) {
      paramLayoutInflater = "1";
    } else {
      paramLayoutInflater = "2";
    }
    ReportController.b(paramViewGroup, "CliOper", "", "", "bottom_tab", "page_exp", 0, 0, paramLayoutInflater, "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X800BE84", "0X800BE84", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramString.equals("GUILD"))
      {
        paramString = "0X800BE05";
        break label42;
      }
    }
    else if (paramString.equals("GUILD"))
    {
      paramString = "0X800BE04";
      break label42;
    }
    paramString = "";
    label42:
    int i;
    if (!paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
  
  protected void b()
  {
    int i = TabDataHelper.getModelType();
    this.c = TabDataHelper.getTabRuleList(this.d.getApplicationContext(), this.d.getCurrentUin(), i);
    this.b = TabDataHelper.getTabSwitch(this.d.getApplicationContext(), this.d.getCurrentUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[BottomTabSettingFragment][getLocalTabCache]  allTabListCacheString: ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" tabSwitchMap: ");
      localStringBuilder.append(this.b);
      QLog.d("BottomTabSettingFragment", 2, localStringBuilder.toString());
    }
  }
  
  protected boolean c()
  {
    Object localObject = this.b;
    boolean bool2 = true;
    boolean bool1;
    if ((localObject != null) && (!TextUtils.isEmpty(this.c)))
    {
      bool1 = true;
    }
    else
    {
      QQToast.makeText(getQBaseActivity(), 1, 2131896633, 2000).show();
      bool1 = d();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[BottomTabSettingFragment][isGetTabSwitchCache] tabSwitchMap == null: ");
      if (this.b != null) {
        bool2 = false;
      }
      ((StringBuilder)localObject).append(bool2);
      QLog.d("BottomTabSettingFragment", 2, ((StringBuilder)localObject).toString());
      if (this.b != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[BottomTabSettingFragment][isGetTabSwitchCache] tabSwitchMap.isEmpty(): ");
        ((StringBuilder)localObject).append(this.b.isEmpty());
        ((StringBuilder)localObject).append(" TextUtils.isEmpty(allTabListCacheString): ");
        ((StringBuilder)localObject).append(TextUtils.isEmpty(this.c));
        QLog.d("BottomTabSettingFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    return bool1;
  }
  
  protected boolean d()
  {
    Object localObject = new -..Lambda.BottomTabSettingFragment.5y64iYUCsdPimuFPuirJM5j7fDI(this);
    boolean bool = true;
    ThreadManager.excute((Runnable)localObject, 160, null, true);
    localObject = this.b;
    if ((localObject != null) && (!((Map)localObject).isEmpty()) && (!TextUtils.isEmpty(this.c))) {
      return true;
    }
    QQToast.makeText(getQBaseActivity(), 1, 2131896632, 2000).show();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[BottomTabSettingFragment][refreshTabListNet] tabSwitchMap == null: ");
      if (this.b != null) {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("BottomTabSettingFragment", 2, ((StringBuilder)localObject).toString());
      if (this.b != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[BottomTabSettingFragment][refreshTabListNet] tabSwitchMap.isEmpty(): ");
        ((StringBuilder)localObject).append(this.b.isEmpty());
        ((StringBuilder)localObject).append(" TextUtils.isEmpty(allTabListCacheString): ");
        ((StringBuilder)localObject).append(TextUtils.isEmpty(this.c));
        QLog.d("BottomTabSettingFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  protected boolean e()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      boolean bool = "VALUE_QQ_SETTING_FRAGMENT".equals(getActivity().getIntent().getStringExtra("KEY_ENTRANCE"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFromQQSetting result: ");
      localStringBuilder.append(bool);
      QLog.d("BottomTabSettingFragment", 1, localStringBuilder.toString());
      return bool;
    }
    return false;
  }
  
  public boolean f()
  {
    return (this.e != null) && ((b("NEW_WORLD") != null) || (b("RIJ") != null));
  }
  
  protected HashMap<String, Integer> g()
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][tabInfo] tabSwitchMap == null: true");
      }
      return null;
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][tabInfo] allTabListCacheString == null: true");
      }
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Integer localInteger = (Integer)localEntry.getValue();
      if ((this.c.contains((CharSequence)localEntry.getKey())) && (localInteger != null) && ((localInteger.intValue() == 2) || (localInteger.intValue() == 3))) {
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  protected void h()
  {
    b();
    Object localObject = this.b;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][openTabTips] tabSwitchMap == null: true");
      }
      return;
    }
    localObject = (Integer)((Map)localObject).get("NEW_WORLD");
    if ((this.b != null) && (localObject != null))
    {
      String str = this.c;
      if (str != null)
      {
        if (str.isEmpty()) {
          return;
        }
        if ((((Integer)localObject).intValue() == 2) && (this.c.contains("NEW_WORLD"))) {
          s();
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((QQAppInterface)getQBaseActivity().getAppRuntime());
    if (!this.d.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(getQBaseActivity(), paramBundle, "/base/login");
      getQBaseActivity().finish();
    }
    b();
    this.e = g();
    if ((!c()) || (this.e == null)) {
      onDestroy();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment
 * JD-Core Version:    0.7.0.1
 */