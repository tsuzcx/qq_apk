package com.tencent.mobileqq.vastrash;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;

class ColorRingPlayer$8
  implements Runnable
{
  ColorRingPlayer$8(ColorRingPlayer paramColorRingPlayer, String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actionName", this.b);
    localBundle.putLong("id", this.jdField_a_of_type_Long);
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle = DataFactory.a("reportColorRing", "", this.this$0.a.key, localBundle);
    this.this$0.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.8
 * JD-Core Version:    0.7.0.1
 */