import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVidInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class tgm
  extends syn
{
  public qqstory_service.RspMsgTabNodeVideoList a;
  public List<tfx> a;
  public tff a;
  public byte[] a;
  
  public tgm(tff paramtff, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Tff = paramtff;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (paramRspMsgTabNodeVideoList.video_list != null)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      label158:
      Object localObject4;
      if (paramtff.jdField_a_of_type_Int == 12)
      {
        ved.a("Q.qqstory:ReqMsgTabNodeVideoList", "new video list receive cookie:%s nodeInfo old size=%d, rsp.video_list size=%d", paramRspMsgTabNodeVideoList.cookie.get(), Integer.valueOf(paramtff.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramRspMsgTabNodeVideoList.video_list.size()));
        paramArrayOfByte = new HashSet();
        paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
        if (paramRspMsgTabNodeVideoList.hasNext())
        {
          localObject1 = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
          localObject2 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).feed_id.get().toStringUtf8();
          localObject3 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).video_index_list.get().iterator();
          i = 0;
          tfx localtfx;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Long)((Iterator)localObject3).next();
            localtfx = tfx.a(paramtff.jdField_a_of_type_JavaUtilList, ((Long)localObject4).longValue());
            if ((localtfx != null) && (!paramArrayOfByte.contains(localObject4))) {
              break label339;
            }
            localtfx = new tfx();
            localtfx.jdField_b_of_type_JavaLangString = ((String)localObject2);
            localtfx.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
            localtfx.jdField_a_of_type_Long = paramtff.jdField_a_of_type_JavaUtilList.size();
            localtfx.jdField_a_of_type_Boolean = false;
            if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
              localtfx.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
            }
            paramtff.jdField_a_of_type_JavaUtilList.add(localtfx);
            this.jdField_a_of_type_JavaUtilList.add(localtfx);
            paramArrayOfByte.add(localObject4);
          }
          for (;;)
          {
            i += 1;
            break label158;
            break;
            label339:
            localtfx.jdField_b_of_type_JavaLangString = ((String)localObject2);
            localtfx.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
            if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
              localtfx.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
            }
          }
        }
      }
      else
      {
        paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
        if (paramRspMsgTabNodeVideoList.hasNext())
        {
          paramArrayOfByte = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
          localObject1 = paramArrayOfByte.feed_id.get().toStringUtf8();
          localObject2 = paramArrayOfByte.video_index_list.get().iterator();
          i = 0;
          label464:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            localObject4 = tfx.a(paramtff.jdField_a_of_type_JavaUtilList, ((Long)localObject3).longValue());
            if (localObject4 != null) {
              break label537;
            }
            ved.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localObject3, paramtff.jdField_a_of_type_JavaUtilList });
          }
          for (;;)
          {
            i += 1;
            break label464;
            break;
            label537:
            ((tfx)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((tfx)localObject4).jdField_a_of_type_JavaLangString = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
            if (paramArrayOfByte.recommand_id_list.has()) {
              ((tfx)localObject4).jdField_b_of_type_Long = ((Integer)paramArrayOfByte.recommand_id_list.get(i)).intValue();
            }
          }
        }
        this.jdField_a_of_type_JavaUtilList = paramtff.jdField_a_of_type_JavaUtilList;
      }
      if (!paramtff.a()) {
        ved.d("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { paramtff.jdField_a_of_type_JavaUtilList });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgm
 * JD-Core Version:    0.7.0.1
 */