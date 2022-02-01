package com.tencent.mobileqq.util;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.Constants;
import com.tencent.mobileqq.profile.ProfileCardBackground;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyData;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.FriendProfileCardBgInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileCardUtil
{
  public static int a = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static StringBuilder a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "AT", "BE", "BG", "HR", "CY", "CZ", "DK", "EE", "FI", "FR", "DE", "GR", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "RO", "SK", "SI", "ES", "SE", "GB", "US" };
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return FaceUtil.a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
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
    catch (Exception localException)
    {
      label21:
      double d1;
      break label21;
    }
    d1 = paramResources.getDisplayMetrics().density * 25.0F;
    Double.isNaN(d1);
    return (int)(d1 + 0.5D);
  }
  
  public static int a(AllInOne paramAllInOne)
  {
    int j = 1001;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfilePAUtils.isPaTypeFriend(paramAllInOne)) {}
    int i;
    do
    {
      return 0;
      if ((paramAllInOne.pa == 22) || (paramAllInOne.pa == 21)) {
        break label379;
      }
      i = j;
      if (paramAllInOne.pa == 41) {
        return i;
      }
      if (paramAllInOne.pa == 42) {
        return 1001;
      }
      if (paramAllInOne.pa == 86) {
        return 10002;
      }
      if (paramAllInOne.pa == 94) {
        return 10004;
      }
      if (paramAllInOne.pa == 3) {}
      while (paramAllInOne.pa == 2) {
        return 1005;
      }
      if (paramAllInOne.pa == 74) {
        return 1023;
      }
      if ((paramAllInOne.pa == 32) || (paramAllInOne.pa == 31) || (paramAllInOne.pa == 51) || (paramAllInOne.pa == 50) || (paramAllInOne.pa == 34) || (paramAllInOne.pa == 53)) {
        break label375;
      }
      if ((paramAllInOne.pa == 46) || (paramAllInOne.pa == 47)) {
        break label371;
      }
      if ((paramAllInOne.pa == 56) || (paramAllInOne.pa == 57)) {
        break label367;
      }
      if (paramAllInOne.pa == 58) {
        return 1020;
      }
      if ((paramAllInOne.pa == 71) || (paramAllInOne.pa == 72)) {
        break;
      }
    } while (paramAllInOne.pa == 70);
    if ((paramAllInOne.pa != 27) && (paramAllInOne.pa != 25))
    {
      if ((paramAllInOne.pa != 75) && (paramAllInOne.pa != 76))
      {
        if (paramAllInOne.pa == 80) {
          return 25;
        }
        if (paramAllInOne.pa == 115) {
          return 10008;
        }
        i = j;
        if (paramAllInOne.pa == 117) {
          return 10010;
        }
      }
      else
      {
        return 1010;
      }
    }
    else
    {
      return 1022;
      return 1021;
      label367:
      return 1009;
      label371:
      return 1004;
      label375:
      return 1006;
      label379:
      i = 1000;
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    long l = System.currentTimeMillis();
    paramString = a(paramString, 100, 0.56338F);
    int n = 0;
    if (paramString == null) {
      return 0;
    }
    int j = 0;
    int i = 0;
    int k = 0;
    while (j < paramString.getHeight())
    {
      int m = 0;
      while (m < paramString.getWidth())
      {
        int i1 = paramString.getPixel(m, j);
        if ((Color.red(i1) + Color.green(i1) + Color.blue(i1)) / 3 > 127) {
          i += 1;
        } else {
          k += 1;
        }
        m += 1;
      }
      j += 1;
    }
    j = n;
    if (i >= k) {
      j = 1;
    }
    paramString.recycle();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("-->calculate background color cost:");
      paramString.append(System.currentTimeMillis() - l);
      paramString.append("(ms)");
      QLog.d("ProfileCardUtil", 2, paramString.toString());
    }
    return j;
  }
  
  public static long a()
  {
    try
    {
      if (Utils.a()) {
        return Utils.a(new File(AppConstants.SDCARD_ROOT));
      }
      long l = Utils.a(new File(Environment.getRootDirectory().getPath()));
      return l;
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    return -1L;
  }
  
  public static Intent a(Intent paramIntent, String paramString, AppInterface paramAppInterface, AllInOne paramAllInOne, BusinessCard paramBusinessCard)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramAppInterface == null) {
        return paramIntent;
      }
      Object localObject = String.format("https://ti.qq.com/qcard/profile?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramAppInterface.getAppid()), "android-8.7.0" });
      paramString = (String)localObject;
      if (a())
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append("&intl=1");
        paramString = paramString.toString();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openDetails() url = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject).toString());
      }
      paramIntent = new Intent(paramIntent);
      paramIntent.putExtra("url", paramString);
      paramIntent.putExtra("uin", paramAppInterface.getCurrentAccountUin());
      paramIntent.putExtra("AllInOne", paramAllInOne);
      paramIntent.putExtra("BusinessCard", paramBusinessCard);
      return paramIntent;
    }
    return paramIntent;
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: new 272	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 357	java/io/File:exists	()Z
    //   13: ifeq +198 -> 211
    //   16: aload_0
    //   17: invokevirtual 360	java/io/File:length	()J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifle +189 -> 211
    //   25: aload_0
    //   26: invokevirtual 363	java/io/File:isDirectory	()Z
    //   29: ifeq +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: new 365	java/io/BufferedInputStream
    //   37: dup
    //   38: new 367	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 379	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 382	java/io/BufferedInputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: aload 6
    //   69: invokevirtual 220	android/graphics/Bitmap:getWidth	()I
    //   72: istore 4
    //   74: aload 6
    //   76: invokevirtual 217	android/graphics/Bitmap:getHeight	()I
    //   79: istore 5
    //   81: iload 4
    //   83: iload_1
    //   84: if_icmple +65 -> 149
    //   87: iload_1
    //   88: i2f
    //   89: fstore_3
    //   90: fload_3
    //   91: fload_2
    //   92: fdiv
    //   93: f2i
    //   94: istore_1
    //   95: new 384	android/graphics/Matrix
    //   98: dup
    //   99: invokespecial 385	android/graphics/Matrix:<init>	()V
    //   102: astore 7
    //   104: aload 7
    //   106: fload_3
    //   107: iload 4
    //   109: i2f
    //   110: fdiv
    //   111: iload_1
    //   112: i2f
    //   113: iload 5
    //   115: i2f
    //   116: fdiv
    //   117: invokevirtual 389	android/graphics/Matrix:postScale	(FF)Z
    //   120: pop
    //   121: aload 6
    //   123: iconst_0
    //   124: iconst_0
    //   125: iload 4
    //   127: iload 5
    //   129: aload 7
    //   131: iconst_1
    //   132: invokestatic 393	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   135: astore 7
    //   137: aload 6
    //   139: invokevirtual 237	android/graphics/Bitmap:recycle	()V
    //   142: aload_0
    //   143: invokevirtual 382	java/io/BufferedInputStream:close	()V
    //   146: aload 7
    //   148: areturn
    //   149: aload_0
    //   150: invokevirtual 382	java/io/BufferedInputStream:close	()V
    //   153: aload 6
    //   155: areturn
    //   156: astore 7
    //   158: aload_0
    //   159: astore 6
    //   161: aload 7
    //   163: astore_0
    //   164: goto +13 -> 177
    //   167: goto +24 -> 191
    //   170: goto +33 -> 203
    //   173: astore_0
    //   174: aconst_null
    //   175: astore 6
    //   177: aload 6
    //   179: ifnull +8 -> 187
    //   182: aload 6
    //   184: invokevirtual 382	java/io/BufferedInputStream:close	()V
    //   187: aload_0
    //   188: athrow
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 382	java/io/BufferedInputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 382	java/io/BufferedInputStream:close	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: goto -13 -> 201
    //   217: astore_0
    //   218: goto -29 -> 189
    //   221: astore 6
    //   223: goto -53 -> 170
    //   226: astore 6
    //   228: goto -61 -> 167
    //   231: astore_0
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload 7
    //   237: areturn
    //   238: astore_0
    //   239: aload 6
    //   241: areturn
    //   242: astore 6
    //   244: goto -57 -> 187
    //   247: astore_0
    //   248: aconst_null
    //   249: areturn
    //   250: astore_0
    //   251: aconst_null
    //   252: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString	String
    //   0	253	1	paramInt	int
    //   0	253	2	paramFloat	float
    //   89	18	3	f	float
    //   72	54	4	i	int
    //   79	49	5	j	int
    //   54	129	6	localObject1	Object
    //   221	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   226	14	6	localException1	Exception
    //   242	1	6	localException2	Exception
    //   102	45	7	localObject2	Object
    //   156	80	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   50	56	156	finally
    //   67	81	156	finally
    //   90	142	156	finally
    //   34	50	173	finally
    //   34	50	213	java/lang/OutOfMemoryError
    //   34	50	217	java/lang/Exception
    //   50	56	221	java/lang/OutOfMemoryError
    //   67	81	221	java/lang/OutOfMemoryError
    //   90	142	221	java/lang/OutOfMemoryError
    //   50	56	226	java/lang/Exception
    //   67	81	226	java/lang/Exception
    //   90	142	226	java/lang/Exception
    //   61	65	231	java/lang/Exception
    //   142	146	234	java/lang/Exception
    //   149	153	238	java/lang/Exception
    //   182	187	242	java/lang/Exception
    //   195	199	247	java/lang/Exception
    //   207	211	250	java/lang/Exception
  }
  
  public static SpannableString a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 1;
      StringBuilder localStringBuilder;
      int j;
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        j = 0;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        paramString = localStringBuilder.toString();
        j = paramString.length() - 1;
        i = paramString.length();
      }
      paramString = new SpannableString(paramString);
      paramInt2 = (int)paramContext.getResources().getDimension(paramInt2);
      paramInt3 = (int)paramContext.getResources().getDimension(paramInt3);
      paramContext = paramContext.getResources().getDrawable(paramInt1);
      paramContext.setBounds(0, 0, paramInt2, paramInt3);
      ProfileCardUtils.setNightModeFilterForDrawable(paramQQAppInterface, paramContext);
      paramString.setSpan(new ImageSpan(paramContext), j, i, 33);
      return paramString;
    }
    return null;
  }
  
  public static SpannableString a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Context paramContext, QQAppInterface paramQQAppInterface, ClickableSpan paramClickableSpan)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 1;
      StringBuilder localStringBuilder;
      int j;
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  ");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        j = 0;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("  ");
        paramString = localStringBuilder.toString();
        j = paramString.length() - 1;
        i = paramString.length();
      }
      paramString = new SpannableString(paramString);
      paramInt2 = (int)paramContext.getResources().getDimension(paramInt2);
      paramInt3 = (int)paramContext.getResources().getDimension(paramInt3);
      paramContext = paramContext.getResources().getDrawable(paramInt1);
      paramContext.setBounds(0, 0, paramInt2, paramInt3);
      ProfileCardUtils.setNightModeFilterForDrawable(paramQQAppInterface, paramContext);
      paramString.setSpan(new VerticalCenterImageSpan(paramContext, 0), j, i, 33);
      if (paramClickableSpan != null) {
        paramString.setSpan(paramClickableSpan, j, i, 33);
      }
      return paramString;
    }
    return null;
  }
  
  public static SpannableStringBuilder a(List<SpannableString> paramList, int paramInt1, int paramInt2, String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null) {
      paramSpannableStringBuilder = new SpannableStringBuilder();
    } else {
      paramSpannableStringBuilder.clear();
    }
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int j = paramInt1;
    while ((j >= 0) && (j < paramInt2) && (j < i))
    {
      if (j > paramInt1) {
        paramSpannableStringBuilder.append(paramString);
      }
      paramSpannableStringBuilder.append((CharSequence)paramList.get(j));
      j += 1;
    }
    return paramSpannableStringBuilder;
  }
  
  public static FriendProfileCardBgDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject;
    if (!paramString1.equals(""))
    {
      FriendProfileCardBgInfo localFriendProfileCardBgInfo = a(FileUtils.readFileToStringEx(new File(paramString1, "config.json"), -1));
      localObject = localFriendProfileCardBgInfo;
      if (localFriendProfileCardBgInfo != null)
      {
        localObject = new String[localFriendProfileCardBgInfo.jdField_a_of_type_Int];
        int j;
        for (int i = 0; i < localFriendProfileCardBgInfo.jdField_a_of_type_Int; i = j)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append("/");
          j = i + 1;
          localStringBuilder.append(j);
          localStringBuilder.append(".png");
          localObject[i] = localStringBuilder.toString();
        }
        localFriendProfileCardBgInfo.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
        localObject = localFriendProfileCardBgInfo;
      }
    }
    else
    {
      localObject = null;
    }
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = new FriendProfileCardBgInfo();
    }
    if (paramString1 != null) {
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
    }
    return new FriendProfileCardBgDrawable(paramResources, paramString1);
  }
  
  public static Card a(AppRuntime paramAppRuntime, String paramString)
  {
    for (;;)
    {
      try
      {
        FriendsManager localFriendsManager = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramAppRuntime = null;
        if (localFriendsManager != null)
        {
          localFriends = localFriendsManager.e(paramString);
          paramAppRuntime = localFriendsManager.a(paramString);
          int i = 0;
          byte b2 = 0;
          if (paramAppRuntime == null)
          {
            if (QLog.isColorLevel())
            {
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append("initCard card = null, uin = ");
              paramAppRuntime.append(paramString);
              QLog.d("ProfileCardUtil", 2, paramAppRuntime.toString());
            }
            paramAppRuntime = new Card();
            paramAppRuntime.uin = paramString;
            paramAppRuntime.shGender = -1;
            if (localFriends != null)
            {
              paramAppRuntime.strNick = localFriends.name;
              paramAppRuntime.strReMark = localFriends.remark;
              paramAppRuntime.strShowName = localFriends.alias;
              if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                break label519;
              }
              b1 = 1;
              paramAppRuntime.bQQVipOpen = b1;
              if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                break label524;
              }
              b1 = 1;
              paramAppRuntime.bSuperVipOpen = b1;
              b1 = b2;
              if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                b1 = 1;
              }
              paramAppRuntime.bSuperQQOpen = b1;
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("initCard bSuperVipOpen=");
                localStringBuilder.append(paramAppRuntime.bSuperVipOpen);
                localStringBuilder.append(",bQQVipOpen=");
                localStringBuilder.append(paramAppRuntime.bQQVipOpen);
                localStringBuilder.append(",uin = ");
                localStringBuilder.append(paramString);
                QLog.d("ProfileCardUtil", 2, localStringBuilder.toString());
              }
              paramAppRuntime.iQQVipType = localFriends.getServiceType(EVIPSPEC.E_SP_QQVIP);
              paramAppRuntime.iSuperVipType = localFriends.getServiceType(EVIPSPEC.E_SP_SUPERVIP);
              paramAppRuntime.iSuperQQType = localFriends.getServiceType(EVIPSPEC.E_SP_SUPERQQ);
              paramAppRuntime.iQQVipLevel = localFriends.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
              paramAppRuntime.iSuperVipLevel = localFriends.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
              paramAppRuntime.iSuperQQLevel = localFriends.getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
              paramAppRuntime.lUserFlag = localFriends.cSpecialFlag;
              paramAppRuntime.namePlateOfKingGameId = localFriends.namePlateOfKingGameId;
              paramAppRuntime.namePlateOfKingLoginTime = localFriends.namePlateOfKingLoginTime;
            }
            else
            {
              paramAppRuntime.strSign = "";
              paramAppRuntime.strNick = "";
              paramAppRuntime.strReMark = "";
            }
            paramString = paramAppRuntime;
            if (localFriendsManager != null)
            {
              localFriendsManager.a(paramAppRuntime);
              paramString = paramAppRuntime;
            }
          }
          else
          {
            paramString = paramAppRuntime;
            if (localFriends != null)
            {
              if (!Utils.a(localFriends.alias, paramAppRuntime.strShowName))
              {
                paramAppRuntime.strShowName = localFriends.alias;
                i = 1;
              }
              if ((localFriends.cSpecialFlag & 0x1) == 1) {
                paramAppRuntime.lUserFlag |= 1L;
              }
              paramString = paramAppRuntime;
              if (localFriendsManager != null)
              {
                paramString = paramAppRuntime;
                if (i != 0)
                {
                  localFriendsManager.a(paramAppRuntime);
                  paramString = paramAppRuntime;
                }
              }
            }
          }
          return paramString;
        }
      }
      finally {}
      Friends localFriends = null;
      continue;
      label519:
      byte b1 = 0;
      continue;
      label524:
      b1 = 0;
    }
  }
  
  @NotNull
  public static BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(-1);
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = localLocalRedTouchManager.a(-4);
    if ((localLocalRedTouchManager.a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      QLog.d("ProfileCardUtil", 1, "getProfileMsgListRedTouch");
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
    }
    return localRedTypeInfo;
  }
  
  public static ProfileCardUtil.AvatarUploadResult a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    String str = FaceUtil.a();
    ImageUtil.a(paramString, str, 1080, 1080, 100);
    return a(paramQQAppInterface, str, paramIntent, true);
  }
  
  private static ProfileCardUtil.AvatarUploadResult a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    long l = ((File)localObject).length();
    ProfileCardUtil.AvatarUploadResult localAvatarUploadResult = new ProfileCardUtil.AvatarUploadResult();
    if (!((File)localObject).exists())
    {
      localAvatarUploadResult.jdField_a_of_type_Int = -10000;
      localAvatarUploadResult.jdField_a_of_type_JavaLangString = "file not exist";
      a("onAvatarChanged", localAvatarUploadResult.jdField_a_of_type_Int, localAvatarUploadResult.jdField_a_of_type_JavaLangString);
      return localAvatarUploadResult;
    }
    if (!NetworkUtil.isNetSupport(paramQQAppInterface.getApp()))
    {
      localAvatarUploadResult.jdField_a_of_type_Int = -10001;
      localAvatarUploadResult.jdField_a_of_type_JavaLangString = "network error";
      a("onAvatarChanged", localAvatarUploadResult.jdField_a_of_type_Int, localAvatarUploadResult.jdField_a_of_type_JavaLangString);
      return localAvatarUploadResult;
    }
    if ((l > 0L) && (l < 1749600L))
    {
      if (paramBoolean)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        int i = ((BitmapFactory.Options)localObject).outWidth;
        if ((i != ((BitmapFactory.Options)localObject).outHeight) || (i <= 0) || (i > 1080))
        {
          localAvatarUploadResult.jdField_a_of_type_Int = -10000;
          localAvatarUploadResult.jdField_a_of_type_JavaLangString = "image illegal, size must be square.";
          a("onAvatarChanged", localAvatarUploadResult.jdField_a_of_type_Int, localAvatarUploadResult.jdField_a_of_type_JavaLangString);
          return localAvatarUploadResult;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAvatarChanged|start upload : size = ");
        ((StringBuilder)localObject).append(l);
        QLog.d("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
      }
      localAvatarUploadResult.jdField_a_of_type_Int = 0;
      localAvatarUploadResult.jdField_a_of_type_JavaLangString = "ok";
      FaceUtil.a(paramString);
      a(paramQQAppInterface, paramString, paramIntent);
      return localAvatarUploadResult;
    }
    a("onAvatarChanged", 0, String.valueOf(l));
    localAvatarUploadResult.jdField_a_of_type_Int = -10000;
    localAvatarUploadResult.jdField_a_of_type_JavaLangString = "image illegal, size must be square.";
    a("onAvatarChanged", localAvatarUploadResult.jdField_a_of_type_Int, localAvatarUploadResult.jdField_a_of_type_JavaLangString);
    return localAvatarUploadResult;
  }
  
  public static FriendProfileCardBgInfo a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ProfileCardUtil", 2, "do parse ProfileCardBgInfo");
      }
      Object localObject = new FriendProfileCardBgInfo();
      try
      {
        paramString = new JSONObject(paramString);
        ((FriendProfileCardBgInfo)localObject).jdField_b_of_type_Int = paramString.getInt("frameInterval");
        ((FriendProfileCardBgInfo)localObject).jdField_a_of_type_Int = paramString.getInt("frameNumber");
        ((FriendProfileCardBgInfo)localObject).jdField_a_of_type_Float = ((float)paramString.getDouble("positionX"));
        ((FriendProfileCardBgInfo)localObject).jdField_b_of_type_Float = ((float)paramString.getDouble("positionY"));
        ((FriendProfileCardBgInfo)localObject).c = ((float)paramString.getDouble("width"));
        ((FriendProfileCardBgInfo)localObject).d = ((float)paramString.getDouble("height"));
        return localObject;
      }
      catch (JSONException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse, exception=");
        ((StringBuilder)localObject).append(MsfSdkUtils.getStackTraceString(paramString));
        QLog.e("ProfileCardUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("temp");
    localStringBuilder.append("/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_cardbg.tmp");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      return null;
    case 12: 
      return HardCodeUtil.a(2131708445);
    case 11: 
      return HardCodeUtil.a(2131708453);
    case 10: 
      return HardCodeUtil.a(2131708473);
    case 9: 
      return HardCodeUtil.a(2131708465);
    case 8: 
      return HardCodeUtil.a(2131708456);
    case 7: 
      return HardCodeUtil.a(2131708443);
    case 6: 
      return HardCodeUtil.a(2131708429);
    case 5: 
      return HardCodeUtil.a(2131708430);
    case 4: 
      return HardCodeUtil.a(2131708423);
    case 3: 
      return HardCodeUtil.a(2131708451);
    case 2: 
      return HardCodeUtil.a(2131708425);
    case 1: 
      return HardCodeUtil.a(2131708433);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    String str = "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 1: 
    case 4: 
      str = "mvip.gongneng.mobileqq.mingpian.open.android";
    }
    return str;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131693879));
      localStringBuilder.append("  ");
    }
    else if (paramInt1 == 1)
    {
      localStringBuilder.append(paramContext.getString(2131692259));
      localStringBuilder.append("  ");
    }
    if (paramInt2 != 0)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(paramContext.getString(2131719391));
      localStringBuilder.append("  ");
    }
    String str = "";
    paramContext = str;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext = str;
      if (!HardCodeUtil.a(2131708437).equals(paramString1))
      {
        paramContext = new StringBuilder();
        paramContext.append("");
        paramContext.append(paramString1);
        paramContext = paramContext.toString();
      }
    }
    paramString1 = paramContext;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramContext);
        paramString1.append(" ");
        paramString1 = paramString1.toString();
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString1);
      paramContext.append(paramString2);
      paramString1 = paramContext.toString();
    }
    paramContext = paramString1;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString1);
        paramContext.append(" ");
        paramContext = paramContext.toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramContext);
      paramString1.append(paramString3);
      paramContext = paramString1.toString();
    }
    localStringBuilder.append(paramContext);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    Card localCard = paramProfileCardInfo.card;
    ContactCard localContactCard = paramProfileCardInfo.contactCard;
    boolean bool = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isFieldVisible(41610, paramProfileCardInfo);
    String str = "";
    if (bool)
    {
      int i;
      if (localCard != null) {
        i = localCard.age;
      } else if (localContactCard != null) {
        i = localContactCard.bAge;
      } else {
        i = -1;
      }
      if ((i > 0) && (!a()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(paramContext.getString(2131719391));
        localObject = ((StringBuilder)localObject).toString();
        break label124;
      }
    }
    Object localObject = "";
    label124:
    if (((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isFieldVisible(41614, paramProfileCardInfo))
    {
      if (localCard != null)
      {
        if ((!TextUtils.isEmpty(localCard.strCountry)) && (!HardCodeUtil.a(2131708435).equals(localCard.strCountry)))
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          paramContext.append(localCard.strCountry);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "";
        }
        paramProfileCardInfo = paramContext;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          paramProfileCardInfo = paramContext;
          if (!TextUtils.isEmpty(paramContext))
          {
            paramProfileCardInfo = new StringBuilder();
            paramProfileCardInfo.append(paramContext);
            paramProfileCardInfo.append(" ");
            paramProfileCardInfo = paramProfileCardInfo.toString();
          }
          paramContext = new StringBuilder();
          paramContext.append(paramProfileCardInfo);
          paramContext.append(localCard.strProvince);
          paramProfileCardInfo = paramContext.toString();
        }
        paramContext = paramProfileCardInfo;
        if (TextUtils.isEmpty(localCard.strCity)) {
          break label609;
        }
        paramContext = paramProfileCardInfo;
        if (!TextUtils.isEmpty(paramProfileCardInfo))
        {
          paramContext = new StringBuilder();
          paramContext.append(paramProfileCardInfo);
          paramContext.append(" ");
          paramContext = paramContext.toString();
        }
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append(paramContext);
        paramProfileCardInfo.append(localCard.strCity);
        paramContext = paramProfileCardInfo.toString();
        break label609;
      }
      if (localContactCard != null)
      {
        if ((!TextUtils.isEmpty(localContactCard.strCountry)) && (!HardCodeUtil.a(2131708448).equals(localContactCard.strCountry)))
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          paramContext.append(localContactCard.strCountry);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "";
        }
        paramProfileCardInfo = paramContext;
        if (!TextUtils.isEmpty(localContactCard.strProvince))
        {
          paramProfileCardInfo = paramContext;
          if (!TextUtils.isEmpty(paramContext))
          {
            paramProfileCardInfo = new StringBuilder();
            paramProfileCardInfo.append(paramContext);
            paramProfileCardInfo.append(" ");
            paramProfileCardInfo = paramProfileCardInfo.toString();
          }
          paramContext = new StringBuilder();
          paramContext.append(paramProfileCardInfo);
          paramContext.append(localContactCard.strProvince);
          paramProfileCardInfo = paramContext.toString();
        }
        paramContext = paramProfileCardInfo;
        if (TextUtils.isEmpty(localContactCard.strCity)) {
          break label609;
        }
        paramContext = paramProfileCardInfo;
        if (!TextUtils.isEmpty(paramProfileCardInfo))
        {
          paramContext = new StringBuilder();
          paramContext.append(paramProfileCardInfo);
          paramContext.append(" ");
          paramContext = paramContext.toString();
        }
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append(paramContext);
        paramProfileCardInfo.append(localContactCard.strCity);
        paramContext = paramProfileCardInfo.toString();
        break label609;
      }
    }
    paramContext = "";
    label609:
    paramProfileCardInfo = str;
    if (localObject != null)
    {
      paramProfileCardInfo = str;
      if (((String)localObject).length() > 0)
      {
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append("");
        paramProfileCardInfo.append(" ");
        paramProfileCardInfo.append((String)localObject);
        paramProfileCardInfo = paramProfileCardInfo.toString();
      }
    }
    localObject = paramProfileCardInfo;
    if (paramContext != null)
    {
      localObject = paramProfileCardInfo;
      if (paramContext.length() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramProfileCardInfo);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramContext);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.PROFILE_CARD_BACKGROUND_DIR);
    localStringBuilder.append("IMG");
    int i = 1;
    localStringBuilder.append(localCalendar.get(1));
    int j = localCalendar.get(2) + 1;
    if (j < 10)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("0");
      paramQQAppInterface.append(j);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else
    {
      paramQQAppInterface = Integer.valueOf(j);
    }
    localStringBuilder.append(paramQQAppInterface);
    j = localCalendar.get(5);
    if (j < 10)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("0");
      paramQQAppInterface.append(j);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else
    {
      paramQQAppInterface = Integer.valueOf(j);
    }
    localStringBuilder.append(paramQQAppInterface);
    j = localCalendar.get(11);
    if (j < 10)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("0");
      paramQQAppInterface.append(j);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else
    {
      paramQQAppInterface = Integer.valueOf(j);
    }
    localStringBuilder.append(paramQQAppInterface);
    j = localCalendar.get(12);
    if (j < 10)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("0");
      paramQQAppInterface.append(j);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else
    {
      paramQQAppInterface = Integer.valueOf(j);
    }
    localStringBuilder.append(paramQQAppInterface);
    j = localCalendar.get(13);
    if (j < 10)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("0");
      paramQQAppInterface.append(j);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else
    {
      paramQQAppInterface = Integer.valueOf(j);
    }
    localStringBuilder.append(paramQQAppInterface);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(localStringBuilder.toString());
    paramQQAppInterface.append(".jpg");
    if (!new File(paramQQAppInterface.toString()).exists())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(localStringBuilder.toString());
      paramQQAppInterface.append(".jpg");
      return paramQQAppInterface.toString();
    }
    paramQQAppInterface = new StringBuilder(localStringBuilder);
    j = localStringBuilder.length();
    while (i < 2147483647)
    {
      paramQQAppInterface.append('(');
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(')');
      paramQQAppInterface.append(".jpg");
      if (!new File(paramQQAppInterface.toString()).exists()) {
        break;
      }
      paramQQAppInterface.delete(j, paramQQAppInterface.length());
      i += 1;
    }
    return paramQQAppInterface.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQQAppInterface != null) && (paramActivity != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null) && (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.uin)))
    {
      String str = paramProfileCardInfo.allInOne.uin;
      QidianManager localQidianManager = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
      if (localQidianManager.a(str)) {
        return String.format("https://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027", new Object[] { str, Integer.valueOf(paramQQAppInterface.getAppid()), "android-8.7.0" });
      }
      if (localQidianManager.f(str)) {
        return paramActivity.getIntent().getStringExtra("key_qidian_detail_url");
      }
      return ProfileCardUtils.getProfileDetailUrl(paramQQAppInterface, paramProfileCardInfo);
    }
    return null;
  }
  
  public static String a(AllInOne paramAllInOne)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramAllInOne != null)
    {
      localObject2 = localObject1;
      if (paramAllInOne.contactArray != null)
      {
        localObject2 = localObject1;
        if (paramAllInOne.contactArray.size() > 0)
        {
          localObject2 = (ProfileContactInfo)paramAllInOne.contactArray.get(0);
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(((ProfileContactInfo)localObject2).phoneNationalCode);
            ((StringBuilder)localObject1).append(((ProfileContactInfo)localObject2).phoneNumber);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(paramAllInOne.uin)) {
              localObject2 = paramAllInOne.uin;
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ProfileCardTemplateUtil.a());
    localStringBuilder.append(b(paramString));
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 != 0) && (paramInt2 != 1))
          {
            if (paramInt2 == 2) {
              return "mvip.gongneng.android.mingpian_open429";
            }
            if (paramInt2 == 4) {
              return "mvip.gongneng.android.mingpian_open4210";
            }
          }
          else
          {
            return "mvip.gongneng.android.mingpian_open427";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4)) {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 != 0) && (paramInt2 != 1))
          {
            if (paramInt2 == 2) {
              return "mvip.gongneng.android.mingpian_open424";
            }
            if (paramInt2 == 4) {
              return "mvip.gongneng.android.mingpian_open425";
            }
          }
          else
          {
            return "mvip.gongneng.android.mingpian_open422";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4)) {
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
  
  public static List<Pair<String, String>> a(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    ArrayList localArrayList = new ArrayList(3);
    if (paramContext != null)
    {
      if (paramProfileCardInfo.card == null) {
        return localArrayList;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
      }
      int i = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(paramProfileCardInfo);
      if (i == 0) {
        localArrayList.add(Pair.create(paramContext.getString(2131693879), ""));
      } else if (i == 1) {
        localArrayList.add(Pair.create(paramContext.getString(2131692259), ""));
      }
      paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getSchoolWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(Pair.create(paramContext, "school"));
      }
      paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(Pair.create(paramContext, "company"));
      }
      if (localArrayList.size() >= 4) {
        return localArrayList;
      }
      paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(paramProfileCardInfo);
      String str1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(paramProfileCardInfo);
      String str2 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(paramProfileCardInfo);
      StringBuilder localStringBuilder = new StringBuilder(50);
      if ((!TextUtils.isEmpty(paramContext)) && (!HardCodeUtil.a(2131708444).equals(paramContext))) {
        localStringBuilder.append(paramContext);
      }
      if (!TextUtils.isEmpty(str1))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str1);
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str2);
      }
      if (localStringBuilder.length() > 0) {
        localArrayList.add(Pair.create(localStringBuilder.toString(), "location"));
      }
      if (localArrayList.size() >= 4) {
        return localArrayList;
      }
      paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(Pair.create(paramContext, ""));
      }
    }
    return localArrayList;
  }
  
  public static List<SpannableString> a(QQAppInterface paramQQAppInterface, Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramContext != null)
    {
      if (paramProfileCardInfo.card == null) {
        return localArrayList;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
      }
      int i = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(paramProfileCardInfo);
      if (i == 0) {
        localArrayList.add(new SpannableString(paramContext.getString(2131693879)));
      } else if (i == 1) {
        localArrayList.add(new SpannableString(paramContext.getString(2131692259)));
      }
      String str = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getSchoolWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(str)) {
        if (paramProfileCardInfo.card.schoolVerifiedFlag) {
          localArrayList.add(a(str, true, 2130845178, 2131298260, 2131298259, paramContext, paramQQAppInterface));
        } else {
          localArrayList.add(new SpannableString(paramProfileCardInfo.card.strSchool));
        }
      }
      paramQQAppInterface = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
      if (localArrayList.size() >= 4) {
        return localArrayList;
      }
      paramQQAppInterface = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(paramProfileCardInfo);
      paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(paramProfileCardInfo);
      str = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(paramProfileCardInfo);
      StringBuilder localStringBuilder = new StringBuilder(50);
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!HardCodeUtil.a(2131708444).equals(paramQQAppInterface))) {
        localStringBuilder.append(paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(paramContext);
      }
      if (!TextUtils.isEmpty(str))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str);
      }
      if (localStringBuilder.length() > 0) {
        localArrayList.add(new SpannableString(localStringBuilder.toString()));
      }
      if (localArrayList.size() >= 4) {
        return localArrayList;
      }
      paramQQAppInterface = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
    }
    return localArrayList;
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
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt, AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramActivity, paramView, paramString, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2, AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("is_hide_actionsheet", paramBoolean1);
    localIntent.putExtra("is_hide_footbar", paramBoolean2);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramBoolean, false, "", 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean, int paramInt4)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramBoolean, false, "", paramInt4);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt4)
  {
    paramString4 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString4.putExtra("uin", paramString1);
    paramString4.putExtra("isShowAd", false);
    paramString4.putExtra("hide_more_button", true);
    paramString4.putExtra("has_red_dot", paramBoolean2);
    paramString4.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2 = IndividuationUrlHelper.a(paramActivity, "card", paramString2);
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("&");
      paramString1.append(paramString3);
      paramString1 = paramString1.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("&entryId=");
    paramString2.append(paramInt2);
    paramString2.append("&isCache=");
    paramString2.append(paramInt1);
    paramString2.append("&tabId=");
    paramString2.append(paramInt3);
    paramString1 = paramString2.toString();
    if (((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isProfileCardActivity(paramActivity)) {
      if (paramInt2 == 0) {
        paramString4.putExtra("individuation_url_type", 40202);
      } else if (paramInt2 == 1) {
        paramString4.putExtra("individuation_url_type", 40203);
      } else if (paramInt2 == 3) {
        paramString4.putExtra("individuation_url_type", 40204);
      }
    }
    paramString1 = VasWebviewUtil.a(paramString1, paramInt4);
    paramString4.putExtra("url", paramString1);
    VasWebviewUtil.b(paramActivity, paramString1, -1L, paramString4, paramBoolean1, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString1);
      Card localCard = a((AppRuntime)localObject, paramString2);
      paramString1 = new AllInOne(paramString2, 9);
      paramString1.nickname = ContactUtils.a((AppRuntime)localObject, paramString2);
      paramString1.preWinUin = paramString2;
      paramString1.preWinType = paramInt;
      paramString1.lastActivity = 2;
      paramString1.profileEntryType = 123;
      paramString2 = new ProfileCardInfo();
      paramString2.card = localCard;
      paramString2.allInOne = paramString1;
      paramString2 = BusinessCardUtils.a((AppInterface)localObject, paramString2);
      if (paramString2.mobilesNum.size() >= 3)
      {
        QQToast.a(paramActivity, 0, 2131694827, 0).a();
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("add_phone_num", paramString3);
      a(paramActivity, paramString2, paramString1, false, (Bundle)localObject);
      return;
    }
    catch (AccountNotMatchException paramActivity)
    {
      QLog.e("openBusinessCardToAddingPhone", 1, paramActivity, new Object[0]);
    }
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 1500L) {
      return;
    }
    jdField_a_of_type_Long = l;
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/signature/msglist?_wv=3&_wwv=128");
    paramContext.startActivity(localIntent);
    paramContext = (LocalRedTouchManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    paramContext.a(10019, false);
    paramContext.a(10020, false);
    paramContext.a(10022, false);
    paramContext.a(10021, false);
    paramContext.a(10023, false);
    paramContext.a(10024, false);
    paramContext.a(10025, false);
    paramContext.a(10026, false);
    paramContext.a(10027, false);
    paramContext.a(10028, false);
    QLog.d("ProfileCardUtil", 1, "jumpProfileBubbleMsgList");
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
  
  public static void a(Context paramContext, BusinessCard paramBusinessCard, AllInOne paramAllInOne)
  {
    a(paramContext, paramBusinessCard, paramAllInOne, false);
  }
  
  public static void a(Context paramContext, BusinessCard paramBusinessCard, AllInOne paramAllInOne, boolean paramBoolean)
  {
    a(paramContext, paramBusinessCard, paramAllInOne, paramBoolean, null);
  }
  
  public static void a(Context paramContext, BusinessCard paramBusinessCard, AllInOne paramAllInOne, boolean paramBoolean, Bundle paramBundle)
  {
    Intent localIntent;
    if (!paramBoolean)
    {
      localIntent = new Intent(paramContext, BusinessCardEditActivity.class);
    }
    else
    {
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", BusinessCardEditActivity.class.getName());
    }
    if (paramAllInOne.pa == 0)
    {
      localIntent.putExtra("mode_type", 3);
      localIntent.putExtra("source_activity", 3);
    }
    else
    {
      localIntent.putExtra("mode_type", 2);
      localIntent.putExtra("source_activity", 1);
      paramBusinessCard.bindUin = paramAllInOne.uin;
    }
    localIntent.putExtra("cur_card_body", paramBusinessCard);
    localIntent.putExtra("is_edit_mode", true);
    localIntent.putExtra("finish_immedia", true);
    Object localObject = paramAllInOne.contactArray;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramBusinessCard = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBusinessCard.add(((ProfileContactInfo)((Iterator)localObject).next()).phoneNumber);
      }
      localIntent.putExtra("bind_phone_num", paramBusinessCard);
    }
    if (paramBoolean)
    {
      localIntent.putExtra("notify_plugin", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramContext.startActivity(localIntent);
    if (paramAllInOne.pa == 0)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2)
  {
    if (paramTextView != null)
    {
      Resources localResources = paramTextView.getResources();
      LongClickCopyData localLongClickCopyData = new LongClickCopyData();
      String str = paramTextView.getText().toString();
      if ((paramString1 != null) && (str.contains(paramString1)))
      {
        localLongClickCopyData.addCopyItem(localResources.getString(2131699149), paramString1);
        if ((!TextUtils.isEmpty(paramString2)) && (str.length() > paramString1.length() + 2)) {
          localLongClickCopyData.addCopyItem(localResources.getString(2131699148), paramString2);
        }
      }
      else if ((paramString2 != null) && (str.contains(paramString2)))
      {
        localLongClickCopyData.addCopyItem(localResources.getString(2131699148), paramString2);
      }
      else
      {
        localLongClickCopyData.addCopyItem(localResources.getString(2131699147), str);
      }
      LongClickCopyAction.attachCopyAction(paramTextView, localLongClickCopyData);
    }
  }
  
  @Deprecated
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    NewReportPlugin.a(paramBaseActivity, paramLong, paramString1, paramString2, paramInt, "", new Bundle());
  }
  
  @Deprecated
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    NewReportPlugin.a(paramBaseActivity, paramLong, paramString1, paramString2, paramInt, paramString3, paramBundle);
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface)
  {
    QVipConfigManager.a(paramQQAppInterface, "show_diy_template_guide_for_guest_time", QVipConfigManager.a(paramQQAppInterface, "show_diy_template_guide_for_guest_time", 0) + 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, null, 0L, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F, "", 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, int paramInt, String paramString3, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, String paramString5, long paramLong4)
  {
    paramQQAppInterface.execute(new ProfileCardUtil.4(paramInt, paramString3, paramString4, paramFloat1, paramFloat2, paramFloat3, paramQQAppInterface, paramLong4, paramLong1, paramLong2, paramString1, paramLong3, paramString2, paramString5));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, String paramString3, long paramLong4)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F, paramString3, paramLong4);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = paramView instanceof DynamicAvatarView;
    int i = 0;
    if (bool)
    {
      DynamicFaceDrawable localDynamicFaceDrawable = ((DynamicAvatarView)paramView).a;
      if ((localDynamicFaceDrawable != null) && (localDynamicFaceDrawable.a) && (!TextUtils.isEmpty(localDynamicFaceDrawable.c)))
      {
        b(paramActivity, paramView, localDynamicFaceDrawable.c);
        paramInt1 = 1;
      }
      else if (paramInt2 == 1)
      {
        a(paramActivity, paramView, paramString, paramInt1);
        paramInt1 = i;
      }
      else
      {
        a(paramActivity, paramView, paramString, true, true);
        paramInt1 = i;
      }
    }
    else if (paramInt2 == 1)
    {
      a(paramActivity, paramView, paramString, paramInt1);
      paramInt1 = i;
    }
    else
    {
      a(paramActivity, paramView, paramString, true, true);
      paramInt1 = i;
    }
    if (paramInt2 == 0)
    {
      if (paramInt1 != 0) {
        paramActivity = "1";
      } else {
        paramActivity = "0";
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramActivity, "", "", "");
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = localStringBuilder.toString();
    localSharedPreferences.edit().putLong(paramQQAppInterface, System.currentTimeMillis()).apply();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    ThreadManager.postImmediately(new ProfileCardUtil.1(paramString, paramIntent, paramQQAppInterface), null, true);
  }
  
  public static void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((paramCard != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_school_guide_init_");
      localStringBuilder.append(paramCard.uin);
      paramQQAppInterface.putBoolean(localStringBuilder.toString(), false).commit();
    }
  }
  
  public static void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((paramProfileCardInfo != null) && (paramQQAppInterface != null))
    {
      if (paramActivity == null) {
        return;
      }
      paramProfileCardInfo = a(paramQQAppInterface, paramActivity, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardUtil", 2, String.format("openDetails url=%s", new Object[] { paramProfileCardInfo }));
      }
      if (!TextUtils.isEmpty(paramProfileCardInfo))
      {
        Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", paramProfileCardInfo);
        localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
        localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
        localIntent.putExtra("reqType", 1);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        paramActivity.startActivity(localIntent);
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ProfileCardUtil.3(paramString));
  }
  
  public static final void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = jdField_a_of_type_JavaLangStringBuilder;
    if (localStringBuilder == null) {
      jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    } else {
      localStringBuilder.setLength(0);
    }
    localStringBuilder = jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", reason = [");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], code = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("UPLOAD_AVATAR_FAIL", 1, jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public static void a(String paramString, Activity paramActivity)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if ((!bool2) && (paramActivity != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putString("forward_filepath", paramString);
      localBundle.putString("forward_thumb", paramString);
      paramString = new Intent();
      paramString.putExtras(localBundle);
      ForwardBaseOption.a(paramActivity, paramString, 21);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("param:activity:");
      if (paramActivity != null) {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.i("forwardtofriend", 2, paramString.toString());
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null) && (paramActivity != null))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = paramQQAppInterface.getCurrentAccountUin();
      localUserInfo.nickname = ContactUtils.e(paramQQAppInterface, localUserInfo.qzone_uin);
      QZoneHelper.forwardToPublishMood(paramActivity, localUserInfo, paramString, paramActivity.getString(2131692105), "", -1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("param:app:");
      boolean bool2 = true;
      boolean bool1;
      if (paramQQAppInterface == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.append(bool1);
      paramString.append(",activity:");
      if (paramActivity == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.i("forwardQzone", 2, paramString.toString());
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openAddPersonalityLabel");
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("url", Constants.c);
    paramString.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify_personality_label");
    paramString.putExtra("fromProfile", paramBoolean);
    paramActivity.startActivity(paramString);
  }
  
  public static boolean a()
  {
    String str = Locale.getDefault().getCountry();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(str, arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QVipConfigManager.a(paramQQAppInterface, "show_diy_template_guide_for_guest_time", 0) >= 3) {
      return false;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return System.currentTimeMillis() - l >= 86400000L;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    boolean bool = false;
    if (a(paramQQAppInterface, paramString, paramIntent, false).jdField_a_of_type_Int == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCard != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (!paramCard.isNewSchoolStatusWriteForGuide())
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramCard.strSchool))
          {
            paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("new_school_guide_init_");
            localStringBuilder.append(paramCard.uin);
            bool1 = paramQQAppInterface.getBoolean(localStringBuilder.toString(), true);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("isNeedGuideForNewSchoolData ");
      paramCard.append(bool1);
      QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
    }
    return bool1;
  }
  
  public static boolean a(ProfileCardBackground paramProfileCardBackground)
  {
    return paramProfileCardBackground.jdField_a_of_type_Int == 160;
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not exists");
        }
        return false;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isExistBgResource exception msg=");
        localStringBuilder.append(paramString.getMessage());
        QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      return paramArrayList.contains(Integer.valueOf(2));
    }
    return false;
  }
  
  public static int b(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (int)((Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - 10) * 0.8F + 0.5F);
  }
  
  public static int b(Context paramContext)
  {
    return (int)(a(paramContext) * 0.56338F);
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static String b(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(paramProfileCardInfo);
    if (i == 0)
    {
      localStringBuilder.append(paramContext.getString(2131693879));
      localStringBuilder.append("  ");
    }
    else if (i == 1)
    {
      localStringBuilder.append(paramContext.getString(2131692259));
      localStringBuilder.append("  ");
    }
    i = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getAgeWithPrivacy(paramProfileCardInfo);
    if (a()) {
      i = 0;
    }
    if (i != 0)
    {
      localStringBuilder.append(i);
      localStringBuilder.append(paramContext.getString(2131719391));
      localStringBuilder.append("  ");
    }
    paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramContext))
    {
      localStringBuilder.append(paramContext);
      localStringBuilder.append("  ");
    }
    String str3 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(paramProfileCardInfo);
    String str2 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(paramProfileCardInfo);
    String str1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(paramProfileCardInfo);
    paramProfileCardInfo = "";
    paramContext = paramProfileCardInfo;
    if (!TextUtils.isEmpty(str3))
    {
      paramContext = paramProfileCardInfo;
      if (!HardCodeUtil.a(2131708464).equals(str3))
      {
        paramContext = new StringBuilder();
        paramContext.append("");
        paramContext.append(str3);
        paramContext = paramContext.toString();
      }
    }
    paramProfileCardInfo = paramContext;
    if (!TextUtils.isEmpty(str2))
    {
      paramProfileCardInfo = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append(paramContext);
        paramProfileCardInfo.append("-");
        paramProfileCardInfo = paramProfileCardInfo.toString();
      }
      paramContext = new StringBuilder();
      paramContext.append(paramProfileCardInfo);
      paramContext.append(str2);
      paramProfileCardInfo = paramContext.toString();
    }
    paramContext = paramProfileCardInfo;
    if (!TextUtils.isEmpty(str1))
    {
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(paramProfileCardInfo))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramProfileCardInfo);
        paramContext.append("-");
        paramContext = paramContext.toString();
      }
      paramProfileCardInfo = new StringBuilder();
      paramProfileCardInfo.append(paramContext);
      paramProfileCardInfo.append(str1);
      paramContext = paramProfileCardInfo.toString();
    }
    localStringBuilder.append(paramContext);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
  
  public static void b(Activity paramActivity, View paramView, String paramString)
  {
    Object localObject = new PicInfo();
    ((PicInfo)localObject).d = paramString;
    paramString = new ArrayList(1);
    paramString.add(localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("intent_param_index", 0);
    ((Intent)localObject).putExtra("intent_param_pic_infos", paramString);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    ((Intent)localObject).addFlags(536870912);
    RouteUtils.a(paramActivity, (Intent)localObject, "/nearby/profile/pic/browser");
  }
  
  @NotNull
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    paramQQAppInterface.a(10019, false);
    paramQQAppInterface.a(10020, false);
    paramQQAppInterface.a(10022, false);
    paramQQAppInterface.a(10021, false);
    paramQQAppInterface.a(10023, false);
    paramQQAppInterface.a(10024, false);
    paramQQAppInterface.a(10025, false);
    paramQQAppInterface.a(10026, false);
    paramQQAppInterface.a(10027, false);
    paramQQAppInterface.a(10028, false);
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null) && (paramActivity != null)) {
      try
      {
        QfavBuilder.b(paramString).a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("forwardFavorite", 2, "", paramString);
        }
        QQToast.a(paramActivity, paramActivity.getResources().getString(2131692762), 0).a();
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("param:app:");
      boolean bool2 = true;
      boolean bool1;
      if (paramQQAppInterface == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.append(bool1);
      paramString.append(",activity:");
      if (paramActivity == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.i("forwardFavorite", 2, paramString.toString());
    }
  }
  
  public static boolean b(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      return paramArrayList.contains(Integer.valueOf(1));
    }
    return false;
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
  
  public static String c(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    if (((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isFieldVisible(41611, paramProfileCardInfo))
    {
      localObject1 = paramProfileCardInfo.card;
      localObject2 = paramProfileCardInfo.contactCard;
      int i;
      if ((paramProfileCardInfo.allInOne.gender != 0) && (paramProfileCardInfo.allInOne.gender != 1))
      {
        if ((localObject1 != null) && ((((Card)localObject1).shGender == 0) || (((Card)localObject1).shGender == 1))) {
          i = ((Card)localObject1).shGender;
        } else if ((localObject2 != null) && ((((ContactCard)localObject2).bSex == 0) || (((ContactCard)localObject2).bSex == 1))) {
          i = ((ContactCard)localObject2).bSex;
        } else {
          i = -1;
        }
      }
      else {
        i = paramProfileCardInfo.allInOne.gender;
      }
      if (i == 0)
      {
        localObject1 = paramContext.getString(2131693879);
        break label162;
      }
      if (i == 1)
      {
        localObject1 = paramContext.getString(2131692259);
        break label162;
      }
    }
    Object localObject1 = "";
    label162:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(a(paramContext, paramProfileCardInfo));
    return ((StringBuilder)localObject2).toString();
  }
  
  public static boolean c(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      return paramArrayList.contains(Integer.valueOf(3));
    }
    return false;
  }
  
  public static int d(Activity paramActivity)
  {
    return c(paramActivity) * 3 / 4;
  }
  
  public static boolean d(ArrayList<Integer> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      if ((!b(paramArrayList)) && (!c(paramArrayList)))
      {
        bool1 = bool2;
        if (!a(paramArrayList)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean e(ArrayList<Integer> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      if (!b(paramArrayList))
      {
        bool1 = bool2;
        if (!c(paramArrayList)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil
 * JD-Core Version:    0.7.0.1
 */