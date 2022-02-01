import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.ConsumeReportItem;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.RspBody;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.TaskConfig;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.TipsItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class qre
  extends nkq
{
  public qre(RIJRedPacketManager paramRIJRedPacketManager, String paramString, int paramInt, qrg paramqrg) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 error code: " + paramInt);
    if (paramInt == 0)
    {
      oidb_0xe21.RspBody localRspBody = new oidb_0xe21.RspBody();
      boolean bool1;
      boolean bool2;
      int i2;
      boolean bool4;
      label1163:
      label1178:
      label1184:
      label1190:
      label1196:
      label1201:
      for (;;)
      {
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          paramInt = -1;
          if (localRspBody.result_code.has()) {
            paramInt = localRspBody.result_code.get();
          }
          if (paramInt >= 0)
          {
            paramArrayOfByte = this.jdField_a_of_type_JavaLangString;
            i = this.jdField_a_of_type_Int;
            int n = 0;
            paramInt = 0;
            j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager.a();
            boolean bool3 = true;
            bool1 = true;
            long l1 = 0L;
            long l2 = l1;
            int m = j;
            int i1 = i;
            paramBundle = paramArrayOfByte;
            if (localRspBody.rpt_consume_report_item.has())
            {
              if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rowkey.has()) {
                paramArrayOfByte = ((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rowkey.get();
              }
              if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).current_rowkey_progress.has()) {
                paramInt = ((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).current_rowkey_progress.get();
              }
              if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).current_rowkey_incr_progress.has()) {
                i = ((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).current_rowkey_incr_progress.get();
              }
              if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).current_progress.has()) {
                j = ((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).current_progress.get();
              }
              if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).need_record.has())
              {
                if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).need_record.get() != 1) {
                  break label1219;
                }
                bool1 = true;
                break label1201;
              }
              if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).next_request_time.has()) {
                l1 = ((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).next_request_time.get() * 1000L;
              }
              bool3 = bool1;
              l2 = l1;
              m = j;
              n = paramInt;
              i1 = i;
              paramBundle = paramArrayOfByte;
              if (localRspBody.rpt_consume_report_item.has())
              {
                bool3 = bool1;
                l2 = l1;
                m = j;
                n = paramInt;
                i1 = i;
                paramBundle = paramArrayOfByte;
                if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rpt_tips_items.has())
                {
                  bool3 = bool1;
                  l2 = l1;
                  m = j;
                  n = paramInt;
                  i1 = i;
                  paramBundle = paramArrayOfByte;
                  if (((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rpt_tips_items.get().size() > 0)
                  {
                    bool3 = bool1;
                    l2 = l1;
                    m = j;
                    n = paramInt;
                    i1 = i;
                    paramBundle = paramArrayOfByte;
                    if (((oidb_0xe21.TipsItem)((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rpt_tips_items.get().get(0)).has())
                    {
                      bool3 = bool1;
                      l2 = l1;
                      m = j;
                      n = paramInt;
                      i1 = i;
                      paramBundle = paramArrayOfByte;
                      if (((oidb_0xe21.TipsItem)((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rpt_tips_items.get().get(0)).tips.has())
                      {
                        String str = ((oidb_0xe21.TipsItem)((oidb_0xe21.ConsumeReportItem)localRspBody.rpt_consume_report_item.get()).rpt_tips_items.get().get(0)).tips.get();
                        pfd.a().a(true, str);
                        bool3 = bool1;
                        l2 = l1;
                        m = j;
                        n = paramInt;
                        i1 = i;
                        paramBundle = paramArrayOfByte;
                        if (this.jdField_a_of_type_Qrg != null)
                        {
                          this.jdField_a_of_type_Qrg.a(true, str);
                          paramBundle = paramArrayOfByte;
                          i1 = i;
                          n = paramInt;
                          m = j;
                          l2 = l1;
                          bool3 = bool1;
                        }
                      }
                    }
                  }
                }
              }
            }
            i = 0;
            paramInt = 0;
            j = 0;
            k = 0;
            if (localRspBody.task_config.has())
            {
              if (!localRspBody.task_config.article_max_time.has()) {
                break label1196;
              }
              paramInt = localRspBody.task_config.article_max_time.get();
              RIJRedPacketManager.a().d(paramInt);
              if (!localRspBody.task_config.total_cycle.has()) {
                break label1190;
              }
              i = localRspBody.task_config.total_cycle.get();
              RIJRedPacketManager.a().e(i);
              if (!localRspBody.task_config.article_still_max_time.has()) {
                break label1184;
              }
              j = localRspBody.task_config.article_still_max_time.get();
              RIJRedPacketManager.a().c(j);
              if (!localRspBody.task_config.total_progress.has()) {
                break label1178;
              }
              k = localRspBody.task_config.total_progress.get();
              RIJRedPacketManager.a().b(k);
              paramArrayOfByte = localRspBody.task_config.rpt_record_article_type.get().iterator();
              bool2 = false;
              bool1 = false;
              if (paramArrayOfByte.hasNext())
              {
                i2 = ((Integer)paramArrayOfByte.next()).intValue();
                if (i2 != 1) {
                  break label1225;
                }
                bool4 = true;
                bool1 = bool2;
                bool2 = bool4;
                break;
              }
              RIJRedPacketManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager, bool1);
              RIJRedPacketManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager, bool2);
              i2 = i;
              i = paramInt;
              paramInt = i2;
            }
            QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 rspbody: rowkey: " + paramBundle + "\n increase rowkey progress: " + i1 + "\n global currentProgress: " + m + "\n totalProgress: " + k + "\n can do task: " + bool3 + "\n next request can do task Time: " + l2 + "\n total cycle: " + paramInt + "\n article still max time: " + j + "\n article max time: " + i);
            paramInt = Math.max(i1, n);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager.a(paramBundle, paramInt);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager.a(paramBundle);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager.b(paramBundle);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager.a(m);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager.a(bool3, l2);
            return;
          }
          QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 retCode " + paramInt + " report fail");
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          QLog.i("RIJRedPacketManager", 1, paramArrayOfByte.toString());
          return;
        }
        bool4 = bool1;
        bool1 = bool2;
        bool2 = bool4;
        break;
        int k = 0;
        continue;
        int j = 0;
        continue;
        int i = 0;
        continue;
        paramInt = 0;
      }
      for (;;)
      {
        bool4 = bool2;
        bool2 = bool1;
        bool1 = bool4;
        break;
        label1219:
        bool1 = false;
        break label1201;
        label1225:
        if (i2 != 2) {
          break label1163;
        }
        bool4 = true;
        bool2 = bool1;
        bool1 = bool4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qre
 * JD-Core Version:    0.7.0.1
 */