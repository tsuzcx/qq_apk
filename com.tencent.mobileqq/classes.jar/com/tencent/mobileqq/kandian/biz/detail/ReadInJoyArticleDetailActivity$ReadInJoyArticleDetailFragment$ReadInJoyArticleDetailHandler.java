package com.tencent.mobileqq.kandian.biz.detail;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$ReadInJoyArticleDetailHandler
  extends SwiftBrowserUIStyleHandler
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$ReadInJoyArticleDetailHandler(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void Y_()
  {
    super.Y_();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_Boolean) && (ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment) != null) && (this.c != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment;
      ((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localObject).jdField_a_of_type_AndroidWidgetImageView = new ImageView(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localObject));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841723);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView);
      if (IPluginAdapterProxy.getProxy().isNightMode())
      {
        this.c.setBackgroundColor(-6710887);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841724);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.ReadInJoyArticleDetailHandler
 * JD-Core Version:    0.7.0.1
 */