import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class nrb
  extends amle
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  boolean d;
  
  private nrb(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, String paramString) {}
  
  public nrb(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt, String paramString, long paramLong)
  {
    this(paramPublicAccountJavascriptInterface, paramInt, -1L, paramLong, false, false, 0, false, paramString);
  }
  
  public nrb(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, long paramLong)
  {
    this(paramPublicAccountJavascriptInterface, paramInt1, 10000L, paramLong, true, paramBoolean1, paramInt2, paramBoolean2, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "onConsecutiveFailure: errCode=" + paramInt1 + ", failCount=" + paramInt2);
    }
    if ((paramInt2 * 2000 < this.jdField_b_of_type_Long) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-2", "{type:1, data:null}" });
    String str = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), str, "", "");
    SosoInterface.b(this);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.jdField_a_of_type_Boolean + ", reqRawData=" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if (paramInt == 0)
      {
        double d1 = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a;
        double d2 = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:2, lat:" + d1 + ", lon:" + d2 + "}" });
        }
        for (;;)
        {
          paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.format("'%1$f,%2$f'", new Object[] { Double.valueOf(d2), Double.valueOf(d1) }) });
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-1", "{}" });
      paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
      return;
    }
    if (paramSosoLbsInfo != null) {}
    for (byte[] arrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      boolean bool;
      if (arrayOfByte != null)
      {
        if (this.d) {}
        for (;;)
        {
          try
          {
            paramSosoLbsInfo = bhoo.a(PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, arrayOfByte), "nbyvie");
            if (TextUtils.isEmpty(paramSosoLbsInfo)) {
              break label931;
            }
            bool = true;
            label363:
            if (QLog.isColorLevel()) {
              QLog.d("PAjs.location", 2, "onLocationFinish: success=" + bool + ", mUseFallback=" + this.jdField_b_of_type_Boolean);
            }
            if (!bool) {
              break label691;
            }
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:1, decrypt_padding:" + this.jdField_a_of_type_Int + ",data:\"" + paramSosoLbsInfo + "\"}" });
            paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
            azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
            if (arrayOfByte == null) {
              break;
            }
            paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
            if (paramSosoLbsInfo == null) {
              break;
            }
            paramSosoLbsInfo = paramSosoLbsInfo.getUrl();
            if ((TextUtils.isEmpty(paramSosoLbsInfo)) || (!paramSosoLbsInfo.contains("_bid=108"))) {
              break;
            }
            nco.a(null, 81, "", 0, 0, bdbi.encodeToString(arrayOfByte, 2), "", "", "");
            return;
          }
          catch (Exception paramSosoLbsInfo)
          {
            paramSosoLbsInfo.printStackTrace();
            paramSosoLbsInfo = "";
            continue;
          }
          try
          {
            if (this.jdField_a_of_type_Int == 1) {}
            for (bool = true;; bool = false)
            {
              paramSosoLbsInfo = bdbi.encodeToString(svi.a(bool, svi.a(arrayOfByte), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB"), 2);
              break;
            }
            paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
          }
          catch (Exception localException)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime == null) {}
          }
        }
      }
      for (;;)
      {
        if (paramSosoLbsInfo != null) {
          azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, paramSosoLbsInfo.getAccount(), localException.getMessage(), "", "");
        }
        paramSosoLbsInfo = "";
        break;
        label691:
        if ((this.jdField_b_of_type_Boolean) && (paramInt != -10000) && (paramInt != 2))
        {
          this.jdField_a_of_type_Boolean = false;
          long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          long l3 = this.jdField_b_of_type_Long - l1;
          if (l3 > 0L)
          {
            long l2 = this.jdField_c_of_type_Long - l1;
            l1 = l2;
            if (l2 < 0L) {
              l1 = 0L;
            }
            SosoInterface.a(new nrb(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, 0, l3, l1, false, false, 0, true, this.jdField_a_of_type_JavaLangString));
          }
          for (;;)
          {
            paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
            azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 2, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
            return;
            this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-1", "{}" });
          }
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-1", "{}" });
        paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        azmj.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
        return;
        label931:
        bool = false;
        break label363;
        paramSosoLbsInfo = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nrb
 * JD-Core Version:    0.7.0.1
 */