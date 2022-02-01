package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qcircle.api.event.QCircleTabConfigChangeEvent;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class BottomTabSettingFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private BottomTabSettingFragment.BottomTabListAdapter jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter;
  private final HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int b;
  
  private static int a()
  {
    boolean bool1 = QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a());
    boolean bool2 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab();
    if (bool1) {
      return 2;
    }
    if (bool2) {
      return 1;
    }
    return 0;
  }
  
  public static String a(Resources paramResources)
  {
    if (paramResources == null) {
      return "";
    }
    int i = a();
    if (i != 1)
    {
      if (i != 2) {
        return paramResources.getString(2131690694);
      }
      return paramResources.getString(2131697851);
    }
    return paramResources.getString(2131693524);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), getResources().getString(2131690694));
    if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).hideKandianTab()) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), getResources().getString(2131693524));
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), getResources().getString(2131697851));
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          b(false);
          a(true);
          ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "littleworld_clk", 0, 0, "", "", "", "");
        }
      }
      else
      {
        b(true);
        a(false);
        ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "kandian_clk", 0, 0, "", "", "", "");
      }
    }
    else
    {
      b(false);
      a(false);
      ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "no_display_clk", 0, 0, "", "", "", "");
    }
    this.b = paramInt;
    BottomTabSettingFragment.BottomTabListAdapter localBottomTabListAdapter = this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter;
    if (localBottomTabListAdapter != null) {
      localBottomTabListAdapter.notifyDataSetChanged();
    }
    QQToast.a(getBaseActivity(), 2, 2131695003, 2000).a();
  }
  
  private void a(boolean paramBoolean)
  {
    String str;
    if (StudyModeManager.a()) {
      str = "qqcircle_show_entrance_on_main_tab_on_children_mode";
    } else {
      str = "qqcircle_show_entrance_on_main_tab";
    }
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    Object localObject = new QCircleSetCircleSwitchRequest("qqcircle", str, (String)localObject);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new BottomTabSettingFragment.1(this, paramBoolean, str));
  }
  
  private boolean a()
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
  
  private void b()
  {
    if (this.jdField_a_of_type_Int != this.b)
    {
      SimpleEventBus localSimpleEventBus = SimpleEventBus.getInstance();
      boolean bool;
      if (this.b == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localSimpleEventBus.dispatchEvent(new QCircleTabConfigChangeEvent(bool));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getText(2131690695));
    a();
    this.b = a();
    this.jdField_a_of_type_Int = this.b;
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131363768));
    this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter = new BottomTabSettingFragment.BottomTabListAdapter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter);
    paramViewGroup = BaseApplicationImpl.getApplication().getRuntime();
    if (a()) {
      paramLayoutInflater = "1";
    } else {
      paramLayoutInflater = "2";
    }
    ReportController.b(paramViewGroup, "CliOper", "", "", "bottom_tab", "page_exp", 0, 0, paramLayoutInflater, "", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131560712;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment
 * JD-Core Version:    0.7.0.1
 */