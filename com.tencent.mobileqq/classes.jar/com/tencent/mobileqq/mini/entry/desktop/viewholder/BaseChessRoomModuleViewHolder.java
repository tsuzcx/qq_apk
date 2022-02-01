package com.tencent.mobileqq.mini.entry.desktop.viewholder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.GameAppUiItem;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseChessRoomModuleViewHolder
  extends RecyclerView.ViewHolder
{
  private static final String TAG = "BaseChessRoomModuleViewHolder";
  protected final WeakReference<Activity> mActivityWeakRef;
  protected int mChessEntranceTabIndex;
  protected final int mGameAppSize;
  protected final ArrayList<GameAppUiItem> mGameAppUiItems;
  protected MiniAppInfo mMoreAppInfo;
  protected final View mRootView;
  
  public BaseChessRoomModuleViewHolder(View paramView, WeakReference<Activity> paramWeakReference, int paramInt)
  {
    super(paramView);
    this.mRootView = paramView.findViewById(2030305327);
    this.mActivityWeakRef = paramWeakReference;
    this.mGameAppSize = paramInt;
    this.mGameAppUiItems = new ArrayList(paramInt);
  }
  
  private String getExtendData(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tabIndex", paramInt);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONException,ex=");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e("BaseChessRoomModuleViewHolder", 1, localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  protected MiniAppConfig getMiniAppConfig(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = new MiniAppConfig(paramMiniAppInfo);
    paramMiniAppInfo.launchParam.scene = 3038;
    return paramMiniAppInfo;
  }
  
  protected void handleOnClickEvent(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("BaseChessRoomModuleViewHolder", 1, "miniAppInfo is null");
      return;
    }
    Activity localActivity = (Activity)this.mActivityWeakRef.get();
    if (localActivity != null) {
      MiniAppDesktopAdapter.startMiniApp(localActivity, paramMiniAppInfo, 3038);
    }
  }
  
  protected void initAppPanelVisibleState()
  {
    int j = this.mGameAppUiItems.size();
    int i = 0;
    while (i < j)
    {
      ((GameAppUiItem)this.mGameAppUiItems.get(i)).appPanel.setVisibility(4);
      i += 1;
    }
  }
  
  protected void jumpEnterChessRoom(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("BaseChessRoomModuleViewHolder", 1, "jumpEnterChessRoom,miniAppInfo is null");
      return;
    }
    Activity localActivity = (Activity)this.mActivityWeakRef.get();
    if (localActivity == null)
    {
      QLog.e("BaseChessRoomModuleViewHolder", 1, "miniAppInfo is null");
      return;
    }
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = 3038;
    paramMiniAppInfo.extendData = getExtendData(paramInt);
    MiniAppDesktopAdapter.startMiniApp(localActivity, paramMiniAppInfo, localLaunchParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.viewholder.BaseChessRoomModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */