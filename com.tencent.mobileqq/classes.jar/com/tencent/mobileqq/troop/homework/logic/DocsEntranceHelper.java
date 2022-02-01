package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfig;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DocsEntranceHelper
  implements View.OnClickListener, IHomeworkHelper
{
  protected int a;
  protected long a;
  protected View a;
  protected LinearLayout a;
  protected TextView a;
  protected PublishHomeWorkFragment a;
  protected Boolean a;
  protected String a;
  protected JSONObject a;
  protected boolean a;
  protected View b;
  protected TextView b;
  protected String b;
  protected boolean b;
  protected View c;
  protected String c;
  protected boolean c;
  protected String d;
  protected boolean d;
  
  public DocsEntranceHelper(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment = paramPublishHomeWorkFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity() == null) {
      localObject1 = null;
    } else {
      localObject1 = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getQBaseActivity().getAppRuntime();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject2 instanceof AppInterface)) {
        localObject1 = (AppInterface)localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return "publish_hw_docs_guide_counts";
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("publish_hw_docs_guide_counts");
    ((StringBuilder)localObject1).append(((AppInterface)localObject2).getCurrentAccountUin());
    return ((StringBuilder)localObject1).toString();
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToDocs");
    }
    paramView = (PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605);
    if (paramView != null)
    {
      paramView = paramView.c();
      if (paramView.isEmpty()) {
        return;
      }
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView.append("&appid=");
      paramView.append("101458937");
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramView);
      RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), (Intent)localObject, "/base/browser", 265);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        a(false, 3);
        c(false);
        d(false);
      }
    }
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a();
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = "";
    }
    TroopReportor.a("Grp_edu", "homework", "createHW_doc_clk", 0, 0, new String[] { paramView, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.postImmediately(new DocsEntranceHelper.3(this, paramBoolean, paramInt), null, false);
  }
  
  private void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickDocsLink");
    }
    paramView = (PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605);
    if (paramView != null)
    {
      paramView = paramView.d();
      if (paramView.isEmpty()) {
        return;
      }
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView.append("&appid=");
      paramView.append("101458937");
      paramView.append("&examid=");
      paramView.append(this.jdField_d_of_type_JavaLangString);
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramView);
      RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), localIntent, "/base/browser");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
      }
    }
  }
  
  private boolean b()
  {
    PublishHwkThirdPartyEntryConfig localPublishHwkThirdPartyEntryConfig = (PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605);
    boolean bool = false;
    if ((localPublishHwkThirdPartyEntryConfig != null) && (!localPublishHwkThirdPartyEntryConfig.b())) {
      return false;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity()).getInt(a(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 3) {
      bool = true;
    }
    return bool;
  }
  
  private void c(View paramView)
  {
    a(false);
    paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2);
  }
  
  private void c(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130837912, 0, 0, 0);
        return;
      }
      localTextView.setVisibility(8);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
      {
        localView.setVisibility(0);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131373242);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131373244));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131372481);
    PublishHwkThirdPartyEntryConfig localPublishHwkThirdPartyEntryConfig = (PublishHwkThirdPartyEntryConfig)QConfigManager.a().a(605);
    if (localPublishHwkThirdPartyEntryConfig != null) {
      if (localPublishHwkThirdPartyEntryConfig.b())
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379234));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379383));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379195);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_Boolean = b();
    if (this.jdField_d_of_type_Boolean)
    {
      c(true);
      a(true, 1);
      return;
    }
    c(false);
    d(false);
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
      TroopReportor.a("Grp_edu", "homework", "createHW_doc", 0, 0, new String[] { str1, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 265) {
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
      label65:
      break label65;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.optString("title");
    this.jdField_c_of_type_JavaLangString = paramIntent.optString("course_name");
    this.jdField_d_of_type_JavaLangString = paramIntent.optString("exam_id");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewView.setEnabled(false);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
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
        localJSONObject.put("appid", "101458937");
        localJSONObject.put("exam_id", this.jdField_d_of_type_JavaLangString);
        localJSONObject.put("course_name", this.jdField_c_of_type_JavaLangString);
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
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101458937")))
    {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      str1 = paramJSONObject.optString("title");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("exam_id");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2);
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      d(false);
    }
    else if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_d_of_type_Boolean) {
        ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.1(this), 500L);
      }
    }
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      d(false);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.2(this), 20L);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131373242) {
      a(paramView);
    } else if (i == 2131379234) {
      b(paramView);
    } else if (i == 2131379195) {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper
 * JD-Core Version:    0.7.0.1
 */