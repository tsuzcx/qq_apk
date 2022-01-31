package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

final class MiniArkShareAsyncManager$3
  implements MiniAppCmdInterface
{
  MiniArkShareAsyncManager$3(CmdCallback paramCmdCallback) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("imageUrl", paramJSONObject.optString("imageUrl"));
    try
    {
      this.val$cmdCallback.onCmdResult(paramBoolean, localBundle);
      return;
    }
    catch (RemoteException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager.3
 * JD-Core Version:    0.7.0.1
 */