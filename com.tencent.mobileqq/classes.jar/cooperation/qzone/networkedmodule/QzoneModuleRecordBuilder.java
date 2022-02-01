package cooperation.qzone.networkedmodule;

import android.text.TextUtils;

public class QzoneModuleRecordBuilder
{
  private String classIds;
  private int classIdsCount;
  private String keyClassName = "";
  private String mainVersion;
  private String md5 = "";
  private long moduleFileLength;
  private String moduleId;
  private QzoneModuleRecord newVersion;
  private String url;
  private String version;
  
  public QzoneModuleRecord build()
  {
    if (!TextUtils.isEmpty(this.moduleId)) {
      return new QzoneModuleRecord(this.moduleId, this.version, this.mainVersion, this.url, this.md5, this.keyClassName, this.classIds, this.classIdsCount, this.moduleFileLength, this.newVersion);
    }
    throw new IllegalArgumentException("moduleId can not be null");
  }
  
  public QzoneModuleRecordBuilder setClassIds(String paramString)
  {
    this.classIds = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder setClassIdsCount(int paramInt)
  {
    this.classIdsCount = paramInt;
    return this;
  }
  
  public QzoneModuleRecordBuilder setKeyClassName(String paramString)
  {
    this.keyClassName = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder setMD5(String paramString)
  {
    this.md5 = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder setMainVersion(String paramString)
  {
    this.mainVersion = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder setModuleFileLength(long paramLong)
  {
    this.moduleFileLength = paramLong;
    return this;
  }
  
  public QzoneModuleRecordBuilder setModuleId(String paramString)
  {
    this.moduleId = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder setNewVersion(QzoneModuleRecord paramQzoneModuleRecord)
  {
    this.newVersion = paramQzoneModuleRecord;
    return this;
  }
  
  public QzoneModuleRecordBuilder setUrl(String paramString)
  {
    this.url = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder setVersion(String paramString)
  {
    this.version = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleRecordBuilder
 * JD-Core Version:    0.7.0.1
 */