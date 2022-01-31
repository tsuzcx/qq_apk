import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sdl
{
  private static final Comparator<sdr> a = new sdm();
  
  @NonNull
  public static sdo a(@NonNull sdn paramsdn)
  {
    return a(paramsdn, true);
  }
  
  @NonNull
  public static sdo a(@NonNull sdn paramsdn, boolean paramBoolean)
  {
    int i = paramsdn.a();
    int j = paramsdn.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new sdq(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      sdq localsdq2 = (sdq)localArrayList2.remove(localArrayList2.size() - 1);
      sdr localsdr = a(paramsdn, localsdq2.jdField_a_of_type_Int, localsdq2.jdField_b_of_type_Int, localsdq2.c, localsdq2.d, arrayOfInt1, arrayOfInt2, i);
      if (localsdr != null)
      {
        if (localsdr.c > 0) {
          localArrayList1.add(localsdr);
        }
        localsdr.jdField_a_of_type_Int += localsdq2.jdField_a_of_type_Int;
        localsdr.jdField_b_of_type_Int += localsdq2.c;
        sdq localsdq1;
        if (localArrayList3.isEmpty())
        {
          localsdq1 = new sdq();
          label217:
          localsdq1.jdField_a_of_type_Int = localsdq2.jdField_a_of_type_Int;
          localsdq1.c = localsdq2.c;
          if (!localsdr.jdField_b_of_type_Boolean) {
            break label362;
          }
          localsdq1.jdField_b_of_type_Int = localsdr.jdField_a_of_type_Int;
          localsdq1.d = localsdr.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localsdq1);
          if (!localsdr.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localsdr.jdField_a_of_type_Boolean) {
            break label420;
          }
          localsdq2.jdField_a_of_type_Int = (localsdr.jdField_a_of_type_Int + localsdr.c + 1);
          localsdq2.c = (localsdr.jdField_b_of_type_Int + localsdr.c);
        }
        for (;;)
        {
          localArrayList2.add(localsdq2);
          break;
          localsdq1 = (sdq)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localsdr.jdField_a_of_type_Boolean)
          {
            localsdq1.jdField_b_of_type_Int = (localsdr.jdField_a_of_type_Int - 1);
            localsdq1.d = localsdr.jdField_b_of_type_Int;
            break label265;
          }
          localsdq1.jdField_b_of_type_Int = localsdr.jdField_a_of_type_Int;
          localsdq1.d = (localsdr.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localsdq2.jdField_a_of_type_Int = (localsdr.jdField_a_of_type_Int + localsdr.c);
          localsdq2.c = (localsdr.jdField_b_of_type_Int + localsdr.c + 1);
          continue;
          label457:
          localsdq2.jdField_a_of_type_Int = (localsdr.jdField_a_of_type_Int + localsdr.c);
          localsdq2.c = (localsdr.jdField_b_of_type_Int + localsdr.c);
        }
      }
      localArrayList3.add(localsdq2);
    }
    Collections.sort(localArrayList1, a);
    return new sdo(paramsdn, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static sdr a(sdn paramsdn, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramsdn.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramsdn = new sdr();
          paramsdn.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramsdn.jdField_b_of_type_Int = (paramsdn.jdField_a_of_type_Int - j);
          paramsdn.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramsdn.jdField_a_of_type_Boolean = bool;
          paramsdn.jdField_b_of_type_Boolean = false;
          return paramsdn;
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
          while ((k > 0) && (paramInt2 > 0) && (paramsdn.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramsdn = new sdr();
          paramsdn.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramsdn.jdField_b_of_type_Int = (paramsdn.jdField_a_of_type_Int - i3);
          paramsdn.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramsdn.jdField_a_of_type_Boolean = bool;
          paramsdn.jdField_b_of_type_Boolean = true;
          return paramsdn;
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
 * Qualified Name:     sdl
 * JD-Core Version:    0.7.0.1
 */