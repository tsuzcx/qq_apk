package com.tencent.mobileqq.remind.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnEndFlingListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class IosTimepicker
  extends LinearLayout
{
  private static String a = "remind";
  private Context b;
  private ActionSheet c;
  private IosTimepicker.OnTimePickerSelectListener d;
  private String[] e;
  private String[] f;
  private View g = null;
  private Button h = null;
  private TextView i = null;
  private LinearLayout j;
  private WheelView[] k;
  private BaseAdapter[] l;
  private int[] m;
  private long n;
  private long o;
  private int p;
  private int q;
  private IosTimepicker.FormatDataListener r;
  private AdapterView.OnItemSelectedListener s = new IosTimepicker.2(this);
  private VerticalGallery.OnSelectViewDataUpdateListener t = new IosTimepicker.3(this);
  private VerticalGallery.OnEndFlingListener u = new IosTimepicker.4(this);
  
  public IosTimepicker(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }
  
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
  }
  
  @TargetApi(11)
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
  }
  
  private void a()
  {
    if (this.r != null)
    {
      int i2 = this.m.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.m[i1] = this.k[i1].getSelectedItemPosition();
        i1 += 1;
      }
      this.o = this.r.a(this.k, this.m);
    }
    IosTimepicker.OnTimePickerSelectListener localOnTimePickerSelectListener = this.d;
    if (localOnTimePickerSelectListener != null) {
      localOnTimePickerSelectListener.a(this.o);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(20.0F);
        paramView.setTextColor(this.p);
        return;
      }
      paramView = (WheelTextView)paramView;
      paramView.setTextSize(20.0F);
      paramView.setTextColor(this.q);
    }
  }
  
  public void a(Context paramContext, ActionSheet paramActionSheet, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, IosTimepicker.FormatDataListener paramFormatDataListener)
  {
    if ((paramArrayOfBaseAdapter != null) && (paramArrayOfBaseAdapter.length != 0) && (paramArrayOfBaseAdapter.length <= 3))
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
      {
        if (paramArrayOfInt.length == paramArrayOfBaseAdapter.length)
        {
          this.b = paramContext;
          this.c = paramActionSheet;
          this.d = paramOnTimePickerSelectListener;
          this.l = paramArrayOfBaseAdapter;
          this.m = paramArrayOfInt;
          int i4 = paramArrayOfBaseAdapter.length;
          int i3 = paramArrayOfInt.length;
          this.k = new WheelView[i4];
          this.r = paramFormatDataListener;
          int i2 = 0;
          int i1 = 0;
          while (i1 < i4)
          {
            this.k[i1] = new WheelView(this.b);
            i1 += 1;
          }
          paramActionSheet = this.b.getResources();
          this.p = paramActionSheet.getColor(2131168129);
          this.q = paramActionSheet.getColor(2131168054);
          this.e = TimeHelper.b;
          this.f = TimeHelper.c;
          this.g = findViewById(2131435908);
          this.j = ((LinearLayout)findViewById(2131435907));
          this.i = ((TextView)findViewById(2131445540));
          this.h = ((Button)findViewById(2131447373));
          i1 = paramActionSheet.getColor(2131168144);
          findViewById(2131435906).setBackgroundColor(i1);
          findViewById(2131435905).setBackgroundColor(i1);
          this.g.setBackgroundColor(paramActionSheet.getColor(2131168077));
          i1 = paramActionSheet.getColor(2131168143);
          findViewById(2131437231).setBackgroundColor(i1);
          findViewById(2131437214).setBackgroundColor(i1);
          if (paramOnClickListener != null) {
            this.h.setOnClickListener(paramOnClickListener);
          } else {
            this.h.setOnClickListener(new IosTimepicker.1(this));
          }
          if (i4 == 1)
          {
            paramContext = new LinearLayout.LayoutParams(-1, -1);
            this.k[0].setLayoutParams(paramContext);
            this.k[0].setAdapter(this.l[0]);
            i1 = i2;
            if (QLog.isColorLevel())
            {
              paramContext = a;
              paramActionSheet = new StringBuilder();
              paramActionSheet.append("createTimePicker Time :");
              paramActionSheet.append(TimeHelper.d(this.n));
              QLog.d(paramContext, 2, paramActionSheet.toString());
              i1 = i2;
            }
          }
          else
          {
            i1 = 0;
            while (i1 < i4)
            {
              paramOnTimePickerSelectListener = this.k[i1];
              if (i1 == 0) {
                paramContext = new LinearLayout.LayoutParams(paramActionSheet.getDimensionPixelSize(2131299908), -1);
              } else {
                paramContext = new LinearLayout.LayoutParams(paramActionSheet.getDimensionPixelSize(2131299910), -1);
              }
              paramContext.setMargins(0, paramActionSheet.getDimensionPixelSize(2131299913), 0, paramActionSheet.getDimensionPixelSize(2131299911));
              paramOnTimePickerSelectListener.setLayoutParams(paramContext);
              if (i1 != 0)
              {
                paramOnTimePickerSelectListener.setScrollCycle(true);
                paramOnTimePickerSelectListener.setmMaxRotationAngle(80);
                paramOnTimePickerSelectListener.setmMaxSkew(0.1F);
                paramOnTimePickerSelectListener.setNeedTranslate(true);
              }
              i1 += 1;
            }
            i1 = i2;
            if (QLog.isColorLevel())
            {
              paramContext = a;
              paramActionSheet = new StringBuilder();
              paramActionSheet.append("createTimePicker Time :");
              paramActionSheet.append(TimeHelper.d(this.n));
              QLog.d(paramContext, 2, paramActionSheet.toString());
              i1 = i2;
            }
          }
          while (i1 < i3)
          {
            paramContext = this.k[i1];
            this.j.addView(paramContext);
            paramContext.setAdapter(this.l[i1]);
            paramContext.setSelection(this.m[i1], true);
            paramContext.setOnItemSelectedListener(this.s);
            paramContext.setOnSelectViewDataUpdateListener(this.t);
            paramContext.setOnEndFlingListener(this.u);
            i1 += 1;
          }
          a();
          return;
        }
        throw new IllegalArgumentException("selectionPos.length is not equal to adapters.length");
      }
      throw new IllegalArgumentException("selectionPos is null or empty, or its length is larger than 3");
    }
    paramContext = new IllegalArgumentException("adapters is null or empty, or its length is larger than 3");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public long getSetcetTimeInMillis()
  {
    return this.o;
  }
  
  public void setFormatDataListener(IosTimepicker.FormatDataListener paramFormatDataListener)
  {
    this.r = paramFormatDataListener;
  }
  
  public void setMaxDays(int paramInt)
  {
    TimeHelper.a = paramInt;
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMaxDays days = ");
      localStringBuilder.append(TimeHelper.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void setOnTimePickerSelectListener(IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener)
  {
    this.d = paramOnTimePickerSelectListener;
  }
  
  public void setTips(String paramString)
  {
    TextView localTextView = this.i;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */