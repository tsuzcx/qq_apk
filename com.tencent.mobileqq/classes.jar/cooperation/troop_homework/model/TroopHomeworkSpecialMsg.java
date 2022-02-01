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
    this.c = HardCodeUtil.a(2131895220);
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopHomeworkSpecialMsg))
    {
      paramObject = (TroopHomeworkSpecialMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      return paramObject;
    }
    paramObject = new TroopHomeworkSpecialMsg(BaseApplication.getContext());
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.d("TroopSpecialAttentionMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.c = paramArrayOfByte.getString("content");
      this.e = paramArrayOfByte.getInt("time");
      this.f = paramArrayOfByte.getInt("color");
      this.g = paramArrayOfByte.getString("messageNavInfo");
      if ((!TextUtils.isEmpty(this.g)) && (this.h == null))
      {
        this.h = new MessageNavInfo();
        this.h.a(this.g);
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] b()
  {
    return c();
  }
  
  public byte[] c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.c);
      localJSONObject.put("time", this.e);
      localJSONObject.put("color", this.f);
      if (this.h != null) {
        this.g = this.h.b();
      }
      localJSONObject.put("messageNavInfo", this.g);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.model.TroopHomeworkSpecialMsg
 * JD-Core Version:    0.7.0.1
 */