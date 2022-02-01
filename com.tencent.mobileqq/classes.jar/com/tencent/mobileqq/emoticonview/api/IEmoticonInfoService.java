package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Adapter;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
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
  
  public abstract IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(Context paramContext, IPanelListener paramIPanelListener);
  
  public abstract int getAddedHeight();
  
  public abstract <T> List<T> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, boolean paramBoolean);
  
  public abstract ImageButton getDeleteImageBtn(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener);
  
  public abstract <T> List<T> getEmoticonList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2);
  
  public abstract JSONObject getJSONFromLocal(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract boolean isSmallEmotionDownloadedAdapter(Adapter paramAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
 * JD-Core Version:    0.7.0.1
 */