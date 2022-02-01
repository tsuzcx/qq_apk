package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoADItem;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

class TribeVideoListPlayerFragment$11$1
  implements Runnable
{
  TribeVideoListPlayerFragment$11$1(TribeVideoListPlayerFragment.11 param11) {}
  
  public void run()
  {
    try
    {
      HttpResponse localHttpResponse = HttpUtil.openRequest(BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoADItem.h, null, "GET", null, null);
      if ((localHttpResponse != null) && (localHttpResponse.getStatusLine().getStatusCode() == 200))
      {
        TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.11.1.1(this));
        TribeVideoListPlayerFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment, this.a.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoADItem, "ad_dislike_suc", "negative ad report error: e= ");
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TribeVideoListPlayerFragment", 2, "negative ad error: e= " + localIOException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.11.1
 * JD-Core Version:    0.7.0.1
 */