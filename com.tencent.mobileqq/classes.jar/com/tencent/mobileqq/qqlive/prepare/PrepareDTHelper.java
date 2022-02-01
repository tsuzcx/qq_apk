package com.tencent.mobileqq.qqlive.prepare;

import android.view.View;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import java.util.HashMap;
import java.util.Map;

public class PrepareDTHelper
{
  public static Map<String, String> a(PrepareFragmentViewModel paramPrepareFragmentViewModel, IQQLiveSDK paramIQQLiveSDK)
  {
    HashMap localHashMap = new HashMap();
    if ((paramPrepareFragmentViewModel != null) && (paramPrepareFragmentViewModel.a() != null))
    {
      paramPrepareFragmentViewModel = paramPrepareFragmentViewModel.a;
      localHashMap.put("qqlive_zhibo_type", String.valueOf(paramPrepareFragmentViewModel.roomAttr.liveRoomType));
      localHashMap.put("qqlive_room_id", String.valueOf(paramPrepareFragmentViewModel.roomInfo.id));
    }
    if ((paramIQQLiveSDK.getLoginModule() != null) && (paramIQQLiveSDK.getLoginModule().getLoginInfo() != null))
    {
      paramPrepareFragmentViewModel = String.valueOf(paramIQQLiveSDK.getLoginModule().getLoginInfo().uid);
      localHashMap.put("qqlive_user_id", paramPrepareFragmentViewModel);
      localHashMap.put("qqlive_anchor_id", paramPrepareFragmentViewModel);
    }
    localHashMap.put("zengzhi_tracedetail ", "");
    return localHashMap;
  }
  
  public static void a(View paramView, String paramString, Map<String, String> paramMap)
  {
    if (paramView != null)
    {
      paramMap = new HashMap(paramMap);
      ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(paramView, true, null, paramString, paramMap);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrepareDaTongHelper", 1, "the view is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.PrepareDTHelper
 * JD-Core Version:    0.7.0.1
 */