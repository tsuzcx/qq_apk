package com.tencent.mobileqq.troop.troopcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.association.api.ITroopAssociationHandler;
import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopAssociationsListWrapper
  implements View.OnClickListener
{
  protected long a;
  protected Context a;
  protected View a;
  protected LinearLayout a;
  protected TextView a;
  protected AppInterface a;
  protected TroopAssociationObserver a;
  protected TroopAssociationsAdapter a;
  protected TroopAssociationsListWrapper.ICallbacks a;
  protected QFormSimpleItem a;
  protected XListView a;
  protected String a;
  protected ArrayList<AssociatedTroopItem> a;
  protected boolean a;
  protected long b;
  protected View b;
  protected String b;
  
  public TroopAssociationsListWrapper(AppInterface paramAppInterface, Context paramContext, TroopAssociationsListWrapper.ICallbacks paramICallbacks, XListView paramXListView, LinearLayout paramLinearLayout, String paramString, long paramLong)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper$ICallbacks = paramICallbacks;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver = new TroopAssociationsListWrapper.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver);
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(MobileQQ.getContext().getResources().getString(2131699451));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(Utils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Utils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, Utils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561565, null);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130851081);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561547, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131369172));
      a(0, 0, this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem, MobileQQ.getContext().getResources().getString(2131699459), MobileQQ.getContext().getResources().getString(2131699456), true);
      TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368828);
      localTextView.setBackgroundResource(2130839435);
      localTextView.setText(MobileQQ.getContext().getResources().getString(2131699453));
      localTextView.setTextColor(MobileQQ.getContext().getResources().getColor(2131167138));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    ITroopAssociationHandler localITroopAssociationHandler = (ITroopAssociationHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
    if ((localITroopAssociationHandler != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Long = localITroopAssociationHandler.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected void a(int paramInt)
  {
    Object localObject;
    if ((paramInt != 1) && (paramInt != 2))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXListView.findHeaderViewPosition((View)localObject) < 0) {
          this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetTextView);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsAdapter == null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsAdapter = new TroopAssociationsAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsAdapter);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView((View)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      boolean bool = TroopInfoUtil.a((AppRuntime)localObject, this.jdField_a_of_type_JavaLangString, ((AppInterface)localObject).getCurrentUin());
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        if ((bool) && (paramInt == 1))
        {
          ((View)localObject).setVisibility(0);
          ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "0", "", "");
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        if ((bool) && (paramInt == 1))
        {
          ((View)localObject).setVisibility(0);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, QFormSimpleItem paramQFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramQFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramQFormSimpleItem.setOnClickListener(this);
      paramQFormSimpleItem.a(true);
    }
    else
    {
      paramQFormSimpleItem.setTag(null);
      paramQFormSimpleItem.setOnClickListener(null);
      paramQFormSimpleItem.a(false);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4) {
              paramQFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
            }
          }
          else {
            paramQFormSimpleItem.setBgType(3);
          }
        }
        else {
          paramQFormSimpleItem.setBgType(2);
        }
      }
      else {
        paramQFormSimpleItem.setBgType(1);
      }
    }
    else {
      paramQFormSimpleItem.setBgType(0);
    }
    paramQFormSimpleItem.setRightTextColor(2);
    paramQFormSimpleItem.setLeftTextColor(0);
    paramQFormSimpleItem.getBackground().setAlpha(255);
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramQFormSimpleItem.setLeftText(str1);
    paramQFormSimpleItem.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    if (paramCharSequence == null) {
      paramString = str2;
    } else {
      paramString = new QQText(paramCharSequence, 3);
    }
    paramQFormSimpleItem.setRightText(paramString);
  }
  
  protected void a(String paramString, List<AssociatedTroopItem> paramList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        AssociatedTroopItem localAssociatedTroopItem = (AssociatedTroopItem)localIterator.next();
        if ((!TextUtils.isEmpty(localAssociatedTroopItem.uin)) && (localAssociatedTroopItem.uin.equals(paramString))) {
          paramList.remove(localAssociatedTroopItem);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      c();
      localObject = (ITroopAssociationHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Long = ((ITroopAssociationHandler)localObject).a(this.jdField_a_of_type_JavaLangString, 2, "");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (TroopInfoUtil.a((AppRuntime)localObject, this.jdField_a_of_type_JavaLangString, ((AppInterface)localObject).getCurrentUin()))
      {
        c();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "0", "", "");
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsAdapter;
      if (localObject != null) {
        ((TroopAssociationsAdapter)localObject).a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<AssociatedTroopItem> paramList, long paramLong)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.jdField_a_of_type_JavaLangString)))
    {
      paramInt2 = 2;
      if (paramInt1 == 2)
      {
        if (this.jdField_b_of_type_Long != paramLong) {
          return;
        }
        int i = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_b_of_type_JavaLangString = paramString2;
        if (paramList != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
          a(paramString1, this.jdField_a_of_type_JavaUtilArrayList);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
        {
          if ((paramList != null) && (paramList.size() == 1)) {
            paramInt1 = paramInt2;
          } else {
            paramInt1 = 1;
          }
        }
        else {
          paramInt1 = 3;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (i == 0)) {
          ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "1", "", "");
        }
        a(paramInt1);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsAdapter;
        if (paramString1 != null) {
          paramString1.a(this.jdField_a_of_type_JavaUtilArrayList);
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper$ICallbacks;
        if (paramString1 != null) {
          paramString1.a(this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
  }
  
  protected boolean a()
  {
    return TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null)
    {
      TroopAssociationObserver localTroopAssociationObserver = this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver;
      if (localTroopAssociationObserver != null) {
        localAppInterface.removeObserver(localTroopAssociationObserver);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem)
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).openTroopAssociationWebPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4B0", "0X800B4B0", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopAssociationsListWrapper
 * JD-Core Version:    0.7.0.1
 */