package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.os.Parcel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONException;
import org.json.JSONObject;

final class ReportUtil$3
  implements Runnable
{
  ReportUtil$3(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    BaseArticleInfo localBaseArticleInfo;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(this.a, 0, this.a.length);
      localParcel.setDataPosition(0);
      localBaseArticleInfo = new BaseArticleInfo(localParcel);
      try
      {
        localParcel.recycle();
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      localBaseArticleInfo = null;
    }
    if (localBaseArticleInfo == null) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = this.b;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    JSONObject localJSONObject = new JSONObject();
    if (localBaseActivity != null) {
      localJSONObject = RIJTransMergeKanDianReport.a(localBaseActivity, localBaseArticleInfo, (int)localBaseArticleInfo.mChannelID, "2");
    }
    try
    {
      localJSONObject.put("rowkey", localBaseArticleInfo.innerUniqueID);
      localJSONObject.put("duration", l1 - l2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ReportUtil.a(localBaseArticleInfo, "0X800A732", localJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.3
 * JD-Core Version:    0.7.0.1
 */