package com.tencent.mobileqq.soload.biz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class SoLoadIPCModule
  extends QIPCModule
{
  public static final String ACTION_COM_IPC_UTILS = "ComIPCUtils";
  public static final String KEY_IS_SYNC = "is_sync";
  public static final String KEY_LOAD_ITEM = "load_item";
  public static final String KEY_LOAD_PARAM = "load_param";
  public static final String KEY_OPER_TYPE = "oper_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESULT = "res";
  public static final String NAME = "SoLoadIPCModule";
  public static final int OPER_TYPE_GET_SO_LOAD_INFO = 17;
  public static final int OPER_TYPE_TEST_FILE_EXIST = 18;
  private static final String TAG = "SoLoadWidget.SoLoadIPCModule";
  public static SoLoadIPCModule mInstance;
  
  private SoLoadIPCModule()
  {
    super("SoLoadIPCModule");
  }
  
  public static SoLoadIPCModule getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new SoLoadIPCModule();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("SoLoadWidget.SoLoadIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    if ("ComIPCUtils".equals(paramString)) {
      try
      {
        int i = paramBundle.getInt("oper_type", -1);
        if (i != 17)
        {
          if (i != 18) {
            return null;
          }
          paramInt = SoDataUtil.a(paramBundle.getString("path"));
          paramString = new Bundle();
          paramString.putInt("res", paramInt);
          return EIPCResult.createSuccessResult(paramString);
        }
        boolean bool = paramBundle.getBoolean("is_sync");
        paramString = (LoadParam)paramBundle.getSerializable("load_param");
        paramBundle = (LoadParam.LoadItem)paramBundle.getSerializable("load_item");
        localObject = (ISoLoaderService)QRoute.api(ISoLoaderService.class);
        if (localObject == null) {
          return null;
        }
        if (bool)
        {
          paramString = ((ISoLoaderService)localObject).getSoLoadInfoTaskSync(paramString, paramBundle);
          paramBundle = new Bundle();
          paramBundle.putSerializable("res", paramString);
          return EIPCResult.createSuccessResult(paramBundle);
        }
        ((ISoLoaderService)localObject).getSoLoadInfoTaskAsync(paramString, paramBundle, new SoLoadIPCModule.1(this, paramInt));
        return null;
      }
      catch (Throwable paramString)
      {
        QLog.e("SoLoadWidget.SoLoadIPCModule", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.SoLoadIPCModule
 * JD-Core Version:    0.7.0.1
 */