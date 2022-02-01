package com.tencent.mobileqq.troop.troopcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class TroopAssociationsAdapter
  extends BaseAdapter
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopAssociationsAdapter.1(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<AssociatedTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new TroopAssociationsAdapter.2(this);
  
  public TroopAssociationsAdapter(Context paramContext, AppInterface paramAppInterface, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561522, null);
    paramOnClickListener3 = new TroopAssociationsAdapter.ViewHolder();
    paramOnClickListener3.jdField_a_of_type_AndroidViewView = paramContext;
    paramOnClickListener3.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131369534));
    if ((paramOnClickListener3.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)paramOnClickListener3.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    paramOnClickListener3.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramContext.findViewById(2131379955));
    paramOnClickListener3.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131363961));
    paramOnClickListener3.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)paramContext.findViewById(2131363409));
    paramOnClickListener3.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131363416));
    paramOnClickListener3.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)paramContext.findViewById(2131379611));
    paramOnClickListener3.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    paramContext.setOnClickListener(paramOnClickListener1);
    paramContext.setTag(paramOnClickListener3);
    return paramContext;
  }
  
  private void a(TroopAssociationsAdapter.ViewHolder paramViewHolder, AssociatedTroopItem paramAssociatedTroopItem, Drawable paramDrawable)
  {
    if ((paramViewHolder != null) && (paramAssociatedTroopItem != null))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramAssociatedTroopItem.name);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramAssociatedTroopItem.name);
      paramDrawable = paramAssociatedTroopItem.labelList;
      if ((paramDrawable != null) && (paramDrawable.size() > 0))
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setAutoCreateDistanceTextView(true);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramDrawable);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      }
      if (paramAssociatedTroopItem.privilege != 3)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699455);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296742), 0, 0, 0);
      }
      else if (paramAssociatedTroopItem.memberNum < paramAssociatedTroopItem.maxMemberNum)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699454);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296742), 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296742), 0);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699452);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296742), 0, 0, 0);
      }
      if (TextUtils.isEmpty(paramAssociatedTroopItem.intro)) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696146));
      } else {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramAssociatedTroopItem.intro, 11, 16));
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramAssociatedTroopItem);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(paramAssociatedTroopItem);
      return;
    }
    QLog.d("TroopAssociationsAdapter", 1, "viewHolder == null || troopItem == null");
  }
  
  public AssociatedTroopItem a(int paramInt)
  {
    return (AssociatedTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<AssociatedTroopItem> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof TroopAssociationsAdapter.ViewHolder)) {}
    }
    else
    {
      localView = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    paramView = (TroopAssociationsAdapter.ViewHolder)localView.getTag();
    AssociatedTroopItem localAssociatedTroopItem = a(paramInt);
    a(paramView, localAssociatedTroopItem, FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 4, localAssociatedTroopItem.uin));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopAssociationsAdapter
 * JD-Core Version:    0.7.0.1
 */