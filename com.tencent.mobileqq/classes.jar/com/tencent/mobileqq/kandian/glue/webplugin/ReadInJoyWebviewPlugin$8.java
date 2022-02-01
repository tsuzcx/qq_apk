package com.tencent.mobileqq.kandian.glue.webplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class ReadInJoyWebviewPlugin$8
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$8(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, int paramInt, Intent paramIntent, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("BUNDLE_KEY_JS_OBJ", "");
    if (ReadInJoyWebviewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginReadInJoyWebviewPlugin, paramBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.8
 * JD-Core Version:    0.7.0.1
 */