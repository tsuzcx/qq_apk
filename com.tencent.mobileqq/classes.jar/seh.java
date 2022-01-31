import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class seh
{
  public List<seh> a;
  public sei a;
  private boolean a;
  
  public seh()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Sei = new sei();
    this.jdField_a_of_type_Sei.jdField_a_of_type_Int = 0;
    sei.a(this.jdField_a_of_type_Sei, 0);
    this.jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString = null;
  }
  
  public seh(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Sei = new sei();
    this.jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Sei.jdField_a_of_type_Int = paramInt1;
    sei.a(this.jdField_a_of_type_Sei, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new seh(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = sei.a(this.jdField_a_of_type_Sei);
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    seh localseh = (seh)localIterator.next();
    if (!localseh.jdField_a_of_type_Boolean) {
      i = localseh.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<seh> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      localArrayList.add(this);
    }
    for (;;)
    {
      return localArrayList;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        seh localseh = (seh)localIterator.next();
        if (!localseh.jdField_a_of_type_Boolean) {
          if (localseh.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localseh);
          } else {
            localArrayList.addAll(localseh.a());
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((seh)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Sei.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Sei.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Sei.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((seh)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Sei;
        sei.a(paramString, sei.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new seh(paramString, this.jdField_a_of_type_Sei.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Sei;
    sei.a(paramString, sei.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Sei).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     seh
 * JD-Core Version:    0.7.0.1
 */