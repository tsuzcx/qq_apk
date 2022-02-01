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
  private Activity jdField_a_of_type_AndroidAppActivity;
  ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener jdField_a_of_type_ComTencentMobileqqKandianBizDebugReadInJoyDropFrameHelper$OnFeedsFluencyResultListener = new PTSFragment.5(this);
  private PTSAppInstance jdField_a_of_type_ComTencentPtsCorePTSAppInstance;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName");
      this.b = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.FrameTreeJson");
      this.c = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageJs");
      this.d = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.BindDataJs");
      this.e = ((Intent)localObject).getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.AnimationJs");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initArguments], pageName = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.i("PTSFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(View paramView)
  {
    ReadInJoyDropFrameHelper.a().a(9999, this.jdField_a_of_type_ComTencentMobileqqKandianBizDebugReadInJoyDropFrameHelper$OnFeedsFluencyResultListener);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.addOnRecyclerViewScrollListener(new PTSFragment.6(this));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "daily_feeds"))
    {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560171, paramViewGroup);
      View localView1 = paramViewGroup.findViewById(2131370524);
      View localView2 = paramViewGroup.findViewById(2131370529);
      ((TextView)paramViewGroup.findViewById(2131379938)).setVisibility(8);
      localView1.setOnClickListener(new PTSFragment.3(this));
      localView2.setOnClickListener(new PTSFragment.4(this));
    }
  }
  
  private void b()
  {
    PTSReport.a("0X800A7C7", "", "", "", new PTSReport.R5Builder().a("page_name", this.jdField_a_of_type_JavaLangString).a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidAppActivity = getBaseActivity();
    a();
    paramViewGroup = paramLayoutInflater.inflate(2131560261, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (ViewGroup)paramViewGroup.findViewById(2131365187);
    a((ViewGroup)paramViewGroup.findViewById(2131378807));
    paramBundle = PTSJSBridgeManager.getInstance().getJSBridge(this.jdField_a_of_type_AndroidAppActivity, this.d, this.e);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance = new PTSAppInstance.Builder().withContext(this.jdField_a_of_type_AndroidAppActivity).withRootView(paramLayoutInflater).withRootNodeType(0).withPTSJSBridge(paramBundle).withPageName(this.jdField_a_of_type_JavaLangString).withFrameTreeJson(this.b).withPageJs(this.c).build();
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onCreate();
    a(paramViewGroup);
    b();
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    VideoReport.setPageId(paramViewGroup, "14");
    VideoReport.setPageParams(paramViewGroup, new RIJDtParamBuilder().a(Integer.valueOf(DailyModeConfigHandler.b())).a());
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("PTSFragment", 1, "[onDestroy]");
    super.onDestroy();
    PTSThreadUtil.runOnSubThread(new PTSFragment.1(this, this.jdField_a_of_type_AndroidAppActivity));
    ReadInJoyDropFrameHelper.a().b(9999, this.jdField_a_of_type_ComTencentMobileqqKandianBizDebugReadInJoyDropFrameHelper$OnFeedsFluencyResultListener);
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
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    RIJAppSetting.a(localActivity, true, RIJAppSetting.a(localActivity));
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.PTSFragment
 * JD-Core Version:    0.7.0.1
 */