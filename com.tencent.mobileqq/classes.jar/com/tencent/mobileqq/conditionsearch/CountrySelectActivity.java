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
  static final boolean a = AppSetting.e;
  private static final String[] i = { "#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  PinnedDividerListView b;
  CountrySelectActivity.CountryAdapter c;
  IndexView d;
  List<Object> e;
  LinkedHashMap<String, Integer> f;
  String g;
  boolean h = true;
  
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
    setContentView(2131625566);
    this.b = ((PinnedDividerListView)findViewById(2131431450));
    this.d = ((IndexView)findViewById(2131435677));
    setTitle(HardCodeUtil.a(2131900772));
    Object localObject1 = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).c();
    this.f = new LinkedHashMap();
    this.e = new ArrayList(((List)localObject1).size() + 26);
    this.g = getIntent().getStringExtra("key_country_code");
    if (TextUtils.isEmpty(this.g)) {
      this.g = "0";
    }
    this.h = getIntent().getBooleanExtra("key_no_limit_allow", false);
    if (this.h)
    {
      paramBundle = getLayoutInflater().inflate(2131625568, null);
      localObject2 = new CountrySelectActivity.ViewHolder(null);
      ((TextView)paramBundle.findViewById(2131431449)).setText("不限");
      localObject3 = paramBundle.findViewById(2131430679);
      if (this.g.equals("0")) {
        j = 0;
      } else {
        j = 8;
      }
      ((View)localObject3).setVisibility(j);
      paramBundle.findViewById(2131431448).setVisibility(8);
      ((CountrySelectActivity.ViewHolder)localObject2).c = "0";
      paramBundle.setTag(localObject2);
      paramBundle.setOnClickListener(this);
      if (a) {
        paramBundle.setContentDescription("不限");
      }
      this.b.addHeaderView(paramBundle);
    }
    paramBundle = getLayoutInflater().inflate(2131625568, null);
    Object localObject2 = new CountrySelectActivity.ViewHolder(null);
    ((TextView)paramBundle.findViewById(2131431449)).setText("中国");
    Object localObject3 = paramBundle.findViewById(2131430679);
    if (this.g.equals("1")) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject3).setVisibility(j);
    paramBundle.findViewById(2131431448).setVisibility(8);
    ((CountrySelectActivity.ViewHolder)localObject2).c = "1";
    paramBundle.setTag(localObject2);
    paramBundle.setOnClickListener(this);
    if (a) {
      paramBundle.setContentDescription("中国");
    }
    this.b.addHeaderView(paramBundle);
    localObject2 = this.f;
    paramBundle = "#";
    ((LinkedHashMap)localObject2).put("#", Integer.valueOf(0));
    localObject2 = ((List)localObject1).iterator();
    int j = 0;
    int k;
    for (;;)
    {
      k = j;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (BaseAddress)((Iterator)localObject2).next();
      if ((!((BaseAddress)localObject3).code.equals("0")) && (!((BaseAddress)localObject3).code.equals("1")))
      {
        k = j;
        localObject1 = paramBundle;
        if (!((BaseAddress)localObject3).pinyinFirst.equals(paramBundle))
        {
          localObject1 = ((BaseAddress)localObject3).pinyinFirst;
          int m = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf((String)localObject1);
          while (j <= m)
          {
            paramBundle = this.f;
            k = j + 1;
            paramBundle.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, k), Integer.valueOf(this.e.size() + this.b.getHeaderViewsCount()));
            j = k;
          }
          this.f.put(localObject1, Integer.valueOf(this.e.size() + this.b.getHeaderViewsCount()));
          paramBundle = new CountrySelectActivity.DividerItem(null);
          paramBundle.a = ((String)localObject1);
          this.e.add(paramBundle);
          k = j;
        }
        this.e.add(localObject3);
        j = k;
        paramBundle = (Bundle)localObject1;
      }
    }
    while (k < 26)
    {
      paramBundle = this.f;
      j = k + 1;
      paramBundle.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(k, j), Integer.valueOf(this.e.size() + this.b.getHeaderViewsCount()));
      k = j;
    }
    this.c = new CountrySelectActivity.CountryAdapter(this, null);
    this.b.setAdapter(this.c);
    this.d.setIndex(i, false);
    this.d.setOnIndexChangedListener(this);
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
      localIntent.putExtra("key_country_code", ((CountrySelectActivity.ViewHolder)localObject).c);
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
    Integer localInteger = (Integer)this.f.get(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIndexChanged | c = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | i = ");
      localStringBuilder.append(localInteger);
      QLog.d("CountrySelectActivity", 2, localStringBuilder.toString());
    }
    this.b.setSelection(localInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity
 * JD-Core Version:    0.7.0.1
 */