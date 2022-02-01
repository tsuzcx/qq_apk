package com.tencent.mobileqq.flashshow.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.events.FSOpenH5Event;
import com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper;
import com.tencent.mobileqq.flashshow.report.datong.FSDTParamBuilder;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Map;

public abstract class FSBaseFragment
  extends BasePartFragment
  implements SimpleEventReceiver
{
  public static final ISPBandwidthPredictor a = SuperPlayerFactory.createBandwidthPredictor(FSApplication.APP);
  
  private void g()
  {
    Object localObject;
    if (this.D == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister  mContentView == null , subPage: ");
      ((StringBuilder)localObject).append(b());
      QLog.i("FSBaseFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    if (!TextUtils.isEmpty(e())) {
      localObject = e();
    } else {
      localObject = b();
    }
    VideoReport.setPageId(this.D, (String)localObject);
    VideoReport.setPageParams(this.D, new FSDTParamBuilder().a(a()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister  subPage: ");
    localStringBuilder.append(b());
    localStringBuilder.append(", pageId: ");
    localStringBuilder.append((String)localObject);
    QLog.i("FSBaseFragment", 1, localStringBuilder.toString());
  }
  
  protected Map<String, Object> a()
  {
    return null;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->doOnCreateView");
    QLog.d(str, 1, localStringBuilder.toString());
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    g();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAccountChanged:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void ag()
  {
    if ((getActivity() instanceof QBaseActivity))
    {
      if (((QBaseActivity)getActivity()).getSystemBarComp() == null) {
        return;
      }
      ((QBaseActivity)getActivity()).getSystemBarComp().init();
      ((QBaseActivity)getActivity()).getSystemBarComp().setStatusBarColor(getResources().getColor(2131166100));
      ((QBaseActivity)getActivity()).getSystemBarComp().setStatusBarDrawable(null);
      return;
    }
    super.ag();
  }
  
  public abstract String b();
  
  public abstract String e();
  
  public FSReportBean f()
  {
    Object localObject = super.getViewTagData();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseFragment", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseFragment", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (FSReportBean)localObject;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSAccountChangeEvent.class);
    localArrayList.add(FSFeedEvent.class);
    localArrayList.add(FSOpenH5Event.class);
    return localArrayList;
  }
  
  public int j()
  {
    return FSThemeUtil.a();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onAttach");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onDestroy");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onDestroy();
    FSPopupWindowHelper.a().b();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onDetach()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onDetach");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSAccountChangeEvent))
    {
      a(((FSAccountChangeEvent)paramSimpleBaseEvent).hasSwitchAccount());
      return;
    }
    if (((paramSimpleBaseEvent instanceof FSOpenH5Event)) && (((FSOpenH5Event)paramSimpleBaseEvent).getOpenH5EventFlag())) {
      onStop();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public PartManager p()
  {
    if (this.C == null) {
      this.C = new PartManager(this, getView());
    }
    return this.C;
  }
  
  protected Object r()
  {
    FSReportBean localFSReportBean = new FSReportBean(e());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      if (!getActivity().getIntent().hasExtra("fs_key_bundle_common_init_bean")) {
        return localFSReportBean;
      }
      FSInitBean localFSInitBean = (FSInitBean)getActivity().getIntent().getSerializableExtra("fs_key_bundle_common_init_bean");
      if (localFSInitBean.getFromReportBean() == null) {
        return localFSReportBean;
      }
      localFSReportBean.setFromPageId(localFSInitBean.getFromReportBean().getPageId());
    }
    return localFSReportBean;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->setUserVisibleHint:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    super.setUserVisibleHint(paramBoolean);
    FSThreadUtils.a(new FSBaseFragment.1(this), 200L);
  }
  
  public boolean v()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSBaseFragment
 * JD-Core Version:    0.7.0.1
 */