package com.tencent.mobileqq.ocr.ui;

import afqc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class SearchResultPageView
  implements SearchResultAdapter.OnResultItemClickedListener
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  BaseOCRTextSearchFragment jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment;
  SearchResultAdapter jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter;
  SearchResultViewPagerAdapter.TabItem jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem;
  public XListView a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  
  public SearchResultPageView(BaseOCRTextSearchFragment.SearchActivityInterface paramSearchActivityInterface, SearchResultFragment paramSearchResultFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface = paramSearchActivityInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment = paramSearchResultFragment;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter = new SearchResultAdapter(paramSearchActivityInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a(), QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a().startActivity(localIntent);
  }
  
  public View a(Context paramContext, SearchResultViewPagerAdapter.TabItem paramTabItem)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2130970462, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramContext.findViewById(2131363901));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131366696));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363902));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment.a);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131366697));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidViewView = paramContext;
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter);
    }
    a(paramTabItem);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a(null);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131430510);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439013);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(SearchResultAdapter.ListItem paramListItem)
  {
    if (paramListItem == null) {
      return;
    }
    if ((paramListItem.b == 2049) && (paramListItem.jdField_a_of_type_Int == 0))
    {
      paramListItem = (OCRTextSearchInfo.SougouSearchInfo)paramListItem.jdField_a_of_type_JavaLangObject;
      if ((paramListItem != null) && (!TextUtils.isEmpty(paramListItem.jumpURL))) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramListItem.jumpURL);
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  protected void a(SearchResultViewPagerAdapter.TabItem paramTabItem)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem = paramTabItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem.b == 0) && (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.SearchResultFragment", 2, "results: " + this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem.a.size());
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem.a;
      if (localList.size() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$TabItem, localList, false, false);
      }
    }
    else
    {
      b();
      a(paramTabItem.b);
      return;
    }
    a(-1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = false;
    this.jdField_a_of_type_Int = 0;
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new afqc(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultPageView
 * JD-Core Version:    0.7.0.1
 */