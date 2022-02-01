import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import java.util.ArrayList;
import java.util.Iterator;

public class fr
{
  private int jdField_a_of_type_Int;
  private ArrayList<fm> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  private int b;
  private int c;
  private int d;
  private int e;
  
  public int a()
  {
    return this.d;
  }
  
  public fm a(int paramInt)
  {
    int j = this.jdField_a_of_type_Int;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = j;
    while (localIterator.hasNext())
    {
      fm localfm = (fm)localIterator.next();
      i += localfm.c();
      if ((j <= paramInt) && (paramInt < i)) {
        return localfm;
      }
      j = i;
    }
    return null;
  }
  
  public ArrayList<fm> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fm localfm = (fm)localIterator.next();
      localfm.a(paramCanvas, paramInt1, paramInt2, this.d);
      paramInt1 += localfm.c();
    }
  }
  
  public void a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = 0;
    this.d = paramInt3;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fm localfm = (fm)localIterator.next();
      if (localfm.d() > this.d) {
        this.d = localfm.d();
      }
      paramInt1 = this.c;
      this.c = (localfm.c() + paramInt1);
    }
    this.e = 0;
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramInt1 = ((fm)localIterator.next()).a(paramETEngine);
      if (paramInt1 > this.e) {
        this.e = paramInt1;
      }
    }
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fm localfm = (fm)localIterator.next();
      localfm.a(paramETEngine, paramBitmap, paramETDecoration, paramInt1, this.d - localfm.d() + paramInt2 - (this.e - localfm.a(paramETEngine)));
      paramInt1 += localfm.c();
    }
  }
  
  public void a(fm paramfm)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramfm);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fm localfm = (fm)localIterator.next();
      localfm.b(paramCanvas, paramInt1, paramInt2, this.d);
      paramInt1 += localfm.c();
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fr
 * JD-Core Version:    0.7.0.1
 */