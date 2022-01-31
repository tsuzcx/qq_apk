package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import mqq.app.AppRuntime;

public class DIYThemeUtils
{
  public static final String SOURCE_DIR = AppConstants.aJ + "custom_background/";
  private static final String TAG = "DIYThemeUtils";
  public static String httpHeader = "http://gxh.vip.qq.com/xydata/";
  
  /* Error */
  public static android.graphics.drawable.Drawable getDIYDrawable(android.content.Context paramContext, ResData paramResData, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_0
    //   5: ifnonnull +49 -> 54
    //   8: ldc 9
    //   10: iconst_1
    //   11: new 14	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   18: ldc 50
    //   20: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: ldc 55
    //   29: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: ldc 57
    //   38: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload 4
    //   43: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: areturn
    //   54: aload_1
    //   55: getfield 72	com/tencent/mobileqq/theme/diy/ResData:resID	I
    //   58: ifle +147 -> 205
    //   61: aload_1
    //   62: getfield 72	com/tencent/mobileqq/theme/diy/ResData:resID	I
    //   65: ldc 73
    //   67: if_icmpne +127 -> 194
    //   70: aload_0
    //   71: invokevirtual 79	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   74: invokevirtual 85	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   77: astore_1
    //   78: aload_1
    //   79: ldc 87
    //   81: invokevirtual 93	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   84: astore 6
    //   86: aload 6
    //   88: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   91: astore_1
    //   92: aload 6
    //   94: invokevirtual 104	java/io/InputStream:close	()V
    //   97: aload_1
    //   98: ifnull +86 -> 184
    //   101: new 106	android/graphics/drawable/BitmapDrawable
    //   104: dup
    //   105: aload_0
    //   106: invokevirtual 79	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   109: aload_1
    //   110: invokespecial 109	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   113: areturn
    //   114: astore_1
    //   115: ldc 9
    //   117: iconst_1
    //   118: new 14	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   125: ldc 111
    //   127: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 114	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -53 -> 92
    //   148: astore 6
    //   150: aconst_null
    //   151: astore_1
    //   152: ldc 9
    //   154: iconst_1
    //   155: new 14	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   162: ldc 116
    //   164: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 6
    //   169: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto -84 -> 97
    //   184: ldc 9
    //   186: iconst_1
    //   187: ldc 119
    //   189: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aconst_null
    //   193: areturn
    //   194: invokestatic 125	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   197: aload_1
    //   198: getfield 72	com/tencent/mobileqq/theme/diy/ResData:resID	I
    //   201: invokevirtual 129	com/tencent/theme/SkinEngine:getDefaultThemeDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   204: areturn
    //   205: iconst_1
    //   206: aload_1
    //   207: getfield 132	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   210: if_icmpne +151 -> 361
    //   213: aload_0
    //   214: invokevirtual 79	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc 73
    //   219: invokevirtual 135	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   222: astore 6
    //   224: iload 5
    //   226: ifeq +193 -> 419
    //   229: aconst_null
    //   230: invokestatic 141	com/tencent/mobileqq/vas/VasApngUtil:a	(Lmqq/app/AppRuntime;)Z
    //   233: ifeq +186 -> 419
    //   236: iconst_1
    //   237: istore 5
    //   239: aload_1
    //   240: getfield 144	com/tencent/mobileqq/theme/diy/ResData:path	Ljava/lang/String;
    //   243: astore 7
    //   245: new 14	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   252: aload_1
    //   253: getfield 147	com/tencent/mobileqq/theme/diy/ResData:url	Ljava/lang/String;
    //   256: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: astore 8
    //   261: iload 5
    //   263: ifeq +162 -> 425
    //   266: ldc 149
    //   268: astore_1
    //   269: new 151	java/net/URL
    //   272: dup
    //   273: ldc 153
    //   275: aload 7
    //   277: aload 8
    //   279: aload_1
    //   280: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 156	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   289: astore_1
    //   290: invokestatic 162	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   293: astore 7
    //   295: iload 4
    //   297: bipush 100
    //   299: if_icmpne +13 -> 312
    //   302: aload 7
    //   304: iload 4
    //   306: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: putfield 172	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   312: aload 7
    //   314: iload 5
    //   316: putfield 176	com/tencent/image/URLDrawable$URLDrawableOptions:mUseApngImage	Z
    //   319: aload 7
    //   321: iload_2
    //   322: putfield 179	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   325: aload 7
    //   327: iload_3
    //   328: putfield 182	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   331: aload 7
    //   333: aload 6
    //   335: putfield 186	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   338: aload 7
    //   340: aload 6
    //   342: putfield 189	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   345: aload 7
    //   347: aload_0
    //   348: invokestatic 194	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   351: putfield 197	com/tencent/image/URLDrawable$URLDrawableOptions:mUseSharpPImage	Z
    //   354: aload_1
    //   355: aload 7
    //   357: invokestatic 202	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   360: areturn
    //   361: iconst_2
    //   362: aload_1
    //   363: getfield 132	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   366: if_icmpne +17 -> 383
    //   369: aload_0
    //   370: invokevirtual 79	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   373: ldc 203
    //   375: invokevirtual 135	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   378: astore 6
    //   380: goto -156 -> 224
    //   383: iconst_3
    //   384: aload_1
    //   385: getfield 132	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   388: if_icmpne +17 -> 405
    //   391: aload_0
    //   392: invokevirtual 79	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   395: ldc 204
    //   397: invokevirtual 135	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   400: astore 6
    //   402: goto -178 -> 224
    //   405: aload_0
    //   406: invokevirtual 79	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   409: ldc 205
    //   411: invokevirtual 135	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   414: astore 6
    //   416: goto -192 -> 224
    //   419: iconst_0
    //   420: istore 5
    //   422: goto -183 -> 239
    //   425: ldc 207
    //   427: astore_1
    //   428: goto -159 -> 269
    //   431: astore_0
    //   432: ldc 9
    //   434: iconst_1
    //   435: new 14	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   442: ldc 209
    //   444: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_0
    //   448: invokevirtual 210	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   451: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload 6
    //   462: areturn
    //   463: astore 6
    //   465: goto -313 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContext	android.content.Context
    //   0	468	1	paramResData	ResData
    //   0	468	2	paramInt1	int
    //   0	468	3	paramInt2	int
    //   0	468	4	paramInt3	int
    //   0	468	5	paramBoolean	boolean
    //   84	9	6	localInputStream	java.io.InputStream
    //   148	20	6	localException1	java.lang.Exception
    //   222	239	6	localDrawable	android.graphics.drawable.Drawable
    //   463	1	6	localException2	java.lang.Exception
    //   243	113	7	localObject	Object
    //   259	19	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   86	92	114	java/lang/OutOfMemoryError
    //   78	86	148	java/lang/Exception
    //   86	92	148	java/lang/Exception
    //   115	143	148	java/lang/Exception
    //   239	261	431	java/net/MalformedURLException
    //   269	290	431	java/net/MalformedURLException
    //   92	97	463	java/lang/Exception
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
      localResData.path = (AppConstants.bK + "deal/" + paramResSuitData.id);
      return localResData;
    case 110: 
      localResData.path = (AppConstants.bF + "preview/" + paramResSuitData.id);
      return localResData;
    case 117: 
      localResData.path = (AppConstants.bJ + paramResSuitData.id);
      return localResData;
    case 120: 
    case 121: 
      if (paramAppRuntime == null)
      {
        paramAppRuntime = "0";
        paramAppRuntime = paramAppRuntime + "/";
        paramAppRuntime = new StringBuilder().append(AppConstants.aJ).append("custom_background/").append(paramAppRuntime);
        if (120 != paramInt) {
          break label370;
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
      label370:
      localResData.path = (AppConstants.aJ + "custom_background/" + "styleShot/" + paramString);
      return localResData;
    }
    localResData.path = (AppConstants.aJ + "custom_background/" + "styleThum/" + paramString);
    return localResData;
  }
  
  public static boolean isNeedDealDarkBright(ThemeDIYData paramThemeDIYData, ResSuitData paramResSuitData, ResData paramResData)
  {
    return (paramThemeDIYData.position == 1) && ((paramResSuitData == null) || ("999".equals(paramResSuitData.id))) && ((paramResData == null) || ((paramResSuitData != null) && (!paramResSuitData.id.equals(paramResData.dealThemeID))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.DIYThemeUtils
 * JD-Core Version:    0.7.0.1
 */