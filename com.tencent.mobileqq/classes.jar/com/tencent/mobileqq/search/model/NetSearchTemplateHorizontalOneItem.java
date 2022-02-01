package com.tencent.mobileqq.search.model;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.widget.RoundRelativeLayout;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalOneItem
  extends NetSearchTemplateHorizontalBaseItem
{
  private static final Pattern C = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  private static final Pattern D = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final String f = "NetSearchTemplateHorizontalOneItem";
  public int A;
  public int B = 0;
  public String t;
  public String u;
  public boolean v;
  public String w;
  public boolean x;
  public String y;
  public String z;
  
  protected NetSearchTemplateHorizontalOneItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem, int paramInt3)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
    this.A = paramInt3;
    a(false);
  }
  
  protected NetSearchTemplateHorizontalOneItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem, int paramInt3)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
    this.A = paramInt3;
    a(false);
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      Matcher localMatcher = C.matcher(paramString);
      String str1 = paramString;
      while (localMatcher.find())
      {
        String str2 = localMatcher.group();
        String str3 = c(str2);
        Object localObject = "";
        paramString = (String)localObject;
        if (!TextUtils.isEmpty(str3))
        {
          FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          paramString = (String)localObject;
          if (localFriendsManager != null)
          {
            paramString = localFriendsManager.m(str3);
            if (paramString != null) {
              localObject = paramString.getFriendNickWithAlias();
            }
            paramString = (String)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramString = d(str2);
            }
          }
        }
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" ");
          str1 = str1.replace(str2, ((StringBuilder)localObject).toString());
        }
      }
      return str1;
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Matcher localMatcher = D.matcher(paramString);
    while (localMatcher.find()) {
      paramString = paramString.replace(localMatcher.group(), "");
    }
    return paramString;
  }
  
  public static String c(String paramString)
  {
    if ("".equals(paramString)) {
      return null;
    }
    int k = paramString.indexOf("uin:");
    int j = paramString.indexOf(",");
    int i = 0;
    if (k != -1) {
      i = k + 4;
    }
    if ((i != 0) && (j != -1)) {
      return paramString.substring(i, j);
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = paramString.indexOf(",nick:");
    int j = paramString.indexOf("}");
    int i = 0;
    if (k != -1) {
      i = k + 6;
    }
    if ((j != -1) && (i != 0)) {
      return paramString.substring(i, j);
    }
    return null;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.A);
    localStringBuilder.append("");
    localHashMap.put("ext5", localStringBuilder.toString());
    localHashMap.put("ext6", g());
    if (this.B == 6)
    {
      localHashMap.put("ext7", this.t);
      localHashMap.put("ext8", "1");
    }
    else
    {
      localHashMap.put("ext7", this.z);
      localHashMap.put("ext8", "2");
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(73).setSubActionType(1).setThrActionType(2).setExtras(localHashMap));
    SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.w);
    UniteSearchReportController.a(null, 0, this.p, "0X800BA23", 0, 0, null, null);
    SearchReportUtil.a(this);
  }
  
  public void a(NetSearchTemplateHorizontalBaseView paramNetSearchTemplateHorizontalBaseView)
  {
    if (!(paramNetSearchTemplateHorizontalBaseView instanceof NetSearchTemplateHorizontalOneView)) {
      return;
    }
    int i = paramNetSearchTemplateHorizontalBaseView.h().getLayoutParams().width;
    if (this.q != null) {
      SearchTemplatePresenter.a(this, paramNetSearchTemplateHorizontalBaseView, true, i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = ThemeUtil.isNowThemeIsNight((AppRuntime)localObject, false, null);
    if (bool)
    {
      paramNetSearchTemplateHorizontalBaseView.b().setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateHorizontalBaseView.d().setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.b().setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateHorizontalBaseView.d().setTextColor(Color.parseColor("#737373"));
    }
    if (TextUtils.isEmpty(this.t))
    {
      paramNetSearchTemplateHorizontalBaseView.b().setVisibility(8);
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.b().setVisibility(0);
      if (this.x) {
        paramNetSearchTemplateHorizontalBaseView.b().setText(SearchUtils.a(paramNetSearchTemplateHorizontalBaseView.b(), i, 2, this.t, this.n.a, false, false));
      } else {
        paramNetSearchTemplateHorizontalBaseView.b().setText(this.t);
      }
      if (this.B == 6)
      {
        paramNetSearchTemplateHorizontalBaseView.b().setMaxLines(1);
        paramNetSearchTemplateHorizontalBaseView.b().setMinLines(1);
      }
    }
    if (TextUtils.isEmpty(this.u))
    {
      paramNetSearchTemplateHorizontalBaseView.d().setVisibility(8);
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.d().setVisibility(0);
      paramNetSearchTemplateHorizontalBaseView.d().setText(this.u);
    }
    if (this.v)
    {
      paramNetSearchTemplateHorizontalBaseView.b().setGravity(1);
      paramNetSearchTemplateHorizontalBaseView.d().setGravity(1);
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.b().setGravity(3);
      paramNetSearchTemplateHorizontalBaseView.d().setGravity(3);
    }
    if (TextUtils.isEmpty(this.w)) {
      paramNetSearchTemplateHorizontalBaseView.h().setOnClickListener(null);
    } else {
      paramNetSearchTemplateHorizontalBaseView.h().setOnClickListener(this);
    }
    if ((localObject instanceof QQAppInterface))
    {
      URLImageView localURLImageView = (URLImageView)paramNetSearchTemplateHorizontalBaseView.h().findViewById(2131428988);
      if (this.B == 6) {
        localURLImageView.setVisibility(8);
      } else {
        localURLImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable((QQAppInterface)localObject, this.y, (byte)2));
      }
    }
    localObject = (RoundRelativeLayout)paramNetSearchTemplateHorizontalBaseView.h().findViewById(2131445443);
    ((RoundRelativeLayout)localObject).setRoundLayoutRadius(DisplayUtil.a(paramNetSearchTemplateHorizontalBaseView.h().getContext(), 12.0F));
    if (bool) {
      ((RoundRelativeLayout)localObject).setBackgroundResource(2130843377);
    } else {
      ((RoundRelativeLayout)localObject).setBackgroundResource(2130843376);
    }
    paramNetSearchTemplateHorizontalBaseView = new HashMap();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.A);
    ((StringBuilder)localObject).append("");
    paramNetSearchTemplateHorizontalBaseView.put("ext5", ((StringBuilder)localObject).toString());
    paramNetSearchTemplateHorizontalBaseView.put("ext6", g());
    if (this.B == 6)
    {
      paramNetSearchTemplateHorizontalBaseView.put("ext7", this.t);
      paramNetSearchTemplateHorizontalBaseView.put("ext8", "1");
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.put("ext7", this.z);
      paramNetSearchTemplateHorizontalBaseView.put("ext8", "2");
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(73).setSubActionType(1).setThrActionType(1).setExtras(paramNetSearchTemplateHorizontalBaseView));
  }
  
  public void b(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.t = paramJSONObject.optString("title");
    boolean bool2 = true;
    try
    {
      this.t = a(this.t, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.t = b(this.t);
    }
    catch (Exception localException)
    {
      String str = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException);
      localStringBuilder.append("");
      QLog.e(str, 1, localStringBuilder.toString());
    }
    this.u = paramJSONObject.optString("desc");
    boolean bool1;
    if (paramJSONObject.optInt("needCenter") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.v = bool1;
    this.w = paramJSONObject.optString("jumpUrl");
    if (paramJSONObject.optInt("highlightTitle", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.x = bool1;
    this.e = paramJSONObject.optString("result_id");
    this.d = paramJSONObject.optString("extra_report_info");
    this.y = paramJSONObject.optString("uin");
    if ((!TextUtils.isEmpty(this.w)) && (this.w.contains("feedid")))
    {
      int i = this.w.indexOf("feedid");
      int j = this.w.indexOf("&", i);
      if (j > i + 6) {
        this.z = this.w.substring(i + 7, j);
      }
    }
    paramJSONObject = paramJSONObject.optJSONObject("imageInfo");
    if (paramJSONObject != null)
    {
      a(paramJSONObject);
      return;
    }
    this.q = null;
  }
  
  public String r()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem
 * JD-Core Version:    0.7.0.1
 */