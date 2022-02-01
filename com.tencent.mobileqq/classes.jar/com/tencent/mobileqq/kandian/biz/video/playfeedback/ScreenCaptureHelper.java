package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SavePicTask;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploader;
import com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper;", "", "()V", "handler", "Landroid/os/Handler;", "paint", "Landroid/graphics/Paint;", "captureActivity", "", "activity", "Landroid/app/Activity;", "containSurface", "", "callback", "Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper$CaptureViewCallback;", "scale", "", "captureAndUpload", "listener", "Lcom/tencent/mobileqq/kandian/biz/ugc/upload/IImageUploadListener;", "captureViewApiO", "view", "Landroid/view/View;", "captureViewLowApi", "combineTextureView", "Landroid/graphics/Bitmap;", "viewBitmap", "textureView", "Landroid/view/TextureView;", "getBitmapFromViewLowApi", "getBitmapFromViewLowApiContainSurface", "isInScreen", "mergeBitmap", "backBitmap", "frontBitmap", "frontRect", "Landroid/graphics/RectF;", "needCombine", "onResultBitmapCallback", "resultBitmap", "recycleBitmap", "bitmap", "saveBitmapAndUpload", "searchTextureView", "resultList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "searchTextureViewAndCombine", "uploadFile", "path", "", "CaptureViewCallback", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ScreenCaptureHelper
{
  @NotNull
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  public static final ScreenCaptureHelper.Companion a;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(4);
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackScreenCaptureHelper$Companion = new ScreenCaptureHelper.Companion(null);
  }
  
  private final Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, RectF paramRectF)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramBitmap1.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
    localCanvas.drawBitmap(paramBitmap2, null, paramRectF, null);
    a(paramBitmap1);
    a(paramBitmap2);
    return localBitmap;
  }
  
  private final Bitmap a(Bitmap paramBitmap, View paramView, TextureView paramTextureView, float paramFloat)
  {
    Bitmap localBitmap2 = paramTextureView.getBitmap((int)(paramTextureView.getWidth() * paramFloat), (int)(paramTextureView.getHeight() * paramFloat));
    Bitmap localBitmap1 = Bitmap.createBitmap((int)(paramView.getWidth() * paramFloat), (int)(paramView.getHeight() * paramFloat), jdField_a_of_type_AndroidGraphicsBitmap$Config);
    int[] arrayOfInt = new int[2];
    int[] tmp57_55 = arrayOfInt;
    tmp57_55[0] = 0;
    int[] tmp61_57 = tmp57_55;
    tmp61_57[1] = 0;
    tmp61_57;
    paramTextureView.getLocationOnScreen(arrayOfInt);
    paramView = localBitmap1;
    if (localBitmap2 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localBitmap1, "panelBitmap");
      paramView = a(localBitmap1, localBitmap2, new RectF(arrayOfInt[0] * paramFloat, arrayOfInt[1] * paramFloat, (arrayOfInt[0] + paramTextureView.getWidth()) * paramFloat, (arrayOfInt[1] + paramTextureView.getHeight()) * paramFloat));
    }
    Intrinsics.checkExpressionValueIsNotNull(paramView, "panelBitmap");
    paramBitmap = a(paramView, paramBitmap, new RectF(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight()));
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "panelBitmap");
    return paramBitmap;
  }
  
  private final Bitmap a(View paramView, float paramFloat)
  {
    paramView.setDrawingCacheEnabled(true);
    paramView.setDrawingCacheBackgroundColor(0);
    Bitmap localBitmap = paramView.getDrawingCache(true).copy(jdField_a_of_type_AndroidGraphicsBitmap$Config, true);
    localBitmap.setHasAlpha(true);
    paramView.setDrawingCacheEnabled(false);
    paramView.destroyDrawingCache();
    Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
    return a(paramView, localBitmap, paramFloat);
  }
  
  private final Bitmap a(View paramView, Bitmap paramBitmap, float paramFloat)
  {
    Object localObject = new ArrayList();
    a(paramView, (ArrayList)localObject);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TextureView localTextureView = (TextureView)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localTextureView, "textureView");
      if (a(localTextureView)) {
        paramBitmap = a(paramBitmap, paramView, localTextureView, paramFloat);
      }
    }
    return paramBitmap;
  }
  
  @RequiresApi(26)
  private final void a(Activity paramActivity, View paramView, float paramFloat, ScreenCaptureHelper.CaptureViewCallback paramCaptureViewCallback)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      Bitmap localBitmap = Bitmap.createBitmap((int)(paramView.getWidth() * paramFloat), (int)(paramView.getHeight() * paramFloat), jdField_a_of_type_AndroidGraphicsBitmap$Config);
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      try
      {
        PixelCopy.request(paramActivity, new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight()), localBitmap, (PixelCopy.OnPixelCopyFinishedListener)new ScreenCaptureHelper.captureViewApiO..inlined.let.lambda.1(localBitmap, this, paramView, paramFloat, paramCaptureViewCallback), this.jdField_a_of_type_AndroidOsHandler);
        return;
      }
      catch (IllegalArgumentException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  private final void a(Bitmap paramBitmap)
  {
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
  }
  
  private final void a(Bitmap paramBitmap, IImageUploadListener paramIImageUploadListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(URLDrawableHelper.diskCachePath.toString());
    ((StringBuilder)localObject1).append(File.separator);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("screen_capture");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(AbsDownloader.getFileName(((StringBuilder)localObject2).toString()));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new SavePicTask(paramBitmap, (String)localObject1);
    ((SavePicTask)localObject2).a((URLDrawable.DownloadListener)new ScreenCaptureHelper.saveBitmapAndUpload.1(this, (String)localObject1, paramIImageUploadListener, paramBitmap));
    ((SavePicTask)localObject2).a();
  }
  
  private final void a(Bitmap paramBitmap, ScreenCaptureHelper.CaptureViewCallback paramCaptureViewCallback)
  {
    if ((paramBitmap.isRecycled() ^ true))
    {
      if (paramCaptureViewCallback != null) {
        paramCaptureViewCallback.a(paramBitmap);
      }
    }
    else if (paramCaptureViewCallback != null) {
      paramCaptureViewCallback.a();
    }
  }
  
  private final void a(View paramView, ArrayList<TextureView> paramArrayList)
  {
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      while (i < j)
      {
        View localView = paramView.getChildAt(i);
        Intrinsics.checkExpressionValueIsNotNull(localView, "view.getChildAt(i)");
        a(localView, paramArrayList);
        i += 1;
      }
    }
    if ((paramView instanceof TextureView)) {
      paramArrayList.add(paramView);
    }
  }
  
  private final void a(View paramView, boolean paramBoolean, float paramFloat, ScreenCaptureHelper.CaptureViewCallback paramCaptureViewCallback)
  {
    ThreadManager.getFileThreadHandler().post((Runnable)new ScreenCaptureHelper.captureViewLowApi.1(this, paramView, paramFloat, paramCaptureViewCallback));
  }
  
  private final void a(String paramString, IImageUploadListener paramIImageUploadListener)
  {
    Context localContext = (Context)BaseApplicationImpl.getContext();
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime != null)
    {
      paramString = (IImageUploader)new RIJUgcImageUploader(localContext, (QQAppInterface)localAppRuntime, paramString);
      paramString.a(paramIImageUploadListener);
      paramString.a();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final boolean a(TextureView paramTextureView)
  {
    return b(paramTextureView);
  }
  
  private final boolean b(TextureView paramTextureView)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    paramTextureView.getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[0] >= 0)
    {
      if (arrayOfInt[0] > UIUtils.a((Context)BaseApplicationImpl.getContext())) {
        return false;
      }
      if (arrayOfInt[1] >= 0) {
        return arrayOfInt[1] <= UIUtils.d((Context)BaseApplicationImpl.getContext());
      }
    }
    return false;
  }
  
  public final void a(@NotNull Activity paramActivity, boolean paramBoolean, float paramFloat, @Nullable IImageUploadListener paramIImageUploadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    a(paramActivity, paramBoolean, paramFloat, (ScreenCaptureHelper.CaptureViewCallback)new ScreenCaptureHelper.captureAndUpload.1(this, paramIImageUploadListener));
  }
  
  public final void a(@NotNull Activity paramActivity, boolean paramBoolean, float paramFloat, @Nullable ScreenCaptureHelper.CaptureViewCallback paramCaptureViewCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    try
    {
      paramFloat = RangesKt.coerceAtMost(paramFloat, 1.0F);
      Object localObject = paramActivity.getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.window");
      localObject = ((Window)localObject).getDecorView();
      int i = Build.VERSION.SDK_INT;
      if (i >= 26)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "captureView");
        a(paramActivity, (View)localObject, paramFloat, paramCaptureViewCallback);
        return;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "captureView");
      a((View)localObject, paramBoolean, paramFloat, paramCaptureViewCallback);
      return;
    }
    catch (Throwable paramActivity)
    {
      if (paramCaptureViewCallback != null) {
        paramCaptureViewCallback.a();
      }
      QLog.e("ScreenCaptureHelper", 1, "captureActivity failed.", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper
 * JD-Core Version:    0.7.0.1
 */