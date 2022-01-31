import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormTableData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class qlr
{
  private static Map a(qlt paramqlt, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramqlt != null) && (paramJSONObject != null)) {}
    label34:
    do
    {
      do
      {
        do
        {
          try
          {
            localObject = JSONObject.NULL;
            if (paramJSONObject != localObject) {
              break label34;
            }
          }
          catch (JSONException paramqlt)
          {
            for (;;)
            {
              Object localObject;
              GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseRegex", paramqlt);
            }
            return localHashMap;
          }
          catch (Throwable paramqlt)
          {
            for (;;)
            {
              GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseRegex", paramqlt);
            }
          }
          GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramqlt.d = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          GdtLog.b("GdtCanvasFormUpdateRegexUtil", "onResponse code:" + paramqlt.d + " message:" + (String)localObject);
        } while (paramqlt.d != 0);
        paramqlt = paramJSONObject.getJSONObject("data");
      } while ((paramqlt == null) || (paramqlt == JSONObject.NULL));
      paramqlt = paramqlt.getJSONObject("regexMap");
    } while ((paramqlt == null) || (paramqlt == JSONObject.NULL));
    paramJSONObject = paramqlt.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramqlt.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static qlt a()
  {
    qlt localqlt = new qlt(null);
    localqlt.a("https://h5.gdt.qq.com/pageviewer/api/form/getRegexp");
    localqlt.jdField_a_of_type_JavaLangString = "GET";
    localqlt.jdField_b_of_type_JavaLangString = "application/json";
    localqlt.jdField_a_of_type_Int = 5000;
    localqlt.jdField_b_of_type_Int = 5000;
    return localqlt;
  }
  
  public static void a(WeakReference paramWeakReference)
  {
    ThreadManager.post(new qls(paramWeakReference), 5, null, true);
  }
  
  private static void a(WeakReference paramWeakReference, qlt paramqlt)
  {
    if ((paramqlt == null) || (!paramqlt.b()) || (paramqlt.jdField_b_of_type_ArrayOfByte == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((GdtCanvasFormComponentData)paramWeakReference.get()).isValid()))
    {
      GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseResponse error");
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = Charset.forName("UTF-8");
        if (localObject == null) {
          break;
        }
        localObject = new String(paramqlt.jdField_b_of_type_ArrayOfByte, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramqlt = a(paramqlt, new JSONObject((String)localObject));
        if (paramqlt == null) {
          break;
        }
        i = 0;
        if (i >= ((GdtCanvasFormComponentData)paramWeakReference.get()).table.getSize()) {
          break;
        }
        localObject = ((GdtCanvasFormComponentData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((GdtCanvasFormItemData)localObject).isValid()))
        {
          GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtCanvasFormItemTextBoxData))
        {
          localObject = (GdtCanvasFormItemTextBoxData)GdtCanvasFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtCanvasFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramqlt.containsKey(Integer.valueOf(((GdtCanvasFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtCanvasFormItemTextBoxData)localObject).regex = ((String)paramqlt.get(Integer.valueOf(((GdtCanvasFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      qlt localqlt;
      if (i < 3)
      {
        localqlt = a();
        if (localqlt != null) {}
      }
      else
      {
        GdtLog.d("GdtCanvasFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        GdtHttp.a(localqlt);
        a(paramWeakReference, localqlt);
      } while ((localqlt.b()) && (localqlt.d == 0));
      try
      {
        Thread.sleep(1000L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          GdtLog.d("GdtCanvasFormUpdateRegexUtil", "update", localInterruptedException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qlr
 * JD-Core Version:    0.7.0.1
 */