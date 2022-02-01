package dov.com.qq.im.ae.camera.ui.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$DashboardAdapter
  extends RecyclerView.Adapter<AEVideoStoryDashboardPart.DashboardHolder>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<AEVideoStoryDashboardPart.DashboardInfo> jdField_a_of_type_JavaUtilList;
  
  public AEVideoStoryDashboardPart$DashboardAdapter(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public AEVideoStoryDashboardPart.DashboardHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEVideoStoryDashboardPart.DashboardHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558504, paramViewGroup, false));
  }
  
  public void a(AEVideoStoryDashboardPart.DashboardHolder paramDashboardHolder, int paramInt)
  {
    paramDashboardHolder.a((AEVideoStoryDashboardPart.DashboardInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramDashboardHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<AEVideoStoryDashboardPart.DashboardInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.DashboardAdapter.1(this));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardAdapter
 * JD-Core Version:    0.7.0.1
 */