package com.tencent.mobileqq.tianshu.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchTempApi;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouch
  extends FrameLayout
{
  protected static int e = 1;
  protected int a;
  protected Context a;
  protected Handler a;
  protected View a;
  public ImageView a;
  protected LinearLayout a;
  public TextView a;
  protected BusinessInfoCheckUpdate.RedTypeInfo a;
  public String a;
  protected List<BusinessInfoCheckUpdate.RedTypeInfo> a;
  protected boolean a;
  protected int b;
  public ImageView b;
  public TextView b;
  protected boolean b;
  protected int c;
  public ImageView c;
  public TextView c;
  protected boolean c;
  protected int d;
  public TextView d;
  protected boolean d;
  public TextView e;
  protected boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  public boolean g;
  protected int h;
  public boolean h;
  protected int i;
  boolean i;
  protected int j = 0;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected int v = -2;
  protected int w = 30;
  private int x;
  
  public RedTouch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouch(Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 21;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    f();
  }
  
  private static int a(String paramString1, String paramString2)
  {
    try
    {
      int i1 = new JSONObject(paramString1).optInt(paramString2, 0);
      return i1;
    }
    catch (JSONException paramString1)
    {
      QLog.d("RedTouch", 1, new Object[] { "getIntJSONObj error : ", paramString1.getMessage() });
    }
    return 0;
  }
  
  private FrameLayout.LayoutParams a()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.k;
    localLayoutParams.leftMargin = this.l;
    localLayoutParams.rightMargin = this.m;
    localLayoutParams.topMargin = this.n;
    localLayoutParams.bottomMargin = this.o;
    return localLayoutParams;
  }
  
  private FrameLayout a(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(a(30), a(30));
    localLayoutParams.gravity = 80;
    localLayoutParams.topMargin = a(16);
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramImageView.setImageResource(2130850766);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
    return localFrameLayout;
  }
  
  public static AnimIconRedDot a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return null;
    }
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return null;
      }
      if ((paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
      {
        AnimIconRedDot localAnimIconRedDot = new AnimIconRedDot(null, 0, null);
        Iterator localIterator = paramAppInfo.red_display_info.red_type_info.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next();
          if (localObject != null)
          {
            int i1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get();
            if (i1 == 17)
            {
              paramAppInfo = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get();
              localObject = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get();
              i1 = a((String)localObject, "time");
              boolean bool;
              if (a((String)localObject, "dot") == 1) {
                bool = true;
              } else {
                bool = false;
              }
              localAnimIconRedDot.a(bool);
              localAnimIconRedDot.a(paramAppInfo);
              localAnimIconRedDot.a(i1);
              QLog.d("RedTouch", 1, new Object[] { "red_content : ", paramAppInfo, " redDesc : ", localObject });
            }
            else if (i1 == 16)
            {
              paramAppInfo = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get();
              if ((paramAppInfo != null) && (paramAppInfo.contains("\\n")))
              {
                i1 = paramAppInfo.indexOf("\\n");
                localObject = paramAppInfo.substring(i1 + 2).replace("\\n", " ");
                paramAppInfo = paramAppInfo.substring(0, i1);
              }
              else
              {
                localObject = "";
              }
              localAnimIconRedDot.b(paramAppInfo);
              localAnimIconRedDot.c((String)localObject);
              QLog.d("RedTouch", 1, new Object[] { "red_content : ", paramAppInfo });
            }
          }
        }
        if ((localAnimIconRedDot.a() != null) || (localAnimIconRedDot.b() != null)) {
          return localAnimIconRedDot;
        }
      }
    }
    return null;
  }
  
  public static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "";
    }
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return "";
      }
      if ((paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
      {
        paramAppInfo = paramAppInfo.red_display_info.red_type_info.get().iterator();
        while (paramAppInfo.hasNext())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
          if ((localRedTypeInfo != null) && ((localRedTypeInfo.red_type.get() == 4) || (localRedTypeInfo.red_type.get() == -100))) {
            return localRedTypeInfo.red_content.get();
          }
        }
      }
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    ((IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class)).onProcessAddRedPoint(this.jdField_a_of_type_AndroidViewView);
    ImageView localImageView = a(paramInt);
    if (localImageView != null)
    {
      if (this.x == 10)
      {
        View localView = b();
        if (localView != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        }
      }
      paramInt = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (paramInt + 1);
      localImageView.setId(paramInt);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup == null) {
      return;
    }
    if ((localViewGroup instanceof RelativeLayout))
    {
      i1 = jdField_e_of_type_Int;
      jdField_e_of_type_Int = i1 + 1;
      setId(i1);
      int i3 = paramView.getId();
      RelativeLayout localRelativeLayout = (RelativeLayout)localViewGroup;
      i1 = 0;
      while (i1 < localRelativeLayout.getChildCount())
      {
        View localView = localRelativeLayout.getChildAt(i1);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        int[] arrayOfInt = localLayoutParams.getRules();
        int i2 = 0;
        while (i2 < arrayOfInt.length)
        {
          if (arrayOfInt[i2] == i3) {
            arrayOfInt[i2] = getId();
          }
          i2 += 1;
        }
        localView.setLayoutParams(localLayoutParams);
        i1 += 1;
      }
    }
    int i1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    setLayoutParams(paramView.getLayoutParams());
    localViewGroup.addView(this, i1);
  }
  
  private void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, JSONObject paramJSONObject, int paramInt)
  {
    int i1;
    if (paramJSONObject.has("cr")) {
      i1 = a(paramJSONObject.getString("cr"));
    } else {
      i1 = -1;
    }
    int i2;
    if (paramJSONObject.has("cn")) {
      i2 = a(paramJSONObject.getString("cn"));
    } else {
      i2 = 0;
    }
    paramJSONObject = a(paramRedTypeInfo.red_content.get(), i1, i2, paramInt);
    if (paramJSONObject != null)
    {
      if (paramRedTypeInfo.red_type.get() == 4)
      {
        paramInt = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (paramInt + 1);
      }
      else
      {
        paramInt = this.jdField_d_of_type_Int;
        this.jdField_d_of_type_Int = (paramInt + 1);
      }
      paramJSONObject.setId(paramInt);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramJSONObject);
    }
  }
  
  private void a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leba show waterMark url = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" width = ");
    localStringBuilder.append(localURLDrawableOptions.mRequestWidth);
    localStringBuilder.append(" height = ");
    localStringBuilder.append(localURLDrawableOptions.mRequestHeight);
    QLog.i("RedTouch", 1, localStringBuilder.toString());
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTargetDensity(getResources().getDisplayMetrics().densityDpi);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  public static boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return false;
    }
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return false;
      }
      if (paramAppInfo.red_display_info.get() != null)
      {
        if (paramAppInfo.red_display_info.red_type_info.get() == null) {
          return false;
        }
        return paramAppInfo.red_display_info.red_type_info.get().size() != 0;
      }
    }
    return false;
  }
  
  private boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.red_type.get() != paramRedTypeInfo2.red_type.get()) {
      return false;
    }
    if (!paramRedTypeInfo1.red_content.get().equals(paramRedTypeInfo2.red_content.get())) {
      return false;
    }
    if (!paramRedTypeInfo1.red_desc.get().equals(paramRedTypeInfo2.red_desc.get())) {
      return false;
    }
    return paramRedTypeInfo1.red_priority.get() == paramRedTypeInfo2.red_priority.get();
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() != paramList.size()) {
      return false;
    }
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (!a((BusinessInfoCheckUpdate.RedTypeInfo)this.jdField_a_of_type_JavaUtilList.get(i1), (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i1))) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private View b()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = a();
    localLayoutParams.width = 0;
    localLayoutParams.height = 1;
    localLayoutParams.weight = 1.0F;
    localView.setLayoutParams(localLayoutParams);
    return localView;
  }
  
  private View b(String paramString)
  {
    Object localObject = getResources().getDrawable(2130840321);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mRequestWidth = a(30);
    localURLDrawableOptions.mRequestHeight = a(30);
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    LinearLayout.LayoutParams localLayoutParams = a();
    localLayoutParams.width = a(30);
    localLayoutParams.height = a(30);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    return localObject;
  }
  
  private FrameLayout.LayoutParams b()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  private FrameLayout b(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    int i1;
    int i2;
    if (this.jdField_d_of_type_Boolean)
    {
      i1 = this.w + 12;
      i2 = 6;
    }
    else
    {
      i1 = 38;
      i2 = 4;
    }
    paramImageView.setLayoutParams(new FrameLayout.LayoutParams(a(i1), a(i1)));
    paramImageView.setPadding(a(i2), a(i2), a(i2), a(i2));
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramImageView.setImageResource(2130850766);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
    return localFrameLayout;
  }
  
  public static String b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "";
    }
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return "";
      }
      if ((paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
      {
        paramAppInfo = paramAppInfo.red_display_info.red_type_info.get().iterator();
        while (paramAppInfo.hasNext())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
          if ((localRedTypeInfo != null) && (localRedTypeInfo.red_type.get() == 11)) {
            return localRedTypeInfo.red_content.get();
          }
        }
      }
    }
    return "";
  }
  
  private void b(View paramView)
  {
    paramView.setLayoutParams(b());
    addView(paramView);
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool = this.jdField_i_of_type_Boolean;
    int i1 = 0;
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    try
    {
      JSONObject localJSONObject;
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
        localJSONObject = new JSONObject();
      } else {
        localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get());
      }
      if (localJSONObject.has("bg")) {
        i1 = a(localJSONObject.getString("bg"));
      }
      int i2 = paramRedTypeInfo.red_type.get();
      if (i2 != 0)
      {
        if (i2 != 9)
        {
          if (i2 != 3)
          {
            if ((i2 != 4) && (i2 != 5)) {
              return;
            }
            a(paramRedTypeInfo, localJSONObject, i1);
            return;
          }
          b(paramRedTypeInfo, localJSONObject, i1);
          return;
        }
        c(paramRedTypeInfo);
        return;
      }
      a(i1);
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      QLog.e("RedTouch", 1, "addRedTouch ", paramRedTypeInfo);
    }
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {
      e();
    }
    boolean bool = paramJSONObject.has("av");
    int i1 = 0;
    int i2;
    if (bool) {
      i2 = paramJSONObject.getInt("av");
    } else {
      i2 = 0;
    }
    int i3;
    if (paramJSONObject.has("dot")) {
      i3 = paramJSONObject.getInt("dot");
    } else {
      i3 = 0;
    }
    int i4;
    if (paramJSONObject.has("drawable")) {
      i4 = paramJSONObject.getInt("drawable");
    } else {
      i4 = 0;
    }
    if (paramJSONObject.has("st")) {
      i1 = Integer.valueOf(paramJSONObject.getString("st")).intValue();
    }
    if (paramJSONObject.has("uin")) {
      i1 = 2;
    }
    if (i1 == 0)
    {
      paramRedTypeInfo = a(paramRedTypeInfo.red_content.get(), i2, i3, paramInt, i4, "");
      if (paramRedTypeInfo != null)
      {
        paramInt = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (paramInt + 1);
        paramRedTypeInfo.setId(paramInt);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
      }
    }
    else if (i1 == 1)
    {
      paramRedTypeInfo = b(paramRedTypeInfo.red_content.get());
      if (paramRedTypeInfo != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
      }
    }
    else if (i1 == 2)
    {
      paramRedTypeInfo = a("", i2, i3, paramInt, i4, paramJSONObject.getString("uin"));
      if (paramRedTypeInfo != null)
      {
        paramInt = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (paramInt + 1);
        paramRedTypeInfo.setId(paramInt);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
      }
    }
  }
  
  private void c(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    paramRedTypeInfo = a(paramRedTypeInfo.red_content.get());
    if (paramRedTypeInfo != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
    }
  }
  
  public static void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (paramAppInfo.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
        if (localRedTypeInfo.red_type.get() == 3) {
          localRedTypeInfo.red_type.set(0);
        } else if (localRedTypeInfo.red_type.get() == 4) {
          localRedTypeInfo.red_type.set(-100);
        } else if (localRedTypeInfo.red_type.get() == 9) {
          localRedTypeInfo.red_type.set(-1);
        }
      }
    }
  }
  
  private void f()
  {
    this.k = this.jdField_f_of_type_Int;
    this.l = this.jdField_g_of_type_Int;
    this.m = this.jdField_h_of_type_Int;
    this.n = this.jdField_i_of_type_Int;
    this.o = this.j;
    this.p = 99;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 20;
    this.jdField_c_of_type_Int = 30;
    this.jdField_d_of_type_Int = 40;
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(100);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  public int a()
  {
    return this.x;
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("#"))) {
      return Color.parseColor(paramString);
    }
    return 0;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected View a(String paramString)
  {
    try
    {
      i1 = Integer.parseInt(paramString);
    }
    catch (NumberFormatException paramString)
    {
      int i1;
      label8:
      LinearLayout.LayoutParams localLayoutParams;
      break label8;
    }
    i1 = 0;
    if (i1 <= 0) {
      return null;
    }
    paramString = new View(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams = a();
    localLayoutParams.width = a(i1);
    localLayoutParams.height = 1;
    paramString.setLayoutParams(localLayoutParams);
    return paramString;
  }
  
  protected View a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setBackgroundColor(paramInt3);
    if (paramInt4 != 0)
    {
      localURLImageView.setImageDrawable(getResources().getDrawable(paramInt4));
    }
    else if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = (IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class);
      if (paramString1 != null)
      {
        paramString2 = paramString1.getFaceDrawable(this.jdField_a_of_type_AndroidContentContext, paramString2);
        if (paramString2 != null) {
          localURLImageView.setImageDrawable(paramString2);
        } else {
          localURLImageView.setImageBitmap(paramString1.getDefaultFaceBitmap());
        }
      }
    }
    else
    {
      a(paramString1, localURLImageView, paramInt1);
    }
    if (paramInt2 == 1)
    {
      if (this.jdField_f_of_type_Boolean) {
        return a(localURLImageView);
      }
      return b(localURLImageView);
    }
    if (paramInt4 != 0)
    {
      localURLImageView.setLayoutParams(a());
      localURLImageView.setPadding(a(3), a(3), a(3), a(3));
      return localURLImageView;
    }
    paramString1 = a();
    paramString1.width = a(30);
    paramString1.height = a(30);
    localURLImageView.setLayoutParams(paramString1);
    return localURLImageView;
  }
  
  protected ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localImageView.setImageResource(2130850766);
      localImageView.setBackgroundColor(paramInt);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label26:
      break label26;
    }
    QLog.e("RedTouch", 1, "getRedPoint oom");
    a();
    localImageView.setLayoutParams(a());
    return localImageView;
  }
  
  protected LinearLayout.LayoutParams a()
  {
    int i1 = this.v;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      if (Integer.parseInt(paramString) > this.p)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.p);
        localStringBuilder.append("+");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label74:
      break label74;
    }
    localTextView.setText(paramString.trim());
    localTextView.setTextColor(paramInt1);
    localTextView.setGravity(17);
    localTextView.setSingleLine(true);
    if (paramInt2 != 0)
    {
      localTextView.setTextSize(11.0F);
      if (this.jdField_e_of_type_Boolean)
      {
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130850772);
      }
      else
      {
        localTextView.setBackgroundResource(2130850770);
      }
    }
    else
    {
      localTextView.setTextSize(13.0F);
    }
    if (this.x == 10) {
      localTextView.setTextSize(1, 17.0F);
    }
    localTextView.setLayoutParams(a());
    if (this.jdField_b_of_type_Boolean)
    {
      localTextView.measure(0, 0);
      this.l = (localTextView.getMeasuredWidth() / 2);
      c();
    }
    return localTextView;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo;
  }
  
  public RedTouch a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      g();
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    c();
    return this;
  }
  
  public RedTouch a(int paramInt)
  {
    this.v = paramInt;
    return this;
  }
  
  public RedTouch a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l = a(paramInt1);
    this.m = a(paramInt2);
    this.n = a(paramInt3);
    this.o = a(paramInt4);
    return this;
  }
  
  public RedTouch a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject).next();
        if ((localRedTypeInfo != null) && (localRedTypeInfo.red_type.get() == 4)) {
          return localRedTypeInfo.red_content.get();
        }
      }
    }
    return "";
  }
  
  public String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramString.toCharArray();
    int i5 = localObject.length;
    int i1 = 0;
    int i3;
    for (int i2 = 0;; i2 = i3)
    {
      i3 = paramInt1;
      if (i1 >= i5) {
        break;
      }
      int i6 = localObject[i1];
      int i4 = 1;
      i3 = i2 + 1;
      if (65 <= i6)
      {
        i2 = i4;
        if (i6 <= 90) {}
      }
      else if ((97 <= i6) && (i6 <= 122))
      {
        i2 = i4;
      }
      else
      {
        i2 = 0;
      }
      if (i2 == 0) {
        paramInt1 = paramInt2;
      }
      if (i3 >= paramInt1)
      {
        i3 = paramInt1;
        break;
      }
      i1 += 1;
    }
    localObject = paramString;
    if (paramString.length() > i3)
    {
      paramString = paramString.substring(0, i3);
      localObject = paramString;
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public List<BusinessInfoCheckUpdate.RedTypeInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      ((IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class)).removeLebaIconAnim(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    d();
    if (paramAppInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return;
      }
      if (paramAppInfo.red_display_info.get() != null)
      {
        if (paramAppInfo.red_display_info.red_type_info.get() == null) {
          return;
        }
        if (a(paramAppInfo.red_display_info.red_type_info.get())) {
          return;
        }
        this.x = paramAppInfo.type.get();
        this.jdField_a_of_type_JavaUtilList.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramAppInfo.hasNext()) {
          b((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next());
        }
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo = paramRedTypeInfo;
    if (paramRedTypeInfo == null)
    {
      d();
      return;
    }
    d();
    b(paramRedTypeInfo);
  }
  
  protected void a(String paramString, URLImageView paramURLImageView, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = getResources().getDrawable(2130840321);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    int i1 = 30;
    if (this.jdField_d_of_type_Boolean) {
      i1 = this.w;
    }
    localURLDrawableOptions.mRequestWidth = a(i1);
    localURLDrawableOptions.mRequestHeight = a(i1);
    try
    {
      localObject = URLDrawable.getDrawable(new URL("redtouchpicdownloadprotoc", null, paramString), localURLDrawableOptions);
      ((URLDrawable)localObject).setTag(paramString);
      ((URLDrawable)localObject).addHeader("isCircle", String.valueOf(paramInt));
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramURLImageView = new StringBuilder();
        paramURLImageView.append("parse img exception : e = ");
        paramURLImageView.append(paramString);
        QLog.d("RedTouch", 2, paramURLImageView.toString());
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject == null) || (((TextView)localObject).getVisibility() != 0))
    {
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (((localObject == null) || (((TextView)localObject).getVisibility() != 0)) && (!c()))
      {
        localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        if ((localObject == null) || (((ImageView)localObject).getDrawable() == null)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public RedTouch b(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      return;
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      ((ImageView)localObject).setVisibility(8);
      return;
    }
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      QLog.i("RedTouch", 1, "leba show waterMark but json isEmpty");
      return;
    }
    try
    {
      localObject = new JSONObject(this.jdField_a_of_type_JavaLangString).optString("waterMarkUrl");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        QLog.i("RedTouch", 1, "leba show waterMark but url isEmpty");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight() > 0)
      {
        a((String)localObject);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new RedTouch.1(this, (String)localObject));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("RedTouch", 1, "leba show waterMark", localException);
    }
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    a(paramAppInfo);
    Object localObject;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localObject = b(paramAppInfo);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        localObject = a((String)localObject, 3, 2, false);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = a(paramAppInfo);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        localObject = a((String)localObject, 8, 8, true);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      paramAppInfo = a(paramAppInfo);
      localObject = (IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class);
      ((IRedTouchTempApi)localObject).removeLebaIconAnim(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView);
      if (paramAppInfo != null)
      {
        URLDrawable localURLDrawable = ((IRedTouchTempApi)localObject).getApngDrawable(this.jdField_a_of_type_AndroidContentContext, paramAppInfo.a());
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        boolean bool = TextUtils.isEmpty(paramAppInfo.b()) ^ true;
        if (bool)
        {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramAppInfo.b());
          this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAppInfo.c());
        }
        ((IRedTouchTempApi)localObject).startLebaIconAnim(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, bool, 5000L, paramAppInfo.a() * 1000, paramAppInfo.a());
        if (paramAppInfo.a()) {
          a(0);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_d_of_type_AndroidWidgetTextView.setText("");
        this.jdField_e_of_type_AndroidWidgetTextView.setText("");
        ((IRedTouchTempApi)localObject).removeLebaIconAnim(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView);
      }
    }
  }
  
  public boolean b()
  {
    if (a())
    {
      ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((localImageView == null) || (localImageView.getDrawable() == null)) {
        return true;
      }
    }
    return false;
  }
  
  public RedTouch c(int paramInt)
  {
    this.l = a(paramInt);
    return this;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    d();
    if (paramAppInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return;
      }
      if (paramAppInfo.red_display_info.get() != null)
      {
        if (paramAppInfo.red_display_info.red_type_info.get() == null) {
          return;
        }
        if (a(paramAppInfo.red_display_info.red_type_info.get())) {
          return;
        }
        this.x = paramAppInfo.type.get();
        this.jdField_a_of_type_JavaUtilList.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramAppInfo.hasNext())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
          if (localRedTypeInfo.red_type.get() == 4) {
            localRedTypeInfo.red_type.set(-1);
          }
          b(localRedTypeInfo);
        }
      }
    }
  }
  
  public boolean c()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    boolean bool = false;
    if (localLinearLayout == null) {
      return false;
    }
    if (localLinearLayout.getChildCount() != 0) {
      bool = true;
    }
    return bool;
  }
  
  public RedTouch d(int paramInt)
  {
    this.m = a(paramInt);
    return this;
  }
  
  public void d()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null)
    {
      localLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Int = 10;
      this.jdField_b_of_type_Int = 20;
      this.jdField_c_of_type_Int = 30;
      this.jdField_d_of_type_Int = 40;
    }
  }
  
  public RedTouch e(int paramInt)
  {
    this.n = a(paramInt);
    return this;
  }
  
  protected void e()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.q;
    localLayoutParams.leftMargin = this.r;
    localLayoutParams.rightMargin = this.s;
    localLayoutParams.topMargin = this.t;
    localLayoutParams.bottomMargin = this.u;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public RedTouch f(int paramInt)
  {
    this.o = a(paramInt);
    return this;
  }
  
  public RedTouch g(int paramInt)
  {
    this.w = paramInt;
    this.jdField_d_of_type_Boolean = true;
    return this;
  }
  
  public void setHostEnable(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      localLinearLayout.setVisibility(i1);
    }
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.ui.RedTouch
 * JD-Core Version:    0.7.0.1
 */