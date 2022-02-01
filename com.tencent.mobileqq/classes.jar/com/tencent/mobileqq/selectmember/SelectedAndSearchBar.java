package com.tencent.mobileqq.selectmember;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectedAndSearchBar
  extends RelativeLayout
  implements DecodeTaskCompletionListener
{
  private View a;
  private CustomGridView b;
  private EditText c;
  private ImageView d;
  private ImageView e;
  private CustomHorizontalScrollView f;
  private float g;
  private List<ResultRecord> h = new ArrayList();
  private SelectedAndSearchBar.GridViewAdapter i;
  private IFaceDecoder j;
  private Context k;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback l;
  private boolean m;
  private final ResultRecord.DefaultComparator n = new ResultRecord.DefaultComparator();
  private IQQGuildService o;
  private int p;
  
  public SelectedAndSearchBar(Context paramContext)
  {
    super(paramContext);
    f();
    g();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
    g();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
    g();
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  private void f()
  {
    this.a = LayoutInflater.from(getContext()).inflate(2131629276, this);
    this.b = ((CustomGridView)this.a.findViewById(2131445556));
    this.c = ((EditText)this.a.findViewById(2131445437));
    this.d = ((ImageView)this.a.findViewById(2131435634));
    this.e = ((ImageView)this.a.findViewById(2131445432));
    this.f = ((CustomHorizontalScrollView)this.a.findViewById(2131445370));
    AccessibilityUtil.a(this.f, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.f.setOverScrollMode(2);
      this.b.setOverScrollMode(2);
    }
    this.b.setOnItemClickListener(new SelectedAndSearchBar.1(this));
    this.c.setOnKeyListener(new SelectedAndSearchBar.2(this));
    this.c.addTextChangedListener(new SelectedAndSearchBar.3(this));
    this.c.setOnFocusChangeListener(new SelectedAndSearchBar.4(this));
  }
  
  private void g()
  {
    this.g = getResources().getDisplayMetrics().density;
    this.k = getContext();
  }
  
  public void a(long paramLong)
  {
    int i1 = a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -i1, 0 });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new SelectedAndSearchBar.7(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(new SelectedAndSearchBar.5(this, paramOnClickListener));
  }
  
  public void a(List<ResultRecord> paramList, IFaceDecoder paramIFaceDecoder, SelectedAndSearchBar.ISelectedAndSearchBarCallback paramISelectedAndSearchBarCallback)
  {
    if (paramList != null) {
      this.h = paramList;
    }
    this.j = paramIFaceDecoder;
    this.l = paramISelectedAndSearchBarCallback;
    this.i = new SelectedAndSearchBar.GridViewAdapter(this);
    this.b.setAdapter(this.i);
    this.b.setSmoothScrollbarEnabled(false);
    this.j.setDecodeTaskCompletionListener(this);
  }
  
  public void a(List<ResultRecord> paramList, IFaceDecoder paramIFaceDecoder, SelectedAndSearchBar.ISelectedAndSearchBarCallback paramISelectedAndSearchBarCallback, IQQGuildService paramIQQGuildService)
  {
    this.o = paramIQQGuildService;
    a(paramList, paramIFaceDecoder, paramISelectedAndSearchBarCallback);
  }
  
  public void a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    Collections.sort(paramList, this.n);
    this.h = paramList;
    a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setNumColumns(this.h.size());
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    localLayoutParams.width = ((int)((this.h.size() * 40 + this.h.size() * 10) * this.g));
    this.b.setLayoutParams(localLayoutParams);
    e();
    if (paramBoolean) {
      postDelayed(new SelectedAndSearchBar.6(this), 200L);
    }
    this.i.notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.c.hasFocus();
  }
  
  public void b()
  {
    this.c.setText("");
  }
  
  public void b(long paramLong)
  {
    int i1 = a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -i1 });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new SelectedAndSearchBar.8(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void c()
  {
    this.c.clearFocus();
  }
  
  public void d()
  {
    this.f.scrollTo(this.b.getLayoutParams().width, 0);
  }
  
  public void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.g * 40.0F));
    float f1 = this.g;
    int i1 = (int)(40.0F * f1);
    int i2 = (int)(f1 * 10.0F);
    if (this.h.size() > 0)
    {
      if (this.h.size() < 5)
      {
        f1 = this.h.size() * 40 + this.h.size() * 10;
        float f2 = this.g;
        i1 = (int)(f1 * f2) + (int)(f2 * 10.0F);
      }
      else
      {
        i1 = (int)(this.g * 230.0F);
      }
      this.e.setVisibility(8);
    }
    else
    {
      this.e.setVisibility(0);
    }
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(i1, 0, i2, 0);
    this.c.setLayoutParams(localLayoutParams);
  }
  
  public Editable getEditTextContent()
  {
    return this.c.getText();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.b == null) {
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < this.b.getChildCount())
    {
      View localView = this.b.getChildAt(paramInt1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof ResultRecord)))
      {
        localObject = (ResultRecord)localObject;
        if ((paramString.equals(((ResultRecord)localObject).uin)) && (((ResultRecord)localObject).type == paramInt2)) {
          ((ImageView)localView.findViewById(2131432714)).setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void setIsFrom(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar
 * JD-Core Version:    0.7.0.1
 */