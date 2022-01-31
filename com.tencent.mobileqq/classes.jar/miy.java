import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ScreenLayoutMultipleGrid.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class miy
  extends miw
{
  public static final int a;
  static final int[] jdField_a_of_type_ArrayOfInt;
  static final int[][] jdField_a_of_type_Array2dOfInt;
  public static final int b;
  static final int[] b;
  public static final int c = jdField_a_of_type_Array2dOfInt[(jdField_a_of_type_Array2dOfInt.length - 1)].length;
  private volatile HashMap<Long, mlj> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    int[] arrayOfInt1 = { 2, 2 };
    int[] arrayOfInt2 = { 2, 2, 2 };
    int[] arrayOfInt3 = { 2, 2, 3 };
    int[] arrayOfInt4 = { 3, 3, 3, 2 };
    int[] arrayOfInt5 = { 3, 4, 4, 4 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 1 }, { 1, 1 }, { 1, 2 }, arrayOfInt1, { 2, 2, 1 }, arrayOfInt2, arrayOfInt3, { 2, 3, 3 }, { 3, 3, 3 }, { 3, 3, 2, 2 }, arrayOfInt4, { 3, 3, 3, 3 }, { 3, 3, 3, 4 }, { 3, 3, 4, 4 }, arrayOfInt5, { 4, 4, 4, 4 } };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3, 4, 1, 6, 7, 8, 5, 2 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 4, 5, 1, 8, 9, 12, 6, 2, 13, 10, 14, 15, 11, 7, 3 };
    jdField_a_of_type_Int = jdField_a_of_type_Array2dOfInt.length;
    jdField_b_of_type_Int = jdField_a_of_type_Array2dOfInt[(jdField_a_of_type_Array2dOfInt.length - 1)][0];
  }
  
  protected miy(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private List<Rect> a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    int[] arrayOfInt2 = jdField_a_of_type_Array2dOfInt[(paramInt1 - 1)];
    int i5 = arrayOfInt2.length;
    int i4 = (paramInt3 + 0) / i5 + 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    label56:
    int k;
    Object localObject1;
    if (paramInt1 <= 9)
    {
      j = 1;
      if (paramInt1 != 5) {
        break label348;
      }
      i = 1;
      if (i == 0) {
        break label499;
      }
      k = paramInt3 / 10;
      localObject1 = new int[] { 0, k * 3, k * 6 };
    }
    for (Object localObject2 = { k * 3, k * 3, paramInt3 - k * 6 };; localObject2 = null)
    {
      int[] arrayOfInt1;
      if (j != 0)
      {
        arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
        label130:
        if (j == 0) {
          break label362;
        }
        paramInt3 = 3;
        label137:
        if (j == 0) {
          break label367;
        }
        j = 3;
        label145:
        k = 0;
      }
      for (;;)
      {
        if (k >= paramInt3) {
          break label401;
        }
        int m;
        label166:
        int n;
        int i2;
        label199:
        Object localObject3;
        int i6;
        if (i != 0)
        {
          m = localObject1[k];
          int i1 = 0;
          n = 0;
          if (k < i5)
          {
            i1 = arrayOfInt2[k];
            n = (paramInt2 + 0) / i1 + 0;
          }
          i2 = 0;
          if (i2 >= j) {
            break label392;
          }
          Object localObject4 = null;
          localObject3 = localObject4;
          if (i1 > 0)
          {
            localObject3 = localObject4;
            if (i2 < i1)
            {
              i6 = i2 * (n + 0);
              if (i == 0) {
                break label385;
              }
            }
          }
        }
        label385:
        for (int i3 = localObject2[k];; i3 = i4)
        {
          localObject3 = new Rect(i6, m, i6 + n, i3 + m);
          if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutMultipleGrid", 1, "getViewRects, creat rect: [" + k + "|" + i2 + "] :" + localObject3);
          }
          localArrayList.add(localObject3);
          i2 += 1;
          break label199;
          j = 0;
          break;
          label348:
          i = 0;
          break label56;
          arrayOfInt1 = jdField_b_of_type_ArrayOfInt;
          break label130;
          label362:
          paramInt3 = 4;
          break label137;
          label367:
          j = 4;
          break label145;
          m = (i4 + 0) * k;
          break label166;
        }
        label392:
        k += 1;
      }
      label401:
      localObject1 = new ArrayList();
      paramInt2 = 0;
      if (paramInt2 < paramInt1)
      {
        paramInt3 = arrayOfInt1[paramInt2];
        localObject2 = (Rect)localArrayList.get(paramInt3);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutMultipleGrid", 1, "getViewRects, sort rect has wrong: " + paramInt2 + "|" + paramInt3);
          }
        }
      }
      return localObject1;
      label499:
      localObject1 = null;
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, HashMap<Long, mlj> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(lgf paramlgf, mee[] paramArrayOfmee, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    label35:
    label97:
    do
    {
      return;
      paramInt3 = Math.min(paramlgf.c.size(), paramArrayOfmee.length);
      float f1;
      boolean bool;
      if (paramInt3 > jdField_a_of_type_Int)
      {
        paramInt3 = jdField_a_of_type_Int;
        if ((paramInt3 >= 2) && (muf.a(1))) {
          ThreadManager.getUIHandler().post(new ScreenLayoutMultipleGrid.1(this));
        }
        paramlgf = a(paramInt3, paramInt1, paramInt2);
        f1 = muf.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        float f2 = muf.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        paramInt1 = 0;
        if (paramInt1 < paramInt3)
        {
          Object localObject = (Rect)paramlgf.get(paramInt1);
          if (localObject == null) {
            continue;
          }
          paramArrayOfmee[paramInt1].b(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
          paramArrayOfmee[paramInt1].a(0, 0, 0, 0);
          long l1 = AudioHelper.a(paramArrayOfmee[paramInt1].b());
          long l2 = paramArrayOfmee[paramInt1].h();
          if ((TextUtils.isEmpty(paramArrayOfmee[paramInt1].a())) && (l1 != 0L)) {
            paramArrayOfmee[paramInt1].b(String.valueOf(l1));
          }
          if ((l1 == 0L) || (l2 == 2L)) {
            break label302;
          }
          paramBoolean = true;
          bool = paramBoolean;
          if (paramBoolean)
          {
            localObject = (mlj)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l1));
            if (localObject == null) {
              break label308;
            }
            bool = ((mlj)localObject).d();
          }
          paramArrayOfmee[paramInt1].c(bool);
          if (paramInt3 != 1) {
            break label314;
          }
          paramArrayOfmee[paramInt1].h(false);
          paramArrayOfmee[paramInt1].a(f2);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break label97;
        break;
        break label35;
        paramBoolean = false;
        break label225;
        bool = false;
        break label263;
        if (paramInt3 >= 2)
        {
          paramArrayOfmee[paramInt1].h(true);
          paramArrayOfmee[paramInt1].a(f1);
        }
      }
    } while (!QLog.isDevelopLevel());
    label225:
    QLog.w("ScreenLayoutMultipleGrid", 1, "layoutMulti, layout rect has wrong: " + paramInt1);
    label263:
    label302:
    label308:
    label314:
    return;
  }
  
  public void a(mee[] paramArrayOfmee, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ScreenLayoutMultipleGrid", 1, "setSmallVideoViewLayout, wrong call！ " + new Throwable());
    }
  }
  
  public void a(mee[] paramArrayOfmee, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ScreenLayoutMultipleGrid", 1, "layoutCommon, wrong call！ " + new Throwable());
    }
    paramArrayOfmee[0].a(0, 0, 0, 0);
    paramArrayOfmee[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfmee[0].d(-15197410);
    paramArrayOfmee[1].a(3, 3, 3, 3);
    paramArrayOfmee[1].d(-15197410);
    a(paramArrayOfmee, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     miy
 * JD-Core Version:    0.7.0.1
 */