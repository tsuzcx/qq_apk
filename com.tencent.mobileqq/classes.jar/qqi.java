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

public class qqi
{
  private static Map a(qqk paramqqk, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramqqk != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramqqk)
          {
            for (;;)
            {
              Object localObject;
              GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseRegex", paramqqk);
            }
            return localHashMap;
          }
          catch (Throwable paramqqk)
          {
            for (;;)
            {
              GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseRegex", paramqqk);
            }
          }
          GdtLog.d("GdtCanvasFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramqqk.d = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          GdtLog.b("GdtCanvasFormUpdateRegexUtil", "onResponse code:" + paramqqk.d + " message:" + (String)localObject);
        } while (paramqqk.d != 0);
        paramqqk = paramJSONObject.getJSONObject("data");
      } while ((paramqqk == null) || (paramqqk == JSONObject.NULL));
      paramqqk = paramqqk.getJSONObject("regexMap");
    } while ((paramqqk == null) || (paramqqk == JSONObject.NULL));
    paramJSONObject = paramqqk.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramqqk.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static qqk a()
  {
    qqk localqqk = new qqk(null);
    localqqk.a("https://h5.gdt.qq.com/pageviewer/api/form/getRegexp");
    localqqk.jdField_a_of_type_JavaLangString = "GET";
    localqqk.jdField_b_of_type_JavaLangString = "application/json";
    localqqk.jdField_a_of_type_Int = 5000;
    localqqk.jdField_b_of_type_Int = 5000;
    return localqqk;
  }
  
  public static void a(WeakReference paramWeakReference)
  {
    ThreadManager.post(new qqj(paramWeakReference), 5, null, true);
  }
  
  private static void a(WeakReference paramWeakReference, qqk paramqqk)
  {
    if ((paramqqk == null) || (!paramqqk.b()) || (paramqqk.jdField_b_of_type_ArrayOfByte == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((GdtCanvasFormComponentData)paramWeakReference.get()).isValid()))
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
        localObject = new String(paramqqk.jdField_b_of_type_ArrayOfByte, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramqqk = a(paramqqk, new JSONObject((String)localObject));
        if (paramqqk == null) {
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
        if (paramqqk.containsKey(Integer.valueOf(((GdtCanvasFormItemTextBoxData)localObject).regexType))) {
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
      ((GdtCanvasFormItemTextBoxData)localObject).regex = ((String)paramqqk.get(Integer.valueOf(((GdtCanvasFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      qqk localqqk;
      if (i < 3)
      {
        localqqk = a();
        if (localqqk != null) {}
      }
      else
      {
        GdtLog.d("GdtCanvasFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        GdtHttp.a(localqqk);
        a(paramWeakReference, localqqk);
      } while ((localqqk.b()) && (localqqk.d == 0));
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
 * Qualified Name:     qqi
 * JD-Core Version:    0.7.0.1
 */