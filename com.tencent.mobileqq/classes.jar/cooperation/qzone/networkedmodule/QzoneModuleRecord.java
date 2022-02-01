package cooperation.qzone.networkedmodule;

import android.text.TextUtils;

public class QzoneModuleRecord
{
  public final String mClassIds;
  public final int mClassIdsCount;
  public final String mKeyClassName;
  public final String mMD5;
  public final String mMainVersion;
  public long mModuleFileLength;
  public final String mModuleId;
  public QzoneModuleRecord mNewVersion;
  public final String mQua;
  public final String mUrl;
  public final String mVersion;
  
  public QzoneModuleRecord(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong, QzoneModuleRecord paramQzoneModuleRecord)
  {
    this.mModuleId = paramString1;
    this.mVersion = paramString2;
    this.mMainVersion = paramString3;
    this.mQua = paramString3;
    this.mUrl = paramString4;
    this.mMD5 = paramString5;
    this.mKeyClassName = paramString6;
    this.mNewVersion = paramQzoneModuleRecord;
    this.mClassIds = paramString7;
    this.mClassIdsCount = paramInt;
    this.mModuleFileLength = paramLong;
  }
  
  private static boolean isEqual(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 != null)
    {
      if ((paramObject2 == null) && ((paramObject1 instanceof String)) && (TextUtils.isEmpty((String)paramObject1))) {
        return true;
      }
      return paramObject1.equals(paramObject2);
    }
    return ((paramObject2 instanceof String)) && (TextUtils.isEmpty((String)paramObject2));
  }
  
  public QzoneModuleRecord getDownloadRecord()
  {
    QzoneModuleRecord localQzoneModuleRecord = this.mNewVersion;
    if (localQzoneModuleRecord != null) {
      return localQzoneModuleRecord;
    }
    return this;
  }
  
  public boolean hasNewConfig()
  {
    QzoneModuleRecord localQzoneModuleRecord = this.mNewVersion;
    return (localQzoneModuleRecord != null) && ((!isEqual(this.mVersion, localQzoneModuleRecord.mVersion)) || (!isEqual(this.mMainVersion, this.mNewVersion.mMainVersion)) || (!isEqual(this.mUrl, this.mNewVersion.mUrl)) || (!isEqual(this.mMD5, this.mNewVersion.mMD5)) || (!isEqual(this.mKeyClassName, this.mNewVersion.mKeyClassName)) || (!isEqual(this.mQua, this.mNewVersion.mQua)) || (!isEqual(this.mClassIds, this.mNewVersion.mClassIds)) || (this.mClassIdsCount != this.mNewVersion.mClassIdsCount));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleRecord
 * JD-Core Version:    0.7.0.1
 */