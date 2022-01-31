package com.tencent.mobileqq.util;

import QQService.EVIPSPEC;
import akai;
import akaj;
import akak;
import akan;
import akao;
import akar;
import akau;
import akav;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.PersonalityLabel.Constants;
import com.tencent.mobileqq.profile.ProfileCardBackground;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.FriendProfileCardBgInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileCardUtil
{
  protected static long a;
  public static String a;
  public static StringBuilder a;
  public static ArrayList a;
  protected static HashMap a;
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "AT", "BE", "BG", "HR", "CY", "CZ", "DK", "EE", "FI", "FR", "DE", "GR", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "RO", "SK", "SI", "ES", "SE", "GB", "US" };
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(640, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static int a(Context paramContext)
  {
    int i = a(paramContext.getResources());
    return (int)((paramContext.getResources().getDisplayMetrics().heightPixels - i) * 0.75F);
  }
  
  public static final int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static final int a(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static final int a(Resources paramResources)
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {}
    for (;;)
    {
      return i;
      if ((paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 21)) {
        i = 1000;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42)) {
        i = 1001;
      } else if (paramAllInOne.jdField_a_of_type_Int == 86) {
        i = 10002;
      } else if (paramAllInOne.jdField_a_of_type_Int == 94) {
        i = 10004;
      } else if (paramAllInOne.jdField_a_of_type_Int == 3) {
        i = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 2) {
        i = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 74) {
        i = 1023;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 32) || (paramAllInOne.jdField_a_of_type_Int == 31) || (paramAllInOne.jdField_a_of_type_Int == 51) || (paramAllInOne.jdField_a_of_type_Int == 50) || (paramAllInOne.jdField_a_of_type_Int == 34) || (paramAllInOne.jdField_a_of_type_Int == 53)) {
        i = 1006;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47)) {
        i = 1004;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57)) {
        i = 1009;
      } else if (paramAllInOne.jdField_a_of_type_Int == 58) {
        i = 1020;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 72)) {
        i = 1021;
      } else if (paramAllInOne.jdField_a_of_type_Int != 70) {
        if ((paramAllInOne.jdField_a_of_type_Int == 27) || (paramAllInOne.jdField_a_of_type_Int == 25)) {
          i = 1022;
        } else if ((paramAllInOne.jdField_a_of_type_Int == 75) || (paramAllInOne.jdField_a_of_type_Int == 76)) {
          i = 1010;
        } else if (paramAllInOne.jdField_a_of_type_Int == 80) {
          i = 25;
        } else if (ProfileActivity.AllInOne.b(paramAllInOne.jdField_a_of_type_Int)) {
          i = 1029;
        } else {
          i = 1001;
        }
      }
    }
  }
  
  public static int a(String paramString)
  {
    int i1 = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    paramString = a(paramString, 100, 0.56338F);
    if (paramString == null) {}
    int i;
    do
    {
      return j;
      int k = 0;
      int n = 0;
      j = 0;
      while (k < paramString.getHeight())
      {
        int m = 0;
        i = n;
        if (m < paramString.getWidth())
        {
          n = paramString.getPixel(m, k);
          int i2 = Color.red(n);
          int i3 = Color.green(n);
          if ((Color.blue(n) + (i2 + i3)) / 3 > 127)
          {
            n = j + 1;
            j = i;
          }
          for (i = n;; i = n)
          {
            n = m + 1;
            m = i;
            i = j;
            j = m;
            m = n;
            break;
            n = j;
            j = i + 1;
          }
        }
        k += 1;
        n = i;
      }
      i = i1;
      if (j >= n) {
        i = 1;
      }
      paramString.recycle();
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCardUtil", 2, "-->calculate background color cost:" + (System.currentTimeMillis() - l) + "(ms)");
    return i;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() - jdField_a_of_type_Long;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramAllInOne == null)) {
      return 0L;
    }
    if ((paramAllInOne.jdField_c_of_type_JavaLangString != null) && (paramAllInOne.jdField_c_of_type_JavaLangString.length() > 0)) {
      paramQQAppInterface = paramAllInOne.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      paramAllInOne = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramAllInOne = "0";
      }
      try
      {
        long l = Long.valueOf(paramAllInOne).longValue();
        return l;
      }
      catch (Exception paramQQAppInterface)
      {
        return 0L;
      }
      if ((paramAllInOne.jdField_d_of_type_JavaLangString != null) && (paramAllInOne.jdField_d_of_type_JavaLangString.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.getEntityManagerFactory().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.jdField_d_of_type_JavaLangString });
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.troopuin;
          continue;
        }
      }
      paramQQAppInterface = "0";
    }
  }
  
  public static Intent a(Intent paramIntent, String paramString, QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, BusinessCard paramBusinessCard)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return paramIntent;
    }
    String str = String.format("http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramQQAppInterface.getAppid()), "android-7.6.3" });
    paramString = str;
    if (b()) {
      paramString = str + "&intl=1";
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
    }
    paramIntent = new Intent(paramIntent);
    paramIntent.putExtra("url", paramString);
    paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramIntent.putExtra("AllInOne", paramAllInOne);
    paramIntent.putExtra("BusinessCard", paramBusinessCard);
    return paramIntent;
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: new 369	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 372	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: invokevirtual 375	java/io/File:exists	()Z
    //   17: ifeq +19 -> 36
    //   20: aload_0
    //   21: invokevirtual 377	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +10 -> 36
    //   29: aload_0
    //   30: invokevirtual 380	java/io/File:isDirectory	()Z
    //   33: ifeq +9 -> 42
    //   36: aconst_null
    //   37: astore 7
    //   39: aload 7
    //   41: areturn
    //   42: new 382	java/io/BufferedInputStream
    //   45: dup
    //   46: new 384	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 387	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 390	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 396	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +13 -> 79
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: aload 6
    //   81: invokevirtual 217	android/graphics/Bitmap:getWidth	()I
    //   84: istore_3
    //   85: aload 6
    //   87: invokevirtual 214	android/graphics/Bitmap:getHeight	()I
    //   90: istore 4
    //   92: iload_3
    //   93: iload_1
    //   94: if_icmple +68 -> 162
    //   97: iload_1
    //   98: i2f
    //   99: fload_2
    //   100: fdiv
    //   101: f2i
    //   102: istore 5
    //   104: new 401	android/graphics/Matrix
    //   107: dup
    //   108: invokespecial 402	android/graphics/Matrix:<init>	()V
    //   111: astore 7
    //   113: aload 7
    //   115: iload_1
    //   116: i2f
    //   117: iload_3
    //   118: i2f
    //   119: fdiv
    //   120: iload 5
    //   122: i2f
    //   123: iload 4
    //   125: i2f
    //   126: fdiv
    //   127: invokevirtual 406	android/graphics/Matrix:postScale	(FF)Z
    //   130: pop
    //   131: aload 6
    //   133: iconst_0
    //   134: iconst_0
    //   135: iload_3
    //   136: iload 4
    //   138: aload 7
    //   140: iconst_1
    //   141: invokestatic 410	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   144: astore 7
    //   146: aload 6
    //   148: invokevirtual 234	android/graphics/Bitmap:recycle	()V
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   159: aload 7
    //   161: areturn
    //   162: aload 6
    //   164: astore 7
    //   166: aload_0
    //   167: ifnull -128 -> 39
    //   170: aload_0
    //   171: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   174: aload 6
    //   176: areturn
    //   177: astore_0
    //   178: aload 6
    //   180: areturn
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore 6
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   219: aload 6
    //   221: athrow
    //   222: astore_0
    //   223: goto -146 -> 77
    //   226: astore_0
    //   227: goto -68 -> 159
    //   230: astore_0
    //   231: goto -39 -> 192
    //   234: astore_0
    //   235: goto -30 -> 205
    //   238: astore_0
    //   239: goto -20 -> 219
    //   242: astore 6
    //   244: goto -33 -> 211
    //   247: astore 6
    //   249: goto -52 -> 197
    //   252: astore 6
    //   254: goto -70 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   0	257	1	paramInt	int
    //   0	257	2	paramFloat	float
    //   84	52	3	i	int
    //   90	47	4	j	int
    //   102	19	5	k	int
    //   62	117	6	localBitmap	Bitmap
    //   207	13	6	localObject1	Object
    //   242	1	6	localObject2	Object
    //   247	1	6	localException	Exception
    //   252	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   37	128	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   170	174	177	java/lang/Exception
    //   42	58	181	java/lang/OutOfMemoryError
    //   42	58	194	java/lang/Exception
    //   42	58	207	finally
    //   73	77	222	java/lang/Exception
    //   155	159	226	java/lang/Exception
    //   188	192	230	java/lang/Exception
    //   201	205	234	java/lang/Exception
    //   215	219	238	java/lang/Exception
    //   58	64	242	finally
    //   79	92	242	finally
    //   97	151	242	finally
    //   58	64	247	java/lang/Exception
    //   79	92	247	java/lang/Exception
    //   97	151	247	java/lang/Exception
    //   58	64	252	java/lang/OutOfMemoryError
    //   79	92	252	java/lang/OutOfMemoryError
    //   97	151	252	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +66 -> 67
    //   4: new 415	android/text/SpannableString
    //   7: dup
    //   8: ldc_w 417
    //   11: invokespecial 420	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   14: astore 10
    //   16: aload_0
    //   17: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc_w 421
    //   23: invokevirtual 425	android/content/res/Resources:getDimension	(I)F
    //   26: f2i
    //   27: istore_1
    //   28: aload_0
    //   29: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: ldc_w 426
    //   35: invokevirtual 430	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: iconst_0
    //   42: iload_1
    //   43: iload_1
    //   44: invokevirtual 436	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   47: aload 10
    //   49: new 438	android/text/style/ImageSpan
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 441	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   57: iconst_0
    //   58: iconst_1
    //   59: bipush 33
    //   61: invokevirtual 445	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   64: aload 10
    //   66: areturn
    //   67: iload_2
    //   68: bipush 64
    //   70: idiv
    //   71: istore 6
    //   73: iload_2
    //   74: bipush 64
    //   76: irem
    //   77: istore_2
    //   78: iload_2
    //   79: bipush 16
    //   81: idiv
    //   82: istore 7
    //   84: iload_2
    //   85: bipush 16
    //   87: irem
    //   88: istore 9
    //   90: iload 9
    //   92: iconst_4
    //   93: idiv
    //   94: istore 8
    //   96: ldc 24
    //   98: astore 11
    //   100: iconst_0
    //   101: istore 4
    //   103: iload 4
    //   105: iconst_4
    //   106: if_icmpge +137 -> 243
    //   109: iconst_0
    //   110: istore_2
    //   111: ldc 24
    //   113: astore 10
    //   115: iload 4
    //   117: tableswitch	default:+31 -> 148, 0:+71->188, 1:+82->199, 2:+93->210, 3:+104->221
    //   149: istore 5
    //   151: iload 5
    //   153: iload_2
    //   154: if_icmpge +80 -> 234
    //   157: new 244	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   164: aload 11
    //   166: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 10
    //   171: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 11
    //   179: iload 5
    //   181: iconst_1
    //   182: iadd
    //   183: istore 5
    //   185: goto -34 -> 151
    //   188: ldc_w 447
    //   191: astore 10
    //   193: iload 6
    //   195: istore_2
    //   196: goto -48 -> 148
    //   199: ldc_w 449
    //   202: astore 10
    //   204: iload 7
    //   206: istore_2
    //   207: goto -59 -> 148
    //   210: ldc_w 451
    //   213: astore 10
    //   215: iload 8
    //   217: istore_2
    //   218: goto -70 -> 148
    //   221: ldc_w 453
    //   224: astore 10
    //   226: iload 9
    //   228: iconst_4
    //   229: irem
    //   230: istore_2
    //   231: goto -83 -> 148
    //   234: iload 4
    //   236: iconst_1
    //   237: iadd
    //   238: istore 4
    //   240: goto -137 -> 103
    //   243: iload_3
    //   244: ifeq +491 -> 735
    //   247: aload 11
    //   249: invokevirtual 273	java/lang/String:length	()I
    //   252: iload_1
    //   253: if_icmple +482 -> 735
    //   256: aload 11
    //   258: iconst_0
    //   259: iload_1
    //   260: invokevirtual 457	java/lang/String:substring	(II)Ljava/lang/String;
    //   263: astore 10
    //   265: aload 10
    //   267: astore 14
    //   269: new 415	android/text/SpannableString
    //   272: dup
    //   273: aload 14
    //   275: invokespecial 420	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   278: astore 16
    //   280: aload_0
    //   281: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   284: ldc_w 421
    //   287: invokevirtual 425	android/content/res/Resources:getDimension	(I)F
    //   290: f2i
    //   291: istore 4
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: aload 14
    //   298: invokevirtual 273	java/lang/String:length	()I
    //   301: if_icmpge +406 -> 707
    //   304: aconst_null
    //   305: astore 13
    //   307: aconst_null
    //   308: astore 15
    //   310: aconst_null
    //   311: astore 12
    //   313: iload_2
    //   314: iload_1
    //   315: iconst_1
    //   316: isub
    //   317: if_icmpne +97 -> 414
    //   320: iload_3
    //   321: iconst_1
    //   322: if_icmpne +92 -> 414
    //   325: aload 13
    //   327: astore 10
    //   329: aload 15
    //   331: astore 11
    //   333: aload_0
    //   334: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 458
    //   340: invokevirtual 430	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   343: astore 12
    //   345: aload 12
    //   347: ifnull +50 -> 397
    //   350: aload 12
    //   352: astore 10
    //   354: aload 12
    //   356: astore 11
    //   358: aload 12
    //   360: iconst_0
    //   361: iconst_0
    //   362: iload 4
    //   364: iload 4
    //   366: invokevirtual 436	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   369: aload 12
    //   371: astore 10
    //   373: aload 12
    //   375: astore 11
    //   377: aload 16
    //   379: new 438	android/text/style/ImageSpan
    //   382: dup
    //   383: aload 12
    //   385: invokespecial 441	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   388: iload_2
    //   389: iload_2
    //   390: iconst_1
    //   391: iadd
    //   392: bipush 33
    //   394: invokevirtual 445	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   397: aload 16
    //   399: areturn
    //   400: astore 10
    //   402: aload 10
    //   404: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   407: aload 11
    //   409: astore 14
    //   411: goto -142 -> 269
    //   414: aload 13
    //   416: astore 10
    //   418: aload 15
    //   420: astore 11
    //   422: ldc_w 447
    //   425: aload 14
    //   427: iload_2
    //   428: iload_2
    //   429: iconst_1
    //   430: iadd
    //   431: invokevirtual 457	java/lang/String:substring	(II)Ljava/lang/String;
    //   434: invokevirtual 465	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   437: ifeq +23 -> 460
    //   440: aload 13
    //   442: astore 10
    //   444: aload 15
    //   446: astore 11
    //   448: aload_0
    //   449: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 466
    //   455: invokevirtual 430	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   458: astore 12
    //   460: aload 12
    //   462: astore 13
    //   464: aload 12
    //   466: astore 10
    //   468: aload 12
    //   470: astore 11
    //   472: ldc_w 449
    //   475: aload 14
    //   477: iload_2
    //   478: iload_2
    //   479: iconst_1
    //   480: iadd
    //   481: invokevirtual 457	java/lang/String:substring	(II)Ljava/lang/String;
    //   484: invokevirtual 465	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   487: ifeq +23 -> 510
    //   490: aload 12
    //   492: astore 10
    //   494: aload 12
    //   496: astore 11
    //   498: aload_0
    //   499: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   502: ldc_w 467
    //   505: invokevirtual 430	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   508: astore 13
    //   510: aload 13
    //   512: astore 10
    //   514: aload 13
    //   516: astore 11
    //   518: ldc_w 451
    //   521: aload 14
    //   523: iload_2
    //   524: iload_2
    //   525: iconst_1
    //   526: iadd
    //   527: invokevirtual 457	java/lang/String:substring	(II)Ljava/lang/String;
    //   530: invokevirtual 465	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   533: ifeq +195 -> 728
    //   536: aload 13
    //   538: astore 10
    //   540: aload 13
    //   542: astore 11
    //   544: aload_0
    //   545: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   548: ldc_w 468
    //   551: invokevirtual 430	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   554: astore 12
    //   556: aload 12
    //   558: astore 10
    //   560: aload 10
    //   562: astore 11
    //   564: ldc_w 453
    //   567: aload 14
    //   569: iload_2
    //   570: iload_2
    //   571: iconst_1
    //   572: iadd
    //   573: invokevirtual 457	java/lang/String:substring	(II)Ljava/lang/String;
    //   576: invokevirtual 465	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +15 -> 594
    //   582: aload_0
    //   583: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   586: ldc_w 469
    //   589: invokevirtual 430	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   592: astore 11
    //   594: aload 11
    //   596: astore 10
    //   598: aload 10
    //   600: ifnull +34 -> 634
    //   603: aload 10
    //   605: iconst_0
    //   606: iconst_0
    //   607: iload 4
    //   609: iload 4
    //   611: invokevirtual 436	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   614: aload 16
    //   616: new 438	android/text/style/ImageSpan
    //   619: dup
    //   620: aload 10
    //   622: invokespecial 441	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   625: iload_2
    //   626: iload_2
    //   627: iconst_1
    //   628: iadd
    //   629: bipush 33
    //   631: invokevirtual 445	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   634: iload_2
    //   635: iconst_1
    //   636: iadd
    //   637: istore_2
    //   638: goto -343 -> 295
    //   641: astore 12
    //   643: aload 10
    //   645: astore 11
    //   647: aload 11
    //   649: astore 10
    //   651: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -56 -> 598
    //   657: ldc_w 337
    //   660: iconst_2
    //   661: aload 12
    //   663: invokevirtual 470	java/lang/Error:toString	()Ljava/lang/String;
    //   666: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload 11
    //   671: astore 10
    //   673: goto -75 -> 598
    //   676: astore 12
    //   678: aload 11
    //   680: astore 10
    //   682: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq -87 -> 598
    //   688: ldc_w 337
    //   691: iconst_2
    //   692: aload 12
    //   694: invokevirtual 471	java/lang/Exception:toString	()Ljava/lang/String;
    //   697: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: aload 11
    //   702: astore 10
    //   704: goto -106 -> 598
    //   707: aload 16
    //   709: areturn
    //   710: astore 12
    //   712: aload 10
    //   714: astore 11
    //   716: goto -38 -> 678
    //   719: astore 12
    //   721: aload 10
    //   723: astore 11
    //   725: goto -78 -> 647
    //   728: aload 13
    //   730: astore 10
    //   732: goto -172 -> 560
    //   735: aload 11
    //   737: astore 10
    //   739: goto -474 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	paramContext	Context
    //   0	742	1	paramInt1	int
    //   0	742	2	paramInt2	int
    //   0	742	3	paramBoolean	boolean
    //   101	509	4	i	int
    //   149	35	5	j	int
    //   71	123	6	k	int
    //   82	123	7	m	int
    //   94	122	8	n	int
    //   88	142	9	i1	int
    //   14	358	10	localObject1	Object
    //   400	3	10	localException1	Exception
    //   416	322	10	localObject2	Object
    //   98	638	11	localObject3	Object
    //   311	246	12	localDrawable	Drawable
    //   641	21	12	localError1	java.lang.Error
    //   676	17	12	localException2	Exception
    //   710	1	12	localException3	Exception
    //   719	1	12	localError2	java.lang.Error
    //   305	424	13	localObject4	Object
    //   267	301	14	localObject5	Object
    //   308	137	15	localObject6	Object
    //   278	430	16	localSpannableString	SpannableString
    // Exception table:
    //   from	to	target	type
    //   247	265	400	java/lang/Exception
    //   333	345	641	java/lang/Error
    //   358	369	641	java/lang/Error
    //   377	397	641	java/lang/Error
    //   422	440	641	java/lang/Error
    //   448	460	641	java/lang/Error
    //   472	490	641	java/lang/Error
    //   498	510	641	java/lang/Error
    //   518	536	641	java/lang/Error
    //   544	556	641	java/lang/Error
    //   333	345	676	java/lang/Exception
    //   358	369	676	java/lang/Exception
    //   377	397	676	java/lang/Exception
    //   422	440	676	java/lang/Exception
    //   448	460	676	java/lang/Exception
    //   472	490	676	java/lang/Exception
    //   498	510	676	java/lang/Exception
    //   518	536	676	java/lang/Exception
    //   544	556	676	java/lang/Exception
    //   564	594	710	java/lang/Exception
    //   564	594	719	java/lang/Error
  }
  
  public static FriendProfileCardBgDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    FriendProfileCardBgInfo localFriendProfileCardBgInfo = null;
    if (!paramString1.equals(""))
    {
      localFriendProfileCardBgInfo = a(FileUtils.a(new File(paramString1, "config.json"), -1));
      if (localFriendProfileCardBgInfo != null)
      {
        String[] arrayOfString = new String[localFriendProfileCardBgInfo.jdField_a_of_type_Int];
        int i = 0;
        while (i < localFriendProfileCardBgInfo.jdField_a_of_type_Int)
        {
          arrayOfString[i] = (paramString1 + "/" + (i + 1) + ".png");
          i += 1;
        }
        localFriendProfileCardBgInfo.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
      }
    }
    paramString1 = localFriendProfileCardBgInfo;
    if (localFriendProfileCardBgInfo == null) {
      paramString1 = new FriendProfileCardBgInfo();
    }
    if (paramString1 != null) {
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
    }
    return new FriendProfileCardBgDrawable(paramResources, paramString1);
  }
  
  public static Card a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    byte b2 = 1;
    FriendsManager localFriendsManager;
    OlympicManager localOlympicManager;
    byte b1;
    try
    {
      localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
      localOlympicManager = (OlympicManager)paramQQAppInterface.getManager(166);
      if (localFriendsManager == null) {
        break label573;
      }
      localObject1 = localFriendsManager.c(paramString);
      paramQQAppInterface = localFriendsManager.a(paramString);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCardUtil", 2, "initCard card = null, uin = " + paramString);
        }
        paramQQAppInterface = new Card();
        paramQQAppInterface.uin = paramString;
        paramQQAppInterface.shGender = -1;
        if (localOlympicManager.a(paramString))
        {
          b1 = 1;
          paramQQAppInterface.olympicTorch = b1;
          if (localObject1 == null) {
            break label420;
          }
          paramQQAppInterface.strNick = ((Friends)localObject1).name;
          paramQQAppInterface.strReMark = ((Friends)localObject1).remark;
          paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            break label405;
          }
          b1 = 1;
          label166:
          paramQQAppInterface.bQQVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label410;
          }
          b1 = 1;
          label184:
          paramQQAppInterface.bSuperVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
            break label415;
          }
          b1 = b2;
          label202:
          paramQQAppInterface.bSuperQQOpen = b1;
          if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
            QLog.d("ProfileCardUtil", 2, "initCard bSuperVipOpen=" + paramQQAppInterface.bSuperVipOpen + ",bQQVipOpen=" + paramQQAppInterface.bQQVipOpen + ",uin = " + paramString);
          }
          paramQQAppInterface.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.iQQVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.lUserFlag = ((Friends)localObject1).cSpecialFlag;
          paramQQAppInterface.namePlateOfKingGameId = ((Friends)localObject1).namePlateOfKingGameId;
          paramQQAppInterface.namePlateOfKingLoginTime = ((Friends)localObject1).namePlateOfKingLoginTime;
        }
        for (;;)
        {
          if (localFriendsManager == null) {
            break label570;
          }
          localFriendsManager.a(paramQQAppInterface);
          label381:
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.getBusiEntrys();
            paramQQAppInterface.getPersonalityLabel();
          }
          return paramQQAppInterface;
          b1 = 0;
          break;
          label405:
          b1 = 0;
          break label166;
          label410:
          b1 = 0;
          break label184;
          label415:
          b1 = 0;
          break label202;
          label420:
          paramQQAppInterface.strSign = "";
          paramQQAppInterface.strNick = "";
          paramQQAppInterface.strReMark = "";
        }
      }
      if (localObject1 == null) {
        break label547;
      }
    }
    finally {}
    int i;
    label479:
    boolean bool2;
    boolean bool1;
    if (!Utils.a(((Friends)localObject1).alias, paramQQAppInterface.strShowName))
    {
      paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
      i = 1;
      if ((((Friends)localObject1).cSpecialFlag & 0x1) == 1) {
        paramQQAppInterface.lUserFlag |= 1L;
      }
      bool2 = localOlympicManager.a(paramString);
      if (paramQQAppInterface.olympicTorch == 1)
      {
        bool1 = true;
        break label586;
      }
    }
    for (;;)
    {
      label522:
      paramQQAppInterface.olympicTorch = b1;
      i = 1;
      label530:
      if ((localFriendsManager != null) && (i != 0)) {
        localFriendsManager.a(paramQQAppInterface);
      }
      label547:
      break label381;
      bool1 = false;
      label570:
      label573:
      label586:
      do
      {
        b1 = 0;
        break label522;
        do
        {
          break label530;
          i = 0;
          break label479;
          break label381;
          Object localObject2 = null;
          paramQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = localObject2;
          break;
        } while (bool1 == bool2);
      } while (!bool2);
      b1 = 1;
    }
  }
  
  public static ProfileCardTemplate a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int k = 0;
    if (paramLong == ProfileCardTemplate.jdField_a_of_type_Long) {
      return null;
    }
    ArrayList localArrayList = a(paramQQAppInterface, true, paramBoolean);
    int m = localArrayList.size();
    int i = 0;
    paramQQAppInterface = null;
    int j = k;
    if (i < m)
    {
      paramQQAppInterface = (ProfileCardTemplate)localArrayList.get(i);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.jdField_l_of_type_Long == paramLong)) {
        j = 1;
      }
    }
    else
    {
      if ((j != 1) || (paramQQAppInterface == null)) {
        break label92;
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      i += 1;
      break;
      label92:
      paramQQAppInterface = null;
    }
  }
  
  public static ProfileCardTemplate a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {
      return null;
    }
    ProfileCardTemplate localProfileCardTemplate = new ProfileCardTemplate();
    localProfileCardTemplate.jdField_l_of_type_Long = paramProfileCardTemplate.jdField_l_of_type_Long;
    localProfileCardTemplate.jdField_a_of_type_JavaLangString = paramProfileCardTemplate.jdField_a_of_type_JavaLangString;
    localProfileCardTemplate.jdField_b_of_type_JavaLangString = paramProfileCardTemplate.jdField_b_of_type_JavaLangString;
    localProfileCardTemplate.jdField_c_of_type_JavaLangString = paramProfileCardTemplate.jdField_c_of_type_JavaLangString;
    localProfileCardTemplate.jdField_a_of_type_Int = paramProfileCardTemplate.jdField_a_of_type_Int;
    localProfileCardTemplate.jdField_b_of_type_Int = paramProfileCardTemplate.jdField_b_of_type_Int;
    localProfileCardTemplate.jdField_c_of_type_Int = paramProfileCardTemplate.jdField_c_of_type_Int;
    localProfileCardTemplate.jdField_d_of_type_JavaLangString = paramProfileCardTemplate.jdField_d_of_type_JavaLangString;
    localProfileCardTemplate.jdField_e_of_type_JavaLangString = paramProfileCardTemplate.jdField_e_of_type_JavaLangString;
    localProfileCardTemplate.jdField_f_of_type_JavaLangString = paramProfileCardTemplate.jdField_f_of_type_JavaLangString;
    localProfileCardTemplate.jdField_g_of_type_JavaLangString = paramProfileCardTemplate.jdField_g_of_type_JavaLangString;
    localProfileCardTemplate.jdField_h_of_type_JavaLangString = paramProfileCardTemplate.jdField_h_of_type_JavaLangString;
    localProfileCardTemplate.jdField_i_of_type_JavaLangString = paramProfileCardTemplate.jdField_i_of_type_JavaLangString;
    localProfileCardTemplate.jdField_j_of_type_JavaLangString = paramProfileCardTemplate.jdField_j_of_type_JavaLangString;
    localProfileCardTemplate.jdField_k_of_type_JavaLangString = paramProfileCardTemplate.jdField_k_of_type_JavaLangString;
    localProfileCardTemplate.jdField_d_of_type_Int = paramProfileCardTemplate.jdField_d_of_type_Int;
    localProfileCardTemplate.p = paramProfileCardTemplate.p;
    localProfileCardTemplate.q = paramProfileCardTemplate.q;
    localProfileCardTemplate.r = paramProfileCardTemplate.r;
    localProfileCardTemplate.s = paramProfileCardTemplate.s;
    localProfileCardTemplate.jdField_l_of_type_JavaLangString = paramProfileCardTemplate.jdField_l_of_type_JavaLangString;
    localProfileCardTemplate.n = paramProfileCardTemplate.n;
    localProfileCardTemplate.m = paramProfileCardTemplate.m;
    localProfileCardTemplate.o = paramProfileCardTemplate.o;
    localProfileCardTemplate.jdField_h_of_type_Int = paramProfileCardTemplate.jdField_h_of_type_Int;
    localProfileCardTemplate.t = paramProfileCardTemplate.t;
    localProfileCardTemplate.jdField_i_of_type_Int = paramProfileCardTemplate.jdField_i_of_type_Int;
    localProfileCardTemplate.jdField_j_of_type_Int = paramProfileCardTemplate.jdField_j_of_type_Int;
    localProfileCardTemplate.jdField_k_of_type_Int = paramProfileCardTemplate.jdField_k_of_type_Int;
    localProfileCardTemplate.jdField_e_of_type_Int = paramProfileCardTemplate.jdField_e_of_type_Int;
    localProfileCardTemplate.jdField_f_of_type_Int = paramProfileCardTemplate.jdField_f_of_type_Int;
    localProfileCardTemplate.jdField_g_of_type_Int = paramProfileCardTemplate.jdField_g_of_type_Int;
    localProfileCardTemplate.jdField_l_of_type_Int = paramProfileCardTemplate.jdField_l_of_type_Int;
    localProfileCardTemplate.jdField_a_of_type_Boolean = paramProfileCardTemplate.jdField_a_of_type_Boolean;
    return localProfileCardTemplate;
  }
  
  public static FriendProfileCardBgInfo a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ProfileCardUtil", 2, "do parse ProfileCardBgInfo");
      }
      FriendProfileCardBgInfo localFriendProfileCardBgInfo = new FriendProfileCardBgInfo();
      try
      {
        paramString = new JSONObject(paramString);
        localFriendProfileCardBgInfo.jdField_b_of_type_Int = paramString.getInt("frameInterval");
        localFriendProfileCardBgInfo.jdField_a_of_type_Int = paramString.getInt("frameNumber");
        localFriendProfileCardBgInfo.jdField_a_of_type_Float = ((float)paramString.getDouble("positionX"));
        localFriendProfileCardBgInfo.jdField_b_of_type_Float = ((float)paramString.getDouble("positionY"));
        localFriendProfileCardBgInfo.c = ((float)paramString.getDouble("width"));
        localFriendProfileCardBgInfo.d = ((float)paramString.getDouble("height"));
        return localFriendProfileCardBgInfo;
      }
      catch (JSONException paramString)
      {
        QLog.e("ProfileCardUtil", 2, "parse, exception=" + MsfSdkUtils.getStackTraceString(paramString));
      }
    }
    return null;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return localStringBuilder.toString();
  }
  
  public static String a(byte paramByte)
  {
    switch (paramByte)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return "水瓶座";
    case 2: 
      return "双鱼座";
    case 3: 
      return "白羊座";
    case 4: 
      return "金牛座";
    case 5: 
      return "双子座";
    case 6: 
      return "巨蟹座";
    case 7: 
      return "狮子座";
    case 8: 
      return "处女座";
    case 9: 
      return "天秤座";
    case 10: 
      return "天蝎座";
    case 11: 
      return "射手座";
    }
    return "摩羯座";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 2: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 3: 
      return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    case 4: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    }
    return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_label_config.json" + "7.6.3";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131433941));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(paramContext.getString(2131433943));
        localStringBuilder.append("  ");
      }
      paramContext = NearbyProfileUtil.c(paramInt3);
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(paramContext);
        localStringBuilder.append("  ");
      }
      String str = "";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = str;
        if (!"中国".equals(paramString1)) {
          paramContext = "" + paramString1;
        }
      }
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramString1 = paramContext + "-";
        }
        paramString1 = paramString1 + paramString2;
      }
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext = paramString1 + "-";
        }
        paramContext = paramContext + paramString3;
      }
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(paramContext.getString(2131433942));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131433941));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(paramContext.getString(2131433943));
        localStringBuilder.append("  ");
      }
      String str = "";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = str;
        if (!"中国".equals(paramString1)) {
          paramContext = "" + paramString1;
        }
      }
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramString1 = paramContext + " ";
        }
        paramString1 = paramString1 + paramString2;
      }
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext = paramString1 + " ";
        }
        paramContext = paramContext + paramString3;
      }
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(paramContext.getString(2131433942));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public static String a(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i = -1;
    paramProfileCardInfo = "";
    Object localObject;
    if (localCard != null)
    {
      i = localCard.age;
      localObject = paramProfileCardInfo;
      if (i > 0)
      {
        localObject = paramProfileCardInfo;
        if (!b()) {
          localObject = i + paramContext.getString(2131433943);
        }
      }
      paramProfileCardInfo = "";
      if (localCard == null) {
        break label353;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(localCard.strCountry))
      {
        paramContext = paramProfileCardInfo;
        if (!"中国".equals(localCard.strCountry)) {
          paramContext = "" + localCard.strCountry;
        }
      }
      paramProfileCardInfo = paramContext;
      if (!TextUtils.isEmpty(localCard.strProvince))
      {
        paramProfileCardInfo = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramProfileCardInfo = paramContext + " ";
        }
        paramProfileCardInfo = paramProfileCardInfo + localCard.strProvince;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(localCard.strCity))
      {
        paramContext = paramProfileCardInfo;
        if (!TextUtils.isEmpty(paramProfileCardInfo)) {
          paramContext = paramProfileCardInfo + " ";
        }
        paramContext = paramContext + localCard.strCity;
      }
      label260:
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label548;
      }
    }
    label548:
    for (paramProfileCardInfo = "" + " " + (String)localObject;; paramProfileCardInfo = "")
    {
      localObject = paramProfileCardInfo;
      if (paramContext != null)
      {
        localObject = paramProfileCardInfo;
        if (paramContext.length() > 0) {
          localObject = paramProfileCardInfo + " " + paramContext;
        }
      }
      return localObject;
      if (localContactCard == null) {
        break;
      }
      i = localContactCard.bAge;
      break;
      label353:
      paramContext = paramProfileCardInfo;
      if (localContactCard == null) {
        break label260;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(localContactCard.strCountry))
      {
        paramContext = paramProfileCardInfo;
        if (!"中国".equals(localContactCard.strCountry)) {
          paramContext = "" + localContactCard.strCountry;
        }
      }
      paramProfileCardInfo = paramContext;
      if (!TextUtils.isEmpty(localContactCard.strProvince))
      {
        paramProfileCardInfo = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramProfileCardInfo = paramContext + " ";
        }
        paramProfileCardInfo = paramProfileCardInfo + localContactCard.strProvince;
      }
      paramContext = paramProfileCardInfo;
      if (TextUtils.isEmpty(localContactCard.strCity)) {
        break label260;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(paramProfileCardInfo)) {
        paramContext = paramProfileCardInfo + " ";
      }
      paramContext = paramContext + localContactCard.strCity;
      break label260;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return c(paramContext) + c(paramString);
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    String str = "";
    Object localObject = str;
    if (paramAllInOne != null)
    {
      localObject = str;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = str;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject == null) {
            break label99;
          }
        }
      }
    }
    label99:
    for (str = ((ProfileActivity.CardContactInfo)localObject).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject).jdField_c_of_type_JavaLangString;; str = "")
    {
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) {
          localObject = paramAllInOne.jdField_a_of_type_JavaLangString;
        }
      }
      return localObject;
    }
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramAllInOne.jdField_a_of_type_JavaLangString;
    QidianManager localQidianManager = (QidianManager)paramQQAppInterface.getManager(164);
    if (localQidianManager.a(str)) {
      paramQQAppInterface = String.format("https://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027", new Object[] { str, String.valueOf(paramQQAppInterface.getAppid()), "android-7.6.3" });
    }
    for (;;)
    {
      paramActivity = paramQQAppInterface;
      if (ProfileActivity.AllInOne.i(paramAllInOne)) {
        paramActivity = paramQQAppInterface + "&adtag=campus";
      }
      return paramActivity;
      if (localQidianManager.f(str))
      {
        paramQQAppInterface = paramActivity.getIntent().getStringExtra("key_qidian_detail_url");
      }
      else
      {
        paramActivity = String.format("http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { str, String.valueOf(paramQQAppInterface.getAppid()), "android-7.6.3" });
        paramQQAppInterface = paramActivity;
        if (b()) {
          paramQQAppInterface = paramActivity + "&intl=1";
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bU);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramQQAppInterface = "0" + i;
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label308;
      }
      paramQQAppInterface = "0" + i;
      label111:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label316;
      }
      paramQQAppInterface = "0" + i;
      label152:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label324;
      }
      paramQQAppInterface = "0" + i;
      label193:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label332;
      }
    }
    label308:
    label316:
    label324:
    label332:
    for (paramQQAppInterface = "0" + i;; paramQQAppInterface = Integer.valueOf(i))
    {
      localStringBuilder.append(paramQQAppInterface);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label340;
      }
      return localStringBuilder.toString() + ".jpg";
      paramQQAppInterface = Integer.valueOf(i);
      break;
      paramQQAppInterface = Integer.valueOf(i);
      break label111;
      paramQQAppInterface = Integer.valueOf(i);
      break label152;
      paramQQAppInterface = Integer.valueOf(i);
      break label193;
    }
    label340:
    paramQQAppInterface = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        paramQQAppInterface.append('(');
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(')');
        paramQQAppInterface.append(".jpg");
        if (new File(paramQQAppInterface.toString()).exists()) {}
      }
      else
      {
        return paramQQAppInterface.toString();
      }
      paramQQAppInterface.delete(j, paramQQAppInterface.length());
      i += 1;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getDir(".profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return paramQQAppInterface + File.separator + "common_" + "583";
    }
    if ((paramLong != ProfileCardTemplate.jdField_a_of_type_Long) && (paramLong > 0L)) {
      return paramQQAppInterface + File.separator + paramLong;
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    int j = 10;
    int i;
    if ((paramInt == 1102) || (paramInt == 10022) || (paramInt == 10029))
    {
      j = 50;
      i = 1;
    }
    for (;;)
    {
      if (((paramInt != 1101) && (paramInt != 10026) && (paramInt != 10027) && (paramInt != 11011)) || ((!TextUtils.isEmpty(paramString2)) || (paramInt == 10000)))
      {
        List localList2 = paramQQAppInterface.a().a(paramString2, 1, 100);
        if (localList2 != null)
        {
          localList1 = localList2;
          if (!localList2.isEmpty()) {
            break label121;
          }
        }
      }
      for (List localList1 = paramQQAppInterface.a().a(paramString2, 3000, 100);; localList1 = paramQQAppInterface.a().a(paramString1, i, j * 2))
      {
        label121:
        return a(paramString1, paramString2, paramInt, j, localList1);
        if (paramInt == 1014)
        {
          j = 50;
          i = 3000;
          break;
        }
        if (paramInt != 10000) {
          break label187;
        }
        j = 20;
        i = 1;
        break;
      }
      label187:
      i = 0;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, List paramList)
  {
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      if ((localObject2 instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localObject2;
        if (((MessageForMixedMsg)localObject2).msgElemList != null)
        {
          localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            if (a((MessageRecord)localObject4))
            {
              ((MessageRecord)localObject4).istroop = ((MessageForMixedMsg)localObject2).istroop;
              ((MessageRecord)localObject4).senderuin = ((MessageForMixedMsg)localObject2).senderuin;
              ((MessageRecord)localObject4).selfuin = ((MessageForMixedMsg)localObject2).selfuin;
              ((MessageRecord)localObject4).frienduin = ((MessageForMixedMsg)localObject2).frienduin;
              ((List)localObject1).add(localObject4);
            }
          }
        }
      }
      else if (a((MessageRecord)localObject2))
      {
        if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg)))
        {
          if (((MessageRecord)localObject2).msgtype == -1000) {
            ((List)localObject1).add(localObject2);
          }
        }
        else {
          ((List)localObject1).add(localObject2);
        }
      }
    }
    Object localObject4 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      if (paramList != null)
      {
        label301:
        int i;
        if ((paramList.istroop == 1000) || (paramList.istroop == 1004)) {
          if (paramList.isSend())
          {
            localObject1 = paramList.selfuin;
            if (((paramInt1 == 1101) || (paramInt1 == 10026) || (paramInt1 == 10027) || (paramInt1 == 11011)) && (((!TextUtils.isEmpty(paramString2)) && (!TextUtils.equals((CharSequence)localObject1, paramString1))) || ((paramInt1 == 10000) && (!TextUtils.equals((CharSequence)localObject1, paramString1))))) {
              break label697;
            }
            if (!(paramList instanceof MessageForPic)) {
              break label699;
            }
            paramList = (MessageForPic)paramList;
            paramList.parse();
            paramList = paramList.uuid;
            localObject2 = "2";
            i = 0;
            label396:
            localObject3 = paramList;
            if (i != 0) {}
          }
        }
        for (;;)
        {
          for (;;)
          {
            label697:
            label699:
            try
            {
              localObject3 = paramList.replace("\"", "\\\"");
              paramList = (List)localObject3;
            }
            catch (Throwable localThrowable1) {}
            try
            {
              localObject3 = ((String)localObject3).replace("'", "\\'");
              paramList = (List)localObject3;
              localObject3 = ((String)localObject3).replace("|", "\\|");
              paramList = (List)localObject3;
              localObject3 = ((String)localObject3).replace(":", "\\:");
              paramList = (List)localObject3;
              localObject3 = ((String)localObject3).replace(";", "\\;");
              paramList = (List)localObject3;
              localObject3 = ((String)localObject3).replace("[", "\\[");
              paramList = (List)localObject3;
              localObject3 = ((String)localObject3).replace("]", "\\]");
              paramList = (List)localObject3;
              localObject3 = ((String)localObject3).replace("=", "\\=");
              paramList = new StringBuffer();
              paramList.append("[");
              paramList.append("uin=" + (String)localObject1);
              paramList.append(";");
              paramList.append("content=" + (String)localObject3);
              paramList.append(";");
              paramList.append("type=" + (String)localObject2);
              paramList.append("]");
              ((List)localObject4).add(paramList.toString());
            }
            catch (Throwable localThrowable2)
            {
              label776:
              List localList;
              break label776;
            }
          }
          localObject1 = paramList.frienduin;
          break label301;
          localObject1 = paramList.senderuin;
          break label301;
          break;
          if (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))
          {
            paramList = paramList.msg;
            localObject2 = "1";
            i = 0;
            break label396;
          }
          if (!(paramList instanceof MessageForStructing)) {
            break;
          }
          paramList = ((MessageForStructing)paramList).structingMsg;
          if (paramList == null) {
            break;
          }
          paramList = paramList.getXml();
          i = 1;
          localObject2 = "3";
          break label396;
          localThrowable1.printStackTrace();
          localList = paramList;
        }
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("chatmsg:");
    if (((List)localObject4).size() > paramInt2) {
      paramInt1 = ((List)localObject4).size() - paramInt2;
    }
    while (paramInt1 < ((List)localObject4).size())
    {
      paramString1.append((String)((List)localObject4).get(paramInt1));
      paramInt1 += 1;
      continue;
      paramInt1 = 0;
    }
    return URLEncoder.encode(paramString1.toString(), "UTF-8");
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open427";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open429";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open4210";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open422";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open424";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open425";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open421";
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open413";
          }
          return "mvip.gongneng.android.mingpian_open412";
        }
        if (paramInt2 == 2) {
          return "mvip.gongneng.android.mingpian_open411";
        }
      }
    }
    return "";
  }
  
  /* Error */
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc_w 337
    //   12: iconst_2
    //   13: ldc_w 1180
    //   16: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 968	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 1182	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   28: astore 8
    //   30: new 369	java/io/File
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 372	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 375	java/io/File:exists	()Z
    //   46: istore 5
    //   48: iload 5
    //   50: ifne +8 -> 58
    //   53: ldc_w 1184
    //   56: astore 8
    //   58: getstatic 26	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: aload 8
    //   63: invokestatic 1058	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   66: ifeq +20 -> 86
    //   69: getstatic 22	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   72: invokevirtual 1185	java/util/ArrayList:isEmpty	()Z
    //   75: ifne +11 -> 86
    //   78: iload_1
    //   79: ifne +7 -> 86
    //   82: getstatic 22	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: areturn
    //   86: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +13 -> 102
    //   92: ldc_w 337
    //   95: iconst_2
    //   96: ldc_w 1187
    //   99: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: new 17	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 20	java/util/ArrayList:<init>	()V
    //   109: astore 10
    //   111: iload 5
    //   113: ifeq +103 -> 216
    //   116: new 384	java/io/FileInputStream
    //   119: dup
    //   120: aload 7
    //   122: invokespecial 387	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_0
    //   126: new 1189	java/io/ByteArrayOutputStream
    //   129: dup
    //   130: invokespecial 1190	java/io/ByteArrayOutputStream:<init>	()V
    //   133: astore 7
    //   135: sipush 4096
    //   138: newarray byte
    //   140: astore 6
    //   142: aload_0
    //   143: aload 6
    //   145: iconst_0
    //   146: sipush 4096
    //   149: invokevirtual 1196	java/io/InputStream:read	([BII)I
    //   152: istore_2
    //   153: iload_2
    //   154: iconst_m1
    //   155: if_icmpeq +75 -> 230
    //   158: aload 7
    //   160: aload 6
    //   162: iconst_0
    //   163: iload_2
    //   164: invokevirtual 1200	java/io/ByteArrayOutputStream:write	([BII)V
    //   167: goto -25 -> 142
    //   170: astore 9
    //   172: aload 7
    //   174: astore 6
    //   176: aload 9
    //   178: astore 7
    //   180: aload 7
    //   182: invokevirtual 1136	java/lang/Throwable:printStackTrace	()V
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 1201	java/io/InputStream:close	()V
    //   193: aload 6
    //   195: ifnull +8 -> 203
    //   198: aload 6
    //   200: invokevirtual 1202	java/io/ByteArrayOutputStream:close	()V
    //   203: aload 8
    //   205: putstatic 26	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   208: aload 10
    //   210: putstatic 22	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   213: aload 10
    //   215: areturn
    //   216: aload_0
    //   217: invokevirtual 1206	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   220: ldc_w 1208
    //   223: invokevirtual 1214	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   226: astore_0
    //   227: goto -101 -> 126
    //   230: new 28	java/lang/String
    //   233: dup
    //   234: aload 7
    //   236: invokevirtual 1218	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   239: ldc_w 1220
    //   242: invokespecial 1223	java/lang/String:<init>	([BLjava/lang/String;)V
    //   245: astore 6
    //   247: aload 6
    //   249: invokevirtual 273	java/lang/String:length	()I
    //   252: ifle +596 -> 848
    //   255: new 751	org/json/JSONObject
    //   258: dup
    //   259: aload 6
    //   261: invokespecial 752	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   264: astore 6
    //   266: aload 6
    //   268: ldc_w 1225
    //   271: invokevirtual 1228	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +574 -> 848
    //   277: aload 6
    //   279: ldc_w 1225
    //   282: invokevirtual 1232	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   285: astore 6
    //   287: aload 6
    //   289: invokevirtual 1235	org/json/JSONArray:length	()I
    //   292: istore_3
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: iload_3
    //   297: if_icmpge +489 -> 786
    //   300: aload 6
    //   302: iload_2
    //   303: invokevirtual 1239	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   306: astore 9
    //   308: new 651	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   311: dup
    //   312: invokespecial 667	com/tencent/mobileqq/profile/ProfileCardTemplate:<init>	()V
    //   315: astore 11
    //   317: aload 11
    //   319: aload 9
    //   321: ldc_w 1241
    //   324: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   327: i2l
    //   328: putfield 665	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_Long	J
    //   331: aload 11
    //   333: aload 9
    //   335: ldc_w 1245
    //   338: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: putfield 668	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: aload 11
    //   346: aload 9
    //   348: ldc_w 1250
    //   351: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   354: putfield 670	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   357: aload 11
    //   359: aload 9
    //   361: ldc_w 1252
    //   364: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   367: putfield 671	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   370: aload 11
    //   372: aload 9
    //   374: ldc_w 1254
    //   377: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: putfield 672	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Int	I
    //   383: aload 11
    //   385: aload 9
    //   387: ldc_w 1256
    //   390: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   393: putfield 674	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_Int	I
    //   396: aload 11
    //   398: aload 9
    //   400: ldc_w 1258
    //   403: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   406: putfield 676	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_c_of_type_Int	I
    //   409: aload 11
    //   411: aload 9
    //   413: ldc_w 1260
    //   416: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: putfield 677	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   422: aload 11
    //   424: aload 9
    //   426: ldc_w 1262
    //   429: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: putfield 680	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   435: aload 11
    //   437: aload 9
    //   439: ldc_w 1264
    //   442: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 683	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   448: aload 11
    //   450: aload 9
    //   452: ldc_w 1266
    //   455: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: putfield 686	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   461: aload 11
    //   463: aload 9
    //   465: ldc_w 1268
    //   468: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   471: putfield 689	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   474: aload 11
    //   476: aload 9
    //   478: ldc_w 1270
    //   481: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: putfield 691	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   487: aload 11
    //   489: aload 9
    //   491: ldc_w 1272
    //   494: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   497: putfield 694	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   500: aload 11
    //   502: aload 9
    //   504: ldc_w 1274
    //   507: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: putfield 697	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   513: aload 11
    //   515: aload 9
    //   517: ldc_w 1276
    //   520: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   523: putfield 699	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_d_of_type_Int	I
    //   526: aload 11
    //   528: aload 9
    //   530: ldc_w 1278
    //   533: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   536: putfield 702	com/tencent/mobileqq/profile/ProfileCardTemplate:p	Ljava/lang/String;
    //   539: aload 11
    //   541: aload 9
    //   543: ldc_w 1280
    //   546: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   549: putfield 705	com/tencent/mobileqq/profile/ProfileCardTemplate:q	Ljava/lang/String;
    //   552: aload 11
    //   554: aload 9
    //   556: ldc_w 1282
    //   559: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   562: putfield 708	com/tencent/mobileqq/profile/ProfileCardTemplate:r	Ljava/lang/String;
    //   565: aload 11
    //   567: aload 9
    //   569: ldc_w 1284
    //   572: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   575: putfield 711	com/tencent/mobileqq/profile/ProfileCardTemplate:s	Ljava/lang/String;
    //   578: aload 11
    //   580: aload 9
    //   582: ldc_w 1286
    //   585: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: putfield 713	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   591: aload 11
    //   593: aload 9
    //   595: ldc_w 1288
    //   598: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   601: putfield 716	com/tencent/mobileqq/profile/ProfileCardTemplate:n	Ljava/lang/String;
    //   604: aload 11
    //   606: aload 9
    //   608: ldc_w 1290
    //   611: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   614: putfield 719	com/tencent/mobileqq/profile/ProfileCardTemplate:m	Ljava/lang/String;
    //   617: aload 11
    //   619: aload 9
    //   621: ldc_w 1292
    //   624: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: putfield 722	com/tencent/mobileqq/profile/ProfileCardTemplate:o	Ljava/lang/String;
    //   630: aload 11
    //   632: aload 9
    //   634: ldc_w 1294
    //   637: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   640: putfield 724	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_Int	I
    //   643: aload 11
    //   645: aload 9
    //   647: ldc_w 1296
    //   650: invokevirtual 1248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: putfield 727	com/tencent/mobileqq/profile/ProfileCardTemplate:t	Ljava/lang/String;
    //   656: aload 11
    //   658: aload 9
    //   660: ldc_w 1298
    //   663: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   666: putfield 729	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_Int	I
    //   669: aload 11
    //   671: aload 9
    //   673: ldc_w 1300
    //   676: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   679: putfield 731	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_Int	I
    //   682: aload 11
    //   684: aload 9
    //   686: ldc_w 1302
    //   689: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   692: putfield 733	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_k_of_type_Int	I
    //   695: aload 11
    //   697: aload 9
    //   699: ldc_w 1304
    //   702: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   705: putfield 735	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_e_of_type_Int	I
    //   708: aload 11
    //   710: aload 9
    //   712: ldc_w 1306
    //   715: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   718: putfield 737	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_f_of_type_Int	I
    //   721: aload 11
    //   723: aload 9
    //   725: ldc_w 1308
    //   728: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   731: putfield 739	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_g_of_type_Int	I
    //   734: aload 9
    //   736: ldc_w 1310
    //   739: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   742: istore 4
    //   744: aload 11
    //   746: aload 9
    //   748: ldc_w 1312
    //   751: invokevirtual 1244	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   754: putfield 741	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_Int	I
    //   757: iload 4
    //   759: iconst_1
    //   760: if_icmpne +199 -> 959
    //   763: iconst_1
    //   764: istore_1
    //   765: aload 11
    //   767: iload_1
    //   768: putfield 743	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Boolean	Z
    //   771: aload 10
    //   773: aload 11
    //   775: invokevirtual 1313	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   778: pop
    //   779: iload_2
    //   780: iconst_1
    //   781: iadd
    //   782: istore_2
    //   783: goto -488 -> 295
    //   786: new 651	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   789: dup
    //   790: invokespecial 667	com/tencent/mobileqq/profile/ProfileCardTemplate:<init>	()V
    //   793: astore 6
    //   795: aload 6
    //   797: ldc2_w 1314
    //   800: putfield 665	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_Long	J
    //   803: aload 6
    //   805: iconst_1
    //   806: putfield 743	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Boolean	Z
    //   809: aload 10
    //   811: aload 6
    //   813: invokevirtual 1313	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   816: pop
    //   817: new 651	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   820: dup
    //   821: invokespecial 667	com/tencent/mobileqq/profile/ProfileCardTemplate:<init>	()V
    //   824: astore 6
    //   826: aload 6
    //   828: ldc2_w 1316
    //   831: putfield 665	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_Long	J
    //   834: aload 6
    //   836: iconst_1
    //   837: putfield 743	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Boolean	Z
    //   840: aload 10
    //   842: aload 6
    //   844: invokevirtual 1313	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   847: pop
    //   848: aload_0
    //   849: ifnull +7 -> 856
    //   852: aload_0
    //   853: invokevirtual 1201	java/io/InputStream:close	()V
    //   856: aload 7
    //   858: ifnull -655 -> 203
    //   861: aload 7
    //   863: invokevirtual 1202	java/io/ByteArrayOutputStream:close	()V
    //   866: goto -663 -> 203
    //   869: astore_0
    //   870: aload_0
    //   871: invokevirtual 1318	java/io/IOException:printStackTrace	()V
    //   874: goto -671 -> 203
    //   877: astore_0
    //   878: aload_0
    //   879: invokevirtual 1318	java/io/IOException:printStackTrace	()V
    //   882: goto -679 -> 203
    //   885: astore 6
    //   887: aconst_null
    //   888: astore 7
    //   890: aconst_null
    //   891: astore_0
    //   892: aload_0
    //   893: ifnull +7 -> 900
    //   896: aload_0
    //   897: invokevirtual 1201	java/io/InputStream:close	()V
    //   900: aload 7
    //   902: ifnull +8 -> 910
    //   905: aload 7
    //   907: invokevirtual 1202	java/io/ByteArrayOutputStream:close	()V
    //   910: aload 6
    //   912: athrow
    //   913: astore_0
    //   914: aload_0
    //   915: invokevirtual 1318	java/io/IOException:printStackTrace	()V
    //   918: goto -8 -> 910
    //   921: astore 6
    //   923: aconst_null
    //   924: astore 7
    //   926: goto -34 -> 892
    //   929: astore 6
    //   931: goto -39 -> 892
    //   934: astore 8
    //   936: aload 6
    //   938: astore 7
    //   940: aload 8
    //   942: astore 6
    //   944: goto -52 -> 892
    //   947: astore 7
    //   949: aconst_null
    //   950: astore_0
    //   951: goto -771 -> 180
    //   954: astore 7
    //   956: goto -776 -> 180
    //   959: iconst_0
    //   960: istore_1
    //   961: goto -196 -> 765
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	964	0	paramQQAppInterface	QQAppInterface
    //   0	964	1	paramBoolean	boolean
    //   152	631	2	i	int
    //   292	6	3	j	int
    //   742	19	4	k	int
    //   46	66	5	bool	boolean
    //   1	842	6	localObject1	Object
    //   885	26	6	localObject2	Object
    //   921	1	6	localObject3	Object
    //   929	8	6	localObject4	Object
    //   942	1	6	localObject5	Object
    //   39	900	7	localObject6	Object
    //   947	1	7	localThrowable1	Throwable
    //   954	1	7	localThrowable2	Throwable
    //   28	176	8	str	String
    //   934	7	8	localObject7	Object
    //   170	7	9	localThrowable3	Throwable
    //   306	441	9	localJSONObject	JSONObject
    //   109	732	10	localArrayList	ArrayList
    //   315	459	11	localProfileCardTemplate	ProfileCardTemplate
    // Exception table:
    //   from	to	target	type
    //   135	142	170	java/lang/Throwable
    //   142	153	170	java/lang/Throwable
    //   158	167	170	java/lang/Throwable
    //   230	293	170	java/lang/Throwable
    //   300	757	170	java/lang/Throwable
    //   765	779	170	java/lang/Throwable
    //   786	848	170	java/lang/Throwable
    //   852	856	869	java/io/IOException
    //   861	866	869	java/io/IOException
    //   189	193	877	java/io/IOException
    //   198	203	877	java/io/IOException
    //   116	126	885	finally
    //   216	227	885	finally
    //   896	900	913	java/io/IOException
    //   905	910	913	java/io/IOException
    //   126	135	921	finally
    //   135	142	929	finally
    //   142	153	929	finally
    //   158	167	929	finally
    //   230	293	929	finally
    //   300	757	929	finally
    //   765	779	929	finally
    //   786	848	929	finally
    //   180	185	934	finally
    //   116	126	947	java/lang/Throwable
    //   216	227	947	java/lang/Throwable
    //   126	135	954	java/lang/Throwable
  }
  
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getProfileTemplateList isReturnHidden=" + paramBoolean1 + ",returnExpire=" + paramBoolean2);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramQQAppInterface, false);
    if (!((ArrayList)localObject).isEmpty())
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ProfileCardTemplate localProfileCardTemplate = (ProfileCardTemplate)((Iterator)localObject).next();
        if ((paramBoolean1) || (!localProfileCardTemplate.jdField_a_of_type_Boolean)) {
          if (paramBoolean2) {
            localArrayList.add(localProfileCardTemplate);
          } else if (a(paramQQAppInterface, localProfileCardTemplate)) {
            localArrayList.add(localProfileCardTemplate);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = null;
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    a(paramActivity, paramView, paramString, false, false);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("curType", paramInt);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("is_from_face2face_add_friend", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramView, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramActivity, paramView, paramString, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("requestType", 881);
    localIntent.putExtra("is_hide_actionsheet", paramBoolean1);
    localIntent.putExtra("is_hide_footbar", paramBoolean2);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramBoolean, false, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    paramString4 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString4.putExtra("uin", paramString1);
    paramString4.putExtra("isShowAd", false);
    paramString4.putExtra("hide_more_button", true);
    paramString4.putExtra("has_red_dot", paramBoolean2);
    paramString4.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2 = IndividuationUrlHelper.a(paramActivity, "card", paramString2);
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString2 + "&" + paramString3;
    }
    paramString1 = paramString1 + "&entryId=" + paramInt2 + "&isCache=" + paramInt1 + "&tabId=" + paramInt3;
    if ((paramActivity instanceof FriendProfileCardActivity))
    {
      if (paramInt2 != 0) {
        break label208;
      }
      paramString4.putExtra("individuation_url_type", 40202);
    }
    for (;;)
    {
      paramString4.putExtra("url", paramString1);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString1, -1L, paramString4, paramBoolean1, 1025);
      return;
      label208:
      if (paramInt2 == 1) {
        paramString4.putExtra("individuation_url_type", 40203);
      } else if (paramInt2 == 3) {
        paramString4.putExtra("individuation_url_type", 40204);
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = String.format(IndividuationUrlHelper.a("rareCard"), new Object[] { Long.valueOf(paramLong) });
    }
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Resources paramResources, View paramView, StatusManager paramStatusManager, RichStatus paramRichStatus, boolean paramBoolean)
  {
    Object localObject1 = null;
    int j = 0;
    TextView localTextView = (TextView)paramView.findViewById(2131364119);
    ImageView localImageView = (ImageView)paramView.findViewById(2131363443);
    if (paramRichStatus != null) {
      localObject1 = paramRichStatus.toSpannableString(null, -8947849, paramResources.getColor(2131492971));
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SpannableString("");
    }
    int i;
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
      if (paramStatusManager != null)
      {
        localObject1 = paramStatusManager.a(paramRichStatus.actionId, 200);
        localObject1 = new StatableBitmapDrawable(paramResources, (Bitmap)localObject1, false, false);
        i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
        ((OffsetableImageSpan)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, "[S]".length(), 17);
        localTextView.setText((CharSequence)localObject2);
        label208:
        if (!paramBoolean) {
          break label543;
        }
        if (paramStatusManager != null) {
          break label452;
        }
        paramBoolean = false;
      }
    }
    for (;;)
    {
      label220:
      if (paramBoolean)
      {
        i = 2130838600;
        label230:
        paramResources = paramResources.getDrawable(i);
        if (localImageView.getDrawable() != paramResources)
        {
          localImageView.setImageDrawable(paramResources);
          if ((paramResources instanceof Animatable)) {
            ((Animatable)paramResources).start();
          }
        }
        paramResources = "";
        if (paramRichStatus == null) {
          break label475;
        }
        if (paramRichStatus.actionText != null) {
          paramResources = "" + paramRichStatus.actionText;
        }
        paramStatusManager = paramResources;
        if (paramRichStatus.dataText != null) {
          paramStatusManager = paramResources + paramRichStatus.dataText;
        }
        if (paramRichStatus.plainText == null) {
          break label469;
        }
        i = paramRichStatus.plainText.size();
        label352:
        paramResources = paramStatusManager;
        label354:
        paramStatusManager = paramResources;
        if (j >= i) {
          break label478;
        }
        paramStatusManager = (String)paramRichStatus.plainText.get(j);
        if (TextUtils.isEmpty(paramStatusManager)) {
          break label540;
        }
        paramResources = paramResources + paramStatusManager;
      }
      label540:
      for (;;)
      {
        j += 1;
        break label354;
        localObject1 = BitmapManager.a(paramResources, 2130845456);
        break;
        if (((SpannableString)localObject2).length() == 0)
        {
          localTextView.setText("编辑个性签名");
          break label208;
        }
        localTextView.setText((CharSequence)localObject2);
        break label208;
        label452:
        paramBoolean = paramStatusManager.a();
        break label220;
        i = 2130838484;
        break label230;
        label469:
        i = 0;
        break label352;
        label475:
        paramStatusManager = "";
        label478:
        if ((paramView.getTag() instanceof DataTag)) {
          ((DataTag)paramView.getTag()).a = paramStatusManager;
        }
        for (;;)
        {
          paramView.setContentDescription("个性签名是" + paramStatusManager);
          return;
          paramView.setTag(new DataTag(3, paramStatusManager));
        }
      }
      label543:
      paramBoolean = false;
    }
  }
  
  public static void a(ProfileActivity.AllInOne paramAllInOne, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((paramAllInOne == null) || (TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      return;
    }
    paramAllInOne = a(paramAllInOne, paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "openDetails url: %s", new Object[] { paramAllInOne }));
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramAllInOne);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
    localIntent.putExtra("reqType", 1);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport param null");
      }
      return;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    try
    {
      localQQProgressDialog.show();
      if (paramLong <= 0L)
      {
        ((NearbyFaceScoreManager)paramBaseActivity.getAppInterface().getManager(203)).a(Long.parseLong(paramString1), new akan(paramBaseActivity, paramString1, paramString2, paramInt, localQQProgressDialog));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      b(paramBaseActivity, String.valueOf(paramLong), paramString1, paramString2, paramInt, localQQProgressDialog);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramBaseActivity, BusinessCardEditActivity.class);
    if (paramAllInOne.jdField_a_of_type_Int == 0)
    {
      localIntent.putExtra("mode_type", 3);
      localIntent.putExtra("source_activity", 3);
    }
    for (;;)
    {
      localIntent.putExtra("cur_card_body", paramBusinessCard);
      localIntent.putExtra("is_edit_mode", true);
      localIntent.putExtra("finish_immedia", true);
      Object localObject = paramAllInOne.jdField_a_of_type_JavaUtilArrayList;
      paramBusinessCard = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBusinessCard.add(((ProfileActivity.CardContactInfo)((Iterator)localObject).next()).jdField_c_of_type_JavaLangString);
      }
      localIntent.putExtra("mode_type", 2);
      localIntent.putExtra("source_activity", 1);
      paramBusinessCard.bindUin = paramAllInOne.jdField_a_of_type_JavaLangString;
    }
    localIntent.putExtra("bind_phone_num", paramBusinessCard);
    paramBaseActivity.startActivity(localIntent);
    if (paramAllInOne.jdField_a_of_type_Int == 0)
    {
      ReportController.b(paramBaseActivity.app, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(paramBaseActivity.app, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport param null");
      }
      return;
    }
    paramString3 = new QQProgressDialog(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    try
    {
      paramString3.show();
      ThreadManager.post(new akak(paramInt, paramString1, paramString2, paramString4, paramBaseActivity, paramString3), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString5)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport param null");
      }
      return;
    }
    paramString5 = new QQProgressDialog(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    try
    {
      paramString5.show();
      ThreadManager.post(new akar(paramInt, paramString2, paramString1, paramString3, paramString4, paramString6, paramBaseActivity, paramString5), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new akav(paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, null, 0L, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, int paramInt, String paramString3, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramQQAppInterface.a(new akau(paramInt, paramString3, paramString4, paramFloat1, paramFloat2, paramFloat3, paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      DynamicFaceDrawable localDynamicFaceDrawable = ((DynamicAvatarView)paramView).a;
      if ((localDynamicFaceDrawable != null) && (localDynamicFaceDrawable.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localDynamicFaceDrawable.jdField_c_of_type_JavaLangString)))
      {
        b(paramActivity, paramView, localDynamicFaceDrawable.jdField_c_of_type_JavaLangString);
        paramInt1 = 1;
        if (paramInt2 == 0) {
          if (paramInt1 == 0) {
            break label159;
          }
        }
      }
    }
    label159:
    for (paramActivity = "1";; paramActivity = "0")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramActivity, "", "", "");
      return;
      if (paramInt2 == 1)
      {
        a(paramActivity, paramView, paramString, paramInt1);
        paramInt1 = 0;
        break;
      }
      a(paramActivity, paramView, paramString, true, true);
      for (;;)
      {
        paramInt1 = 0;
        break;
        if (paramInt2 == 1)
        {
          a(paramActivity, paramView, paramString, paramInt1);
          paramInt1 = 0;
          break;
        }
        a(paramActivity, paramView, paramString, true, true);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = new URL("profile_img_thumb", null, paramQQAppInterface.a(false, paramString, true));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big", null, a(paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, "", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getDir(".profilecard", 0).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File(paramQQAppInterface).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        while (i < arrayOfFile.length)
        {
          String str = arrayOfFile[i].getName();
          if ((str.startsWith(String.valueOf(paramString1))) && (!str.endsWith(paramString2)))
          {
            str = paramQQAppInterface + File.separator + String.valueOf(paramString1) + "_" + str;
            FileUtils.a(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir old dir=" + str);
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|false");
      }
      jdField_a_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    jdField_b_of_type_JavaLangString = paramString;
    jdField_a_of_type_Boolean = true;
  }
  
  public static final void a(String paramString1, int paramInt, String paramString2)
  {
    if (jdField_a_of_type_JavaLangStringBuilder == null) {
      jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangStringBuilder.append(paramString1).append(", reason = [").append(paramString2).append("], code = [").append(paramInt).append("]");
      QLog.i("UPLOAD_AVATAR_FAIL", 1, jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  public static void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, long paramLong1, int paramInt2, int paramInt3, long paramLong2, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doStaticForVoiceTransfer()").append(", uin = ").append(paramString1).append(", nOpType = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(", filekey = ").append(paramString2).append(", ip = ").append(paramString3).append(", duration = ").append(paramLong1).append(", retry_count = ").append(paramInt2).append(", failCode = ").append(paramInt3).append(", fileSize = ").append(paramLong2).append(", errorMsg = ").append(paramString4).append(", rspHeader = ").append(paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {}
    HashMap localHashMap;
    for (localObject = "actIntroPttUpload";; localObject = "actIntroPttDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("serverip", paramString3);
      localHashMap.put("param_uuid", paramString2);
      if (!paramBoolean) {
        break;
      }
      localHashMap.put("param_retry", String.valueOf(paramInt2));
      StatisticCollector.a(BaseApplication.getContext()).a(paramString1, (String)localObject, paramBoolean, paramLong1, paramLong2, localHashMap, "", false);
      return;
    }
    if (!BaseTransProcessor.a(paramInt3, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt3));
      if ((paramInt3 == -9527) || (paramInt3 == 9311) || (paramInt3 == 9044) || (paramInt3 == 9350) || (paramInt3 == 9351))
      {
        localHashMap.put(BaseTransProcessor.jdField_k_of_type_JavaLangString, paramString4);
        label316:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label379;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      label379:
      paramString5 = "";
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openAddPersonalityLabel");
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("url", Constants.jdField_c_of_type_JavaLangString);
    paramString.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify_personality_label");
    paramString.putExtra("fromProfile", paramBoolean);
    paramActivity.startActivity(paramString);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = HexUtil.a(paramArrayOfByte);
      String str = HexUtil.a(paramArrayOfByte);
      ThreadManager.post(new akai(str, b(paramArrayOfByte)), 8, null, false);
      b(str);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, paramArrayOfByte.toString());
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = a(paramContext, paramString);
    boolean bool1;
    try
    {
      paramContext = new File(paramContext);
      if ((paramContext.exists()) && (paramContext.isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
      }
      else
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not exists");
        return false;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource exception msg=" + paramContext.getMessage());
        return false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = a(paramQQAppInterface, -1L);
    if (localObject != null)
    {
      paramQQAppInterface = new File((String)localObject);
      localObject = new File((String)localObject + File.separator + "config_black.json");
      bool1 = bool2;
      if (paramQQAppInterface.isDirectory())
      {
        bool1 = bool2;
        if (((File)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common dir exists=" + paramQQAppInterface.isDirectory() + " templateConfig exists= " + ((File)localObject).exists());
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common path is null");
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ProfileCardTemplate paramProfileCardTemplate)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (((paramProfileCardTemplate.jdField_j_of_type_Int > 100) && (l < paramProfileCardTemplate.jdField_j_of_type_Int)) || ((paramProfileCardTemplate.jdField_k_of_type_Int > 100) && (l > paramProfileCardTemplate.jdField_k_of_type_Int)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ProfileCardUtil", 2, "filterTemplate->sytle:" + paramProfileCardTemplate.jdField_l_of_type_Long + ",beginTime:" + paramProfileCardTemplate.jdField_j_of_type_Int + ",endTime:" + paramProfileCardTemplate.jdField_k_of_type_Int);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    File localFile = new File(paramString);
    long l = localFile.length();
    if ((!localFile.exists()) || (l <= 0L) || (l >= 614400L))
    {
      a("onAvatarChanged", 0, String.valueOf(l));
      return false;
    }
    if (!NetworkUtil.d(paramQQAppInterface.getApp()))
    {
      a("onAvatarChanged", 1, "net_not_support");
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + l);
    }
    a(paramString);
    paramQQAppInterface.a().a(paramQQAppInterface, paramString, paramIntent);
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg));
  }
  
  public static boolean a(ProfileCardBackground paramProfileCardBackground)
  {
    return paramProfileCardBackground.jdField_a_of_type_Int == 160;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(2));
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = HexUtil.a(paramString);
    }
    return arrayOfByte;
  }
  
  public static int b(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (int)((Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - 10) * 0.8F + 0.5F);
  }
  
  public static int b(Context paramContext)
  {
    return (int)(0.56338F * a(paramContext));
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static long b()
  {
    try
    {
      if (Utils.a()) {
        return Utils.a(new File(AppConstants.aI));
      }
      long l = Utils.a(new File(Environment.getRootDirectory().getPath()));
      return l;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_template.json" + "7.6.3";
  }
  
  public static String b(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    int j = -1;
    String str = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1))
    {
      i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
      if (i != 0) {
        break label150;
      }
      str = paramContext.getString(2131433941);
    }
    for (;;)
    {
      return str + a(paramContext, paramProfileCardInfo);
      if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
      {
        i = localCard.shGender;
        break;
      }
      i = j;
      if (localContactCard == null) {
        break;
      }
      if (localContactCard.bSex != 0)
      {
        i = j;
        if (localContactCard.bSex != 1) {
          break;
        }
      }
      i = localContactCard.bSex;
      break;
      label150:
      if (i == 1) {
        str = paramContext.getString(2131433942);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardUtil", 2, "clear drawables from doOnDestroy.");
    }
    if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ProfileCardTemplate)localIterator.next()).a();
      }
    }
  }
  
  public static void b(Activity paramActivity, View paramView, String paramString)
  {
    Object localObject = new PicInfo();
    ((PicInfo)localObject).jdField_d_of_type_JavaLangString = paramString;
    paramString = new ArrayList(1);
    paramString.add(localObject);
    localObject = new Intent(paramActivity, NearbyProfilePicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", 0);
    ((Intent)localObject).putExtra("intent_param_pic_infos", paramString);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    ((Intent)localObject).addFlags(536870912);
    paramActivity.startActivity((Intent)localObject);
  }
  
  private static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    ThreadManager.post(new akao(paramInt, paramString1, paramBaseActivity, paramString2, paramString3, paramQQProgressDialog), 5, null, false);
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public static boolean b()
  {
    Locale localLocale = Locale.getDefault();
    String str = localLocale.getCountry();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!TextUtils.equals(str, arrayOfString[i])) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("TRUETe", 4, String.format(localLocale, "isEuropeAndAmerica country:%s, local: %s", new Object[] { str, localLocale }));
      }
      return bool;
      i += 1;
      break;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.equals(""))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      paramContext = c(paramContext) + "." + c(paramString);
      try
      {
        paramContext = new File(paramContext);
        if ((!paramContext.exists()) || (!paramContext.isDirectory())) {
          break label156;
        }
        paramContext = paramContext.list();
        if ((paramContext != null) && (paramContext.length > 0))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistDynamicBgResource is exists");
          return true;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistDynamicBgResource exception msg=" + paramContext.getMessage());
        }
        return false;
      }
    }
    QLog.e("Q.profilecard.FrdProfileCard", 1, "isExistDynamicBgResource is not exists, fileNames is empty!");
    return false;
    label156:
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistDynamicBgResource is not exists");
    }
    return false;
  }
  
  public static boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(1));
  }
  
  public static int c(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static final int c(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_cardbg.tmp");
    return localStringBuilder.toString();
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      if (Utils.a()) {
        return AppConstants.bU;
      }
      String str = paramContext.getDir(".profilecard", 0).getAbsoluteFile() + File.separator;
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, "getBGDir error, e = " + localException);
    }
    return paramContext.getDir(".profilecard", 0).getAbsoluteFile() + File.separator;
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new akaj(paramString));
  }
  
  public static boolean c(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(3));
  }
  
  public static int d(Activity paramActivity)
  {
    return c(paramActivity) * 3 / 4;
  }
  
  public static boolean d(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!b(paramArrayList)) && (!c(paramArrayList)) && (!a(paramArrayList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil
 * JD-Core Version:    0.7.0.1
 */