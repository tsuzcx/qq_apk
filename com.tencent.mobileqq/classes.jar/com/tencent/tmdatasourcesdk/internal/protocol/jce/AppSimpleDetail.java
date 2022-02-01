package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class AppSimpleDetail
  extends JceStruct
{
  static ArrayList<ApkDownUrl> cache_apkDownUrl;
  public ArrayList<ApkDownUrl> apkDownUrl = null;
  public long apkId = 0L;
  public String apkMd5 = "";
  public long appId = 0L;
  public String appName = "";
  public String channelId = "";
  public String diffApkMd5 = "";
  public long diffFileSize = 0L;
  public long fileSize = 0L;
  public String iconUrl = "";
  public String packageName = "";
  public String signatureMd5 = "";
  public int versionCode = 0;
  public String versionName = "";
  
  public AppSimpleDetail() {}
  
  public AppSimpleDetail(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, long paramLong3, ArrayList<ApkDownUrl> paramArrayList, String paramString7, long paramLong4, String paramString8)
  {
    this.appId = paramLong1;
    this.apkId = paramLong2;
    this.appName = paramString1;
    this.iconUrl = paramString2;
    this.packageName = paramString3;
    this.versionName = paramString4;
    this.versionCode = paramInt;
    this.signatureMd5 = paramString5;
    this.apkMd5 = paramString6;
    this.fileSize = paramLong3;
    this.apkDownUrl = paramArrayList;
    this.diffApkMd5 = paramString7;
    this.diffFileSize = paramLong4;
    this.channelId = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.apkId = paramJceInputStream.read(this.apkId, 1, false);
    this.appName = paramJceInputStream.readString(2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
    this.packageName = paramJceInputStream.readString(4, false);
    this.versionName = paramJceInputStream.readString(5, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 6, false);
    this.signatureMd5 = paramJceInputStream.readString(7, false);
    this.apkMd5 = paramJceInputStream.readString(8, false);
    this.fileSize = paramJceInputStream.read(this.fileSize, 9, false);
    if (cache_apkDownUrl == null)
    {
      cache_apkDownUrl = new ArrayList();
      ApkDownUrl localApkDownUrl = new ApkDownUrl();
      cache_apkDownUrl.add(localApkDownUrl);
    }
    this.apkDownUrl = ((ArrayList)paramJceInputStream.read(cache_apkDownUrl, 10, false));
    this.diffApkMd5 = paramJceInputStream.readString(11, false);
    this.diffFileSize = paramJceInputStream.read(this.diffFileSize, 12, false);
    this.channelId = paramJceInputStream.readString(13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.apkId, 1);
    Object localObject = this.appName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.iconUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.packageName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.versionName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.versionCode, 6);
    localObject = this.signatureMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.apkMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.fileSize, 9);
    localObject = this.apkDownUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    localObject = this.diffApkMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    paramJceOutputStream.write(this.diffFileSize, 12);
    localObject = this.channelId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail
 * JD-Core Version:    0.7.0.1
 */