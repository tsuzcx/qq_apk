package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouch
  extends FrameLayout
{
  protected static int e;
  protected int a;
  protected Context a;
  protected Handler a;
  protected View a;
  private ImageView a;
  protected LinearLayout a;
  protected List a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  public boolean e;
  protected int f;
  boolean f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q = -2;
  
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
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
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
    paramImageView.setImageResource(2130845923);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
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
  
  private boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.red_type.get() != paramRedTypeInfo2.red_type.get()) {}
    while ((!paramRedTypeInfo1.red_content.get().equals(paramRedTypeInfo2.red_content.get())) || (!paramRedTypeInfo1.red_desc.get().equals(paramRedTypeInfo2.red_desc.get())) || (paramRedTypeInfo1.red_priority.get() != paramRedTypeInfo2.red_priority.get())) {
      return false;
    }
    return true;
  }
  
  private boolean a(List paramList)
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
  
  private View b(String paramString)
  {
    Object localObject = getResources().getDrawable(2130839128);
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
    paramImageView.setLayoutParams(new FrameLayout.LayoutParams(a(38), a(38)));
    paramImageView.setPadding(a(4), a(4), a(4), a(4));
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramImageView.setImageResource(2130845923);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
    return localFrameLayout;
  }
  
  private void b(View paramView)
  {
    paramView.setLayoutParams(b());
    addView(paramView);
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    int i3 = 0;
    int i1 = 0;
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    try
    {
      Object localObject;
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get()))
      {
        localObject = new JSONObject();
        if (!((JSONObject)localObject).has("bg")) {
          break label622;
        }
      }
      label622:
      for (int i2 = a(((JSONObject)localObject).getString("bg"));; i2 = 0) {
        switch (paramRedTypeInfo.red_type.get())
        {
        case 0: 
          localObject = new JSONObject(paramRedTypeInfo.red_desc.get());
          break;
          paramRedTypeInfo = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371147);
          if (paramRedTypeInfo != null) {
            paramRedTypeInfo.setVisibility(0);
          }
          paramRedTypeInfo = a(i2);
          if (paramRedTypeInfo == null) {
            break label627;
          }
          i1 = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_Int = (i1 + 1);
          paramRedTypeInfo.setId(i1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
          return;
        case 3: 
          if (!((JSONObject)localObject).has("av")) {}
        case 4: 
        case 5: 
        case 9: 
          for (i3 = ((JSONObject)localObject).getInt("av");; i3 = 0)
          {
            if (((JSONObject)localObject).has("dot")) {}
            for (int i4 = ((JSONObject)localObject).getInt("dot");; i4 = 0)
            {
              if (((JSONObject)localObject).has("drawable")) {}
              for (int i5 = ((JSONObject)localObject).getInt("drawable");; i5 = 0)
              {
                if (((JSONObject)localObject).has("st")) {
                  i1 = Integer.valueOf(((JSONObject)localObject).getString("st")).intValue();
                }
                if (((JSONObject)localObject).has("uin")) {
                  i1 = 2;
                }
                if (i1 == 0)
                {
                  paramRedTypeInfo = a(paramRedTypeInfo.red_content.get(), i3, i4, i2, i5, "");
                  if (paramRedTypeInfo == null) {
                    break;
                  }
                  i1 = this.jdField_b_of_type_Int;
                  this.jdField_b_of_type_Int = (i1 + 1);
                  paramRedTypeInfo.setId(i1);
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
                  return;
                }
                if (i1 == 1)
                {
                  paramRedTypeInfo = b(paramRedTypeInfo.red_content.get());
                  if (paramRedTypeInfo == null) {
                    break;
                  }
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
                  return;
                }
                if (i1 != 2) {
                  break;
                }
                paramRedTypeInfo = a("", i3, i4, i2, i5, ((JSONObject)localObject).getString("uin"));
                if (paramRedTypeInfo == null) {
                  break;
                }
                i1 = this.jdField_b_of_type_Int;
                this.jdField_b_of_type_Int = (i1 + 1);
                paramRedTypeInfo.setId(i1);
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
                return;
                i1 = -1;
                if (((JSONObject)localObject).has("cr")) {
                  i1 = a(((JSONObject)localObject).getString("cr"));
                }
                if (((JSONObject)localObject).has("cn")) {
                  i3 = a(((JSONObject)localObject).getString("cn"));
                }
                localObject = a(paramRedTypeInfo.red_content.get(), i1, i3, i2);
                if (localObject == null) {
                  break;
                }
                if (paramRedTypeInfo.red_type.get() == 4)
                {
                  i1 = this.jdField_c_of_type_Int;
                  this.jdField_c_of_type_Int = (i1 + 1);
                }
                for (;;)
                {
                  ((View)localObject).setId(i1);
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
                  return;
                  i1 = this.jdField_d_of_type_Int;
                  this.jdField_d_of_type_Int = (i1 + 1);
                }
                paramRedTypeInfo = a(paramRedTypeInfo.red_content.get());
                if (paramRedTypeInfo == null) {
                  break;
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
                return;
              }
            }
          }
        }
      }
      label627:
      return;
    }
    catch (Exception paramRedTypeInfo) {}
  }
  
  private void c()
  {
    this.k = this.jdField_f_of_type_Int;
    this.l = this.g;
    this.m = this.h;
    this.n = this.i;
    this.o = this.j;
    this.p = 99;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 20;
    this.jdField_c_of_type_Int = 30;
    this.jdField_d_of_type_Int = 40;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(100);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
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
      if (this.jdField_d_of_type_Boolean)
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
            paramString1 = FaceDrawable.a(paramString1, 1, paramString2);
            if (paramString1 != null) {
              localURLImageView.setImageDrawable(paramString1);
            } else {
              localURLImageView.setImageBitmap(ImageUtil.a());
            }
          }
          else
          {
            localURLImageView.setImageBitmap(ImageUtil.a());
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
    localImageView.setImageResource(2130845923);
    localImageView.setBackgroundColor(paramInt);
    localImageView.setLayoutParams(a());
    return localImageView;
  }
  
  protected LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.q, this.q);
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
          break label179;
        }
        localTextView.setTextSize(11.0F);
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130845929);
        localTextView.setLayoutParams(a());
        if (this.jdField_b_of_type_Boolean)
        {
          localTextView.measure(0, 0);
          this.l = (localTextView.getMeasuredWidth() / 2);
          a();
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
        localTextView.setBackgroundResource(2130845927);
        continue;
        label179:
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
      d();
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    a();
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
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    b();
    if (paramAppInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null) && (!a(paramAppInfo.red_display_info.red_type_info.get())))
      {
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
    if (paramRedTypeInfo == null)
    {
      b();
      return;
    }
    b();
    b(paramRedTypeInfo);
  }
  
  protected void a(String paramString, URLImageView paramURLImageView, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      Object localObject = getResources().getDrawable(2130839128);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mRequestWidth = a(30);
      localURLDrawableOptions.mRequestHeight = a(30);
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
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
        Object localObject2 = (ViewGroup)getParent();
        Object localObject1 = (TextView)((ViewGroup)localObject2).findViewById(2131374727);
        if ((localObject1 != null) && ((localObject2 instanceof LinearLayout)))
        {
          removeView(this.jdField_a_of_type_AndroidViewView);
          ((ViewGroup)localObject2).removeAllViews();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131558948));
          RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((ViewGroup)localObject2).addView(localRelativeLayout, localLayoutParams);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new RelativeLayout.LayoutParams(((TextView)localObject1).getLayoutParams());
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.jdField_a_of_type_AndroidViewView.getId());
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.jdField_a_of_type_AndroidViewView.getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.jdField_a_of_type_AndroidViewView.getId());
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845451);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
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
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
      return false;
    }
    return true;
  }
  
  public RedTouch b(int paramInt)
  {
    this.l = a(paramInt);
    return this;
  }
  
  public void b()
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
  
  public RedTouch c(int paramInt)
  {
    this.m = a(paramInt);
    return this;
  }
  
  public RedTouch d(int paramInt)
  {
    this.n = a(paramInt);
    return this;
  }
  
  public RedTouch e(int paramInt)
  {
    this.o = a(paramInt);
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
      this.jdField_f_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void setMaxNum(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouch
 * JD-Core Version:    0.7.0.1
 */