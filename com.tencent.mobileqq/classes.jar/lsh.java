import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

class lsh
{
  private int jdField_a_of_type_Int;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  public lsh(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.d = 0;
    this.c = 0;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream.flush();
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("FilterProcessTest", 4, "DebugFile-save close fail path: " + this.jdField_b_of_type_JavaLangString, localThrowable1);
          }
        }
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        throw localObject;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("FilterProcessTest", 4, "DebugFile-save close fail path: " + this.jdField_b_of_type_JavaLangString, localThrowable4);
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2 = localThrowable2;
      if (QLog.isDevelopLevel()) {
        QLog.i("FilterProcessTest", 4, "DebugFile-save flush fail path: " + this.jdField_b_of_type_JavaLangString, localThrowable2);
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        return;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("FilterProcessTest", 4, "DebugFile-save close fail path: " + this.jdField_b_of_type_JavaLangString, localThrowable3);
          }
        }
      }
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FilterProcessTest", 4, String.format("DebugFile-end size[%s, %s], fmt[%s], frame[%s], path[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Integer.valueOf(this.d), this.jdField_b_of_type_JavaLangString }));
    }
    b();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.d = 0;
    this.c = 0;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt3 == 0)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaIoFileOutputStream == null) || (this.jdField_a_of_type_Int != paramInt2) || (this.jdField_b_of_type_Int != paramInt3) || (this.c != paramInt1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FilterProcessTest", 4, String.format("DebugFile-save pre_size[%s,%s], cur_size[%s,%s], pre_fmt[%s], cur_fmt[%s], count[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.c), Integer.valueOf(paramInt1), Integer.valueOf(this.d) }));
      }
      b();
      this.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "_" + lsg.a(paramInt2, paramInt3, paramInt1) + ".yuv");
      File localFile = new File(this.jdField_b_of_type_JavaLangString);
      if ((localFile.exists()) && (localFile.isFile()) && (!localFile.delete()) && (QLog.isDevelopLevel())) {
        QLog.i("FilterProcessTest", 4, "DebugFile-save del fail path: " + this.jdField_b_of_type_JavaLangString);
      }
    }
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_b_of_type_Int = paramInt3;
      this.d = 0;
      this.c = paramInt1;
      this.d += 1;
      lsg.a(this.jdField_a_of_type_JavaIoFileOutputStream, paramArrayOfByte);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 4, "DebugFile-save create FileOutputStream fail path: " + this.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lsh
 * JD-Core Version:    0.7.0.1
 */