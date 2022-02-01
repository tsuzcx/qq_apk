package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.TabItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.OCRAccountUtil;
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
  TabItem jdField_a_of_type_ComTencentMobileqqOcrTabItem;
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  BaseOCRTextSearchFragment jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment;
  SearchResultAdapter jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  
  public SearchResultPageView(BaseOCRTextSearchFragment.SearchActivityInterface paramSearchActivityInterface, SearchResultFragment paramSearchResultFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface = paramSearchActivityInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment = paramSearchResultFragment;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter = new SearchResultAdapter(paramSearchActivityInterface.a(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a(), "/base/browser");
    localActivityURIRequest.extra().putString("uin", paramString1);
    localActivityURIRequest.extra().putString("url", paramString2);
    localActivityURIRequest.extra().putBoolean("hide_more_button", true);
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public View a(Context paramContext, TabItem paramTabItem)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131561259, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramContext.findViewById(2131377082));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131378241));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131371921));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment.a);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131370355));
      this.jdField_a_of_type_AndroidViewView = paramContext;
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter);
    }
    a(paramTabItem);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt == 1)
          {
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696037);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699084);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a(null);
  }
  
  protected void a(TabItem paramTabItem)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqOcrTabItem = paramTabItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrTabItem.b == 0) && (this.jdField_a_of_type_ComTencentMobileqqOcrTabItem.a != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("results: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqOcrTabItem.a.size());
        QLog.d("Q.ocr.SearchResultFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTabItem.a;
      if (((List)localObject).size() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqOcrTabItem, (List)localObject, false, false);
      }
      else
      {
        a(-1);
        return;
      }
    }
    b();
    a(paramTabItem.b);
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
        a(OCRAccountUtil.a(), paramListItem.jumpURL);
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = false;
    this.jdField_a_of_type_Int = 0;
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
    SearchResultAdapter localSearchResultAdapter = this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultAdapter;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SearchResultPageView.1(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultPageView
 * JD-Core Version:    0.7.0.1
 */