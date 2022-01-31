package com.tencent.mobileqq.minigame.jsapi.widgets;

import alud;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyboardLayout
  extends RelativeLayout
{
  private static final String TAG = "KeyboardLayout";
  private Button mConfirmBT;
  private boolean mConfirmHold;
  private EditText mInputET;
  
  public KeyboardLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    this.mInputET = new EditText(getContext());
    this.mConfirmBT = new Button(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.leftMargin = DpUtil.dip2px(getContext(), 4.0F);
    localLayoutParams.rightMargin = DpUtil.dip2px(getContext(), 2.0F);
    localLayoutParams.topMargin = DpUtil.dip2px(getContext(), 2.0F);
    this.mConfirmBT.setText(alud.a(2131706335));
    this.mConfirmBT.setTextColor(-1);
    this.mConfirmBT.setBackgroundResource(2130840786);
    this.mConfirmBT.setMinHeight(0);
    this.mConfirmBT.setMinimumHeight(0);
    this.mConfirmBT.setPadding(DpUtil.dip2px(getContext(), 10.0F), DpUtil.dip2px(getContext(), 5.0F), DpUtil.dip2px(getContext(), 10.0F), DpUtil.dip2px(getContext(), 5.0F));
    addView(this.mConfirmBT, localLayoutParams);
    this.mConfirmBT.setId(2131370583);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(0, this.mConfirmBT.getId());
    localLayoutParams.leftMargin = DpUtil.dip2px(getContext(), 4.0F);
    this.mInputET.setBackgroundResource(2130840789);
    addView(this.mInputET, localLayoutParams);
    setBackgroundColor(-1);
    setPadding(0, DpUtil.dip2px(getContext(), 5.0F), 0, DpUtil.dip2px(getContext(), 2.0F));
  }
  
  public Button getConfirmBT()
  {
    return this.mConfirmBT;
  }
  
  public EditText getInputET()
  {
    return this.mInputET;
  }
  
  public boolean isConfirmHold()
  {
    return this.mConfirmHold;
  }
  
  public void setPaddingBottom(int paramInt)
  {
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), paramInt);
  }
  
  public void setParam(String paramString)
  {
    boolean bool1 = true;
    if (!TextUtils.isEmpty(paramString)) {
      label282:
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
          paramString = alud.a(2131706334);
          if ("send".equals(str))
          {
            i = 4;
            paramString = alud.a(2131706333);
            this.mInputET.setText((CharSequence)localObject);
            if (j >= 0)
            {
              this.mInputET.setFilters(new InputFilter[] { new InputFilter.LengthFilter(j) });
              localObject = this.mInputET;
              if (bool3) {
                break label282;
              }
              ((EditText)localObject).setSingleLine(bool1);
              this.mInputET.setImeOptions(0x10000000 | i | 0x2000000);
              this.mInputET.setSelection(this.mInputET.getText().length());
              this.mConfirmHold = bool2;
              this.mConfirmBT.setText(paramString);
            }
          }
          else
          {
            if ("search".equals(str))
            {
              i = 3;
              paramString = alud.a(2131706336);
              continue;
            }
            if ("next".equals(str))
            {
              i = 5;
              paramString = alud.a(2131706332);
              continue;
            }
            if (!"go".equals(str)) {
              continue;
            }
            i = 2;
            paramString = alud.a(2131706331);
            continue;
          }
          this.mInputET.setFilters(new InputFilter[0]);
          continue;
          bool1 = false;
        }
        catch (JSONException paramString)
        {
          GameLog.getInstance().e("KeyboardLayout", "setParam exception", paramString);
          return;
        }
      }
    }
    GameLog.getInstance().e("KeyboardLayout", "setParam no param ?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout
 * JD-Core Version:    0.7.0.1
 */