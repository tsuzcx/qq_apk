package com.tencent.mobileqq.richmedia.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PtvTemplateAdapter
  extends BaseAdapter
  implements Observer
{
  float jdField_a_of_type_Float;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private PtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$IPtvTemplateItemCallback = new PtvTemplateAdapter.1(this);
  CapturePtvTemplateManager jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager;
  private TemplateGroupItem jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem;
  private ProviderView.ProviderViewListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new PtvTemplateAdapter.2(this);
  public PtvTemplateManager.PtvTemplateInfo a;
  GridView jdField_a_of_type_ComTencentWidgetGridView;
  public String a;
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> a;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public PtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, GridView paramGridView, ProviderView.ProviderViewListener paramProviderViewListener, TemplateGroupItem paramTemplateGroupItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager = CapturePtvTemplateManager.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem = paramTemplateGroupItem;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void b(int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo1 = CapturePtvTemplateManager.a().a();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo2 = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localPtvTemplateInfo2 != null) && (localPtvTemplateInfo1 != null) && (localPtvTemplateInfo1.id.equals(localPtvTemplateInfo2.id)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "checkChooseFilter  name=" + localPtvTemplateInfo1.name);
      }
      if ((localPtvTemplateInfo1.usable) || (!localPtvTemplateInfo1.downloading)) {
        a(paramInt);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    this.jdField_b_of_type_Int = paramInt;
    CapturePtvTemplateManager.a().a(localPtvTemplateInfo);
    if (!localPtvTemplateInfo.id.equals("0"))
    {
      CapturePtvTemplateManager localCapturePtvTemplateManager = CapturePtvTemplateManager.a();
      localCapturePtvTemplateManager.a(localPtvTemplateInfo, 111);
      localCapturePtvTemplateManager.a(3, localPtvTemplateInfo.categoryId, localPtvTemplateInfo.id);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = localPtvTemplateInfo;
    CapturePtvTemplateManager.a().a(114, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals("0")))
    {
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.a(localPtvTemplateInfo, this.jdField_a_of_type_JavaLangString);
      }
      CapturePtvTemplateManager.a().a(null);
      CapturePtvTemplateManager.a().a(113, null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
    {
      this.jdField_a_of_type_JavaLangString = CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener.a(localPtvTemplateInfo, this.jdField_a_of_type_JavaLangString);
      }
      CapturePtvTemplateManager.a().a(113, null);
    }
    for (;;)
    {
      SharedPreUtils.a();
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
      }
    }
  }
  
  public void a(List<PtvTemplateManager.PtvTemplateInfo> paramList, int paramInt)
  {
    int i = 0;
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Int = paramInt;
      paramInt = i;
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      while (paramInt < this.jdField_a_of_type_Int)
      {
        localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        localPtvTemplateInfo.categoryId = 0;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        paramInt += 1;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramList.next();
        if ((this.jdField_a_of_type_Boolean) || (!localPtvTemplateInfo.advertisement)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        }
      }
      notifyDataSetChanged();
    }
    finally {}
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PtvTemplateItemView localPtvTemplateItemView;
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      localPtvTemplateItemView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      localPtvTemplateItemView.a();
    }
    for (;;)
    {
      localPtvTemplateItemView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$IPtvTemplateItemCallback);
      if (!this.jdField_b_of_type_Boolean) {
        b(paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localPtvTemplateItemView;
      localPtvTemplateItemView = (PtvTemplateItemView)paramView;
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        a(((TemplateGroupItem)paramVarArgs[0]).a, 1);
        notifyDataSetChanged();
      }
      return;
      break label66;
    }
    label66:
    do
    {
      for (;;)
      {
        if (paramInt == 112) {
          if ((paramVarArgs != null) && (paramVarArgs.length == 1))
          {
            paramObject = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs[0];
            paramVarArgs = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (paramVarArgs.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
              if (!paramObject.id.equals(localPtvTemplateInfo.id)) {
                break;
              }
              localPtvTemplateInfo.downloading = false;
              localPtvTemplateInfo.usable = true;
              notifyDataSetChanged();
              return;
            }
          }
        }
      }
    } while (paramInt != 113);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */