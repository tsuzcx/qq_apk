package com.tencent.mobileqq.jubao;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class JubaoIPCServer
  extends QIPCModule
  implements BusinessObserver
{
  private static JubaoIPCServer a;
  private ArrayList<ChatMessage> b;
  private String c;
  private String d;
  private int e;
  private String f;
  private ArrayList<JubaoMsgData> g;
  private String h;
  private int i;
  
  private JubaoIPCServer(String paramString)
  {
    super(paramString);
  }
  
  public static JubaoIPCServer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new JubaoIPCServer("JubaoIPCServer");
        }
      }
      finally {}
    }
    return a;
  }
  
  private QQAppInterface d()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = d();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication().getApplicationContext(), JubaoServlet.class);
    localNewIntent.putExtra("jubao_chat_uin", this.c);
    localNewIntent.putExtra("jubao_group_code", this.d);
    localNewIntent.putExtra("jubao_chat_type", this.e);
    localNewIntent.putExtra("jubao_msg_list", this.g);
    localNewIntent.putExtra("multi_msg_resID", paramString);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList<ChatMessage> paramArrayList)
  {
    this.b = new ArrayList(paramArrayList);
  }
  
  public void b()
  {
    EIPCResult localEIPCResult = new EIPCResult();
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("receive_success", false);
    localEIPCResult.data = ((Bundle)localObject);
    localObject = this.b;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    callbackResult(this.i, localEIPCResult);
  }
  
  public ArrayList<ChatMessage> c()
  {
    return this.b;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jubaoIpcServer onCall= ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",callbackId = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("JubaoIPCServer", 2, ((StringBuilder)localObject).toString());
    }
    this.i = paramInt;
    this.c = paramBundle.getString("jubao_chat_uin");
    this.d = paramBundle.getString("jubao_group_code");
    this.e = paramBundle.getInt("jubao_chat_type");
    this.f = paramBundle.getString("jubao_evil_uin");
    this.g = ((ArrayList)paramBundle.getSerializable("jubao_msg_list"));
    Object localObject = d();
    NewIntent localNewIntent = new NewIntent(((QQAppInterface)localObject).getApplication().getApplicationContext(), JubaoServlet.class);
    localNewIntent.putExtra("jubao_evil_uin", this.f);
    localNewIntent.putExtra("jubao_chat_uin", this.c);
    localNewIntent.putExtra("jubao_group_code", this.d);
    localNewIntent.putExtra("jubao_chat_type", this.e);
    localNewIntent.putExtra("jubao_msg_list", this.g);
    if (this.e == 10007)
    {
      this.h = paramBundle.getString("jubao_game_sig");
      localNewIntent.putExtra("jubao_game_sig", this.h);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("  jubaoIpcServer uin= ");
        paramBundle.append(paramString);
        paramBundle.append(",sig = ");
        paramBundle.append(this.h);
        QLog.d("JubaoIPCServer", 2, paramBundle.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("jubaoIpcServer onCall= ");
      paramBundle.append(paramString);
      paramBundle.append(",callbackId = ");
      paramBundle.append(paramInt);
      QLog.d("JubaoIPCServer", 2, paramBundle.toString());
    }
    localNewIntent.setObserver(this);
    ((QQAppInterface)localObject).startServlet(localNewIntent);
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    paramBundle.putBoolean("receive_success", paramBoolean);
    localEIPCResult.data = paramBundle;
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.clear();
    }
    callbackResult(this.i, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoIPCServer
 * JD-Core Version:    0.7.0.1
 */