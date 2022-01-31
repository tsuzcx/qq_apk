import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class rqw
{
  private final int jdField_a_of_type_Int;
  private final List<rqz> jdField_a_of_type_JavaUtilList;
  private final rqv jdField_a_of_type_Rqv;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  rqw(rqv paramrqv, List<rqz> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Rqv = paramrqv;
    this.jdField_a_of_type_Int = paramrqv.a();
    this.jdField_b_of_type_Int = paramrqv.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static rqx a(List<rqx> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      rqx localrqx2 = (rqx)paramList.get(i);
      if ((localrqx2.jdField_a_of_type_Int == paramInt) && (localrqx2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localrqx1 = localrqx2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localrqx1 = (rqx)paramList.get(paramInt);
        int j = localrqx1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localrqx1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    rqx localrqx1 = null;
    label123:
    return localrqx1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (rqz localrqz = null;; localrqz = (rqz)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localrqz == null) || (localrqz.jdField_a_of_type_Int != 0) || (localrqz.jdField_b_of_type_Int != 0))
      {
        localrqz = new rqz();
        localrqz.jdField_a_of_type_Int = 0;
        localrqz.jdField_b_of_type_Int = 0;
        localrqz.jdField_a_of_type_Boolean = false;
        localrqz.c = 0;
        localrqz.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localrqz);
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
  
  private void a(List<rqx> paramList, rrq paramrrq, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramrrq.a(paramInt1, paramInt2);
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
      paramrrq.a(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        rqx localrqx = (rqx)localIterator.next();
        localrqx.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        paramrrq.c(a(paramList, j, true).jdField_b_of_type_Int, paramInt1);
        if (i == 4) {
          paramrrq.a(paramInt1, 1, this.jdField_a_of_type_Rqv.a(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new rqx(paramInt3 + paramInt2, paramInt1, false));
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
      rqz localrqz = (rqz)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localrqz.jdField_a_of_type_Int;
      int n = localrqz.c;
      int i1 = localrqz.jdField_b_of_type_Int;
      int i2 = localrqz.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_Rqv.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_Rqv.b(paramInt2, j)) {}
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
        if (this.jdField_a_of_type_Rqv.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_Rqv.b(j, paramInt2)) {}
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
      paramInt2 = localrqz.jdField_a_of_type_Int;
      i = localrqz.jdField_b_of_type_Int;
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
      rqz localrqz = (rqz)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localrqz.jdField_a_of_type_Int;
      int i3 = localrqz.c;
      int n = localrqz.jdField_b_of_type_Int;
      int i1 = localrqz.c;
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
      if (i < localrqz.c)
      {
        m = localrqz.jdField_a_of_type_Int + i;
        n = localrqz.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_Rqv.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localrqz.jdField_a_of_type_Int;
      i = localrqz.jdField_b_of_type_Int;
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
  
  private void b(List<rqx> paramList, rrq paramrrq, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramrrq.b(paramInt1, paramInt2);
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
      paramrrq.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        rqx localrqx = (rqx)((Iterator)localObject).next();
        localrqx.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        paramrrq.c(paramInt1 + paramInt2, ((rqx)localObject).jdField_b_of_type_Int - 1);
        if (i == 4) {
          paramrrq.a(((rqx)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_Rqv.a(paramInt3 + paramInt2, j));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new rqx(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(@NonNull RecyclerView.Adapter paramAdapter)
  {
    a(new rqr(paramAdapter));
  }
  
  public void a(@NonNull rrq paramrrq)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramrrq instanceof rqs))
    {
      paramrrq = (rqs)paramrrq;
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
      rqz localrqz = (rqz)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localrqz.c;
      int n = localrqz.jdField_a_of_type_Int + m;
      int i1 = localrqz.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramrrq, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramrrq, n, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localrqz.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramrrq.a(localrqz.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_Rqv.a(localrqz.jdField_a_of_type_Int + j, localrqz.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramrrq = new rqs(paramrrq);
          break;
        }
      }
      j = localrqz.jdField_a_of_type_Int;
      k = localrqz.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramrrq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqw
 * JD-Core Version:    0.7.0.1
 */