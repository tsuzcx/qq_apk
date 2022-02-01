import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class mjn
  extends mjj
{
  private int a;
  
  public mjn(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = ((int)bhmg.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, mma> paramConcurrentHashMap)
  {
    paramRect2.set(paramRect1.left, paramRect1.top - paramInt, paramRect1.right, paramRect1.bottom - paramInt);
  }
  
  public void a(lff paramlff, mep[] paramArrayOfmep, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
  }
  
  public void a(mep[] paramArrayOfmep, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfmep == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299104);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299101);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299102);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299103);
    if (paramInt5 == 0) {
      i = m;
    }
    for (;;)
    {
      int j;
      int k;
      switch (paramInt1)
      {
      default: 
        j = 0;
        k = 0;
        m = 0;
        i = n;
      }
      for (;;)
      {
        paramArrayOfmep[1].b(m, k, j, i);
        lir.b(i2, i1);
        lir.a(m, k);
        lir.a(paramInt1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("ScreenLayoutSliderWindow", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.jdField_a_of_type_Int + "]");
        return;
        j = m + i1;
        k = i + paramInt4;
        i = k + i2;
        continue;
        m = paramInt2 - i1 - m;
        j = m + i1;
        k = i + paramInt4;
        i = k + i2;
        continue;
        j = m + i1;
        k = paramInt3 - i2 - i - paramInt5;
        i = k + i2;
        continue;
        m = paramInt2 - i1 - m;
        j = m + i1;
        k = paramInt3 - i2 - i - paramInt5;
        i = k + i2;
      }
    }
  }
  
  public void a(mep[] paramArrayOfmep, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfmep[0].a(0, 0, 0, 0);
    paramArrayOfmep[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmep[0].d(-15197410);
    paramArrayOfmep[1].a(3, 3, 3, 3);
    paramArrayOfmep[1].d(-15197410);
    a(paramArrayOfmep, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    mcx localmcx = new mcx(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localmcx });
      if (QLog.isDevelopLevel()) {
        QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView, mBlock[" + localmcx.jdField_b_of_type_Boolean + "], mBlockName[" + localmcx.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localmcx.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjn
 * JD-Core Version:    0.7.0.1
 */