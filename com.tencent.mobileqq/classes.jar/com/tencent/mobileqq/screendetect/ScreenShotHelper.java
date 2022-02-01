package com.tencent.mobileqq.screendetect;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.IScreenShotShareHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.ConversationHelper;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class ScreenShotHelper
{
  private static ScreenShotConfigProcessor.ScreenShotConfigData jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotConfigProcessor$ScreenShotConfigData;
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  public static boolean a;
  private static boolean b = false;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3000));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1004));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1000));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1022));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1001));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10002));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1006));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1005));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10008));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10010));
  }
  
  /* Error */
  public static Point a(Context paramContext)
  {
    // Byte code:
    //   0: new 45	android/graphics/Point
    //   3: dup
    //   4: invokespecial 46	android/graphics/Point:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: ldc 48
    //   11: invokevirtual 54	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 56	android/view/WindowManager
    //   17: invokeinterface 60 1 0
    //   22: astore_0
    //   23: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 17
    //   28: if_icmplt +10 -> 38
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 72	android/view/Display:getRealSize	(Landroid/graphics/Point;)V
    //   36: aload_1
    //   37: areturn
    //   38: ldc 68
    //   40: ldc 74
    //   42: iconst_0
    //   43: anewarray 76	java/lang/Class
    //   46: invokevirtual 80	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   49: astore_2
    //   50: ldc 68
    //   52: ldc 82
    //   54: iconst_0
    //   55: anewarray 76	java/lang/Class
    //   58: invokevirtual 80	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: astore_3
    //   62: aload_1
    //   63: aload_2
    //   64: aload_0
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokevirtual 88	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 28	java/lang/Integer
    //   75: invokevirtual 92	java/lang/Integer:intValue	()I
    //   78: aload_3
    //   79: aload_0
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokevirtual 88	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 28	java/lang/Integer
    //   90: invokevirtual 92	java/lang/Integer:intValue	()I
    //   93: invokevirtual 96	android/graphics/Point:set	(II)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 99	android/view/Display:getWidth	()I
    //   104: aload_0
    //   105: invokevirtual 102	android/view/Display:getHeight	()I
    //   108: invokevirtual 96	android/graphics/Point:set	(II)V
    //   111: aload_2
    //   112: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   115: aload_1
    //   116: areturn
    //   117: astore_2
    //   118: aload_1
    //   119: astore_0
    //   120: aload_2
    //   121: astore_1
    //   122: goto +6 -> 128
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: ldc 107
    //   130: iconst_1
    //   131: ldc 109
    //   133: aload_1
    //   134: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload_0
    //   138: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramContext	Context
    //   7	115	1	localObject	Object
    //   125	9	1	localException1	Exception
    //   49	15	2	localMethod1	java.lang.reflect.Method
    //   98	14	2	localException2	Exception
    //   117	4	2	localException3	Exception
    //   61	18	3	localMethod2	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   38	96	98	java/lang/Exception
    //   8	36	117	java/lang/Exception
    //   99	115	117	java/lang/Exception
    //   0	8	125	java/lang/Exception
  }
  
  private List<RecentBaseData> a(List<RecentBaseData> paramList, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      int k;
      try
      {
        int m = paramList.size();
        i = 0;
        j = -1;
        Object localObject;
        if (i < m)
        {
          localObject = (RecentBaseData)paramList.get(i);
          if (a((RecentBaseData)localObject))
          {
            localArrayList.add(localObject);
            k = j;
          }
          else
          {
            k = j;
            if (((RecentBaseData)localObject).getRecentUserType() == 6000)
            {
              k = j;
              if (TextUtils.equals(((RecentBaseData)localObject).getRecentUserUin(), AppConstants.DATALINE_PC_UIN))
              {
                localArrayList.add(localObject);
                k = i;
              }
            }
          }
        }
        else
        {
          if ((localArrayList.size() == 0) || (j == -1))
          {
            paramList = new StringBuilder();
            paramList.append("filterRecentUser resultList.size = ");
            paramList.append(localArrayList.size());
            paramList.append(", index = ");
            paramList.append(j);
            QLog.d("ScreenShotHelper", 2, paramList.toString());
            if (QFileAssistantUtils.a(paramQQAppInterface))
            {
              localObject = new RecentUser("3636666661", 0);
              paramList = paramActivity.getResources().getString(2131698288);
            }
            else
            {
              localObject = new RecentUser(AppConstants.DATALINE_PC_UIN, 6000);
              paramList = paramActivity.getResources().getString(2131693779);
            }
            paramActivity = ConversationDataFactory.a((RecentUser)localObject, paramQQAppInterface, paramActivity);
            if (paramActivity != null)
            {
              paramActivity.mTitleName = paramList;
              localArrayList.add(paramActivity);
            }
          }
          Collections.sort(localArrayList, new ConversationHelper(paramQQAppInterface));
          return localArrayList;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ScreenShotHelper", 1, "filterRecentUser error.", paramList);
        return localArrayList;
      }
      i += 1;
      int j = k;
    }
  }
  
  private static void a()
  {
    Object localObject2 = (ScreenShotConfigProcessor.ScreenShotConfigData)QConfigManager.a().a(485);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new ScreenShotConfigProcessor.ScreenShotConfigData();
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData = null, general new bean, so switch default is opened!");
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ScreenShotConfigData switch isOpened = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("ScreenShotHelper", 2, ((StringBuilder)localObject2).toString());
    }
    jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotConfigProcessor$ScreenShotConfigData = localObject1;
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFloatView() called with: activity = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.d("ScreenShotHelper", 2, localStringBuilder.toString());
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376981);
    if (paramActivity != null) {
      ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, Handler paramHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onActivityResumeHideFloatView");
    }
    View localView = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376981);
    if (localView != null)
    {
      localView.setVisibility(0);
      paramHandler.postDelayed(new ScreenShotHelper.2(new WeakReference(paramActivity), localView, paramHandler), 5000L);
    }
  }
  
  public static void a(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("disaptchTouchEventCallback() called with: activity = [");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append("], ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("]");
      QLog.d("ScreenShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376981);
    if (paramActivity != null)
    {
      localObject = new int[2];
      paramActivity.getLocationOnScreen((int[])localObject);
      if (!new RectF(localObject[0], localObject[1], localObject[0] + paramActivity.getWidth(), localObject[1] + paramActivity.getHeight()).contains(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
        ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Handler paramHandler)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView().getRootView();
    View localView = localViewGroup.findViewById(2131376981);
    int j = ViewUtils.b(79.0F);
    Object localObject1 = a(paramActivity);
    int i = (int)(((Point)localObject1).y / ((Point)localObject1).x * j);
    double d1 = i;
    double d2 = j;
    Double.isNaN(d2);
    d2 *= 2.5D;
    if (d1 > d2) {
      i = (int)d2;
    }
    localObject1 = localView;
    ImageView localImageView;
    Object localObject2;
    if (localView == null)
    {
      localObject1 = localView;
      if ((localViewGroup instanceof FrameLayout))
      {
        localObject1 = null;
        localView = View.inflate(paramActivity, 2131562767, null);
        localImageView = (ImageView)localView.findViewById(2131376984);
        localObject2 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = i;
        ((RelativeLayout.LayoutParams)localObject2).width = j;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        try
        {
          paramActivity.getResources().getDrawable(2130840405);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.getFailedDrawable();
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject2).mNeedCheckNetType = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mRetryCount = 3;
          localObject2 = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = localObject2;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
          if (i > 0) {
            i = ((BitmapFactory.Options)localObject2).outHeight / i;
          } else {
            i = 1;
          }
          if (j > 0) {
            j = ((BitmapFactory.Options)localObject2).outWidth / j;
          } else {
            j = 1;
          }
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
          int k = j;
          if (i > j) {
            k = i;
          }
          ((BitmapFactory.Options)localObject2).inSampleSize = k;
          ((BitmapFactory.Options)localObject2).inTargetDensity = 320;
          if (BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi > ((BitmapFactory.Options)localObject2).inDensity) {
            ((BitmapFactory.Options)localObject2).inDensity = 320;
          } else {
            ((BitmapFactory.Options)localObject2).inDensity = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
          }
        }
      }
    }
    try
    {
      localObject2 = new BitmapDrawable(BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2));
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      label429:
      break label429;
    }
    QLog.e("ScreenShotHelper", 1, "decode screenshot failed ", localIllegalStateException);
    localImageView.setImageDrawable((Drawable)localObject1);
    localObject1 = new FrameLayout.LayoutParams(ViewUtils.b(96.0F), -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 21;
    ((FrameLayout.LayoutParams)localObject1).rightMargin = ViewUtils.b(16.0F);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localViewGroup.addView(localView);
    localView.setId(2131376981);
    localObject1 = localView;
    if (localObject1 != null)
    {
      a((View)localObject1);
      ((View)localObject1).setTag(paramString);
      ((View)localObject1).setOnClickListener(new ScreenShotHelper.1());
      a(paramActivity, paramHandler);
      return;
    }
    QLog.e("ScreenShotHelper", 1, "screenshot float view failed ");
  }
  
  public static void a(Context paramContext, Uri paramUri, View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    SparseArray localSparseArray = new SparseArray(2);
    int j = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(paramUri, paramContext, 3, localSparseArray);
    boolean bool = QRUtils.b(j);
    String str = "";
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotHelper", 2, "ScreenShot page detect app code success");
      }
      paramContext = localSparseArray.get(2);
      if ((paramContext instanceof String))
      {
        paramUri = (String)paramContext;
        try
        {
          paramContext = new JSONObject();
          try
          {
            paramContext.put("strMini", paramUri);
          }
          catch (JSONException paramUri) {}
          paramUri.printStackTrace();
        }
        catch (JSONException paramUri)
        {
          paramContext = null;
        }
      }
      else
      {
        paramContext = null;
      }
      if (paramContext == null) {
        paramContext = "";
      } else {
        paramContext = paramContext.toString();
      }
      paramView2.setVisibility(0);
      paramView2.setTag(paramContext);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (QRUtils.a(j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotHelper", 2, "ScreenShot page detect qr code success");
      }
      paramUri = localSparseArray.get(1);
      paramContext = localObject2;
      if ((paramUri instanceof Pair))
      {
        paramContext = (Pair)paramUri;
        paramUri = String.valueOf(paramContext.second).trim();
        paramView2 = String.valueOf(paramContext.first).trim();
        try
        {
          paramContext = new JSONObject();
          try
          {
            paramContext.put("scannerType", paramUri);
            paramContext.put("scannerResult", paramView2);
          }
          catch (JSONException paramUri) {}
          paramUri.printStackTrace();
        }
        catch (JSONException paramUri)
        {
          paramContext = localObject1;
        }
      }
      if (paramContext == null) {
        paramContext = str;
      } else {
        paramContext = paramContext.toString();
      }
      if ((i == 0) || (paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShotHelper", 2, "ScreenShot page qr code entrance show success");
        }
        paramView1.setVisibility(0);
        paramView1.setTag(paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("detectType", paramInt);
    localIntent.putExtra("fromPicQRDecode", true);
    RouteUtils.a(paramContext, localIntent, "/qrscan/scanner");
  }
  
  public static void a(Context paramContext, String paramString, Handler paramHandler)
  {
    try
    {
      if ((paramContext instanceof Activity))
      {
        if ((Build.VERSION.SDK_INT >= 24) && (((Activity)paramContext).isInMultiWindowMode()))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ScreenShotHelper", 2, "start float view is error and errMsg : isInMultiWindowMode");
          return;
        }
        a((Activity)paramContext, paramString, paramHandler);
        paramString = IScreenShotShareHandler.a;
        if (paramString != null)
        {
          if ((paramContext instanceof AppActivity))
          {
            AppActivity.setActivityDispatchCallback(paramString);
            return;
          }
          PluginProxyActivity.setActivityDispatchCallback(paramString);
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotHelper", 2, paramContext, new Object[0]);
    }
    return;
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext instanceof Activity))
    {
      localObject = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView().getRootView()).findViewById(2131376981);
      if (localObject != null) {
        ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).putExtra("screen_path", paramString);
    int j = 0;
    int i = j;
    if ((paramContext instanceof BaseActivity))
    {
      paramString = (BaseActivity)paramContext;
      QQAppInterface localQQAppInterface = paramString.app;
      i = j;
      if (localQQAppInterface != null)
      {
        i = j;
        if (localQQAppInterface.getMessageFacade() != null)
        {
          i = j;
          if (localQQAppInterface.getMessageFacade().a())
          {
            i = j;
            if (localQQAppInterface.getMessageFacade().a() != null)
            {
              i = j;
              if (localQQAppInterface.getMessageFacade().a().size() > 0)
              {
                ((Intent)localObject).putExtra("is_aio_page_with_msg", true);
                PublicFragmentActivity.Launcher.a(paramString, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 9011);
                i = 1;
              }
            }
          }
        }
      }
    }
    if ((paramContext instanceof QQBrowserActivity))
    {
      paramString = (QQBrowserActivity)paramContext;
      if (a(paramString))
      {
        ((Intent)localObject).putExtra("is_screen_shot_from_web", true);
        PublicFragmentActivity.Launcher.a(paramString, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 11);
        return;
      }
    }
    ((Intent)localObject).putExtra("switch_bottom_layout", paramBoolean);
    if (i == 0) {
      PublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class);
    }
  }
  
  public static void a(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(300L);
    paramView.start();
  }
  
  public static void a(ScreenShotConfigProcessor.ScreenShotConfigData paramScreenShotConfigData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfUpdate : ");
      localStringBuilder.append(paramScreenShotConfigData);
      QLog.d("ScreenShotHelper", 2, localStringBuilder.toString());
    }
    if (paramScreenShotConfigData != null) {
      jdField_a_of_type_Boolean = paramScreenShotConfigData.a();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  public static boolean a()
  {
    if (b) {
      return jdField_a_of_type_Boolean;
    }
    b = true;
    a();
    jdField_a_of_type_Boolean = jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotConfigProcessor$ScreenShotConfigData.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ScreenShotConfigData isSwitchOpened = ");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("ScreenShotHelper", 2, localStringBuilder.toString());
    }
    return jdField_a_of_type_Boolean;
  }
  
  private static boolean a(QQBrowserActivity paramQQBrowserActivity)
  {
    if (paramQQBrowserActivity == null)
    {
      QLog.e("ScreenShotHelper", 1, "isCurrentPageIsWebFragment activity is null");
      return false;
    }
    return paramQQBrowserActivity.getSupportFragmentManager().findFragmentById(2131365183) instanceof WebViewFragment;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData)
  {
    return jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramRecentBaseData.getRecentUserType()));
  }
  
  public static void b(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideFloatView() called with: activity = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.d("ScreenShotHelper", 2, localStringBuilder.toString());
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131376981);
    if (paramActivity != null) {
      paramActivity.setVisibility(8);
    }
  }
  
  public List<RecentBaseData> a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramQQAppInterface.getProxyManager().a().a(false).size() > 0) {
        localArrayList.addAll(RecentDataListManager.a().jdField_a_of_type_JavaUtilList);
      }
    }
    catch (Exception localException)
    {
      QLog.e("ScreenShotHelper", 1, "getRecentUser error.", localException);
    }
    return a(localArrayList, paramActivity, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotHelper
 * JD-Core Version:    0.7.0.1
 */