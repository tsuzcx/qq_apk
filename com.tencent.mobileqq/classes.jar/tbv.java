class tbv
  implements tey
{
  tbv(tbu paramtbu) {}
  
  public void a(boolean paramBoolean, teu paramteu)
  {
    veg.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramteu != null))
    {
      veg.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramteu.b), Integer.valueOf(paramteu.a));
      this.a.a(paramteu.b, paramteu.a);
      return;
    }
    veg.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbv
 * JD-Core Version:    0.7.0.1
 */