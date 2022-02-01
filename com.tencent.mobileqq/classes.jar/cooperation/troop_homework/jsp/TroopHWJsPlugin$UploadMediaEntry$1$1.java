package cooperation.troop_homework.jsp;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopHWJsPlugin$UploadMediaEntry$1$1
  implements TroopHWJsPlugin.UploadVideoThumbCallback
{
  TroopHWJsPlugin$UploadMediaEntry$1$1(TroopHWJsPlugin.UploadMediaEntry.1 param1) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      JSONObject localJSONObject = this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource.c, this.a.a.jdField_a_of_type_Int, this.a.a.b, "uploaded", this.a.a.jdField_a_of_type_JavaLangString, 0);
      try
      {
        localJSONObject.put("result", 0);
        localJSONObject.put("progress", 1.0D);
        localJSONObject.put("coverurl", paramString);
        paramString = new StringBuilder();
        paramString.append("upload thumb success:");
        paramString.append(localJSONObject.toString());
        QLog.e("TroopHWJsPlugin", 2, paramString.toString());
        this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("TroopHWJsPlugin", 2, "upload thumb exception:", paramString);
        return;
      }
    }
    QLog.e("TroopHWJsPlugin", 1, "upload thumb failed!");
    this.a.b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.1.1
 * JD-Core Version:    0.7.0.1
 */