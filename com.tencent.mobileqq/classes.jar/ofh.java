import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

public class ofh
{
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public ofh a(qq_ad.QQAdGetRsp.RedPointInfo paramRedPointInfo)
  {
    int j = 0;
    int i;
    if (paramRedPointInfo.begin_time.has())
    {
      i = paramRedPointInfo.begin_time.get();
      this.c = i;
      if (!paramRedPointInfo.task_id.has()) {
        break label172;
      }
      i = paramRedPointInfo.task_id.get();
      label43:
      this.jdField_a_of_type_Int = i;
      if (!paramRedPointInfo.tab_id.has()) {
        break label177;
      }
      i = paramRedPointInfo.tab_id.get();
      label66:
      this.b = i;
      if (!paramRedPointInfo.end_time.has()) {
        break label182;
      }
      i = paramRedPointInfo.end_time.get();
      label89:
      this.d = i;
      if (!paramRedPointInfo.delay_second.has()) {
        break label187;
      }
      i = paramRedPointInfo.delay_second.get();
      label112:
      this.e = i;
      i = j;
      if (paramRedPointInfo.red_type.has()) {
        i = paramRedPointInfo.red_type.get();
      }
      this.f = i;
      if (!paramRedPointInfo.red_url.has()) {
        break label192;
      }
    }
    label172:
    label177:
    label182:
    label187:
    label192:
    for (paramRedPointInfo = paramRedPointInfo.red_url.get();; paramRedPointInfo = "")
    {
      this.jdField_a_of_type_JavaLangString = paramRedPointInfo;
      return this;
      i = 0;
      break;
      i = 0;
      break label43;
      i = 0;
      break label66;
      i = 0;
      break label89;
      i = 0;
      break label112;
    }
  }
  
  public String toString()
  {
    return "RedPointInfo{mTashId=" + this.jdField_a_of_type_Int + ", mTabId=" + this.b + ", mBeginTime=" + this.c + ", mEndTime=" + this.d + ", mDelaySeconds=" + this.e + ", mRedType=" + this.f + ", mRedUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofh
 * JD-Core Version:    0.7.0.1
 */