package com.tencent.ttpic.openapi.factory;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.ChannelSplitFilter;
import com.tencent.ttpic.openapi.filter.PtuFilterFactory;
import com.tencent.view.FilterEngineFactory;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

public class TTPicFilterFactoryLocal
{
  private static final String TAG = "TTPicFilterFactoryLocal";
  
  public static void clearLutFiles()
  {
    if (AEModule.getLutDirPath() == null) {
      return;
    }
    FileUtils.delete(new File(AEModule.getLutDirPath()));
  }
  
  public static BaseFilter creatFilterById(int paramInt)
  {
    Object localObject1 = AEModule.getLutDirPath();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    if (paramInt != 215)
    {
      if (paramInt != 273) {
        if (paramInt != 283) {
          if (paramInt != 297) {
            if (paramInt != 1000) {
              if (paramInt != 249) {
                if (paramInt != 250) {
                  if (paramInt != 267) {
                    if (paramInt != 268) {
                      if (paramInt != 270) {
                        if (paramInt != 271) {
                          if (paramInt != 292) {
                            if (paramInt != 293) {
                              switch (paramInt)
                              {
                              default: 
                                switch (paramInt)
                                {
                                default: 
                                  switch (paramInt)
                                  {
                                  default: 
                                    localObject1 = null;
                                    break;
                                  case 289: 
                                    localObject1 = new GPUImageLookupFilter();
                                    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/ziran_lf.png", 33986));
                                    break;
                                  case 288: 
                                    localObject1 = new GPUImageLookupFilter();
                                    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/youjiali_lf.png", 33986));
                                    break;
                                  case 287: 
                                    localObject1 = new GPUImageLookupFilter();
                                    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/shuilian_lf.png", 33986));
                                    break;
                                  case 286: 
                                    localObject1 = new GPUImageLookupFilter();
                                    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
                                    break;
                                  case 285: 
                                    localObject1 = new GPUImageLookupFilter();
                                    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/xinye_lf.png", 33986));
                                  }
                                  break;
                                case 258: 
                                  localObject1 = new GPUImageLookupFilter();
                                  ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/zhahuang_lf.png", 33986));
                                  break;
                                case 257: 
                                  localObject1 = new GPUImageLookupFilter();
                                  ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/dongjing_lf.png", 33986));
                                  break;
                                case 256: 
                                  localObject1 = "MIC_PTU_ZIPAI_YOUNG";
                                  break;
                                case 255: 
                                  localObject1 = new GPUImageLookupFilter();
                                  ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
                                  break;
                                case 254: 
                                  localObject1 = "MIC_PTU_ZIPAI_LIGHTRED";
                                  break;
                                case 253: 
                                  localObject1 = new GPUImageLookupFilter();
                                  ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/fenbi_lf.png", 33986));
                                  break;
                                case 252: 
                                  localObject1 = new GPUImageLookupFilter();
                                  ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/tianbohe_lf.png", 33986));
                                }
                                break;
                              case 246: 
                                localObject1 = "MIC_PTU_ZIPAI_FAIRYTALE";
                                break;
                              case 245: 
                                localObject1 = "MIC_PTU_ZIPAI_LIGHTWHITE";
                                break;
                              case 244: 
                                localObject1 = "MIC_PTU_ZIPAI_RICHRED";
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject1 = null;
        break;
        localObject1 = "MIC_PTU_FBBS_LANGMAN";
        continue;
        localObject1 = new GPUImageLookupFilter();
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/nuanyang_lf.png", 33986));
        break;
        localObject1 = "MIC_PTU_ZIPAI_LIGHT";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_TEAMILK";
        continue;
        localObject1 = new GPUImageLookupFilter();
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/blackwhite_lf.png", 33986));
        break;
        localObject1 = "MIC_PTU_ZIPAI_GRADIENT_LIPNEW";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_RICHYELLOW";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_RICHBLUE";
        continue;
        localObject1 = new ChannelSplitFilter();
        break;
        localObject1 = new GPUImageLookupFilter();
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/wuxia_lf.png", 33986));
        break;
        localObject1 = new GPUImageLookupFilter();
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/qiangwei_lf.png", 33986));
        break;
        localObject1 = "MIC_PTU_ZIPAI_MAPLERED";
      }
    }
    else
    {
      localObject1 = new GPUImageLookupFilter();
      ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/fennen_lf.png", 33986));
    }
    if (localObject1 != null) {
      return localObject1;
    }
    if (TextUtils.isEmpty(localObject2)) {
      return PtuFilterFactory.createFilter(paramInt);
    }
    localObject1 = lutFilterWithID(localObject2);
    if (localObject1 == null)
    {
      filter2Image(paramInt, localObject2);
      return PtuFilterFactory.createFilter(paramInt);
    }
    return localObject1;
  }
  
  public static void filter2Image(int paramInt, String paramString)
  {
    if (AEModule.getLutDirPath() == null) {
      return;
    }
    FilterEngineFactory.getInstance().queue(new TTPicFilterFactoryLocal.1(paramInt, paramString));
  }
  
  public static Bitmap getBitmapFromEncryptedFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if (paramString.startsWith("assets://")) {
        paramString = AEModule.getContext().getAssets().open(FileUtils.getRealPath(paramString));
      } else {
        paramString = new FileInputStream(paramString);
      }
      localObject = FileEncryptUtils.decryptFile(paramString);
    }
    catch (Exception paramString)
    {
      label58:
      break label58;
    }
    try
    {
      IOUtils.closeQuietly(paramString);
      paramString = (String)localObject;
    }
    catch (Exception paramString)
    {
      paramString = (String)localObject;
      break label60;
    }
    paramString = null;
    label60:
    if (paramString == null) {
      return null;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      LogUtils.e("BitmapUtils", "decodeByteArray", paramString, new Object[0]);
      return null;
    }
  }
  
  public static BaseFilter lutFilterWithBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    GPUImageLookupFilter localGPUImageLookupFilter = new GPUImageLookupFilter();
    localGPUImageLookupFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", paramBitmap, 33986, true));
    return localGPUImageLookupFilter;
  }
  
  public static BaseFilter lutFilterWithID(String paramString)
  {
    if (AEModule.getLutDirPath() == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEModule.getLutDirPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".png2");
    paramString = getBitmapFromEncryptedFile(((StringBuilder)localObject).toString());
    if (paramString == null) {
      return null;
    }
    localObject = new GPUImageLookupFilter();
    ((BaseFilter)localObject).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", paramString, 33986, true));
    return localObject;
  }
  
  public static Bitmap preloadBaseLUTImage()
  {
    for (;;)
    {
      Object localObject;
      int n;
      int j;
      try
      {
        byte[] arrayOfByte = new byte[1048576];
        localObject = new byte[64];
        i = 0;
        if (i < 64)
        {
          localObject[i] = ((byte)Math.round(i * 4.047619F));
          i += 1;
          continue;
          if (i < 64)
          {
            n = i / 8;
            j = 0;
            break label98;
          }
          localObject = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(arrayOfByte));
          return localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return null;
      }
      int i = 0;
      continue;
      label98:
      while (j < 64)
      {
        int m = (n * 64 + j) * 512 * 4 + i % 8 * 64 * 4;
        int k = 0;
        while (k < 64)
        {
          int i1 = m + 1;
          localOutOfMemoryError[m] = localObject[k];
          m = i1 + 1;
          localOutOfMemoryError[i1] = localObject[j];
          i1 = m + 1;
          localOutOfMemoryError[m] = localObject[i];
          m = i1 + 1;
          localOutOfMemoryError[i1] = -1;
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void saveLutOrg()
  {
    if (AEModule.getLutDirPath() == null) {
      return;
    }
    Bitmap localBitmap = preloadBaseLUTImage();
    if (localBitmap == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEModule.getLutDirPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("LUT_ORG.png");
    BitmapUtils.saveBitmap2PNG(localBitmap, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal
 * JD-Core Version:    0.7.0.1
 */