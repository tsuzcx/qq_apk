package com.tencent.mobileqq.vas;

import akpc;
import akpd;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ICmShowLibLoadCallback;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.earlydownload.handler.ApolloLibHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class FlashCarGameManager
  implements Handler.Callback, ICmShowLibLoadCallback, Manager
{
  public static final String a;
  public static boolean a;
  public static final String b;
  public static boolean b;
  public static final String c;
  public static boolean c;
  private static final String d;
  public static boolean d;
  private static final String e;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public PopupWindow a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private MqqHandler b;
  public boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aK + ".apollo/game/3003/";
    jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "sandbox/";
    jdField_e_of_type_JavaLangString = jdField_d_of_type_JavaLangString + "qq_screenshot.png";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "main.js";
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "loading/";
    jdField_c_of_type_Boolean = true;
  }
  
  public FlashCarGameManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.setHandler(FlashCarGameManager.class, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getFileThreadLooper());
  }
  
  private CustomFrameAnimationDrawable a()
  {
    int m = 0;
    Object localObject1 = new File(jdField_c_of_type_JavaLangString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if (localObject1.length > 0)
      {
        int n = localObject1.length;
        int j = 0;
        int k;
        for (int i = 0; j < n; i = k)
        {
          k = i;
          if (localObject1[j].endsWith(".png")) {
            k = i + 1;
          }
          j += 1;
        }
        if (i > 0)
        {
          localObject1 = new ArrayList();
          j = 1;
          while (j <= i)
          {
            if (new File(jdField_c_of_type_JavaLangString + j + ".png").exists()) {
              ((ArrayList)localObject1).add(jdField_c_of_type_JavaLangString + j + ".png");
            }
            j += 1;
          }
          try
          {
            Object localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inSampleSize = 1;
            ((BitmapFactory.Options)localObject2).inMutable = true;
            localObject2 = ImageUtil.a((String)((ArrayList)localObject1).get(0), (BitmapFactory.Options)localObject2);
            localObject2 = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), (Bitmap)localObject2, this.jdField_b_of_type_MqqOsMqqHandler);
            ((CustomFrameAnimationDrawable)localObject2).h();
            i = m;
            while (i < ((ArrayList)localObject1).size())
            {
              ((CustomFrameAnimationDrawable)localObject2).a(i, 200, (String)((ArrayList)localObject1).get(i));
              i += 1;
            }
            return localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            QLog.e("FlashCarGame", 1, "getLoadingDrawable error: " + localOutOfMemoryError.getMessage());
          }
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, View paramView)
  {
    // Byte code:
    //   0: new 114	java/io/File
    //   3: dup
    //   4: getstatic 51	com/tencent/mobileqq/vas/FlashCarGameManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 114	java/io/File
    //   14: dup
    //   15: getstatic 55	com/tencent/mobileqq/vas/FlashCarGameManager:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_3
    //   23: invokevirtual 121	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_3
    //   30: invokevirtual 208	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aload_2
    //   35: invokevirtual 211	java/io/File:createNewFile	()Z
    //   38: pop
    //   39: new 213	java/io/FileOutputStream
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 216	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: aload_0
    //   49: getstatic 222	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   52: bipush 100
    //   54: aload_2
    //   55: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 231	java/io/FileOutputStream:flush	()V
    //   63: aload_2
    //   64: invokevirtual 234	java/io/FileOutputStream:close	()V
    //   67: aload_1
    //   68: invokevirtual 239	android/view/View:destroyDrawingCache	()V
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual 242	android/view/View:setDrawingCacheEnabled	(Z)V
    //   76: getstatic 55	com/tencent/mobileqq/vas/FlashCarGameManager:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   79: areturn
    //   80: astore_3
    //   81: ldc 188
    //   83: iconst_1
    //   84: new 27	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   91: ldc 244
    //   93: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_3
    //   97: invokevirtual 245	java/io/IOException:toString	()Ljava/lang/String;
    //   100: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: goto -70 -> 39
    //   112: astore_2
    //   113: ldc 188
    //   115: iconst_1
    //   116: new 27	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   123: ldc 244
    //   125: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 246	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   132: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -95 -> 48
    //   146: astore_0
    //   147: ldc 248
    //   149: areturn
    //   150: astore_0
    //   151: ldc 188
    //   153: iconst_1
    //   154: new 27	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   161: ldc 244
    //   163: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_0
    //   167: invokevirtual 245	java/io/IOException:toString	()Ljava/lang/String;
    //   170: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: goto -116 -> 63
    //   182: astore_0
    //   183: ldc 188
    //   185: iconst_1
    //   186: new 27	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   193: ldc 244
    //   195: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: invokevirtual 245	java/io/IOException:toString	()Ljava/lang/String;
    //   202: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: goto -144 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramBitmap	Bitmap
    //   0	214	1	paramView	View
    //   21	43	2	localObject1	Object
    //   112	17	2	localFileNotFoundException	java.io.FileNotFoundException
    //   142	1	2	localObject2	Object
    //   10	20	3	localFile	File
    //   80	17	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   22	34	80	java/io/IOException
    //   34	39	80	java/io/IOException
    //   39	48	112	java/io/FileNotFoundException
    //   48	59	146	java/lang/Exception
    //   59	63	150	java/io/IOException
    //   63	67	182	java/io/IOException
  }
  
  private static String a(String paramString)
  {
    return String.format("lib%s.so", new Object[] { paramString });
  }
  
  private boolean a()
  {
    if (new File(jdField_b_of_type_JavaLangString).exists()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlashCarGame", 2, "checkGameResource game not exists");
    }
    this.jdField_e_of_type_Boolean = true;
    return false;
  }
  
  private boolean b()
  {
    Object localObject2 = UpdateAvSo.a() + a("png-armeabi-v7a");
    Object localObject3 = UpdateAvSo.a() + a("TcHevcDec");
    Object localObject1 = UpdateAvSo.a() + a("sava");
    localObject2 = new File((String)localObject2);
    localObject3 = new File((String)localObject3);
    localObject1 = new File((String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("FlashCarGame", 2, "checkApolloSoExists png: " + ((File)localObject2).exists() + " sharpP: " + ((File)localObject3).exists() + " sava: " + ((File)localObject1).exists() + " jsc: " + ApolloLibHandler.b());
    }
    return (ApolloLibHandler.b()) && (((File)localObject2).exists()) && (((File)localObject3).exists()) && (((File)localObject1).exists());
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void a(View paramView, Activity paramActivity)
  {
    if ((jdField_b_of_type_Boolean) && (a(true))) {
      b(paramView, paramActivity);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashCarGame", 2, "onLoadCompleted startGame = " + paramBoolean);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(261, 3000L);
      }
      SosoInterface.a(new akpd(this, 3, true, true, 300000L, true, false, "FlashCarGame"));
      return;
    }
    a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2;
    if (!paramBoolean)
    {
      if (!jdField_c_of_type_Boolean) {
        return false;
      }
      jdField_c_of_type_Boolean = false;
      bool2 = GesturePWDUtils.getSplashLock(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      bool1 = bool2;
      if (bool2) {
        jdField_b_of_type_Boolean = true;
      }
    }
    for (boolean bool1 = bool2;; bool1 = GesturePWDUtils.getGestureLocking(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashCarGame", 2, "shouldShowGameLoading isGestrueLocking = " + bool1 + " afterLock = " + paramBoolean + " shouGameLoading = " + jdField_a_of_type_Boolean + " isLogin" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin());
      }
      if ((!jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (bool1) || (!a())) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("flash_car_game_config", 0);
      if ((!"qq_flash_car".equals(((SharedPreferences)localObject).getString("splash_title", ""))) || (System.currentTimeMillis() - ((SharedPreferences)localObject).getLong("flash_car_game_loaded_time", 0L) <= 604800000L) || (!b())) {
        break;
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("flash_car_game_loaded_time", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).apply();
      return true;
    }
    return false;
  }
  
  public void b(View paramView, Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
      paramActivity = LayoutInflater.from(paramActivity).inflate(2130968998, null);
      ImageView localImageView = (ImageView)paramActivity.findViewById(2131364666);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null)
        {
          localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
        }
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramActivity, -1, -1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BFFFFFFF")));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, 0, 0);
      if (!paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(true);
      }
      paramView.buildDrawingCache();
      paramActivity = paramView.getDrawingCache();
      if (QLog.isColorLevel()) {
        QLog.d("FlashCarGame", 2, "screenShot bitmap = " + paramActivity);
      }
      ApolloEngine.a(this);
      ThreadManager.post(new akpc(this, paramActivity, paramView), 8, null, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        a(true);
        return true;
        a(false);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("FlashCarGame", 2, "MSG_APOLLO_GAME_START");
        }
        a();
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = null;
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("FlashCarGame", 2, "MSG_GET_LOCATION_FAIL");
      }
      jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
      ApolloGameActivity.a(this.jdField_a_of_type_AndroidAppActivity, 3003, 1, "{\"isFromSplash\":1}", null);
    } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(259, 2000L);
    return true;
    a();
    return true;
  }
  
  public void onDestroy()
  {
    ApolloEngine.b(this);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeHandler(FlashCarGameManager.class);
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FlashCarGameManager
 * JD-Core Version:    0.7.0.1
 */