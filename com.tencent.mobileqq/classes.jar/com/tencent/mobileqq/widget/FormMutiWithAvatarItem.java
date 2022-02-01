package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class FormMutiWithAvatarItem
  extends FormMutiItem
{
  protected OverlappingImgLayout o;
  protected TextView p;
  protected CharSequence q;
  protected int r = 2;
  protected LinearLayout s;
  
  public FormMutiWithAvatarItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMutiWithAvatarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  private void e()
  {
    this.s = new LinearLayout(getContext());
    this.s.setId(2131433630);
    this.s.setOrientation(0);
    this.s.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131433631);
    localLayoutParams.addRule(15);
    addView(this.s, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131433629);
    localLayoutParams.addRule(0, 2131433630);
    localLayoutParams.addRule(15);
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public boolean b()
  {
    OverlappingImgLayout localOverlappingImgLayout = this.o;
    return (localOverlappingImgLayout != null) && (localOverlappingImgLayout.getChildCount() != 0);
  }
  
  public void setOverimgLayout(int paramInt1, int paramInt2, String[] paramArrayOfString, IFaceDecoder paramIFaceDecoder)
  {
    this.o.a(paramInt1, paramInt2, paramArrayOfString, paramIFaceDecoder);
  }
  
  public void setOverloading()
  {
    this.p = new TextView(getContext());
    this.p.setSingleLine(true);
    this.p.setTextColor(FormResHelper.a(getResources(), this.r));
    int i = getResources().getDimensionPixelSize(2131297104);
    this.p.setTextSize(0, i);
    this.p.setGravity(21);
    this.p.setEllipsize(TextUtils.TruncateAt.END);
    this.p.setDuplicateParentStateEnabled(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(getContext(), 5.0F));
    this.s.addView(this.p, localLayoutParams);
    this.o = new OverlappingImgLayout(getContext());
    this.o.setGravity(21);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(getContext(), 12.0F));
    this.s.addView(this.o, localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("FormMutiWithAvatarItem", 2, "setOverloading, run ");
    }
  }
  
  public void setPeopleText(String paramString)
  {
    this.q = paramString;
    this.p.setText(this.q);
  }
  
  public void setPeopleTextColor(int paramInt)
  {
    this.r = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiWithAvatarItem
 * JD-Core Version:    0.7.0.1
 */