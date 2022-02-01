import java.io.File;

public class ldl
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public int a()
  {
    if (this.a == 1) {
      return 2;
    }
    if (this.a == 4) {
      return 1;
    }
    if (this.a == 2) {
      return 4;
    }
    if (this.a == 8) {
      return 3;
    }
    return 0;
  }
  
  public String a()
  {
    lny locallny = new lny('=', ';');
    locallny.a("s_path", this.jdField_b_of_type_JavaLangString);
    if (a())
    {
      locallny.a("i_fps", this.jdField_b_of_type_Int);
      locallny.a("i_bitrate", this.jdField_c_of_type_Int);
      locallny.a("s_outpath", this.d);
      File localFile = new File(this.d);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    for (;;)
    {
      return locallny.a();
      locallny.a("s_expMd5", this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.a == 2) || (this.a == 8)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.a == 1);
      bool1 = bool2;
    } while (this.a != 4);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldl
 * JD-Core Version:    0.7.0.1
 */