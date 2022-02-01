package com.tencent.mobileqq.redtouch;

import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

class RedTouchManager$1
  extends NumRedGetMsgCallback
{
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    ArraySet localArraySet = new ArraySet();
    ArrayList localArrayList = new ArrayList();
    if ("QQCircleRedCircle".equals(paramString))
    {
      QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle updateNumMsg");
      if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (NumRedMsg.NumMsgBusi)paramString.next();
          if ((paramList != null) && (paramList.str_ext.get() != null)) {
            try
            {
              JSONObject localJSONObject = new JSONObject(paramList.str_ext.get());
              localArraySet.add(localJSONObject.optString("_red_ext_uin"));
              long l = RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager);
              if (l > 0L) {
                try
                {
                  if (Long.parseLong(localJSONObject.optString("_red_ext_feed_time")) < RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager))
                  {
                    localArrayList.add(Long.valueOf(paramList.ui64_msgid.get()));
                    RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager, 140000, (int)paramList.ui64_msgid.get(), 3);
                  }
                }
                catch (Exception paramList)
                {
                  paramList.printStackTrace();
                  QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle ", paramList);
                }
              }
            }
            catch (Exception paramList)
            {
              paramList.printStackTrace();
              QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle ", paramList);
            }
          }
        }
        paramString = new ArrayList(localArraySet);
        if (this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiInterfacesOnGetQQCircleNumRedMsgListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiInterfacesOnGetQQCircleNumRedMsgListener.onGet(paramString, this.jdField_a_of_type_Int);
          QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle listener returns successfully: " + paramString.size() + ", num = " + this.jdField_a_of_type_Int);
        }
        if (RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager) > 0L)
        {
          RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager, 0L);
          if (localArrayList.size() > 0)
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.a("140000");
            RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager, paramString, 9, false, null, localArrayList, "");
            QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle updateNumMsg updateMsgId: " + localArrayList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */