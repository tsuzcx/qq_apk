package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

public class TroopAdminList$AdminListAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public TroopAdminList$AdminListAdapter(TroopAdminList paramTroopAdminList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopAdminList.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new TroopAdminList.ViewHolder();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560605, null);
      localViewHolder.c = ((ImageView)paramView.findViewById(2131369372));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371697));
      localViewHolder.b = ((TextView)paramView.findViewById(2131368773));
      paramView.setTag(localViewHolder);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      localViewHolder = (TroopAdminList.ViewHolder)paramView.getTag();
    }
    Map localMap = (Map)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = localMap.get("uin").toString();
    localViewHolder.jdField_a_of_type_JavaLangString = str;
    localViewHolder.c.setBackgroundDrawable(ImageUtil.e());
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.app, localMap.get("uin").toString(), (byte)3);
    if (localFaceDrawable != null) {
      localViewHolder.c.setBackgroundDrawable(localFaceDrawable);
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMap.get("nick").toString());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.b.equals(str)) {
      localViewHolder.b.setVisibility(0);
    } else {
      localViewHolder.b.setVisibility(4);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.AdminListAdapter
 * JD-Core Version:    0.7.0.1
 */