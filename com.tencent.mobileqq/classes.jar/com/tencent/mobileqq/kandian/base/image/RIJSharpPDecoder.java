package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPDecoder;
import com.tencent.sharpP.SharpPDecoder.SharpPFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/RIJSharpPDecoder;", "", "()V", "mDecoder", "Lcom/tencent/sharpP/SharpPDecoder;", "closeDecoderInNative", "", "hObj", "", "createDecoderInNative", "path", "", "sharpPFeature", "Lcom/tencent/sharpP/SharpPDecoder$SharpPFeature;", "(Ljava/lang/String;Lcom/tencent/sharpP/SharpPDecoder$SharpPFeature;)Ljava/lang/Long;", "decodeImageToBitmapInNative", "", "index", "bitmap", "Landroid/graphics/Bitmap;", "delayTime", "(JILandroid/graphics/Bitmap;Ljava/lang/Integer;)Ljava/lang/Integer;", "decodeSharpP", "dstWidth", "dstHeight", "config", "Landroid/graphics/Bitmap$Config;", "reuseBitmap", "decodeSharpPBounds", "Landroid/graphics/BitmapFactory$Options;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJSharpPDecoder
{
  public static final RIJSharpPDecoder.Companion a;
  private static final String jdField_a_of_type_JavaLangString = "RIJSharpPDecoder";
  private SharpPDecoder jdField_a_of_type_ComTencentSharpPSharpPDecoder;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseImageRIJSharpPDecoder$Companion = new RIJSharpPDecoder.Companion(null);
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString, int paramInt1, int paramInt2, @NotNull Bitmap.Config paramConfig, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramConfig, "config");
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoder = new SharpPDecoder();
    Bitmap localBitmap = (Bitmap)null;
    SharpPDecoder.SharpPFeature localSharpPFeature = new SharpPDecoder.SharpPFeature(this.jdField_a_of_type_ComTencentSharpPSharpPDecoder);
    Object localObject = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    if (localObject != null) {
      localObject = Integer.valueOf(((SharpPDecoder)localObject).ParseHeader2(paramString, localSharpPFeature));
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return localBitmap;
    }
    if (((Integer)localObject).intValue() == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
      if (localObject != null) {
        paramString = Long.valueOf(((SharpPDecoder)localObject).CreateDecoder2(paramString, localSharpPFeature));
      } else {
        paramString = null;
      }
      if (((paramString == null) || (paramString.longValue() != 0L)) && (paramString != null))
      {
        if (paramBitmap == null) {
          paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
        }
        int j = localSharpPFeature.layerNum;
        paramInt1 = 0;
        int i;
        for (paramInt2 = 0; paramInt1 < j; paramInt2 = i)
        {
          paramConfig = a(paramString.longValue(), paramInt1, paramBitmap, Integer.valueOf(0));
          if (paramConfig != null)
          {
            i = paramInt2;
            if (paramConfig.intValue() == 0) {}
          }
          else
          {
            localObject = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeSharpP error:layerNo=");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append(",status=");
            localStringBuilder.append(paramConfig);
            QLog.d((String)localObject, 1, localStringBuilder.toString());
            i = paramInt2 + 1;
          }
          paramInt1 += 1;
        }
        paramConfig = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
        if (paramConfig != null) {
          paramConfig.CloseDecoder2(paramString.longValue());
        }
        if (paramInt2 == localSharpPFeature.layerNum) {
          return localBitmap;
        }
        return paramBitmap;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "decodeSharpPInNative error:hDec=0 or null");
      return null;
    }
    return localBitmap;
  }
  
  @NotNull
  public final BitmapFactory.Options a(@Nullable String paramString)
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoder = new SharpPDecoder();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.outWidth = -1;
    localOptions.outHeight = -1;
    SharpPDecoder.SharpPFeature localSharpPFeature = new SharpPDecoder.SharpPFeature(this.jdField_a_of_type_ComTencentSharpPSharpPDecoder);
    SharpPDecoder localSharpPDecoder = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    if (localSharpPDecoder != null) {
      paramString = Integer.valueOf(localSharpPDecoder.ParseHeader2(paramString, localSharpPFeature));
    } else {
      paramString = null;
    }
    if (paramString == null) {
      return localOptions;
    }
    if (paramString.intValue() == 0)
    {
      localOptions.outWidth = localSharpPFeature.width;
      localOptions.outHeight = localSharpPFeature.height;
    }
    return localOptions;
  }
  
  @Nullable
  public final Integer a(long paramLong, int paramInt, @Nullable Bitmap paramBitmap, @Nullable Integer paramInteger)
  {
    SharpPDecoder localSharpPDecoder = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    if (localSharpPDecoder != null) {
      return Integer.valueOf(localSharpPDecoder.DecodeImageToBitmap2(paramLong, paramInt, paramBitmap, paramInteger));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJSharpPDecoder
 * JD-Core Version:    0.7.0.1
 */