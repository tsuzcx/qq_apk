import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormTableData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class qql
{
  public static GdtCanvasFormError a(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    byte[] arrayOfByte = a(paramGdtCanvasData, paramGdtCanvasFormComponentData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "upload error");
      localObject = new GdtCanvasFormError(4, -1, null);
      return localObject;
    }
    GdtCanvasFormError localGdtCanvasFormError = new GdtCanvasFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      qqn localqqn;
      if (i < 3)
      {
        localqqn = a(arrayOfByte);
        if (localqqn != null) {}
      }
      else
      {
        GdtLog.d("GdtCanvasFormUploadUtil", "upload error");
        return localGdtCanvasFormError;
      }
      GdtHttp.a(localqqn);
      if (localqqn.b()) {
        localGdtCanvasFormError = a(paramGdtCanvasData, paramGdtCanvasFormComponentData, localqqn);
      }
      localObject = localGdtCanvasFormError;
      if (localqqn.d == 0) {
        break;
      }
      localObject = localGdtCanvasFormError;
      if (localqqn.d == 1) {
        break;
      }
      localObject = localGdtCanvasFormError;
      if (localqqn.d == 2) {
        break;
      }
      try
      {
        Thread.sleep(1000L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          GdtLog.d("GdtCanvasFormUploadUtil", "getRequestData", localInterruptedException);
        }
      }
    }
  }
  
  private static GdtCanvasFormError a(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData, qqn paramqqn)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()) || (paramGdtCanvasFormComponentData == null) || (!paramGdtCanvasFormComponentData.isValid()) || (paramqqn == null) || (!paramqqn.b()))
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "commit error");
      paramGdtCanvasData = new GdtCanvasFormError(4, -1, null);
      return paramGdtCanvasData;
    }
    try
    {
      paramGdtCanvasData = new JSONObject(new String(paramqqn.jdField_b_of_type_ArrayOfByte, "UTF-8"));
      paramqqn.d = paramGdtCanvasData.getInt("code");
      localObject = paramGdtCanvasData.optString("message");
      GdtLog.b("GdtCanvasFormUploadUtil", "parseResponse code:" + paramqqn.d + " message:" + (String)localObject);
      if (paramqqn.d == 0)
      {
        paramGdtCanvasData = new GdtCanvasFormError(1, -1, null);
        return paramGdtCanvasData;
      }
    }
    catch (UnsupportedEncodingException paramGdtCanvasData)
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse", paramGdtCanvasData);
      return new GdtCanvasFormError(4, -1, null);
      if (paramqqn.d != 1) {
        break label453;
      }
      paramqqn = new GdtCanvasFormError(4, -1, null);
      paramGdtCanvasData = paramGdtCanvasData.getJSONObject("data");
      if ((paramGdtCanvasData == null) || (paramGdtCanvasData == JSONObject.NULL))
      {
        GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse error");
        return paramqqn;
      }
    }
    catch (JSONException paramGdtCanvasData)
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse", paramGdtCanvasData);
      return new GdtCanvasFormError(4, -1, null);
    }
    Object localObject = paramGdtCanvasData.getJSONArray("items");
    if (((JSONArray)localObject).length() != paramGdtCanvasFormComponentData.table.getSize())
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse error");
      return paramqqn;
    }
    for (;;)
    {
      paramGdtCanvasData = paramqqn;
      int i;
      if (i >= ((JSONArray)localObject).length()) {
        break;
      }
      paramGdtCanvasData = paramGdtCanvasFormComponentData.table.getItem(i);
      if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()))
      {
        GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse error");
        return new GdtCanvasFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse error");
        return new GdtCanvasFormError(4, i, paramGdtCanvasData.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new GdtCanvasFormError(5, i, paramGdtCanvasData.title.text);
        }
        if (j == 2) {
          return new GdtCanvasFormError(6, i, paramGdtCanvasData.title.text);
        }
        GdtLog.d("GdtCanvasFormUploadUtil", "parseResponse error");
        return new GdtCanvasFormError(4, i, paramGdtCanvasData.title.text);
        label453:
        paramGdtCanvasData = new GdtCanvasFormError(4, -1, null);
        return paramGdtCanvasData;
        i = 0;
      }
    }
  }
  
  private static JSONArray a(GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    if ((paramGdtCanvasFormComponentData == null) || (!paramGdtCanvasFormComponentData.isValid()))
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramGdtCanvasFormComponentData.table.getSize())
    {
      Object localObject = paramGdtCanvasFormComponentData.table.getItem(i);
      if ((localObject == null) || (!((GdtCanvasFormItemData)localObject).isValid())) {
        GdtLog.d("GdtCanvasFormUploadUtil", "toJson error");
      }
      for (;;)
      {
        i += 1;
        break;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", ((GdtCanvasFormItemData)localObject).title.text);
          localJSONObject.put("require", ((GdtCanvasFormItemData)localObject).required);
          if ((localObject instanceof GdtCanvasFormItemTextBoxData))
          {
            localObject = (GdtCanvasFormItemTextBoxData)GdtCanvasFormItemTextBoxData.class.cast(localObject);
            localJSONObject.put("regexType", ((GdtCanvasFormItemTextBoxData)localObject).regexType);
            localJSONObject.put("value", ((GdtCanvasFormItemTextBoxData)localObject).getResult());
          }
          localJSONArray.put(i, localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          GdtLog.d("GdtCanvasFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  private static qqn a(byte[] paramArrayOfByte)
  {
    qqn localqqn = new qqn(null);
    localqqn.a("https://h5.gdt.qq.com/pageviewer/api/form/save");
    localqqn.jdField_a_of_type_JavaLangString = "POST";
    localqqn.jdField_b_of_type_JavaLangString = "application/json";
    localqqn.jdField_a_of_type_Int = 5000;
    localqqn.jdField_b_of_type_Int = 5000;
    localqqn.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return localqqn;
  }
  
  private static byte[] a(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    JSONArray localJSONArray = a(paramGdtCanvasFormComponentData);
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()) || (paramGdtCanvasFormComponentData == null) || (!paramGdtCanvasFormComponentData.isValid()) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasFormUploadUtil", "getRequestData error");
      return null;
    }
    if (TextUtils.isEmpty(paramGdtCanvasFormComponentData.tokenForUpload)) {}
    for (paramGdtCanvasData = "";; paramGdtCanvasData = paramGdtCanvasFormComponentData.tokenForUpload) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", paramGdtCanvasData);
        localJSONObject.put("formId", paramGdtCanvasFormComponentData.formId);
        localJSONObject.put("formValue", localJSONArray.toString());
        paramGdtCanvasData = localJSONObject.toString().getBytes("UTF-8");
        return paramGdtCanvasData;
      }
      catch (JSONException paramGdtCanvasData)
      {
        GdtLog.d("GdtCanvasFormUploadUtil", "getRequestData", paramGdtCanvasData);
        return null;
      }
      catch (UnsupportedEncodingException paramGdtCanvasData)
      {
        GdtLog.d("GdtCanvasFormUploadUtil", "getRequestData", paramGdtCanvasData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qql
 * JD-Core Version:    0.7.0.1
 */