package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import azqs;
import bbcx;
import bbei;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import ndd;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class TribeVideoListPlayerFragment$12$1
  implements Runnable
{
  public TribeVideoListPlayerFragment$12$1(bbcx parambbcx) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        HttpResponse localHttpResponse = ndd.a(BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_Bbei.h, null, "GET", null, null);
        if ((localHttpResponse != null) && (localHttpResponse.getStatusLine().getStatusCode() == 200)) {
          TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.post(new TribeVideoListPlayerFragment.12.1.1(this));
        }
      }
      catch (IOException localIOException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TribeVideoListPlayerFragment", 2, "negative ad error: e= " + localIOException.toString());
      }
      try
      {
        azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_dislike_suc", this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e, 0, "" + this.a.jdField_a_of_type_Bbei.a.report_info.trace_info.aid.get(), "" + (this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.indexOf(this.a.jdField_a_of_type_Bbei) + 1), "", "");
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("TribeVideoListPlayerFragment", 2, "negative ad report error: e= " + localException.toString());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.12.1
 * JD-Core Version:    0.7.0.1
 */