package com.tencent.mobileqq.search.model;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalOneItem
  extends NetSearchTemplateHorizontalBaseItem
{
  private static final Pattern a;
  private static final Pattern b;
  public static final String k = NetSearchTemplateHorizontalOneItem.class.getSimpleName();
  public int b;
  public boolean b;
  public boolean c;
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
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = null;
      return str;
    }
    Matcher localMatcher = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
    for (;;)
    {
      str = paramString;
      if (!localMatcher.find()) {
        break;
      }
      paramString = paramString.replace(localMatcher.group(), "");
    }
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      localObject = null;
    }
    Matcher localMatcher;
    do
    {
      return localObject;
      localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
      localObject = paramString;
    } while (!localMatcher.find());
    String str2 = localMatcher.group();
    String str3 = b(str2);
    String str1 = "";
    Object localObject = str1;
    if (!TextUtils.isEmpty(str3))
    {
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject = str1;
      if (localFriendsManager != null)
      {
        localObject = localFriendsManager.e(str3);
        if (localObject == null) {
          break label154;
        }
      }
    }
    label152:
    label154:
    for (localObject = ((Friends)localObject).getFriendNickWithAlias();; localObject = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = c(str2);
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label152;
        }
        paramString = paramString.replace(str2, "@" + (String)localObject + " ");
        break;
      }
      break;
    }
  }
  
  public static String b(String paramString)
  {
    if ("".equals(paramString)) {}
    int j;
    int i;
    do
    {
      return null;
      int i1 = paramString.indexOf("uin:");
      j = paramString.indexOf(",");
      i = 0;
      if (i1 != -1) {
        i = i1 + 4;
      }
    } while ((i == 0) || (j == -1));
    return paramString.substring(i, j);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    int i;
    do
    {
      return null;
      int i1 = paramString.indexOf(",nick:");
      j = paramString.indexOf("}");
      i = 0;
      if (i1 != -1) {
        i = i1 + 6;
      }
    } while ((j == -1) || (i == 0));
    return paramString.substring(i, j);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext5", this.jdField_b_of_type_Int + "");
    localHashMap.put("ext6", a());
    localHashMap.put("ext7", this.p);
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo != null) {
      SearchTemplatePresenter.a(this, paramNetSearchTemplateHorizontalBaseView, true, i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = ThemeUtil.isNowThemeIsNight((AppRuntime)localObject, false, null);
    if (bool)
    {
      paramNetSearchTemplateHorizontalBaseView.a().setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateHorizontalBaseView.c().setTextColor(Color.parseColor("#4A4A4A"));
      if (!TextUtils.isEmpty(this.l)) {
        break label355;
      }
      paramNetSearchTemplateHorizontalBaseView.a().setVisibility(8);
      label98:
      if (!TextUtils.isEmpty(this.m)) {
        break label417;
      }
      paramNetSearchTemplateHorizontalBaseView.c().setVisibility(8);
      label117:
      if (!this.jdField_b_of_type_Boolean) {
        break label439;
      }
      paramNetSearchTemplateHorizontalBaseView.a().setGravity(1);
      paramNetSearchTemplateHorizontalBaseView.c().setGravity(1);
      label140:
      if (!TextUtils.isEmpty(this.n)) {
        break label458;
      }
      paramNetSearchTemplateHorizontalBaseView.a().setOnClickListener(null);
      label158:
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        ((URLImageView)paramNetSearchTemplateHorizontalBaseView.a().findViewById(2131363196)).setImageDrawable(FaceDrawable.getUserFaceDrawable((AppInterface)localObject, this.o, (byte)2));
      }
      localObject = (RoundRelativeLayout)paramNetSearchTemplateHorizontalBaseView.a().findViewById(2131377634);
      ((RoundRelativeLayout)localObject).setRoundLayoutRadius(DisplayUtil.a(paramNetSearchTemplateHorizontalBaseView.a().getContext(), 12.0F));
      if (!bool) {
        break label469;
      }
      ((RoundRelativeLayout)localObject).setBackgroundResource(2130842525);
    }
    for (;;)
    {
      paramNetSearchTemplateHorizontalBaseView = new HashMap();
      paramNetSearchTemplateHorizontalBaseView.put("ext5", this.jdField_b_of_type_Int + "");
      paramNetSearchTemplateHorizontalBaseView.put("ext6", a());
      paramNetSearchTemplateHorizontalBaseView.put("ext7", this.p);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 73, 1, 1, paramNetSearchTemplateHorizontalBaseView, null, null);
      return;
      paramNetSearchTemplateHorizontalBaseView.a().setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateHorizontalBaseView.c().setTextColor(Color.parseColor("#737373"));
      break;
      label355:
      paramNetSearchTemplateHorizontalBaseView.a().setVisibility(0);
      if (this.jdField_c_of_type_Boolean)
      {
        paramNetSearchTemplateHorizontalBaseView.a().setText(SearchUtils.a(paramNetSearchTemplateHorizontalBaseView.a(), i, 2, this.l, this.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.a, false, false));
        break label98;
      }
      paramNetSearchTemplateHorizontalBaseView.a().setText(this.l);
      break label98;
      label417:
      paramNetSearchTemplateHorizontalBaseView.c().setVisibility(0);
      paramNetSearchTemplateHorizontalBaseView.c().setText(this.m);
      break label117;
      label439:
      paramNetSearchTemplateHorizontalBaseView.a().setGravity(3);
      paramNetSearchTemplateHorizontalBaseView.c().setGravity(3);
      break label140;
      label458:
      paramNetSearchTemplateHorizontalBaseView.a().setOnClickListener(this);
      break label158;
      label469:
      ((RoundRelativeLayout)localObject).setBackgroundResource(2130842524);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    this.l = paramJSONObject.optString("title");
    try
    {
      this.l = a(this.l, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.l = a(this.l);
      this.m = paramJSONObject.optString("desc");
      if (paramJSONObject.optInt("needCenter") == 1)
      {
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        this.n = paramJSONObject.optString("jumpUrl");
        if (paramJSONObject.optInt("highlightTitle", 1) != 1) {
          break label268;
        }
        bool1 = bool2;
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
        if (paramJSONObject == null) {
          break label274;
        }
        a(paramJSONObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(k, 1, localException + "");
        continue;
        boolean bool1 = false;
        continue;
        label268:
        bool1 = false;
      }
      label274:
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem
 * JD-Core Version:    0.7.0.1
 */