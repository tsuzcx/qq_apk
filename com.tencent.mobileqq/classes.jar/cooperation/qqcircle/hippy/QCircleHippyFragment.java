package cooperation.qqcircle.hippy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qqcircle.beans.QCircleHippyBean;
import cooperation.qqcircle.events.QCircleRefreshHippyPageEvent;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;
import thu;
import vgn;
import zbi;

public class QCircleHippyFragment
  extends ViolaFragment
  implements SimpleEventReceiver
{
  private static final String TAG = "QCircleHippyFragment";
  private QCircleHippyBean bean;
  private String mDefaultH5Url;
  private long mLaunchTimeStamp;
  private String mModuleName;
  
  private void addMaskLayer()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private JSONObject getJSInitData()
  {
    if (getActivity() != null)
    {
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(2);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", str);
        localJSONObject.put("p_uin", str);
        localJSONObject.put("skey", localTicketManager.getSkey(str));
        localJSONObject.put("p_skey", localTicketManager.getPskey(str, "qzone.qq.com"));
        if ((this.bean != null) && (!TextUtils.isEmpty(this.bean.getPersonalUin()))) {
          localJSONObject.put("host_uin", this.bean.getPersonalUin());
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private HashMap<String, Object> getUIConfig()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(thu.b, Integer.valueOf(1));
    localHashMap.put(thu.h, Boolean.valueOf(true));
    localHashMap.put(thu.i, Boolean.valueOf(false));
    localHashMap.put(thu.v, Boolean.valueOf(false));
    localHashMap.put(thu.j, Boolean.valueOf(true));
    return localHashMap;
  }
  
  private void initHippy(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.mViolaUiDelegate.a(paramViewGroup, new QCircleHippyFragment.1(this));
        this.mHippyQQEngine.initHippy(getContentView(), paramBundle, this.mViolaUiDelegate.b(), new QCircleHippyFragment.2(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void jumpHybirdActivityWithDefaultH5Url()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", this.mDefaultH5Url);
    vgn.a(BaseApplicationImpl.getContext(), "openwebview", localHashMap);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void registerDaTongReport(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "small_world_base");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().setPageSubclass("QCircleHippyFragment").buildPageParams());
    QLog.i("QCircleHippyFragment", 1, "reportDaTongRegister  subPage: QCircleHippyFragment");
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleRefreshHippyPageEvent.class);
    return localArrayList;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.bean = ((QCircleHippyBean)paramBundle.getSerializable("key_hippy_bean"));
    if (this.bean != null)
    {
      this.mModuleName = this.bean.getModuleName();
      this.mDefaultH5Url = this.bean.getDefaultUrl();
      this.mLaunchTimeStamp = this.bean.getStartTime();
      if (TextUtils.isEmpty(this.mModuleName)) {
        break label158;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleHippyFragment", 2, "Hippy: moduleName=" + this.mModuleName);
      }
      if (this.mHippyQQEngine == null) {
        this.mHippyQQEngine = new HippyQQEngine(this, this.mModuleName, null);
      }
      this.mHippyQQEngine.setInitData(null, getJSInitData());
      initHippy(paramBundle, paramViewGroup);
    }
    for (;;)
    {
      this.mViolaUiDelegate.a(getUIConfig(), paramViewGroup);
      initFPS();
      return;
      label158:
      jumpHybirdActivityWithDefaultH5Url();
      QCircleQualityReporter.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", "-2"), QCircleReportHelper.newEntry("attach_info", "request module name is null!") }), false);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (zbi.a()) {
      addMaskLayer();
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    registerDaTongReport(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRefreshHippyPageEvent))
    {
      paramSimpleBaseEvent = (QCircleRefreshHippyPageEvent)paramSimpleBaseEvent;
      if ((!this.mModuleName.equals(paramSimpleBaseEvent.mModule)) || (this.mHippyQQEngine == null) || (this.mHippyQQEngine.getHippyEngine() == null)) {}
    }
    try
    {
      paramSimpleBaseEvent = new HippyMap();
      paramSimpleBaseEvent.pushString("result", "call refresh hippy from native");
      ((EventDispatcher)this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramSimpleBaseEvent);
      QLog.d("QCircleHippyFragment", 1, "notify hippy refresh page data success,module:" + this.mModuleName);
      return;
    }
    catch (Exception paramSimpleBaseEvent)
    {
      QLog.e("QCircleHippyFragment", 1, "refresh hippy page fail!exception: " + paramSimpleBaseEvent.getMessage() + ",module:" + this.mModuleName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hippy.QCircleHippyFragment
 * JD-Core Version:    0.7.0.1
 */