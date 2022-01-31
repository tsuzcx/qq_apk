import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lyi
  extends lyf
{
  private int a;
  
  public lyi(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = ((int)bacc.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(kvq paramkvq, ltl[] paramArrayOfltl, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramArrayOfltl[0].a(0, 0, 0, 0);
    paramArrayOfltl[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfltl[0].d(-15197410);
    int i;
    if (paramkvq.A == 2)
    {
      paramArrayOfltl[0].a(Boolean.valueOf(false));
      paramArrayOfltl[1].a(Boolean.valueOf(true));
      paramArrayOfltl[2].a(Boolean.valueOf(true));
      paramArrayOfltl[3].a(Boolean.valueOf(true));
      paramArrayOfltl[4].a(Boolean.valueOf(true));
      if ((!paramArrayOfltl[0].f()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfltl[0].k())) {
        break label471;
      }
      if (paramInt3 == 0) {
        paramArrayOfltl[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131166520));
      }
    }
    else
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167851);
      if (paramInt4 == 0) {
        break label528;
      }
    }
    label519:
    label528:
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167852);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfltl[1].b().left;
        paramInt2 = paramArrayOfltl[1].b().right;
        label244:
        paramArrayOfltl[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label501;
        }
        paramInt2 = paramArrayOfltl[2].b().left;
        paramInt1 = paramArrayOfltl[2].b().right;
        label283:
        paramArrayOfltl[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label510;
        }
        paramInt1 = paramArrayOfltl[3].b().left;
        paramInt2 = paramArrayOfltl[3].b().right;
        label322:
        paramArrayOfltl[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label519;
        }
        paramInt2 = paramArrayOfltl[4].b().left;
        paramInt1 = paramArrayOfltl[4].b().right;
      }
      for (;;)
      {
        paramArrayOfltl[4].b(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfltl[1].d(-15197410);
        paramArrayOfltl[2].d(-15197410);
        paramArrayOfltl[3].d(-15197410);
        paramArrayOfltl[4].d(-15197410);
        paramArrayOfltl[1].a(2, 3, 3, 3);
        paramArrayOfltl[2].a(2, 3, 2, 3);
        paramArrayOfltl[3].a(2, 3, 2, 3);
        paramArrayOfltl[4].a(3, 3, 2, 3);
        return;
        paramArrayOfltl[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131166520), 0, 0);
        break;
        label471:
        paramArrayOfltl[0].a(0, 0, 0, 0);
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
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + locallry.jdField_b_of_type_Boolean + "], mBlockName[" + locallry.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !locallry.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyi
 * JD-Core Version:    0.7.0.1
 */