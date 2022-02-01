package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;

public class EmotionAdapter
  extends BaseAdapter
  implements URLDrawableDownListener
{
  protected Context a;
  protected Handler a;
  protected EmoticonPreviewData a;
  public List<EmoticonPreviewData> a;
  
  public EmotionAdapter(Context paramContext, Handler paramHandler, EmoticonPreviewData paramEmoticonPreviewData)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData = paramEmoticonPreviewData;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public int a(EmoticonPreviewData paramEmoticonPreviewData)
  {
    return paramEmoticonPreviewData.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public EmoticonPreviewData a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (EmoticonPreviewData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData;
  }
  
  public Long a(int paramInt)
  {
    return Long.valueOf(a(paramInt).a());
  }
  
  public List<EmoticonPreviewData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<EmoticonPreviewData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 1;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null) {
      localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    }
    paramView = new StringBuilder();
    paramView.append("getView position:");
    paramView.append(paramInt);
    com.tencent.qphone.base.util.QLog.d("EmotionAdapter", 1, paramView.toString());
    paramView = this.jdField_a_of_type_JavaUtilList;
    if ((paramView != null) && (!paramView.isEmpty())) {
      paramView = (EmoticonPreviewData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } else {
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData;
    }
    Drawable localDrawable = paramView.a(this.jdField_a_of_type_AndroidContentContext);
    if ((!paramView.a()) && (paramView.b())) {
      ((URLImageView)localObject).setURLDrawableDownListener(this);
    } else {
      ((URLImageView)localObject).setURLDrawableDownListener(null);
    }
    if ((localDrawable instanceof PngFrameDrawable))
    {
      paramView = (PngFrameDrawable)localDrawable;
      if (paramView.a() != null)
      {
        int i = AIOUtils.b(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView = a(paramView.a(), i, i);
        ((ImageView)localObject).setImageBitmap(paramView);
        break label205;
      }
    }
    ((ImageView)localObject).setImageDrawable(localDrawable);
    label205:
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001, paramInt, 0, localDrawable).sendToTarget();
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    int i;
    try
    {
      File localFile = paramURLDrawable.getFileInLocal();
      if (localFile != null) {
        i = ImageUtil.d(localFile.getAbsolutePath());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("EmotionAdapter", 0, "onLoadSuccessed,orientation");
    }
    AIOGalleryAdapter.a(paramView, paramURLDrawable, i);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001, -1, 1, paramURLDrawable).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionAdapter
 * JD-Core Version:    0.7.0.1
 */