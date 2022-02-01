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
  public static final String g;
  private int a;
  private String b;
  private Object c;
  private List<Object> d;
  private boolean e;
  public String h;
  public long i;
  public String j;
  public List<String> k;
  public String l;
  public String m;
  public HighlightModel n;
  public String o;
  public int p;
  public NetSearchTemplateBaseItem.ImageInfo q;
  public boolean r;
  public String s;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.uniteSearch.");
    localStringBuilder.append(NetSearchTemplateBaseItem.class.getName());
    g = localStringBuilder.toString();
  }
  
  public NetSearchTemplateBaseItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.h = paramResultItem.result_id.get().toStringUtf8();
      this.a = paramResultItem.layout_id.get();
      this.o = paramResultItem.extension.get().toStringUtf8();
      this.b = paramResultItem.layout_content.get().toStringUtf8();
      this.j = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.i = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.d = new ArrayList();
        this.d.addAll(paramResultItem.sub_result_items.get());
      }
      this.l = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.p = paramInt;
    this.c = paramResultItem;
    this.k = paramList;
    this.m = paramString;
    this.n = new HighlightModel(paramList, g());
    if (!TextUtils.isEmpty(this.b)) {
      o_(this.b);
    }
    a(false);
  }
  
  public NetSearchTemplateBaseItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.h = paramResultItem.result_id.get().toStringUtf8();
      this.a = paramResultItem.layout_id.get();
      this.o = paramResultItem.extension.get().toStringUtf8();
      this.b = paramResultItem.layout_content.get().toStringUtf8();
      this.j = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.i = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.d = new ArrayList();
        this.d.addAll(paramResultItem.sub_result_items.get());
      }
      this.l = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.p = paramInt;
    this.c = paramResultItem;
    this.k = paramList;
    this.m = paramString;
    this.n = new HighlightModel(paramList, g());
    if (!TextUtils.isEmpty(this.b)) {
      o_(this.b);
    }
    a(false);
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public CharSequence a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Object localObject2 = this.j;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Object localObject6;
    Object localObject1;
    if (SearchUtils.l.containsKey(this))
    {
      localObject4 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
      localObject3 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      localObject5 = new JSONObject();
      try
      {
        ((JSONObject)localObject5).put("project", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
        ((JSONObject)localObject5).put("event_src", "client");
        ((JSONObject)localObject5).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject4).c);
        ((JSONObject)localObject5).put("get_src", "web");
        ((JSONObject)localObject5).put("tepl", this.l);
      }
      catch (JSONException localJSONException)
      {
        localObject6 = g;
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
      ((StringBuilder)localObject6).append(this.i);
      ((StringBuilder)localObject6).append("");
      localObject1 = ((ReportModelDC02528)localObject1).obj1(((StringBuilder)localObject6).toString()).obj2(((SearchUtils.ObjectItemInfo)localObject4).e).ver1(this.m).ver2(UniteSearchReportController.a(this.p)).ver7(((JSONObject)localObject5).toString());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((AppInterface)localObject3).getCurrentAccountUin());
      ((StringBuilder)localObject4).append(SearchUtils.j);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject4).toString()));
    }
    if (SearchUtils.k.containsKey(this))
    {
      localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.k.get(this);
      int i1;
      if (((SearchUtils.ObjectItemInfo)localObject1).f) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      localObject3 = this.m;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(this.i);
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(((SearchUtils.ObjectItemInfo)localObject1).e);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(((SearchUtils.ObjectItemInfo)localObject1).c);
      ((StringBuilder)localObject6).append("");
      SearchUtils.a("all_result", "clk_object", i1, 0, new String[] { localObject3, localObject4, localObject5, ((StringBuilder)localObject6).toString() });
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
    long l1 = this.i;
    if (l1 == 268435456L)
    {
      SearchUtils.a(paramView.getContext(), Integer.valueOf(this.h).intValue(), -1);
      return;
    }
    if (l1 == 1001L)
    {
      localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      localObject2 = new SearchResultItem();
      ((SearchResultItem)localObject2).a = Long.valueOf(this.h).longValue();
      ((SearchResultItem)localObject2).c = d().toString();
      ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity((Activity)paramView.getContext(), (SearchResultItem)localObject2, (AppInterface)localObject1, true, 1);
      return;
    }
    if (l1 == 536870912L)
    {
      long l2 = 0L;
      try
      {
        l1 = Long.valueOf(new JSONObject(this.o).optString("proid")).longValue();
      }
      catch (Exception localException)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e(g, 2, localException, new Object[0]);
          l1 = l2;
        }
      }
      ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToStoryProfileActivity(paramView.getContext(), ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getQQStoryDynamicSearch(), l1);
      return;
    }
    if (l1 == 1002L)
    {
      Bundle localBundle = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopProfileExtra(this.h, 2);
      localBundle.putInt("exposureSource", 3);
      localBundle.putInt("t_s_f", 1000);
      ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToTroopInfoActivity(paramView.getContext(), localBundle, 2);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.q = new NetSearchTemplateBaseItem.ImageInfo(this);
    int i1 = paramJSONObject.optInt("imageType");
    this.q.b = paramJSONObject.optString("imageUrl");
    this.q.a = a(i1);
    this.q.c = paramJSONObject.optInt("cornerRadius");
    NetSearchTemplateBaseItem.ImageInfo localImageInfo = this.q;
    i1 = paramJSONObject.optInt("needPlayIcon");
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    localImageInfo.d = bool;
    this.q.e = paramJSONObject.optString("topLeftTagText");
    this.q.f = paramJSONObject.optString("topLeftTagColor");
    this.q.g = paramJSONObject.optString("bottomRightText");
    this.q.h = paramJSONObject.optString("bottomRightIconUrl");
    this.q.i = paramJSONObject.optString("bottomRightIconText");
    this.q.k = paramJSONObject.optInt("imageHeight");
    this.q.j = paramJSONObject.optInt("imageWidth");
  }
  
  protected void a(boolean paramBoolean)
  {
    long l1 = this.i;
    if (l1 == 1003L)
    {
      f(17);
      if (q()) {
        f(5);
      }
    }
    else
    {
      if (l1 == 1106L)
      {
        f(14);
        return;
      }
      if (l1 == 1101L)
      {
        f(19);
        return;
      }
      if (l1 == 1100L)
      {
        f(10);
        if (paramBoolean) {
          f(1);
        }
      }
      else if (l1 == 1105L)
      {
        f(18);
      }
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.m;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public Object j()
  {
    return this.c;
  }
  
  public int m()
  {
    return this.a;
  }
  
  public int n()
  {
    int i2 = this.a;
    int i1 = 2131625860;
    switch (i2)
    {
    case 5: 
    case 10: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("in NetSearchTemplateBaseItem.getLayoutId() is not supported!!!");
      throw new RuntimeException(localStringBuilder.toString());
    case 18: 
      return 2131629231;
    case 17: 
      return 2131627778;
    case 16: 
      return 2131625847;
    case 15: 
      return 2131625867;
    case 14: 
      return 2131625871;
    case 13: 
      return 2131625862;
    case 12: 
      return 2131625858;
    case 11: 
      return 2131625859;
    case 9: 
      return 2131625870;
    case 8: 
      return 2131625869;
    case 6: 
      return 2131625872;
    case 4: 
      return 2131625857;
    case 3: 
      return 2131625873;
    case 2: 
      i1 = 2131625856;
    }
    return i1;
  }
  
  public void o()
  {
    p();
  }
  
  public void o_(String paramString) {}
  
  public void p()
  {
    if (this.e) {
      return;
    }
    this.e = true;
  }
  
  public boolean q()
  {
    if ((this instanceof NetSearchTemplateUniversalItem))
    {
      if (TextUtils.isEmpty(this.m)) {
        return false;
      }
      Object localObject = (NetSearchTemplateUniversalItem)this;
      if ((((NetSearchTemplateUniversalItem)localObject).c != null) && (((NetSearchTemplateUniversalItem)localObject).c.size() > 0))
      {
        localObject = (NetSearchTemplateUniversalItem.NormalWord)((NetSearchTemplateUniversalItem)localObject).c.get(0);
        if (localObject != null) {
          return ((NetSearchTemplateUniversalItem.NormalWord)localObject).a.toString().equalsIgnoreCase(this.m);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem
 * JD-Core Version:    0.7.0.1
 */