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
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private String h;
  private String i;
  private String j;
  
  /* Error */
  public ForwardH5HongBaoOption(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 20	com/tencent/mobileqq/forward/ForwardBaseOption:<init>	(Landroid/content/Intent;)V
    //   5: aload_0
    //   6: new 22	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 25	java/util/ArrayList:<init>	()V
    //   13: putfield 27	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield 29	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:i	Ljava/lang/String;
    //   21: aload_0
    //   22: new 31	org/json/JSONObject
    //   25: dup
    //   26: aload_1
    //   27: ldc 33
    //   29: invokevirtual 39	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokespecial 42	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: putfield 44	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   38: aload_0
    //   39: getfield 44	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   42: ldc 46
    //   44: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +90 -> 142
    //   55: aload_0
    //   56: getfield 58	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: ifnull +83 -> 142
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 58	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   70: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +69 -> 142
    //   76: new 35	android/content/Intent
    //   79: dup
    //   80: invokespecial 71	android/content/Intent:<init>	()V
    //   83: astore_1
    //   84: new 31	org/json/JSONObject
    //   87: dup
    //   88: invokespecial 72	org/json/JSONObject:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: ldc 74
    //   97: ldc 76
    //   99: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload 4
    //   105: ldc 82
    //   107: ldc 84
    //   109: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_1
    //   114: ldc 86
    //   116: aload 4
    //   118: invokevirtual 89	org/json/JSONObject:toString	()Ljava/lang/String;
    //   121: invokevirtual 93	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   124: pop
    //   125: aload_0
    //   126: getfield 96	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   129: iconst_m1
    //   130: aload_1
    //   131: invokevirtual 102	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   134: aload_0
    //   135: getfield 96	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   138: invokevirtual 105	android/app/Activity:finish	()V
    //   141: return
    //   142: ldc 107
    //   144: astore_1
    //   145: aload_0
    //   146: getfield 44	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   149: ldc 109
    //   151: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 5
    //   156: aload_0
    //   157: getfield 44	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   160: ldc 111
    //   162: invokevirtual 115	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   165: astore 4
    //   167: aload 5
    //   169: ldc 117
    //   171: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq +77 -> 251
    //   177: aload 4
    //   179: ifnull +22 -> 201
    //   182: aload 4
    //   184: ldc 119
    //   186: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore_1
    //   190: aload_0
    //   191: aload 4
    //   193: ldc 121
    //   195: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: putfield 29	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:i	Ljava/lang/String;
    //   201: aload_1
    //   202: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifne +95 -> 300
    //   208: aload_1
    //   209: ldc 123
    //   211: invokevirtual 127	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   214: astore_1
    //   215: iconst_0
    //   216: istore_2
    //   217: aload_1
    //   218: arraylength
    //   219: istore_3
    //   220: iload_2
    //   221: iload_3
    //   222: if_icmpge +78 -> 300
    //   225: aload_0
    //   226: getfield 27	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   229: aload_1
    //   230: iload_2
    //   231: aaload
    //   232: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   235: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: invokeinterface 142 2 0
    //   243: pop
    //   244: iload_2
    //   245: iconst_1
    //   246: iadd
    //   247: istore_2
    //   248: goto -31 -> 217
    //   251: aload_0
    //   252: getfield 44	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   255: ldc 144
    //   257: invokevirtual 115	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   260: astore 4
    //   262: aload 4
    //   264: ifnull -63 -> 201
    //   267: aload 4
    //   269: ldc 119
    //   271: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore_1
    //   275: aload_0
    //   276: aload 4
    //   278: ldc 121
    //   280: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   283: putfield 29	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:i	Ljava/lang/String;
    //   286: goto -85 -> 201
    //   289: astore_1
    //   290: aload_1
    //   291: invokevirtual 147	org/json/JSONException:printStackTrace	()V
    //   294: return
    //   295: astore 4
    //   297: goto -53 -> 244
    //   300: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	ForwardH5HongBaoOption
    //   0	301	1	paramIntent	Intent
    //   216	32	2	k	int
    //   219	4	3	m	int
    //   91	186	4	localJSONObject	JSONObject
    //   295	1	4	localNumberFormatException	java.lang.NumberFormatException
    //   154	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   21	141	289	org/json/JSONException
    //   145	177	289	org/json/JSONException
    //   182	201	289	org/json/JSONException
    //   201	215	289	org/json/JSONException
    //   217	220	289	org/json/JSONException
    //   225	244	289	org/json/JSONException
    //   251	262	289	org/json/JSONException
    //   267	286	289	org/json/JSONException
    //   225	244	295	java/lang/NumberFormatException
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser != null)
      {
        if ((this.jdField_a_of_type_JavaUtilList.contains(b)) && (localRecentUser.getType() == 0)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.jdField_a_of_type_JavaUtilList.contains(c)) && (localRecentUser.getType() == 1)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.jdField_a_of_type_JavaUtilList.contains(d)) && (localRecentUser.getType() == 3000)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
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
      if (localJSONObject2.optInt("resultCode", -1) != 0)
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
        return;
      }
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("data");
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("chat_type", this.h);
      ((JSONObject)localObject).put("uin", this.j);
      localJSONObject2.put("data", localObject);
      paramIntent.putExtra("result", localJSONObject2.toString());
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
    if (TextUtils.isEmpty(this.i)) {
      return super.b();
    }
    return this.i;
  }
  
  protected void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      int k = ((Integer)localIterator.next()).intValue();
      if (p()) {
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(k));
      }
    }
  }
  
  protected boolean c()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694457, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
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
          this.j = str;
          ((JSONObject)localObject).put("recv_uin", str);
          this.jdField_a_of_type_OrgJsonJSONObject.put("appid", String.valueOf(AppSetting.a()));
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
      this.h = "group";
      this.jdField_a_of_type_OrgJsonJSONObject.put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      this.jdField_a_of_type_OrgJsonJSONObject.put("recv_type", 3);
      continue;
      this.h = "discuss";
      this.jdField_a_of_type_OrgJsonJSONObject.put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      this.jdField_a_of_type_OrgJsonJSONObject.put("recv_type", 2);
      continue;
      this.h = "c2c";
      this.jdField_a_of_type_OrgJsonJSONObject.put("recv_type", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardH5HongBaoOption
 * JD-Core Version:    0.7.0.1
 */