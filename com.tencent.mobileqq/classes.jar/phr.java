import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.ScreenShotCallback;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

class phr
  implements SwiftBrowserMiscHandler.ScreenShotCallback
{
  phr(phq paramphq) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("shareWebPage", 2, "WebView screenshot CALLBACK. imgUrl=" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
      this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localObject1);
      localObject3 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      str2 = this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      str3 = ((TicketManager)localObject3).getSkey(str2);
      l2 = System.currentTimeMillis();
      localObject2 = null;
      localObject1 = new File(paramString);
      if (((File)localObject1).exists())
      {
        l1 = ((File)localObject1).length();
        Object localObject4 = FileUtils.b(paramString);
        localObject1 = localObject2;
        if (l1 > 0L)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject1 = HttpUtil.a(NetworkUtil.a(String.format(Locale.getDefault(), "http://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d", new Object[] { localObject4, Long.valueOf(l1) }), 1007), str2, str3);
          }
        }
        l1 = System.currentTimeMillis() - l2;
        if (localObject1 != null) {
          break label1618;
        }
        localObject1 = new Pair(Integer.valueOf(-1), "");
        if (QLog.isColorLevel()) {
          QLog.d(Share.jdField_a_of_type_JavaLangString, 2, "queryImage, ret=" + ((Pair)localObject1).first + ",cost=" + l1 + ",url=" + (String)((Pair)localObject1).second);
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("report_type", "102");
        ((Bundle)localObject2).putString("act_type", "16");
        ((Bundle)localObject2).putString("intext_1", "" + ((Pair)localObject1).first);
        localObject4 = new StringBuilder().append("");
        if (((Integer)((Pair)localObject1).first).intValue() != -1) {
          break label987;
        }
        i = 0;
        ((Bundle)localObject2).putString("intext_2", i);
        ((Bundle)localObject2).putString("intext_5", "" + l1);
        ReportCenter.a().a((Bundle)localObject2, "", str2, false);
        m = 1;
        if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
          break label1002;
        }
        this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.h = ((String)((Pair)localObject1).second);
        this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.e = false;
        this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.b = 0;
        if (QLog.isColorLevel()) {
          QLog.e("shareWebPage", 2, "Share info after WebView screenshot: title=" + this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.d + ", summary=" + this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.g + ", thumb=" + this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.h + ", shareURL=" + this.a.a.jdField_a_of_type_JavaLangString);
        }
        paramString = new Bundle();
        j = 0;
        if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.h)) {
          j = 1;
        }
        i = j;
        if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.g)) {
          i = j | 0x2;
        }
        j = i;
        if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.d)) {
          j = i | 0x4;
        }
        paramString.putString("report_type", "102");
        paramString.putString("act_type", "93");
        localObject1 = new StringBuilder().append("");
        if (j != 0) {
          break label1595;
        }
        i = 0;
        label752:
        paramString.putString("intext_1", i);
        paramString.putString("intext_3", "" + ReportDef.RepUtil.b(this.a.a.jdField_a_of_type_Int));
        paramString.putString("intext_2", "" + j);
        paramString.putString("stringext_1", this.a.a.jdField_a_of_type_JavaLangString);
        ReportCenter.a().a(paramString, "", this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
        if (QLog.isColorLevel()) {
          QLog.e("shareWebPage", 2, "WebView screenshot END. thumb=" + this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.h);
        }
        Share.a(this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare, this.a.a.jdField_a_of_type_JavaLangString, this.a.a.jdField_a_of_type_Int, this.a.a.jdField_a_of_type_Boolean);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label1563:
      label1595:
      label1604:
      label1618:
      for (;;)
      {
        Object localObject3;
        String str2;
        String str3;
        long l2;
        Object localObject2;
        long l1;
        int i;
        int m;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.e("shareWebPage", 2, "WebView screenshot OutOfMemoryError.");
          continue;
          l1 = 0L;
          continue;
          label987:
          i = ((Integer)localOutOfMemoryError.first).intValue();
          continue;
          label1002:
          if (QLog.isColorLevel()) {
            QLog.e("shareWebPage", 2, "WebView screenshot UPLOAD. length=" + new File(paramString).length());
          }
          localObject2 = new HashMap();
          ((Map)localObject2).put("Connection", "keep-alive");
          ((Map)localObject2).put("Referer", "http://www.qq.com");
          ((Map)localObject2).put("Host", "cgi.connect.qq.com");
          String str1 = ((TicketManager)localObject3).getPskey(str2, "cgi.connect.qq.com");
          if (!TextUtils.isEmpty(str1)) {
            ((Map)localObject2).put("Cookie", "p_uin=" + str2 + ";p_skey=" + str1);
          }
          localObject3 = new HashMap();
          ((Map)localObject3).put("share_image", paramString);
          paramString = new Bundle();
          paramString.putString("report_type", "102");
          paramString.putString("act_type", "51");
          paramString.putString("intext_3", "1");
          paramString.putString("stringext_1", this.a.a.jdField_a_of_type_JavaLangString);
          ReportCenter.a().a(paramString, "", str2, false);
          l1 = System.currentTimeMillis();
          str1 = HttpUtil.a(NetworkUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), str2, str3, null, (Map)localObject3, (Map)localObject2);
          paramString = str1;
          if (str1 == null) {
            paramString = HttpUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", str2, str3, null, (Map)localObject3, (Map)localObject2);
          }
          if (paramString != null) {}
          for (;;)
          {
            try
            {
              paramString = new JSONObject(paramString);
              j = paramString.getInt("retcode");
              if (j != 0) {
                break label1604;
              }
            }
            catch (JSONException paramString)
            {
              try
              {
                if (!paramString.has("result")) {
                  break label1604;
                }
                paramString = paramString.getJSONObject("result").getString("url");
                if (TextUtils.isEmpty(paramString)) {
                  break label1604;
                }
                this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.h = paramString;
                this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.e = false;
                this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.b = 0;
                i = 0;
                k = i;
                i = j;
                l2 = System.currentTimeMillis();
                paramString = new Bundle();
                paramString.putString("report_type", "102");
                paramString.putString("act_type", "11");
                paramString.putString("intext_1", "" + k);
                paramString.putString("intext_2", "" + i);
                paramString.putString("intext_3", "1");
                paramString.putString("intext_5", "" + (l2 - l1));
                if (k == 1) {
                  paramString.putString("stringext_1", this.a.a.jdField_a_of_type_JavaLangString);
                }
                ReportCenter.a().a(paramString, "", str2, false);
              }
              catch (JSONException paramString)
              {
                break label1563;
              }
              paramString = paramString;
              j = 0;
            }
            i = j;
            int k = m;
            if (QLog.isColorLevel())
            {
              QLog.d(Share.jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
              i = j;
              k = m;
              continue;
              i = 1;
              break label752;
              i = 1;
              continue;
              i = 0;
              k = m;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phr
 * JD-Core Version:    0.7.0.1
 */