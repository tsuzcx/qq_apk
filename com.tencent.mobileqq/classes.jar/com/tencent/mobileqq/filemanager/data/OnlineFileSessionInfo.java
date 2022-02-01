package com.tencent.mobileqq.filemanager.data;

public class OnlineFileSessionInfo
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public short b;
  public boolean b;
  public long c;
  public boolean c;
  
  public OnlineFileSessionInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ArrayOfByte = new byte[16];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Short = 0;
    this.jdField_b_of_type_Short = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public OnlineFileSessionInfo a()
  {
    try
    {
      OnlineFileSessionInfo localOnlineFileSessionInfo = (OnlineFileSessionInfo)super.clone();
      return localOnlineFileSessionInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo
 * JD-Core Version:    0.7.0.1
 */