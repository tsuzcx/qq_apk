import java.io.File;
import java.util.Map;

class teb
  extends tfc
{
  teb(tea paramtea, stz paramstz)
  {
    super(paramstz);
  }
  
  protected tff a(tfe... paramVarArgs)
  {
    tff localtff = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localtff.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      vyi.d(str);
      label42:
      int i = nay.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (tea.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              veg.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localtff;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              veg.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            veg.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new tff(localtff.jdField_a_of_type_Tfe, -1, "illegal config file");
          }
        }
        veg.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new tff(localtff.jdField_a_of_type_Tfe, -1, "illegal folder");
      }
      veg.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new tff(localtff.jdField_a_of_type_Tfe, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(tff arg1)
  {
    veg.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      veg.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Tfe.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      tea.a(this.a, null);
      this.a.d();
      return;
      veg.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Tfe.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     teb
 * JD-Core Version:    0.7.0.1
 */