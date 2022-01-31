import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sdi
{
  private static final Comparator<sdo> a = new sdj();
  
  @NonNull
  public static sdl a(@NonNull sdk paramsdk)
  {
    return a(paramsdk, true);
  }
  
  @NonNull
  public static sdl a(@NonNull sdk paramsdk, boolean paramBoolean)
  {
    int i = paramsdk.a();
    int j = paramsdk.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new sdn(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      sdn localsdn2 = (sdn)localArrayList2.remove(localArrayList2.size() - 1);
      sdo localsdo = a(paramsdk, localsdn2.jdField_a_of_type_Int, localsdn2.jdField_b_of_type_Int, localsdn2.c, localsdn2.d, arrayOfInt1, arrayOfInt2, i);
      if (localsdo != null)
      {
        if (localsdo.c > 0) {
          localArrayList1.add(localsdo);
        }
        localsdo.jdField_a_of_type_Int += localsdn2.jdField_a_of_type_Int;
        localsdo.jdField_b_of_type_Int += localsdn2.c;
        sdn localsdn1;
        if (localArrayList3.isEmpty())
        {
          localsdn1 = new sdn();
          label217:
          localsdn1.jdField_a_of_type_Int = localsdn2.jdField_a_of_type_Int;
          localsdn1.c = localsdn2.c;
          if (!localsdo.jdField_b_of_type_Boolean) {
            break label362;
          }
          localsdn1.jdField_b_of_type_Int = localsdo.jdField_a_of_type_Int;
          localsdn1.d = localsdo.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localsdn1);
          if (!localsdo.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localsdo.jdField_a_of_type_Boolean) {
            break label420;
          }
          localsdn2.jdField_a_of_type_Int = (localsdo.jdField_a_of_type_Int + localsdo.c + 1);
          localsdn2.c = (localsdo.jdField_b_of_type_Int + localsdo.c);
        }
        for (;;)
        {
          localArrayList2.add(localsdn2);
          break;
          localsdn1 = (sdn)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localsdo.jdField_a_of_type_Boolean)
          {
            localsdn1.jdField_b_of_type_Int = (localsdo.jdField_a_of_type_Int - 1);
            localsdn1.d = localsdo.jdField_b_of_type_Int;
            break label265;
          }
          localsdn1.jdField_b_of_type_Int = localsdo.jdField_a_of_type_Int;
          localsdn1.d = (localsdo.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localsdn2.jdField_a_of_type_Int = (localsdo.jdField_a_of_type_Int + localsdo.c);
          localsdn2.c = (localsdo.jdField_b_of_type_Int + localsdo.c + 1);
          continue;
          label457:
          localsdn2.jdField_a_of_type_Int = (localsdo.jdField_a_of_type_Int + localsdo.c);
          localsdn2.c = (localsdo.jdField_b_of_type_Int + localsdo.c);
        }
      }
      localArrayList3.add(localsdn2);
    }
    Collections.sort(localArrayList1, a);
    return new sdl(paramsdk, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static sdo a(sdk paramsdk, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramsdk.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramsdk = new sdo();
          paramsdk.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramsdk.jdField_b_of_type_Int = (paramsdk.jdField_a_of_type_Int - j);
          paramsdk.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramsdk.jdField_a_of_type_Boolean = bool;
          paramsdk.jdField_b_of_type_Boolean = false;
          return paramsdk;
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
          while ((k > 0) && (paramInt2 > 0) && (paramsdk.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramsdk = new sdo();
          paramsdk.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramsdk.jdField_b_of_type_Int = (paramsdk.jdField_a_of_type_Int - i3);
          paramsdk.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramsdk.jdField_a_of_type_Boolean = bool;
          paramsdk.jdField_b_of_type_Boolean = true;
          return paramsdk;
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
 * Qualified Name:     sdi
 * JD-Core Version:    0.7.0.1
 */