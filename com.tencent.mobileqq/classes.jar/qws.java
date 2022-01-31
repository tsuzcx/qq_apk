import com.tencent.qphone.base.util.QLog;
import java.io.File;

class qws
  implements qwj<qnz>
{
  qws(qwp paramqwp) {}
  
  public boolean a(qnz paramqnz)
  {
    try
    {
      paramqnz = new File(paramqnz.b);
      if (paramqnz.isFile())
      {
        boolean bool = paramqnz.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramqnz)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramqnz);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qws
 * JD-Core Version:    0.7.0.1
 */