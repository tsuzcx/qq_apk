package com.tencent.mobileqq.search.model;

import SummaryCard.SearchInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;
import pb.unite.search.DynamicSearch.SubItem;

public class NetSearchTemplateBaseItem
  extends ISearchResultPositionModel
{
  public static final String c;
  private int jdField_a_of_type_Int;
  public long a;
  public NetSearchTemplateBaseItem.ImageInfo a;
  public HighlightModel a;
  private String jdField_a_of_type_JavaLangString;
  public DynamicSearch.ResultItem a;
  public boolean a;
  public int b;
  public List b;
  public int c;
  public List c;
  public String d;
  public List d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    jdField_c_of_type_JavaLangString = "Q.uniteSearch." + NetSearchTemplateBaseItem.class.getName();
  }
  
  public NetSearchTemplateBaseItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.jdField_d_of_type_JavaLangString = paramResultItem.result_id.get().toStringUtf8();
      this.jdField_a_of_type_Int = paramResultItem.layout_id.get();
      this.h = paramResultItem.extension.get().toStringUtf8();
      this.jdField_a_of_type_JavaLangString = paramResultItem.layout_content.get().toStringUtf8();
      this.e = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_c_of_type_JavaUtilList = paramResultItem.sub_item_list.get();
      this.jdField_d_of_type_JavaUtilList = paramResultItem.sub_result_items.get();
      this.f = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_PbUniteSearchDynamicSearch$ResultItem = paramResultItem;
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.g = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel = new HighlightModel(paramList, b());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public CharSequence a()
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    Object localObject3 = this.e;
    SearchUtil.ObjectItemInfo localObjectItemInfo;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (SearchUtil.c.containsKey(this))
    {
      localObjectItemInfo = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("tepl", this.f);
      Object localObject1 = "clk_item";
      if ((this instanceof NetSearchTemplateSubItemTitle)) {
        localObject1 = "clk_more";
      }
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action((String)localObject1).obj1(this.jdField_a_of_type_Long + "").obj2(localObjectItemInfo.jdField_b_of_type_JavaLangString).ver1(this.g).ver2(UniteSearchReportController.a(this.jdField_b_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      if (SearchUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(this))
      {
        localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.jdField_a_of_type_JavaUtilHashMap.get(this);
        if (((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_Boolean)
        {
          j = 2;
          SearchUtils.a("all_result", "clk_object", j, 0, new String[] { this.g, "" + this.jdField_a_of_type_Long, ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString + "", ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int + "" });
        }
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label496;
        }
        localObject1 = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject3);
        if (localObject1 == null) {
          break label433;
        }
        ((JumpAction)localObject1).b();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      label433:
      label496:
      do
      {
        for (;;)
        {
          QLog.e(jdField_c_of_type_JavaLangString, 2, "e = " + localJSONException);
          continue;
          int j = 1;
        }
        Object localObject2;
        if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
        {
          QZoneHelper.a((String)localObject3);
          paramView = paramView.getContext();
          localObject2 = new Intent(paramView, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject3);
          paramView.startActivity((Intent)localObject2);
          return;
        }
        if (this.jdField_a_of_type_Long == 268435456L)
        {
          SearchUtils.a(paramView.getContext(), Integer.valueOf(this.jdField_d_of_type_JavaLangString).intValue(), -1);
          return;
        }
        if (this.jdField_a_of_type_Long == 1001L)
        {
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject3 = new SearchInfo();
          ((SearchInfo)localObject3).lUIN = Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue();
          ((SearchInfo)localObject3).strNick = a().toString();
          AddFriendActivity.a((Activity)paramView.getContext(), (SearchInfo)localObject3, ((QQAppInterface)localObject2).getCurrentAccountUin(), null, true, 1);
          return;
        }
        if (this.jdField_a_of_type_Long == 536870912L)
        {
          long l2 = 0L;
          try
          {
            l1 = Long.valueOf(new JSONObject(this.h).optString("proid")).longValue();
            StoryApi.a(paramView.getContext(), 24, l1);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.e(jdField_c_of_type_JavaLangString, 2, localException, new Object[0]);
                l1 = l2;
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Long != 1002L);
      Bundle localBundle = TroopInfoActivity.a(this.jdField_d_of_type_JavaLangString, 2);
      localBundle.putInt("exposureSource", 3);
      localBundle.putInt("t_s_f", 1000);
      ChatSettingForTroop.a(paramView.getContext(), localBundle, 2);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(List paramList)
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      int j = 0;
      while (j < this.jdField_c_of_type_JavaUtilList.size())
      {
        DynamicSearch.SubItem localSubItem = (DynamicSearch.SubItem)this.jdField_c_of_type_JavaUtilList.get(j);
        if (SearchUtils.a(localSubItem)) {
          paramList.add(new SearchResultModelForEntrance(this.g, this.jdField_a_of_type_Long, localSubItem));
        }
        j += 1;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo = new NetSearchTemplateBaseItem.ImageInfo(this);
    int j = paramJSONObject.optInt("imageType");
    this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
    this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_Int = a(j);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_b_of_type_Int = paramJSONObject.optInt("cornerRadius");
    NetSearchTemplateBaseItem.ImageInfo localImageInfo = this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo;
    if (paramJSONObject.optInt("needPlayIcon") == 1) {}
    for (;;)
    {
      localImageInfo.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_JavaLangCharSequence = paramJSONObject.optString("topLeftTagText");
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("topLeftTagColor");
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_b_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightText");
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("bottomRightIconUrl");
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightIconText");
      return;
      bool = false;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public int e()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 5: 
    default: 
      throw new RuntimeException(this.jdField_a_of_type_Int + "in NetSearchTemplateBaseItem.getLayoutId() is not supported!!!");
    case 2: 
      return 2130969394;
    case 3: 
      return 2130969404;
    case 4: 
      return 2130969395;
    case 6: 
      return 2130969403;
    case 7: 
      return 2130969396;
    case 8: 
      return 2130969401;
    }
    return 2130969402;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem
 * JD-Core Version:    0.7.0.1
 */