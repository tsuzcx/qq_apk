import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListRequest;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListResponse;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

public class nia
{
  static long a = -1L;
  
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject;
    label235:
    try
    {
      localObject = new account_detail_dynamic_list.AccountDetailDynamicListResponse();
      try
      {
        ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).mergeFrom(paramArrayOfByte);
        i = j;
        if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).ret_info.has())
        {
          i = j;
          if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).ret_info.ret_code.get() == 0)
          {
            if ((!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).puin.has()) || (!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).last_msg_id.has()) || (!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_cnt.has())) {
              break label396;
            }
            l1 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).puin.get();
            l2 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).last_msg_id.get();
            l3 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_cnt.get();
            if (QLog.isColorLevel()) {
              QLog.d("AccountDetailDynamicListModel", 2, "updateAccountDetailDynamicInfo puin:" + l1 + " last_msg_id:" + l2 + " msg_cnt:" + l3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
            }
            localArrayList = nhz.a(paramQQAppInterface).a(l1);
            if ((!paramBoolean1) || (!paramBoolean2) || (localArrayList == null)) {
              break label235;
            }
            boolean bool = localArrayList.isEmpty();
            if (bool) {
              break label235;
            }
            i = 6;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          long l1;
          long l2;
          long l3;
          ArrayList localArrayList;
          int i = 2;
        }
      }
      return i;
    }
    finally {}
    localArrayList = new ArrayList();
    if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_infos.has())
    {
      localObject = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_infos.get();
      if (localObject == null)
      {
        i = 0;
        break label415;
      }
    }
    for (;;)
    {
      if (j < i)
      {
        String str = ((ByteStringMicro)((List)localObject).get(j)).toStringUtf8();
        localArrayList.add(str);
        if (!QLog.isColorLevel()) {
          break label421;
        }
        QLog.d("AccountDetailDynamicListModel", 2, "updateAccountDetailDynamicInfo jsonBody" + str);
        break label421;
        i = ((List)localObject).size();
      }
      else
      {
        if (l3 == localArrayList.size())
        {
          i = nhz.a(paramQQAppInterface).a(paramArrayOfByte, paramBoolean1, l1, l2, l3, localArrayList, paramBoolean2);
          break;
        }
        i = 5;
        break;
        label396:
        i = 4;
        break;
      }
      label415:
      j = 0;
      continue;
      label421:
      j += 1;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, alvc paramalvc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList last_msg_id:" + paramLong2 + "  msg_cnt:" + paramInt + "  mLastMSgID: " + a);
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), nrz.class);
    localNewIntent.putExtra("cmd", "pull_account_detail_dynamic_list");
    Object localObject = new account_detail_dynamic_list.AccountDetailDynamicListRequest();
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).versionInfo.set("8.3.3,3,4515");
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).puin.set(paramLong1);
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).last_msg_id.set(paramLong2);
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).toByteArray());
    boolean bool;
    label204:
    int i;
    if (paramLong2 == 0L)
    {
      bool = true;
      localNewIntent.putExtra("isFirstEnter", bool);
      a = paramLong2;
      localObject = (aluw)paramQQAppInterface.getManager(56);
      if (localObject == null) {
        break label350;
      }
      localObject = ((aluw)localObject).a(String.valueOf(paramLong1));
      if (localObject == null) {
        break label350;
      }
      if (((AccountDetail)localObject).followType != 1) {
        break label344;
      }
      paramInt = 1;
      i = nrt.a(paramQQAppInterface, String.valueOf(paramLong1), (AccountDetail)localObject);
    }
    for (;;)
    {
      String str1 = paramLong1 + "";
      String str2 = paramLong2 + "";
      if (paramInt != 0) {}
      for (localObject = "02";; localObject = "01")
      {
        nrt.a(null, str1, "0X80077FF", "0X80077FF", 0, 0, "1", str2, (String)localObject, String.valueOf(i), false);
        localNewIntent.setObserver(new nib(paramQQAppInterface, bool, paramalvc));
        paramQQAppInterface.startServlet(localNewIntent);
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList exit");
        }
        return;
        bool = false;
        break;
      }
      label344:
      paramInt = 0;
      break label204;
      label350:
      i = 1;
      paramInt = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, alvc paramalvc)
  {
    nhz.a(paramQQAppInterface).a(paramQQAppInterface, paramLong, paramalvc);
    a(paramQQAppInterface, paramLong, 0L, 25, paramalvc);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, alvc paramalvc)
  {
    nhp localnhp = nhz.a(paramQQAppInterface).a(paramLong);
    if ((localnhp != null) && (localnhp.b > 0L))
    {
      if (a != localnhp.b) {
        a(paramQQAppInterface, paramLong, localnhp.b, 25, paramalvc);
      }
      return;
    }
    a(paramQQAppInterface, paramLong, paramalvc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nia
 * JD-Core Version:    0.7.0.1
 */