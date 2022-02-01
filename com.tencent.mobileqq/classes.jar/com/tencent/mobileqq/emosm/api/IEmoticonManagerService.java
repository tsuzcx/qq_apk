package com.tencent.mobileqq.emosm.api;

import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SupportSize;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IEmoticonManagerService
  extends IRuntimeService
{
  public abstract void addEmotionKeywordExpose(EmotionKeyword paramEmotionKeyword, boolean paramBoolean);
  
  public abstract void addEmotionKeywordToCache(EmotionKeyword paramEmotionKeyword);
  
  public abstract void addExtensionSizeByScreenSizeFromKeyword(String paramString, Emoticon paramEmoticon, List<EmosmPb.SupportSize> paramList);
  
  public abstract void addRecentEmotionExposeNum(EmotionKeyword paramEmotionKeyword, boolean paramBoolean);
  
  public abstract void addRecentEmotionToCache(RecentEmotion paramRecentEmotion);
  
  public abstract void addTabEmoticonPackage(String paramString, int paramInt);
  
  public abstract void asyncFindEmoticon(String paramString1, String paramString2, QueryCallback<Emoticon> paramQueryCallback);
  
  public abstract void asyncFindEmoticonPackage(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback);
  
  public abstract void asyncFindEmoticonPackage(String paramString, QueryCallback<EmoticonPackage> paramQueryCallback);
  
  public abstract void asyncFindTabEmoticonPackageById(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback);
  
  public abstract void asyncFindTabEmoticonPackageById(String paramString, QueryCallback<EmoticonPackage> paramQueryCallback);
  
  public abstract <T> void asyncGetEmoticonInfo(MarkFaceMessage paramMarkFaceMessage, QueryCallback<T> paramQueryCallback);
  
  public abstract void asyncGetTabEmoticonPackages(int paramInt, QueryCallback<List<EmoticonPackage>> paramQueryCallback);
  
  public abstract void asyncIncreaseEmotionClickNum(Emoticon paramEmoticon);
  
  public abstract void clearAllRecommendExposeNum();
  
  public abstract void clearCache();
  
  public abstract void clearEmotionKeyword(String paramString);
  
  public abstract EmoticonTab findEmoticonTabById(String paramString);
  
  public abstract List<Emoticon> findKeywordEmotion(String paramString);
  
  public abstract int getExtensionSizeByScreenSize(String paramString);
  
  public abstract VipIPSiteInfo getIPSiteInfoFromBytes(byte[] paramArrayOfByte);
  
  public abstract long getKeywordLastReqTime(String paramString);
  
  public abstract int getKeywordTotalCount(String paramString);
  
  public abstract List<String> getKeywordsByEmoticon(Emoticon paramEmoticon);
  
  public abstract List<String> getLocalExposeNumFullKeyword(String paramString);
  
  public abstract List<EmoticonInfo> getMagicEmoticonInfoList(int paramInt);
  
  public abstract QQLruCache<String, EmoticonPackage> getPkgCache();
  
  public abstract List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract Emoticon getRecentEmotionByKeyword(String paramString);
  
  public abstract String getSmallEmoticonDescription(String paramString1, String paramString2);
  
  public abstract List<String> getTabCache();
  
  public abstract boolean handleFetchEmoticonPackagesResp(boolean paramBoolean, int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2);
  
  public abstract boolean isEpidInTabcache(String paramString);
  
  public abstract boolean isKeywordsInHotWordList(String paramString);
  
  public abstract boolean isShowRecommendTabRedPoint(int paramInt);
  
  public abstract boolean isWifiOrG3OrG4();
  
  public abstract void parseCloudKeywordsJson();
  
  public abstract byte[] parseIPSiteInfoToBytes(VipIPSiteInfo paramVipIPSiteInfo);
  
  public abstract void pushRecommendExposeInfoToSP();
  
  public abstract List<Emoticon> queryBigEmoticonsFromDB();
  
  public abstract void reconstructAllTabEmoticonPackage(List<String> paramList, int paramInt);
  
  public abstract void reconstructEmoticonPackage(String paramString, List<Emoticon> paramList);
  
  public abstract void recordRecommendEpExpose(PromotionEmoticonPkg paramPromotionEmoticonPkg);
  
  public abstract boolean removeEmoticonPackage(EmoticonPackage paramEmoticonPackage);
  
  public abstract void removeTabEmoticonPackage(String paramString, int paramInt);
  
  public abstract void reportSwitchSpeakerPhoneClick(ChatMessage paramChatMessage, BaseSessionInfo paramBaseSessionInfo, boolean paramBoolean);
  
  public abstract void saveAndUpdateRecommendEmosInfo(EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend, int paramInt);
  
  public abstract void saveEmoticon(Emoticon paramEmoticon);
  
  public abstract void saveEmoticonPackage(EmoticonPackage paramEmoticonPackage);
  
  public abstract void saveEmoticonPackageKeywordJson(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3);
  
  public abstract void saveEmoticonPackages(List<EmoticonPackage> paramList);
  
  public abstract void saveEmoticonPkgUpdateStatus(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3);
  
  public abstract void saveEmoticons(List<Emoticon> paramList);
  
  public abstract void saveEmotionKeywordToDB();
  
  public abstract void saveRecentEmotionToDB();
  
  public abstract void setRecommendEpRedFlag(String paramString, int paramInt);
  
  public abstract Emoticon syncFindEmoticonById(String paramString1, String paramString2);
  
  public abstract EmoticonPackage syncFindEmoticonPackageById(String paramString);
  
  public abstract EmoticonPackage syncFindEmoticonPackageById(String paramString, int paramInt);
  
  public abstract EmoticonPackage syncFindEmoticonPackageInCache(String paramString, int paramInt);
  
  public abstract EmoticonPackage syncFindTabEmoticonPackageById(String paramString);
  
  public abstract EmoticonPackage syncFindTabEmoticonPackageById(String paramString, int paramInt);
  
  public abstract <T extends EmoticonInfo> T syncGetEmoticonInfo(MarkFaceMessage paramMarkFaceMessage);
  
  public abstract List<Emoticon> syncGetEmoticonsByKeyword(String paramString, boolean paramBoolean);
  
  public abstract List<Emoticon> syncGetSubEmoticonsByPackageId(String paramString);
  
  public abstract List<Emoticon> syncGetSubEmoticonsByPackageId(String paramString, boolean paramBoolean);
  
  public abstract List<EmoticonPackage> syncGetTabEmoticonPackages();
  
  public abstract List<EmoticonPackage> syncGetTabEmoticonPackages(int paramInt);
  
  public abstract void syncIncreaseEmoticonExposeNum(IStickerRecEmoticon paramIStickerRecEmoticon);
  
  public abstract void syncPcTabEmoticonPackage(String paramString, int paramInt);
  
  public abstract void updateKeywordReqTime(EmoticonKeywords paramEmoticonKeywords);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmoticonManagerService
 * JD-Core Version:    0.7.0.1
 */