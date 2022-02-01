package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.File;
import java.lang.ref.WeakReference;

public class SkinDrawable
{
  private final Object a = new Object();
  private TypedValue b = new TypedValue();
  protected String c = "";
  protected volatile boolean d = false;
  protected volatile boolean e = true;
  protected WeakReference<SkinDrawable.IVasSkinChangeCallback> f;
  
  private TypedValue a()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.b != null)
        {
          TypedValue localTypedValue = this.b;
          this.b = null;
          if (localTypedValue == null) {
            return new TypedValue();
          }
          return localTypedValue;
        }
      }
      Object localObject2 = null;
    }
  }
  
  private Object a(String paramString)
  {
    paramString = (Pair)GlobalImageCache.a.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.first;
  }
  
  private void a(TypedValue paramTypedValue)
  {
    synchronized (this.a)
    {
      if (this.b == null) {
        this.b = paramTypedValue;
      }
      return;
    }
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
        return;
      }
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingLeft();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingBottom();
      paramView.setBackgroundDrawable(paramDrawable);
      paramView.setPadding(j, i, k, m);
    }
  }
  
  private void a(String paramString, ColorStateList paramColorStateList)
  {
    GlobalImageCache.a.put(paramString, new Pair(paramColorStateList, Integer.valueOf(100)));
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicHeight();
    int j = paramDrawable.getIntrinsicWidth();
    GlobalImageCache.a.put(paramString, new Pair(paramDrawable, Integer.valueOf(i * j * 4)));
  }
  
  /* Error */
  protected Drawable a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 111	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:du_	()Z
    //   4: ifeq +396 -> 400
    //   7: aload_0
    //   8: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   11: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +383 -> 400
    //   20: new 119	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_0
    //   30: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   33: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: iload_2
    //   39: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_0
    //   44: aload_3
    //   45: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 133	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +15 -> 68
    //   56: aload_3
    //   57: instanceof 96
    //   60: ifeq +8 -> 68
    //   63: aload_3
    //   64: checkcast 96	android/graphics/drawable/Drawable
    //   67: areturn
    //   68: aload_0
    //   69: invokespecial 135	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   72: astore 5
    //   74: aload_1
    //   75: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   78: iload_2
    //   79: aload 5
    //   81: iconst_1
    //   82: invokevirtual 147	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   85: aload 5
    //   87: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   90: checkcast 153	java/lang/String
    //   93: astore 6
    //   95: aload_0
    //   96: aload 5
    //   98: invokespecial 155	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   101: aload 6
    //   103: ifnull +288 -> 391
    //   106: new 119	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   113: astore_3
    //   114: aload_3
    //   115: aload_0
    //   116: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   119: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: ldc 157
    //   126: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: aload 6
    //   133: aload 6
    //   135: ldc 159
    //   137: invokevirtual 163	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   140: iconst_1
    //   141: iadd
    //   142: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new 169	java/io/File
    //   152: dup
    //   153: aload_3
    //   154: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 175	java/io/File:exists	()Z
    //   165: ifeq +226 -> 391
    //   168: new 177	android/graphics/Rect
    //   171: dup
    //   172: invokespecial 178	android/graphics/Rect:<init>	()V
    //   175: astore 7
    //   177: aload 5
    //   179: sipush 480
    //   182: putfield 182	android/util/TypedValue:density	I
    //   185: new 184	java/io/BufferedInputStream
    //   188: dup
    //   189: new 186	java/io/FileInputStream
    //   192: dup
    //   193: aload_3
    //   194: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   200: astore 4
    //   202: aload 4
    //   204: astore_3
    //   205: aload_1
    //   206: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   209: aload 5
    //   211: aload 4
    //   213: aload 6
    //   215: aconst_null
    //   216: aload 7
    //   218: iconst_1
    //   219: invokestatic 198	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   222: aload_1
    //   223: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   226: invokevirtual 204	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   229: astore 5
    //   231: aload 4
    //   233: astore_3
    //   234: new 119	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   241: astore 6
    //   243: aload 4
    //   245: astore_3
    //   246: aload 6
    //   248: aload_0
    //   249: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   252: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 4
    //   258: astore_3
    //   259: aload 6
    //   261: iload_2
    //   262: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: astore_3
    //   269: aload_0
    //   270: aload 6
    //   272: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload 5
    //   277: invokespecial 206	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   280: aload 4
    //   282: invokevirtual 211	java/io/InputStream:close	()V
    //   285: aload 5
    //   287: areturn
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   293: aload 5
    //   295: areturn
    //   296: astore 5
    //   298: goto +19 -> 317
    //   301: astore 5
    //   303: goto +40 -> 343
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_3
    //   309: goto +64 -> 373
    //   312: astore 5
    //   314: aconst_null
    //   315: astore 4
    //   317: aload 4
    //   319: astore_3
    //   320: aload 5
    //   322: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   325: aload 4
    //   327: ifnull +64 -> 391
    //   330: aload 4
    //   332: invokevirtual 211	java/io/InputStream:close	()V
    //   335: goto +56 -> 391
    //   338: astore 5
    //   340: aconst_null
    //   341: astore 4
    //   343: aload 4
    //   345: astore_3
    //   346: aload 5
    //   348: invokevirtual 215	java/lang/OutOfMemoryError:printStackTrace	()V
    //   351: aload 4
    //   353: ifnull +38 -> 391
    //   356: aload 4
    //   358: invokevirtual 211	java/io/InputStream:close	()V
    //   361: goto +30 -> 391
    //   364: astore_3
    //   365: aload_3
    //   366: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   369: goto +22 -> 391
    //   372: astore_1
    //   373: aload_3
    //   374: ifnull +15 -> 389
    //   377: aload_3
    //   378: invokevirtual 211	java/io/InputStream:close	()V
    //   381: goto +8 -> 389
    //   384: astore_3
    //   385: aload_3
    //   386: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   389: aload_1
    //   390: athrow
    //   391: aload_1
    //   392: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   395: iload_2
    //   396: invokevirtual 219	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   399: areturn
    //   400: aload_1
    //   401: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   404: iload_2
    //   405: invokevirtual 219	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   408: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	SkinDrawable
    //   0	409	1	paramContext	Context
    //   0	409	2	paramInt	int
    //   27	319	3	localObject1	Object
    //   364	14	3	localIOException1	java.io.IOException
    //   384	2	3	localIOException2	java.io.IOException
    //   200	157	4	localBufferedInputStream	java.io.BufferedInputStream
    //   72	222	5	localObject2	Object
    //   296	1	5	localIOException3	java.io.IOException
    //   301	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   312	9	5	localIOException4	java.io.IOException
    //   338	9	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   93	178	6	localObject3	Object
    //   175	42	7	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   280	285	288	java/io/IOException
    //   205	231	296	java/io/IOException
    //   234	243	296	java/io/IOException
    //   246	256	296	java/io/IOException
    //   259	266	296	java/io/IOException
    //   269	280	296	java/io/IOException
    //   205	231	301	java/lang/OutOfMemoryError
    //   234	243	301	java/lang/OutOfMemoryError
    //   246	256	301	java/lang/OutOfMemoryError
    //   259	266	301	java/lang/OutOfMemoryError
    //   269	280	301	java/lang/OutOfMemoryError
    //   185	202	306	finally
    //   185	202	312	java/io/IOException
    //   185	202	338	java/lang/OutOfMemoryError
    //   330	335	364	java/io/IOException
    //   356	361	364	java/io/IOException
    //   205	231	372	finally
    //   234	243	372	finally
    //   246	256	372	finally
    //   259	266	372	finally
    //   269	280	372	finally
    //   320	325	372	finally
    //   346	351	372	finally
    //   377	381	384	java/io/IOException
  }
  
  /* Error */
  protected Drawable a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 111	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:du_	()Z
    //   4: ifeq +419 -> 423
    //   7: aload_0
    //   8: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   11: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +406 -> 423
    //   20: new 119	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   35: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: iload_2
    //   42: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_0
    //   47: aload 4
    //   49: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 133	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +17 -> 76
    //   62: aload 4
    //   64: instanceof 96
    //   67: ifeq +9 -> 76
    //   70: aload 4
    //   72: checkcast 96	android/graphics/drawable/Drawable
    //   75: areturn
    //   76: aload_0
    //   77: invokespecial 135	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   80: astore 5
    //   82: aload_1
    //   83: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   86: iload_2
    //   87: aload 5
    //   89: iconst_1
    //   90: invokevirtual 147	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   93: aload 5
    //   95: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   98: checkcast 153	java/lang/String
    //   101: astore 6
    //   103: aload_0
    //   104: aload 5
    //   106: invokespecial 155	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   109: aload 6
    //   111: ifnull +303 -> 414
    //   114: new 119	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: aload_0
    //   126: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   129: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: ldc 159
    //   137: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: aload_3
    //   144: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 169	java/io/File
    //   151: dup
    //   152: aload 4
    //   154: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 175	java/io/File:exists	()Z
    //   165: ifeq +249 -> 414
    //   168: new 177	android/graphics/Rect
    //   171: dup
    //   172: invokespecial 178	android/graphics/Rect:<init>	()V
    //   175: astore 7
    //   177: new 184	java/io/BufferedInputStream
    //   180: dup
    //   181: new 186	java/io/FileInputStream
    //   184: dup
    //   185: aload_3
    //   186: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   189: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: aload 5
    //   199: sipush 480
    //   202: putfield 182	android/util/TypedValue:density	I
    //   205: aload 4
    //   207: astore_3
    //   208: aload_1
    //   209: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   212: aload 5
    //   214: aload 4
    //   216: aload 6
    //   218: aconst_null
    //   219: aload 7
    //   221: iconst_1
    //   222: invokestatic 198	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   225: astore 5
    //   227: aload 5
    //   229: ifnull +82 -> 311
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: aload_1
    //   238: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   241: invokevirtual 204	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   244: astore 5
    //   246: aload 4
    //   248: astore_3
    //   249: new 119	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   256: astore 6
    //   258: aload 4
    //   260: astore_3
    //   261: aload 6
    //   263: aload_0
    //   264: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   267: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 4
    //   273: astore_3
    //   274: aload 6
    //   276: iload_2
    //   277: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 4
    //   283: astore_3
    //   284: aload_0
    //   285: aload 6
    //   287: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: aload 5
    //   292: invokespecial 206	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   295: aload 4
    //   297: invokevirtual 211	java/io/InputStream:close	()V
    //   300: aload 5
    //   302: areturn
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   308: aload 5
    //   310: areturn
    //   311: aload 4
    //   313: invokevirtual 211	java/io/InputStream:close	()V
    //   316: goto +98 -> 414
    //   319: astore 5
    //   321: goto +19 -> 340
    //   324: astore 5
    //   326: goto +40 -> 366
    //   329: astore_1
    //   330: aconst_null
    //   331: astore_3
    //   332: goto +64 -> 396
    //   335: astore 5
    //   337: aconst_null
    //   338: astore 4
    //   340: aload 4
    //   342: astore_3
    //   343: aload 5
    //   345: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   348: aload 4
    //   350: ifnull +64 -> 414
    //   353: aload 4
    //   355: invokevirtual 211	java/io/InputStream:close	()V
    //   358: goto +56 -> 414
    //   361: astore 5
    //   363: aconst_null
    //   364: astore 4
    //   366: aload 4
    //   368: astore_3
    //   369: aload 5
    //   371: invokevirtual 215	java/lang/OutOfMemoryError:printStackTrace	()V
    //   374: aload 4
    //   376: ifnull +38 -> 414
    //   379: aload 4
    //   381: invokevirtual 211	java/io/InputStream:close	()V
    //   384: goto +30 -> 414
    //   387: astore_3
    //   388: aload_3
    //   389: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   392: goto +22 -> 414
    //   395: astore_1
    //   396: aload_3
    //   397: ifnull +15 -> 412
    //   400: aload_3
    //   401: invokevirtual 211	java/io/InputStream:close	()V
    //   404: goto +8 -> 412
    //   407: astore_3
    //   408: aload_3
    //   409: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   412: aload_1
    //   413: athrow
    //   414: aload_1
    //   415: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   418: iload_2
    //   419: invokevirtual 219	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   422: areturn
    //   423: aload_1
    //   424: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   427: iload_2
    //   428: invokevirtual 219	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   431: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	SkinDrawable
    //   0	432	1	paramContext	Context
    //   0	432	2	paramInt	int
    //   0	432	3	paramString	String
    //   27	353	4	localObject1	Object
    //   80	229	5	localObject2	Object
    //   319	1	5	localIOException1	java.io.IOException
    //   324	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   335	9	5	localIOException2	java.io.IOException
    //   361	9	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   101	185	6	localObject3	Object
    //   175	45	7	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   295	300	303	java/io/IOException
    //   197	205	319	java/io/IOException
    //   208	227	319	java/io/IOException
    //   235	246	319	java/io/IOException
    //   249	258	319	java/io/IOException
    //   261	271	319	java/io/IOException
    //   274	281	319	java/io/IOException
    //   284	295	319	java/io/IOException
    //   197	205	324	java/lang/OutOfMemoryError
    //   208	227	324	java/lang/OutOfMemoryError
    //   235	246	324	java/lang/OutOfMemoryError
    //   249	258	324	java/lang/OutOfMemoryError
    //   261	271	324	java/lang/OutOfMemoryError
    //   274	281	324	java/lang/OutOfMemoryError
    //   284	295	324	java/lang/OutOfMemoryError
    //   177	194	329	finally
    //   177	194	335	java/io/IOException
    //   177	194	361	java/lang/OutOfMemoryError
    //   311	316	387	java/io/IOException
    //   353	358	387	java/io/IOException
    //   379	384	387	java/io/IOException
    //   197	205	395	finally
    //   208	227	395	finally
    //   235	246	395	finally
    //   249	258	395	finally
    //   261	271	395	finally
    //   274	281	395	finally
    //   284	295	395	finally
    //   343	348	395	finally
    //   369	374	395	finally
    //   400	404	407	java/io/IOException
  }
  
  public StateListDrawable a(Context paramContext, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = a(paramContext, paramInt1);
    paramContext = a(paramContext, paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[] { 16842919 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof TextView))
    {
      ((TextView)localView).setTextColor(c(paramView.getContext(), paramInt2));
      return;
    }
    if ((localView instanceof SingleLineTextView)) {
      ((SingleLineTextView)localView).setTextColor(c(paramView.getContext(), paramInt2));
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof ImageView)) {
      ((ImageView)localView).setImageDrawable(a(paramView.getContext(), paramInt2, paramInt3));
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramView.findViewById(paramInt1);
    if (localView != null)
    {
      Drawable localDrawable1 = a(paramView.getContext(), paramInt2);
      Drawable localDrawable2 = a(paramView.getContext(), paramInt3);
      paramView = a(paramView.getContext(), paramInt4);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, paramView);
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
      localStateListDrawable.addState(new int[0], localDrawable1);
      localView.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, String paramString)
  {
    paramView = paramView.findViewById(paramInt1);
    if (paramView != null) {
      paramView.setBackgroundDrawable(a(paramView.getContext(), paramInt2, paramString));
    }
  }
  
  public void a(SkinDrawable.IVasSkinChangeCallback paramIVasSkinChangeCallback)
  {
    if (paramIVasSkinChangeCallback == null) {
      return;
    }
    this.f = new WeakReference(paramIVasSkinChangeCallback);
  }
  
  protected Drawable b(Context paramContext, int paramInt)
  {
    if ((du_()) && (!TextUtils.isEmpty(this.c)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = a(((StringBuilder)localObject1).toString());
      if ((localObject1 != null) && ((localObject1 instanceof Drawable))) {
        return (Drawable)localObject1;
      }
      Object localObject2 = a();
      paramContext.getResources().getValue(paramInt, (TypedValue)localObject2, true);
      localObject1 = (String)((TypedValue)localObject2).string;
      a((TypedValue)localObject2);
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("/drawable-xxhdpi/");
        ((StringBuilder)localObject2).append(((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
        localObject1 = ((StringBuilder)localObject2).toString();
        if (new File((String)localObject1).exists())
        {
          Object localObject3 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject3).inDensity = 480;
          ((BitmapFactory.Options)localObject3).inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
          localObject2 = new BitmapManager.BitmapDecodeResult();
          BitmapManager.a((String)localObject1, (BitmapFactory.Options)localObject3, (BitmapManager.BitmapDecodeResult)localObject2);
          if (((BitmapManager.BitmapDecodeResult)localObject2).b == 0)
          {
            paramContext = new ChatBackgroundDrawable(paramContext.getResources(), ((BitmapManager.BitmapDecodeResult)localObject2).a);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.c);
            ((StringBuilder)localObject1).append(paramInt);
            a(((StringBuilder)localObject1).toString(), paramContext);
            return paramContext;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(" decodeFail: ");
          ((StringBuilder)localObject3).append(((BitmapManager.BitmapDecodeResult)localObject2).b);
          QLog.e("SkinDrawable", 1, ((StringBuilder)localObject3).toString());
        }
      }
      return paramContext.getResources().getDrawable(paramInt);
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2)
  {
    paramView = paramView.findViewById(paramInt1);
    if (paramView != null) {
      paramView.setBackgroundDrawable(a(paramView.getContext(), paramInt2));
    }
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = paramView.findViewById(paramInt1);
    if (localView != null) {
      localView.setBackgroundDrawable(a(paramView.getContext(), paramInt2, paramInt3));
    }
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2, String paramString)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof ImageView)) {
      ((ImageView)localView).setImageDrawable(a(paramView.getContext(), paramInt2, paramString));
    }
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  /* Error */
  protected ColorStateList c(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 111	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:du_	()Z
    //   4: ifeq +400 -> 404
    //   7: aload_0
    //   8: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   11: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +387 -> 404
    //   20: new 119	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_0
    //   30: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   33: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: iload_2
    //   39: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_0
    //   44: aload_3
    //   45: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 133	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +15 -> 68
    //   56: aload_3
    //   57: instanceof 323
    //   60: ifeq +8 -> 68
    //   63: aload_3
    //   64: checkcast 323	android/content/res/ColorStateList
    //   67: areturn
    //   68: aload_0
    //   69: invokespecial 135	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   72: astore 4
    //   74: aload_1
    //   75: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   78: iload_2
    //   79: aload 4
    //   81: iconst_1
    //   82: invokevirtual 147	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   85: aload 4
    //   87: getfield 151	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   90: checkcast 153	java/lang/String
    //   93: astore_3
    //   94: aload_0
    //   95: aload 4
    //   97: invokespecial 155	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   100: aload_3
    //   101: ifnull +294 -> 395
    //   104: new 119	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   111: astore 4
    //   113: aload 4
    //   115: aload_0
    //   116: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   119: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: ldc_w 325
    //   128: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload_3
    //   135: aload_3
    //   136: ldc 159
    //   138: invokevirtual 163	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   141: iconst_1
    //   142: iadd
    //   143: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   146: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 4
    //   152: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore 8
    //   157: new 169	java/io/File
    //   160: dup
    //   161: aload 8
    //   163: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 175	java/io/File:exists	()Z
    //   169: ifeq +226 -> 395
    //   172: aconst_null
    //   173: astore 5
    //   175: aconst_null
    //   176: astore 6
    //   178: aconst_null
    //   179: astore 4
    //   181: aload 4
    //   183: astore_3
    //   184: new 327	com/tencent/theme/AndroidXmlResourceParser
    //   187: dup
    //   188: invokespecial 328	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   191: astore 7
    //   193: aload 4
    //   195: astore_3
    //   196: new 186	java/io/FileInputStream
    //   199: dup
    //   200: new 169	java/io/File
    //   203: dup
    //   204: aload 8
    //   206: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   212: astore 4
    //   214: aload 7
    //   216: aload 4
    //   218: ldc_w 330
    //   221: invokeinterface 336 3 0
    //   226: invokestatic 342	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   229: aload_1
    //   230: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   233: aload 7
    //   235: iconst_1
    //   236: invokestatic 348	com/tencent/theme/SkinnableColorStateList:createFromXml	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/SkinnableColorStateList;
    //   239: astore_3
    //   240: new 119	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   247: astore 5
    //   249: aload 5
    //   251: aload_0
    //   252: getfield 24	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:c	Ljava/lang/String;
    //   255: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 5
    //   261: iload_2
    //   262: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_0
    //   267: aload 5
    //   269: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: aload_3
    //   273: invokespecial 350	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/content/res/ColorStateList;)V
    //   276: aload 4
    //   278: invokevirtual 211	java/io/InputStream:close	()V
    //   281: aload_3
    //   282: areturn
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   288: aload_3
    //   289: areturn
    //   290: astore_1
    //   291: goto +84 -> 375
    //   294: astore 5
    //   296: goto +23 -> 319
    //   299: astore 5
    //   301: goto +45 -> 346
    //   304: astore_1
    //   305: aload_3
    //   306: astore 4
    //   308: goto +67 -> 375
    //   311: astore_3
    //   312: aload 5
    //   314: astore 4
    //   316: aload_3
    //   317: astore 5
    //   319: aload 4
    //   321: astore_3
    //   322: aload 5
    //   324: invokevirtual 351	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   327: aload 4
    //   329: ifnull +66 -> 395
    //   332: aload 4
    //   334: invokevirtual 211	java/io/InputStream:close	()V
    //   337: goto +58 -> 395
    //   340: astore 5
    //   342: aload 6
    //   344: astore 4
    //   346: aload 4
    //   348: astore_3
    //   349: aload 5
    //   351: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   354: aload 4
    //   356: ifnull +39 -> 395
    //   359: aload 4
    //   361: invokevirtual 211	java/io/InputStream:close	()V
    //   364: goto +31 -> 395
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   372: goto +23 -> 395
    //   375: aload 4
    //   377: ifnull +16 -> 393
    //   380: aload 4
    //   382: invokevirtual 211	java/io/InputStream:close	()V
    //   385: goto +8 -> 393
    //   388: astore_3
    //   389: aload_3
    //   390: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   393: aload_1
    //   394: athrow
    //   395: aload_1
    //   396: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   399: iload_2
    //   400: invokevirtual 355	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   403: areturn
    //   404: aload_1
    //   405: invokevirtual 141	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   408: iload_2
    //   409: invokevirtual 355	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   412: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	SkinDrawable
    //   0	413	1	paramContext	Context
    //   0	413	2	paramInt	int
    //   27	279	3	localObject1	Object
    //   311	6	3	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   321	28	3	localObject2	Object
    //   367	2	3	localIOException1	java.io.IOException
    //   388	2	3	localIOException2	java.io.IOException
    //   72	309	4	localObject3	Object
    //   173	95	5	localStringBuilder	StringBuilder
    //   294	1	5	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   299	14	5	localIOException3	java.io.IOException
    //   317	6	5	localXmlPullParserException3	org.xmlpull.v1.XmlPullParserException
    //   340	10	5	localIOException4	java.io.IOException
    //   176	167	6	localObject4	Object
    //   191	43	7	localAndroidXmlResourceParser	com.tencent.theme.AndroidXmlResourceParser
    //   155	50	8	str	String
    // Exception table:
    //   from	to	target	type
    //   276	281	283	java/io/IOException
    //   214	276	290	finally
    //   214	276	294	org/xmlpull/v1/XmlPullParserException
    //   214	276	299	java/io/IOException
    //   184	193	304	finally
    //   196	214	304	finally
    //   322	327	304	finally
    //   349	354	304	finally
    //   184	193	311	org/xmlpull/v1/XmlPullParserException
    //   196	214	311	org/xmlpull/v1/XmlPullParserException
    //   184	193	340	java/io/IOException
    //   196	214	340	java/io/IOException
    //   332	337	367	java/io/IOException
    //   359	364	367	java/io/IOException
    //   380	385	388	java/io/IOException
  }
  
  protected String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/anim/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public boolean du_()
  {
    return (this.d) && (this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.SkinDrawable
 * JD-Core Version:    0.7.0.1
 */