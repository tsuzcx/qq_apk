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
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
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
    TypedValue localTypedValue = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidUtilTypedValue != null)
      {
        localTypedValue = this.jdField_a_of_type_AndroidUtilTypedValue;
        this.jdField_a_of_type_AndroidUtilTypedValue = null;
      }
      ??? = localTypedValue;
      if (localTypedValue == null) {
        ??? = new TypedValue();
      }
      return ???;
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
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingLeft();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(j, i, k, m);
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
    //   1: invokevirtual 107	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:m_	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: iload_2
    //   22: invokevirtual 125	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: new 127	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 141	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +15 -> 70
    //   58: aload_3
    //   59: instanceof 143
    //   62: ifeq +8 -> 70
    //   65: aload_3
    //   66: checkcast 143	android/content/res/ColorStateList
    //   69: areturn
    //   70: aload_0
    //   71: invokespecial 145	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   74: astore_3
    //   75: aload_1
    //   76: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   79: iload_2
    //   80: aload_3
    //   81: iconst_1
    //   82: invokevirtual 149	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   85: aload_3
    //   86: getfield 153	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   89: checkcast 155	java/lang/String
    //   92: astore 4
    //   94: aload_0
    //   95: aload_3
    //   96: invokespecial 157	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   99: aload 4
    //   101: ifnull +192 -> 293
    //   104: new 127	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   111: aload_0
    //   112: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 159
    //   120: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 4
    //   125: aload 4
    //   127: ldc 161
    //   129: invokevirtual 165	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 169	java/lang/String:substring	(I)Ljava/lang/String;
    //   137: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore_3
    //   144: new 171	java/io/File
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: invokevirtual 177	java/io/File:exists	()Z
    //   155: ifeq +138 -> 293
    //   158: new 179	com/tencent/theme/AndroidXmlResourceParser
    //   161: dup
    //   162: invokespecial 180	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   165: astore 5
    //   167: new 182	java/io/FileInputStream
    //   170: dup
    //   171: new 171	java/io/File
    //   174: dup
    //   175: aload_3
    //   176: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   182: astore 4
    //   184: aload 4
    //   186: astore_3
    //   187: aload 5
    //   189: aload 4
    //   191: ldc 187
    //   193: invokeinterface 193 3 0
    //   198: aload 4
    //   200: astore_3
    //   201: invokestatic 199	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   204: aload_1
    //   205: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   208: aload 5
    //   210: iconst_1
    //   211: invokestatic 205	com/tencent/theme/SkinnableColorStateList:createFromXml	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/SkinnableColorStateList;
    //   214: astore 5
    //   216: aload 4
    //   218: astore_3
    //   219: aload_0
    //   220: new 127	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   227: aload_0
    //   228: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   231: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload_2
    //   235: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload 5
    //   243: invokespecial 207	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/content/res/ColorStateList;)V
    //   246: aload 5
    //   248: astore_1
    //   249: aload 4
    //   251: ifnull -225 -> 26
    //   254: aload 4
    //   256: invokevirtual 212	java/io/InputStream:close	()V
    //   259: aload 5
    //   261: areturn
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   267: aload 5
    //   269: areturn
    //   270: astore 5
    //   272: aconst_null
    //   273: astore 4
    //   275: aload 4
    //   277: astore_3
    //   278: aload 5
    //   280: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   283: aload 4
    //   285: ifnull +8 -> 293
    //   288: aload 4
    //   290: invokevirtual 212	java/io/InputStream:close	()V
    //   293: aload_1
    //   294: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   297: iload_2
    //   298: invokevirtual 125	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   301: areturn
    //   302: astore_3
    //   303: aload_3
    //   304: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   307: goto -14 -> 293
    //   310: astore 5
    //   312: aconst_null
    //   313: astore 4
    //   315: aload 4
    //   317: astore_3
    //   318: aload 5
    //   320: invokevirtual 216	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   323: aload 4
    //   325: ifnull -32 -> 293
    //   328: aload 4
    //   330: invokevirtual 212	java/io/InputStream:close	()V
    //   333: goto -40 -> 293
    //   336: astore_3
    //   337: aload_3
    //   338: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   341: goto -48 -> 293
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_3
    //   347: aload_3
    //   348: ifnull +7 -> 355
    //   351: aload_3
    //   352: invokevirtual 212	java/io/InputStream:close	()V
    //   355: aload_1
    //   356: athrow
    //   357: astore_3
    //   358: aload_3
    //   359: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   362: goto -7 -> 355
    //   365: astore_1
    //   366: goto -19 -> 347
    //   369: astore 5
    //   371: goto -56 -> 315
    //   374: astore 5
    //   376: goto -101 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	SkinDrawable
    //   0	379	1	paramContext	Context
    //   0	379	2	paramInt	int
    //   53	225	3	localObject1	Object
    //   302	2	3	localIOException1	java.io.IOException
    //   317	1	3	localObject2	Object
    //   336	2	3	localIOException2	java.io.IOException
    //   346	6	3	localObject3	Object
    //   357	2	3	localIOException3	java.io.IOException
    //   92	237	4	localObject4	Object
    //   165	103	5	localObject5	Object
    //   270	9	5	localIOException4	java.io.IOException
    //   310	9	5	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   369	1	5	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   374	1	5	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   254	259	262	java/io/IOException
    //   158	184	270	java/io/IOException
    //   288	293	302	java/io/IOException
    //   158	184	310	org/xmlpull/v1/XmlPullParserException
    //   328	333	336	java/io/IOException
    //   158	184	344	finally
    //   351	355	357	java/io/IOException
    //   187	198	365	finally
    //   201	216	365	finally
    //   219	246	365	finally
    //   278	283	365	finally
    //   318	323	365	finally
    //   187	198	369	org/xmlpull/v1/XmlPullParserException
    //   201	216	369	org/xmlpull/v1/XmlPullParserException
    //   219	246	369	org/xmlpull/v1/XmlPullParserException
    //   187	198	374	java/io/IOException
    //   201	216	374	java/io/IOException
    //   219	246	374	java/io/IOException
  }
  
  /* Error */
  protected Drawable a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:m_	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: iload_2
    //   22: invokevirtual 223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: new 127	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 141	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +15 -> 70
    //   58: aload_3
    //   59: instanceof 92
    //   62: ifeq +8 -> 70
    //   65: aload_3
    //   66: checkcast 92	android/graphics/drawable/Drawable
    //   69: areturn
    //   70: aload_0
    //   71: invokespecial 145	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   74: astore 5
    //   76: aload_1
    //   77: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   80: iload_2
    //   81: aload 5
    //   83: iconst_1
    //   84: invokevirtual 149	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   87: aload 5
    //   89: getfield 153	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   92: checkcast 155	java/lang/String
    //   95: astore 6
    //   97: aload_0
    //   98: aload 5
    //   100: invokespecial 157	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   103: aload 6
    //   105: ifnull +197 -> 302
    //   108: new 171	java/io/File
    //   111: dup
    //   112: new 127	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   119: aload_0
    //   120: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   123: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 225
    //   128: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 6
    //   133: aload 6
    //   135: ldc 161
    //   137: invokevirtual 165	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   140: iconst_1
    //   141: iadd
    //   142: invokevirtual 169	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: astore_3
    //   155: aload_3
    //   156: invokevirtual 177	java/io/File:exists	()Z
    //   159: ifeq +143 -> 302
    //   162: new 227	android/graphics/Rect
    //   165: dup
    //   166: invokespecial 228	android/graphics/Rect:<init>	()V
    //   169: astore 7
    //   171: aload 5
    //   173: sipush 480
    //   176: putfield 232	android/util/TypedValue:density	I
    //   179: new 234	java/io/BufferedInputStream
    //   182: dup
    //   183: new 182	java/io/FileInputStream
    //   186: dup
    //   187: aload_3
    //   188: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   191: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   194: astore 4
    //   196: aload 4
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   203: aload 5
    //   205: aload 4
    //   207: aload 6
    //   209: aconst_null
    //   210: aload 7
    //   212: iconst_1
    //   213: invokestatic 243	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   216: aload_1
    //   217: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   220: invokevirtual 249	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   223: astore 5
    //   225: aload 4
    //   227: astore_3
    //   228: aload_0
    //   229: new 127	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   236: aload_0
    //   237: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_2
    //   244: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload 5
    //   252: invokespecial 251	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   255: aload 5
    //   257: astore_1
    //   258: aload 4
    //   260: ifnull -234 -> 26
    //   263: aload 4
    //   265: invokevirtual 212	java/io/InputStream:close	()V
    //   268: aload 5
    //   270: areturn
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   276: aload 5
    //   278: areturn
    //   279: astore 5
    //   281: aconst_null
    //   282: astore 4
    //   284: aload 4
    //   286: astore_3
    //   287: aload 5
    //   289: invokevirtual 252	java/lang/OutOfMemoryError:printStackTrace	()V
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 212	java/io/InputStream:close	()V
    //   302: aload_1
    //   303: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   306: iload_2
    //   307: invokevirtual 223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   310: areturn
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   316: goto -14 -> 302
    //   319: astore 5
    //   321: aconst_null
    //   322: astore 4
    //   324: aload 4
    //   326: astore_3
    //   327: aload 5
    //   329: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   332: aload 4
    //   334: ifnull -32 -> 302
    //   337: aload 4
    //   339: invokevirtual 212	java/io/InputStream:close	()V
    //   342: goto -40 -> 302
    //   345: astore_3
    //   346: aload_3
    //   347: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   350: goto -48 -> 302
    //   353: astore_1
    //   354: aconst_null
    //   355: astore_3
    //   356: aload_3
    //   357: ifnull +7 -> 364
    //   360: aload_3
    //   361: invokevirtual 212	java/io/InputStream:close	()V
    //   364: aload_1
    //   365: athrow
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   371: goto -7 -> 364
    //   374: astore_1
    //   375: goto -19 -> 356
    //   378: astore 5
    //   380: goto -56 -> 324
    //   383: astore 5
    //   385: goto -101 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	SkinDrawable
    //   0	388	1	paramContext	Context
    //   0	388	2	paramInt	int
    //   53	234	3	localObject1	Object
    //   311	2	3	localIOException1	java.io.IOException
    //   326	1	3	localObject2	Object
    //   345	2	3	localIOException2	java.io.IOException
    //   355	6	3	localObject3	Object
    //   366	2	3	localIOException3	java.io.IOException
    //   194	144	4	localBufferedInputStream	java.io.BufferedInputStream
    //   74	203	5	localObject4	Object
    //   279	9	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   319	9	5	localIOException4	java.io.IOException
    //   378	1	5	localIOException5	java.io.IOException
    //   383	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   95	113	6	str	String
    //   169	42	7	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   263	268	271	java/io/IOException
    //   179	196	279	java/lang/OutOfMemoryError
    //   297	302	311	java/io/IOException
    //   179	196	319	java/io/IOException
    //   337	342	345	java/io/IOException
    //   179	196	353	finally
    //   360	364	366	java/io/IOException
    //   199	225	374	finally
    //   228	255	374	finally
    //   287	292	374	finally
    //   327	332	374	finally
    //   199	225	378	java/io/IOException
    //   228	255	378	java/io/IOException
    //   199	225	383	java/lang/OutOfMemoryError
    //   228	255	383	java/lang/OutOfMemoryError
  }
  
  /* Error */
  protected Drawable a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:m_	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: iload_2
    //   22: invokevirtual 223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: new 127	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 141	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +17 -> 74
    //   60: aload 4
    //   62: instanceof 92
    //   65: ifeq +9 -> 74
    //   68: aload 4
    //   70: checkcast 92	android/graphics/drawable/Drawable
    //   73: areturn
    //   74: aload_0
    //   75: invokespecial 145	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	()Landroid/util/TypedValue;
    //   78: astore 5
    //   80: aload_1
    //   81: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   84: iload_2
    //   85: aload 5
    //   87: iconst_1
    //   88: invokevirtual 149	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   91: aload 5
    //   93: getfield 153	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   96: checkcast 155	java/lang/String
    //   99: astore 6
    //   101: aload_0
    //   102: aload 5
    //   104: invokespecial 157	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Landroid/util/TypedValue;)V
    //   107: aload 6
    //   109: ifnull +186 -> 295
    //   112: new 171	java/io/File
    //   115: dup
    //   116: new 127	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   123: aload_0
    //   124: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   127: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 161
    //   132: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore_3
    //   146: aload_3
    //   147: invokevirtual 177	java/io/File:exists	()Z
    //   150: ifeq +145 -> 295
    //   153: new 227	android/graphics/Rect
    //   156: dup
    //   157: invokespecial 228	android/graphics/Rect:<init>	()V
    //   160: astore 7
    //   162: new 234	java/io/BufferedInputStream
    //   165: dup
    //   166: new 182	java/io/FileInputStream
    //   169: dup
    //   170: aload_3
    //   171: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   177: astore 4
    //   179: aload 4
    //   181: astore_3
    //   182: aload 5
    //   184: sipush 480
    //   187: putfield 232	android/util/TypedValue:density	I
    //   190: aload 4
    //   192: astore_3
    //   193: aload_1
    //   194: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   197: aload 5
    //   199: aload 4
    //   201: aload 6
    //   203: aconst_null
    //   204: aload 7
    //   206: iconst_1
    //   207: invokestatic 243	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   210: astore 5
    //   212: aload 5
    //   214: ifnull +71 -> 285
    //   217: aload 4
    //   219: astore_3
    //   220: aload 5
    //   222: aload_1
    //   223: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   226: invokevirtual 249	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   229: astore 5
    //   231: aload 4
    //   233: astore_3
    //   234: aload_0
    //   235: new 127	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   242: aload_0
    //   243: getfield 20	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   246: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload_2
    //   250: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aload 5
    //   258: invokespecial 251	com/tencent/mobileqq/theme/ListenTogetherTheme/SkinDrawable:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   261: aload 5
    //   263: astore_1
    //   264: aload 4
    //   266: ifnull -240 -> 26
    //   269: aload 4
    //   271: invokevirtual 212	java/io/InputStream:close	()V
    //   274: aload 5
    //   276: areturn
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   282: aload 5
    //   284: areturn
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 212	java/io/InputStream:close	()V
    //   295: aload_1
    //   296: invokevirtual 119	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   299: iload_2
    //   300: invokevirtual 223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   303: areturn
    //   304: astore_3
    //   305: aload_3
    //   306: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   309: goto -14 -> 295
    //   312: astore 5
    //   314: aconst_null
    //   315: astore 4
    //   317: aload 4
    //   319: astore_3
    //   320: aload 5
    //   322: invokevirtual 252	java/lang/OutOfMemoryError:printStackTrace	()V
    //   325: aload 4
    //   327: ifnull -32 -> 295
    //   330: aload 4
    //   332: invokevirtual 212	java/io/InputStream:close	()V
    //   335: goto -40 -> 295
    //   338: astore_3
    //   339: aload_3
    //   340: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   343: goto -48 -> 295
    //   346: astore 5
    //   348: aconst_null
    //   349: astore 4
    //   351: aload 4
    //   353: astore_3
    //   354: aload 5
    //   356: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   359: aload 4
    //   361: ifnull -66 -> 295
    //   364: aload 4
    //   366: invokevirtual 212	java/io/InputStream:close	()V
    //   369: goto -74 -> 295
    //   372: astore_3
    //   373: aload_3
    //   374: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   377: goto -82 -> 295
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_3
    //   383: aload_3
    //   384: ifnull +7 -> 391
    //   387: aload_3
    //   388: invokevirtual 212	java/io/InputStream:close	()V
    //   391: aload_1
    //   392: athrow
    //   393: astore_3
    //   394: aload_3
    //   395: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   398: goto -7 -> 391
    //   401: astore_1
    //   402: goto -19 -> 383
    //   405: astore 5
    //   407: goto -56 -> 351
    //   410: astore 5
    //   412: goto -95 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	SkinDrawable
    //   0	415	1	paramContext	Context
    //   0	415	2	paramInt	int
    //   0	415	3	paramString	String
    //   53	312	4	localObject1	Object
    //   78	205	5	localObject2	Object
    //   312	9	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   346	9	5	localIOException1	java.io.IOException
    //   405	1	5	localIOException2	java.io.IOException
    //   410	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   99	103	6	str	String
    //   160	45	7	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   269	274	277	java/io/IOException
    //   290	295	304	java/io/IOException
    //   162	179	312	java/lang/OutOfMemoryError
    //   330	335	338	java/io/IOException
    //   162	179	346	java/io/IOException
    //   364	369	372	java/io/IOException
    //   162	179	380	finally
    //   387	391	393	java/io/IOException
    //   182	190	401	finally
    //   193	212	401	finally
    //   220	231	401	finally
    //   234	261	401	finally
    //   320	325	401	finally
    //   354	359	401	finally
    //   182	190	405	java/io/IOException
    //   193	212	405	java/io/IOException
    //   220	231	405	java/io/IOException
    //   234	261	405	java/io/IOException
    //   182	190	410	java/lang/OutOfMemoryError
    //   193	212	410	java/lang/OutOfMemoryError
    //   220	231	410	java/lang/OutOfMemoryError
    //   234	261	410	java/lang/OutOfMemoryError
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
    return this.jdField_a_of_type_JavaLangString + "/anim/" + paramString;
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof TextView)) {
      ((TextView)localView).setTextColor(a(paramView.getContext(), paramInt2));
    }
    while (!(localView instanceof SingleLineTextView)) {
      return;
    }
    ((SingleLineTextView)localView).setTextColor(a(paramView.getContext(), paramInt2));
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
    if ((!m_()) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    Object localObject1 = a(this.jdField_a_of_type_JavaLangString + paramInt);
    if ((localObject1 != null) && ((localObject1 instanceof Drawable))) {
      return (Drawable)localObject1;
    }
    localObject1 = a();
    paramContext.getResources().getValue(paramInt, (TypedValue)localObject1, true);
    Object localObject2 = (String)((TypedValue)localObject1).string;
    a((TypedValue)localObject1);
    if (localObject2 != null)
    {
      localObject1 = this.jdField_a_of_type_JavaLangString + "/drawable-xxhdpi/" + ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
      if (new File((String)localObject1).exists())
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inDensity = 480;
        ((BitmapFactory.Options)localObject2).inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
        BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
        BitmapManager.a((String)localObject1, (BitmapFactory.Options)localObject2, localBitmapDecodeResult);
        if (localBitmapDecodeResult.jdField_a_of_type_Int == 0)
        {
          paramContext = new ChatBackgroundDrawable(paramContext.getResources(), localBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap);
          a(this.jdField_a_of_type_JavaLangString + paramInt, paramContext);
          return paramContext;
        }
        QLog.e("SkinDrawable", 1, (String)localObject1 + " decodeFail: " + localBitmapDecodeResult.jdField_a_of_type_Int);
      }
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
  
  public boolean m_()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.SkinDrawable
 * JD-Core Version:    0.7.0.1
 */