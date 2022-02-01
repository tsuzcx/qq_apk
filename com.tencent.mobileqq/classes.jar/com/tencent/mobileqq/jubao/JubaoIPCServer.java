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
  private static JubaoIPCServer jdField_a_of_type_ComTencentMobileqqJubaoJubaoIPCServer;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ChatMessage> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<JubaoMsgData> jdField_b_of_type_JavaUtilArrayList;
  
  private JubaoIPCServer(String paramString)
  {
    super(paramString);
  }
  
  private QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static JubaoIPCServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqJubaoJubaoIPCServer == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqJubaoJubaoIPCServer == null) {
          jdField_a_of_type_ComTencentMobileqqJubaoJubaoIPCServer = new JubaoIPCServer("JubaoIPCServer");
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqJubaoJubaoIPCServer;
  }
  
  public ArrayList<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    EIPCResult localEIPCResult = new EIPCResult();
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("receive_success", false);
    localEIPCResult.data = ((Bundle)localObject);
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    callbackResult(this.jdField_b_of_type_Int, localEIPCResult);
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication().getApplicationContext(), JubaoServlet.class);
    localNewIntent.putExtra("jubao_chat_uin", this.jdField_a_of_type_JavaLangString);
    localNewIntent.putExtra("jubao_group_code", this.jdField_b_of_type_JavaLangString);
    localNewIntent.putExtra("jubao_chat_type", this.jdField_a_of_type_Int);
    localNewIntent.putExtra("jubao_msg_list", this.jdField_b_of_type_JavaUtilArrayList);
    localNewIntent.putExtra("multi_msg_resID", paramString);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList<ChatMessage> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jubaoIpcServer onCall= ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",callbackId = ");
      localStringBuilder.append(paramInt);
      QLog.d("JubaoIPCServer", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("jubao_chat_uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("jubao_group_code");
    this.jdField_a_of_type_Int = paramBundle.getInt("jubao_chat_type");
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)paramBundle.getSerializable("jubao_msg_list"));
    paramString = a();
    paramBundle = new NewIntent(paramString.getApplication().getApplicationContext(), JubaoServlet.class);
    paramBundle.putExtra("jubao_chat_uin", this.jdField_a_of_type_JavaLangString);
    paramBundle.putExtra("jubao_group_code", this.jdField_b_of_type_JavaLangString);
    paramBundle.putExtra("jubao_chat_type", this.jdField_a_of_type_Int);
    paramBundle.putExtra("jubao_msg_list", this.jdField_b_of_type_JavaUtilArrayList);
    paramBundle.setObserver(this);
    paramString.startServlet(paramBundle);
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    paramBundle.putBoolean("receive_success", paramBoolean);
    localEIPCResult.data = paramBundle;
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramBundle != null) {
      paramBundle.clear();
    }
    callbackResult(this.jdField_b_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoIPCServer
 * JD-Core Version:    0.7.0.1
 */