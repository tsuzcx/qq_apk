package com.tencent.mobileqq.leba.controller.table;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.report.EXReportController;
import com.tencent.mobileqq.leba.report.LebaReportUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class LebaBannerLogic
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  public FrameLayout a;
  protected ILebaBasisApi a;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  protected AppRuntime a;
  
  public LebaBannerLogic(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, View paramView)
  {
    ((RoundRelativeLayout)paramView.findViewById(2131364203)).jdField_a_of_type_Int = ViewUtils.a(16.0F);
    Object localObject = (LinearLayout)paramView.findViewById(2131370660);
    if (ThemeUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, false, null))
    {
      ((LinearLayout)localObject).setBackgroundResource(2130840686);
      if (this.jdField_a_of_type_Int != 1) {
        break label258;
      }
      ((LinearLayout)localObject).setPadding(0, 0, 0, 0);
      label64:
      if ((((LinearLayout)localObject).getTag() == null) || (!(((LinearLayout)localObject).getTag() instanceof RedTouch))) {
        break label276;
      }
      paramView = (RedTouch)((LinearLayout)localObject).getTag();
    }
    for (;;)
    {
      if (paramAppInfo.red_display_info == null) {
        break label328;
      }
      localObject = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject).next();
        if ((localRedTypeInfo.red_type.get() == 5) || (localRedTypeInfo.red_type.get() == 4)) {
          try
          {
            JSONObject localJSONObject = new JSONObject(localRedTypeInfo.red_desc.get());
            localJSONObject.put("cr", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167040)) }));
            localRedTypeInfo.red_desc.set(localJSONObject.toString());
          }
          catch (Exception localException)
          {
            QLog.i("LebaBannerLogic", 1, "parse json exception", localException);
          }
        }
      }
      ((LinearLayout)localObject).setBackgroundResource(2130839537);
      break;
      label258:
      int i = ViewUtils.a(8.0F);
      ((LinearLayout)localObject).setPadding(0, i, 0, i);
      break label64;
      label276:
      paramView = paramView.findViewById(2131370570);
      paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).d(ViewUtils.b(5.0F)).c(ViewUtils.b(1.0F)).b(19).a();
      ((LinearLayout)localObject).setTag(paramView);
    }
    label328:
    paramView.a(paramAppInfo);
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramAppInfo.uiAppId.get()))) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramAppInfo.uiAppId.get()));
      if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
        QLog.i("LebaBannerLogic", 1, "mRuntime == null");
      }
    }
    for (;;)
    {
      return;
      ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(paramAppInfo.uiAppId.get(), 30);
      localObject = paramAppInfo.buffer.get();
      paramAppInfo = paramAppInfo.missions.get();
      QLog.i("LebaBannerLogic", 1, String.format("reportExposure buffer = %s missions = %s", new Object[] { localObject, paramAppInfo }));
      try
      {
        localObject = new JSONObject((String)localObject);
        a(((JSONObject)localObject).optString("_jump_url"), ((JSONObject)localObject).optString("_jump_type"), ((JSONObject)localObject).optString("_app_id"), paramAppInfo, 1);
        if (!AppSetting.d) {
          continue;
        }
        AccessibilityUtil.a(paramView, paramView.a(), Button.class.getName());
        return;
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          QLog.i("LebaBannerLogic", 1, "parse json exception", paramAppInfo);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("LebaBannerLogic", 1, String.format("jump jumpUrl:%s ,jumpType:%s ,appId:%s ", new Object[] { paramString1, paramString2, paramString3 }));
    try
    {
      if ("url".equals(paramString2))
      {
        paramString2 = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/base/browser");
        paramString2.extra().putString("url", paramString1);
        QRoute.startUri(paramString2, null);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi.jumpByScheme(this.jdField_a_of_type_AndroidContentContext, paramString1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.i("LebaBannerLogic", 1, "jump exception ", paramString1);
      return;
    }
    LebaUtil.a("LebaBannerLogic", "jump", "BasisApi");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt)
  {
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (paramList.size() > 0) {
        localObject1 = (String)paramList.get(0);
      }
    }
    if ("url".equals(paramString2))
    {
      i = 1;
      if (paramInt != 1) {
        break label131;
      }
      paramString2 = LebaReportUtils.a("banner_exp");
      paramString2.jdField_b_of_type_Int = i;
      paramString2.a = paramString3;
      paramString2.jdField_b_of_type_JavaLangString = ((String)localObject1);
      paramString2.e = paramString1;
      EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2);
    }
    label131:
    while (paramInt != 2)
    {
      return;
      if ("scheme".equals(paramString2))
      {
        i = 2;
        break;
      }
      if (!"miniapp".equals(paramString2)) {
        break;
      }
      i = 3;
      break;
    }
    paramString2 = LebaReportUtils.a("banner_clk");
    paramString2.jdField_b_of_type_Int = i;
    paramString2.a = paramString3;
    paramString2.jdField_b_of_type_JavaLangString = ((String)localObject1);
    paramString2.e = paramString1;
    EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      if (paramInt != this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      return;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi = ((ILebaBasisApi)QRoute.api(ILebaBasisApi.class));
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new LebaBannerLogic.1(this));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      QLog.i("LebaBannerLogic", 1, "onClick mRootLayout == null");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      a();
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
      Object localObject1 = localIRedTouchManager.getAppInfo(0, "100000");
      if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).exposure_max.get() >= 0))
      {
        String str1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
        localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get();
        QLog.i("LebaBannerLogic", 1, String.format("onClick buffer = %s missions = %s time = %d", new Object[] { str1, localObject1, Long.valueOf(System.currentTimeMillis() - l) }));
        try
        {
          Object localObject2 = new JSONObject(str1);
          str1 = ((JSONObject)localObject2).optString("_jump_url");
          String str2 = ((JSONObject)localObject2).optString("_jump_type");
          localObject2 = ((JSONObject)localObject2).optString("_app_id");
          a(str1, str2, (String)localObject2);
          a(str1, str2, (String)localObject2, (List)localObject1, 2);
          localIRedTouchManager.reportLevelOneRedInfo(100000, 31);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("LebaBannerLogic", 1, "parse json exception ", localException);
          }
        }
      }
      else
      {
        QLog.i("LebaBannerLogic", 1, "onClick appInfo no new");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaBannerLogic
 * JD-Core Version:    0.7.0.1
 */