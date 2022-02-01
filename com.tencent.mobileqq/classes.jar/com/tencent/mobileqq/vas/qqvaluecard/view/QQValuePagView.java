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
  public static int a;
  private static final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static int b;
  private QQValueInfoItem jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem;
  private String jdField_a_of_type_JavaLangString = "";
  Function1<View, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new QQValuePagView.1(this);
  private String b;
  private int jdField_c_of_type_Int = -2;
  private String jdField_c_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_Int = 42;
    jdField_b_of_type_Int = 15;
  }
  
  public QQValuePagView(@NotNull Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public QQValuePagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public QQValuePagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int j = a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    int i = paramInt;
    if (paramBoolean)
    {
      i = paramInt;
      if (j != -2)
      {
        i = paramInt;
        if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int != a(this.jdField_b_of_type_JavaLangString, "setting"))
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int != a(this.jdField_b_of_type_JavaLangString, "card"))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int == j) {
              return 0;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int > j) {
              return 1;
            }
            i = -1;
          }
        }
      }
    }
    return i;
  }
  
  private int a(String paramString1, String paramString2)
  {
    paramString1 = (Integer)jdField_a_of_type_JavaUtilMap.get(a(paramString1, paramString2));
    if (paramString1 == null) {
      return -2;
    }
    return paramString1.intValue();
  }
  
  private String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("old_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(a(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramBoolean))
    {
      PAGView localPAGView = (PAGView)paramView;
      if (localPAGView.getFile() != null)
      {
        a().a();
        return true;
      }
      if (a(localPAGView, this.jdField_b_of_type_JavaLangString, paramString2, paramString1))
      {
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramInt1);
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int);
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int;
        paramLayoutParams.width = AIOUtils.b(jdField_a_of_type_Int, paramView.getResources());
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
          int i = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int;
          if (i == -1)
          {
            paramString1 = "????";
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append(i);
            paramString1.append("");
            paramString1 = paramString1.toString();
          }
          paramString3.text = paramString1;
          paramPAGView.setTextData(0, paramString3);
        }
        paramPAGView.setFile(paramString2);
        paramPAGView.setRepeatCount(-1);
        paramPAGView.play();
        return true;
      }
      return false;
    }
    QQValueInfoManage.a().c(paramString1);
    return false;
  }
  
  private int b(String paramString1, String paramString2)
  {
    paramString1 = (Integer)jdField_a_of_type_JavaUtilMap.get(b(paramString1, paramString2));
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.intValue();
  }
  
  private String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("old_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_Trend");
    return localStringBuilder.toString();
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(b(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem;
    if (localObject != null)
    {
      if (!((QQValueInfoItem)localObject).jdField_a_of_type_Boolean) {
        return false;
      }
      removeAllViews();
      localObject = new TextView(getContext());
      if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int == -1)
      {
        ((TextView)localObject).setBackgroundDrawable(getResources().getDrawable(2130850638));
      }
      else
      {
        ((TextView)localObject).setBackgroundDrawable(getResources().getDrawable(2130850648));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      ((TextView)localObject).setPadding(30, 0, 0, 9);
      ((TextView)localObject).setTextSize(11.0F);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextScaleX(0.9F);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
      addView((View)localObject, AIOUtils.b(jdField_a_of_type_Int, ((TextView)localObject).getResources()), AIOUtils.b(jdField_b_of_type_Int, ((TextView)localObject).getResources()));
      return true;
    }
    return false;
  }
  
  private boolean c()
  {
    return (this.jdField_c_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int) || (b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString) != 0) || ((this.jdField_a_of_type_JavaLangString == "setting") && (this.jdField_b_of_type_JavaLangString != this.jdField_c_of_type_JavaLangString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (getContext() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem = QQValueInfoManage.a().a(paramString2);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_b_of_type_JavaLangString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_b_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem = QQValueInfoManage.a().a(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem;
    if ((paramString1 != null) && (paramString1.d != 1) && (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int >= -1) && (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_b_of_type_Int != 0))
    {
      setVisibility(0);
      QQValueInfoManage.a().a(paramString2, this);
      if ((paramString2 == "card") && (this.jdField_c_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int)) {
        return;
      }
      if (paramBoolean) {
        setForeground(new ColorDrawable(1996488704));
      } else {
        setForeground(null);
      }
      if (b()) {
        return;
      }
      a().b(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      if (!a())
      {
        a().a();
        return;
      }
      a().b();
      return;
    }
    setVisibility(8);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.jdField_c_of_type_JavaLangString.equals(paramString)) {
        a(paramString, this.jdField_a_of_type_JavaLangString, paramBoolean);
      }
    }
    else {
      post(new QQValuePagView.2(this, paramString, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView
 * JD-Core Version:    0.7.0.1
 */