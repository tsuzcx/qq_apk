package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper.OnPreloadFeedsListener;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameTimingLogger;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GamePubNav;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
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
  private GamePAPreloadHelper.OnPreloadFeedsListener jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGamePAPreloadHelper$OnPreloadFeedsListener = new GamePAHippyFragmentV2.2(this);
  private GamePubNav jdField_a_of_type_ComTencentMobileqqQqgamepubViewGamePubNav;
  private View b;
  
  private View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559153, null, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131368190));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGamePubNav = ((GamePubNav)paramLayoutInflater.findViewById(2131376636));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGamePubNav.a();
    QQGameUIHelper.a(this.jdField_a_of_type_AndroidViewView);
    i();
    return paramLayoutInflater;
  }
  
  private void b(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragmentV2.6(this, paramGmpEnterInfoRsp, paramBoolean));
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGamePubNav.setMoreClick(new GamePAHippyFragmentV2.3(this));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGamePubNav.setReturnClick(new GamePAHippyFragmentV2.4(this));
  }
  
  private void j()
  {
    String str = GamePubAccountHelper.a(this.jdField_a_of_type_JavaUtilList, this.h, this.jdField_a_of_type_Int).toString();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = -1;
    localMessage.arg2 = -1;
    localMessage.obj = str;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected int a()
  {
    return 10;
  }
  
  String a()
  {
    return "3";
  }
  
  void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    b(paramGmpEnterInfoRsp, paramBoolean);
  }
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyV2,call handleAdReverseFeedBack arkViewId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject).next();
        if (paramString.equals(String.valueOf(localQQGameMsgInfo.uniseq)))
        {
          this.jdField_a_of_type_JavaUtilList.remove(localQQGameMsgInfo);
          j();
        }
      }
    }
  }
  
  protected int b()
  {
    return 12;
  }
  
  public void b() {}
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onHippyFirstScreen");
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "--->on HippyFirstScreen");
    if ((paramLong > 0L) && (paramLong > this.jdField_b_of_type_Long)) {
      this.f = (paramLong - this.jdField_b_of_type_Long);
    }
  }
  
  void c(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramArrayList);
      j();
    }
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onHippShow");
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "--->on hippy show");
    this.g = (paramLong - this.jdField_b_of_type_Long);
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragmentV2.7(this));
    ((IWebProcessManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
  }
  
  protected JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gameData", GamePubAccountHelper.a(this.jdField_a_of_type_JavaUtilList, this.h, this.jdField_a_of_type_Int));
        localJSONObject.put("headerHeight", 373);
        int k = 0;
        localJSONObject.put("messageHeight", 0);
        localJSONObject.put("msgNum", this.jdField_a_of_type_Int);
        int j = k;
        Object localObject;
        if (this.jdField_a_of_type_Int == 0)
        {
          localObject = GamePubAccountHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          i = 0;
          j = k;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localQQGameMsgInfo.paMsgid == null) || (!localQQGameMsgInfo.paMsgid.equals(localObject))) {
              break label237;
            }
            j = i;
          }
        }
        localJSONObject.put("index", j);
        paramJSONObject.put("GpInitData", localJSONObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("feedEventJson=");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, ((StringBuilder)localObject).toString());
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("QQGamePub_GamePAHippyFragmentV2", 1, localJSONException.getMessage());
      }
      return paramJSONObject;
      label237:
      i += 1;
    }
  }
  
  public void g()
  {
    super.g();
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragmentV2.8(this));
  }
  
  public void h()
  {
    super.h();
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragmentV2.9(this));
  }
  
  public void onClick(View paramView) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidViewView = a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initView");
    loadHippy(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("loadHippy");
    b();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initGameContentView");
    GamePAPreloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGamePAPreloadHelper$OnPreloadFeedsListener);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("setPreloadListener");
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initViewEnd");
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    GamePAPreloadHelper.b();
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadHippyError statusCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, localStringBuilder.toString());
    this.jdField_b_of_type_Int = 6;
    super.onLoadHippyError(paramInt, paramString);
    this.d = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    this.g = -1L;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("cilke GamePubAccount to onLoadError:");
    localStringBuilder.append(this.d);
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onLoadHippyEnd");
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragmentV2.5(this, paramInt, paramString));
  }
  
  protected void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onLoadHippyEnd");
    this.d = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("click GamePubAccount to onLoadSucc:");
    localStringBuilder.append(this.d);
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, localStringBuilder.toString());
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        ((IGameMsgManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
        return;
      }
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
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePAHippyFragmentV2", 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2
 * JD-Core Version:    0.7.0.1
 */