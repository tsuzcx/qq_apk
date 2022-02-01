package com.tencent.mobileqq.kandian.glue.viola.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBaseView$ViolaCreactPageObject
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "120";
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = "0";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  
  public ViolaBaseView$ViolaCreactPageObject(String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt, String paramString3)
  {
    this(paramString1, paramJSONObject, paramString2, paramString3);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = RIJBlackWhiteModeHelper.a.b();
  }
  
  public ViolaBaseView$ViolaCreactPageObject(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_JavaLangString = paramString3;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.contains("v_present=1")) || (this.jdField_a_of_type_JavaLangString.contains("v_present=2")))) {
      this.jdField_a_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_auto_top=0"))) {
      this.jdField_c_of_type_Int = 0;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_top"))) {
      this.jdField_d_of_type_JavaLangString = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("v_present_top");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("is_last_index=1"))) {
      this.jdField_f_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("channelId"))) {
      this.jdField_e_of_type_JavaLangString = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("channelId");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("unreadMessageCount"))) {
      try
      {
        paramString1 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("unreadMessageCount");
        if (paramString1 != null) {
          this.jdField_e_of_type_Int = Integer.valueOf(paramString1).intValue();
        }
      }
      catch (NumberFormatException paramString1)
      {
        QLog.e(ViolaBaseView.b(), 1, paramString1.toString());
      }
    }
    paramString1 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    if (paramString1 != null) {
      this.jdField_c_of_type_JavaLangString = paramString1.getAccount();
    }
    this.jdField_d_of_type_Int = ViewUtils.c(CommonSuspensionGestureLayout.a(QBaseActivity.sTopActivity));
  }
  
  private int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getResources();
    if (localObject == null) {
      return 1;
    }
    localObject = ((Resources)localObject).getConfiguration();
    if (localObject == null) {
      return 1;
    }
    return ((Configuration)localObject).orientation;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    float f1;
    if ((QBaseActivity.sTopActivity != null) && (QBaseActivity.sTopActivity.getResources() != null)) {
      f1 = ViewUtils.c(QBaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131297336));
    } else {
      f1 = 54.0F;
    }
    paramJSONObject.put("qqTabBarHeight", f1);
  }
  
  private boolean b()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public String a()
  {
    return a().toString();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_OrgJsonJSONObject.put("unreadMessageCount", this.jdField_e_of_type_Int);
        localJSONObject.put("param", this.jdField_a_of_type_OrgJsonJSONObject);
        localJSONObject.put("cache", this.jdField_b_of_type_JavaLangString);
        localJSONObject.put("uin", this.jdField_c_of_type_JavaLangString);
        localJSONObject.put("isPresent", this.jdField_a_of_type_Int);
        localJSONObject.put("isChannel", this.jdField_b_of_type_Int);
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        int j = 0;
        if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject, false, null))
        {
          i = 1;
          localJSONObject.put("isNightMode", i);
          localJSONObject.put("isAutoTop", this.jdField_c_of_type_Int);
          localJSONObject.put("presentMarginTop", this.jdField_d_of_type_JavaLangString);
          localJSONObject.put("nowNavBarHeight", this.jdField_d_of_type_Int);
          localJSONObject.put("orientation", a());
          localJSONObject.put("screenWidth", FlexConvertUtils.getScreenWidth(BaseApplicationImpl.getApplication()));
          localJSONObject.put("screenHeight", FlexConvertUtils.getScreenHeight(BaseApplicationImpl.getApplication()));
          if (CUKingCardUtils.a() != 1) {
            break label473;
          }
          i = 1;
          localJSONObject.put("isKindCard", i);
          localJSONObject.put("channel_id", this.jdField_e_of_type_JavaLangString);
          if (!PlayerHelper.a.a()) {
            break label478;
          }
          i = 1;
          localJSONObject.put("supportRate", i);
          localJSONObject.put("netType", HttpUtil.getNetWorkType());
          localObject = ViolaBizUtils.a();
          localJSONObject.put("topActivityWidth", localObject[0]);
          localJSONObject.put("topActivityHeight", localObject[1]);
          localJSONObject.put("navHeight", localObject[2]);
          if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
            localJSONObject.put("colorBallData", new JSONObject(this.jdField_f_of_type_JavaLangString));
          }
          if (b())
          {
            i = j;
            if (this.jdField_a_of_type_Boolean) {
              i = 1;
            }
            localJSONObject.put("isBlackWhiteMode", i);
          }
          if (String.valueOf(41726).equals(this.jdField_e_of_type_JavaLangString)) {
            a(localJSONObject);
          }
          localJSONObject.put("wifiMac", NetworkUtils.a(BaseApplicationImpl.getApplication()));
          localJSONObject.put("wifiSsid", NetworkUtils.b(BaseApplicationImpl.getApplication()));
          localJSONObject.put("is_last_index", this.jdField_f_of_type_Int);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        String str = ViolaBaseView.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ViolaCreactPageObject toJSON error = ");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.e(str, 1, localStringBuilder.toString());
        return localJSONObject;
      }
      int i = 0;
      continue;
      label473:
      i = 0;
      continue;
      label478:
      i = 0;
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public boolean a()
  {
    return (b()) && (this.jdField_a_of_type_Boolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViolaCreactPageObject : url:");
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    String str = "null";
    if (bool) {
      localObject = "null";
    } else {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((JSONObject)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    localObject = this.jdField_b_of_type_JavaLangString;
    if (localObject == null) {
      localObject = str;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.ViolaCreactPageObject
 * JD-Core Version:    0.7.0.1
 */