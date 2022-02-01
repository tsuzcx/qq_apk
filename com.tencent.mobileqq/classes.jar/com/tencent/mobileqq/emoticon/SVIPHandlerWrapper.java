package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.qphone.base.util.QLog;

public class SVIPHandlerWrapper
{
  public static Bundle a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    int i = ((ISVIPHandler)paramBaseQQAppInterface.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).g();
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("call, vipType = ");
      paramBaseQQAppInterface.append(i);
      QLog.i("EmoticonContentProvider", 2, paramBaseQQAppInterface.toString());
    }
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt(paramString, i);
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SVIPHandlerWrapper
 * JD-Core Version:    0.7.0.1
 */