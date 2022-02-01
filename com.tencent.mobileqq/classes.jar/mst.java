import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID2UserAccInfo;

@Deprecated
public class mst
{
  public static int a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    String str = paramString.replace("-", "").replace(" ", "");
    if (str.length() <= 6) {
      return 5;
    }
    if (str.length() > 16) {
      return 4;
    }
    paramString = str;
    if (paramBoolean) {
      if ((!str.startsWith("00")) && (!str.startsWith("+")))
      {
        paramString = str;
        if (!str.startsWith("86")) {}
      }
      else
      {
        if (!str.startsWith("0086")) {
          break label117;
        }
        paramString = str.substring(4);
      }
    }
    while ((paramString.startsWith("400")) || (paramString.startsWith("800")))
    {
      return 2;
      label117:
      if (str.startsWith("+86")) {
        paramString = str.substring(3);
      } else if (str.startsWith("86")) {
        paramString = str.substring(2);
      } else {
        return 1;
      }
    }
    if ((!paramString.startsWith("0")) && (paramString.length() <= 9)) {
      return 3;
    }
    if ((paramString.length() == 11) || (paramString.length() == 12)) {
      return 0;
    }
    return 6;
  }
  
  private static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = ((avsy)paramQQAppInterface.getManager(11)).b(paramString);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ContactUtils.getPhoneContactFaceText(((PhoneContact)localObject2).name);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ContactUtils.getPhoneContactFaceText(paramString);
    }
    paramString = new bfri(paramQQAppInterface.getApp(), (String)localObject2);
    int i = paramString.getIntrinsicWidth();
    int j = paramString.getIntrinsicHeight();
    if (paramString.getOpacity() != -1) {}
    for (paramQQAppInterface = Bitmap.Config.ARGB_8888;; paramQQAppInterface = Bitmap.Config.RGB_565)
    {
      paramQQAppInterface = Bitmap.createBitmap(i, j, paramQQAppInterface);
      localObject1 = new Canvas(paramQQAppInterface);
      paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      paramString.draw((Canvas)localObject1);
      return paramQQAppInterface;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> uin = " + paramString + " ,uinType = " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramString == null)) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramQQAppInterface = (azjc)paramQQAppInterface.getManager(38);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface = paramQQAppInterface.a(paramString, paramInt);
      if (paramQQAppInterface == null) {
        break;
      }
      paramString = paramQQAppInterface.pstnInfo;
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> value = " + paramString);
    return paramString;
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber is null");
      }
      str = null;
    }
    do
    {
      do
      {
        return str;
        if (paramString.length() >= paramInt) {
          break;
        }
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber less ncount");
      return paramString;
      str = paramString;
    } while (paramString.length() < "***".length() + paramInt);
    String str = paramString.substring(paramString.length() - 2, paramString.length());
    paramString = paramString.substring(0, 3);
    return paramString + "***" + str;
  }
  
  public static String a(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.get(i);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject1.put("a", localAVPhoneUserInfo.account);
        localJSONObject1.put("at", localAVPhoneUserInfo.accountType);
        localJSONObject2.put("m", localAVPhoneUserInfo.telInfo.mobile);
        localJSONObject2.put("n", localAVPhoneUserInfo.telInfo.nation);
        localJSONObject2.put("p", localAVPhoneUserInfo.telInfo.prefix);
        localJSONObject2.put("ns", localAVPhoneUserInfo.telInfo.nationState);
        localJSONObject1.put("ti", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<AVPhoneUserInfo> a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ArrayList localArrayList = new ArrayList();
        paramString = localArrayList;
        if (i < localJSONArray.length())
        {
          paramString = localJSONArray.getJSONObject(i);
          JSONObject localJSONObject = paramString.optJSONObject("ti");
          AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramString.optLong("a", 0L);
          localAVPhoneUserInfo.accountType = paramString.optInt("at", -1);
          localAVPhoneUserInfo.telInfo.mobile = localJSONObject.optString("m", "");
          localAVPhoneUserInfo.telInfo.nation = localJSONObject.optString("n", "");
          localAVPhoneUserInfo.telInfo.prefix = localJSONObject.optString("p", "");
          localAVPhoneUserInfo.telInfo.nationState = localJSONObject.optInt("ns", 0);
          if (-1 == localAVPhoneUserInfo.accountType) {
            break label174;
          }
          localArrayList.add(localAVPhoneUserInfo);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      return paramString;
      label174:
      i += 1;
    }
  }
  
  public static ArrayList<AVPhoneUserInfo> a(List<cmd0xa02.TinyID2UserAccInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (cmd0xa02.TinyID2UserAccInfo)localIterator.next();
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramList.uint64_tinyid.get();
      localAVPhoneUserInfo.accountType = paramList.uint32_useracctype.get();
      paramList = paramList.str_useracc_identifier.get();
      if ((!TextUtils.isEmpty(paramList)) && (paramList.length() >= 5))
      {
        String str;
        if (paramList.contains("-"))
        {
          paramList = paramList.split("-");
          str = paramList[0];
        }
        for (paramList = paramList[1];; paramList = paramList.substring(4, paramList.length()))
        {
          localAVPhoneUserInfo.telInfo.nation = str;
          localAVPhoneUserInfo.telInfo.mobile = paramList;
          if (!TextUtils.isEmpty(localAVPhoneUserInfo.telInfo.nation)) {
            localAVPhoneUserInfo.telInfo.nationState = 1;
          }
          localArrayList.add(localAVPhoneUserInfo);
          break;
          str = paramList.substring(0, 4);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<AVPhoneUserInfo> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = a(paramQQAppInterface, paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === pstnInfo : " + (String)localObject1);
    }
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
      return null;
    }
    Object localObject2 = a((String)localObject1);
    if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
      return null;
    }
    localObject1 = (amrb)paramQQAppInterface.getManager(53);
    if (localObject1 == null) {
      return null;
    }
    paramString = ((amrb)localObject1).a(paramString);
    localObject1 = (avsy)paramQQAppInterface.getManager(11);
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    AVPhoneUserInfo localAVPhoneUserInfo;
    while (((Iterator)localObject2).hasNext())
    {
      localAVPhoneUserInfo = (AVPhoneUserInfo)((Iterator)localObject2).next();
      paramQQAppInterface = localAVPhoneUserInfo.telInfo.mobile;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
      {
        paramQQAppInterface = ((avsy)localObject1).b(paramQQAppInterface);
        if (paramQQAppInterface == null) {
          break label266;
        }
      }
    }
    label266:
    for (paramQQAppInterface = paramQQAppInterface.uin;; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() == 0))
      {
        localArrayList.add(localAVPhoneUserInfo);
        break;
      }
      if ((paramString != null) && (paramString.containsKey(paramQQAppInterface))) {
        break;
      }
      localArrayList.add(localAVPhoneUserInfo);
      break;
      if (QLog.isColorLevel()) {
        QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === list : " + localArrayList.toString());
      }
      return localArrayList;
    }
  }
  
  public static List<Bitmap> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramQQAppInterface, paramString, paramInt1);
    QLog.i("PstnUtils", 2, " ==== getRealAVPhoneBitmap === pstnInfo : " + (String)localObject);
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = a((String)localObject);
    if ((localArrayList1 == null) || (localArrayList1.size() == 0)) {
      return null;
    }
    localObject = (amrb)paramQQAppInterface.getManager(53);
    if (localObject == null) {
      return null;
    }
    Map localMap = ((amrb)localObject).a(paramString);
    avsy localavsy = (avsy)paramQQAppInterface.getManager(11);
    ArrayList localArrayList2 = new ArrayList();
    paramInt2 = Math.min(paramInt2, localArrayList1.size());
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      localObject = (AVPhoneUserInfo)localArrayList1.get(paramInt1);
      String str = ((AVPhoneUserInfo)localObject).telInfo.mobile;
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        PhoneContact localPhoneContact = localavsy.b(str);
        paramString = null;
        if (localPhoneContact != null) {
          paramString = localPhoneContact.uin;
        }
        if ((paramString == null) || (paramString.length() == 0))
        {
          localArrayList2.add(a(paramQQAppInterface, str));
        }
        else if (!localMap.containsKey(paramString))
        {
          localObject = paramQQAppInterface.getFaceBitmap(11, ((AVPhoneUserInfo)localObject).telInfo.nation + str, (byte)3, true, 0);
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = a(paramQQAppInterface, str);
          }
          localArrayList2.add(paramString);
        }
      }
    }
    return localArrayList2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mst
 * JD-Core Version:    0.7.0.1
 */