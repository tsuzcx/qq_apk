import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class srd
{
  public List<srd> a;
  public sre a;
  private boolean a;
  
  public srd()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Sre = new sre();
    this.jdField_a_of_type_Sre.jdField_a_of_type_Int = 0;
    sre.a(this.jdField_a_of_type_Sre, 0);
    this.jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString = null;
  }
  
  public srd(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Sre = new sre();
    this.jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Sre.jdField_a_of_type_Int = paramInt1;
    sre.a(this.jdField_a_of_type_Sre, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new srd(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = sre.a(this.jdField_a_of_type_Sre);
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
    srd localsrd = (srd)localIterator.next();
    if (!localsrd.jdField_a_of_type_Boolean) {
      i = localsrd.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<srd> a()
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
        srd localsrd = (srd)localIterator.next();
        if (!localsrd.jdField_a_of_type_Boolean) {
          if (localsrd.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localsrd);
          } else {
            localArrayList.addAll(localsrd.a());
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
      ((srd)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Sre.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Sre.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Sre.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((srd)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Sre;
        sre.a(paramString, sre.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new srd(paramString, this.jdField_a_of_type_Sre.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Sre;
    sre.a(paramString, sre.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Sre).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srd
 * JD-Core Version:    0.7.0.1
 */