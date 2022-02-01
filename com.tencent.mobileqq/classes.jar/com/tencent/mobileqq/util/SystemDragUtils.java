package com.tencent.mobileqq.util;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.QFileImageItemBuilder.FileHolder;
import com.tencent.mobileqq.activity.aio.item.QFileSimpleItemBuilder.FileHolder;
import com.tencent.mobileqq.activity.aio.item.QFileVideoItemBuilder.FileHolder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SystemDragUtils
{
  public static float a;
  public static float b;
  public static int c = -1;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final Boolean g;
  private static SystemDragUtils.TouchHandler h;
  private static boolean i;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Tencent/MobileQQ/SharedIn/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Tencent/MobileQQ/SharedOut/");
    e = localStringBuilder.toString();
    f = HardCodeUtil.a(2131912011);
    g = Boolean.valueOf(false);
    h = new SystemDragUtils.TouchHandler();
  }
  
  /* Error */
  private static File a(Context paramContext, java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: ifnull +193 -> 200
    //   10: aload 6
    //   12: astore_0
    //   13: sipush 8192
    //   16: newarray byte
    //   18: astore 7
    //   20: aload 6
    //   22: astore_0
    //   23: new 34	java/io/File
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 8
    //   33: aload 6
    //   35: astore_0
    //   36: aload 8
    //   38: invokevirtual 91	java/io/File:exists	()Z
    //   41: ifne +12 -> 53
    //   44: aload 6
    //   46: astore_0
    //   47: aload 8
    //   49: invokevirtual 94	java/io/File:mkdir	()Z
    //   52: pop
    //   53: aload 6
    //   55: astore_0
    //   56: new 34	java/io/File
    //   59: dup
    //   60: aload_2
    //   61: aload_3
    //   62: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: astore_3
    //   66: aload 6
    //   68: astore_0
    //   69: aload_3
    //   70: invokevirtual 91	java/io/File:exists	()Z
    //   73: ifeq +11 -> 84
    //   76: aload 6
    //   78: astore_0
    //   79: aload_3
    //   80: invokevirtual 100	java/io/File:delete	()Z
    //   83: pop
    //   84: aload 6
    //   86: astore_0
    //   87: new 102	java/io/FileOutputStream
    //   90: dup
    //   91: aload_3
    //   92: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore_2
    //   96: aload_1
    //   97: aload 7
    //   99: invokevirtual 111	java/io/InputStream:read	([B)I
    //   102: istore 4
    //   104: iload 4
    //   106: iconst_m1
    //   107: if_icmpeq +15 -> 122
    //   110: aload_2
    //   111: aload 7
    //   113: iconst_0
    //   114: iload 4
    //   116: invokevirtual 117	java/io/OutputStream:write	([BII)V
    //   119: goto -23 -> 96
    //   122: aload_2
    //   123: invokevirtual 120	java/io/OutputStream:flush	()V
    //   126: aload_2
    //   127: invokevirtual 123	java/io/OutputStream:close	()V
    //   130: aload_3
    //   131: areturn
    //   132: astore_1
    //   133: aload_2
    //   134: astore_0
    //   135: goto +55 -> 190
    //   138: astore_0
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: astore_3
    //   143: goto +24 -> 167
    //   146: astore_0
    //   147: aload_3
    //   148: astore_1
    //   149: aload 5
    //   151: astore_2
    //   152: aload_0
    //   153: astore_3
    //   154: goto +13 -> 167
    //   157: astore_1
    //   158: goto +32 -> 190
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_1
    //   164: aload 5
    //   166: astore_2
    //   167: aload_2
    //   168: astore_0
    //   169: ldc 125
    //   171: iconst_1
    //   172: ldc 127
    //   174: aload_3
    //   175: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: aload_1
    //   179: astore_0
    //   180: aload_2
    //   181: ifnull +21 -> 202
    //   184: aload_2
    //   185: invokevirtual 123	java/io/OutputStream:close	()V
    //   188: aload_1
    //   189: areturn
    //   190: aload_0
    //   191: ifnull +7 -> 198
    //   194: aload_0
    //   195: invokevirtual 123	java/io/OutputStream:close	()V
    //   198: aload_1
    //   199: athrow
    //   200: aconst_null
    //   201: astore_0
    //   202: aload_0
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramContext	Context
    //   0	204	1	paramInputStream	java.io.InputStream
    //   0	204	2	paramString1	String
    //   0	204	3	paramString2	String
    //   102	13	4	j	int
    //   1	164	5	localObject1	Object
    //   4	81	6	localObject2	Object
    //   18	94	7	arrayOfByte	byte[]
    //   31	17	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   96	104	132	finally
    //   110	119	132	finally
    //   122	126	132	finally
    //   96	104	138	java/io/IOException
    //   110	119	138	java/io/IOException
    //   122	126	138	java/io/IOException
    //   69	76	146	java/io/IOException
    //   79	84	146	java/io/IOException
    //   87	96	146	java/io/IOException
    //   13	20	157	finally
    //   23	33	157	finally
    //   36	44	157	finally
    //   47	53	157	finally
    //   56	66	157	finally
    //   69	76	157	finally
    //   79	84	157	finally
    //   87	96	157	finally
    //   169	178	157	finally
    //   13	20	161	java/io/IOException
    //   23	33	161	java/io/IOException
    //   36	44	161	java/io/IOException
    //   47	53	161	java/io/IOException
    //   56	66	161	java/io/IOException
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 140	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aload 7
    //   14: astore 5
    //   16: aload 4
    //   18: ifnull +120 -> 138
    //   21: aload_0
    //   22: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   25: aload_1
    //   26: invokevirtual 152	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: aload_2
    //   38: aload_3
    //   39: invokestatic 154	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/content/Context;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   42: invokevirtual 157	java/io/File:getPath	()Ljava/lang/String;
    //   45: astore_0
    //   46: aload_0
    //   47: astore 5
    //   49: aload 4
    //   51: ifnull +87 -> 138
    //   54: aload_0
    //   55: astore_1
    //   56: aload 4
    //   58: invokevirtual 158	java/io/InputStream:close	()V
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: ldc 125
    //   66: iconst_1
    //   67: ldc 160
    //   69: aload_0
    //   70: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_1
    //   74: areturn
    //   75: astore_2
    //   76: aload 4
    //   78: astore_0
    //   79: goto +12 -> 91
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_1
    //   85: goto +30 -> 115
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_1
    //   93: aload_2
    //   94: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   97: aload 7
    //   99: astore 5
    //   101: aload_0
    //   102: ifnull +36 -> 138
    //   105: aload 6
    //   107: astore_1
    //   108: aload_0
    //   109: invokevirtual 158	java/io/InputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull +20 -> 136
    //   119: aload_1
    //   120: invokevirtual 158	java/io/InputStream:close	()V
    //   123: goto +13 -> 136
    //   126: astore_1
    //   127: ldc 125
    //   129: iconst_1
    //   130: ldc 160
    //   132: aload_1
    //   133: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_0
    //   137: athrow
    //   138: aload 5
    //   140: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramContext	Context
    //   0	141	1	paramUri	Uri
    //   0	141	2	paramString1	String
    //   0	141	3	paramString2	String
    //   4	73	4	localObject1	Object
    //   14	125	5	localObject2	Object
    //   10	96	6	localObject3	Object
    //   7	91	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   56	61	63	java/lang/Exception
    //   108	112	63	java/lang/Exception
    //   34	46	75	java/lang/Exception
    //   21	31	82	finally
    //   21	31	88	java/lang/Exception
    //   34	46	114	finally
    //   93	97	114	finally
    //   119	123	126	java/lang/Exception
  }
  
  public static String a(Uri paramUri, ContentResolver paramContentResolver)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    try
    {
      paramUri = paramContentResolver.query(paramUri, arrayOfString, null, null, null);
      if (paramUri != null)
      {
        paramUri.moveToFirst();
        paramContentResolver = paramUri.getString(paramUri.getColumnIndex(arrayOfString[0]));
        paramUri.close();
        return paramContentResolver;
      }
      return null;
    }
    catch (Exception paramUri)
    {
      QLog.e("SystemDragUtils", 1, "getFilePathFromContentUri exception", paramUri);
    }
    return null;
  }
  
  public static void a(Context paramContext, SystemDragUtils.DragTouchDelegate paramDragTouchDelegate, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    h.b = new WeakReference(paramContext);
    h.c = paramOnLongClickAndTouchListener;
    paramDragTouchDelegate.a(paramOnLongClickAndTouchListener);
    paramDragTouchDelegate.a(new SystemDragUtils.3());
  }
  
  @RequiresApi(api=16)
  public static void a(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Context paramContext, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000) && (paramSessionInfo.a != 0) && (!MsgProxyUtils.a(paramSessionInfo.a)))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("unsupported UinType:");
      paramQQAppInterface.append(paramSessionInfo.a);
      QLog.d("SystemDragUtils", 1, paramQQAppInterface.toString());
      return;
    }
    ImageView localImageView = new ImageView(paramContext);
    ColorDrawable localColorDrawable1 = new ColorDrawable(Color.parseColor("#33000000"));
    ColorDrawable localColorDrawable2 = new ColorDrawable(Color.parseColor("#7F000000"));
    localImageView.setImageDrawable(localColorDrawable1);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramViewGroup.setOnDragListener(new SystemDragUtils.1(localImageView, localColorDrawable1, paramViewGroup, localColorDrawable2, paramContext, paramQQAppInterface, paramSessionInfo));
  }
  
  public static boolean a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static SystemDragUtils.DropItem b(Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject1;
    long l;
    if ((paramViewHolder instanceof QFileSimpleItemBuilder.FileHolder))
    {
      localObject1 = QFileUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramViewHolder.q);
      l = FileUtils.getFileSizes((String)localObject1);
      localObject2 = paramViewHolder.h;
      paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
      localObject1 = localObject2;
    }
    else if ((paramViewHolder instanceof QFileImageItemBuilder.FileHolder))
    {
      localObject1 = QFileUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramViewHolder.q);
      l = FileUtils.getFileSizes((String)localObject1);
      localObject2 = ((QFileImageItemBuilder.FileHolder)paramViewHolder).a;
      paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
      localObject1 = localObject2;
    }
    else if ((paramViewHolder instanceof QFileVideoItemBuilder.FileHolder))
    {
      localObject1 = QFileUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramViewHolder.q);
      l = FileUtils.getFileSizes((String)localObject1);
      localObject2 = ((QFileVideoItemBuilder.FileHolder)paramViewHolder).a;
      paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
      localObject1 = localObject2;
    }
    else if ((paramViewHolder instanceof BasePicItemBuilder.Holder))
    {
      localObject2 = (MessageForPic)paramViewHolder.q;
      localObject3 = ((IPicHelper)QRoute.api(IPicHelper.class)).getBiggestFilePath((MessageForPic)localObject2);
      String str = FileManagerUtil.a((String)localObject3);
      int j = ((IPicUtil)QRoute.api(IPicUtil.class)).getImageType((String)localObject3);
      if (j == 1001) {
        localObject1 = ".png";
      } else if (j == 1005) {
        localObject1 = ".bmp";
      } else if (j == 2000) {
        localObject1 = ".gif";
      } else {
        localObject1 = ".jpg";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(e);
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startDrag orgPath= ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("  ,imageType=");
        localStringBuilder.append(j);
        localStringBuilder.append(",filePath=");
        localStringBuilder.append((String)localObject1);
        QLog.d("SystemDragUtils", 2, localStringBuilder.toString());
      }
      if ((((IPicHelper)QRoute.api(IPicHelper.class)).getBiggestFilePath((MessageForPic)localObject2) != null) && (FileUtils.copyFile(((IPicHelper)QRoute.api(IPicHelper.class)).getBiggestFilePath((MessageForPic)localObject2), (String)localObject1)))
      {
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        l = ((MessageForPic)localObject2).size;
        localObject2 = ((BasePicItemBuilder.Holder)paramViewHolder).a;
        paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        return null;
      }
    }
    else
    {
      if ((paramViewHolder instanceof ShortVideoItemBuilder.Holder))
      {
        localObject1 = (MessageForShortVideo)paramViewHolder.q;
        localObject2 = SVUtils.a((MessageForShortVideo)localObject1, "mp4");
        l = ((MessageForShortVideo)localObject1).videoFileSize;
        localObject1 = ((ShortVideoItemBuilder.Holder)paramViewHolder).a;
        paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject2;
      }
      for (;;)
      {
        break;
        if ((paramViewHolder instanceof ShortVideoRealItemBuilder.Holder))
        {
          localObject2 = (MessageForShortVideo)paramViewHolder.q;
          localObject1 = SVUtils.a((MessageForShortVideo)localObject2, "mp4");
          l = ((MessageForShortVideo)localObject2).videoFileSize;
          localObject2 = ((ShortVideoRealItemBuilder.Holder)paramViewHolder).a;
          paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          l = 0L;
          localObject1 = null;
          paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
        }
      }
    }
    if (TextUtils.isEmpty(paramViewHolder))
    {
      paramContext = new StringBuilder();
      paramContext.append("startDrag: no file ");
      paramContext.append(paramViewHolder);
      QLog.e("SystemDragUtils", 1, paramContext.toString());
      return null;
    }
    Object localObject2 = new File(paramViewHolder);
    if (!((File)localObject2).exists())
    {
      paramContext = new StringBuilder();
      paramContext.append("startDrag: no file ");
      paramContext.append(paramViewHolder);
      QLog.e("SystemDragUtils", 1, paramContext.toString());
      return null;
    }
    if (((File)localObject2).length() < l)
    {
      paramContext = new StringBuilder();
      paramContext.append("startDrag: Incomplete file ");
      paramContext.append(paramViewHolder);
      QLog.e("SystemDragUtils", 1, paramContext.toString());
      return null;
    }
    if (localObject1 == null)
    {
      QLog.e("SystemDragUtils", 1, "DragTrigger.onLongLongClick: dragView is null");
      return null;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Start drag, path=");
    ((StringBuilder)localObject3).append(paramViewHolder);
    QLog.d("SystemDragUtils", 1, ((StringBuilder)localObject3).toString());
    paramViewHolder = FileProvider.getUriForFile(paramContext, "com.tencent.mobileqq.fileprovider", (File)localObject2);
    localObject3 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject3).addCategory("android.intent.category.HOME");
    localObject3 = paramContext.getPackageManager().queryIntentActivities((Intent)localObject3, 65536).iterator();
    while (((Iterator)localObject3).hasNext()) {
      paramContext.grantUriPermission(((ResolveInfo)((Iterator)localObject3).next()).activityInfo.packageName, paramViewHolder, 3);
    }
    return new SystemDragUtils.DropItem((File)localObject2, (View)localObject1, ClipData.newUri(paramContext.getContentResolver(), "uri", paramViewHolder));
  }
  
  private static String b(Uri paramUri, Context paramContext)
  {
    Object localObject = null;
    if (paramUri == null) {
      return null;
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_display_name";
    paramContext = paramContext.getContentResolver().query(paramUri, arrayOfString, null, null, null);
    paramUri = localObject;
    if (paramContext != null)
    {
      paramContext.moveToFirst();
      paramUri = paramContext.getString(paramContext.getColumnIndex(arrayOfString[0]));
      paramContext.close();
    }
    return paramUri;
  }
  
  private static void b(ArrayList<String> paramArrayList, HashMap<Integer, SendVideoInfo> paramHashMap, Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (!paramHashMap.isEmpty()) {
      localIntent.putExtra("PhotoConst.VIDEO_INFOS", paramHashMap);
    }
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", paramArrayList.size());
    localIntent.putExtra("uin", paramSessionInfo.b);
    localIntent.putExtra("uintype", paramSessionInfo.a);
    localIntent.putExtra("troop_uin", paramSessionInfo.c);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.v);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", paramSessionInfo.s);
    if (paramArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList);
    }
    paramContext.startActivity(localIntent);
  }
  
  private static boolean b(DragEvent paramDragEvent, ImageView paramImageView, ColorDrawable paramColorDrawable1, ViewGroup paramViewGroup, ColorDrawable paramColorDrawable2, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject = paramDragEvent.getLocalState();
    int j = 0;
    if ((localObject != null) && ("QQ_AIO_DRAG".equals(paramDragEvent.getLocalState().toString())))
    {
      QLog.d("SystemDragUtils", 1, "local state is available");
      return false;
    }
    switch (paramDragEvent.getAction())
    {
    default: 
      return false;
    case 6: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_EXITED");
      paramImageView.setImageDrawable(paramColorDrawable1);
      return true;
    case 5: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_ENTERED");
      paramImageView.setImageDrawable(paramColorDrawable2);
      return true;
    case 4: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_ENDED");
      if (paramViewGroup.indexOfChild(paramImageView) != -1) {
        paramViewGroup.removeView(paramImageView);
      }
      return true;
    case 3: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DROP");
      if (paramViewGroup.indexOfChild(paramImageView) != -1) {
        paramViewGroup.removeView(paramImageView);
      }
      paramDragEvent = paramDragEvent.getClipData();
      if (paramDragEvent == null)
      {
        QLog.d("SystemDragUtils", 1, "drag clipData is null");
        return true;
      }
      paramImageView = paramDragEvent.getDescription();
      if (QLog.isColorLevel())
      {
        paramColorDrawable1 = new StringBuilder();
        paramColorDrawable1.append("drag description.description=");
        paramColorDrawable1.append(paramImageView.toString());
        QLog.d("SystemDragUtils", 2, paramColorDrawable1.toString());
      }
      int k = paramImageView.getMimeTypeCount();
      if (k == 0)
      {
        QLog.d("SystemDragUtils", 1, "drag description.mimetype is null");
        return true;
      }
      while (j < k)
      {
        paramColorDrawable1 = paramImageView.getMimeType(j).split("/");
        if ((paramColorDrawable1 != null) && (paramColorDrawable1.length != 0))
        {
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("drag description.mimetype=");
          paramViewGroup.append(Arrays.toString(paramColorDrawable1));
          QLog.d("SystemDragUtils", 2, paramViewGroup.toString());
        }
        else
        {
          QLog.d("SystemDragUtils", 1, "drag description.mimetype is null");
        }
        j += 1;
      }
      paramImageView = new ReportProgressDialog(paramContext, 2131953338);
      paramImageView.setCancelable(true);
      paramImageView.setContentView(2131625585);
      ((TextView)paramImageView.findViewById(2131440191)).setText(HardCodeUtil.a(2131912010));
      ThreadManager.executeOnFileThread(new SystemDragUtils.2(paramDragEvent, paramContext, paramQQAppInterface, paramSessionInfo, paramImageView));
    case 2: 
      return true;
    }
    QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_STARTED");
    paramImageView.setImageDrawable(paramColorDrawable1);
    if (paramViewGroup.indexOfChild(paramImageView) == -1) {
      paramViewGroup.addView(paramImageView, paramImageView.getLayoutParams());
    }
    return true;
  }
  
  private static boolean e()
  {
    if (g.booleanValue()) {
      return true;
    }
    int j = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (j > 28)
    {
      bool2 = bool1;
      if ("huawei".equalsIgnoreCase(Build.MANUFACTURER))
      {
        try
        {
          Method localMethod = Class.forName("com.huawei.android.pc.HwPCManagerEx").getDeclaredMethod("isInWindowsCastMode", new Class[0]);
          bool1 = bool3;
          if (localMethod != null) {
            bool1 = ((Boolean)localMethod.invoke(null, new Object[0])).booleanValue();
          }
        }
        catch (Exception localException)
        {
          QLog.e("SystemDragUtils", 1, "isInWindowsCastMode", localException);
          bool1 = bool3;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isInWindowsCastMode = ");
          localStringBuilder.append(bool1);
          QLog.e("SystemDragUtils", 2, localStringBuilder.toString());
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils
 * JD-Core Version:    0.7.0.1
 */