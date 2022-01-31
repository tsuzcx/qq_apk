import com.tencent.qphone.base.util.QLog;

class lkf
{
  int jdField_a_of_type_Int = -99;
  boolean jdField_a_of_type_Boolean = false;
  int b = -99;
  int c = -99;
  int d = -99;
  int e = -99;
  int f = -99;
  int g = -99;
  int h = -99;
  int i = -99;
  int j = -99;
  
  void a()
  {
    a(-101, this.b, this.c, this.jdField_a_of_type_Boolean, -101, -101, -101, -101, -101, -101);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    long l = this.j;
    if (paramInt1 <= -99) {}
    for (this.j = 0;; this.j += 1)
    {
      if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (this.c != paramInt3) || (this.jdField_a_of_type_Boolean != paramBoolean) || (this.d != paramInt4) || (this.e != paramInt5) || (this.f != paramInt6) || (this.g != paramInt7) || (this.h != paramInt8) || (this.i != paramInt9)) {
        QLog.w("AndroidCamera", 1, "PreviewCallback, Index[" + l + "->" + this.j + "], degree[" + this.jdField_a_of_type_Int + "->" + paramInt1 + "], CUR_CAMERA[" + this.b + "->" + paramInt2 + "], nInFPS[" + this.c + "->" + paramInt3 + "], mSupportLandscape[" + this.jdField_a_of_type_Boolean + "->" + paramBoolean + "], cameraImageOrientation[" + this.d + "->" + paramInt4 + "], displayRotation[" + this.e + "->" + paramInt5 + "], mobileRotation[" + this.f + "->" + paramInt6 + "], dataLength[" + this.g + "->" + paramInt7 + "], w[" + this.h + "->" + paramInt8 + "], h[" + this.i + "->" + paramInt9 + "]");
      }
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramInt7;
      this.h = paramInt8;
      this.i = paramInt9;
      return;
    }
  }
  
  void b()
  {
    a(-100, this.b, this.c, this.jdField_a_of_type_Boolean, -100, -100, -100, -100, -100, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkf
 * JD-Core Version:    0.7.0.1
 */