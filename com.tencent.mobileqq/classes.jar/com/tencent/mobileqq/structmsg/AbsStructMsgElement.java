package com.tencent.mobileqq.structmsg;

import ahtf;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgElement
  implements View.OnClickListener, StructMsgConstants
{
  public int a;
  public long a;
  public AbsStructMsg a;
  public String a;
  public WeakReference a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r = "";
  public String s;
  public String t;
  
  public AbsStructMsgElement()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_d_of_type_Int = -1;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (!paramString.startsWith("https")) {
        str = "http://" + paramString;
      }
    }
    try
    {
      paramString = new URL(str).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return "";
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public abstract View a(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int & paramInt) == 0) {
      this.jdField_b_of_type_Int |= paramInt;
    }
  }
  
  public void a(AbsShareMsg paramAbsShareMsg) {}
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_a_of_type_Int);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_Int & paramInt) == paramInt;
  }
  
  public abstract boolean a(StructMsgNode paramStructMsgNode);
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if (!getClass().isInstance(localObject1)) {
        continue;
      }
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localObject1;
      Object localObject3 = paramView.getContext();
      if ((!SplashActivity.class.isInstance(localObject3)) && (!ChatActivity.class.isInstance(localObject3))) {
        continue;
      }
      localObject1 = (FragmentActivity)localObject3;
      if (((FragmentActivity)localObject1).getChatFragment() == null) {
        continue;
      }
      QQAppInterface localQQAppInterface = ((FragmentActivity)localObject1).getChatFragment().a();
      if ((localAbsStructMsgElement.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(localAbsStructMsgElement.s))) {
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localAbsStructMsgElement.t, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.s), 0, "", "", Long.toString(localAbsStructMsgElement.jdField_a_of_type_Long), "");
      }
      ReadinjoySPEventReport.a().a(localAbsStructMsgElement.t, localAbsStructMsgElement);
      if (localAbsStructMsgElement.jdField_a_of_type_Long > 0L) {
        ThreadManager.getSubThreadHandler().postDelayed(new ahtf(this, localAbsStructMsgElement, localQQAppInterface), 0L);
      }
      try
      {
        localObject1 = AIOUtils.a(paramView);
        if ((localObject1 == null) || (localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!"1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
      }
      catch (ClassCastException localClassCastException)
      {
        try
        {
          Object localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("puin", ((ChatMessage)localObject1).frienduin);
          ((JSONObject)localObject4).put("type", localAbsStructMsgElement.l);
          ((JSONObject)localObject4).put("index", localAbsStructMsgElement.j);
          ((JSONObject)localObject4).put("name", localAbsStructMsgElement.k);
          ((JSONObject)localObject4).put("net", String.valueOf(HttpUtil.a()));
          ((JSONObject)localObject4).put("mobile_imei", DeviceInfoUtil.a());
          ((JSONObject)localObject4).put("obj", "");
          ((JSONObject)localObject4).put("gdt_cli_data", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick"));
          ((JSONObject)localObject4).put("view_id", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_view_id"));
          PAReportUtil.a(localQQAppInterface, ((ChatMessage)localObject1).selfuin, ((JSONObject)localObject4).toString(), "" + localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
          paramView = new StructMsgClickHandler(localQQAppInterface, paramView, (MessageRecord)localObject1);
          localObject4 = ((FragmentActivity)localObject3).getChatFragment();
          Object localObject5;
          if (localObject4 != null)
          {
            localObject4 = ((ChatFragment)localObject4).a();
            if ((localObject4 instanceof PublicAccountChatPie))
            {
              localObject5 = (PublicAccountChatPie)localObject4;
              ((PublicAccountChatPie)localObject5).t += 1;
              if ("web".equals(localAbsStructMsgElement.c))
              {
                localObject4 = (PublicAccountChatPie)localObject4;
                ((PublicAccountChatPie)localObject4).v += 1;
              }
            }
          }
          if (localObject1 != null) {
            localAbsStructMsgElement.jdField_b_of_type_JavaLangString = EcShopAssistantManager.a(((ChatMessage)localObject1).frienduin, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, localQQAppInterface);
          }
          bool = ((EcShopAssistantManager)localQQAppInterface.getManager(87)).a(this, (Activity)localObject3);
          if (!bool)
          {
            if (localAbsStructMsgElement.jdField_a_of_type_Long > 0L)
            {
              bool = paramView.a(localAbsStructMsgElement.c, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, localAbsStructMsgElement.jdField_d_of_type_JavaLangString, localAbsStructMsgElement.e, localAbsStructMsgElement.jdField_a_of_type_Long);
              if ((localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null)) {}
            }
            try
            {
              if (localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 92)
              {
                i1 = Integer.parseInt(localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                paramView = localAbsStructMsgElement.jdField_b_of_type_JavaLangString;
                if (QLog.isColorLevel()) {
                  QLog.d("StructMsg", 2, String.format("click qidian bulk message, taskId: %d, actionUrl: %s", new Object[] { Integer.valueOf(i1), paramView }));
                }
                if (i1 != 0)
                {
                  localObject3 = new JSONObject();
                  ((JSONObject)localObject3).put("action", "click");
                  ((JSONObject)localObject3).put("fromUin", localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin);
                  ((JSONObject)localObject3).put("toUin", localQQAppInterface.getCurrentAccountUin());
                  ((JSONObject)localObject3).put("taskID", localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                  ((JSONObject)localObject3).put("clickURL", paramView);
                  ((JSONObject)localObject3).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                  ((QidianHandler)localQQAppInterface.a(85)).a(((JSONObject)localObject3).toString(), localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "", 10009, 0);
                }
              }
            }
            catch (Exception paramView)
            {
              int i1;
              label824:
              int i2;
              break label824;
            }
            if (((localObject1 != null) && (((ChatMessage)localObject1).istroop == 1024)) || (((ChatMessage)localObject1).istroop == 1025))
            {
              localObject4 = (QidianManager)localQQAppInterface.getManager(164);
              localObject3 = "";
              paramView = (View)localObject3;
              if ((localAbsStructMsgElement instanceof StructMsgGroupItemElement))
              {
                localObject5 = ((StructMsgGroupItemElement)localAbsStructMsgElement).a;
                paramView = (View)localObject3;
                if (localObject5 != null)
                {
                  localObject5 = ((List)localObject5).iterator();
                  do
                  {
                    paramView = (View)localObject3;
                    if (!((Iterator)localObject5).hasNext()) {
                      break;
                    }
                    paramView = (AbsStructMsgElement)((Iterator)localObject5).next();
                  } while (!(paramView instanceof StructMsgItemSummary));
                  paramView = ((StructMsgItemSummary)paramView).A;
                }
              }
              ((QidianManager)localObject4).a(localAbsStructMsgElement.c, localAbsStructMsgElement.e, localAbsStructMsgElement.jdField_d_of_type_JavaLangString, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, 2, paramView);
            }
            i1 = 0;
            if (bool) {
              i1 = 1;
            }
            i2 = -1;
            try
            {
              int i3 = Integer.parseInt(localAbsStructMsgElement.s);
              i2 = i3;
            }
            catch (Exception paramView)
            {
              label996:
              break label996;
            }
            ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localAbsStructMsgElement.t, "0X80055C7", "0X80055C7", i2, i1, "" + localAbsStructMsgElement.jdField_a_of_type_Long, localAbsStructMsgElement.r, "", localAbsStructMsgElement.jdField_b_of_type_JavaLangString);
            paramView = new StringBuilder().append("MSGID=").append(Long.toString(localAbsStructMsgElement.jdField_a_of_type_Long)).append(";TEPLATEID=").append(localAbsStructMsgElement.r).append(";ARTICALID=").append("").append(";REFERRER=").append(a(localAbsStructMsgElement.jdField_b_of_type_JavaLangString));
            ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localAbsStructMsgElement.t, "0X8005D49", "0X8005D49", i2, i1, paramView.toString(), "", "", "");
            if (localObject1 == null) {
              continue;
            }
            paramView = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
            if (!TextUtils.isEmpty(paramView)) {
              localObject3 = new JSONObject();
            }
            try
            {
              if (TextUtils.isEmpty(localAbsStructMsgElement.t)) {
                break label1400;
              }
              ((JSONObject)localObject3).put("puin", localAbsStructMsgElement.t);
              ((JSONObject)localObject3).put("index", Long.toString(i2));
              ((JSONObject)localObject3).put("gdt_cli_data", paramView);
            }
            catch (JSONException paramView)
            {
              for (;;)
              {
                Object localObject2;
                paramView.printStackTrace();
                continue;
                if ((((String)localObject3).equals("1")) || (!localJSONException.equals("1"))) {}
              }
            }
            new ArrayList().add(String.valueOf(localAbsStructMsgElement.jdField_a_of_type_Long));
            paramView = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_singleAd");
            localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_mulAd");
            localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_followAd");
            if (paramView.equals("1"))
            {
              paramView = (EcShopAssistantManager)localQQAppInterface.getManager(87);
              localObject3 = (EcshopReportHandler)localQQAppInterface.a(88);
              if ((localObject1 == null) || (paramView == null) || (localObject3 == null) || (!paramView.a(((ChatMessage)localObject1).senderuin))) {
                continue;
              }
              ((EcshopReportHandler)localObject3).a(false, (MessageRecord)localObject1, i2, localAbsStructMsgElement.jdField_b_of_type_JavaLangString);
              return;
              localClassCastException = localClassCastException;
              localObject2 = null;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            boolean bool = paramView.a(localAbsStructMsgElement.c, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, localAbsStructMsgElement.jdField_d_of_type_JavaLangString, localAbsStructMsgElement.e);
            continue;
            label1400:
            ((JSONObject)localObject3).put("puin", localObject2.frienduin);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement
 * JD-Core Version:    0.7.0.1
 */