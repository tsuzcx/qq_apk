import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class rqt
{
  private static final Comparator<rqz> a = new rqu();
  
  @NonNull
  public static rqw a(@NonNull rqv paramrqv)
  {
    return a(paramrqv, true);
  }
  
  @NonNull
  public static rqw a(@NonNull rqv paramrqv, boolean paramBoolean)
  {
    int i = paramrqv.a();
    int j = paramrqv.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new rqy(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      rqy localrqy2 = (rqy)localArrayList2.remove(localArrayList2.size() - 1);
      rqz localrqz = a(paramrqv, localrqy2.jdField_a_of_type_Int, localrqy2.jdField_b_of_type_Int, localrqy2.c, localrqy2.d, arrayOfInt1, arrayOfInt2, i);
      if (localrqz != null)
      {
        if (localrqz.c > 0) {
          localArrayList1.add(localrqz);
        }
        localrqz.jdField_a_of_type_Int += localrqy2.jdField_a_of_type_Int;
        localrqz.jdField_b_of_type_Int += localrqy2.c;
        rqy localrqy1;
        if (localArrayList3.isEmpty())
        {
          localrqy1 = new rqy();
          label217:
          localrqy1.jdField_a_of_type_Int = localrqy2.jdField_a_of_type_Int;
          localrqy1.c = localrqy2.c;
          if (!localrqz.jdField_b_of_type_Boolean) {
            break label362;
          }
          localrqy1.jdField_b_of_type_Int = localrqz.jdField_a_of_type_Int;
          localrqy1.d = localrqz.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localrqy1);
          if (!localrqz.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localrqz.jdField_a_of_type_Boolean) {
            break label420;
          }
          localrqy2.jdField_a_of_type_Int = (localrqz.jdField_a_of_type_Int + localrqz.c + 1);
          localrqy2.c = (localrqz.jdField_b_of_type_Int + localrqz.c);
        }
        for (;;)
        {
          localArrayList2.add(localrqy2);
          break;
          localrqy1 = (rqy)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localrqz.jdField_a_of_type_Boolean)
          {
            localrqy1.jdField_b_of_type_Int = (localrqz.jdField_a_of_type_Int - 1);
            localrqy1.d = localrqz.jdField_b_of_type_Int;
            break label265;
          }
          localrqy1.jdField_b_of_type_Int = localrqz.jdField_a_of_type_Int;
          localrqy1.d = (localrqz.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localrqy2.jdField_a_of_type_Int = (localrqz.jdField_a_of_type_Int + localrqz.c);
          localrqy2.c = (localrqz.jdField_b_of_type_Int + localrqz.c + 1);
          continue;
          label457:
          localrqy2.jdField_a_of_type_Int = (localrqz.jdField_a_of_type_Int + localrqz.c);
          localrqy2.c = (localrqz.jdField_b_of_type_Int + localrqz.c);
        }
      }
      localArrayList3.add(localrqy2);
    }
    Collections.sort(localArrayList1, a);
    return new rqw(paramrqv, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static rqz a(rqv paramrqv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int m = paramInt2 - paramInt1;
    int n = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 < 1) || (paramInt4 - paramInt3 < 1)) {
      return null;
    }
    int i1 = m - n;
    int i2 = (m + n + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i2 - 1, paramInt5 + i2 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i2 - 1 + i1, paramInt5 + i2 + 1 + i1, m);
    int i;
    if (i1 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i2) {
        break label664;
      }
      int j = -i;
      boolean bool;
      int k;
      for (;;)
      {
        if (j > i) {
          break label382;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= j;
          while ((k < m) && (paramInt2 < n) && (paramrqv.a(paramInt1 + k, paramInt3 + paramInt2)))
          {
            k += 1;
            paramInt2 += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = k;
        if ((paramInt4 != 0) && (j >= i1 - i + 1) && (j <= i1 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          paramrqv = new rqz();
          paramrqv.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramrqv.jdField_b_of_type_Int = (paramrqv.jdField_a_of_type_Int - j);
          paramrqv.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramrqv.jdField_a_of_type_Boolean = bool;
          paramrqv.jdField_b_of_type_Boolean = false;
          return paramrqv;
        }
        j += 2;
      }
      label382:
      j = -i;
      while (j <= i)
      {
        int i3 = j + i1;
        if ((i3 == i + i1) || ((i3 != -i + i1) && (paramArrayOfInt2[(paramInt5 + i3 - 1)] < paramArrayOfInt2[(paramInt5 + i3 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 - 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= i3;
          while ((k > 0) && (paramInt2 > 0) && (paramrqv.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramrqv = new rqz();
          paramrqv.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramrqv.jdField_b_of_type_Int = (paramrqv.jdField_a_of_type_Int - i3);
          paramrqv.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramrqv.jdField_a_of_type_Boolean = bool;
          paramrqv.jdField_b_of_type_Boolean = true;
          return paramrqv;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqt
 * JD-Core Version:    0.7.0.1
 */