import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
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

public class rep
  implements Cloneable
{
  public Long a;
  public List<SocializeFeedsInfo.BiuCommentInfo> a;
  public Long b;
  
  public rep()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public SpannableStringBuilder a(int paramInt, ArticleInfo paramArticleInfo, String paramString, pwf parampwf)
  {
    return SocializeFeedsInfo.a(paramInt, paramArticleInfo, paramString, parampwf, this.jdField_a_of_type_JavaUtilList);
  }
  
  public SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, pwf parampwf)
  {
    return SocializeFeedsInfo.a(paramArticleInfo, paramString, parampwf, this.jdField_a_of_type_JavaUtilList);
  }
  
  public CharSequence a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = localList.size();
    String str = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
    Object localObject;
    label82:
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
    if ((!TextUtils.isEmpty(str)) && ((str.startsWith(":")) || (str.startsWith("："))))
    {
      localObject = str.substring(1);
      localSpannableStringBuilder.append((CharSequence)localObject);
      i -= 2;
      if (i < 0) {
        break label326;
      }
      localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
      switch (localBiuCommentInfo.c)
      {
      default: 
        localObject = ReadInJoyUserInfoModule.a(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue(), null);
        if (localObject != null)
        {
          localObject = ((ReadInJoyUserInfo)localObject).nick;
          label150:
          str = "@" + (String)localObject;
          localObject = str;
          if (localBiuCommentInfo.c == 1) {
            localObject = str + " ";
          }
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            break label317;
          }
        }
        break;
      }
    }
    label264:
    label301:
    label317:
    for (str = "";; str = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
    {
      localSpannableStringBuilder.append((CharSequence)localObject).append(str);
      do
      {
        i -= 1;
        break label82;
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
      } while (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo == null);
      if (SocializeFeedsInfo.JumpInfo.a(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo) == null)
      {
        localObject = "";
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
          break label301;
        }
      }
      for (str = "";; str = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append((CharSequence)localObject).append(str);
        break;
        localObject = SocializeFeedsInfo.JumpInfo.a(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo);
        break label264;
      }
      localObject = ReadInJoyUserInfoModule.a();
      break label150;
    }
    label326:
    return localSpannableStringBuilder;
  }
  
  public rep a()
  {
    try
    {
      rep localrep = (rep)super.clone();
      try
      {
        localrep.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
          localrep.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo.a());
        }
        return localrep;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      return null;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1) {}
  }
  
  public articlesummary.BiuMultiLevel a()
  {
    articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
    if (this.jdField_a_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(this.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (this.jdField_b_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(this.jdField_b_of_type_JavaLangLong.longValue());
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
        localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.jdField_a_of_type_Int);
        localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
        if (localBiuCommentInfo.jdField_b_of_type_JavaLangLong != null) {
          localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.jdField_b_of_type_JavaLangLong.longValue());
        }
        if (!TextUtils.isEmpty(localBiuCommentInfo.jdField_b_of_type_JavaLangString)) {
          localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_b_of_type_JavaLangString));
        }
        localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.jdField_b_of_type_Int);
        localBiuOneLevelItem.op_type.set(localBiuCommentInfo.c);
        if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new articlesummary.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
        }
        localArrayList.add(localBiuOneLevelItem);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
    }
    return localBiuMultiLevel;
  }
  
  public feeds_info.BiuMultiLevel a()
  {
    feeds_info.BiuMultiLevel localBiuMultiLevel = new feeds_info.BiuMultiLevel();
    if (this.jdField_a_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(this.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (this.jdField_b_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(this.jdField_b_of_type_JavaLangLong.longValue());
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
        feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
        localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.jdField_a_of_type_Int);
        localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
        if (localBiuCommentInfo.jdField_b_of_type_JavaLangLong != null) {
          localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.jdField_b_of_type_JavaLangLong.longValue());
        }
        if (!TextUtils.isEmpty(localBiuCommentInfo.jdField_b_of_type_JavaLangString)) {
          localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_b_of_type_JavaLangString));
        }
        localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.jdField_b_of_type_Int);
        localBiuOneLevelItem.op_type.set(localBiuCommentInfo.c);
        if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
        }
        if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
        {
          localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_JavaLangString));
          localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int);
          localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_b_of_type_Int);
        }
        localArrayList.add(localBiuOneLevelItem);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
    }
    return localBiuMultiLevel;
  }
  
  public String toString()
  {
    return "BiuInfo{oriFeedId=" + this.jdField_a_of_type_JavaLangLong + "BiuCommentList=" + this.jdField_a_of_type_JavaUtilList + "oriFeedType" + this.jdField_b_of_type_JavaLangLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rep
 * JD-Core Version:    0.7.0.1
 */