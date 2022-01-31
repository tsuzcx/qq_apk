import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class lyf
{
  Context a;
  public VideoAppInterface a;
  
  protected lyf(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
  }
  
  public static lyf a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
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
          paramContext = new lyl(paramContext, paramVideoAppInterface);
          continue;
        }
        finally {}
      }
      else
      {
        paramContext = new lyi(paramContext, paramVideoAppInterface);
        continue;
        if (paramBoolean)
        {
          paramContext = new lyk(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new lyg(paramContext, paramVideoAppInterface);
          continue;
          if (paramBoolean)
          {
            paramContext = new lyl(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new lyh(paramContext, paramVideoAppInterface);
            continue;
            if (paramBoolean) {
              paramContext = new lyl(paramContext, paramVideoAppInterface);
            } else {
              paramContext = new lyj(paramContext, paramVideoAppInterface);
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
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, HashMap<Long, mas> paramHashMap) {}
  
  public void a(kvq paramkvq, ltl[] paramArrayOfltl, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(ltl[] paramArrayOfltl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(ltl[] paramArrayOfltl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract boolean a();
  
  public boolean b()
  {
    return a() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyf
 * JD-Core Version:    0.7.0.1
 */