package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import atti;
import attj;
import attn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PortalManager$5$1
  implements Runnable
{
  public PortalManager$5$1(atti paramatti, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    attj localattj = (attj)this.jdField_a_of_type_Atti.a.a.get(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Atti.a.a.remove(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      localObject1 = PortalManager.a(this.jdField_a_of_type_Atti.a).a(this.jdField_a_of_type_JavaLangString, false);
      if (localObject1 != null)
      {
        localObject1 = attn.a((Bitmap)localObject1);
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("errorCode", 0);
      localJSONObject.put("key", localattj.jdField_a_of_type_JavaLangString);
      localJSONObject.put("result", localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + localattj.jdField_a_of_type_JavaLangString);
      }
      PortalManager.a(this.jdField_a_of_type_Atti.a, localattj.b, localJSONObject.toString(), localattj.jdField_a_of_type_Int);
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
          QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + localattj.jdField_a_of_type_JavaLangString);
        }
        PortalManager.a(this.jdField_a_of_type_Atti.a, localattj.b, localattj.jdField_a_of_type_Int, null, -1, "get bitmap failed!");
        return;
      }
      finally
      {
        i = 0;
      }
      localObject2 = finally;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + localattj.jdField_a_of_type_JavaLangString);
    }
    if (i != 0)
    {
      PortalManager.a(this.jdField_a_of_type_Atti.a, localattj.b, localJSONObject.toString(), localattj.jdField_a_of_type_Int);
      return;
    }
    throw localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.5.1
 * JD-Core Version:    0.7.0.1
 */