package com.tencent.mobileqq.qwallet.hb.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.IRedPacketProxy;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetAvailableListListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class RedPacketProxyImpl
  implements IRedPacketProxy
{
  public static final int FUNC_GET_POPAD = 4;
  public static final int FUNC_GET_SKINS = 1;
  public static final int FUNC_GET_VOICE_RATE_SOURCE = 5;
  public static final int FUNC_IS_HB_THEME_CONFIG_EXIST = 6;
  public static final int FUNC_IS_RISK_SWITCH_OPEN = 2;
  public static final int FUNC_REQUEST_SKINS = 3;
  public static final String KEY_CALLBACK = "key_callback";
  public static final String KEY_CHANNEL = "key_channel";
  public static final String KEY_FUNC = "key_func";
  public static final String KEY_IS_RISK_SWITCH_OEPN = "key_is_risk_switch_open";
  public static final String KEY_RED_PACKET_INFO = "key_red_packet_info";
  public static final String KEY_SKIN_ID = "key_skin_id";
  public static final String KEY_THEME_EXIST = "key_theme_exist";
  
  public RedPacketProxyImpl()
  {
    QWalletIPCConnector.a().a();
  }
  
  /* Error */
  public JSONObject getPopAd(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/mobileqq/qwallet/ipc/impl/QWalletIPCConnector:a	()Lcom/tencent/mobileqq/qwallet/ipc/impl/QWalletIPCConnector;
    //   3: invokevirtual 53	com/tencent/mobileqq/qwallet/ipc/impl/QWalletIPCConnector:a	()V
    //   6: new 60	android/os/Bundle
    //   9: dup
    //   10: invokespecial 61	android/os/Bundle:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 29
    //   17: iconst_4
    //   18: invokevirtual 65	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   21: aload_3
    //   22: ldc 38
    //   24: iload_1
    //   25: invokevirtual 65	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   28: aload_3
    //   29: ldc 26
    //   31: iload_2
    //   32: invokevirtual 65	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: invokestatic 71	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   38: invokevirtual 75	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   41: ldc 77
    //   43: ldc 79
    //   45: aload_3
    //   46: invokevirtual 85	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   49: astore 5
    //   51: aconst_null
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload 5
    //   59: ifnull +107 -> 166
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: invokevirtual 91	eipc/EIPCResult:isSuccess	()Z
    //   70: ifeq +96 -> 166
    //   73: aload 5
    //   75: getfield 95	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   78: ldc 97
    //   80: invokevirtual 101	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 4
    //   85: aload 5
    //   87: getfield 95	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   90: ldc 103
    //   92: invokevirtual 101	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 6
    //   97: aload 5
    //   99: getfield 95	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   102: ldc 105
    //   104: invokevirtual 109	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   107: istore_1
    //   108: aload 5
    //   110: getfield 95	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   113: ldc 111
    //   115: invokevirtual 101	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 5
    //   120: new 113	org/json/JSONObject
    //   123: dup
    //   124: invokespecial 114	org/json/JSONObject:<init>	()V
    //   127: astore_3
    //   128: aload_3
    //   129: ldc 97
    //   131: aload 4
    //   133: invokevirtual 118	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload_3
    //   138: ldc 103
    //   140: aload 6
    //   142: invokevirtual 118	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload_3
    //   147: ldc 105
    //   149: iload_1
    //   150: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokevirtual 118	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   156: pop
    //   157: aload_3
    //   158: ldc 111
    //   160: aload 5
    //   162: invokevirtual 118	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload_3
    //   167: areturn
    //   168: astore_3
    //   169: aconst_null
    //   170: areturn
    //   171: astore 4
    //   173: goto -7 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	RedPacketProxyImpl
    //   0	176	1	paramInt1	int
    //   0	176	2	paramInt2	int
    //   13	154	3	localObject1	Object
    //   168	1	3	localJSONException1	org.json.JSONException
    //   52	80	4	str1	String
    //   171	1	4	localJSONException2	org.json.JSONException
    //   49	112	5	localObject2	Object
    //   95	46	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   120	128	168	org/json/JSONException
    //   128	166	171	org/json/JSONException
  }
  
  public List<String> getReadyResList()
  {
    return null;
  }
  
  public IRedPacket getRedPacket()
  {
    if ((QWalletHelperImpl.getAppRuntime() instanceof BaseQQAppInterface)) {
      return (IRedPacket)QRoute.api(IRedPacketManager.class);
    }
    return (IRedPacket)QRoute.api(IRedPacketProxy.class);
  }
  
  public void getSkin(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if (paramRedPacketInfoBase != null)
    {
      if (paramOnGetSkinListener == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSkin | skinId = ");
        ((StringBuilder)localObject).append(paramRedPacketInfoBase.skinId);
        ((StringBuilder)localObject).append(",skinType=");
        ((StringBuilder)localObject).append(paramRedPacketInfoBase.skinType);
        QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("key_func", 1);
      ((Bundle)localObject).putParcelable("key_red_packet_info", paramRedPacketInfoBase);
      ((Bundle)localObject).putParcelable("key_callback", PreloadStaticApi.a(new RedPacketProxyImpl.1(this, null, paramOnGetSkinListener)));
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "red_packet", (Bundle)localObject, null);
    }
  }
  
  public JSONObject getTail(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if (paramRedPacketInfoBase != null)
    {
      if (paramOnGetSkinListener == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_func", 5);
      localBundle.putParcelable("key_red_packet_info", paramRedPacketInfoBase);
      localBundle.putParcelable("key_callback", PreloadStaticApi.a(new RedPacketProxyImpl.2(this, null, paramOnGetSkinListener)));
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "red_packet", localBundle, null);
    }
  }
  
  public boolean isRiskSwitchOpen()
  {
    QWalletIPCConnector.a().a();
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_func", 2);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "red_packet", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("key_is_risk_switch_open");
    }
    return false;
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
  
  public void onActiveAccount() {}
  
  public boolean onGetThemeConfig(int paramInt)
  {
    QWalletIPCConnector.a().a();
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_func", 6);
    ((Bundle)localObject).putInt("theme_id", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "red_packet", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("key_theme_exist");
    }
    return false;
  }
  
  public void onUpdate(int paramInt) {}
  
  public void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver) {}
  
  public void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener) {}
  
  public void requestRedPacketSkinList()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_func", 3);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "red_packet", localBundle, null);
  }
  
  public void requestRedPacketSkinList(String paramString1, String paramString2, int paramInt) {}
  
  public void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver) {}
  
  public void unregistRedPacketSkinListObserver(BusinessObserver paramBusinessObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketProxyImpl
 * JD-Core Version:    0.7.0.1
 */