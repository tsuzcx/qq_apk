import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class sve
{
  private final int jdField_a_of_type_Int;
  private final List<svh> jdField_a_of_type_JavaUtilList;
  private final svd jdField_a_of_type_Svd;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  sve(svd paramsvd, List<svh> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Svd = paramsvd;
    this.jdField_a_of_type_Int = paramsvd.a();
    this.jdField_b_of_type_Int = paramsvd.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static svf a(List<svf> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      svf localsvf2 = (svf)paramList.get(i);
      if ((localsvf2.jdField_a_of_type_Int == paramInt) && (localsvf2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localsvf1 = localsvf2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localsvf1 = (svf)paramList.get(paramInt);
        int j = localsvf1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localsvf1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    svf localsvf1 = null;
    label123:
    return localsvf1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (svh localsvh = null;; localsvh = (svh)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localsvh == null) || (localsvh.jdField_a_of_type_Int != 0) || (localsvh.jdField_b_of_type_Int != 0))
      {
        localsvh = new svh();
        localsvh.jdField_a_of_type_Int = 0;
        localsvh.jdField_b_of_type_Int = 0;
        localsvh.jdField_a_of_type_Boolean = false;
        localsvh.c = 0;
        localsvh.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localsvh);
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ArrayOfInt[(paramInt1 - 1)] != 0) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private void a(List<svf> paramList, svy paramsvy, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramsvy.a(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Iterator localIterator;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramsvy.a(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        svf localsvf = (svf)localIterator.next();
        localsvf.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        paramsvy.c(a(paramList, j, true).jdField_b_of_type_Int, paramInt1);
        if (i == 4) {
          paramsvy.a(paramInt1, 1, this.jdField_a_of_type_Svd.a(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new svf(paramInt3 + paramInt2, paramInt1, false));
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int m = 8;
    int j;
    int k;
    int i;
    if (paramBoolean)
    {
      j = paramInt2 - 1;
      k = paramInt2 - 1;
      i = paramInt1;
      paramInt2 = j;
      j = k;
      k = i;
      i = paramInt2;
      paramInt2 = k;
    }
    for (;;)
    {
      if (paramInt3 < 0) {
        break label289;
      }
      svh localsvh = (svh)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localsvh.jdField_a_of_type_Int;
      int n = localsvh.c;
      int i1 = localsvh.jdField_b_of_type_Int;
      int i2 = localsvh.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_Svd.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_Svd.b(paramInt2, j)) {}
            for (paramInt1 = 8;; paramInt1 = 4)
            {
              this.jdField_b_of_type_ArrayOfInt[j] = (paramInt2 << 5 | 0x10);
              this.jdField_a_of_type_ArrayOfInt[paramInt2] = (paramInt1 | j << 5);
              return true;
              j = paramInt1 - 1;
              i = paramInt1 - 1;
              break;
            }
          }
          paramInt2 -= 1;
        }
      }
      paramInt2 = i - 1;
      while (paramInt2 >= i1 + i2)
      {
        if (this.jdField_a_of_type_Svd.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_Svd.b(j, paramInt2)) {}
          for (paramInt3 = m;; paramInt3 = 4)
          {
            this.jdField_a_of_type_ArrayOfInt[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
            this.jdField_b_of_type_ArrayOfInt[paramInt2] = (paramInt1 - 1 << 5 | paramInt3);
            return true;
          }
        }
        paramInt2 -= 1;
      }
      label269:
      paramInt2 = localsvh.jdField_a_of_type_Int;
      i = localsvh.jdField_b_of_type_Int;
      paramInt3 -= 1;
    }
    label289:
    return false;
  }
  
  private void b()
  {
    int j = this.jdField_a_of_type_Int;
    int i = this.jdField_b_of_type_Int;
    int k = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (k >= 0)
    {
      svh localsvh = (svh)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localsvh.jdField_a_of_type_Int;
      int i3 = localsvh.c;
      int n = localsvh.jdField_b_of_type_Int;
      int i1 = localsvh.c;
      int m;
      if (this.jdField_a_of_type_Boolean)
      {
        for (;;)
        {
          m = i;
          if (j <= i2 + i3) {
            break;
          }
          a(j, i, k);
          j -= 1;
        }
        while (m > n + i1)
        {
          b(j, m, k);
          m -= 1;
        }
      }
      i = 0;
      if (i < localsvh.c)
      {
        m = localsvh.jdField_a_of_type_Int + i;
        n = localsvh.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_Svd.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localsvh.jdField_a_of_type_Int;
      i = localsvh.jdField_b_of_type_Int;
      k -= 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_ArrayOfInt[(paramInt2 - 1)] != 0) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, true);
  }
  
  private void b(List<svf> paramList, svy paramsvy, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramsvy.b(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramsvy.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        svf localsvf = (svf)((Iterator)localObject).next();
        localsvf.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        paramsvy.c(paramInt1 + paramInt2, ((svf)localObject).jdField_b_of_type_Int - 1);
        if (i == 4) {
          paramsvy.a(((svf)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_Svd.a(paramInt3 + paramInt2, j));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new svf(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(@NonNull RecyclerView.Adapter paramAdapter)
  {
    a(new suz(paramAdapter));
  }
  
  public void a(@NonNull svy paramsvy)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramsvy instanceof sva))
    {
      paramsvy = (sva)paramsvy;
      localArrayList = new ArrayList();
      j = this.jdField_a_of_type_Int;
      k = this.jdField_b_of_type_Int;
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label234;
      }
      svh localsvh = (svh)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localsvh.c;
      int n = localsvh.jdField_a_of_type_Int + m;
      int i1 = localsvh.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramsvy, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramsvy, n, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localsvh.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramsvy.a(localsvh.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_Svd.a(localsvh.jdField_a_of_type_Int + j, localsvh.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramsvy = new sva(paramsvy);
          break;
        }
      }
      j = localsvh.jdField_a_of_type_Int;
      k = localsvh.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramsvy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sve
 * JD-Core Version:    0.7.0.1
 */