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
  private static boolean n = false;
  public ConcurrentHashMap<Integer, HiBoomItem> b = new ConcurrentHashMap();
  public AppInterface c;
  LegalJudgeResultLisener d = null;
  ConcurrentHashMap<Integer, String> e = new ConcurrentHashMap();
  private Vector<Integer> f = new Vector();
  private Vector<Integer> g = new Vector();
  private Vector<Integer> h = new Vector();
  private AtomicBoolean i = new AtomicBoolean(false);
  private final Object j = new Object();
  private Handler k;
  private Handler l;
  private AtomicBoolean m = new AtomicBoolean(false);
  private IPCDownloadListener o;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("hiboom_list_cache");
    a = localStringBuilder.toString();
  }
  
  private void a()
  {
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    ArrayList localArrayList = new ArrayList();
    int i1 = 2000;
    while (i1 < 2005)
    {
      VipFontUpdate.TPosterFontInfo localTPosterFontInfo = new VipFontUpdate.TPosterFontInfo();
      localTPosterFontInfo.i32_font_id.set(i1);
      long l1;
      if (i1 % 2 == 0) {
        l1 = System.currentTimeMillis() / 1000L + 86400L;
      } else {
        l1 = System.currentTimeMillis() / 1000L - i1;
      }
      localTPosterFontInfo.u64_ts.set(l1);
      localArrayList.add(localTPosterFontInfo);
      i1 += 1;
    }
    localTGetPosterFontRsp.rpt_using_list.set(localArrayList);
    parseHiBoomList(localTGetPosterFontRsp, true);
  }
  
  private void a(int paramInt)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.c.getRuntimeService(IVasQuickUpdateService.class, "");
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
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      HiBoomItem localHiBoomItem = (HiBoomItem)localIterator.next();
      if (!localHiBoomItem.i.get()) {
        loadHiBoomConfig(localHiBoomItem.a, true, false, false);
      }
    }
  }
  
  public void downloadHiBoomFont(int paramInt, String paramString)
  {
    if (this.e.containsKey(Integer.valueOf(paramInt)))
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
      this.e.put(Integer.valueOf(paramInt), paramString);
      HiBoomConstants.e.a(paramInt);
    }
  }
  
  public Object getHandlerLock()
  {
    return this.j;
  }
  
  public HiBoomItem getHiBoomItemById(int paramInt)
  {
    try
    {
      HiBoomItem localHiBoomItem2 = (HiBoomItem)this.b.get(Integer.valueOf(paramInt));
      HiBoomItem localHiBoomItem1 = localHiBoomItem2;
      if (localHiBoomItem2 == null)
      {
        localHiBoomItem1 = new HiBoomItem();
        localHiBoomItem1.a = paramInt;
        this.b.put(Integer.valueOf(paramInt), localHiBoomItem1);
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
    byte[] arrayOfByte = FileUtils.readFile(a);
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
    if (this.i.compareAndSet(false, true))
    {
      if (n)
      {
        a();
        return;
      }
      ((ISVIPHandler)this.c.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).c();
    }
  }
  
  public Vector<Integer> getInvalidHiBoomList()
  {
    return this.g;
  }
  
  public Vector<Integer> getRecommandHiBoomList()
  {
    return this.h;
  }
  
  public Vector<Integer> getValidHiBoomList()
  {
    return this.f;
  }
  
  public void invalidateHiBoomPanel()
  {
    synchronized (this.j)
    {
      if (this.k != null) {
        this.k.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public boolean isHiBoomEnable()
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getRichTextChatConfig(this.c);
    return (this.m.get()) && (isMemorySupport());
  }
  
  public boolean isHiBoomListInit()
  {
    return this.i.get();
  }
  
  public boolean isMemorySupport()
  {
    long l1 = Runtime.getRuntime().maxMemory();
    boolean bool;
    if (l1 > 134217728L) {
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
      localStringBuilder.append(l1);
      QLog.d("HiBoomFont.HiBoomManager", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void loadHiBoomConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HiBoomItem localHiBoomItem = getHiBoomItemById(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HiBoomFont.g);
    ((StringBuilder)localObject).append(localHiBoomItem.a);
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
          localHiBoomItem.b = ((JSONObject)localObject).optString("name");
          localHiBoomItem.c = ((JSONObject)localObject).optInt("engine");
          localHiBoomItem.e = ((JSONObject)localObject).optString("tag");
          if (!TextUtils.isEmpty(localHiBoomItem.e)) {
            localHiBoomItem.e = localHiBoomItem.e.toLowerCase();
          }
          localHiBoomItem.f = HiBoomFont.a(paramInt);
          boolean bool = localHiBoomItem.f;
          if (!bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HiBoomFont.g);
            ((StringBuilder)localObject).append(localHiBoomItem.a);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append("panelImg.png");
            localObject = new File(((StringBuilder)localObject).toString());
            if (((File)localObject).exists())
            {
              localHiBoomItem.g = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).decodeFileWithBufferedStream(((File)localObject).getAbsolutePath(), null);
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
                a(localHiBoomItem.a);
              }
            }
          }
          if (paramBoolean3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HiBoomFont.g);
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append("aiodbclick.png");
            localObject = new File(((StringBuilder)localObject).toString());
            if (((File)localObject).exists())
            {
              localHiBoomItem.h = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).decodeFileWithBufferedStream(((File)localObject).getAbsolutePath(), null);
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
                a(localHiBoomItem.a);
              }
            }
          }
          localHiBoomItem.i.set(true);
          if (paramBoolean2) {
            invalidateHiBoomPanel();
          }
          if ((!paramBoolean3) || (this.l == null)) {
            return;
          }
          localObject = this.l.obtainMessage(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getInvalidateHiBoomPreviewType());
          ((Message)localObject).obj = localHiBoomItem.h;
          this.l.sendMessage((Message)localObject);
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
      a(localException.a);
    }
  }
  
  public void onAIODestroy()
  {
    ??? = this.k;
    if (??? != null)
    {
      ((Handler)???).removeCallbacksAndMessages(null);
      synchronized (this.j)
      {
        this.k = null;
      }
    }
    this.d = null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.c = ((AppInterface)paramAppRuntime);
    HiBoomConstants.b.set(false);
  }
  
  public void onDestroy() {}
  
  public void onDirtywordFilterResult(boolean paramBoolean)
  {
    HiBoomConstants.c.set(paramBoolean);
    if (paramBoolean) {
      invalidateHiBoomPanel();
    }
    LegalJudgeResultLisener localLegalJudgeResultLisener = this.d;
    if (localLegalJudgeResultLisener != null) {
      localLegalJudgeResultLisener.b(paramBoolean);
    }
  }
  
  public void onHiBoomItemDownloaded(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.c.getCurrentUin();
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
    int i2 = 0;
    ((HiBoomItem)???).k = false;
    int i1;
    if (paramInt2 == 0) {
      i1 = 100;
    } else {
      i1 = -1;
    }
    ((HiBoomItem)???).j = i1;
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((HiBoomItem)???).f = bool;
    synchronized (this.j)
    {
      if (this.k != null)
      {
        localObject2 = this.k.obtainMessage(3);
        ((Message)localObject2).arg1 = paramInt1;
        this.k.sendMessage((Message)localObject2);
      }
      ??? = (String)this.e.get(Integer.valueOf(paramInt1));
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        this.e.remove(Integer.valueOf(paramInt1));
        if ((!((String)???).equals("0")) && (this.o != null))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("callbackId", (String)???);
          ??? = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).putSrcType((Bundle)localObject2);
          localObject2 = this.o;
          long l1 = paramInt1;
          if (paramInt2 == 0) {
            paramInt1 = i2;
          } else {
            paramInt1 = -1;
          }
          ((IPCDownloadListener)localObject2).a(l1, paramInt1, (Bundle)???);
        }
      }
      return;
    }
  }
  
  public void parseHiBoomList(VipFontUpdate.TGetPosterFontRsp paramTGetPosterFontRsp, boolean paramBoolean)
  {
    this.f.clear();
    this.g.clear();
    this.h.clear();
    Object localObject1 = paramTGetPosterFontRsp.rpt_using_list.get();
    Object localObject2;
    int i1;
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
        i1 = ((VipFontUpdate.TPosterFontInfo)localObject2).i32_font_id.get();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("parseHiBoomList id = ");
          ((StringBuilder)localObject3).append(i1);
          QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject3).toString());
        }
        Object localObject3 = getHiBoomItemById(i1);
        ((HiBoomItem)localObject3).a = i1;
        ((HiBoomItem)localObject3).d = ((VipFontUpdate.TPosterFontInfo)localObject2).u64_ts.get();
        if (a(((HiBoomItem)localObject3).d)) {
          this.g.add(Integer.valueOf(i1));
        } else {
          this.f.add(Integer.valueOf(i1));
        }
      }
      Collections.reverse(this.f);
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
        i1 = ((Integer)((Iterator)localObject1).next()).intValue();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseHiBoomList recommand id = ");
          ((StringBuilder)localObject2).append(i1);
          QLog.d("HiBoomFont.HiBoomManager", 2, ((StringBuilder)localObject2).toString());
        }
        getHiBoomItemById(i1);
        this.h.add(Integer.valueOf(i1));
      }
    }
    b();
    invalidateHiBoomPanel();
    if (paramBoolean) {
      FileUtils.writeFile(paramTGetPosterFontRsp.toByteArray(), a);
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
      int i1 = 0;
      if (bool)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", HardCodeUtil.a(2131903457));
      }
      else
      {
        if (localHiBoomItem.f)
        {
          localJSONObject2.put("status", 3);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131903446));
        }
        else if (localHiBoomItem.j == -1)
        {
          localJSONObject2.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", HardCodeUtil.a(2131903448));
        }
        else
        {
          localJSONObject2.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131903453));
        }
        if (localHiBoomItem.j == -3) {
          i1 = 1;
        }
        localJSONObject2.put("canceling", i1);
        localJSONObject2.put("progress", localHiBoomItem.j);
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
    this.o = paramIPCDownloadListener;
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
    int i1;
    if ((paramIBaseChatPieAdapter.g() != 1008) && (paramIBaseChatPieAdapter.g() != 7200)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      localObject1 = HiBoomConstants.a(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      if (((String)localObject1).length() <= 20)
      {
        if (((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).hasSysEmotion((String)localObject1))
        {
          if (!this.c.getPreferences().getBoolean("HiBoom_CHN_Tips", false))
          {
            QQToast.makeText(paramIBaseChatPieAdapter.c(), HardCodeUtil.a(2131903450), 0).show();
            this.c.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
          }
          return false;
        }
        Object localObject2 = new HiBoomMessage();
        ((HiBoomMessage)localObject2).id = paramInt1;
        ((HiBoomMessage)localObject2).text = ((String)localObject1);
        ((HiBoomMessage)localObject2).type = paramInt2;
        ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).sendHiBoomMessage(this.c, paramIBaseChatPieAdapter.e(), (HiBoomMessage)localObject2, null);
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
        localObject2 = this.c.getCurrentUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt1);
        VasWebviewUtil.a((String)localObject2, "HighFont", "Send", "", 1, 0, 0, "", localStringBuilder.toString(), (String)localObject1);
        a(paramIBaseChatPieAdapter, paramString);
        return true;
      }
      QQToast.makeText(paramIBaseChatPieAdapter.c(), "嗨爆字体不能超过20字", 0).show();
    }
    return false;
  }
  
  public void setAIOPreviewHandler(Handler paramHandler)
  {
    this.l = paramHandler;
  }
  
  public void setIsHiBoomListInit(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
  }
  
  public void setLegalJugeResultLisener(LegalJudgeResultLisener paramLegalJudgeResultLisener)
  {
    this.d = paramLegalJudgeResultLisener;
  }
  
  public void setListUIHandler(Handler paramHandler)
  {
    this.k = paramHandler;
  }
  
  public void stopDownloadHiBoomFont(int paramInt)
  {
    Object localObject = getHiBoomItemById(paramInt);
    ((HiBoomItem)localObject).j = -3;
    ((HiBoomItem)localObject).k = false;
    if (this.e.containsKey(Integer.valueOf(paramInt))) {
      this.e.remove(Integer.valueOf(paramInt));
    }
    localObject = (IVasQuickUpdateService)this.c.getRuntimeService(IVasQuickUpdateService.class, "");
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
    getHiBoomItemById(paramInt1).j = paramInt2;
    synchronized (this.j)
    {
      if (this.k != null)
      {
        Message localMessage = this.k.obtainMessage(2);
        localMessage.arg1 = paramInt1;
        localMessage.arg2 = paramInt2;
        this.k.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void updateHiBoomSwitch(boolean paramBoolean)
  {
    this.m.set(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.api.impl.HiBoomManagerImpl
 * JD-Core Version:    0.7.0.1
 */