import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class slr
{
  final ArrayList<slq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Character> jdField_a_of_type_JavaUtilSet;
  private final sls jdField_a_of_type_Sls;
  boolean jdField_a_of_type_Boolean = false;
  private slo[] jdField_a_of_type_ArrayOfSlo;
  boolean b = false;
  
  public slr(sls paramsls)
  {
    this.jdField_a_of_type_Sls = paramsls;
  }
  
  public float a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      i += 1;
    }
    return f;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramFloat, this.b);
      i += 1;
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      slq localslq = (slq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localslq.a(paramCanvas, paramPaint);
      paramCanvas.translate(localslq.a(), 0.0F);
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfSlo == null) {
      throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a() > 0.0F) {
        i += 1;
      }
      for (;;)
      {
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    int[] arrayOfInt = sln.a(a(), paramArrayOfChar, this.jdField_a_of_type_JavaUtilSet);
    int m = 0;
    int i1 = 1;
    int i2 = 1;
    int n = 0;
    i = 0;
    if (m < arrayOfInt.length)
    {
      int i4;
      int j;
      int k;
      int i3;
      switch (arrayOfInt[m])
      {
      default: 
        throw new IllegalArgumentException("Unknown action: " + arrayOfInt[m]);
      case 1: 
        this.jdField_a_of_type_JavaUtilArrayList.add(i, new slq(this.jdField_a_of_type_ArrayOfSlo, this.jdField_a_of_type_Sls));
      case 0: 
        slq localslq = (slq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localslq.a(i2, paramArrayOfChar[n], this.b);
        i4 = i + 1;
        n += 1;
        j = i1;
        k = i2;
        i3 = n;
        i = i4;
        if (this.jdField_a_of_type_Boolean) {
          if (localslq.a() == localslq.b())
          {
            j = i1;
            k = i2;
            i3 = n;
            i = i4;
            if (i2 <= 1) {
              break;
            }
          }
          else
          {
            k = i2 + i1;
            j = i1 + 1;
            i = i4;
            i3 = n;
          }
        }
        break;
      }
      for (;;)
      {
        m += 1;
        i1 = j;
        i2 = k;
        n = i3;
        break;
        ((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(i2, '\000', this.b);
        i4 = i + 1;
        j = i1;
        k = i2;
        i3 = n;
        i = i4;
        if (this.jdField_a_of_type_Boolean)
        {
          k = i2 + i1;
          j = i1 + 1;
          i3 = n;
          i = i4;
        }
      }
    }
  }
  
  public void a(String... paramVarArgs)
  {
    int j = 0;
    this.jdField_a_of_type_ArrayOfSlo = new slo[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfSlo[i] = new slo(paramVarArgs[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_JavaUtilSet.addAll(this.jdField_a_of_type_ArrayOfSlo[i].a());
      i += 1;
    }
  }
  
  char[] a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public slo[] a()
  {
    return this.jdField_a_of_type_ArrayOfSlo;
  }
  
  public float b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((slq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     slr
 * JD-Core Version:    0.7.0.1
 */