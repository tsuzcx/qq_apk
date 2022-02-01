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
import azzl;
import azzm;
import azzt;
import azzu;
import azzx;
import azzy;
import azzz;
import baae;
import baaf;
import bdla;
import bheg;
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
  private azzz jdField_a_of_type_Azzz;
  public QQAppInterface a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private List<azzl> jdField_a_of_type_JavaUtilList = new ArrayList();
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
    this.jdField_a_of_type_Azzz = new azzz(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    int i = AIOUtils.dp2px(12.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new baaf(i, 0));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azzz);
    e();
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new azzx(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new azzy(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables() != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      azzt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    return bheg.a();
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
    this.jdField_a_of_type_Int = ((int)(Math.random() * azzm.a.length));
  }
  
  public void a(List<azzl> paramList)
  {
    c();
    a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Azzz.notifyDataSetChanged();
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
      azzu.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 1);
      bdla.b(null, "dc00898", "", "", "0X800B46C", "0X800B46C", 0, 0, "", "", "", "");
      continue;
      f();
      azzu.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2);
      bdla.b(null, "dc00898", "", "", "0X800B46C", "0X800B46C", 0, 0, "", "", "", "");
      continue;
      f();
      azzu.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      bdla.b(null, "dc00898", "", "", "0X800B46D", "0X800B46D", 0, 0, "", "", "", "");
      continue;
      f();
      azzu.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 3);
      bdla.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B473", "0X800B473", 0, 0, "", "", "", "");
      continue;
      f();
      azzu.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 6);
      bdla.b(null, "dc00898", "", "", "0X800B472", "0X800B472", 0, 0, "", "", "", "");
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
        if (!(localObject instanceof baae)) {
          break label123;
        }
        i = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {}
      }
      else
      {
        return;
      }
      azzl localazzl = (azzl)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localazzl != null) && (localazzl.c == Long.parseLong(paramString)) && (paramBitmap != null)) {
        ((baae)localObject).d.setImageBitmap(paramBitmap);
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