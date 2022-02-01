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
  
  public void a(String paramString)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CountrySelectActivity", 2, "onIndexChanged | c = " + paramString + " | i = " + localInteger);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(localInteger.intValue());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559666);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365411));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369038));
    setTitle(HardCodeUtil.a(2131702649));
    Object localObject1 = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(((List)localObject1).size() + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_country_code");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "0";
    }
    this.b = getIntent().getBooleanExtra("key_no_limit_allow", false);
    Object localObject2;
    Object localObject3;
    int i;
    if (this.b)
    {
      paramBundle = getLayoutInflater().inflate(2131559668, null);
      localObject2 = new CountrySelectActivity.ViewHolder(null);
      ((TextView)paramBundle.findViewById(2131365410)).setText("不限");
      localObject3 = paramBundle.findViewById(2131364720);
      if (this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        i = 0;
        ((View)localObject3).setVisibility(i);
        paramBundle.findViewById(2131365409).setVisibility(8);
        ((CountrySelectActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = "0";
        paramBundle.setTag(localObject2);
        paramBundle.setOnClickListener(this);
        if (jdField_a_of_type_Boolean) {
          paramBundle.setContentDescription("不限");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(paramBundle);
      }
    }
    else
    {
      paramBundle = getLayoutInflater().inflate(2131559668, null);
      localObject2 = new CountrySelectActivity.ViewHolder(null);
      ((TextView)paramBundle.findViewById(2131365410)).setText("中国");
      localObject3 = paramBundle.findViewById(2131364720);
      if (!this.jdField_a_of_type_JavaLangString.equals("1")) {
        break label554;
      }
      i = 0;
      label330:
      ((View)localObject3).setVisibility(i);
      paramBundle.findViewById(2131365409).setVisibility(8);
      ((CountrySelectActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = "1";
      paramBundle.setTag(localObject2);
      paramBundle.setOnClickListener(this);
      if (jdField_a_of_type_Boolean) {
        paramBundle.setContentDescription("中国");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(paramBundle);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", Integer.valueOf(0));
      paramBundle = "#";
      localObject2 = ((List)localObject1).iterator();
      i = 0;
    }
    int j;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break label638;
      }
      localObject3 = (BaseAddress)((Iterator)localObject2).next();
      if ((!((BaseAddress)localObject3).code.equals("0")) && (!((BaseAddress)localObject3).code.equals("1")))
      {
        j = i;
        localObject1 = paramBundle;
        if (!((BaseAddress)localObject3).pinyinFirst.equals(paramBundle))
        {
          localObject1 = ((BaseAddress)localObject3).pinyinFirst;
          j = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf((String)localObject1);
          for (;;)
          {
            if (i <= j)
            {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, i + 1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
              i += 1;
              continue;
              i = 8;
              break;
              label554:
              i = 8;
              break label330;
            }
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
    label638:
    while (j < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, j + 1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
      j += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchCountrySelectActivity$CountryAdapter = new CountrySelectActivity.CountryAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqConditionsearchCountrySelectActivity$CountryAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void doOnDestroy()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity
 * JD-Core Version:    0.7.0.1
 */