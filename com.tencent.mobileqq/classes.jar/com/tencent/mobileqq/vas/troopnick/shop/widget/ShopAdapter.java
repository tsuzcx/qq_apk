package com.tencent.mobileqq.vas.troopnick.shop.widget;

import QC.CGetChiefRsp;
import QC.ItemDisDetail;
import QC.ModuleData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ShopAdapter
  extends RecyclerView.Adapter<ShopAdapter.BgHolder>
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ShopAdapter.Callback jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$Callback;
  private ShopAdapter.DataItem jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem;
  private ShopLayout.ShopSetting jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$ShopSetting;
  private ArrayList<ShopAdapter.DataItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private ShopAdapter.DataItem b;
  
  public ShopAdapter(Context paramContext)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130847824;
    case 0: 
    case 1: 
      return 2130847823;
    case 4: 
      return 2130847828;
    case 5: 
      return 2130847827;
    case 21: 
      return 2130847826;
    }
    return 2130847825;
  }
  
  private Drawable a(String paramString, boolean paramBoolean)
  {
    int i = 14606046;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!paramString.contains("#")) {
        str = "#" + paramString;
      }
      i = Color.parseColor(str);
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847837) });
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(ViewUtils.b(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a(paramInt), 0);
  }
  
  private void a(ShopAdapter.BgHolder paramBgHolder, int paramInt, ShopAdapter.DataItem paramDataItem)
  {
    paramBgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramDataItem.jdField_a_of_type_JavaLangString);
    if (paramBgHolder.b != null) {
      paramBgHolder.b.setText(paramDataItem.jdField_b_of_type_JavaLangString);
    }
    View localView = paramBgHolder.itemView.findViewById(2131378634);
    if (localView != null)
    {
      if (TextUtils.isEmpty(paramDataItem.jdField_b_of_type_JavaLangString)) {
        localView.setVisibility(8);
      }
    }
    else
    {
      paramDataItem = paramBgHolder.itemView.findViewById(2131365917);
      if (paramDataItem != null)
      {
        if (paramInt <= 1) {
          break label134;
        }
        paramDataItem.setVisibility(0);
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramBgHolder.c.getBackground().setTint(Color.parseColor("#FFDE66"));
      }
      paramBgHolder.c.setOnClickListener(new ShopAdapter.1(this));
      return;
      localView.setVisibility(0);
      break;
      label134:
      paramDataItem.setVisibility(8);
    }
  }
  
  private void a(ShopAdapter.DataItem paramDataItem)
  {
    notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$ShopSetting != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$ShopSetting.a(paramDataItem.jdField_c_of_type_Int, paramDataItem.jdField_b_of_type_Int);
    }
  }
  
  public ShopAdapter.BgHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 1: 
      return new ShopAdapter.BgHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562220, null));
    }
    paramViewGroup = new ShopAdapter.BgHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562222, null));
    paramViewGroup.jdField_a_of_type_Boolean = true;
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) && (((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int == paramInt))
        {
          this.jdField_a_of_type_Int = paramInt;
          this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem = ((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(ShopAdapter.BgHolder paramBgHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)) {}
    ShopAdapter.DataItem localDataItem;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramBgHolder, paramInt, getItemId(paramInt));
        return;
        localDataItem = (ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localDataItem.jdField_a_of_type_Int != 2) {
          break;
        }
        a(paramBgHolder, paramInt, localDataItem);
      }
    } while (!((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
    paramBgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localDataItem.e);
    boolean bool;
    if (this.jdField_a_of_type_Int == localDataItem.jdField_b_of_type_Int)
    {
      bool = true;
      label109:
      paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(a(localDataItem.jdField_d_of_type_JavaLangString, bool));
      if (localDataItem.jdField_a_of_type_Boolean)
      {
        paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131691921);
        paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramBgHolder.jdField_a_of_type_AndroidWidgetButton.getResources().getColor(2131165501));
      }
      int i = (ScreenUtil.getRealWidth(this.jdField_a_of_type_AndroidContentContext) - ScreenUtil.dip2px(96.0F)) / 3;
      ViewGroup.LayoutParams localLayoutParams = paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = ((int)(i * 0.57F));
      paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(VasApngFactory.a(localDataItem.jdField_c_of_type_JavaLangString));
      a(paramBgHolder.jdField_a_of_type_AndroidWidgetTextView, localDataItem.jdField_d_of_type_Int);
      if (localDataItem.jdField_a_of_type_Boolean) {
        break label299;
      }
      paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ShopAdapter.ItemOnClickListener(this, localDataItem, true));
    }
    for (;;)
    {
      paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setOnClickListener(new ShopAdapter.ItemOnClickListener(this, localDataItem, false));
      break;
      bool = false;
      break label109;
      label299:
      paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
    }
  }
  
  public void a(ShopAdapter.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$Callback = paramCallback;
  }
  
  public void a(ShopLayout.ShopSetting paramShopSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$ShopSetting = paramShopSetting;
  }
  
  @UiThread
  public void a(Object[] paramArrayOfObject)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramArrayOfObject == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof CGetChiefRsp))
      {
        localObject = (CGetChiefRsp)localObject;
        if ((((CGetChiefRsp)localObject).ret == 0) && (((CGetChiefRsp)localObject).modData != null) && (((CGetChiefRsp)localObject).modData.size() > 0))
        {
          Iterator localIterator1 = ((CGetChiefRsp)localObject).modData.iterator();
          while (localIterator1.hasNext())
          {
            ModuleData localModuleData = (ModuleData)localIterator1.next();
            localObject = "";
            if (localModuleData.extModParams != null) {
              localObject = (String)localModuleData.extModParams.get("subTitle");
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(new ShopAdapter.DataItem(this, 2, localModuleData.cname, (String)localObject));
            if (this.jdField_a_of_type_Boolean) {
              ReportHelper.a(2, 0, 0, 111);
            }
            if ((localModuleData.vitem != null) && (localModuleData.vitem.size() != 0))
            {
              Iterator localIterator2 = localModuleData.vitem.iterator();
              while (localIterator2.hasNext())
              {
                ItemDisDetail localItemDisDetail = (ItemDisDetail)localIterator2.next();
                this.jdField_a_of_type_JavaUtilArrayList.add(new ShopAdapter.DataItem(this, 0, localModuleData.cname, (String)localObject, localItemDisDetail));
                if (this.jdField_a_of_type_Boolean) {
                  ReportHelper.a(2, localItemDisDetail.itemId, localItemDisDetail.feeType, 101);
                }
              }
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter
 * JD-Core Version:    0.7.0.1
 */