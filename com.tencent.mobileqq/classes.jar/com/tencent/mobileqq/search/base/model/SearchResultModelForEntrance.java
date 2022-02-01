package com.tencent.mobileqq.search.base.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchResultModelForEntrance
  extends ISearchResultPositionModel
{
  public String a;
  public String b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public boolean k = true;
  private String l;
  private String m;
  
  public SearchResultModelForEntrance(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    this.k = paramBoolean;
    m();
  }
  
  public SearchResultModelForEntrance(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a = paramString1;
    this.f = paramString2;
    this.c = paramInt;
    this.e = paramString3;
    o();
    m();
  }
  
  private void o()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("extension info:");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("Q.uniteSearch.SearchResultModelForEntrance", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.f)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.f);
        if (((JSONObject)localObject).getInt("hideArrow") != 0) {
          break label128;
        }
        bool = true;
        this.k = bool;
        this.g = ((JSONObject)localObject).optString("title1");
        this.a = ((JSONObject)localObject).optString("title2");
        this.h = ((JSONObject)localObject).optString("title3");
        this.i = ((JSONObject)localObject).optString("secondLine");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label128:
      boolean bool = false;
    }
  }
  
  public CharSequence a()
  {
    int n = this.c;
    if (n != -4)
    {
      if (n != -1) {
        return "";
      }
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      return SearchEntryConfigManager.b(MobileQQ.sMobileQQ, localAppInterface.getCurrentUin());
    }
    return this.i;
  }
  
  public void a(View paramView)
  {
    int n = this.c;
    Object localObject1 = "";
    Object localObject2;
    StringBuilder localStringBuilder;
    if ((n != -4) && (n != -3))
    {
      if (n != -1)
      {
        localObject1 = this.b;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = JumpParser.a((BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), paramView.getContext(), (String)localObject1);
          if (localObject2 != null)
          {
            ((JumpAction)localObject2).a();
            return;
          }
          if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("url", localObject1);
            ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(paramView.getContext(), (Map)localObject2);
          }
        }
      }
      else
      {
        ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToActiveEntitySearchActivity(paramView.getContext(), this.a, HardCodeUtil.a(2131911111), new long[] { 1001L, 1002L, 1107L });
        SearchUtils.a("all_result", "clk_people_group", new String[] { this.a });
        SearchUtils.a("all_search", "all_result", "clk_user_grp", 0, 0, new String[] { "", "", this.a, "" });
        if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
        {
          if (SearchUtils.l.containsKey(this))
          {
            paramView = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
            localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("project", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
              ((JSONObject)localObject2).put("event_src", "client");
              ((JSONObject)localObject2).put("obj_lct", paramView.c);
              ((JSONObject)localObject2).put("get_src", "native");
            }
            catch (JSONException localJSONException1)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("e = ");
              localStringBuilder.append(localJSONException1);
              QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, localStringBuilder.toString());
            }
            ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportRuntimeDC02528((AppInterface)localObject1, paramView.b, paramView.e, paramView.a, (JSONObject)localObject2);
          }
          ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, this.ah, 0, "0X8009D3F", 0, 0, null, null);
        }
      }
    }
    else
    {
      localObject2 = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getJumpUrl(paramView.getContext(), this.a, this.b);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("url", localObject2);
        localHashMap.put("search_title", this.a);
        ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(paramView.getContext(), localHashMap);
      }
      if (!TextUtils.isEmpty(this.a)) {
        localObject1 = this.a;
      }
      SearchUtils.a("all_result", "clk_net_search", new String[] { localObject1 });
      if ((((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) && (SearchUtils.l.containsKey(this)))
      {
        paramView = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
        localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("project", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("obj_lct", paramView.c);
          ((JSONObject)localObject2).put("get_src", "web");
        }
        catch (JSONException localJSONException2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(localJSONException2);
          QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, localStringBuilder.toString());
        }
        ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportRuntimeDC02528((AppInterface)localObject1, paramView.b, paramView.e, paramView.a, (JSONObject)localObject2);
      }
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public String c()
  {
    return null;
  }
  
  public CharSequence d()
  {
    int n = this.c;
    if (n != -4)
    {
      if (n != -1) {
        return HardCodeUtil.a(2131911125);
      }
      return this.a;
    }
    return this.g;
  }
  
  public CharSequence e()
  {
    return this.a;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.l;
  }
  
  public boolean h()
  {
    return this.k;
  }
  
  public boolean i()
  {
    return this.c == -1;
  }
  
  public int j()
  {
    int n = this.c;
    if ((n != -4) && (n != -3)) {
      return 2131625843;
    }
    return 2131625836;
  }
  
  protected void m()
  {
    if (this.c == -1) {
      f(8);
    }
  }
  
  public void m_(String paramString)
  {
    this.l = paramString;
  }
  
  public String n()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance
 * JD-Core Version:    0.7.0.1
 */