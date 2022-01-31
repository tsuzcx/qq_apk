package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgnt;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$4
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$4(FileJsPlugin paramFileJsPlugin, bgok parambgok, long paramLong) {}
  
  public String run()
  {
    try
    {
      String str1 = new JSONObject(this.val$req.b).optString("path");
      String str2 = bgnt.a().a(str1);
      QMLog.d("FileJsPlugin", "accessFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str2);
      if ((TextUtils.isEmpty(str2)) || (!new File(str2).exists())) {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory \"" + str1 + "\"");
      }
      str1 = FileJsPlugin.access$200(this.this$0, this.val$req, null);
      return str1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */