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
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.MosaicOperator;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditPicRawImage
  extends EditVideoPart
  implements Handler.Callback, View.OnLayoutChangeListener, Runnable
{
  public static int a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public EditPicRawImage(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_b_of_type_Int = paramInt;
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
    AEBaseReportParam.a().a(-1L);
    ThreadManager.post(this, 8, null, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376483));
    this.jdField_a_of_type_AndroidWidgetImageView.addOnLayoutChangeListener(this);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    paramGenerateContext.a.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    paramGenerateContext.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 7)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
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
    if ((!this.jdField_b_of_type_Boolean) && (!EditVideoPartManager.a(this.jdField_b_of_type_Int, 8192)) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_Int == 0))
    {
      this.jdField_b_of_type_Boolean = true;
      if (VideoUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j))
      {
        localObject = ImageUtil.a(a(), this.jdField_a_of_type_AndroidGraphicsBitmap, 0.25F, 20.0F);
        if (localObject != null)
        {
          Canvas localCanvas = new Canvas();
          if (!((Bitmap)localObject).isMutable()) {
            break label289;
          }
          paramBitmap = (Bitmap)localObject;
          localCanvas.setBitmap(paramBitmap);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramBitmap = VideoUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j);
          this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.a(BitmapUtils.a((Bitmap)localObject, ((Integer)paramBitmap.first).intValue(), ((Integer)paramBitmap.second).intValue(), true), this.jdField_a_of_type_AndroidGraphicsBitmap);
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
      b();
    }
    label289:
    do
    {
      do
      {
        return;
        paramBitmap = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
        break;
        paramBitmap = (EditDoodleExport)a(EditDoodleExport.class);
      } while (paramBitmap == null);
      localObject = (MosaicOperator)paramBitmap.a().a().a(104);
    } while (localObject == null);
    ((MosaicOperator)localObject).e();
    ((MosaicOperator)localObject).b();
    paramBitmap.a().r();
  }
  
  void b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject2).widthPixels;
    int i = ((DisplayMetrics)localObject2).heightPixels;
    if (jdField_a_of_type_Int != 0) {
      i = jdField_a_of_type_Int;
    }
    int k = LiuHaiUtils.a(a());
    i += k;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditVideoRawImage", 2, new Object[] { "resizeDoodleView, imgH:", Integer.valueOf(i), " currentModelHeight:", Integer.valueOf(jdField_a_of_type_Int), " statusBarHeight:", Integer.valueOf(k) });
    }
    k = ((Bitmap)localObject1).getWidth();
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
      SLog.c("EditPicActivity.EditVideoRawImage", "getDisplayBounds " + localObject1 + " scale " + f1 + " old scale " + f4);
      localObject2 = (EditDoodleExport)a(EditDoodleExport.class);
      if (localObject2 == null) {
        break;
      }
      try
      {
        ((EditDoodleExport)localObject2).a((int)((RectF)localObject1).width(), (int)((RectF)localObject1).height(), false);
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
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(999);
    jdField_a_of_type_Int = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().isFinishing()))
    {
      paramMessage = "handleMessage isFinishing" + paramMessage.what + " mUi is null, ";
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null)
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
          QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getApplicationContext(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getString(2131719989), 0).a();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2130772034, 0);
          return false;
        }
      } while (paramMessage.what != 999);
      a((Bitmap)paramMessage.obj, false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.x();
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() != 103))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 2, 1024, 0));
        return false;
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 2, 4, 0));
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
      b();
    }
  }
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    ImageUtil.a((String)localObject2, localOptions);
    if ((localOptions.outWidth < 64) || (localOptions.outHeight < 64))
    {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(998);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int i = a(localOptions, ((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = i;
    try
    {
      localObject1 = ImageUtil.a((String)localObject2, localOptions);
      if (localObject1 == null)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + null);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2130772034, 0);
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
          Bitmap localBitmap1 = ImageUtil.a((String)localObject2, localOptions);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + localOptions.inSampleSize);
          localOptions.inSampleSize = (i * 4);
          try
          {
            Bitmap localBitmap2 = ImageUtil.a((String)localObject2, localOptions);
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d = localBitmap3.getWidth();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e = localBitmap3.getHeight();
      i = ImageUtil.c((String)localObject2);
      localObject2 = localBitmap3;
      if (i != 0)
      {
        localObject2 = localBitmap3;
        if (i % 90 == 0)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int = i;
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
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(999, localObject2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */