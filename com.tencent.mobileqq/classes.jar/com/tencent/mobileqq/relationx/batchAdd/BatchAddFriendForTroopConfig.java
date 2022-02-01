package com.tencent.mobileqq.relationx.batchAdd;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class BatchAddFriendForTroopConfig
{
  public static final long[] a = { 10009L, 10010L, 10011L, 32L };
  public int A = 48;
  public int b = 0;
  public int c = 100;
  public int d = 15;
  public long e = 1514736000L;
  public float f = 0.01F;
  public float g = 0.5F;
  public int h = 2;
  public int i = 3;
  public int j = 3;
  public int k = 10;
  public int l = 1;
  public int m = 21;
  public int n = 3;
  public int o = 5;
  public int p = 1;
  public int q = 1;
  public int r = 5;
  public int s = 1;
  public double t = 3.0D;
  public int u = 10;
  public int v = 1;
  public int w = 0;
  public int x = 200;
  public long[] y = { 10009L, 10010L, 10011L, 32L };
  public int z = 24;
  
  public BatchAddFriendForTroopConfig(QQAppInterface paramQQAppInterface)
  {
    a(SharedPreUtils.s(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "batch_add_friend_for_troop_config"));
  }
  
  public int a(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return 10;
          }
          return this.w;
        }
        return this.r;
      }
      return this.o;
    }
    return this.k;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 4, "update content is null!");
      }
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("switchOn")) {
        this.b = paramString.getInt("switchOn");
      }
      if (paramString.has("troopMemberNumLimit")) {
        this.c = paramString.getInt("troopMemberNumLimit");
      }
      if (paramString.has("troopJoinDayLimit")) {
        this.d = paramString.getInt("troopJoinDayLimit");
      }
      if (paramString.has("commonFriendProportionLimit")) {
        this.f = ((float)paramString.getDouble("commonFriendProportionLimit"));
      }
      if (paramString.has("troopJoinLine"))
      {
        String str = paramString.getString("troopJoinLine");
        try
        {
          this.e = (new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime() / 1000L);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      if (paramString.has("nonFriendProportionLimit")) {
        this.g = ((float)paramString.getDouble("nonFriendProportionLimit"));
      }
      if (paramString.has("tipsTotalCountForTroopEveryday")) {
        this.i = paramString.getInt("tipsTotalCountForTroopEveryday");
      }
      if (paramString.has("tipsTotalCountForUin")) {
        this.j = paramString.getInt("tipsTotalCountForUin");
      }
      Object localObject;
      if (paramString.has("activeUser"))
      {
        localObject = paramString.getJSONObject("activeUser");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("totalCommonFriends")) {
            this.k = ((JSONObject)localObject).getInt("totalCommonFriends");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.l = ((JSONObject)localObject).getInt("switchOn");
          }
        }
      }
      boolean bool = paramString.has("highFreqInteract");
      if (bool)
      {
        localObject = paramString.getJSONObject("highFreqInteract");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("interactDuration")) {
            this.m = ((JSONObject)localObject).getInt("interactDuration");
          }
          if (((JSONObject)localObject).has("interactRounds")) {
            this.n = ((JSONObject)localObject).getInt("interactRounds");
          }
          if (((JSONObject)localObject).has("commonFriends")) {
            this.o = ((JSONObject)localObject).getInt("commonFriends");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.p = ((JSONObject)localObject).getInt("switchOn");
          }
        }
      }
      if (paramString.has("newMember"))
      {
        localObject = paramString.getJSONObject("newMember");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("newMemberIndex")) {
            this.q = ((JSONObject)localObject).getInt("newMemberIndex");
          }
          if (((JSONObject)localObject).has("commonFriends")) {
            this.r = ((JSONObject)localObject).getInt("commonFriends");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.s = ((JSONObject)localObject).getInt("switchOn");
          }
        }
      }
      if (paramString.has("atMeOrReplyMe"))
      {
        localObject = paramString.getJSONObject("atMeOrReplyMe");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("maxDateLenth")) {
            this.t = ((JSONObject)localObject).getDouble("maxDateLenth");
          }
          if (((JSONObject)localObject).has("maxMsgCount")) {
            this.u = ((JSONObject)localObject).getInt("maxMsgCount");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.v = ((JSONObject)localObject).getInt("switchOn");
          }
          if (((JSONObject)localObject).has("commonFriends")) {
            this.w = ((JSONObject)localObject).getInt("commonFriends");
          }
        }
      }
      if (paramString.has("troopMemberCount_ahn")) {
        this.x = paramString.getInt("troopMemberCount_ahn");
      }
      if (paramString.has("troopType_ahn"))
      {
        localObject = paramString.getJSONArray("troopType_ahn");
        this.y = new long[((JSONArray)localObject).length()];
        int i1 = 0;
        while (i1 < this.y.length)
        {
          this.y[i1] = ((JSONArray)localObject).optInt(i1);
          i1 += 1;
        }
      }
      if (paramString.has("cacheTimeCmnFrdCntData")) {
        this.z = paramString.getInt("cacheTimeCmnFrdCntData");
      }
      if (paramString.has("cacheTimeRemarkData")) {
        this.A = paramString.getInt("cacheTimeRemarkData");
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        paramString.printStackTrace();
        QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, "update exception ", paramString);
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, String.format(Locale.getDefault(), "update {switchOn: %s, troopMemberNumLimit: %s, troopJoinDayLimit: %s, commonFriendProportionLimit:%s, troopJoinLine: %s, insertGrayTipLimit: %s, nonFriendProportionLimit: %s}", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Float.valueOf(this.f), Long.valueOf(this.e), Integer.valueOf(this.h), Float.valueOf(this.g) }));
      paramString = new StringBuilder();
      paramString.append("update tipsTotalCountForTroopEveryday = ");
      paramString.append(this.i);
      paramString.append(",tipsTotalCountForUin = ");
      paramString.append(this.j);
      paramString.append(",au_totalCommonFriends = ");
      paramString.append(this.k);
      paramString.append(",au_switchOn = ");
      paramString.append(this.l);
      paramString.append(",hfi_interactDuration = ");
      paramString.append(this.m);
      paramString.append(",hfi_interactRounds = ");
      paramString.append(this.n);
      paramString.append(",hfi_commonFriends = ");
      paramString.append(this.o);
      paramString.append(",nm_newMemberIndex = ");
      paramString.append(this.q);
      paramString.append(",nm_commonFriends = ");
      paramString.append(this.r);
      paramString.append(",nm_switchOn = ");
      paramString.append(this.s);
      paramString.append(",aor_maxDateLength = ");
      paramString.append(this.t);
      paramString.append(",aor_maxMsgCount = ");
      paramString.append(this.u);
      paramString.append(",aor_switchOn = ");
      paramString.append(this.v);
      paramString.append(",aor_commonFriends = ");
      paramString.append(this.w);
      paramString.append(",troopMemberCount_ahn = ");
      paramString.append(this.x);
      paramString.append(",troopType_ahn = ");
      paramString.append(Arrays.toString(this.y));
      paramString.append(",cacheTimeCmnFrdCntData = ");
      paramString.append(this.z);
      paramString.append(",cacheTimeRemarkData = ");
      paramString.append(this.A);
      QLog.d("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, paramString.toString());
    }
  }
  
  public boolean a(TroopInfo paramTroopInfo, long[] paramArrayOfLong)
  {
    if (paramTroopInfo == null) {
      return false;
    }
    int i2 = paramArrayOfLong.length;
    int i1 = 0;
    while (i1 < i2)
    {
      long l1 = paramArrayOfLong[i1];
      if (paramTroopInfo.dwGroupClassExt == l1) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig
 * JD-Core Version:    0.7.0.1
 */