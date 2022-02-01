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
  public long a = 8996L;
  private ImageView b;
  private ImageView c;
  private AdvertisementInfo d;
  private AppRuntime e;
  private boolean f;
  private ActionEntity g;
  
  private void a()
  {
    AdvertisementInfo localAdvertisementInfo = this.d;
    if (localAdvertisementInfo == null) {
      return;
    }
    int i = localAdvertisementInfo.mImaxShowAdType;
    if (i == 1001)
    {
      this.g = ActionEntity.ImaxVideo;
      return;
    }
    if (i == 1002) {
      this.g = ActionEntity.ImaxPic;
    }
  }
  
  private void b()
  {
    LiuHaiUtils.f(getQBaseActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getQBaseActivity());
    }
    int i;
    if (LiuHaiUtils.b()) {
      i = LiuHaiUtils.e(getQBaseActivity());
    } else {
      i = 0;
    }
    if (getUIStyleHandler().g.o != null) {
      getUIStyleHandler().g.o.setVisibility(8);
    }
    if (getUIStyleHandler().x != null) {
      getWebTitleBarInterface().a(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296967), 0);
    }
    if (getUIStyleHandler().u == null) {
      return;
    }
    int j = UIUtils.a(getQBaseActivity(), 30.0F);
    this.b = new ImageView(getQBaseActivity());
    this.b.setBackgroundResource(2130843986);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = UIUtils.a(getQBaseActivity(), 15.0F);
    localLayoutParams.topMargin = (UIUtils.a(getQBaseActivity(), 15.0F) + i);
    getUIStyleHandler().u.addView(this.b, localLayoutParams);
    this.b.setOnClickListener(new ReadInJoyAdIMAXBrowserFragment.2(this));
    this.c = new ImageView(getQBaseActivity());
    this.c.setBackgroundResource(2130843988);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = UIUtils.a(getQBaseActivity(), 15.0F);
    localLayoutParams.topMargin = (UIUtils.a(getQBaseActivity(), 15.0F) + i);
    getUIStyleHandler().u.addView(this.c, localLayoutParams);
    this.c.setOnClickListener(c());
  }
  
  private View.OnClickListener c()
  {
    return new ReadInJoyAdIMAXBrowserFragment.3(this);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ReadInJoyAdIMAXBrowserFragment.1(this, this.webViewSurface);
  }
  
  public void onResume()
  {
    super.onResume();
    VideoFeedsHelper.h(getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */