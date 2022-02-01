package com.tencent.mobileqq.vas.handler.api.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.handler.api.IClubContentUpdateHandler;
import mqq.app.MobileQQ;

public class ClubContentUpdateHandlerImpl
  implements IClubContentUpdateHandler
{
  public void checkJsonVersion(Context paramContext)
  {
    paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)paramContext.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
    if (localClubContentUpdateHandler != null) {
      localClubContentUpdateHandler.a(paramContext.getApplication().getApplicationContext());
    }
  }
  
  public void saveQVIPResConfigContent(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
    if (localClubContentUpdateHandler != null) {
      localClubContentUpdateHandler.a(localQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.handler.api.impl.ClubContentUpdateHandlerImpl
 * JD-Core Version:    0.7.0.1
 */