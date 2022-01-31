package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import arzy;
import awga;
import baoo;
import baou;
import baub;
import bdcs;
import bfdq;
import bfhl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import ndd;
import ndk;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardSdkShareProcessor$ImageUploadStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$ImageUploadStep$1(baou parambaou) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|run|retry=" + baou.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    String str3 = this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    byte b;
    if ((!TextUtils.isEmpty(baoo.b(this.a.jdField_b_of_type_Baoo))) && (TextUtils.isEmpty(baoo.a(this.a.jdField_b_of_type_Baoo))))
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
    long l1;
    Object localObject4;
    for (;;)
    {
      if (i != 0)
      {
        str2 = baoo.b(this.a.jdField_b_of_type_Baoo);
        localObject1 = new CompressInfo(str2, 0);
        ((CompressInfo)localObject1).f = 0;
        arzy.a("compress_local_image");
        arzy.a("compress_local_image", str3, awga.b((CompressInfo)localObject1));
        if (!TextUtils.isEmpty(((CompressInfo)localObject1).e)) {
          baoo.e(this.a.jdField_b_of_type_Baoo, ((CompressInfo)localObject1).e);
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
        localObject1 = new File(baoo.b(this.a.jdField_b_of_type_Baoo));
        if (((File)localObject1).exists())
        {
          l1 = ((File)localObject1).length();
          localObject1 = bdcs.c(baoo.b(this.a.jdField_b_of_type_Baoo));
          if ((l1 <= 0L) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label2148;
          }
          localObject1 = String.format("https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { localObject1, Long.valueOf(l1) });
          arzy.a("query_image");
          localObject1 = ndd.a(ndk.a((String)localObject1, 1007), str3, baoo.f(this.a.jdField_b_of_type_Baoo));
          localObject4 = new HashMap();
          if (localObject1 != null) {
            break label1287;
          }
          ((HashMap)localObject4).put("param_ret_code", "-1");
          ((HashMap)localObject4).put("param_need_upload", "0");
          arzy.a("query_image", str3, (HashMap)localObject4, false);
        }
      }
    }
    for (;;)
    {
      l1 = System.currentTimeMillis() - l2;
      if (localObject1 == null) {
        localObject1 = new Pair(Integer.valueOf(-1), "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|queryImage|ret=" + ((Pair)localObject1).first + ",cost=" + l1 + ",url=" + (String)((Pair)localObject1).second);
        }
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("report_type", "102");
        ((Bundle)localObject3).putString("act_type", "16");
        ((Bundle)localObject3).putString("intext_1", "" + ((Pair)localObject1).first);
        localObject4 = new StringBuilder().append("");
        label566:
        boolean bool2;
        boolean bool1;
        label784:
        int j;
        if (((Integer)((Pair)localObject1).first).intValue() == -1)
        {
          i = 0;
          ((Bundle)localObject3).putString("intext_2", i);
          ((Bundle)localObject3).putString("intext_5", "" + l1);
          bfdq.a().a((Bundle)localObject3, "", str3, false);
          bool2 = false;
          i = 0;
          if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
            break label1391;
          }
          bool1 = true;
          baoo.c(this.a.jdField_b_of_type_Baoo, (String)((Pair)localObject1).second);
          baoo.b(this.a.jdField_b_of_type_Baoo).set(true);
          l1 = System.currentTimeMillis() - l2;
          if (QLog.isColorLevel())
          {
            localObject1 = "ImageUploadStep|uploadImage|suc=" + bool1 + ",cost=" + l1 + ",localImgUrl=" + baoo.b(this.a.jdField_b_of_type_Baoo) + ",targetUrl=" + baoo.e(this.a.jdField_b_of_type_Baoo);
            if ((bool1) && (l1 <= 5000L)) {
              break label1913;
            }
            QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject1);
          }
          if (!bool1) {
            QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|uploadImage|ret=" + i + ",retry=" + baou.a(this.a));
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "11");
          localObject3 = new StringBuilder().append("");
          if (!bool1) {
            break label1924;
          }
          j = 0;
          ((Bundle)localObject1).putString("intext_1", j);
          ((Bundle)localObject1).putString("intext_2", "" + i);
          ((Bundle)localObject1).putString("intext_3", "0");
          ((Bundle)localObject1).putString("intext_5", "" + l1);
          if (!bool1)
          {
            ((Bundle)localObject1).putString("stringext_2", baoo.b(this.a.jdField_b_of_type_Baoo));
            ((Bundle)localObject1).putString("stringext_1", baoo.e(this.a.jdField_b_of_type_Baoo));
          }
          bfdq.a().a((Bundle)localObject1, "", str3, false);
          if (!bool1) {
            break label1974;
          }
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = new File(str2).toURL().toString();
              arzy.a("reuse_image_for_aio");
              bfhl.a(true, (String)localObject1, baoo.b(this.a.jdField_b_of_type_Baoo), baoo.a(this.a.jdField_b_of_type_Baoo));
              arzy.a("reuse_image_for_aio", str3, true);
              b = 1;
              localObject1 = this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long);
              if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
              {
                localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
                ((AbsShareMsg)localObject1).updateCover(baoo.a(this.a.jdField_b_of_type_Baoo));
                ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b;
                this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long, ((AbsShareMsg)localObject1).getBytes());
              }
              baoo.a(this.a.jdField_b_of_type_Baoo).set(true);
              this.a.b();
              return;
              l1 = 0L;
              break;
              label1287:
              ((HashMap)localObject4).put("param_ret_code", String.valueOf(((Pair)localObject1).first));
              if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second))
              {
                localObject3 = "0";
                label1321:
                ((HashMap)localObject4).put("param_need_upload", localObject3);
                if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
                  break label1370;
                }
              }
              label1370:
              for (bool1 = true;; bool1 = false)
              {
                arzy.a("query_image", str3, (HashMap)localObject4, bool1);
                break;
                localObject3 = "1";
                break label1321;
              }
              i = ((Integer)((Pair)localObject1).first).intValue();
              break label566;
              label1391:
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
              localHashMap2.put("share_image", baoo.b(this.a.jdField_b_of_type_Baoo));
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("report_type", "102");
              ((Bundle)localObject1).putString("act_type", "51");
              ((Bundle)localObject1).putString("intext_3", "0");
              ((Bundle)localObject1).putString("stringext_1", baoo.e(this.a.jdField_b_of_type_Baoo));
              bfdq.a().a((Bundle)localObject1, "", str3, false);
              localObject4 = new HashMap();
              ((HashMap)localObject4).put("param_is_ip_direct", "1");
              arzy.a("upload_local_thumb_image");
              localObject3 = ndd.a(ndk.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str3, baoo.f(this.a.jdField_b_of_type_Baoo), null, localHashMap2, localHashMap1, false);
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                arzy.a("upload_local_thumb_image", str3, (HashMap)localObject4, false);
                arzy.a("upload_local_thumb_image");
                localObject1 = ndd.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str3, baoo.f(this.a.jdField_b_of_type_Baoo), null, localHashMap2, localHashMap1, true);
                ((HashMap)localObject4).put("param_is_ip_direct", "0");
              }
              if (localObject1 == null) {
                break label2136;
              }
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                i = ((JSONObject)localObject1).getInt("retcode");
                if (i != 0) {
                  break label2130;
                }
              }
              catch (JSONException localJSONException1)
              {
                try
                {
                  if (!((JSONObject)localObject1).has("result")) {
                    break label2130;
                  }
                  localObject1 = ((JSONObject)localObject1).getJSONObject("result");
                  baoo.c(this.a.jdField_b_of_type_Baoo, ((JSONObject)localObject1).getString("url"));
                  baoo.b(this.a.jdField_b_of_type_Baoo).set(true);
                  bool1 = true;
                  ((HashMap)localObject4).put("param_ret_code", Integer.toString(i));
                  arzy.a("upload_local_thumb_image", str3, bool1);
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
            label1913:
            QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException1);
            break label784;
            label1924:
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
          label1974:
          if ((i == 100000) && (baoo.c(this.a.jdField_b_of_type_Baoo) < 2))
          {
            baoo.d(this.a.jdField_b_of_type_Baoo);
            baoo.d(this.a.jdField_b_of_type_Baoo, null);
            baoo.a(this.a.jdField_b_of_type_Baoo, true);
            baoo.a(this.a.jdField_b_of_type_Baoo);
            return;
          }
          if (baou.b(this.a) < 2)
          {
            ThreadManager.post(this, 8, null, true);
            return;
          }
          this.a.jdField_b_of_type_Baoo.b(9402, "upload share thumbnail fail");
          this.a.c();
          return;
          QLog.d("Q.share.ForwardSdkShareProcessor", 1, "skip ImageUploadStep change remote url : " + baoo.a(this.a.jdField_b_of_type_Baoo));
          continue;
          label2130:
          bool1 = false;
          continue;
          label2136:
          i = 0;
          bool1 = bool2;
        }
      }
      label2148:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */