package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class AgentActivity$2
  implements Runnable
{
  AgentActivity$2(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "addExpiredRunnable run expired");
    AgentActivity.a(this.this$0);
    AgentActivity.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.2
 * JD-Core Version:    0.7.0.1
 */