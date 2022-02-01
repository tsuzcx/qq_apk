import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class mjj
{
  Context a;
  public VideoAppInterface a;
  
  protected mjj(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
  }
  
  public static mjj a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
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
          paramContext = new mjp(paramContext, paramVideoAppInterface);
          continue;
        }
        finally {}
      }
      else
      {
        paramContext = new mjm(paramContext, paramVideoAppInterface);
        continue;
        if (paramBoolean)
        {
          paramContext = new mjo(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new mjk(paramContext, paramVideoAppInterface);
          continue;
          if (paramBoolean)
          {
            paramContext = new mjp(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new mjl(paramContext, paramVideoAppInterface);
            continue;
            if (paramBoolean) {
              paramContext = new mjp(paramContext, paramVideoAppInterface);
            } else {
              paramContext = new mjn(paramContext, paramVideoAppInterface);
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
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, mma> paramConcurrentHashMap) {}
  
  public void a(lff paramlff, mep[] paramArrayOfmep, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(mep[] paramArrayOfmep, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mep[] paramArrayOfmep, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract boolean a();
  
  public boolean b()
  {
    return a() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjj
 * JD-Core Version:    0.7.0.1
 */