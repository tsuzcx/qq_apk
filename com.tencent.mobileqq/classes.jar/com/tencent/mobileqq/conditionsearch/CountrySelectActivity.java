package com.tencent.mobileqq.conditionsearch;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class CountrySelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  static final boolean jdField_a_of_type_Boolean = AppSetting.d;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  CountrySelectActivity.CountryAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchCountrySelectActivity$CountryAdapter;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<String, Integer> jdField_a_of_type_JavaUtilLinkedHashMap;
  List<Object> jdField_a_of_type_JavaUtilList;
  boolean b = true;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559544);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365276));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368760));
    setTitle(HardCodeUtil.a(2131702782));
    Object localObject1 = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(((List)localObject1).size() + 26);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_country_code");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "0";
    }
    this.b = getIntent().getBooleanExtra("key_no_limit_allow", false);
    if (this.b)
    {
      paramBundle = getLayoutInflater().inflate(2131559546, null);
      localObject2 = new CountrySelectActivity.ViewHolder(null);
      ((TextView)paramBundle.findViewById(2131365275)).setText("不限");
      localObject3 = paramBundle.findViewById(2131364607);
      if (this.jdField_a_of_type_JavaLangString.equals("0")) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject3).setVisibility(i);
      paramBundle.findViewById(2131365274).setVisibility(8);
      ((CountrySelectActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = "0";
      paramBundle.setTag(localObject2);
      paramBundle.setOnClickListener(this);
      if (jdField_a_of_type_Boolean) {
        paramBundle.setContentDescription("不限");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(paramBundle);
    }
    paramBundle = getLayoutInflater().inflate(2131559546, null);
    Object localObject2 = new CountrySelectActivity.ViewHolder(null);
    ((TextView)paramBundle.findViewById(2131365275)).setText("中国");
    Object localObject3 = paramBundle.findViewById(2131364607);
    if (this.jdField_a_of_type_JavaLangString.equals("1")) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject3).setVisibility(i);
    paramBundle.findViewById(2131365274).setVisibility(8);
    ((CountrySelectActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = "1";
    paramBundle.setTag(localObject2);
    paramBundle.setOnClickListener(this);
    if (jdField_a_of_type_Boolean) {
      paramBundle.setContentDescription("中国");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(paramBundle);
    localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    paramBundle = "#";
    ((LinkedHashMap)localObject2).put("#", Integer.valueOf(0));
    localObject2 = ((List)localObject1).iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (BaseAddress)((Iterator)localObject2).next();
      if ((!((BaseAddress)localObject3).code.equals("0")) && (!((BaseAddress)localObject3).code.equals("1")))
      {
        j = i;
        localObject1 = paramBundle;
        if (!((BaseAddress)localObject3).pinyinFirst.equals(paramBundle))
        {
          localObject1 = ((BaseAddress)localObject3).pinyinFirst;
          int k = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf((String)localObject1);
          while (i <= k)
          {
            paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap;
            j = i + 1;
            paramBundle.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, j), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
            i = j;
          }
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
          paramBundle = new CountrySelectActivity.DividerItem(null);
          paramBundle.jdField_a_of_type_JavaLangString = ((String)localObject1);
          this.jdField_a_of_type_JavaUtilList.add(paramBundle);
          j = i;
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject3);
        i = j;
        paramBundle = (Bundle)localObject1;
      }
    }
    while (j < 26)
    {
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      i = j + 1;
      paramBundle.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
      j = i;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchCountrySelectActivity$CountryAdapter = new CountrySelectActivity.CountryAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqConditionsearchCountrySelectActivity$CountryAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof CountrySelectActivity.ViewHolder))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_country_code", ((CountrySelectActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString);
      setResult(-1, localIntent);
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIndexChanged | c = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | i = ");
      localStringBuilder.append(localInteger);
      QLog.d("CountrySelectActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(localInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity
 * JD-Core Version:    0.7.0.1
 */