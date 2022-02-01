package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.business.group.model.SearchResultGroupModelImpl;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModeTitle
  extends SearchResultGroupModelImpl
{
  public String a;
  public boolean b;
  public boolean c;
  private String d = HardCodeUtil.a(2131903353);
  private boolean e;
  private String i;
  private ISearchResultGroupModel j;
  private boolean k;
  private boolean l;
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel)
  {
    boolean bool = true;
    this.b = true;
    this.c = false;
    this.j = paramISearchResultGroupModel;
    this.a = paramISearchResultGroupModel.a();
    if (paramISearchResultGroupModel.b() != null)
    {
      if (paramISearchResultGroupModel.b().size() <= paramISearchResultGroupModel.d()) {
        bool = false;
      }
      this.e = bool;
    }
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, String paramString, boolean paramBoolean)
  {
    this.b = true;
    this.c = false;
    this.j = paramISearchResultGroupModel;
    if (TextUtils.isEmpty(paramString)) {
      this.a = paramISearchResultGroupModel.a();
    } else {
      this.a = paramString;
    }
    this.e = paramBoolean;
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = true;
    this.c = false;
    this.j = paramISearchResultGroupModel;
    this.a = paramISearchResultGroupModel.a();
    this.e = paramBoolean1;
    this.k = paramBoolean2;
  }
  
  public GroupSearchModeTitle(String paramString1, String paramString2, String paramString3)
  {
    this.b = true;
    this.c = false;
    this.a = paramString1;
    this.d = paramString2;
    this.i = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.d = HardCodeUtil.a(2131903358);
    }
    this.e = (TextUtils.isEmpty(paramString3) ^ true);
  }
  
  private void a(SearchInfoInterface paramSearchInfoInterface)
  {
    if (paramSearchInfoInterface != null)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        if (!(localObject instanceof GroupBaseNetSearchModel)) {
          return;
        }
        localObject = (GroupBaseNetSearchModel)localObject;
        if (SearchUtils.a(((GroupBaseNetSearchModel)localObject).a))
        {
          int m;
          if ((!TextUtils.isEmpty(this.i)) && ((this.i.startsWith("http://")) || (this.i.startsWith("https://")))) {
            m = 0;
          } else {
            m = 1;
          }
          String str1 = paramSearchInfoInterface.h();
          paramSearchInfoInterface = new StringBuilder();
          paramSearchInfoInterface.append("");
          paramSearchInfoInterface.append(h());
          String str2 = paramSearchInfoInterface.toString();
          if (m != 0) {
            paramSearchInfoInterface = "1";
          } else {
            paramSearchInfoInterface = "0";
          }
          SearchUtils.a("all_result", "more_object", new String[] { str1, str2, paramSearchInfoInterface });
        }
        if ((!TextUtils.isEmpty(((GroupBaseNetSearchModel)localObject).g())) && (((GroupBaseNetSearchModel)localObject).g().contains("opencirclesearch")))
        {
          paramSearchInfoInterface = new HashMap();
          paramSearchInfoInterface.put("ext6", c());
          if ((((GroupBaseNetSearchModel)localObject).c != null) && (((GroupBaseNetSearchModel)localObject).c.size() > 0) && ((((GroupBaseNetSearchModel)localObject).c.get(0) instanceof NetSearchTemplateHorizontalOneItem)))
          {
            localObject = (NetSearchTemplateHorizontalOneItem)((GroupBaseNetSearchModel)localObject).c.get(0);
            if (((NetSearchTemplateHorizontalOneItem)localObject).B == 6) {
              paramSearchInfoInterface.put("ext8", "1");
            } else if (((NetSearchTemplateHorizontalOneItem)localObject).B == 5) {
              paramSearchInfoInterface.put("ext8", "2");
            }
          }
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(73).setSubActionType(2).setThrActionType(2).setExtras(paramSearchInfoInterface));
          UniteSearchReportController.a(null, 0, UniteSearchActivity.f, "0X800BA25", 0, 0, null, null);
        }
      }
    }
  }
  
  private void l()
  {
    if (this.l) {
      return;
    }
    this.l = true;
    if (!this.e) {
      return;
    }
    Object localObject1 = this.j.b();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ISearchResultModel)((Iterator)localObject1).next();
      if ((localObject2 instanceof NetSearchTemplateMiniAppItem))
      {
        UniteSearchReportController.a(null, 0, ((NetSearchTemplateMiniAppItem)localObject2).p, "0X8009D46", 0, 0, null, null);
        return;
      }
      if ((localObject2 instanceof NetSearchTemplateBaseItem))
      {
        localObject2 = (NetSearchTemplateBaseItem)localObject2;
        if (((NetSearchTemplateBaseItem)localObject2).i == 1003L) {
          UniteSearchReportController.a(null, 0, ((NetSearchTemplateBaseItem)localObject2).p, "0X8009D52", 0, 0, null, null);
        }
      }
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((localContext instanceof SearchInfoInterface))
    {
      localObject1 = (SearchInfoInterface)localContext;
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int m = ((SearchInfoInterface)localObject1).i();
      Object localObject4;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            break label483;
          }
          localObject2 = ((SearchInfoInterface)localObject1).h();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(((SearchInfoInterface)localObject1).j());
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(a(1));
          SearchUtils.a("sub_result", "more_result", new String[] { localObject2, localObject3, ((StringBuilder)localObject4).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject1).j()) });
          break label483;
        }
      }
      else
      {
        if ((this.j instanceof GroupBaseNetSearchModel)) {
          a((SearchInfoInterface)localObject1);
        }
        if (!SearchUtil.a)
        {
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject2).put("event_src", "client");
            ((JSONObject)localObject2).put("get_src", "web");
          }
          catch (JSONException localJSONException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("e = ");
            ((StringBuilder)localObject4).append(localJSONException);
            QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, ((StringBuilder)localObject4).toString());
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject4 = new ReportModelDC02528().module("all_result").action("clk_more");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(h());
          localStringBuilder.append("");
          localObject2 = ((ReportModelDC02528)localObject4).obj1(localStringBuilder.toString()).ver1(((SearchInfoInterface)localObject1).h()).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(((JSONObject)localObject2).toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localQQAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject4).append(SearchUtils.j);
          UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject4).toString()));
        }
      }
      SearchUtils.a("all_result", "clk_tab_more", new String[] { c(), SearchUtils.a(((SearchInfoInterface)localObject1).j()), "", SearchUtils.a("dynamic_unite_search.1", ((SearchInfoInterface)localObject1).j()) });
    }
    label483:
    Object localObject1 = this.j;
    if (localObject1 != null)
    {
      ((ISearchResultGroupModel)localObject1).a(paramView);
      return;
    }
    if (this.e) {
      localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(this.i)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public List<ISearchResultModel> b()
  {
    return null;
  }
  
  public String c()
  {
    ISearchResultGroupModel localISearchResultGroupModel = this.j;
    if (localISearchResultGroupModel != null) {
      return localISearchResultGroupModel.c();
    }
    return null;
  }
  
  public int d()
  {
    return 3;
  }
  
  public void dl_()
  {
    super.dl_();
    l();
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public String g()
  {
    String str2 = this.d;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public long h()
  {
    ISearchResultGroupModel localISearchResultGroupModel = this.j;
    if (localISearchResultGroupModel != null)
    {
      int m = SearchUtil.a(localISearchResultGroupModel);
      if (m > 0) {
        return m;
      }
    }
    localISearchResultGroupModel = this.j;
    if ((localISearchResultGroupModel != null) && ((localISearchResultGroupModel instanceof GroupBaseNetSearchModel))) {
      return ((GroupBaseNetSearchModel)localISearchResultGroupModel).a;
    }
    return -1L;
  }
  
  public int i()
  {
    ISearchResultGroupModel localISearchResultGroupModel = this.j;
    if ((localISearchResultGroupModel instanceof GroupBaseNetSearchModel))
    {
      if (SearchUtils.a(((GroupBaseNetSearchModel)localISearchResultGroupModel).a)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public ISearchResultGroupModel k()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModeTitle
 * JD-Core Version:    0.7.0.1
 */