package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;

public class VasCommonJsPlugin$ChooseFriendReceiver
  extends ResultReceiver
{
  private VasCommonJsPlugin mJsPlugin;
  
  public VasCommonJsPlugin$ChooseFriendReceiver(VasCommonJsPlugin paramVasCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramVasCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.doChooseFriendResult(null, null, null, null, null, null, null, null);
      return;
    }
    ArrayList localArrayList1 = paramBundle.getStringArrayList("choose_friend_uins");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("choose_friend_phones");
    ArrayList localArrayList3 = paramBundle.getStringArrayList("choose_friend_names");
    ArrayList localArrayList4 = paramBundle.getStringArrayList("choose_friend_group_uins");
    ArrayList localArrayList5 = paramBundle.getStringArrayList("choose_friend_group_names");
    ArrayList localArrayList6 = paramBundle.getIntegerArrayList("choose_friend_group_counts");
    paramBundle = paramBundle.getIntegerArrayList("choose_friend_group_types");
    this.mJsPlugin.doChooseFriendResult(localArrayList1, localArrayList2, localArrayList3, null, localArrayList4, localArrayList5, localArrayList6, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.ChooseFriendReceiver
 * JD-Core Version:    0.7.0.1
 */