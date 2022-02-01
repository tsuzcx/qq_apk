import com.tencent.mobileqq.data.troop.TroopInfo;

class nrt
  extends aofu
{
  nrt(nrr paramnrr) {}
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_a_of_type_Long = 0L;
    nrr.a(this.a, false);
    if (paramBoolean)
    {
      nrr.a(this.a, paramTroopInfo);
      return;
    }
    nrr.a(this.a, 2131718500, 1);
    this.a.jdField_a_of_type_Nru.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrt
 * JD-Core Version:    0.7.0.1
 */