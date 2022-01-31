package com.tencent.open.agent;

import bfbw;
import bfca;
import java.util.ArrayList;

public class OpenSdkFriendService$GetFriendListCallback$1
  implements Runnable
{
  public OpenSdkFriendService$GetFriendListCallback$1(bfca parambfca, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    if ("action_invite".equals(this.jdField_a_of_type_Bfca.a.d))
    {
      this.jdField_a_of_type_Bfca.a.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Bfca.a.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback.1
 * JD-Core Version:    0.7.0.1
 */