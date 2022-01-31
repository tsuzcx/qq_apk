package cooperation.comic.ui;

import altw;
import altx;
import alty;
import altz;
import alub;
import aluc;
import alud;
import aluf;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import cooperation.comic.VipComicConfigHelper;
import cooperation.comic.VipComicReportUtils;
import cooperation.comic.jsp.QQComicDownloadCountObserver;
import cooperation.comic.jsp.QQComicDownloadObserverProxy;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicRedTouchManager;
import cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver;
import cooperation.comic.utils.SimpleBiMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class QQComicTabBarView
  extends LinearLayout
{
  static final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "1113.100800", "1113.100801", "1113.100804", "1113.100802", "1113.100803" };
  final float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int;
  public long a;
  public final Paint a;
  public Handler a;
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public AppInterface a;
  public TabBarView.OnTabChangeListener a;
  public QQComicDownloadCountObserver a;
  public QQComicRedTouchManager.PluginRedTouchObserver a;
  public QQComicRedTouchManager a;
  public final SimpleBiMap a;
  boolean jdField_a_of_type_Boolean = true;
  public float b;
  final int jdField_b_of_type_Int;
  public final Paint b;
  public SparseArray b;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public final SimpleBiMap b;
  boolean jdField_b_of_type_Boolean = true;
  final int c;
  public final Paint c;
  final int d;
  final int e;
  final int f;
  int g = 0;
  public int h = -1;
  public int i = -1;
  int j = -1;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
    jdField_a_of_type_AndroidUtilSparseArray.put(0, "200458");
    jdField_a_of_type_AndroidUtilSparseArray.put(1, "200459");
    jdField_a_of_type_AndroidUtilSparseArray.put(2, "200460");
    jdField_a_of_type_AndroidUtilSparseArray.put(3, "200461");
    jdField_a_of_type_AndroidUtilSparseArray.put(4, "200462");
  }
  
  public QQComicTabBarView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_CooperationComicUtilsSimpleBiMap = new SimpleBiMap();
    this.jdField_b_of_type_CooperationComicUtilsSimpleBiMap = new SimpleBiMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new altw(this, Looper.getMainLooper());
    this.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager = null;
    this.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager$PluginRedTouchObserver = new altx(this);
    this.jdField_a_of_type_CooperationComicJspQQComicDownloadCountObserver = new alty(this);
    paramContext = super.getContext().getResources();
    this.jdField_b_of_type_Int = -8947849;
    this.jdField_a_of_type_Int = -19456;
    this.jdField_a_of_type_Float = TypedValue.applyDimension(2, 17.0F, paramContext.getDisplayMetrics());
    this.jdField_c_of_type_Int = -19456;
    this.d = ((int)TypedValue.applyDimension(1, 6.0F, paramContext.getDisplayMetrics()));
    this.e = -8947849;
    this.f = ((int)TypedValue.applyDimension(1, 54.0F, paramContext.getDisplayMetrics()));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.f, this.f);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(13);
    ThreadManager.post(new altz(this), 5, null, false);
    setLayerType(2, null);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    String str2;
    if (paramAppInterface != null)
    {
      str2 = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (!TextUtils.isEmpty(str2)) {
        if (!paramBoolean) {
          break label59;
        }
      }
    }
    label59:
    for (String str1 = "1";; str1 = "")
    {
      VipComicReportUtils.a(paramAppInterface, "3071", "2", str2, "", "", "", "", "", "", str1, new String[0]);
      return;
    }
  }
  
  float a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramFloat < 0.6F) {
        paramFloat = 0.0F;
      }
    }
    for (;;)
    {
      float f1 = paramFloat;
      if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {
        f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(paramFloat);
      }
      return f1;
      paramFloat = (paramFloat - 0.6F) / 0.4F;
      continue;
      if (paramFloat < 0.6F) {
        paramFloat /= 0.6F;
      } else {
        paramFloat = 1.0F;
      }
    }
  }
  
  public int a()
  {
    return this.i;
  }
  
  public View a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) || (paramInt > super.getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(super.getContext());
    SimpleTextView localSimpleTextView = new SimpleTextView(super.getContext());
    localSimpleTextView.setText(paramString1);
    localSimpleTextView.setTextSize(0, this.jdField_a_of_type_Float);
    localSimpleTextView.setTextColor(this.jdField_b_of_type_Int);
    localSimpleTextView.setContentDescription(paramString1);
    localSimpleTextView.setGravity(17);
    QQComicTabBarView.ViewHolder localViewHolder = new QQComicTabBarView.ViewHolder(this);
    localViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView = localSimpleTextView;
    localRelativeLayout.setTag(-3, localViewHolder);
    boolean bool1;
    if (!this.jdField_a_of_type_Boolean) {
      bool1 = true;
    }
    for (;;)
    {
      localRelativeLayout.setOnClickListener(new aluf(this, paramInt, bool1));
      localRelativeLayout.addView(localSimpleTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      Object localObject;
      File localFile;
      ColorDrawable localColorDrawable;
      boolean bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new ImageView(super.getContext());
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localFile = new File(paramString2);
        localColorDrawable = new ColorDrawable(getResources().getColor(17170445));
        bool2 = this.jdField_b_of_type_Boolean;
        bool1 = bool2;
        if (!bool2) {}
      }
      try
      {
        bool1 = ApngDrawable.isApngFile(localFile);
        if (bool1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putFloat("key_frame_delay_fraction", 0.6F);
          paramString2 = VasApngUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString2, "-comic-tab-bar-", localColorDrawable, new int[] { 12 }, "-comic-tab-bar-", localBundle);
          if (paramString2 != null)
          {
            if (ApngImage.canDecodeIDs.contains(Integer.valueOf(12))) {
              break label535;
            }
            ApngImage.canDecodeIDs.add(Integer.valueOf(12));
            localViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramString2;
            if (!bool1)
            {
              paramString2 = URLDrawable.URLDrawableOptions.obtain();
              paramString2.mLoadingDrawable = localColorDrawable;
              paramString2.mFailedDrawable = localColorDrawable;
              localViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localFile, paramString2);
            }
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
            localRelativeLayout.addView((View)localObject, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
            ((ImageView)localObject).setVisibility(8);
            super.addView(localRelativeLayout, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
            if ((paramInt >= 0) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
            {
              paramString2 = jdField_a_of_type_ArrayOfJavaLangString[paramInt];
              localObject = (RedTouchUI)new RedTouchUI(super.getContext(), localSimpleTextView).a(5).a();
              ((RedTouchUI)localObject).setRedpointImgResID(2130845923);
              ((RedTouchUI)localObject).setTextOrNumImgRedID(2130845927);
              this.jdField_b_of_type_CooperationComicUtilsSimpleBiMap.put(paramString2, a(paramString2, 0));
              this.jdField_a_of_type_CooperationComicUtilsSimpleBiMap.put(paramString2, localObject);
              localViewHolder.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI = ((RedTouchUI)localObject);
            }
            if (AppSetting.jdField_b_of_type_Boolean) {
              localRelativeLayout.setContentDescription(paramString1);
            }
            return localSimpleTextView;
            bool1 = false;
          }
        }
      }
      catch (IOException localIOException)
      {
        label535:
        for (;;)
        {
          QLog.e("WebViewTabBarView", 1, localIOException, new Object[0]);
          bool1 = bool2;
          continue;
          bool1 = false;
          continue;
        }
      }
    }
  }
  
  public String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = VipComicReportUtils.a();
    int k;
    if (paramInt == 0)
    {
      k = 100000000;
      localStringBuilder.append(100600);
      localStringBuilder.append('.');
    }
    while (paramString.contains("."))
    {
      paramString = paramString.split("\\.");
      if (paramString.length <= 0) {
        break label235;
      }
      int i1 = paramString.length;
      int m = 0;
      int n = 0;
      for (;;)
      {
        if (m >= i1) {
          break label142;
        }
        String str = paramString[m];
        try
        {
          localStringBuilder.append(Integer.parseInt(str) + k);
          localStringBuilder.append('.');
          n += 1;
          m += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
      if (paramInt == 1)
      {
        k = -100000000;
      }
      else
      {
        return null;
        label142:
        if (n != paramString.length) {
          break label235;
        }
        k = 1;
      }
    }
    while (k != 0)
    {
      if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == '.')) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      if (paramInt == 1)
      {
        paramInt = localStringBuilder.indexOf(".");
        if (paramInt < 0)
        {
          return null;
          try
          {
            localStringBuilder.append(k + Integer.parseInt(paramString));
            k = 1;
          }
          catch (NumberFormatException paramString)
          {
            paramString.printStackTrace();
          }
          label235:
          k = 0;
        }
        else
        {
          return localStringBuilder.substring(paramInt + 1);
        }
      }
      else
      {
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.postImmediately(new alud(this), null, false);
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        int k = super.getChildCount();
        if (paramInt >= k) {
          return;
        }
        Object localObject1 = super.getChildAt(paramInt).getTag(-3);
        if ((localObject1 instanceof QQComicTabBarView.ViewHolder))
        {
          RedTouchUI localRedTouchUI = ((QQComicTabBarView.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
          if ((localRedTouchUI != null) && (!localRedTouchUI.a()))
          {
            localObject1 = (RedAppInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
            if (localObject1 == null)
            {
              localObject1 = new RedAppInfo();
              ((RedAppInfo)localObject1).a(1113);
              ((RedAppInfo)localObject1).b(1);
              ((RedAppInfo)localObject1).c(0);
              RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
              RedTypeInfo localRedTypeInfo = new RedTypeInfo();
              localRedTypeInfo.setRed_type(0);
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localRedTypeInfo);
              localRedDisplayInfo.a(localArrayList);
              ((RedAppInfo)localObject1).a(localRedDisplayInfo);
              this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
              a(localRedTouchUI, (RedAppInfo)localObject1, true);
            }
            else
            {
              localObject2.b(1);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = super.getChildAt(paramInt1);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder)) {
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_b_of_type_Int);
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder)) {
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(Intent paramIntent, List paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
    if (paramIntent != null)
    {
      this.g = paramIntent.getIntExtra("key_maintab", 0);
      paramIntent.removeExtra("key_maintab");
    }
    if ((!DeviceInfoUtil.e()) && (VipComicConfigHelper.a("navSwitchAnimation", 1) == 1)) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (paramList == null) {
        break label152;
      }
      paramIntent = paramList.iterator();
      while (paramIntent.hasNext()) {
        if (TextUtils.isEmpty(((WebViewTabBarData)paramIntent.next()).tabIcon)) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      bool = false;
    }
    paramIntent = paramList.iterator();
    while (paramIntent.hasNext())
    {
      paramList = (WebViewTabBarData)paramIntent.next();
      a(super.getChildCount(), paramList.tabName, paramList.tabIcon);
    }
    label152:
    setSelectedTab(this.g, false);
    super.setVisibility(0);
    a();
  }
  
  public void a(RedTouchUI paramRedTouchUI, RedAppInfo paramRedAppInfo, boolean paramBoolean)
  {
    if ((paramRedTouchUI == null) || (paramRedAppInfo == null) || (paramRedAppInfo.a() == null) || (paramRedAppInfo.a().a() == null)) {}
    while ((paramBoolean) && (paramRedTouchUI.a != null)) {
      return;
    }
    Iterator localIterator = paramRedAppInfo.a().a().iterator();
    while (localIterator.hasNext())
    {
      RedTypeInfo localRedTypeInfo = (RedTypeInfo)localIterator.next();
      if (localRedTypeInfo.getRed_type() != 9)
      {
        if ((localRedTypeInfo.getRed_type() == 3) || (localRedTypeInfo.getRed_type() == 4)) {
          localRedTypeInfo.setRed_type(0);
        }
        if (localRedTypeInfo.getRed_type() != 0) {
          break label135;
        }
        paramRedTouchUI.a(0, 13, 12, 0).a();
      }
    }
    for (;;)
    {
      paramRedTouchUI.a(paramRedAppInfo);
      return;
      label135:
      paramRedTouchUI.a(0, 8, 7, 0).a();
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_CooperationComicUtilsSimpleBiMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (RedTouchUI)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null) && (((RedTouchUI)localObject).a()) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
          if ("1113.100800".equals(str)) {
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "100" });
          } else if ("1113.100801".equals(str)) {
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "102" });
          } else if ("1113.100802".equals(str)) {
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "103" });
          } else if ("1113.100803".equals(str)) {
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "104" });
          } else if ("1113.100804".equals(str)) {
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "101" });
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= super.getChildCount())) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = super.getChildAt(paramInt).getTag(-3);
        } while (!(localObject instanceof QQComicTabBarView.ViewHolder));
        localObject = ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
      } while (localObject == null);
      ((RedTouchUI)localObject).b();
    } while ((paramInt != 1) || (QQComicPluginBridge.a == null));
    QQComicPluginBridge.a.a();
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "tab switch : old=" + paramInt1 + ", new=" + paramInt2);
    }
    Object localObject = super.getChildAt(paramInt1);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder))
      {
        localObject = (QQComicTabBarView.ViewHolder)localObject;
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(0);
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "tab icon hide.");
        }
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder))
      {
        localObject = (QQComicTabBarView.ViewHolder)localObject;
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(8);
        URLDrawable localURLDrawable = ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        if ((localURLDrawable != null) && ((localURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
        {
          ((ApngDrawable)localURLDrawable.getCurrDrawable()).repaly();
          if (QLog.isColorLevel()) {
            QLog.d("WebViewTabBarView", 2, "tab icon anim play.");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "tab icon show.");
        }
      }
    }
  }
  
  void c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= super.getChildCount())) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = super.getChildAt(paramInt).getTag(-3);
        } while (!(localObject1 instanceof QQComicTabBarView.ViewHolder));
        localObject1 = ((QQComicTabBarView.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
      } while ((localObject1 == null) || (!((RedTouchUI)localObject1).a()));
      ((RedTouchUI)localObject1).b();
      localObject2 = (String)this.jdField_a_of_type_CooperationComicUtilsSimpleBiMap.a(localObject1);
      if (this.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager != null)
      {
        this.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager.a((String)localObject2);
        this.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager.a((String)this.jdField_b_of_type_CooperationComicUtilsSimpleBiMap.get(localObject2));
      }
      localObject2 = (RedAppInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    } while (((localObject2 != null) && (((RedTouchUI)localObject1).a == localObject2)) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { "100" });
      return;
    case 1: 
      VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { "102" });
      return;
    case 2: 
      VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { "101" });
      return;
    case 3: 
      VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { "103" });
      return;
    }
    VipComicReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { "104" });
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool2 = true;
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {}
    View localView1;
    View localView2;
    do
    {
      return;
      localView1 = super.getChildAt(this.i);
      localView2 = super.getChildAt(this.h);
    } while ((localView1 == null) || (localView2 == null));
    int m = localView1.getLeft();
    int k = localView1.getRight();
    boolean bool1;
    float f1;
    if (this.jdField_b_of_type_Float > 0.0F) {
      if (this.i < this.h)
      {
        bool1 = true;
        m = (int)(localView1.getLeft() + a(this.jdField_b_of_type_Float, bool1) * (localView2.getLeft() - localView1.getLeft()));
        f1 = localView1.getRight();
        float f2 = this.jdField_b_of_type_Float;
        if (bool1) {
          break label285;
        }
        bool1 = bool2;
        label137:
        k = (int)(a(f2, bool1) * (localView2.getRight() - localView1.getRight()) + f1);
      }
    }
    for (;;)
    {
      paramCanvas.drawRect(m, super.getHeight() - this.d, k, super.getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
      k = (localView2.getLeft() + localView2.getRight()) / 2;
      m = (localView2.getTop() + localView2.getBottom()) / 2;
      f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha((int)(96.0F * (1.0F - this.jdField_b_of_type_Float)));
      paramCanvas.drawCircle(k, m, f1 * 1.2F * this.jdField_b_of_type_Float, this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
      bool1 = false;
      break;
      label285:
      bool1 = false;
      break label137;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ThreadManager.getSubThreadHandler().post(new alub(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ThreadManager.getSubThreadHandler().post(new aluc(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    super.setMeasuredDimension(super.getMeasuredWidth(), this.f);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    int m = super.getChildCount();
    paramInt = k;
    if (k >= m) {
      paramInt = m - 1;
    }
    if (this.i != paramInt)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener.onTabSelected(this.i, paramInt);
      }
      if (this.jdField_a_of_type_Boolean) {
        b(this.j, paramInt);
      }
      if (!paramBoolean) {
        break label123;
      }
      this.h = paramInt;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    for (;;)
    {
      this.j = this.h;
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt, false);
      c(paramInt);
      b(paramInt);
      return;
      label123:
      this.h = paramInt;
      this.jdField_b_of_type_Float = 1.0F;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView
 * JD-Core Version:    0.7.0.1
 */