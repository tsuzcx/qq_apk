package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSSegmentManager;", "", "()V", "segHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSSegmentManager$BitmapWithKey;", "get", "Landroid/graphics/Bitmap;", "index", "", "key", "", "getCacheName", "preSegModel", "Lcom/tencent/qcircle/tavcut/aekit/PreSegModel;", "cropModel", "Lcom/tencent/qcircle/weseevideo/model/effect/CropModel;", "put", "", "bitmap", "release", "BitmapWithKey", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSSegmentManager
{
  public static final WSSegmentManager INSTANCE = new WSSegmentManager();
  private static final SparseArray<WSSegmentManager.BitmapWithKey> segHashMap = new SparseArray();
  
  @JvmStatic
  @Nullable
  public static final Bitmap get(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    WSSegmentManager.BitmapWithKey localBitmapWithKey = (WSSegmentManager.BitmapWithKey)segHashMap.get(paramInt);
    if (localBitmapWithKey != null)
    {
      if ((Intrinsics.areEqual(localBitmapWithKey.getKey(), paramString) ^ true)) {
        return null;
      }
      return localBitmapWithKey.getBitmap();
    }
    paramString = INSTANCE;
    return null;
  }
  
  @JvmStatic
  @Nullable
  public static final String getCacheName(@Nullable PreSegModel paramPreSegModel, @Nullable CropModel paramCropModel)
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
    paramPreSegModel = INSTANCE;
    return null;
  }
  
  @JvmStatic
  public static final void put(int paramInt, @NotNull String paramString, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Object localObject = (WSSegmentManager.BitmapWithKey)segHashMap.get(paramInt);
    if (localObject != null) {
      localObject = ((WSSegmentManager.BitmapWithKey)localObject).getBitmap();
    } else {
      localObject = null;
    }
    if (paramBitmap != null)
    {
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      segHashMap.put(paramInt, new WSSegmentManager.BitmapWithKey(paramBitmap, paramString));
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
  }
  
  @JvmStatic
  @RequiresApi(19)
  public static final void release()
  {
    int j = segHashMap.size();
    if (j >= 0)
    {
      int i = 0;
      for (;;)
      {
        localObject = (WSSegmentManager.BitmapWithKey)segHashMap.get(i);
        if (localObject != null)
        {
          localObject = ((WSSegmentManager.BitmapWithKey)localObject).getBitmap();
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
    Object localObject = segHashMap;
    ((SparseArray)localObject).removeAtRange(0, ((SparseArray)localObject).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WSSegmentManager
 * JD-Core Version:    0.7.0.1
 */