package com.tencent.mobileqq.hotpic;

class VideoBaseItem$VideoStatusRecord
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public VideoBaseItem$VideoStatusRecord(VideoBaseItem paramVideoBaseItem, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected VideoStatusRecord a()
  {
    return (VideoStatusRecord)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.VideoStatusRecord
 * JD-Core Version:    0.7.0.1
 */