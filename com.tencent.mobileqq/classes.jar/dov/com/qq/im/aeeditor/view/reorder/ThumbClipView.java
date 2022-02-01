package dov.com.qq.im.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bmot;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache.LRUKey;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/view/reorder/ThumbClipView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/weishi/module/edit/widget/playtrack/provider/VideoThumbListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mResourcePath", "", "mSelectedStart", "", "mUuid", "path", "Landroid/graphics/Path;", "radius", "getRadius", "()I", "radius$delegate", "Lkotlin/Lazy;", "thumb1", "Landroid/widget/ImageView;", "createObjTag", "uuid", "index", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onThumbGenerated", "tag", "", "startTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "setClipUrl", "selectedStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThumbClipView
  extends FrameLayout
  implements VideoThumbListener
{
  private long jdField_a_of_type_Long;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)ThumbClipView.radius.2.INSTANCE);
  private String b;
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131558552, (ViewGroup)this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378586));
  }
  
  private final int a()
  {
    return ((Number)this.jdField_a_of_type_KotlinLazy.getValue()).intValue();
  }
  
  private final String a(String paramString, int paramInt)
  {
    return paramString + '_' + paramInt;
  }
  
  protected void dispatchDraw(@Nullable Canvas paramCanvas)
  {
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    if ((localPath != null) && (paramCanvas != null)) {
      paramCanvas.clipPath(localPath);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    VideoThumbProviderManager.getInstance().registerListener((VideoThumbListener)this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoThumbProviderManager.getInstance().unRegisterListener((VideoThumbListener)this);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    if (localPath != null) {
      localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), a(), a(), Path.Direction.CW);
    }
  }
  
  public void onThumbGenerated(@Nullable Object paramObject, @Nullable CMTime paramCMTime, @Nullable Bitmap paramBitmap)
  {
    Iterator localIterator = ((Iterable)CollectionsKt.listOf(this.jdField_a_of_type_AndroidWidgetImageView)).iterator();
    if (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      if (paramBitmap != null)
      {
        if (localImageView != null) {}
        for (paramCMTime = localImageView.getTag();; paramCMTime = null)
        {
          if ((!Intrinsics.areEqual(paramObject, paramCMTime)) || (paramBitmap.isRecycled())) {
            break label97;
          }
          post((Runnable)new ThumbClipView.onThumbGenerated..inlined.forEach.lambda.1(localImageView, this, paramBitmap, paramObject));
          break;
        }
      }
      label97:
      VideoThumbProviderManager.getInstance().releaseBitmapCacheByKey(new BaseVideoThumbAssetCache.LRUKey(this.b, this.jdField_a_of_type_Long + 500L));
      paramCMTime = this.jdField_a_of_type_JavaLangString;
      if (paramCMTime != null) {}
      for (paramCMTime = a(paramCMTime, 0);; paramCMTime = null)
      {
        Bitmap localBitmap = VideoThumbProviderManager.getInstance().getBitmapByTime(this.jdField_a_of_type_Long + 500L, paramCMTime, this.b);
        if (localImageView != null) {
          localImageView.setTag(paramCMTime);
        }
        if (localImageView == null) {
          break;
        }
        paramCMTime = getResources();
        Intrinsics.checkExpressionValueIsNotNull(paramCMTime, "resources");
        localImageView.setImageDrawable((Drawable)new bmot(paramCMTime, localBitmap));
        break;
      }
    }
  }
  
  public final void setClipUrl(@NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uuid");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    Object localObject1 = (Iterable)CollectionsKt.listOf(this.jdField_a_of_type_AndroidWidgetImageView);
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (ImageView)localObject2;
      Object localObject3 = a(paramString1, i);
      Bitmap localBitmap = VideoThumbProviderManager.getInstance().getBitmapByTime(500L * i + paramLong, localObject3, paramString2);
      if (localObject2 != null) {
        ((ImageView)localObject2).setTag(localObject3);
      }
      if (localObject2 != null)
      {
        localObject3 = getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
        ((ImageView)localObject2).setImageDrawable((Drawable)new bmot((Resources)localObject3, localBitmap));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.ThumbClipView
 * JD-Core Version:    0.7.0.1
 */