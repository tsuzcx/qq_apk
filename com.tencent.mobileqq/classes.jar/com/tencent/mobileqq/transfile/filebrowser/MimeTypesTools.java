package com.tencent.mobileqq.transfile.filebrowser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class MimeTypesTools
{
  public static final String TAG = "MimeTypesTools";
  private static boolean hasLoadMimeType = false;
  private static MimeTypes mMimeTypes;
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  public static Bitmap getBitmapForFileName(Context paramContext, String paramString)
  {
    paramContext = getDrawableForFileName(paramContext, paramString);
    if (paramContext == null) {
      return null;
    }
    return drawableToBitmap(paramContext);
  }
  
  public static Drawable getDrawableForFileName(Context paramContext, String paramString)
  {
    return getDrawableForMimetype(paramContext, getMimeType(paramContext, paramString));
  }
  
  public static Drawable getDrawableForMimetype(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType(paramString);
    paramString = localPackageManager.queryIntentActivities(localIntent, 65536);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((ResolveInfo)paramString.get(0)).loadIcon(localPackageManager);
    }
    return paramContext.getResources().getDrawable(2130853403);
  }
  
  public static String getMimeType(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.toLowerCase();
    }
    return getMimeTypes(paramContext).getMimeType(str);
  }
  
  private static MimeTypes getMimeTypes(Context paramContext)
  {
    loadMimeTypes(paramContext);
    return mMimeTypes;
  }
  
  public static boolean isImageType(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.lastIndexOf(".");
    if (i < 0) {
      return false;
    }
    paramString = paramString.substring(i, paramString.length());
    return (".jpg".equalsIgnoreCase(paramString)) || (".png".equalsIgnoreCase(paramString)) || (".gif".equalsIgnoreCase(paramString)) || (".jpeg".equalsIgnoreCase(paramString)) || (".bmp".equalsIgnoreCase(paramString));
  }
  
  private static void loadMimeTypes(Context paramContext)
  {
    MimeTypeParser localMimeTypeParser;
    if (!hasLoadMimeType)
    {
      localMimeTypeParser = new MimeTypeParser();
      paramContext = paramContext.getResources().getXml(2132082695);
    }
    try
    {
      mMimeTypes = localMimeTypeParser.fromXmlResource(paramContext);
      hasLoadMimeType = true;
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      break label47;
    }
    catch (IOException paramContext)
    {
      label37:
      label47:
      break label37;
    }
    throw new RuntimeException("PreselectedChannelsActivity: IOException");
    throw new RuntimeException("PreselectedChannelsActivity: XmlPullParserException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools
 * JD-Core Version:    0.7.0.1
 */