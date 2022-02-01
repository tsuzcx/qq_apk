package com.tencent.qapmsdk.common.device;

import android.app.Application;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Process;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceCamera$Companion;", "", "()V", "SUPPORTED_PICTURE_SIZES", "", "SUPPORTED_PREVIEW_SIZES", "TAG", "getAllCameraSize", "app", "Landroid/app/Application;", "getMaxCamera", "", "(Landroid/app/Application;)[Ljava/lang/String;", "isCameraGranted", "", "info", "Ljava/util/HashMap;", "", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "Lkotlin/collections/HashMap;", "T", "(Landroid/hardware/Camera;)Ljava/util/HashMap;", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceCamera$Companion
{
  private final <T extends Camera> HashMap<?, List<Camera.Size>> info(@NotNull T paramT)
  {
    Object localObject1 = paramT.getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "parameters");
    localObject1 = ((Camera.Parameters)localObject1).getSupportedPreviewSizes();
    Object localObject2 = paramT.getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "parameters");
    localObject2 = ((Camera.Parameters)localObject2).getSupportedPictureSizes();
    paramT.stopPreview();
    paramT.release();
    return MapsKt.hashMapOf(new Pair[] { TuplesKt.to("supportedPreviewSizes", localObject1), TuplesKt.to("supportedPictureSizes", localObject2) });
  }
  
  private final boolean isCameraGranted(Application paramApplication)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramApplication != null)
    {
      bool1 = bool2;
      if (paramApplication.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @NotNull
  public final String getAllCameraSize(@Nullable Application paramApplication)
  {
    if (!((Companion)this).isCameraGranted(paramApplication)) {
      return "";
    }
    Object localObject2;
    try
    {
      localObject1 = ((Companion)this).info(Camera.open());
      paramApplication = new StringBuilder("{\"PictureSizes\":[");
      localObject2 = (List)((Map)localObject1).get("supportedPictureSizes");
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
          paramApplication.append(localSize.width + 'x' + localSize.height + ',');
        }
        paramApplication.deleteCharAt(paramApplication.length() - 1);
      }
    }
    catch (Exception paramApplication)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceCamera", paramApplication + ": get all camera size error." });
      return "";
    }
    paramApplication.append("],").append("{\"PreviewSizes\":[");
    Object localObject1 = (List)((Map)localObject1).get("supportedPreviewSizes");
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        paramApplication.append(((Camera.Size)localObject2).width + 'x' + ((Camera.Size)localObject2).height + ',');
      }
      paramApplication.deleteCharAt(paramApplication.length() - 1);
    }
    paramApplication.append("]}");
    paramApplication = paramApplication.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramApplication, "builder.toString()");
    return paramApplication;
  }
  
  @NotNull
  public final String[] getMaxCamera(@Nullable Application paramApplication)
  {
    if (!((Companion)this).isCameraGranted(paramApplication)) {
      return new String[] { "", "" };
    }
    paramApplication = (Camera)null;
    try
    {
      paramApplication = ((Companion)this).info(Camera.open());
      localCollection = paramApplication.values();
      Intrinsics.checkExpressionValueIsNotNull(localCollection, "cameraInfo.values");
      if (CollectionsKt.filterNotNull((Iterable)localCollection).size() < paramApplication.size()) {
        return new String[] { "", "" };
      }
    }
    catch (Exception paramApplication)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceCamera", paramApplication + ": can not get camera info." });
      return new String[] { "", "" };
    }
    paramApplication = paramApplication.values();
    Intrinsics.checkExpressionValueIsNotNull(paramApplication, "cameraInfo.values");
    paramApplication = (Iterable)CollectionsKt.filterNotNull((Iterable)paramApplication);
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramApplication, 10));
    Iterator localIterator = paramApplication.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramApplication = (List)localIterator.next();
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          Intrinsics.checkExpressionValueIsNotNull(paramApplication, "it");
          paramApplication = ((Camera.Size)CollectionsKt.last(paramApplication)).height + 'x' + ((Camera.Size)CollectionsKt.last(paramApplication)).width;
          localCollection.add(paramApplication);
        }
        catch (Exception paramApplication)
        {
          for (;;)
          {
            Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceCamera", paramApplication + ": camera height or width get error." });
            paramApplication = "0x0";
          }
        }
      }
    }
    paramApplication = ((Collection)localCollection).toArray(new String[0]);
    if (paramApplication == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramApplication = (String[])paramApplication;
    return paramApplication;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceCamera.Companion
 * JD-Core Version:    0.7.0.1
 */