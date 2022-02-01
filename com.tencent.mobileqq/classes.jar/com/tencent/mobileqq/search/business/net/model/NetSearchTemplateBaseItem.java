package com.tencent.mobileqq.search.business.net.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateBaseItem
  extends ISearchResultPositionModel
{
  public static final String c;
  private int jdField_a_of_type_Int;
  public long a;
  public NetSearchTemplateBaseItem.ImageInfo a;
  public HighlightModel a;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private List<Object> jdField_a_of_type_JavaUtilList;
  public boolean a;
  public List<String> b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.uniteSearch.");
    localStringBuilder.append(NetSearchTemplateBaseItem.class.getName());
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public NetSearchTemplateBaseItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.d = paramResultItem.result_id.get().toStringUtf8();
      this.jdField_a_of_type_Int = paramResultItem.layout_id.get();
      this.h = paramResultItem.extension.get().toStringUtf8();
      this.jdField_a_of_type_JavaLangString = paramResultItem.layout_content.get().toStringUtf8();
      this.e = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.jdField_a_of_type_Long = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.addAll(paramResultItem.sub_result_items.get());
      }
      this.f = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramResultItem;
    this.b = paramList;
    this.g = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel = new HighlightModel(paramList, b());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public NetSearchTemplateBaseItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.d = paramResultItem.result_id.get().toStringUtf8();
      this.jdField_a_of_type_Int = paramResultItem.layout_id.get();
      this.h = paramResultItem.extension.get().toStringUtf8();
      this.jdField_a_of_type_JavaLangString = paramResultItem.layout_content.get().toStringUtf8();
      this.e = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.jdField_a_of_type_Long = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.addAll(paramResultItem.sub_result_items.get());
      }
      this.f = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramResultItem;
    this.b = paramList;
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
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(View paramView)
  {
    Object localObject2 = this.e;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Object localObject6;
    Object localObject1;
    if (SearchUtils.b.containsKey(this))
    {
      localObject4 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
      localObject3 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      localObject5 = new JSONObject();
      try
      {
        ((JSONObject)localObject5).put("project", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
        ((JSONObject)localObject5).put("event_src", "client");
        ((JSONObject)localObject5).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_Int);
        ((JSONObject)localObject5).put("get_src", "web");
        ((JSONObject)localObject5).put("tepl", this.f);
      }
      catch (JSONException localJSONException)
      {
        localObject6 = jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e((String)localObject6, 2, localStringBuilder.toString());
      }
      if ((this instanceof NetSearchTemplateSubItemTitle)) {
        localObject1 = "clk_more";
      } else {
        localObject1 = "clk_item";
      }
      localObject1 = new ReportModelDC02528().module("all_result").action((String)localObject1);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject6).append("");
      localObject1 = ((ReportModelDC02528)localObject1).obj1(((StringBuilder)localObject6).toString()).obj2(((SearchUtils.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString).ver1(this.g).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver7(((JSONObject)localObject5).toString());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((AppInterface)localObject3).getCurrentAccountUin());
      ((StringBuilder)localObject4).append(SearchUtils.d);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject4).toString()));
    }
    if (SearchUtils.a.containsKey(this))
    {
      localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.a.get(this);
      int j;
      if (((SearchUtils.ObjectItemInfo)localObject1).jdField_b_of_type_Boolean) {
        j = 2;
      } else {
        j = 1;
      }
      localObject3 = this.g;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_Long);
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(((SearchUtils.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
      ((StringBuilder)localObject6).append("");
      SearchUtils.a("all_result", "clk_object", j, 0, new String[] { localObject3, localObject4, localObject5, ((StringBuilder)localObject6).toString() });
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = JumpParser.a((BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), paramView.getContext(), (String)localObject2);
      if (localObject1 != null)
      {
        ((JumpAction)localObject1).a();
        return;
      }
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        if (((String)localObject2).startsWith("tel://"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tel:");
          ((StringBuilder)localObject1).append(((String)localObject2).substring(6));
          localObject1 = new Intent("android.intent.action.DIAL", Uri.parse(((StringBuilder)localObject1).toString()));
          paramView.getContext().startActivity((Intent)localObject1);
        }
      }
      else
      {
        QZoneHelper.reportIfIsFromQZone((String)localObject2);
        paramView = paramView.getContext();
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("url", localObject2);
        ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(paramView, (Map)localObject1);
        return;
      }
    }
    long l1 = this.jdField_a_of_type_Long;
    if (l1 == 268435456L)
    {
      SearchUtils.a(paramView.getContext(), Integer.valueOf(this.d).intValue(), -1);
      return;
    }
    if (l1 == 1001L)
    {
      localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      localObject2 = new SearchResultItem();
      ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.d).longValue();
      ((SearchResultItem)localObject2).jdField_a_of_type_JavaLangString = b().toString();
      ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity((Activity)paramView.getContext(), (SearchResultItem)localObject2, (AppInterface)localObject1, true, 1);
      return;
    }
    if (l1 == 536870912L)
    {
      long l2 = 0L;
      try
      {
        l1 = Long.valueOf(new JSONObject(this.h).optString("proid")).longValue();
      }
      catch (Exception localException)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_c_of_type_JavaLangString, 2, localException, new Object[0]);
          l1 = l2;
        }
      }
      ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToStoryProfileActivity(paramView.getContext(), ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getQQStoryDynamicSearch(), l1);
      return;
    }
    if (l1 == 1002L)
    {
      Bundle localBundle = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopProfileExtra(this.d, 2);
      localBundle.putInt("exposureSource", 3);
      localBundle.putInt("t_s_f", 1000);
      ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToTroopInfoActivity(paramView.getContext(), localBundle, 2);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo = new NetSearchTemplateBaseItem.ImageInfo(this);
    int j = paramJSONObject.optInt("imageType");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_Int = a(j);
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_b_of_type_Int = paramJSONObject.optInt("cornerRadius");
    NetSearchTemplateBaseItem.ImageInfo localImageInfo = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo;
    j = paramJSONObject.optInt("needPlayIcon");
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    localImageInfo.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_JavaLangCharSequence = paramJSONObject.optString("topLeftTagText");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("topLeftTagColor");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_b_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightText");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("bottomRightIconUrl");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightIconText");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.d = paramJSONObject.optInt("imageHeight");
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_Int = paramJSONObject.optInt("imageWidth");
  }
  
  public boolean a()
  {
    return false;
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
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public int e()
  {
    int k = this.jdField_a_of_type_Int;
    int j = 2131559817;
    switch (k)
    {
    case 5: 
    case 10: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("in NetSearchTemplateBaseItem.getLayoutId() is not supported!!!");
      throw new RuntimeException(localStringBuilder.toString());
    case 18: 
      return 2131562786;
    case 17: 
      return 2131561422;
    case 16: 
      return 2131559804;
    case 15: 
      return 2131559824;
    case 14: 
      return 2131559828;
    case 13: 
      return 2131559819;
    case 12: 
      return 2131559815;
    case 11: 
      return 2131559816;
    case 9: 
      return 2131559827;
    case 8: 
      return 2131559826;
    case 6: 
      return 2131559829;
    case 4: 
      return 2131559814;
    case 3: 
      return 2131559830;
    case 2: 
      j = 2131559813;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem
 * JD-Core Version:    0.7.0.1
 */