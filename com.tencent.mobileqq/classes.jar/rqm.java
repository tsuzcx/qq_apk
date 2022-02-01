import com.tencent.qphone.base.util.QLog;
import java.io.File;

class rqm
  implements rqd<rgo>
{
  rqm(rqj paramrqj) {}
  
  public boolean a(rgo paramrgo)
  {
    try
    {
      paramrgo = new File(paramrgo.b);
      if (paramrgo.isFile())
      {
        boolean bool = paramrgo.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramrgo)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramrgo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqm
 * JD-Core Version:    0.7.0.1
 */