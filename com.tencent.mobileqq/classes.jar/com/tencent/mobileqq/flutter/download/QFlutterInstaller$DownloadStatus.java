package com.tencent.mobileqq.flutter.download;

class QFlutterInstaller$DownloadStatus
{
  public int a;
  private long a;
  public boolean a;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private long c = 0L;
  private long d = 0L;
  
  private QFlutterInstaller$DownloadStatus()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.c = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.d = (System.currentTimeMillis() - this.c);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterInstaller.DownloadStatus
 * JD-Core Version:    0.7.0.1
 */