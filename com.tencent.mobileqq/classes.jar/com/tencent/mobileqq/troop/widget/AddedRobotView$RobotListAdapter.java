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
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;

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
    return new AddedRobotView.RobotListAdapter.RobotViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561533, paramViewGroup, false));
  }
  
  public void a(AddedRobotView.RobotListAdapter.RobotViewHolder paramRobotViewHolder, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (paramInt < ((ArrayList)localObject1).size()))
    {
      TroopRobotInfo localTroopRobotInfo = (TroopRobotInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localTroopRobotInfo != null)
      {
        String str = String.valueOf(localTroopRobotInfo.a());
        Object localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).getBitmapFromCache(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ImageUtil.f();
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
          localObject2 = (ITroopRobotService)((QQAppInterface)localObject1).getRuntimeService(ITroopRobotService.class, "all");
          boolean bool;
          if (localObject2 != null) {
            bool = ((ITroopRobotService)localObject2).isRobotUinNeedShowRed((AppRuntime)localObject1, String.valueOf(localTroopRobotInfo.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));
          } else {
            bool = false;
          }
          if (bool) {
            paramRobotViewHolder.c.setVisibility(0);
          } else {
            paramRobotViewHolder.c.setVisibility(8);
          }
        }
        if (localTroopRobotInfo.b())
        {
          paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846423));
          paramRobotViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else
        {
          paramRobotViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846377));
          paramRobotViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRobotViewHolder, paramInt, getItemId(paramInt));
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof TroopRobotInfo)))
    {
      localObject = (TroopRobotInfo)localObject;
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(((TroopRobotInfo)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        ITroopRobotService localITroopRobotService = (ITroopRobotService)localQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
        if ((localITroopRobotService != null) && (localITroopRobotService.isRobotUinNeedShowRed(localQQAppInterface, String.valueOf(((TroopRobotInfo)localObject).a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localITroopRobotService.removeRobotUinInRed(localQQAppInterface, String.valueOf(((TroopRobotInfo)localObject).a()));
        }
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((TroopRobotInfo)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView.RobotListAdapter
 * JD-Core Version:    0.7.0.1
 */