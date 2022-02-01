import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJInteractiveCardsHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ReqBody;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.RspBody;

public class qix
  extends qii
{
  public qix(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xc6d.RspBody();
    int j = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int i = 0;
    if (j == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_card_json.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(((ByteStringMicro)paramFromServiceMsg.next()).toStringUtf8());
      }
      i = paramToServiceMsg.size();
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJInteractiveCardsHandler.1(this, paramToServiceMsg));
    }
    QLog.d("RIJInteractiveCardsHandler", 1, "handle0xc6dInteractiveCards,result=" + j + " size=" + i);
  }
  
  public void a(String paramString)
  {
    Object localObject = new oidb_cmd0xc6d.ReqBody();
    if (!TextUtils.isEmpty(paramString)) {
      ((oidb_cmd0xc6d.ReqBody)localObject).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    for (;;)
    {
      localObject = qxp.a("OidbSvc.0xc6d", 3181, 1, ((oidb_cmd0xc6d.ReqBody)localObject).toByteArray());
      this.jdField_a_of_type_Qep.b((ToServiceMsg)localObject);
      QLog.d("RIJInteractiveCardsHandler", 1, "request0xc6dInteractiveAreaCards,rowKey=" + paramString);
      return;
      ((oidb_cmd0xc6d.ReqBody)localObject).bytes_row_key.set(ByteStringMicro.copyFromUtf8(""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qix
 * JD-Core Version:    0.7.0.1
 */