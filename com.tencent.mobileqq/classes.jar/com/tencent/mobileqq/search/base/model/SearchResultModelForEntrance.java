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
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public SearchResultModelForEntrance(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public SearchResultModelForEntrance(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
    a();
  }
  
  private void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("extension info:");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("Q.uniteSearch.SearchResultModelForEntrance", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.d)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.d);
        if (((JSONObject)localObject).getInt("hideArrow") != 0) {
          break label128;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        this.e = ((JSONObject)localObject).optString("title1");
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("title2");
        this.f = ((JSONObject)localObject).optString("title3");
        this.g = ((JSONObject)localObject).optString("secondLine");
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
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != -4)
    {
      if (i != -1) {
        return "";
      }
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      return SearchEntryConfigManager.a(MobileQQ.sMobileQQ, localAppInterface.getCurrentUin());
    }
    return this.g;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject1 = "";
    Object localObject2;
    StringBuilder localStringBuilder;
    if ((i != -4) && (i != -3))
    {
      if (i != -1)
      {
        localObject1 = this.jdField_b_of_type_JavaLangString;
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
        ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToActiveEntitySearchActivity(paramView.getContext(), this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131713565), new long[] { 1001L, 1002L });
        SearchUtils.a("all_result", "clk_people_group", new String[] { this.jdField_a_of_type_JavaLangString });
        SearchUtils.a("all_search", "all_result", "clk_user_grp", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, "" });
        if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
        {
          if (SearchUtils.b.containsKey(this))
          {
            paramView = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
            localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("project", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
              ((JSONObject)localObject2).put("event_src", "client");
              ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
              ((JSONObject)localObject2).put("get_src", "native");
            }
            catch (JSONException localJSONException1)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("e = ");
              localStringBuilder.append(localJSONException1);
              QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, localStringBuilder.toString());
            }
            ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportRuntimeDC02528((AppInterface)localObject1, paramView.jdField_a_of_type_Long, paramView.jdField_b_of_type_JavaLangString, paramView.jdField_a_of_type_JavaLangString, (JSONObject)localObject2);
          }
          ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, this.v, 0, "0X8009D3F", 0, 0, null, null);
        }
      }
    }
    else
    {
      localObject2 = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getJumpUrl(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("url", localObject2);
        localHashMap.put("search_title", this.jdField_a_of_type_JavaLangString);
        ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(paramView.getContext(), localHashMap);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      SearchUtils.a("all_result", "clk_net_search", new String[] { localObject1 });
      if ((((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) && (SearchUtils.b.containsKey(this)))
      {
        paramView = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
        localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("project", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
          ((JSONObject)localObject2).put("get_src", "web");
        }
        catch (JSONException localJSONException2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(localJSONException2);
          QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, localStringBuilder.toString());
        }
        ((ISearchReportFetcher)QRoute.api(ISearchReportFetcher.class)).onReportRuntimeDC02528((AppInterface)localObject1, paramView.jdField_a_of_type_Long, paramView.jdField_b_of_type_JavaLangString, paramView.jdField_a_of_type_JavaLangString, (JSONObject)localObject2);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public CharSequence b()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != -4)
    {
      if (i != -1) {
        return HardCodeUtil.a(2131713580);
      }
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.e;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int d()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i != -4) && (i != -3)) {
      return 2131559800;
    }
    return 2131559793;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance
 * JD-Core Version:    0.7.0.1
 */