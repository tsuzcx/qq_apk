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
  protected int a = -1;
  private ArrayList<ShopAdapter.DataItem> b = new ArrayList();
  private ShopLayout.ShopSetting c;
  private Context d;
  private ShopAdapter.DataItem e;
  private ShopAdapter.DataItem f;
  private ShopAdapter.Callback g;
  private boolean h = true;
  
  public ShopAdapter(Context paramContext)
  {
    this.d = paramContext;
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
    return new LayerDrawable(new Drawable[] { paramString, this.d.getResources().getDrawable(2130849364) });
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, b(paramInt), 0);
  }
  
  private void a(ShopAdapter.BgHolder paramBgHolder, int paramInt, ShopAdapter.DataItem paramDataItem)
  {
    paramBgHolder.a.setText(paramDataItem.a);
    if (paramBgHolder.g != null) {
      paramBgHolder.g.setText(paramDataItem.c);
    }
    View localView = paramBgHolder.itemView.findViewById(2131446525);
    if (localView != null) {
      if (TextUtils.isEmpty(paramDataItem.c)) {
        localView.setVisibility(8);
      } else {
        localView.setVisibility(0);
      }
    }
    paramDataItem = paramBgHolder.itemView.findViewById(2131431997);
    if (paramDataItem != null) {
      if (paramInt > 1) {
        paramDataItem.setVisibility(0);
      } else {
        paramDataItem.setVisibility(8);
      }
    }
    if (Build.VERSION.SDK_INT >= 21) {
      paramBgHolder.h.getBackground().setTint(Color.parseColor("#FFDE66"));
    }
    paramBgHolder.h.setOnClickListener(new ShopAdapter.1(this));
  }
  
  private void a(ShopAdapter.DataItem paramDataItem)
  {
    notifyDataSetChanged();
    ShopLayout.ShopSetting localShopSetting = this.c;
    if (localShopSetting != null) {
      localShopSetting.a(paramDataItem.f, paramDataItem.e);
    }
  }
  
  private boolean a(ModuleData paramModuleData, String paramString)
  {
    if (paramModuleData.extModParams != null) {
      paramString = (String)paramModuleData.extModParams.get("subTitle");
    }
    this.b.add(new ShopAdapter.DataItem(this, 2, paramModuleData.cname, paramString));
    if (this.h) {
      ReportHelper.a(2, 0, 0, 111);
    }
    if ((paramModuleData.vitem != null) && (paramModuleData.vitem.size() != 0))
    {
      Iterator localIterator = paramModuleData.vitem.iterator();
      while (localIterator.hasNext())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)localIterator.next();
        this.b.add(new ShopAdapter.DataItem(this, 0, paramModuleData.cname, paramString, localItemDisDetail));
        if (this.h) {
          ReportHelper.a(2, localItemDisDetail.itemId, localItemDisDetail.feeType, 101);
        }
      }
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
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
              return 2130849351;
            }
            return 2130849352;
          }
          return 2130849353;
        }
        return 2130849354;
      }
      return 2130849355;
    }
    return 2130849350;
  }
  
  public ShopAdapter.BgHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2) {
        return null;
      }
      paramViewGroup = new ShopAdapter.BgHolder(this, View.inflate(this.d, 2131628485, null));
      paramViewGroup.f = true;
      return paramViewGroup;
    }
    return new ShopAdapter.BgHolder(this, View.inflate(this.d, 2131628483, null));
  }
  
  public void a(int paramInt)
  {
    this.a = -1;
    if (this.b == null) {
      return;
    }
    int i = 0;
    while (i < this.b.size())
    {
      if ((((ShopAdapter.DataItem)this.b.get(i)).a()) && (((ShopAdapter.DataItem)this.b.get(i)).e == paramInt))
      {
        this.a = paramInt;
        this.e = ((ShopAdapter.DataItem)this.b.get(i));
        notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  public void a(ShopAdapter.BgHolder paramBgHolder, int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((ArrayList)localObject).get(paramInt) != null))
    {
      localObject = (ShopAdapter.DataItem)this.b.get(paramInt);
      if (((ShopAdapter.DataItem)localObject).b == 2)
      {
        a(paramBgHolder, paramInt, (ShopAdapter.DataItem)localObject);
      }
      else if (((ShopAdapter.DataItem)this.b.get(paramInt)).a())
      {
        paramBgHolder.a.setText(((ShopAdapter.DataItem)localObject).j);
        boolean bool;
        if (this.a == ((ShopAdapter.DataItem)localObject).e) {
          bool = true;
        } else {
          bool = false;
        }
        paramBgHolder.c.setBackgroundDrawable(a(((ShopAdapter.DataItem)localObject).i, bool));
        if (((ShopAdapter.DataItem)localObject).d)
        {
          paramBgHolder.e.setText(2131888814);
          paramBgHolder.e.setTextColor(paramBgHolder.e.getResources().getColor(2131165798));
        }
        int i = (ScreenUtil.getRealWidth(this.d) - ScreenUtil.dip2px(96.0F)) / 3;
        ViewGroup.LayoutParams localLayoutParams = paramBgHolder.b.getLayoutParams();
        localLayoutParams.width = i;
        localLayoutParams.height = ((int)(i * 0.57F));
        paramBgHolder.b.setLayoutParams(localLayoutParams);
        paramBgHolder.b.setImageDrawable(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(((ShopAdapter.DataItem)localObject).h));
        a(paramBgHolder.a, ((ShopAdapter.DataItem)localObject).g);
        if (!((ShopAdapter.DataItem)localObject).d) {
          paramBgHolder.e.setOnClickListener(new ShopAdapter.ItemOnClickListener(this, (ShopAdapter.DataItem)localObject, true));
        } else {
          paramBgHolder.e.setOnClickListener(null);
        }
        paramBgHolder.c.setOnClickListener(new ShopAdapter.ItemOnClickListener(this, (ShopAdapter.DataItem)localObject, false));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBgHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(ShopAdapter.Callback paramCallback)
  {
    this.g = paramCallback;
  }
  
  public void a(ShopLayout.ShopSetting paramShopSetting)
  {
    this.c = paramShopSetting;
  }
  
  @UiThread
  public void a(Object[] paramArrayOfObject)
  {
    Object localObject = this.b;
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
                this.h = false;
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
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ShopAdapter.DataItem)this.b.get(paramInt)).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter
 * JD-Core Version:    0.7.0.1
 */