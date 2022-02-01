package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import baif;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletHomeReq
  extends BaseReq
{
  public static final int RED_TOUCH_GET = 1;
  public static final int RED_TOUCH_REPORT = 2;
  public boolean isAppLoadFinished;
  public String redTouchPath;
  public ArrayList<String> redTouchPaths;
  public int type;
  
  private static String getContentByAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    JSONObject localJSONObject2 = null;
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (TextUtils.isEmpty(paramAppInfo)) {}
    }
    for (;;)
    {
      String str;
      try
      {
        JSONObject localJSONObject3 = new JSONObject(paramAppInfo).optJSONObject("msg");
        if (localJSONObject3 == null) {
          return "";
        }
        Iterator localIterator = localJSONObject3.keys();
        localJSONObject1 = null;
        paramAppInfo = localJSONObject2;
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (TextUtils.isEmpty(str)) {
            break label203;
          }
          localJSONObject2 = localJSONObject3.getJSONObject(str);
          if (localJSONObject2 == null) {
            break label203;
          }
          if (paramAppInfo == null)
          {
            localJSONObject1 = localJSONObject2;
            paramAppInfo = str;
            continue;
          }
          try
          {
            int i = Integer.valueOf(paramAppInfo).intValue();
            int j = Integer.valueOf(str).intValue();
            if (j <= i) {
              break label206;
            }
            localJSONObject1 = localJSONObject2;
            paramAppInfo = str;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (str.length() > paramAppInfo.length()) {
              break label212;
            }
          }
          if (str.compareTo(paramAppInfo) <= 0) {
            break label203;
          }
          break label212;
        }
        if (localJSONObject1 != null)
        {
          paramAppInfo = localJSONObject1.optString("content");
          return paramAppInfo;
        }
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
        return "";
      }
      paramAppInfo = "";
      continue;
      label203:
      continue;
      label206:
      continue;
      return "";
      label212:
      JSONObject localJSONObject1 = localJSONObject2;
      paramAppInfo = str;
    }
  }
  
  private static int getRedType(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return -1;
    }
    paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
    int i;
    if (paramAppInfo.size() > 0)
    {
      int m = 0;
      int j = -1;
      i = j;
      if (m < paramAppInfo.size())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(m);
        i = j;
        int k;
        if (localRedTypeInfo != null)
        {
          k = localRedTypeInfo.red_type.get();
          if ((k != 3) && (k != 4))
          {
            i = j;
            if (k != 0) {}
          }
          else
          {
            if (j != -1) {
              break label107;
            }
            i = k;
          }
        }
        for (;;)
        {
          m += 1;
          j = i;
          break;
          label107:
          if (k == 3)
          {
            i = k;
          }
          else
          {
            i = j;
            if (k == 4)
            {
              i = j;
              if (j != 3) {
                i = k;
              }
            }
          }
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.type = paramBundle.getInt("_qwallet_ipc_WalletHomeReq_Type");
    if (this.type == 2) {
      this.redTouchPath = paramBundle.getString("_qwallet_ipc_WalletHomeReq_RedTouchPath");
    }
    for (;;)
    {
      this.isAppLoadFinished = paramBundle.getBoolean("_qwallet_ipc_WalletHomeReq_isAppLoadFinished");
      return;
      this.redTouchPaths = paramBundle.getStringArrayList("_qwallet_ipc_WalletHomeReq_RedTouchPaths");
    }
  }
  
  protected void getRedTouch(QQAppInterface paramQQAppInterface)
  {
    baif localbaif = (baif)paramQQAppInterface.getManager(36);
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = localbaif.a();
    if (paramQQAppInterface == null)
    {
      onGetRedTouch(null);
      return;
    }
    Iterator localIterator1 = paramQQAppInterface.rptMsgAppInfo.get().iterator();
    if (localIterator1.hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator1.next();
      Iterator localIterator2 = this.redTouchPaths.iterator();
      label81:
      int j;
      Object localObject2;
      Object localObject3;
      Object localObject1;
      List localList;
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          paramQQAppInterface = (String)localIterator2.next();
          if ((localAppInfo.path.get().equals(paramQQAppInterface)) && (localAppInfo.iNewFlag.get() != 0))
          {
            j = getRedType(localAppInfo);
            localObject2 = null;
            localObject3 = null;
            if ((j != 3) && (j != 5))
            {
              localObject1 = localObject2;
              paramQQAppInterface = localObject3;
              if (j != 4) {
                break;
              }
            }
            else
            {
              localList = localAppInfo.red_display_info.red_type_info.get();
              localObject1 = localObject2;
              paramQQAppInterface = localObject3;
              if (localList.size() > 0) {
                i = 0;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        paramQQAppInterface = localObject3;
        if (i < localList.size())
        {
          paramQQAppInterface = (BusinessInfoCheckUpdate.RedTypeInfo)localList.get(i);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.red_type.get() == 3) || (paramQQAppInterface.red_type.get() == 5) || (paramQQAppInterface.red_type.get() == 4)))
          {
            localObject1 = paramQQAppInterface.red_desc.get();
            paramQQAppInterface = paramQQAppInterface.red_content.get();
          }
        }
        else
        {
          localArrayList.add(new QWalletRedTouchInfo(localAppInfo.path.get(), j, getContentByAppInfo(localAppInfo), (String)localObject1, paramQQAppInterface));
          break label81;
          break;
        }
        i += 1;
      }
    }
    int i = localbaif.a("100007.102000", 100);
    if (i > 0) {
      localArrayList.add(new QWalletRedTouchInfo("100007.102000", 5, null, null, i + ""));
    }
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      onGetRedTouch(null);
      return;
    }
    onGetRedTouch(localArrayList);
  }
  
  protected void onGetRedTouch(ArrayList<QWalletRedTouchInfo> paramArrayList)
  {
    WalletHomeResp localWalletHomeResp = new WalletHomeResp();
    localWalletHomeResp.resp = paramArrayList;
    localWalletHomeResp.type = this.type;
    localWalletHomeResp.isAppLoadFinished = this.isAppLoadFinished;
    paramArrayList = new Bundle();
    localWalletHomeResp.toBundle(paramArrayList);
    super.doCallback(paramArrayList);
  }
  
  public void onReceive()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.getAppInterface();
    if (localQQAppInterface == null)
    {
      onGetRedTouch(null);
      return;
    }
    switch (this.type)
    {
    default: 
      onGetRedTouch(null);
      return;
    case 1: 
      getRedTouch(localQQAppInterface);
      return;
    }
    reportRedTouch(localQQAppInterface);
  }
  
  protected void reportRedTouch(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      ((baif)paramQQAppInterface.getManager(36)).b(this.redTouchPath);
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_qwallet_ipc_WalletHomeReq_Type", this.type);
    paramBundle.putString("_qwallet_ipc_WalletHomeReq_RedTouchPath", this.redTouchPath);
    paramBundle.putStringArrayList("_qwallet_ipc_WalletHomeReq_RedTouchPaths", this.redTouchPaths);
    paramBundle.putBoolean("_qwallet_ipc_WalletHomeReq_isAppLoadFinished", this.isAppLoadFinished);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.WalletHomeReq
 * JD-Core Version:    0.7.0.1
 */