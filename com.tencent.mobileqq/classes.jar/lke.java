import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lke
  extends lka
{
  public Canvas a;
  public Paint a;
  public lki a;
  public boolean a;
  public lla[] a;
  public int b;
  public Paint b;
  public Rect b;
  public lla b;
  public lla[] b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public lke(lki paramlki)
  {
    this.jdField_b_of_type_ArrayOfLla = new lla[4];
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    Bitmap localBitmap = Bitmap.createBitmap(252, 148, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_Lki = paramlki;
    this.jdField_a_of_type_Lla = new lla(localBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap);
    a(-10.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
    if (paramInt1 > 2)
    {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 13, 37, 59);
      if (this.jdField_a_of_type_ArrayOfLla != null)
      {
        if (paramInt1 < 10) {
          break label239;
        }
        if (this.jdField_a_of_type_ArrayOfLla[(paramInt1 / 10)] != null) {
          this.jdField_a_of_type_ArrayOfLla[(paramInt1 / 10)].a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        this.jdField_b_of_type_AndroidGraphicsRect.set(37, 13, 74, 59);
        if (this.jdField_a_of_type_ArrayOfLla[(paramInt1 % 10)] != null) {
          this.jdField_a_of_type_ArrayOfLla[(paramInt1 % 10)].a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        this.jdField_b_of_type_AndroidGraphicsRect.set(74, 0, 229, 59);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Lla != null) {
        this.jdField_b_of_type_Lla.a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 59, 252, 148);
      paramInt1 = (paramInt2 - 80) / 10;
      if ((paramInt1 >= 0) && (paramInt1 < this.jdField_b_of_type_ArrayOfLla.length) && (this.jdField_b_of_type_ArrayOfLla[paramInt1] != null)) {
        this.jdField_b_of_type_ArrayOfLla[paramInt1].a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      label239:
      if (this.jdField_a_of_type_ArrayOfLla[paramInt1] != null) {
        this.jdField_a_of_type_ArrayOfLla[paramInt1].a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_b_of_type_AndroidGraphicsRect.set(37, 0, 192, 59);
    }
  }
  
  public void a(long paramLong)
  {
    paramLong -= this.jdField_a_of_type_Long;
    int k = 0;
    int j = 0;
    int i;
    float f1;
    if (this.jdField_a_of_type_Boolean) {
      if ((paramLong > 0L) && (paramLong < 100L))
      {
        i = (int)(255L * paramLong / 100L);
        if (paramLong > 200L) {
          break label141;
        }
        f1 = 0.0055F * (float)paramLong + 0.0F;
      }
    }
    for (;;)
    {
      a(i);
      b(f1);
      return;
      if ((paramLong >= 100L) && (paramLong <= 1250L))
      {
        i = 255;
        break;
      }
      i = j;
      if (paramLong <= 1250L) {
        break;
      }
      i = j;
      if (paramLong >= 1350L) {
        break;
      }
      i = (int)(255L * (paramLong - 1350L) / -100L);
      break;
      label141:
      if ((paramLong > 200L) && (paramLong <= 300L))
      {
        f1 = -0.001F * (float)paramLong + 1.3F;
      }
      else if ((paramLong > 300L) && (paramLong <= 1150L))
      {
        f1 = 1.0F;
      }
      else if ((paramLong > 1150L) && (paramLong <= 1250L))
      {
        f1 = 0.001F * (float)paramLong - 0.15F;
      }
      else if ((paramLong > 1250L) && (paramLong <= 1350L))
      {
        f1 = -0.011F * (float)paramLong + 14.85F;
      }
      else
      {
        f1 = 0.0F;
        continue;
        if (paramLong < 100L) {
          i = (int)(255L * paramLong / 100L);
        }
        for (;;)
        {
          if (paramLong > 200L) {
            break label357;
          }
          f1 = 0.0055F * (float)paramLong + 0.0F;
          break;
          if ((paramLong >= 100L) && (paramLong <= 650L))
          {
            i = 255;
          }
          else
          {
            i = k;
            if (paramLong > 650L)
            {
              i = k;
              if (paramLong < 750L) {
                i = (int)(255L * (paramLong - 750L) / -100L);
              }
            }
          }
        }
        label357:
        if ((paramLong > 200L) && (paramLong <= 300L)) {
          f1 = -0.001F * (float)paramLong + 1.3F;
        } else if ((paramLong > 300L) && (paramLong <= 550L)) {
          f1 = 1.0F;
        } else if ((paramLong > 550L) && (paramLong <= 650L)) {
          f1 = 0.001F * (float)paramLong + 0.45F;
        } else if ((paramLong > 650L) && (paramLong <= 750L)) {
          f1 = -0.011F * (float)paramLong + 8.25F;
        } else {
          f1 = 0.0F;
        }
      }
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager, lla[] paramArrayOflla)
  {
    this.jdField_b_of_type_ArrayOfLla[0] = new lla(paramAVRedPacketManager.a("qav_redpacket_score_80.png"));
    this.jdField_b_of_type_ArrayOfLla[1] = new lla(paramAVRedPacketManager.a("qav_redpacket_score_90.png"));
    this.jdField_b_of_type_ArrayOfLla[2] = new lla(paramAVRedPacketManager.a("qav_redpacket_score_100.png"));
    this.jdField_b_of_type_ArrayOfLla[3] = new lla(paramAVRedPacketManager.a("qav_redpacket_score_110.png"));
    this.jdField_b_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_score_combo.png"));
    this.jdField_a_of_type_ArrayOfLla = paramArrayOflla;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    super.b();
    lla[] arrayOflla = this.jdField_b_of_type_ArrayOfLla;
    int j = arrayOflla.length;
    int i = 0;
    while (i < j)
    {
      lla locallla = arrayOflla[i];
      if (locallla != null) {
        locallla.a();
      }
      i += 1;
    }
    if (this.jdField_b_of_type_Lla != null) {
      this.jdField_b_of_type_Lla.a();
    }
    this.jdField_a_of_type_ArrayOfLla = null;
    this.jdField_a_of_type_Lki = null;
    this.jdField_b_of_type_ArrayOfLla = null;
    this.jdField_b_of_type_Lla = null;
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_b_of_type_AndroidGraphicsPaint = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 104 / 750);
    this.c = (paramInt1 * 123 / 750);
    this.d = (paramInt1 * 252 / 750);
    this.e = (paramInt1 * 148 / 750);
    this.f = (paramInt1 * 10 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Lki.a();
    int j = localRect.left - this.jdField_b_of_type_Int;
    int i = j;
    if (j < this.f) {
      i = this.f;
    }
    j = localRect.top - this.c;
    a(i, j, this.d + i, this.e + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lke
 * JD-Core Version:    0.7.0.1
 */