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
  private TypedValue jdField_a_of_type_AndroidUtilTypedValue = new TypedValue();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected String a;
  protected WeakReference<SkinDrawable.IVasSkinChangeCallback> a;
  protected volatile boolean a;
  protected volatile boolean b = true;
  
  public SkinDrawable()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  private TypedValue a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidUtilTypedValue != null)
        {
          TypedValue localTypedValue = this.jdField_a_of_type_AndroidUtilTypedValue;
          this.jdField_a_of_type_AndroidUtilTypedValue = null;
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidUtilTypedValue == null) {
        this.jdField_a_of_type_AndroidUtilTypedValue = paramTypedValue;
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
  protected ColorStateList a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:n_	()Z
    //   4: ifeq +398 -> 402
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +385 -> 402
    //   20: new 115	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_0
    //   30: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: iload_2
    //   39: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_0
    //   44: aload_3
    //   45: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 129	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +15 -> 68
    //   56: aload_3
    //   57: instanceof 131
    //   60: ifeq +8 -> 68
    //   63: aload_3
    //   64: checkcast 131	android/content/res/ColorStateList
    //   67: areturn
    //   68: aload_0
    //   69: invokespecial 133	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   72: astore 4
    //   74: aload_1
    //   75: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   78: iload_2
    //   79: aload 4
    //   81: iconst_1
    //   82: invokevirtual 145	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   85: aload 4
    //   87: getfield 149	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   90: checkcast 151	java/lang/String
    //   93: astore_3
    //   94: aload_0
    //   95: aload 4
    //   97: invokespecial 153	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   100: aload_3
    //   101: ifnull +292 -> 393
    //   104: new 115	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   111: astore 4
    //   113: aload 4
    //   115: aload_0
    //   116: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   119: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: ldc 155
    //   127: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: aload_3
    //   134: aload_3
    //   135: ldc 157
    //   137: invokevirtual 161	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   140: iconst_1
    //   141: iadd
    //   142: invokevirtual 165	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 8
    //   156: new 167	java/io/File
    //   159: dup
    //   160: aload 8
    //   162: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: invokevirtual 173	java/io/File:exists	()Z
    //   168: ifeq +225 -> 393
    //   171: aconst_null
    //   172: astore 5
    //   174: aconst_null
    //   175: astore 6
    //   177: aconst_null
    //   178: astore 4
    //   180: aload 4
    //   182: astore_3
    //   183: new 175	com/tencent/theme/AndroidXmlResourceParser
    //   186: dup
    //   187: invokespecial 176	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   190: astore 7
    //   192: aload 4
    //   194: astore_3
    //   195: new 178	java/io/FileInputStream
    //   198: dup
    //   199: new 167	java/io/File
    //   202: dup
    //   203: aload 8
    //   205: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   208: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   211: astore 4
    //   213: aload 7
    //   215: aload 4
    //   217: ldc 183
    //   219: invokeinterface 189 3 0
    //   224: invokestatic 195	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   227: aload_1
    //   228: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   231: aload 7
    //   233: iconst_1
    //   234: invokestatic 201	com/tencent/theme/SkinnableColorStateList:createFromXml	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/SkinnableColorStateList;
    //   237: astore_3
    //   238: new 115	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   245: astore 5
    //   247: aload 5
    //   249: aload_0
    //   250: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   253: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 5
    //   259: iload_2
    //   260: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_0
    //   265: aload 5
    //   267: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: aload_3
    //   271: invokespecial 203	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/content/res/ColorStateList;)V
    //   274: aload 4
    //   276: invokevirtual 208	java/io/InputStream:close	()V
    //   279: aload_3
    //   280: areturn
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   286: aload_3
    //   287: areturn
    //   288: astore_1
    //   289: goto +84 -> 373
    //   292: astore 5
    //   294: goto +23 -> 317
    //   297: astore 5
    //   299: goto +45 -> 344
    //   302: astore_1
    //   303: aload_3
    //   304: astore 4
    //   306: goto +67 -> 373
    //   309: astore_3
    //   310: aload 5
    //   312: astore 4
    //   314: aload_3
    //   315: astore 5
    //   317: aload 4
    //   319: astore_3
    //   320: aload 5
    //   322: invokevirtual 212	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   325: aload 4
    //   327: ifnull +66 -> 393
    //   330: aload 4
    //   332: invokevirtual 208	java/io/InputStream:close	()V
    //   335: goto +58 -> 393
    //   338: astore 5
    //   340: aload 6
    //   342: astore 4
    //   344: aload 4
    //   346: astore_3
    //   347: aload 5
    //   349: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   352: aload 4
    //   354: ifnull +39 -> 393
    //   357: aload 4
    //   359: invokevirtual 208	java/io/InputStream:close	()V
    //   362: goto +31 -> 393
    //   365: astore_3
    //   366: aload_3
    //   367: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   370: goto +23 -> 393
    //   373: aload 4
    //   375: ifnull +16 -> 391
    //   378: aload 4
    //   380: invokevirtual 208	java/io/InputStream:close	()V
    //   383: goto +8 -> 391
    //   386: astore_3
    //   387: aload_3
    //   388: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   391: aload_1
    //   392: athrow
    //   393: aload_1
    //   394: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   397: iload_2
    //   398: invokevirtual 216	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   401: areturn
    //   402: aload_1
    //   403: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   406: iload_2
    //   407: invokevirtual 216	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   410: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	SkinDrawable
    //   0	411	1	paramContext	Context
    //   0	411	2	paramInt	int
    //   27	277	3	localObject1	Object
    //   309	6	3	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   319	28	3	localObject2	Object
    //   365	2	3	localIOException1	java.io.IOException
    //   386	2	3	localIOException2	java.io.IOException
    //   72	307	4	localObject3	Object
    //   172	94	5	localStringBuilder	StringBuilder
    //   292	1	5	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   297	14	5	localIOException3	java.io.IOException
    //   315	6	5	localXmlPullParserException3	org.xmlpull.v1.XmlPullParserException
    //   338	10	5	localIOException4	java.io.IOException
    //   175	166	6	localObject4	Object
    //   190	42	7	localAndroidXmlResourceParser	com.tencent.theme.AndroidXmlResourceParser
    //   154	50	8	str	String
    // Exception table:
    //   from	to	target	type
    //   274	279	281	java/io/IOException
    //   213	274	288	finally
    //   213	274	292	org/xmlpull/v1/XmlPullParserException
    //   213	274	297	java/io/IOException
    //   183	192	302	finally
    //   195	213	302	finally
    //   320	325	302	finally
    //   347	352	302	finally
    //   183	192	309	org/xmlpull/v1/XmlPullParserException
    //   195	213	309	org/xmlpull/v1/XmlPullParserException
    //   183	192	338	java/io/IOException
    //   195	213	338	java/io/IOException
    //   330	335	365	java/io/IOException
    //   357	362	365	java/io/IOException
    //   378	383	386	java/io/IOException
  }
  
  /* Error */
  protected Drawable a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:n_	()Z
    //   4: ifeq +396 -> 400
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +383 -> 400
    //   20: new 115	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_0
    //   30: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: iload_2
    //   39: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_0
    //   44: aload_3
    //   45: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 129	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +15 -> 68
    //   56: aload_3
    //   57: instanceof 92
    //   60: ifeq +8 -> 68
    //   63: aload_3
    //   64: checkcast 92	android/graphics/drawable/Drawable
    //   67: areturn
    //   68: aload_0
    //   69: invokespecial 133	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   72: astore 5
    //   74: aload_1
    //   75: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   78: iload_2
    //   79: aload 5
    //   81: iconst_1
    //   82: invokevirtual 145	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   85: aload 5
    //   87: getfield 149	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   90: checkcast 151	java/lang/String
    //   93: astore 6
    //   95: aload_0
    //   96: aload 5
    //   98: invokespecial 153	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   101: aload 6
    //   103: ifnull +288 -> 391
    //   106: new 115	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   113: astore_3
    //   114: aload_3
    //   115: aload_0
    //   116: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   119: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: ldc 221
    //   126: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: aload 6
    //   133: aload 6
    //   135: ldc 157
    //   137: invokevirtual 161	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   140: iconst_1
    //   141: iadd
    //   142: invokevirtual 165	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new 167	java/io/File
    //   152: dup
    //   153: aload_3
    //   154: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 173	java/io/File:exists	()Z
    //   165: ifeq +226 -> 391
    //   168: new 223	android/graphics/Rect
    //   171: dup
    //   172: invokespecial 224	android/graphics/Rect:<init>	()V
    //   175: astore 7
    //   177: aload 5
    //   179: sipush 480
    //   182: putfield 228	android/util/TypedValue:density	I
    //   185: new 230	java/io/BufferedInputStream
    //   188: dup
    //   189: new 178	java/io/FileInputStream
    //   192: dup
    //   193: aload_3
    //   194: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   200: astore 4
    //   202: aload 4
    //   204: astore_3
    //   205: aload_1
    //   206: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   209: aload 5
    //   211: aload 4
    //   213: aload 6
    //   215: aconst_null
    //   216: aload 7
    //   218: iconst_1
    //   219: invokestatic 239	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   222: aload_1
    //   223: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   226: invokevirtual 245	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   229: astore 5
    //   231: aload 4
    //   233: astore_3
    //   234: new 115	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   241: astore 6
    //   243: aload 4
    //   245: astore_3
    //   246: aload 6
    //   248: aload_0
    //   249: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   252: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 4
    //   258: astore_3
    //   259: aload 6
    //   261: iload_2
    //   262: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: astore_3
    //   269: aload_0
    //   270: aload 6
    //   272: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload 5
    //   277: invokespecial 247	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   280: aload 4
    //   282: invokevirtual 208	java/io/InputStream:close	()V
    //   285: aload 5
    //   287: areturn
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 211	java/io/IOException:printStackTrace	()V
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
    //   322: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   325: aload 4
    //   327: ifnull +64 -> 391
    //   330: aload 4
    //   332: invokevirtual 208	java/io/InputStream:close	()V
    //   335: goto +56 -> 391
    //   338: astore 5
    //   340: aconst_null
    //   341: astore 4
    //   343: aload 4
    //   345: astore_3
    //   346: aload 5
    //   348: invokevirtual 248	java/lang/OutOfMemoryError:printStackTrace	()V
    //   351: aload 4
    //   353: ifnull +38 -> 391
    //   356: aload 4
    //   358: invokevirtual 208	java/io/InputStream:close	()V
    //   361: goto +30 -> 391
    //   364: astore_3
    //   365: aload_3
    //   366: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   369: goto +22 -> 391
    //   372: astore_1
    //   373: aload_3
    //   374: ifnull +15 -> 389
    //   377: aload_3
    //   378: invokevirtual 208	java/io/InputStream:close	()V
    //   381: goto +8 -> 389
    //   384: astore_3
    //   385: aload_3
    //   386: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   389: aload_1
    //   390: athrow
    //   391: aload_1
    //   392: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   395: iload_2
    //   396: invokevirtual 252	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   399: areturn
    //   400: aload_1
    //   401: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   404: iload_2
    //   405: invokevirtual 252	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
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
    //   1: invokevirtual 107	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:n_	()Z
    //   4: ifeq +419 -> 423
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: goto +406 -> 423
    //   20: new 115	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: iload_2
    //   42: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_0
    //   47: aload 4
    //   49: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 129	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +17 -> 76
    //   62: aload 4
    //   64: instanceof 92
    //   67: ifeq +9 -> 76
    //   70: aload 4
    //   72: checkcast 92	android/graphics/drawable/Drawable
    //   75: areturn
    //   76: aload_0
    //   77: invokespecial 133	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   80: astore 5
    //   82: aload_1
    //   83: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   86: iload_2
    //   87: aload 5
    //   89: iconst_1
    //   90: invokevirtual 145	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   93: aload 5
    //   95: getfield 149	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   98: checkcast 151	java/lang/String
    //   101: astore 6
    //   103: aload_0
    //   104: aload 5
    //   106: invokespecial 153	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   109: aload 6
    //   111: ifnull +303 -> 414
    //   114: new 115	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: aload_0
    //   126: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: ldc 157
    //   137: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: aload_3
    //   144: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 167	java/io/File
    //   151: dup
    //   152: aload 4
    //   154: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 173	java/io/File:exists	()Z
    //   165: ifeq +249 -> 414
    //   168: new 223	android/graphics/Rect
    //   171: dup
    //   172: invokespecial 224	android/graphics/Rect:<init>	()V
    //   175: astore 7
    //   177: new 230	java/io/BufferedInputStream
    //   180: dup
    //   181: new 178	java/io/FileInputStream
    //   184: dup
    //   185: aload_3
    //   186: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   189: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: aload 5
    //   199: sipush 480
    //   202: putfield 228	android/util/TypedValue:density	I
    //   205: aload 4
    //   207: astore_3
    //   208: aload_1
    //   209: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   212: aload 5
    //   214: aload 4
    //   216: aload 6
    //   218: aconst_null
    //   219: aload 7
    //   221: iconst_1
    //   222: invokestatic 239	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   225: astore 5
    //   227: aload 5
    //   229: ifnull +82 -> 311
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: aload_1
    //   238: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   241: invokevirtual 245	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   244: astore 5
    //   246: aload 4
    //   248: astore_3
    //   249: new 115	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   256: astore 6
    //   258: aload 4
    //   260: astore_3
    //   261: aload 6
    //   263: aload_0
    //   264: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   267: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 4
    //   273: astore_3
    //   274: aload 6
    //   276: iload_2
    //   277: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 4
    //   283: astore_3
    //   284: aload_0
    //   285: aload 6
    //   287: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: aload 5
    //   292: invokespecial 247	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   295: aload 4
    //   297: invokevirtual 208	java/io/InputStream:close	()V
    //   300: aload 5
    //   302: areturn
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   308: aload 5
    //   310: areturn
    //   311: aload 4
    //   313: invokevirtual 208	java/io/InputStream:close	()V
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
    //   345: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   348: aload 4
    //   350: ifnull +64 -> 414
    //   353: aload 4
    //   355: invokevirtual 208	java/io/InputStream:close	()V
    //   358: goto +56 -> 414
    //   361: astore 5
    //   363: aconst_null
    //   364: astore 4
    //   366: aload 4
    //   368: astore_3
    //   369: aload 5
    //   371: invokevirtual 248	java/lang/OutOfMemoryError:printStackTrace	()V
    //   374: aload 4
    //   376: ifnull +38 -> 414
    //   379: aload 4
    //   381: invokevirtual 208	java/io/InputStream:close	()V
    //   384: goto +30 -> 414
    //   387: astore_3
    //   388: aload_3
    //   389: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   392: goto +22 -> 414
    //   395: astore_1
    //   396: aload_3
    //   397: ifnull +15 -> 412
    //   400: aload_3
    //   401: invokevirtual 208	java/io/InputStream:close	()V
    //   404: goto +8 -> 412
    //   407: astore_3
    //   408: aload_3
    //   409: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   412: aload_1
    //   413: athrow
    //   414: aload_1
    //   415: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   418: iload_2
    //   419: invokevirtual 252	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   422: areturn
    //   423: aload_1
    //   424: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   427: iload_2
    //   428: invokevirtual 252	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
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
  
  protected String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/anim/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof TextView))
    {
      ((TextView)localView).setTextColor(a(paramView.getContext(), paramInt2));
      return;
    }
    if ((localView instanceof SingleLineTextView)) {
      ((SingleLineTextView)localView).setTextColor(a(paramView.getContext(), paramInt2));
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIVasSkinChangeCallback);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Drawable b(Context paramContext, int paramInt)
  {
    if ((n_()) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
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
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
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
          if (((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int == 0)
          {
            paramContext = new ChatBackgroundDrawable(paramContext.getResources(), ((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_AndroidGraphicsBitmap);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(paramInt);
            a(((StringBuilder)localObject1).toString(), paramContext);
            return paramContext;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(" decodeFail: ");
          ((StringBuilder)localObject3).append(((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int);
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
  
  public boolean n_()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.SkinDrawable
 * JD-Core Version:    0.7.0.1
 */