package com.tencent.mobileqq.troopgift;

import bdes;
import bdeu;
import bdfs;
import bfzt;
import bfzu;

public class TroopGiftToAllSurfaceView$5
  implements Runnable
{
  TroopGiftToAllSurfaceView$5(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TroopGiftToAllSurfaceView.a(this.this$0, new bdfs(this.this$0, this.this$0.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b));
    TroopGiftToAllSurfaceView.a(this.this$0).a(TroopGiftToAllSurfaceView.a(this.this$0).jdField_a_of_type_Int / 2, TroopGiftToAllSurfaceView.a(this.this$0).b * TroopGiftToAllSurfaceView.a(this.this$0).f / 100);
    this.this$0.a(TroopGiftToAllSurfaceView.a(this.this$0));
    TroopGiftToAllSurfaceView.a(this.this$0).jdField_a_of_type_Int = 0;
    bdeu localbdeu = new bdeu(500);
    localbdeu.a(new bfzt(this));
    TroopGiftToAllSurfaceView.a(this.this$0).a(new bdes[] { localbdeu });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */