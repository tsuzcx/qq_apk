import com.tencent.qphone.base.util.QLog;
import java.io.File;

class rsq
  implements rsh<riw>
{
  rsq(rsn paramrsn) {}
  
  public boolean a(riw paramriw)
  {
    try
    {
      paramriw = new File(paramriw.b);
      if (paramriw.isFile())
      {
        boolean bool = paramriw.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramriw)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramriw);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsq
 * JD-Core Version:    0.7.0.1
 */