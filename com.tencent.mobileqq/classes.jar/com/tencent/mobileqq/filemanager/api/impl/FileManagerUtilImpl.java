package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.CheckResult;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.IThumbResult;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.VideoThumbInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TimeoutParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import mqq.app.AppRuntime;

public class FileManagerUtilImpl
  implements IFileManagerUtil
{
  private static String getDocFileType(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.toLowerCase();
      if (".doc|.docx|.wps|.pages|".indexOf(paramString) >= 0) {
        return "WORD";
      }
      if (".ppt|.pptx.|.dps|.keynote|".indexOf(paramString) >= 0) {
        return "PPT";
      }
      if (".xls|.xlsx|.et|.numbers|".indexOf(paramString) >= 0) {
        return "EXCEL";
      }
      if (".pdf|".indexOf(paramString) >= 0) {
        return "PDF";
      }
      return HardCodeUtil.a(2131692586);
    }
    return HardCodeUtil.a(2131692586);
  }
  
  private String getGroupName(String paramString, int paramInt)
  {
    String str = HardCodeUtil.a(2131692586);
    if (paramInt != 3)
    {
      if (paramInt != 11) {
        return str;
      }
      return getOtherFileType(paramString);
    }
    return getDocFileType(paramString);
  }
  
  private static String getOtherFileType(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.toLowerCase();
      if (".rar|.zip|.7z|.iso|.tar|.gz|".indexOf(paramString) >= 0) {
        return HardCodeUtil.a(2131692590);
      }
      if (".txt|.html|.lit|.wdl|.ceb|.pdg|.epub|.caj|.umd|.jar|.mobi|".indexOf(paramString) >= 0) {
        return HardCodeUtil.a(2131692588);
      }
      if (".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|".indexOf(paramString) >= 0) {
        return HardCodeUtil.a(2131692585);
      }
      return HardCodeUtil.a(2131692583);
    }
    return HardCodeUtil.a(2131692583);
  }
  
  public void addCloseButtonSessionId(long paramLong)
  {
    QQFileManagerUtilImpl.a(paramLong);
  }
  
  public int addExternalFileToFMRecv(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public void addShortcut(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramContext, paramString1, paramString2, paramInt);
  }
  
  public void associateLocalWithCloud(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramFileManagerEntity);
  }
  
  public boolean bShowFlowDlg(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    return QQFileManagerUtilImpl.a(paramBoolean, paramArrayList);
  }
  
  public boolean bZip(int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramInt);
  }
  
  public String binToHEX(ByteStringMicro paramByteStringMicro)
  {
    return QQFileManagerUtilImpl.a(paramByteStringMicro);
  }
  
  public int binanrySearch(List<FileInfo> paramList, long paramLong)
  {
    return QQFileManagerUtilImpl.a(paramList, paramLong);
  }
  
  public void calcFileDescription(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramTextView, paramFileManagerEntity);
  }
  
  public boolean canCreateThumb(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.f(paramFileManagerEntity);
  }
  
  public boolean canPreview(Context paramContext, String paramString, long paramLong)
  {
    return QQFileManagerUtilImpl.a(paramContext, paramString, paramLong);
  }
  
  public int chechFileType(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.b(paramFileManagerEntity);
  }
  
  public int chechZipFileType(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.c(paramFileManagerEntity);
  }
  
  public void checkFileExisted(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, QQFileManagerUtil.CheckResult paramCheckResult)
  {
    QQFileManagerUtilImpl.a(paramFileManagerEntity, paramBaseQQAppInterface, paramCheckResult);
  }
  
  public boolean checkMultiFileBubbleClickable(ChatMessage paramChatMessage, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    return QQFileManagerUtilImpl.a(paramChatMessage, paramBaseQQAppInterface, paramContext);
  }
  
  public void clearAllRecentFileForTest() {}
  
  public void clearRememberPicSelectForQlink(Context paramContext)
  {
    QQFileManagerUtilImpl.a(paramContext);
  }
  
  public void correctFileInfo(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.b(paramFileManagerEntity);
  }
  
  public FileManagerEntity createFileRecordForMultiMsg(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramChatMessage);
  }
  
  public void createMediThumbnail(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.c(paramFileManagerEntity);
  }
  
  public String createMediaThumbnail(String paramString, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult)
  {
    return QQFileManagerUtilImpl.a(paramString, paramInt1, paramInt2, paramIThumbResult);
  }
  
  public String createVideoThumbPath(String paramString)
  {
    return QQFileManagerUtilImpl.f(paramString);
  }
  
  public String cutLongLongFileName(String paramString, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramString, paramInt);
  }
  
  public String cutLongName(String paramString)
  {
    return QQFileManagerUtilImpl.d(paramString);
  }
  
  public void dealWithErrCode(String paramString)
  {
    QQFileManagerUtilImpl.a(paramString);
  }
  
  public boolean dealWithErrCode(int paramInt, String paramString)
  {
    return QQFileManagerUtilImpl.a(paramInt, paramString);
  }
  
  public void dealWithErrCodeById(int paramInt)
  {
    QQFileManagerUtilImpl.a(paramInt);
  }
  
  public void dealWithTransFileFaild(long paramLong, int paramInt, String paramString)
  {
    QQFileManagerUtilImpl.a(paramLong, paramInt, paramString);
  }
  
  public void dealWithTransFileSuc(long paramLong)
  {
    QQFileManagerUtilImpl.c(paramLong);
  }
  
  public void delCloseButtonSessionId(long paramLong)
  {
    QQFileManagerUtilImpl.b(paramLong);
  }
  
  public int delExternalFileFromFMRecv(String paramString)
  {
    return QQFileManagerUtilImpl.b(paramString);
  }
  
  public void downloadUniformQQBrowser(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQFileManagerUtilImpl.a(paramContext, paramString, paramBundle);
  }
  
  public String enCodecString(String paramString)
  {
    return QQFileManagerUtilImpl.e(paramString);
  }
  
  public boolean fileExist(String paramString)
  {
    return QQFileManagerUtilImpl.b(paramString);
  }
  
  public boolean fileWhetherExpire(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.a(paramFileManagerEntity);
  }
  
  public String filesizeToString(long paramLong)
  {
    return QQFileManagerUtilImpl.a(paramLong);
  }
  
  public void fillFileMessageRecord(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    QQFileManagerUtilImpl.a(paramChatMessage, paramMessageForFile);
  }
  
  public boolean filterFiles(String paramString1, String paramString2)
  {
    return QQFileManagerUtilImpl.a(paramString1, paramString2);
  }
  
  public void fixEntityThumbSize(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.d(paramFileManagerEntity);
  }
  
  public void forwardRencentFiles(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    QQFileManagerUtilImpl.a(paramList, paramActivity);
  }
  
  public long genMsgSeq()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public long genMsgUid()
  {
    return QQFileManagerUtilImpl.b();
  }
  
  public Long genSessionId()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public byte[] get3SHA(String paramString)
  {
    return QQFileManagerUtilImpl.b(paramString);
  }
  
  public ArrayList<FileInfo> getAllFMRecvFiles(boolean paramBoolean, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramBoolean, paramInt);
  }
  
  public Map<String, File> getAllStorageLocations(Context paramContext)
  {
    return QQFileManagerUtilImpl.a(paramContext);
  }
  
  public BaseQQAppInterface getApp()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public Bitmap getCircleFaceBitmap(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramContext, paramBitmap, paramInt);
  }
  
  public SpannableString getClickableTips(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    return QQFileManagerUtilImpl.a(paramString1, paramString2, paramTipsClickedInterface);
  }
  
  public IForwardCallBack getDatalineProcessCallBack(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramInt);
  }
  
  public HashMap<String, String> getDocsImportConfigGroupFromStr(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public long getDocsImportFileMaxSize(String paramString)
  {
    return QQFileManagerUtilImpl.b(paramString);
  }
  
  public String getFMDownloadPath()
  {
    return QQFileManagerUtilImpl.b();
  }
  
  public int getFileIconResId(int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramInt);
  }
  
  public int getFileIconResId(int paramInt1, int paramInt2)
  {
    return QQFileManagerUtilImpl.a(paramInt1, paramInt2);
  }
  
  public int getFileIconResId(String paramString)
  {
    return QQFileManagerUtilImpl.c(paramString);
  }
  
  public FileManagerEntity getFileManagerEntityByMsgFile(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramMessageForFile);
  }
  
  public String getFileName(String paramString)
  {
    return QQFileManagerUtilImpl.b(paramString);
  }
  
  public String getFileOperationTypeToPeer(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.e(paramFileManagerEntity);
  }
  
  public FileManagerEntity getFileRecordForMultiMsg(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramLong, paramString, paramInt, paramChatMessage);
  }
  
  public String getFileSizeInvalidTime(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.d(paramFileManagerEntity);
  }
  
  public long getFileSizes(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public int getFileSrcCloudType(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.a(paramFileManagerEntity);
  }
  
  public String getFileSuffix(String paramString)
  {
    return QQFileManagerUtilImpl.g(paramString);
  }
  
  public int getFileType(String paramString)
  {
    return QQFileManagerUtilImpl.d(paramString);
  }
  
  public String getFileType(int paramInt)
  {
    return QQFileManagerUtilImpl.b(paramInt);
  }
  
  public int getFileTypeFromMultiMsgRecord(ChatMessage paramChatMessage)
  {
    return QQFileManagerUtilImpl.a(paramChatMessage);
  }
  
  public byte[] getFullMd5(String paramString)
  {
    return QQFileManagerUtilImpl.e(paramString);
  }
  
  public String getHardCodeConfig(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public String getImageUrl(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.b(paramFileManagerEntity);
  }
  
  public byte[] getMd5(String paramString)
  {
    return QQFileManagerUtilImpl.c(paramString);
  }
  
  public byte[] getMd5(String paramString, long paramLong)
  {
    return QQFileManagerUtilImpl.a(paramString, paramLong);
  }
  
  public int[] getMediaFileWidthHeight(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public String getMultiFileThumbPath(ChatMessage paramChatMessage)
  {
    return QQFileManagerUtilImpl.a(paramChatMessage);
  }
  
  public String getPeerNick(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public String getQQStr(int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramInt);
  }
  
  public int getQlinkIntroShowTime(String paramString)
  {
    return QQFileManagerUtilImpl.e(paramString);
  }
  
  public String getReportFileTypeStr(int paramInt)
  {
    return QQFileManagerUtilImpl.c(paramInt);
  }
  
  public AppRuntime getRuntime()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public byte[] getSHA(String paramString)
  {
    return QQFileManagerUtilImpl.d(paramString);
  }
  
  public FileManagerEntity getSelectedEntity()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public byte[] getSha3(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public void getSortMap(TreeMap<Long, FileInfo> paramTreeMap, int paramInt, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap1, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap2, List<FileInfo> paramList)
  {
    if (paramTreeMap == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramTreeMap = paramTreeMap.entrySet().iterator();
    while (paramTreeMap.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)((Map.Entry)paramTreeMap.next()).getValue();
      if (localFileInfo == null) {
        return;
      }
      paramList.add(0, localFileInfo);
      if (paramLinkedHashMap2 != null)
      {
        str = getGroupName(QQFileManagerUtilImpl.g(localFileInfo.d()), paramInt);
        if (!paramLinkedHashMap2.containsKey(str)) {
          paramLinkedHashMap2.put(str, new ArrayList());
        }
        ((List)paramLinkedHashMap2.get(str)).add(localFileInfo);
      }
      long l = localFileInfo.b();
      String str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(l);
      if (!localHashMap.containsValue(str)) {
        localHashMap.put(str, Integer.valueOf((int)(l / 1000L)));
      } else if (((Integer)localHashMap.get(str)).intValue() > l) {
        localHashMap.put(str, Integer.valueOf((int)(l / 1000L)));
      }
      if (!localLinkedHashMap.containsKey(str)) {
        localLinkedHashMap.put(str, new ArrayList());
      }
      ((List)localLinkedHashMap.get(str)).add(localFileInfo);
    }
    paramTreeMap = new ArrayList(localHashMap.entrySet());
    Collections.sort(paramTreeMap, new FileManagerUtilImpl.1(this));
    paramTreeMap = paramTreeMap.iterator();
    while (paramTreeMap.hasNext())
    {
      paramLinkedHashMap2 = (Map.Entry)paramTreeMap.next();
      paramList = (List)localLinkedHashMap.get(paramLinkedHashMap2.getKey());
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new FileManagerUtilImpl.2(this));
        paramLinkedHashMap1.put(paramLinkedHashMap2.getKey(), paramList);
      }
    }
  }
  
  public int getStatus(int paramInt)
  {
    return QQFileManagerUtilImpl.b(paramInt);
  }
  
  public byte[] getTempSessionSig(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramString, paramInt);
  }
  
  public long getTempSessionType(int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramInt);
  }
  
  public TimeoutParam getTimeOutParamer()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public long getWeiyunZipTargetId(long paramLong)
  {
    return QQFileManagerUtilImpl.a(paramLong);
  }
  
  public String getZipThumbSavePath(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.a(paramFileManagerEntity);
  }
  
  public String getZipThumbUrlWithFileUrl(String paramString)
  {
    return QQFileManagerUtilImpl.h(paramString);
  }
  
  public String handleLongFileName(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    return QQFileManagerUtilImpl.a(paramString, paramBoolean, paramInt1, paramTextPaint, paramInt2);
  }
  
  public boolean hasNoThumb(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.b(paramFileManagerEntity);
  }
  
  public boolean hasShortCut(Context paramContext, String paramString)
  {
    return QQFileManagerUtilImpl.a(paramContext, paramString);
  }
  
  public boolean hasThumb(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.e(paramFileManagerEntity);
  }
  
  public String hexToString(byte[] paramArrayOfByte)
  {
    return QQFileManagerUtilImpl.a(paramArrayOfByte);
  }
  
  public boolean ifShowFileMask(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.a(paramContext, paramFileManagerEntity);
  }
  
  public void initNoMedia() {}
  
  public void initSaveToPc(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramChatMessage, paramContext);
  }
  
  public boolean initSaveToWeiYun(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramChatMessage, paramContext);
  }
  
  public boolean initSaveToWeiYun(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramChatMessage, paramContext, paramBoolean);
  }
  
  public void installApkFile(Context paramContext, String paramString)
  {
    QQFileManagerUtilImpl.c(paramContext, paramString);
  }
  
  public boolean is2GOr3G()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public boolean isBuddyIntroShow(String paramString1, String paramString2)
  {
    return QQFileManagerUtilImpl.b(paramString1, paramString2);
  }
  
  public boolean isContainChinese(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public boolean isDebugVersion()
  {
    return QQFileManagerUtilImpl.d();
  }
  
  public boolean isImportLocaFilesForH5(Context paramContext)
  {
    return QQFileManagerUtilImpl.a(paramContext);
  }
  
  public boolean isLocalFile(String paramString)
  {
    return QQFileManagerUtilImpl.c(paramString);
  }
  
  public boolean isMultiMessageSender(BaseQQAppInterface paramBaseQQAppInterface, ChatMessage paramChatMessage)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramChatMessage);
  }
  
  public boolean isPreDownloadThumb()
  {
    return QQFileManagerUtilImpl.b();
  }
  
  public boolean isSameDay(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    return QQFileManagerUtilImpl.a(paramLong1, paramLong2, paramTimeZone);
  }
  
  public boolean isSelectedFavImageEntity()
  {
    return QQFileManagerUtilImpl.c();
  }
  
  public boolean isSupportFavorite(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.c(paramFileManagerEntity);
  }
  
  public boolean isTroopFile(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.d(paramFileManagerEntity);
  }
  
  public LinkedHashMap jsonToMap(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public String mapToJson(Map paramMap)
  {
    return QQFileManagerUtilImpl.a(paramMap);
  }
  
  public String millsTimeToString(long paramLong, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramLong, paramInt);
  }
  
  public FileManagerEntity newEntityByFav(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramString6, paramInt);
  }
  
  public FileManagerEntity newEntityByLocalFileInfo(FileInfo paramFileInfo)
  {
    return QQFileManagerUtilImpl.a(paramFileInfo);
  }
  
  public FileManagerEntity newEntityByOfflineFileInfo(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    return QQFileManagerUtilImpl.a(paramOfflineFileInfo, paramInt);
  }
  
  public FileManagerEntity newEntityByWeiYunFileInfo(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return QQFileManagerUtilImpl.a(paramWeiYunFileInfo);
  }
  
  public FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle paramBundle)
  {
    return QQFileManagerUtilImpl.a(paramBundle);
  }
  
  public void onDatalineForward(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, int paramInt)
  {
    QQFileManagerUtilImpl.a(paramFileManagerEntity, paramBaseQQAppInterface, paramActivity, paramInt);
  }
  
  public void onQlinkFileErrIconClicked(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramContext, paramFileManagerEntity);
  }
  
  public void openFileWithOtherAppWithSystem(Context paramContext, String paramString)
  {
    QQFileManagerUtilImpl.b(paramContext, paramString);
  }
  
  public void openWithOtherApp(Activity paramActivity, String paramString)
  {
    QQFileManagerUtilImpl.a(paramActivity, paramString);
  }
  
  public void preLoadThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramFileManagerEntity);
  }
  
  public String printFileManagerEntityInfo(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtilImpl.c(paramFileManagerEntity);
  }
  
  public String printStack()
  {
    return QQFileManagerUtilImpl.a();
  }
  
  public void processAIOTimGraytips(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramLong);
  }
  
  public String recreateFilePath(String paramString)
  {
    return QQFileManagerUtilImpl.c(paramString);
  }
  
  public boolean renameFile(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    return QQFileManagerUtilImpl.a(paramVFSFile1, paramVFSFile2);
  }
  
  public boolean renameFile(File paramFile1, File paramFile2)
  {
    return QQFileManagerUtilImpl.a(paramFile1, paramFile2);
  }
  
  public void reportFileAssistans(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramContext);
  }
  
  public void reportFilemanagerFaildInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10);
  }
  
  public void reportFilemanagerFaildInfoEx(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, paramBundle);
  }
  
  public void reportFilemanagerSuccessInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6);
  }
  
  public void reportFilemanagerSuccessInfoEx(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, paramBundle);
  }
  
  public String reportSrcType(int paramInt1, int paramInt2)
  {
    return QQFileManagerUtilImpl.a(paramInt1, paramInt2);
  }
  
  public void resume(Context paramContext, FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    QQFileManagerUtilImpl.a(paramContext, paramFileManagerEntity, paramBaseQQAppInterface, paramBoolean);
  }
  
  public void saveQlinkIntroShowTime(String paramString, int paramInt)
  {
    QQFileManagerUtilImpl.a(paramString, paramInt);
  }
  
  public void saveToAlbum(Context paramContext, String paramString)
  {
    QQFileManagerUtilImpl.a(paramContext, paramString);
  }
  
  public void setBuddyIntroShow(String paramString1, String paramString2, boolean paramBoolean)
  {
    QQFileManagerUtilImpl.a(paramString1, paramString2, paramBoolean);
  }
  
  public void setFileIcon(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramImageView, paramFileManagerEntity);
  }
  
  public void setFileIcon(ImageView paramImageView, String paramString)
  {
    QQFileManagerUtilImpl.a(paramImageView, paramString);
  }
  
  public void setFileIcon(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public void setFileIcon(AsyncImageView paramAsyncImageView, String paramString)
  {
    QQFileManagerUtilImpl.a(paramAsyncImageView, paramString);
  }
  
  public void setFileIcon(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    QQFileManagerUtilImpl.a(paramAsyncImageView, paramString, paramInt);
  }
  
  public void setFileIcon(AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    QQFileManagerUtilImpl.a(paramAsyncImageView, paramString, paramBoolean);
  }
  
  public void setTempParam(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
  }
  
  public void setZipImageFileIcon(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtilImpl.b(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public void showFlowDialog(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    QQFileManagerUtilImpl.a(paramBoolean, paramContext, paramFMDialogInterface);
  }
  
  public void showFlowDialog(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt)
  {
    QQFileManagerUtilImpl.a(paramBoolean, paramContext, paramFMDialogInterface, paramInt);
  }
  
  public void startLoadingAnim(Activity paramActivity, TextView paramTextView)
  {
    QQFileManagerUtilImpl.a(paramActivity, paramTextView);
  }
  
  public void stopLoadingAnim(TextView paramTextView)
  {
    QQFileManagerUtilImpl.a(paramTextView);
  }
  
  public QQFileManagerUtil.VideoThumbInfo syncCreateVideoThumb(String paramString)
  {
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public void updateBatProcessTips(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public String updateRecentListTxt(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramMessage);
  }
  
  public String updateRecentListTxtByMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return QQFileManagerUtilImpl.a(paramBaseQQAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileManagerUtilImpl
 * JD-Core Version:    0.7.0.1
 */