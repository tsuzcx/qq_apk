package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareWithPictureActionSheetBuilder
  extends ShareActionSheetBuilder
{
  protected Bitmap y;
  
  public ShareWithPictureActionSheetBuilder(Context paramContext)
  {
    super(paramContext, false);
  }
  
  protected View a()
  {
    View localView = View.inflate(this.a, 2131629283, null);
    this.u.a((RelativeLayout)localView.findViewById(2131427848));
    this.g = ((TextView)localView.findViewById(2131427554));
    if (this.v)
    {
      this.g.setVisibility(0);
      if (this.l != null) {
        this.g.setText(this.l);
      }
    }
    else
    {
      hideTitle();
    }
    this.e = ((ElasticHorScrView)localView.findViewById(2131445372));
    this.f = ((ElasticHorScrView)localView.findViewById(2131445373));
    Object localObject2 = d();
    if (localObject2.length > 0) {
      localObject1 = localObject2[0];
    } else {
      localObject1 = new ArrayList(0);
    }
    boolean bool1 = ((List)localObject1).isEmpty() ^ true;
    if (localObject2.length > 1) {
      localObject2 = localObject2[1];
    } else {
      localObject2 = new ArrayList(0);
    }
    boolean bool2 = true ^ ((List)localObject2).isEmpty();
    Object localObject4 = new TextPaint();
    ((TextPaint)localObject4).setTextSize(this.a.getResources().getDimensionPixelSize(2131299838));
    Object localObject3 = new StaticLayout(a((TextPaint)localObject4, this.q, a((List)localObject1), 5), (TextPaint)localObject4, this.q, Layout.Alignment.ALIGN_CENTER, 1.0F, this.s, true);
    localObject4 = new StaticLayout(a((TextPaint)localObject4, this.q, a((List)localObject2), 5), (TextPaint)localObject4, this.q, Layout.Alignment.ALIGN_CENTER, 1.0F, this.s, true);
    if (((StaticLayout)localObject3).getHeight() < ((StaticLayout)localObject4).getHeight()) {
      localObject3 = localObject4;
    }
    int m = this.a.getResources().getDimensionPixelOffset(2131297126);
    int n;
    if (bool1)
    {
      this.w = ((GridView)localView.findViewById(2131434386));
      if (Build.VERSION.SDK_INT >= 9) {
        this.e.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject4).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility == 0) {
          i += 1;
        }
      }
      n = this.p + getIconWidth() + this.p;
      this.w.setColumnWidth(n);
      this.w.setNumColumns(i);
      localObject4 = this.w.getLayoutParams();
      this.w.setPadding(this.t, this.w.getPaddingTop(), this.t, this.w.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (this.t + i * n + this.t);
      this.j = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.o + this.r + ((StaticLayout)localObject3).getHeight() + m);
      this.w.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.w.setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.a, (List)localObject1));
      this.w.setSelector(new ColorDrawable(0));
      this.w.setOnItemClickListener(this.b);
    }
    if (bool2)
    {
      this.x = ((GridView)localView.findViewById(2131434387));
      if (Build.VERSION.SDK_INT >= 9) {
        this.f.setOverScrollMode(2);
      }
      this.x.setSmoothScrollbarEnabled(false);
      localObject1 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility == 0) {
          i += 1;
        }
      }
      n = this.p + getIconWidth() + this.p;
      this.x.setColumnWidth(n);
      this.x.setNumColumns(i);
      localObject1 = this.x.getLayoutParams();
      this.x.setPadding(this.t, this.x.getPaddingTop(), this.t, this.x.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject1).width = (this.t + n * i + this.t);
      this.k = ((ViewGroup.LayoutParams)localObject1).width;
      ((ViewGroup.LayoutParams)localObject1).height = (this.o + this.r + ((StaticLayout)localObject3).getHeight() + m);
      this.x.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.x.setNumColumns(i);
      this.x.setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.a, (List)localObject2));
      this.x.setSelector(new ColorDrawable(0));
      this.x.setOnItemClickListener(this.b);
    }
    Object localObject1 = (TextView)localView.findViewById(2131427546);
    ((TextView)localObject1).setText(2131887648);
    ((TextView)localObject1).setOnClickListener(new ShareWithPictureActionSheetBuilder.1(this));
    if (!bool1) {
      this.e.setVisibility(8);
    }
    if (!bool2) {
      this.f.setVisibility(8);
    }
    localView.post(new ShareWithPictureActionSheetBuilder.2(this));
    int j = ViewUtils.dip2px(90.0F);
    int i = j;
    if (this.w != null) {
      i = j + this.w.getLayoutParams().height;
    }
    j = i;
    if (this.x != null) {
      j = i + this.x.getLayoutParams().height;
    }
    int k = this.a.getResources().getDisplayMetrics().widthPixels;
    i = this.a.getResources().getDisplayMetrics().heightPixels;
    localObject1 = (RelativeLayout)localView.findViewById(2131445784);
    localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    i -= j;
    ((ViewGroup.LayoutParams)localObject2).height = i;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if (this.y != null)
    {
      m = ViewUtils.dip2px(20.0F);
      j = i - ViewUtils.dip2px(30.0F) * 2;
      i = this.y.getWidth() * j / this.y.getHeight();
      k -= m * 2;
      if (i > k)
      {
        j = this.y.getHeight() * k / this.y.getWidth();
        i = k;
      }
      localObject1 = (ImageView)localView.findViewById(2131445783);
      localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = j;
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setImageBitmap(this.y);
    }
    return localView;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.y = paramBitmap;
    this.n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */