package com.tencent.mobileqq.richstatus;

import PersonalState.HotRishState;
import PersonalState.RespGetSameStateList;
import PersonalState.UserProfile;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class StatusObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RichStatus> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, ArrayList<HotRishState> paramArrayList) {}
  
  protected void a(boolean paramBoolean, List<byte[]> paramList, List<Integer> paramList1) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList<UserProfile> paramArrayList) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    default: 
    case 8: 
      b(paramBoolean, paramBundle);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("clear self sign ret:");
        paramBundle.append(paramBoolean);
        QLog.d("StatusObserver", 2, paramBundle.toString());
        return;
      }
      break;
    case 7: 
    case 9: 
      a(paramBoolean, paramBundle);
      return;
    case 6: 
      a(paramBoolean, (ArrayList)paramBundle.get("k_resp_hot_status"));
      return;
    case 5: 
      Object localObject = paramBundle.getStringArrayList("k_status_key");
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((String)((Iterator)localObject).next()).getBytes());
        }
      }
      a(paramBoolean, localArrayList, paramBundle.getIntegerArrayList("k_status_err_code_list"));
      return;
    case 4: 
      paramBundle = (StatusServlet.RspGetHistory)paramBundle.getSerializable("k_data");
      a(paramBoolean, paramBundle.startTime, paramBundle.endTime, paramBundle.over, paramBundle.richStatus, paramBundle.isAddFromCard);
      return;
    case 3: 
      bool1 = paramBundle.getBoolean("k_is_first");
      paramInt = paramBundle.getInt("k_fetch_sex");
      if (paramBoolean)
      {
        paramBundle = (RespGetSameStateList)paramBundle.getSerializable("k_resp_mate");
        a(paramBoolean, bool1, paramInt, paramBundle.vCookie, paramBundle.vUserInfos);
        return;
      }
      a(false, bool1, paramInt, null, null);
      return;
    case 2: 
      if (paramBoolean) {
        bool1 = paramBundle.getBoolean("k_sync_ss", false);
      }
      b(paramBoolean, bool1);
      return;
    case 1: 
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = paramBundle.getBoolean("k_sync_ss", false);
      }
      a(paramBoolean, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusObserver
 * JD-Core Version:    0.7.0.1
 */