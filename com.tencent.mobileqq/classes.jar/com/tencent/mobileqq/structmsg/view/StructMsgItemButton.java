package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemButton
  extends AbsStructMsgTextElement
{
  public String aM = null;
  public String aN = null;
  public String aO = null;
  public String aP = null;
  public int aQ = 999;
  long aR = -1L;
  View.OnClickListener aS = new StructMsgItemButton.3(this);
  
  public StructMsgItemButton()
  {
    this.b = "button";
  }
  
  private void t()
  {
    if ((!TextUtils.isEmpty(this.e)) && (this.e.equals("pay")))
    {
      Object localObject;
      if (TextUtils.isEmpty(this.g)) {
        localObject = this.f;
      } else {
        localObject = this.g;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("appId")) {
            this.aM = ((JSONObject)localObject).getString("appId");
          }
          if (((JSONObject)localObject).has("orderId")) {
            this.aN = ((JSONObject)localObject).getString("orderId");
          }
          if (((JSONObject)localObject).has("package")) {
            this.aP = ((JSONObject)localObject).getString("package");
          }
          if (((JSONObject)localObject).has("expireTime"))
          {
            this.aO = ((JSONObject)localObject).getString("expireTime");
            return;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("read msg=");
            localStringBuilder.append(localException.getMessage());
            QLog.e("StructMsgItemButton", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = paramBundle.getInt("Layout3ButtonCount", 0);
    int j = paramBundle.getInt("Layout3ButtonIndex", -1);
    paramContext = (TextView)super.a(paramContext, paramView, paramBundle);
    paramContext.setBackgroundResource(2130838313);
    if (i > 1) {
      if (j == 0)
      {
        paramContext.setBackgroundResource(2130838306);
      }
      else
      {
        if (j == i - 1)
        {
          paramContext.setBackgroundResource(2130838310);
          i = 2;
          break label91;
        }
        paramContext.setBackgroundResource(2130838308);
        i = 1;
        break label91;
      }
    }
    i = 0;
    label91:
    paramContext.setTag(2131446443, Integer.valueOf(i));
    paramContext.setGravity(17);
    paramContext.setSingleLine();
    paramContext.setEllipsize(null);
    if ((r()) && ((!r()) || (!q())))
    {
      paramContext.setClickable(false);
      paramContext.setOnClickListener(null);
      paramContext.setOnTouchListener(null);
      paramContext.setOnLongClickListener(null);
      return paramContext;
    }
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this.aS);
    paramContext.setOnLongClickListener(new StructMsgItemButton.1(this));
    paramContext.setOnTouchListener(new StructMsgItemButton.2(this));
    return paramContext;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.d = paramObjectInput.readUTF();
    this.e = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
    this.g = paramObjectInput.readUTF();
    this.h = paramObjectInput.readUTF();
    if (this.a > 5)
    {
      this.l = paramObjectInput.readUTF();
      this.m = paramObjectInput.readUTF();
      this.n = paramObjectInput.readUTF();
    }
    t();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.d;
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.d;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.e == null) {
      localObject = "";
    } else {
      localObject = this.e;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.f == null) {
      localObject = "";
    } else {
      localObject = this.f;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.g == null) {
      localObject = "";
    } else {
      localObject = this.g;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.h == null) {
      localObject = "";
    } else {
      localObject = this.h;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.a > 5)
    {
      if (this.l == null) {
        localObject = "";
      } else {
        localObject = this.l;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.m == null) {
        localObject = "";
      } else {
        localObject = this.m;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.n == null) {
        localObject = str;
      } else {
        localObject = this.n;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        i = Integer.valueOf(paramString).intValue();
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      i = 999;
    }
    int k = i;
    if (i != 23001027)
    {
      k = i;
      if (i != 0)
      {
        k = i;
        if (i != -4)
        {
          k = i;
          if (i != -6)
          {
            paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            boolean bool = ((IQWalletConfigService)paramString.getRuntimeService(IQWalletConfigService.class, "")).isPublicAccountSupportPay(paramMessageRecord.frienduin);
            int j = 1;
            if (!bool) {
              i = -4;
            } else if (s()) {
              i = -6;
            } else {
              j = 0;
            }
            k = i;
            if (j != 0)
            {
              paramStructMsgForGeneralShare.savePayInfo(paramString.getApplication(), this.aN, i);
              k = i;
            }
          }
        }
      }
    }
    c(k);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    paramXmlSerializer.startTag(null, "button");
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "action", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.g)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.g);
    }
    if (!TextUtils.isEmpty(this.h)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.h);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "url", this.d);
    }
    if (!TextUtils.isEmpty(this.l)) {
      paramXmlSerializer.attribute(null, "index", this.l);
    }
    if (!TextUtils.isEmpty(this.m)) {
      paramXmlSerializer.attribute(null, "index_name", this.m);
    }
    if (!TextUtils.isEmpty(this.n)) {
      paramXmlSerializer.attribute(null, "index_type", this.n);
    }
    paramXmlSerializer.endTag(null, "button");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    super.a(paramStructMsgNode);
    this.e = paramStructMsgNode.a("action");
    this.f = paramStructMsgNode.a("actionData");
    this.g = paramStructMsgNode.a("a_actionData");
    this.h = paramStructMsgNode.a("i_actionData");
    this.d = paramStructMsgNode.a("url");
    this.l = paramStructMsgNode.a("index");
    this.m = paramStructMsgNode.a("index_name");
    this.n = paramStructMsgNode.a("index_type");
    t();
    return true;
  }
  
  public String b()
  {
    return "Confirm";
  }
  
  public void c(int paramInt)
  {
    this.aQ = paramInt;
    if (paramInt != -6)
    {
      if (paramInt != 23001027)
      {
        if (paramInt != -4)
        {
          if ((paramInt == -3) || (paramInt == -2) || (paramInt == -1)) {
            return;
          }
          if (paramInt == 0) {}
        }
        else
        {
          b(HardCodeUtil.a(2131911928));
          c("#ff777777");
        }
      }
      else {
        this.aQ = 0;
      }
      b(HardCodeUtil.a(2131911921));
      c("#ff777777");
    }
    else
    {
      b(HardCodeUtil.a(2131911919));
      c("#ff777777");
    }
  }
  
  protected int f()
  {
    return 2131429846;
  }
  
  public int i()
  {
    return -16734752;
  }
  
  public int j()
  {
    return 32;
  }
  
  public boolean q()
  {
    int i = this.aQ;
    return (i != -6) && (i != -4) && (i != 0) && (i != 23001027);
  }
  
  public boolean r()
  {
    return (!TextUtils.isEmpty(this.aM)) && (!TextUtils.isEmpty(this.aO)) && (!TextUtils.isEmpty(this.aN)) && ("pay".equals(this.e));
  }
  
  public boolean s()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    try
    {
      long l2 = Long.parseLong(this.aO);
      if (l2 > l1) {
        return false;
      }
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton
 * JD-Core Version:    0.7.0.1
 */