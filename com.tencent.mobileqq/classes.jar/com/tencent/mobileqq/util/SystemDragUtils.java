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
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import cooperation.peak.PeakUtils;
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
  public static int a;
  private static SystemDragUtils.TouchHandler jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler;
  private static final Boolean jdField_a_of_type_JavaLangBoolean;
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/SharedIn/";
  private static boolean jdField_a_of_type_Boolean;
  public static float b;
  private static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/SharedOut/";
  private static final String c = HardCodeUtil.a(2131714582);
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler = new SystemDragUtils.TouchHandler();
    jdField_a_of_type_Int = -1;
  }
  
  /* Error */
  private static File a(Context paramContext, java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: ifnull +182 -> 186
    //   7: sipush 8192
    //   10: newarray byte
    //   12: astore 7
    //   14: new 28	java/io/File
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 86	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_0
    //   31: invokevirtual 89	java/io/File:mkdir	()Z
    //   34: pop
    //   35: new 28	java/io/File
    //   38: dup
    //   39: aload_2
    //   40: aload_3
    //   41: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 86	java/io/File:exists	()Z
    //   51: ifeq +9 -> 60
    //   54: aload 5
    //   56: invokevirtual 95	java/io/File:delete	()Z
    //   59: pop
    //   60: new 97	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore_0
    //   70: aload_0
    //   71: astore_2
    //   72: aload_1
    //   73: aload 7
    //   75: invokevirtual 106	java/io/InputStream:read	([B)I
    //   78: istore 4
    //   80: iload 4
    //   82: iconst_m1
    //   83: if_icmpeq +46 -> 129
    //   86: aload_0
    //   87: astore_2
    //   88: aload_0
    //   89: aload 7
    //   91: iconst_0
    //   92: iload 4
    //   94: invokevirtual 112	java/io/OutputStream:write	([BII)V
    //   97: goto -27 -> 70
    //   100: astore_3
    //   101: aload 5
    //   103: astore_1
    //   104: aload_0
    //   105: astore_2
    //   106: ldc 114
    //   108: iconst_1
    //   109: ldc 116
    //   111: aload_3
    //   112: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_1
    //   116: astore_2
    //   117: aload_0
    //   118: ifnull +9 -> 127
    //   121: aload_0
    //   122: invokevirtual 125	java/io/OutputStream:close	()V
    //   125: aload_1
    //   126: astore_2
    //   127: aload_2
    //   128: areturn
    //   129: aload_0
    //   130: astore_2
    //   131: aload_0
    //   132: invokevirtual 128	java/io/OutputStream:flush	()V
    //   135: aload 5
    //   137: astore_2
    //   138: aload_0
    //   139: ifnull -12 -> 127
    //   142: aload_0
    //   143: invokevirtual 125	java/io/OutputStream:close	()V
    //   146: aload 5
    //   148: areturn
    //   149: astore_0
    //   150: aload 6
    //   152: astore_1
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 125	java/io/OutputStream:close	()V
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: aload_2
    //   165: astore_1
    //   166: goto -13 -> 153
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -70 -> 104
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_0
    //   180: aload 5
    //   182: astore_1
    //   183: goto -79 -> 104
    //   186: aconst_null
    //   187: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramContext	Context
    //   0	188	1	paramInputStream	java.io.InputStream
    //   0	188	2	paramString1	String
    //   0	188	3	paramString2	String
    //   78	15	4	i	int
    //   44	137	5	localFile	File
    //   1	150	6	localObject	Object
    //   12	78	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	80	100	java/io/IOException
    //   88	97	100	java/io/IOException
    //   131	135	100	java/io/IOException
    //   7	35	149	finally
    //   35	46	149	finally
    //   46	60	149	finally
    //   60	70	149	finally
    //   72	80	163	finally
    //   88	97	163	finally
    //   106	115	163	finally
    //   131	135	163	finally
    //   7	35	169	java/io/IOException
    //   35	46	169	java/io/IOException
    //   46	60	177	java/io/IOException
    //   60	70	177	java/io/IOException
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 5
    //   5: astore 4
    //   7: aload_1
    //   8: invokevirtual 136	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: aload_1
    //   19: invokevirtual 148	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   22: astore_1
    //   23: aload_1
    //   24: astore 4
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: aload_3
    //   30: invokestatic 150	com/tencent/mobileqq/util/SystemDragUtils:a	(Landroid/content/Context;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   33: invokevirtual 153	java/io/File:getPath	()Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: astore 4
    //   40: aload_1
    //   41: ifnull +10 -> 51
    //   44: aload_1
    //   45: invokevirtual 154	java/io/InputStream:close	()V
    //   48: aload_0
    //   49: astore 4
    //   51: aload 4
    //   53: areturn
    //   54: astore_1
    //   55: ldc 114
    //   57: iconst_1
    //   58: ldc 156
    //   60: aload_1
    //   61: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: astore 4
    //   72: aload_0
    //   73: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   76: aload 5
    //   78: astore 4
    //   80: aload_1
    //   81: ifnull -30 -> 51
    //   84: aload_1
    //   85: invokevirtual 154	java/io/InputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: ldc 114
    //   93: iconst_1
    //   94: ldc 156
    //   96: aload_0
    //   97: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: astore 4
    //   106: aload 4
    //   108: ifnull +8 -> 116
    //   111: aload 4
    //   113: invokevirtual 154	java/io/InputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: ldc 114
    //   121: iconst_1
    //   122: ldc 156
    //   124: aload_1
    //   125: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto -12 -> 116
    //   131: astore_0
    //   132: goto -26 -> 106
    //   135: astore_0
    //   136: goto -67 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramContext	Context
    //   0	139	1	paramUri	Uri
    //   0	139	2	paramString1	String
    //   0	139	3	paramString2	String
    //   5	107	4	localObject1	Object
    //   1	76	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	48	54	java/lang/Exception
    //   14	23	66	java/lang/Exception
    //   84	88	90	java/lang/Exception
    //   14	23	102	finally
    //   111	116	118	java/lang/Exception
    //   26	37	131	finally
    //   72	76	131	finally
    //   26	37	135	java/lang/Exception
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
    jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    paramDragTouchDelegate.a(paramOnLongClickAndTouchListener);
    paramDragTouchDelegate.a(new SystemDragUtils.3());
  }
  
  @RequiresApi(api=16)
  public static void a(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Context paramContext, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000) && (paramSessionInfo.jdField_a_of_type_Int != 0) && (!MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_Int)))
    {
      QLog.d("SystemDragUtils", 1, "unsupported UinType:" + paramSessionInfo.jdField_a_of_type_Int);
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
    if ((jdField_a_of_type_Int == -1) || (paramBoolean)) {
      if (!b()) {
        break label32;
      }
    }
    label32:
    for (int i = 1;; i = 0)
    {
      jdField_a_of_type_Int = i;
      if (jdField_a_of_type_Int != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static SystemDragUtils.DropItem b(Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    long l = 0L;
    Object localObject1;
    if ((paramViewHolder instanceof QFileSimpleItemBuilder.FileHolder))
    {
      localObject1 = QFileUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      l = FileUtils.a((String)localObject1);
      paramViewHolder = paramViewHolder.jdField_a_of_type_AndroidViewView;
    }
    for (;;)
    {
      label76:
      Object localObject2;
      Object localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("SystemDragUtils", 1, "startDrag: no file " + (String)localObject1);
        return null;
        if ((paramViewHolder instanceof QFileImageItemBuilder.FileHolder))
        {
          localObject1 = QFileUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          l = FileUtils.a((String)localObject1);
          paramViewHolder = ((QFileImageItemBuilder.FileHolder)paramViewHolder).a;
          continue;
        }
        if ((paramViewHolder instanceof QFileVideoItemBuilder.FileHolder))
        {
          localObject1 = QFileUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          l = FileUtils.a((String)localObject1);
          paramViewHolder = ((QFileVideoItemBuilder.FileHolder)paramViewHolder).a;
          continue;
        }
        if ((paramViewHolder instanceof BasePicItemBuilder.Holder))
        {
          localObject2 = (MessageForPic)paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject3 = ((MessageForPic)localObject2).getBiggestFilePath();
          String str = FileManagerUtil.a((String)localObject3);
          int i = PeakUtils.a((String)localObject3);
          localObject1 = ".jpg";
          if (i == 1001) {
            localObject1 = ".png";
          }
          for (;;)
          {
            localObject1 = b + str + (String)localObject1;
            if (QLog.isColorLevel()) {
              QLog.d("SystemDragUtils", 2, "startDrag orgPath= " + (String)localObject3 + "  ,imageType=" + i + ",filePath=" + (String)localObject1);
            }
            if ((((MessageForPic)localObject2).getBiggestFilePath() == null) || (!FileUtils.d(((MessageForPic)localObject2).getBiggestFilePath(), (String)localObject1)) || (TextUtils.isEmpty(str))) {
              break label76;
            }
            l = ((MessageForPic)localObject2).size;
            paramViewHolder = ((BasePicItemBuilder.Holder)paramViewHolder).a;
            break;
            if (i == 1005) {
              localObject1 = ".bmp";
            } else if (i == 2000) {
              localObject1 = ".gif";
            }
          }
        }
        if ((paramViewHolder instanceof ShortVideoItemBuilder.Holder))
        {
          localObject2 = (MessageForShortVideo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject1 = ShortVideoUtils.getShortVideoSavePath((MessageForShortVideo)localObject2, "mp4");
          l = ((MessageForShortVideo)localObject2).videoFileSize;
          paramViewHolder = ((ShortVideoItemBuilder.Holder)paramViewHolder).a;
          continue;
        }
        if ((paramViewHolder instanceof ShortVideoRealItemBuilder.Holder))
        {
          localObject2 = (MessageForShortVideo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject1 = ShortVideoUtils.getShortVideoSavePath((MessageForShortVideo)localObject2, "mp4");
          l = ((MessageForShortVideo)localObject2).videoFileSize;
          paramViewHolder = ((ShortVideoRealItemBuilder.Holder)paramViewHolder).a;
        }
      }
      else
      {
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          QLog.e("SystemDragUtils", 1, "startDrag: no file " + (String)localObject1);
          return null;
        }
        if (((File)localObject2).length() < l)
        {
          QLog.e("SystemDragUtils", 1, "startDrag: Incomplete file " + (String)localObject1);
          return null;
        }
        if (paramViewHolder == null)
        {
          QLog.e("SystemDragUtils", 1, "DragTrigger.onLongLongClick: dragView is null");
          return null;
        }
        QLog.d("SystemDragUtils", 1, "Start drag, path=" + (String)localObject1);
        localObject1 = FileProvider.getUriForFile(paramContext, "com.tencent.mobileqq.fileprovider", (File)localObject2);
        localObject3 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject3).addCategory("android.intent.category.HOME");
        localObject3 = paramContext.getPackageManager().queryIntentActivities((Intent)localObject3, 65536).iterator();
        while (((Iterator)localObject3).hasNext()) {
          paramContext.grantUriPermission(((ResolveInfo)((Iterator)localObject3).next()).activityInfo.packageName, (Uri)localObject1, 3);
        }
        return new SystemDragUtils.DropItem((File)localObject2, paramViewHolder, ClipData.newUri(paramContext.getContentResolver(), "uri", (Uri)localObject1));
      }
      paramViewHolder = null;
      localObject1 = null;
    }
  }
  
  private static String b(Uri paramUri, Context paramContext)
  {
    if (paramUri == null) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = new String[1];
      arrayOfString[0] = "_display_name";
      paramUri = paramContext.getContentResolver().query(paramUri, arrayOfString, null, null, null);
    } while (paramUri == null);
    paramUri.moveToFirst();
    paramContext = paramUri.getString(paramUri.getColumnIndex(arrayOfString[0]));
    paramUri.close();
    return paramContext;
  }
  
  private static void b(ArrayList<String> paramArrayList, HashMap<Integer, SendVideoActivity.SendVideoInfo> paramHashMap, Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (!paramHashMap.isEmpty()) {
      localIntent.putExtra("PhotoConst.VIDEO_INFOS", paramHashMap);
    }
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", paramArrayList.size());
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramSessionInfo.b);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.e);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", paramSessionInfo.c);
    if (paramArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList);
    }
    paramContext.startActivity(localIntent);
  }
  
  private static boolean b()
  {
    boolean bool2;
    if (jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      bool2 = true;
    }
    do
    {
      return bool2;
      if ((Build.VERSION.SDK_INT <= 28) || (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {
        break label122;
      }
      try
      {
        Method localMethod = Class.forName("com.huawei.android.pc.HwPCManagerEx").getDeclaredMethod("isInWindowsCastMode", new Class[0]);
        if (localMethod == null) {
          break;
        }
        bool1 = ((Boolean)localMethod.invoke(null, new Object[0])).booleanValue();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("SystemDragUtils", 1, "isInWindowsCastMode", localException);
          boolean bool1 = false;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.e("SystemDragUtils", 2, "isInWindowsCastMode = " + bool1);
    return bool1;
    label122:
    return false;
  }
  
  private static boolean b(DragEvent paramDragEvent, ImageView paramImageView, ColorDrawable paramColorDrawable1, ViewGroup paramViewGroup, ColorDrawable paramColorDrawable2, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramDragEvent.getLocalState() != null) && ("QQ_AIO_DRAG".equals(paramDragEvent.getLocalState().toString())))
    {
      QLog.d("SystemDragUtils", 1, "local state is available");
      return false;
    }
    switch (paramDragEvent.getAction())
    {
    default: 
      return false;
    case 1: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_STARTED");
      paramImageView.setImageDrawable(paramColorDrawable1);
      if (paramViewGroup.indexOfChild(paramImageView) == -1) {
        paramViewGroup.addView(paramImageView, paramImageView.getLayoutParams());
      }
      return true;
    case 4: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_ENDED");
      if (paramViewGroup.indexOfChild(paramImageView) != -1) {
        paramViewGroup.removeView(paramImageView);
      }
      return true;
    case 2: 
      return true;
    case 5: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_ENTERED");
      paramImageView.setImageDrawable(paramColorDrawable2);
      return true;
    case 6: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_EXITED");
      paramImageView.setImageDrawable(paramColorDrawable1);
      return true;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("SystemDragUtils", 2, "drag description.description=" + paramImageView.toString());
    }
    int j = paramImageView.getMimeTypeCount();
    if (j == 0)
    {
      QLog.d("SystemDragUtils", 1, "drag description.mimetype is null");
      return true;
    }
    int i = 0;
    if (i < j)
    {
      paramColorDrawable1 = paramImageView.getMimeType(i).split("/");
      if ((paramColorDrawable1 == null) || (paramColorDrawable1.length == 0)) {
        QLog.d("SystemDragUtils", 1, "drag description.mimetype is null");
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.d("SystemDragUtils", 2, "drag description.mimetype=" + Arrays.toString(paramColorDrawable1));
      }
    }
    paramImageView = new ReportProgressDialog(paramContext, 2131755842);
    paramImageView.setCancelable(true);
    paramImageView.setContentView(2131559683);
    ((TextView)paramImageView.findViewById(2131373066)).setText(HardCodeUtil.a(2131714581));
    ThreadManager.executeOnFileThread(new SystemDragUtils.2(paramDragEvent, paramContext, paramQQAppInterface, paramSessionInfo, paramImageView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils
 * JD-Core Version:    0.7.0.1
 */