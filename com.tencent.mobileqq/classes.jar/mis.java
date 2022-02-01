import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class mis
  extends min
{
  protected mis(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(mdt parammdt1, mdt parammdt2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = mio.b(paramInt);
    parammdt1.a(0, 0, 0, 0);
    parammdt1.b(i, 0, paramInt, j);
    parammdt1.d(-15197410);
    parammdt2.a(0, 0, 0, 0);
    parammdt2.b(0, 0, i, j);
    parammdt2.d(-15197410);
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(mdt[] paramArrayOfmdt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mdt[] paramArrayOfmdt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmdt[1].a(0)))
    {
      bool = true;
      lbc.c("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
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
        a(paramArrayOfmdt[0], paramArrayOfmdt[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmdt[1], paramArrayOfmdt[0], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mis
 * JD-Core Version:    0.7.0.1
 */