import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.redpacket.ui.RedPacketGameScore.1;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.List;

public class lkz
  implements View.OnClickListener
{
  public static final float[] a;
  public float a;
  public int a;
  public long a;
  public Bitmap a;
  public Path a;
  public RedPacketGameView a;
  public Runnable a;
  private WeakReference<AVActivity> a;
  public lkv a;
  public boolean a;
  public lkv[] a;
  public lla[] a;
  public float b;
  public int b;
  public long b;
  public Bitmap b;
  public lkv b;
  public boolean b;
  public float[] b;
  public int c;
  public Bitmap c;
  public lkv c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 7.0F, -7.0F, 0.0F, -4.0F, 7.0F, 3.0F };
  }
  
  public lkz(RedPacketGameView paramRedPacketGameView, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ArrayOfLkv = new lkv[4];
    this.jdField_a_of_type_Lkv = new lkv();
    this.jdField_b_of_type_Lkv = new lkv();
    this.jdField_c_of_type_Lkv = new lkv();
    this.jdField_c_of_type_Int = 10;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
    this.jdField_a_of_type_JavaLangRunnable = new RedPacketGameScore.1(this);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView = paramRedPacketGameView;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    int n = 0;
    while (n < this.jdField_a_of_type_ArrayOfLkv.length)
    {
      this.jdField_a_of_type_ArrayOfLkv[n] = new lkv();
      this.jdField_a_of_type_ArrayOfLkv[n].jdField_b_of_type_Int = (n * 37 + 30);
      this.jdField_a_of_type_ArrayOfLkv[n].jdField_c_of_type_Int = 30;
      this.jdField_a_of_type_ArrayOfLkv[n].d = 37;
      this.jdField_a_of_type_ArrayOfLkv[n].e = 46;
      this.jdField_a_of_type_ArrayOfLkv[n].a(255);
      n += 1;
    }
    this.jdField_a_of_type_Lkv.jdField_c_of_type_Int = 36;
    this.jdField_a_of_type_Lkv.d = 200;
    this.jdField_a_of_type_Lkv.e = 28;
    this.jdField_a_of_type_Lkv.a(255);
    this.jdField_b_of_type_Lkv.jdField_c_of_type_Int = 36;
    this.jdField_b_of_type_Lkv.d = 200;
    this.jdField_b_of_type_Lkv.e = 28;
    this.jdField_b_of_type_Lkv.a(255);
    this.jdField_c_of_type_Lkv.jdField_c_of_type_Int = 36;
    this.jdField_c_of_type_Lkv.d = 200;
    this.jdField_c_of_type_Lkv.e = 28;
    this.jdField_c_of_type_Lkv.a(255);
    paramRedPacketGameView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.getContext();
    paramAVActivity = new View(paramRedPacketGameView);
    paramAVActivity.setId(2131306745);
    paramAVActivity.setOnClickListener(this);
    paramAVActivity.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.addView(paramAVActivity, localLayoutParams);
    paramRedPacketGameView = new View(paramRedPacketGameView);
    paramRedPacketGameView.setId(2131306746);
    paramRedPacketGameView.setOnClickListener(this);
    paramRedPacketGameView.setVisibility(8);
    paramAVActivity = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.addView(paramRedPacketGameView, paramAVActivity);
  }
  
  private void d()
  {
    e();
  }
  
  private void e()
  {
    View localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306745);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = ((int)(this.j + this.g + this.jdField_b_of_type_Float));
    localLayoutParams.leftMargin = ((int)(this.k + this.jdField_a_of_type_Float));
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306746);
    localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = ((int)(this.l + this.g + this.jdField_b_of_type_Float));
    localLayoutParams.leftMargin = ((int)(this.m + this.jdField_a_of_type_Float));
    localView.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = 520;
      if (!this.jdField_b_of_type_Boolean) {
        break label106;
      }
    }
    label106:
    for (int i1 = 348;; i1 = 276)
    {
      this.jdField_a_of_type_Lkv.jdField_b_of_type_Int = n;
      this.jdField_b_of_type_Lkv.jdField_b_of_type_Int = n;
      this.jdField_c_of_type_Lkv.jdField_b_of_type_Int = n;
      this.jdField_a_of_type_Lkv.b(this.h, this.i, 0, 0);
      this.jdField_b_of_type_Lkv.b(this.h, this.i, 0, 0);
      this.d = (this.h * i1 / 750);
      a();
      return;
      n = 448;
      break;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Lkv.a();
    int i1 = this.e * this.jdField_b_of_type_Int / this.jdField_c_of_type_Int + this.d;
    int n = ((Rect)localObject).width() + i1;
    this.jdField_c_of_type_Lkv.a(i1, ((Rect)localObject).top, n, ((Rect)localObject).bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    i1 = ((Rect)localObject).height() / 2 - this.f;
    localObject = new RectF(((Rect)localObject).left + i1, ((Rect)localObject).top + i1, n - i1, ((Rect)localObject).bottom - i1);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect((RectF)localObject, this.f, this.f, Path.Direction.CCW);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      int n = 1000;
      int i2 = 0;
      int i1 = paramInt;
      paramInt = i2;
      while (paramInt < this.jdField_a_of_type_ArrayOfLkv.length)
      {
        i2 = i1 / n;
        if (this.jdField_a_of_type_ArrayOfLla != null) {
          this.jdField_a_of_type_ArrayOfLkv[paramInt].a = this.jdField_a_of_type_ArrayOfLla[i2];
        }
        i1 %= n;
        n /= 10;
        paramInt += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    int n = 0;
    while (n < this.jdField_a_of_type_ArrayOfLkv.length)
    {
      this.jdField_a_of_type_ArrayOfLkv[n].b(paramInt1, paramInt2, paramInt3, paramInt4);
      n += 1;
    }
    this.h = paramInt1;
    this.i = paramInt2;
    this.e = (paramInt1 * 172 / 750);
    this.f = (paramInt1 * 10 / 750);
    f();
    paramInt2 = i1;
    while (paramInt2 < jdField_a_of_type_ArrayOfFloat.length)
    {
      this.jdField_b_of_type_ArrayOfFloat[paramInt2] = (jdField_a_of_type_ArrayOfFloat[paramInt2] * paramInt1 / 750.0F);
      paramInt2 += 1;
    }
    this.j = (paramInt1 * 24 / 750);
    this.k = (paramInt1 * 668 / 750);
    this.l = (paramInt1 * 24 / 750);
    this.m = (paramInt1 * 468 / 750);
    c();
  }
  
  public void a(long paramLong)
  {
    boolean bool2 = false;
    paramLong -= this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    int n = 0;
    float f1;
    float f2;
    Object localObject;
    label311:
    label322:
    boolean bool3;
    label412:
    boolean bool1;
    label445:
    label489:
    int i2;
    if (n < 8)
    {
      if ((paramLong >= n * 25) && (paramLong < (n + 1) * 25))
      {
        this.jdField_a_of_type_Float = ((this.jdField_b_of_type_ArrayOfFloat[((n * 2 + 2) % 8)] - this.jdField_b_of_type_ArrayOfFloat[(n * 2 % 8)]) * (float)paramLong / 25.0F + (this.jdField_b_of_type_ArrayOfFloat[(n * 2 % 8)] * (n + 1) - this.jdField_b_of_type_ArrayOfFloat[((n * 2 + 2) % 8)] * n));
        f1 = this.jdField_b_of_type_ArrayOfFloat[((n * 2 + 3) % 8)];
        f2 = this.jdField_b_of_type_ArrayOfFloat[((n * 2 + 1) % 8)];
        f1 = (float)paramLong * (f1 - f2) / 25.0F;
        f2 = this.jdField_b_of_type_ArrayOfFloat[((n * 2 + 1) % 8)];
        float f3 = n + 1;
        float f4 = this.jdField_b_of_type_ArrayOfFloat[((n * 2 + 3) % 8)];
        this.jdField_b_of_type_Float = (f2 * f3 - n * f4 + f1);
      }
    }
    else
    {
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (((AVActivity)localObject).a != null))
      {
        localObject = ((AVActivity)localObject).a.a();
        if (localObject != null)
        {
          ((GLRootView)localObject).setX(this.jdField_a_of_type_Float);
          ((GLRootView)localObject).setY(this.jdField_b_of_type_Float);
        }
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        e();
        paramLong = this.jdField_b_of_type_Long;
        if (!this.jdField_a_of_type_Boolean) {
          break label594;
        }
        f1 = 1.0F;
        if (Float.compare(f1, 0.0F) >= 0) {
          break label599;
        }
        f2 = 0.0F;
        n = (int)(255.0F * f2) & 0xFF;
        this.jdField_a_of_type_Lkv.a(n);
        this.jdField_b_of_type_Lkv.a(n);
        this.jdField_c_of_type_Lkv.a(n);
        localObject = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306745);
        if (Float.compare(f2, ((View)localObject).getAlpha()) != 0) {
          ((View)localObject).setAlpha(f2);
        }
        i1 = ((View)localObject).getVisibility();
        if (Float.compare(f2, 0.0F) <= 0) {
          break label616;
        }
        n = 0;
        if (n != i1) {
          ((View)localObject).setVisibility(n);
        }
        bool3 = ((View)localObject).isClickable();
        if (Float.compare(f2, 1.0F) < 0) {
          break label623;
        }
        bool1 = true;
        if (bool1 != bool3) {
          ((View)localObject).setClickable(bool1);
        }
        localObject = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306746);
        i1 = (int)((1.0F - f2) * 10000.0F);
        if (i1 >= 0) {
          break label629;
        }
        n = 0;
        Drawable localDrawable = ((View)localObject).getBackground();
        if ((localDrawable != null) && (n != localDrawable.getLevel())) {
          localDrawable.setLevel(n);
        }
        i2 = ((View)localObject).getVisibility();
        if (n <= 0) {
          break label649;
        }
      }
    }
    label649:
    for (int i1 = 0;; i1 = 8)
    {
      if (i1 != i2) {
        ((View)localObject).setVisibility(i1);
      }
      bool3 = ((View)localObject).isClickable();
      bool1 = bool2;
      if (n >= 10000) {
        bool1 = true;
      }
      if (bool1 != bool3) {
        ((View)localObject).setClickable(bool1);
      }
      return;
      n += 1;
      break;
      label594:
      f1 = 0.0F;
      break label311;
      label599:
      f2 = f1;
      if (Float.compare(f1, 1.0F) <= 0) {
        break label322;
      }
      f2 = 1.0F;
      break label322;
      label616:
      n = 8;
      break label412;
      label623:
      bool1 = false;
      break label445;
      label629:
      n = i1;
      if (i1 <= 10000) {
        break label489;
      }
      n = 10000;
      break label489;
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float + this.g);
    int n = 0;
    while (n < this.jdField_a_of_type_ArrayOfLkv.length)
    {
      this.jdField_a_of_type_ArrayOfLkv[n].a(paramCanvas, paramPaint);
      n += 1;
    }
    this.jdField_a_of_type_Lkv.a(paramCanvas, paramPaint);
    paramCanvas.save();
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    this.jdField_b_of_type_Lkv.a(paramCanvas, paramPaint);
    this.jdField_c_of_type_Lkv.a(paramCanvas, paramPaint);
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager, lla[] paramArrayOflla)
  {
    this.jdField_a_of_type_Lkv.a = new lla(paramAVRedPacketManager.a("qav_redpacket_progressbar_bg.png"));
    this.jdField_b_of_type_Lkv.a = new lla(paramAVRedPacketManager.a("qav_redpacket_progressbar_red.png"));
    this.jdField_c_of_type_Lkv.a = new lla(paramAVRedPacketManager.a("qav_redpacket_progressbar_yellow.png"));
    this.jdField_a_of_type_ArrayOfLla = paramArrayOflla;
    int n = 0;
    while (n < this.jdField_a_of_type_ArrayOfLkv.length)
    {
      this.jdField_a_of_type_ArrayOfLkv[n].a = this.jdField_a_of_type_ArrayOfLla[0];
      n += 1;
    }
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    a(paramLocalFrameSyncInfo.curScore);
    if ((paramLocalFrameSyncInfo.localEmojiInfos.size() > 0) && (paramBoolean)) {
      b(((AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0)).emojiId + 1);
    }
    for (;;)
    {
      if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 3) {
        this.jdField_a_of_type_Long = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
      }
      return;
      if (!paramBoolean) {
        b(paramLocalFrameSyncInfo.localHitInfo.emojiId + 1);
      }
    }
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    View localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306745);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramAVRedPacketManager.a("qav_redpacket_close.png");
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramAVRedPacketManager.a("qav_redpacket_close_normal.png");
      this.jdField_c_of_type_AndroidGraphicsBitmap = paramAVRedPacketManager.a("qav_redpacket_close_pressed.png");
      paramAVRedPacketManager = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.getResources();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        localView.setBackgroundDrawable(mit.a(paramAVRedPacketManager, this.jdField_a_of_type_AndroidGraphicsBitmap, 2131100329));
      }
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_c_of_type_AndroidGraphicsBitmap != null))
      {
        localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306746);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramAVRedPacketManager, this.jdField_c_of_type_AndroidGraphicsBitmap);
        localStateListDrawable.addState(new int[] { 16842919 }, localBitmapDrawable);
        paramAVRedPacketManager = new BitmapDrawable(paramAVRedPacketManager, this.jdField_b_of_type_AndroidGraphicsBitmap);
        localStateListDrawable.addState(new int[] { -16842919 }, paramAVRedPacketManager);
        localView.setBackgroundDrawable(new ClipDrawable(localStateListDrawable, 5, 1));
      }
    }
    f();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Lkv.b();
    this.jdField_b_of_type_Lkv.b();
    this.jdField_c_of_type_Lkv.b();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.removeAllViews();
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && (((AVActivity)localObject).a != null))
    {
      localObject = ((AVActivity)localObject).a.a();
      if (localObject != null)
      {
        ((GLRootView)localObject).setX(0.0F);
        ((GLRootView)localObject).setY(0.0F);
      }
    }
    this.jdField_a_of_type_ArrayOfLla = null;
    this.jdField_a_of_type_ArrayOfLkv = null;
    this.jdField_a_of_type_Lkv = null;
    this.jdField_b_of_type_Lkv = null;
    this.jdField_c_of_type_Lkv = null;
    this.jdField_a_of_type_AndroidGraphicsPath = null;
    this.jdField_b_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView = null;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      a();
    }
  }
  
  public void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306745).getLayoutParams();
    localLayoutParams.width = (this.h * 52 / 750);
    localLayoutParams.height = (this.h * 52 / 750);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131306746).getLayoutParams();
    localLayoutParams.width = (this.h * 252 / 750);
    localLayoutParams.height = (this.h * 72 / 750);
    e();
  }
  
  public void c(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_c_of_type_Int = paramInt;
      a();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131306745: 
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      mey.n();
      return;
    }
    ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).e();
    mey.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkz
 * JD-Core Version:    0.7.0.1
 */