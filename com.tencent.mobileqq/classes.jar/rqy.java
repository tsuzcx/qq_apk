import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;

public class rqy
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  public int c = 1;
  
  public rqy(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  private void a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    int j = 0;
    long l;
    int i;
    label63:
    String str;
    if (paramSocializeFeedsInfo.msg_master_uin.has())
    {
      l = qdv.a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint64_uin);
      this.jdField_a_of_type_Long = l;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label190;
      }
      i = qdv.a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).enum_uin_type);
      this.jdField_a_of_type_Int = i;
      i = j;
      if (paramSocializeFeedsInfo.msg_master_uin.has()) {
        i = qdv.a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint32_star_style);
      }
      this.b = i;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label202;
      }
      if (!paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.has()) {
        break label195;
      }
      str = paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.get().toStringUtf8();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = str;
      if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (paramSocializeFeedsInfo.msg_master_uin.uint32_is_real_user.has())) {
        this.c = paramSocializeFeedsInfo.msg_master_uin.uint32_is_real_user.get();
      }
      return;
      l = 0L;
      break;
      label190:
      i = 0;
      break label63;
      label195:
      str = "";
      continue;
      label202:
      str = "";
    }
  }
  
  public rqy a()
  {
    try
    {
      rqy localrqy = (rqy)super.clone();
      return localrqy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    return "uin=" + this.jdField_a_of_type_Long + "type=" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqy
 * JD-Core Version:    0.7.0.1
 */