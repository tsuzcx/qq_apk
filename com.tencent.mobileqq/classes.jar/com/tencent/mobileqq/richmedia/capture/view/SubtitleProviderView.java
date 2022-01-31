package com.tencent.mobileqq.richmedia.capture.view;

import aciy;
import ahlk;
import ahmp;
import ahmr;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import ausg;
import aute;
import autf;
import auts;
import auwc;
import awqx;
import behi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubtitleProviderView
  extends ProviderView
  implements ahmr, behi
{
  public static final int a;
  public static final int b = aciy.a(12.0F, BaseApplication.getContext().getResources());
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ausg jdField_a_of_type_Ausg;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private List<aute> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Int = aciy.a(64.0F, BaseApplication.getContext().getResources());
  }
  
  public SubtitleProviderView(Context paramContext)
  {
    super(paramContext);
    ahmp.a().a(true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = new aute();
    ((aute)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = ahmp.a().a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    if (this.jdField_a_of_type_Ausg != null) {
      this.jdField_a_of_type_Ausg.notifyDataSetChanged();
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ausg != null)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
      int i = j;
      if (i <= k)
      {
        if (i < 0) {}
        aute localaute;
        do
        {
          i += 1;
          break;
          localaute = (aute)this.jdField_a_of_type_JavaUtilList.get(i);
        } while ((localaute == null) || (localaute.jdField_a_of_type_Int != paramInt1) || (!localaute.b));
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleProviderView", 2, "onProgressUpdate index: " + i + " progress: " + paramInt2);
        }
        View localView = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
        this.jdField_a_of_type_Ausg.b(localaute, localView);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    View localView;
    if (this.jdField_a_of_type_Ausg != null)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
      int i = j;
      if (i <= k)
      {
        if (i < 0) {}
        do
        {
          i += 1;
          break;
          paramString = (aute)this.jdField_a_of_type_JavaUtilList.get(i);
          localView = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
          if (paramString != null) {
            paramString.b = false;
          }
        } while ((paramString == null) || (paramString.jdField_a_of_type_Int != paramInt1));
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleProviderView", 2, "onDownloadResult index: " + i);
        }
        if (paramInt2 != 0) {
          break label221;
        }
        this.jdField_a_of_type_Ausg.a(paramString, localView);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ausg.b(paramString, localView);
      if ((this.jdField_a_of_type_Ausg != null) && (this.jdField_a_of_type_Ausg.jdField_a_of_type_Int == paramInt1) && (paramString.b()))
      {
        paramString.b = false;
        if (this.jdField_a_of_type_Auwc != null)
        {
          if (paramString.jdField_a_of_type_Autf == null) {
            break;
          }
          this.jdField_a_of_type_Auwc.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Autf.f);
        }
      }
      return;
      label221:
      this.jdField_a_of_type_Ausg.a(paramString, localView);
    }
    this.jdField_a_of_type_Auwc.a(paramString.jdField_a_of_type_Int, null);
  }
  
  public void a(Bundle paramBundle)
  {
    setNeedTabBar(false);
    super.a(paramBundle);
    ahmp.a().a(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131495452, this, false));
    }
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentWidgetGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetGridView);
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(-1);
    this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(jdField_a_of_type_Int);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - b * 2;
    int i = j / jdField_a_of_type_Int;
    j -= jdField_a_of_type_Int * i;
    if (j > 0)
    {
      i = j / (i - 1);
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(i);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(b);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(b, b, b, b);
      this.jdField_a_of_type_ComTencentWidgetGridView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetGridView.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetGridView.setClickable(false);
      this.jdField_a_of_type_Ausg = new ausg(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Ausg.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Ausg.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(this.jdField_a_of_type_Ausg);
      this.jdField_a_of_type_Ausg.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      if (ahmp.a().a() == 2) {
        b();
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(0);
    }
  }
  
  public void aO_()
  {
    if (this.jdField_a_of_type_Ausg != null) {
      this.jdField_a_of_type_Ausg.notifyDataSetChanged();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_Ausg == null)) {}
    do
    {
      return;
      paramAdapterView = (aute)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Ausg.jdField_a_of_type_Int = paramAdapterView.jdField_a_of_type_Int;
    if (paramAdapterView.jdField_a_of_type_Int != 0)
    {
      awqx.b(null, "dc00898", "", "", "0X8008757", "0X8008757", 0, 0, "", "", "", "");
      auts.a(ahlk.a(paramAdapterView.jdField_a_of_type_Int));
      if (paramAdapterView.b())
      {
        paramAdapterView.b = false;
        if (this.jdField_a_of_type_Auwc != null)
        {
          paramView = this.jdField_a_of_type_Auwc;
          paramInt = paramAdapterView.jdField_a_of_type_Int;
          if (paramAdapterView.jdField_a_of_type_Autf != null) {
            break label177;
          }
          paramAdapterView = null;
          paramView.a(paramInt, paramAdapterView);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ausg.notifyDataSetChanged();
      return;
      label177:
      paramAdapterView = paramAdapterView.jdField_a_of_type_Autf.f;
      break;
      paramAdapterView.b = true;
      ahmp.a().a(paramAdapterView.c, paramAdapterView.jdField_a_of_type_Autf);
      continue;
      if (this.jdField_a_of_type_Auwc != null) {
        this.jdField_a_of_type_Auwc.a(paramAdapterView.jdField_a_of_type_Int, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SubtitleProviderView
 * JD-Core Version:    0.7.0.1
 */