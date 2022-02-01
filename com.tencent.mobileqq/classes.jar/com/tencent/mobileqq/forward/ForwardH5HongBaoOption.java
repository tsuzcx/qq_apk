package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
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
  private JSONObject a;
  private List<Integer> ad;
  private String ae;
  private String af;
  private String ag;
  
  /* Error */
  public ForwardH5HongBaoOption(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 21	com/tencent/mobileqq/forward/ForwardBaseOption:<init>	(Landroid/content/Intent;)V
    //   5: aload_0
    //   6: new 23	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 26	java/util/ArrayList:<init>	()V
    //   13: putfield 28	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:ad	Ljava/util/List;
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield 30	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:af	Ljava/lang/String;
    //   21: aload_0
    //   22: new 32	org/json/JSONObject
    //   25: dup
    //   26: aload_1
    //   27: ldc 34
    //   29: invokevirtual 40	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: putfield 45	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:a	Lorg/json/JSONObject;
    //   38: aload_0
    //   39: getfield 45	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:a	Lorg/json/JSONObject;
    //   42: ldc 47
    //   44: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +90 -> 142
    //   55: aload_0
    //   56: getfield 60	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:q	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: ifnull +83 -> 142
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 60	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:q	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 66	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   70: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +69 -> 142
    //   76: new 36	android/content/Intent
    //   79: dup
    //   80: invokespecial 73	android/content/Intent:<init>	()V
    //   83: astore_1
    //   84: new 32	org/json/JSONObject
    //   87: dup
    //   88: invokespecial 74	org/json/JSONObject:<init>	()V
    //   91: astore 5
    //   93: aload 5
    //   95: ldc 76
    //   97: ldc 78
    //   99: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload 5
    //   105: ldc 84
    //   107: ldc 86
    //   109: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_1
    //   114: ldc 88
    //   116: aload 5
    //   118: invokevirtual 91	org/json/JSONObject:toString	()Ljava/lang/String;
    //   121: invokevirtual 95	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   124: pop
    //   125: aload_0
    //   126: getfield 99	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:s	Landroid/app/Activity;
    //   129: iconst_m1
    //   130: aload_1
    //   131: invokevirtual 105	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   134: aload_0
    //   135: getfield 99	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:s	Landroid/app/Activity;
    //   138: invokevirtual 108	android/app/Activity:finish	()V
    //   141: return
    //   142: ldc 110
    //   144: astore_1
    //   145: aload_0
    //   146: getfield 45	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:a	Lorg/json/JSONObject;
    //   149: ldc 112
    //   151: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 6
    //   156: aload_0
    //   157: getfield 45	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:a	Lorg/json/JSONObject;
    //   160: ldc 114
    //   162: invokevirtual 118	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   165: astore 5
    //   167: aload 6
    //   169: ldc 120
    //   171: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: istore 4
    //   176: iload 4
    //   178: ifeq +30 -> 208
    //   181: aload 5
    //   183: ifnull +60 -> 243
    //   186: aload 5
    //   188: ldc 122
    //   190: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   193: astore_1
    //   194: aload_0
    //   195: aload 5
    //   197: ldc 124
    //   199: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: putfield 30	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:af	Ljava/lang/String;
    //   205: goto +38 -> 243
    //   208: aload_0
    //   209: getfield 45	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:a	Lorg/json/JSONObject;
    //   212: ldc 126
    //   214: invokevirtual 118	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   217: astore 5
    //   219: aload 5
    //   221: ifnull +22 -> 243
    //   224: aload 5
    //   226: ldc 122
    //   228: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: astore_1
    //   232: aload_0
    //   233: aload 5
    //   235: ldc 124
    //   237: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   240: putfield 30	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:af	Ljava/lang/String;
    //   243: aload_1
    //   244: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +51 -> 298
    //   250: aload_1
    //   251: ldc 128
    //   253: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   256: astore_1
    //   257: iconst_0
    //   258: istore_2
    //   259: aload_1
    //   260: arraylength
    //   261: istore_3
    //   262: iload_2
    //   263: iload_3
    //   264: if_icmpge +34 -> 298
    //   267: aload_0
    //   268: getfield 28	com/tencent/mobileqq/forward/ForwardH5HongBaoOption:ad	Ljava/util/List;
    //   271: aload_1
    //   272: iload_2
    //   273: aaload
    //   274: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   277: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: invokeinterface 147 2 0
    //   285: pop
    //   286: iload_2
    //   287: iconst_1
    //   288: iadd
    //   289: istore_2
    //   290: goto -31 -> 259
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 150	org/json/JSONException:printStackTrace	()V
    //   298: return
    //   299: astore 5
    //   301: goto -15 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	ForwardH5HongBaoOption
    //   0	304	1	paramIntent	Intent
    //   258	32	2	i	int
    //   261	4	3	j	int
    //   174	3	4	bool	boolean
    //   91	143	5	localJSONObject	JSONObject
    //   299	1	5	localNumberFormatException	java.lang.NumberFormatException
    //   154	14	6	str	String
    // Exception table:
    //   from	to	target	type
    //   21	141	293	org/json/JSONException
    //   145	176	293	org/json/JSONException
    //   186	205	293	org/json/JSONException
    //   208	219	293	org/json/JSONException
    //   224	243	293	org/json/JSONException
    //   243	257	293	org/json/JSONException
    //   259	262	293	org/json/JSONException
    //   267	286	293	org/json/JSONException
    //   267	286	299	java/lang/NumberFormatException
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
        if ((this.ad.contains(c)) && (localRecentUser.getType() == 0)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.ad.contains(d)) && (localRecentUser.getType() == 1)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.ad.contains(e)) && (localRecentUser.getType() == 3000)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("result");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onActivityResult = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ForwardOption.ForwardH5HongBaoOption", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject1);
      if (localJSONObject.optInt("resultCode", -1) != 0)
      {
        this.s.setResult(-1, paramIntent);
        return;
      }
      localObject2 = localJSONObject.optJSONObject("data");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      ((JSONObject)localObject1).put("chat_type", this.ae);
      ((JSONObject)localObject1).put("uin", this.ag);
      localJSONObject.put("data", localObject1);
      paramIntent.putExtra("result", localJSONObject.toString());
      this.s.setResult(-1, paramIntent);
      this.s.finish();
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
  
  protected void c()
  {
    Iterator localIterator = this.ad.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (ag()) {
        this.C.add(Integer.valueOf(i));
      }
    }
  }
  
  protected boolean f()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
      return true;
    }
    try
    {
      int i = this.t.getInt("uintype");
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 3000)
          {
            this.ae = "discuss";
            this.a.put("group_id", this.t.getString("uin"));
            this.a.put("recv_type", 2);
          }
        }
        else
        {
          this.ae = "group";
          this.a.put("group_id", this.t.getString("uin"));
          this.a.put("recv_type", 3);
        }
      }
      else
      {
        this.ae = "c2c";
        this.a.put("recv_type", 1);
      }
      localObject = this.a;
      String str = this.t.getString("uin");
      this.ag = str;
      ((JSONObject)localObject).put("recv_uin", str);
      this.a.put("appid", String.valueOf(AppSetting.d()));
      this.a.put("from_memo", this.q.getCurrentNickname());
      this.a.put("userId", this.q.getCurrentAccountUin());
    }
    catch (Exception localException)
    {
      Object localObject;
      label252:
      break label252;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("extra_data = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ForwardOption.ForwardH5HongBaoOption", 4, ((StringBuilder)localObject).toString());
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("come_from", 2);
    ((Intent)localObject).putExtra("extra_data", this.a.toString());
    ((Intent)localObject).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=0", 0, null));
    RouteUtils.a(this.s, (Intent)localObject, "/qwallet/redpacket/sendhb", 20002);
    return true;
  }
  
  public String u()
  {
    if (TextUtils.isEmpty(this.af)) {
      return super.u();
    }
    return this.af;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardH5HongBaoOption
 * JD-Core Version:    0.7.0.1
 */