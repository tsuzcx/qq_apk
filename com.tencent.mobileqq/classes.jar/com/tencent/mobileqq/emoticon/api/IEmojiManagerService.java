package com.tencent.mobileqq.emoticon.api;

import android.os.Bundle;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IEmojiManagerService
  extends IRuntimeService
{
  public abstract int addEmotionTaskByList(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt);
  
  public abstract void addH5MagicChildDownloadTask(EmoticonPackage paramEmoticonPackage, boolean paramBoolean);
  
  public abstract void addThumbTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle);
  
  public abstract boolean canPlayH5Magic();
  
  public abstract int collectEmoji(Emoticon paramEmoticon);
  
  public abstract boolean downloadAIOEmoticon(Emoticon paramEmoticon, int paramInt);
  
  public abstract void fetchEmoticonEncryptKeys(String paramString, ArrayList<Emoticon> paramArrayList);
  
  public abstract void fetchEmoticonEncryptKeys(String paramString, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo);
  
  public abstract void generateFileList(String paramString1, String paramString2);
  
  public abstract Bundle getAllDownloadProgress(int paramInt);
  
  public abstract Bundle getDownloadProgress(Bundle paramBundle);
  
  public abstract DownloaderInterface getDownloader();
  
  public abstract JobQueue getEmoQueue();
  
  public abstract IEmojiListenerManager getEmojiListenerManager();
  
  public abstract float getEmoticonPackageLoadingProgress(String paramString);
  
  public abstract boolean getHaveInitFav();
  
  public abstract boolean getHaveInitSmallAndNormal();
  
  public abstract String[] getImgPreviewTask(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract boolean getMagicFaceSendAccessControl();
  
  public abstract ConcurrentHashMap<String, TaskStatus> getStatusMap();
  
  public abstract void handleEmoticonPackageDownloaded(Bundle paramBundle, Object paramObject, boolean paramBoolean, int paramInt1, String paramString, long paramLong, int paramInt2);
  
  public abstract void handleEmotionEncryptKey(DownloadTask paramDownloadTask);
  
  public abstract void handleMagicOrH5MagicDownloadOnDoneFile(DownloadTask paramDownloadTask);
  
  public abstract boolean isDPCSupportH5Magic();
  
  public abstract boolean isEmojiCollected(Emoticon paramEmoticon);
  
  public abstract boolean isH5MagicFacePackageIntact(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean isH5MagicIntact(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean isMagicFacePackageIntact(String paramString, Boolean paramBoolean);
  
  public abstract void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean);
  
  public abstract void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract boolean sendEmojiToAio(Emoticon paramEmoticon);
  
  public abstract void setHaveInitFav(boolean paramBoolean);
  
  public abstract void setHaveInitSmallAndNormal(boolean paramBoolean);
  
  public abstract void setStatusMap(ConcurrentHashMap<String, TaskStatus> paramConcurrentHashMap);
  
  public abstract void startCoverDownload(EmoticonPackage paramEmoticonPackage);
  
  public abstract Bundle startDownloadEmoji(Bundle paramBundle);
  
  public abstract void startDownloadEmosmJson(String paramString, int paramInt);
  
  public abstract void startDownloadEmosmJson(String paramString, int paramInt1, int paramInt2);
  
  public abstract void startDownloadEmosmJson(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean);
  
  public abstract void startDownloadEmosmJson(String paramString, int paramInt1, Bundle paramBundle, boolean paramBoolean, int paramInt2);
  
  public abstract Bundle stopDownloadPacket(String paramString, int paramInt);
  
  public abstract void stopEmoticonPackageDownload(String paramString);
  
  public abstract boolean supportExtensionDisplay(Emoticon paramEmoticon);
  
  public abstract boolean tasksFileExists(Emoticon paramEmoticon, int paramInt);
  
  public abstract boolean verifyMagicFacePackageIntact(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IEmojiManagerService
 * JD-Core Version:    0.7.0.1
 */