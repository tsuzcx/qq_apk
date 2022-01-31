package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
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
    if (this.this$0.mRunFirstTime.compareAndSet(false, true)) {}
    long l;
    String str1;
    try
    {
      bool = VipFunCallManager.a(this.this$0.app.getApplication(), "ThemeDIYActivity", false);
      l = Utils.b();
      QLog.d("ThemeDIYActivity", 2, "loadResJson Err haveSDCard:" + bool + ", availableSpace:" + l);
      if (100 == this.val$resType)
      {
        str1 = "diytheme.json";
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "loadResJson decode scid json: " + str1 + ", ifAfterDownladed:" + this.val$ifAfterDownladed);
        }
        Object localObject1 = this.this$0.app;
        if (this.val$ifAfterDownladed) {
          break label264;
        }
        bool = true;
        localObject1 = VasQuickUpdateManager.a((AppRuntime)localObject1, str1, bool, this.this$0.callBacker);
        if (localObject1 != null) {
          break label270;
        }
        QLog.d("ThemeDIYActivity", 2, "parseCloudKeywordsJson json file not, json: " + str1 + ", ifAfterDownladed:" + this.val$ifAfterDownladed);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.d("ThemeDIYActivity", 2, "loadResJson Err2 e:" + localException1.getMessage());
        continue;
        str1 = "diytheme.style.json";
        continue;
        label264:
        boolean bool = false;
      }
      label270:
      i = 0;
    }
    Object localObject3;
    Object localObject4;
    try
    {
      l = localException1.optLong("timeStamp");
      if (100 != this.val$resType) {
        break label519;
      }
      JSONArray localJSONArray1 = localException1.getJSONArray("data");
      i = 0;
      if (i < localJSONArray1.length())
      {
        localObject3 = localJSONArray1.getJSONObject(i);
        localObject4 = new ResSuitData.BgSuit((JSONObject)localObject3);
        ((ResSuitData.BgSuit)localObject4).from = 2;
        if (((ResSuitData.BgSuit)localObject4).isdecoded) {
          this.this$0.mBgSuits.add(localObject4);
        } else {
          QLog.e("ThemeDIYActivity", 2, "loadResJson bgSuit.isdecoded = false, bgObj=" + localObject3 + ", timeStamp:" + l);
        }
      }
    }
    catch (Exception localException2)
    {
      QLog.e("ThemeDIYActivity", 1, "loadResJson Err:" + localException2.getMessage());
      return;
    }
    Object localObject2 = this.this$0.mBgSuits;
    int i = 0;
    break label1614;
    label444:
    int j;
    label488:
    int k;
    label519:
    label561:
    int m;
    if (j < this.this$0.showData.length)
    {
      if (this.this$0.showData[j].usedBgRSD == null) {
        break label1660;
      }
      localObject3 = this.this$0.showData[j].usedBgRSD.id;
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || ("100".equals(localObject3))) {
        break label1624;
      }
      if (!"99".equals(localObject3)) {
        break label1666;
      }
      break label1624;
      localObject4 = ThemeUtil.getThemeDensity(this.this$0.mContext);
      JSONArray localJSONArray2 = ((JSONObject)localObject2).getJSONArray("data");
      if (localJSONArray2.length() <= 0) {
        break label1631;
      }
      this.this$0.mStyleSuits.clear();
      break label1631;
      if (k < localJSONArray2.length())
      {
        localObject3 = localJSONArray2.getJSONObject(k);
        Object localObject5 = ((JSONObject)localObject3).getJSONObject("data");
        JSONObject localJSONObject2 = ((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0);
        String str2 = ((JSONObject)localObject3).optString("id");
        if (localJSONObject2.optInt("status", 1) != 1)
        {
          localObject3 = localObject2;
          m = i;
          if (!QLog.isColorLevel()) {
            break label1639;
          }
          QLog.d("ThemeDIYActivity", 2, "loadResJson style status: " + localJSONObject2.optInt("status") + ", id:" + str2 + ", timeStamp:" + l);
          localObject3 = localObject2;
          m = i;
          break label1639;
        }
        JSONObject localJSONObject1 = ((JSONObject)localObject5).getJSONArray("operateAndroid").getJSONObject(0);
        if ((!IndividuationConfigInfo.a(localJSONObject1.optString("minVersion"), "7.6.3")) || (IndividuationConfigInfo.a(localJSONObject1.optString("maxVersion"), "7.6.3")))
        {
          localObject3 = localObject2;
          m = i;
          if (!QLog.isColorLevel()) {
            break label1639;
          }
          QLog.d("ThemeDIYActivity", 2, "loadResJson style subVersion: 7.6.3, minVersion:" + localJSONObject1.optString("minVersion") + ", maxVersion:" + localJSONObject1.optString("maxVersion") + ", id:" + str2 + ", timeStamp:" + l);
          localObject3 = localObject2;
          m = i;
          break label1639;
        }
        ResSuitData.StyleSuit localStyleSuit = new ResSuitData.StyleSuit();
        localStyleSuit.id = str2;
        localStyleSuit.appStr = ((JSONObject)localObject3).optString("app");
        localStyleSuit.typeStr = ((JSONObject)localObject3).optString("type");
        localStyleSuit.name = localJSONObject2.optString("name");
        localStyleSuit.feeType = localJSONObject2.getInt("feeType");
        localStyleSuit.thumbnail = localJSONObject2.optString("image");
        localStyleSuit.setFrontImg = localJSONObject2.optString("setFrontImg");
        localStyleSuit.msgFrontImg = localJSONObject2.optString("msgFrontImg");
        localStyleSuit.chatFrontImg = localJSONObject2.optString("chatFrontImg");
        localStyleSuit.zipVersion = localJSONObject1.optString("zipVersion");
        if ("999".equals(localStyleSuit.id))
        {
          this.this$0.mStyleSuits.add(0, localStyleSuit);
          if (this.this$0.tryOnStyleRSD == null) {
            this.this$0.tryOnStyleRSD = localStyleSuit;
          }
          j = i;
          if (!TextUtils.isEmpty(this.this$0.mUserThemeId))
          {
            j = i;
            if (this.this$0.mUserThemeId.equals(localStyleSuit.id))
            {
              this.this$0.initStyleRSD = localStyleSuit;
              this.this$0.usedStyleRSD = localStyleSuit;
              this.this$0.tryOnStyleRSD = localStyleSuit;
              localObject3 = this.this$0.mAdapter;
              this.this$0.mAdapter.tryOnStyleRSD = localStyleSuit;
              ((ThemeDiyBgAdapter)localObject3).usedStyleRSD = localStyleSuit;
              j = 1;
            }
          }
          if (!((String)localObject4).equals("m")) {
            break label1273;
          }
          localStyleSuit.zipSize = localJSONObject1.optInt("m_size");
          localStyleSuit.zipUrl = localJSONObject1.optString("zipm");
          localStyleSuit.zipVersion = localJSONObject1.optString("m_version");
        }
        for (;;)
        {
          localObject3 = localObject2;
          m = j;
          if (j != 1) {
            break label1639;
          }
          localObject2 = ((JSONObject)localObject5).getJSONArray("bgList");
          i = 0;
          label1176:
          if ((i >= ((JSONArray)localObject2).length()) || (i >= 5)) {
            break label1419;
          }
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject5 = new ResSuitData.BgSuit((JSONObject)localObject3);
          ((ResSuitData.BgSuit)localObject5).from = 1;
          if (!((ResSuitData.BgSuit)localObject5).isdecoded) {
            break label1379;
          }
          if (localStyleSuit.bgSuits == null) {
            localStyleSuit.bgSuits = new ArrayList();
          }
          localStyleSuit.bgSuits.add(localObject5);
          break label1653;
          this.this$0.mStyleSuits.add(localStyleSuit);
          break;
          label1273:
          if (((String)localObject4).equals("h"))
          {
            localStyleSuit.zipSize = localJSONObject1.optInt("h_size");
            localStyleSuit.zipUrl = localJSONObject1.optString("ziph");
            localStyleSuit.zipVersion = localJSONObject1.optString("h_version");
          }
          else if (((String)localObject4).equals("xh"))
          {
            localStyleSuit.zipSize = localJSONObject1.optInt("xh_size");
            localStyleSuit.zipUrl = localJSONObject1.optString("zipxh");
            localStyleSuit.zipVersion = localJSONObject1.optString("xh_version");
          }
        }
        label1379:
        QLog.e("ThemeDIYActivity", 2, "loadResJson style.bgSuit.isdecoded = false, bgObj=" + localObject3 + ", timeStamp:" + l);
        break label1653;
        label1419:
        localObject3 = localStyleSuit.bgSuits;
        m = j;
        break label1639;
      }
      if ((i == 1) || (this.this$0.mStyleSuits.size() <= 0)) {
        break label1604;
      }
      i = 1;
      break label1614;
    }
    for (;;)
    {
      if (k < ((ArrayList)localObject2).size())
      {
        localObject4 = (ResSuitData)((ArrayList)localObject2).get(k);
        if (!((String)localObject3).equals(((ResSuitData)localObject4).id)) {
          break label1671;
        }
        this.this$0.showData[j].usedBgRSD = ((ResSuitData)localObject4);
        this.this$0.showData[j].initBgRSD = ((ResSuitData)localObject4);
        break label1671;
        label1604:
        label1614:
        do
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "loadResJson decode json complete scid: " + str1 + ", ifAfterDownladed:" + this.val$ifAfterDownladed + ", timeStamp=" + l);
          }
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 21, i, this.val$resType));
          return;
          continue;
          i += 1;
          break;
        } while (localObject2 == null);
        j = 0;
        break label444;
      }
      label1624:
      j += 1;
      break label444;
      label1631:
      localObject2 = null;
      k = 0;
      break label561;
      label1639:
      k += 1;
      localObject2 = localObject3;
      i = m;
      break label561;
      label1653:
      i += 1;
      break label1176;
      label1660:
      localObject3 = null;
      break label488;
      label1666:
      k = 0;
      continue;
      label1671:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.4
 * JD-Core Version:    0.7.0.1
 */