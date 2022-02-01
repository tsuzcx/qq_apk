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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/imageopt/RIJSharpPDecoder;", "", "()V", "mDecoder", "Lcom/tencent/sharpP/SharpPDecoder;", "closeDecoderInNative", "", "hObj", "", "createDecoderInNative", "path", "", "sharpPFeature", "Lcom/tencent/sharpP/SharpPDecoder$SharpPFeature;", "(Ljava/lang/String;Lcom/tencent/sharpP/SharpPDecoder$SharpPFeature;)Ljava/lang/Long;", "decodeImageToBitmapInNative", "", "index", "bitmap", "Landroid/graphics/Bitmap;", "delayTime", "(JILandroid/graphics/Bitmap;Ljava/lang/Integer;)Ljava/lang/Integer;", "decodeSharpP", "dstWidth", "dstHeight", "config", "Landroid/graphics/Bitmap$Config;", "reuseBitmap", "decodeSharpPBounds", "Landroid/graphics/BitmapFactory$Options;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class psr
{
  private static final String jdField_a_of_type_JavaLangString = "RIJSharpPDecoder";
  public static final pss a;
  private SharpPDecoder jdField_a_of_type_ComTencentSharpPSharpPDecoder;
  
  static
  {
    jdField_a_of_type_Pss = new pss(null);
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString, int paramInt1, int paramInt2, @NotNull Bitmap.Config paramConfig, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramConfig, "config");
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoder = new SharpPDecoder();
    Bitmap localBitmap = (Bitmap)null;
    SharpPDecoder.SharpPFeature localSharpPFeature = new SharpPDecoder.SharpPFeature(this.jdField_a_of_type_ComTencentSharpPSharpPDecoder);
    Object localObject = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((SharpPDecoder)localObject).ParseHeader2(paramString, localSharpPFeature));
      if (localObject != null) {
        break label75;
      }
    }
    label75:
    while (((Integer)localObject).intValue() != 0)
    {
      return localBitmap;
      localObject = null;
      break;
    }
    localObject = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    if (localObject != null)
    {
      paramString = Long.valueOf(((SharpPDecoder)localObject).CreateDecoder2(paramString, localSharpPFeature));
      if (paramString != null) {
        break label130;
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label142;
      }
      label130:
      do
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "decodeSharpPInNative error:hDec=0 or null");
        return null;
        paramString = null;
        break;
      } while (paramString.longValue() == 0L);
    }
    label142:
    if (paramBitmap != null)
    {
      paramConfig = paramBitmap;
      paramInt2 = 0;
      paramInt1 = 0;
      int j = localSharpPFeature.layerNum;
      label162:
      if (paramInt1 >= j) {
        break label267;
      }
      paramBitmap = a(paramString.longValue(), paramInt1, paramConfig, Integer.valueOf(0));
      if (paramBitmap != null) {
        break label253;
      }
    }
    for (;;)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "decodeSharpP error:layerNo=" + paramInt1 + ",status=" + paramBitmap);
      int i = paramInt2 + 1;
      label253:
      do
      {
        paramInt1 += 1;
        paramInt2 = i;
        break label162;
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
        break;
        i = paramInt2;
      } while (paramBitmap.intValue() == 0);
    }
    label267:
    paramBitmap = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    if (paramBitmap != null) {
      paramBitmap.CloseDecoder2(paramString.longValue());
    }
    if (paramInt2 == localSharpPFeature.layerNum) {
      return (Bitmap)null;
    }
    return paramConfig;
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
    if (localSharpPDecoder != null)
    {
      paramString = Integer.valueOf(localSharpPDecoder.ParseHeader2(paramString, localSharpPFeature));
      if (paramString != null) {
        break label74;
      }
    }
    label74:
    while (paramString.intValue() != 0)
    {
      return localOptions;
      paramString = null;
      break;
    }
    localOptions.outWidth = localSharpPFeature.width;
    localOptions.outHeight = localSharpPFeature.height;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psr
 * JD-Core Version:    0.7.0.1
 */