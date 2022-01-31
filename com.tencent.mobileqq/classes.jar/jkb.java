import com.tencent.qphone.base.util.QLog;

public class jkb
{
  int a = -1;
  int b = -1;
  int c = -1;
  int d = -1;
  int e = -1;
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 != this.a) || (paramInt2 != this.b) || (paramInt3 != this.c) || (paramInt4 != this.d) || (paramInt5 != this.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GraphicRenderMgr", 1, "setBeautyOrFaceConfig, level[" + this.a + "->" + paramInt1 + "], type[" + this.b + "->" + paramInt2 + "], endlevel[" + this.c + "->" + paramInt3 + "], faceLevel[" + this.d + "->" + paramInt4 + "], beautyLevel[" + this.e + "->" + paramInt5 + "]");
      }
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkb
 * JD-Core Version:    0.7.0.1
 */