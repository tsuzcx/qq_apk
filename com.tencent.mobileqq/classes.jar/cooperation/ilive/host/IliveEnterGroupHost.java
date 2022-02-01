package cooperation.ilive.host;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveEnterGroupHost
{
  private static final String TAG = "IliveEnterGroupHost";
  
  public static void getAnchorGroupList(long paramLong, IliveHostCallback paramIliveHostCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IliveEnterGroupHost getAnchorGroupList uid = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("IliveEnterGroupHost", 1, ((StringBuilder)localObject).toString());
    localObject = new SubscribePersonalDetailRequest(String.valueOf(paramLong), null);
    paramIliveHostCallback = new IliveEnterGroupHost.1(paramIliveHostCallback);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, paramIliveHostCallback);
  }
  
  public static int getWNSConfig(String paramString1, String paramString2, int paramInt)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInt);
  }
  
  public static String getWNSConfig(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  private static void handleGetGroup(boolean paramBoolean, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp, IliveHostCallback paramIliveHostCallback)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramBoolean) && (paramStGetMainPageRsp != null))
    {
      paramStGetMainPageRsp = paramStGetMainPageRsp.vecGroup.get();
      if (paramStGetMainPageRsp != null) {
        try
        {
          paramStGetMainPageRsp = paramStGetMainPageRsp.iterator();
          while (paramStGetMainPageRsp.hasNext())
          {
            CertifiedAccountMeta.StQQGroup localStQQGroup = (CertifiedAccountMeta.StQQGroup)paramStGetMainPageRsp.next();
            if (localStQQGroup != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("groupName", localStQQGroup.name.get());
              localJSONObject.put("joinState", localStQQGroup.joinState.get());
              localJSONObject.put("groupId", localStQQGroup.id.get());
              localJSONArray.put(localJSONObject);
            }
          }
          if (paramIliveHostCallback == null) {
            return;
          }
        }
        catch (JSONException paramStGetMainPageRsp)
        {
          paramStGetMainPageRsp.printStackTrace();
        }
      }
    }
    paramIliveHostCallback.onResult(paramBoolean, localJSONArray.toString());
  }
  
  public static void joinGroup(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {}
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ChatActivity.class);
      localIntent.putExtra("open_chatfragment", true);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", paramString2);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString1 = TroopInfoUIUtil.a(paramString1, 4);
    paramString1.putInt("troop_info_from", 30);
    TroopUtils.a(BaseApplicationImpl.getContext(), paramString1, 2);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.host.IliveEnterGroupHost
 * JD-Core Version:    0.7.0.1
 */