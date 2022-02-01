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
  protected Bitmap a;
  
  public ShareWithPictureActionSheetBuilder(Context paramContext)
  {
    super(paramContext, false);
  }
  
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562838, null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$AdViewManager.a((RelativeLayout)localView.findViewById(2131362261));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361994));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    else
    {
      hideTitle();
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377008));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377009));
    Object localObject2 = a();
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
    ((TextPaint)localObject4).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299101));
    Object localObject3 = new StaticLayout(a((TextPaint)localObject4, this.e, a((List)localObject1), 5), (TextPaint)localObject4, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
    localObject4 = new StaticLayout(a((TextPaint)localObject4, this.e, a((List)localObject2), 5), (TextPaint)localObject4, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
    if (((StaticLayout)localObject3).getHeight() < ((StaticLayout)localObject4).getHeight()) {
      localObject3 = localObject4;
    }
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296795);
    int n;
    if (bool1)
    {
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367811));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject4).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility == 0) {
          i += 1;
        }
      }
      n = this.d + getIconWidth() + this.d;
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(n);
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
      localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (this.h + i * n + this.h);
      this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.c + this.f + ((StaticLayout)localObject3).getHeight() + m);
      this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    if (bool2)
    {
      this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367812));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
      localObject1 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext()) {
        if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility == 0) {
          i += 1;
        }
      }
      n = this.d + getIconWidth() + this.d;
      this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(n);
      this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
      localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
      this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject1).width = (this.h + n * i + this.h);
      this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
      ((ViewGroup.LayoutParams)localObject1).height = (this.c + this.f + ((StaticLayout)localObject3).getHeight() + m);
      this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
      this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
      this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    Object localObject1 = (TextView)localView.findViewById(2131361986);
    ((TextView)localObject1).setText(2131690728);
    ((TextView)localObject1).setOnClickListener(new ShareWithPictureActionSheetBuilder.1(this));
    if (!bool1) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    if (!bool2) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    localView.post(new ShareWithPictureActionSheetBuilder.2(this));
    int j = ViewUtils.a(90.0F);
    int i = j;
    if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
      i = j + this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().height;
    }
    j = i;
    if (this.jdField_b_of_type_AndroidWidgetGridView != null) {
      j = i + this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams().height;
    }
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    localObject1 = (RelativeLayout)localView.findViewById(2131377385);
    localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    i -= j;
    ((ViewGroup.LayoutParams)localObject2).height = i;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      m = ViewUtils.a(20.0F);
      j = i - ViewUtils.a(30.0F) * 2;
      i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * j / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      k -= m * 2;
      if (i > k)
      {
        j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * k / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        i = k;
      }
      localObject1 = (ImageView)localView.findViewById(2131377384);
      localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = j;
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    return localView;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */