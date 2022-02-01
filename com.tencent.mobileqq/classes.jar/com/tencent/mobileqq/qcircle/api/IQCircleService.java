package com.tencent.mobileqq.qcircle.api;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(needUin=false, process={"all"})
public abstract interface IQCircleService
  extends IRuntimeService
{
  public abstract void downloadSkinPackage(String paramString);
  
  public abstract void enterByScheme(Context paramContext, String paramString);
  
  public abstract void enterBySchemeAction(Context paramContext, String paramString, HashMap<String, String> paramHashMap);
  
  public abstract void enterBySchemeAction(Context paramContext, String paramString, HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1);
  
  public abstract Pair<Integer, List<String>> getQCircleChatRedPointInfoFromMessageList();
  
  public abstract void loadImage(Option paramOption, QCirclePicStateListener paramQCirclePicStateListener);
  
  public abstract ArrayList<QCircleRecentDataInterface> makeRecentBaseDataList();
  
  public abstract void openRewardActivity(Activity paramActivity, JSONObject paramJSONObject);
  
  public abstract void refreshMainPageFeed(String paramString, VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp> paramonVSRspCallBack);
  
  public abstract void releaseWhenExitQCircle();
  
  public abstract void sendGetRainBowRequest();
  
  public abstract void tryGetSplashVideoAsync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleService
 * JD-Core Version:    0.7.0.1
 */