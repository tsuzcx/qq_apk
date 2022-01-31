import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class lyj
  extends lyf
{
  private int a;
  
  public lyj(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = ((int)bacc.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, HashMap<Long, mas> paramHashMap)
  {
    paramRect2.set(paramRect1.left, paramRect1.top - paramInt, paramRect1.right, paramRect1.bottom - paramInt);
  }
  
  public void a(kvq paramkvq, ltl[] paramArrayOfltl, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
  }
  
  public void a(ltl[] paramArrayOfltl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfltl == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167853);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167850);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167851);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167852);
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
        paramArrayOfltl[1].b(m, k, j, i);
        kyy.b(i2, i1);
        kyy.a(m, k);
        kyy.a(paramInt1);
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
  
  public void a(ltl[] paramArrayOfltl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfltl[0].a(0, 0, 0, 0);
    paramArrayOfltl[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfltl[0].d(-15197410);
    paramArrayOfltl[1].a(3, 3, 3, 3);
    paramArrayOfltl[1].d(-15197410);
    a(paramArrayOfltl, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    lry locallry = new lry(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), locallry });
      if (QLog.isDevelopLevel()) {
        QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView, mBlock[" + locallry.jdField_b_of_type_Boolean + "], mBlockName[" + locallry.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !locallry.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyj
 * JD-Core Version:    0.7.0.1
 */