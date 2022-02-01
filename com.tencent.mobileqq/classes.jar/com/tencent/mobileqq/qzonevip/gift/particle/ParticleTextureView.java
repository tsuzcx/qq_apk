package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import bazv;
import bazw;
import bazx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

public abstract class ParticleTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  protected int a;
  protected Context a;
  protected Matrix a;
  protected Paint a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  protected Handler a;
  protected HandlerThread a;
  private Surface jdField_a_of_type_AndroidViewSurface;
  protected bazw a;
  public final Object a;
  public ArrayList<bazv> a;
  protected Random a;
  public volatile boolean a;
  protected int b;
  public int c;
  
  public ParticleTextureView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangObject = new Object();
    a(paramContext);
  }
  
  public ParticleTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangObject = new Object();
    a(paramContext);
  }
  
  public ParticleTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangObject = new Object();
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      QLog.i("ParticleTextureView", 1, "sendValidMessage: handle = null ");
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(paramInt1)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    setOpaque(false);
    setSurfaceTextureListener(this);
  }
  
  protected float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat1 + this.jdField_a_of_type_JavaUtilRandom.nextFloat() * (paramFloat2 - paramFloat1);
  }
  
  protected abstract int a();
  
  protected int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt1;
    }
    return paramInt1 + this.jdField_a_of_type_JavaUtilRandom.nextInt(paramInt2 - paramInt1);
  }
  
  public abstract void a();
  
  public abstract void a(Bitmap[] paramArrayOfBitmap);
  
  public abstract boolean a();
  
  public abstract Bitmap[] a();
  
  public void b()
  {
    a(1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    bazv localbazv2 = null;
    Canvas localCanvas = null;
    Object localObject6 = this.jdField_a_of_type_JavaLangObject;
    Object localObject4 = localCanvas;
    bazv localbazv1 = localbazv2;
    try
    {
      Surface localSurface = this.jdField_a_of_type_AndroidViewSurface;
      if (localSurface == null) {
        try
        {
          if (this.jdField_a_of_type_AndroidViewSurface != null) {
            this.jdField_a_of_type_AndroidViewSurface.unlockCanvasAndPost(null);
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable1);
          }
        }
        finally {}
      }
      localObject4 = localCanvas;
      Object localObject2 = localbazv2;
      localCanvas = this.jdField_a_of_type_AndroidViewSurface.lockCanvas(this.jdField_a_of_type_AndroidGraphicsRect);
      if (localCanvas != null)
      {
        localObject4 = localCanvas;
        localObject2 = localCanvas;
        if (this.jdField_a_of_type_AndroidViewSurface.isValid())
        {
          localObject4 = localCanvas;
          localObject2 = localCanvas;
          localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          localObject2 = localCanvas;
          try
          {
            localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            for (;;)
            {
              localObject2 = localCanvas;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject2 = localCanvas;
              localbazv2 = (bazv)((Iterator)localObject4).next();
              if (localbazv2 != null)
              {
                localObject2 = localCanvas;
                localbazv2.a(localCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsMatrix);
              }
            }
            try
            {
              if (this.jdField_a_of_type_AndroidViewSurface != null) {
                this.jdField_a_of_type_AndroidViewSurface.unlockCanvasAndPost(localCanvas);
              }
              QLog.i("ParticleTextureView", 1, "consume = " + (System.currentTimeMillis() - l));
              if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
              {
                a(3, a());
                return;
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable2);
              }
            }
          }
          catch (Throwable localThrowable6)
          {
            localObject4 = localCanvas;
            localObject2 = localCanvas;
            QLog.e("ParticleTextureView", 1, "onCanvasDraw draw has a exception e: " + localThrowable6);
          }
        }
      }
      Object localObject3;
      return;
    }
    catch (Throwable localThrowable5)
    {
      for (;;)
      {
        localObject3 = localObject4;
        QLog.e("ParticleTextureView", 1, "onCanvasDraw draw has a exception e: " + localThrowable5);
        try
        {
          if (this.jdField_a_of_type_AndroidViewSurface != null) {
            this.jdField_a_of_type_AndroidViewSurface.unlockCanvasAndPost((Canvas)localObject4);
          }
        }
        catch (Throwable localThrowable3)
        {
          QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable3);
        }
      }
    }
    finally
    {
      try
      {
        if (this.jdField_a_of_type_AndroidViewSurface != null) {
          this.jdField_a_of_type_AndroidViewSurface.unlockCanvasAndPost(localThrowable3);
        }
        throw localObject5;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable4);
        }
      }
      if (this.jdField_a_of_type_Bazw != null) {
        this.jdField_a_of_type_Bazw.a();
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("ParticleTextureView", 1, "onSurfaceTextureAvailable: width = " + paramInt1 + " height = " + paramInt2);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(paramSurfaceTexture);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Particle-Texture-Thread" + UUID.randomUUID());
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new bazx(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidViewSurface = null;
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setParticleListener(bazw parambazw)
  {
    this.jdField_a_of_type_Bazw = parambazw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
 * JD-Core Version:    0.7.0.1
 */