package com.tencent.mobileqq.kandian.repo.atlas;

import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class AtlasModelImageList
  extends AtlasModel
{
  public static final String TAG = "AtlasModelImageList";
  public int biuCount;
  public long channelId;
  public int commentCount;
  public final TimeSliceHelper commentTimeMonitor = new TimeSliceHelper();
  public ByteStringMicro cookie;
  public int currentPage = 0;
  public gallery.GalleryInfo galleryInfo;
  public boolean hasMoreData = false;
  public boolean isAD;
  public int likeCount = -1;
  public AtlasModelRecommend mModelRecommend = new AtlasModelRecommend();
  public AtlasModelImageList.ParsedInfo mParsedInfo = new AtlasModelImageList.ParsedInfo();
  private long mPauseTime = -1L;
  public long noUseTime = 0L;
  public long recommendSeq = -1L;
  public String rowKey;
  public int source;
  
  public AtlasModelImageList(gallery.GalleryInfo paramGalleryInfo, boolean paramBoolean, int paramInt, String paramString)
  {
    this.type = 3;
    this.galleryInfo = paramGalleryInfo;
    this.hasMoreData = paramBoolean;
    this.source = paramInt;
    this.rowKey = paramString;
    this.mParsedInfo.a = paramGalleryInfo.uint64_article_id.get();
    this.mParsedInfo.b = paramGalleryInfo.int32_reason.get();
    this.mParsedInfo.c = String.valueOf(paramGalleryInfo.uint64_publisher_uin.get());
    this.mParsedInfo.d = paramGalleryInfo.bytes_row_key.get().toStringUtf8();
    TimeSliceHelper.a(paramString, this.commentTimeMonitor);
  }
  
  public void onPause()
  {
    this.mPauseTime = System.currentTimeMillis();
    this.commentTimeMonitor.c();
  }
  
  public void onResume()
  {
    if (this.mPauseTime > 0L)
    {
      this.noUseTime += System.currentTimeMillis() - this.mPauseTime;
      this.mPauseTime = -1L;
    }
    this.commentTimeMonitor.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rowkey :");
    localStringBuilder.append(this.rowKey);
    localStringBuilder.append(",currentPage :");
    localStringBuilder.append(this.currentPage);
    localStringBuilder.append(",mModelRecommend :");
    localStringBuilder.append(this.mModelRecommend);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasModelImageList
 * JD-Core Version:    0.7.0.1
 */