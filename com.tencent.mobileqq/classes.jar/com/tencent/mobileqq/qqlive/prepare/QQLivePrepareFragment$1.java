package com.tencent.mobileqq.qqlive.prepare;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import java.util.Map;

class QQLivePrepareFragment$1
  extends QQLiveAnchorRoomThirdPushBaseCallback
{
  QQLivePrepareFragment$1(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void a(QQLiveAnchorRoomState paramQQLiveAnchorRoomState1, QQLiveAnchorRoomState paramQQLiveAnchorRoomState2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStateChange: ");
    localStringBuilder.append(paramQQLiveAnchorRoomState1.name());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramQQLiveAnchorRoomState2.name());
    QLog.d("QQLivePrepareFragment", 1, localStringBuilder.toString());
  }
  
  public void a(QQLiveAnchorDataAuth paramQQLiveAnchorDataAuth)
  {
    super.a(paramQQLiveAnchorDataAuth);
    if ((!paramQQLiveAnchorDataAuth.isSuccess) && (paramQQLiveAnchorDataAuth.errorMsg != null))
    {
      if (paramQQLiveAnchorDataAuth.errorMsg.originErrCode == 999) {
        paramQQLiveAnchorDataAuth = "实名验证取消";
      } else {
        paramQQLiveAnchorDataAuth = "实名验证失败";
      }
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      {
        QQToast.makeText(localFragmentActivity, paramQQLiveAnchorDataAuth, 1).show();
        localFragmentActivity.finish();
      }
    }
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPrepare, isSuccess:");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPrepare.isSuccess);
    QLog.i("QQLivePrepareFragment", 1, ((StringBuilder)localObject).toString());
    QQLivePrepareFragment.b(this.a).a(paramQQLiveAnchorDataPrepare);
    localObject = this.a;
    QQLivePrepareFragment.a((QQLivePrepareFragment)localObject, QQLivePrepareFragment.e((QQLivePrepareFragment)localObject));
    QQLivePrepareFragment.b(this.a).b = paramQQLiveAnchorDataPrepare.isSuccess;
    QQLivePrepareFragment.f(this.a);
    localObject = new QQLiveAnchorAutoCheckPullPlayParams();
    ((QQLiveAnchorAutoCheckPullPlayParams)localObject).autoCheckPullPlay = true;
    ((QQLiveAnchorAutoCheckPullPlayParams)localObject).isMute = true;
    if (QQLivePrepareFragment.c(this.a) != null) {
      QQLivePrepareFragment.c(this.a).getPushInfo(QQLivePrepareFragment.a(this.a, paramQQLiveAnchorDataPrepare), (QQLiveAnchorAutoCheckPullPlayParams)localObject, this);
    }
    if ((paramQQLiveAnchorDataPrepare.roomAttr == null) || (paramQQLiveAnchorDataPrepare.roomAttr.gameInfo == null)) {
      QQLivePrepareFragment.b(this.a).a(true);
    }
    QQLivePrepareFragment.g(this.a);
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    super.a(paramQQLiveAnchorDataPullInfo);
    if (QQLivePrepareFragment.a(this.a)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetPullInfo, isSuccess:");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPullInfo.isSuccess);
    QLog.i("QQLivePrepareFragment", 1, ((StringBuilder)localObject).toString());
    if ((paramQQLiveAnchorDataPullInfo.isSuccess) && (!TextUtils.isEmpty(paramQQLiveAnchorDataPullInfo.defaultPlayUrl)) && (QQLivePrepareFragment.c(this.a) != null))
    {
      localObject = new QQLiveAnchorAutoCheckPullPlayParams();
      ((QQLiveAnchorAutoCheckPullPlayParams)localObject).isMute = true;
      QQLivePrepareFragment.c(this.a).startCheck(paramQQLiveAnchorDataPullInfo.defaultPlayUrl, (QQLiveAnchorAutoCheckPullPlayParams)localObject, QQLivePrepareFragment.d(this.a));
    }
  }
  
  public void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    super.a(paramQQLiveAnchorDataPushInfo);
    if (QQLivePrepareFragment.a(this.a)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetPushInfo, isSuccess:");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPushInfo.isSuccess);
    QLog.d("QQLivePrepareFragment", 1, ((StringBuilder)localObject).toString());
    if (paramQQLiveAnchorDataPushInfo.isSuccess)
    {
      localObject = new ThirdPushRtmpData();
      ((ThirdPushRtmpData)localObject).a = paramQQLiveAnchorDataPushInfo.serverPart;
      ((ThirdPushRtmpData)localObject).b = paramQQLiveAnchorDataPushInfo.streamParam;
      QQLivePrepareFragment.b(this.a).j.setValue(localObject);
      return;
    }
    QQLivePrepareFragment.b(this.a).j.setValue(null);
  }
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSet, isSuccess:");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataSet.isSuccess);
    QLog.i("QQLivePrepareFragment", 1, ((StringBuilder)localObject).toString());
    Map localMap = PrepareDTHelper.a(QQLivePrepareFragment.b(this.a), QQLivePrepareFragment.h(this.a));
    if ((!paramQQLiveAnchorDataSet.isSuccess) && (paramQQLiveAnchorDataSet.errorMsg != null)) {
      localMap.put("qqlive_fail_reason", paramQQLiveAnchorDataSet.errorMsg.bizErrMsg);
    }
    ILiveReportUtil localILiveReportUtil = ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
    if (paramQQLiveAnchorDataSet.isSuccess) {
      localObject = "ev_qqlive_start_success";
    } else {
      localObject = "ev_qqlive_start_failure";
    }
    localILiveReportUtil.a((String)localObject, localMap);
    if (paramQQLiveAnchorDataSet.isSuccess)
    {
      if (QQLivePrepareFragment.c(this.a) != null) {
        QQLivePrepareFragment.c(this.a).stopCheck();
      }
      if (QQLivePrepareFragment.b(this.a).a().roomAttr.liveRoomType == 1)
      {
        QQLivePrepareFragment.i(this.a);
        return;
      }
      QQLivePrepareFragment.j(this.a);
    }
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    super.a(paramQQLiveAnchorDataThirdPushCheck);
    if (QQLivePrepareFragment.a(this.a)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onThirdPushChecked, isSuccess:");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataThirdPushCheck.isSuccess);
    QLog.i("QQLivePrepareFragment", 1, ((StringBuilder)localObject).toString());
    localObject = (ThirdPushRtmpData)QQLivePrepareFragment.b(this.a).j.getValue();
    if (localObject != null)
    {
      ((ThirdPushRtmpData)localObject).c = paramQQLiveAnchorDataThirdPushCheck.isSuccess;
      QQLivePrepareFragment.b(this.a).j.setValue(localObject);
    }
  }
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (paramQQLiveErrorMsg != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError: ");
      localStringBuilder.append(paramQQLiveErrorMsg.toString());
      QLog.e("QQLivePrepareFragment", 1, localStringBuilder.toString());
      if (paramQQLiveErrorMsg.originErrCode == 1007)
      {
        QQLivePrepareFragment.a(this.a, paramQQLiveErrorMsg.originErrMsg);
        return;
      }
      QQLivePrepareFragment.b(this.a, paramQQLiveErrorMsg.originErrMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.1
 * JD-Core Version:    0.7.0.1
 */