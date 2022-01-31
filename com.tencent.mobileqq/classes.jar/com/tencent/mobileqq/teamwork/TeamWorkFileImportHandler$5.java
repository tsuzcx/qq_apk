package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import axem;
import axfe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$5
  implements Runnable
{
  public TeamWorkFileImportHandler$5(axem paramaxem, String paramString) {}
  
  public void run()
  {
    int i = 0;
    if (this.this$0.app == null) {}
    Object localObject;
    do
    {
      return;
      localObject = axfe.a(this.a, this.this$0.app.getCurrentAccountUin());
    } while (TextUtils.isEmpty((CharSequence)localObject));
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("TotalUnreadNum")) {
        i = ((JSONObject)localObject).getInt("TotalUnreadNum");
      }
      this.this$0.notifyUI(3, true, new Object[] { Integer.valueOf(i) });
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("TeamWorkFileImportHandler", 1, localJSONException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.5
 * JD-Core Version:    0.7.0.1
 */