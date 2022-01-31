package com.tencent.mobileqq.confess;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;

public class ConfessPlugin$ChooseFriendReceiver
  extends ResultReceiver
{
  private ConfessPlugin a;
  
  public ConfessPlugin$ChooseFriendReceiver(ConfessPlugin paramConfessPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramConfessPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.a.a(null, null);
      return;
    }
    ArrayList localArrayList = paramBundle.getStringArrayList("choose_friend_uins");
    paramBundle = paramBundle.getStringArrayList("choose_friend_names");
    this.a.a(localArrayList, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.ChooseFriendReceiver
 * JD-Core Version:    0.7.0.1
 */