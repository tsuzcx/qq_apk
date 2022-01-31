import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public final class lkw
  implements Runnable
{
  public lkw(Object paramObject, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new ByteArrayOutputStream();
      Object localObject2 = new ObjectOutputStream((OutputStream)localObject1);
      ((ObjectOutputStream)localObject2).writeObject(this.jdField_a_of_type_JavaLangObject);
      ((ObjectOutputStream)localObject2).flush();
      ((ObjectOutputStream)localObject2).close();
      localObject1 = PkgTools.a(((ByteArrayOutputStream)localObject1).toByteArray());
      localObject2 = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, this.jdField_a_of_type_Boolean);
      if (localObject2 != null)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putString(this.jdField_a_of_type_JavaLangString, (String)localObject1);
        ((SharedPreferences.Editor)localObject2).commit();
      }
      QLog.d("ReadInJoyUtils", 2, "writeDataToSP successful !  key : " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.d("ReadInJoyUtils", 2, "write hb info to storage , error : " + localIOException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkw
 * JD-Core Version:    0.7.0.1
 */