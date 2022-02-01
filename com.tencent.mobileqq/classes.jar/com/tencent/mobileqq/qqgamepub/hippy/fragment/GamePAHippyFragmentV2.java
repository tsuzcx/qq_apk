package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenterV2;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyViewV2;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GamePubNav;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class GamePAHippyFragmentV2
  extends GamePAHippyBaseFragment<QQGameHippyPresenterV2>
  implements IQQGameHippyViewV2<QQGameHippyPresenterV2>
{
  public View b;
  private ViewGroup c;
  private GamePubNav d;
  
  private View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624908, null, false);
    this.c = ((ViewGroup)paramLayoutInflater.findViewById(2131435055));
    this.d = ((GamePubNav)paramLayoutInflater.findViewById(2131444897));
    this.b = this.d.getRightImg();
    QQGameUIHelper.a(this.b);
    h();
    return paramLayoutInflater;
  }
  
  private void h()
  {
    this.d.setMoreClick(new GamePAHippyFragmentV2.1(this));
    this.d.setReturnClick(new GamePAHippyFragmentV2.2(this));
  }
  
  private void i()
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyFragmentV2.5(this));
  }
  
  public void a()
  {
    super.a();
    i();
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    ((QQGameHippyPresenterV2)this.a).a(3);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("onHippyFirstScreen");
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "--->on HippyFirstScreen");
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).c(paramLong);
  }
  
  public void b()
  {
    super.b();
    i();
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    ((QQGameHippyPresenterV2)this.a).a(4);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("onHippShow");
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "--->on hippy show");
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).d(paramLong);
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragmentV2.4(this));
  }
  
  public void e()
  {
    try
    {
      f();
      ((IGamePubAccountMsgService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGamePubAccountMsgService.class, "")).showFirstOperationMsg();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePAHippyFragmentV2", 2, localThrowable, new Object[0]);
    }
  }
  
  public void f()
  {
    boolean bool = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isPubAccountReceiveMsg((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    if (!bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showGameCenterNewEntryByNoticeMsg--->isFlowPa: ");
      ((StringBuilder)localObject1).append(bool);
      QLog.i("QQGamePub_GamePAHippyFragmentV2", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = GamePubAccountHelper.e();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showGameCenterNewEntryByNoticeMsg: ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("QQGamePub_GamePAHippyFragmentV2", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = ((JSONObject)localObject1).optJSONObject("inner");
    if (localObject2 != null)
    {
      this.d.d();
      this.d.setNoticeId(((JSONObject)localObject1).optString("notice_id"));
      this.d.setBubbleJumpUrl(((JSONObject)localObject2).optString("jump_url"));
      this.d.setUrlType(((JSONObject)localObject2).optInt("jump_type"));
      this.d.a((JSONObject)localObject1);
      return;
    }
    this.d.c();
    this.d.e();
    QLog.w("QQGamePub_GamePAHippyFragmentV2", 1, "push config is empty");
  }
  
  public QQGameHippyPresenterV2 g()
  {
    return new QQGameHippyPresenterV2();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = a(paramLayoutInflater);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("initView");
    loadHippy(this.c);
    ((QQGameHippyPresenterV2)this.a).a(2);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("loadHippy");
    e();
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("initGameContentView");
    ((QQGameHippyPresenterV2)this.a).y();
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("initPreloadListener");
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("initViewEnd");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    super.onLoadHippyError(paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadHippyError statusCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, localStringBuilder.toString());
    ((QQGameHippyPresenterV2)this.a).a(6);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a(false);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).d(-1L);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("onLoadHippyEnd");
    ThreadManagerV2.executeOnSubThread(new GamePAHippyFragmentV2.3(this, paramInt, paramString));
  }
  
  protected void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    ((QQGameHippyPresenterV2)this.a).a(5);
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a("onLoadHippyEnd");
    ((QQGameHippyModel)((QQGameHippyPresenterV2)this.a).b()).a(true);
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      if (!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isPubAccountReceiveMsg((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)))
      {
        i();
        this.d.e();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePAHippyFragmentV2", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2
 * JD-Core Version:    0.7.0.1
 */