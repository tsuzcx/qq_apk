package com.tencent.mobileqq.emosm.favroaming;

import java.util.ArrayList;
import java.util.List;

class FavroamingManager$8
  implements Runnable
{
  FavroamingManager$8(FavroamingManager paramFavroamingManager, int paramInt, FavroamingManager.AddCustomEmotionsCallback paramAddCustomEmotionsCallback, List paramList) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    FavroamingManager.a(this.this$0, new FavroamingManager.8.1(this, (List)localObject));
    localObject = (String)this.jdField_a_of_type_JavaUtilList.get(0);
    FavroamingManager.a(this.this$0, (String)localObject, FavroamingManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8
 * JD-Core Version:    0.7.0.1
 */