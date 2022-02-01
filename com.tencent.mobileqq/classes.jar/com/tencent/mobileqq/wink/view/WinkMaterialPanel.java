package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.R.styleable;
import java.util.List;

public class WinkMaterialPanel
  extends LinearLayout
{
  private LinearLayout a;
  private RecyclerView b;
  private RecyclerView c;
  private ImageView d;
  private LinearLayoutManager e;
  private WinkMaterialPanelCategoryAdapter f;
  private WinkMaterialPanelContentAdapter g;
  private WinkMaterialPanel.CategoryItemListener h;
  private List<MetaCategory> i;
  private List<MetaMaterial> j;
  private boolean k;
  
  public WinkMaterialPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WinkMaterialPanel(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WinkMaterialPanel(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(@Nullable AttributeSet paramAttributeSet)
  {
    setOrientation(1);
    this.a = new LinearLayout(getContext());
    this.a.setOrientation(0);
    this.a.setGravity(16);
    this.d = new ImageView(getContext());
    int m = DisplayUtil.a(getContext(), 6.0F);
    this.d.setPadding(m, m, m, m);
    m = DisplayUtil.a(getContext(), 32.0F);
    Object localObject = new LinearLayout.LayoutParams(m, m);
    ((LinearLayout.LayoutParams)localObject).setMargins(DisplayUtil.a(getContext(), 14.0F), 0, 0, 0);
    this.a.addView(this.d, (ViewGroup.LayoutParams)localObject);
    setClearButtonEnable(false);
    this.b = new RecyclerView(getContext());
    this.b.setOverScrollMode(2);
    this.b.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    localObject = (SimpleItemAnimator)this.b.getItemAnimator();
    if (localObject != null) {
      ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    }
    localObject = new LinearLayout.LayoutParams(-1, -2);
    this.a.addView(this.b, (ViewGroup.LayoutParams)localObject);
    addView(this.a, new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 32.0F)));
    this.c = new RecyclerView(getContext());
    this.c.setOverScrollMode(2);
    this.e = new LinearLayoutManager(getContext(), 0, false);
    this.e.setAutoMeasureEnabled(false);
    this.c.setLayoutManager(this.e);
    localObject = (SimpleItemAnimator)this.c.getItemAnimator();
    if (localObject != null) {
      ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    }
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.eU);
      if (paramAttributeSet != null)
      {
        m = paramAttributeSet.getDimensionPixelSize(R.styleable.eV, 0);
        paramAttributeSet.recycle();
        break label354;
      }
    }
    m = 0;
    label354:
    paramAttributeSet = new LinearLayout.LayoutParams(-1, -2);
    paramAttributeSet.setMargins(0, m, 0, 0);
    addView(this.c, paramAttributeSet);
    this.c.addOnScrollListener(new WinkMaterialPanel.1(this));
  }
  
  public void setCategoryItemListener(WinkMaterialPanel.CategoryItemListener paramCategoryItemListener)
  {
    this.h = paramCategoryItemListener;
  }
  
  public void setCategoryLayoutVisibility(boolean paramBoolean)
  {
    Object localObject = this.a;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    ((LinearLayout)localObject).setVisibility(m);
    localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
    if (localObject != null)
    {
      if (paramBoolean) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 0.0F);
      } else {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 18.0F);
      }
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setClearButtonEnable(boolean paramBoolean)
  {
    if (this.d.isEnabled() == paramBoolean) {
      return;
    }
    this.d.setEnabled(paramBoolean);
    ImageView localImageView = this.d;
    int m;
    if (paramBoolean) {
      m = 2130853648;
    } else {
      m = 2130853649;
    }
    localImageView.setImageResource(m);
  }
  
  public void setOnClearButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void setup(WinkMaterialPanelContentAdapter paramWinkMaterialPanelContentAdapter, @NonNull List<MetaCategory> paramList, @NonNull List<MetaMaterial> paramList1)
  {
    this.g = paramWinkMaterialPanelContentAdapter;
    this.i = paramList;
    this.j = paramList1;
    this.f = new WinkMaterialPanelCategoryAdapter(paramList, new WinkMaterialPanel.2(this));
    this.b.setAdapter(this.f);
    this.g.a(this.j);
    this.c.setAdapter(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanel
 * JD-Core Version:    0.7.0.1
 */