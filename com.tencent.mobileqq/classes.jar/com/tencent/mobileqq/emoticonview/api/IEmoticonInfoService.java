package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.adapter.IEmotionAdapterHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IEmoticonInfoService
  extends QRouteApi
{
  public abstract void addToCommonUsed(AppRuntime paramAppRuntime, Parcelable paramParcelable, int paramInt1, int paramInt2);
  
  public abstract IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(Context paramContext, boolean paramBoolean);
  
  public abstract IEmotionAdapterHelper createEmotionAdapterHelper(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt);
  
  public abstract IEmoticonInfoSender createEmotionInfoSender(int paramInt);
  
  public abstract <T> List<T> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, boolean paramBoolean);
  
  public abstract <T> List<T> getEmoticonList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2);
  
  public abstract <T> List<T> getEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract JSONObject getJSONFromLocal(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract <T> List<T> getOldEmoticonList(int[] paramArrayOfInt);
  
  public abstract <T> List<T> getOnlySysEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, int[] paramArrayOfInt);
  
  public abstract <T> List<T> getUniversalEmoticonListFromConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract String getVasExtensionDownloaderProtocol();
  
  public abstract void preload(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
 * JD-Core Version:    0.7.0.1
 */