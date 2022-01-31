package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.MosaicOperator;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditPicRawImage
  extends EditVideoPart
  implements Handler.Callback, View.OnTouchListener, Runnable
{
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  
  public EditPicRawImage(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int i = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (i > paramInt1))
    {
      k /= 2;
      int m = i / 2;
      i = 2;
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (m / i <= paramInt1) {
            break;
          }
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public RectF a(Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = j / i;
    float f2;
    float f3;
    if (m / k > f1)
    {
      f2 = j;
      f1 = j / m;
      f3 = k * f1 + 0.5F;
    }
    for (;;)
    {
      paramBitmap = new RectF(0.0F, 0.0F, f3, f2);
      SLog.c("EditPicActivity.EditVideoRawImage", "getDisplayBounds " + paramBitmap + " scale " + f1 + " old scale " + f4);
      return paramBitmap;
      f3 = i;
      f1 = i / k;
      f2 = m * f1 + 0.5F;
    }
  }
  
  public void a()
  {
    super.a();
    ThreadManager.post(this, 8, null, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364374));
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    paramGenerateContext.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.destroyDrawingCache();
      this.jdField_a_of_type_AndroidWidgetImageView.refreshDrawableState();
      this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    }
    EditDoodleExport localEditDoodleExport;
    if (!paramBoolean)
    {
      paramBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      localEditDoodleExport = (EditDoodleExport)a(EditDoodleExport.class);
      if (localEditDoodleExport == null) {}
    }
    for (;;)
    {
      try
      {
        localEditDoodleExport.a((int)paramBitmap.width(), (int)paramBitmap.height(), false);
        return;
      }
      catch (Exception paramBitmap) {}
      paramBitmap = (EditDoodleExport)a(EditDoodleExport.class);
      if (paramBitmap != null)
      {
        paramBitmap = (MosaicOperator)paramBitmap.a().a().a(104);
        if (paramBitmap != null)
        {
          paramBitmap.e();
          paramBitmap.b();
          return;
        }
      }
    }
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
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(999);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().isFinishing()) {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "handleMessage isFinishing" + paramMessage.what);
    }
    do
    {
      do
      {
        return false;
        if (paramMessage.what == 998)
        {
          QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getApplicationContext(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getString(2131438745), 0).a();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
          return false;
        }
      } while (paramMessage.what != 999);
      paramMessage = (Bitmap)paramMessage.obj;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.b() == 8)) {
        a(paramMessage, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.x();
        if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() == 1)) {
          break;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 2, 32, 0));
        return false;
        a(paramMessage, false);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 2, 64, 0));
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject1);
    if ((((BitmapFactory.Options)localObject1).outWidth < 64) || (((BitmapFactory.Options)localObject1).outHeight < 64))
    {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(998);
      return;
    }
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int i = a((BitmapFactory.Options)localObject1, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inSampleSize = i;
    try
    {
      localObject1 = ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject1);
      if (localObject1 == null)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + null);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decodeoom");
        localBitmap = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditVideoRawImage", 2, "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.c = localBitmap.getWidth();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d = localBitmap.getHeight();
      i = ImageUtil.a((String)localObject2);
      localObject2 = localBitmap;
      if (i != 0)
      {
        localObject2 = localBitmap;
        if (i % 90 == 0)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c = i;
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditVideoRawImage", 2, "has exif rotate" + i);
          }
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          localObject2 = new Matrix();
          ((Matrix)localObject2).postRotate(360 - i, j / 2.0F, k / 2.0F);
          localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, j, k, (Matrix)localObject2, true);
        }
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(999, localObject2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */