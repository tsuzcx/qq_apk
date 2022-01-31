import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

public class oub
  extends Handler
{
  public oub(TroopMemberApiClient paramTroopMemberApiClient) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Bundle localBundle;
    int i;
    boolean bool;
    int j;
    Iterator localIterator;
    label549:
    do
    {
      do
      {
        return;
        localBundle = paramMessage.getData();
      } while (localBundle == null);
      i = localBundle.getInt("seq", -1);
      switch (paramMessage.what)
      {
      case 4: 
      case 6: 
      case 9: 
      case 10: 
      case 12: 
      case 21: 
      case 22: 
      case 27: 
      case 30: 
      case 31: 
      case 32: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 45: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 53: 
      case 54: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 68: 
      case 69: 
      case 70: 
      case 71: 
      case 72: 
      case 74: 
      case 75: 
      case 78: 
      case 83: 
      case 84: 
      case 86: 
      case 89: 
      case 90: 
      case 93: 
      case 94: 
      case 95: 
      case 96: 
      case 97: 
      case 98: 
      case 99: 
      case 100: 
      case 101: 
      case 104: 
      case 105: 
      case 106: 
      case 107: 
      case 108: 
      case 109: 
      case 114: 
      default: 
        return;
      case 3: 
        i = localBundle.getInt("type");
        bool = localBundle.getBoolean("isSuccess", false);
        paramMessage = localBundle.getSerializable("data");
        j = localBundle.getInt("observer_type");
        localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
      }
    } while (!localIterator.hasNext());
    BusinessObserver localBusinessObserver = (BusinessObserver)localIterator.next();
    Object localObject;
    if (((j == 1) && ((localBusinessObserver instanceof LBSObserver))) || ((j == 2) && ((localBusinessObserver instanceof FriendListObserver)))) {
      if (28 == i)
      {
        localObject = localBundle.getByteArray("groupInfo");
        paramMessage = new cmd0x7f5.GroupInfo();
        if (localObject == null) {
          break label2074;
        }
      }
    }
    label2074:
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom((byte[])localObject);
        localObject = new Object[2];
        localObject[0] = Integer.valueOf(localBundle.getInt("count"));
        localObject[1] = paramMessage;
        paramMessage = (Message)localObject;
        localBusinessObserver.onUpdate(i, bool, paramMessage);
      }
      catch (InvalidProtocolBufferMicroException paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = null;
        continue;
      }
      if ((j == 3) && ((localBusinessObserver instanceof TroopObserver)))
      {
        ((TroopObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label549;
      }
      if ((j == 4) && ((localBusinessObserver instanceof BizTroopObserver)))
      {
        ((BizTroopObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label549;
      }
      if ((j != 5) || (!(localBusinessObserver instanceof HotChatObserver))) {
        break label549;
      }
      ((HotChatObserver)localBusinessObserver).onUpdate(i, bool, paramMessage);
      break label549;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      j = localBundle.getInt("retCode", -1);
      int k = localBundle.getInt("rate", -1);
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      if ((j == 0) && (k != 100)) {
        break;
      }
      QLog.d("ReadInJoy", 4, "download finish:" + localBundle);
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null) {
        break;
      }
      paramMessage = localBundle.getString("pageUrl");
      localObject = localBundle.getStringArrayList("lstVideoUrl");
      i = localBundle.getInt("totalTime", 0);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver.onUpdate(localBundle.getInt("type"), true, new Object[] { paramMessage, localObject, Integer.valueOf(i) });
      return;
      this.a.a().a(localBundle);
      return;
      localObject = (BusinessObserver)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(localBundle.getInt("req_seq"));
      if (localObject == null) {
        break;
      }
      this.a.jdField_a_of_type_AndroidUtilSparseArray.remove(localBundle.getInt("req_seq"));
      ((BusinessObserver)localObject).onUpdate(paramMessage.what, true, localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if ((i == -1) || (paramMessage == null)) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      paramMessage = localBundle.getString("FileName");
      i = localBundle.getInt("Status");
      if ((TroopMemberApiClient.a(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.a(this.a).get(paramMessage) == null)) {
        break;
      }
      j = ((Integer)TroopMemberApiClient.a(this.a).get(paramMessage)).intValue();
      if (j == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      if (i != 11) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
      return;
      paramMessage = localBundle.getString("FilePath");
      i = localBundle.getInt("size");
      localObject = paramMessage + "/" + i;
      if ((TroopMemberApiClient.b(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.b(this.a).get(localObject) == null)) {
        break;
      }
      i = ((Integer)TroopMemberApiClient.b(this.a).get(localObject)).intValue();
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i != -1)
      {
        localObject = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
        if (localObject != null) {
          ((TroopMemberApiClient.Callback)localObject).a(localBundle);
        }
      }
      super.handleMessage(paramMessage);
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      bool = localBundle.getBoolean("actionFinish");
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      if (!bool) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      return;
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (TroopMemberApiClient.a(this.a) == null) {
        break;
      }
      TroopMemberApiClient.a(this.a).a(localBundle);
      return;
      if (TroopMemberApiClient.a(this.a) == null) {
        break;
      }
      TroopMemberApiClient.a(this.a).a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putString("type", "troopCreateOpenAIO");
      paramMessage.a(localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oub
 * JD-Core Version:    0.7.0.1
 */