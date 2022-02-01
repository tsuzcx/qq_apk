package com.tencent.mobileqq.qqexpand.feed;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class MiniAppRecommViewHolder$MiniAppAdapter
  extends RecyclerView.Adapter<MiniAppRecommViewHolder.MicroAppViewHolder>
{
  private final List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MiniAppRecommViewHolder$MiniAppAdapter(MiniAppRecommViewHolder paramMiniAppRecommViewHolder) {}
  
  public MiniAppRecommViewHolder.MicroAppViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(MiniAppRecommViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedMiniAppRecommViewHolder)).inflate(2131559468, null, false);
    return new MiniAppRecommViewHolder.MicroAppViewHolder(MiniAppRecommViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedMiniAppRecommViewHolder), paramViewGroup);
  }
  
  public void a(MiniAppRecommViewHolder.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramMicroAppViewHolder.a(localMiniApp);
    paramMicroAppViewHolder.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo != null))
    {
      paramMicroAppViewHolder = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(localMiniApp.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo));
      paramMicroAppViewHolder.launchParam.scene = 2065;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportMiniAppExposureData(paramMicroAppViewHolder, paramInt);
      MiniAppRecommViewHolder.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
    }
  }
  
  public void a(List<MiniAppRecommInfo.MiniApp> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder.MiniAppAdapter
 * JD-Core Version:    0.7.0.1
 */