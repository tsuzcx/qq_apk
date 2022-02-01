package cooperation.troop_homework.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopHomeworkSpecialMsg
  extends AbstructRecentUserMsg
  implements Cloneable
{
  public TroopHomeworkSpecialMsg(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131697447);
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopHomeworkSpecialMsg))
    {
      paramObject = (TroopHomeworkSpecialMsg)paramObject;
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
    }
    paramObject = new TroopHomeworkSpecialMsg(BaseApplication.getContext());
    paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.d("TroopSpecialAttentionMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("content");
      this.jdField_a_of_type_Int = paramArrayOfByte.getInt("time");
      this.b = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getString("messageNavInfo");
      if ((!TextUtils.isEmpty(this.c)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(this.c);
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] a()
  {
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("time", this.jdField_a_of_type_Int);
      localJSONObject.put("color", this.b);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo != null) {
        this.c = this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
      }
      localJSONObject.put("messageNavInfo", this.c);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.model.TroopHomeworkSpecialMsg
 * JD-Core Version:    0.7.0.1
 */