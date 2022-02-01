package com.tencent.mobileqq.vas;

import android.os.Bundle;
import arpd;
import arph;
import bgxg;

public class ColorRingPlayer$8
  implements Runnable
{
  public ColorRingPlayer$8(bgxg parambgxg, String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actionName", this.b);
    localBundle.putLong("id", this.jdField_a_of_type_Long);
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle = arph.a("reportColorRing", "", this.this$0.a.key, localBundle);
    this.this$0.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingPlayer.8
 * JD-Core Version:    0.7.0.1
 */