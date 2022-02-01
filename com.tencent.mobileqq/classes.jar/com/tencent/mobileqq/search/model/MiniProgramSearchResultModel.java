package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramSearchResultModel
  extends IContactSearchModel
{
  public MiniAppLocalSearchEntity a;
  protected String b;
  public int[] c = new int[3];
  
  public MiniProgramSearchResultModel(QQAppInterface paramQQAppInterface, int paramInt, MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity, String paramString)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.a = paramMiniAppLocalSearchEntity;
    this.b = paramString;
    B();
  }
  
  protected boolean A()
  {
    String str = this.a.appName;
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.b)) && (str.equalsIgnoreCase(this.b));
  }
  
  protected void B()
  {
    if (A())
    {
      f(3);
      return;
    }
    f(9);
  }
  
  public CharSequence a()
  {
    return this.a.desc;
  }
  
  public void a(View paramView)
  {
    if (this.m.getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH) != null)
    {
      int i;
      if (this.a.showMask == 0) {
        i = 1005;
      } else {
        i = 1027;
      }
      if (this.a.miniAppType == 1) {
        ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniAppById((Activity)paramView.getContext(), this.a.appId, "", i);
      } else {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById((Activity)paramView.getContext(), this.a.appId, null, null, null, null, i, null);
      }
    }
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (SearchUtils.l.containsKey(this))
      {
        paramView = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
        Object localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("obj_lct", paramView.c);
          ((JSONObject)localObject1).put("get_src", "native");
        }
        catch (JSONException localJSONException)
        {
          localObject2 = l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(localJSONException);
          QLog.e((String)localObject2, 2, localStringBuilder.toString());
        }
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramView.b);
        ((StringBuilder)localObject2).append("");
        localReportModelDC02528 = localReportModelDC02528.obj1(((StringBuilder)localObject2).toString()).obj2(this.a.appId).ver1(paramView.a).ver2(UniteSearchReportController.a(UniteSearchActivity.f));
        if (x()) {
          paramView = "1";
        } else {
          paramView = "0";
        }
        paramView = localReportModelDC02528.ver3(paramView).ver7(((JSONObject)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject1).append(SearchUtils.j);
        UniteSearchReportController.a(null, paramView.session_id(((StringBuilder)localObject1).toString()));
      }
      SearchUtils.b(localQQAppInterface, this.b, this.p, s(), o());
      if ((this.p != null) && (!TextUtils.isEmpty(this.p)))
      {
        UniteSearchReportController.a(null, 0, this.n, "0X8009D31", 3, 0, null, null);
        return;
      }
      if ((this.a.appName != null) && (this.a.appName.equals(this.b)))
      {
        UniteSearchReportController.a(null, 0, this.n, "0X8009D33", 0, 0, this.a.appId, null);
        return;
      }
      UniteSearchReportController.a(null, 0, this.n, "0X8009D45", 0, 0, this.a.appId, null);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public String c()
  {
    return this.a.appId;
  }
  
  public CharSequence d()
  {
    return SearchUtils.b(this.a.appName, this.b, 10, true);
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public int j()
  {
    return 0;
  }
  
  public String m()
  {
    return this.a.appName;
  }
  
  public String n()
  {
    return null;
  }
  
  protected long n_(String paramString)
  {
    return 0L;
  }
  
  public int o()
  {
    return 6;
  }
  
  public String s()
  {
    return this.a.appId;
  }
  
  public String t()
  {
    return this.a.iconUrl;
  }
  
  public String w()
  {
    return "https://qzonestyle.gtimg.cn/aoi/sola/20190108152813_orkMRcBegl.png";
  }
  
  public boolean x()
  {
    return (this.a.showMask & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.MiniProgramSearchResultModel
 * JD-Core Version:    0.7.0.1
 */