import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class svb
{
  private static final Comparator<svh> a = new svc();
  
  @NonNull
  public static sve a(@NonNull svd paramsvd)
  {
    return a(paramsvd, true);
  }
  
  @NonNull
  public static sve a(@NonNull svd paramsvd, boolean paramBoolean)
  {
    int i = paramsvd.a();
    int j = paramsvd.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new svg(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      svg localsvg2 = (svg)localArrayList2.remove(localArrayList2.size() - 1);
      svh localsvh = a(paramsvd, localsvg2.jdField_a_of_type_Int, localsvg2.jdField_b_of_type_Int, localsvg2.c, localsvg2.d, arrayOfInt1, arrayOfInt2, i);
      if (localsvh != null)
      {
        if (localsvh.c > 0) {
          localArrayList1.add(localsvh);
        }
        localsvh.jdField_a_of_type_Int += localsvg2.jdField_a_of_type_Int;
        localsvh.jdField_b_of_type_Int += localsvg2.c;
        svg localsvg1;
        if (localArrayList3.isEmpty())
        {
          localsvg1 = new svg();
          label217:
          localsvg1.jdField_a_of_type_Int = localsvg2.jdField_a_of_type_Int;
          localsvg1.c = localsvg2.c;
          if (!localsvh.jdField_b_of_type_Boolean) {
            break label362;
          }
          localsvg1.jdField_b_of_type_Int = localsvh.jdField_a_of_type_Int;
          localsvg1.d = localsvh.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localsvg1);
          if (!localsvh.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localsvh.jdField_a_of_type_Boolean) {
            break label420;
          }
          localsvg2.jdField_a_of_type_Int = (localsvh.jdField_a_of_type_Int + localsvh.c + 1);
          localsvg2.c = (localsvh.jdField_b_of_type_Int + localsvh.c);
        }
        for (;;)
        {
          localArrayList2.add(localsvg2);
          break;
          localsvg1 = (svg)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localsvh.jdField_a_of_type_Boolean)
          {
            localsvg1.jdField_b_of_type_Int = (localsvh.jdField_a_of_type_Int - 1);
            localsvg1.d = localsvh.jdField_b_of_type_Int;
            break label265;
          }
          localsvg1.jdField_b_of_type_Int = localsvh.jdField_a_of_type_Int;
          localsvg1.d = (localsvh.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localsvg2.jdField_a_of_type_Int = (localsvh.jdField_a_of_type_Int + localsvh.c);
          localsvg2.c = (localsvh.jdField_b_of_type_Int + localsvh.c + 1);
          continue;
          label457:
          localsvg2.jdField_a_of_type_Int = (localsvh.jdField_a_of_type_Int + localsvh.c);
          localsvg2.c = (localsvh.jdField_b_of_type_Int + localsvh.c);
        }
      }
      localArrayList3.add(localsvg2);
    }
    Collections.sort(localArrayList1, a);
    return new sve(paramsvd, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static svh a(svd paramsvd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramsvd.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramsvd = new svh();
          paramsvd.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramsvd.jdField_b_of_type_Int = (paramsvd.jdField_a_of_type_Int - j);
          paramsvd.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramsvd.jdField_a_of_type_Boolean = bool;
          paramsvd.jdField_b_of_type_Boolean = false;
          return paramsvd;
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
          while ((k > 0) && (paramInt2 > 0) && (paramsvd.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramsvd = new svh();
          paramsvd.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramsvd.jdField_b_of_type_Int = (paramsvd.jdField_a_of_type_Int - i3);
          paramsvd.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramsvd.jdField_a_of_type_Boolean = bool;
          paramsvd.jdField_b_of_type_Boolean = true;
          return paramsvd;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svb
 * JD-Core Version:    0.7.0.1
 */