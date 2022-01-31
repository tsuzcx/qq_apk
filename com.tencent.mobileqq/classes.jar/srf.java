import java.io.File;
import java.util.Map;

class srf
  extends ssg
{
  srf(sre paramsre, shd paramshd)
  {
    super(paramshd);
  }
  
  protected ssj a(ssi... paramVarArgs)
  {
    ssj localssj = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localssj.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      vlm.d(str);
      label42:
      int i = mpx.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (sre.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              urk.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localssj;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              urk.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            urk.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new ssj(localssj.jdField_a_of_type_Ssi, -1, "illegal config file");
          }
        }
        urk.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new ssj(localssj.jdField_a_of_type_Ssi, -1, "illegal folder");
      }
      urk.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new ssj(localssj.jdField_a_of_type_Ssi, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(ssj arg1)
  {
    urk.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      urk.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_Ssi.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      sre.a(this.a, null);
      this.a.d();
      return;
      urk.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Ssi.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srf
 * JD-Core Version:    0.7.0.1
 */