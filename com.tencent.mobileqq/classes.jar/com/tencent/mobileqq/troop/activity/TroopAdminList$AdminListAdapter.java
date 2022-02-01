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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new TroopAdminList.ViewHolder();
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560717, null);
      paramView.c = ((ImageView)localView.findViewById(2131369675));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
      paramView.b = ((TextView)localView.findViewById(2131369051));
      localView.setTag(paramView);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject = (Map)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.get(paramInt);
      String str = ((Map)localObject).get("uin").toString();
      paramView.jdField_a_of_type_JavaLangString = str;
      paramView.c.setBackgroundDrawable(ImageUtil.c());
      FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.app, ((Map)localObject).get("uin").toString(), (byte)3);
      if (localFaceDrawable != null) {
        paramView.c.setBackgroundDrawable(localFaceDrawable);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Map)localObject).get("nick").toString());
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.b.equals(str)) {
        break label249;
      }
      paramView.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TroopAdminList.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label249:
      paramView.b.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.AdminListAdapter
 * JD-Core Version:    0.7.0.1
 */