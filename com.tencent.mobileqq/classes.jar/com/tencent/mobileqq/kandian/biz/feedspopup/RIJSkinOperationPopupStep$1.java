package com.tencent.mobileqq.kandian.biz.feedspopup;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyOperationManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.biz.skin.RefreshRes;
import com.tencent.qphone.base.util.QLog;

class RIJSkinOperationPopupStep$1
  implements Runnable
{
  RIJSkinOperationPopupStep$1(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep) {}
  
  public void run()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoySkinHandler localReadInJoySkinHandler = (ReadInJoySkinHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.READ_INJOY_SKIN_HANDLER);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    Object localObject1 = (ReadInJoyOperationManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
    ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    localObject2 = localReadInJoyRefreshManager.a(RIJSkinOperationPopupStep.a(this.this$0), 0);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel()) {
      if (localObject2 == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSkinAndRefresh refreshData = ");
        localStringBuilder.append(localObject2);
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSkinAndRefresh refreshData = ");
        localStringBuilder.append(((RefreshData)localObject2).toString());
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
    }
    int i = (int)(System.currentTimeMillis() / 1000L);
    boolean bool1;
    if ((localObject2 != null) && (((RefreshData)localObject2).isShowInSource(0))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localObject2 != null) && (i >= ((RefreshData)localObject2).beginTime) && (i <= ((RefreshData)localObject2).endTime)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((bool1) && (bool2))
    {
      bool1 = RefreshRes.a(((RefreshData)localObject2).id);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =");
        localStringBuilder.append(bool1);
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
      if (bool1)
      {
        if (((RefreshData)localObject2).isShown)
        {
          localReadInJoyRefreshManager.a(1, ((RefreshData)localObject2).id, ((RefreshData)localObject2).seq, 0);
          localReadInJoyRefreshManager.a(true);
        }
        else
        {
          localReadInJoyRefreshManager.a(0, "", -1L, 0);
        }
      }
      else
      {
        localReadInJoyRefreshManager.a(0, "", -1L, 0);
        localReadInJoyRefreshManager.a((RefreshData)localObject2, 0);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSkinAndRefresh dataMatch =");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",timeMatch = ");
        localStringBuilder.append(bool2);
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
      localReadInJoyRefreshManager.a(0, "", -1L, 0);
    }
    localObject1 = (GuideData)((ReadInJoyOperationManager)localObject1).a("operation_guide");
    localReadInJoySkinHandler.a(localReadInJoySkinManager.a(RIJSkinOperationPopupStep.a(this.this$0)), null, (RefreshData)localObject2, (GuideData)localObject1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */