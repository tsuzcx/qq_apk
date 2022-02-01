import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class mzh
{
  private int jdField_a_of_type_Int = ImmersiveUtils.a();
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lrs jdField_a_of_type_Lrs;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = ImmersiveUtils.b();
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private lrs jdField_b_of_type_Lrs;
  private lrs c;
  private lrs d;
  
  public mzh(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private Bitmap a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Bitmap localBitmap = ((VideoController)localObject).a(String.valueOf(paramLong), String.valueOf(((VideoController)localObject).a().g), ((VideoController)localObject).a().F, true, false);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localObject = localBitmap;
      if (localBitmap.getConfig() != null) {}
    }
    else
    {
      localObject = mvk.a(this.jdField_a_of_type_AndroidContentContext, 2130840576);
    }
    return bheg.a((Bitmap)localObject, bheg.a(((Bitmap)localObject).getWidth()));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Lrs == null)
    {
      this.jdField_a_of_type_Lrs = new lrs(mvk.a(this.jdField_a_of_type_AndroidContentContext, 2130842357));
      this.jdField_a_of_type_Lrs.a(false);
    }
    if (this.c == null)
    {
      this.c = new lrs(a(paramLong1));
      this.c.a(false);
    }
    if (this.jdField_b_of_type_Lrs == null)
    {
      this.jdField_b_of_type_Lrs = new lrs(mvk.a(this.jdField_a_of_type_AndroidContentContext, 2130842356));
      this.jdField_b_of_type_Lrs.a(false);
    }
    if (this.d == null)
    {
      this.d = new lrs(a(paramLong2));
      this.d.a(false);
    }
  }
  
  private void a(lqo paramlqo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    lrs locallrs1;
    if (paramBoolean)
    {
      locallrs1 = this.jdField_a_of_type_Lrs;
      if (!paramBoolean) {
        break label139;
      }
    }
    label139:
    for (lrs locallrs2 = this.c;; locallrs2 = this.d)
    {
      int i = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = paramInt1 + (paramInt3 - paramInt1) / 2;
      int m = paramInt2 + (paramInt4 - paramInt2) / 2;
      paramlqo.a(k, m);
      paramlqo.a(locallrs1, 0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      paramlqo.a(locallrs2, 0, 0, i, j);
      paramlqo.a(-k, -m);
      return;
      locallrs1 = this.jdField_b_of_type_Lrs;
      break;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    int i = AIOUtils.dp2px(120.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.dp2px(172.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int m = (this.jdField_a_of_type_Int - i * 2 - 2) / 2;
    int k = this.jdField_b_of_type_Int - j - AIOUtils.dp2px(161.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(m, k, m + i, k + j);
    m = m + i + 2;
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(m, k, i + m, j + k);
  }
  
  public void a()
  {
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if (this.jdField_a_of_type_Lrs != null)
    {
      this.jdField_a_of_type_Lrs.a();
      this.jdField_a_of_type_Lrs = null;
    }
    if (this.jdField_b_of_type_Lrs != null)
    {
      this.jdField_b_of_type_Lrs.a();
      this.jdField_b_of_type_Lrs = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(lqo paramlqo, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    b();
    a(paramLong1, paramLong2);
    if (!paramBoolean1) {
      a(paramlqo, true, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (!paramBoolean2) {
      a(paramlqo, false, this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzh
 * JD-Core Version:    0.7.0.1
 */