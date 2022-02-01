package com.tencent.mobileqq.vas.qqvaluecard.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGView;

public class QQValuePagView
  extends VasPagView
{
  public static int a = 42;
  public static int b = 15;
  private static final Map<String, Integer> e = new HashMap();
  Function1<View, Unit> c = new QQValuePagView.1(this);
  private String f = "";
  private String g = "";
  private QQValueInfoItem h;
  private String i = "";
  private int j = -2;
  
  public QQValuePagView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QQValuePagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQValuePagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int m = d(this.g, this.f);
    int k = paramInt;
    if (paramBoolean)
    {
      k = paramInt;
      if (m != -2)
      {
        k = paramInt;
        if (this.h.a != d(this.g, "setting"))
        {
          k = paramInt;
          if (this.h.a != d(this.g, "card"))
          {
            if (this.h.a == m) {
              return 0;
            }
            if (this.h.a > m) {
              return 1;
            }
            k = -1;
          }
        }
      }
    }
    return k;
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    e.put(b(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private boolean a()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      if (!((QQValueInfoItem)localObject).g) {
        return false;
      }
      removeAllViews();
      localObject = new TextView(getContext());
      if (this.h.a == -1)
      {
        ((TextView)localObject).setBackgroundDrawable(getResources().getDrawable(2130852442));
      }
      else
      {
        ((TextView)localObject).setBackgroundDrawable(getResources().getDrawable(2130852452));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.h.a);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      ((TextView)localObject).setPadding(30, 0, 0, 9);
      ((TextView)localObject).setTextSize(11.0F);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextScaleX(0.9F);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
      addView((View)localObject, AIOUtils.b(a, ((TextView)localObject).getResources()), AIOUtils.b(b, ((TextView)localObject).getResources()));
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramBoolean))
    {
      PAGView localPAGView = (PAGView)paramView;
      if (localPAGView.getFile() != null)
      {
        g().a();
        return true;
      }
      if (a(localPAGView, this.g, paramString2, paramString1))
      {
        b(this.g, this.f, paramInt1);
        a(this.g, this.f, this.h.a);
        this.i = this.g;
        this.j = this.h.a;
        paramLayoutParams.width = AIOUtils.b(a, paramView.getResources());
        paramView.postInvalidate();
        return false;
      }
      paramLayoutParams.width = 0;
    }
    return false;
  }
  
  private boolean a(PAGView paramPAGView, String paramString1, String paramString2, String paramString3)
  {
    if (paramPAGView == null) {
      return false;
    }
    File localFile1 = new File(paramString2);
    File localFile2 = new File(paramString3);
    if ((localFile1.exists()) && (localFile2.exists()))
    {
      paramString1 = PAGFont.RegisterFont(paramString2);
      paramString2 = PAGFile.Load(paramString3);
      if (paramString2 != null)
      {
        if (paramString1 == null) {
          return false;
        }
        if (paramString2.numTexts() > 0)
        {
          paramString3 = paramString2.getTextData(0);
          paramString3.fontFamily = paramString1.fontFamily;
          paramString3.fontStyle = paramString1.fontStyle;
          int k = this.h.a;
          if (k == -1)
          {
            paramString1 = "????";
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append(k);
            paramString1.append("");
            paramString1 = paramString1.toString();
          }
          paramString3.text = paramString1;
          paramString2.replaceText(0, paramString3);
        }
        paramPAGView.setComposition(paramString2);
        paramPAGView.setRepeatCount(-1);
        paramPAGView.play();
        return true;
      }
      return false;
    }
    QQValueInfoManage.a().e(paramString1);
    return false;
  }
  
  private String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("old_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    e.put(c(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private String c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("old_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_Trend");
    return localStringBuilder.toString();
  }
  
  private int d(String paramString1, String paramString2)
  {
    paramString1 = (Integer)e.get(b(paramString1, paramString2));
    if (paramString1 == null) {
      return -2;
    }
    return paramString1.intValue();
  }
  
  private int e(String paramString1, String paramString2)
  {
    paramString1 = (Integer)e.get(c(paramString1, paramString2));
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.intValue();
  }
  
  private boolean h()
  {
    return (this.j != this.h.a) || (e(this.g, this.f) != 0) || ((this.f == "setting") && (this.g != this.i));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (getContext() == null) {
      return;
    }
    if (this.h == null) {
      this.h = QQValueInfoManage.a().c(paramString2);
    }
    if (TextUtils.isEmpty(this.h.e)) {
      return;
    }
    Object localObject = this.h.e;
    paramString2 = new StringBuilder((String)localObject);
    if (((String)localObject).contains("?"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&from=");
      ((StringBuilder)localObject).append(paramString1);
      paramString2.append(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("?from=");
      ((StringBuilder)localObject).append(paramString1);
      paramString2.append(((StringBuilder)localObject).toString());
    }
    paramString1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject = new Intent(getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", paramString1.getCurrentUin());
    ((Intent)localObject).putExtra("url", paramString2.toString());
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    getContext().startActivity((Intent)localObject);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.h = QQValueInfoManage.a().c(paramString1);
    this.f = paramString2;
    this.g = paramString1;
    paramString1 = this.h;
    if ((paramString1 != null) && (paramString1.f != 1) && (this.h.a >= -1) && (this.h.b != 0))
    {
      setVisibility(0);
      QQValueInfoManage.a().a(paramString2, this);
      if ((paramString2 == "card") && (this.j == this.h.a)) {
        return;
      }
      if (paramBoolean) {
        setForeground(new ColorDrawable(1996488704));
      } else {
        setForeground(null);
      }
      if (a()) {
        return;
      }
      g().b(this.c);
      if (!b())
      {
        g().a();
        return;
      }
      g().b();
      return;
    }
    setVisibility(8);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.i.equals(paramString)) {
        a(paramString, this.f, paramBoolean);
      }
    }
    else {
      post(new QQValuePagView.2(this, paramString, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView
 * JD-Core Version:    0.7.0.1
 */