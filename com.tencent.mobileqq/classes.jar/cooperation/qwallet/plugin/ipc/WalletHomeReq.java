package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
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
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (!TextUtils.isEmpty(paramAppInfo)) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramAppInfo).optJSONObject("msg");
          if (localJSONObject2 == null) {
            return "";
          }
          Iterator localIterator = localJSONObject2.keys();
          paramAppInfo = null;
          Object localObject = null;
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!TextUtils.isEmpty(str))
            {
              JSONObject localJSONObject1 = localJSONObject2.getJSONObject(str);
              if (localJSONObject1 != null)
              {
                if (localObject != null) {}
                for (;;)
                {
                  try
                  {
                    int i = Integer.valueOf((String)localObject).intValue();
                    int j = Integer.valueOf(str).intValue();
                    if (j <= i) {
                      break;
                    }
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    if (str.length() > ((String)localObject).length()) {
                      continue;
                    }
                  }
                  localObject = str;
                  paramAppInfo = localJSONObject1;
                  break;
                  if (str.compareTo((String)localObject) <= 0) {
                    break;
                  }
                }
              }
            }
          }
          if (paramAppInfo != null)
          {
            paramAppInfo = paramAppInfo.optString("content");
            return paramAppInfo;
          }
        }
        catch (JSONException paramAppInfo)
        {
          paramAppInfo.printStackTrace();
        }
      }
    }
    return "";
  }
  
  private static int getRedType(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int i = -1;
    if (paramAppInfo == null) {
      return -1;
    }
    paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
    if (paramAppInfo.size() > 0)
    {
      int j = 0;
      int k;
      for (i = -1; j < paramAppInfo.size(); i = k)
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(j);
        k = i;
        if (localRedTypeInfo != null)
        {
          int m = localRedTypeInfo.red_type.get();
          if ((m != 3) && (m != 4) && (m != 0))
          {
            k = i;
            if (m != 15) {}
          }
          else if ((i != -1) && (m != 3))
          {
            k = i;
            if (m == 4)
            {
              k = i;
              if (i == 3) {}
            }
          }
          else
          {
            k = m;
          }
        }
        j += 1;
      }
    }
    return i;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.type = paramBundle.getInt("_qwallet_ipc_WalletHomeReq_Type");
    if (this.type == 2) {
      this.redTouchPath = paramBundle.getString("_qwallet_ipc_WalletHomeReq_RedTouchPath");
    } else {
      this.redTouchPaths = paramBundle.getStringArrayList("_qwallet_ipc_WalletHomeReq_RedTouchPaths");
    }
    this.isAppLoadFinished = paramBundle.getBoolean("_qwallet_ipc_WalletHomeReq_isAppLoadFinished");
  }
  
  protected void getRedTouch(AppRuntime paramAppRuntime)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    ArrayList localArrayList = new ArrayList();
    paramAppRuntime = localIRedTouchManager.getLocalTimeRspBody();
    if (paramAppRuntime == null)
    {
      onGetRedTouch(null);
      return;
    }
    Iterator localIterator1 = paramAppRuntime.rptMsgAppInfo.get().iterator();
    while (localIterator1.hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator1.next();
      Iterator localIterator2 = this.redTouchPaths.iterator();
      while (localIterator2.hasNext())
      {
        paramAppRuntime = (String)localIterator2.next();
        if ((localAppInfo.path.get().equals(paramAppRuntime)) && (localAppInfo.iNewFlag.get() != 0))
        {
          int j = getRedType(localAppInfo);
          if ((j == 3) || (j == 5) || (j == 4) || (j == 15))
          {
            paramAppRuntime = localAppInfo.red_display_info.red_type_info.get();
            if (paramAppRuntime.size() > 0)
            {
              i = 0;
              while (i < paramAppRuntime.size())
              {
                localObject = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppRuntime.get(i);
                if ((localObject != null) && ((((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 3) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 5) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 4) || (j == 15)))
                {
                  paramAppRuntime = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get();
                  localObject = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get();
                  break label285;
                }
                i += 1;
              }
            }
          }
          paramAppRuntime = null;
          Object localObject = null;
          label285:
          localArrayList.add(new QWalletRedTouchInfo(localAppInfo.path.get(), j, getContentByAppInfo(localAppInfo), paramAppRuntime, (String)localObject));
        }
      }
    }
    int i = localIRedTouchManager.getNumRedNumByPath("100007.102000", 100);
    if (i > 0)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(i);
      paramAppRuntime.append("");
      localArrayList.add(new QWalletRedTouchInfo("100007.102000", 5, null, null, paramAppRuntime.toString()));
    }
    if (localArrayList.size() == 0)
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
    AppRuntime localAppRuntime = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
    if (localAppRuntime == null)
    {
      onGetRedTouch(null);
      return;
    }
    int i = this.type;
    if (i != 1)
    {
      if (i != 2)
      {
        onGetRedTouch(null);
        return;
      }
      reportRedTouch(localAppRuntime);
      return;
    }
    getRedTouch(localAppRuntime);
  }
  
  protected void reportRedTouch(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(this.redTouchPath);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.WalletHomeReq
 * JD-Core Version:    0.7.0.1
 */