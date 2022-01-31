import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class miy
  extends mit
{
  protected miy(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(mdz parammdz1, mdz parammdz2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = miu.b(paramInt);
    parammdz1.a(0, 0, 0, 0);
    parammdz1.b(i, 0, paramInt, j);
    parammdz1.d(-15197410);
    parammdz2.a(0, 0, 0, 0);
    parammdz2.b(0, 0, i, j);
    parammdz2.d(-15197410);
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(mdz[] paramArrayOfmdz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mdz[] paramArrayOfmdz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmdz[1].a(0)))
    {
      bool = true;
      lcg.c("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
      if (!bool) {
        break label112;
      }
      if (paramBoolean) {
        break label94;
      }
      paramBoolean = true;
    }
    label94:
    label112:
    for (;;)
    {
      if (paramBoolean)
      {
        a(paramArrayOfmdz[0], paramArrayOfmdz[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmdz[1], paramArrayOfmdz[0], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     miy
 * JD-Core Version:    0.7.0.1
 */