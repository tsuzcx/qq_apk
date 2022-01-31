import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class klb
  implements AsyncBack
{
  public klb(BidDownloader paramBidDownloader, long paramLong) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(paramInt);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    boolean bool = true;
    int i = 0;
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if ((HtmlOffline.a != null) && (HtmlOffline.a.containsKey(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString))) {
      HtmlOffline.a.remove(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    if (paramInt == 0)
    {
      OfflinePlugin.d(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Boolean)
      {
        if (!HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString))
        {
          Util.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_JavaLangString);
          Util.a(OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
          paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 10, j);
          this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, 14, 0L, NetworkUtil.a(BidDownloader.jdField_a_of_type_AndroidContentContext), "lixian_update", "0");
          OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 14, "", "", "");
        }
      }
      else if (((this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.e)) && (!this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.b()))
      {
        QLog.e(BidDownloader.jdField_d_of_type_JavaLangString, 1, "businessId " + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString + " now un compress file error! " + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_JavaLangString);
        return;
      }
      if (2 == this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_Int)
      {
        bool = HtmlOffline.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, -1, j);
        this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      while (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Boolean)
      {
        OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 0, "", "", "");
        BaseApplicationImpl.getApplication().getSharedPreferences("bid_update_success_time", 4).edit().putLong(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, System.currentTimeMillis()).commit();
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "success update bid: " + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        }
        HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, paramInt, j, NetworkUtil.a(BidDownloader.jdField_a_of_type_AndroidContentContext), "lixian_update", this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int + "");
        return;
        if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_Boolean) {
          bool = HtmlOffline.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        }
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, j);
        this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString;
      if (bool) {}
      for (;;)
      {
        OfflinePlugin.a(paramString, "Offline_Update", j, i, "", "", "");
        break;
        i = 13;
      }
    }
    paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader;
    paramString.jdField_b_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Int < 3)
    {
      BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new klc(this));
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, j);
    this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, paramInt, j, NetworkUtil.a(BidDownloader.jdField_a_of_type_AndroidContentContext), "lixian_update", this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int + "");
    OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update", j, paramInt, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klb
 * JD-Core Version:    0.7.0.1
 */