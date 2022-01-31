package cooperation.comic;

import java.lang.reflect.Array;

public class PluginPreloadStrategy$KMeans
{
  private int jdField_a_of_type_Int = 3;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float[][] jdField_a_of_type_Array2dOfFloat;
  
  public PluginPreloadStrategy$KMeans(PluginPreloadStrategy paramPluginPreloadStrategy, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = i;
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Array2dOfFloat = ((float[][])Array.newInstance(Float.TYPE, new int[] { paramInt, 2 }));
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Array2dOfFloat[paramInt][0] = 0;
      this.jdField_a_of_type_Array2dOfFloat[paramInt][1] = 0;
      paramInt += 1;
    }
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Int <= 0) || (paramInt < 1) || (paramInt > paramArrayOfInt.length)) {
      return -1;
    }
    int i2 = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int k = i2 / this.jdField_a_of_type_Int;
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      j = i * k;
      this.jdField_a_of_type_Array2dOfFloat[i][0] = j;
      this.jdField_a_of_type_Array2dOfFloat[i][1] = this.jdField_a_of_type_ArrayOfInt[j];
      while ((j < (i + 1) * k) && (j < i2))
      {
        if (this.jdField_a_of_type_ArrayOfInt[j] > this.jdField_a_of_type_Array2dOfFloat[i][1])
        {
          this.jdField_a_of_type_Array2dOfFloat[i][0] = j;
          this.jdField_a_of_type_Array2dOfFloat[i][1] = this.jdField_a_of_type_ArrayOfInt[j];
        }
        j += 1;
      }
      i += 1;
    }
    paramArrayOfInt = new int[i2];
    i = 0;
    while (i < i2)
    {
      paramArrayOfInt[i] = -1;
      i += 1;
    }
    i = this.jdField_a_of_type_Int;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int[] arrayOfInt1 = new int[this.jdField_a_of_type_Int];
    i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      arrayOfInt[i][0] = 0;
      arrayOfInt[i][1] = 0;
      arrayOfInt1[i] = ((int)this.jdField_a_of_type_Array2dOfFloat[i][0]);
      i += 1;
    }
    i = 0;
    int j = 0;
    while ((j < 10) && (i == 0))
    {
      k = 0;
      int n;
      int m;
      if (k < i2)
      {
        if (this.jdField_a_of_type_ArrayOfInt[k] == 0) {}
        for (;;)
        {
          k += 1;
          break;
          n = 0;
          m = Math.abs(k - (int)this.jdField_a_of_type_Array2dOfFloat[0][0]);
          i = 0;
          while (i < this.jdField_a_of_type_Int)
          {
            int i1 = m;
            if (m > Math.abs(k - (int)this.jdField_a_of_type_Array2dOfFloat[i][0]))
            {
              i1 = Math.abs(k - (int)this.jdField_a_of_type_Array2dOfFloat[i][0]);
              n = i;
            }
            i += 1;
            m = i1;
          }
          paramArrayOfInt[k] = n;
        }
      }
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        arrayOfInt[i][0] = 0;
        arrayOfInt[i][1] = 0;
        i += 1;
      }
      i = 0;
      int[] arrayOfInt2;
      if (i < i2)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] == 0) {}
        for (;;)
        {
          i += 1;
          break;
          arrayOfInt2 = arrayOfInt[paramArrayOfInt[i]];
          arrayOfInt2[0] += this.jdField_a_of_type_ArrayOfInt[i] * i;
          arrayOfInt2 = arrayOfInt[paramArrayOfInt[i]];
          arrayOfInt2[1] += this.jdField_a_of_type_ArrayOfInt[i];
        }
      }
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        if (arrayOfInt[i][1] != 0)
        {
          this.jdField_a_of_type_Array2dOfFloat[i][0] = ((int)Math.round(arrayOfInt[i][0] * 1.0D / arrayOfInt[i][1]));
          m = (int)this.jdField_a_of_type_Array2dOfFloat[i][0] - paramInt / 2;
          if (m < 0)
          {
            k = i2;
            arrayOfInt[i][1] = 0;
            m += k;
            k = 0;
            label613:
            if (k >= paramInt) {
              break label695;
            }
            if (paramArrayOfInt[m] == i)
            {
              arrayOfInt2 = arrayOfInt[i];
              arrayOfInt2[1] += this.jdField_a_of_type_ArrayOfInt[m];
            }
            n = m + 1;
            if (n < i2) {
              break label689;
            }
          }
          label689:
          for (m = -i2;; m = 0)
          {
            k += 1;
            m = n + m;
            break label613;
            k = 0;
            break;
          }
          label695:
          this.jdField_a_of_type_Array2dOfFloat[i][1] = arrayOfInt[i][1];
        }
        i += 1;
      }
      i = 1;
      k = 0;
      while (k < this.jdField_a_of_type_Int)
      {
        if (arrayOfInt1[k] != (int)this.jdField_a_of_type_Array2dOfFloat[k][0])
        {
          arrayOfInt1[k] = ((int)this.jdField_a_of_type_Array2dOfFloat[k][0]);
          i = 0;
        }
        k += 1;
      }
      j += 1;
    }
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_Array2dOfFloat.length)
    {
      i = 0;
      while (i < this.jdField_a_of_type_Array2dOfFloat.length - paramInt - 1)
      {
        if (this.jdField_a_of_type_Array2dOfFloat[(i + 1)][1] > this.jdField_a_of_type_Array2dOfFloat[i][1])
        {
          j = this.jdField_a_of_type_Array2dOfFloat[i][0];
          k = this.jdField_a_of_type_Array2dOfFloat[i][1];
          this.jdField_a_of_type_Array2dOfFloat[i][0] = this.jdField_a_of_type_Array2dOfFloat[(i + 1)][0];
          this.jdField_a_of_type_Array2dOfFloat[i][1] = this.jdField_a_of_type_Array2dOfFloat[(i + 1)][1];
          this.jdField_a_of_type_Array2dOfFloat[(i + 1)][0] = j;
          this.jdField_a_of_type_Array2dOfFloat[(i + 1)][1] = k;
        }
        i += 1;
      }
      paramInt += 1;
    }
    return (int)this.jdField_a_of_type_Array2dOfFloat[0][0];
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramInt <= 0) || (paramArrayOfInt.length < paramInt)) {
      return null;
    }
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      i += paramArrayOfInt[j];
      j += 1;
    }
    int k = 1;
    int m = i;
    j = 0;
    if (k < paramArrayOfInt.length)
    {
      i -= paramArrayOfInt[(k - 1)];
      if (k + paramInt - 1 < paramArrayOfInt.length) {
        i += paramArrayOfInt[(k + paramInt - 1)];
      }
      for (;;)
      {
        int n = m;
        if (m < i)
        {
          n = i;
          j = k;
        }
        k += 1;
        m = n;
        break;
        i += paramArrayOfInt[((k + paramInt - 1) % paramArrayOfInt.length)];
      }
    }
    int[] arrayOfInt = new int[paramInt];
    i = 0;
    if (i < paramInt)
    {
      arrayOfInt[i] = j;
      k = j + 1;
      if (k >= paramArrayOfInt.length) {}
      for (j = -paramArrayOfInt.length;; j = 0)
      {
        j = k + j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.PluginPreloadStrategy.KMeans
 * JD-Core Version:    0.7.0.1
 */