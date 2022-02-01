import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mju
  extends mjo
{
  protected Display a;
  
  protected mju(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(lfe paramlfe, meu[] paramArrayOfmeu, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299178);
    if (paramInt4 != 0) {}
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299179);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfmeu[1].b().left;
        paramInt2 = paramArrayOfmeu[1].b().right;
        paramArrayOfmeu[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label320;
        }
        paramInt2 = paramArrayOfmeu[2].b().left;
        paramInt1 = paramArrayOfmeu[2].b().right;
        label139:
        paramArrayOfmeu[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label329;
        }
        paramInt1 = paramArrayOfmeu[3].b().left;
        paramInt2 = paramArrayOfmeu[3].b().right;
        label178:
        paramArrayOfmeu[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label338;
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
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break;
        label320:
        paramInt2 = paramInt1 - k;
        break label139;
        label329:
        paramInt1 = paramInt2 - k;
        break label178;
        label338:
        paramInt2 = paramInt1 - k;
      }
    }
  }
  
  public void a(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout position: " + paramInt1);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout mContext == null");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299180);
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299177);
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299178);
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299179);
    int m;
    int k;
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidViewDisplay.getRotation() % 2 == 0)
    {
      m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297911);
      k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297908);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297909);
      j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297910);
      if (paramInt5 != 0) {
        break label450;
      }
      j = i;
    }
    label450:
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = 0;
        paramInt3 = 0;
        i = 0;
        paramInt1 = n;
      }
      for (;;)
      {
        paramArrayOfmeu[1].b(i, paramInt3, paramInt2, paramInt1);
        lix.a("setSmallVideoViewLayout " + m + "|" + k);
        return;
        m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297908);
        k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297911);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297910);
        j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297909);
        break;
        paramInt2 = i + m;
        paramInt3 = j + paramInt4;
        paramInt1 = paramInt3 + k;
        continue;
        i = paramInt2 - m - i;
        paramInt2 = i + m;
        paramInt3 = j + paramInt4;
        paramInt1 = paramInt3 + k;
        continue;
        paramInt2 = i + m;
        paramInt3 = paramInt3 - k - j - paramInt5;
        paramInt1 = paramInt3 + k;
        continue;
        i = paramInt2 - m - i;
        paramInt3 = paramInt3 - k - j - paramInt5;
        paramInt2 = i + m;
        paramInt1 = paramInt3 + k;
      }
    }
  }
  
  public void a(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfmeu[1].a(3, 3, 3, 3);
    paramArrayOfmeu[1].d(-15197410);
    a(paramArrayOfmeu, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mju
 * JD-Core Version:    0.7.0.1
 */