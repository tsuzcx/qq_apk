package com.tencent.qqmini.sdk.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyboardLayout
  extends RelativeLayout
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private boolean jdField_a_of_type_Boolean;
  
  public KeyboardLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = new EditText(getContext());
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 4.0F);
    localLayoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    localLayoutParams.topMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694344);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840887);
    this.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
    this.jdField_a_of_type_AndroidWidgetButton.setMinimumHeight(0);
    this.jdField_a_of_type_AndroidWidgetButton.setPadding(DisplayUtil.dip2px(getContext(), 10.0F), DisplayUtil.dip2px(getContext(), 5.0F), DisplayUtil.dip2px(getContext(), 10.0F), DisplayUtil.dip2px(getContext(), 5.0F));
    addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131370583);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(0, this.jdField_a_of_type_AndroidWidgetButton.getId());
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 4.0F);
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(2130840890);
    addView(this.jdField_a_of_type_AndroidWidgetEditText, localLayoutParams);
    setBackgroundColor(-1);
    setPadding(0, DisplayUtil.dip2px(getContext(), 5.0F), 0, DisplayUtil.dip2px(getContext(), 2.0F));
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setPaddingBottom(int paramInt)
  {
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), paramInt);
  }
  
  public void setParam(String paramString)
  {
    boolean bool1 = true;
    if (!TextUtils.isEmpty(paramString)) {
      label298:
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          Object localObject = paramString.optString("defaultValue", "");
          int j = paramString.optInt("maxLength", -1);
          boolean bool3 = paramString.optBoolean("multiple", false);
          boolean bool2 = paramString.optBoolean("confirmHold", false);
          String str = paramString.optString("confirmType");
          int i = 6;
          paramString = getResources().getText(2131694344);
          if ("send".equals(str))
          {
            i = 4;
            paramString = getResources().getText(2131694346);
            this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
            if (j >= 0)
            {
              this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(j) });
              localObject = this.jdField_a_of_type_AndroidWidgetEditText;
              if (bool3) {
                break label298;
              }
              ((EditText)localObject).setSingleLine(bool1);
              this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(0x10000000 | i | 0x2000000);
              this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
              this.jdField_a_of_type_Boolean = bool2;
              this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
            }
          }
          else
          {
            if ("search".equals(str))
            {
              i = 3;
              paramString = getResources().getText(2131694345);
              continue;
            }
            if ("next".equals(str))
            {
              i = 5;
              paramString = getResources().getText(2131694343);
              continue;
            }
            if (!"go".equals(str)) {
              continue;
            }
            i = 2;
            paramString = getResources().getText(2131694342);
            continue;
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[0]);
          continue;
          bool1 = false;
        }
        catch (JSONException paramString)
        {
          QMLog.e("KeyboardLayout", "setParam exception", paramString);
          return;
        }
      }
    }
    QMLog.e("KeyboardLayout", "setParam no param ?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.KeyboardLayout
 * JD-Core Version:    0.7.0.1
 */