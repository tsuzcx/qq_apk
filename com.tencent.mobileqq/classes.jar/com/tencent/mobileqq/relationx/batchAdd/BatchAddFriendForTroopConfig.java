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
  public static final long[] a;
  public double a;
  public float a;
  public int a;
  public long a;
  public float b;
  public int b;
  public long[] b;
  public int c = 15;
  public int d = 2;
  public int e = 3;
  public int f = 3;
  public int g = 10;
  public int h = 1;
  public int i = 21;
  public int j = 3;
  public int k = 5;
  public int l = 1;
  public int m = 1;
  public int n = 5;
  public int o = 1;
  public int p = 10;
  public int q = 1;
  public int r = 0;
  public int s = 200;
  public int t = 24;
  public int u = 48;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 10009L, 10010L, 10011L, 32L };
  }
  
  public BatchAddFriendForTroopConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Double = 3.0D;
    this.jdField_b_of_type_ArrayOfLong = new long[] { 10009L, 10010L, 10011L, 32L };
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 100;
    this.jdField_a_of_type_Long = 1514736000L;
    this.jdField_a_of_type_Float = 0.01F;
    this.jdField_b_of_type_Float = 0.5F;
    a(SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "batch_add_friend_for_troop_config"));
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
          return this.r;
        }
        return this.n;
      }
      return this.k;
    }
    return this.g;
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
        this.jdField_a_of_type_Int = paramString.getInt("switchOn");
      }
      if (paramString.has("troopMemberNumLimit")) {
        this.jdField_b_of_type_Int = paramString.getInt("troopMemberNumLimit");
      }
      if (paramString.has("troopJoinDayLimit")) {
        this.c = paramString.getInt("troopJoinDayLimit");
      }
      if (paramString.has("commonFriendProportionLimit")) {
        this.jdField_a_of_type_Float = ((float)paramString.getDouble("commonFriendProportionLimit"));
      }
      if (paramString.has("troopJoinLine"))
      {
        String str = paramString.getString("troopJoinLine");
        try
        {
          this.jdField_a_of_type_Long = (new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime() / 1000L);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      if (paramString.has("nonFriendProportionLimit")) {
        this.jdField_b_of_type_Float = ((float)paramString.getDouble("nonFriendProportionLimit"));
      }
      if (paramString.has("tipsTotalCountForTroopEveryday")) {
        this.e = paramString.getInt("tipsTotalCountForTroopEveryday");
      }
      if (paramString.has("tipsTotalCountForUin")) {
        this.f = paramString.getInt("tipsTotalCountForUin");
      }
      Object localObject;
      if (paramString.has("activeUser"))
      {
        localObject = paramString.getJSONObject("activeUser");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("totalCommonFriends")) {
            this.g = ((JSONObject)localObject).getInt("totalCommonFriends");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.h = ((JSONObject)localObject).getInt("switchOn");
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
            this.i = ((JSONObject)localObject).getInt("interactDuration");
          }
          if (((JSONObject)localObject).has("interactRounds")) {
            this.j = ((JSONObject)localObject).getInt("interactRounds");
          }
          if (((JSONObject)localObject).has("commonFriends")) {
            this.k = ((JSONObject)localObject).getInt("commonFriends");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.l = ((JSONObject)localObject).getInt("switchOn");
          }
        }
      }
      if (paramString.has("newMember"))
      {
        localObject = paramString.getJSONObject("newMember");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("newMemberIndex")) {
            this.m = ((JSONObject)localObject).getInt("newMemberIndex");
          }
          if (((JSONObject)localObject).has("commonFriends")) {
            this.n = ((JSONObject)localObject).getInt("commonFriends");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.o = ((JSONObject)localObject).getInt("switchOn");
          }
        }
      }
      if (paramString.has("atMeOrReplyMe"))
      {
        localObject = paramString.getJSONObject("atMeOrReplyMe");
        if (localObject != null)
        {
          if (((JSONObject)localObject).has("maxDateLenth")) {
            this.jdField_a_of_type_Double = ((JSONObject)localObject).getDouble("maxDateLenth");
          }
          if (((JSONObject)localObject).has("maxMsgCount")) {
            this.p = ((JSONObject)localObject).getInt("maxMsgCount");
          }
          if (((JSONObject)localObject).has("switchOn")) {
            this.q = ((JSONObject)localObject).getInt("switchOn");
          }
          if (((JSONObject)localObject).has("commonFriends")) {
            this.r = ((JSONObject)localObject).getInt("commonFriends");
          }
        }
      }
      if (paramString.has("troopMemberCount_ahn")) {
        this.s = paramString.getInt("troopMemberCount_ahn");
      }
      if (paramString.has("troopType_ahn"))
      {
        localObject = paramString.getJSONArray("troopType_ahn");
        this.jdField_b_of_type_ArrayOfLong = new long[((JSONArray)localObject).length()];
        int i1 = 0;
        while (i1 < this.jdField_b_of_type_ArrayOfLong.length)
        {
          this.jdField_b_of_type_ArrayOfLong[i1] = ((JSONArray)localObject).optInt(i1);
          i1 += 1;
        }
      }
      if (paramString.has("cacheTimeCmnFrdCntData")) {
        this.t = paramString.getInt("cacheTimeCmnFrdCntData");
      }
      if (paramString.has("cacheTimeRemarkData")) {
        this.u = paramString.getInt("cacheTimeRemarkData");
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
      QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, String.format(Locale.getDefault(), "update {switchOn: %s, troopMemberNumLimit: %s, troopJoinDayLimit: %s, commonFriendProportionLimit:%s, troopJoinLine: %s, insertGrayTipLimit: %s, nonFriendProportionLimit: %s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Float.valueOf(this.jdField_a_of_type_Float), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.d), Float.valueOf(this.jdField_b_of_type_Float) }));
      paramString = new StringBuilder();
      paramString.append("update tipsTotalCountForTroopEveryday = ");
      paramString.append(this.e);
      paramString.append(",tipsTotalCountForUin = ");
      paramString.append(this.f);
      paramString.append(",au_totalCommonFriends = ");
      paramString.append(this.g);
      paramString.append(",au_switchOn = ");
      paramString.append(this.h);
      paramString.append(",hfi_interactDuration = ");
      paramString.append(this.i);
      paramString.append(",hfi_interactRounds = ");
      paramString.append(this.j);
      paramString.append(",hfi_commonFriends = ");
      paramString.append(this.k);
      paramString.append(",nm_newMemberIndex = ");
      paramString.append(this.m);
      paramString.append(",nm_commonFriends = ");
      paramString.append(this.n);
      paramString.append(",nm_switchOn = ");
      paramString.append(this.o);
      paramString.append(",aor_maxDateLength = ");
      paramString.append(this.jdField_a_of_type_Double);
      paramString.append(",aor_maxMsgCount = ");
      paramString.append(this.p);
      paramString.append(",aor_switchOn = ");
      paramString.append(this.q);
      paramString.append(",aor_commonFriends = ");
      paramString.append(this.r);
      paramString.append(",troopMemberCount_ahn = ");
      paramString.append(this.s);
      paramString.append(",troopType_ahn = ");
      paramString.append(Arrays.toString(this.jdField_b_of_type_ArrayOfLong));
      paramString.append(",cacheTimeCmnFrdCntData = ");
      paramString.append(this.t);
      paramString.append(",cacheTimeRemarkData = ");
      paramString.append(this.u);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig
 * JD-Core Version:    0.7.0.1
 */