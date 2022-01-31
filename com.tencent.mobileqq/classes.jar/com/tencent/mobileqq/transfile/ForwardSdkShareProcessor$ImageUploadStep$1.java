package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import aqgh;
import auoq;
import ayqr;
import ayqx;
import aywa;
import bbdj;
import bded;
import bdhy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import nam;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardSdkShareProcessor$ImageUploadStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$ImageUploadStep$1(ayqx paramayqx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|run|retry=" + ayqx.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    String str3 = this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    byte b;
    if ((!TextUtils.isEmpty(ayqr.b(this.a.jdField_b_of_type_Ayqr))) && (TextUtils.isEmpty(ayqr.a(this.a.jdField_b_of_type_Ayqr))))
    {
      i = 1;
      if (i == 0) {
        break label217;
      }
      b = 2;
    }
    String str2;
    Object localObject1;
    label217:
    long l2;
    Object localObject2;
    long l1;
    Object localObject3;
    for (;;)
    {
      if (i != 0)
      {
        str2 = ayqr.b(this.a.jdField_b_of_type_Ayqr);
        localObject1 = new CompressInfo(str2, 0);
        ((CompressInfo)localObject1).f = 0;
        aqgh.a("compress_local_image");
        aqgh.a("compress_local_image", str3, auoq.b((CompressInfo)localObject1));
        if (!TextUtils.isEmpty(((CompressInfo)localObject1).e)) {
          ayqr.e(this.a.jdField_b_of_type_Ayqr, ((CompressInfo)localObject1).e);
        }
        if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          this.a.f();
          return;
          i = 0;
          break;
          b = 4;
          continue;
        }
        l2 = System.currentTimeMillis();
        localObject2 = null;
        localObject1 = new File(ayqr.b(this.a.jdField_b_of_type_Ayqr));
        if (((File)localObject1).exists())
        {
          l1 = ((File)localObject1).length();
          localObject3 = bbdj.c(ayqr.b(this.a.jdField_b_of_type_Ayqr));
          localObject1 = localObject2;
          if (l1 > 0L)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject1 = String.format("http://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { localObject3, Long.valueOf(l1) });
              aqgh.a("query_image");
              localObject1 = nam.a(bdhy.a((String)localObject1, 1007), str3, ayqr.f(this.a.jdField_b_of_type_Ayqr));
              localObject3 = new HashMap();
              if (localObject1 != null) {
                break label1298;
              }
              ((HashMap)localObject3).put("param_ret_code", "-1");
              ((HashMap)localObject3).put("param_need_upload", "0");
              aqgh.a("query_image", str3, (HashMap)localObject3, false);
            }
          }
          l1 = System.currentTimeMillis() - l2;
          if (localObject1 != null) {
            break label2148;
          }
          localObject1 = new Pair(Integer.valueOf(-1), "");
        }
      }
    }
    label577:
    label2133:
    label2139:
    label2148:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|queryImage|ret=" + ((Pair)localObject1).first + ",cost=" + l1 + ",url=" + (String)((Pair)localObject1).second);
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "16");
      ((Bundle)localObject2).putString("intext_1", "" + ((Pair)localObject1).first);
      localObject3 = new StringBuilder().append("");
      boolean bool2;
      boolean bool1;
      int j;
      if (((Integer)((Pair)localObject1).first).intValue() == -1)
      {
        i = 0;
        ((Bundle)localObject2).putString("intext_2", i);
        ((Bundle)localObject2).putString("intext_5", "" + l1);
        bded.a().a((Bundle)localObject2, "", str3, false);
        bool2 = false;
        i = 0;
        if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
          break label1402;
        }
        bool1 = true;
        ayqr.c(this.a.jdField_b_of_type_Ayqr, (String)((Pair)localObject1).second);
        ayqr.b(this.a.jdField_b_of_type_Ayqr).set(true);
        l1 = System.currentTimeMillis() - l2;
        if (QLog.isColorLevel())
        {
          localObject1 = "ImageUploadStep|uploadImage|suc=" + bool1 + ",cost=" + l1 + ",localImgUrl=" + ayqr.b(this.a.jdField_b_of_type_Ayqr) + ",targetUrl=" + ayqr.e(this.a.jdField_b_of_type_Ayqr);
          if ((bool1) && (l1 <= 5000L)) {
            break label1916;
          }
          QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject1);
        }
        if (!bool1) {
          QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|uploadImage|ret=" + i + ",retry=" + ayqx.a(this.a));
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("report_type", "102");
        ((Bundle)localObject1).putString("act_type", "11");
        localObject2 = new StringBuilder().append("");
        if (!bool1) {
          break label1927;
        }
        j = 0;
        ((Bundle)localObject1).putString("intext_1", j);
        ((Bundle)localObject1).putString("intext_2", "" + i);
        ((Bundle)localObject1).putString("intext_3", "0");
        ((Bundle)localObject1).putString("intext_5", "" + l1);
        if (!bool1)
        {
          ((Bundle)localObject1).putString("stringext_2", ayqr.b(this.a.jdField_b_of_type_Ayqr));
          ((Bundle)localObject1).putString("stringext_1", ayqr.e(this.a.jdField_b_of_type_Ayqr));
        }
        bded.a().a((Bundle)localObject1, "", str3, false);
        if (!bool1) {
          break label1977;
        }
        b = 1;
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            localObject1 = new File(str2).toURL().toString();
            aqgh.a("reuse_image_for_aio");
            bdhy.a(true, (String)localObject1, ayqr.b(this.a.jdField_b_of_type_Ayqr), ayqr.a(this.a.jdField_b_of_type_Ayqr));
            aqgh.a("reuse_image_for_aio", str3, true);
            localObject1 = this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
            if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
            {
              localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
              ((AbsShareMsg)localObject1).updateCover(ayqr.a(this.a.jdField_b_of_type_Ayqr));
              ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b;
              this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long, ((AbsShareMsg)localObject1).getBytes());
            }
            ayqr.a(this.a.jdField_b_of_type_Ayqr).set(true);
            this.a.b();
            return;
            l1 = 0L;
            break;
            ((HashMap)localObject3).put("param_ret_code", String.valueOf(((Pair)localObject1).first));
            if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second))
            {
              localObject2 = "0";
              ((HashMap)localObject3).put("param_need_upload", localObject2);
              if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
                break label1381;
              }
            }
            label1381:
            for (bool1 = true;; bool1 = false)
            {
              aqgh.a("query_image", str3, (HashMap)localObject3, bool1);
              break;
              localObject2 = "1";
              break label1332;
            }
            i = ((Integer)((Pair)localObject1).first).intValue();
            break label577;
            label1402:
            if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
            {
              this.a.f();
              return;
            }
            HashMap localHashMap1 = new HashMap();
            localHashMap1.put("Connection", "keep-alive");
            localHashMap1.put("Referer", "http://www.qq.com");
            localHashMap1.put("Host", "cgi.connect.qq.com");
            localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(str3, "cgi.connect.qq.com");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localHashMap1.put("Cookie", "p_uin=" + str3 + ";p_skey=" + (String)localObject1);
            }
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("share_image", ayqr.b(this.a.jdField_b_of_type_Ayqr));
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "102");
            ((Bundle)localObject1).putString("act_type", "51");
            ((Bundle)localObject1).putString("intext_3", "0");
            ((Bundle)localObject1).putString("stringext_1", ayqr.e(this.a.jdField_b_of_type_Ayqr));
            bded.a().a((Bundle)localObject1, "", str3, false);
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("param_is_ip_direct", "1");
            aqgh.a("upload_local_thumb_image");
            localObject2 = nam.a(bdhy.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), str3, ayqr.f(this.a.jdField_b_of_type_Ayqr), null, localHashMap2, localHashMap1);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              aqgh.a("upload_local_thumb_image", str3, (HashMap)localObject3, false);
              aqgh.a("upload_local_thumb_image");
              localObject1 = nam.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", str3, ayqr.f(this.a.jdField_b_of_type_Ayqr), null, localHashMap2, localHashMap1);
              ((HashMap)localObject3).put("param_is_ip_direct", "0");
            }
            if (localObject1 == null) {
              break label2139;
            }
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              i = ((JSONObject)localObject1).getInt("retcode");
              if (i != 0) {
                break label2133;
              }
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                if (!((JSONObject)localObject1).has("result")) {
                  break label2133;
                }
                localObject1 = ((JSONObject)localObject1).getJSONObject("result");
                ayqr.c(this.a.jdField_b_of_type_Ayqr, ((JSONObject)localObject1).getString("url"));
                ayqr.b(this.a.jdField_b_of_type_Ayqr).set(true);
                bool1 = true;
                ((HashMap)localObject3).put("param_ret_code", Integer.toString(i));
                aqgh.a("upload_local_thumb_image", str3, bool1);
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  String str1;
                  j = i;
                }
              }
              localJSONException1 = localJSONException1;
              j = 0;
            }
          }
          i = j;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException1.getMessage());
          i = j;
          bool1 = bool2;
          continue;
          label1916:
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException1);
          break label795;
          j = 1;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.share.ForwardSdkShareProcessor", 2, "srcPath to URL err:" + localMalformedURLException.getMessage());
          }
          str1 = str2;
          continue;
        }
        if ((i == 100000) && (ayqr.c(this.a.jdField_b_of_type_Ayqr) < 2))
        {
          ayqr.d(this.a.jdField_b_of_type_Ayqr);
          ayqr.d(this.a.jdField_b_of_type_Ayqr, null);
          ayqr.a(this.a.jdField_b_of_type_Ayqr, true);
          ayqr.a(this.a.jdField_b_of_type_Ayqr);
          return;
        }
        if (ayqx.b(this.a) < 2)
        {
          ThreadManager.post(this, 8, null, true);
          return;
        }
        this.a.jdField_b_of_type_Ayqr.b(9402, "upload share thumbnail fail");
        this.a.c();
        return;
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "skip ImageUploadStep change remote url : " + ayqr.a(this.a.jdField_b_of_type_Ayqr));
        continue;
        bool1 = false;
        continue;
        i = 0;
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */