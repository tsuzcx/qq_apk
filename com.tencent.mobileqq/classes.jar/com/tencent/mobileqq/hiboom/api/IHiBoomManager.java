package com.tencent.mobileqq.hiboom.api;

import android.os.Handler;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;

public abstract interface IHiBoomManager
  extends IVasManager, Manager
{
  public abstract void downloadHiBoomFont(int paramInt, String paramString);
  
  public abstract Object getHandlerLock();
  
  public abstract HiBoomItem getHiBoomItemById(int paramInt);
  
  public abstract void getHiBoomListFromLocal();
  
  public abstract void getHiBoomListFromServer();
  
  public abstract Vector<Integer> getInvalidHiBoomList();
  
  public abstract Vector<Integer> getRecommandHiBoomList();
  
  public abstract Vector<Integer> getValidHiBoomList();
  
  public abstract void invalidateHiBoomPanel();
  
  public abstract boolean isHiBoomEnable();
  
  public abstract boolean isHiBoomListInit();
  
  public abstract boolean isMemorySupport();
  
  public abstract void loadHiBoomConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void onAIODestroy();
  
  public abstract void onCreate(AppRuntime paramAppRuntime);
  
  public abstract void onDirtywordFilterResult(boolean paramBoolean);
  
  public abstract void onHiBoomItemDownloaded(int paramInt1, int paramInt2);
  
  public abstract void parseHiBoomList(VipFontUpdate.TGetPosterFontRsp paramTGetPosterFontRsp, boolean paramBoolean);
  
  public abstract JSONObject queryDownloadInfo(int paramInt);
  
  public abstract void registerIPCDownloadListener(IPCDownloadListener paramIPCDownloadListener);
  
  public abstract boolean sendHiBoomMessage(IBaseChatPieAdapter paramIBaseChatPieAdapter, String paramString, int paramInt1, int paramInt2);
  
  public abstract void setAIOPreviewHandler(Handler paramHandler);
  
  public abstract void setIsHiBoomListInit(boolean paramBoolean);
  
  public abstract void setLegalJugeResultLisener(LegalJudgeResultLisener paramLegalJudgeResultLisener);
  
  public abstract void setListUIHandler(Handler paramHandler);
  
  public abstract void stopDownloadHiBoomFont(int paramInt);
  
  public abstract void updateHiBoomItemProgress(int paramInt1, int paramInt2);
  
  public abstract void updateHiBoomSwitch(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.api.IHiBoomManager
 * JD-Core Version:    0.7.0.1
 */