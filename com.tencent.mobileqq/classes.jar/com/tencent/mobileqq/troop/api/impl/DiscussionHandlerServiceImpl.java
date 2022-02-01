package com.tencent.mobileqq.troop.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import mqq.app.AppRuntime;

public class DiscussionHandlerServiceImpl
  implements IDiscussionHandlerService
{
  protected AppRuntime mApp;
  
  public void checkPstnIconInfoAndUpdate(String paramString)
  {
    if ((this.mApp instanceof QQAppInterface))
    {
      DiscussionHandler localDiscussionHandler = (DiscussionHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if ((localDiscussionHandler != null) && (localDiscussionHandler.a() != null)) {
        localDiscussionHandler.a().f(paramString);
      }
    }
  }
  
  public Bitmap getDiscussionFaceIcon(String paramString, boolean paramBoolean)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      return ((DiscussionHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramString, paramBoolean);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void updateDiscussionIcon(String paramString, boolean paramBoolean)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      ((DiscussionHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.DiscussionHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */