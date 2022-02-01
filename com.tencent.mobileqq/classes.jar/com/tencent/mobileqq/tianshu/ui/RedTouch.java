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
import com.tencent.widget.RedWidgetUtil;
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
  protected static int i = 1;
  protected int A;
  protected int B;
  protected int C;
  protected int D;
  protected int E;
  protected int F = -2;
  protected int G = 30;
  protected boolean H = false;
  protected boolean I = false;
  protected List<BusinessInfoCheckUpdate.RedTypeInfo> J;
  protected BusinessInfoCheckUpdate.RedTypeInfo K;
  public boolean L = false;
  public TextView M;
  public TextView N;
  public ImageView O;
  public String P;
  public boolean Q;
  public ImageView R;
  public ImageView S;
  public TextView T;
  public TextView U;
  public TextView V;
  boolean W = true;
  private int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected Context f;
  protected View g;
  protected LinearLayout h;
  protected boolean j = false;
  protected Handler k;
  protected int l = 21;
  protected int m = 0;
  protected int n = 0;
  protected int o = 0;
  protected int p = 0;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected boolean v;
  protected int w;
  protected boolean x = false;
  protected boolean y;
  protected boolean z;
  
  public RedTouch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouch(Context paramContext, View paramView)
  {
    super(paramContext);
    this.f = paramContext;
    this.g = paramView;
    j();
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
  
  private FrameLayout a(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(a(30.0F), a(30.0F));
    localLayoutParams.gravity = 80;
    localLayoutParams.topMargin = a(16.0F);
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.f);
    paramImageView.setImageResource(2130852588);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(getRedTouchLayoutParams());
    return localFrameLayout;
  }
  
  private void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup == null) {
      return;
    }
    if ((localViewGroup instanceof RelativeLayout))
    {
      i1 = i;
      i = i1 + 1;
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
        paramInt = this.d;
        this.d = (paramInt + 1);
      }
      else
      {
        paramInt = this.e;
        this.e = (paramInt + 1);
      }
      paramJSONObject.setId(paramInt);
      this.h.addView(paramJSONObject);
    }
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
    if (this.J.size() == 0) {
      return false;
    }
    if (this.J.size() != paramList.size()) {
      return false;
    }
    int i1 = 0;
    while (i1 < this.J.size())
    {
      if (!a((BusinessInfoCheckUpdate.RedTypeInfo)this.J.get(i1), (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i1))) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private FrameLayout b(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    int i1;
    int i2;
    if (this.z)
    {
      i1 = this.G + 12;
      i2 = 6;
    }
    else
    {
      i1 = 38;
      i2 = 4;
    }
    float f1 = i1;
    paramImageView.setLayoutParams(new FrameLayout.LayoutParams(a(f1), a(f1)));
    f1 = i2;
    paramImageView.setPadding(a(f1), a(f1), a(f1), a(f1));
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.f);
    paramImageView.setImageResource(2130852588);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(getRedTouchLayoutParams());
    return localFrameLayout;
  }
  
  private void b(View paramView)
  {
    paramView.setLayoutParams(getRedTouchTargetLayoutParams());
    addView(paramView);
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool = this.W;
    int i1 = 0;
    if (bool) {
      this.h.setVisibility(0);
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
      g(i1);
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      QLog.e("RedTouch", 1, "addRedTouch ", paramRedTypeInfo);
    }
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, JSONObject paramJSONObject, int paramInt)
  {
    if (this.y) {
      i();
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
        paramInt = this.c;
        this.c = (paramInt + 1);
        paramRedTypeInfo.setId(paramInt);
        this.h.addView(paramRedTypeInfo);
      }
    }
    else if (i1 == 1)
    {
      paramRedTypeInfo = d(paramRedTypeInfo.red_content.get());
      if (paramRedTypeInfo != null) {
        this.h.addView(paramRedTypeInfo);
      }
    }
    else if (i1 == 2)
    {
      paramRedTypeInfo = a("", i2, i3, paramInt, i4, paramJSONObject.getString("uin"));
      if (paramRedTypeInfo != null)
      {
        paramInt = this.c;
        this.c = (paramInt + 1);
        paramRedTypeInfo.setId(paramInt);
        this.h.addView(paramRedTypeInfo);
      }
    }
  }
  
  private void c(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    paramRedTypeInfo = b(paramRedTypeInfo.red_content.get());
    if (paramRedTypeInfo != null) {
      this.h.addView(paramRedTypeInfo);
    }
  }
  
  private void c(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.O.getMeasuredWidth();
    localURLDrawableOptions.mRequestHeight = this.O.getMeasuredHeight();
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
    this.O.setImageDrawable(paramString);
  }
  
  private View d(String paramString)
  {
    Object localObject = getResources().getDrawable(2130841060);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mRequestWidth = a(30.0F);
    localURLDrawableOptions.mRequestHeight = a(30.0F);
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = new ImageView(this.f);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    LinearLayout.LayoutParams localLayoutParams = getRedTouchLayoutParams();
    localLayoutParams.width = a(30.0F);
    localLayoutParams.height = a(30.0F);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    return localObject;
  }
  
  public static boolean d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
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
  
  public static AnimIconRedDot e(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
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
        if ((localAnimIconRedDot.a() != null) || (localAnimIconRedDot.c() != null)) {
          return localAnimIconRedDot;
        }
      }
    }
    return null;
  }
  
  public static String f(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
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
  
  public static String g(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
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
  
  private void g(int paramInt)
  {
    ((IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class)).onProcessAddRedPoint(this.g);
    ImageView localImageView = a(paramInt);
    if (localImageView != null)
    {
      if (this.a == 10)
      {
        View localView = getExtenSpace();
        if (localView != null) {
          this.h.addView(localView);
        }
      }
      paramInt = this.b;
      this.b = (paramInt + 1);
      localImageView.setId(paramInt);
      this.h.addView(localImageView);
    }
  }
  
  private View getExtenSpace()
  {
    View localView = new View(this.f);
    LinearLayout.LayoutParams localLayoutParams = getRedTouchLayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.height = 1;
    localLayoutParams.weight = 1.0F;
    localView.setLayoutParams(localLayoutParams);
    return localView;
  }
  
  private FrameLayout.LayoutParams getRedTouchContainerLayoutParams()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.q;
    localLayoutParams.leftMargin = this.r;
    localLayoutParams.rightMargin = this.s;
    localLayoutParams.topMargin = this.t;
    localLayoutParams.bottomMargin = this.u;
    return localLayoutParams;
  }
  
  private FrameLayout.LayoutParams getRedTouchTargetLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  private void j()
  {
    this.q = this.l;
    this.r = this.m;
    this.s = this.n;
    this.t = this.o;
    this.u = this.p;
    this.w = 99;
    this.J = new ArrayList();
    this.k = new Handler(Looper.getMainLooper());
    this.b = 10;
    this.c = 20;
    this.d = 30;
    this.e = 40;
  }
  
  private void k()
  {
    this.h = new LinearLayout(this.f);
    this.h.setLayoutParams(getRedTouchContainerLayoutParams());
    this.h.setOrientation(0);
    this.h.setId(100);
    this.h.setVisibility(8);
    addView(this.h);
  }
  
  protected int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("#"))) {
      return Color.parseColor(paramString);
    }
    return 0;
  }
  
  protected View a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    URLImageView localURLImageView = new URLImageView(this.f);
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
        paramString2 = paramString1.getFaceDrawable(this.f, paramString2);
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
      if (this.I) {
        return a(localURLImageView);
      }
      return b(localURLImageView);
    }
    if (paramInt4 != 0)
    {
      localURLImageView.setLayoutParams(getRedTouchLayoutParams());
      localURLImageView.setPadding(a(3.0F), a(3.0F), a(3.0F), a(3.0F));
      return localURLImageView;
    }
    paramString1 = getRedTouchLayoutParams();
    paramString1.width = a(30.0F);
    paramString1.height = a(30.0F);
    localURLImageView.setLayoutParams(paramString1);
    return localURLImageView;
  }
  
  protected ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.f);
    try
    {
      localImageView.setImageResource(2130852588);
      localImageView.setBackgroundColor(paramInt);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label26:
      break label26;
    }
    QLog.e("RedTouch", 1, "getRedPoint oom");
    getRedTouchLayoutParams();
    localImageView.setLayoutParams(getRedTouchLayoutParams());
    return localImageView;
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.f);
    try
    {
      paramInt3 = Integer.parseInt(paramString);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int i1;
      label81:
      label84:
      break label81;
    }
    try
    {
      if (paramInt3 > this.w)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.w);
        localStringBuilder.append("+");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        localTextView.setText(paramString);
      }
      i1 = 1;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label84;
    }
    paramInt3 = 0;
    localTextView.setText(paramString.trim());
    i1 = 0;
    localTextView.setTextColor(paramInt1);
    localTextView.setGravity(17);
    localTextView.setSingleLine(true);
    if (paramInt2 != 0)
    {
      localTextView.setTextSize(11.0F);
      if (this.H)
      {
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130852594);
      }
      else
      {
        localTextView.setBackgroundResource(2130852592);
      }
    }
    else
    {
      localTextView.setTextSize(13.0F);
    }
    if (this.a == 10) {
      localTextView.setTextSize(1, 17.0F);
    }
    if ((!this.H) && (i1 != 0) && (this.x)) {
      RedWidgetUtil.fixTextViewLayout(localTextView, paramInt3, this.w, 2130852592);
    } else {
      localTextView.setLayoutParams(getRedTouchLayoutParams());
    }
    if (this.v)
    {
      localTextView.measure(0, 0);
      this.r = (localTextView.getMeasuredWidth() / 2);
      f();
    }
    return localTextView;
  }
  
  public RedTouch a()
  {
    if (!this.j)
    {
      a(this.g);
      b(this.g);
      k();
      this.j = true;
      return this;
    }
    f();
    return this;
  }
  
  public RedTouch a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.r = a(paramInt1);
    this.s = a(paramInt2);
    this.t = a(paramInt3);
    this.u = a(paramInt4);
    return this;
  }
  
  public RedTouch a(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
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
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    g();
    if (paramAppInfo == null) {
      return;
    }
    this.J.clear();
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
        this.a = paramAppInfo.type.get();
        this.J.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.J.iterator();
        while (paramAppInfo.hasNext()) {
          b((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next());
        }
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    this.K = paramRedTypeInfo;
    if (paramRedTypeInfo == null)
    {
      g();
      return;
    }
    g();
    b(paramRedTypeInfo);
  }
  
  protected void a(String paramString, URLImageView paramURLImageView, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = getResources().getDrawable(2130841060);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    int i1 = 30;
    if (this.z) {
      i1 = this.G;
    }
    float f1 = i1;
    localURLDrawableOptions.mRequestWidth = a(f1);
    localURLDrawableOptions.mRequestHeight = a(f1);
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
  
  protected View b(String paramString)
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
    paramString = new View(this.f);
    localLayoutParams = getRedTouchLayoutParams();
    localLayoutParams.width = a(i1);
    localLayoutParams.height = 1;
    paramString.setLayoutParams(localLayoutParams);
    return paramString;
  }
  
  public RedTouch b(float paramFloat)
  {
    this.s = a(paramFloat);
    return this;
  }
  
  public RedTouch b(int paramInt)
  {
    this.F = paramInt;
    return this;
  }
  
  public void b()
  {
    TextView localTextView = this.N;
    if (localTextView != null)
    {
      localTextView.setText("");
      this.N.setVisibility(8);
    }
    localTextView = this.M;
    if (localTextView != null)
    {
      localTextView.setText("");
      this.M.setVisibility(8);
    }
    if ((this.S != null) && (this.R != null)) {
      ((IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class)).removeLebaIconAnim(this.S, this.R, this.T, this.U, this.V);
    }
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    a(paramAppInfo);
    Object localObject;
    if (this.N != null)
    {
      localObject = g(paramAppInfo);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.N.setText("");
        this.N.setVisibility(8);
      }
      else
      {
        localObject = a((String)localObject, 3, 2, false);
        this.N.setText((CharSequence)localObject);
        this.N.setVisibility(0);
      }
    }
    if (this.M != null)
    {
      localObject = f(paramAppInfo);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.M.setText("");
        this.M.setVisibility(8);
      }
      else
      {
        localObject = a((String)localObject, 8, 8, true);
        this.M.setText((CharSequence)localObject);
        this.M.setVisibility(0);
      }
    }
    if (this.S != null)
    {
      paramAppInfo = e(paramAppInfo);
      localObject = (IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class);
      ((IRedTouchTempApi)localObject).removeLebaIconAnim(this.S, this.R, this.T, this.U, this.V);
      if (paramAppInfo != null)
      {
        URLDrawable localURLDrawable = ((IRedTouchTempApi)localObject).getApngDrawable(this.f, paramAppInfo.a());
        this.S.setImageDrawable(localURLDrawable);
        boolean bool = TextUtils.isEmpty(paramAppInfo.c()) ^ true;
        if (bool)
        {
          this.U.setText(paramAppInfo.c());
          this.V.setText(paramAppInfo.e());
        }
        ((IRedTouchTempApi)localObject).startLebaIconAnim(this.S, this.R, this.T, this.U, this.V, this.M, bool, 5000L, paramAppInfo.b() * 1000, paramAppInfo.a());
        if (paramAppInfo.d()) {
          g(0);
        }
      }
      else
      {
        this.S.setImageDrawable(null);
        this.U.setText("");
        this.V.setText("");
        ((IRedTouchTempApi)localObject).removeLebaIconAnim(this.S, this.R, this.T, this.U, this.V);
      }
    }
  }
  
  public RedTouch c(float paramFloat)
  {
    this.t = a(paramFloat);
    return this;
  }
  
  public RedTouch c(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    g();
    if (paramAppInfo == null) {
      return;
    }
    this.J.clear();
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
        this.a = paramAppInfo.type.get();
        this.J.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.J.iterator();
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
    Object localObject = this.M;
    if ((localObject == null) || (((TextView)localObject).getVisibility() != 0))
    {
      localObject = this.N;
      if (((localObject == null) || (((TextView)localObject).getVisibility() != 0)) && (!h()))
      {
        localObject = this.S;
        if ((localObject == null) || (((ImageView)localObject).getDrawable() == null)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public RedTouch d(int paramInt)
  {
    this.r = a(paramInt);
    return this;
  }
  
  public boolean d()
  {
    if (c())
    {
      ImageView localImageView = this.S;
      if ((localImageView == null) || (localImageView.getDrawable() == null)) {
        return true;
      }
    }
    return false;
  }
  
  public RedTouch e(int paramInt)
  {
    this.u = a(paramInt);
    return this;
  }
  
  public void e()
  {
    Object localObject = this.O;
    if (localObject == null) {
      return;
    }
    if (!this.Q)
    {
      ((ImageView)localObject).setVisibility(8);
      return;
    }
    if (!d())
    {
      this.O.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(this.P))
    {
      this.O.setVisibility(8);
      QLog.i("RedTouch", 1, "leba show waterMark but json isEmpty");
      return;
    }
    try
    {
      localObject = new JSONObject(this.P).optString("waterMarkUrl");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.O.setVisibility(8);
        QLog.i("RedTouch", 1, "leba show waterMark but url isEmpty");
        return;
      }
      this.O.setVisibility(0);
      if (this.O.getMeasuredHeight() > 0)
      {
        c((String)localObject);
        return;
      }
      this.O.getViewTreeObserver().addOnGlobalLayoutListener(new RedTouch.1(this, (String)localObject));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("RedTouch", 1, "leba show waterMark", localException);
    }
  }
  
  public RedTouch f(int paramInt)
  {
    this.G = paramInt;
    this.z = true;
    return this;
  }
  
  protected void f()
  {
    this.h.setLayoutParams(getRedTouchContainerLayoutParams());
  }
  
  public void g()
  {
    LinearLayout localLinearLayout = this.h;
    if (localLinearLayout != null)
    {
      localLinearLayout.removeAllViews();
      this.h.setVisibility(8);
      this.b = 10;
      this.c = 20;
      this.d = 30;
      this.e = 40;
    }
  }
  
  public int getGravity()
  {
    return this.q;
  }
  
  public int getLeftMargin()
  {
    return this.r;
  }
  
  public int getOuterRedType()
  {
    return this.a;
  }
  
  protected LinearLayout.LayoutParams getRedTouchLayoutParams()
  {
    int i1 = this.F;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedType()
  {
    return this.K;
  }
  
  public List<BusinessInfoCheckUpdate.RedTypeInfo> getRedTypeInfo()
  {
    return this.J;
  }
  
  public String getRedTypeInfoText()
  {
    Object localObject = this.J;
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
  
  public int getRightMargin()
  {
    return this.s;
  }
  
  public View getTarget()
  {
    return this.g;
  }
  
  public int getTopMargin()
  {
    return this.t;
  }
  
  public boolean h()
  {
    LinearLayout localLinearLayout = this.h;
    boolean bool = false;
    if (localLinearLayout == null) {
      return false;
    }
    if (localLinearLayout.getChildCount() != 0) {
      bool = true;
    }
    return bool;
  }
  
  protected void i()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.A;
    localLayoutParams.leftMargin = this.B;
    localLayoutParams.rightMargin = this.C;
    localLayoutParams.topMargin = this.D;
    localLayoutParams.bottomMargin = this.E;
    this.h.setLayoutParams(localLayoutParams);
  }
  
  public void setHostEnable(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.h;
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
    this.W = paramBoolean;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setUseNewStyle(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.ui.RedTouch
 * JD-Core Version:    0.7.0.1
 */