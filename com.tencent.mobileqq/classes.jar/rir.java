import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mfsdk.reporter.ReporterMachine;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class rir
  implements Runnable
{
  String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath();
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  String b = "/Tencent";
  String c = "/tencent";
  String d = "/MobileQQ/log/";
  String e = "/Magnifier/dumpfile/";
  String f = "/SNGAPM/battery/";
  
  public rir()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_a_of_type_JavaLangString.endsWith("/")) {
        this.jdField_a_of_type_JavaLangString += "/";
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString + this.b + this.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString + this.b + this.e);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString + this.b + this.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString + this.c + this.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString + this.c + this.e);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString + this.c + this.f);
    }
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject;
    int i;
    while (localIterator.hasNext())
    {
      localObject = new File((String)localIterator.next());
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null) {
          i = 0;
        }
      }
    }
    while (i < localObject.length)
    {
      String str = localObject[i].getPath();
      if ((str.contains(".txt")) || (str.contains(".zip"))) {}
      try
      {
        ReporterMachine.a().add(str);
        label108:
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label108;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rir
 * JD-Core Version:    0.7.0.1
 */