package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.subtitles.AnimDrawerFactory;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.SubtitleDataManagerListener;
import com.tencent.mobileqq.richmedia.capture.adapter.SubtitleProviderGridAdapter;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem.FontItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubtitleProviderView
  extends ProviderView
  implements SubtitleDataManager.SubtitleDataManagerListener, AdapterView.OnItemClickListener
{
  public static final int a;
  public static final int b = AIOUtils.a(12.0F, BaseApplication.getContext().getResources());
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SubtitleProviderGridAdapter jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Int = AIOUtils.a(64.0F, BaseApplication.getContext().getResources());
  }
  
  public SubtitleProviderView(Context paramContext)
  {
    super(paramContext);
    SubtitleDataManager.a().a(true);
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = new SubtitleItem();
    ((SubtitleItem)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = SubtitleDataManager.a().a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.notifyDataSetChanged();
    }
  }
  
  protected int a()
  {
    return 2130970595;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter != null)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
      int i = j;
      if (i <= k)
      {
        if (i < 0) {}
        SubtitleItem localSubtitleItem;
        do
        {
          i += 1;
          break;
          localSubtitleItem = (SubtitleItem)this.jdField_a_of_type_JavaUtilList.get(i);
        } while ((localSubtitleItem == null) || (localSubtitleItem.jdField_a_of_type_Int != paramInt1) || (!localSubtitleItem.b));
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleProviderView", 2, "onProgressUpdate index: " + i + " progress: " + paramInt2);
        }
        View localView = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.b(localSubtitleItem, localView);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter != null)
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
          paramString = (SubtitleItem)this.jdField_a_of_type_JavaUtilList.get(i);
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
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.a(paramString, localView);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.b(paramString, localView);
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.jdField_a_of_type_Int == paramInt1) && (paramString.b()))
      {
        paramString.b = false;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null)
        {
          if (paramString.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.f);
        }
      }
      return;
      label221:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.a(paramString, localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.a(paramString.jdField_a_of_type_Int, null);
  }
  
  public void a(Bundle paramBundle)
  {
    setNeedTabBar(false);
    super.a(paramBundle);
    SubtitleDataManager.a().a(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130970595, this, false));
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter = new SubtitleProviderGridAdapter(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      if (SubtitleDataManager.a().a() == 2) {
        c();
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(0);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter == null)) {}
    do
    {
      return;
      paramAdapterView = (SubtitleItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.jdField_a_of_type_Int = paramAdapterView.jdField_a_of_type_Int;
    if (paramAdapterView.jdField_a_of_type_Int != 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X8008757", "0X8008757", 0, 0, "", "", "", "");
      CaptureReportUtil.a(AnimDrawerFactory.a(paramAdapterView.jdField_a_of_type_Int));
      if (paramAdapterView.b())
      {
        paramAdapterView.b = false;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener;
          paramInt = paramAdapterView.jdField_a_of_type_Int;
          if (paramAdapterView.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem != null) {
            break label177;
          }
          paramAdapterView = null;
          paramView.a(paramInt, paramAdapterView);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.notifyDataSetChanged();
      return;
      label177:
      paramAdapterView = paramAdapterView.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.f;
      break;
      paramAdapterView.b = true;
      SubtitleDataManager.a().a(paramAdapterView.c, paramAdapterView.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.a(paramAdapterView.jdField_a_of_type_Int, null);
      }
    }
  }
  
  public void ak_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterSubtitleProviderGridAdapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    SubtitleDataManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SubtitleProviderView
 * JD-Core Version:    0.7.0.1
 */