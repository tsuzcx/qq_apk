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
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem;
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
    return "old_" + paramString1 + "_" + paramString2;
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(a(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private boolean a(PAGView paramPAGView, String paramString1, String paramString2, String paramString3)
  {
    if (paramPAGView == null) {
      return false;
    }
    File localFile1 = new File(paramString2);
    File localFile2 = new File(paramString3);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQValueInfoManage.a().c(paramString1);
      return false;
    }
    paramString1 = PAGFont.RegisterFont(paramString2);
    paramString2 = PAGFile.Load(paramString3);
    if ((paramString2 == null) || (paramString1 == null)) {
      return false;
    }
    int i;
    if (paramString2.numTexts() > 0)
    {
      paramString3 = paramString2.getTextData(0);
      paramString3.fontFamily = paramString1.fontFamily;
      paramString3.fontStyle = paramString1.fontStyle;
      i = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int;
      if (i != -1) {
        break label152;
      }
    }
    label152:
    for (paramString1 = "????";; paramString1 = i + "")
    {
      paramString3.text = paramString1;
      paramPAGView.setTextData(0, paramString3);
      paramPAGView.setFile(paramString2);
      paramPAGView.setRepeatCount(-1);
      paramPAGView.play();
      return true;
    }
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
    return "old_" + paramString1 + "_" + paramString2 + "_Trend";
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(b(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem == null) || (!this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Boolean)) {
      return false;
    }
    removeAllViews();
    TextView localTextView = new TextView(getContext());
    if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int == -1) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130850712));
    }
    for (;;)
    {
      localTextView.setPadding(30, 0, 0, 9);
      localTextView.setTextSize(11.0F);
      localTextView.setGravity(17);
      localTextView.setTextScaleX(0.9F);
      localTextView.setTextColor(-1);
      localTextView.setTypeface(Typeface.DEFAULT_BOLD);
      addView(localTextView, AIOUtils.a(jdField_a_of_type_Int, localTextView.getResources()), AIOUtils.a(jdField_b_of_type_Int, localTextView.getResources()));
      return true;
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130850722));
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int + "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (getContext() == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem == null) {
        this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem = QQValueInfoManage.a().a(paramString2);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_b_of_type_JavaLangString));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_b_of_type_JavaLangString;
    paramString2 = new StringBuilder((String)localObject);
    if (((String)localObject).contains("?")) {
      paramString2.append("&from=" + paramString1);
    }
    for (;;)
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new Intent(getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", paramString1.getCurrentUin());
      ((Intent)localObject).putExtra("url", paramString2.toString());
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      getContext().startActivity((Intent)localObject);
      return;
      paramString2.append("?from=" + paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem = QQValueInfoManage.a().a(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem == null) || (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.d == 1) || (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int < -1) || (this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_b_of_type_Int == 0)) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      QQValueInfoManage.a().a(paramString2, this);
      if ((paramString2 != "card") || (this.jdField_c_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardBeanQQValueInfoItem.jdField_a_of_type_Int))
      {
        if (paramBoolean) {
          setForeground(new ColorDrawable(1996488704));
        }
        while (!b())
        {
          setStateChangeListener(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
          if (a()) {
            break label154;
          }
          b();
          return;
          setForeground(null);
        }
      }
    }
    label154:
    c();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.jdField_c_of_type_JavaLangString.equals(paramString)) {
        a(paramString, this.jdField_a_of_type_JavaLangString, paramBoolean);
      }
      return;
    }
    post(new QQValuePagView.2(this, paramString, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView
 * JD-Core Version:    0.7.0.1
 */