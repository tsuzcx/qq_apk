import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class qll
{
  private static qln a(String paramString)
  {
    paramString = String.format("https://h5.gdt.qq.com/pageviewer/api/form/getSaveToken?traceId=%s", new Object[] { paramString });
    qln localqln = new qln(null);
    localqln.a(paramString);
    localqln.jdField_a_of_type_JavaLangString = "GET";
    localqln.jdField_b_of_type_JavaLangString = "application/json";
    localqln.jdField_a_of_type_Int = 5000;
    localqln.jdField_b_of_type_Int = 5000;
    return localqln;
  }
  
  public static void a(WeakReference paramWeakReference1, WeakReference paramWeakReference2)
  {
    ThreadManager.post(new qlm(paramWeakReference1, paramWeakReference2), 5, null, true);
  }
  
  private static void a(WeakReference paramWeakReference1, WeakReference paramWeakReference2, qln paramqln)
  {
    if ((paramqln == null) || (!paramqln.b()) || (!a(paramWeakReference1, paramWeakReference2)))
    {
      GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramWeakReference1 = new JSONObject(new String(paramqln.jdField_b_of_type_ArrayOfByte, "UTF-8"));
      paramqln.d = paramWeakReference1.getInt("code");
      String str = paramWeakReference1.optString("message");
      GdtLog.b("GdtCanvasFormPrefetchTokenUtil", "onResponse code:" + paramqln.d + " message:" + str);
      if (paramqln.d == 0)
      {
        paramWeakReference1 = paramWeakReference1.getJSONObject("data");
        ((GdtCanvasFormComponentData)paramWeakReference2.get()).tokenForUpload = paramWeakReference1.getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramWeakReference1)
    {
      GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "onResponse", paramWeakReference1);
      return;
      GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramWeakReference1)
    {
      GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "onResponse", paramWeakReference1);
    }
  }
  
  private static boolean a(WeakReference paramWeakReference1, WeakReference paramWeakReference2)
  {
    return (paramWeakReference1 != null) && (paramWeakReference1.get() != null) && (((GdtCanvasData)paramWeakReference1.get()).isValid()) && (paramWeakReference2 != null) && (paramWeakReference2.get() != null) && (((GdtCanvasFormComponentData)paramWeakReference2.get()).isValid()) && (!TextUtils.isEmpty(((GdtCanvasData)paramWeakReference1.get()).ad.getTraceId()));
  }
  
  private static void c(WeakReference paramWeakReference1, WeakReference paramWeakReference2)
  {
    if (!a(paramWeakReference1, paramWeakReference2))
    {
      GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    String str = ((GdtCanvasData)paramWeakReference1.get()).ad.getTraceId();
    int i = 0;
    for (;;)
    {
      qln localqln;
      if (i < 3)
      {
        if (!a(paramWeakReference1, paramWeakReference2))
        {
          GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localqln = a(str);
        if (localqln != null) {}
      }
      else
      {
        GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      GdtHttp.a(localqln);
      a(paramWeakReference1, paramWeakReference2, localqln);
      if ((localqln.b()) && (localqln.d == 0)) {
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
          GdtLog.d("GdtCanvasFormPrefetchTokenUtil", "prefetch", localInterruptedException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qll
 * JD-Core Version:    0.7.0.1
 */