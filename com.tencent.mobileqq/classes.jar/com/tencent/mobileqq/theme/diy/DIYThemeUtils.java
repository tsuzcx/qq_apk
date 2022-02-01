package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import mqq.app.AppRuntime;

public class DIYThemeUtils
{
  private static final String TAG = "DIYThemeUtils";
  public static String httpHeader = "https://gxh.vip.qq.com/xydata/";
  
  /* Error */
  public static android.graphics.drawable.Drawable getDIYDrawable(android.content.Context paramContext, ResData paramResData, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_0
    //   5: ifnonnull +49 -> 54
    //   8: ldc 8
    //   10: iconst_1
    //   11: new 29	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   18: ldc 32
    //   20: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: ldc 41
    //   29: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: ldc 43
    //   38: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload 4
    //   43: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: areturn
    //   54: aload_1
    //   55: getfield 62	com/tencent/mobileqq/theme/diy/ResData:resID	I
    //   58: ifle +147 -> 205
    //   61: aload_1
    //   62: getfield 62	com/tencent/mobileqq/theme/diy/ResData:resID	I
    //   65: ldc 63
    //   67: if_icmpne +127 -> 194
    //   70: aload_0
    //   71: invokevirtual 69	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   74: invokevirtual 75	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   77: astore_1
    //   78: aload_1
    //   79: ldc 77
    //   81: invokevirtual 83	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   84: astore 6
    //   86: aload 6
    //   88: invokestatic 89	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   91: astore_1
    //   92: aload 6
    //   94: invokevirtual 94	java/io/InputStream:close	()V
    //   97: aload_1
    //   98: ifnull +86 -> 184
    //   101: new 96	android/graphics/drawable/BitmapDrawable
    //   104: dup
    //   105: aload_0
    //   106: invokevirtual 69	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   109: aload_1
    //   110: invokespecial 99	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   113: areturn
    //   114: astore_1
    //   115: ldc 8
    //   117: iconst_1
    //   118: new 29	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   125: ldc 101
    //   127: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 104	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -53 -> 92
    //   148: astore 6
    //   150: aconst_null
    //   151: astore_1
    //   152: ldc 8
    //   154: iconst_1
    //   155: new 29	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   162: ldc 106
    //   164: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 6
    //   169: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto -84 -> 97
    //   184: ldc 8
    //   186: iconst_1
    //   187: ldc 109
    //   189: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aconst_null
    //   193: areturn
    //   194: invokestatic 115	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   197: aload_1
    //   198: getfield 62	com/tencent/mobileqq/theme/diy/ResData:resID	I
    //   201: invokevirtual 119	com/tencent/theme/SkinEngine:getDefaultThemeDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   204: areturn
    //   205: iconst_1
    //   206: aload_1
    //   207: getfield 122	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   210: if_icmpne +136 -> 346
    //   213: aload_0
    //   214: invokevirtual 69	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc 63
    //   219: invokevirtual 125	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   222: astore 6
    //   224: aload_1
    //   225: getfield 128	com/tencent/mobileqq/theme/diy/ResData:path	Ljava/lang/String;
    //   228: astore 7
    //   230: new 29	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   237: aload_1
    //   238: getfield 131	com/tencent/mobileqq/theme/diy/ResData:url	Ljava/lang/String;
    //   241: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: astore 8
    //   246: iload 5
    //   248: ifeq +156 -> 404
    //   251: ldc 133
    //   253: astore_1
    //   254: new 135	java/net/URL
    //   257: dup
    //   258: ldc 137
    //   260: aload 7
    //   262: aload 8
    //   264: aload_1
    //   265: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokespecial 140	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   274: astore_1
    //   275: invokestatic 146	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   278: astore 7
    //   280: iload 4
    //   282: bipush 100
    //   284: if_icmpne +13 -> 297
    //   287: aload 7
    //   289: iload 4
    //   291: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: putfield 156	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   297: aload 7
    //   299: iload 5
    //   301: putfield 160	com/tencent/image/URLDrawable$URLDrawableOptions:mUseApngImage	Z
    //   304: aload 7
    //   306: iload_2
    //   307: putfield 163	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   310: aload 7
    //   312: iload_3
    //   313: putfield 166	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   316: aload 7
    //   318: aload 6
    //   320: putfield 170	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   323: aload 7
    //   325: aload 6
    //   327: putfield 173	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   330: aload 7
    //   332: aload_0
    //   333: invokestatic 179	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   336: putfield 182	com/tencent/image/URLDrawable$URLDrawableOptions:mUseSharpPImage	Z
    //   339: aload_1
    //   340: aload 7
    //   342: invokestatic 187	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   345: areturn
    //   346: iconst_2
    //   347: aload_1
    //   348: getfield 122	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   351: if_icmpne +17 -> 368
    //   354: aload_0
    //   355: invokevirtual 69	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   358: ldc 188
    //   360: invokevirtual 125	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   363: astore 6
    //   365: goto -141 -> 224
    //   368: iconst_3
    //   369: aload_1
    //   370: getfield 122	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   373: if_icmpne +17 -> 390
    //   376: aload_0
    //   377: invokevirtual 69	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   380: ldc 189
    //   382: invokevirtual 125	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   385: astore 6
    //   387: goto -163 -> 224
    //   390: aload_0
    //   391: invokevirtual 69	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   394: ldc 190
    //   396: invokevirtual 125	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   399: astore 6
    //   401: goto -177 -> 224
    //   404: ldc 192
    //   406: astore_1
    //   407: goto -153 -> 254
    //   410: astore_0
    //   411: ldc 8
    //   413: iconst_1
    //   414: new 29	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   421: ldc 194
    //   423: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_0
    //   427: invokevirtual 195	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   430: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload 6
    //   441: areturn
    //   442: astore 6
    //   444: goto -292 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramContext	android.content.Context
    //   0	447	1	paramResData	ResData
    //   0	447	2	paramInt1	int
    //   0	447	3	paramInt2	int
    //   0	447	4	paramInt3	int
    //   0	447	5	paramBoolean	boolean
    //   84	9	6	localInputStream	java.io.InputStream
    //   148	20	6	localException1	java.lang.Exception
    //   222	218	6	localDrawable	android.graphics.drawable.Drawable
    //   442	1	6	localException2	java.lang.Exception
    //   228	113	7	localObject	Object
    //   244	19	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   86	92	114	java/lang/OutOfMemoryError
    //   78	86	148	java/lang/Exception
    //   86	92	148	java/lang/Exception
    //   115	143	148	java/lang/Exception
    //   224	246	410	java/net/MalformedURLException
    //   254	275	410	java/net/MalformedURLException
    //   92	97	442	java/lang/Exception
  }
  
  public static ResData getResData(AppRuntime paramAppRuntime, ResSuitData paramResSuitData, int paramInt, String paramString)
  {
    ResData localResData = new ResData();
    localResData.type = paramInt;
    localResData.id = paramResSuitData.id;
    localResData.url = (httpHeader + paramResSuitData.appStr + "/" + paramResSuitData.typeStr + "/" + localResData.id + "/" + paramString);
    localResData.name = paramString;
    switch (paramInt)
    {
    default: 
      return localResData;
    case 115: 
      localResData.path = ChatBackgroundManager.a(true, paramResSuitData.id);
      return localResData;
    case 116: 
      localResData.path = (AppConstants.PATH_SYSTEM_BACKGROUND_RESOURCE + "deal/" + paramResSuitData.id);
      return localResData;
    case 110: 
      localResData.path = ChatBackgroundManager.a(true, paramResSuitData.id);
      return localResData;
    case 117: 
      localResData.path = (AppConstants.PATH_SYSTEM_BACKGROUND_THUMBNAIL + localResData.id + "/" + localResData.url.hashCode());
      return localResData;
    case 120: 
    case 121: 
      if (paramAppRuntime == null)
      {
        paramAppRuntime = "0";
        paramAppRuntime = new StringBuilder().append(ThemeDiyStyleLogic.getDataDIYDir()).append(DiySecureFileHelper.a(paramAppRuntime)).append("/");
        if (120 != paramInt) {
          break label350;
        }
      }
      for (;;)
      {
        localResData.path = paramString;
        return localResData;
        paramAppRuntime = paramAppRuntime.getAccount();
        break;
        paramString = "org/" + paramString;
      }
    case 201: 
      label350:
      localResData.path = (ThemeDiyStyleLogic.getSdcardDIYDir() + "styleShot/" + paramString);
      return localResData;
    }
    localResData.path = (ThemeDiyStyleLogic.getSdcardDIYDir() + "styleThum/" + paramString);
    return localResData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.DIYThemeUtils
 * JD-Core Version:    0.7.0.1
 */