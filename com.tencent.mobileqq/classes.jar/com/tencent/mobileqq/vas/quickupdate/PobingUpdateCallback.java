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
    int[] arrayOfInt1 = new int[2];
    int j = paramBitmap.getWidth() / 2;
    int i = 0;
    arrayOfInt1[0] = j;
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
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = 320;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    BitmapManager.a(paramString, (BitmapFactory.Options)localObject, localBitmapDecodeResult);
    if (localBitmapDecodeResult.b != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" decodeFail: ");
      ((StringBuilder)localObject).append(localBitmapDecodeResult.b);
      QLog.e("PobingUpdateCallback", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    return localBitmapDecodeResult.a;
  }
  
  public long getBID()
  {
    return 40L;
  }
  
  public String getFilePathById(Context paramContext, int paramInt, String paramString)
  {
    paramContext = getDir(paramContext, getScid(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("newComeCard.");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    paramContext = sInstance.getDir(paramContext, (String)localObject);
    if (!new File(paramContext).exists()) {
      return false;
    }
    return isPobingCardExit(paramInt, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.PobingUpdateCallback
 * JD-Core Version:    0.7.0.1
 */