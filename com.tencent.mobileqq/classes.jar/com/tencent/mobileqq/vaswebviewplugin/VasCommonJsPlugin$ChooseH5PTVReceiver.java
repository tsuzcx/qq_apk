package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;

public class VasCommonJsPlugin$ChooseH5PTVReceiver
  extends ResultReceiver
{
  private VasCommonJsPlugin mJsPlugin;
  
  public VasCommonJsPlugin$ChooseH5PTVReceiver(VasCommonJsPlugin paramVasCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramVasCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.doChooseFriendResultForH5(null, null, null, null);
      return;
    }
    ArrayList localArrayList1 = paramBundle.getStringArrayList("choose_friend_uins");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("choose_friend_phones");
    ArrayList localArrayList3 = paramBundle.getStringArrayList("choose_friend_names");
    paramBundle = paramBundle.getStringArrayList("choose_friend_types");
    this.mJsPlugin.doChooseFriendResultForH5(localArrayList1, localArrayList2, localArrayList3, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.ChooseH5PTVReceiver
 * JD-Core Version:    0.7.0.1
 */