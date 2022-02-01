package com.tencent.mobileqq.leba.mgr.table;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.leba.business.LebaTableMgrItemBizProxy;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;

public class LebaTableMgrAdpter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  protected LebaTableMgrItemBizProxy a;
  private LebaMgrDataLogic jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic;
  private ItemTouchHelper jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public LebaTableMgrAdpter(Context paramContext, LebaMgrDataLogic paramLebaMgrDataLogic, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845632);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_Int = ViewUtils.a(32.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic = paramLebaMgrDataLogic;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(LebaTableMgrItemBizProxy paramLebaTableMgrItemBizProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy = paramLebaTableMgrItemBizProxy;
  }
  
  public void a(LebaTableMgrAdpter.PluginViewHolder paramPluginViewHolder, LebaMgrViewItem paramLebaMgrViewItem)
  {
    if ((paramLebaMgrViewItem.a == null) || (paramLebaMgrViewItem.a.a == null))
    {
      paramPluginViewHolder.itemView.setEnabled(false);
      paramPluginViewHolder.itemView.setOnLongClickListener(null);
      LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setVisibility(8);
      LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setVisibility(8);
      LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setEnabled(false);
      LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setOnClickListener(null);
      LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setVisibility(8);
      if (AppSetting.d)
      {
        AccessibilityUtil.a(LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder), "", Button.class.getName());
        AccessibilityUtil.a(paramPluginViewHolder.itemView, "", Button.class.getName());
      }
    }
    label171:
    label332:
    label346:
    label477:
    for (;;)
    {
      return;
      paramPluginViewHolder.itemView.setEnabled(true);
      String str;
      Object localObject;
      if ((this.jdField_a_of_type_Boolean) && (paramLebaMgrViewItem.a.a()))
      {
        paramPluginViewHolder.itemView.setOnLongClickListener(new LebaTableMgrAdpter.1(this, paramPluginViewHolder));
        if (!TextUtils.isEmpty(paramLebaMgrViewItem.a.a.strResName)) {
          break label332;
        }
        str = "";
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setVisibility(0);
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setText(str);
        localObject = paramLebaMgrViewItem.a.a.strGridIconUrl;
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label346;
        }
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label226:
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setEnabled(true);
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setVisibility(0);
        if (!paramLebaMgrViewItem.a.a()) {
          break label440;
        }
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setOnClickListener(new LebaTableMgrAdpter.2(this, paramLebaMgrViewItem, paramPluginViewHolder));
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setImageResource(2130850711);
      }
      for (paramLebaMgrViewItem = this.jdField_a_of_type_AndroidContentContext.getString(2131693635);; paramLebaMgrViewItem = this.jdField_a_of_type_AndroidContentContext.getString(2131693634))
      {
        if (!AppSetting.d) {
          break label477;
        }
        AccessibilityUtil.a(LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder), paramLebaMgrViewItem, Button.class.getName());
        AccessibilityUtil.a(paramPluginViewHolder.itemView, str, Button.class.getName());
        return;
        paramPluginViewHolder.itemView.setOnLongClickListener(null);
        break;
        str = paramLebaMgrViewItem.a.a.strResName;
        break label171;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Int;
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setColorFilter(-1, PorterDuff.Mode.DST_IN);
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setImageDrawable((Drawable)localObject);
        break label226;
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setOnClickListener(new LebaTableMgrAdpter.3(this, paramLebaMgrViewItem, paramPluginViewHolder));
        LebaTableMgrAdpter.PluginViewHolder.a(paramPluginViewHolder).setImageResource(2130850709);
      }
    }
  }
  
  public void a(ItemTouchHelper paramItemTouchHelper)
  {
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper = paramItemTouchHelper;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    LebaMgrViewItem localLebaMgrViewItem = this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(paramInt);
    if (localLebaMgrViewItem == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof LebaTableMgrAdpter.TitleViewHolder)) {
        ((LebaTableMgrAdpter.TitleViewHolder)paramViewHolder).a(localLebaMgrViewItem);
      } else if ((paramViewHolder instanceof LebaTableMgrAdpter.PluginViewHolder)) {
        a((LebaTableMgrAdpter.PluginViewHolder)paramViewHolder, localLebaMgrViewItem);
      } else if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy.a(paramViewHolder, localLebaMgrViewItem, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Boolean);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561307, paramViewGroup, false);
      paramViewGroup.setTag(2131370251, Integer.valueOf(paramInt));
      localObject = new LebaTableMgrAdpter.TitleViewHolder(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.jdField_b_of_type_Boolean);
      return localObject;
    }
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561305, paramViewGroup, false);
      paramViewGroup.setTag(2131370251, Integer.valueOf(paramInt));
      return new LebaTableMgrAdpter.PluginViewHolder(paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager, this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy != null) {}
    for (paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramInt, this.jdField_b_of_type_Boolean);; paramViewGroup = null)
    {
      localObject = paramViewGroup;
      if (paramViewGroup != null) {
        break;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrAdpter
 * JD-Core Version:    0.7.0.1
 */