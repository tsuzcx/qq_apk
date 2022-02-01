package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.uftransfer.api.UFTHost;
import java.util.List;

public class UFTFileUploaderProp$ExtfSvrInfo
{
  protected String a;
  protected List<UFTHost> a;
  protected boolean a;
  protected byte[] a;
  protected String b;
  protected List<UFTHost> b;
  protected List<UFTHost> c;
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<UFTHost> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<UFTHost> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<UFTHost> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b(List<UFTHost> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public boolean b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0)) {
      return true;
    }
    this.jdField_b_of_type_JavaLangString = "bigDataChnHost is empty";
    return false;
  }
  
  public List<UFTHost> c()
  {
    return this.c;
  }
  
  public void c(List<UFTHost> paramList)
  {
    this.c = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfSvrInfo
 * JD-Core Version:    0.7.0.1
 */