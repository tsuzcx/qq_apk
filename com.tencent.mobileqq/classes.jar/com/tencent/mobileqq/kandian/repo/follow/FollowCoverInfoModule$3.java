package com.tencent.mobileqq.kandian.repo.follow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

class FollowCoverInfoModule$3
  implements Runnable
{
  public void run()
  {
    Object localObject = RIJSPUtils.a(FollowCoverInfoModule.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info_exposure");
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowCoverInfoModule.3
 * JD-Core Version:    0.7.0.1
 */