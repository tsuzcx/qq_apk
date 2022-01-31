import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class rir
{
  final ArrayList<riq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Character> jdField_a_of_type_JavaUtilSet;
  private final ris jdField_a_of_type_Ris;
  boolean jdField_a_of_type_Boolean = false;
  private rio[] jdField_a_of_type_ArrayOfRio;
  boolean b = false;
  
  public rir(ris paramris)
  {
    this.jdField_a_of_type_Ris = paramris;
  }
  
  public float a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
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
      ((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramFloat, this.b);
      i += 1;
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      riq localriq = (riq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localriq.a(paramCanvas, paramPaint);
      paramCanvas.translate(localriq.a(), 0.0F);
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfRio == null) {
      throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a() > 0.0F) {
        i += 1;
      }
      for (;;)
      {
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    int[] arrayOfInt = rin.a(a(), paramArrayOfChar, this.jdField_a_of_type_JavaUtilSet);
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
        this.jdField_a_of_type_JavaUtilArrayList.add(i, new riq(this.jdField_a_of_type_ArrayOfRio, this.jdField_a_of_type_Ris));
      case 0: 
        riq localriq = (riq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localriq.a(i2, paramArrayOfChar[n], this.b);
        i4 = i + 1;
        n += 1;
        j = i1;
        k = i2;
        i3 = n;
        i = i4;
        if (this.jdField_a_of_type_Boolean) {
          if (localriq.a() == localriq.b())
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
        ((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(i2, '\000', this.b);
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
    this.jdField_a_of_type_ArrayOfRio = new rio[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfRio[i] = new rio(paramVarArgs[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_JavaUtilSet.addAll(this.jdField_a_of_type_ArrayOfRio[i].a());
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
      arrayOfChar[i] = ((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public rio[] a()
  {
    return this.jdField_a_of_type_ArrayOfRio;
  }
  
  public float b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((riq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rir
 * JD-Core Version:    0.7.0.1
 */