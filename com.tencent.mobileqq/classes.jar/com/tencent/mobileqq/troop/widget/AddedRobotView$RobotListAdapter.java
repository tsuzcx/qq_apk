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
  LayoutInflater a;
  private ArrayList<TroopRobotInfo> c = new ArrayList();
  private Context d;
  
  public AddedRobotView$RobotListAdapter(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.d = paramContext;
    this.a = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public AddedRobotView.RobotListAdapter.RobotViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AddedRobotView.RobotListAdapter.RobotViewHolder(this, this.a.inflate(2131627894, paramViewGroup, false));
  }
  
  public void a(AddedRobotView.RobotListAdapter.RobotViewHolder paramRobotViewHolder, int paramInt)
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (paramInt < ((ArrayList)localObject1).size()))
    {
      TroopRobotInfo localTroopRobotInfo = (TroopRobotInfo)this.c.get(paramInt);
      if (localTroopRobotInfo != null)
      {
        String str = String.valueOf(localTroopRobotInfo.a());
        Object localObject2 = AddedRobotView.b(this.b).getBitmapFromCache(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ImageUtil.k();
          localObject1 = localObject2;
          if (!AddedRobotView.b(this.b).isPausing())
          {
            AddedRobotView.b(this.b).requestDecodeFace(str, 1, false);
            localObject1 = localObject2;
          }
        }
        paramRobotViewHolder.b.setImageBitmap((Bitmap)localObject1);
        paramRobotViewHolder.a.setText(localTroopRobotInfo.b());
        paramRobotViewHolder.d = String.valueOf(localTroopRobotInfo.a());
        paramRobotViewHolder.e.setOnClickListener(this);
        paramRobotViewHolder.e.setTag(localTroopRobotInfo);
        paramRobotViewHolder.a.setOnClickListener(this);
        paramRobotViewHolder.a.setTag(localTroopRobotInfo);
        paramRobotViewHolder.e.setContentDescription(localTroopRobotInfo.b());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (ITroopRobotService)((QQAppInterface)localObject1).getRuntimeService(ITroopRobotService.class, "all");
          boolean bool;
          if (localObject2 != null) {
            bool = ((ITroopRobotService)localObject2).isRobotUinNeedShowRed((AppRuntime)localObject1, String.valueOf(localTroopRobotInfo.a()), AddedRobotView.a(this.b));
          } else {
            bool = false;
          }
          if (bool) {
            paramRobotViewHolder.f.setVisibility(0);
          } else {
            paramRobotViewHolder.f.setVisibility(8);
          }
        }
        if (localTroopRobotInfo.e())
        {
          paramRobotViewHolder.e.setBackgroundDrawable(this.d.getResources().getDrawable(2130847896));
          paramRobotViewHolder.c.setVisibility(0);
        }
        else
        {
          paramRobotViewHolder.e.setBackgroundDrawable(this.d.getResources().getDrawable(2130847850));
          paramRobotViewHolder.c.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRobotViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(ArrayList<TroopRobotInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.c.clear();
      this.c.addAll(paramArrayList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.c;
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
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this.d, AddedRobotView.a(this.b), String.valueOf(((TroopRobotInfo)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        ITroopRobotService localITroopRobotService = (ITroopRobotService)localQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
        if ((localITroopRobotService != null) && (localITroopRobotService.isRobotUinNeedShowRed(localQQAppInterface, String.valueOf(((TroopRobotInfo)localObject).a()), AddedRobotView.a(this.b)))) {
          localITroopRobotService.removeRobotUinInRed(localQQAppInterface, String.valueOf(((TroopRobotInfo)localObject).a()));
        }
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((TroopRobotInfo)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView.RobotListAdapter
 * JD-Core Version:    0.7.0.1
 */