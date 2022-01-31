import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class sxi
  implements BusinessObserver
{
  sxi(sxe paramsxe, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramBundle.getByteArray("data");
      if (localObject1 != null) {
        paramBundle = new mobileqq_mp.JSApiWebServerResponse();
      }
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom((byte[])localObject1);
        localObject1 = (mobileqq_mp.RetInfo)paramBundle.ret_info.get();
        Object localObject2 = paramBundle.body.get();
        int i = ((mobileqq_mp.RetInfo)localObject1).ret_code.get();
        paramBundle = ((mobileqq_mp.RetInfo)localObject1).err_info.get();
        localObject1 = new JSONObject();
        paramInt = i;
        if (i == 0)
        {
          localObject2 = new JSONObject((String)localObject2);
          i = ((JSONObject)localObject2).optInt("ret");
          paramBundle = ((JSONObject)localObject2).optString("msg");
          this.jdField_a_of_type_Sxe.k = ((JSONObject)localObject2).optString("puin");
          if (i == -1)
          {
            paramInt = ((JSONObject)localObject2).optInt("refuseSec");
            if (paramInt > 0)
            {
              this.jdField_a_of_type_Sxe.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_Sxe.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, paramInt * 1000);
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("bitmap");
          Object localObject3 = new ArrayList();
          if (localObject2 != null)
          {
            paramInt = 0;
            if (paramInt < ((JSONArray)localObject2).length())
            {
              ((ArrayList)localObject3).add(Integer.valueOf(((JSONArray)localObject2).getInt(paramInt)));
              paramInt += 1;
              continue;
            }
          }
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = sxe.a(((Integer)((Iterator)localObject3).next()).intValue());
            int j = localObject4.length;
            paramInt = 0;
            if (paramInt < j)
            {
              ((ArrayList)localObject2).add(Integer.valueOf(localObject4[paramInt]));
              paramInt += 1;
              continue;
            }
            continue;
          }
          localObject3 = new ArrayList();
          Object localObject4 = (ArrayList)sxe.b.get(this.jdField_a_of_type_JavaLangString);
          paramInt = 0;
          if (paramInt < ((ArrayList)localObject2).size())
          {
            String str = (String)sxe.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
            if ((str != null) && (((Integer)((ArrayList)localObject2).get(paramInt)).intValue() == 1) && (sxe.a((ArrayList)localObject4, str))) {
              ((ArrayList)localObject3).add(str);
            }
          }
          else
          {
            sxe.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, localObject3);
            sxe.b.remove(this.jdField_a_of_type_JavaLangString);
            localObject2 = new ArrayList();
            if (localObject4 != null)
            {
              paramInt = 0;
              if (paramInt < ((ArrayList)localObject4).size())
              {
                if (sxe.a((ArrayList)localObject3, (String)((ArrayList)localObject4).get(paramInt))) {
                  break label583;
                }
                ((ArrayList)localObject2).add(Integer.valueOf(paramInt));
                break label583;
              }
            }
            ((JSONObject)localObject1).put("forbidden", new JSONArray((Collection)localObject2));
            paramInt = i;
          }
        }
        else
        {
          ((JSONObject)localObject1).put("msg", paramBundle);
          ((JSONObject)localObject1).put("retCode", paramInt);
          paramBundle = ((JSONObject)localObject1).toString();
          if (this.jdField_a_of_type_Sxe.m != null) {
            this.jdField_a_of_type_Sxe.callJs(this.jdField_a_of_type_Sxe.m, new String[] { paramBundle });
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      paramInt += 1;
      continue;
      label583:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxi
 * JD-Core Version:    0.7.0.1
 */