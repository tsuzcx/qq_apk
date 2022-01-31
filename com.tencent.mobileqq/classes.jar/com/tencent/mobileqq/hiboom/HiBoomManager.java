package com.tencent.mobileqq.hiboom;

import adxk;
import adxl;
import adxm;
import adxn;
import adxo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

public class HiBoomManager
  implements Manager
{
  public static HiBoomFont.HiBoomFontDownloader a;
  public static HiBoomFont.HiBoomFontDownloader b;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  public Handler a;
  public QQAppInterface a;
  public final Object a;
  public Vector a;
  public AtomicBoolean a;
  public AtomicBoolean b;
  public AtomicBoolean c = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new adxn();
    jdField_b_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new adxo();
  }
  
  public HiBoomManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static QQProgressDialog a(Context paramContext)
  {
    if (((FragmentActivity)paramContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramContext);
      }
      return ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    hiboom_auth.TTipsInfo localTTipsInfo;
    if (paramArrayOfByte != null) {
      localTTipsInfo = new hiboom_auth.TTipsInfo();
    }
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        localTTipsInfo.mergeFrom(paramArrayOfByte);
        i = localTTipsInfo.i32_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult tipsType = " + i);
        }
        paramArrayOfByte = localTTipsInfo.str_title.get();
        Object localObject2 = paramArrayOfByte;
        if (android.text.TextUtils.isEmpty(paramArrayOfByte)) {
          localObject2 = "温馨提示";
        }
        localObject1 = localTTipsInfo.str_msg.get();
        paramArrayOfByte = (byte[])localObject1;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (i == 1) {
            paramArrayOfByte = "查看活动详情";
          }
        }
        else
        {
          String str = localTTipsInfo.str_button.get();
          localObject1 = str;
          if (android.text.TextUtils.isEmpty(str))
          {
            if (i == 1) {
              localObject1 = "了解详情";
            }
          }
          else
          {
            DialogUtil.a(paramContext, (String)localObject2, paramArrayOfByte, "取消", (String)localObject1, null, new adxl(i, localTTipsInfo.str_url.get(), paramContext, localTTipsInfo), new adxm()).show();
            return;
          }
          localObject1 = str;
          if (i != 2) {
            continue;
          }
          localObject1 = "开通超级会员";
          continue;
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("HiBoomFont.HiBoomManager", 1, "onHiBoomAuthResult merge error: " + paramContext.getLocalizedMessage() + " trace: " + Log.getStackTraceString(paramContext));
      }
      paramArrayOfByte = (byte[])localObject1;
      if (i == 2) {
        paramArrayOfByte = "开通超级会员";
      }
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    int i = VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if ((i == 5) || (i == 22)) {
      return 2;
    }
    return 1;
  }
  
  public HiBoomItem a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(true, false);
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext())
    {
      HiBoomItem localHiBoomItem = (HiBoomItem)localIterator.next();
      if (localHiBoomItem.jdField_a_of_type_Int == paramInt) {
        return localHiBoomItem;
      }
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      Object localObject = new Date(this.jdField_a_of_type_Long);
      localObject = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject);
      return "使用有效期截至" + (String)localObject;
    }
    return null;
  }
  
  public void a()
  {
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(0, "", 3);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "updateHiBoomAuthority authRet = " + paramInt + " validTime = " + paramLong);
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = (1000L * paramLong);
  }
  
  public void a(AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.compareAndSet(false, true)) {
      a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    adxk localadxk;
    if ((paramBoolean2) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "getRecommendListFromJSON");
      }
      localadxk = new adxk(this, paramBoolean1);
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        ThreadManager.post(localadxk, 8, null, true);
      }
    }
    else
    {
      return;
    }
    localadxk.run();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Long > 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() > this.jdField_a_of_type_Long) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, String paramString, int paramInt)
  {
    int i;
    if ((paramBaseChatPie.b() != 1008) && (paramBaseChatPie.b() != 7200) && (!AnonymousChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      i = 1;
      if (i != 0)
      {
        paramString = a(paramString);
        if (!android.text.TextUtils.isEmpty(paramString)) {
          break label64;
        }
      }
    }
    label64:
    do
    {
      return false;
      i = 0;
      break;
      if (paramString.length() > 20) {
        break label180;
      }
      if (!com.tencent.mobileqq.text.TextUtils.a(paramString)) {
        break label142;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("HiBoom_CHN_Tips", false));
    QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体暂不支持带表情的文字输入", 0).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
    return false;
    label142:
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt;
    localHiBoomMessage.text = paramString;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHiBoomMessage, null);
    return true;
    label180:
    QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体不能超过20字", 0).a();
    return false;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Long > 0L);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager
 * JD-Core Version:    0.7.0.1
 */