import java.io.File;
import java.util.Map;

class tdy
  extends tez
{
  tdy(tdx paramtdx, stw paramstw)
  {
    super(paramstw);
  }
  
  protected tfc a(tfb... paramVarArgs)
  {
    tfc localtfc = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localtfc.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      vyf.d(str);
      label42:
      int i = nav.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (tdx.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              ved.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localtfc;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              ved.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            ved.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new tfc(localtfc.jdField_a_of_type_Tfb, -1, "illegal config file");
          }
        }
        ved.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new tfc(localtfc.jdField_a_of_type_Tfb, -1, "illegal folder");
      }
      ved.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new tfc(localtfc.jdField_a_of_type_Tfb, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(tfc arg1)
  {
    ved.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      ved.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Tfb.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      tdx.a(this.a, null);
      this.a.d();
      return;
      ved.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Tfb.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdy
 * JD-Core Version:    0.7.0.1
 */