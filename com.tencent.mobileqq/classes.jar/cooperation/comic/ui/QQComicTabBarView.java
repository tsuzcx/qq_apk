package cooperation.comic.ui;

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
import bbdh;
import bbqz;
import bcsc;
import bghi;
import bghx;
import bgig;
import bgih;
import bgir;
import bgis;
import bgit;
import bgiu;
import bgiv;
import bgja;
import bgje;
import bgjg;
import bgji;
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
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class QQComicTabBarView
  extends LinearLayout
{
  static final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  static final Map<String, String> jdField_b_of_type_JavaUtilMap;
  static final Map<String, String> jdField_c_of_type_JavaUtilMap;
  final float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int;
  public long a;
  public final Paint a;
  public Handler a;
  public SparseArray<RedAppInfo> a;
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public bcsc a;
  bgig jdField_a_of_type_Bgig = new bgit(this);
  bgje jdField_a_of_type_Bgje = null;
  bgjg jdField_a_of_type_Bgjg = new bgis(this);
  public final bgji<String, RedTouchUI> a;
  public AppInterface a;
  public List<WebViewTabBarData> a;
  boolean jdField_a_of_type_Boolean = true;
  public float b;
  final int jdField_b_of_type_Int;
  public final Paint b;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  final bgji<String, String> jdField_b_of_type_Bgji = new bgji();
  boolean jdField_b_of_type_Boolean = true;
  final int jdField_c_of_type_Int;
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
    jdField_a_of_type_JavaUtilMap.put("index", "1113.100800");
    jdField_a_of_type_JavaUtilMap.put("fav", "1113.100801");
    jdField_a_of_type_JavaUtilMap.put("category", "1113.100804");
    jdField_a_of_type_JavaUtilMap.put("more", "1113.100802");
    jdField_a_of_type_JavaUtilMap.put("group", "1113.100803");
    jdField_b_of_type_JavaUtilMap = new HashMap(5);
    jdField_c_of_type_JavaUtilMap = new HashMap(5);
    jdField_b_of_type_JavaUtilMap.put("index", "200458");
    jdField_b_of_type_JavaUtilMap.put("fav", "200459");
    jdField_b_of_type_JavaUtilMap.put("category", "200460");
    jdField_b_of_type_JavaUtilMap.put("more", "200461");
    jdField_b_of_type_JavaUtilMap.put("group", "200462");
    jdField_c_of_type_JavaUtilMap.put("index", "100");
    jdField_c_of_type_JavaUtilMap.put("fav", "102");
    jdField_c_of_type_JavaUtilMap.put("category", "101");
    jdField_c_of_type_JavaUtilMap.put("more", "103");
    jdField_c_of_type_JavaUtilMap.put("group", "104");
  }
  
  public QQComicTabBarView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bgji = new bgji();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new bgir(this, Looper.getMainLooper());
    paramContext = super.getContext().getResources();
    this.jdField_b_of_type_Int = -8947849;
    this.jdField_a_of_type_Int = -14629889;
    this.jdField_a_of_type_Float = TypedValue.applyDimension(2, 17.0F, paramContext.getDisplayMetrics());
    this.jdField_c_of_type_Int = -14629889;
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
    ThreadManager.post(new QQComicTabBarView.4(this), 5, null, false);
    setLayerType(2, null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramAppInterface != null)
    {
      str = (String)jdField_b_of_type_JavaUtilMap.get(paramString);
      if (!TextUtils.isEmpty(str)) {
        if (!paramBoolean) {
          break label67;
        }
      }
    }
    label67:
    for (paramString = "1";; paramString = "")
    {
      bghx.a(paramAppInterface, "3071", "2", str, "", "", "", "", "", "", paramString, new String[0]);
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
  
  public View a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt < 0) || (paramInt > super.getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(super.getContext());
    SimpleTextView localSimpleTextView = new SimpleTextView(super.getContext());
    localSimpleTextView.setText(paramString2);
    localSimpleTextView.setTextSize(0, this.jdField_a_of_type_Float);
    localSimpleTextView.setTextColor(this.jdField_b_of_type_Int);
    localSimpleTextView.setContentDescription(paramString2);
    localSimpleTextView.setGravity(17);
    bgiv localbgiv = new bgiv(this);
    localbgiv.jdField_a_of_type_ComTencentWidgetSimpleTextView = localSimpleTextView;
    localRelativeLayout.setTag(-3, localbgiv);
    boolean bool1;
    if (!this.jdField_a_of_type_Boolean) {
      bool1 = true;
    }
    for (;;)
    {
      localRelativeLayout.setOnClickListener(new bgiu(this, paramInt, bool1, this.jdField_a_of_type_JavaUtilList));
      localRelativeLayout.addView(localSimpleTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ImageView localImageView;
      File localFile;
      ColorDrawable localColorDrawable;
      boolean bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        localImageView = new ImageView(super.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localFile = new File(paramString3);
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
          paramString3 = bbqz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString3, "-comic-tab-bar-", localColorDrawable, new int[] { 12 }, "-comic-tab-bar-", localBundle);
          if (paramString3 != null)
          {
            if (ApngImage.canDecodeIDs.contains(Integer.valueOf(12))) {
              break label555;
            }
            ApngImage.canDecodeIDs.add(Integer.valueOf(12));
            localbgiv.jdField_a_of_type_ComTencentImageURLDrawable = paramString3;
            if (!bool1)
            {
              paramString3 = URLDrawable.URLDrawableOptions.obtain();
              paramString3.mLoadingDrawable = localColorDrawable;
              paramString3.mFailedDrawable = localColorDrawable;
              localbgiv.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localFile, paramString3);
            }
            localbgiv.jdField_a_of_type_AndroidWidgetImageView = localImageView;
            localRelativeLayout.addView(localImageView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
            localImageView.setVisibility(8);
            super.addView(localRelativeLayout, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
            if (jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
            {
              paramString1 = (String)jdField_a_of_type_JavaUtilMap.get(paramString1);
              paramString3 = (RedTouchUI)new RedTouchUI(super.getContext(), localSimpleTextView).a(5).a();
              paramString3.setRedpointImgResID(2130849297);
              paramString3.setTextOrNumImgRedID(2130849301);
              this.jdField_b_of_type_Bgji.put(paramString1, a(paramString1, 0));
              this.jdField_a_of_type_Bgji.put(paramString1, paramString3);
              localbgiv.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI = paramString3;
            }
            if (AppSetting.d) {
              localRelativeLayout.setContentDescription(paramString2);
            }
            return localSimpleTextView;
            bool1 = false;
          }
        }
      }
      catch (IOException localIOException)
      {
        label555:
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
    StringBuilder localStringBuilder = bghx.a();
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
    ThreadManager.postImmediately(new QQComicTabBarView.7(this), null, false);
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
        if ((localObject1 instanceof bgiv))
        {
          RedTouchUI localRedTouchUI = ((bgiv)localObject1).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
          if ((localRedTouchUI != null) && (!localRedTouchUI.a()))
          {
            localObject1 = (RedAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
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
      if ((localObject instanceof bgiv)) {
        ((bgiv)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_b_of_type_Int);
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof bgiv)) {
        ((bgiv)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
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
        } while (!(localObject instanceof bgiv));
        localObject = ((bgiv)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
      } while (localObject == null);
      ((RedTouchUI)localObject).b();
    } while ((!paramBoolean) || (bgja.a == null));
    bgja.a.a();
  }
  
  public void a(Intent paramIntent, List<WebViewTabBarData> paramList, bcsc parambcsc)
  {
    this.jdField_a_of_type_Bcsc = parambcsc;
    int k;
    if (paramIntent != null)
    {
      k = paramIntent.getIntExtra("key_maintab", -1);
      paramIntent.removeExtra("key_maintab");
    }
    for (;;)
    {
      if ((!bbdh.e()) && (bghi.a("navSwitchAnimation", 1) == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_b_of_type_Boolean = bool;
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (paramList == null) {
          break label159;
        }
        paramIntent = paramList.iterator();
        while (paramIntent.hasNext()) {
          if (TextUtils.isEmpty(((WebViewTabBarData)paramIntent.next()).tabIcon)) {
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      paramIntent = paramList.iterator();
      while (paramIntent.hasNext())
      {
        paramList = (WebViewTabBarData)paramIntent.next();
        a(super.getChildCount(), paramList.tag, paramList.tabName, paramList.tabIcon);
      }
      label159:
      super.setVisibility(0);
      a();
      if (k != -1)
      {
        this.g = k;
        b(this.j, this.g);
        this.i = this.g;
        this.j = this.i;
      }
      return;
      k = -1;
    }
  }
  
  void a(RedTouchUI paramRedTouchUI, RedAppInfo paramRedAppInfo, boolean paramBoolean)
  {
    if ((paramRedTouchUI == null) || (paramRedAppInfo == null) || (paramRedAppInfo.a() == null) || (paramRedAppInfo.a().a() == null)) {}
    while ((paramBoolean) && (paramRedTouchUI.a != null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    Iterator localIterator = paramRedAppInfo.a().a().iterator();
    RedTypeInfo localRedTypeInfo;
    while (localIterator.hasNext())
    {
      localRedTypeInfo = (RedTypeInfo)localIterator.next();
      if (localRedTypeInfo.getRed_type() != 9)
      {
        if ((localRedTypeInfo.getRed_type() == 3) || (localRedTypeInfo.getRed_type() == 4)) {
          localRedTypeInfo.setRed_type(0);
        }
        if (localRedTypeInfo.getRed_type() != 0) {
          break label162;
        }
        paramRedTouchUI.a(0, 13, 12, 0).a();
      }
    }
    for (;;)
    {
      localArrayList.add(localRedTypeInfo);
      paramRedAppInfo.a().a(localArrayList);
      paramRedTouchUI.a(paramRedAppInfo);
      return;
      label162:
      paramRedTouchUI.a(0, 8, 7, 0).a();
    }
  }
  
  void b()
  {
    Iterator localIterator = this.jdField_a_of_type_Bgji.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (RedTouchUI)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null) && (((RedTouchUI)localObject).a()) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
          if ("1113.100800".equals(str)) {
            bghx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "100" });
          } else if ("1113.100801".equals(str)) {
            bghx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "102" });
          } else if ("1113.100802".equals(str)) {
            bghx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "103" });
          } else if ("1113.100803".equals(str)) {
            bghx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "104" });
          } else if ("1113.100804".equals(str)) {
            bghx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "101" });
          }
        }
      }
    }
  }
  
  void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= super.getChildCount())) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = super.getChildAt(paramInt).getTag(-3);
        } while (!(localObject1 instanceof bgiv));
        localObject1 = ((bgiv)localObject1).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchUI;
      } while ((localObject1 == null) || (!((RedTouchUI)localObject1).a()));
      ((RedTouchUI)localObject1).b();
      localObject2 = (String)this.jdField_a_of_type_Bgji.a(localObject1);
      if (this.jdField_a_of_type_Bgje != null)
      {
        this.jdField_a_of_type_Bgje.a((String)localObject2);
        this.jdField_a_of_type_Bgje.a((String)this.jdField_b_of_type_Bgji.get(localObject2));
      }
      localObject2 = (RedAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    } while (((localObject2 != null) && (((RedTouchUI)localObject1).a == localObject2)) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null));
    Object localObject1 = (WebViewTabBarData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bghx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { (String)jdField_c_of_type_JavaUtilMap.get(((WebViewTabBarData)localObject1).tag) });
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
      if ((localObject instanceof bgiv))
      {
        localObject = (bgiv)localObject;
        ((bgiv)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(0);
        ((bgiv)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "tab icon hide.");
        }
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof bgiv))
      {
        localObject = (bgiv)localObject;
        if ((((bgiv)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (((bgiv)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView != null))
        {
          ((bgiv)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(8);
          URLDrawable localURLDrawable = ((bgiv)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
          ((bgiv)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((bgiv)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
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
    ThreadManager.getSubThreadHandler().post(new QQComicTabBarView.5(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ThreadManager.getSubThreadHandler().post(new QQComicTabBarView.6(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    super.setMeasuredDimension(super.getMeasuredWidth(), this.f);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
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
      if (this.jdField_a_of_type_Bcsc != null) {
        this.jdField_a_of_type_Bcsc.onTabSelected(this.i, paramInt);
      }
      if (this.jdField_a_of_type_Boolean) {
        b(this.j, paramInt);
      }
      if (!paramBoolean) {
        break label164;
      }
      this.h = paramInt;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    for (;;)
    {
      this.j = this.h;
      WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localWebViewTabBarData.tag, false);
      b(paramInt);
      paramBoolean = bool;
      if (paramInt == VipComicJumpActivity.a("fav", this.jdField_a_of_type_JavaUtilList)) {
        paramBoolean = true;
      }
      a(paramInt, paramBoolean);
      return;
      label164:
      this.h = paramInt;
      this.jdField_b_of_type_Float = 1.0F;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView
 * JD-Core Version:    0.7.0.1
 */