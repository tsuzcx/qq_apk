import java.util.List;

public class sqv
{
  public int a;
  public String a;
  public List<String> a;
  public int b;
  public String b;
  public int c;
  
  public sqv() {}
  
  public sqv(spi paramspi)
  {
    this.jdField_a_of_type_Int = paramspi.jdField_e_of_type_Int;
    if (paramspi.g > 0) {}
    for (int i = paramspi.g;; i = squ.a(this.jdField_a_of_type_Int))
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramspi.jdField_e_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramspi.d;
      this.c = paramspi.f;
      this.jdField_a_of_type_JavaUtilList = paramspi.jdField_a_of_type_JavaUtilList;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("BaseSplitConfig =[");
    localStringBuilder1.append(" type=").append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(" mTransId=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(" mTextId=").append(this.c);
    localStringBuilder1.append(" mAlbumMinPicCount=").append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(" mAlbumDesc=").append(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" mTransList=");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (String str = "";; str = this.jdField_a_of_type_JavaUtilList.toString())
    {
      localStringBuilder2.append(str);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqv
 * JD-Core Version:    0.7.0.1
 */