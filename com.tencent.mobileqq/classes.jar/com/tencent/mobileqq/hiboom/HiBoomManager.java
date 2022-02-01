package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterFontInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

public class HiBoomManager
  implements Manager
{
  public static int a;
  public static HiBoomFont.HiBoomFontDownloader a;
  public static final String a;
  private static boolean jdField_a_of_type_Boolean;
  public static HiBoomFont.HiBoomFontDownloader b;
  public static AtomicBoolean b;
  public static AtomicBoolean c;
  public Handler a;
  public QQAppInterface a;
  HiBoomManager.LegalJudgeResultLisener jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$LegalJudgeResultLisener = null;
  private IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
  public final Object a;
  public Vector<Integer> a;
  public ConcurrentHashMap<Integer, HiBoomItem> a;
  public AtomicBoolean a;
  public Handler b;
  public Vector<Integer> b;
  ConcurrentHashMap<Integer, String> b;
  public Vector<Integer> c;
  private AtomicBoolean d = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "hiboom_list_cache";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = 300;
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new HiBoomManager.3();
    jdField_b_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new HiBoomManager.4();
  }
  
  public HiBoomManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    this.jdField_c_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public static int a(int paramInt)
  {
    HiBoomFontDrawer localHiBoomFontDrawer = HiBoomFont.a().a(paramInt, 0, jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
    if ((localHiBoomFontDrawer.jdField_a_of_type_Int != 2) && (localHiBoomFontDrawer.jdField_a_of_type_Int != 1) && (localHiBoomFontDrawer.jdField_a_of_type_Int != 4) && (localHiBoomFontDrawer.jdField_a_of_type_Int != 3)) {
      localHiBoomFontDrawer.a(false);
    }
    return localHiBoomFontDrawer.jdField_a_of_type_Int;
  }
  
  public static HiBoomManager a(QQAppInterface paramQQAppInterface)
  {
    return (HiBoomManager)paramQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER);
  }
  
  public static QQProgressDialog a(Context paramContext)
  {
    if ((((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
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
  
  static void a(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      hiboom_auth.TTipsInfo localTTipsInfo = new hiboom_auth.TTipsInfo();
      label333:
      for (;;)
      {
        try
        {
          localTTipsInfo.mergeFrom(paramArrayOfByte);
          int i = localTTipsInfo.i32_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult tipsType = " + i);
          }
          String str2 = localTTipsInfo.str_title.get();
          if (android.text.TextUtils.isEmpty(str2))
          {
            str2 = HardCodeUtil.a(2131705487);
            paramArrayOfByte = localTTipsInfo.str_msg.get();
            if (android.text.TextUtils.isEmpty(paramArrayOfByte))
            {
              String str3;
              if (i == 1)
              {
                paramArrayOfByte = HardCodeUtil.a(2131705491);
                str3 = localTTipsInfo.str_button.get();
                str1 = str3;
                if (android.text.TextUtils.isEmpty(str3))
                {
                  if (i == 1) {
                    str1 = HardCodeUtil.a(2131705492);
                  }
                }
                else
                {
                  str3 = localTTipsInfo.str_url.get();
                  DialogUtil.a(paramContext, 230, str2, paramArrayOfByte, HardCodeUtil.a(2131705495), str1, new HiBoomManager.1(i, str3, paramContext, localTTipsInfo, paramInt), new HiBoomManager.2()).show();
                  if (!(paramContext instanceof FragmentActivity)) {
                    break;
                  }
                  paramContext = (FragmentActivity)paramContext;
                  if ((paramContext.getChatFragment() == null) || (paramContext.getChatFragment().a() == null)) {
                    break;
                  }
                  ((HiBoomManager)paramContext.getChatFragment().a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER)).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                }
              }
              else
              {
                if (i != 2) {
                  break label333;
                }
                paramArrayOfByte = HardCodeUtil.a(2131705496);
                continue;
              }
              String str1 = str3;
              if (i != 2) {
                continue;
              }
              str1 = HardCodeUtil.a(2131705489);
              continue;
            }
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("HiBoomFont.HiBoomManager", 1, "onHiBoomAuthResult merge error: " + paramContext.getLocalizedMessage() + " trace: " + Log.getStackTraceString(paramContext));
          return;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4);
  }
  
  private static boolean a(long paramLong)
  {
    return NetConnInfoCenter.getServerTime() > paramLong;
  }
  
  private void b(int paramInt)
  {
    ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(5L, "font.hiFontQQ.json." + paramInt, "HiBoomManager");
  }
  
  public static boolean b()
  {
    long l = Runtime.getRuntime().maxMemory();
    if (l > 134217728L) {}
    for (boolean bool = true;; bool = false)
    {
      if ((QLog.isColorLevel()) || (!bool)) {
        QLog.d("HiBoomFont.HiBoomManager", 1, "isMemorySupport: " + bool + " maxHeap=" + l);
      }
      return bool;
    }
  }
  
  private void e()
  {
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    ArrayList localArrayList = new ArrayList();
    int i = 2000;
    if (i < 2005)
    {
      VipFontUpdate.TPosterFontInfo localTPosterFontInfo = new VipFontUpdate.TPosterFontInfo();
      localTPosterFontInfo.i32_font_id.set(i);
      if (i % 2 == 0) {}
      for (long l = System.currentTimeMillis() / 1000L + 86400L;; l = System.currentTimeMillis() / 1000L - i)
      {
        localTPosterFontInfo.u64_ts.set(l);
        localArrayList.add(localTPosterFontInfo);
        i += 1;
        break;
      }
    }
    localTGetPosterFontRsp.rpt_using_list.set(localArrayList);
    a(localTGetPosterFontRsp, true);
  }
  
  private void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      HiBoomItem localHiBoomItem = (HiBoomItem)localIterator.next();
      if (!localHiBoomItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a(localHiBoomItem.jdField_a_of_type_Int, true, false, false);
      }
    }
  }
  
  public HiBoomItem a(int paramInt)
  {
    try
    {
      HiBoomItem localHiBoomItem2 = (HiBoomItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      HiBoomItem localHiBoomItem1 = localHiBoomItem2;
      if (localHiBoomItem2 == null)
      {
        localHiBoomItem1 = new HiBoomItem();
        localHiBoomItem1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localHiBoomItem1);
      }
      return localHiBoomItem1;
    }
    finally {}
  }
  
  public JSONObject a(int paramInt)
  {
    i = 1;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localHiBoomItem = a(paramInt);
        if (!HiBoomFont.a(paramInt)) {
          continue;
        }
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", HardCodeUtil.a(2131705498));
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (Exception localException)
      {
        HiBoomItem localHiBoomItem;
        localException.printStackTrace();
        continue;
        if (localHiBoomItem.c != -1) {
          continue;
        }
        localException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", HardCodeUtil.a(2131705488));
        continue;
        localException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", HardCodeUtil.a(2131705493));
        continue;
        i = 0;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "queryInfo hiboomId=" + paramInt + ",json=" + localJSONObject1.toString());
      }
      return localJSONObject1;
      if (!localHiBoomItem.jdField_a_of_type_Boolean) {
        continue;
      }
      localJSONObject2.put("status", 3);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", HardCodeUtil.a(2131705486));
      if (localHiBoomItem.c != -3) {
        continue;
      }
      localJSONObject2.put("canceling", i);
      localJSONObject2.put("progress", localHiBoomItem.c);
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    HiBoomItem localHiBoomItem = a(paramInt);
    localHiBoomItem.c = -3;
    localHiBoomItem.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
    ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).cancelDwonloadItem(5L, "font.hifont.android." + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "updateHiBoomItemProgress id = " + paramInt1 + " progress = " + paramInt2);
    }
    a(paramInt1).c = paramInt2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        localMessage.arg1 = paramInt1;
        localMessage.arg2 = paramInt2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "downloadHiBoomFont id = " + paramInt + " is downloading");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HiBoomItem localHiBoomItem = a(paramInt);
    Object localObject = new File(HiBoomFont.c + localHiBoomItem.jdField_a_of_type_Int + File.separator + "hifont.json");
    if (((File)localObject).exists())
    {
      localObject = FileUtils.a((File)localObject, -1);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            localHiBoomItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
            localHiBoomItem.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("engine");
            localHiBoomItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
            if (!android.text.TextUtils.isEmpty(localHiBoomItem.jdField_b_of_type_JavaLangString)) {
              localHiBoomItem.jdField_b_of_type_JavaLangString = localHiBoomItem.jdField_b_of_type_JavaLangString.toLowerCase();
            }
            localHiBoomItem.jdField_a_of_type_Boolean = HiBoomFont.a(paramInt);
            if (!localHiBoomItem.jdField_a_of_type_Boolean)
            {
              localObject = new File(HiBoomFont.c + localHiBoomItem.jdField_a_of_type_Int + File.separator + "panelImg.png");
              if (((File)localObject).exists()) {
                localHiBoomItem.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(((File)localObject).getAbsolutePath(), null);
              }
            }
            else
            {
              if (paramBoolean3)
              {
                localObject = new File(HiBoomFont.c + paramInt + File.separator + "aiodbclick.png");
                if (!((File)localObject).exists()) {
                  break label450;
                }
                localHiBoomItem.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a(((File)localObject).getAbsolutePath(), null);
              }
              localHiBoomItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              if (paramBoolean2) {
                a();
              }
              if ((!paramBoolean3) || (this.jdField_b_of_type_AndroidOsHandler == null)) {
                break;
              }
              localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(19);
              ((Message)localObject).obj = localHiBoomItem.jdField_b_of_type_AndroidGraphicsBitmap;
              this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " preview not exists");
            }
            if (!paramBoolean1) {
              continue;
            }
            b(localHiBoomItem.jdField_a_of_type_Int);
            continue;
            if (!QLog.isColorLevel()) {
              break label488;
            }
          }
          catch (Exception localException)
          {
            QLog.e("HiBoomFont.HiBoomManager", 1, "loadHiBoomConfig: " + Log.getStackTraceString(localException));
            return;
          }
          label450:
          QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " aio preview not exists");
          label488:
          if (paramBoolean1) {
            b(localException.jdField_a_of_type_Int);
          }
        }
      }
    }
    else if (paramBoolean1)
    {
      b(localException.jdField_a_of_type_Int);
    }
  }
  
  public void a(HiBoomManager.LegalJudgeResultLisener paramLegalJudgeResultLisener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$LegalJudgeResultLisener = paramLegalJudgeResultLisener;
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(VipFontUpdate.TGetPosterFontRsp paramTGetPosterFontRsp, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_b_of_type_JavaUtilVector.clear();
    this.jdField_c_of_type_JavaUtilVector.clear();
    Object localObject = paramTGetPosterFontRsp.rpt_using_list.get();
    int i;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList size = " + ((List)localObject).size());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipFontUpdate.TPosterFontInfo localTPosterFontInfo = (VipFontUpdate.TPosterFontInfo)((Iterator)localObject).next();
        i = localTPosterFontInfo.i32_font_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList id = " + i);
        }
        HiBoomItem localHiBoomItem = a(i);
        localHiBoomItem.jdField_a_of_type_Int = i;
        localHiBoomItem.jdField_a_of_type_Long = localTPosterFontInfo.u64_ts.get();
        if (a(localHiBoomItem.jdField_a_of_type_Long)) {
          this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(i));
        } else {
          this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(i));
        }
      }
      Collections.reverse(this.jdField_a_of_type_JavaUtilVector);
    }
    localObject = paramTGetPosterFontRsp.i32_recommend_font_id.get();
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList recommand size = " + ((List)localObject).size());
    }
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i = ((Integer)((Iterator)localObject).next()).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList recommand id = " + i);
        }
        a(i);
        this.jdField_c_of_type_JavaUtilVector.add(Integer.valueOf(i));
      }
    }
    f();
    a();
    if (paramBoolean) {
      FileUtils.a(paramTGetPosterFontRsp.toByteArray(), jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.set(paramBoolean);
  }
  
  public boolean a()
  {
    RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (this.d.get()) && (b());
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "sendHiBoomMessage hiBoomId = " + paramInt1);
    }
    if (paramBaseChatPie == null) {}
    label167:
    for (;;)
    {
      return false;
      if ((paramBaseChatPie.b() != 1008) && (paramBaseChatPie.b() != 7200)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label167;
        }
        localObject = a(paramString);
        if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (((String)localObject).length() > 20) {
          break label377;
        }
        if (!com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject)) {
          break label169;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("HiBoom_CHN_Tips", false)) {
          break;
        }
        QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705490), 0).a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
        return false;
      }
    }
    label169:
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt1;
    localHiBoomMessage.text = ((String)localObject);
    localHiBoomMessage.type = paramInt2;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHiBoomMessage, null);
    Object localObject = "99";
    switch (a(paramInt1).a())
    {
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "HighFont", "Send", "", 1, 0, 0, "", "" + paramInt1, (String)localObject);
      localObject = new ChatActivityFacade.SendMsgParams();
      paramBaseChatPie.a((ChatActivityFacade.SendMsgParams)localObject);
      ((ChatActivityFacade.SendMsgParams)localObject).i = paramBaseChatPie.E;
      paramBaseChatPie.E = false;
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (QWalletAIOLifeCycleHelper)paramBaseChatPie.a(27);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.a(paramString, (ChatActivityFacade.SendMsgParams)localObject, 0);
        }
      }
      return true;
      localObject = "2";
      continue;
      localObject = "3";
      continue;
      localObject = "1";
    }
    label377:
    QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体不能超过20字", 0).a();
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      if (jdField_a_of_type_Boolean) {
        e();
      }
    }
    else {
      return;
    }
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int j = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str = "" + paramInt1;
    int i;
    if (paramInt2 == 0)
    {
      ??? = "0";
      VasWebviewUtil.reportCommercialDrainage((String)localObject2, "HighFont", "ClickDown", "", 1, 0, 0, "", str, (String)???);
      ??? = a(paramInt1);
      ((HiBoomItem)???).jdField_b_of_type_Boolean = false;
      if (paramInt2 != 0) {
        break label267;
      }
      i = 100;
      label87:
      ((HiBoomItem)???).c = i;
      if (paramInt2 != 0) {
        break label272;
      }
      ((HiBoomItem)???).jdField_a_of_type_Boolean = bool;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
          ((Message)localObject2).arg1 = paramInt1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        }
        localObject2 = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
          if ((!((String)localObject2).equals("0")) && (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
          {
            ??? = new Bundle();
            ((Bundle)???).putString("callbackId", (String)localObject2);
            ((Bundle)???).putInt("srcType", 2);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
            long l = paramInt1;
            if (paramInt2 != 0) {
              break label286;
            }
            paramInt1 = j;
            ((IPCDownloadListener)localObject2).a(l, paramInt1, (Bundle)???);
          }
        }
        return;
        ??? = "1";
        break;
        label267:
        i = -1;
        break label87;
        label272:
        bool = false;
      }
      label286:
      paramInt1 = -1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    if (paramBoolean) {
      a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$LegalJudgeResultLisener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$LegalJudgeResultLisener.a(paramBoolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "getHiBoomListFromLocal");
    }
    byte[] arrayOfByte = FileUtils.a(jdField_a_of_type_JavaLangString);
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp;
    if (arrayOfByte != null) {
      localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    }
    try
    {
      localTGetPosterFontRsp.mergeFrom(arrayOfByte);
      a(localTGetPosterFontRsp, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("HiBoomFont.HiBoomManager", 1, "getHiBoomListFromLocal error: " + Log.getStackTraceString(localException));
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$LegalJudgeResultLisener = null;
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager
 * JD-Core Version:    0.7.0.1
 */