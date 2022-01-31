package com.tencent.plato.sdk.dom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.annotation.Exported;
import java.util.HashMap;

public class CanvasModule
  extends ExportedModule
{
  private static final String TAG = "DocumentModule";
  private static HashMap<String, Bitmap> bitmaps = new HashMap();
  private static Canvas canvas;
  private static boolean created;
  private static SurfaceView surfaceView = null;
  
  static
  {
    canvas = null;
    created = false;
  }
  
  public CanvasModule()
  {
    super("CanvasModule");
  }
  
  public static SurfaceView createSurfaceView(Context paramContext)
  {
    surfaceView = new MySurfaceView(paramContext);
    return surfaceView;
  }
  
  public static void setSurfaceView(SurfaceView paramSurfaceView)
  {
    surfaceView = paramSurfaceView;
    created = true;
  }
  
  @Exported("clearRect")
  public void clearRect(IPlatoRuntime paramIPlatoRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (canvas != null)
    {
      paramIPlatoRuntime = new Paint();
      paramIPlatoRuntime.setAntiAlias(true);
      paramIPlatoRuntime.setColor(-1);
      canvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramIPlatoRuntime);
    }
  }
  
  /* Error */
  @Exported("drawImage")
  public void drawImage(IPlatoRuntime paramIPlatoRuntime, String paramString, com.tencent.plato.core.IReadableArray paramIReadableArray)
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/plato/sdk/dom/CanvasModule:canvas	Landroid/graphics/Canvas;
    //   3: ifnull +259 -> 262
    //   6: new 56	android/graphics/Paint
    //   9: dup
    //   10: invokespecial 57	android/graphics/Paint:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: iconst_1
    //   18: invokevirtual 61	android/graphics/Paint:setAntiAlias	(Z)V
    //   21: getstatic 35	com/tencent/plato/sdk/dom/CanvasModule:bitmaps	Ljava/util/HashMap;
    //   24: aload_2
    //   25: invokevirtual 84	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 86	android/graphics/Bitmap
    //   31: astore 5
    //   33: aload 5
    //   35: astore 6
    //   37: aload 5
    //   39: ifnonnull +66 -> 105
    //   42: ldc 88
    //   44: astore 7
    //   46: aload 7
    //   48: astore 6
    //   50: aload_1
    //   51: invokeinterface 94 1 0
    //   56: ldc 96
    //   58: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   61: istore 4
    //   63: iload 4
    //   65: ifeq +198 -> 263
    //   68: aload 7
    //   70: astore 6
    //   72: aload_1
    //   73: invokeinterface 106 1 0
    //   78: invokevirtual 112	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   81: aload_2
    //   82: iconst_2
    //   83: invokevirtual 116	java/lang/String:substring	(I)Ljava/lang/String;
    //   86: invokevirtual 122	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   89: invokestatic 128	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: getstatic 35	com/tencent/plato/sdk/dom/CanvasModule:bitmaps	Ljava/util/HashMap;
    //   96: aload_2
    //   97: aload_1
    //   98: invokevirtual 132	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_1
    //   103: astore 6
    //   105: aload_3
    //   106: invokeinterface 138 1 0
    //   111: bipush 8
    //   113: if_icmpne +222 -> 335
    //   116: new 140	android/graphics/Rect
    //   119: dup
    //   120: invokespecial 141	android/graphics/Rect:<init>	()V
    //   123: astore_1
    //   124: aload_1
    //   125: aload_3
    //   126: iconst_0
    //   127: iconst_0
    //   128: invokeinterface 145 3 0
    //   133: putfield 149	android/graphics/Rect:left	I
    //   136: aload_1
    //   137: aload_3
    //   138: iconst_1
    //   139: iconst_0
    //   140: invokeinterface 145 3 0
    //   145: putfield 152	android/graphics/Rect:top	I
    //   148: aload_1
    //   149: aload_1
    //   150: getfield 149	android/graphics/Rect:left	I
    //   153: aload_3
    //   154: iconst_2
    //   155: iconst_0
    //   156: invokeinterface 145 3 0
    //   161: iadd
    //   162: putfield 155	android/graphics/Rect:right	I
    //   165: aload_1
    //   166: aload_1
    //   167: getfield 152	android/graphics/Rect:top	I
    //   170: aload_3
    //   171: iconst_3
    //   172: iconst_0
    //   173: invokeinterface 145 3 0
    //   178: iadd
    //   179: putfield 158	android/graphics/Rect:bottom	I
    //   182: new 140	android/graphics/Rect
    //   185: dup
    //   186: invokespecial 141	android/graphics/Rect:<init>	()V
    //   189: astore_2
    //   190: aload_2
    //   191: aload_3
    //   192: iconst_4
    //   193: iconst_0
    //   194: invokeinterface 145 3 0
    //   199: putfield 149	android/graphics/Rect:left	I
    //   202: aload_2
    //   203: aload_3
    //   204: iconst_5
    //   205: iconst_0
    //   206: invokeinterface 145 3 0
    //   211: putfield 152	android/graphics/Rect:top	I
    //   214: aload_2
    //   215: aload_2
    //   216: getfield 149	android/graphics/Rect:left	I
    //   219: aload_3
    //   220: bipush 6
    //   222: iconst_0
    //   223: invokeinterface 145 3 0
    //   228: iadd
    //   229: putfield 155	android/graphics/Rect:right	I
    //   232: aload_2
    //   233: aload_2
    //   234: getfield 152	android/graphics/Rect:top	I
    //   237: aload_3
    //   238: bipush 7
    //   240: iconst_0
    //   241: invokeinterface 145 3 0
    //   246: iadd
    //   247: putfield 158	android/graphics/Rect:bottom	I
    //   250: getstatic 26	com/tencent/plato/sdk/dom/CanvasModule:canvas	Landroid/graphics/Canvas;
    //   253: aload 6
    //   255: aload_1
    //   256: aload_2
    //   257: aload 8
    //   259: invokevirtual 162	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   262: return
    //   263: aload 7
    //   265: astore 6
    //   267: new 164	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   274: aload_1
    //   275: invokeinterface 94 1 0
    //   280: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 171
    //   285: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_2
    //   289: iconst_2
    //   290: invokevirtual 116	java/lang/String:substring	(I)Ljava/lang/String;
    //   293: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: astore_1
    //   300: aload_1
    //   301: astore 6
    //   303: aload_1
    //   304: invokestatic 178	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   307: astore_1
    //   308: goto -215 -> 93
    //   311: astore_1
    //   312: new 180	android/graphics/BitmapFactory$Options
    //   315: dup
    //   316: invokespecial 181	android/graphics/BitmapFactory$Options:<init>	()V
    //   319: astore_1
    //   320: aload_1
    //   321: iconst_2
    //   322: putfield 184	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   325: aload 6
    //   327: aload_1
    //   328: invokestatic 187	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   331: astore_1
    //   332: goto -239 -> 93
    //   335: aload_3
    //   336: invokeinterface 138 1 0
    //   341: iconst_4
    //   342: if_icmpne +128 -> 470
    //   345: new 140	android/graphics/Rect
    //   348: dup
    //   349: invokespecial 141	android/graphics/Rect:<init>	()V
    //   352: astore_1
    //   353: aload_1
    //   354: iconst_0
    //   355: putfield 149	android/graphics/Rect:left	I
    //   358: aload_1
    //   359: iconst_0
    //   360: putfield 152	android/graphics/Rect:top	I
    //   363: aload_1
    //   364: aload_1
    //   365: getfield 149	android/graphics/Rect:left	I
    //   368: aload 6
    //   370: invokevirtual 190	android/graphics/Bitmap:getWidth	()I
    //   373: iadd
    //   374: putfield 155	android/graphics/Rect:right	I
    //   377: aload_1
    //   378: aload_1
    //   379: getfield 152	android/graphics/Rect:top	I
    //   382: aload 6
    //   384: invokevirtual 193	android/graphics/Bitmap:getHeight	()I
    //   387: iadd
    //   388: putfield 158	android/graphics/Rect:bottom	I
    //   391: new 140	android/graphics/Rect
    //   394: dup
    //   395: invokespecial 141	android/graphics/Rect:<init>	()V
    //   398: astore_2
    //   399: aload_2
    //   400: aload_3
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokeinterface 145 3 0
    //   408: putfield 149	android/graphics/Rect:left	I
    //   411: aload_2
    //   412: aload_3
    //   413: iconst_1
    //   414: iconst_0
    //   415: invokeinterface 145 3 0
    //   420: putfield 152	android/graphics/Rect:top	I
    //   423: aload_2
    //   424: aload_2
    //   425: getfield 149	android/graphics/Rect:left	I
    //   428: aload_3
    //   429: iconst_2
    //   430: iconst_0
    //   431: invokeinterface 145 3 0
    //   436: iadd
    //   437: putfield 155	android/graphics/Rect:right	I
    //   440: aload_2
    //   441: aload_2
    //   442: getfield 152	android/graphics/Rect:top	I
    //   445: aload_3
    //   446: iconst_3
    //   447: iconst_0
    //   448: invokeinterface 145 3 0
    //   453: iadd
    //   454: putfield 158	android/graphics/Rect:bottom	I
    //   457: getstatic 26	com/tencent/plato/sdk/dom/CanvasModule:canvas	Landroid/graphics/Canvas;
    //   460: aload 6
    //   462: aload_1
    //   463: aload_2
    //   464: aload 8
    //   466: invokevirtual 162	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   469: return
    //   470: aload_3
    //   471: invokeinterface 138 1 0
    //   476: iconst_2
    //   477: if_icmpne -215 -> 262
    //   480: getstatic 26	com/tencent/plato/sdk/dom/CanvasModule:canvas	Landroid/graphics/Canvas;
    //   483: aload 6
    //   485: aload_3
    //   486: iconst_0
    //   487: iconst_0
    //   488: invokeinterface 145 3 0
    //   493: i2f
    //   494: aload_3
    //   495: iconst_1
    //   496: iconst_0
    //   497: invokeinterface 145 3 0
    //   502: i2f
    //   503: aload 8
    //   505: invokevirtual 196	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   508: return
    //   509: astore_1
    //   510: aload 5
    //   512: astore_1
    //   513: goto -420 -> 93
    //   516: astore_1
    //   517: aload 5
    //   519: astore_1
    //   520: goto -427 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	CanvasModule
    //   0	523	1	paramIPlatoRuntime	IPlatoRuntime
    //   0	523	2	paramString	String
    //   0	523	3	paramIReadableArray	com.tencent.plato.core.IReadableArray
    //   61	3	4	bool	boolean
    //   31	487	5	localBitmap	Bitmap
    //   35	449	6	localObject	java.lang.Object
    //   44	220	7	str	String
    //   13	491	8	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   50	63	311	java/lang/OutOfMemoryError
    //   72	93	311	java/lang/OutOfMemoryError
    //   267	300	311	java/lang/OutOfMemoryError
    //   303	308	311	java/lang/OutOfMemoryError
    //   312	332	509	java/lang/Exception
    //   72	93	516	java/io/IOException
  }
  
  @Exported("fillText")
  public void fillText(IPlatoRuntime paramIPlatoRuntime, String paramString, int paramInt1, int paramInt2)
  {
    if (canvas != null)
    {
      paramIPlatoRuntime = new Paint();
      paramIPlatoRuntime.setAntiAlias(true);
      paramIPlatoRuntime.setStrokeWidth(3.0F);
      paramIPlatoRuntime.setTextSize(60.0F);
      paramIPlatoRuntime.setColor(-1);
      paramIPlatoRuntime.setTextAlign(Paint.Align.LEFT);
      canvas.drawText(paramString, paramInt1, paramInt2, paramIPlatoRuntime);
    }
  }
  
  @Exported("lockCanvas")
  public void lockCanvas()
  {
    if ((created) && (surfaceView != null)) {
      canvas = surfaceView.getHolder().lockCanvas();
    }
  }
  
  @Exported("unlockCanvas")
  public void unlockCanvas()
  {
    if ((created) && (surfaceView != null))
    {
      surfaceView.getHolder().unlockCanvasAndPost(canvas);
      canvas = null;
    }
  }
  
  static class MySurfaceView
    extends SurfaceView
    implements SurfaceHolder.Callback
  {
    public MySurfaceView(Context paramContext)
    {
      super();
      getHolder().addCallback(this);
      setBackgroundColor(-1);
    }
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      CanvasModule.access$002(true);
    }
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      CanvasModule.access$002(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.dom.CanvasModule
 * JD-Core Version:    0.7.0.1
 */