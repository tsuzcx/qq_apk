package com.tencent.mobileqq.winkpublish.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.winkpublish.util.FSTransUtils;
import com.tencent.mobileqq.winkpublish.util.QCircleThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class PublishBaseFragment
  extends BasePartFragment
  implements SimpleEventReceiver
{
  public static final ISPBandwidthPredictor a = SuperPlayerFactory.createBandwidthPredictor(FSTransUtils.e());
  
  private void a(String paramString)
  {
    if (this.D == null)
    {
      paramString = new StringBuilder();
      paramString.append("reportDaTongRegister mContentView == null , subPage: ");
      paramString.append(b());
      QLog.i("FSBaseFragment", 1, paramString.toString());
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    String str;
    if (!TextUtils.isEmpty(e())) {
      str = e();
    } else {
      str = b();
    }
    VideoReport.setPageId(this.D, str);
    VideoReport.setPageParams(this.D, new WinkDTParamBuilder().buildPageParams(a(), paramString));
    paramString = new StringBuilder();
    paramString.append("reportDaTongRegister subPage: ");
    paramString.append(b());
    paramString.append(", pageId: ");
    paramString.append(str);
    QLog.i("FSBaseFragment", 1, paramString.toString());
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (this.D == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister mContentView == null , subPage: ");
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
    VideoReport.setPageParams(this.D, new WinkDTParamBuilder().buildPageParams(a(), paramBoolean));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister subPage: ");
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
    paramLayoutInflater = getActivity();
    paramBundle = null;
    if ((paramLayoutInflater != null) && (getActivity().getIntent() != null)) {
      paramLayoutInflater = (HashMap)getActivity().getIntent().getSerializableExtra("PUBLISH_EDIT_DATONG_DATA");
    } else {
      paramLayoutInflater = null;
    }
    paramViewGroup = paramBundle;
    if (paramLayoutInflater != null)
    {
      paramViewGroup = paramBundle;
      if (!TextUtils.isEmpty((String)paramLayoutInflater.get("xsj_camera_session_id"))) {
        paramViewGroup = (String)paramLayoutInflater.get("xsj_camera_session_id");
      }
    }
    if (TextUtils.isEmpty(paramViewGroup)) {
      a(true);
    } else {
      a(paramViewGroup);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    if ((v()) && (!bh_()) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      QCircleThemeUtil.a(getActivity(), QCircleSkinHelper.getInstance().getColor(2131167446));
      ImmersiveUtils.setStatusTextColor(QCircleCommonUtil.isInNightMode(), getActivity().getWindow());
    }
  }
  
  public abstract String b();
  
  public abstract String e();
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
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
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
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
    return null;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.base.PublishBaseFragment
 * JD-Core Version:    0.7.0.1
 */