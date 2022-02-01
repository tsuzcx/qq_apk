package com.tencent.mobileqq.vas.hippy;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONException;
import org.json.JSONObject;

public class VasFriendInfoHippyHelper$ChooseFriendReceiver
  extends ResultReceiver
{
  private Promise a;
  
  public VasFriendInfoHippyHelper$ChooseFriendReceiver(Promise paramPromise, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramPromise;
  }
  
  public void a(Promise paramPromise)
  {
    this.a = paramPromise;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt == 0) && (paramBundle != null))
    {
      JSONObject localJSONObject = VasFriendInfoHippyHelper.a(null, paramBundle.getStringArrayList("choose_friend_uins"), paramBundle.getStringArrayList("choose_friend_phones"), paramBundle.getStringArrayList("choose_friend_names"), null, paramBundle.getStringArrayList("choose_friend_group_uins"), paramBundle.getStringArrayList("choose_friend_group_names"), paramBundle.getIntegerArrayList("choose_friend_group_counts"), paramBundle.getIntegerArrayList("choose_friend_group_types"));
      if (localJSONObject != null)
      {
        try
        {
          localJSONObject.put("dialog_input_callback", paramBundle.getString("emsg"));
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
        this.a.resolve(VasHippyUtils.a(paramInt, "success", localJSONObject));
      }
      return;
    }
    this.a.reject(VasHippyUtils.a(paramInt, "resultData is null", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasFriendInfoHippyHelper.ChooseFriendReceiver
 * JD-Core Version:    0.7.0.1
 */