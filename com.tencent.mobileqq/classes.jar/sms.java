import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class sms
  extends soi
{
  qqstory_service.RspGetCommentList jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList;
  
  public sms(sml paramsml) {}
  
  public sms(sml paramsml, qqstory_service.RspGetCommentList paramRspGetCommentList)
  {
    super(paramRspGetCommentList.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList = paramRspGetCommentList;
  }
  
  public void a()
  {
    boolean bool = false;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.comment_list.get();
    ArrayList localArrayList = new ArrayList();
    sml.a(this.jdField_a_of_type_Sml, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.cookie.get().toStringUtf8());
    sqs localsqs = (sqs)sqg.a(2);
    int i = 0;
    if (i < ((List)localObject).size())
    {
      CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((List)localObject).get(i));
      QQUserUIItem localQQUserUIItem = localsqs.c(localCommentEntry.authorUnionId);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable()))
      {
        localCommentEntry.authorName = tfy.b;
        label114:
        if (!TextUtils.isEmpty(localCommentEntry.replyUin))
        {
          localQQUserUIItem = localsqs.c(localCommentEntry.replierUnionId);
          if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
            break label187;
          }
        }
      }
      label187:
      for (localCommentEntry.replierName = tfy.b;; localCommentEntry.replierName = localQQUserUIItem.nickName)
      {
        localArrayList.add(localCommentEntry);
        i += 1;
        break;
        localCommentEntry.authorName = localQQUserUIItem.nickName;
        break label114;
      }
    }
    localObject = this.jdField_a_of_type_Sml;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.is_end.get() == 1) {
      bool = true;
    }
    ((sml)localObject).jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Sml.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.total_comment_num.get();
    this.jdField_a_of_type_Sml.jdField_a_of_type_Smz.a(localArrayList);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Sml.jdField_a_of_type_Smz.d();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedCommentDataProvider", 2, new Object[] { "ReqGetCommentList NetWork ErrorCode:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Sml.jdField_a_of_type_Smz.d();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedCommentDataProvider", 2, "ReqGetCommentList fails: " + paramInt + "|" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sms
 * JD-Core Version:    0.7.0.1
 */