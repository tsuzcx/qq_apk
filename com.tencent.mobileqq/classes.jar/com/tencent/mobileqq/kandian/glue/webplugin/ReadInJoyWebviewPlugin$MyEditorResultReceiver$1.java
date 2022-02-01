package com.tencent.mobileqq.kandian.glue.webplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class ReadInJoyWebviewPlugin$MyEditorResultReceiver$1
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$MyEditorResultReceiver$1(ReadInJoyWebviewPlugin.MyEditorResultReceiver paramMyEditorResultReceiver, Intent paramIntent, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("BUNDLE_KEY_JS_OBJ", "");
    if (ReadInJoyWebviewPlugin.MyEditorResultReceiver.a(this.c, paramBundle, this.a)) {
      return;
    }
    this.c.a(this.b, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.MyEditorResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */