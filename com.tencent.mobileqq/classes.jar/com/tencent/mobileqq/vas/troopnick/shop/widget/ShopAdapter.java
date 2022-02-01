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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRelativeLayout;
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
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 21)
          {
            if (paramInt != 22) {
              return 2130847691;
            }
            return 2130847692;
          }
          return 2130847693;
        }
        return 2130847694;
      }
      return 2130847695;
    }
    return 2130847690;
  }
  
  private Drawable a(String paramString, boolean paramBoolean)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramString;
      if (!paramString.contains("#"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      i = Color.parseColor((String)localObject);
    }
    else
    {
      i = 14606046;
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847704) });
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
    View localView = paramBgHolder.itemView.findViewById(2131378026);
    if (localView != null) {
      if (TextUtils.isEmpty(paramDataItem.jdField_b_of_type_JavaLangString)) {
        localView.setVisibility(8);
      } else {
        localView.setVisibility(0);
      }
    }
    paramDataItem = paramBgHolder.itemView.findViewById(2131365754);
    if (paramDataItem != null) {
      if (paramInt > 1) {
        paramDataItem.setVisibility(0);
      } else {
        paramDataItem.setVisibility(8);
      }
    }
    if (Build.VERSION.SDK_INT >= 21) {
      paramBgHolder.c.getBackground().setTint(Color.parseColor("#FFDE66"));
    }
    paramBgHolder.c.setOnClickListener(new ShopAdapter.1(this));
  }
  
  private void a(ShopAdapter.DataItem paramDataItem)
  {
    notifyDataSetChanged();
    ShopLayout.ShopSetting localShopSetting = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout$ShopSetting;
    if (localShopSetting != null) {
      localShopSetting.a(paramDataItem.jdField_c_of_type_Int, paramDataItem.jdField_b_of_type_Int);
    }
  }
  
  private boolean a(ModuleData paramModuleData, String paramString)
  {
    if (paramModuleData.extModParams != null) {
      paramString = (String)paramModuleData.extModParams.get("subTitle");
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ShopAdapter.DataItem(this, 2, paramModuleData.cname, paramString));
    if (this.jdField_a_of_type_Boolean) {
      ReportHelper.a(2, 0, 0, 111);
    }
    if ((paramModuleData.vitem != null) && (paramModuleData.vitem.size() != 0))
    {
      Iterator localIterator = paramModuleData.vitem.iterator();
      while (localIterator.hasNext())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(new ShopAdapter.DataItem(this, 0, paramModuleData.cname, paramString, localItemDisDetail));
        if (this.jdField_a_of_type_Boolean) {
          ReportHelper.a(2, localItemDisDetail.itemId, localItemDisDetail.feeType, 101);
        }
      }
      return false;
    }
    return true;
  }
  
  public ShopAdapter.BgHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2) {
        return null;
      }
      paramViewGroup = new ShopAdapter.BgHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562059, null));
      paramViewGroup.jdField_a_of_type_Boolean = true;
      return paramViewGroup;
    }
    return new ShopAdapter.BgHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562057, null));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
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
  
  public void a(ShopAdapter.BgHolder paramBgHolder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).get(paramInt) != null))
    {
      localObject = (ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (((ShopAdapter.DataItem)localObject).jdField_a_of_type_Int == 2)
      {
        a(paramBgHolder, paramInt, (ShopAdapter.DataItem)localObject);
      }
      else if (((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a())
      {
        paramBgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((ShopAdapter.DataItem)localObject).e);
        boolean bool;
        if (this.jdField_a_of_type_Int == ((ShopAdapter.DataItem)localObject).jdField_b_of_type_Int) {
          bool = true;
        } else {
          bool = false;
        }
        paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setBackgroundDrawable(a(((ShopAdapter.DataItem)localObject).jdField_d_of_type_JavaLangString, bool));
        if (((ShopAdapter.DataItem)localObject).jdField_a_of_type_Boolean)
        {
          paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131691849);
          paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramBgHolder.jdField_a_of_type_AndroidWidgetButton.getResources().getColor(2131165477));
        }
        int i = (ScreenUtil.getRealWidth(this.jdField_a_of_type_AndroidContentContext) - ScreenUtil.dip2px(96.0F)) / 3;
        ViewGroup.LayoutParams localLayoutParams = paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.width = i;
        localLayoutParams.height = ((int)(i * 0.57F));
        paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(((ShopAdapter.DataItem)localObject).jdField_c_of_type_JavaLangString));
        a(paramBgHolder.jdField_a_of_type_AndroidWidgetTextView, ((ShopAdapter.DataItem)localObject).jdField_d_of_type_Int);
        if (!((ShopAdapter.DataItem)localObject).jdField_a_of_type_Boolean) {
          paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ShopAdapter.ItemOnClickListener(this, (ShopAdapter.DataItem)localObject, true));
        } else {
          paramBgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
        }
        paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setOnClickListener(new ShopAdapter.ItemOnClickListener(this, (ShopAdapter.DataItem)localObject, false));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBgHolder, paramInt, getItemId(paramInt));
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (paramArrayOfObject == null) {
        return;
      }
      ((ArrayList)localObject).clear();
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfObject[i];
        if ((localObject instanceof CGetChiefRsp))
        {
          localObject = (CGetChiefRsp)localObject;
          if ((((CGetChiefRsp)localObject).ret == 0) && (((CGetChiefRsp)localObject).modData != null) && (((CGetChiefRsp)localObject).modData.size() > 0))
          {
            localObject = ((CGetChiefRsp)localObject).modData.iterator();
            while (((Iterator)localObject).hasNext()) {
              if (!a((ModuleData)((Iterator)localObject).next(), "")) {
                this.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
        i += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ShopAdapter.DataItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter
 * JD-Core Version:    0.7.0.1
 */