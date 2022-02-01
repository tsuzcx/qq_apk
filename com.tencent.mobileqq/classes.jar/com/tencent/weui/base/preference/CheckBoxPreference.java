package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class CheckBoxPreference
  extends Preference
{
  private boolean a = false;
  private MMSwitchBtn b;
  private TextView c;
  private int d = -1;
  private String e = "";
  private int f = 8;
  private View g;
  
  public CheckBoxPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(2131625448);
  }
  
  public boolean isChecked()
  {
    MMSwitchBtn localMMSwitchBtn = this.b;
    if (localMMSwitchBtn != null) {
      return localMMSwitchBtn.isCheck();
    }
    return this.a;
  }
  
  public void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.b = ((MMSwitchBtn)paramView.findViewById(2131430688));
    this.b.setSwitchListener(new CheckBoxPreference.1(this));
    this.b.setCheck(this.a);
    if (!isEnabled())
    {
      this.b.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131165571));
    }
    this.c = ((TextView)paramView.findViewById(2131447418));
    setTipIcon(this.e, this.d);
    setTipIconVisible(this.f);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131431322);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2131625459, localViewGroup);
    this.g = paramViewGroup;
    return this.g;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setTipIcon(String paramString, int paramInt)
  {
    this.d = paramInt;
    this.e = paramString;
    paramString = this.c;
    if (paramString != null)
    {
      if (paramInt > 0) {
        paramString.setBackgroundResource(this.d);
      }
      if (!TextUtils.isEmpty(this.e)) {
        this.c.setText(this.e);
      }
    }
  }
  
  public void setTipIconVisible(int paramInt)
  {
    this.f = paramInt;
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setVisibility(this.f);
    }
  }
  
  public void updateCheckStatus(boolean paramBoolean)
  {
    MMSwitchBtn localMMSwitchBtn = this.b;
    if (localMMSwitchBtn != null)
    {
      this.a = paramBoolean;
      localMMSwitchBtn.setCheck(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */