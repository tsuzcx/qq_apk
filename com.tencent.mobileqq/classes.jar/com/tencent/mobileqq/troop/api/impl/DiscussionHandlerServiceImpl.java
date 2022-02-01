package com.tencent.mobileqq.troop.api.impl;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class DiscussionHandlerServiceImpl
  implements IDiscussionHandlerService
{
  protected AppRuntime mApp;
  
  public void addDiscussMember(long paramLong, Object paramObject)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((DiscussionHandler)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(paramLong, (ArrayList)paramObject);
    }
  }
  
  public void checkPstnIconInfoAndUpdate(String paramString)
  {
    Object localObject = this.mApp;
    if ((localObject instanceof AppInterface))
    {
      localObject = (DiscussionHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if ((localObject != null) && (((DiscussionHandler)localObject).a() != null)) {
        ((DiscussionHandler)localObject).a().f(paramString);
      }
    }
  }
  
  public void collectDiscussion(long paramLong)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof AppInterface)) {
      ((DiscussionHandler)((AppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).d(paramLong);
    }
  }
  
  public void createDiscuss(String paramString, Object paramObject, int paramInt)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((DiscussionHandler)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramString, (ArrayList)paramObject, paramInt);
    }
  }
  
  public void createDiscuss(String paramString, Object paramObject, int paramInt, long paramLong)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((DiscussionHandler)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramString, (ArrayList)paramObject, paramInt, paramLong);
    }
  }
  
  public void getAtAllRemainCountInfo(String paramString1, String paramString2)
  {
    ((DiscussionHandler)((AppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(paramString1, paramString2);
  }
  
  public Bitmap getDiscussionFaceIcon(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof AppInterface)) {
      return ((DiscussionHandler)((AppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(paramString, paramBoolean);
    }
    return null;
  }
  
  public void kickOutMemberFromDiscussion(long paramLong1, long paramLong2)
  {
    ((DiscussionHandler)((AppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(paramLong1, paramLong2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void unCollectDiscussion(long paramLong)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof AppInterface)) {
      ((DiscussionHandler)((AppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).e(paramLong);
    }
  }
  
  public void updateDiscussionIcon(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof AppInterface)) {
      ((DiscussionHandler)((AppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).c(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.DiscussionHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */