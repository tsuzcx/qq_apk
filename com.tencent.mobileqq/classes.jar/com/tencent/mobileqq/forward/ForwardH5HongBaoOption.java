package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardH5HongBaoOption
  extends ForwardBaseOption
{
  private List jdField_a_of_type_JavaUtilList;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private String f;
  private String g;
  private String h;
  
  /* Error */
  public ForwardH5HongBaoOption(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 19	com/tencent/mobileqq/forward/ForwardBaseOption:<init>	(Landroid/content/Intent;)V
    //   5: aload_0
    //   6: new 21	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 24	java/util/ArrayList:<init>	()V
    //   13: putfield 26	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: aload_0
    //   17: new 28	org/json/JSONObject
    //   20: dup
    //   21: aload_1
    //   22: ldc 30
    //   24: invokevirtual 36	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokespecial 39	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: putfield 41	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   33: aload_0
    //   34: getfield 41	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   37: ldc 43
    //   39: invokevirtual 46	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +90 -> 137
    //   50: aload_0
    //   51: getfield 55	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: ifnull +83 -> 137
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 55	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   62: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   65: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifne +69 -> 137
    //   71: new 32	android/content/Intent
    //   74: dup
    //   75: invokespecial 68	android/content/Intent:<init>	()V
    //   78: astore_1
    //   79: new 28	org/json/JSONObject
    //   82: dup
    //   83: invokespecial 69	org/json/JSONObject:<init>	()V
    //   86: astore 4
    //   88: aload 4
    //   90: ldc 71
    //   92: ldc 73
    //   94: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload 4
    //   100: ldc 79
    //   102: ldc 81
    //   104: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload_1
    //   109: ldc 83
    //   111: aload 4
    //   113: invokevirtual 86	org/json/JSONObject:toString	()Ljava/lang/String;
    //   116: invokevirtual 90	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   119: pop
    //   120: aload_0
    //   121: getfield 93	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   124: iconst_m1
    //   125: aload_1
    //   126: invokevirtual 99	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   129: aload_0
    //   130: getfield 93	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   133: invokevirtual 102	android/app/Activity:finish	()V
    //   136: return
    //   137: aload_0
    //   138: getfield 41	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   141: ldc 104
    //   143: invokevirtual 108	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   146: astore_1
    //   147: aload_1
    //   148: ldc 110
    //   150: invokevirtual 46	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifne +50 -> 210
    //   163: aload 4
    //   165: ldc 112
    //   167: invokevirtual 116	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   170: astore 4
    //   172: iconst_0
    //   173: istore_2
    //   174: aload 4
    //   176: arraylength
    //   177: istore_3
    //   178: iload_2
    //   179: iload_3
    //   180: if_icmpge +30 -> 210
    //   183: aload_0
    //   184: getfield 26	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   187: aload 4
    //   189: iload_2
    //   190: aaload
    //   191: invokestatic 122	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   194: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokeinterface 131 2 0
    //   202: pop
    //   203: iload_2
    //   204: iconst_1
    //   205: iadd
    //   206: istore_2
    //   207: goto -33 -> 174
    //   210: aload_0
    //   211: aload_1
    //   212: ldc 133
    //   214: invokevirtual 46	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   217: putfield 135	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:g	Ljava/lang/String;
    //   220: return
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 138	org/json/JSONException:printStackTrace	()V
    //   226: return
    //   227: astore 5
    //   229: goto -26 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	ForwardH5HongBaoOption
    //   0	232	1	paramIntent	Intent
    //   173	34	2	i	int
    //   177	4	3	j	int
    //   86	102	4	localObject	Object
    //   227	1	5	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   16	136	221	org/json/JSONException
    //   137	172	221	org/json/JSONException
    //   174	178	221	org/json/JSONException
    //   183	203	221	org/json/JSONException
    //   210	220	221	org/json/JSONException
    //   183	203	227	java/lang/NumberFormatException
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser != null)
      {
        if ((this.jdField_a_of_type_JavaUtilList.contains(b)) && (localRecentUser.type == 0)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.jdField_a_of_type_JavaUtilList.contains(c)) && (localRecentUser.type == 1)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.jdField_a_of_type_JavaUtilList.contains(d)) && (localRecentUser.type == 3000)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (h()) {
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i));
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("result");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardH5HongBaoOption", 2, "onActivityResult = " + (String)localObject);
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject((String)localObject);
      if (localJSONObject2.optInt("resultCode", -1) == 0)
      {
        JSONObject localJSONObject1 = localJSONObject2.optJSONObject("data");
        localObject = localJSONObject1;
        if (localJSONObject1 == null) {
          localObject = new JSONObject();
        }
        ((JSONObject)localObject).put("chat_type", this.f);
        ((JSONObject)localObject).put("uin", this.h);
        localJSONObject2.put("data", localObject);
        paramIntent.putExtra("result", localJSONObject2.toString());
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    return false;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.g)) {
      return super.b();
    }
    return this.g;
  }
  
  protected boolean c()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131433196, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      return true;
    }
    for (;;)
    {
      try
      {
        switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"))
        {
        case 1: 
          localObject = this.jdField_a_of_type_OrgJsonJSONObject;
          String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
          this.h = str;
          ((JSONObject)localObject).put("recv_uin", str);
          this.jdField_a_of_type_OrgJsonJSONObject.put("appid", String.valueOf(AppSetting.a));
          this.jdField_a_of_type_OrgJsonJSONObject.put("from_memo", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
          this.jdField_a_of_type_OrgJsonJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("ForwardOption.ForwardH5HongBaoOption", 4, "extra_data = " + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendHbActivity.class);
      ((Intent)localObject).putExtra("come_from", 2);
      ((Intent)localObject).putExtra("extra_data", this.jdField_a_of_type_OrgJsonJSONObject.toString());
      ((Intent)localObject).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=0", 0, null));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 20002);
      return true;
      this.f = "group";
      this.jdField_a_of_type_OrgJsonJSONObject.put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      this.jdField_a_of_type_OrgJsonJSONObject.put("recv_type", 3);
      continue;
      this.f = "discuss";
      this.jdField_a_of_type_OrgJsonJSONObject.put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      this.jdField_a_of_type_OrgJsonJSONObject.put("recv_type", 2);
      continue;
      this.f = "c2c";
      this.jdField_a_of_type_OrgJsonJSONObject.put("recv_type", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardH5HongBaoOption
 * JD-Core Version:    0.7.0.1
 */