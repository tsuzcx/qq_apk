package com.tencent.mobileqq.resourcesgrab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qflutter.resource_loader.NinePatchChunk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinData;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import rx.Observable;
import rx.schedulers.Schedulers;

class ResourceGrabRepository
  extends BaseRepository
{
  private SparseArray<String> a = new SparseArray();
  private SparseArray<String> b = new SparseArray();
  
  private Bitmap a(Bitmap paramBitmap, String paramString)
  {
    if ((paramString.endsWith(".9.png")) && (NinePatch.isNinePatchChunk(paramBitmap.getNinePatchChunk())))
    {
      paramString = NinePatchChunk.deserialize(paramBitmap.getNinePatchChunk());
      if (paramString != null)
      {
        int j = paramBitmap.getWidth() + 2;
        int k = paramBitmap.getHeight() + 2;
        Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.translate(1.0F, 1.0F);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
        int m = paramString.mPaddings.left;
        int n = paramString.mPaddings.right;
        int i1 = paramString.mPaddings.top;
        int i2 = paramString.mPaddings.bottom;
        int i = 1;
        while (i < Math.max(k, j) - 1)
        {
          if (a(paramString, i, true)) {
            localBitmap.setPixel(i, 0, -16777216);
          }
          if ((i > m) && (i < j - 1 - n)) {
            localBitmap.setPixel(i, k - 1, -16777216);
          }
          if (a(paramString, i, false)) {
            localBitmap.setPixel(0, i, -16777216);
          }
          if ((i > i1) && (i < k - 1 - i2)) {
            localBitmap.setPixel(j - 1, i, -16777216);
          }
          i += 1;
        }
        return localBitmap;
      }
    }
    return paramBitmap;
  }
  
  private Bitmap a(ResourceGrabSkinData paramResourceGrabSkinData)
  {
    if (paramResourceGrabSkinData != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inScaled = false;
      if ((!ThemeUtil.isDefaultTheme()) && (!TextUtils.isEmpty(paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFilePath)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabModel", 2, "get theme package resource");
        }
        return BitmapFactory.decodeFile(paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFilePath, localOptions);
      }
      paramResourceGrabSkinData = paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName.substring(0, paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName.indexOf("."));
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      String str = localBaseApplication.getPackageName();
      int i = localBaseApplication.getResources().getIdentifier(paramResourceGrabSkinData, "drawable", str);
      if (i > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabModel", 2, "get system resource");
        }
        return BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), i, localOptions);
      }
    }
    return null;
  }
  
  private File a(String paramString)
  {
    File localFile = BaseApplicationImpl.getContext().getExternalCacheDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bitmapResource/");
    localStringBuilder.append(paramString);
    return new File(localFile, localStringBuilder.toString());
  }
  
  private void a(ResourceGrabSkinData paramResourceGrabSkinData, HashSet<String> paramHashSet)
  {
    if (paramResourceGrabSkinData.jdField_a_of_type_Int == 3)
    {
      b(paramResourceGrabSkinData, paramHashSet);
      return;
    }
    c(paramResourceGrabSkinData, paramHashSet);
  }
  
  /* Error */
  private void a(String paramString1, HashSet<String> paramHashSet, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +243 -> 247
    //   7: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +38 -> 48
    //   13: new 216	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 249
    //   26: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 151
    //   39: iconst_2
    //   40: aload 4
    //   42: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: aload_3
    //   50: invokespecial 251	com/tencent/mobileqq/resourcesgrab/ResourceGrabRepository:b	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore 5
    //   55: aload_2
    //   56: aload 5
    //   58: invokevirtual 254	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: invokevirtual 260	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: aconst_null
    //   66: astore 4
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: aload 5
    //   74: invokevirtual 263	java/io/File:exists	()Z
    //   77: ifne +35 -> 112
    //   80: aload_3
    //   81: astore_2
    //   82: aload 5
    //   84: invokevirtual 266	java/io/File:getParentFile	()Ljava/io/File;
    //   87: invokevirtual 263	java/io/File:exists	()Z
    //   90: ifne +14 -> 104
    //   93: aload_3
    //   94: astore_2
    //   95: aload 5
    //   97: invokevirtual 266	java/io/File:getParentFile	()Ljava/io/File;
    //   100: invokevirtual 269	java/io/File:mkdir	()Z
    //   103: pop
    //   104: aload_3
    //   105: astore_2
    //   106: aload 5
    //   108: invokevirtual 272	java/io/File:createNewFile	()Z
    //   111: pop
    //   112: aload_3
    //   113: astore_2
    //   114: new 274	java/io/OutputStreamWriter
    //   117: dup
    //   118: new 276	java/io/FileOutputStream
    //   121: dup
    //   122: aload 5
    //   124: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: ldc_w 281
    //   130: invokespecial 284	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   133: astore_3
    //   134: aload_3
    //   135: aload_1
    //   136: invokevirtual 288	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   139: aload_3
    //   140: invokevirtual 291	java/io/OutputStreamWriter:flush	()V
    //   143: aload_3
    //   144: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   147: aload_3
    //   148: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   151: return
    //   152: astore_1
    //   153: ldc 151
    //   155: iconst_1
    //   156: aload_1
    //   157: iconst_0
    //   158: anewarray 296	java/lang/Object
    //   161: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   164: return
    //   165: astore_1
    //   166: aload_3
    //   167: astore_2
    //   168: goto +54 -> 222
    //   171: astore_2
    //   172: aload_3
    //   173: astore_1
    //   174: aload_2
    //   175: astore_3
    //   176: goto +11 -> 187
    //   179: astore_1
    //   180: goto +42 -> 222
    //   183: astore_3
    //   184: aload 4
    //   186: astore_1
    //   187: aload_1
    //   188: astore_2
    //   189: ldc 151
    //   191: iconst_1
    //   192: aload_3
    //   193: iconst_0
    //   194: anewarray 296	java/lang/Object
    //   197: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   200: aload_1
    //   201: ifnull +46 -> 247
    //   204: aload_1
    //   205: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   208: return
    //   209: astore_1
    //   210: ldc 151
    //   212: iconst_1
    //   213: aload_1
    //   214: iconst_0
    //   215: anewarray 296	java/lang/Object
    //   218: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   221: return
    //   222: aload_2
    //   223: ifnull +22 -> 245
    //   226: aload_2
    //   227: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   230: goto +15 -> 245
    //   233: astore_2
    //   234: ldc 151
    //   236: iconst_1
    //   237: aload_2
    //   238: iconst_0
    //   239: anewarray 296	java/lang/Object
    //   242: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   245: aload_1
    //   246: athrow
    //   247: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	ResourceGrabRepository
    //   0	248	1	paramString1	String
    //   0	248	2	paramHashSet	HashSet<String>
    //   0	248	3	paramString2	String
    //   20	165	4	localStringBuilder	StringBuilder
    //   53	70	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   147	151	152	java/lang/Exception
    //   134	147	165	finally
    //   134	147	171	java/lang/Exception
    //   72	80	179	finally
    //   82	93	179	finally
    //   95	104	179	finally
    //   106	112	179	finally
    //   114	134	179	finally
    //   189	200	179	finally
    //   72	80	183	java/lang/Exception
    //   82	93	183	java/lang/Exception
    //   95	104	183	java/lang/Exception
    //   106	112	183	java/lang/Exception
    //   114	134	183	java/lang/Exception
    //   204	208	209	java/lang/Exception
    //   226	230	233	java/lang/Exception
  }
  
  private boolean a(NinePatchChunk paramNinePatchChunk, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramNinePatchChunk = paramNinePatchChunk.mDivX;
    } else {
      paramNinePatchChunk = paramNinePatchChunk.mDivY;
    }
    if ((paramNinePatchChunk != null) && (paramNinePatchChunk.length > 0))
    {
      int i = 0;
      while (i < paramNinePatchChunk.length - 1)
      {
        if ((paramInt > paramNinePatchChunk[i]) && (paramInt <= paramNinePatchChunk[(i + 1)])) {
          return true;
        }
        i += 2;
      }
    }
    return false;
  }
  
  private File b(String paramString)
  {
    File localFile = BaseApplicationImpl.getContext().getExternalCacheDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xmlResource/");
    localStringBuilder.append(paramString);
    return new File(localFile, localStringBuilder.toString());
  }
  
  private void b(ResourceGrabSkinData paramResourceGrabSkinData, HashSet<String> paramHashSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramResourceGrabSkinData.jdField_a_of_type_Array2dOfInt != null) && (paramResourceGrabSkinData.jdField_a_of_type_ArrayOfInt != null) && (paramResourceGrabSkinData.jdField_a_of_type_Array2dOfInt.length == paramResourceGrabSkinData.jdField_a_of_type_ArrayOfInt.length))
    {
      localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      localStringBuilder.append("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n");
      int i = 0;
      while (i < paramResourceGrabSkinData.jdField_a_of_type_ArrayOfInt.length)
      {
        localStringBuilder.append("    <item ");
        int j = 0;
        while (j < paramResourceGrabSkinData.jdField_a_of_type_Array2dOfInt[i].length)
        {
          int k = paramResourceGrabSkinData.jdField_a_of_type_Array2dOfInt[i][j];
          String str = (String)this.a.get(k);
          if (!TextUtils.isEmpty(str))
          {
            localStringBuilder.append(str);
            localStringBuilder.append(" ");
          }
          j += 1;
        }
        j = paramResourceGrabSkinData.jdField_a_of_type_ArrayOfInt[i];
        localStringBuilder.append("android:color=\"");
        localStringBuilder.append("#");
        localStringBuilder.append(Integer.toHexString(j).toUpperCase());
        localStringBuilder.append("\"");
        localStringBuilder.append(" />\n");
        i += 1;
      }
      localStringBuilder.append("</selector>");
    }
    a(localStringBuilder.toString(), paramHashSet, paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
  }
  
  private void c(ResourceGrabSkinData paramResourceGrabSkinData, HashSet<String> paramHashSet)
  {
    Bitmap localBitmap = a(paramResourceGrabSkinData);
    if (localBitmap != null)
    {
      localBitmap = a(localBitmap, paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      paramResourceGrabSkinData = a(paramResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      paramHashSet.add(paramResourceGrabSkinData.getAbsolutePath());
      try
      {
        if (!paramResourceGrabSkinData.exists())
        {
          if (!paramResourceGrabSkinData.getParentFile().exists()) {
            paramResourceGrabSkinData.getParentFile().mkdir();
          }
          paramResourceGrabSkinData.createNewFile();
        }
        paramResourceGrabSkinData = new FileOutputStream(paramResourceGrabSkinData);
        localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramResourceGrabSkinData);
        paramResourceGrabSkinData.flush();
        paramResourceGrabSkinData.close();
        return;
      }
      catch (Exception paramResourceGrabSkinData)
      {
        QLog.d("ResourceGrabModel", 1, paramResourceGrabSkinData, new Object[0]);
      }
    }
  }
  
  String a(int paramInt)
  {
    String str2 = (String)this.b.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = String.valueOf(paramInt);
    }
    return str1;
  }
  
  void a()
  {
    this.a.put(16842909, "android:state_window_focused=\"true\"");
    this.a.put(-16842909, "android:state_window_focused=\"false\"");
    this.a.put(16842913, "android:state_selected=\"true\"");
    this.a.put(-16842913, "android:state_selected=\"false\"");
    this.a.put(16842908, "android:state_focused=\"true\"");
    this.a.put(-16842908, "android:state_focused=\"false\"");
    this.a.put(16842910, "android:state_enabled=\"true\"");
    this.a.put(-16842910, "android:state_enabled=\"false\"");
    this.a.put(16842919, "android:state_pressed=\"true\"");
    this.a.put(-16842919, "android:state_pressed=\"false\"");
    this.a.put(16842912, "android:state_checked=\"true\"");
    this.a.put(-16842912, "android:state_checked=\"false\"");
    this.a.put(16843518, "android:state_activated=\"true\"");
    this.a.put(-16843518, "android:state_activated=\"false\"");
    this.a.put(16843547, "android:state_accelerated=\"true\"");
    this.a.put(-16843547, "android:state_accelerated=\"false\"");
    this.a.put(16843623, "android:state_hovered=\"true\"");
    this.a.put(-16843623, "android:state_hovered=\"false\"");
    this.a.put(16843624, "android:state_drag_can_accept=\"true\"");
    this.a.put(-16843624, "android:state_drag_can_accept=\"false\"");
    this.a.put(16843625, "android:state_drag_hovered=\"true\"");
    this.a.put(-16843625, "android:state_drag_hovered=\"false\"");
    this.b.put(0, "background");
    this.b.put(1, "image_drawable");
    this.b.put(2, "compound_drawables");
    this.b.put(3, "text_color");
  }
  
  void a(List<ResourceGrabSkinData> paramList, ResourceGrabRepository.OnFileSaveCompleteCallback paramOnFileSaveCompleteCallback)
  {
    if (!paramList.isEmpty())
    {
      HashSet localHashSet = new HashSet();
      Observable.from(paramList).distinct(new ResourceGrabRepository.4(this)).subscribeOn(Schedulers.io()).subscribe(new ResourceGrabRepository.1(this, localHashSet), new ResourceGrabRepository.2(this), new ResourceGrabRepository.3(this, paramOnFileSaveCompleteCallback, localHashSet));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabRepository
 * JD-Core Version:    0.7.0.1
 */