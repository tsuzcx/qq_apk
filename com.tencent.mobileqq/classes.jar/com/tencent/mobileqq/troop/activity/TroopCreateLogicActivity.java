package com.tencent.mobileqq.troop.activity;

import ajyc;
import akhq;
import akim;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import aqas;
import aqbc;
import aqdk;
import axuk;
import axuo;
import axux;
import axuy;
import ayki;
import azhz;
import azia;
import azib;
import azic;
import azid;
import azie;
import azif;
import azoa;
import azoj;
import azok;
import bamh;
import batu;
import bbev;
import bbjj;
import bcpw;
import bcwh;
import bdhr;
import bgyu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogicActivity
  extends BaseActivity
  implements azoj
{
  public akim a;
  azoa jdField_a_of_type_Azoa = null;
  batu jdField_a_of_type_Batu;
  public bcwh a;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  public String a;
  public boolean a;
  
  public TroopCreateLogicActivity()
  {
    this.jdField_a_of_type_Bcwh = new azhz(this);
    this.jdField_a_of_type_Akim = new azia(this);
  }
  
  private void a()
  {
    if (getIntent() != null) {
      aqdk.a(getIntent(), this.app, this).a(aqas.a.intValue(), getIntent().getExtras());
    }
  }
  
  private void a(String paramString, azif paramazif)
  {
    if ((paramazif == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setURLDrawableListener(new azid(this, paramString, paramazif));
    paramString.setDownloadListener(new azie(this, paramString, paramazif));
    if (paramString.getStatus() == 1)
    {
      paramazif.a(bdhr.a(paramString, 100, 100));
      return;
    }
    paramString.startDownload();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("shareLink");
    String str1 = paramJSONObject.optString("shareTitle");
    String str2 = paramJSONObject.optString("shareDesc");
    paramJSONObject = paramJSONObject.optString("shareIcon");
    localObject = new axuk(StructMsgForGeneralShare.class).c(149).a(ajyc.a(2131715280) + str1).e((String)localObject).a();
    axuo localaxuo = axux.a(2);
    localaxuo.a(paramJSONObject, str1, str2);
    ((AbsShareMsg)localObject).addItem(localaxuo);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("forward_type", -3);
    paramJSONObject.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
    aqbc.a(this, paramJSONObject, 1002);
  }
  
  private void b()
  {
    if (getIntent() != null) {
      aqdk.a(getIntent(), this.app, this).p();
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    Object localObject = paramJSONObject.optString("shareIcon");
    paramJSONObject = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.add(localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("title", str2);
    ((Bundle)localObject).putString("desc", str3);
    ((Bundle)localObject).putLong("req_share_id", 0L);
    ((Bundle)localObject).putString("detail_url", str1);
    ((Bundle)localObject).putString("url", str1);
    ((Bundle)localObject).putStringArrayList("image_url", paramJSONObject);
    ((Bundle)localObject).putString("bizname", "SharePlato");
    bgyu.a(this.app, this, (Bundle)localObject, null, 1001);
  }
  
  private void c()
  {
    Object localObject = getIntent();
    int i = ((Intent)localObject).getIntExtra("chanelId", -1);
    localObject = ((Intent)localObject).getStringExtra("params");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        switch (i)
        {
        case 0: 
          QLog.e("qqBaseActivity", 1, "unrecognized channel! shareChanel = " + i);
          finish();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "commonShare failed! exception = ", localException);
        return;
      }
      a((JSONObject)localObject);
      return;
      b(localException);
      return;
      c(localException);
      return;
      d(localException);
      return;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (!bbev.g(this))
    {
      bcpw.a(this, 1, 2131694609, 1).a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new azib(this, str2, str3, str1));
    finish();
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (!bbev.g(this))
    {
      bcpw.a(this, 1, 2131694609, 1).a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new azic(this, str2, str3, str1));
    finish();
  }
  
  public void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("retCode", paramInt);
    localIntent.putExtra("troopUin", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null)
    {
      finish();
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString);
    if (localTroopInfo == null)
    {
      finish();
      return;
    }
    localObject = new JSONObject();
    paramString = "";
    try
    {
      if (!TextUtils.isEmpty(localTroopInfo.mRichFingerMemo)) {
        paramString = new ayki(localTroopInfo.mRichFingerMemo, 11).a();
      }
      ((JSONObject)localObject).put("classify", localTroopInfo.dwGroupClassExt);
      ((JSONObject)localObject).put("name", localTroopInfo.troopname);
      ((JSONObject)localObject).put("introduction", paramString);
      ((JSONObject)localObject).put("location", localTroopInfo.strLocation);
      ((JSONObject)localObject).put("percentage", "1.0");
      paramString = new Intent();
      paramString.putExtra("modifiedInfo", ((JSONObject)localObject).toString());
      setResult(-1, paramString);
      finish();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      finish();
    }
  }
  
  public void b(int paramInt, String paramString) {}
  
  public void b(String paramString)
  {
    if ((this.app == null) || (this.jdField_a_of_type_Batu == null) || (TextUtils.isEmpty(paramString))) {
      finish();
    }
    label76:
    do
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        try
        {
          if (Long.parseLong(paramString) > 0L) {
            break label76;
          }
          finish();
          return;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          TroopManager localTroopManager;
          paramString = "";
        }
      }
      finish();
      localJSONException1.printStackTrace();
      while (TextUtils.isEmpty(paramString))
      {
        finish();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = paramString;
      localTroopManager = (TroopManager)this.app.getManager(52);
    } while (localTroopManager == null);
    paramString = localTroopManager.b(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(paramString, getResources(), this.app.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
    }
    this.jdField_a_of_type_Batu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
  }
  
  public void c(String paramString) {}
  
  public void d(String paramString)
  {
    j = 0;
    String str4 = "";
    String str2 = "";
    i = j;
    localObject1 = str2;
    localObject2 = str4;
    if (this.app != null)
    {
      i = j;
      localObject1 = str2;
      localObject2 = str4;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = str2;
        localObject2 = str4;
        str3 = str2;
        str1 = str4;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = str2;
      localObject2 = str4;
      str3 = str2;
      str1 = str4;
      paramString = localJSONObject.getString("troopUin");
      localObject1 = str2;
      localObject2 = paramString;
      str3 = str2;
      str1 = paramString;
      str2 = localJSONObject.getString("groupName");
      localObject1 = str2;
      localObject2 = paramString;
      str3 = str2;
      str1 = paramString;
      long l = Long.parseLong(paramString);
      i = j;
      localObject1 = str2;
      localObject2 = paramString;
      if (l > 0L)
      {
        i = 1;
        localObject2 = paramString;
        localObject1 = str2;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
        localObject1 = str3;
        localObject2 = str1;
      }
    }
    if (i != 0)
    {
      paramString = new TroopInfo();
      paramString.troopuin = ((String)localObject2);
      paramString.troopname = ((String)localObject1);
      paramString.Administrator = this.app.getCurrentAccountUin();
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 != null) {
        ((TroopManager)localObject1).b(paramString);
      }
    }
    finish();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      int i;
      Object localObject;
      do
      {
        return;
        if (paramInt2 != -1) {
          break;
        }
        i = getResources().getDimensionPixelSize(2131298865);
        bcpw.a(this, 2, getString(2131696779), 0).b(i);
        localObject = axuy.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      } while (localObject == null);
      if ((localObject instanceof StructMsgForImageShare)) {}
      String str;
      for (;;)
      {
        if (TextUtils.isEmpty(paramIntent.getExtras().getString("share_comment_message"))) {
          localObject = ((AbsStructMsg)localObject).mCommentText;
        }
        this.jdField_a_of_type_Boolean = false;
        finish();
        break;
        str = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("uintype", -1);
        bbjj.a(this.app, str, i, (AbsStructMsg)localObject, null);
      }
      if (paramInt2 == -1)
      {
        localObject = axuy.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        str = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("uintype", -1);
        if ((localObject == null) || (TextUtils.isEmpty(str))) {
          break label244;
        }
        bbjj.a(this.app, str, i, (AbsStructMsg)localObject, null);
      }
      for (;;)
      {
        finish();
        break;
        label244:
        if (QLog.isColorLevel()) {
          QLog.e("qqBaseActivity", 2, "friendUin = " + str + " structMsg = " + localObject);
        }
      }
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Azoa = ((azoa)this.app.getManager(32));
    this.jdField_a_of_type_Batu = new batu(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", -1);
    if (i == 1) {
      e(paramBundle.getStringExtra("cfg"));
    }
    for (;;)
    {
      bamh.a("TroopCreateLogicActivity", new String[] { "" + i });
      return true;
      if (i == 2)
      {
        f(paramBundle.getStringExtra("troop_uin"));
      }
      else if (i == 3)
      {
        b(paramBundle.getStringExtra("cfg"));
      }
      else if (i == 4)
      {
        a(paramBundle.getStringExtra("troop_uin"));
      }
      else if (i == 5)
      {
        String str = paramBundle.getStringExtra("troop_location");
        long l = paramBundle.getLongExtra("troop_uin", 0L);
        this.app.addObserver(this.jdField_a_of_type_Akim);
        ((akhq)this.app.a(20)).a(l, TextUtils.isEmpty(str), str);
      }
      else if (i == 6)
      {
        if (this.jdField_a_of_type_Azoa == null)
        {
          finish();
        }
        else
        {
          paramBundle = new Intent();
          paramBundle.putExtra("has_head", this.jdField_a_of_type_Azoa.a().jdField_a_of_type_Boolean);
          setResult(-1, paramBundle);
          finish();
        }
      }
      else if (i == 7)
      {
        d(paramBundle.getStringExtra("cfg"));
      }
      else if (i == 8)
      {
        c();
      }
      else if (i == 9)
      {
        a();
      }
      else if (i == 10)
      {
        b();
      }
      else
      {
        finish();
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Azoa = null;
    if (this.jdField_a_of_type_Batu != null)
    {
      this.jdField_a_of_type_Batu.f();
      this.jdField_a_of_type_Batu = null;
    }
    if (this.jdField_a_of_type_Akim != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Akim);
      this.jdField_a_of_type_Akim = null;
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_Azoa != null)
    {
      this.jdField_a_of_type_Azoa.a(paramString, 0);
      this.jdField_a_of_type_Azoa.b(this);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Azoa != null) {
      this.jdField_a_of_type_Azoa.a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    finish();
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity
 * JD-Core Version:    0.7.0.1
 */