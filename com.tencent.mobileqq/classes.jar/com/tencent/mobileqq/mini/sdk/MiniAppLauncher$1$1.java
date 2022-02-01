package com.tencent.mobileqq.mini.sdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class MiniAppLauncher$1$1
  implements Runnable
{
  MiniAppLauncher$1$1(MiniAppLauncher.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = this.val$ret;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("errMsg");
      QQToast.makeText(BaseApplicationImpl.getContext(), 1, (CharSequence)localObject, 0).show();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131892657, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.1.1
 * JD-Core Version:    0.7.0.1
 */