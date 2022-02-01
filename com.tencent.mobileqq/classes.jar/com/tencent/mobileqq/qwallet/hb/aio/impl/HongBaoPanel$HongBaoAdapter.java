package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

class HongBaoPanel$HongBaoAdapter
  extends RecyclerView.Adapter<HongBaoPanel.MyViewHolder>
{
  private HongBaoPanel.OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener;
  private List<PanelData> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  HongBaoPanel$HongBaoAdapter(HongBaoPanel paramHongBaoPanel) {}
  
  public HongBaoPanel.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    HongBaoPanel localHongBaoPanel = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel;
    return new HongBaoPanel.MyViewHolder(localHongBaoPanel, LayoutInflater.from(localHongBaoPanel.jdField_a_of_type_AndroidContentContext).inflate(R.layout.c, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener);
  }
  
  public PanelData a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (PanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List<PanelData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(HongBaoPanel.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
        return;
      }
      localObject1 = (PanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel;
      Object localObject3 = paramMyViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      String str = ((PanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
      int i;
      if (HongBaoPanel.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel).equals("#5B6175")) {
        i = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel.jdField_a_of_type_AndroidContentContext.getResources().getColor(R.color.j);
      } else {
        i = Color.parseColor(HongBaoPanel.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel));
      }
      HongBaoPanel.a((HongBaoPanel)localObject2, (TextView)localObject3, str, i, 0);
      paramMyViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(R.drawable.m);
      if (!StringUtil.a(((PanelData)localObject1).c))
      {
        paramMyViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(((PanelData)localObject1).c);
        localObject2 = HongBaoPanel.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel, paramInt, ((PanelData)localObject1).c, paramMyViewHolder.jdField_a_of_type_AndroidWidgetImageView);
        if ((localObject2 != null) && (((RedPacketInfo)localObject2).icon != null)) {
          paramMyViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((RedPacketInfo)localObject2).icon);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService.getShowInfo(((PanelData)localObject1).jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = paramMyViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
          if (((IQWalletRedService.ShowInfo)localObject1).jdField_a_of_type_Boolean) {
            paramInt = 0;
          } else {
            paramInt = 8;
          }
          ((RelativeLayout)localObject2).setVisibility(paramInt);
          if (((IQWalletRedService.ShowInfo)localObject1).b)
          {
            paramMyViewHolder.b.setVisibility(0);
            try
            {
              localObject2 = new ColorDrawable(0);
              ((Drawable)localObject2).setAlpha(0);
              localObject3 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
              localObject1 = URLDrawable.getDrawable(((IQWalletRedService.ShowInfo)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
              paramMyViewHolder.b.setImageDrawable((Drawable)localObject1);
              return;
            }
            catch (Throwable paramMyViewHolder)
            {
              paramMyViewHolder.printStackTrace();
              return;
            }
          }
          paramMyViewHolder.b.setVisibility(8);
        }
      }
    }
  }
  
  public void a(HongBaoPanel.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener = paramOnHolderItemClickListener;
  }
  
  public void a(List<PanelData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.HongBaoAdapter
 * JD-Core Version:    0.7.0.1
 */