package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.model.effect.CropModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/composition/effectnode/WSSegmentManager;", "", "()V", "segHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/weseevideo/composition/effectnode/WSSegmentManager$BitmapWithKey;", "get", "Landroid/graphics/Bitmap;", "index", "", "key", "", "getCacheName", "preSegModel", "Lcom/tencent/tavcut/aekit/PreSegModel;", "cropModel", "Lcom/tencent/weseevideo/model/effect/CropModel;", "put", "", "bitmap", "release", "BitmapWithKey", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSSegmentManager
{
  private static final SparseArray<WSSegmentManager.BitmapWithKey> a;
  public static final WSSegmentManager a;
  
  static
  {
    jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeWSSegmentManager = new WSSegmentManager();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  @JvmStatic
  @Nullable
  public static final Bitmap a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    WSSegmentManager.BitmapWithKey localBitmapWithKey = (WSSegmentManager.BitmapWithKey)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localBitmapWithKey != null)
    {
      if ((Intrinsics.areEqual(localBitmapWithKey.a(), paramString) ^ true)) {
        return null;
      }
      return localBitmapWithKey.a();
    }
    paramString = jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeWSSegmentManager;
    return null;
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable PreSegModel paramPreSegModel, @Nullable CropModel paramCropModel)
  {
    if (paramPreSegModel != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramPreSegModel.getSegMaterial());
      ((StringBuilder)localObject).append(paramPreSegModel.getOriginPic());
      localObject = ((StringBuilder)localObject).toString();
      paramPreSegModel = (PreSegModel)localObject;
      if (paramCropModel != null)
      {
        paramPreSegModel = new StringBuilder();
        paramPreSegModel.append((String)localObject);
        localObject = paramCropModel.getCropConfig();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.cropConfig");
        paramPreSegModel.append(String.valueOf(((CropConfig)localObject).getX()));
        localObject = paramCropModel.getCropConfig();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.cropConfig");
        paramPreSegModel.append(String.valueOf(((CropConfig)localObject).getY()));
        localObject = paramCropModel.getCropConfig();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.cropConfig");
        paramPreSegModel.append(String.valueOf(((CropConfig)localObject).getWidth()));
        paramCropModel = paramCropModel.getCropConfig();
        Intrinsics.checkExpressionValueIsNotNull(paramCropModel, "it.cropConfig");
        paramPreSegModel.append(String.valueOf(paramCropModel.getHeight()));
        paramPreSegModel = paramPreSegModel.toString();
      }
      return paramPreSegModel;
    }
    paramPreSegModel = jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeWSSegmentManager;
    return null;
  }
  
  @JvmStatic
  @RequiresApi(19)
  public static final void a()
  {
    int j = jdField_a_of_type_AndroidUtilSparseArray.size();
    if (j >= 0)
    {
      int i = 0;
      for (;;)
      {
        localObject = (WSSegmentManager.BitmapWithKey)jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localObject = ((WSSegmentManager.BitmapWithKey)localObject).a();
          if (localObject != null) {
            ((Bitmap)localObject).recycle();
          }
        }
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    Object localObject = jdField_a_of_type_AndroidUtilSparseArray;
    ((SparseArray)localObject).removeAtRange(0, ((SparseArray)localObject).size());
  }
  
  @JvmStatic
  public static final void a(int paramInt, @NotNull String paramString, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Object localObject = (WSSegmentManager.BitmapWithKey)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      localObject = ((WSSegmentManager.BitmapWithKey)localObject).a();
    } else {
      localObject = null;
    }
    jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WSSegmentManager.BitmapWithKey(paramBitmap, paramString));
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSSegmentManager
 * JD-Core Version:    0.7.0.1
 */