import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgListHeadNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tcc
  extends slu
{
  private String jdField_a_of_type_JavaLangString;
  private List<ssm> jdField_a_of_type_JavaUtilList;
  
  public tcc(@NonNull qqstory_service.RspMsgListHeadNode paramRspMsgListHeadNode)
  {
    super(paramRspMsgListHeadNode.result);
    this.jdField_a_of_type_JavaLangString = paramRspMsgListHeadNode.list_seq.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = a(paramRspMsgListHeadNode.node_list.get());
  }
  
  private static List<ssm> a(List<qqstory_service.MsgTabNodeInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qqstory_service.MsgTabNodeInfo localMsgTabNodeInfo = (qqstory_service.MsgTabNodeInfo)paramList.next();
      ssm localssm = new ssm();
      localssm.a(localMsgTabNodeInfo);
      localArrayList.add(localssm);
    }
    return localArrayList;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<ssm> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String toString()
  {
    return "RecentTabHaloResponse{mSeq='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mMsgTabNodeInfos=" + this.jdField_a_of_type_JavaUtilList + ", errorCode=" + this.jdField_a_of_type_Int + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcc
 * JD-Core Version:    0.7.0.1
 */