import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ExitAIOAttributes;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class mva
  implements Runnable
{
  public mva(List paramList, int paramInt, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        UserOperationModule localUserOperationModule = new UserOperationModule(null, null, null, ReadInJoyMSFService.a(), null);
        Object localObject2;
        Object localObject3;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(0);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("UnreadMsg");
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 == null) || (!((QQAppInterface)localObject1).isLogin())) {
            continue;
          }
          localObject3 = ((QQAppInterface)localObject1).a();
          if (localObject3 == null) {
            break label806;
          }
          i = ((QQMessageFacade)localObject3).b();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(i));
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(100);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FolderStatus");
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(ReadInJoyUtils.d));
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(101);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KDInScreen");
          localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
          if (ReadInJoyUtils.c((QQAppInterface)localObject1))
          {
            localObject1 = String.valueOf(1);
            ((PBStringField)localObject3).set((String)localObject1);
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            localObject1 = new oidb_cmd0x80a.AttributeList();
            ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(106);
            ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("LastRedExposureTime");
            ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(ReadInJoyUtils.a + ":" + ReadInJoyUtils.d);
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
            localObject2 = new oidb_cmd0x80a.AttributeList();
            ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(107);
            ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("dt_red");
            localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
            if (!ReadinjoySPEventReport.a()) {
              continue;
            }
            localObject1 = String.valueOf(1);
            ((PBStringField)localObject3).set((String)localObject1);
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            localObject1 = new oidb_cmd0x80a.AttributeList();
            ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(108);
            ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("last_inforeground_time");
            ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(ReadinjoySPEventReport.a() / 1000L));
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
            localObject1 = new oidb_cmd0x80a.AttributeList();
            ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(109);
            ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("last_in_aio_time");
            ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(ReadinjoySPEventReport.b() / 1000L));
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
            localObject1 = ReadinjoySPEventReport.a().a();
            if (localObject1 != null)
            {
              ((ReadinjoySPEventReport.ExitAIOAttributes)localObject1).b.att_id.set(110);
              this.jdField_a_of_type_JavaUtilList.add(((ReadinjoySPEventReport.ExitAIOAttributes)localObject1).b);
            }
            localObject1 = PublicAccountUtil.b();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new oidb_cmd0x80a.AttributeList();
              ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(102);
              ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KDAttrL");
              ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            this.jdField_a_of_type_JavaUtilList.addAll(ReadinjoySPEventReport.a().a());
          }
        }
        else
        {
          localObject1 = "KDreportPushEffectEvent info : eventId:" + Integer.toString(this.jdField_a_of_type_Int) + "; eventName :" + this.jdField_a_of_type_JavaLangString + "; AttributeList:[";
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (oidb_cmd0x80a.AttributeList)((Iterator)localObject2).next();
          localObject1 = (String)localObject1 + "{ att_id:" + Integer.toString(((oidb_cmd0x80a.AttributeList)localObject3).att_id.get()) + "; att_name:" + ((oidb_cmd0x80a.AttributeList)localObject3).att_name.get() + "; att_value:" + ((oidb_cmd0x80a.AttributeList)localObject3).att_value.get() + " },";
          continue;
        }
        Object localObject1 = String.valueOf(0);
        continue;
        localObject1 = String.valueOf(0);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountUtil", 2, (String)localObject1);
        }
        localUserOperationModule.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("PublicAccountUtil", 2, "reportPushEffectEvent", localException);
        AIOUtils.a("reportPushEffectEvent", "reportPushEffectEvent", localException);
        return;
      }
      label806:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mva
 * JD-Core Version:    0.7.0.1
 */