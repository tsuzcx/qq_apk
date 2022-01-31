package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bbef;
import bcql;
import bfob;
import bizx;
import bjsu;
import bjxl;
import bjxn;
import bjyv;
import bkaw;
import bkfo;
import bkld;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import ved;
import vxv;
import vzu;

public class EditPicRawImage
  extends bjxl
  implements Handler.Callback, View.OnLayoutChangeListener, View.OnTouchListener, Runnable
{
  public static int a;
  private long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bfob jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public EditPicRawImage(@NonNull bjxn parambjxn, long paramLong)
  {
    super(parambjxn);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int j = 1;
    int i = paramInt2;
    if (m > k * 6) {
      i = paramInt2 * 3;
    }
    paramInt2 = paramInt1;
    if (k > m * 6) {
      paramInt2 = paramInt1 * 3;
    }
    if ((m > i * 1.2F) || (k > paramInt2 * 1.2F))
    {
      m /= 2;
      k /= 2;
      paramInt1 = 2;
      for (;;)
      {
        if (m / paramInt1 <= i)
        {
          j = paramInt1;
          if (k / paramInt1 <= paramInt2) {
            break;
          }
        }
        paramInt1 *= 2;
      }
    }
    return j;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    super.a();
    bizx.a().a(-1L);
    ThreadManager.post(this, 8, null, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131374709));
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.addOnLayoutChangeListener(this);
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    parambkld.a.jdField_a_of_type_Boolean = this.b;
    parambkld.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    Object localObject;
    if ((!this.b) && (!bjxn.a(this.jdField_a_of_type_Long, 68719476736L)) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_Bjxn.jdField_a_of_type_Int == 0))
    {
      this.b = true;
      if (vzu.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j))
      {
        localObject = bbef.a(a(), this.jdField_a_of_type_AndroidGraphicsBitmap, 0.25F, 20.0F);
        if (localObject != null)
        {
          Canvas localCanvas = new Canvas();
          if (!((Bitmap)localObject).isMutable()) {
            break label289;
          }
          paramBitmap = (Bitmap)localObject;
          localCanvas.setBitmap(paramBitmap);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramBitmap = vzu.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j);
          this.jdField_a_of_type_AndroidGraphicsBitmap = vxv.a(vxv.a((Bitmap)localObject, ((Integer)paramBitmap.first).intValue(), ((Integer)paramBitmap.second).intValue(), true), this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.destroyDrawingCache();
      this.jdField_a_of_type_AndroidWidgetImageView.refreshDrawableState();
      this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      c();
    }
    label289:
    do
    {
      do
      {
        return;
        paramBitmap = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
        break;
        paramBitmap = (bjsu)a(bjsu.class);
      } while (paramBitmap == null);
      localObject = (bkfo)paramBitmap.a().a().a(104);
    } while (localObject == null);
    ((bkfo)localObject).e();
    ((bkfo)localObject).b();
    paramBitmap.a().v();
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (paramInt == 11)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject2 = this.jdField_a_of_type_Bjyv.getActivity().getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject2).widthPixels;
    int i = ((DisplayMetrics)localObject2).heightPixels;
    if (QLog.isColorLevel()) {
      QLog.i("EditPicActivity.EditVideoRawImage", 2, "resizeDoodleView,imgH:" + i + " currentModelHeight:" + jdField_a_of_type_Int);
    }
    if (jdField_a_of_type_Int != 0) {
      i = jdField_a_of_type_Int;
    }
    int k = ((Bitmap)localObject1).getWidth();
    int m = ((Bitmap)localObject1).getHeight();
    float f1 = i / j;
    float f2;
    float f3;
    if (m / k > f1)
    {
      f2 = i;
      f1 = i / m;
      f3 = k * f1 + 0.5F;
    }
    for (;;)
    {
      localObject1 = new RectF(0.0F, 0.0F, f3, f2);
      ved.c("EditPicActivity.EditVideoRawImage", "getDisplayBounds " + localObject1 + " scale " + f1 + " old scale " + f4);
      localObject2 = (bjsu)a(bjsu.class);
      if (localObject2 == null) {
        break;
      }
      try
      {
        ((bjsu)localObject2).a((int)((RectF)localObject1).width(), (int)((RectF)localObject1).height(), false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      f3 = j;
      f1 = j / k;
      f2 = m * f1 + 0.5F;
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Bfob.removeMessages(999);
    jdField_a_of_type_Int = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if ((this.jdField_a_of_type_Bjyv == null) || (this.jdField_a_of_type_Bjyv.getActivity() == null) || (this.jdField_a_of_type_Bjyv.getActivity().isFinishing()))
    {
      paramMessage = "handleMessage isFinishing" + paramMessage.what + " mUi is null, ";
      if (this.jdField_a_of_type_Bjyv == null)
      {
        bool = true;
        QLog.e("EditPicActivity.EditVideoRawImage", 1, new Object[] { paramMessage, Boolean.valueOf(bool) });
      }
    }
    do
    {
      do
      {
        return false;
        bool = false;
        break;
        if (paramMessage.what == 998)
        {
          bcql.a(this.jdField_a_of_type_Bjyv.getActivity().getApplicationContext(), this.jdField_a_of_type_Bjyv.getActivity().getResources().getString(2131720350), 0).a();
          this.jdField_a_of_type_Bjyv.a(0, null, 2130772028, 0);
          return false;
        }
      } while (paramMessage.what != 999);
      paramMessage = (Bitmap)paramMessage.obj;
      if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 8)) {
        a(paramMessage, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjxn.z();
        if ((!(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) || (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) || (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)) {
          break;
        }
        this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 2, 536870912, 0));
        return false;
        a(paramMessage, false);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 2, 4, 0));
    return false;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditPicActivity.EditVideoRawImage", 2, "onLayoutChange, height pixel change,bottom:" + paramInt4 + " oldBottom:" + paramInt8 + " top:" + paramInt2 + " oldTop:" + paramInt6);
    }
    if ((paramInt8 != paramInt4) && (jdField_a_of_type_Int == 0) && (paramInt4 > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.removeOnLayoutChangeListener(this);
      jdField_a_of_type_Int = paramInt4 - paramInt2;
      c();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bbef.a((String)localObject2, localOptions);
    if ((localOptions.outWidth < 64) || (localOptions.outHeight < 64))
    {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
      this.jdField_a_of_type_Bfob.sendEmptyMessage(998);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Bjyv.getActivity().getResources().getDisplayMetrics();
    int i = a(localOptions, ((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = i;
    try
    {
      localObject1 = bbef.a((String)localObject2, localOptions);
      if (localObject1 == null)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + null);
        this.jdField_a_of_type_Bjyv.a(0, null, 2130772028, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Bitmap localBitmap3;
      for (;;)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + localOptions.inSampleSize);
        localOptions.inSampleSize = (i * 2);
        try
        {
          Bitmap localBitmap1 = bbef.a((String)localObject2, localOptions);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + localOptions.inSampleSize);
          localOptions.inSampleSize = (i * 4);
          try
          {
            Bitmap localBitmap2 = bbef.a((String)localObject2, localOptions);
          }
          catch (OutOfMemoryError localOutOfMemoryError3)
          {
            QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom again" + localOptions.inSampleSize);
            localBitmap3 = null;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditVideoRawImage", 2, "sampleSize" + i + " w " + localBitmap3.getWidth() + " h " + localBitmap3.getHeight());
      }
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c = localBitmap3.getWidth();
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d = localBitmap3.getHeight();
      i = bbef.b((String)localObject2);
      localObject2 = localBitmap3;
      if (i != 0)
      {
        localObject2 = localBitmap3;
        if (i % 90 == 0)
        {
          this.jdField_a_of_type_Bjxn.b = i;
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditVideoRawImage", 2, "has exif rotate" + i);
          }
          int j = localBitmap3.getWidth();
          int k = localBitmap3.getHeight();
          localObject2 = new Matrix();
          ((Matrix)localObject2).postRotate(i, j / 2.0F, k / 2.0F);
          localObject2 = Bitmap.createBitmap(localBitmap3, 0, 0, j, k, (Matrix)localObject2, true);
        }
      }
      this.jdField_a_of_type_Bfob.obtainMessage(999, localObject2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */