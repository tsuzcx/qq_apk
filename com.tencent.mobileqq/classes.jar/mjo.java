import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class mjo
  extends mjj
{
  protected mjo(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(mep parammep1, mep parammep2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = mjk.b(paramInt);
    parammep1.a(0, 0, 0, 0);
    parammep1.b(i, 0, paramInt, j);
    parammep1.d(-15197410);
    parammep2.a(0, 0, 0, 0);
    parammep2.b(0, 0, i, j);
    parammep2.d(-15197410);
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(mep[] paramArrayOfmep, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mep[] paramArrayOfmep, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmep[1].a(0)))
    {
      bool = true;
      lbj.c("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
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
        a(paramArrayOfmep[0], paramArrayOfmep[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmep[1], paramArrayOfmep[0], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjo
 * JD-Core Version:    0.7.0.1
 */