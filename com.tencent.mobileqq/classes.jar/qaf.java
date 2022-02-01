import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class qaf
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
  
  public qaf a()
  {
    qaf localqaf = new qaf();
    localqaf.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg).a(this.jdField_a_of_type_Int).b(this.jdField_b_of_type_Int).a(this.jdField_a_of_type_JavaUtilList).b(this.jdField_b_of_type_JavaUtilList).a(this.jdField_a_of_type_Boolean).b(this.jdField_b_of_type_Boolean).a(this.jdField_a_of_type_ArrayOfByte).a(this.jdField_a_of_type_JavaLangString);
    return localqaf;
  }
  
  public qaf a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public qaf a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    return this;
  }
  
  public qaf a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public qaf a(List<ArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public qaf a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public qaf a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public qaf b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public qaf b(List<ArticleInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public qaf b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qaf
 * JD-Core Version:    0.7.0.1
 */