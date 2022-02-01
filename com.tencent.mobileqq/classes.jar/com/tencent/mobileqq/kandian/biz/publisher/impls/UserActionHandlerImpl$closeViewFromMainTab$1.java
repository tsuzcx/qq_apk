package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserActionHandlerImpl$closeViewFromMainTab$1
  implements Runnable
{
  UserActionHandlerImpl$closeViewFromMainTab$1(Activity paramActivity) {}
  
  public final void run()
  {
    Intent localIntent = ReadInJoyActivityHelper.b((Context)this.a, 0, 70);
    if (localIntent != null) {
      localIntent.putExtra("edit_video_jump_and_refresh", true);
    }
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl.closeViewFromMainTab.1
 * JD-Core Version:    0.7.0.1
 */