import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class mll
{
  Context a;
  public VideoAppInterface a;
  
  protected mll(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
  }
  
  public static mll a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      return paramContext;
      if (paramBoolean)
      {
        try
        {
          paramContext = new mlr(paramContext, paramVideoAppInterface);
          continue;
        }
        finally {}
      }
      else
      {
        paramContext = new mlo(paramContext, paramVideoAppInterface);
        continue;
        if (paramBoolean)
        {
          paramContext = new mlq(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new mlm(paramContext, paramVideoAppInterface);
          continue;
          if (paramBoolean)
          {
            paramContext = new mlr(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new mln(paramContext, paramVideoAppInterface);
            continue;
            if (paramBoolean) {
              paramContext = new mlr(paramContext, paramVideoAppInterface);
            } else {
              paramContext = new mlp(paramContext, paramVideoAppInterface);
            }
          }
        }
      }
    }
  }
  
  public abstract int a();
  
  public void a()
  {
    QLog.d("ScreenLayout", 1, "ScreenLayout. onDestroy." + this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, moa> paramConcurrentHashMap) {}
  
  public void a(lid paramlid, mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract boolean a();
  
  public boolean b()
  {
    return a() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mll
 * JD-Core Version:    0.7.0.1
 */