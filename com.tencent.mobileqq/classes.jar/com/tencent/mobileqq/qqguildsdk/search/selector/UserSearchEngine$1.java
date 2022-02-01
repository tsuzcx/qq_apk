package com.tencent.mobileqq.qqguildsdk.search.selector;

import android.os.Handler;
import com.tencent.mobileqq.qqguildsdk.search.model.SearchRequestModel;
import java.util.List;

class UserSearchEngine$1
  implements Runnable
{
  UserSearchEngine$1(UserSearchEngine paramUserSearchEngine) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = UserSearchEngine.a((UserSearchEngine)localObject, new SearchRequestModel(((UserSearchEngine)localObject).c, this.this$0.d));
    this.this$0.b.post(new UserSearchEngine.1.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.UserSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */