package com.tencent.mobileqq.kandian.biz.pts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport.R5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;

public class PTSFragment
  extends PublicBaseFragment
{
  ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener a = new PTSFragment.5(this);
  private PTSAppInstance b;
  private Activity c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  private void a()
  {
    Object localObject = this.c.getIntent();
    if (localObject != null)
    {
      this.d = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName");
      this.e = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.FrameTreeJson");
      this.f = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageJs");
      this.g = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.BindDataJs");
      this.h = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.AnimationJs");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initArguments], pageName = ");
    ((StringBuilder)localObject).append(this.d);
    QLog.i("PTSFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(View paramView)
  {
    ReadInJoyDropFrameHelper.d().a(9999, this.a);
    this.b.addOnRecyclerViewScrollListener(new PTSFragment.6(this));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    if (TextUtils.equals(this.d, "daily_feeds"))
    {
      paramViewGroup = View.inflate(this.c, 2131626218, paramViewGroup);
      View localView1 = paramViewGroup.findViewById(2131437797);
      View localView2 = paramViewGroup.findViewById(2131437802);
      ((TextView)paramViewGroup.findViewById(2131448824)).setVisibility(8);
      localView1.setOnClickListener(new PTSFragment.3(this));
      localView2.setOnClickListener(new PTSFragment.4(this));
    }
  }
  
  private void b()
  {
    PTSReport.a("0X800A7C7", "", "", "", new PTSReport.R5Builder().a("page_name", this.d).a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = getBaseActivity();
    a();
    paramViewGroup = paramLayoutInflater.inflate(2131626308, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (ViewGroup)paramViewGroup.findViewById(2131431349);
    a((ViewGroup)paramViewGroup.findViewById(2131447489));
    paramBundle = PTSJSBridgeManager.getInstance().getJSBridge(this.c, this.g, this.h);
    this.b = new PTSAppInstance.Builder().withContext(this.c).withRootView(paramLayoutInflater).withRootNodeType(0).withPTSJSBridge(paramBundle).withPageName(this.d).withFrameTreeJson(this.e).withPageJs(this.f).build();
    this.b.onCreate();
    a(paramViewGroup);
    b();
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    VideoReport.setPageId(paramViewGroup, "14");
    VideoReport.setPageParams(paramViewGroup, new RIJDtParamBuilder().a(Integer.valueOf(DailyModeConfigHandler.j())).b());
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("PTSFragment", 1, "[onDestroy]");
    super.onDestroy();
    PTSThreadUtil.runOnSubThread(new PTSFragment.1(this, this.c));
    ReadInJoyDropFrameHelper.d().b(9999, this.a);
  }
  
  public void onFinish()
  {
    QLog.i("PTSFragment", 2, "[onFinish]");
    super.onFinish();
    PTSThreadUtil.runOnSubThread(new PTSFragment.2(this));
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Activity localActivity = this.c;
    RIJAppSetting.a(localActivity, true, RIJAppSetting.a(localActivity));
    this.b.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.PTSFragment
 * JD-Core Version:    0.7.0.1
 */