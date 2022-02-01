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
  View.OnClickListener a;
  public String as = null;
  public String at = null;
  public String au = null;
  public String av = null;
  long c;
  public int o = 999;
  
  public StructMsgItemButton()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemButton.3(this);
    this.jdField_a_of_type_JavaLangString = "button";
  }
  
  private void b()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals("pay")))
    {
      Object localObject;
      if (TextUtils.isEmpty(this.e)) {
        localObject = this.d;
      } else {
        localObject = this.e;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("appId")) {
            this.as = ((JSONObject)localObject).getString("appId");
          }
          if (((JSONObject)localObject).has("orderId")) {
            this.at = ((JSONObject)localObject).getString("orderId");
          }
          if (((JSONObject)localObject).has("package")) {
            this.av = ((JSONObject)localObject).getString("package");
          }
          if (((JSONObject)localObject).has("expireTime"))
          {
            this.au = ((JSONObject)localObject).getString("expireTime");
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
    paramContext.setBackgroundResource(2130838254);
    if (i > 1) {
      if (j == 0)
      {
        paramContext.setBackgroundResource(2130838247);
      }
      else
      {
        if (j == i - 1)
        {
          paramContext.setBackgroundResource(2130838251);
          i = 2;
          break label91;
        }
        paramContext.setBackgroundResource(2130838249);
        i = 1;
        break label91;
      }
    }
    i = 0;
    label91:
    paramContext.setTag(2131377956, Integer.valueOf(i));
    paramContext.setGravity(17);
    paramContext.setSingleLine();
    paramContext.setEllipsize(null);
    if ((b()) && ((!b()) || (!a())))
    {
      paramContext.setClickable(false);
      paramContext.setOnClickListener(null);
      paramContext.setOnTouchListener(null);
      paramContext.setOnLongClickListener(null);
      return paramContext;
    }
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramContext.setOnLongClickListener(new StructMsgItemButton.1(this));
    paramContext.setOnTouchListener(new StructMsgItemButton.2(this));
    return paramContext;
  }
  
  public String a()
  {
    return "Confirm";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.b = paramObjectInput.readUTF();
    this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
    this.d = paramObjectInput.readUTF();
    this.e = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int > 5)
    {
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
    }
    b();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.b;
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.b;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_c_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_c_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.d == null) {
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
    if (this.jdField_a_of_type_Int > 5)
    {
      if (this.j == null) {
        localObject = "";
      } else {
        localObject = this.j;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.k == null) {
        localObject = "";
      } else {
        localObject = this.k;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.l == null) {
        localObject = str;
      } else {
        localObject = this.l;
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
            } else if (c()) {
              i = -6;
            } else {
              j = 0;
            }
            k = i;
            if (j != 0)
            {
              paramStructMsgForGeneralShare.savePayInfo(paramString.getApplication(), this.at, i);
              k = i;
            }
          }
        }
      }
    }
    b(k);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    paramXmlSerializer.startTag(null, "button");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "actionData", this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    if (!TextUtils.isEmpty(this.j)) {
      paramXmlSerializer.attribute(null, "index", this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      paramXmlSerializer.attribute(null, "index_name", this.k);
    }
    if (!TextUtils.isEmpty(this.l)) {
      paramXmlSerializer.attribute(null, "index_type", this.l);
    }
    paramXmlSerializer.endTag(null, "button");
  }
  
  public boolean a()
  {
    int i = this.o;
    return (i != -6) && (i != -4) && (i != 0) && (i != 23001027);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    super.a(paramStructMsgNode);
    this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
    this.d = paramStructMsgNode.a("actionData");
    this.e = paramStructMsgNode.a("a_actionData");
    this.f = paramStructMsgNode.a("i_actionData");
    this.b = paramStructMsgNode.a("url");
    this.j = paramStructMsgNode.a("index");
    this.k = paramStructMsgNode.a("index_name");
    this.l = paramStructMsgNode.a("index_type");
    b();
    return true;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
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
          a(HardCodeUtil.a(2131714417));
          b("#ff777777");
        }
      }
      else {
        this.o = 0;
      }
      a(HardCodeUtil.a(2131714410));
      b("#ff777777");
    }
    else
    {
      a(HardCodeUtil.a(2131714408));
      b("#ff777777");
    }
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.as)) && (!TextUtils.isEmpty(this.au)) && (!TextUtils.isEmpty(this.at)) && ("pay".equals(this.jdField_c_of_type_JavaLangString));
  }
  
  protected int c()
  {
    return 2131363896;
  }
  
  public boolean c()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    try
    {
      long l2 = Long.parseLong(this.au);
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
  
  public int e()
  {
    return -16734752;
  }
  
  public int f()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton
 * JD-Core Version:    0.7.0.1
 */