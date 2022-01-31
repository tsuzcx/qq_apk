import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.ResponseCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SpellTool;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

public final class mrs
  implements Runnable
{
  public mrs(boolean paramBoolean, String paramString1, String paramString2, String paramString3, FastWebRequestUtil.ResponseCallback paramResponseCallback) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    Object localObject4 = new HashMap();
    String str2 = ((QQAppInterface)localObject1).getAccount();
    Object localObject3 = ((TicketManager)((QQAppInterface)localObject1).getManager(2)).getSkey(str2);
    label111:
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = "0";
      ((Map)localObject4).put("puin", localObject1);
      ((Map)localObject4).put("id", this.b);
      ((Map)localObject4).put("tag", this.c);
      if (localObject3 != null) {
        break label460;
      }
      localObject1 = "";
      ((Map)localObject4).put("token", localObject1);
      localJSONObject = new JSONObject();
    }
    int i;
    boolean bool;
    for (;;)
    {
      try
      {
        localJSONObject.put("muidtype", 1);
        localObject3 = DeviceInfoUtil.a();
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = "0000000000000000";
        }
        localJSONObject.put("muid", localObject1);
        localObject1 = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getNetworkOperatorName();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label740;
        }
        if ("中国电信".equals(localObject1)) {
          break label745;
        }
        if (!((String)localObject1).contains("电信")) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        label431:
        String str1;
        label460:
        localException2.printStackTrace();
        continue;
        QLog.d("Q.readinjoy.fast_web", 2, "" + localException2 + "    uin : " + str2);
        localObject3 = new Bundle();
        HttpUtil.a((Bundle)localObject3);
        localObject2 = new String(HttpUtil.a(BaseApplicationImpl.getContext(), localException2.toString(), "GET", null, (Bundle)localObject3));
        QLog.d("Q.readinjoy.fast_web", 2, "" + (String)localObject2);
        localObject2 = new JSONObject((String)localObject2);
        j = Integer.parseInt(((JSONObject)localObject2).getString("strategy"), 16);
        localObject2 = ((JSONObject)localObject2).getJSONArray("result");
        i = 0;
      }
      localJSONObject.put("carrier", i);
      localJSONObject.put("conn", HttpUtil.a());
      localJSONObject.put("c_os", "android");
      try
      {
        localObject1 = new StringBuilder(FastWebRequestUtil.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("ext=" + URLEncoder.encode(localJSONObject.toString(), "utf-8"));
        localObject3 = ((Map)localObject4).entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append("&" + (String)((Map.Entry)localObject4).getKey() + "=" + URLEncoder.encode((String)((Map.Entry)localObject4).getValue(), "utf-8"));
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$ResponseCallback == null) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        QLog.e("Q.readinjoy.fast_web", 2, localException1, new Object[] { "" + SpellTool.a });
        bool = false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$ResponseCallback.a(bool, localArrayList);
      return;
      str1 = this.jdField_a_of_type_JavaLangString;
      break;
      str1 = ReadInJoyWebDataManager.a((String)localObject3);
      break label111;
      if (("中国联通".equals(str1)) || (str1.contains("联通"))) {
        break label750;
      }
      if (!"中国移动".equals(str1))
      {
        bool = str1.contains("移动");
        if (!bool) {
          break label740;
        }
      }
      i = 1;
    }
    for (;;)
    {
      Object localObject2;
      int j;
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        if ((FastWebRequestUtil.a(j)) && (i == 0)) {
          localArrayList.add(FastWebRequestUtil.a((JSONObject)localObject3, true, -1));
        } else {
          localArrayList.add(FastWebRequestUtil.a((JSONObject)localObject3, false, FastWebRequestUtil.a(j)));
        }
      }
      else
      {
        bool = true;
        break label431;
        label740:
        i = 0;
        break;
        label745:
        i = 3;
        break;
        label750:
        i = 2;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrs
 * JD-Core Version:    0.7.0.1
 */