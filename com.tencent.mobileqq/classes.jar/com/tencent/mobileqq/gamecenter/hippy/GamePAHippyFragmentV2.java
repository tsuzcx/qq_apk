package com.tencent.mobileqq.gamecenter.hippy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.OnPreloadFeedsListener;
import com.tencent.mobileqq.gamecenter.util.QQGameUIHelper;
import com.tencent.mobileqq.gamecenter.view.GamePubNav;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GamePAHippyFragmentV2
  extends GamePAHippyBaseFragment
  implements View.OnClickListener
{
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new GamePAHippyFragmentV2.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private QQGameHelper.OnPreloadFeedsListener jdField_a_of_type_ComTencentMobileqqGamecenterUtilQQGameHelper$OnPreloadFeedsListener = new GamePAHippyFragmentV2.2(this);
  private GamePubNav jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav;
  private View b;
  
  private View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561751, null, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131368438));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav = ((GamePubNav)paramLayoutInflater.findViewById(2131377159));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.a();
    QQGameUIHelper.a(this.jdField_a_of_type_AndroidViewView);
    h();
    return paramLayoutInflater;
  }
  
  private void b(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragmentV2.6(this, paramGmpEnterInfoRsp, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.setMoreClick(new GamePAHippyFragmentV2.3(this));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.setReturnClick(new GamePAHippyFragmentV2.4(this));
  }
  
  String a()
  {
    return "3";
  }
  
  void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    b(paramGmpEnterInfoRsp, paramBoolean);
  }
  
  void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramArrayList);
      paramArrayList = QQGameHelper.b(this.jdField_a_of_type_JavaUtilList).toString();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.arg1 = -1;
      localMessage.arg2 = -1;
      localMessage.obj = paramArrayList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onHippyFirstScreen");
    QLog.d("GamePAHippyFragmentV2", 1, "--->on HippyFirstScreen");
    if ((paramLong > 0L) && (paramLong > this.jdField_b_of_type_Long)) {
      this.f = (paramLong - this.jdField_b_of_type_Long);
    }
  }
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onHippShow");
    QLog.d("GamePAHippyFragmentV2", 1, "--->on hippy show");
    this.g = (paramLong - this.jdField_b_of_type_Long);
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragmentV2.7(this));
    ((IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
  }
  
  public JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gameData", QQGameHelper.b(this.jdField_a_of_type_JavaUtilList));
        localJSONObject.put("headerHeight", 373);
        localJSONObject.put("messageHeight", 0);
        localJSONObject.put("msgNum", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int == 0)
        {
          String str = QQGameHelper.a(CmGameUtil.a());
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localQQGameMsgInfo.paMsgid != null) && (localQQGameMsgInfo.paMsgid.equals(str)))
            {
              localJSONObject.put("index", i);
              paramJSONObject.put("GpInitData", localJSONObject);
              if (QLog.isColorLevel()) {
                QLog.d("GamePAHippyFragmentV2", 1, "feedEventJson=" + localJSONObject.toString());
              }
              return paramJSONObject;
            }
            i += 1;
            continue;
          }
        }
        int i = 0;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return paramJSONObject;
      }
    }
  }
  
  public void e()
  {
    super.e();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.a())) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.a(true);
    }
  }
  
  public void f()
  {
    super.f();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.a())) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.a(true);
    }
  }
  
  public void g() {}
  
  public void onClick(View paramView) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger = new QQGameTimingLogger("GamePAHippyFragmentV2", "onCreateView");
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    a(getActivity());
    a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("preGetIntentData");
    d();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("setStatusBarImmersive");
    a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initDownload");
    this.jdField_b_of_type_AndroidViewView = a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initView");
    b();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initMessage");
    loadHippy(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("loadHippy");
    g();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initGameContentView");
    QQGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilQQGameHelper$OnPreloadFeedsListener);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("setPreloadListener");
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initViewEnd");
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WadlProxyServiceUtil.a().b(this);
    if (this.jdField_b_of_type_JavaUtilList != null) {
      ArkPubicEventWrap.a().b(this.jdField_b_of_type_JavaUtilList);
    }
    GameVideoManager.a().f();
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager.deleteObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgObserver);
    }
    QQGameHelper.g();
    QQGameUIHelper.a();
  }
  
  public void onLoadHippyError(int paramInt, String paramString)
  {
    QLog.d("GamePAHippyFragmentV2", 1, "onLoadHippyError statusCode:" + paramInt + " msg:" + paramString);
    this.jdField_b_of_type_Int = 6;
    super.onLoadHippyError(paramInt, paramString);
    this.d = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    this.g = -1L;
    QLog.d("GamePAHippyFragmentV2", 1, "cilke GamePubAccount to onLoadError:" + this.d);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onLoadHippyEnd");
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragmentV2.5(this, paramInt, paramString));
  }
  
  public void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onLoadHippyEnd");
    this.d = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    QLog.d("GamePAHippyFragmentV2", 1, "click GamePubAccount to onLoadSucc:" + this.d);
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a("2747277822", 1008, true, true);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyFragmentV2
 * JD-Core Version:    0.7.0.1
 */