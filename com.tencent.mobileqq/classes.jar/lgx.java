import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;

public class lgx
  extends Handler
{
  public lgx(MagicFaceDataEntity paramMagicFaceDataEntity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lba.f("MagicFaceDataEntity", "MagicFaceDataEntity handleMessage A: " + this.a.a + "|" + paramMessage.what);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgx
 * JD-Core Version:    0.7.0.1
 */