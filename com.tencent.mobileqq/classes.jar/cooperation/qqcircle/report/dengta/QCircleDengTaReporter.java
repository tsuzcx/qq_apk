package cooperation.qqcircle.report.dengta;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.HashMap;

public class QCircleDengTaReporter
{
  public static final String APP_KEY = "00000VCDPV3YVLO1";
  public static final String DEBUG_APP_KEY = "LOGDEBUGKEY00001";
  public static final String TAG = "QCircleDengTaReporter";
  
  private QCircleDengTaReporter()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
    UserAction.registerTunnel(new TunnelInfo("00000VCDPV3YVLO1"));
    UserAction.setAppKey("00000VCDPV3YVLO1");
    UserAction.setLogAble(false, false);
    QLog.d("QCircleDengTaReporter", 1, "getQIMEI , qimei:" + UserAction.getQIMEI());
  }
  
  public static QCircleDengTaReporter g()
  {
    return QCircleDengTaReporter.SingletonHolder.access$100();
  }
  
  private StatisticCollector getStatisticCollector()
  {
    return StatisticCollector.getInstance(BaseApplicationImpl.getContext());
  }
  
  public void report(QCircleDengTaReporter.DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      QLog.e("QCircleDengTaReporter", 1, "DataBuilder == null");
      return;
    }
    String str;
    StringBuilder localStringBuilder;
    label65:
    Object localObject2;
    if (QCircleCommonUtil.getCurrentAccountLongUin() == 0L)
    {
      localObject1 = "";
      str = String.valueOf(localObject1);
      UserAction.setUserID(str);
      localStringBuilder = new StringBuilder();
      if (QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder) != null)
      {
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getPageIdStr())) {
          break label788;
        }
        localObject1 = "main";
        localObject2 = localStringBuilder.append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getModuleIdStr())) {
          break label799;
        }
        localObject1 = "main";
        label94:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$400(paramDataBuilder))) {
          break label810;
        }
        localObject1 = "main";
        label120:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$300(paramDataBuilder))) {
          break label818;
        }
        localObject1 = "main";
        label146:
        ((StringBuilder)localObject2).append((String)localObject1);
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("event_code", localStringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        ((HashMap)localObject2).put("qq_uin", str);
      }
      ((HashMap)localObject2).put("network_type", QCircleDengTaUtil.getNetType() + "");
      if (QCircleDengTaReporter.DataBuilder.access$500(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("qq_touin", QCircleDengTaReporter.DataBuilder.access$500(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$600(paramDataBuilder) != -1) {
        ((HashMap)localObject2).put("position_index", String.valueOf(QCircleDengTaReporter.DataBuilder.access$600(paramDataBuilder)));
      }
      if (QCircleDengTaReporter.DataBuilder.access$700(paramDataBuilder) != -1) {
        ((HashMap)localObject2).put("feed_index", String.valueOf(QCircleDengTaReporter.DataBuilder.access$700(paramDataBuilder) + 1));
      }
      ((HashMap)localObject2).put("isreaded", "1");
      if (QCircleDengTaReporter.DataBuilder.access$800(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("video_total_time", QCircleDengTaReporter.DataBuilder.access$800(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$900(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("video_play_time", QCircleDengTaReporter.DataBuilder.access$900(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder) != null)
      {
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getPageIdStr())) {
          break label826;
        }
        localObject1 = "main";
        label358:
        ((HashMap)localObject2).put("page_id", localObject1);
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getModuleIdStr())) {
          break label837;
        }
        localObject1 = "main";
        label383:
        ((HashMap)localObject2).put("module_id", localObject1);
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$400(paramDataBuilder))) {
          break label848;
        }
        localObject1 = "main";
        label405:
        ((HashMap)localObject2).put("element_id", localObject1);
        ((HashMap)localObject2).put("action_id", QCircleDengTaReporter.DataBuilder.access$300(paramDataBuilder));
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getFromPageIdStr())) {
          break label856;
        }
        localObject1 = "main";
        label442:
        ((HashMap)localObject2).put("fpage_id", localObject1);
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getFromModuleIdStr())) {
          break label867;
        }
        localObject1 = "main";
        label467:
        ((HashMap)localObject2).put("fmodule_id", localObject1);
        if (!TextUtils.isEmpty(QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getFromElementIdStr())) {
          break label878;
        }
      }
    }
    label788:
    label799:
    label810:
    label818:
    label826:
    label837:
    label848:
    label856:
    label867:
    label878:
    for (Object localObject1 = "main";; localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getFromElementIdStr())
    {
      ((HashMap)localObject2).put("felement_id", localObject1);
      ((HashMap)localObject2).put("feedid", QCircleDengTaReporter.DataBuilder.access$1000(paramDataBuilder));
      ((HashMap)localObject2).put("feed_tag", QCircleDengTaReporter.DataBuilder.access$1100(paramDataBuilder));
      ((HashMap)localObject2).put("author_uin", QCircleDengTaReporter.DataBuilder.access$1200(paramDataBuilder));
      ((HashMap)localObject2).put("feedtype1", String.valueOf(QCircleDengTaReporter.DataBuilder.access$1300(paramDataBuilder)));
      ((HashMap)localObject2).put("feedtype2", String.valueOf(QCircleDengTaReporter.DataBuilder.access$1400(paramDataBuilder)));
      ((HashMap)localObject2).put("feedtype3", String.valueOf(QCircleDengTaReporter.DataBuilder.access$1500(paramDataBuilder)));
      if (QCircleDengTaReporter.DataBuilder.access$1600(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext1", QCircleDengTaReporter.DataBuilder.access$1600(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$1700(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext2", QCircleDengTaReporter.DataBuilder.access$1700(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$1800(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext3", QCircleDengTaReporter.DataBuilder.access$1800(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$1900(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext4", QCircleDengTaReporter.DataBuilder.access$1900(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$2000(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext5", QCircleDengTaReporter.DataBuilder.access$2000(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$2100(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext6", QCircleDengTaReporter.DataBuilder.access$2100(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$2200(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext7", QCircleDengTaReporter.DataBuilder.access$2200(paramDataBuilder));
      }
      if (QCircleDengTaReporter.DataBuilder.access$2300(paramDataBuilder) != null) {
        ((HashMap)localObject2).put("ext8", QCircleDengTaReporter.DataBuilder.access$2300(paramDataBuilder));
      }
      QCircleDengTaUtil.dumpParams(localStringBuilder.toString(), (HashMap)localObject2);
      getStatisticCollector().collectPerformance("00000VCDPV3YVLO1", str, localStringBuilder.toString(), true, -1L, -1L, (HashMap)localObject2, "");
      return;
      localObject1 = Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin());
      break;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getPageIdStr();
      break label65;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getModuleIdStr();
      break label94;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$400(paramDataBuilder);
      break label120;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$300(paramDataBuilder);
      break label146;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getPageIdStr();
      break label358;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getModuleIdStr();
      break label383;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$400(paramDataBuilder);
      break label405;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getFromPageIdStr();
      break label442;
      localObject1 = QCircleDengTaReporter.DataBuilder.access$200(paramDataBuilder).getFromModuleIdStr();
      break label467;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.dengta.QCircleDengTaReporter
 * JD-Core Version:    0.7.0.1
 */