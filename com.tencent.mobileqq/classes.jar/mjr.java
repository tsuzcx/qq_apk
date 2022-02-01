import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class mjr
  extends mjo
{
  private int b;
  
  public mjr(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.b = ((int)bhdz.a(paramContext, 100.0F));
  }
  
  private void b(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfmeu[0].a(0, 0, 0, 0);
    paramArrayOfmeu[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmeu[0].d(-15197410);
    paramArrayOfmeu[1].a(3, 3, 3, 3);
    paramArrayOfmeu[1].d(-15197410);
    a(paramArrayOfmeu, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  private void c(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramBoolean = paramArrayOfmeu[0].a().equalsIgnoreCase(paramArrayOfmeu[0].c());
    meu localmeu;
    if (paramBoolean)
    {
      localmeu = paramArrayOfmeu[0];
      if (!paramBoolean) {
        break label178;
      }
      paramArrayOfmeu = paramArrayOfmeu[1];
      label36:
      if (!this.jdField_a_of_type_Boolean) {
        break label185;
      }
      paramInt3 = 0;
      label46:
      if (!this.jdField_a_of_type_Boolean) {
        break label202;
      }
    }
    label178:
    label185:
    label202:
    for (paramInt4 = 0;; paramInt4 = AIOUtils.dp2px(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramInt1 = paramInt1 - paramInt3 - AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt2 = paramInt2 - AIOUtils.dp2px(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - paramInt4;
      localmeu.a(0, 0, 0, 0);
      localmeu.d(-15197410);
      localmeu.b(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      paramInt1 = paramInt1 - paramInt3 - AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramArrayOfmeu.a(0, 0, 0, 0);
      paramArrayOfmeu.d(-15197410);
      paramArrayOfmeu.b(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
      return;
      localmeu = paramArrayOfmeu[1];
      break;
      paramArrayOfmeu = paramArrayOfmeu[0];
      break label36;
      paramInt3 = AIOUtils.dp2px(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label46;
    }
  }
  
  private void d(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramBoolean = paramArrayOfmeu[0].a().equalsIgnoreCase(paramArrayOfmeu[0].c());
    meu localmeu;
    if (paramBoolean)
    {
      localmeu = paramArrayOfmeu[0];
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (paramArrayOfmeu = paramArrayOfmeu[1];; paramArrayOfmeu = paramArrayOfmeu[0])
    {
      paramInt3 = AIOUtils.dp2px(120.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt4 = AIOUtils.dp2px(172.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt1 = (paramInt1 - paramInt3 * 2 - 2) / 2;
      paramInt2 = paramInt2 - paramInt4 - AIOUtils.dp2px(161.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localmeu.a(0, 0, 0, 0);
      localmeu.d(-15197410);
      localmeu.b(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      paramInt1 = paramInt1 + paramInt3 + 2;
      paramArrayOfmeu.a(0, 0, 0, 0);
      paramArrayOfmeu.d(-15197410);
      paramArrayOfmeu.b(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
      return;
      localmeu = paramArrayOfmeu[1];
      break;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(lfe paramlfe, meu[] paramArrayOfmeu, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramArrayOfmeu[0].a(0, 0, 0, 0);
    paramArrayOfmeu[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmeu[0].d(-15197410);
    int i;
    if (paramlfe.D == 2)
    {
      paramArrayOfmeu[0].a(Boolean.valueOf(false));
      paramArrayOfmeu[1].a(Boolean.valueOf(true));
      paramArrayOfmeu[2].a(Boolean.valueOf(true));
      paramArrayOfmeu[3].a(Boolean.valueOf(true));
      paramArrayOfmeu[4].a(Boolean.valueOf(true));
      if ((!paramArrayOfmeu[0].f()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfmeu[0].k())) {
        break label471;
      }
      if (paramInt3 == 0) {
        paramArrayOfmeu[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297777));
      }
    }
    else
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299178);
      if (paramInt4 == 0) {
        break label528;
      }
    }
    label519:
    label528:
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299179);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfmeu[1].b().left;
        paramInt2 = paramArrayOfmeu[1].b().right;
        label244:
        paramArrayOfmeu[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label501;
        }
        paramInt2 = paramArrayOfmeu[2].b().left;
        paramInt1 = paramArrayOfmeu[2].b().right;
        label283:
        paramArrayOfmeu[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label510;
        }
        paramInt1 = paramArrayOfmeu[3].b().left;
        paramInt2 = paramArrayOfmeu[3].b().right;
        label322:
        paramArrayOfmeu[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label519;
        }
        paramInt2 = paramArrayOfmeu[4].b().left;
        paramInt1 = paramArrayOfmeu[4].b().right;
      }
      for (;;)
      {
        paramArrayOfmeu[4].b(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfmeu[1].d(-15197410);
        paramArrayOfmeu[2].d(-15197410);
        paramArrayOfmeu[3].d(-15197410);
        paramArrayOfmeu[4].d(-15197410);
        paramArrayOfmeu[1].a(2, 3, 3, 3);
        paramArrayOfmeu[2].a(2, 3, 2, 3);
        paramArrayOfmeu[3].a(2, 3, 2, 3);
        paramArrayOfmeu[4].a(3, 3, 2, 3);
        return;
        paramArrayOfmeu[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297777), 0, 0);
        break;
        label471:
        paramArrayOfmeu[0].a(0, 0, 0, 0);
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
  
  public void a(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfmeu == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299180);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299177);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299178);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299179);
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
        paramArrayOfmeu[1].b(m, k, j, i);
        lix.b(i2, i1);
        lix.a(m, k);
        lix.a(paramInt1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("OriginScreenLayout", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.b + "]");
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
  
  public void a(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0) {
      b(paramArrayOfmeu, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        c(paramArrayOfmeu, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    d(paramArrayOfmeu, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
  }
  
  public boolean b()
  {
    mdb localmdb = new mdb(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localmdb });
      if (QLog.isDevelopLevel()) {
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + localmdb.jdField_b_of_type_Boolean + "], mBlockName[" + localmdb.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localmdb.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mjr
 * JD-Core Version:    0.7.0.1
 */