import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class gf
  extends QIPCModule
{
  private static gf jdField_a_of_type_Gf;
  public static String a;
  public static String b;
  public static String c;
  public static String d = "action_download_signature_config";
  public static String e = "action_get_my_signature";
  public static String f = "action_change_status";
  public static String g = "action_get_action";
  public static String h = "action_download_use_quickupdate";
  public static String i = "action_get_shield_font";
  public static String j = "action_get_history_signature_num";
  private VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new gg(this);
  private Vector<Integer> jdField_a_of_type_JavaUtilVector = new Vector();
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Vector<Integer> jdField_b_of_type_JavaUtilVector = new Vector();
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private AtomicInteger c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "action_download_hy_so";
    jdField_b_of_type_JavaLangString = "action_download_fz_so";
    jdField_c_of_type_JavaLangString = "action_download_font";
  }
  
  private gf(String paramString)
  {
    super(paramString);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static gf a()
  {
    try
    {
      if (jdField_a_of_type_Gf == null) {
        jdField_a_of_type_Gf = new gf("VasFontIPCModule");
      }
      gf localgf = jdField_a_of_type_Gf;
      return localgf;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Integer localInteger;
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      localVector = new Vector(this.jdField_a_of_type_JavaUtilVector);
      localIterator = localVector.iterator();
      while (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        localObject = new Bundle();
        ((Bundle)localObject).putInt("font_type", paramInt1);
        localObject = EIPCResult.createResult(paramInt2, (Bundle)localObject);
        callbackResult(localInteger.intValue(), (EIPCResult)localObject);
      }
      this.jdField_a_of_type_JavaUtilVector.removeAll(localVector);
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Vector localVector = new Vector(this.jdField_b_of_type_JavaUtilVector);
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("font_type", paramInt1);
      localObject = EIPCResult.createResult(paramInt2, (Bundle)localObject);
      callbackResult(localInteger.intValue(), (EIPCResult)localObject);
    }
    this.jdField_b_of_type_JavaUtilVector.removeAll(localVector);
  }
  
  public void a(int paramInt1, RichStatus paramRichStatus, TipsInfo paramTipsInfo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "onChangeStatus result = " + paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)
    {
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("notify_type", 5);
      paramRichStatus.putInt("result", paramInt1);
      paramRichStatus.putInt("type", paramInt2);
      if ((paramTipsInfo != null) && (paramTipsInfo.errorDesc != null)) {
        paramRichStatus.putString("errorDesc", paramTipsInfo.errorDesc);
      }
      if (paramInt2 == 0)
      {
        paramRichStatus.putBoolean("hasTipsInfo", false);
        if (paramTipsInfo.type > 0)
        {
          paramRichStatus.putInt("result", paramTipsInfo.ret);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramTipsInfo.type);
          paramRichStatus.putString("tips_titleWording", paramTipsInfo.titleWording);
          paramRichStatus.putString("tips_wording", paramTipsInfo.wording);
          paramRichStatus.putString("tips_rightBtnWording", paramTipsInfo.rightBtnWording);
          paramRichStatus.putString("tips_leftBtnWording", paramTipsInfo.leftBtnWording);
          paramRichStatus.putString("tips_vipType", paramTipsInfo.vipType);
          paramRichStatus.putInt("tips_vipMonth", paramTipsInfo.vipMonth);
          paramRichStatus.putString("tips_url", paramTipsInfo.url);
          paramRichStatus.putInt("authAppid", paramTipsInfo.authAppid);
        }
      }
      paramRichStatus = EIPCResult.createResult(0, paramRichStatus);
      callbackResult(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), paramRichStatus);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "onGetHistorySigNum result = " + paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("notify_type", 9);
      ((Bundle)localObject).putInt("result", paramInt1);
      ((Bundle)localObject).putInt("key_history_signature_num", paramInt2);
      localObject = EIPCResult.createResult(0, (Bundle)localObject);
      callbackResult(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), (EIPCResult)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (paramInt1 == 102) && (paramInt2 == 300) && (BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      avbr localavbr = ((avev)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(15)).a(this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      if (localavbr != null)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("notify_type", 6);
        ((Bundle)localObject).putString("url", localavbr.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject).putInt("id", this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        localObject = EIPCResult.createResult(0, (Bundle)localObject);
        callbackResult(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), (EIPCResult)localObject);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "IPC get action callback id = " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " url = " + localavbr.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFontIPCModule", 2, "onCall action = " + paramString);
    }
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label88;
      }
      ThreadManagerV2.executeOnSubThread(new VasFontIPCModule.1(this, paramInt, localQQAppInterface), true);
    }
    label88:
    do
    {
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              if (jdField_c_of_type_JavaLangString.equals(paramString))
              {
                k = paramBundle.getInt("id");
                int m = paramBundle.getInt("font_type");
                ((fv)localQQAppInterface.getManager(42)).a(k, Integer.toString(paramInt), m);
                return null;
              }
              if (!jdField_b_of_type_JavaLangString.equals(paramString)) {
                break;
              }
              if (new File(bajo.a() + "libFounderColorFont_818.so").exists())
              {
                callbackResult(paramInt, EIPCResult.createResult(0, null));
                return null;
              }
              this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
            } while (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
            ((VasQuickUpdateManager)localQQAppInterface.getManager(184)).downloadItem(1004L, "libColorFont_818", "VasFontIPCModule");
            return null;
            if (!d.equals(paramString)) {
              break;
            }
            k = paramBundle.getInt("id");
          } while ((k <= 0) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(k))));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(k), Integer.valueOf(paramInt));
          paramString = "signature.item." + k + ".json";
          paramBundle = (VasQuickUpdateManager)localQQAppInterface.getManager(184);
          paramBundle.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          paramBundle.downloadItem(1000L, paramString, "VasFontIPCModule");
          return null;
          if (e.equals(paramString))
          {
            paramString = ((avev)localQQAppInterface.getManager(15)).a(true);
            paramBundle = new Bundle();
            paramBundle.putInt("notify_type", 4);
            paramBundle.putSerializable("my_signature", paramString);
            callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
            return null;
          }
          if (f.equals(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Signature", 2, "ACTION_CHANGE_STATUS");
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
            paramString = paramBundle.getSerializable("my_signature");
            if ((paramString instanceof RichStatus))
            {
              paramString = (RichStatus)paramString;
              ((avev)localQQAppInterface.getManager(15)).a(paramString, 0);
              return null;
            }
            QLog.e("VasFontIPCModule", 1, "change status error, status is null");
            new Bundle().putInt("notify_type", 5);
            callbackResult(paramInt, EIPCResult.createResult(-102, null));
            return null;
          }
          if (!g.equals(paramString)) {
            break label710;
          }
          k = paramBundle.getInt("id");
          paramString = ((avev)localQQAppInterface.getManager(15)).a(k);
          if (paramString != null) {
            break;
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
          this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(k);
        } while (!QLog.isColorLevel());
        QLog.d("Signature", 2, "IPC get action fail, wait for callback id = " + k);
        return null;
        paramBundle = new Bundle();
        paramBundle.putInt("notify_type", 6);
        paramBundle.putString("url", paramString.jdField_b_of_type_JavaLangString);
        paramBundle.putInt("id", k);
        callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
      } while (!QLog.isColorLevel());
      QLog.d("Signature", 2, "IPC get action success id = " + k + " url = " + paramString.jdField_b_of_type_JavaLangString);
      return null;
      long l;
      if (h.equals(paramString))
      {
        l = paramBundle.getLong("bid");
        paramString = paramBundle.getString("scid");
        if (TextUtils.isEmpty(paramString))
        {
          callbackResult(paramInt, EIPCResult.createResult(-102, null));
          return null;
        }
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          paramBundle = new Bundle();
          paramBundle.putInt("notify_type", 8);
          paramBundle.putLong("bid", l);
          paramBundle.putString("scid", paramString);
          paramBundle.putInt("download_result", 1);
          callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
          return null;
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(paramInt));
        paramBundle = (VasQuickUpdateManager)localQQAppInterface.getManager(184);
        paramBundle.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        paramBundle.downloadItem(l, paramString, "VasFontIPCModule");
        return null;
      }
      if (i.equals(paramString))
      {
        paramString = new Bundle();
        paramString.putInt("key_shield_font", gh.a);
        callbackResult(paramInt, EIPCResult.createResult(0, paramString));
        return null;
      }
      if (j.equals(paramString))
      {
        l = paramBundle.getLong("key_current_uin");
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        ((avev)localQQAppInterface.getManager(15)).a(l);
        return null;
      }
    } while (!QLog.isColorLevel());
    label710:
    QLog.d("VasFontIPCModule", 2, "onCall action = " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     gf
 * JD-Core Version:    0.7.0.1
 */