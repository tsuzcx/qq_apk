package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Typeface;
import android.widget.TextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManagerForTool;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class TroopNickFontAdapter
  extends SignatureFontAdapter
{
  public static Map<String, Typeface> a;
  private static int b = 0;
  WeakReference<TextView> a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public TroopNickFontAdapter(TextView paramTextView, VasRes paramVasRes, AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramVasRes, paramAppRuntime, paramInt);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTextView);
  }
  
  public static Typeface a(int paramInt1, int paramInt2)
  {
    return (Typeface)jdField_a_of_type_JavaUtilMap.get(a(paramInt1, paramInt2));
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + "_" + paramInt2;
  }
  
  private boolean a(Typeface paramTypeface)
  {
    if (paramTypeface == null) {
      return false;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTextView == null) {
      return true;
    }
    localTextView.post(new TroopNickFontAdapter.2(this, localTextView, paramTypeface));
    return true;
  }
  
  public void b()
  {
    if (AppUtil.a()) {}
    for (FontInfo localFontInfo = a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);; localFontInfo = FontManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int))
    {
      if (localFontInfo != null)
      {
        b(localFontInfo.jdField_a_of_type_Int, localFontInfo.b);
        c();
        if (QLog.isColorLevel()) {
          QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_load," + b);
        }
      }
      return;
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    ThreadManagerV2.executeOnFileThread(new TroopNickFontAdapter.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter
 * JD-Core Version:    0.7.0.1
 */