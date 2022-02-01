package com.tencent.mobileqq.redtouch;

import amvb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import azuy;
import azvg;
import bfvo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
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
  protected static int e;
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
  private ImageView d;
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
  protected int j;
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
  
  static
  {
    jdField_e_of_type_Int = 1;
  }
  
  public RedTouch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouch(Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_f_of_type_Int = 21;
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
    paramImageView.setImageResource(2130850321);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
    return localFrameLayout;
  }
  
  public static azuy a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return null;
    }
    if ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0)) {
      return null;
    }
    if ((paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
    {
      azuy localazuy = new azuy(null, 0, null);
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
            if (a((String)localObject, "dot") == 1) {}
            for (boolean bool = true;; bool = false)
            {
              localazuy.a(bool);
              localazuy.a(paramAppInfo);
              localazuy.a(i1);
              QLog.d("RedTouch", 1, new Object[] { "red_content : ", paramAppInfo, " redDesc : ", localObject });
              break;
            }
          }
          if (i1 == 16)
          {
            String str1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get();
            String str2 = "";
            localObject = str2;
            paramAppInfo = str1;
            if (str1 != null)
            {
              localObject = str2;
              paramAppInfo = str1;
              if (str1.contains("\\n"))
              {
                i1 = str1.indexOf("\\n");
                localObject = str1.substring("\\n".length() + i1).replace("\\n", " ");
                paramAppInfo = str1.substring(0, i1);
              }
            }
            localazuy.b(paramAppInfo);
            localazuy.c((String)localObject);
            QLog.d("RedTouch", 1, new Object[] { "red_content : ", paramAppInfo });
          }
        }
      }
      if ((localazuy.a() != null) || (localazuy.b() != null)) {
        return localazuy;
      }
    }
    return null;
  }
  
  public static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "";
    }
    if ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0)) {
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
    return "";
  }
  
  private void a(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380117);
    if (localImageView != null) {
      localImageView.setVisibility(0);
    }
    localImageView = a(paramInt);
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
    int i1 = -1;
    int i2 = 0;
    if (paramJSONObject.has("cr")) {
      i1 = a(paramJSONObject.getString("cr"));
    }
    if (paramJSONObject.has("cn")) {
      i2 = a(paramJSONObject.getString("cn"));
    }
    paramJSONObject = a(paramRedTypeInfo.red_content.get(), i1, i2, paramInt);
    if (paramJSONObject != null)
    {
      if (paramRedTypeInfo.red_type.get() != 4) {
        break label110;
      }
      paramInt = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (paramInt + 1);
    }
    for (;;)
    {
      paramJSONObject.setId(paramInt);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramJSONObject);
      return;
      label110:
      paramInt = this.jdField_d_of_type_Int;
      this.jdField_d_of_type_Int = (paramInt + 1);
    }
  }
  
  private void a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    QLog.i("RedTouch", 1, "leba show waterMark url = " + paramString + " width = " + localURLDrawableOptions.mRequestWidth + " height = " + localURLDrawableOptions.mRequestHeight);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTargetDensity(getResources().getDisplayMetrics().densityDpi);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  public static boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0) || (paramAppInfo.red_display_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get().size() == 0)) {
      return false;
    }
    return true;
  }
  
  private boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.red_type.get() != paramRedTypeInfo2.red_type.get()) {}
    while ((!paramRedTypeInfo1.red_content.get().equals(paramRedTypeInfo2.red_content.get())) || (!paramRedTypeInfo1.red_desc.get().equals(paramRedTypeInfo2.red_desc.get())) || (paramRedTypeInfo1.red_priority.get() != paramRedTypeInfo2.red_priority.get())) {
      return false;
    }
    return true;
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    while (this.jdField_a_of_type_JavaUtilList.size() != paramList.size()) {
      return false;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label84;
      }
      if (!a((BusinessInfoCheckUpdate.RedTypeInfo)this.jdField_a_of_type_JavaUtilList.get(i1), (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i1))) {
        break;
      }
      i1 += 1;
    }
    label84:
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
    Object localObject = getResources().getDrawable(2130840312);
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
    int i2 = 38;
    int i1 = 4;
    if (this.jdField_d_of_type_Boolean)
    {
      i2 = this.w + 12;
      i1 = 6;
    }
    paramImageView.setLayoutParams(new FrameLayout.LayoutParams(a(i2), a(i2)));
    paramImageView.setPadding(a(i1), a(i1), a(i1), a(i1));
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramImageView.setImageResource(2130850321);
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
    if ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0)) {
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
    return "";
  }
  
  private void b(View paramView)
  {
    paramView.setLayoutParams(b());
    addView(paramView);
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    int i1 = 0;
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    JSONObject localJSONObject;
    try
    {
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {}
      for (localJSONObject = new JSONObject();; localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get()))
      {
        if (localJSONObject.has("bg")) {
          i1 = a(localJSONObject.getString("bg"));
        }
        switch (paramRedTypeInfo.red_type.get())
        {
        }
      }
      a(i1);
    }
    catch (Exception paramRedTypeInfo)
    {
      QLog.e("RedTouch", 1, "addRedTouch ", paramRedTypeInfo);
      return;
    }
    return;
    b(paramRedTypeInfo, localJSONObject, i1);
    return;
    a(paramRedTypeInfo, localJSONObject, i1);
    return;
    c(paramRedTypeInfo);
    return;
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, JSONObject paramJSONObject, int paramInt)
  {
    int i1 = 0;
    if (this.jdField_c_of_type_Boolean) {
      e();
    }
    if (paramJSONObject.has("av")) {}
    for (int i2 = paramJSONObject.getInt("av");; i2 = 0)
    {
      if (paramJSONObject.has("dot")) {}
      for (int i3 = paramJSONObject.getInt("dot");; i3 = 0)
      {
        if (paramJSONObject.has("drawable")) {}
        for (int i4 = paramJSONObject.getInt("drawable");; i4 = 0)
        {
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
          do
          {
            do
            {
              do
              {
                return;
                if (i1 != 1) {
                  break;
                }
                paramRedTypeInfo = b(paramRedTypeInfo.red_content.get());
              } while (paramRedTypeInfo == null);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
              return;
            } while (i1 != 2);
            paramRedTypeInfo = a("", i2, i3, paramInt, i4, paramJSONObject.getString("uin"));
          } while (paramRedTypeInfo == null);
          paramInt = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (paramInt + 1);
          paramRedTypeInfo.setId(paramInt);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
          return;
        }
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
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
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
      if (i1 <= 0) {
        return null;
      }
    }
    catch (NumberFormatException paramString)
    {
      int i1;
      for (;;)
      {
        i1 = 0;
      }
      paramString = new View(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = a();
      localLayoutParams.width = a(i1);
      localLayoutParams.height = 1;
      paramString.setLayoutParams(localLayoutParams);
    }
    return paramString;
  }
  
  protected View a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setBackgroundColor(paramInt3);
    if (paramInt4 != 0) {
      localURLImageView.setImageDrawable(getResources().getDrawable(paramInt4));
    }
    while (paramInt2 == 1) {
      if (this.jdField_f_of_type_Boolean)
      {
        return a(localURLImageView);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = null;
          if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
            paramString1 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
          }
          if (paramString1 != null)
          {
            paramString1 = FaceDrawable.getFaceDrawable(paramString1, 1, 4, paramString2);
            if (paramString1 != null) {
              localURLImageView.setImageDrawable(paramString1);
            } else {
              localURLImageView.setImageBitmap(bfvo.a(true));
            }
          }
          else
          {
            localURLImageView.setImageBitmap(bfvo.a(true));
          }
        }
        else
        {
          a(paramString1, localURLImageView, paramInt1);
        }
      }
      else
      {
        return b(localURLImageView);
      }
    }
    if (paramInt4 != 0)
    {
      localURLImageView.setLayoutParams(a());
      localURLImageView.setPadding(a(3), a(3), a(3), a(3));
    }
    for (;;)
    {
      return localURLImageView;
      paramString1 = a();
      paramString1.width = a(30);
      paramString1.height = a(30);
      localURLImageView.setLayoutParams(paramString1);
    }
  }
  
  protected ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localImageView.setImageResource(2130850321);
      localImageView.setBackgroundColor(paramInt);
      a();
      localImageView.setLayoutParams(a());
      return localImageView;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("RedTouch", 1, "getRedPoint oom");
      }
    }
  }
  
  protected LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.v, this.v);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      if (Integer.parseInt(paramString) > this.p) {
        localTextView.setText(this.p + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break label197;
        }
        localTextView.setTextSize(11.0F);
        if (!this.jdField_e_of_type_Boolean) {
          break;
        }
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130850327);
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
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString.trim());
        continue;
        localTextView.setBackgroundResource(2130850325);
        continue;
        label197:
        localTextView.setTextSize(13.0F);
      }
    }
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
    this.k = paramInt;
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next();
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
    int i4 = localObject.length;
    int i1 = 0;
    int i3;
    for (int i2 = 0;; i2 = i3)
    {
      i3 = paramInt1;
      if (i1 < i4)
      {
        int i5 = localObject[i1];
        i3 = i2 + 1;
        if (((65 > i5) || (i5 > 90)) && ((97 > i5) || (i5 > 122))) {
          break label140;
        }
      }
      label140:
      for (i2 = 1;; i2 = 0)
      {
        if (i2 == 0) {
          paramInt1 = paramInt2;
        }
        if (i3 < paramInt1) {
          break;
        }
        i3 = paramInt1;
        localObject = paramString;
        if (paramString.length() > i3)
        {
          paramString = paramString.substring(0, i3);
          localObject = paramString;
          if (paramBoolean) {
            localObject = paramString + "...";
          }
        }
        return localObject;
      }
      i1 += 1;
    }
  }
  
  public List<BusinessInfoCheckUpdate.RedTypeInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      amvb.a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    d();
    if (paramAppInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.exposure_max.get() >= 0) && (paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null) && (!a(paramAppInfo.red_display_info.red_type_info.get())))
      {
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
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = paramRedTypeInfo;
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      Object localObject = getResources().getDrawable(2130840312);
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
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedTouch", 2, "parse img exception : e = " + paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_g_of_type_Boolean = paramBoolean;
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = paramBoolean;
        Object localObject2 = (ViewGroup)getParent();
        Object localObject1 = (TextView)((ViewGroup)localObject2).findViewById(2131378537);
        if ((localObject1 != null) && ((localObject2 instanceof LinearLayout)))
        {
          removeView(this.jdField_a_of_type_AndroidViewView);
          ((ViewGroup)localObject2).removeAllViews();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298808));
          RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((ViewGroup)localObject2).addView(localRelativeLayout, localLayoutParams);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new RelativeLayout.LayoutParams(((TextView)localObject1).getLayoutParams());
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.jdField_a_of_type_AndroidViewView.getId());
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.jdField_a_of_type_AndroidViewView.getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.jdField_a_of_type_AndroidViewView.getId());
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.dp2px(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130849675);
          localRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("RedTouch", 1, "parseRedBagTouch, ", localException);
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) || ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) || (c()) || ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getDrawable() != null));
  }
  
  public RedTouch b(int paramInt)
  {
    this.l = a(paramInt);
    return this;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
      String str = new JSONObject(this.jdField_a_of_type_JavaLangString).optString("waterMarkUrl");
      if (TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        QLog.i("RedTouch", 1, "leba show waterMark but url isEmpty");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("RedTouch", 1, "leba show waterMark", localException);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight() > 0)
    {
      a(localException);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new azvg(this, localException));
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool = true;
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
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = a(paramAppInfo);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label261;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label81:
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        paramAppInfo = a(paramAppInfo);
        amvb.a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView);
        if (paramAppInfo == null) {
          break label296;
        }
        localObject = amvb.a(this.jdField_a_of_type_AndroidContentContext, paramAppInfo.a());
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (TextUtils.isEmpty(paramAppInfo.b())) {
          break label291;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramAppInfo.b());
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAppInfo.c());
      }
      amvb.a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, bool, 5000L, paramAppInfo.a() * 1000, paramAppInfo.a());
      if (paramAppInfo.a()) {
        a(0);
      }
      return;
      localObject = a((String)localObject, 3, 2, false);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label261:
      localObject = a((String)localObject, 8, 8, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label81;
      label291:
      bool = false;
    }
    label296:
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    this.jdField_e_of_type_AndroidWidgetTextView.setText("");
    amvb.a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView);
  }
  
  public boolean b()
  {
    return (a()) && ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getDrawable() == null));
  }
  
  public RedTouch c(int paramInt)
  {
    this.m = a(paramInt);
    return this;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    d();
    if (paramAppInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.exposure_max.get() >= 0) && (paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null) && (!a(paramAppInfo.red_display_info.red_type_info.get())))
      {
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
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
      return false;
    }
    return true;
  }
  
  public RedTouch d(int paramInt)
  {
    this.n = a(paramInt);
    return this;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Int = 10;
      this.jdField_b_of_type_Int = 20;
      this.jdField_c_of_type_Int = 30;
      this.jdField_d_of_type_Int = 40;
    }
  }
  
  public RedTouch e(int paramInt)
  {
    this.o = a(paramInt);
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
    this.w = paramInt;
    this.jdField_d_of_type_Boolean = true;
    return this;
  }
  
  public void setHostEnable(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i1 = 0;; i1 = 4)
    {
      localLinearLayout.setVisibility(i1);
      this.jdField_i_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void setMaxNum(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouch
 * JD-Core Version:    0.7.0.1
 */