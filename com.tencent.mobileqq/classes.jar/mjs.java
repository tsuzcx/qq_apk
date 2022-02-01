import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class mjs
  extends mjo
{
  private int b;
  
  public mjs(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.b = ((int)bhdz.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, mmg> paramConcurrentHashMap)
  {
    paramRect2.set(paramRect1.left, paramRect1.top - paramInt, paramRect1.right, paramRect1.bottom - paramInt);
  }
  
  public void a(lfe paramlfe, meu[] paramArrayOfmeu, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
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
        QLog.w("ScreenLayoutSliderWindow", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.b + "]");
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
    paramArrayOfmeu[0].a(0, 0, 0, 0);
    paramArrayOfmeu[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmeu[0].d(-15197410);
    paramArrayOfmeu[1].a(3, 3, 3, 3);
    paramArrayOfmeu[1].d(-15197410);
    a(paramArrayOfmeu, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean b()
  {
    mdb localmdb = new mdb(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localmdb });
      if (QLog.isDevelopLevel()) {
        QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView, mBlock[" + localmdb.jdField_b_of_type_Boolean + "], mBlockName[" + localmdb.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localmdb.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mjs
 * JD-Core Version:    0.7.0.1
 */