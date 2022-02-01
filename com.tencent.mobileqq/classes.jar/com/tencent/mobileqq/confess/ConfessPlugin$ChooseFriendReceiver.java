package com.tencent.mobileqq.confess;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
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
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 2, String.format("onReceiveResult resultCode=%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((paramInt == 0) && (paramBundle != null))
    {
      ArrayList localArrayList = paramBundle.getStringArrayList("choose_friend_uins");
      paramBundle = paramBundle.getStringArrayList("choose_friend_names");
      this.a.a(localArrayList, paramBundle);
      return;
    }
    this.a.a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.ChooseFriendReceiver
 * JD-Core Version:    0.7.0.1
 */