package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingBaseSection
  extends LinearLayout
{
  private BaseSectionAdapter a;
  private QFormSimpleItem b;
  private LinearLayout c;
  
  public ColorNoteSettingBaseSection(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ColorNoteSettingBaseSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ColorNoteSettingBaseSection(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    inflate(getContext(), 2131624511, this);
    this.b = ((QFormSimpleItem)findViewById(2131445492));
    this.c = ((LinearLayout)findViewById(2131429342));
  }
  
  public void a()
  {
    this.c.removeAllViews();
    Iterator localIterator = this.a.a(getContext()).iterator();
    while (localIterator.hasNext())
    {
      HistoryFormItem localHistoryFormItem = (HistoryFormItem)localIterator.next();
      this.c.addView(localHistoryFormItem);
    }
  }
  
  public void setAdapter(BaseSectionAdapter paramBaseSectionAdapter)
  {
    this.a = paramBaseSectionAdapter;
    this.a.a(new ColorNoteSettingBaseSection.1(this));
  }
  
  public void setBgType(int paramInt)
  {
    QFormSimpleItem localQFormSimpleItem = this.b;
    if (localQFormSimpleItem != null) {
      localQFormSimpleItem.setBgType(paramInt);
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.b.setContentDescription(paramCharSequence);
  }
  
  public void setHeaderOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void setHeaderTitle(CharSequence paramCharSequence)
  {
    this.b.setLeftText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingBaseSection
 * JD-Core Version:    0.7.0.1
 */