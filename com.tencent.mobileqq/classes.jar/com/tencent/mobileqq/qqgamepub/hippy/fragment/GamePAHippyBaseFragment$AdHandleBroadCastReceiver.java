package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;

class GamePAHippyBaseFragment$AdHandleBroadCastReceiver
  extends BroadcastReceiver
{
  private GamePAHippyBaseFragment$AdHandleBroadCastReceiver(GamePAHippyBaseFragment paramGamePAHippyBaseFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_qgame_delete_ad".equals(paramIntent.getAction())) {
      try
      {
        if ((this.a.getQBaseActivity() != null) && (this.a.isAdded()) && (!this.a.getQBaseActivity().isFinishing()))
        {
          GamePAHippyBaseFragment.a(this.a, paramIntent);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment.AdHandleBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */