package cooperation.qzone.report.lp;

import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReport_dc03179
  implements LpReportInfo
{
  String appid;
  String attach_info;
  String client_time;
  String device_model;
  float exif_avg_cost;
  int exif_error_count;
  float face_avg_cost;
  int face_error_count;
  int pause_reason;
  String qua;
  int scan_photo_count;
  int scanned_exif_count;
  int scanned_face_count;
  int scanned_tag_count;
  float tag_avg_cost;
  int tag_error_count;
  int total_photo_count;
  int total_scanned_exif_count;
  int total_scanned_face_count;
  int total_scanned_tag_count;
  String uin;
  
  public String getSimpleInfo()
  {
    return "dc03179:, total_photo_count" + this.total_photo_count + ", scan_photo_count=" + this.scan_photo_count;
  }
  
  public void report(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, int paramInt8, int paramInt9, int paramInt10, float paramFloat3, int paramInt11, int paramInt12, String paramString)
  {
    LpReport_dc03179 localLpReport_dc03179 = new LpReport_dc03179();
    localLpReport_dc03179.total_photo_count = paramInt1;
    localLpReport_dc03179.scan_photo_count = paramInt2;
    localLpReport_dc03179.scanned_exif_count = paramInt3;
    localLpReport_dc03179.total_scanned_exif_count = paramInt4;
    localLpReport_dc03179.exif_avg_cost = paramFloat1;
    localLpReport_dc03179.exif_error_count = paramInt5;
    localLpReport_dc03179.scanned_tag_count = paramInt6;
    localLpReport_dc03179.total_scanned_tag_count = paramInt7;
    localLpReport_dc03179.tag_avg_cost = paramFloat2;
    localLpReport_dc03179.tag_error_count = paramInt8;
    localLpReport_dc03179.scanned_face_count = paramInt9;
    localLpReport_dc03179.total_scanned_face_count = paramInt10;
    localLpReport_dc03179.face_avg_cost = paramFloat3;
    localLpReport_dc03179.face_error_count = paramInt11;
    localLpReport_dc03179.pause_reason = paramInt12;
    localLpReport_dc03179.client_time = paramString;
    LpReportManager.getInstance().reportToDC03179(localLpReport_dc03179, false, true);
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (BaseApplicationImpl.getApplication().getRuntime().getAccount() != null)) {
      LpReportUtils.safePut(localHashMap, "uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
    LpReportUtils.safePut(localHashMap, "qua", QUA.getQUA3());
    LpReportUtils.safePut(localHashMap, "total_photo_count", this.total_photo_count);
    LpReportUtils.safePut(localHashMap, "scan_photo_count", this.scan_photo_count);
    LpReportUtils.safePut(localHashMap, "scanned_exif_count", this.scanned_exif_count);
    LpReportUtils.safePut(localHashMap, "total_scanned_exif_count", this.total_scanned_exif_count);
    LpReportUtils.safePut(localHashMap, "exif_avg_cost", String.format("%.2f", new Object[] { Float.valueOf(this.exif_avg_cost) }));
    LpReportUtils.safePut(localHashMap, "exif_error_count", this.exif_error_count);
    LpReportUtils.safePut(localHashMap, "scanned_tag_count", this.scanned_tag_count);
    LpReportUtils.safePut(localHashMap, "total_scanned_tag_count", this.total_scanned_tag_count);
    LpReportUtils.safePut(localHashMap, "tag_avg_cost", String.format("%.2f", new Object[] { Float.valueOf(this.tag_avg_cost) }));
    LpReportUtils.safePut(localHashMap, "tag_error_count", this.tag_error_count);
    LpReportUtils.safePut(localHashMap, "scanned_face_count", this.scanned_face_count);
    LpReportUtils.safePut(localHashMap, "total_scanned_face_count", this.total_scanned_face_count);
    LpReportUtils.safePut(localHashMap, "face_avg_cost", String.format("%.2f", new Object[] { Float.valueOf(this.face_avg_cost) }));
    LpReportUtils.safePut(localHashMap, "face_error_count", this.face_error_count);
    LpReportUtils.safePut(localHashMap, "pause_reason", this.pause_reason);
    LpReportUtils.safePut(localHashMap, "device_model", Build.MODEL);
    LpReportUtils.safePut(localHashMap, "appid", String.valueOf(1000027));
    LpReportUtils.safePut(localHashMap, "attach_info", this.attach_info);
    LpReportUtils.safePut(localHashMap, "client_time", this.client_time);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_dc03179
 * JD-Core Version:    0.7.0.1
 */