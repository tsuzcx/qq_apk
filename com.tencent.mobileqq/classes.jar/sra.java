import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sra
{
  public List<sra> a;
  public srb a;
  private boolean a;
  
  public sra()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Srb = new srb();
    this.jdField_a_of_type_Srb.jdField_a_of_type_Int = 0;
    srb.a(this.jdField_a_of_type_Srb, 0);
    this.jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString = null;
  }
  
  public sra(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Srb = new srb();
    this.jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Srb.jdField_a_of_type_Int = paramInt1;
    srb.a(this.jdField_a_of_type_Srb, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new sra(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = srb.a(this.jdField_a_of_type_Srb);
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
    sra localsra = (sra)localIterator.next();
    if (!localsra.jdField_a_of_type_Boolean) {
      i = localsra.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<sra> a()
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
        sra localsra = (sra)localIterator.next();
        if (!localsra.jdField_a_of_type_Boolean) {
          if (localsra.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localsra);
          } else {
            localArrayList.addAll(localsra.a());
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
      ((sra)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Srb.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Srb.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Srb.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((sra)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Srb;
        srb.a(paramString, srb.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new sra(paramString, this.jdField_a_of_type_Srb.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Srb;
    srb.a(paramString, srb.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Srb).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sra
 * JD-Core Version:    0.7.0.1
 */