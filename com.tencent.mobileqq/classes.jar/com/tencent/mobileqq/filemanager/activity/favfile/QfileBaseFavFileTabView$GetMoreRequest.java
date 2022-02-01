package com.tencent.mobileqq.filemanager.activity.favfile;

class QfileBaseFavFileTabView$GetMoreRequest
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" startCount:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" targetCount:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ReqSeq:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" continueCount:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mNoNewDataCount:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mLastRecordSize:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  void a(int paramInt)
  {
    this.d += 1;
    if (paramInt == this.f) {
      this.e += 1;
    }
    this.f = paramInt;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c += 1;
    this.d = 0;
    this.e = 0;
    this.f = paramInt1;
  }
  
  boolean a()
  {
    return (this.e < 5) || (this.d > 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.GetMoreRequest
 * JD-Core Version:    0.7.0.1
 */