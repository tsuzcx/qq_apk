import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class ors
{
  public int a;
  public ToServiceMsg a;
  public String a;
  public List<ArticleInfo> a;
  public boolean a;
  public byte[] a;
  public int b;
  public List<ArticleInfo> b;
  public boolean b;
  
  public ors a()
  {
    ors localors = new ors();
    localors.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg).a(this.jdField_a_of_type_Int).b(this.jdField_b_of_type_Int).a(this.jdField_a_of_type_JavaUtilList).b(this.jdField_b_of_type_JavaUtilList).a(this.jdField_a_of_type_Boolean).b(this.jdField_b_of_type_Boolean).a(this.jdField_a_of_type_ArrayOfByte).a(this.jdField_a_of_type_JavaLangString);
    return localors;
  }
  
  public ors a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ors a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    return this;
  }
  
  public ors a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ors a(List<ArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public ors a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public ors a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public ors b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ors b(List<ArticleInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public ors b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ors
 * JD-Core Version:    0.7.0.1
 */