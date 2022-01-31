import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mlo
  extends mll
{
  private int a;
  
  public mlo(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = ((int)bdgz.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(lid paramlid, mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramArrayOfmgp[0].a(0, 0, 0, 0);
    paramArrayOfmgp[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmgp[0].d(-15197410);
    int i;
    if (paramlid.C == 2)
    {
      paramArrayOfmgp[0].a(Boolean.valueOf(false));
      paramArrayOfmgp[1].a(Boolean.valueOf(true));
      paramArrayOfmgp[2].a(Boolean.valueOf(true));
      paramArrayOfmgp[3].a(Boolean.valueOf(true));
      paramArrayOfmgp[4].a(Boolean.valueOf(true));
      if ((!paramArrayOfmgp[0].f()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfmgp[0].k())) {
        break label471;
      }
      if (paramInt3 == 0) {
        paramArrayOfmgp[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297630));
      }
    }
    else
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299005);
      if (paramInt4 == 0) {
        break label528;
      }
    }
    label519:
    label528:
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299006);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfmgp[1].b().left;
        paramInt2 = paramArrayOfmgp[1].b().right;
        label244:
        paramArrayOfmgp[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label501;
        }
        paramInt2 = paramArrayOfmgp[2].b().left;
        paramInt1 = paramArrayOfmgp[2].b().right;
        label283:
        paramArrayOfmgp[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label510;
        }
        paramInt1 = paramArrayOfmgp[3].b().left;
        paramInt2 = paramArrayOfmgp[3].b().right;
        label322:
        paramArrayOfmgp[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label519;
        }
        paramInt2 = paramArrayOfmgp[4].b().left;
        paramInt1 = paramArrayOfmgp[4].b().right;
      }
      for (;;)
      {
        paramArrayOfmgp[4].b(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfmgp[1].d(-15197410);
        paramArrayOfmgp[2].d(-15197410);
        paramArrayOfmgp[3].d(-15197410);
        paramArrayOfmgp[4].d(-15197410);
        paramArrayOfmgp[1].a(2, 3, 3, 3);
        paramArrayOfmgp[2].a(2, 3, 2, 3);
        paramArrayOfmgp[3].a(2, 3, 2, 3);
        paramArrayOfmgp[4].a(3, 3, 2, 3);
        return;
        paramArrayOfmgp[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297630), 0, 0);
        break;
        label471:
        paramArrayOfmgp[0].a(0, 0, 0, 0);
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
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfmgp == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299007);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299004);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299005);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299006);
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
        paramArrayOfmgp[1].b(m, k, j, i);
        llm.b(i2, i1);
        llm.a(m, k);
        llm.a(paramInt1);
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
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfmgp[0].a(0, 0, 0, 0);
    paramArrayOfmgp[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmgp[0].d(-15197410);
    paramArrayOfmgp[1].a(3, 3, 3, 3);
    paramArrayOfmgp[1].d(-15197410);
    a(paramArrayOfmgp, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    mey localmey = new mey(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localmey });
      if (QLog.isDevelopLevel()) {
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + localmey.jdField_b_of_type_Boolean + "], mBlockName[" + localmey.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localmey.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mlo
 * JD-Core Version:    0.7.0.1
 */