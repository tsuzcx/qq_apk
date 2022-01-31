class soz
  implements ssc
{
  soz(soy paramsoy) {}
  
  public void a(boolean paramBoolean, sry paramsry)
  {
    urk.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramsry != null))
    {
      urk.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramsry.b), Integer.valueOf(paramsry.a));
      this.a.a(paramsry.b, paramsry.a);
      return;
    }
    urk.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     soz
 * JD-Core Version:    0.7.0.1
 */