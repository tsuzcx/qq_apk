import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class tbg
{
  final ArrayList<tbf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Character> jdField_a_of_type_JavaUtilSet;
  private final tbh jdField_a_of_type_Tbh;
  boolean jdField_a_of_type_Boolean = false;
  private tbd[] jdField_a_of_type_ArrayOfTbd;
  boolean b = false;
  
  public tbg(tbh paramtbh)
  {
    this.jdField_a_of_type_Tbh = paramtbh;
  }
  
  public float a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
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
      ((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramFloat, this.b);
      i += 1;
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      tbf localtbf = (tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localtbf.a(paramCanvas, paramPaint);
      paramCanvas.translate(localtbf.a(), 0.0F);
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfTbd == null) {
      throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a() > 0.0F) {
        i += 1;
      }
      for (;;)
      {
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    int[] arrayOfInt = tbc.a(a(), paramArrayOfChar, this.jdField_a_of_type_JavaUtilSet);
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
        this.jdField_a_of_type_JavaUtilArrayList.add(i, new tbf(this.jdField_a_of_type_ArrayOfTbd, this.jdField_a_of_type_Tbh));
      case 0: 
        tbf localtbf = (tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localtbf.a(i2, paramArrayOfChar[n], this.b);
        i4 = i + 1;
        n += 1;
        j = i1;
        k = i2;
        i3 = n;
        i = i4;
        if (this.jdField_a_of_type_Boolean) {
          if (localtbf.a() == localtbf.b())
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
        ((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(i2, '\000', this.b);
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
    this.jdField_a_of_type_ArrayOfTbd = new tbd[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfTbd[i] = new tbd(paramVarArgs[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_JavaUtilSet.addAll(this.jdField_a_of_type_ArrayOfTbd[i].a());
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
      arrayOfChar[i] = ((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public tbd[] a()
  {
    return this.jdField_a_of_type_ArrayOfTbd;
  }
  
  public float b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((tbf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbg
 * JD-Core Version:    0.7.0.1
 */