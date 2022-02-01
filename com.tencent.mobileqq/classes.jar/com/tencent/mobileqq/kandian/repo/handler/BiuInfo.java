package com.tencent.mobileqq.kandian.repo.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;

public class BiuInfo
  implements Cloneable
{
  public Long a;
  public List<BiuCommentInfo> a;
  public Long b;
  
  public BiuInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Long localLong = Long.valueOf(0L);
    this.jdField_a_of_type_JavaLangLong = localLong;
    this.b = localLong;
  }
  
  public BiuInfo a()
  {
    try
    {
      BiuInfo localBiuInfo = (BiuInfo)super.clone();
      Iterator localIterator;
      Object localObject;
      return localBiuInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      for (;;)
      {
        try
        {
          localBiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          localObject = localBiuInfo;
          if (localIterator.hasNext())
          {
            localObject = (BiuCommentInfo)localIterator.next();
            localBiuInfo.jdField_a_of_type_JavaUtilList.add(((BiuCommentInfo)localObject).clone());
            continue;
            localObject = null;
          }
          return localObject;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2) {}
        localCloneNotSupportedException1 = localCloneNotSupportedException1;
      }
    }
  }
  
  public articlesummary.BiuMultiLevel a()
  {
    articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
    if (this.jdField_a_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(this.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (this.b != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(this.b.longValue());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localIterator.next();
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
        localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.mBiuTime);
        localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.mUin.longValue());
        if (localBiuCommentInfo.mFeedId != null) {
          localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.mFeedId.longValue());
        }
        if (!TextUtils.isEmpty(localBiuCommentInfo.mOrigBiuComment)) {
          localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.mOrigBiuComment));
        }
        localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.mFeedsType);
        localBiuOneLevelItem.op_type.set(localBiuCommentInfo.mOpType);
        if (localBiuCommentInfo.jumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new articlesummary.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jumpInfo.getId());
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getJumpUrl()));
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getWording()));
        }
        ((List)localObject).add(localBiuOneLevelItem);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.set((List)localObject);
    }
    return localBiuMultiLevel;
  }
  
  public feeds_info.BiuMultiLevel a()
  {
    feeds_info.BiuMultiLevel localBiuMultiLevel = new feeds_info.BiuMultiLevel();
    if (this.jdField_a_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(this.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (this.b != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(this.b.longValue());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localIterator.next();
        feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
        localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.mBiuTime);
        localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.mUin.longValue());
        if (localBiuCommentInfo.mFeedId != null) {
          localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.mFeedId.longValue());
        }
        if (!TextUtils.isEmpty(localBiuCommentInfo.mOrigBiuComment)) {
          localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.mOrigBiuComment));
        }
        localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.mFeedsType);
        localBiuOneLevelItem.op_type.set(localBiuCommentInfo.mOpType);
        if (localBiuCommentInfo.jumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jumpInfo.getId());
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getJumpUrl()));
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getWording()));
        }
        if (localBiuCommentInfo.ugcVoiceInfo != null)
        {
          localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.ugcVoiceInfo.voiceUrl));
          localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.ugcVoiceInfo.duration);
          localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.ugcVoiceInfo.fileSize);
        }
        ((List)localObject).add(localBiuOneLevelItem);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.set((List)localObject);
    }
    return localBiuMultiLevel;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BiuInfo{oriFeedId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    localStringBuilder.append("BiuCommentList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append("oriFeedType");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.BiuInfo
 * JD-Core Version:    0.7.0.1
 */