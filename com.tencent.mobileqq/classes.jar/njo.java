import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class njo
{
  public static final int a;
  public static long a;
  public static njo a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public HashMap<String, njq> a;
  public njr a;
  public njs a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = Color.rgb(64, 64, 65);
    jdField_b_of_type_Int = Color.rgb(166, 166, 166);
    jdField_c_of_type_Int = Color.argb(205, 255, 255, 255);
    d = Color.argb(154, 255, 255, 255);
    e = Color.rgb(19, 19, 19);
    jdField_a_of_type_Long = -1L;
  }
  
  public njo()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static String a(int paramInt)
  {
    return "https://pub.idqqimg.com/pc/group/anony/portrait/img/" + paramInt + ".png";
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flags", paramInt1);
      localJSONObject.put("an_id", paramString1);
      localJSONObject.put("an_nick", paramString2);
      localJSONObject.put("head_protrait", paramInt2);
      localJSONObject.put("expire_time", paramInt3);
      localJSONObject.put("rankColor", paramString3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousChatHelper", 2, "getJsonStr JSONException:" + paramString1.toString());
      }
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static njo a()
  {
    if (jdField_a_of_type_Njo == null) {
      jdField_a_of_type_Njo = new njo();
    }
    return jdField_a_of_type_Njo;
  }
  
  public static njp a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("anonymous");
    paramMessageRecord = new njp();
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("flags")) {
        paramMessageRecord.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("flags");
      }
      if (((JSONObject)localObject).has("an_id")) {
        paramMessageRecord.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("an_id");
      }
      if (((JSONObject)localObject).has("an_nick")) {
        paramMessageRecord.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("an_nick");
      }
      if (((JSONObject)localObject).has("head_protrait")) {
        paramMessageRecord.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("head_protrait");
      }
      if (((JSONObject)localObject).has("expire_time")) {
        paramMessageRecord.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("expire_time");
      }
      if (((JSONObject)localObject).has("rankColor")) {
        paramMessageRecord.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("rankColor");
      }
      return paramMessageRecord;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramMessageRecord;
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = paramContext.getSharedPreferences("anonymous_chat", 0);
    if (paramContext.getBoolean("first_enter_anonymous" + paramQQAppInterface.getCurrentAccountUin(), true))
    {
      paramContext.edit().putBoolean("first_enter_anonymous" + paramQQAppInterface.getCurrentAccountUin(), false).commit();
      return true;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.extLong & 0x3) == 3;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof ChatMessage)) && (((ChatMessage)paramMessageRecord).fakeSenderType == 2)) {}
    for (int i = 1;; i = 0) {
      return (i == 0) && (!paramMessageRecord.isMultiMsg) && (a(paramMessageRecord).jdField_a_of_type_Int == 2);
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (this.jdField_a_of_type_Njr == null) {
      return null;
    }
    return this.jdField_a_of_type_Njr.jdField_c_of_type_JavaLangString;
  }
  
  public njq a(String paramString)
  {
    return (njq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_Boolean) {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    while (!a(paramMessageRecord.frienduin)) {
      return;
    }
    njq localnjq = a(paramMessageRecord.frienduin);
    paramMessageRecord.vipBubbleID = localnjq.jdField_a_of_type_Long;
    paramMessageRecord.extLong |= 0x3;
    paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, localnjq.jdField_b_of_type_JavaLangString, localnjq.jdField_a_of_type_JavaLangString, localnjq.jdField_a_of_type_Int, localnjq.jdField_b_of_type_Int, localnjq.jdField_c_of_type_JavaLangString));
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousUpdate", 2, "nickName=" + paramString2 + ", vipBubbleId=" + paramLong + ", headId=" + paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      localnjq = (njq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      localnjq.jdField_a_of_type_Int = paramInt1;
      if ((paramString2 != null) && (!paramString2.equals(localnjq.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Njs != null)) {
        this.jdField_a_of_type_Njs.a(paramString1, paramString2);
      }
      localnjq.jdField_a_of_type_JavaLangString = paramString2;
      localnjq.jdField_a_of_type_Long = paramLong;
      localnjq.jdField_b_of_type_Int = paramInt2;
      localnjq.jdField_b_of_type_JavaLangString = paramString3;
      localnjq.jdField_c_of_type_JavaLangString = paramString4;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localnjq);
      return;
    }
    njq localnjq = new njq(this, false);
    localnjq.jdField_a_of_type_Int = paramInt1;
    localnjq.jdField_a_of_type_JavaLangString = paramString2;
    localnjq.jdField_a_of_type_Long = paramLong;
    localnjq.jdField_b_of_type_Int = paramInt2;
    localnjq.jdField_b_of_type_JavaLangString = paramString3;
    localnjq.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localnjq);
  }
  
  public void a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramMessageRecord == null)) {}
    do
    {
      return;
      paramMessageRecord = abcl.a(paramMessageRecord);
    } while (TextUtils.isEmpty(paramMessageRecord));
    if (this.jdField_a_of_type_Njr == null) {
      this.jdField_a_of_type_Njr = new njr(this);
    }
    this.jdField_a_of_type_Njr.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Njr.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Njr.jdField_c_of_type_JavaLangString = paramMessageRecord;
  }
  
  public void a(njs paramnjs)
  {
    this.jdField_a_of_type_Njs = paramnjs;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      ((njq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new njq(this, paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((njq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Njs = null;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_Boolean) {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    while (!a(paramMessageRecord.frienduin)) {
      return;
    }
    njq localnjq = a(paramMessageRecord.frienduin);
    paramMessageRecord.vipBubbleID = localnjq.jdField_a_of_type_Long;
    paramMessageRecord.extLong |= 0x3;
    paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, null, localnjq.jdField_a_of_type_JavaLangString, localnjq.jdField_a_of_type_Int, localnjq.jdField_b_of_type_Int, localnjq.jdField_c_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njo
 * JD-Core Version:    0.7.0.1
 */