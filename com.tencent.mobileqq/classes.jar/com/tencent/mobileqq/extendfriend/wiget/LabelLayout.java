package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import arqz;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class LabelLayout
  extends LinearLayout
{
  public LabelLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LabelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LabelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
  }
  
  public int a(int paramInt1, List<arqz> paramList, boolean paramBoolean, int paramInt2)
  {
    removeAllViews();
    int j = ViewUtils.dpToPx(12.0F);
    int k = ViewUtils.dpToPx(1.0F);
    int m = ViewUtils.dpToPx(8.0F);
    int n = ViewUtils.dpToPx(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(ViewUtils.dpToPx(paramInt2));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    arqz localarqz;
    if (i < i1)
    {
      localarqz = (arqz)paramList.get(i);
      if (TextUtils.isEmpty(localarqz.jdField_a_of_type_JavaLangCharSequence)) {
        break label366;
      }
      int i2 = (int)(((Paint)localObject).measureText(localarqz.jdField_a_of_type_JavaLangCharSequence.toString()) + m * 2);
      if (paramInt1 >= i2 + n)
      {
        localArrayList.add(localarqz);
        paramInt1 = paramInt1 - i2 - n;
      }
    }
    label366:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localarqz);
      }
      i = localArrayList.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject = (arqz)localArrayList.get(paramInt1);
        paramList = new LabelTextView(getContext());
        paramList.setParam(((arqz)localObject).jdField_a_of_type_Int, ((arqz)localObject).b, j);
        paramList.setTextSize(paramInt2);
        paramList.setText(((arqz)localObject).jdField_a_of_type_JavaLangCharSequence);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt1 != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt1 += 1;
      }
      if (paramBoolean)
      {
        addView(new View(getContext()), 0, new LinearLayout.LayoutParams(0, 0, 1.0F));
        addView(new View(getContext()), getChildCount(), new LinearLayout.LayoutParams(0, 0, 1.0F));
      }
      return localArrayList.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.LabelLayout
 * JD-Core Version:    0.7.0.1
 */