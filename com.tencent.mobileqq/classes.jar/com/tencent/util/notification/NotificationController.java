package com.tencent.util.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class NotificationController
  extends BusinessHandler
  implements Handler.Callback
{
  private HashMap<String, NotificationController.LimitEntry> a;
  private boolean b = false;
  private Handler c;
  private boolean d = false;
  private BaseQQAppInterface e;
  
  public NotificationController(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
    this.e = paramBaseQQAppInterface;
    this.c = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public static Long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 1);
    return Long.valueOf(new Timestamp(localCalendar.getTimeInMillis()).getTime());
  }
  
  private HashMap<String, NotificationController.LimitEntry> b()
  {
    try
    {
      if (this.d) {
        break label484;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NCtr", 2, "[init]");
      }
      localObject1 = BaseApplication.getContext().getSharedPreferences("config_prefile", 0);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("config_should_limit_");
      ((StringBuilder)localObject3).append(this.e.getAccount());
      this.b = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject3).toString(), false);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("extra_limit_uins_");
      ((StringBuilder)localObject3).append(this.e.getAccount());
      localObject3 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), "");
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("LimitUins:[");
        ((StringBuilder)localObject4).append(((String)localObject3).toString());
        ((StringBuilder)localObject4).append("]");
        QLog.d("NCtr", 2, ((StringBuilder)localObject4).toString());
      }
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label479;
      }
      localObject3 = ((String)localObject3).split(",");
      localObject4 = new HashMap();
      j = localObject3.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        int j;
        int i;
        Object localObject5;
        Object localObject6;
        for (;;)
        {
          label479:
          label484:
          throw localObject2;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localObject5 = localObject3[i];
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("extra_limit_entry_");
      ((StringBuilder)localObject6).append(this.e.getAccount());
      ((StringBuilder)localObject6).append("_");
      ((StringBuilder)localObject6).append((String)localObject5);
      localObject6 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject6).toString(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject6 = ((String)localObject6).split(",");
        localObject5 = new NotificationController.LimitEntry(this, localObject6[0], Integer.valueOf(localObject6[1]).intValue(), Integer.valueOf(localObject6[2]).intValue(), Long.valueOf(localObject6[3]).longValue(), Integer.valueOf(localObject6[4]).intValue());
        ((HashMap)localObject4).put(localObject6[0], localObject5);
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("LimitEntry:[");
          ((StringBuilder)localObject6).append(((NotificationController.LimitEntry)localObject5).toString());
          ((StringBuilder)localObject6).append("]");
          QLog.d("NCtr", 2, ((StringBuilder)localObject6).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("LimitEntry is null [");
        ((StringBuilder)localObject6).append((String)localObject5);
        ((StringBuilder)localObject6).append("]");
        QLog.d("NCtr", 2, ((StringBuilder)localObject6).toString());
      }
    }
    else
    {
      this.a = ((HashMap)localObject4);
      this.d = true;
      localObject1 = this.a;
      return localObject1;
    }
  }
  
  private void c(Context paramContext, String paramString)
  {
    Object localObject = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((HashMap)localObject).containsKey(paramString))
      {
        localObject = (NotificationController.LimitEntry)this.a.get(paramString);
        paramContext = paramContext.getSharedPreferences("config_prefile", 0).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("extra_limit_entry_");
        localStringBuilder.append(this.e.getAccount());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        paramContext.putString(localStringBuilder.toString(), ((NotificationController.LimitEntry)localObject).toString());
        paramContext.apply();
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[updateLimitEntrySP]");
      paramContext.append(paramString);
      paramContext.append(" ");
      paramContext.append(bool1);
      QLog.d("NCtr", 2, paramContext.toString());
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("config_prefile", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_appid_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = BaseApplication.getContext();
    int i = 0;
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("config_prefile", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("extra_limit_uins_");
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    localObject1 = ((SharedPreferences)localObject1).edit();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("config_version_");
    localStringBuilder1.append(paramString);
    ((SharedPreferences.Editor)localObject1).remove(localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("config_appid_");
    localStringBuilder1.append(paramString);
    ((SharedPreferences.Editor)localObject1).remove(localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("config_should_limit_");
    localStringBuilder1.append(paramString);
    ((SharedPreferences.Editor)localObject1).remove(localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("extra_limit_uins__");
    localStringBuilder1.append(paramString);
    ((SharedPreferences.Editor)localObject1).remove(localStringBuilder1.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split(",");
      int j = localObject2.length;
      while (i < j)
      {
        localStringBuilder1 = localObject2[i];
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("extra_limit_entry_");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("_");
        localStringBuilder2.append(localStringBuilder1);
        ((SharedPreferences.Editor)localObject1).remove(localStringBuilder2.toString());
        i += 1;
      }
    }
    ((SharedPreferences.Editor)localObject1).apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramString;
    localMessage.what = 0;
    this.c.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label584;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldNotify uin ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" type ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("NCtr", 2, ((StringBuilder)localObject).toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        long l1;
        StringBuilder localStringBuilder;
        long l2;
        label338:
        boolean bool1;
        boolean bool2;
        for (;;)
        {
          throw paramString;
        }
        label584:
        if ((paramInt != 7200) && (paramInt != 1008) && (paramInt != 7220))
        {
          bool2 = true;
          continue;
          label614:
          bool1 = true;
          paramInt = 1;
          continue;
          label622:
          label628:
          label633:
          for (;;)
          {
            bool1 = false;
            break label338;
            paramInt = 0;
            break;
          }
          label636:
          continue;
          bool1 = true;
        }
      }
    }
    localObject = b();
    if ((this.b) && (localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      l1 = a().longValue();
      localObject = (NotificationController.LimitEntry)((HashMap)localObject).get(paramString);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("todayBeginTime = ");
        localStringBuilder.append(new Date(l1));
        localStringBuilder.append("----");
        localStringBuilder.append(l1);
        localStringBuilder.append(" ，entry.mBaseLineTime = ");
        localStringBuilder.append(new Date(((NotificationController.LimitEntry)localObject).d));
        localStringBuilder.append("----");
        localStringBuilder.append(((NotificationController.LimitEntry)localObject).d);
        QLog.d("NCtr", 2, localStringBuilder.toString());
      }
      l2 = ((NotificationController.LimitEntry)localObject).d;
      paramInt = 0;
      if (l2 < 1L)
      {
        if (((NotificationController.LimitEntry)localObject).c <= 0) {
          break label622;
        }
        ((NotificationController.LimitEntry)localObject).d = l1;
        ((NotificationController.LimitEntry)localObject).e += 1;
      }
      else
      {
        if ((int)((l1 - ((NotificationController.LimitEntry)localObject).d) / 86400000L) < ((NotificationController.LimitEntry)localObject).b) {
          break label628;
        }
        ((NotificationController.LimitEntry)localObject).d = l1;
        ((NotificationController.LimitEntry)localObject).e = 0;
        paramInt = 1;
        if ((((NotificationController.LimitEntry)localObject).c <= 0) || (((NotificationController.LimitEntry)localObject).e >= ((NotificationController.LimitEntry)localObject).c)) {
          break label633;
        }
        ((NotificationController.LimitEntry)localObject).e += 1;
        break label614;
        if (paramInt == 0) {
          break label636;
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramString;
        this.c.sendMessage((Message)localObject);
        break label636;
        if (!bool1)
        {
          localObject = this.e;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(System.currentTimeMillis());
          ReportController.b((AppRuntime)localObject, "dc00898", "", paramString, "0X8009995", "0X8009995", 0, 0, localStringBuilder.toString(), "", "", "");
        }
        localObject = this.e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(System.currentTimeMillis());
        ReportController.b((AppRuntime)localObject, "dc00898", "", paramString, "0X8009996", "0X8009996", 0, 0, localStringBuilder.toString(), "", "", "");
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uin ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" shouldNotify is ");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("NCtr", 2, ((StringBuilder)localObject).toString());
          bool2 = bool1;
        }
        return bool2;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NCtr", 1, "inflateConfigString fail", paramArrayOfByte);
      }
    }
    return null;
  }
  
  public int b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("config_prefile", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    int k;
    int i;
    int j;
    boolean bool1;
    int m;
    boolean bool2;
    for (;;)
    {
      try
      {
        localObject1 = b();
        if (localObject1 == null) {
          break label1035;
        }
        localObject2 = (HashMap)((HashMap)localObject1).clone();
        localHashMap = new HashMap();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sourceString : ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.i("NCtr", 1, ((StringBuilder)localObject1).toString());
        }
        localObject3 = XmlPullParserFactory.newInstance().newPullParser();
        ((XmlPullParser)localObject3).setInput(new StringReader(paramString));
        k = ((XmlPullParser)localObject3).getEventType();
        localObject1 = "";
        paramString = "";
        i = 0;
        j = 0;
        bool1 = false;
        m = 50;
        if (k == 1) {
          break label1097;
        }
        localObject4 = ((XmlPullParser)localObject3).getName();
        if (k == 0) {
          break label1041;
        }
        if (k != 2)
        {
          if ((k != 3) || (!((String)localObject4).equalsIgnoreCase("entry"))) {
            break label1041;
          }
          if ((localObject2 != null) && (((HashMap)localObject2).containsKey(paramString)))
          {
            localObject4 = (NotificationController.LimitEntry)((HashMap)localObject2).get(paramString);
            ((HashMap)localObject2).remove(paramString);
            if ((i == ((NotificationController.LimitEntry)localObject4).b) && (j == ((NotificationController.LimitEntry)localObject4).c))
            {
              localHashMap.put(paramString, localObject4);
              break label1052;
            }
            localHashMap.put(paramString, new NotificationController.LimitEntry(this, paramString, i, j, 0L, 0));
            break label1052;
          }
          localHashMap.put(paramString, new NotificationController.LimitEntry(this, paramString, i, j, 0L, 0));
          break label1052;
        }
        if (((String)localObject4).equalsIgnoreCase("body"))
        {
          if (Integer.valueOf(((XmlPullParser)localObject3).getAttributeValue(0)).intValue() != 1) {
            break label1070;
          }
          bool1 = true;
          break label1073;
        }
        if (((String)localObject4).equalsIgnoreCase("puin"))
        {
          paramString = ((XmlPullParser)localObject3).nextText();
          break label1089;
        }
        if (((String)localObject4).equalsIgnoreCase("day"))
        {
          k = Integer.valueOf(((XmlPullParser)localObject3).nextText()).intValue();
          bool2 = bool1;
        }
        else
        {
          k = i;
          bool2 = bool1;
          if (((String)localObject4).equalsIgnoreCase("enableTimes"))
          {
            j = Integer.valueOf(((XmlPullParser)localObject3).nextText()).intValue();
            k = i;
            bool2 = bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        HashMap localHashMap;
        Object localObject3;
        Object localObject4;
        label422:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NCtr", 1, "parse fail", paramString);
        return;
      }
      k = ((XmlPullParser)localObject3).next();
    }
    label1035:
    label1041:
    label1052:
    label1070:
    label1073:
    label1081:
    label1089:
    label1097:
    for (;;)
    {
      this.b = bool1;
      localObject1 = BaseApplication.getContext().getSharedPreferences("config_prefile", 0).edit();
      localObject3 = this.e.getAccount();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("config_version_");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject4).toString(), paramInt1);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("config_appid_");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject4).toString(), paramInt2);
      ((SharedPreferences.Editor)localObject1).apply();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("config_should_limit_");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject4).toString(), bool1);
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("extra_limit_entry_");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append("_");
          ((StringBuilder)localObject4).append(paramString);
          ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject4).toString());
        }
      }
      paramString = new StringBuilder();
      if (localHashMap.size() > 0)
      {
        localObject2 = localHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject5 = (String)((Iterator)localObject2).next();
          localObject4 = (NotificationController.LimitEntry)localHashMap.get(localObject5);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("extra_limit_entry_");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("_");
          localStringBuilder.append((String)localObject5);
          ((SharedPreferences.Editor)localObject1).putString(localStringBuilder.toString(), ((NotificationController.LimitEntry)localObject4).toString());
          paramString.append((String)localObject5);
          paramString.append(",");
          if (QLog.isColorLevel())
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("LimitEntry:[");
            ((StringBuilder)localObject5).append(((NotificationController.LimitEntry)localObject4).toString());
            ((StringBuilder)localObject5).append("]");
            QLog.d("NCtr", 2, ((StringBuilder)localObject5).toString());
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("extra_limit_uins_");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramString.substring(0, paramString.length() - 1));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("LimitUins:[");
          ((StringBuilder)localObject2).append(paramString.substring(0, paramString.length() - 1));
          ((StringBuilder)localObject2).append("].mShouldLimit");
          ((StringBuilder)localObject2).append(this.b);
          QLog.d("NCtr", 2, ((StringBuilder)localObject2).toString());
        }
      }
      ((SharedPreferences.Editor)localObject1).apply();
      this.a = localHashMap;
      return;
      localObject2 = null;
      break;
      k = i;
      bool2 = bool1;
      break label1081;
      m -= 1;
      paramString = (String)localObject1;
      i = 0;
      j = 0;
      break label1089;
      bool1 = false;
      bool2 = bool1;
      k = i;
      bool1 = bool2;
      i = k;
      if (m > 0) {
        break label422;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      c(BaseApplication.getContext(), paramMessage);
      return true;
    }
    b((String)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
    return true;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.c;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.c = null;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.notification.NotificationController
 * JD-Core Version:    0.7.0.1
 */