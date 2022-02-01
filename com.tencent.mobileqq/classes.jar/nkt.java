import com.tencent.mobileqq.data.troop.TroopInfo;

class nkt
  extends andd
{
  nkt(nkr paramnkr) {}
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_a_of_type_Long = 0L;
    nkr.a(this.a, false);
    if (paramBoolean)
    {
      nkr.a(this.a, paramTroopInfo);
      return;
    }
    nkr.a(this.a, 2131718115, 1);
    this.a.jdField_a_of_type_Nku.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkt
 * JD-Core Version:    0.7.0.1
 */