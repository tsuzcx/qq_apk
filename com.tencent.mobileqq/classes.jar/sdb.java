import com.tencent.qphone.base.util.QLog;
import java.io.File;

class sdb
  implements scs<rsv>
{
  sdb(scy paramscy) {}
  
  public boolean a(rsv paramrsv)
  {
    try
    {
      paramrsv = new File(paramrsv.b);
      if (paramrsv.isFile())
      {
        boolean bool = paramrsv.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramrsv)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramrsv);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdb
 * JD-Core Version:    0.7.0.1
 */