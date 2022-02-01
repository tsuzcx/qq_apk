package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfig;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiKeEntranceHelper
  implements View.OnClickListener, IHomeworkHelper
{
  protected int a;
  protected View a;
  protected LinearLayout a;
  protected TextView a;
  protected PublishHomeWorkFragment a;
  protected Boolean a;
  protected String a;
  protected JSONObject a;
  protected int b;
  protected View b;
  protected String b;
  protected String c = "";
  
  public WeiKeEntranceHelper(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment = paramPublishHomeWorkFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c(View paramView)
  {
    a(false);
    paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131373264);
    PublishHwkThirdPartyEntryConfig localPublishHwkThirdPartyEntryConfig = (PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605);
    if (localPublishHwkThirdPartyEntryConfig != null) {
      if (localPublishHwkThirdPartyEntryConfig.a())
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.b() == 1) {
          this.jdField_a_of_type_AndroidViewView.setClickable(true);
        } else {
          this.jdField_a_of_type_AndroidViewView.setClickable(false);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379236));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379243));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379380);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (paramInt == 1))
    {
      Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a();
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      TroopReportor.a("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { str1, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 264) {
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult data == null");
      return;
    }
    Object localObject = paramIntent.getStringExtra("params");
    if (((String)localObject).isEmpty())
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult strData.isEmpty");
      return;
    }
    paramIntent = null;
    try
    {
      localObject = new JSONObject((String)localObject);
      paramIntent = (Intent)localObject;
    }
    catch (JSONException localJSONException)
    {
      label62:
      break label62;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.optString("title");
    this.jdField_a_of_type_Int = paramIntent.optInt("num", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131697439));
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131697440));
    ((StringBuilder)localObject).append(")\n");
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131697441));
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    this.c = paramIntent.optString("course_name");
    this.jdField_b_of_type_Int = paramIntent.optInt("exam_id", -1);
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("type", "str");
      paramIntent.put("text", localObject);
      localObject = new JSONArray();
      ((JSONArray)localObject).put(paramIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().setDataByEdit((JSONArray)localObject);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.g();
      }
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewView.setEnabled(false);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    }
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToWeiKe");
    }
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity());
    paramView = new Intent();
    StringBuilder localStringBuilder = new StringBuilder(((PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605)).a());
    localStringBuilder.append("?gc=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&appid=");
    localStringBuilder.append("101036803");
    localStringBuilder.append("&_wwv=128&_wv=3");
    paramView.putExtra("url", localStringBuilder.toString());
    RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), paramView, "/base/browser", 264);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localJSONObject != null)
      {
        paramJSONArray.put(localJSONObject);
        return;
      }
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", "exam");
        localJSONObject.put("exam_type", "1");
        localJSONObject.put("appid", "101036803");
        localJSONObject.put("exam_id", String.valueOf(this.jdField_b_of_type_Int));
        localJSONObject.put("course_name", this.c);
        localJSONObject.put("exam_count", String.valueOf(this.jdField_a_of_type_Int));
        localJSONObject.put("title", this.jdField_b_of_type_JavaLangString);
        paramJSONArray.put(localJSONObject);
        return;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("exam_type");
    String str3 = paramJSONObject.optString("appid");
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101036803")))
    {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      str1 = paramJSONObject.optString("exam_id");
      paramJSONObject = paramJSONObject.optString("title");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
      this.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickWeiKeLink");
    }
    paramView = ((PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605)).b();
    if (paramView.isEmpty()) {
      return;
    }
    paramView = new StringBuilder(paramView);
    paramView.append("?gc=");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    paramView.append("&appid=");
    paramView.append("101036803");
    paramView.append("&examid=");
    paramView.append(this.jdField_b_of_type_Int);
    paramView.append("&_wwv=128&_wv=3");
    paramView = paramView.toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramView);
    RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), localIntent, "/base/browser");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WeiKeEntranceHelper.1(this), 20L);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131373264) {
      a(paramView);
    } else if (i == 2131379235) {
      b(paramView);
    } else if (i == 2131379380) {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper
 * JD-Core Version:    0.7.0.1
 */