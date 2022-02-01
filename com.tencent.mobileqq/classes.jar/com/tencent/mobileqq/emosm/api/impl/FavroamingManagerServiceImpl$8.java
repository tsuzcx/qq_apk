package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback;
import java.util.ArrayList;
import java.util.List;

class FavroamingManagerServiceImpl$8
  implements Runnable
{
  FavroamingManagerServiceImpl$8(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl, int paramInt, IFavroamingManagerService.AddCustomEmotionsCallback paramAddCustomEmotionsCallback, List paramList) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    FavroamingManagerServiceImpl.access$1702(this.this$0, new FavroamingManagerServiceImpl.8.1(this, (List)localObject));
    localObject = (String)this.jdField_a_of_type_JavaUtilList.get(0);
    FavroamingManagerServiceImpl localFavroamingManagerServiceImpl = this.this$0;
    FavroamingManagerServiceImpl.access$1900(localFavroamingManagerServiceImpl, (String)localObject, FavroamingManagerServiceImpl.access$1700(localFavroamingManagerServiceImpl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */