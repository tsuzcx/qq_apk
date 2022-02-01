package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class EmoticonPackage
  extends Entity
  implements IEmoticonPackage, Serializable
{
  public static final int BUSINESS_GUIDE_FLAG = 4;
  public static final String EMOTION_RSC_TYPE = "rscType";
  public static final int EmoticonPkgNeverUpdateBit = 2;
  public static final int EmoticonPkgRedPointBit = 4;
  public static final int EmoticonPkgUpdateBit = 1;
  public static final int FEE_TYEE_ACTIVITY = 6;
  public static final int FEE_TYEE_FREE = 1;
  public static final int FEE_TYEE_LIMIT_FREE = 3;
  public static final int FEE_TYEE_PAY = 2;
  public static final int FEE_TYEE_SVIP = 5;
  public static final int FEE_TYEE_VIP = 4;
  public static final int JOB_H5_MAGIC = 5;
  public static final int JOB_MAGIC = 3;
  public static final int JOB_NORMAL = 0;
  public static final int JOB_QFACE = 2;
  public static final int JOB_QFACE_MATERIAL = 1;
  public static final int JOB_SMALL = 4;
  public static final String MAGIC_FACE_EPID = "100000";
  public static final int ORIGINAL_FLAG = 1;
  public static final int RSC_TYPE_APNG = 2;
  public static final int RSC_TYPE_GIF = 0;
  public static final int RSC_TYPE_PNGZIP = 1;
  public static final int RSC_TYPE_UNKNOWN = -1;
  public static final int SUBTYPE_DIY = 4;
  public static final int SUBTYPE_SOUND = 1;
  public static final int TAB_TYPE_GIF = 3;
  public static final int TAB_TYPE_H5_MAGIC = 4;
  public static final int TAB_TYPE_MAGIC = 1;
  public static final int TAB_TYPE_PNG = 2;
  public static final int TYPE_MAGIC = 1;
  public static final int WIFI_AUTODOWNLOAD_CLOSE = -3;
  public static final int WIFI_AUTO_DOWNLOAD_FLAG = 2;
  private static final long serialVersionUID = -3944948432927289738L;
  public boolean aio = false;
  public String author;
  public long beginTime;
  public String businessExtra;
  public String buttonWording;
  public String childEpId;
  public String comeFom;
  public String copywritingContent;
  public int copywritingType;
  public String diversionName;
  public int downloadCount;
  public long endTime;
  @unique
  public String epId;
  public long expiretime;
  public int extraFlags;
  public String firstEmotionId;
  public boolean hasIpProduct;
  public boolean hasReadUpdatePage;
  public boolean hasSound;
  public String imageUrl;
  public String ipDetail;
  public String ipJumpUrl;
  public long ipLastReqTime;
  public String ipName;
  public String ipOpName;
  public long ipReqTime;
  public VipIPSiteInfo ipSiteInfo;
  public byte[] ipSiteInfoBytes;
  public String ipUrl;
  public int isAPNG;
  public boolean isMagicFaceDownloading;
  public boolean isRecommendation;
  public int jobType;
  @defaultzero
  public int jsonVersion;
  public String jumpUrl;
  public boolean kandian = false;
  public String kinId;
  public int latestVersion;
  public int localVersion;
  public String mark;
  public String minQQVersion;
  public int mobileFeetype;
  public String name;
  public boolean newSoundEp;
  public long richIPLastReqTime;
  public long richIPReqTime;
  public int rscType = 0;
  public int status;
  public int subType;
  public String supportSize;
  public int type;
  public int updateFlag;
  public String updateTip;
  public int upperLeftLable;
  public boolean valid;
  public long wordingId;
  
  public boolean isNewVoiceType()
  {
    return this.newSoundEp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmoticonPackage [epId=");
    localStringBuilder.append(this.epId);
    localStringBuilder.append(", wordingId=");
    localStringBuilder.append(this.wordingId);
    localStringBuilder.append(", childEpId=");
    localStringBuilder.append(this.childEpId);
    localStringBuilder.append(", minQQVersion=");
    localStringBuilder.append(this.minQQVersion);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", mark=");
    localStringBuilder.append(this.mark);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", author=");
    localStringBuilder.append(this.author);
    localStringBuilder.append(", expiretime=");
    localStringBuilder.append(this.expiretime);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", hasSound=");
    localStringBuilder.append(this.hasSound);
    localStringBuilder.append(", jobType=");
    localStringBuilder.append(this.jobType);
    localStringBuilder.append(", kinId=");
    localStringBuilder.append(this.kinId);
    localStringBuilder.append(", valid=");
    localStringBuilder.append(this.valid);
    localStringBuilder.append(", downloadCount=");
    localStringBuilder.append(this.downloadCount);
    localStringBuilder.append(", mobileFeetype=");
    localStringBuilder.append(this.mobileFeetype);
    localStringBuilder.append(", isRecommendation=");
    localStringBuilder.append(this.isRecommendation);
    localStringBuilder.append(", isMagicFaceDownloading=");
    localStringBuilder.append(this.isMagicFaceDownloading);
    localStringBuilder.append(", firstEmotionId=");
    localStringBuilder.append(this.firstEmotionId);
    localStringBuilder.append(", upperLeftLable=");
    localStringBuilder.append(this.upperLeftLable);
    localStringBuilder.append(", localVersion=");
    localStringBuilder.append(this.localVersion);
    localStringBuilder.append(", latestVersion=");
    localStringBuilder.append(this.latestVersion);
    localStringBuilder.append(", jsonVersion=");
    localStringBuilder.append(this.jsonVersion);
    localStringBuilder.append(", updateFlag=");
    localStringBuilder.append(this.updateFlag);
    localStringBuilder.append(", updateTip=");
    localStringBuilder.append(this.updateTip);
    localStringBuilder.append(", hasReadUpdatePage=");
    localStringBuilder.append(this.hasReadUpdatePage);
    localStringBuilder.append(", rscType=");
    localStringBuilder.append(this.rscType);
    localStringBuilder.append(", supportSize=");
    localStringBuilder.append(this.supportSize);
    localStringBuilder.append(", isAPNG = ");
    localStringBuilder.append(this.isAPNG);
    localStringBuilder.append("， aio =");
    localStringBuilder.append(this.aio);
    localStringBuilder.append(", kandian = ");
    localStringBuilder.append(this.kandian);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonPackage
 * JD-Core Version:    0.7.0.1
 */