import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class miv
  extends mis
{
  private int a;
  
  public miv(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = ((int)bfvh.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(lez paramlez, mdy[] paramArrayOfmdy, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramArrayOfmdy[0].a(0, 0, 0, 0);
    paramArrayOfmdy[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmdy[0].d(-15197410);
    int i;
    if (paramlez.D == 2)
    {
      paramArrayOfmdy[0].a(Boolean.valueOf(false));
      paramArrayOfmdy[1].a(Boolean.valueOf(true));
      paramArrayOfmdy[2].a(Boolean.valueOf(true));
      paramArrayOfmdy[3].a(Boolean.valueOf(true));
      paramArrayOfmdy[4].a(Boolean.valueOf(true));
      if ((!paramArrayOfmdy[0].f()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfmdy[0].k())) {
        break label471;
      }
      if (paramInt3 == 0) {
        paramArrayOfmdy[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297776));
      }
    }
    else
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299167);
      if (paramInt4 == 0) {
        break label528;
      }
    }
    label519:
    label528:
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfmdy[1].b().left;
        paramInt2 = paramArrayOfmdy[1].b().right;
        label244:
        paramArrayOfmdy[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label501;
        }
        paramInt2 = paramArrayOfmdy[2].b().left;
        paramInt1 = paramArrayOfmdy[2].b().right;
        label283:
        paramArrayOfmdy[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label510;
        }
        paramInt1 = paramArrayOfmdy[3].b().left;
        paramInt2 = paramArrayOfmdy[3].b().right;
        label322:
        paramArrayOfmdy[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label519;
        }
        paramInt2 = paramArrayOfmdy[4].b().left;
        paramInt1 = paramArrayOfmdy[4].b().right;
      }
      for (;;)
      {
        paramArrayOfmdy[4].b(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfmdy[1].d(-15197410);
        paramArrayOfmdy[2].d(-15197410);
        paramArrayOfmdy[3].d(-15197410);
        paramArrayOfmdy[4].d(-15197410);
        paramArrayOfmdy[1].a(2, 3, 3, 3);
        paramArrayOfmdy[2].a(2, 3, 2, 3);
        paramArrayOfmdy[3].a(2, 3, 2, 3);
        paramArrayOfmdy[4].a(3, 3, 2, 3);
        return;
        paramArrayOfmdy[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297776), 0, 0);
        break;
        label471:
        paramArrayOfmdy[0].a(0, 0, 0, 0);
        break;
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break label244;
        label501:
        paramInt2 = paramInt1 - k;
        break label283;
        label510:
        paramInt1 = paramInt2 - k;
        break label322;
        paramInt2 = paramInt1 - k;
      }
    }
  }
  
  public void a(mdy[] paramArrayOfmdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfmdy == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299169);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299167);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
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
        paramArrayOfmdy[1].b(m, k, j, i);
        lil.b(i2, i1);
        lil.a(m, k);
        lil.a(paramInt1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("OriginScreenLayout", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.jdField_a_of_type_Int + "]");
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
  
  public void a(mdy[] paramArrayOfmdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfmdy[0].a(0, 0, 0, 0);
    paramArrayOfmdy[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmdy[0].d(-15197410);
    paramArrayOfmdy[1].a(3, 3, 3, 3);
    paramArrayOfmdy[1].d(-15197410);
    a(paramArrayOfmdy, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    mcg localmcg = new mcg(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localmcg });
      if (QLog.isDevelopLevel()) {
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + localmcg.jdField_b_of_type_Boolean + "], mBlockName[" + localmcg.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localmcg.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     miv
 * JD-Core Version:    0.7.0.1
 */