package com.tencent.mobileqq.debug;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/debug/VasAdvDebugFragment$initView$1$2"}, k=3, mv={1, 1, 16})
final class VasAdvDebugFragment$initView$$inlined$apply$lambda$2
  implements View.OnClickListener
{
  VasAdvDebugFragment$initView$$inlined$apply$lambda$2(VasAdvDebugFragment paramVasAdvDebugFragment) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.a.getBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://imgcache.qq.com/club/mTools/webview.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weather");
    this.a.getBaseActivity().startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.VasAdvDebugFragment.initView..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */