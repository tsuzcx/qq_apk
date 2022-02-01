import android.content.Context;
import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.ArrayList;
import java.util.List;

public class nfv
  extends nfw
{
  public static final int a;
  static final int[] jdField_a_of_type_ArrayOfInt;
  static final int[][] jdField_a_of_type_Array2dOfInt;
  static final int[] b;
  
  static
  {
    int[] arrayOfInt = { 3, 3, 4, 4 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 1 }, { 1, 1 }, { 1, 2 }, { 2, 2 }, { 2, 2, 1 }, { 2, 2, 2 }, { 2, 2, 3 }, { 2, 3, 3 }, { 3, 3, 3 }, { 3, 3, 2, 2 }, { 3, 3, 3, 2 }, { 3, 3, 3, 3 }, { 3, 3, 3, 4 }, arrayOfInt, { 3, 4, 4, 4 }, { 4, 4, 4, 4 } };
    jdField_a_of_type_Int = jdField_a_of_type_Array2dOfInt.length;
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3, 4, 1, 6, 7, 8, 5, 2 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 4, 5, 1, 8, 9, 12, 6, 2, 13, 10, 14, 15, 11, 7, 3 };
  }
  
  public nfv(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.jdField_b_of_type_Int = 1;
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
        break label296;
      }
      i = 1;
      if (i == 0) {
        break label402;
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
          break label310;
        }
        paramInt3 = 3;
        label137:
        if (j == 0) {
          break label315;
        }
        j = 3;
        label145:
        k = 0;
      }
      for (;;)
      {
        if (k >= paramInt3) {
          break label349;
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
            break label340;
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
                break label333;
              }
            }
          }
        }
        label296:
        label310:
        label315:
        label333:
        for (int i3 = localObject2[k];; i3 = i4)
        {
          localObject3 = new Rect(i6, m, i6 + n, i3 + m);
          localArrayList.add(localObject3);
          i2 += 1;
          break label199;
          j = 0;
          break;
          i = 0;
          break label56;
          arrayOfInt1 = jdField_b_of_type_ArrayOfInt;
          break label130;
          paramInt3 = 4;
          break label137;
          j = 4;
          break label145;
          m = (i4 + 0) * k;
          break label166;
        }
        label340:
        k += 1;
      }
      label349:
      localObject1 = new ArrayList();
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        localObject2 = (Rect)localArrayList.get(arrayOfInt1[paramInt2]);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        paramInt2 += 1;
      }
      return localObject1;
      label402:
      localObject1 = null;
    }
  }
  
  public void a(nfz[] paramArrayOfnfz1, nfz[] paramArrayOfnfz2, int paramInt1, int paramInt2, List<ncs> paramList)
  {
    paramArrayOfnfz2 = new ArrayList(8);
    int j = paramArrayOfnfz1.length;
    int i = 0;
    while (i < j)
    {
      paramList = paramArrayOfnfz1[i];
      if (paramList.a()) {
        paramArrayOfnfz2.add(paramList);
      }
      i += 1;
    }
    if (paramArrayOfnfz2.isEmpty()) {
      return;
    }
    i = paramArrayOfnfz2.size();
    i = Math.min(i, i);
    if (i > jdField_a_of_type_Int) {
      i = jdField_a_of_type_Int;
    }
    for (;;)
    {
      paramArrayOfnfz1 = a(i, paramInt1, paramInt2);
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= i) {
          break label176;
        }
        paramList = (Rect)paramArrayOfnfz1.get(paramInt1);
        if (paramList == null) {
          break;
        }
        ((nfz)paramArrayOfnfz2.get(paramInt1)).b(paramList.left, paramList.top, paramList.right, paramList.bottom);
        ((nfz)paramArrayOfnfz2.get(paramInt1)).a(0, 0, 0, 0);
        paramInt1 += 1;
      }
      label176:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfv
 * JD-Core Version:    0.7.0.1
 */