package com.tencent.mobileqq.kandian.biz.ugc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.kandian.base.ktx.RIJSerializableKtxKt;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.UgcVideoInfo;

public class UgcVideo
  extends Entity
  implements Parcelable, Serializable, Comparable<UgcVideo>
{
  public static final Parcelable.Creator<UgcVideo> CREATOR = new UgcVideo.1();
  public static int RETRY_TIME_LIMIT = 3;
  public static int STATUS_FAILED = 3;
  public static int STATUS_FINISH = 2;
  public static int STATUS_IDLE = 0;
  public static int STATUS_PAUSE = 4;
  public static int STATUS_UPLOADING = 1;
  public static int SUBSTATUS_COMPRESS_VIDEO = 1;
  public static int SUBSTATUS_IDLE_VIDEO = 0;
  public static int SUBSTATUS_UPLOADING_VIDEO = 2;
  public static final String TAG = "UgcVideo";
  public static int TYPE_NO_PUBLIC = 3;
  public static int TYPE_PUBLIC = 2;
  public static int TYPE_PUBLIC_AND_REMIND = 1;
  public String address = "";
  public long bitrate = 0L;
  public String brief = "";
  public int businessType = 4;
  public byte[] byteArray;
  public boolean canUploadInMobileNet = false;
  public long columnId = 0L;
  public String compressPath = "";
  public int compressProgress = 0;
  public long compressTime = 0L;
  public int coverHeight = 0;
  public String coverPath = "";
  public int coverProgress = 0;
  public String coverUrl = "";
  public int coverWidth = 0;
  public int duration = 0;
  public String fileMd5 = "";
  public String filePath = "";
  public long fileSize = 0L;
  public int fromForReport;
  public int height = 0;
  public long insertTime = 0L;
  public String kdCommunityId;
  public long lastUploadSize = 0L;
  public long lastUploadSizeUpdateTime = 0L;
  public byte[] multiTitleStructBytes;
  public boolean needShowPublishToast;
  public boolean pauseBySwitchNet = false;
  public int publicType = TYPE_PUBLIC;
  public boolean reprintDisable = false;
  public int retryTime = 0;
  public String rowkey = "";
  @unique
  public String seqId = "";
  public long startCompressTime = 0L;
  public long startUploadingTime = 0L;
  public long startUserWaitingTime = 0L;
  public int status = STATUS_IDLE;
  public String title = "";
  public String uploadSpeed = "0KB/S";
  public long uploadTotalCostTime = 0L;
  public int uploadType;
  public int uploadVideoStatus = SUBSTATUS_IDLE_VIDEO;
  public String url = "";
  public long userWaitingTotalCostTime = 0L;
  public int videoProgress = 0;
  public int videoPublishType = 0;
  public String videoUploadKey;
  public int width = 0;
  
  public UgcVideo()
  {
    this.needShowPublishToast = true;
  }
  
  protected UgcVideo(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.needShowPublishToast = true;
    this.seqId = paramParcel.readString();
    this.insertTime = paramParcel.readLong();
    this.filePath = paramParcel.readString();
    this.compressPath = paramParcel.readString();
    this.coverPath = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.rowkey = paramParcel.readString();
    this.businessType = paramParcel.readInt();
    this.compressProgress = paramParcel.readInt();
    this.coverProgress = paramParcel.readInt();
    this.videoProgress = paramParcel.readInt();
    this.videoUploadKey = paramParcel.readString();
    this.compressTime = paramParcel.readLong();
    this.startUploadingTime = paramParcel.readLong();
    this.startUserWaitingTime = paramParcel.readLong();
    this.uploadTotalCostTime = paramParcel.readLong();
    this.userWaitingTotalCostTime = paramParcel.readLong();
    this.bitrate = paramParcel.readLong();
    this.uploadVideoStatus = paramParcel.readInt();
    this.lastUploadSize = paramParcel.readLong();
    this.lastUploadSizeUpdateTime = paramParcel.readLong();
    this.uploadSpeed = paramParcel.readString();
    this.retryTime = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.url = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.coverWidth = paramParcel.readInt();
    this.coverHeight = paramParcel.readInt();
    this.columnId = paramParcel.readLong();
    this.duration = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fileSize = paramParcel.readLong();
    this.fileMd5 = paramParcel.readString();
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.reprintDisable = bool1;
    this.publicType = paramParcel.readByte();
    this.startCompressTime = paramParcel.readLong();
    this.fromForReport = paramParcel.readInt();
    this.uploadType = paramParcel.readInt();
    this.address = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.multiTitleStructBytes = new byte[i];
      paramParcel.readByteArray(this.multiTitleStructBytes);
    }
    this.kdCommunityId = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.needShowPublishToast = bool1;
    this.videoPublishType = paramParcel.readInt();
  }
  
  public UgcVideo(oidb_0xe2a.UgcVideoInfo paramUgcVideoInfo)
  {
    boolean bool = true;
    this.needShowPublishToast = true;
    this.title = paramUgcVideoInfo.bytes_title.get().toStringUtf8();
    this.url = paramUgcVideoInfo.bytes_url.get().toStringUtf8();
    this.coverUrl = paramUgcVideoInfo.bytes_cover_url.get().toStringUtf8();
    this.brief = paramUgcVideoInfo.bytes_brief.get().toStringUtf8();
    this.coverWidth = paramUgcVideoInfo.uint32_cover_width.get();
    this.coverHeight = paramUgcVideoInfo.uint32_cover_height.get();
    this.columnId = paramUgcVideoInfo.uint64_column_id.get();
    this.duration = paramUgcVideoInfo.uint32_duration.get();
    this.width = paramUgcVideoInfo.uint32_width.get();
    this.height = paramUgcVideoInfo.uint32_height.get();
    this.fileSize = paramUgcVideoInfo.uint64_file_size.get();
    this.fileMd5 = paramUgcVideoInfo.bytes_file_md5.get().toStringUtf8();
    this.videoPublishType = paramUgcVideoInfo.uint32_type.get();
    if (paramUgcVideoInfo.uint32_reprint_disable.get() != 1) {
      bool = false;
    }
    this.reprintDisable = bool;
    this.publicType = paramUgcVideoInfo.uint32_remind_friends.get();
    this.uploadType = paramUgcVideoInfo.uint32_upload_type.get();
    setMultiTitleStruct(biuMultiLevelToBiuCommentInfo(paramUgcVideoInfo.biu_multi_level));
    this.address = paramUgcVideoInfo.bytes_position.get().toStringUtf8();
  }
  
  private articlesummary.BiuMultiLevel biuCommentInfoToBiuMultiLevel(List<BiuCommentInfo> paramList)
  {
    articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
    if (paramList == null) {
      return localBiuMultiLevel;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramList.get(i);
      articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
      PBBytesField localPBBytesField = localBiuOneLevelItem.bytes_biu_comments;
      if (localBiuCommentInfo.mBiuComment != null) {
        localObject = localBiuCommentInfo.mBiuComment;
      } else {
        localObject = "";
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      Object localObject = convertJumpInfo(localBiuCommentInfo.jumpInfo);
      if (localObject != null) {
        localBiuOneLevelItem.msg_jump_info.set((MessageMicro)localObject);
      }
      localBiuOneLevelItem.op_type.set(localBiuCommentInfo.mOpType);
      localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.mUin.longValue());
      localArrayList.add(localBiuOneLevelItem);
      i -= 1;
    }
    localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
    return localBiuMultiLevel;
  }
  
  private ArrayList<BiuCommentInfo> biuMultiLevelToBiuCommentInfo(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
    while (localIterator.hasNext())
    {
      articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)localIterator.next();
      BiuCommentInfo localBiuCommentInfo = new BiuCommentInfo();
      if (localBiuOneLevelItem.bytes_biu_comments.get() != null) {
        paramBiuMultiLevel = localBiuOneLevelItem.bytes_biu_comments.get().toStringUtf8();
      } else {
        paramBiuMultiLevel = "";
      }
      localBiuCommentInfo.mBiuComment = paramBiuMultiLevel;
      localBiuCommentInfo.jumpInfo = convertJumpInfo(localBiuOneLevelItem.msg_jump_info);
      localBiuCommentInfo.mOpType = localBiuOneLevelItem.op_type.get();
      localArrayList.add(localBiuCommentInfo);
    }
    return localArrayList;
  }
  
  private JumpInfo convertJumpInfo(articlesummary.JumpInfo paramJumpInfo)
  {
    if (paramJumpInfo == null) {
      return null;
    }
    long l = paramJumpInfo.uint64_id.get();
    Object localObject = paramJumpInfo.bytes_wording.get();
    String str = "";
    if (localObject != null) {
      localObject = paramJumpInfo.bytes_wording.get().toStringUtf8();
    } else {
      localObject = "";
    }
    if (paramJumpInfo.bytes_jump_url.get() != null) {
      str = paramJumpInfo.bytes_jump_url.get().toStringUtf8();
    }
    return new JumpInfo(l, (String)localObject, str);
  }
  
  private articlesummary.JumpInfo convertJumpInfo(JumpInfo paramJumpInfo)
  {
    if (paramJumpInfo == null) {
      return null;
    }
    articlesummary.JumpInfo localJumpInfo = new articlesummary.JumpInfo();
    PBBytesField localPBBytesField = localJumpInfo.bytes_jump_url;
    Object localObject = paramJumpInfo.getJumpUrl();
    String str = "";
    if (localObject != null) {
      localObject = paramJumpInfo.getJumpUrl();
    } else {
      localObject = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localPBBytesField = localJumpInfo.bytes_wording;
    localObject = str;
    if (paramJumpInfo.getWording() != null) {
      localObject = paramJumpInfo.getWording();
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localJumpInfo.uint64_id.set(paramJumpInfo.getId());
    return localJumpInfo;
  }
  
  public int compareTo(UgcVideo paramUgcVideo)
  {
    return (int)(paramUgcVideo.insertTime - this.insertTime);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof UgcVideo)) && (this.seqId.equals(((UgcVideo)paramObject).seqId));
  }
  
  public ArrayList<BiuCommentInfo> getMultiTitleStruct()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll((ArrayList)RIJSerializableKtxKt.a(this.multiTitleStructBytes));
      return localArrayList;
    }
    catch (Exception localException)
    {
      QLog.e("UgcVideo", 1, "getMultiTitleStruct", localException);
    }
    return localArrayList;
  }
  
  public int getProgress()
  {
    return (this.compressProgress + this.coverProgress + this.videoProgress) / 3;
  }
  
  public int hashCode()
  {
    return this.seqId.hashCode();
  }
  
  public oidb_0xe2a.UgcVideoInfo parseUgcVideo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setMultiTitleStruct(ArrayList<BiuCommentInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      this.multiTitleStructBytes = RIJSerializableKtxKt.a(paramArrayList);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo
 * JD-Core Version:    0.7.0.1
 */