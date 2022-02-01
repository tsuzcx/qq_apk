package com.tencent.tkd.topicsdk.imagecompress;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class Luban$Builder
{
  private int jdField_a_of_type_Int = 100;
  private Context jdField_a_of_type_AndroidContentContext;
  private CompressionPredicate jdField_a_of_type_ComTencentTkdTopicsdkImagecompressCompressionPredicate;
  private OnCompressListener jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener;
  private OnRenameListener jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnRenameListener;
  private String jdField_a_of_type_JavaLangString;
  private List<InputStreamProvider> jdField_a_of_type_JavaUtilList;
  
  Luban$Builder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private Luban a()
  {
    return new Luban(this, null);
  }
  
  public Builder a(OnCompressListener paramOnCompressListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener = paramOnCompressListener;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(new Luban.Builder.2(this, paramString));
    return this;
  }
  
  public void a()
  {
    Luban.a(a(), this.jdField_a_of_type_AndroidContentContext);
  }
  
  public Builder b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban.Builder
 * JD-Core Version:    0.7.0.1
 */