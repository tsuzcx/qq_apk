package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import java.io.File;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ICommonUsedSystemEmojiManagerService
  extends IRuntimeService
{
  public abstract void copySystemEmojiFileToFileV2(File paramFile1, File paramFile2);
  
  public abstract List<EmosmPb.SmallYellowItem> getCacheInfo();
  
  public abstract List<EmosmPb.SmallYellowItem> getCommonUsedSystemEmojiInfo();
  
  public abstract List<EmosmPb.SmallYellowItem> getLocalSystemEmojiInfoFromFile();
  
  public abstract List<EmosmPb.SmallYellowItem> getPaddedData(List<EmosmPb.SmallYellowItem> paramList);
  
  public abstract List<EmosmPb.SmallYellowItem> mergeAndSortSystemEmojiInfo(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2);
  
  public abstract List<EmosmPb.SmallYellowItem> mergeList(List<EmosmPb.SmallYellowItem> paramList);
  
  public abstract void saveSystemEmojiInfoToCahce(EmosmPb.SmallYellowItem paramSmallYellowItem);
  
  public abstract void saveSystemEmojiInfoToFile();
  
  public abstract void updateItemInfo(List<EmosmPb.SmallYellowItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
 * JD-Core Version:    0.7.0.1
 */