package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardQFavBatchOption
  extends ForwardBaseOption
{
  boolean a = false;
  boolean ad = false;
  
  public ForwardQFavBatchOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void a(Intent paramIntent, Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    paramString1 = SVBusiUtil.a(3, 2);
    paramIntent.putExtras(paramBundle);
    paramIntent = ShortVideoBusiManager.b(2, paramIntent, paramString1);
    paramIntent.e = this.t.getString("uin");
    paramIntent.f = this.t.getString("troop_uin");
    paramIntent.c = this.t.getInt("uintype");
    paramIntent.b = 2;
    paramIntent.G = paramInt2;
    paramString1.a(paramIntent);
    ShortVideoBusiManager.a(paramString1, this.q);
    QfavReport.a(this.q, "User_Forward", 5, 0, paramInt3);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    String str = AppConstants.DATALINE_PC_UIN;
    paramBundle = QfavHelper.a(paramBundle, str, 7);
    if (paramBundle == null) {
      return;
    }
    this.q.getFileManagerEngine().a(paramBundle, str, 6000, paramInt);
  }
  
  private void a(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    paramBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131889195));
    paramBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131889193));
    paramBundle.putString("struct_share_key_source_action", "plugin");
    paramBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
    paramBundle.putInt("req_type", 133);
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = paramBundle.getBoolean("bFriendCard", false);
    Object localObject1 = paramBundle.getByteArray("sBizDataList");
    int i;
    Object localObject2;
    if (paramInt1 == 6)
    {
      i = paramBundle.getInt("nLinkType");
      if ((i != 4) && (i != 5))
      {
        if ((i != 6) && (i != 7))
        {
          if (i == 8) {
            bool1 = a((byte[])localObject1, paramString1, paramString1, paramString2, paramInt2, paramInt3);
          }
          i = 0;
        }
        else
        {
          i = 1;
          bool1 = bool2;
        }
      }
      else
      {
        localObject2 = new ArkAppMessage();
        ((ArkAppMessage)localObject2).fromAppXml(new String((byte[])localObject1));
        localObject2 = MessageRecordFactory.a(this.q, paramString1, paramString2, paramInt2, (ArkAppMessage)localObject2);
        ForwardOrderManager.a().a(((MessageForArkApp)localObject2).uniseq, ((MessageForArkApp)localObject2).uniseq, paramInt3);
        this.q.getMessageFacade().a((MessageRecord)localObject2, null);
        i = 0;
        bool1 = true;
      }
    }
    else
    {
      if ((bool3) && (localObject1 != null)) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = false;
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (i != 0)
      {
        bool2 = bool1;
        if (localObject1 != null)
        {
          localObject1 = StructMsgFactory.a((byte[])localObject1, 0);
          bool2 = bool1;
          if (localObject1 != null)
          {
            localObject2 = this.q;
            i = MobileQQService.seq;
            MobileQQService.seq = i + 1;
            localObject2 = MessageRecordFactory.c((QQAppInterface)localObject2, paramString3, paramString1, paramString2, paramInt2, i, (AbsStructMsg)localObject1);
            ForwardOrderManager.a().a(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, paramInt3);
            this.q.getMessageFacade().a((MessageRecord)localObject2, null);
            bool2 = true;
          }
        }
      }
    }
    if (!bool2)
    {
      paramBundle = StructMsgFactory.a(paramBundle);
      localObject1 = this.q;
      i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      paramString1 = MessageRecordFactory.c((QQAppInterface)localObject1, paramString3, paramString1, paramString2, paramInt2, i, paramBundle);
      ForwardOrderManager.a().a(paramString1.uniseq, paramBundle.uniseq, paramInt3);
      this.q.getMessageFacade().a(paramString1, null);
    }
    if (paramInt1 == 8)
    {
      QfavReport.a(this.q, "User_Forward", 8, 0, paramInt4);
      return;
    }
    QfavReport.a(this.q, "User_Forward", 2, 0, paramInt4);
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    paramString4 = new SessionInfo();
    paramString4.b = paramString2;
    paramString4.e = paramString1;
    paramString4.a = paramInt1;
    paramString4.c = paramString3;
    paramString1 = paramBundle.getString("lat");
    paramString2 = paramBundle.getString("lon");
    paramString3 = paramBundle.getString("title");
    paramBundle = paramBundle.getString("address");
    this.t.putInt("isArk", 1);
    ChatActivityFacade.a(this.s, this.q, paramString4, paramString1, paramString2, paramBundle, paramString3, paramBundle, null, "", "", "", this.t);
    QfavReport.a(this.q, "User_Forward", 7, 0, paramInt3);
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length <= 0) {
        return false;
      }
    }
    Object localObject;
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = (byte[])localObject)
    {
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte).optJSONObject("arkAppInfo");
        if (paramArrayOfByte == null) {
          return false;
        }
        localObject = paramArrayOfByte.optString("appName");
        String str1 = paramArrayOfByte.optString("appDesc");
        String str2 = paramArrayOfByte.optString("appMinVersion", "0.0.0.1");
        String str3 = paramArrayOfByte.optString("appView");
        String str4 = paramArrayOfByte.optString("appConfig");
        String str5 = paramArrayOfByte.optString("metaData");
        paramArrayOfByte = new ArkAppMessage(paramArrayOfByte.optString("promptText"), (String)localObject, str1, str3, str2, str5, str4, "");
        localObject = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject, this.t, paramArrayOfByte);
        if (localObject != null) {
          continue;
        }
        localObject = new SessionInfo();
        ((SessionInfo)localObject).b = paramString2;
        ((SessionInfo)localObject).e = paramString1;
        ((SessionInfo)localObject).a = paramInt1;
        ((SessionInfo)localObject).c = paramString3;
        paramArrayOfByte.forwardID = paramInt2;
        ChatActivityFacade.b(this.q, (SessionInfo)localObject, paramArrayOfByte);
        return true;
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return false;
    }
  }
  
  private void b(Bundle paramBundle, int paramInt)
  {
    String str = this.t.getString("uin");
    int i = this.t.getInt("uintype");
    paramBundle = QfavHelper.a(paramBundle, this.t.getString("uin"), this.t.getInt("uintype"));
    if (paramBundle == null) {
      return;
    }
    this.q.getFileManagerEngine().a(paramBundle, str, i, paramInt);
  }
  
  private void b(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    String str = paramBundle.getString("text");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    paramBundle = MessageRecordFactory.a(this.q, paramString3, paramString1, paramString2, paramInt2, (byte)1, (byte)0, (short)0, paramBundle);
    if (this.q.getMessageFacade() != null) {
      this.q.getMessageFacade().a(paramBundle, null);
    }
    QfavReport.a(this.q, "User_Forward", 1, 0, paramInt4);
  }
  
  private void c(Bundle paramBundle, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    paramString3 = paramBundle.getString("forward_filepath");
    paramBundle = paramString3;
    if (paramString3 == null) {
      paramBundle = "";
    }
    ThreadManager.post(new ForwardQFavBatchOption.3(this, paramBundle, paramString1, paramInt2, paramString2, paramInt3), 8, null, false);
    QfavReport.a(this.q, "User_Forward", 3, 0, paramInt4);
  }
  
  private String e(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    Object localObject2 = paramBundle.getString("forward_extra");
    int i = paramBundle.getInt("qfavType");
    Object localObject1;
    if ((i != 5) && (i != 8))
    {
      localObject1 = localObject2;
      if (i != 2) {}
    }
    else
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramBundle.getString("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramBundle.getString("forward_filepath");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
    }
    return localObject1;
  }
  
  public String B()
  {
    String str = this.t.getString("uinname");
    if (this.t.getInt("key_forward_ability_type") == g.intValue()) {
      str = HardCodeUtil.a(2131892059);
    }
    return str;
  }
  
  protected void X()
  {
    if (this.a) {
      Y();
    }
  }
  
  public void ab()
  {
    String str2 = this.t.getString("troop_uin");
    String str1 = this.t.getString("uin");
    Object localObject2 = this.t.getString("uinname");
    int m = this.t.getInt("uintype");
    Object localObject3 = new Intent();
    boolean bool = this.r.getBooleanExtra("needStartChatActivity", false);
    ((Intent)localObject3).putExtra("needStartChatActivity", bool);
    Object localObject1 = localObject3;
    if (bool)
    {
      localObject1 = AIOUtils.a((Intent)localObject3, null);
      ((Intent)localObject1).putExtras(this.t);
    }
    this.s.getIntent().putExtra("isFromFavorites", true);
    this.s.setResult(-1, (Intent)localObject1);
    this.s.finish();
    Object localObject4 = new Intent((Intent)localObject1);
    String str3 = this.q.getCurrentAccountUin();
    int j;
    if (this.r.getBooleanExtra("forwardFromAIO", false)) {
      j = 2;
    } else {
      j = 1;
    }
    localObject3 = this.r.getParcelableArrayListExtra("bundleList");
    int n = this.t.getInt("KEY_MSG_FORWARD_ID");
    int i = 0;
    localObject1 = localObject2;
    localObject2 = localObject4;
    while (i < ((ArrayList)localObject3).size())
    {
      Object localObject5 = (Bundle)((ArrayList)localObject3).get(i);
      if (localObject5 != null)
      {
        localObject4 = ThreadManager.getUIHandler();
        int k = i;
        localObject5 = new ForwardQFavBatchOption.1(this, (Bundle)localObject5, str1, str2, m, n, str3, j, (String)localObject1, (Intent)localObject2);
        long l;
        if (k == 0) {
          l = 200L;
        } else {
          l = k * 10;
        }
        ((MqqHandler)localObject4).postDelayed((Runnable)localObject5, l);
      }
      i += 1;
    }
    QfavReport.a(this.q, "User_BatchForwardSendBtnClick", 0, 0, ((ArrayList)localObject3).size());
  }
  
  protected void b(Intent paramIntent)
  {
    if (this.ad) {
      return;
    }
    this.ad = true;
    ArrayList localArrayList = this.r.getParcelableArrayListExtra("bundleList");
    this.s.getIntent().putExtra("isFromFavorites", true);
    Object localObject = this.s.getIntent();
    int j = 0;
    ((Intent)localObject).putExtra("hasJumpAIO", false);
    this.s.setResult(-1, paramIntent);
    this.s.finish();
    int k = this.t.getInt("KEY_MSG_FORWARD_ID");
    int i;
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject = (Bundle)localArrayList.get(0);
      i = ((Bundle)localObject).getInt("qfavType");
      if (i == 5)
      {
        paramIntent.putExtra("dataline_forward_type", 100);
        a((Bundle)localObject, k);
      }
      else if ((i == 8) || (i == 2))
      {
        localObject = e((Bundle)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramIntent.putExtra("dataline_forward_type", 101);
          paramIntent.putExtra("forward_filepath", (String)localObject);
          paramIntent.putExtra("forward_extra", (String)localObject);
          paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendDatalineSingle filePath: ");
          localStringBuilder.append((String)localObject);
          QLog.d("ForwardOption.ForwardQFavBatchOption", 1, localStringBuilder.toString());
          paramIntent.putExtra("dataline_forward_path", (String)localObject);
          AutoSaveUtils.a(true, (String)localObject);
        }
      }
    }
    if ((localArrayList != null) && (localArrayList.size() > 1))
    {
      boolean bool = this.r.getBooleanExtra("needStartChatActivity", false);
      paramIntent.putExtra("needStartChatActivity", bool);
      i = j;
      if (bool)
      {
        AIOUtils.a(paramIntent, null).putExtras(this.t);
        i = j;
      }
      while (i < localArrayList.size())
      {
        localObject = (Bundle)localArrayList.get(i);
        if (localObject != null)
        {
          paramIntent = ThreadManager.getUIHandler();
          localObject = new ForwardQFavBatchOption.2(this, (Bundle)localObject, k);
          long l;
          if (i == 0) {
            l = 200L;
          } else {
            l = i * 10;
          }
          paramIntent.postDelayed((Runnable)localObject, l);
        }
        i += 1;
      }
    }
  }
  
  protected void c()
  {
    super.c();
    Object localObject = this.r.getParcelableArrayListExtra("bundleList");
    int k = 1;
    int i = k;
    if (localObject != null)
    {
      int j = 0;
      i = 1;
      while (j < ((ArrayList)localObject).size())
      {
        if (((Bundle)((ArrayList)localObject).get(j)).getInt("qfavType") != 3) {
          i = 0;
        }
        j += 1;
      }
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = (Bundle)((ArrayList)localObject).get(0);
        j = ((Bundle)localObject).getInt("qfavType");
        if (((j == 5) || (j == 8) || (j == 2)) && (((Bundle)localObject).getBoolean("k_dataline", false))) {
          i = k;
        }
      }
    }
    if (i != 0)
    {
      this.C.add(g);
      this.C.add(l);
      this.r.putExtra("isJumpAIO", false);
    }
  }
  
  protected void d()
  {
    this.A.setMessageWithEmo(this.u, this.z);
    TextView localTextView = this.A.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  public boolean e()
  {
    super.e();
    this.a = this.r.getBooleanExtra("bSinglePicSelected", false);
    if ((this.a) && (TextUtils.isEmpty(this.v))) {
      this.v = this.t.getString("forward_filepath");
    }
    if (this.t.getBoolean("qqfav_extra_skip_confirm", false)) {
      ab();
    }
    Object localObject = this.r.getParcelableArrayListExtra("bundleList");
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      localObject = (Bundle)((ArrayList)localObject).get(0);
      if (localObject == null) {
        return false;
      }
      if (((Bundle)localObject).getInt("qfavType") == 5) {
        this.v = ((Bundle)localObject).getString("forward_thumb");
      }
    }
    return true;
  }
  
  public String n()
  {
    Object localObject;
    if (!this.a)
    {
      localObject = this.r.getParcelableArrayListExtra("bundleList");
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ArrayList)localObject).size());
        localStringBuilder.append(this.s.getString(2131896006));
        this.u = localStringBuilder.toString();
      }
    }
    else
    {
      this.u = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DialogContent:mForwardText=");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("ForwardOption.ForwardQFavBatchOption", 2, ((StringBuilder)localObject).toString());
    }
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption
 * JD-Core Version:    0.7.0.1
 */