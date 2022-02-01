package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import azug;
import azuh;
import azul;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PortalManager$5$1
  implements Runnable
{
  public PortalManager$5$1(azug paramazug, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    azuh localazuh = (azuh)this.jdField_a_of_type_Azug.a.a.get(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Azug.a.a.remove(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      localObject1 = PortalManager.a(this.jdField_a_of_type_Azug.a).a(this.jdField_a_of_type_JavaLangString, false);
      if (localObject1 != null)
      {
        localObject1 = azul.a((Bitmap)localObject1);
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("errorCode", 0);
      localJSONObject.put("key", localazuh.jdField_a_of_type_JavaLangString);
      localJSONObject.put("result", localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + localazuh.jdField_a_of_type_JavaLangString);
      }
      PortalManager.a(this.jdField_a_of_type_Azug.a, localazuh.b, localJSONObject.toString(), localazuh.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    finally
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManagerhead", 2, "error heppened info = " + localJSONObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + localazuh.jdField_a_of_type_JavaLangString);
        }
        PortalManager.a(this.jdField_a_of_type_Azug.a, localazuh.b, localazuh.jdField_a_of_type_Int, null, -1, "get bitmap failed!");
        return;
      }
      finally
      {
        i = 0;
      }
      localObject2 = finally;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + localazuh.jdField_a_of_type_JavaLangString);
    }
    if (i != 0)
    {
      PortalManager.a(this.jdField_a_of_type_Azug.a, localazuh.b, localJSONObject.toString(), localazuh.jdField_a_of_type_Int);
      return;
    }
    throw localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.5.1
 * JD-Core Version:    0.7.0.1
 */