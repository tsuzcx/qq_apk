import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import mqq.app.AppRuntime;

public class prd
{
  public static Object a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramAppRuntime = bmhv.a(paramAppRuntime, true, paramBoolean);
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getString(paramString, "");
          if (!TextUtils.isEmpty(paramAppRuntime))
          {
            paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(PkgTools.hexToBytes(paramAppRuntime)));
            paramString = paramAppRuntime.readObject();
            paramAppRuntime.close();
            return paramString;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (!(paramObject instanceof Serializable)) {
      throw new RuntimeException("the data obj must implement Serializable interface ! ");
    }
    ThreadManager.executeOnFileThread(new RIJSPUtils.2(paramString, paramObject, paramBoolean));
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnFileThread(new RIJSPUtils.1(paramBoolean, paramString));
  }
  
  public static void b(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      paramObject = PkgTools.toHexStr(((ByteArrayOutputStream)localObject).toByteArray());
      localObject = bmhv.a(pnn.a(), true, paramBoolean);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramObject);
        ((SharedPreferences.Editor)localObject).apply();
      }
      QLog.d("RIJSPUtils", 2, "asyncWriteDataToSP successful !  key : " + paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.d("RIJSPUtils", 2, "write hb info to storage , error : " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prd
 * JD-Core Version:    0.7.0.1
 */