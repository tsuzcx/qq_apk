import android.os.Bundle;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class tah
  extends tbb
{
  qqstory_service.RspFeedLikeList jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList;
  boolean jdField_a_of_type_Boolean;
  
  public tah(taf paramtaf) {}
  
  public tah(taf paramtaf, qqstory_service.RspFeedLikeList paramRspFeedLikeList, boolean paramBoolean)
  {
    super(paramRspFeedLikeList.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList = paramRspFeedLikeList;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public List<LikeEntry> a(qqstory_struct.FeedLikeInfo paramFeedLikeInfo)
  {
    paramFeedLikeInfo = paramFeedLikeInfo.like_list.get();
    ArrayList localArrayList1 = new ArrayList();
    tdl localtdl = (tdl)tcz.a(2);
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramFeedLikeInfo.size())
    {
      LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)paramFeedLikeInfo.get(i));
      if (localtdl.b(localLikeEntry.unionId) == null) {
        localArrayList2.add(new teg("", localLikeEntry.unionId));
      }
      localArrayList1.add(localLikeEntry);
      i += 1;
    }
    if (!localArrayList2.isEmpty()) {
      new tki().a(1, localArrayList2);
    }
    return localArrayList1;
  }
  
  public void a()
  {
    qqstory_struct.FeedLikeInfo localFeedLikeInfo = (qqstory_struct.FeedLikeInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList.feed_like_info.get();
    List localList = a(localFeedLikeInfo);
    this.jdField_a_of_type_Taf.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = localFeedLikeInfo.like_total_count.get();
    this.jdField_a_of_type_Taf.a.jdField_a_of_type_JavaUtilList = localList;
    this.jdField_a_of_type_Taf.a.jdField_a_of_type_Tcl.a(localList, this.jdField_a_of_type_Taf.c, this.jdField_a_of_type_Boolean, true);
    this.jdField_a_of_type_Taf.a.a(localList);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Taf.a.c();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedLikeDataProvider", 2, new Object[] { "GetLikeListResponse NetWork ErrorCode:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Taf.a.c();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedLikeDataProvider", 2, "GetLikeListResponse fails: " + paramInt + "|" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tah
 * JD-Core Version:    0.7.0.1
 */