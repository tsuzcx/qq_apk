import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.ResponseCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SpellTool;
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

public final class mnz
  implements Runnable
{
  public mnz(String paramString1, String paramString2, String paramString3, FastWebRequestUtil.ResponseCallback paramResponseCallback) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    Object localObject3 = ((QQAppInterface)localObject1).getAccount();
    Object localObject4 = ((TicketManager)((QQAppInterface)localObject1).getManager(2)).getSkey((String)localObject3);
    label120:
    boolean bool;
    try
    {
      localObject3 = new HashMap();
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = "0";
        ((Map)localObject3).put("p", localObject1);
        ((Map)localObject3).put("id", this.b);
        ((Map)localObject3).put("rowkey", this.c);
        ((Map)localObject3).put("mqv", "7.6.3");
        if (localObject4 != null) {
          break label370;
        }
        localObject1 = "";
        ((Map)localObject3).put("token", localObject1);
        ((Map)localObject3).put("net_type", HttpUtil.a() + "");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("c_version", "7.6.3".replace(".", ""));
        ((Map)localObject3).put("extInfo", URLEncoder.encode(((JSONObject)localObject1).toString()));
        localObject1 = new StringBuilder(FastWebRequestUtil.b);
        localObject3 = ((Map)localObject3).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            ((StringBuilder)localObject1).append("&" + (String)((Map.Entry)localObject4).getKey() + "=" + (String)((Map.Entry)localObject4).getValue());
            continue;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$ResponseCallback == null) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "" + SpellTool.a });
      bool = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$ResponseCallback.a(bool, localArrayList);
      return;
      Object localObject2 = this.jdField_a_of_type_JavaLangString;
      break;
      label370:
      localObject2 = ReadInJoyWebDataManager.a((String)localObject4);
      break label120;
      QLog.d("Q.readinjoy.fast_web", 2, "" + localObject2);
      localObject2 = new String(HttpUtil.a(BaseApplicationImpl.getContext(), ((StringBuilder)localObject2).toString(), "GET", null, null));
      QLog.d("Q.readinjoy.fast_web", 2, "" + (String)localObject2);
      localObject2 = new JSONObject((String)localObject2).getJSONObject("data").getJSONArray("recommend_other");
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localObject3 = FastWebRequestUtil.a(((JSONArray)localObject2).getJSONObject(i));
        if (localObject3 != null) {
          localArrayList.add(localObject3);
        }
        i += 1;
      }
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnz
 * JD-Core Version:    0.7.0.1
 */