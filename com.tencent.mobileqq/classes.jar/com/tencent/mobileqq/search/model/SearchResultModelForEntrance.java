package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.SubItem;
import pb.unite.search.DynamicSearch.SubItemText;

public class SearchResultModelForEntrance
  extends ISearchResultPositionModel
{
  public int a;
  public long a;
  public String a;
  public List a;
  public DynamicSearch.SubItem a;
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
  
  public SearchResultModelForEntrance(String paramString, long paramLong, DynamicSearch.SubItem paramSubItem)
  {
    this.jdField_a_of_type_Boolean = true;
    this.h = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem = paramSubItem;
    this.jdField_a_of_type_Int = paramSubItem.layout_id.get();
  }
  
  public SearchResultModelForEntrance(String paramString1, String paramString2, int paramInt, String paramString3, List paramList)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public SearchResultModelForEntrance(DynamicSearch.SubItem paramSubItem)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem = paramSubItem;
    this.jdField_a_of_type_Int = paramSubItem.layout_id.get();
  }
  
  public SearchResultModelForEntrance(DynamicSearch.SubItem paramSubItem, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem = paramSubItem;
    this.jdField_a_of_type_Int = paramSubItem.layout_id.get();
    this.jdField_a_of_type_Long = paramLong;
    this.h = paramString;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchResultModelForEntrance", 2, "extension info:" + this.d);
    }
    if (!TextUtils.isEmpty(this.d)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.d);
      if (localJSONObject.getInt("hideArrow") == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.e = localJSONObject.optString("title1");
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString("title2");
        this.f = localJSONObject.optString("title3");
        this.g = localJSONObject.optString("secondLine");
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case -3: 
    case -2: 
    default: 
      return "搜索:";
    case -4: 
      return this.e;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    case -2: 
    default: 
      localObject1 = this.jdField_b_of_type_JavaLangString;
      if ((this.jdField_b_of_type_JavaLangString != null) || (this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem == null) || (!this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.jump_url.has())) {
        break label1038;
      }
      localObject1 = this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.jump_url.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject1);
        if (localObject2 == null) {
          break label889;
        }
        ((JumpAction)localObject2).b();
      }
      if (this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem != null)
      {
        paramView = new StringBuilder();
        i = 0;
        while (i < this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.title.size())
        {
          paramView.append(((DynamicSearch.SubItemText)this.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.title.get(i)).text.get().toStringUtf8());
          paramView.append(":");
          i += 1;
        }
      }
    case -1: 
      label119:
      ActiveEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, "人和群", new long[] { 1001L, 1002L });
      SearchUtils.a("all_result", "clk_people_group", new String[] { this.jdField_a_of_type_JavaLangString });
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtil.c.containsKey(this)))
      {
        paramView = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("get_src", "native");
        UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(paramView.jdField_b_of_type_JavaLangString).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + localJSONException1);
        }
      }
    }
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      switch (((UniteSearchActivity)paramView.getContext()).jdField_a_of_type_Int)
      {
      }
    }
    for (int i = 0;; i = 0)
    {
      for (;;)
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localObject1 = SearchConfigUtils.a(this.jdField_a_of_type_JavaLangString, i, "group");
          label540:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            ((Intent)localObject2).putExtra("search_title", this.jdField_a_of_type_JavaLangString);
            paramView.getContext().startActivity((Intent)localObject2);
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label850;
          }
          localObject1 = this.jdField_a_of_type_JavaLangString;
          SearchUtils.a("all_result", "clk_net_search", new String[] { localObject1 });
          if ((!(paramView.getContext() instanceof UniteSearchActivity)) || (!SearchUtil.c.containsKey(this))) {
            break;
          }
          paramView = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
          ((JSONObject)localObject2).put("get_src", "web");
          UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(paramView.jdField_b_of_type_JavaLangString).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
          return;
          i = 1;
          continue;
          i = 2;
          continue;
          i = 3;
          continue;
          localObject1 = this.jdField_b_of_type_JavaLangString;
          break label540;
          label850:
          localObject1 = "";
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + localJSONException2);
          }
        }
      }
      label889:
      if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {
        break label119;
      }
      paramView = paramView.getContext();
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      break label119;
      SearchUtils.a("sub_result", "clk_custom", new String[] { this.h + "", this.jdField_a_of_type_Long + "", this.jdField_a_of_type_Int + "" });
      return;
      label1038:
      break;
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        DynamicSearch.SubItem localSubItem = (DynamicSearch.SubItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if (SearchUtils.a(localSubItem)) {
          paramList.add(new SearchResultModelForEntrance(localSubItem));
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    default: 
      return 2130969381;
    case -1: 
      return 2130969382;
    case -2: 
      return 2130969380;
    case -4: 
    case -3: 
      return 2130969376;
    case 2: 
      return 2130969385;
    case 3: 
      return 2130969386;
    }
    return 2130969384;
  }
  
  public CharSequence b()
  {
    return this.jdField_a_of_type_JavaLangString;
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
    switch (this.jdField_a_of_type_Int)
    {
    case -3: 
    case -2: 
    default: 
      return "";
    case -1: 
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return SearchEntryConfigManager.a(BaseApplicationImpl.getContext(), localQQAppInterface.c());
    }
    return this.g;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchResultModelForEntrance
 * JD-Core Version:    0.7.0.1
 */