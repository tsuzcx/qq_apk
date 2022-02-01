package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

class NowWebViewPlugin$1
  implements TroopMemberApiClient.Callback
{
  NowWebViewPlugin$1(NowWebViewPlugin paramNowWebViewPlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      NowWebViewPlugin.a(this.a, paramBundle.getInt("state"));
      NowWebViewPlugin.a(this.a, NowWebViewPlugin.a(this.a), NowWebViewPlugin.b(this.a));
    }
    while (i != 91) {
      return;
    }
    i = paramBundle.getInt("errCode");
    paramBundle = paramBundle.getString("desc");
    NowWebViewPlugin.a(this.a, i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowWebViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */