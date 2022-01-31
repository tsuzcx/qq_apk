package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import armv;
import arsg;
import bcvq;
import blmf;
import blrz;
import blst;
import blsx;
import bmss;
import bmst;
import bmsu;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;

public class EditTextPanel
  extends RelativeLayout
  implements arsg
{
  public static String a;
  int jdField_a_of_type_Int = -1;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private blsx jdField_a_of_type_Blsx = new bmss(this);
  bmsu jdField_a_of_type_Bmsu;
  public EditTextEffectView a;
  int b = -1;
  int c;
  int d = 0;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditTextPanel";
  }
  
  public EditTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView = new EditTextEffectView(paramContext, this);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView, paramContext);
  }
  
  private void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    if (this.jdField_a_of_type_Bmsu != null) {
      this.jdField_a_of_type_Bmsu.a(paramDynamicTextConfigBean, paramInt);
    }
  }
  
  public int a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.a(paramInt);
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.a(paramInt);
      postDelayed(new EditTextPanel.1(this, paramInt), 200L);
      this.c = paramInt;
      this.jdField_a_of_type_Int = paramInt;
    }
    return paramInt;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt1, int paramInt2)
  {
    try
    {
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.a(paramInt2);
      return localDynamicTextConfigBean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "getSelectedItem" + paramInt1 + " " + this.c + "itemPosition=" + paramInt2);
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "selectItem position = " + paramInt2);
    }
    DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = a(paramInt1, paramInt2);
    if (localDynamicTextConfigBean != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      }
      a(localDynamicTextConfigBean, paramInt2);
    }
    for (;;)
    {
      this.c = paramInt2;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "cancelChoose");
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onItemClick position = " + paramInt1);
    }
    this.d = paramInt1;
    DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = a(paramInt2, paramInt1);
    if (localDynamicTextConfigBean != null) {
      if (!AppSetting.c) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        bcvq.a(paramView, blst.a(localDynamicTextConfigBean.text_id, 0));
        DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)blmf.a(7);
        blrz localblrz = (blrz)blmf.a(14);
        if (localDynamicTextConfigBean != null) {
          localblrz.a(String.valueOf(localDynamicTextConfigBean.text_id), 5);
        }
        if (localDynamicTextConfigManager.a(localDynamicTextConfigBean))
        {
          a(paramInt2, paramInt1);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        if (NetConnInfoCenter.isMobileConn())
        {
          armv.a(paramView.getContext(), 2131698576, 2131698575, new bmst(this, localException, localDynamicTextConfigBean));
          return;
        }
        localException.a(localDynamicTextConfigBean, this.jdField_a_of_type_Blsx);
        return;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onItemClick item null");
  }
  
  public void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.setEditPhoto(paramBoolean);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.a();
    }
  }
  
  public void setOpIn(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.setOpIn(paramInt);
    }
  }
  
  public void setPanelListener(bmsu parambmsu)
  {
    this.jdField_a_of_type_Bmsu = parambmsu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel
 * JD-Core Version:    0.7.0.1
 */