package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotInfo;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class AddedRobotView$RobotListAdapter
  extends RecyclerView.Adapter<AddedRobotView.RobotListAdapter.RobotViewHolder>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<TroopRobotInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public AddedRobotView$RobotListAdapter(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public AddedRobotView.RobotListAdapter.RobotViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AddedRobotView.RobotListAdapter.RobotViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561691, paramViewGroup, false));
  }
  
  public void a(AddedRobotView.RobotListAdapter.RobotViewHolder paramRobotViewHolder, int paramInt)
  {
    TroopRobotInfo localTroopRobotInfo;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localTroopRobotInfo = (TroopRobotInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localTroopRobotInfo != null)
      {
        String str = String.valueOf(localTroopRobotInfo.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).getBitmapFromCache(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ImageUtil.c();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).isPausing())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).requestDecodeFace(str, 1, false);
            localObject1 = localObject2;
          }
        }
        paramRobotViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        paramRobotViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopRobotInfo.a());
        paramRobotViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(localTroopRobotInfo.a());
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(localTroopRobotInfo);
        paramRobotViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramRobotViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(localTroopRobotInfo);
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localTroopRobotInfo.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (TroopRobotManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
          if (localObject2 == null) {
            break label357;
          }
        }
      }
    }
    label326:
    label357:
    for (boolean bool = ((TroopRobotManager)localObject2).a((QQAppInterface)localObject1, String.valueOf(localTroopRobotInfo.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool)
      {
        paramRobotViewHolder.c.setVisibility(0);
        if (!localTroopRobotInfo.b()) {
          break label326;
        }
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846548));
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramRobotViewHolder, paramInt, getItemId(paramInt));
        return;
        paramRobotViewHolder.c.setVisibility(8);
        break;
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846497));
        paramRobotViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(ArrayList<TroopRobotInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof TroopRobotInfo)))
    {
      localObject = (TroopRobotInfo)localObject;
      RobotUtils.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(((TroopRobotInfo)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        TroopRobotManager localTroopRobotManager = (TroopRobotManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        if ((localTroopRobotManager != null) && (localTroopRobotManager.a(localQQAppInterface, String.valueOf(((TroopRobotInfo)localObject).a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localTroopRobotManager.a(localQQAppInterface, String.valueOf(((TroopRobotInfo)localObject).a()));
        }
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((TroopRobotInfo)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView.RobotListAdapter
 * JD-Core Version:    0.7.0.1
 */