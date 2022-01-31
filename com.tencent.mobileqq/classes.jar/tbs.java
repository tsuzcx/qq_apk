class tbs
  implements tev
{
  tbs(tbr paramtbr) {}
  
  public void a(boolean paramBoolean, ter paramter)
  {
    ved.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramter != null))
    {
      ved.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramter.b), Integer.valueOf(paramter.a));
      this.a.a(paramter.b, paramter.a);
      return;
    }
    ved.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbs
 * JD-Core Version:    0.7.0.1
 */