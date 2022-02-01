package com.tencent.mobileqq.widget.participle;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ParticipleBottomMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private ParticipleView a;
  private int b;
  private int c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ParticipleBottomMenuView.OnMenuClickListener h;
  
  public ParticipleBottomMenuView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ParticipleBottomMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ParticipleBottomMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2131625559, this, true);
    this.d = ((ImageView)findViewById(2131439842));
    this.e = ((ImageView)findViewById(2131439846));
    this.f = ((ImageView)findViewById(2131439844));
    this.g = ((ImageView)findViewById(2131439848));
    this.d.setContentDescription(a(HardCodeUtil.a(2131905709)));
    this.e.setContentDescription(a(HardCodeUtil.a(2131905713)));
    this.f.setContentDescription(a(HardCodeUtil.a(2131905712)));
    this.g.setContentDescription(a(HardCodeUtil.a(2131905710)));
    TextView localTextView = (TextView)findViewById(2131448633);
    findViewById(2131439843).setOnClickListener(this);
    findViewById(2131439847).setOnClickListener(this);
    findViewById(2131439845).setOnClickListener(this);
    findViewById(2131439849).setOnClickListener(this);
    localTextView.setOnClickListener(this);
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cb);
      this.b = paramContext.getInteger(R.styleable.cd, 0);
      this.c = paramContext.getInteger(R.styleable.cc, 200);
      paramContext.recycle();
    }
    int i = this.b;
    paramAttributeSet = "#000000";
    if (i == 1) {
      paramContext = "#000000";
    } else {
      paramContext = "#e6ffffff";
    }
    setBackgroundColor(Color.parseColor(paramContext));
    paramContext = paramAttributeSet;
    if (this.b == 1) {
      paramContext = "#ffffff";
    }
    localTextView.setTextColor(Color.parseColor(paramContext));
    a();
  }
  
  public String a(String paramString)
  {
    return getContext().getString(2131887628, new Object[] { paramString });
  }
  
  public void a()
  {
    ParticipleView localParticipleView = this.a;
    if ((localParticipleView != null) && (!TextUtils.isEmpty(localParticipleView.getSelectedParticiple())))
    {
      if (this.b == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_BLACK");
        }
        this.d.setBackgroundResource(2130847233);
        this.e.setBackgroundResource(2130847258);
        this.f.setBackgroundResource(2130847239);
        this.g.setBackgroundResource(2130847271);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.d.setBackgroundResource(2130847230);
      this.e.setBackgroundResource(2130847245);
      this.f.setBackgroundResource(2130847236);
      this.g.setBackgroundResource(2130847251);
      return;
    }
    if (this.b == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.d.setBackgroundResource(2130847231);
      this.e.setBackgroundResource(2130847246);
      this.f.setBackgroundResource(2130847237);
      this.g.setBackgroundResource(2130847248);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.d.setBackgroundResource(2130847232);
    this.e.setBackgroundResource(2130847247);
    this.f.setBackgroundResource(2130847238);
    this.g.setBackgroundResource(2130847252);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.a = paramParticipleView;
    this.a.setOnParticipleSelectChangeListener(new ParticipleBottomMenuView.1(this));
  }
  
  public void b()
  {
    a();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(this.c);
    setAlpha(0.0F);
    setVisibility(0);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    if (this.h != null) {
      if (paramView.getId() == 2131448633)
      {
        this.h.a();
        ReportController.b(null, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
      }
      else
      {
        Object localObject = this.a;
        if (localObject != null)
        {
          localObject = ((ParticipleView)localObject).getSelectedParticiple();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (paramView.getId() == 2131439843)
            {
              this.h.a((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            }
            else if (paramView.getId() == 2131439845)
            {
              this.h.c((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            }
            else if (paramView.getId() == 2131439847)
            {
              this.h.b((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            }
            else if (paramView.getId() == 2131439849)
            {
              this.h.d((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            }
          }
          else {
            QQToast.makeText(BaseApplication.getContext(), -1, HardCodeUtil.a(2131905708), 0).show();
          }
        }
        else
        {
          QQToast.makeText(getContext(), HardCodeUtil.a(2131905711), 0).show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnMenuClickListener(ParticipleBottomMenuView.OnMenuClickListener paramOnMenuClickListener)
  {
    this.h = paramOnMenuClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */