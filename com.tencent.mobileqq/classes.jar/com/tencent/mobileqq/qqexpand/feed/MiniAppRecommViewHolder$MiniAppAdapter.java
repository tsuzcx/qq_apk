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
  private final List<MiniAppRecommInfo.MiniApp> b = new ArrayList();
  
  public MiniAppRecommViewHolder$MiniAppAdapter(MiniAppRecommViewHolder paramMiniAppRecommViewHolder) {}
  
  public MiniAppRecommViewHolder.MicroAppViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(MiniAppRecommViewHolder.a(this.a)).inflate(2131625434, null, false);
    return new MiniAppRecommViewHolder.MicroAppViewHolder(MiniAppRecommViewHolder.a(this.a), paramViewGroup);
  }
  
  public void a(MiniAppRecommViewHolder.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.b.get(paramInt);
    paramMicroAppViewHolder.a(localMiniApp);
    paramMicroAppViewHolder.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.e != null))
    {
      paramMicroAppViewHolder = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(localMiniApp.e));
      paramMicroAppViewHolder.launchParam.scene = 2065;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportMiniAppExposureData(paramMicroAppViewHolder, paramInt);
      MiniAppRecommViewHolder.a(101, paramInt, localMiniApp.f);
    }
  }
  
  public void a(List<MiniAppRecommInfo.MiniApp> paramList)
  {
    if (paramList != null)
    {
      this.b.clear();
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder.MiniAppAdapter
 * JD-Core Version:    0.7.0.1
 */