package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import anqz;
import anra;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.util.gifCoderWnsConfig;
import cooperation.qzone.widget.FastAnimationDrawable;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class EditGifImage
  extends EditVideoPart
  implements Handler.Callback, View.OnTouchListener, Runnable
{
  public static final int a;
  float jdField_a_of_type_Float;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public URLImageView a;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public FastAnimationDrawable a;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  public FastAnimationDrawable b;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  public boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g;
  boolean h;
  boolean i;
  
  static
  {
    jdField_a_of_type_Int = gifCoderWnsConfig.e;
  }
  
  public EditGifImage(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = paramOptions.outHeight;
    int n = paramOptions.outWidth;
    int k = 1;
    if ((m > paramInt2) || (n > paramInt1))
    {
      int j = 2;
      for (;;)
      {
        if (m / j <= paramInt2)
        {
          k = j;
          if (n / j <= paramInt1) {
            break;
          }
        }
        j *= 2;
      }
    }
    return k;
  }
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_name", paramString1);
    localHashMap.put("module_status", paramString2);
    if ((this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) && (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a != null)) {
      localHashMap.put("module_frameNum", this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a.size() + "");
    }
    localHashMap.put("module_exposeStatus", this.i + "");
    localHashMap.put("module_showStatus", this.g + "");
    localHashMap.put("module_resetStatus", this.h + "");
    try
    {
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "GifAntishakeModule", true, 0L, 0L, localHashMap, null);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EditPicActivity.EditGifImage", 1, "reportToBeacon failed " + paramString1.getMessage());
    }
  }
  
  private void c()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.d))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mPlayGifImage = true;
        localEditLocalGifSource.jdField_a_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new anqz(this));
    }
  }
  
  private void j()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.d))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mPlayGifImage = true;
        localEditLocalGifSource.jdField_a_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new anra(this));
    }
  }
  
  public RectF a(Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject).widthPixels;
    int k = ((DisplayMetrics)localObject).heightPixels;
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    float f1 = k / j;
    float f2;
    float f3;
    if (n / m > f1)
    {
      f2 = k;
      f1 = k / n;
      f3 = m * f1 + 0.5F;
    }
    for (;;)
    {
      paramBitmap = new RectF(0.0F, 0.0F, f3, f2);
      SLog.c("EditPicActivity.EditGifImage", "getDisplayBounds " + paramBitmap + " scale " + f1 + " old scale " + f4);
      return paramBitmap;
      f3 = j;
      f1 = j / m;
      f2 = n * f1 + 0.5F;
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)a(2131364409));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ThreadManager.post(this, 8, null, false);
  }
  
  public void a(@NonNull GenerateContext paramGenerateContext)
  {
    paramGenerateContext.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    a("PublishBtn", this.d + "");
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
    }
  }
  
  public void aB_()
  {
    super.aB_();
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (paramInt == 11)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  public void ax_()
  {
    super.ax_();
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    }
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditGifImage", 2, "EditGifImage onDestroy");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(999);
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = null;
    }
    if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().isFinishing()) {
      QLog.e("EditPicActivity.EditGifImage", 1, "handleMessage isFinishing" + paramMessage.what);
    }
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            return false;
            if (paramMessage.what == 998)
            {
              QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getApplicationContext(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getString(2131438722), 0).a();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
              return false;
            }
            if (paramMessage.what != 999) {
              break;
            }
            AbstractGifImage.resumeAll();
            paramMessage = a((Bitmap)paramMessage.obj);
            localObject = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramMessage.bottom);
            ((ViewGroup.LayoutParams)localObject).width = ((int)paramMessage.right);
            this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
            {
              this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
              this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
            }
            localObject = (EditDoodleExport)a(EditDoodleExport.class);
          } while (localObject == null);
          ((EditDoodleExport)localObject).a((int)paramMessage.width(), (int)paramMessage.height(), false);
          return false;
          if (paramMessage.what != 995) {
            break;
          }
          this.e = false;
          j();
        } while (this.h);
        a("AutoOptimizationBtn", "resetAntishake");
        this.h = true;
        return false;
        if (paramMessage.what != 994) {
          break;
        }
        this.e = true;
        c();
      } while (this.g);
      a("AutoOptimizationBtn", "showAntishake");
      this.g = true;
      return false;
      if (paramMessage.what == 997)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a(false, false);
        return false;
      }
    } while (paramMessage.what != 996);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a(true, false);
    a("AutoOptimizationBtn", "exposeAntishake");
    this.i = true;
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.jdField_b_of_type_Float) < 10.0F)) {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b != 21)
        {
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(5);
            VideoEditReport.b("0X80075D7");
          }
          else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b == 0)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(27);
          }
          else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b == 27)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
          }
        }
        else {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        }
      }
    }
  }
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outWidth < jdField_a_of_type_Int) || (((BitmapFactory.Options)localObject2).outHeight < jdField_a_of_type_Int))
      {
        QLog.e("EditPicActivity.EditGifImage", 1, "bitmapPath:" + (String)localObject1 + " too small width:" + ((BitmapFactory.Options)localObject2).outWidth + " height:" + ((BitmapFactory.Options)localObject2).outHeight);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(998);
        return;
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) && (((EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList != null) && (((EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          this.jdField_a_of_type_Boolean = true;
          localObject1 = (String)((EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList.get(0);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
        }
      }
      else
      {
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
        int j = a((BitmapFactory.Options)localObject2, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = j;
        try
        {
          localObject2 = ImageUtil.a((String)localObject1, (BitmapFactory.Options)localObject2);
          if (localObject2 == null)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decode" + null);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Bitmap localBitmap;
          for (;;)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decodeoom");
            localBitmap = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditGifImage", 2, "sampleSize" + j + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
          }
          j = ImageUtil.a((String)localObject1);
          localObject1 = localBitmap;
          if (j != 0)
          {
            localObject1 = localBitmap;
            if (j % 90 == 0)
            {
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c = j;
              if (QLog.isColorLevel()) {
                QLog.d("EditPicActivity.EditGifImage", 2, "has exif rotate" + j);
              }
              int k = localBitmap.getWidth();
              int m = localBitmap.getHeight();
              localObject1 = new Matrix();
              ((Matrix)localObject1).postRotate(j, k / 2.0F, m / 2.0F);
              localObject1 = Bitmap.createBitmap(localBitmap, 0, 0, k, m, (Matrix)localObject1, true);
            }
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(999, localObject1).sendToTarget();
          return;
        }
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditGifImage
 * JD-Core Version:    0.7.0.1
 */