import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import java.io.BufferedReader;
import java.io.IOException;

public class lml
{
  public float a;
  private int jdField_a_of_type_Int;
  private PathMeasure jdField_a_of_type_AndroidGraphicsPathMeasure;
  private String jdField_a_of_type_JavaLangString;
  private lmm jdField_a_of_type_Lmm = new lmm();
  private lmp jdField_a_of_type_Lmp = new lmp();
  private lmq jdField_a_of_type_Lmq = new lmq();
  private lmt jdField_a_of_type_Lmt = new lmt();
  private boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private BitmapDrawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  private lmn[] jdField_a_of_type_ArrayOfLmn;
  private boolean[] jdField_a_of_type_ArrayOfBoolean;
  public float b;
  private int jdField_b_of_type_Int = 4;
  private lmp jdField_b_of_type_Lmp = new lmp();
  private lmq jdField_b_of_type_Lmq = new lmq();
  private boolean jdField_b_of_type_Boolean;
  float[] jdField_b_of_type_ArrayOfFloat = new float[2];
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private lmp jdField_c_of_type_Lmp = new lmq();
  private lmq jdField_c_of_type_Lmq = new lmq();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private lmp jdField_d_of_type_Lmp = new lmq();
  private lmq jdField_d_of_type_Lmq = new lmq();
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private lmq jdField_e_of_type_Lmq = new lmq();
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private lmq jdField_f_of_type_Lmq = new lmq();
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private lmq jdField_g_of_type_Lmq = new lmq();
  private boolean jdField_g_of_type_Boolean = true;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int;
  private lmq jdField_h_of_type_Lmq = new lmq();
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int;
  private lmq jdField_i_of_type_Lmq = new lmq();
  private int jdField_j_of_type_Int;
  private lmq jdField_j_of_type_Lmq = new lmq();
  private int jdField_k_of_type_Int;
  private lmq jdField_k_of_type_Lmq = new lmq();
  private lmq l = new lmq();
  
  public lml()
  {
    this.jdField_a_of_type_Float = 1.0F;
    b();
  }
  
  public lml(BufferedReader paramBufferedReader)
  {
    this.jdField_a_of_type_Float = 1.0F;
    b();
    a(paramBufferedReader);
  }
  
  static float a(BufferedReader paramBufferedReader, String paramString)
  {
    return Float.parseFloat(a(paramBufferedReader, paramString));
  }
  
  static int a(BufferedReader paramBufferedReader, String paramString)
  {
    return Integer.parseInt(a(paramBufferedReader, paramString));
  }
  
  static String a(BufferedReader paramBufferedReader, String paramString)
  {
    paramBufferedReader = paramBufferedReader.readLine();
    if (paramBufferedReader == null) {
      throw new IOException("Missing value: " + paramString);
    }
    return paramBufferedReader.substring(paramBufferedReader.indexOf(":") + 1).trim();
  }
  
  static boolean a(BufferedReader paramBufferedReader, String paramString)
  {
    return Boolean.parseBoolean(a(paramBufferedReader, paramString));
  }
  
  private boolean a(lmn paramlmn, float paramFloat, int paramInt)
  {
    paramInt = paramlmn.jdField_b_of_type_Int - paramInt;
    if (paramInt <= 0) {
      return false;
    }
    paramlmn.jdField_b_of_type_Int = paramInt;
    float f4 = 1.0F - paramlmn.jdField_b_of_type_Int / paramlmn.jdField_a_of_type_Int;
    paramInt = this.jdField_d_of_type_Int;
    if ((paramInt & 0x1) != 0) {
      paramlmn.b(paramlmn.jdField_a_of_type_Float + paramlmn.jdField_b_of_type_Float * this.jdField_d_of_type_Lmq.a(f4));
    }
    float f3;
    float f5;
    float f6;
    float f2;
    float f1;
    if ((paramInt & 0x8) != 0)
    {
      f3 = (paramlmn.jdField_e_of_type_Float + paramlmn.jdField_f_of_type_Float * this.jdField_f_of_type_Lmq.a(f4)) * paramFloat;
      if ((paramInt & 0x2) != 0)
      {
        float f7 = paramlmn.jdField_g_of_type_Float + paramlmn.jdField_h_of_type_Float * this.jdField_g_of_type_Lmq.a(f4);
        f5 = lmg.b(f7);
        f6 = lmg.a(f7);
        if ((paramInt & 0x4) != 0)
        {
          f2 = paramlmn.jdField_c_of_type_Float + paramlmn.jdField_d_of_type_Float * this.jdField_e_of_type_Lmq.a(f4);
          f1 = f2;
          if (this.jdField_e_of_type_Boolean) {
            f1 = f2 + f7;
          }
          paramlmn.a(f1);
        }
        f1 = f6 * f3;
        f2 = f3 * f5;
        f3 = f2;
        if ((paramInt & 0x10) != 0) {
          f3 = f2 + (paramlmn.m + paramlmn.n * this.jdField_h_of_type_Lmq.a(f4)) * paramFloat;
        }
        f2 = f1;
        if ((paramInt & 0x20) != 0) {
          f2 = f1 + (paramlmn.o + paramlmn.p * this.jdField_i_of_type_Lmq.a(f4)) * paramFloat;
        }
        paramlmn.a(f3, f2);
        label285:
        if ((paramInt & 0x40) == 0) {
          break label479;
        }
      }
    }
    label479:
    for (float[] arrayOfFloat = this.jdField_a_of_type_Lmm.a(f4);; arrayOfFloat = paramlmn.jdField_a_of_type_ArrayOfFloat)
    {
      paramFloat = arrayOfFloat[0];
      f1 = arrayOfFloat[1];
      f2 = arrayOfFloat[2];
      f3 = paramlmn.k;
      f5 = paramlmn.l;
      paramlmn.b(paramFloat, f1, f2, f3 + this.jdField_j_of_type_Lmq.a(f4) * f5);
      return true;
      f5 = paramlmn.jdField_i_of_type_Float;
      f6 = paramlmn.j;
      if ((this.jdField_e_of_type_Boolean) || ((paramInt & 0x4) != 0))
      {
        f2 = paramlmn.jdField_c_of_type_Float + paramlmn.jdField_d_of_type_Float * this.jdField_e_of_type_Lmq.a(f4);
        f1 = f2;
        if (this.jdField_e_of_type_Boolean) {
          f1 = f2 + paramlmn.jdField_g_of_type_Float;
        }
        paramlmn.a(f1);
      }
      f1 = f6 * f3;
      f2 = f3 * f5;
      break;
      if ((paramInt & 0x4) == 0) {
        break label285;
      }
      paramlmn.a(paramlmn.jdField_c_of_type_Float + paramlmn.jdField_d_of_type_Float * this.jdField_e_of_type_Lmq.a(f4));
      break label285;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_Lmp.a(true);
    this.jdField_c_of_type_Lmq.a(true);
    this.jdField_b_of_type_Lmq.a(true);
    this.jdField_d_of_type_Lmq.a(true);
    this.jdField_j_of_type_Lmq.a(true);
    this.jdField_a_of_type_Lmt.a(true);
    this.jdField_k_of_type_Lmq.a(true);
    this.l.a(true);
  }
  
  private void c()
  {
    float f1;
    if (this.jdField_a_of_type_Lmp.jdField_a_of_type_Boolean)
    {
      f1 = this.jdField_a_of_type_Lmp.a();
      this.jdField_h_of_type_Float = f1;
      this.jdField_i_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float -= this.jdField_a_of_type_Float;
      this.jdField_a_of_type_Float = this.jdField_b_of_type_Lmp.a();
      this.jdField_e_of_type_Int = ((int)this.jdField_c_of_type_Lmq.a());
      this.jdField_f_of_type_Int = ((int)this.jdField_c_of_type_Lmq.b());
      if (!this.jdField_c_of_type_Lmq.a()) {
        this.jdField_f_of_type_Int -= this.jdField_e_of_type_Int;
      }
      this.jdField_j_of_type_Int = ((int)this.jdField_b_of_type_Lmq.a());
      this.jdField_k_of_type_Int = ((int)this.jdField_b_of_type_Lmq.b());
      if (!this.jdField_b_of_type_Lmq.a()) {
        this.jdField_k_of_type_Int -= this.jdField_j_of_type_Int;
      }
      if (!this.jdField_a_of_type_Lmq.jdField_a_of_type_Boolean) {
        break label478;
      }
    }
    label478:
    for (int m = (int)this.jdField_a_of_type_Lmq.a();; m = 0)
    {
      this.jdField_h_of_type_Int = m;
      this.jdField_i_of_type_Int = ((int)this.jdField_a_of_type_Lmq.b());
      if (!this.jdField_a_of_type_Lmq.a()) {
        this.jdField_i_of_type_Int -= this.jdField_h_of_type_Int;
      }
      this.jdField_d_of_type_Float = this.jdField_k_of_type_Lmq.a();
      this.jdField_e_of_type_Float = this.jdField_k_of_type_Lmq.b();
      if (!this.jdField_k_of_type_Lmq.a()) {
        this.jdField_e_of_type_Float -= this.jdField_d_of_type_Float;
      }
      this.jdField_f_of_type_Float = this.l.a();
      this.jdField_g_of_type_Float = this.l.b();
      if (!this.l.a()) {
        this.jdField_g_of_type_Float -= this.jdField_f_of_type_Float;
      }
      this.jdField_d_of_type_Int = 0;
      if ((this.jdField_g_of_type_Lmq.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Lmq.jdField_a_of_type_ArrayOfFloat.length > 1)) {
        this.jdField_d_of_type_Int |= 0x2;
      }
      if (this.jdField_f_of_type_Lmq.jdField_a_of_type_Boolean) {
        this.jdField_d_of_type_Int |= 0x8;
      }
      if (this.jdField_d_of_type_Lmq.jdField_a_of_type_ArrayOfFloat.length > 1) {
        this.jdField_d_of_type_Int |= 0x1;
      }
      if ((this.jdField_e_of_type_Lmq.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Lmq.jdField_a_of_type_ArrayOfFloat.length > 1)) {
        this.jdField_d_of_type_Int |= 0x4;
      }
      if (this.jdField_h_of_type_Lmq.jdField_a_of_type_Boolean) {
        this.jdField_d_of_type_Int |= 0x10;
      }
      if (this.jdField_i_of_type_Lmq.jdField_a_of_type_Boolean) {
        this.jdField_d_of_type_Int |= 0x20;
      }
      if (this.jdField_a_of_type_Lmm.jdField_a_of_type_ArrayOfFloat.length > 1) {
        this.jdField_d_of_type_Int |= 0x40;
      }
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfLmn[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfLmn;
      localObject1 = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[lmg.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length - 1)]);
      localObject2[paramInt] = localObject1;
    }
    float f6 = this.jdField_b_of_type_Float / this.jdField_a_of_type_Float;
    paramInt = this.jdField_d_of_type_Int;
    int m = this.jdField_j_of_type_Int + (int)(this.jdField_k_of_type_Int * this.jdField_b_of_type_Lmq.a(f6));
    ((lmn)localObject1).jdField_a_of_type_Int = m;
    ((lmn)localObject1).jdField_b_of_type_Int = m;
    if (this.jdField_f_of_type_Lmq.jdField_a_of_type_Boolean)
    {
      ((lmn)localObject1).jdField_e_of_type_Float = this.jdField_f_of_type_Lmq.a();
      ((lmn)localObject1).jdField_f_of_type_Float = this.jdField_f_of_type_Lmq.b();
      if (!this.jdField_f_of_type_Lmq.a()) {
        ((lmn)localObject1).jdField_f_of_type_Float -= ((lmn)localObject1).jdField_e_of_type_Float;
      }
    }
    ((lmn)localObject1).jdField_g_of_type_Float = this.jdField_g_of_type_Lmq.a();
    ((lmn)localObject1).jdField_h_of_type_Float = this.jdField_g_of_type_Lmq.b();
    if (!this.jdField_g_of_type_Lmq.a()) {
      ((lmn)localObject1).jdField_h_of_type_Float -= ((lmn)localObject1).jdField_g_of_type_Float;
    }
    float f1;
    if ((paramInt & 0x2) == 0)
    {
      f1 = ((lmn)localObject1).jdField_g_of_type_Float + ((lmn)localObject1).jdField_h_of_type_Float * this.jdField_g_of_type_Lmq.a(0.0F);
      ((lmn)localObject1).jdField_g_of_type_Float = f1;
      ((lmn)localObject1).jdField_i_of_type_Float = lmg.b(f1);
      ((lmn)localObject1).j = lmg.a(f1);
    }
    for (;;)
    {
      float f7 = ((lmn)localObject1).getBitmap().getWidth();
      ((lmn)localObject1).jdField_a_of_type_Float = (this.jdField_d_of_type_Lmq.a() / f7);
      ((lmn)localObject1).jdField_b_of_type_Float = (this.jdField_d_of_type_Lmq.b() / f7);
      if (!this.jdField_d_of_type_Lmq.a()) {
        ((lmn)localObject1).jdField_b_of_type_Float -= ((lmn)localObject1).jdField_a_of_type_Float;
      }
      ((lmn)localObject1).b(((lmn)localObject1).jdField_a_of_type_Float + ((lmn)localObject1).jdField_b_of_type_Float * this.jdField_d_of_type_Lmq.a(0.0F));
      float f2;
      if (this.jdField_e_of_type_Lmq.jdField_a_of_type_Boolean)
      {
        ((lmn)localObject1).jdField_c_of_type_Float = this.jdField_e_of_type_Lmq.a();
        ((lmn)localObject1).jdField_d_of_type_Float = this.jdField_e_of_type_Lmq.b();
        if (!this.jdField_e_of_type_Lmq.a()) {
          ((lmn)localObject1).jdField_d_of_type_Float -= ((lmn)localObject1).jdField_c_of_type_Float;
        }
        f2 = ((lmn)localObject1).jdField_c_of_type_Float + ((lmn)localObject1).jdField_d_of_type_Float * this.jdField_e_of_type_Lmq.a(0.0F);
        if (!this.jdField_e_of_type_Boolean) {
          break label1380;
        }
      }
      label1380:
      for (f1 += f2;; f1 = f2)
      {
        ((lmn)localObject1).a(f1);
        if (this.jdField_h_of_type_Lmq.jdField_a_of_type_Boolean)
        {
          ((lmn)localObject1).m = this.jdField_h_of_type_Lmq.a();
          ((lmn)localObject1).n = this.jdField_h_of_type_Lmq.b();
          if (!this.jdField_h_of_type_Lmq.a()) {
            ((lmn)localObject1).n -= ((lmn)localObject1).m;
          }
        }
        if (this.jdField_i_of_type_Lmq.jdField_a_of_type_Boolean)
        {
          ((lmn)localObject1).o = this.jdField_i_of_type_Lmq.a();
          ((lmn)localObject1).p = this.jdField_i_of_type_Lmq.b();
          if (!this.jdField_i_of_type_Lmq.a()) {
            ((lmn)localObject1).p -= ((lmn)localObject1).o;
          }
        }
        float[] arrayOfFloat = ((lmn)localObject1).jdField_a_of_type_ArrayOfFloat;
        localObject2 = arrayOfFloat;
        if (arrayOfFloat == null)
        {
          localObject2 = new float[3];
          ((lmn)localObject1).jdField_a_of_type_ArrayOfFloat = ((float[])localObject2);
        }
        arrayOfFloat = this.jdField_a_of_type_Lmm.a(0.0F);
        localObject2[0] = arrayOfFloat[0];
        localObject2[1] = arrayOfFloat[1];
        localObject2[2] = arrayOfFloat[2];
        ((lmn)localObject1).k = this.jdField_j_of_type_Lmq.a();
        ((lmn)localObject1).l = (this.jdField_j_of_type_Lmq.b() - ((lmn)localObject1).k);
        float f3 = 3.4028235E+38F;
        float f4 = 3.4028235E+38F;
        f1 = f4;
        f2 = f3;
        float f5;
        if (this.jdField_a_of_type_AndroidGraphicsPathMeasure != null)
        {
          f5 = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
          f1 = f4;
          f2 = f3;
          if (f5 > 0.0F)
          {
            f1 = lmg.c(f5);
            this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(f1, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
            f2 = this.jdField_a_of_type_ArrayOfFloat[0];
            f1 = this.jdField_a_of_type_ArrayOfFloat[1];
          }
        }
        f4 = f2;
        if (this.jdField_c_of_type_Lmp.jdField_a_of_type_Boolean) {
          f4 = f2 + this.jdField_c_of_type_Lmp.a();
        }
        f3 = f1;
        if (this.jdField_d_of_type_Lmp.jdField_a_of_type_Boolean) {
          f3 = f1 + this.jdField_d_of_type_Lmp.a();
        }
        switch (this.jdField_a_of_type_Lmt.jdField_a_of_type_Int)
        {
        default: 
          f2 = f4;
          f1 = f3;
        }
        for (;;)
        {
          f3 = ((lmn)localObject1).getBitmap().getHeight();
          ((lmn)localObject1).a(f2 - f7 / 2.0F, f1 - f3 / 2.0F, f7, f3);
          m = (int)(this.jdField_h_of_type_Int + this.jdField_i_of_type_Int * this.jdField_a_of_type_Lmq.a(f6));
          if (m > 0)
          {
            paramInt = m;
            if (m >= ((lmn)localObject1).jdField_b_of_type_Int) {
              paramInt = ((lmn)localObject1).jdField_b_of_type_Int - 1;
            }
            a((lmn)localObject1, paramInt / 1000.0F, paramInt);
          }
          return;
          f2 = this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * this.jdField_k_of_type_Lmq.a(f6);
          f1 = this.jdField_f_of_type_Float + this.jdField_g_of_type_Float * this.l.a(f6);
          f2 = f4 + (lmg.c(f2) - f2 / 2.0F);
          f1 = f3 + (lmg.c(f1) - f1 / 2.0F);
          continue;
          f5 = this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * this.jdField_k_of_type_Lmq.a(f6);
          f1 = this.jdField_f_of_type_Float;
          f2 = this.jdField_g_of_type_Float;
          float f9 = this.l.a(f6);
          float f8 = f5 / 2.0F;
          f9 = (f1 + f2 * f9) / 2.0F;
          f1 = f3;
          f2 = f4;
          if (f8 != 0.0F)
          {
            f1 = f3;
            f2 = f4;
            if (f9 != 0.0F)
            {
              f1 = f8 / f9;
              if (this.jdField_a_of_type_Lmt.jdField_c_of_type_Boolean)
              {
                switch (this.jdField_a_of_type_Lmt.jdField_b_of_type_Int)
                {
                default: 
                  f5 = lmg.c(360.0F);
                }
                for (;;)
                {
                  f9 = lmg.b(f5);
                  float f10 = lmg.a(f5);
                  f4 += f9 * f8;
                  f3 += f8 * f10 / f1;
                  f1 = f3;
                  f2 = f4;
                  if ((paramInt & 0x2) != 0) {
                    break;
                  }
                  ((lmn)localObject1).jdField_g_of_type_Float = f5;
                  ((lmn)localObject1).jdField_i_of_type_Float = f9;
                  ((lmn)localObject1).j = f10;
                  f1 = f3;
                  f2 = f4;
                  break;
                  f5 = -lmg.c(179.0F);
                  continue;
                  f5 = lmg.c(179.0F);
                }
              }
              do
              {
                f2 = lmg.c(f5) - f8;
                f9 = lmg.c(f5) - f8;
              } while (f2 * f2 + f9 * f9 > f8 * f8);
              f2 = f4 + f2;
              f1 = f3 + f9 / f1;
              continue;
              f1 = this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * this.jdField_k_of_type_Lmq.a(f6);
              f5 = this.jdField_f_of_type_Float + this.jdField_g_of_type_Float * this.l.a(f6);
              if (f1 != 0.0F)
              {
                f8 = lmg.a() * f1;
                f2 = f4 + f8;
                f1 = f3 + f8 * (f5 / f1);
              }
              else
              {
                f1 = f3 + lmg.a() * f5;
                f2 = f4;
              }
            }
          }
        }
      }
      f1 = 0.0F;
    }
  }
  
  protected lmn a(BitmapDrawable paramBitmapDrawable)
  {
    return new lmn(paramBitmapDrawable);
  }
  
  public void a()
  {
    int n = this.jdField_c_of_type_Int;
    if (n == this.jdField_b_of_type_Int) {}
    for (;;)
    {
      return;
      boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
      int m = 0;
      int i1 = arrayOfBoolean.length;
      while (m < i1)
      {
        if (arrayOfBoolean[m] == 0)
        {
          d(m);
          arrayOfBoolean[m] = true;
          this.jdField_c_of_type_Int = (n + 1);
          return;
        }
        m += 1;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable == null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length <= 0)) {}
    do
    {
      return;
      this.jdField_c_of_type_Float += paramFloat * 1000.0F;
    } while (this.jdField_c_of_type_Float < 1.0F);
    int i2 = (int)this.jdField_c_of_type_Float;
    this.jdField_c_of_type_Float -= i2;
    if (this.jdField_i_of_type_Float < this.jdField_h_of_type_Float) {
      this.jdField_i_of_type_Float += i2;
    }
    int n;
    label378:
    for (;;)
    {
      boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
      n = this.jdField_c_of_type_Int;
      lmn[] arrayOflmn = this.jdField_a_of_type_ArrayOfLmn;
      int i3 = arrayOfBoolean.length;
      int m = 0;
      while (m < i3)
      {
        int i1 = n;
        if (arrayOfBoolean[m] != 0)
        {
          i1 = n;
          if (!a(arrayOflmn[m], paramFloat, i2))
          {
            arrayOfBoolean[m] = false;
            i1 = n - 1;
          }
        }
        m += 1;
        n = i1;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        a();
      }
      if (this.jdField_b_of_type_Float < this.jdField_a_of_type_Float)
      {
        this.jdField_b_of_type_Float += i2;
        m = 0;
      }
      for (;;)
      {
        if (m != 0) {
          break label378;
        }
        this.jdField_g_of_type_Int += i2;
        float f1 = this.jdField_e_of_type_Int + this.jdField_f_of_type_Int * this.jdField_c_of_type_Lmq.a(this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
        if (f1 > 0.0F)
        {
          f1 = 1000.0F / f1;
          if (this.jdField_g_of_type_Int >= f1)
          {
            m = Math.min((int)(this.jdField_g_of_type_Int / f1), this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
            this.jdField_g_of_type_Int = ((int)(this.jdField_g_of_type_Int - m * f1));
            this.jdField_g_of_type_Int = ((int)(this.jdField_g_of_type_Int % f1));
            b(m);
          }
        }
        if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_Int) {
          break;
        }
        b(this.jdField_a_of_type_Int - this.jdField_c_of_type_Int);
        break;
        if ((!this.jdField_d_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
        {
          m = 1;
        }
        else
        {
          c();
          m = 0;
        }
      }
    }
    this.jdField_c_of_type_Int = n;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[paramInt];
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfLmn = new lmn[paramInt];
  }
  
  public void a(Canvas paramCanvas)
  {
    lmn[] arrayOflmn = this.jdField_a_of_type_ArrayOfLmn;
    boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
    int m = 0;
    int n = arrayOfBoolean.length;
    while (m < n)
    {
      if (arrayOfBoolean[m] != 0) {
        arrayOflmn[m].draw(paramCanvas);
      }
      m += 1;
    }
  }
  
  public void a(PathMeasure paramPathMeasure)
  {
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = paramPathMeasure;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = a(paramBufferedReader, "name");
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Lmp.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_b_of_type_Lmp.a(paramBufferedReader);
      paramBufferedReader.readLine();
      c(a(paramBufferedReader, "minParticleCount"));
      a(a(paramBufferedReader, "maxParticleCount"));
      paramBufferedReader.readLine();
      this.jdField_c_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_b_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_c_of_type_Lmp.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_d_of_type_Lmp.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Lmt.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_k_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.l.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_d_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_f_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_g_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_e_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_h_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_i_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Lmm.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_j_of_type_Lmq.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_c_of_type_Boolean = a(paramBufferedReader, "attached");
      this.jdField_d_of_type_Boolean = a(paramBufferedReader, "continuous");
      this.jdField_e_of_type_Boolean = a(paramBufferedReader, "aligned");
      this.jdField_g_of_type_Boolean = a(paramBufferedReader, "additive");
      this.jdField_f_of_type_Boolean = a(paramBufferedReader, "behind");
      return;
    }
    catch (RuntimeException paramBufferedReader)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        throw paramBufferedReader;
      }
      throw new RuntimeException("Error parsing emitter: " + this.jdField_a_of_type_JavaLangString, paramBufferedReader);
    }
  }
  
  public void a(BitmapDrawable[] paramArrayOfBitmapDrawable)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable = paramArrayOfBitmapDrawable;
  }
  
  public void b(int paramInt)
  {
    int n = 0;
    int i1 = Math.min(paramInt, this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    if (i1 == 0) {
      return;
    }
    boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
    int i2 = arrayOfBoolean.length;
    int m = 0;
    paramInt = n;
    if (m < i1) {
      for (;;)
      {
        if (paramInt >= i2) {
          break label85;
        }
        if (arrayOfBoolean[paramInt] == 0)
        {
          d(paramInt);
          arrayOfBoolean[paramInt] = true;
          m += 1;
          paramInt += 1;
          break;
        }
        paramInt += 1;
      }
    }
    label85:
    this.jdField_c_of_type_Int += i1;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lml
 * JD-Core Version:    0.7.0.1
 */