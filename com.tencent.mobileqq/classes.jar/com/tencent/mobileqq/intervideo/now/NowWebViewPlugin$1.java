package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class NowWebViewPlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  NowWebViewPlugin$1(NowWebViewPlugin paramNowWebViewPlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      NowWebViewPlugin.a(this.a, paramBundle.getInt("state"));
      paramBundle = this.a;
      NowWebViewPlugin.a(paramBundle, NowWebViewPlugin.a(paramBundle), NowWebViewPlugin.b(this.a));
      return;
    }
    if (i == 91)
    {
      i = paramBundle.getInt("errCode");
      paramBundle = paramBundle.getString("desc");
      NowWebViewPlugin.a(this.a, i, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowWebViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */