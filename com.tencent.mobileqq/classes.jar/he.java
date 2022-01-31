import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import java.util.ArrayList;
import java.util.Iterator;

public class he
{
  private int jdField_a_of_type_Int;
  private ArrayList<gy> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  private int b;
  private int c;
  private int d;
  private int e;
  
  public int a()
  {
    return this.d;
  }
  
  public gy a(int paramInt)
  {
    int j = this.jdField_a_of_type_Int;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = j;
    while (localIterator.hasNext())
    {
      gy localgy = (gy)localIterator.next();
      i += localgy.c();
      if ((j <= paramInt) && (paramInt < i)) {
        return localgy;
      }
      j = i;
    }
    return null;
  }
  
  public ArrayList<gy> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      gy localgy = (gy)localIterator.next();
      localgy.a(paramCanvas, paramInt1, paramInt2, this.d);
      paramInt1 += localgy.c();
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
      gy localgy = (gy)localIterator.next();
      if (localgy.d() > this.d) {
        this.d = localgy.d();
      }
      paramInt1 = this.c;
      this.c = (localgy.c() + paramInt1);
    }
    this.e = 0;
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramInt1 = ((gy)localIterator.next()).a(paramETEngine);
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
      gy localgy = (gy)localIterator.next();
      localgy.a(paramETEngine, paramBitmap, paramETDecoration, paramInt1, this.d - localgy.d() + paramInt2 - (this.e - localgy.a(paramETEngine)));
      paramInt1 += localgy.c();
    }
  }
  
  public void a(gy paramgy)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramgy);
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
      gy localgy = (gy)localIterator.next();
      localgy.b(paramCanvas, paramInt1, paramInt2, this.d);
      paramInt1 += localgy.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     he
 * JD-Core Version:    0.7.0.1
 */