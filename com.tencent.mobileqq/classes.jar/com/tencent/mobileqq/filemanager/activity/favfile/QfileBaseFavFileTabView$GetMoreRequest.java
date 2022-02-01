package com.tencent.mobileqq.filemanager.activity.favfile;

class QfileBaseFavFileTabView$GetMoreRequest
{
  boolean a = false;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  
  void a()
  {
    this.a = false;
    this.b = 0;
    this.c = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
  }
  
  void a(int paramInt)
  {
    this.e += 1;
    if (paramInt == this.g) {
      this.f += 1;
    }
    this.g = paramInt;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.a = true;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d += 1;
    this.e = 0;
    this.f = 0;
    this.g = paramInt1;
  }
  
  boolean b()
  {
    return (this.f < 5) || (this.e > 10);
  }
  
  String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" startCount:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" targetCount:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ReqSeq:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" continueCount:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mNoNewDataCount:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" mLastRecordSize:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.GetMoreRequest
 * JD-Core Version:    0.7.0.1
 */