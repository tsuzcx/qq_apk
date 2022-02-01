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
    ((RoundRelativeLayout)paramView.findViewById(2131364120)).jdField_a_of_type_Int = ViewUtils.a(16.0F);
    Object localObject = (LinearLayout)paramView.findViewById(2131370302);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) {
      ((LinearLayout)localObject).setBackgroundResource(2130840561);
    } else {
      ((LinearLayout)localObject).setBackgroundResource(2130839393);
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout)localObject).setPadding(0, 0, 0, 0);
    }
    else
    {
      int i = ViewUtils.a(8.0F);
      ((LinearLayout)localObject).setPadding(0, i, 0, i);
    }
    if ((((LinearLayout)localObject).getTag() != null) && ((((LinearLayout)localObject).getTag() instanceof RedTouch)))
    {
      paramView = (RedTouch)((LinearLayout)localObject).getTag();
    }
    else
    {
      paramView = paramView.findViewById(2131370226);
      paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).d(ViewUtils.b(5.0F)).c(ViewUtils.b(1.0F)).b(19).a();
      ((LinearLayout)localObject).setTag(paramView);
    }
    if (paramAppInfo.red_display_info != null)
    {
      localObject = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject).next();
        if ((localRedTypeInfo.red_type.get() == 5) || (localRedTypeInfo.red_type.get() == 4)) {
          try
          {
            JSONObject localJSONObject = new JSONObject(localRedTypeInfo.red_desc.get());
            localJSONObject.put("cr", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167063)) }));
            localRedTypeInfo.red_desc.set(localJSONObject.toString());
          }
          catch (Exception localException)
          {
            QLog.i("LebaBannerLogic", 1, "parse json exception", localException);
          }
        }
      }
    }
    paramView.a(paramAppInfo);
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramAppInfo.uiAppId.get()))) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramAppInfo.uiAppId.get()));
      localObject = this.jdField_a_of_type_MqqAppAppRuntime;
      if (localObject == null)
      {
        QLog.i("LebaBannerLogic", 1, "mRuntime == null");
        return;
      }
      ((IRedTouchManager)((AppRuntime)localObject).getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(paramAppInfo.uiAppId.get(), 30);
      localObject = paramAppInfo.buffer.get();
      paramAppInfo = paramAppInfo.missions.get();
      QLog.i("LebaBannerLogic", 1, String.format("reportExposure buffer = %s missions = %s", new Object[] { localObject, paramAppInfo }));
      try
      {
        localObject = new JSONObject((String)localObject);
        a(((JSONObject)localObject).optString("_jump_url"), ((JSONObject)localObject).optString("_jump_type"), ((JSONObject)localObject).optString("_app_id"), paramAppInfo, 1);
      }
      catch (Exception paramAppInfo)
      {
        QLog.i("LebaBannerLogic", 1, "parse json exception", paramAppInfo);
      }
    }
    if (AppSetting.d) {
      AccessibilityUtil.a(paramView, paramView.a(), Button.class.getName());
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
      LebaUtil.a("LebaBannerLogic", "jump", "BasisApi");
      return;
    }
    catch (Exception paramString1)
    {
      QLog.i("LebaBannerLogic", 1, "jump exception ", paramString1);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0)) {
      paramList = (String)paramList.get(0);
    } else {
      paramList = null;
    }
    if ("url".equals(paramString2)) {
      i = 1;
    } else if ("scheme".equals(paramString2)) {
      i = 2;
    } else if ("miniapp".equals(paramString2)) {
      i = 3;
    }
    if (paramInt == 1)
    {
      paramString2 = LebaReportUtils.a("banner_exp");
      paramString2.jdField_b_of_type_Int = i;
      paramString2.a = paramString3;
      paramString2.jdField_b_of_type_JavaLangString = paramList;
      paramString2.e = paramString1;
      EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2);
      return;
    }
    if (paramInt == 2)
    {
      paramString2 = LebaReportUtils.a("banner_clk");
      paramString2.jdField_b_of_type_Int = i;
      paramString2.a = paramString3;
      paramString2.jdField_b_of_type_JavaLangString = paramList;
      paramString2.e = paramString1;
      EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2);
    }
  }
  
  public void a()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null)
    {
      localFrameLayout.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    if (paramInt != this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
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
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("LebaBannerLogic", 1, "onClick mRootLayout == null");
    }
    else
    {
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
        }
        catch (Exception localException)
        {
          QLog.i("LebaBannerLogic", 1, "parse json exception ", localException);
        }
        localIRedTouchManager.reportLevelOneRedInfo(100000, 31);
      }
      else
      {
        QLog.i("LebaBannerLogic", 1, "onClick appInfo no new");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaBannerLogic
 * JD-Core Version:    0.7.0.1
 */