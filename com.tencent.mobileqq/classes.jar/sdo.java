import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class sdo
{
  private final int jdField_a_of_type_Int;
  private final List<sdr> jdField_a_of_type_JavaUtilList;
  private final sdn jdField_a_of_type_Sdn;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  sdo(sdn paramsdn, List<sdr> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Sdn = paramsdn;
    this.jdField_a_of_type_Int = paramsdn.a();
    this.jdField_b_of_type_Int = paramsdn.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static sdp a(List<sdp> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      sdp localsdp2 = (sdp)paramList.get(i);
      if ((localsdp2.jdField_a_of_type_Int == paramInt) && (localsdp2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localsdp1 = localsdp2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localsdp1 = (sdp)paramList.get(paramInt);
        int j = localsdp1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localsdp1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    sdp localsdp1 = null;
    label123:
    return localsdp1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (sdr localsdr = null;; localsdr = (sdr)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localsdr == null) || (localsdr.jdField_a_of_type_Int != 0) || (localsdr.jdField_b_of_type_Int != 0))
      {
        localsdr = new sdr();
        localsdr.jdField_a_of_type_Int = 0;
        localsdr.jdField_b_of_type_Int = 0;
        localsdr.jdField_a_of_type_Boolean = false;
        localsdr.c = 0;
        localsdr.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localsdr);
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
  
  private void a(List<sdp> paramList, sei paramsei, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramsei.a(paramInt1, paramInt2);
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
      paramsei.a(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        sdp localsdp = (sdp)localIterator.next();
        localsdp.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        paramsei.c(a(paramList, j, true).jdField_b_of_type_Int, paramInt1);
        if (i == 4) {
          paramsei.a(paramInt1, 1, this.jdField_a_of_type_Sdn.a(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new sdp(paramInt3 + paramInt2, paramInt1, false));
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
      sdr localsdr = (sdr)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localsdr.jdField_a_of_type_Int;
      int n = localsdr.c;
      int i1 = localsdr.jdField_b_of_type_Int;
      int i2 = localsdr.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_Sdn.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_Sdn.b(paramInt2, j)) {}
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
        if (this.jdField_a_of_type_Sdn.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_Sdn.b(j, paramInt2)) {}
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
      paramInt2 = localsdr.jdField_a_of_type_Int;
      i = localsdr.jdField_b_of_type_Int;
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
      sdr localsdr = (sdr)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localsdr.jdField_a_of_type_Int;
      int i3 = localsdr.c;
      int n = localsdr.jdField_b_of_type_Int;
      int i1 = localsdr.c;
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
      if (i < localsdr.c)
      {
        m = localsdr.jdField_a_of_type_Int + i;
        n = localsdr.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_Sdn.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localsdr.jdField_a_of_type_Int;
      i = localsdr.jdField_b_of_type_Int;
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
  
  private void b(List<sdp> paramList, sei paramsei, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramsei.b(paramInt1, paramInt2);
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
      paramsei.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        sdp localsdp = (sdp)((Iterator)localObject).next();
        localsdp.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        paramsei.c(paramInt1 + paramInt2, ((sdp)localObject).jdField_b_of_type_Int - 1);
        if (i == 4) {
          paramsei.a(((sdp)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_Sdn.a(paramInt3 + paramInt2, j));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new sdp(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(@NonNull RecyclerView.Adapter paramAdapter)
  {
    a(new sdj(paramAdapter));
  }
  
  public void a(@NonNull sei paramsei)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramsei instanceof sdk))
    {
      paramsei = (sdk)paramsei;
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
      sdr localsdr = (sdr)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localsdr.c;
      int n = localsdr.jdField_a_of_type_Int + m;
      int i1 = localsdr.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramsei, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramsei, n, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localsdr.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramsei.a(localsdr.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_Sdn.a(localsdr.jdField_a_of_type_Int + j, localsdr.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramsei = new sdk(paramsei);
          break;
        }
      }
      j = localsdr.jdField_a_of_type_Int;
      k = localsdr.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramsei.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdo
 * JD-Core Version:    0.7.0.1
 */