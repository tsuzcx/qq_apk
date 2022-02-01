import android.util.Base64;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.ReqBody;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetReq;
import tencent.kandian.ugc.topic_info.TopicInfo;

public class rzo
  implements rzk
{
  private QQAppInterface a;
  
  public rzo(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(@NotNull ColumnInfo paramColumnInfo, rzi paramrzi, int paramInt)
  {
    oidb_0xe33.TopicInfoSetReq localTopicInfoSetReq;
    if (QLog.isColorLevel())
    {
      if (paramInt == 1) {
        QLog.e("RIJUGC.ManagerColumnModel", 2, "ManageColumnModel createColumn: columnInfo : " + paramColumnInfo.toString());
      }
    }
    else
    {
      localTopicInfoSetReq = new oidb_0xe33.TopicInfoSetReq();
      if (paramInt != 1) {
        break label155;
      }
      localTopicInfoSetReq.operate_type.set(1);
    }
    for (;;)
    {
      localTopicInfoSetReq.info.set(paramColumnInfo.parseToTopicInfo());
      paramColumnInfo = new oidb_0xe33.ReqBody();
      paramColumnInfo.topic_info_set_req.set(localTopicInfoSetReq);
      ntb.a(this.a, new rzp(this, paramrzi, paramInt), paramColumnInfo.toByteArray(), "OidbSvc.0xe33", 3635, 1);
      return;
      if (paramInt != 2) {
        break;
      }
      QLog.e("RIJUGC.ManagerColumnModel", 2, "ManageColumnModel editColumn: columnInfo : " + paramColumnInfo.toString());
      break;
      label155:
      if (paramInt == 2) {
        localTopicInfoSetReq.operate_type.set(2);
      }
    }
  }
  
  @Nullable
  public ColumnInfo a()
  {
    Object localObject1 = (String)bmhv.a("key_sp_readinjoy_column_info_sketch", "");
    if (((String)localObject1).isEmpty()) {
      return null;
    }
    topic_info.TopicInfo localTopicInfo = new topic_info.TopicInfo();
    try
    {
      localTopicInfo.mergeFrom(Base64.decode((String)localObject1, 0));
      localObject1 = new ColumnInfo(localTopicInfo);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.ManagerColumnModel", 1, "getColumnSketch exception, e=" + localException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  public void a()
  {
    bmhv.a("key_sp_readinjoy_column_info_sketch", "");
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo)
  {
    bmhv.a("key_sp_readinjoy_column_info_sketch", Base64.encodeToString(paramColumnInfo.parseToTopicInfo().toByteArray(), 0));
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, rzi paramrzi)
  {
    a(paramColumnInfo, paramrzi, 1);
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, rzi paramrzi)
  {
    a(paramColumnInfo, paramrzi, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzo
 * JD-Core Version:    0.7.0.1
 */