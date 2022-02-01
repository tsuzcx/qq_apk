import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class svk
  implements svi
{
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  
  public svk(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("" + paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = new File(paramString);
  }
  
  public InputStream a(String paramString)
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString + "/" + paramString);
    if (((File)localObject).exists()) {
      try
      {
        localObject = new FileInputStream((File)localObject);
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        QLog.e("ReadMergeFile", 2, "getFile:" + paramString, localFileNotFoundException);
      }
    }
    return null;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.jdField_a_of_type_JavaIoFile.list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */