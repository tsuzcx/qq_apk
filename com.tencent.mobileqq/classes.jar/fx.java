import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.Vas.ColorFont.FreeTypeLib;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontManager.1;
import com.etrump.mixlayout.FontManager.10;
import com.etrump.mixlayout.FontManager.2;
import com.etrump.mixlayout.FontManager.3;
import com.etrump.mixlayout.FontManager.4;
import com.etrump.mixlayout.FontManager.5;
import com.etrump.mixlayout.FontManager.8;
import com.etrump.mixlayout.FontManager.9;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class fx
  implements Handler.Callback, Manager
{
  public static float a;
  public static long a;
  public static final String a;
  public static Vector<Integer> a;
  public static ConcurrentHashMap<Integer, fw> a;
  public static float b;
  public static int b;
  public static long b;
  public static final String b;
  public static float c;
  public static long c;
  public static AtomicBoolean c;
  public static volatile boolean c;
  public static float d;
  static int jdField_d_of_type_Int;
  public static AtomicBoolean d;
  public static float e;
  private static int jdField_e_of_type_Int;
  public static AtomicBoolean e;
  public static boolean e;
  public static float f;
  public static final String f;
  public static boolean f;
  public static final String g;
  public static final String j = Environment.getExternalStorageDirectory() + "/FontTest" + "/hanyifont/";
  public static final String k = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengfont/";
  public static final String l = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengcolorfont2/";
  public static final String m = Environment.getExternalStorageDirectory() + "/FontTest" + "/diyfont/";
  public int a;
  public Handler a;
  public HandlerThread a;
  public bdwb a;
  public ETEngine a;
  public QQAppInterface a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  List<Integer> jdField_a_of_type_JavaUtilList = new LinkedList();
  Map<Integer, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<ga> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public AtomicBoolean a;
  public boolean a;
  public ETEngine b;
  private Map<Integer, String> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  ConcurrentHashMap<String, fw> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicBoolean b;
  public volatile boolean b;
  public int c;
  public String c;
  private Map<Integer, Long> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, fw>> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  long jdField_d_of_type_Long = 0L;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  long jdField_e_of_type_Long = 0L;
  public String e;
  private int f;
  public float g;
  public volatile boolean g;
  public float h;
  public String h;
  public boolean h;
  public float i;
  public String i;
  boolean i;
  
  static
  {
    jdField_a_of_type_JavaLangString = bduw.a(aljq.aX + ".font_info");
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "fz2.0/";
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_e_of_type_Boolean = true;
    jdField_f_of_type_Boolean = true;
    jdField_a_of_type_Float = 0.3F;
    jdField_b_of_type_Float = 0.3F;
    jdField_c_of_type_Float = 1.5F;
    jdField_d_of_type_Float = 0.7F;
    jdField_e_of_type_Float = 1.3F;
    jdField_f_of_type_Float = 0.7F;
    jdField_b_of_type_Int = 4;
    jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_e_of_type_Int = -1;
    jdField_f_of_type_JavaLangString = bduw.a(aljq.aX + ".font_effect");
    jdField_g_of_type_JavaLangString = jdField_f_of_type_JavaLangString + File.separator + "magicFontConfig.json";
  }
  
  public fx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Bdwb = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_g_of_type_Float = 1.5F;
    this.jdField_h_of_type_Float = 1.3F;
    this.jdField_i_of_type_Float = 1.5F;
    this.jdField_h_of_type_JavaLangString = alpo.a(2131705062);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    a(bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "vas_font_switch_config"));
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    paramQQAppInterface = new StringBuilder();
    if (!this.jdField_d_of_type_Boolean) {
      paramQQAppInterface.append(bdcb.i()).append("; CPU number: ").append(bdcb.b()).append("; CPU frequency: ").append(bdcb.a()).append("; RAM: ").append(bdcb.d());
    }
    this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
    this.jdField_a_of_type_Boolean = c();
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong >> 24) & 0x1;
  }
  
  public static int a(ExtensionInfo paramExtensionInfo)
  {
    int n = 0;
    if (paramExtensionInfo != null) {
      n = (int)(((paramExtensionInfo.uVipFont & 0xFF) << 8) + (paramExtensionInfo.uVipFont >> 8 & 0xFF)) + (paramExtensionInfo.vipFontType << 16) + (paramExtensionInfo.magicFont << 24);
    }
    return n;
  }
  
  public static long a(long paramLong)
  {
    return ((paramLong & 0xFF) << 8) + (paramLong >> 8 & 0xFF);
  }
  
  private fw a()
  {
    ??? = (fw)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_c_of_type_JavaLangString);
    Object localObject3;
    if (??? != null)
    {
      localObject3 = ???;
      if (((fw)???).jdField_b_of_type_Int == 4)
      {
        g.a().a(((fw)???).jdField_a_of_type_Int, ((fw)???).jdField_a_of_type_JavaLangString);
        localObject3 = ???;
      }
      return localObject3;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (!ETEngine.getInstance().isEngineInited.get())
      {
        d();
        return null;
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(j + this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString.hashCode(), true);
        this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(j + this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString.hashCode(), true);
        ??? = new fw(this.jdField_c_of_type_JavaLangString.hashCode(), j + this.jdField_c_of_type_JavaLangString);
        localObject3 = new ETFont(((fw)???).jdField_a_of_type_Int, j + this.jdField_c_of_type_JavaLangString, 1.0F);
        ((fw)???).jdField_c_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getVariantStyleComboCount((ETFont)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getTestFont: fontId=" + ((fw)???).jdField_a_of_type_Int + " styleCount=" + ((fw)???).jdField_c_of_type_Int);
        }
        ((fw)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        localObject3 = ???;
        if (??? == null) {
          break;
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_c_of_type_JavaLangString, ???);
        return ???;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        ??? = new fw(this.jdField_c_of_type_JavaLangString.hashCode(), k + this.jdField_c_of_type_JavaLangString);
        ((fw)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        ((fw)???).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(k + this.jdField_c_of_type_JavaLangString);
        continue;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        if (!g.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          c();
        }
        if (!g.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (g.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            g.a().a().a();
            g.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          }
        }
        else
        {
          ??? = new fw(49152 + (this.jdField_c_of_type_JavaLangString.hashCode() & 0x3FFF), l + this.jdField_c_of_type_JavaLangString);
          ((fw)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          g.a().a(((fw)???).jdField_a_of_type_Int, ((fw)???).jdField_a_of_type_JavaLangString);
          ((fw)???).jdField_c_of_type_Int = f.f(((fw)???).jdField_a_of_type_Int);
          continue;
        }
        return null;
      }
      if (this.jdField_a_of_type_Int != 99) {
        continue;
      }
      if (!ETEngine.getInstance().isEngineInited.get()) {
        d();
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      ??? = new fw(1000, m + this.jdField_c_of_type_JavaLangString);
      ((fw)???).jdField_b_of_type_Int = 1;
      ??? = new File(m + "config.json");
      if (((File)???).exists()) {
        ((fw)???).jdField_b_of_type_JavaLangString = fg.a((File)???);
      }
      ((fw)???).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(((fw)???).jdField_a_of_type_Int, ((fw)???).jdField_a_of_type_JavaLangString, 16.0F, ((fw)???).jdField_b_of_type_Int, ((fw)???).jdField_a_of_type_AndroidGraphicsTypeface);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(j + this.jdField_c_of_type_JavaLangString, ((fw)???).jdField_a_of_type_Int, true);
        this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(j + this.jdField_c_of_type_JavaLangString, ((fw)???).jdField_a_of_type_Int, true);
        ((fw)???).jdField_a_of_type_ComEtrumpMixlayoutETFont.parseDIYJsonString(((fw)???).jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3) {
      return jdField_b_of_type_JavaLangString + paramInt1 + File.separator + paramInt1 + ".ttf";
    }
    return jdField_a_of_type_JavaLangString + File.separator + paramInt1 + File.separator + paramInt1 + ".ttf";
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    switch (paramMessageRecord.istroop)
    {
    default: 
    case 0: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1025: 
    case 10002: 
    case 10004: 
    case 10008: 
    case 1: 
      do
      {
        return null;
        if (paramMessageRecord.isSend()) {
          return paramMessageRecord.selfuin;
        }
        return paramMessageRecord.frienduin;
      } while (nav.a(paramMessageRecord));
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.senderuin;
    }
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.senderuin;
  }
  
  public static void a()
  {
    QLog.e("VasFont", 1, "resetFontSwitch");
    jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    jdField_a_of_type_JavaUtilVector.clear();
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.5(this, paramInt1, paramInt2, paramString, paramInt3, paramBoolean));
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.a != null)
    {
      int i1 = paramBaseChatPie.a.getFirstVisiblePosition();
      int i2 = paramBaseChatPie.a.getLastVisiblePosition();
      int i3 = paramBaseChatPie.a.getHeaderViewsCount();
      int n = i1 - 1;
      if (n <= i2)
      {
        Object localObject = paramBaseChatPie.a.getChildAt(i3 + n - i1);
        if (localObject != null)
        {
          if (!(aekt.a((View)localObject) instanceof afys)) {
            break label113;
          }
          localObject = (afys)aekt.a((View)localObject);
          if ((((afys)localObject).d instanceof ETTextView)) {
            ((ETTextView)((afys)localObject).d).startAnimation(false, true);
          }
        }
        for (;;)
        {
          n += 1;
          break;
          label113:
          if ((aekt.a((View)localObject) instanceof afvg))
          {
            localObject = (afvg)aekt.a((View)localObject);
            if ((((afvg)localObject).a != null) && (((afvg)localObject).a.a != null)) {
              ((afvg)localObject).a.a.startAnimation(false, true);
            }
          }
          else if ((aekt.a((View)localObject) instanceof aflh))
          {
            ((aflh)aekt.a((View)localObject)).a.c();
          }
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "updateFontSwitch configContent = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramString.optBoolean("enableHanyiFont", true));
        jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramString.optBoolean("enableFounderFont", true));
        paramString = paramString.optJSONArray("blackList");
        if ((paramString == null) || (paramString.length() <= 0)) {
          continue;
        }
        int n = 0;
        while (n < paramString.length())
        {
          int i1 = paramString.optInt(n);
          if (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(i1))) {
            jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(i1));
          }
          n += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("VasFont", 1, "updateFontSwitch error: ", paramString);
      }
    }
  }
  
  private void a(String paramString, fw paramfw, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.9(this, paramString, paramfw, paramInt));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return new File(a(paramInt1, paramInt2)).exists();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, int paramInt1, int paramInt2)
  {
    aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
    }
    if (localExtensionInfo.diyFontTimestampMap == null) {
      localExtensionInfo.diyFontTimestampMap = new ConcurrentHashMap();
    }
    if ((localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) == null) || (((Integer)localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1))).intValue() < paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "checkUpdateDIYConfig uin = " + paramString + " fontId = " + paramInt1 + " oldTime = " + localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) + " newTime = " + paramInt2);
      }
      paramQQAppInterface = (alxl)paramQQAppInterface.a(13);
      paramExtensionInfo = new HashMap();
      paramExtensionInfo.put(paramString, Integer.valueOf(paramInt1));
      paramQQAppInterface.a(paramExtensionInfo);
      localExtensionInfo.diyFontTimestampMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      localaloz.a(localExtensionInfo);
      return true;
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (!jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(a(paramChatMessage)));
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    } while ((TextUtils.isEmpty(paramChatMessage)) || (!TextUtils.isDigitsOnly(paramChatMessage)) || ((Long.parseLong(paramChatMessage) >> 24 & 1L) != 1L));
    return true;
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_f_of_type_Int == -1)
    {
      if (((bdcb.b() < 2) || (bdcb.a() <= 1000L)) && ((bdcb.b() < 4) || (bdcb.d() <= 838860800L))) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return true");
      }
      this.jdField_f_of_type_Int = 1;
    }
    for (;;)
    {
      bdqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_font_dpc_fail", "font_dpc_fail", this.jdField_d_of_type_JavaLangString, paramString, 0.0F);
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      return true;
      label92:
      this.jdField_f_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return false. CPU number = " + bdcb.b() + " CPU Frequency = " + bdcb.a() + " Memory = " + bdcb.d());
      }
    }
    return false;
  }
  
  private boolean a(String paramString, fw paramfw, int paramInt)
  {
    if (paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramfw.jdField_a_of_type_Int, paramfw.jdField_a_of_type_JavaLangString, 16.0F, paramfw.jdField_b_of_type_Int, paramfw.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localConcurrentHashMap == null) {
      localConcurrentHashMap = new ConcurrentHashMap();
    }
    for (;;)
    {
      if (ETEngine.getInstance().native_diyFontIsDIYFont(paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont))
      {
        paramfw.jdField_a_of_type_Boolean = true;
        Object localObject2 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = paramString;
        }
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (ExtensionInfo)localObject1, paramfw.jdField_a_of_type_Int, paramInt))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isDIYFont fontId = " + paramfw.jdField_a_of_type_Int + " uin = " + paramString + " needUpdateDiyConfig");
          }
          if (!localConcurrentHashMap.containsKey(Integer.valueOf(paramfw.jdField_a_of_type_Int)))
          {
            localObject1 = new fw(0, "");
            localConcurrentHashMap.put(Integer.valueOf(paramfw.jdField_a_of_type_Int), localObject1);
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap);
          }
          return false;
        }
        if (localConcurrentHashMap.containsKey(Integer.valueOf(paramfw.jdField_a_of_type_Int)))
        {
          if (paramfw.jdField_a_of_type_Int != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isDIYFont fontid = " + paramfw.jdField_a_of_type_Int + " is diy font handle = " + paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle);
            }
            paramfw.jdField_a_of_type_Boolean = true;
            return true;
          }
        }
        else
        {
          if ((((ExtensionInfo)localObject1).diyFontConfigMap != null) && (((ExtensionInfo)localObject1).diyFontConfigMap.containsKey(Integer.valueOf(paramfw.jdField_a_of_type_Int))))
          {
            localObject1 = (String)((ExtensionInfo)localObject1).diyFontConfigMap.get(Integer.valueOf(paramfw.jdField_a_of_type_Int));
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isDIYFont fontId = " + paramfw.jdField_a_of_type_Int + " uin = " + paramString + " config = " + (String)localObject1);
            }
            paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont.parseDIYJsonString((String)localObject1);
            localObject1 = new fw(paramfw.jdField_a_of_type_Int, paramfw.jdField_a_of_type_JavaLangString);
            ((fw)localObject1).jdField_b_of_type_Int = paramfw.jdField_b_of_type_Int;
            ((fw)localObject1).jdField_a_of_type_Boolean = true;
            localObject2 = new ETFont(paramfw.jdField_a_of_type_Int, paramfw.jdField_a_of_type_JavaLangString, 16.0F, paramfw.jdField_b_of_type_Int, null);
            ((ETFont)localObject2).copy(paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            ((fw)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont = ((ETFont)localObject2);
            localConcurrentHashMap.put(Integer.valueOf(paramfw.jdField_a_of_type_Int), localObject1);
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap);
            return true;
          }
          localObject1 = new fw(paramfw.jdField_a_of_type_Int, paramfw.jdField_a_of_type_JavaLangString);
          ((fw)localObject1).jdField_b_of_type_Int = paramfw.jdField_b_of_type_Int;
          ((fw)localObject1).jdField_a_of_type_Boolean = true;
          ((fw)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramfw.jdField_a_of_type_Int, paramfw.jdField_a_of_type_JavaLangString, 16.0F, paramfw.jdField_b_of_type_Int, null);
          localConcurrentHashMap.put(Integer.valueOf(paramfw.jdField_a_of_type_Int), localObject1);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap);
          return true;
        }
      }
      return false;
    }
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 16 & 0xF);
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    return jdField_a_of_type_JavaLangString + File.separator + paramInt1 + File.separator + paramInt1 + "." + paramInt2 + ".ttf";
  }
  
  public static int c(long paramLong)
  {
    fw localfw = null;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localfw = (fw)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf((int)paramLong));
    }
    if (localfw != null) {}
    for (int n = localfw.jdField_c_of_type_Int;; n = 0)
    {
      if (n > 0) {}
      for (int i1 = jdField_d_of_type_Int % n;; i1 = 0)
      {
        jdField_d_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getVariedStyleIndex: sIndex=" + jdField_d_of_type_Int + " fontId=" + paramLong + " styleCount=" + n + " index=" + i1);
        }
        return i1;
      }
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ga localga = (ga)localIterator.next();
      if (localga != null) {
        localga.a();
      }
    }
  }
  
  public int a(int paramInt)
  {
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).cancelDwonloadItem(5L, "font.main.android." + paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "stopDownload font " + paramInt + " complete remove from list");
        }
        this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
      }
      return 0;
    }
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return null;
      try
      {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        localObject1 = BitmapFactory.decodeStream(new FileInputStream((File)localObject1));
        if (localObject1 == null) {
          continue;
        }
        return new BitmapDrawable((Bitmap)localObject1);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, localFileNotFoundException.toString());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public fw a(int paramInt1, int paramInt2)
  {
    fw localfw = (fw)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    Object localObject = localfw;
    if (localfw == null)
    {
      localObject = new File(a(paramInt1, paramInt2));
      boolean bool = ((File)localObject).exists();
      if (bool) {
        localfw = new fw(paramInt1, ((File)localObject).getAbsolutePath());
      }
      localObject = localfw;
      if (QLog.isColorLevel())
      {
        QLog.d("VasFont", 2, "findFontInfo|find from local|fontExists=" + bool);
        localObject = localfw;
      }
    }
    return localObject;
  }
  
  public fw a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    if (((paramInt2 == 4) || (paramInt2 == 3)) && (!g.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      if (!g.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        c();
        localObject = null;
      }
    }
    fw localfw;
    do
    {
      return localObject;
      if (g.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        g.a().a().a();
        g.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localfw = (fw)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (localfw == null)
        {
          a(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
          return localfw;
        }
      }
      else
      {
        return null;
      }
      if (localfw.jdField_b_of_type_Int == 4)
      {
        long l1 = System.currentTimeMillis();
        paramInt2 = g.a().a(paramInt1, localfw.jdField_a_of_type_JavaLangString);
        localfw.jdField_c_of_type_Int = f.f(paramInt1);
        long l2 = System.currentTimeMillis();
        if (paramInt2 != 0) {
          ge.a("action_load", paramInt1, 4, 0, l2 - l1);
        }
      }
      if (localfw.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
        localfw.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt1, localfw.jdField_a_of_type_JavaLangString, 16.0F, localfw.jdField_b_of_type_Int, localfw.jdField_a_of_type_AndroidGraphicsTypeface);
      }
      localObject = localfw;
    } while (!localfw.jdField_a_of_type_Boolean);
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (fw)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt1));
      this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.4(this, paramString, paramInt1, paramInt3));
      return localObject;
    }
    a(paramString, localfw, paramInt3);
    return null;
  }
  
  fw a(ChatMessage paramChatMessage)
  {
    boolean bool = false;
    Object localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    String str = paramChatMessage.getExtInfoFromExtStr("diy_timestamp");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {}
    for (int i2 = Integer.parseInt(str);; i2 = 0)
    {
      int n;
      int i1;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject)) && (!((String)localObject).equals("0")))
      {
        long l1 = Long.parseLong((String)localObject);
        n = (int)a(l1);
        i1 = b(l1);
      }
      for (;;)
      {
        localObject = a(paramChatMessage);
        if (i1 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "doGetUserFont msg do not has font id");
          }
          localObject = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a((String)localObject, false);
          if (localObject != null)
          {
            n = (int)((ExtensionInfo)localObject).uVipFont;
            i1 = ((ExtensionInfo)localObject).vipFontType;
          }
        }
        for (;;)
        {
          if (n != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "doGetUserFont fontID = " + n + " type = " + i1);
            }
            if (jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(n)))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont font is in black list");
              }
              return null;
              QLog.e("VasFont", 1, "doGetUserFont extensionInfo not in cache");
              return null;
            }
            if (((i1 == 4) || (i1 == 3)) && (!a()))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont Founder Color Font not supported");
              }
              return null;
            }
            if ((i1 == 1) && (!jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont HanYi Font not supported");
              }
              return null;
            }
            if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
              bool = true;
            }
            paramChatMessage = a(n, i1, bool, a(paramChatMessage), i2);
            if (paramChatMessage != null)
            {
              jdField_c_of_type_Boolean = true;
              return paramChatMessage;
            }
            if (QLog.isColorLevel()) {
              QLog.e("VasFont", 2, "doGetUserFont no font fontid = " + n + " fontType = " + i1);
            }
            return null;
          }
          return new fw(0, null);
        }
        i1 = 0;
        n = 0;
      }
    }
  }
  
  public File a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt1, paramInt2) != null)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", alpo.a(2131705063));
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt1);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "queryInfo fontId=" + paramInt1 + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1))) {
          break label344;
        }
        f1 = ((Float)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).floatValue();
        if (f1 != 1.0F) {
          break;
        }
        localJSONObject2.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", alpo.a(2131705064));
        break label392;
        localJSONObject2.put("canceling", paramInt2);
        localJSONObject2.put("progress", 100.0F * f1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1;
        localException.printStackTrace();
        continue;
        if (f1 == 2.0F)
        {
          localException.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", alpo.a(2131705061));
        }
        else
        {
          localException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", alpo.a(2131705059));
          break label392;
          label344:
          localException.put("status", 1);
          localException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", alpo.a(2131705060));
          continue;
        }
        label392:
        if (f1 == 3.0F) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
      }
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.3(this, paramInt1));
    }
    do
    {
      return;
      gh.a().a(paramInt1, -102);
    } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.jdField_a_of_type_Bdwb == null));
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackId", this.jdField_e_of_type_JavaLangString);
    localBundle.putInt("srcType", 9);
    this.jdField_a_of_type_Bdwb.a(0L, -1, localBundle);
    this.jdField_e_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt1, int paramInt2, String arg3)
  {
    int n = 0;
    QLog.e("DIYProfileTemplate.VasFont", 1, "字体下载完成回调:" + paramInt1 + " error:" + paramInt2);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "onDownloadComplete font " + paramInt1 + " complete remove from list");
          }
          this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt1));
        }
        if (!this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1))) {
          break label405;
        }
        l1 = ((Long)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).longValue();
        this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
        if (paramInt2 == 0)
        {
          if (l1 > 0L) {
            ge.a("action_download", paramInt1, 4, 0, System.currentTimeMillis() - l1);
          }
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(1.0F));
          ??? = (String)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
          if ((??? != null) && (!???.equals("0")))
          {
            Object localObject1;
            if (TextUtils.isDigitsOnly(???))
            {
              int i1 = Integer.parseInt(???);
              localObject1 = new EIPCResult();
              ((EIPCResult)localObject1).code = paramInt2;
              new Bundle().putInt("id", paramInt1);
              gh.a().callbackResult(i1, (EIPCResult)localObject1);
            }
            if (this.jdField_a_of_type_Bdwb != null)
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("callbackId", ???);
              ((Bundle)localObject1).putInt("srcType", 2);
              ??? = this.jdField_a_of_type_Bdwb;
              l1 = paramInt1;
              if (paramInt2 != 0) {
                break label400;
              }
              paramInt1 = n;
              ???.a(l1, paramInt1, (Bundle)localObject1);
            }
          }
          if (paramInt2 == 0)
          {
            bdkd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            f();
          }
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(2.0F));
      continue;
      label400:
      paramInt1 = -1;
      continue;
      label405:
      long l1 = 0L;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "startDownload font " + paramInt1 + " is downloading");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "startDownload font " + paramInt1 + " start download");
        }
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
        Map localMap = this.jdField_b_of_type_JavaUtilMap;
        ??? = paramString;
        if (paramString == null) {
          ??? = "0";
        }
        localMap.put(Integer.valueOf(paramInt1), ???);
        paramString = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
        if (paramInt2 == 3)
        {
          paramString.downloadItem(5L, "font.fzfont.android." + paramInt1, "FontManager");
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(0.0F));
          return;
        }
      }
      if (paramInt2 == 4) {
        this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
      }
      paramString.downloadItem(5L, "font.main.android." + paramInt1, "FontManager");
    }
  }
  
  public void a(TextView paramTextView)
  {
    fx localfx = (fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    float f1 = localfx.jdField_g_of_type_Float;
    if (alnq.a() == 18.0F) {
      f1 = localfx.jdField_h_of_type_Float;
    }
    for (;;)
    {
      paramTextView.setTextSize(2, Math.round(f1 / this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().density * ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())));
      return;
    }
  }
  
  public void a(bdwb parambdwb)
  {
    this.jdField_a_of_type_Bdwb = parambdwb;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      Object localObject = (MessageForText)paramChatMessage;
      paramChatMessage = null;
      if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
        if (TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          break label128;
        }
      }
      label128:
      for (paramChatMessage = ((MessageForText)localObject).sb2; paramChatMessage != null; paramChatMessage = ((MessageForText)localObject).sb)
      {
        localObject = (fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
        if (!(paramChatMessage instanceof baig)) {
          break;
        }
        paramChatMessage = (bain[])((baig)paramChatMessage).getSpans(0, paramChatMessage.length(), bain.class);
        int i1 = paramChatMessage.length;
        int n = 0;
        while (n < i1)
        {
          paramChatMessage[n].a(azgq.a(Math.round(((fx)localObject).jdField_i_of_type_Float * 32.0F)));
          n += 1;
        }
      }
    }
  }
  
  public void a(ga paramga)
  {
    if ((paramga == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramga))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramga);
  }
  
  public void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {}
    for (;;)
    {
      int n;
      try
      {
        paramFile = new JSONObject(bdcs.a(paramFile));
        Object localObject = paramFile.optJSONArray("defaultEffect");
        if (1 == ((JSONArray)localObject).length()) {
          this.jdField_c_of_type_Int = ((JSONObject)((JSONArray)localObject).get(0)).optInt("effectID", 1);
        }
        paramFile = paramFile.optJSONArray("magicFontConfig");
        n = 0;
        if (n < paramFile.length())
        {
          localObject = (JSONObject)paramFile.get(n);
          if (2 == ((JSONObject)localObject).optInt("platformId", 0))
          {
            this.jdField_g_of_type_Float = ((float)((JSONObject)localObject).optDouble("fontEnlargeFactor"));
            this.jdField_h_of_type_Float = ((float)((JSONObject)localObject).optDouble("maxEnlargeFactor"));
            this.jdField_i_of_type_Float = ((float)((JSONObject)localObject).optDouble("emotionEnlargeFactor"));
            if (((JSONObject)localObject).optInt("switch", 1) != 1) {
              break label335;
            }
            bool = true;
            this.jdField_h_of_type_Boolean = bool;
            this.jdField_h_of_type_JavaLangString = ((JSONObject)localObject).optString("description");
            this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject).optString("magic");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("VasFont", 2, "fontEffectPrefer = " + this.jdField_c_of_type_Int + " enlargeFontText = " + this.jdField_g_of_type_Float + " enlargeFontTextMax = " + this.jdField_h_of_type_Float + " enlargeFontEmo = " + this.jdField_i_of_type_Float + " enlargeFontSwitch = " + this.jdField_h_of_type_Boolean + " enlargeFontDesc = " + this.jdField_h_of_type_JavaLangString + " enlargeFontImgURL = " + this.jdField_i_of_type_JavaLangString);
          }
          this.jdField_i_of_type_Boolean = true;
          bdkd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      }
      catch (Exception paramFile)
      {
        QLog.e("VasFont", 1, "parse fontEffect json config fail", paramFile);
        return;
      }
      n += 1;
      continue;
      label335:
      boolean bool = false;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i1 = 1;
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo2 = localaloz.a(paramString);
    int n = 0;
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = paramString;
      localExtensionInfo1.fontEffect = -1;
      n = 1;
    }
    if (localExtensionInfo1.fontEffect != paramInt)
    {
      localExtensionInfo1.fontEffect = paramInt;
      localExtensionInfo1.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      e();
    }
    for (paramInt = i1;; paramInt = n)
    {
      if (paramInt != 0) {
        localaloz.a(localExtensionInfo1);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = c();
        if (!this.jdField_a_of_type_Boolean) {
          break label596;
        }
        localObject = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
        this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForAnimation();
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine == null)) {
          break label585;
        }
        int i2 = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        n = i2 * i2 * 240 * 18 * 2;
        if (n <= 1048576) {
          break label597;
        }
        boolean bool3 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
        boolean bool2 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
        boolean bool1 = bool3;
        if (!bool3) {}
        try
        {
          bool1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(18, n);
          bool3 = bool2;
          if (!bool2) {
            bool3 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.initEngine(10, 3145728);
          }
          if ((bool1) && (bool3))
          {
            i1 = 1;
            if (paramBoolean)
            {
              if (i1 == 0) {
                break label577;
              }
              String str1 = "1";
              localObject = ((aloz)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              if ((localObject == null) || (0L == ((ExtensionInfo)localObject).uVipFont) || (((ExtensionInfo)localObject).vipFontType != 1)) {
                break label604;
              }
              localObject = "0";
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072CB", 0, 0, str1, (String)localObject, "", "");
              if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "VipFontReport: AIO engine status, status=" + str1 + ", hgType=" + (String)localObject);
              }
            }
            if (i1 == 0) {
              break label596;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "start init font engine fontsize=" + i2 + ",num=" + 18 + ",cache=" + n);
            }
            ETEngine.getInstance().isEngineReady.set(true);
            if (paramBoolean) {
              break label596;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C9", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label596;
            }
            QLog.d("VasFont", 2, "VipFontReport: AioRefreshed");
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("VasFont", 1, "init font engine fail " + localException.getMessage());
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
          return;
        }
        int i1 = 0;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VasFont", 1, "init font engine fail " + localThrowable.getMessage());
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
        return;
      }
      continue;
      label577:
      String str2 = "0";
      continue;
      label585:
      throw new Exception("create font engine Instance fail");
      label596:
      return;
      label597:
      int n = 1048576;
      continue;
      label604:
      Object localObject = "1";
    }
  }
  
  public boolean a()
  {
    return jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get())) {
      return false;
    }
    return this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(paramInt);
  }
  
  public boolean a(aelt paramaelt, ChatMessage paramChatMessage)
  {
    if ((paramaelt instanceof afys))
    {
      paramaelt = (afys)paramaelt;
      if ((paramaelt.d instanceof ETTextView))
      {
        if (((ETTextView)paramaelt.d).mFont == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has no font yet");
          }
          return true;
        }
        fw localfw = b(paramChatMessage);
        if ((localfw != null) && ((paramaelt.d instanceof ETTextView)))
        {
          ETTextView localETTextView = (ETTextView)paramaelt.d;
          if (localETTextView.mFont.mFontId != localfw.jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has font change");
            }
            return true;
          }
          if ((localfw.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (localfw.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle != localETTextView.mFont.m_diyHandle))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has diyFont change");
            }
            return true;
          }
        }
        if (a(paramChatMessage) != ((ETTextView)paramaelt.d).mMagicFont)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change");
          }
          return true;
        }
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh needRefershAIOForFontEffect.");
          }
          return true;
        }
        paramaelt = (ETTextView)paramaelt.d;
        if ((paramaelt.getETLayout() != null) && (paramaelt.mMagicFont != paramaelt.getETLayout().jdField_b_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change 2");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(fw paramfw, String paramString, int paramInt)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString);
        try
        {
          ??? = new File(paramfw.jdField_a_of_type_JavaLangString);
          if (!((File)???).exists())
          {
            a(paramfw.jdField_a_of_type_Int, null, 1);
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "load font fail file not exist font id=" + paramfw.jdField_a_of_type_Int);
            }
            bool1 = false;
            return bool1;
          }
          if (bdcs.a((File)???) == null)
          {
            b(paramfw.jdField_a_of_type_Int, 1);
            VasWebviewUtil.reportVasStatus("Font", "FontMd5Check", "0", 0, 0, paramfw.jdField_a_of_type_Int, 1, "", "");
            bool1 = false;
            continue;
          }
          QLog.d("VasFont", 1, "ET load font start id = " + paramfw.jdField_a_of_type_Int + " time = " + System.currentTimeMillis());
        }
        catch (Throwable paramfw)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VasFont", 2, "load font fail", paramfw);
          continue;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(paramfw.jdField_a_of_type_JavaLangString, paramfw.jdField_a_of_type_Int, bool3);
          bool3 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(paramfw.jdField_a_of_type_JavaLangString, paramfw.jdField_a_of_type_Int, bool3);
          QLog.d("VasFont", 1, "ET load font end id = " + paramfw.jdField_a_of_type_Int + " time = " + System.currentTimeMillis());
          if ((!bool1) || (!bool3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "load font fail font id=" + paramfw.jdField_a_of_type_Int + " ret=" + bool1 + " ret2=" + bool3);
            }
            bool1 = false;
          }
        }
        if (!QLog.isColorLevel()) {
          break label397;
        }
      }
      finally {}
      QLog.d("VasFont", 2, "setActiveFonts refreshAIO");
      label397:
      boolean bool1 = bool2;
      if (a(paramString, paramfw, paramInt))
      {
        bdkd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bool1 = bool2;
      }
    }
  }
  
  public fw b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Boolean = c();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasFont", 2, "getUserFont fontFeatureSupported = false");
      }
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return a();
    }
    String str1 = a(paramChatMessage);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getUserFont uin is empty");
      }
      return new fw(0, null);
    }
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = localaloz.a(str1, false);
    String str2 = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getUserFont: message font id = " + str2 + " uin = " + str1);
    }
    long l1 = paramChatMessage.time;
    long l2;
    int n;
    if ((!TextUtils.isEmpty(str2)) && (TextUtils.isDigitsOnly(str2)) && (!str2.equals("0")))
    {
      l2 = Long.parseLong(str2);
      n = b(l2);
      if ((n == 2) || (n == 1) || (n == 4)) {
        if ((localExtensionInfo != null) && (l1 > localExtensionInfo.lastUpdateTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getUserFont: message time = " + l1 + " lastUpdateTime = " + localExtensionInfo.lastUpdateTime);
          }
          if (a(l2) == localExtensionInfo.uVipFont) {
            break label370;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getUserFont: message font not equals local uin = " + str1);
          }
          bdbg.a(str1);
          n = 1;
        }
      }
    }
    for (;;)
    {
      if (n != 0) {
        bdbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return a(paramChatMessage);
      label370:
      if (a(l2) != localExtensionInfo.magicFont)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getUserFont: message magicfont not equals local uin = " + str1);
        }
        bdbg.a(str1);
        n = 1;
        continue;
        if (localExtensionInfo != null) {
          return a(paramChatMessage);
        }
        new QueryTask(new fy(this, localaloz, str1), new fz(this, paramChatMessage)).a(null);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "getUserFont extensionInfo no cache.");
        }
        return null;
      }
      else
      {
        n = 0;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine != null)
    {
      ETDecoration.clearMap(this.jdField_b_of_type_ComEtrumpMixlayoutETEngine);
      this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
    {
      ETDecoration.clearMap(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine);
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "reDownloadFont start");
    }
    Object localObject = a(paramInt1, paramInt2);
    if (localObject != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
      localObject = new File(((fw)localObject).jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {
        break label242;
      }
      localObject = new File(((File)localObject).getParent());
      File[] arrayOfFile = ((File)localObject).listFiles();
      if (arrayOfFile != null)
      {
        int n = 0;
        while (n < arrayOfFile.length)
        {
          bool = arrayOfFile[n].delete();
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reDownloadFont delete " + arrayOfFile[n].getName() + " ret = " + bool);
          }
          n += 1;
        }
      }
      boolean bool = ((File)localObject).delete();
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownloadFont delete " + ((File)localObject).getName() + " ret = " + bool);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownload startDownload");
      }
      a(paramInt1, null, paramInt2);
      return;
      label242:
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownloadFont fontFile not exist");
      }
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    Object localObject;
    if (NetConnInfoCenter.getServerTimeMillis() - jdField_c_of_type_Long > 86400000L)
    {
      jdField_c_of_type_Long = NetConnInfoCenter.getServerTimeMillis() - NetConnInfoCenter.getServerTimeMillis() % 86400000L;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QLog.d("VasFont", 2, "reportFontEffect: time = " + ((SimpleDateFormat)localObject).format(new Date(jdField_c_of_type_Long)));
      }
    }
    if (paramChatMessage.isSend())
    {
      if (0L == this.jdField_d_of_type_Long) {
        this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("magic_font_last_send_report", 0L);
      }
      if (0L == this.jdField_e_of_type_Long) {
        this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("magic_font_reset_time", 0L);
      }
      if ((this.jdField_d_of_type_Long < jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > this.jdField_e_of_type_Long))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isDigitsOnly((CharSequence)localObject))) {
          break label353;
        }
      }
    }
    label353:
    for (int n = Integer.valueOf((String)localObject).intValue();; n = 0)
    {
      if ((n == 0) && (a(paramChatMessage))) {
        n = 1;
      }
      for (;;)
      {
        if (n != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reportFontEffect real report.");
          }
          VasWebviewUtil.reportCommercialDrainage(paramChatMessage.selfuin, "FontEffect", "SendMsg", "", 1, 0, 0, "", n + "", "");
          this.jdField_d_of_type_Long = (paramChatMessage.time * 1000L);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          ((SharedPreferences.Editor)localObject).putLong("magic_font_last_send_report", paramChatMessage.time * 1000L);
          ((SharedPreferences.Editor)localObject).apply();
        }
        return;
      }
    }
  }
  
  public void b(ga paramga)
  {
    if (paramga == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramga);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.10(this, paramString, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 4).edit().putBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramBoolean).apply();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (jdField_e_of_type_Int == -1)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          QLog.d("VasFont", 1, "FounderDynamicFont DPC value = " + localObject[8]);
          if (!"0".equals(localObject[8])) {
            break label109;
          }
        }
      }
    }
    label109:
    for (jdField_e_of_type_Int = 0;; jdField_e_of_type_Int = 1)
    {
      if ((jdField_e_of_type_Int == 1) || (jdField_e_of_type_Int == -1)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = true;
    if (TextUtils.isEmpty(a(paramChatMessage))) {
      if (QLog.isColorLevel()) {
        QLog.d("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> get sender uin null");
      }
    }
    String str;
    int n;
    label236:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (!a(paramChatMessage)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> magic font first.");
          return false;
          str = paramChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> font effect id(msg str): " + str);
          }
          if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
            break label236;
          }
          n = Integer.valueOf(str).intValue();
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> font effect id(msg int): " + n);
          }
          if (n == 0) {
            break;
          }
          if (this.jdField_g_of_type_Boolean) {
            break label266;
          }
          this.jdField_g_of_type_Boolean = true;
          paramChatMessage = VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5L, "magicFontConfig.json", jdField_g_of_type_JavaLangString, true, null);
          if (paramChatMessage != null) {
            a(paramChatMessage);
          }
        } while (!QLog.isColorLevel());
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, parse Json.");
        return false;
      } while (!QLog.isColorLevel());
      QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, fontEffectId=FONT_EFFECT_NONE.");
      return false;
      QLog.e("tag.vasFont.enlarge", 1, "enableEnlargeFontEffect --> error effect id: " + str);
      return false;
      if (this.jdField_h_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    label266:
    QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, enlargeFontSwitch close.");
    return false;
    aloz localaloz;
    if (paramChatMessage.isSend())
    {
      str = paramChatMessage.selfuin;
      localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localaloz != null)
      {
        ExtensionInfo localExtensionInfo = localaloz.a(str, false);
        if (localExtensionInfo == null) {
          break label517;
        }
        if (QLog.isColorLevel()) {
          QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo.fontEffectLastUpdateTime:" + localExtensionInfo.fontEffectLastUpdateTime + " msg.time:" + paramChatMessage.time);
        }
        if ((localExtensionInfo.fontEffectLastUpdateTime < paramChatMessage.time) && (n != localExtensionInfo.fontEffect))
        {
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> fontEffectId not equal with local.");
          }
          bdbg.a(str);
          bdbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      label438:
      if (2000 != n) {
        break label538;
      }
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> enable enlarge font.");
      }
    }
    label517:
    label538:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        str = paramChatMessage.frienduin;
        break;
      }
      str = paramChatMessage.senderuin;
      break;
      ThreadManager.post(new FontManager.8(this, localaloz, str), 5, null, true);
      break label438;
    }
  }
  
  void c()
  {
    if (g.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    g.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.1(this));
  }
  
  public boolean c()
  {
    if (this.jdField_f_of_type_Int != -1) {
      return this.jdField_f_of_type_Int == 1;
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name(), "default");
    QLog.d("VasFont", 1, "fontSwitch = " + str);
    if (str.equals("1"))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if ((str.equals("000")) || (str.equals("default"))) {
      this.jdField_a_of_type_Boolean = a(str);
    }
    if (str.equals("0")) {
      this.jdField_f_of_type_Int = 0;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    if ((ETEngine.getInstance().isEngineInited.compareAndSet(false, true)) && (gf.c())) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FontManager.2(this), 2000L);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "resetLastSendReportTime.");
    }
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putLong("magic_font_last_send_report", this.jdField_d_of_type_Long);
    localEditor.putLong("magic_font_reset_time", this.jdField_e_of_type_Long);
    localEditor.apply();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int n = paramMessage.what;
    return true;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 1602	fx:jdField_a_of_type_Long	J
    //   4: lconst_0
    //   5: putstatic 1604	fx:jdField_b_of_type_Long	J
    //   8: getstatic 226	fx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: invokevirtual 1605	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   14: aload_0
    //   15: getfield 322	fx:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   18: ifnull +11 -> 29
    //   21: aload_0
    //   22: getfield 322	fx:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   25: aconst_null
    //   26: invokevirtual 1608	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 306	fx:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   33: ifnull +45 -> 78
    //   36: getstatic 1611	com/etrump/mixlayout/ETTextView:mCreateDecorationHandler	Landroid/os/Handler;
    //   39: ifnull +14 -> 53
    //   42: getstatic 1611	com/etrump/mixlayout/ETTextView:mCreateDecorationHandler	Landroid/os/Handler;
    //   45: aconst_null
    //   46: invokevirtual 1608	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   49: aconst_null
    //   50: putstatic 1611	com/etrump/mixlayout/ETTextView:mCreateDecorationHandler	Landroid/os/Handler;
    //   53: getstatic 1612	com/tencent/mobileqq/hiboom/HiBoomTextView:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   56: ifnull +14 -> 70
    //   59: getstatic 1612	com/tencent/mobileqq/hiboom/HiBoomTextView:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   62: aconst_null
    //   63: invokevirtual 1608	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   66: aconst_null
    //   67: putstatic 1612	com/tencent/mobileqq/hiboom/HiBoomTextView:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   70: aload_0
    //   71: getfield 306	fx:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   74: invokevirtual 1615	android/os/HandlerThread:quit	()Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 375	fx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   82: ifnull +53 -> 135
    //   85: aload_0
    //   86: getfield 185	fx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 375	fx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   96: invokestatic 1387	com/etrump/mixlayout/ETDecoration:clearMap	(Lcom/etrump/mixlayout/ETEngine;)V
    //   99: aload_0
    //   100: getfield 375	fx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   103: invokevirtual 1618	com/etrump/mixlayout/ETEngine:native_doneEngine	()V
    //   106: aload_1
    //   107: monitorexit
    //   108: aload_0
    //   109: getfield 375	fx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   112: getfield 366	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: iconst_0
    //   116: invokevirtual 439	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   119: aload_0
    //   120: getfield 375	fx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   123: getfield 373	com/etrump/mixlayout/ETEngine:isEngineReady	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   126: iconst_0
    //   127: invokevirtual 439	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 375	fx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   135: aload_0
    //   136: getfield 386	fx:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   139: ifnull +53 -> 192
    //   142: aload_0
    //   143: getfield 185	fx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   146: astore_1
    //   147: aload_1
    //   148: monitorenter
    //   149: aload_0
    //   150: getfield 386	fx:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   153: invokestatic 1387	com/etrump/mixlayout/ETDecoration:clearMap	(Lcom/etrump/mixlayout/ETEngine;)V
    //   156: aload_0
    //   157: getfield 386	fx:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   160: invokevirtual 1618	com/etrump/mixlayout/ETEngine:native_doneEngine	()V
    //   163: aload_1
    //   164: monitorexit
    //   165: aload_0
    //   166: getfield 386	fx:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   169: getfield 366	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   172: iconst_0
    //   173: invokevirtual 439	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   176: aload_0
    //   177: getfield 386	fx:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   180: getfield 373	com/etrump/mixlayout/ETEngine:isEngineReady	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   183: iconst_0
    //   184: invokevirtual 439	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 386	fx:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   192: invokestatic 1623	asnp:a	()Lasnp;
    //   195: getfield 1624	asnp:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   198: iconst_0
    //   199: invokevirtual 439	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   202: invokestatic 1623	asnp:a	()Lasnp;
    //   205: getfield 1625	asnp:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   208: iconst_0
    //   209: invokevirtual 439	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   212: aload_0
    //   213: getfield 190	fx:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   216: invokevirtual 1626	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   219: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +13 -> 235
    //   225: ldc_w 298
    //   228: iconst_2
    //   229: ldc_w 1628
    //   232: invokestatic 411	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: return
    //   236: astore_2
    //   237: aload_1
    //   238: monitorexit
    //   239: aload_2
    //   240: athrow
    //   241: astore_1
    //   242: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -137 -> 108
    //   248: ldc_w 298
    //   251: iconst_2
    //   252: aload_1
    //   253: invokevirtual 1629	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   256: invokestatic 1185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -151 -> 108
    //   262: astore_2
    //   263: aload_1
    //   264: monitorexit
    //   265: aload_2
    //   266: athrow
    //   267: astore_1
    //   268: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq -106 -> 165
    //   274: ldc_w 298
    //   277: iconst_2
    //   278: aload_1
    //   279: invokevirtual 1629	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   282: invokestatic 1185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto -120 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	fx
    //   241	23	1	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   267	12	1	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   236	4	2	localObject2	Object
    //   262	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   92	108	236	finally
    //   237	239	236	finally
    //   85	92	241	java/lang/UnsatisfiedLinkError
    //   239	241	241	java/lang/UnsatisfiedLinkError
    //   149	165	262	finally
    //   263	265	262	finally
    //   142	149	267	java/lang/UnsatisfiedLinkError
    //   265	267	267	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fx
 * JD-Core Version:    0.7.0.1
 */