package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class RealNearbyProfileCardUtils
{
  private static String a = "RealNearbyProfileCardUtils";
  
  public static void a(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {
      try
      {
        Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", paramAllInOne);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("frome_where", paramInt);
        localIntent.addFlags(536870912);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject1 = (INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    Object localObject2 = (NearbyHandler)((INearbyAppInterface)localObject1).getBusinessHandler(NearbyConstants.a);
    for (;;)
    {
      int i;
      int k;
      try
      {
        Object localObject4 = new JSONObject(paramString);
        localObject2 = ((JSONObject)localObject4).optString("uin");
        i = ((JSONObject)localObject4).optInt("mode", -1);
        int j = ((JSONObject)localObject4).optInt("source", 6);
        k = ((JSONObject)localObject4).optInt("from");
        Object localObject3 = ((JSONObject)localObject4).optString("now_id", "0");
        int m = ((JSONObject)localObject4).optInt("now_user_type", 0);
        try
        {
          localObject5 = new Bundle();
          ((Bundle)localObject5).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
          paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject5);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        Object localObject5 = ((JSONObject)localObject4).optString("tinnyid");
        paramString = new StringBuffer();
        paramString.append("&source=");
        paramString.append(j);
        StringBuilder localStringBuilder;
        if (k != 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("&from=");
          localStringBuilder.append(k);
          paramString.append(localStringBuilder.toString());
        }
        if (i != -1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("&mode=");
          localStringBuilder.append(i);
          paramString.append(localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("&tinnyid=");
          localStringBuilder.append((String)localObject5);
          paramString.append(localStringBuilder.toString());
        }
        localObject4 = ((JSONObject)localObject4).optString("reportsource");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("&reportsource=");
          ((StringBuilder)localObject5).append((String)localObject4);
          paramString.append(((StringBuilder)localObject5).toString());
        }
        paramString.append("&now_id=");
        paramString.append((String)localObject3);
        paramString.append("&now_user_type=");
        paramString.append(m);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mqq://card/show_pslcard/?uin=");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("&card_type=nearby");
        ((StringBuilder)localObject3).append(paramString.toString());
        paramString = ((StringBuilder)localObject3).toString();
        if (!QLog.isColorLevel()) {
          break label633;
        }
        localObject3 = a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("openProfileCard, jumpUrl=");
        ((StringBuilder)localObject4).append(paramString);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      catch (Exception paramContext)
      {
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openProfileCard failed! msg = ");
        ((StringBuilder)localObject1).append(paramContext.getMessage());
        QLog.e(paramString, 2, ((StringBuilder)localObject1).toString());
        return;
      }
      l = Long.parseLong((String)localObject2);
      paramContext = new RealNearbyProfileCardUtils.1((String)localObject2, paramContext, k);
      NearbyHandler.a((INearbyAppInterface)localObject1, new long[] { l }, paramContext);
      return;
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).startActivityForResult(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)), NearbyProfileCardConstants.b);
        return;
      }
      paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
      label633:
      if (i != 1) {
        if ((k != 1) && (k != 7) && (k != 8) && (k != 9) && (k != 10) && (k != 12) && (k != 20)) {
          if ((k < 21) || (k > 28)) {}
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 22) {
      return true;
    }
    return (paramInt >= 7) && (paramInt <= 12) && (paramInt != 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.RealNearbyProfileCardUtils
 * JD-Core Version:    0.7.0.1
 */