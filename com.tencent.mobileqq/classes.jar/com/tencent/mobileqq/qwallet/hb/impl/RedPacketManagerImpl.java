package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetSkinListReq;
import Wallet.RedPackGrapInfo;
import Wallet.SetSelectedSkinReq;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetAvailableListListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.hb.theme.ThemeRedPkgConfig;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgRecord;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class RedPacketManagerImpl
  implements IRedPacketManager
{
  public static List<PanelData> CURRENT_PANEL_DATA = new ArrayList();
  static HashMap<Integer, PanelData> DEFAULT_PANEL_DATA;
  static final int TYPE_GRAP_HISTORY = 100;
  static final int TYPE_GROUP_NO_GRAP_REDPKG = 101;
  static final int TYPE_H5 = 102;
  private static byte[] lock = new byte[0];
  String TAG = "RedPacketManager";
  protected BusinessObserver mObserver = new RedPacketManagerImpl.8(this);
  protected HashMap<String, IRedPacket.OnGetAvailableListListener> mReqGroupAvailableListListeners;
  private List<BusinessObserver> observers = new ArrayList();
  private HashMap<String, JSONObject> popAdCache;
  private HashMap<String, JSONObject> tailCache;
  
  static
  {
    DEFAULT_PANEL_DATA = new HashMap();
    DEFAULT_PANEL_DATA.put(Integer.valueOf(0), new PanelData("", 0, HardCodeUtil.a(R.string.cj), "1102", "", "#5B6175"));
    DEFAULT_PANEL_DATA.put(Integer.valueOf(1), new PanelData("", 1, HardCodeUtil.a(R.string.ct), "1101", "", "#5B6175"));
  }
  
  public static String genCacheKeyBySkin(int paramInt1, int paramInt2)
  {
    Object localObject1 = "";
    if (paramInt1 != -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("f_");
      ((StringBuilder)localObject1).append(paramInt1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (paramInt2 != -1)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("_");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("s_");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    return localObject2;
  }
  
  public static String[] genMatchKeys(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("f_");
    ((StringBuilder)localObject1).append(paramInt1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("s_");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject2);
    return new String[] { localStringBuilder.toString(), localObject1, localObject2 };
  }
  
  public static int getEnterType(int paramInt)
  {
    Iterator localIterator = TYPEHBINFOMAP.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger1 = (Integer)localIterator.next();
      Integer localInteger2 = (Integer)TYPEHBINFOMAP.get(localInteger1);
      if ((localInteger2 != null) && (localInteger2.intValue() == paramInt)) {
        return localInteger1.intValue();
      }
    }
    return 1;
  }
  
  public static JSONObject getHbPannelConfig(int paramInt)
  {
    Object localObject1 = QWalletTools.a();
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "");
      JSONArray localJSONArray = localIQWalletConfigService.getArray("redPackPanel", new String[] { "panelRedPkgList" });
      localObject1 = localIQWalletConfigService;
      localObject2 = localObject3;
      if (localJSONArray != null)
      {
        localObject1 = localIQWalletConfigService;
        localObject2 = localObject3;
        if (localJSONArray.length() > 0)
        {
          localObject1 = null;
          int i = 0;
          while (i < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(i);
            if ((localObject2 != null) && (((JSONObject)localObject2).optInt("type", -1) == paramInt)) {
              localObject1 = ((JSONObject)localObject2).optJSONObject("params");
            }
            i += 1;
          }
          localObject2 = localObject1;
          localObject1 = localIQWalletConfigService;
        }
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject3;
    }
    if ((localObject2 == null) && (localObject1 != null)) {
      ((IQWalletConfigService)localObject1).getAllConfig(0);
    }
    return localObject2;
  }
  
  public static boolean isBulletinValidDate(String paramString1, String paramString2)
  {
    long l1 = QWalletTools.b(paramString1);
    long l2 = QWalletTools.b(paramString2);
    if ((l1 != -1L) && (l2 != -1L) && (l1 < l2))
    {
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if ((l3 >= l1) && (l3 <= l2)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isGroupSession(int paramInt)
  {
    if (paramInt != 1) {
      return paramInt == 3000;
    }
    return true;
  }
  
  private boolean isGroupTab(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean verifyDrawHbParams(PanelData paramPanelData)
  {
    if ((paramPanelData != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      if ((paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subjects") != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subjects").length() > 0)) {
        return true;
      }
      paramPanelData = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("modelList");
      if (paramPanelData != null)
      {
        int i = 0;
        while (i < paramPanelData.length())
        {
          Object localObject = paramPanelData.optJSONObject(i);
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONArray("subjects");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
              return true;
            }
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean verifyEmojiHbParams(PanelData paramPanelData)
  {
    return (paramPanelData != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList") != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList").length() != 0);
  }
  
  public static boolean verifyKuaKuaHbParams(PanelData paramPanelData)
  {
    if ((paramPanelData != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      paramPanelData = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subjectList");
      if ((paramPanelData != null) && (paramPanelData.length() > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean verifyLingBySession(BaseSessionInfo paramBaseSessionInfo)
  {
    return (paramBaseSessionInfo == null) || (!((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatActivityUtil$isTempConv(paramBaseSessionInfo));
  }
  
  public static boolean verifyLuckBySession(BaseSessionInfo paramBaseSessionInfo)
  {
    return (paramBaseSessionInfo == null) || (isGroupSession(paramBaseSessionInfo.jdField_a_of_type_Int));
  }
  
  public static boolean verifyShengpiziHbParams(PanelData paramPanelData)
  {
    if ((paramPanelData != null) && (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      if (!TextUtils.isEmpty(paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("subject"))) {}
      return true;
    }
    return false;
  }
  
  protected void filterHbHasGrabbed(String paramString1, String paramString2, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, boolean paramBoolean)
  {
    if (paramOnGetAvailableListListener == null) {
      return;
    }
    RedPackGrapInfo localRedPackGrapInfo = null;
    if ((paramGetGroupRedPackListRsp != null) && (paramGetGroupRedPackListRsp.vecRedPackList != null))
    {
      long l = NetConnInfoCenter.getServerTime();
      if ((!paramBoolean) && (l > paramGetGroupRedPackListRsp.lFailureTime))
      {
        paramOnGetAvailableListListener.OnGetAvailableList(null);
        return;
      }
      Object localObject1 = NotifyMsgApiImpl.queryRecordsInMemory(2);
      int i = paramGetGroupRedPackListRsp.vecRedPackList.size() - 1;
      int j;
      while (i >= 0)
      {
        Object localObject2 = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(i);
        if (localObject2 == null)
        {
          paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
        }
        else if ((!paramBoolean) && (((RedPackGrapInfo)localObject2).lCreateTime + 864000L < l))
        {
          paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
        }
        else
        {
          localObject2 = ((RedPackGrapInfo)localObject2).sBiilNo;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (localObject1 != null)
            {
              j = 0;
              while (j < ((ArrayList)localObject1).size())
              {
                NotifyMsgRecord localNotifyMsgRecord = (NotifyMsgRecord)((ArrayList)localObject1).get(j);
                if ((localNotifyMsgRecord != null) && (localNotifyMsgRecord.jdField_a_of_type_JavaLangString != null) && (localNotifyMsgRecord.jdField_a_of_type_JavaLangString.equals(localObject2)))
                {
                  paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
                  break;
                }
                j += 1;
              }
            }
          }
          else {
            paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
          }
        }
        i -= 1;
      }
      paramOnGetAvailableListListener.OnGetAvailableList(paramGetGroupRedPackListRsp.vecRedPackList);
      localObject1 = QWalletTools.a();
      paramOnGetAvailableListListener = localRedPackGrapInfo;
      if (localObject1 != null) {
        paramOnGetAvailableListListener = (IPasswdRedBagService)((BaseQQAppInterface)localObject1).getRuntimeService(IPasswdRedBagService.class);
      }
      if (paramOnGetAvailableListListener != null)
      {
        int k = 0;
        while (k < paramGetGroupRedPackListRsp.vecRedPackList.size())
        {
          localRedPackGrapInfo = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(k);
          if ((localRedPackGrapInfo != null) && (!TextUtils.isEmpty(localRedPackGrapInfo.sBiilNo)) && ((localRedPackGrapInfo.iMsgType == 6) || (localRedPackGrapInfo.iMsgType == 13) || (localRedPackGrapInfo.iMsgType == 15) || (localRedPackGrapInfo.iMsgType == 18) || (localRedPackGrapInfo.iMsgType == 19) || (localRedPackGrapInfo.iMsgType == 21) || (localRedPackGrapInfo.iMsgType == 22) || (localRedPackGrapInfo.iMsgType == 26)) && (paramOnGetAvailableListListener.getPasswdRedBagInfoById(localRedPackGrapInfo.sBiilNo) == null))
          {
            if (paramInt == 1) {
              j = 1;
            } else if (paramInt == 2) {
              j = 2;
            } else {
              j = 3;
            }
            if ((localRedPackGrapInfo.iMsgType != 13) && (localRedPackGrapInfo.iMsgType != 15))
            {
              if (localRedPackGrapInfo.iMsgType == 18) {
                i = 2;
              } else if (localRedPackGrapInfo.iMsgType == 19) {
                i = 3;
              } else if ((localRedPackGrapInfo.iMsgType != 21) && (localRedPackGrapInfo.iMsgType != 24) && (localRedPackGrapInfo.iMsgType != 25) && (localRedPackGrapInfo.iMsgType != 27))
              {
                if ((localRedPackGrapInfo.iMsgType != 22) && (localRedPackGrapInfo.iMsgType != 26))
                {
                  if (localRedPackGrapInfo.iMsgType == 23) {
                    i = 6;
                  } else if (localRedPackGrapInfo.iMsgType == 28) {
                    i = 7;
                  } else if (localRedPackGrapInfo.iMsgType == 29) {
                    i = 8;
                  } else {
                    i = 0;
                  }
                }
                else {
                  i = 5;
                }
              }
              else {
                i = 4;
              }
            }
            else {
              i = 1;
            }
            paramOnGetAvailableListListener.savePasswdRedBag(localRedPackGrapInfo.sBiilNo, localRedPackGrapInfo.sIndex, localRedPackGrapInfo.sTitle, String.valueOf(localRedPackGrapInfo.lUin), localRedPackGrapInfo.lCreateTime + 90000L, String.valueOf(j), paramString2, localRedPackGrapInfo.sAuthKey, false, false, i);
          }
          k += 1;
        }
      }
      if (paramBoolean) {
        ThreadManager.getFileThreadHandler().post(new RedPacketManagerImpl.7(this, paramGetGroupRedPackListRsp, paramString1, paramString2, paramInt));
      }
      return;
    }
    paramOnGetAvailableListListener.OnGetAvailableList(null);
  }
  
  public List<PanelData> getPanelList(BaseSessionInfo paramBaseSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    try
    {
      Object localObject1 = QWalletTools.a();
      if (localObject1 != null)
      {
        Object localObject2 = (IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "");
        localObject1 = ((IQWalletConfigService)localObject2).getArray("redPackPanel", new String[] { "panelRedPkgList" });
        localObject2 = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#5B6175", new String[] { "themeInfo", "fontColorIcon" });
        if (localObject1 != null)
        {
          int m = 0;
          int j = 0;
          for (;;)
          {
            int k = j;
            i = j;
            try
            {
              if (m >= ((JSONArray)localObject1).length()) {
                break label937;
              }
              k = j;
              Object localObject3 = ((JSONArray)localObject1).getJSONObject(m);
              int n;
              if (localObject3 == null)
              {
                n = j;
              }
              else
              {
                k = j;
                PanelData localPanelData = new PanelData();
                k = j;
                localPanelData.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("id", "");
                k = j;
                localPanelData.jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("type", -1);
                k = j;
                localPanelData.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("name", "");
                k = j;
                localPanelData.jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).optString("icon_pic", "");
                k = j;
                localPanelData.jdField_e_of_type_JavaLangString = ((String)localObject2);
                k = j;
                localPanelData.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject3).optJSONObject("params");
                k = j;
                if (QLog.isColorLevel())
                {
                  k = j;
                  localObject3 = this.TAG;
                  k = j;
                  StringBuilder localStringBuilder = new StringBuilder();
                  k = j;
                  localStringBuilder.append("panelData: ");
                  k = j;
                  localStringBuilder.append(localPanelData);
                  k = j;
                  QLog.i((String)localObject3, 2, localStringBuilder.toString());
                }
                k = j;
                if (localPanelData.jdField_a_of_type_Int == 0)
                {
                  i = j | 0x1;
                }
                else
                {
                  if (paramBaseSessionInfo != null)
                  {
                    k = j;
                    if (((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatActivityUtil$isTempConv(paramBaseSessionInfo))
                    {
                      n = j;
                      break label903;
                    }
                  }
                  k = j;
                  if (localPanelData.jdField_a_of_type_Int == 1)
                  {
                    n = j;
                    k = j;
                    if (!verifyLuckBySession(paramBaseSessionInfo)) {
                      break label903;
                    }
                    i = j | 0x2;
                  }
                  else
                  {
                    k = j;
                    if (localPanelData.jdField_a_of_type_Int == 2)
                    {
                      n = j;
                      k = j;
                      if (!verifyLingBySession(paramBaseSessionInfo)) {
                        break label903;
                      }
                      i = j | 0x4;
                    }
                    else
                    {
                      k = j;
                      if (localPanelData.jdField_a_of_type_Int == 6)
                      {
                        n = j;
                        k = j;
                        if (!verifyLingBySession(paramBaseSessionInfo)) {
                          break label903;
                        }
                        i = j | 0x8;
                      }
                      else
                      {
                        k = j;
                        if (localPanelData.jdField_a_of_type_Int == 3)
                        {
                          k = j;
                          if (localPanelData.jdField_a_of_type_OrgJsonJSONObject == null)
                          {
                            n = j;
                            break label903;
                          }
                          k = j;
                          i = localPanelData.jdField_a_of_type_OrgJsonJSONObject.optInt("entry", 0);
                          k = j;
                          int i1 = localPanelData.jdField_a_of_type_OrgJsonJSONObject.optInt("theme_id", 0);
                          n = j;
                          if (i < 0) {
                            break label903;
                          }
                          n = j;
                          if (i > 1) {
                            break label903;
                          }
                          n = j;
                          if (i1 < 2) {
                            break label903;
                          }
                          i = j;
                          if (i1 > 127)
                          {
                            n = j;
                            break label903;
                          }
                        }
                        else
                        {
                          k = j;
                          if (localPanelData.jdField_a_of_type_Int == 4)
                          {
                            n = j;
                            k = j;
                            if (localPanelData.jdField_a_of_type_OrgJsonJSONObject == null) {
                              break label903;
                            }
                            i = j;
                            k = j;
                            if (TextUtils.isEmpty(localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("url")))
                            {
                              n = j;
                              break label903;
                            }
                          }
                          else
                          {
                            k = j;
                            if (localPanelData.jdField_a_of_type_Int == 8)
                            {
                              n = j;
                              break label903;
                            }
                            k = j;
                            if (localPanelData.jdField_a_of_type_Int == 10)
                            {
                              i = j;
                              k = j;
                              if (!verifyDrawHbParams(localPanelData))
                              {
                                n = j;
                                break label903;
                              }
                            }
                            else
                            {
                              k = j;
                              if (localPanelData.jdField_a_of_type_Int == 11)
                              {
                                i = j;
                                if (paramBaseSessionInfo != null)
                                {
                                  i = j;
                                  k = j;
                                  if (!isGroupSession(paramBaseSessionInfo.jdField_a_of_type_Int))
                                  {
                                    n = j;
                                    break label903;
                                  }
                                }
                              }
                              else
                              {
                                k = j;
                                if (localPanelData.jdField_a_of_type_Int == 12)
                                {
                                  n = j;
                                  k = j;
                                  if (localPanelData.jdField_a_of_type_OrgJsonJSONObject == null) {
                                    break label903;
                                  }
                                  i = j;
                                  k = j;
                                  if (TextUtils.isEmpty(localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("schema")))
                                  {
                                    n = j;
                                    break label903;
                                  }
                                }
                                else
                                {
                                  k = j;
                                  if (localPanelData.jdField_a_of_type_Int == 15)
                                  {
                                    i = j;
                                    k = j;
                                    if (!verifyKuaKuaHbParams(localPanelData))
                                    {
                                      n = j;
                                      break label903;
                                    }
                                  }
                                  else
                                  {
                                    i = j;
                                    k = j;
                                    if (localPanelData.jdField_a_of_type_Int == 16)
                                    {
                                      i = j;
                                      k = j;
                                      if (!verifyShengpiziHbParams(localPanelData))
                                      {
                                        n = j;
                                        break label903;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                k = i;
                if (localPanelData.jdField_a_of_type_OrgJsonJSONObject == null)
                {
                  k = i;
                  localArrayList.add(localPanelData);
                  n = i;
                }
                else
                {
                  n = i;
                  k = i;
                  if (isValidDate(localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("begintime", ""), localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("endtime", "")))
                  {
                    k = i;
                    localArrayList.add(localPanelData);
                    n = i;
                  }
                }
              }
              label903:
              m += 1;
              j = n;
            }
            catch (Throwable localThrowable1)
            {
              i = k;
              break label932;
            }
          }
        }
      }
      i = 0;
    }
    catch (Throwable localThrowable2)
    {
      i = 0;
      label932:
      localThrowable2.printStackTrace();
    }
    label937:
    if ((i & 0x1) != 1) {
      localArrayList.add(0, DEFAULT_PANEL_DATA.get(Integer.valueOf(0)));
    }
    if (((i & 0x2) != 2) && (verifyLuckBySession(paramBaseSessionInfo))) {
      localArrayList.add(0, DEFAULT_PANEL_DATA.get(Integer.valueOf(1)));
    }
    return localArrayList;
  }
  
  public List<PanelTabData> getPanelTabList(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = isGroupSession(paramInt);
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = QWalletTools.a();
        if (localObject1 != null)
        {
          Object localObject2 = (IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "");
          localObject1 = ((IQWalletConfigService)localObject2).getArray("redPackPanel", new String[] { "panelTabList" });
          localObject2 = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#27BEF6", new String[] { "themeInfo", "fontColorTab" });
          if (localObject1 != null)
          {
            int j = 0;
            if (j < ((JSONArray)localObject1).length())
            {
              Object localObject3 = ((JSONArray)localObject1).getJSONObject(j);
              if ((localObject3 == null) || ((isGroupTab(((JSONObject)localObject3).optInt("type", -1))) && (!bool))) {
                break label448;
              }
              PanelTabData localPanelTabData = new PanelTabData();
              localPanelTabData.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("id", "");
              localPanelTabData.jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("type", -1);
              localPanelTabData.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("name", "");
              localPanelTabData.jdField_c_of_type_JavaLangString = ((String)localObject2);
              localPanelTabData.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject3).optJSONObject("params");
              if (localPanelTabData.jdField_a_of_type_Int != 100) {
                if (localPanelTabData.jdField_a_of_type_Int != 102) {
                  break label451;
                }
              }
              if (localPanelTabData.jdField_a_of_type_OrgJsonJSONObject == null) {
                break label448;
              }
              localObject3 = localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.optString("url");
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label448;
              }
              if (localPanelTabData.jdField_a_of_type_Int != 100) {
                break label451;
              }
              if (paramInt != 1) {
                break label454;
              }
              i = 1;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject3);
              localStringBuilder.append("&type=");
              localStringBuilder.append(i);
              localStringBuilder.append("&uin=");
              localStringBuilder.append(paramString);
              localObject3 = localStringBuilder.toString();
              localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.put("url", localObject3);
              if (localPanelTabData.jdField_a_of_type_OrgJsonJSONObject == null) {
                localArrayList.add(localPanelTabData);
              } else if (isValidDate(localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.optString("begintime", ""), localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.optString("endtime", ""))) {
                localArrayList.add(localPanelTabData);
              }
              j += 1;
              continue;
            }
          }
        }
        return localArrayList;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      label448:
      continue;
      label451:
      continue;
      label454:
      if (paramInt == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public JSONObject getPopAd(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    String[] arrayOfString = null;
    Object localObject4 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      int i;
      try
      {
        Object localObject6 = QWalletTools.a();
        Object localObject3 = arrayOfString;
        if (localObject6 != null)
        {
          localObject2 = localObject1;
          localObject6 = (IQWalletConfigService)((BaseQQAppInterface)localObject6).getRuntimeService(IQWalletConfigService.class, "");
          localObject2 = localObject1;
          localObject3 = this.popAdCache;
          int j = 0;
          if (localObject3 == null)
          {
            localObject2 = localObject1;
            localObject3 = lock;
            localObject2 = localObject1;
            try
            {
              if (this.popAdCache == null)
              {
                localObject2 = ((IQWalletConfigService)localObject6).getArray("redPack", new String[] { "popAd" });
                if (localObject2 != null)
                {
                  this.popAdCache = new HashMap();
                  if (localObject2 != null)
                  {
                    i = 0;
                    if (i < ((JSONArray)localObject2).length())
                    {
                      localObject6 = ((JSONArray)localObject2).getJSONObject(i);
                      if (localObject6 == null) {
                        break label338;
                      }
                      String str = genCacheKeyBySkin(((JSONObject)localObject6).optInt("skinId", -1), ((JSONObject)localObject6).optInt("redPackChannel", -1));
                      if (TextUtils.isEmpty(str)) {
                        break label338;
                      }
                      this.popAdCache.put(str, localObject6);
                      break label338;
                    }
                  }
                }
              }
            }
            finally
            {
              localObject2 = localObject1;
            }
          }
          localObject2 = localObject1;
          localObject3 = arrayOfString;
          if (this.popAdCache != null)
          {
            localObject2 = localObject1;
            arrayOfString = genMatchKeys(paramInt1, paramInt2);
            localObject2 = localObject1;
            paramInt2 = arrayOfString.length;
            paramInt1 = j;
            localObject1 = localObject5;
            localObject3 = localObject1;
            if (paramInt1 < paramInt2)
            {
              localObject3 = arrayOfString[paramInt1];
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject2 = localObject1;
                localObject1 = (JSONObject)this.popAdCache.get(localObject3);
                if (localObject1 != null) {
                  return localObject1;
                }
              }
              paramInt1 += 1;
              continue;
            }
          }
        }
        return localObject3;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject3 = localObject2;
      }
      label338:
      i += 1;
    }
  }
  
  public List<String> getReadyResList()
  {
    return null;
  }
  
  public void getSkin(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if (paramRedPacketInfoBase != null)
    {
      if (paramOnGetSkinListener == null) {
        return;
      }
      try
      {
        Object localObject = QWalletTools.a();
        if (localObject == null) {
          return;
        }
        WeakReference localWeakReference = new WeakReference(paramOnGetSkinListener);
        RedPacketInfo localRedPacketInfo = new RedPacketInfo();
        localRedPacketInfo.type = 5;
        localRedPacketInfo.skinType = paramRedPacketInfoBase.skinType;
        localRedPacketInfo.skinId = paramRedPacketInfoBase.skinId;
        localRedPacketInfo.bigAnimId = paramRedPacketInfoBase.bigAnimId;
        localRedPacketInfo.isCache = paramRedPacketInfoBase.isCache;
        localObject = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a((BaseQQAppInterface)localObject, localRedPacketInfo, new RedPacketManagerImpl.4(this, paramRedPacketInfoBase, localWeakReference));
        if (localObject != null)
        {
          ((RedPacketInfo)localObject).isCache = paramRedPacketInfoBase.isCache;
          paramOnGetSkinListener.onGetSkin((RedPacketInfoBase)localObject);
          return;
        }
      }
      catch (Throwable paramRedPacketInfoBase)
      {
        paramRedPacketInfoBase.printStackTrace();
      }
    }
  }
  
  public JSONObject getTail(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    String[] arrayOfString = null;
    Object localObject4 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      int i;
      try
      {
        Object localObject6 = QWalletTools.a();
        Object localObject3 = arrayOfString;
        if (localObject6 != null)
        {
          localObject2 = localObject1;
          localObject6 = (IQWalletConfigService)((BaseQQAppInterface)localObject6).getRuntimeService(IQWalletConfigService.class, "");
          localObject2 = localObject1;
          localObject3 = this.tailCache;
          int j = 0;
          if (localObject3 == null)
          {
            localObject2 = localObject1;
            localObject3 = lock;
            localObject2 = localObject1;
            try
            {
              if (this.tailCache == null)
              {
                localObject2 = ((IQWalletConfigService)localObject6).getArray("redPack", new String[] { "tail" });
                if (localObject2 != null)
                {
                  this.tailCache = new HashMap();
                  if (localObject2 != null)
                  {
                    i = 0;
                    if (i < ((JSONArray)localObject2).length())
                    {
                      localObject6 = ((JSONArray)localObject2).getJSONObject(i);
                      if (localObject6 == null) {
                        break label338;
                      }
                      String str = genCacheKeyBySkin(((JSONObject)localObject6).optInt("skinId", -1), ((JSONObject)localObject6).optInt("redPackType", -1));
                      if (TextUtils.isEmpty(str)) {
                        break label338;
                      }
                      this.tailCache.put(str, localObject6);
                      break label338;
                    }
                  }
                }
              }
            }
            finally
            {
              localObject2 = localObject1;
            }
          }
          localObject2 = localObject1;
          localObject3 = arrayOfString;
          if (this.tailCache != null)
          {
            localObject2 = localObject1;
            arrayOfString = genMatchKeys(paramInt1, paramInt2);
            localObject2 = localObject1;
            paramInt2 = arrayOfString.length;
            paramInt1 = j;
            localObject1 = localObject5;
            localObject3 = localObject1;
            if (paramInt1 < paramInt2)
            {
              localObject3 = arrayOfString[paramInt1];
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject2 = localObject1;
                localObject1 = (JSONObject)this.tailCache.get(localObject3);
                if (localObject1 != null) {
                  return localObject1;
                }
              }
              paramInt1 += 1;
              continue;
            }
          }
        }
        return localObject3;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject3 = localObject2;
      }
      label338:
      i += 1;
    }
  }
  
  public ThemeRedPkgConfig getThemeRedPkgConfById(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      localObject1 = QWalletTools.a();
      if (localObject1 != null)
      {
        localObject1 = ((IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "")).getArray("redPackPanel", new String[] { "panelRedPkgList" });
        if (localObject1 != null)
        {
          int j = ((JSONArray)localObject1).length();
          if (j > 0)
          {
            int i = 0;
            while (i < j)
            {
              Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              if ((localObject2 != null) && (((JSONObject)localObject2).optInt("type", -1) == 3))
              {
                JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject("params");
                if (localJSONObject != null)
                {
                  int k = localJSONObject.optInt("theme_id", -1);
                  if (paramInt == k)
                  {
                    localObject1 = new ThemeRedPkgConfig();
                    try
                    {
                      ((ThemeRedPkgConfig)localObject1).jdField_a_of_type_Int = k;
                      ((ThemeRedPkgConfig)localObject1).jdField_a_of_type_JavaLangString = localJSONObject.optString("name", "");
                      ((ThemeRedPkgConfig)localObject1).g = localJSONObject.optString("begintime", "");
                      ((ThemeRedPkgConfig)localObject1).h = localJSONObject.optString("endtime", "");
                      ((ThemeRedPkgConfig)localObject1).jdField_c_of_type_Int = localJSONObject.optInt("entry", 0);
                      ((ThemeRedPkgConfig)localObject1).jdField_b_of_type_Int = localJSONObject.optInt("resource_type", 0);
                      if (!isValidDate(((ThemeRedPkgConfig)localObject1).g, ((ThemeRedPkgConfig)localObject1).h)) {
                        return null;
                      }
                      Object localObject4 = localJSONObject.optString("prefix", "");
                      localObject2 = localObject4;
                      if (TextUtils.isEmpty((CharSequence)localObject4)) {
                        localObject2 = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
                      }
                      localObject4 = new StringBuilder();
                      ((StringBuilder)localObject4).append((String)localObject2);
                      ((StringBuilder)localObject4).append(k);
                      ((ThemeRedPkgConfig)localObject1).jdField_c_of_type_JavaLangString = ((StringBuilder)localObject4).toString();
                      localObject4 = new StringBuilder();
                      ((StringBuilder)localObject4).append((String)localObject2);
                      ((StringBuilder)localObject4).append(k);
                      ((StringBuilder)localObject4).append("_bg");
                      ((ThemeRedPkgConfig)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject4).toString();
                      ((ThemeRedPkgConfig)localObject1).jdField_d_of_type_JavaLangString = localJSONObject.optString("tail_word", "");
                      ((ThemeRedPkgConfig)localObject1).jdField_e_of_type_JavaLangString = localJSONObject.optString("tail_color", "");
                      ((ThemeRedPkgConfig)localObject1).f = localJSONObject.optString("tail_url", "");
                      localObject2 = localJSONObject.optJSONObject("c2c");
                      if (localObject2 != null)
                      {
                        ((ThemeRedPkgConfig)localObject1).jdField_a_of_type_OrgJsonJSONArray = ((JSONObject)localObject2).optJSONArray("wish_array");
                        ((ThemeRedPkgConfig)localObject1).jdField_b_of_type_OrgJsonJSONArray = ((JSONObject)localObject2).optJSONArray("money_array");
                      }
                      localObject4 = localJSONObject.optJSONObject("group");
                      localObject2 = localObject1;
                      if (localObject4 == null) {
                        break label519;
                      }
                      ((ThemeRedPkgConfig)localObject1).jdField_c_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_wish_array");
                      ((ThemeRedPkgConfig)localObject1).jdField_d_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_money_array");
                      ((ThemeRedPkgConfig)localObject1).jdField_e_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_total_num_array");
                      return localObject1;
                    }
                    catch (Throwable localThrowable1) {}
                  }
                }
              }
              i += 1;
            }
          }
        }
      }
      return null;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject1 = null;
      localThrowable2.printStackTrace();
      Object localObject3 = localObject1;
      label519:
      return localObject3;
    }
  }
  
  public void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if (paramRedPacketInfoBase != null)
    {
      if (paramOnGetSkinListener == null) {
        return;
      }
      try
      {
        BaseQQAppInterface localBaseQQAppInterface = QWalletTools.a();
        if (localBaseQQAppInterface == null) {
          return;
        }
        RedPacketInfo localRedPacketInfo = new RedPacketInfo();
        localRedPacketInfo.type = 6;
        localRedPacketInfo.templateId = paramRedPacketInfoBase.templateId;
        paramRedPacketInfoBase = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(localBaseQQAppInterface, localRedPacketInfo, new RedPacketManagerImpl.5(this, paramOnGetSkinListener));
        if (paramRedPacketInfoBase != null)
        {
          paramOnGetSkinListener.onGetSkin(paramRedPacketInfoBase);
          return;
        }
      }
      catch (Throwable paramRedPacketInfoBase)
      {
        paramRedPacketInfoBase.printStackTrace();
      }
    }
  }
  
  public boolean isRiskSwitchOpen()
  {
    for (;;)
    {
      try
      {
        Object localObject = QWalletTools.a();
        if (localObject != null)
        {
          localObject = (IQWalletConfigService)((BaseQQAppInterface)localObject).getRuntimeService(IQWalletConfigService.class, "");
          bool = true;
          if (((IQWalletConfigService)localObject).getInt("redPack", 0, new String[] { "riskSwitch" }) == 0) {
            break label99;
          }
          if (QLog.isColorLevel())
          {
            localObject = this.TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isRiskSwitchOpen = ");
            localStringBuilder.append(bool);
            QLog.i((String)localObject, 2, localStringBuilder.toString());
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return false;
      label99:
      boolean bool = false;
    }
  }
  
  public boolean isValidDate(String paramString1, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = QWalletTools.b(paramString1);
    long l3 = QWalletTools.b(paramString2);
    boolean bool2 = true;
    boolean bool1;
    if (l1 >= l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      bool1 = bool2;
      if (l3 != -1L) {
        return l1 <= l3;
      }
    }
    return bool1;
  }
  
  public void onActiveAccount()
  {
    HashMap localHashMap = this.mReqGroupAvailableListListeners;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected void onGetGroupAvailableList(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject = (GetGroupRedPackListReq)paramBundle.getSerializable("req");
    GetGroupRedPackListRsp localGetGroupRedPackListRsp = (GetGroupRedPackListRsp)paramBundle.getSerializable("rsp");
    paramBundle = QWalletTools.a();
    if (paramBundle == null) {
      return;
    }
    int i;
    if (localGetGroupRedPackListRsp != null) {
      i = localGetGroupRedPackListRsp.iRetCode;
    } else {
      i = -1;
    }
    String str = paramBundle.getCurrentAccountUin();
    if (localObject != null) {
      paramBundle = ((GetGroupRedPackListReq)localObject).sGroupUin;
    } else {
      paramBundle = "";
    }
    int j;
    if (localObject != null) {
      j = ((GetGroupRedPackListReq)localObject).iGroupType;
    } else {
      j = 0;
    }
    StringBuilder localStringBuilder1;
    if ((!TextUtils.isEmpty(paramBundle)) && (!TextUtils.isEmpty(str)))
    {
      localStringBuilder1 = null;
      HashMap localHashMap = this.mReqGroupAvailableListListeners;
      localObject = localStringBuilder1;
      if (localHashMap != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramBundle);
        localStringBuilder2.append("_");
        localStringBuilder2.append(j);
        localObject = localStringBuilder1;
        if (localHashMap.get(localStringBuilder2.toString()) != null)
        {
          localObject = this.mReqGroupAvailableListListeners;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramBundle);
          localStringBuilder1.append("_");
          localStringBuilder1.append(j);
          localObject = (IRedPacket.OnGetAvailableListListener)((HashMap)localObject).get(localStringBuilder1.toString());
        }
      }
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onGetGroupAavailableList listener is null");
        }
        return;
      }
      if ((paramBoolean) && (i == 0))
      {
        filterHbHasGrabbed(str, paramBundle, j, (IRedPacket.OnGetAvailableListListener)localObject, localGetGroupRedPackListRsp, true);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = this.TAG;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onGetGroupAavailableList error. isSuccess:");
        localStringBuilder1.append(paramBoolean);
        localStringBuilder1.append(" retCode:");
        localStringBuilder1.append(i);
        QLog.d((String)localObject, 2, localStringBuilder1.toString());
      }
      ThreadManager.getFileThreadHandler().post(new RedPacketManagerImpl.6(this, str, paramBundle, j));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.TAG;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onGetGroupAavailableList groupUin or myUin is null, retCode:");
      localStringBuilder1.append(i);
      localStringBuilder1.append(" groupUin:");
      localStringBuilder1.append(paramBundle);
      QLog.d((String)localObject, 2, localStringBuilder1.toString());
    }
  }
  
  public boolean onGetThemeConfig(int paramInt)
  {
    return getThemeRedPkgConfById(paramInt) != null;
  }
  
  public void onUpdate(int paramInt)
  {
    if (paramInt == 1) {
      synchronized (lock)
      {
        if (this.popAdCache != null)
        {
          this.popAdCache.clear();
          this.popAdCache = null;
        }
        if (this.tailCache != null)
        {
          this.tailCache.clear();
          this.tailCache = null;
        }
        return;
      }
    }
  }
  
  public void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    if (!this.observers.contains(paramBusinessObserver)) {
      this.observers.add(paramBusinessObserver);
    }
  }
  
  public void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener)
  {
    if ((paramOnGetAvailableListListener != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramInt != 1) && (paramInt != 3000)) {
        return;
      }
      Object localObject = QWalletTools.a();
      if (localObject == null) {
        return;
      }
      if (paramInt == 1) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      String str = ((BaseQQAppInterface)localObject).getCurrentUin();
      localObject = (TicketManager)((BaseQQAppInterface)localObject).getManager(2);
      if (localObject != null) {
        localObject = ((TicketManager)localObject).getSkey(str);
      } else {
        localObject = "";
      }
      if (this.mReqGroupAvailableListListeners == null) {
        this.mReqGroupAvailableListListeners = new HashMap();
      }
      HashMap localHashMap = this.mReqGroupAvailableListListeners;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      localHashMap.put(localStringBuilder.toString(), paramOnGetAvailableListListener);
      paramOnGetAvailableListListener = new GetGroupRedPackListReq();
      paramOnGetAvailableListListener.sGroupUin = paramString;
      paramOnGetAvailableListListener.iPlatForm = 1;
      paramOnGetAvailableListListener.sQQVersion = DeviceInfoUtil.a(MobileQQ.sMobileQQ);
      paramOnGetAvailableListListener.iGroupType = paramInt;
      paramOnGetAvailableListListener.sUin = str;
      paramOnGetAvailableListListener.sSkey = ((String)localObject);
      QWalletCommonServlet.a(paramOnGetAvailableListListener, this.mObserver);
      NotifyMsgApiImpl.preloadData();
    }
  }
  
  public void requestRedPacketSkinList()
  {
    requestRedPacketSkinList("", "", 0);
  }
  
  public void requestRedPacketSkinList(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      BaseQQAppInterface localBaseQQAppInterface = QWalletTools.a();
      if (localBaseQQAppInterface != null)
      {
        if (this.observers.isEmpty()) {
          return;
        }
        ThreadManager.post(new RedPacketManagerImpl.1(this, localBaseQQAppInterface), 5, null, false);
        QWalletCommonServlet.a(new GetSkinListReq(localBaseQQAppInterface.getLongAccountUin(), 0, "8.7.0", "Android", Build.MODEL, paramString2, paramString1, paramInt), new RedPacketManagerImpl.2(this, paramString1, localBaseQQAppInterface));
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "requestRedPacketSkinList");
        }
      }
      else {}
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setPanelDataList(List<PanelData> paramList)
  {
    CURRENT_PANEL_DATA.clear();
    CURRENT_PANEL_DATA.addAll(paramList);
  }
  
  public void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.a();
    if (localBaseQQAppInterface != null)
    {
      if (paramBusinessObserver == null) {
        return;
      }
      QWalletCommonServlet.a(new SetSelectedSkinReq(localBaseQQAppInterface.getLongAccountUin(), 0, "8.7.0", "Android", Build.MODEL, paramInt), new RedPacketManagerImpl.3(this, paramBusinessObserver));
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setSelectedSkin2ServerIfChanged");
      }
    }
  }
  
  public void unregistRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    this.observers.remove(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl
 * JD-Core Version:    0.7.0.1
 */