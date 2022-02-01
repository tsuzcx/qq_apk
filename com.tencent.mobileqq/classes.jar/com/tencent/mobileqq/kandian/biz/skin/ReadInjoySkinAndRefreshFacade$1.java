package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;

class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  ReadInjoySkinAndRefreshFacade$1(ReadInjoySkinAndRefreshFacade paramReadInjoySkinAndRefreshFacade) {}
  
  public void run()
  {
    Object localObject = (ReadInJoyRefreshManager)this.this$0.a.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    int i = ReadInjoySkinAndRefreshFacade.a(this.this$0);
    RefreshData localRefreshData = ((ReadInJoyRefreshManager)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(ReadInjoySkinAndRefreshFacade.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime))
    {
      if (RefreshRes.a(localRefreshData.id))
      {
        if (localRefreshData.isShown)
        {
          ((ReadInJoyRefreshManager)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((ReadInJoyRefreshManager)localObject).a(true);
        }
        else
        {
          ((ReadInJoyRefreshManager)localObject).a(0, "", -1L, i);
        }
      }
      else
      {
        ((ReadInJoyRefreshManager)localObject).a(0, "", -1L, i);
        ((ReadInJoyRefreshManager)localObject).a(localRefreshData, ReadInjoySkinAndRefreshFacade.a(this.this$0));
      }
    }
    else {
      ((ReadInJoyRefreshManager)localObject).a(0, "", -1L, i);
    }
    localObject = (GuideData)((ReadInJoyOperationManager)this.this$0.a.getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER)).a("operation_guide");
    SkinData localSkinData = ((ReadInJoySkinManager)this.this$0.a.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.this$0.a.getApp());
    ((ReadInJoySkinHandler)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.READ_INJOY_SKIN_HANDLER)).a(localSkinData, null, localRefreshData, (GuideData)localObject, ReadInjoySkinAndRefreshFacade.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */