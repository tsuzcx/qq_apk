package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

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
    if ((paramInt != 0) || (paramBundle == null)) {
      VasCommonJsPlugin.access$000(this.mJsPlugin);
    }
    Object localObject;
    do
    {
      return;
      localObject = paramBundle.getStringArrayList("choose_friend_uins");
      ArrayList localArrayList1 = paramBundle.getStringArrayList("choose_friend_phones");
      ArrayList localArrayList2 = paramBundle.getStringArrayList("choose_friend_names");
      ArrayList localArrayList3 = paramBundle.getStringArrayList("choose_friend_group_uins");
      ArrayList localArrayList4 = paramBundle.getStringArrayList("choose_friend_group_names");
      ArrayList localArrayList5 = paramBundle.getIntegerArrayList("choose_friend_group_counts");
      ArrayList localArrayList6 = paramBundle.getIntegerArrayList("choose_friend_group_types");
      localObject = this.mJsPlugin.getJsBackJson(null, (List)localObject, localArrayList1, localArrayList2, null, localArrayList3, localArrayList4, localArrayList5, localArrayList6);
    } while (localObject == null);
    paramBundle = VasCommonJsPlugin.access$100(this.mJsPlugin, paramBundle, (JSONObject)localObject);
    VasCommonJsPlugin.access$200(this.mJsPlugin, this.mJsPlugin.mCallback, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.ChooseFriendReceiver
 * JD-Core Version:    0.7.0.1
 */