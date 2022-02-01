package com.tencent.mobileqq.hiboom.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFont.HiBoomFontDownloader;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.hiboom.api.IBaseChatPieAdapter;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.hiboom.api.LegalJudgeResultLisener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IPCDownloadListener;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;

public class HiBoomManagerImpl
  implements IHiBoomManager, Manager
{
  public static final String a;
  private static boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public AppInterface a;
  LegalJudgeResultLisener jdField_a_of_type_ComTencentMobileqqHiboomApiLegalJudgeResultLisener = null;
  private IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Vector<Integer> jdField_a_of_type_JavaUtilVector = new Vector();
  public ConcurrentHashMap<Integer, HiBoomItem> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private Vector<Integer> jdField_b_of_type_JavaUtilVector = new Vector();
  ConcurrentHashMap<Integer, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Vector<Integer> c = new Vector();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("hiboom_list_cache");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public HiBoomManagerImpl()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void a()
  {
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    ArrayList localArrayList = new ArrayList();
    int i = 2000;
    while (i < 2005)
    {
      VipFontUpdate.TPosterFontInfo localTPosterFontInfo = new VipFontUpdate.TPosterFontInfo();
      localTPosterFontInfo.i32_font_id.set(i);
      long l;
      if (i % 2 == 0) {
        l = System.currentTimeMillis() / 1000L + 86400L;
      } else {
        l = System.currentTimeMillis() / 1000L - i;
      }
      localTPosterFontInfo.u64_ts.set(l);
      localArrayList.add(localTPosterFontInfo);
      i += 1;
    }
    localTGetPosterFontRsp.rpt_using_list.set(localArrayList);
    parseHiBoomList(localTGetPosterFontRsp, true);
  }
  
  private void a(int paramInt)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("font.hiFontQQ.json.");
    localStringBuilder.append(paramInt);
    localIVasQuickUpdateService.downloadItem(5L, localStringBuilder.toString(), "HiBoomManager");
  }
  
  private void a(IBaseChatPieAdapter paramIBaseChatPieAdapter, String paramString)
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).handleHiBoomMsg(paramIBaseChatPieAdapter, paramString);
  }
  
  private static boolean a(long paramLong)
  {
    return NetConnInfoCenter.getServerTime() > paramLong;
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      HiBoomItem localHiBoomItem = (HiBoomItem)localIterator.next();
      if (!localHiBoomItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        loadHiBoomConfig(localHiBoomItem.jdField_a_of_type_Int, true, false, false);
      }
    }
  }
  
  public void downloadHiBoomFont(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("downloadHiBoomFont id = ");
        paramString.append(paramInt);
        paramString.append(" is downloading");
        QLog.d("HiBoomFont.HiBoomManager", 2, paramString.toString());
      }
    }
    else
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
      HiBoomConstants.jdField_b_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(paramInt);
    }
  }
  
  public Object getHandlerLock()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public HiBoomItem getHiBoomItemById(int paramInt)
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
  
  public void getHiBoomListFromLocal()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "getHiBoomListFromLocal");
    }
    byte[] arrayOfByte = FileUtils.readFile(jdField_a_of_type_JavaLangString);
    if (arrayOfByte != null)
    {
      Object localObject = new VipFontUpdate.TGetPosterFontRsp();
      try
      {
        ((VipFontUpdate.TGetPosterFontRsp)localObject).mergeFrom(arrayOfByte);
        parseHiBoomList((VipFontUpdate.TGetPosterFontRsp)localObject, false);
        return;
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHiBoomListFromLocal error: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(localException));
        QLog.e("HiBoomFont.HiBoomManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void getHiBoomListFromServer()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      if (jdField_a_of_type_Boolean)
      {
        a();
        return;
      }
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).b();
    }
  }
  
  public Vector<Integer> getInvalidHiBoomList()
  {
    return this.jdField_b_of_type_JavaUtilVector;
  }
  
  public Vector<Integer> getRecommandHiBoomList()
  {
    return this.c;
  }
  
  public Vector<Integer> getValidHiBoomList()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void invalidateHiBoomPanel()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public boolean isHiBoomEnable()
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getRichTextChatConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    return (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (isMemorySupport());
  }
  
  public boolean isHiBoomListInit()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean isMemorySupport()
  {
    long l = Runtime.getRuntime().maxMemory();
    boolean bool;
    if (l > 134217728L) {
      bool = true;
    } else {
      bool = false;
    }
    if ((QLog.isColorLevel()) || (!bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isMemorySupport: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" maxHeap=");
      localStringBuilder.append(l);
      QLog.d("HiBoomFont.HiBoomManager", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void loadHiBoomConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HiBoomItem localHiBoomItem = getHiBoomItemById(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HiBoomFont.c);
    ((StringBuilder)localObject).append(localHiBoomItem.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("hifont.json");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      localObject = FileUtils.readFileToStringEx((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          localHiBoomItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
          localHiBoomItem.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("engine");
          localHiBoomItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
          if (!TextUtils.isEmpty(localHiBoomItem.jdField_b_of_type_JavaLangString)) {
            localHiBoomItem.jdField_b_of_type_JavaLangString = localHiBoomItem.jdField_b_of_type_JavaLangString.toLowerCase();
          }
          localHiBoomItem.jdField_a_of_type_Boolean = HiBoomFont.a(paramInt);
          boolean bool = localHiBoomItem.jdField_a_of_type_Boolean;
          if (!bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HiBoomFont.c);
            ((StringBuilder)localObject).append(localHiBoomItem.jdField_a_of_type_Int);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append("panelImg.png");
            localObject = new File(((StringBuilder)localObject).toString());
            if (((File)localObject).exists())
            {
              localHiBoomItem.jdField_a_of_type_AndroidGraphicsBitmap = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).decodeFileWithBufferedStream(((File)localObject).getAbsolutePath(), null);
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("loadHiBoomConfig id = ");
                ((StringBuilder)localObject).append(paramInt);
                ((StringBuilder)localObject).append(" preview not exists");
                QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject).toString());
              }
              if (paramBoolean1) {
                a(localHiBoomItem.jdField_a_of_type_Int);
              }
            }
          }
          if (paramBoolean3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HiBoomFont.c);
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append("aiodbclick.png");
            localObject = new File(((StringBuilder)localObject).toString());
            if (((File)localObject).exists())
            {
              localHiBoomItem.jdField_b_of_type_AndroidGraphicsBitmap = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).decodeFileWithBufferedStream(((File)localObject).getAbsolutePath(), null);
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("loadHiBoomConfig id = ");
                ((StringBuilder)localObject).append(paramInt);
                ((StringBuilder)localObject).append(" aio preview not exists");
                QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject).toString());
              }
              if (paramBoolean1) {
                a(localHiBoomItem.jdField_a_of_type_Int);
              }
            }
          }
          localHiBoomItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          if (paramBoolean2) {
            invalidateHiBoomPanel();
          }
          if ((!paramBoolean3) || (this.jdField_b_of_type_AndroidOsHandler == null)) {
            return;
          }
          localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getInvalidateHiBoomPreviewType());
          ((Message)localObject).obj = localHiBoomItem.jdField_b_of_type_AndroidGraphicsBitmap;
          this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
          return;
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadHiBoomConfig: ");
          ((StringBuilder)localObject).append(Log.getStackTraceString(localException));
          QLog.e("HiBoomFont.HiBoomManager", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    else if (paramBoolean1)
    {
      a(localException.jdField_a_of_type_Int);
    }
  }
  
  public void onAIODestroy()
  {
    ??? = this.jdField_a_of_type_AndroidOsHandler;
    if (??? != null)
    {
      ((Handler)???).removeCallbacksAndMessages(null);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomApiLegalJudgeResultLisener = null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramAppRuntime);
    HiBoomConstants.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void onDestroy() {}
  
  public void onDirtywordFilterResult(boolean paramBoolean)
  {
    HiBoomConstants.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    if (paramBoolean) {
      invalidateHiBoomPanel();
    }
    LegalJudgeResultLisener localLegalJudgeResultLisener = this.jdField_a_of_type_ComTencentMobileqqHiboomApiLegalJudgeResultLisener;
    if (localLegalJudgeResultLisener != null) {
      localLegalJudgeResultLisener.b(paramBoolean);
    }
  }
  
  public void onHiBoomItemDownloaded(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("");
    ((StringBuilder)???).append(paramInt1);
    String str = ((StringBuilder)???).toString();
    if (paramInt2 == 0) {
      ??? = "0";
    } else {
      ??? = "1";
    }
    VasWebviewUtil.a((String)localObject2, "HighFont", "ClickDown", "", 1, 0, 0, "", str, (String)???);
    ??? = getHiBoomItemById(paramInt1);
    int j = 0;
    ((HiBoomItem)???).jdField_b_of_type_Boolean = false;
    int i;
    if (paramInt2 == 0) {
      i = 100;
    } else {
      i = -1;
    }
    ((HiBoomItem)???).c = i;
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((HiBoomItem)???).jdField_a_of_type_Boolean = bool;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        ((Message)localObject2).arg1 = paramInt1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      }
      ??? = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
        if ((!((String)???).equals("0")) && (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("callbackId", (String)???);
          ??? = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).putSrcType((Bundle)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
          long l = paramInt1;
          if (paramInt2 == 0) {
            paramInt1 = j;
          } else {
            paramInt1 = -1;
          }
          ((IPCDownloadListener)localObject2).a(l, paramInt1, (Bundle)???);
        }
      }
      return;
    }
  }
  
  public void parseHiBoomList(VipFontUpdate.TGetPosterFontRsp paramTGetPosterFontRsp, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_b_of_type_JavaUtilVector.clear();
    this.c.clear();
    Object localObject1 = paramTGetPosterFontRsp.rpt_using_list.get();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseHiBoomList size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (VipFontUpdate.TPosterFontInfo)((Iterator)localObject1).next();
        i = ((VipFontUpdate.TPosterFontInfo)localObject2).i32_font_id.get();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("parseHiBoomList id = ");
          ((StringBuilder)localObject3).append(i);
          QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject3).toString());
        }
        Object localObject3 = getHiBoomItemById(i);
        ((HiBoomItem)localObject3).jdField_a_of_type_Int = i;
        ((HiBoomItem)localObject3).jdField_a_of_type_Long = ((VipFontUpdate.TPosterFontInfo)localObject2).u64_ts.get();
        if (a(((HiBoomItem)localObject3).jdField_a_of_type_Long)) {
          this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(i));
        } else {
          this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(i));
        }
      }
      Collections.reverse(this.jdField_a_of_type_JavaUtilVector);
    }
    localObject1 = paramTGetPosterFontRsp.i32_recommend_font_id.get();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseHiBoomList recommand size = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseHiBoomList recommand id = ");
          ((StringBuilder)localObject2).append(i);
          QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject2).toString());
        }
        getHiBoomItemById(i);
        this.c.add(Integer.valueOf(i));
      }
    }
    b();
    invalidateHiBoomPanel();
    if (paramBoolean) {
      FileUtils.writeFile(paramTGetPosterFontRsp.toByteArray(), jdField_a_of_type_JavaLangString);
    }
  }
  
  public JSONObject queryDownloadInfo(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      HiBoomItem localHiBoomItem = getHiBoomItemById(paramInt);
      boolean bool = HiBoomFont.a(paramInt);
      int i = 0;
      if (bool)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", HardCodeUtil.a(2131705571));
      }
      else
      {
        if (localHiBoomItem.jdField_a_of_type_Boolean)
        {
          localJSONObject2.put("status", 3);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131705559));
        }
        else if (localHiBoomItem.c == -1)
        {
          localJSONObject2.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", HardCodeUtil.a(2131705561));
        }
        else
        {
          localJSONObject2.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131705566));
        }
        if (localHiBoomItem.c == -3) {
          i = 1;
        }
        localJSONObject2.put("canceling", i);
        localJSONObject2.put("progress", localHiBoomItem.c);
      }
      localJSONObject2.put("id", paramInt);
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryInfo hiboomId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",json=");
      localStringBuilder.append(localJSONObject1.toString());
      QLog.d("HiBoomFont.HiBoomManager", 2, localStringBuilder.toString());
    }
    return localJSONObject1;
  }
  
  public void registerIPCDownloadListener(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public boolean sendHiBoomMessage(IBaseChatPieAdapter paramIBaseChatPieAdapter, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendHiBoomMessage hiBoomId = ");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramIBaseChatPieAdapter == null) {
      return false;
    }
    int i;
    if ((paramIBaseChatPieAdapter.a() != 1008) && (paramIBaseChatPieAdapter.a() != 7200)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = HiBoomConstants.a(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      if (((String)localObject1).length() <= 20)
      {
        if (((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).hasSysEmotion((String)localObject1))
        {
          if (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().getBoolean("HiBoom_CHN_Tips", false))
          {
            QQToast.a(paramIBaseChatPieAdapter.a(), HardCodeUtil.a(2131705563), 0).a();
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
          }
          return false;
        }
        Object localObject2 = new HiBoomMessage();
        ((HiBoomMessage)localObject2).id = paramInt1;
        ((HiBoomMessage)localObject2).text = ((String)localObject1);
        ((HiBoomMessage)localObject2).type = paramInt2;
        ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).sendHiBoomMessage(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramIBaseChatPieAdapter.a(), (HiBoomMessage)localObject2, null);
        paramInt2 = getHiBoomItemById(paramInt1).a();
        if (paramInt2 != 0) {
          if (paramInt2 != 1) {
            if (paramInt2 != 2) {
              localObject1 = "99";
            }
          }
        }
        for (;;)
        {
          break;
          localObject1 = "3";
          continue;
          localObject1 = "2";
          continue;
          localObject1 = "1";
        }
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt1);
        VasWebviewUtil.a((String)localObject2, "HighFont", "Send", "", 1, 0, 0, "", localStringBuilder.toString(), (String)localObject1);
        a(paramIBaseChatPieAdapter, paramString);
        return true;
      }
      QQToast.a(paramIBaseChatPieAdapter.a(), "嗨爆字体不能超过20字", 0).a();
    }
    return false;
  }
  
  public void setAIOPreviewHandler(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setIsHiBoomListInit(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public void setLegalJugeResultLisener(LegalJudgeResultLisener paramLegalJudgeResultLisener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomApiLegalJudgeResultLisener = paramLegalJudgeResultLisener;
  }
  
  public void setListUIHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void stopDownloadHiBoomFont(int paramInt)
  {
    Object localObject = getHiBoomItemById(paramInt);
    ((HiBoomItem)localObject).c = -3;
    ((HiBoomItem)localObject).jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
    localObject = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("font.hifont.android.");
    localStringBuilder.append(paramInt);
    ((IVasQuickUpdateService)localObject).cancelDwonloadItem(5L, localStringBuilder.toString());
  }
  
  public void updateHiBoomItemProgress(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("updateHiBoomItemProgress id = ");
      ((StringBuilder)???).append(paramInt1);
      ((StringBuilder)???).append(" progress = ");
      ((StringBuilder)???).append(paramInt2);
      QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)???).toString());
    }
    getHiBoomItemById(paramInt1).c = paramInt2;
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
  
  public void updateHiBoomSwitch(boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.api.impl.HiBoomManagerImpl
 * JD-Core Version:    0.7.0.1
 */