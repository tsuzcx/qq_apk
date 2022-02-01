package com.tencent.mobileqq.kandian.biz.ad;

import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.util.LiuHaiUtils;
import mqq.app.AppRuntime;

public class ReadInJoyAdIMAXBrowserFragment
  extends WebViewFragment
{
  public long a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ActionEntity jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  public ReadInJoyAdIMAXBrowserFragment()
  {
    this.jdField_a_of_type_Long = 8996L;
  }
  
  private View.OnClickListener a()
  {
    return new ReadInJoyAdIMAXBrowserFragment.3(this);
  }
  
  private void a()
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localAdvertisementInfo == null) {
      return;
    }
    int i = localAdvertisementInfo.mImaxShowAdType;
    if (i == 1001)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = ActionEntity.ImaxVideo;
      return;
    }
    if (i == 1002) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = ActionEntity.ImaxPic;
    }
  }
  
  private void b()
  {
    LiuHaiUtils.a(getQBaseActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getQBaseActivity());
    }
    int i;
    if (LiuHaiUtils.b()) {
      i = LiuHaiUtils.b(getQBaseActivity());
    } else {
      i = 0;
    }
    if (getUIStyleHandler().a.a != null) {
      getUIStyleHandler().a.a.setVisibility(8);
    }
    if (getUIStyleHandler().d != null) {
      getWebTitleBarInterface().a(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296653), 0);
    }
    if (getUIStyleHandler().c == null) {
      return;
    }
    int j = UIUtils.a(getQBaseActivity(), 30.0F);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getQBaseActivity());
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843030);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = UIUtils.a(getQBaseActivity(), 15.0F);
    localLayoutParams.topMargin = (UIUtils.a(getQBaseActivity(), 15.0F) + i);
    getUIStyleHandler().c.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyAdIMAXBrowserFragment.2(this));
    this.b = new ImageView(getQBaseActivity());
    this.b.setBackgroundResource(2130843032);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = UIUtils.a(getQBaseActivity(), 15.0F);
    localLayoutParams.topMargin = (UIUtils.a(getQBaseActivity(), 15.0F) + i);
    getUIStyleHandler().c.addView(this.b, localLayoutParams);
    this.b.setOnClickListener(a());
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ReadInJoyAdIMAXBrowserFragment.1(this, this.webViewSurface);
  }
  
  public void onResume()
  {
    super.onResume();
    VideoFeedsHelper.b(getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */