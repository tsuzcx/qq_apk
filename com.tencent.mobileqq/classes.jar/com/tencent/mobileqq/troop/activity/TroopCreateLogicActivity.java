package com.tencent.mobileqq.troop.activity;

import alud;
import amdu;
import ameq;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import aryl;
import aryv;
import asbd;
import azup;
import azut;
import azvc;
import azvd;
import bamp;
import bbkt;
import bbku;
import bbkv;
import bbkw;
import bbkx;
import bbky;
import bbkz;
import bbqu;
import bbrd;
import bbre;
import bcpr;
import bcxl;
import bdin;
import bdna;
import bfah;
import bfln;
import bjev;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogicActivity
  extends BaseActivity
  implements bbrd
{
  public ameq a;
  bbqu jdField_a_of_type_Bbqu = null;
  bcxl jdField_a_of_type_Bcxl;
  public bfah a;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  public String a;
  public boolean a;
  
  public TroopCreateLogicActivity()
  {
    this.jdField_a_of_type_Bfah = new bbkt(this);
    this.jdField_a_of_type_Ameq = new bbku(this);
  }
  
  private void a()
  {
    if (getIntent() != null) {
      asbd.a(getIntent(), this.app, this).a(aryl.a.intValue(), getIntent().getExtras());
    }
  }
  
  private void a(String paramString, bbkz parambbkz)
  {
    if ((parambbkz == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setURLDrawableListener(new bbkx(this, paramString, parambbkz));
    paramString.setDownloadListener(new bbky(this, paramString, parambbkz));
    if (paramString.getStatus() == 1)
    {
      parambbkz.a(bfln.a(paramString, 100, 100));
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
    localObject = new azup(StructMsgForGeneralShare.class).c(149).a(alud.a(2131715675) + str1).e((String)localObject).a();
    azut localazut = azvc.a(2);
    localazut.a(paramJSONObject, str1, str2);
    ((AbsShareMsg)localObject).addItem(localazut);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("forward_type", -3);
    paramJSONObject.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
    aryv.a(this, paramJSONObject, 1002);
  }
  
  private void b()
  {
    if (getIntent() != null) {
      asbd.a(getIntent(), this.app, this).p();
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
    bjev.a(this.app, this, (Bundle)localObject, null, 1001);
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
    if (!bdin.g(this))
    {
      QQToast.a(this, 1, 2131694768, 1).a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new bbkv(this, str2, str3, str1));
    finish();
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (!bdin.g(this))
    {
      QQToast.a(this, 1, 2131694768, 1).a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new bbkw(this, str2, str3, str1));
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
        paramString = new bamp(localTroopInfo.mRichFingerMemo, 11).a();
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
    if ((this.app == null) || (this.jdField_a_of_type_Bcxl == null) || (TextUtils.isEmpty(paramString))) {
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
    this.jdField_a_of_type_Bcxl.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
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
        i = getResources().getDimensionPixelSize(2131298914);
        QQToast.a(this, 2, getString(2131696957), 0).b(i);
        localObject = azvd.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
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
        bdna.a(this.app, str, i, (AbsStructMsg)localObject, null);
      }
      if (paramInt2 == -1)
      {
        localObject = azvd.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        str = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("uintype", -1);
        if ((localObject == null) || (TextUtils.isEmpty(str))) {
          break label244;
        }
        bdna.a(this.app, str, i, (AbsStructMsg)localObject, null);
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
    this.jdField_a_of_type_Bbqu = ((bbqu)this.app.getManager(32));
    this.jdField_a_of_type_Bcxl = new bcxl(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", -1);
    if (i == 1) {
      e(paramBundle.getStringExtra("cfg"));
    }
    for (;;)
    {
      bcpr.a("TroopCreateLogicActivity", new String[] { "" + i });
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
        this.app.addObserver(this.jdField_a_of_type_Ameq);
        ((amdu)this.app.a(20)).a(l, TextUtils.isEmpty(str), str);
      }
      else if (i == 6)
      {
        if (this.jdField_a_of_type_Bbqu == null)
        {
          finish();
        }
        else
        {
          paramBundle = new Intent();
          paramBundle.putExtra("has_head", this.jdField_a_of_type_Bbqu.a().jdField_a_of_type_Boolean);
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
    this.jdField_a_of_type_Bbqu = null;
    if (this.jdField_a_of_type_Bcxl != null)
    {
      this.jdField_a_of_type_Bcxl.f();
      this.jdField_a_of_type_Bcxl = null;
    }
    if (this.jdField_a_of_type_Ameq != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ameq);
      this.jdField_a_of_type_Ameq = null;
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_Bbqu != null)
    {
      this.jdField_a_of_type_Bbqu.a(paramString, 0);
      this.jdField_a_of_type_Bbqu.b(this);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Bbqu != null) {
      this.jdField_a_of_type_Bbqu.a();
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