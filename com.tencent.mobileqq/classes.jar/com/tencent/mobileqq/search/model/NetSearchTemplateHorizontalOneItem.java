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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.widget.RoundRelativeLayout;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
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
  private static final Pattern a;
  private static final Pattern b;
  public static final String k = "NetSearchTemplateHorizontalOneItem";
  public int b;
  public boolean b;
  public boolean c;
  public int d = 0;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  }
  
  protected NetSearchTemplateHorizontalOneItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem, int paramInt3)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  protected NetSearchTemplateHorizontalOneItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem, int paramInt3)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Matcher localMatcher = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
    while (localMatcher.find()) {
      paramString = paramString.replace(localMatcher.group(), "");
    }
    return paramString;
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
      String str1 = paramString;
      while (localMatcher.find())
      {
        String str2 = localMatcher.group();
        String str3 = b(str2);
        Object localObject = "";
        paramString = (String)localObject;
        if (!TextUtils.isEmpty(str3))
        {
          FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          paramString = (String)localObject;
          if (localFriendsManager != null)
          {
            paramString = localFriendsManager.e(str3);
            if (paramString != null) {
              localObject = paramString.getFriendNickWithAlias();
            }
            paramString = (String)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramString = c(str2);
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
    if ("".equals(paramString)) {
      return null;
    }
    int i1 = paramString.indexOf("uin:");
    int j = paramString.indexOf(",");
    int i = 0;
    if (i1 != -1) {
      i = i1 + 4;
    }
    if ((i != 0) && (j != -1)) {
      return paramString.substring(i, j);
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i1 = paramString.indexOf(",nick:");
    int j = paramString.indexOf("}");
    int i = 0;
    if (i1 != -1) {
      i = i1 + 6;
    }
    if ((j != -1) && (i != 0)) {
      return paramString.substring(i, j);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("");
    localHashMap.put("ext5", localStringBuilder.toString());
    localHashMap.put("ext6", b());
    if (this.d == 6)
    {
      localHashMap.put("ext7", this.l);
      localHashMap.put("ext8", "1");
    }
    else
    {
      localHashMap.put("ext7", this.p);
      localHashMap.put("ext8", "2");
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 73, 1, 2, localHashMap, null, null);
    SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.n);
    UniteSearchReportController.a(null, 0, this.jdField_c_of_type_Int, "0X800BA23", 0, 0, null, null);
  }
  
  public void a(NetSearchTemplateHorizontalBaseView paramNetSearchTemplateHorizontalBaseView)
  {
    if (!(paramNetSearchTemplateHorizontalBaseView instanceof NetSearchTemplateHorizontalOneView)) {
      return;
    }
    int i = paramNetSearchTemplateHorizontalBaseView.a().getLayoutParams().width;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo != null) {
      SearchTemplatePresenter.a(this, paramNetSearchTemplateHorizontalBaseView, true, i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = ThemeUtil.isNowThemeIsNight((AppRuntime)localObject, false, null);
    if (bool)
    {
      paramNetSearchTemplateHorizontalBaseView.a().setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateHorizontalBaseView.c().setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.a().setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateHorizontalBaseView.c().setTextColor(Color.parseColor("#737373"));
    }
    if (TextUtils.isEmpty(this.l))
    {
      paramNetSearchTemplateHorizontalBaseView.a().setVisibility(8);
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.a().setVisibility(0);
      if (this.jdField_c_of_type_Boolean) {
        paramNetSearchTemplateHorizontalBaseView.a().setText(SearchUtils.a(paramNetSearchTemplateHorizontalBaseView.a(), i, 2, this.l, this.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.a, false, false));
      } else {
        paramNetSearchTemplateHorizontalBaseView.a().setText(this.l);
      }
      if (this.d == 6)
      {
        paramNetSearchTemplateHorizontalBaseView.a().setMaxLines(1);
        paramNetSearchTemplateHorizontalBaseView.a().setMinLines(1);
      }
    }
    if (TextUtils.isEmpty(this.m))
    {
      paramNetSearchTemplateHorizontalBaseView.c().setVisibility(8);
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.c().setVisibility(0);
      paramNetSearchTemplateHorizontalBaseView.c().setText(this.m);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramNetSearchTemplateHorizontalBaseView.a().setGravity(1);
      paramNetSearchTemplateHorizontalBaseView.c().setGravity(1);
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.a().setGravity(3);
      paramNetSearchTemplateHorizontalBaseView.c().setGravity(3);
    }
    if (TextUtils.isEmpty(this.n)) {
      paramNetSearchTemplateHorizontalBaseView.a().setOnClickListener(null);
    } else {
      paramNetSearchTemplateHorizontalBaseView.a().setOnClickListener(this);
    }
    if ((localObject instanceof QQAppInterface))
    {
      URLImageView localURLImageView = (URLImageView)paramNetSearchTemplateHorizontalBaseView.a().findViewById(2131363135);
      if (this.d == 6) {
        localURLImageView.setVisibility(8);
      } else {
        localURLImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable((QQAppInterface)localObject, this.o, (byte)2));
      }
    }
    localObject = (RoundRelativeLayout)paramNetSearchTemplateHorizontalBaseView.a().findViewById(2131377074);
    ((RoundRelativeLayout)localObject).setRoundLayoutRadius(DisplayUtil.a(paramNetSearchTemplateHorizontalBaseView.a().getContext(), 12.0F));
    if (bool) {
      ((RoundRelativeLayout)localObject).setBackgroundResource(2130842424);
    } else {
      ((RoundRelativeLayout)localObject).setBackgroundResource(2130842423);
    }
    paramNetSearchTemplateHorizontalBaseView = new HashMap();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append("");
    paramNetSearchTemplateHorizontalBaseView.put("ext5", ((StringBuilder)localObject).toString());
    paramNetSearchTemplateHorizontalBaseView.put("ext6", b());
    if (this.d == 6)
    {
      paramNetSearchTemplateHorizontalBaseView.put("ext7", this.l);
      paramNetSearchTemplateHorizontalBaseView.put("ext8", "1");
    }
    else
    {
      paramNetSearchTemplateHorizontalBaseView.put("ext7", this.p);
      paramNetSearchTemplateHorizontalBaseView.put("ext8", "2");
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 73, 1, 1, paramNetSearchTemplateHorizontalBaseView, null, null);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.l = paramJSONObject.optString("title");
    boolean bool2 = true;
    try
    {
      this.l = a(this.l, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.l = a(this.l);
    }
    catch (Exception localException)
    {
      String str = k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException);
      localStringBuilder.append("");
      QLog.e(str, 1, localStringBuilder.toString());
    }
    this.m = paramJSONObject.optString("desc");
    boolean bool1;
    if (paramJSONObject.optInt("needCenter") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.n = paramJSONObject.optString("jumpUrl");
    if (paramJSONObject.optInt("highlightTitle", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    this.j = paramJSONObject.optString("result_id");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("extra_report_info");
    this.o = paramJSONObject.optString("uin");
    if ((!TextUtils.isEmpty(this.n)) && (this.n.contains("feedid")))
    {
      int i = this.n.indexOf("feedid");
      int j = this.n.indexOf("&", i);
      if (j > i + 6) {
        this.p = this.n.substring(i + 7, j);
      }
    }
    paramJSONObject = paramJSONObject.optJSONObject("imageInfo");
    if (paramJSONObject != null)
    {
      a(paramJSONObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem
 * JD-Core Version:    0.7.0.1
 */