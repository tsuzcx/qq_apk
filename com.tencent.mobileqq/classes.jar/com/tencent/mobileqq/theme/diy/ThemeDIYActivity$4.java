package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bhnm;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

class ThemeDIYActivity$4
  implements Runnable
{
  ThemeDIYActivity$4(ThemeDIYActivity paramThemeDIYActivity, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    String str1 = ThemeDIYActivity.access$000(this.this$0, this.val$resType, this.val$ifAfterDownladed);
    Object localObject1 = this.this$0.app;
    if (!this.val$ifAfterDownladed) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, str1, bool, this.this$0.callBacker);
      if (localObject1 != null) {
        break;
      }
      QLog.d("ThemeDIYActivity", 2, "parseCloudKeywordsJson json file not, json: " + str1 + ", ifAfterDownladed:" + this.val$ifAfterDownladed);
      return;
    }
    int i = 0;
    long l;
    int j;
    Object localObject3;
    label197:
    Object localObject4;
    label270:
    int k;
    try
    {
      l = ((JSONObject)localObject1).optLong("timeStamp");
      if (100 == this.val$resType)
      {
        localObject1 = ThemeDIYActivity.access$100(this.this$0, (JSONObject)localObject1, l);
        i = 0;
        break label1036;
        if (j >= this.this$0.showData.length) {
          break label951;
        }
        if (this.this$0.showData[j].usedBgRSD == null) {
          break label1081;
        }
        localObject3 = this.this$0.showData[j].usedBgRSD.id;
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ("100".equals(localObject3))) {
          break label1046;
        }
        if (!"99".equals(localObject3)) {
          break label1087;
        }
        break label1046;
      }
      localObject4 = ThemeUtil.getThemeDensity(this.this$0.mContext);
      localJSONArray = ((JSONObject)localObject1).getJSONArray("data");
      if (localJSONArray.length() <= 0) {
        break label1053;
      }
      this.this$0.mStyleSuits.clear();
    }
    catch (Exception localException)
    {
      JSONArray localJSONArray;
      QLog.e("ThemeDIYActivity", 1, "loadResJson Err:" + localException.getMessage());
      return;
    }
    Object localObject2;
    if (j < localJSONArray.length())
    {
      localObject3 = localJSONArray.getJSONObject(j);
      Object localObject5 = ((JSONObject)localObject3).getJSONObject("data");
      JSONObject localJSONObject1 = ((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0);
      String str2 = ((JSONObject)localObject3).optString("id");
      if (localJSONObject1.optInt("status", 1) != 1)
      {
        localObject3 = localObject1;
        k = i;
        if (QLog.isColorLevel())
        {
          QLog.d("ThemeDIYActivity", 2, "loadResJson style status: " + localJSONObject1.optInt("status") + ", id:" + str2 + ", timeStamp:" + l);
          localObject3 = localObject1;
          k = i;
        }
      }
      else
      {
        JSONObject localJSONObject2 = ((JSONObject)localObject5).getJSONArray("operateAndroid").getJSONObject(0);
        if ((!bhnm.a(localJSONObject2.optString("minVersion"), "8.4.10")) || (bhnm.a(localJSONObject2.optString("maxVersion"), "8.4.10")))
        {
          localObject3 = localObject1;
          k = i;
          if (QLog.isColorLevel())
          {
            QLog.d("ThemeDIYActivity", 2, "loadResJson style subVersion: 8.4.10, minVersion:" + localJSONObject2.optString("minVersion") + ", maxVersion:" + localJSONObject2.optString("maxVersion") + ", id:" + str2 + ", timeStamp:" + l);
            localObject3 = localObject1;
            k = i;
          }
        }
        else
        {
          ResSuitData.StyleSuit localStyleSuit = new ResSuitData.StyleSuit();
          localStyleSuit.id = str2;
          localStyleSuit.appStr = ((JSONObject)localObject3).optString("app");
          localStyleSuit.typeStr = ((JSONObject)localObject3).optString("type");
          localStyleSuit.name = localJSONObject1.optString("name");
          localStyleSuit.feeType = localJSONObject1.getInt("feeType");
          localStyleSuit.thumbnail = localJSONObject1.optString("image");
          localStyleSuit.setFrontImg = localJSONObject1.optString("setFrontImg");
          localStyleSuit.msgFrontImg = localJSONObject1.optString("msgFrontImg");
          localStyleSuit.chatFrontImg = localJSONObject1.optString("chatFrontImg");
          localStyleSuit.zipVersion = localJSONObject2.optString("zipVersion");
          int m = ThemeDIYActivity.access$200(this.this$0, i, (String)localObject4, localJSONObject2, localStyleSuit);
          localObject3 = localException;
          k = m;
          if (m == 1)
          {
            localObject2 = ((JSONObject)localObject5).getJSONArray("bgList");
            i = 0;
            label730:
            if ((i < ((JSONArray)localObject2).length()) && (i < 5))
            {
              localObject3 = ((JSONArray)localObject2).getJSONObject(i);
              localObject5 = new ResSuitData.BgSuit((JSONObject)localObject3);
              ((ResSuitData.BgSuit)localObject5).from = 1;
              if (((ResSuitData.BgSuit)localObject5).isdecoded)
              {
                if (localStyleSuit.bgSuits == null) {
                  localStyleSuit.bgSuits = new ArrayList();
                }
                localStyleSuit.bgSuits.add(localObject5);
                break label1074;
              }
              QLog.e("ThemeDIYActivity", 2, "loadResJson style.bgSuit.isdecoded = false, bgObj=" + localObject3 + ", timeStamp:" + l);
              break label1074;
            }
            localObject3 = localStyleSuit.bgSuits;
            k = m;
          }
        }
      }
    }
    else if ((i != 1) && (this.this$0.mStyleSuits.size() > 0))
    {
      i = 1;
    }
    for (;;)
    {
      if (k < ((ArrayList)localObject2).size())
      {
        localObject4 = (ResSuitData)((ArrayList)localObject2).get(k);
        if (!((String)localObject3).equals(((ResSuitData)localObject4).id)) {
          break label1092;
        }
        this.this$0.showData[j].usedBgRSD = ((ResSuitData)localObject4);
        this.this$0.showData[j].initBgRSD = ((ResSuitData)localObject4);
        break label1092;
        label951:
        do
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "loadResJson decode json complete scid: " + str1 + ", ifAfterDownladed:" + this.val$ifAfterDownladed + ", timeStamp=" + l);
          }
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 21, i, this.val$resType));
          return;
        } while (localObject2 == null);
        label1036:
        j = 0;
        break;
      }
      label1046:
      j += 1;
      break;
      label1053:
      localObject2 = null;
      j = 0;
      break label270;
      j += 1;
      localObject2 = localObject3;
      i = k;
      break label270;
      label1074:
      i += 1;
      break label730;
      label1081:
      localObject3 = null;
      break label197;
      label1087:
      k = 0;
      continue;
      label1092:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.4
 * JD-Core Version:    0.7.0.1
 */