package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

public class QWalletCommonJsPlugin$ChooseQQFriendForTransferReceiver
  extends ResultReceiver
{
  private QWalletCommonJsPlugin mJsPlugin;
  
  public QWalletCommonJsPlugin$ChooseQQFriendForTransferReceiver(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.dochooseQQFriendsForTransferResult(null);
      return;
    }
    ArrayList localArrayList = paramBundle.getStringArrayList("choose_friend_uins");
    paramBundle = paramBundle.getStringArrayList("choose_friend_names");
    if ((localArrayList == null) || (localArrayList.isEmpty()) || (paramBundle == null) || (paramBundle.isEmpty()))
    {
      this.mJsPlugin.dochooseQQFriendsForTransferResult(null);
      return;
    }
    this.mJsPlugin.startTransactionActivity((String)localArrayList.get(0), (String)paramBundle.get(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.ChooseQQFriendForTransferReceiver
 * JD-Core Version:    0.7.0.1
 */