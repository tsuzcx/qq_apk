package com.tencent.mobileqq.extendfriend.bean;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class MiniAppRecommViewHolder$MiniAppAdapter
  extends RecyclerView.Adapter<MiniAppRecommViewHolder.MicroAppViewHolder>
{
  private List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MiniAppRecommViewHolder$MiniAppAdapter(MiniAppRecommViewHolder paramMiniAppRecommViewHolder) {}
  
  public MiniAppRecommViewHolder.MicroAppViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(MiniAppRecommViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommViewHolder)).inflate(2131559591, null, false);
    return new MiniAppRecommViewHolder.MicroAppViewHolder(MiniAppRecommViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommViewHolder), paramViewGroup);
  }
  
  public void a(MiniAppRecommViewHolder.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramMicroAppViewHolder.a(localMiniApp);
    paramMicroAppViewHolder.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo != null))
    {
      SimpleMiniAppConfig localSimpleMiniAppConfig = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(localMiniApp.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo));
      localSimpleMiniAppConfig.launchParam.scene = 2065;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportMiniAppExposureData(localSimpleMiniAppConfig, paramInt);
      MiniAppRecommViewHolder.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMicroAppViewHolder, paramInt, getItemId(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommViewHolder.MiniAppAdapter
 * JD-Core Version:    0.7.0.1
 */