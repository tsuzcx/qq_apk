package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bhpo;

public class VasResController$2
  implements Runnable
{
  public VasResController$2(bhpo parambhpo, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    String[] arrayOfString = this.this$0.a(this.jdField_a_of_type_JavaLangString);
    Message localMessage = bhpo.a(this.this$0).obtainMessage();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1);
    localBundle.putStringArray("pngs", arrayOfString);
    localBundle.putInt("interval", this.jdField_a_of_type_Int);
    localBundle.putInt("repeatTimes", this.b);
    localMessage.setData(localBundle);
    localMessage.what = 10001;
    bhpo.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResController.2
 * JD-Core Version:    0.7.0.1
 */