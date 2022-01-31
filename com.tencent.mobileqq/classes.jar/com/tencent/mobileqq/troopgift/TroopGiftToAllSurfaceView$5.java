package com.tencent.mobileqq.troopgift;

import bado;
import badq;
import baeo;
import bcvi;
import bcvj;

public class TroopGiftToAllSurfaceView$5
  implements Runnable
{
  TroopGiftToAllSurfaceView$5(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TroopGiftToAllSurfaceView.a(this.this$0, new baeo(this.this$0, this.this$0.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b));
    TroopGiftToAllSurfaceView.a(this.this$0).a(TroopGiftToAllSurfaceView.a(this.this$0).jdField_a_of_type_Int / 2, TroopGiftToAllSurfaceView.a(this.this$0).b * TroopGiftToAllSurfaceView.a(this.this$0).f / 100);
    this.this$0.a(TroopGiftToAllSurfaceView.a(this.this$0));
    TroopGiftToAllSurfaceView.a(this.this$0).jdField_a_of_type_Int = 0;
    badq localbadq = new badq(500);
    localbadq.a(new bcvi(this));
    TroopGiftToAllSurfaceView.a(this.this$0).a(new bado[] { localbadq });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */