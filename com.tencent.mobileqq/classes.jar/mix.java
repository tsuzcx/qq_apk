import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mix
  extends mit
{
  private int a;
  
  public mix(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = ((int)bbdv.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, HashMap<Long, mlg> paramHashMap)
  {
    paramRect2.set(paramRect1.left, paramRect1.top - paramInt, paramRect1.right, paramRect1.bottom - paramInt);
  }
  
  public void a(lga paramlga, mdz[] paramArrayOfmdz, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
  }
  
  public void a(mdz[] paramArrayOfmdz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfmdz == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298952);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298949);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298950);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298951);
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
        paramArrayOfmdz[1].b(m, k, j, i);
        ljj.b(i2, i1);
        ljj.a(m, k);
        ljj.a(paramInt1);
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
  
  public void a(mdz[] paramArrayOfmdz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfmdz[0].a(0, 0, 0, 0);
    paramArrayOfmdz[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmdz[0].d(-15197410);
    paramArrayOfmdz[1].a(3, 3, 3, 3);
    paramArrayOfmdz[1].d(-15197410);
    a(paramArrayOfmdz, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    mcj localmcj = new mcj(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localmcj });
      if (QLog.isDevelopLevel()) {
        QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView, mBlock[" + localmcj.jdField_b_of_type_Boolean + "], mBlockName[" + localmcj.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localmcj.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mix
 * JD-Core Version:    0.7.0.1
 */