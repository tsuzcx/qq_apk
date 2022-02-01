package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jetbrains.annotations.Nullable;

public class PobingUpdateCallback
  extends BaseUpdateCallback
{
  public static final int BID = 40;
  private static final String ROOT_DIR = "newComeCard";
  private static final String SCID = "newComeCard.";
  private static final String TAG = "PobingUpdateCallback";
  public static PobingUpdateCallback sInstance = new PobingUpdateCallback();
  
  public static NinePatchDrawable createNinePatchDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    int i = 0;
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = (paramBitmap.getWidth() / 2);
    arrayOfInt1[1] = (paramBitmap.getWidth() / 2 + 1);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = (paramBitmap.getHeight() / 2);
    arrayOfInt2[1] = (paramBitmap.getHeight() / 2 + 1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfInt1.length * 4 + arrayOfInt2.length * 4 + 36 + 32).order(ByteOrder.nativeOrder());
    localByteBuffer.put((byte)1);
    localByteBuffer.put((byte)2);
    localByteBuffer.put((byte)2);
    localByteBuffer.put((byte)9);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(arrayOfInt1[0]);
    localByteBuffer.putInt(arrayOfInt1[1]);
    localByteBuffer.putInt(arrayOfInt2[0]);
    localByteBuffer.putInt(arrayOfInt2[1]);
    while (i < 9)
    {
      localByteBuffer.putInt(1);
      i += 1;
    }
    return new NinePatchDrawable(paramResources, paramBitmap, localByteBuffer.array(), new Rect(), "");
  }
  
  private boolean isPobingCardExit(int paramInt, String paramString)
  {
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).isPobingCardExit(paramInt, paramString);
  }
  
  public Bitmap decodeBitmap(Context paramContext, int paramInt, String paramString)
  {
    return decodeBitmap(getFilePathById(paramContext, paramInt, paramString));
  }
  
  @Nullable
  public Bitmap decodeBitmap(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = 320;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    BitmapManager.a(paramString, localOptions, localBitmapDecodeResult);
    if (localBitmapDecodeResult.jdField_a_of_type_Int != 0)
    {
      QLog.e("PobingUpdateCallback", 1, paramString + " decodeFail: " + localBitmapDecodeResult.jdField_a_of_type_Int);
      return null;
    }
    return localBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public long getBID()
  {
    return 40L;
  }
  
  public String getFilePathById(Context paramContext, int paramInt, String paramString)
  {
    paramContext = getDir(paramContext, getScid(paramInt));
    return paramContext + File.separator + paramString;
  }
  
  protected String getRootDir()
  {
    return "newComeCard";
  }
  
  protected String getScidPrefix()
  {
    return "newComeCard.";
  }
  
  public boolean isCardExists(Context paramContext, int paramInt)
  {
    String str = "newComeCard." + paramInt;
    paramContext = sInstance.getDir(paramContext, str);
    if (!new File(paramContext).exists()) {
      return false;
    }
    return isPobingCardExit(paramInt, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.PobingUpdateCallback
 * JD-Core Version:    0.7.0.1
 */