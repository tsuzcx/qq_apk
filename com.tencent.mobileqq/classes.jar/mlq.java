import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class mlq
  extends mll
{
  protected mlq(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(mgp parammgp1, mgp parammgp2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = mlm.b(paramInt);
    parammgp1.a(0, 0, 0, 0);
    parammgp1.b(i, 0, paramInt, j);
    parammgp1.d(-15197410);
    parammgp2.a(0, 0, 0, 0);
    parammgp2.b(0, 0, i, j);
    parammgp2.d(-15197410);
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmgp[1].a(0)))
    {
      bool = true;
      lek.c("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
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
        a(paramArrayOfmgp[0], paramArrayOfmgp[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmgp[1], paramArrayOfmgp[0], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mlq
 * JD-Core Version:    0.7.0.1
 */