import com.tencent.qphone.base.util.QLog;
import java.io.File;

class rjm
  implements rjd<qzp>
{
  rjm(rjj paramrjj) {}
  
  public boolean a(qzp paramqzp)
  {
    try
    {
      paramqzp = new File(paramqzp.b);
      if (paramqzp.isFile())
      {
        boolean bool = paramqzp.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramqzp)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramqzp);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjm
 * JD-Core Version:    0.7.0.1
 */