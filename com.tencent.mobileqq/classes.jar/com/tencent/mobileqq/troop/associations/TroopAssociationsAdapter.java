package com.tencent.mobileqq.troop.associations;

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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<AssociatedTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new TroopAssociationsAdapter.2(this);
  
  public TroopAssociationsAdapter(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561674, null);
    paramOnClickListener3 = new TroopAssociationsAdapter.ViewHolder();
    paramOnClickListener3.jdField_a_of_type_AndroidViewView = paramContext;
    paramOnClickListener3.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131369848));
    if ((paramOnClickListener3.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)paramOnClickListener3.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    paramOnClickListener3.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramContext.findViewById(2131380681));
    paramOnClickListener3.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131364035));
    paramOnClickListener3.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)paramContext.findViewById(2131363482));
    paramOnClickListener3.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131363489));
    paramOnClickListener3.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)paramContext.findViewById(2131380300));
    paramOnClickListener3.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    paramContext.setOnClickListener(paramOnClickListener1);
    paramContext.setTag(paramOnClickListener3);
    return paramContext;
  }
  
  private void a(TroopAssociationsAdapter.ViewHolder paramViewHolder, AssociatedTroopItem paramAssociatedTroopItem, Drawable paramDrawable)
  {
    if ((paramViewHolder == null) || (paramAssociatedTroopItem == null))
    {
      QLog.d("TroopAssociationsAdapter", 1, "viewHolder == null || troopItem == null");
      return;
    }
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
      if (paramAssociatedTroopItem.privilege == 3) {
        break label206;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699350);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296762), 0, 0, 0);
      label151:
      if (!TextUtils.isEmpty(paramAssociatedTroopItem.intro)) {
        break label329;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696129));
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramAssociatedTroopItem);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(paramAssociatedTroopItem);
      return;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      break;
      label206:
      if (paramAssociatedTroopItem.memberNum < paramAssociatedTroopItem.maxMemberNum)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699349);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296762), 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296762), 0);
        break label151;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699347);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296762), 0, 0, 0);
      break label151;
      label329:
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramAssociatedTroopItem.intro, 11, 16));
    }
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
    if ((paramView == null) || (!(paramView.getTag() instanceof TroopAssociationsAdapter.ViewHolder))) {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    for (;;)
    {
      TroopAssociationsAdapter.ViewHolder localViewHolder = (TroopAssociationsAdapter.ViewHolder)paramView.getTag();
      AssociatedTroopItem localAssociatedTroopItem = a(paramInt);
      a(localViewHolder, localAssociatedTroopItem, FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localAssociatedTroopItem.uin));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.associations.TroopAssociationsAdapter
 * JD-Core Version:    0.7.0.1
 */