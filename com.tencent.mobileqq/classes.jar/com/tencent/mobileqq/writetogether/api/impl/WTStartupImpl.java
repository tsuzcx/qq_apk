package com.tencent.mobileqq.writetogether.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.api.IWTStartup;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class WTStartupImpl
  implements IWTStartup
{
  private static final String TAG = "WTStartupImpl";
  
  private static boolean checkAnonymous(Context paramContext, String paramString)
  {
    boolean bool = ((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(paramString);
    if (bool) {
      QQToast.a(paramContext, 2131720453, 0).a();
    }
    return bool;
  }
  
  private static boolean checkGag(AppRuntime paramAppRuntime, Context paramContext, String paramString)
  {
    boolean bool = isGag(paramAppRuntime, paramString);
    if (bool) {
      QQToast.a(paramContext, 2131720463, 0).a();
    }
    return bool;
  }
  
  private static boolean checkNetwork(Context paramContext)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(paramContext);
    if (!bool) {
      QQToast.a(paramContext, 2131720472, 0).a();
    }
    return bool;
  }
  
  public static boolean isGag(AppRuntime paramAppRuntime, String paramString)
  {
    return ((ITroopGagService)paramAppRuntime.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(paramString, true).a;
  }
  
  public void launchEditor(Context paramContext, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!checkNetwork(paramContext)) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Launch Editor] - Click WT message. docId: ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("WTStartupImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("KEY_CANCEL_OR_BACK", "VALUE_BACK");
    OpenDocParam localOpenDocParam = new OpenDocParam();
    localOpenDocParam.jdField_f_of_type_Int = paramInt1;
    localOpenDocParam.k = paramString2;
    localOpenDocParam.jdField_f_of_type_JavaLangString = paramString1;
    localOpenDocParam.g = 0;
    ((Bundle)localObject).putParcelable("KEY_LAUNCH_EDITOR_PARAM", localOpenDocParam);
    if ((paramContext instanceof Activity))
    {
      WriteTogetherEditorFragment.a((Activity)paramContext, WriteTogetherEditorFragment.class, (Bundle)localObject, paramInt2);
      return;
    }
    if (paramActivity != null)
    {
      WriteTogetherEditorFragment.a(paramActivity, WriteTogetherEditorFragment.class, (Bundle)localObject, paramInt2);
      return;
    }
    WriteTogetherEditorFragment.a(paramContext, WriteTogetherEditorFragment.class, (Bundle)localObject);
  }
  
  public void launchWriteTogetherEditor(AppRuntime paramAppRuntime, Context paramContext, Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!checkNetwork(paramContext)) {
      return;
    }
    if (checkAnonymous(paramContext, paramString2)) {
      return;
    }
    if (checkGag(paramAppRuntime, paramContext, paramString2)) {
      return;
    }
    if (!WriteTogetherUtils.a(paramAppRuntime, paramString2))
    {
      QQToast.a(paramContext, 2131720455, 0).a();
      return;
    }
    if (paramString1 == null) {
      paramString1 = "";
    }
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      if (paramInt1 == 1) {
        paramContext = "input box";
      } else if (paramInt1 == 2) {
        paramContext = "full screen";
      } else {
        paramContext = "unknown";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Launch Editor] - ");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("WTStartupImpl", 2, ((StringBuilder)localObject).toString());
    }
    paramContext = new Bundle();
    Object localObject = WriteTogetherUtils.a(paramString1);
    paramContext.putString("leftViewText", HardCodeUtil.a(2131720417));
    paramContext.putString("KEY_CANCEL_OR_BACK", "VALUE_CANCEL");
    OpenDocParam localOpenDocParam = new OpenDocParam();
    localOpenDocParam.a = ((String)localObject);
    localOpenDocParam.jdField_f_of_type_Int = paramInt1;
    localOpenDocParam.k = paramString2;
    if ((paramInt1 == 5) || (paramInt1 == 6)) {
      localOpenDocParam.g = 0;
    }
    paramContext.putParcelable("KEY_LAUNCH_EDITOR_PARAM", localOpenDocParam);
    WriteTogetherEditorFragment.a(paramActivity, WriteTogetherEditorFragment.class, paramContext, paramInt2);
    paramInt2 = WriteTogetherUtils.a(paramAppRuntime, paramString2);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("");
    paramAppRuntime.append(WriteTogetherUtils.a(paramInt1));
    paramAppRuntime = paramAppRuntime.toString();
    paramContext = new StringBuilder();
    paramContext.append("");
    paramInt1 = i;
    if (TextUtils.isEmpty(paramString1)) {
      paramInt1 = 1;
    }
    paramContext.append(paramInt1);
    ReportController.b(null, "dc00898", "", "", "0X800AF2F", "0X800AF2F", paramInt2, 0, paramAppRuntime, paramContext.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.impl.WTStartupImpl
 * JD-Core Version:    0.7.0.1
 */