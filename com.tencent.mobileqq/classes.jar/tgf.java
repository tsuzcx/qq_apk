import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class tgf
  implements Runnable
{
  public tgf(MainFragment paramMainFragment) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((MainFragment.a(this.a) != null) && (MainFragment.a(this.a).get("看点") != null))
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)MainFragment.a(this.a).get("看点")).getTag(2131362416);
          JSONObject localJSONObject = ReadInJoyUtils.a();
          if (localRedTypeInfo == null)
          {
            i = 1;
            if (i == 3)
            {
              localRedTypeInfo.red_content.get();
              localJSONObject.put("tab_status", i);
              localJSONObject.put("kandian_mode_new", VideoReporter.a());
              if (i == 3) {
                localJSONObject.put("reddot_num", localRedTypeInfo.red_content.get());
              }
              if (ReadInJoyUtils.f != 0) {
                continue;
              }
              i = 0;
              localJSONObject.put("button_state", i);
              PublicAccountReportUtils.a(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, ReadInJoyUtils.a.c, ReadInJoyUtils.a.b, localJSONObject.toString(), false);
            }
          }
          else
          {
            if (localRedTypeInfo.red_type.get() != 5) {
              break label189;
            }
            i = 3;
            continue;
          }
          continue;
          i = 1;
          continue;
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label189:
      int i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgf
 * JD-Core Version:    0.7.0.1
 */