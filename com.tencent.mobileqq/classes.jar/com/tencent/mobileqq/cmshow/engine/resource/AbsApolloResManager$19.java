package com.tencent.mobileqq.cmshow.engine.resource;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.LogUtil;

class AbsApolloResManager$19
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResManager$19(AbsApolloResManager paramAbsApolloResManager) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramInt2 = 0;
    Object localObject;
    if (paramBoolean)
    {
      if ((paramInt1 > 0) && (!this.a.b(paramInt1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]cm_res", 2, "role rsc NOT complete.");
        }
        return;
      }
      if (paramArrayOfInt != null)
      {
        paramInt1 = paramInt2;
        while (paramInt1 < paramArrayOfInt.length)
        {
          if (!this.a.a(paramArrayOfInt[paramInt1]))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("dress rsc NOT complete, id:");
              paramString.append(paramArrayOfInt[paramInt1]);
              QLog.d("[cmshow]cm_res", 2, paramString.toString());
            }
            return;
          }
          paramInt1 += 1;
        }
      }
      paramArrayOfInt = new ArrayList(1);
      paramArrayOfInt.add(paramString);
      localObject = AbsApolloResManager.b(this.a);
      if (localObject != null)
      {
        localObject = (ApolloExtensionHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        ((ApolloExtensionHandler)localObject).notifyUI(2, true, paramArrayOfInt);
        ((ApolloExtensionHandler)localObject).a(paramString, null);
      }
      else
      {
        QLog.e("[cmshow]cm_res", 1, "[getResDownloadListener] notify isSuccess=true error, app is null!");
      }
      CmGameServerQIPCModule.b().a(paramArrayOfInt);
      if (QLog.isColorLevel())
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("apollo dress download ok notifyUI uin: ");
        paramArrayOfInt.append(LogUtil.wrapLogUin(paramString));
        QLog.d("[cmshow]cm_res", 2, paramArrayOfInt.toString());
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        localObject = AbsApolloResManager.b(this.a);
        if (localObject != null)
        {
          localObject = (ApolloExtensionHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
          ((ApolloExtensionHandler)localObject).notifyUI(2, false, paramArrayOfInt);
          ((ApolloExtensionHandler)localObject).a(paramString, null);
        }
        else
        {
          QLog.e("[cmshow]cm_res", 1, "[getResDownloadListener]notify isSuccess=false error, app is null!");
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("apollo dress download failed ");
        paramArrayOfInt.append(LogUtil.wrapLogUin(paramString));
        QLog.d("[cmshow]cm_res", 2, paramArrayOfInt.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.19
 * JD-Core Version:    0.7.0.1
 */