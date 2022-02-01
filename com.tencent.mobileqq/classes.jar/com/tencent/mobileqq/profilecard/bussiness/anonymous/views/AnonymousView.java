package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ayup;
import ayuq;
import ayux;
import ayuy;
import ayvb;
import ayvc;
import ayvd;
import ayvi;
import ayvj;
import bcef;
import bfvo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AnonymousView
  extends ProfileContentTitleView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int;
  public RecyclerView a;
  private ayvd jdField_a_of_type_Ayvd;
  public QQAppInterface a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private List<ayup> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public AnonymousView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnonymousView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_Ayvd = new ayvd(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    int i = AIOUtils.dp2px(12.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new ayvj(i, 0));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ayvd);
    e();
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new ayvb(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new ayvc(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables() != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      ayux.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public Bitmap a(long paramLong)
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, String.valueOf(paramLong));
      if (localBitmap != null) {
        return localBitmap;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(String.valueOf(paramLong), 200, true);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return bfvo.a();
  }
  
  public void a()
  {
    super.a();
    d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getContext(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Int = ((int)(Math.random() * ayuq.a.length));
  }
  
  public void a(List<ayup> paramList)
  {
    c();
    a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Ayvd.notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      f();
      ayuy.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 1);
      bcef.b(null, "dc00898", "", "", "", "0X800B46C", 0, 0, "", "", "", "");
      continue;
      f();
      ayuy.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2);
      bcef.b(null, "dc00898", "", "", "", "0X800B46C", 0, 0, "", "", "", "");
      continue;
      f();
      ayuy.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      bcef.b(null, "dc00898", "", "", "", "0X800B46D", 0, 0, "", "", "", "");
      continue;
      f();
      ayuy.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 3);
      bcef.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "", "0X800B473", 0, 0, "", "", "", "");
      continue;
      f();
      ayuy.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 6);
      bcef.b(null, "dc00898", "", "", "", "0X800B472", 0, 0, "", "", "", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      Object localObject;
      int i;
      if (paramInt1 < paramInt2)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt1);
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if (!(localObject instanceof ayvi)) {
          break label123;
        }
        i = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {}
      }
      else
      {
        return;
      }
      ayup localayup = (ayup)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localayup != null) && (localayup.c == Long.parseLong(paramString)) && (paramBitmap != null)) {
        ((ayvi)localObject).d.setImageBitmap(paramBitmap);
      }
      label123:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView
 * JD-Core Version:    0.7.0.1
 */