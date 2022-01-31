import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;

public class lic
  extends Handler
{
  public lic(MagicFaceDataEntity paramMagicFaceDataEntity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lcl.c("MagicFaceDataEntity", "MagicFaceDataEntity handleMessage A: " + this.a.a + "|" + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.a.a != 1);
          MagicFaceDataEntity.a(this.a, (Object[])paramMessage.obj);
          return;
        } while (this.a.a != 0);
        this.a.a = 1;
        this.a.c();
        return;
      } while (this.a.a != 1);
      this.a.a = 0;
      this.a.d();
      return;
    } while (this.a.a != 1);
    paramMessage = (Integer)paramMessage.obj;
    this.a.a(paramMessage.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lic
 * JD-Core Version:    0.7.0.1
 */