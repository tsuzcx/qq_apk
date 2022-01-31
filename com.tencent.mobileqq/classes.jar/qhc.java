import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;

class qhc
  implements qgs
{
  qhc(qhb paramqhb, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    qgu localqgu = qhb.a(this.jdField_a_of_type_Qhb);
    if (paramInt == 0)
    {
      if (paramBoolean2) {
        RIJRedPacketManager.a().d();
      }
      if (paramBoolean1) {
        RIJRedPacketManager.a().c();
      }
      if (localqgu != null)
      {
        localqgu.a(paramBoolean2, paramBoolean1);
        if ((!paramBoolean2) || (paramBoolean1)) {
          break label85;
        }
        localqgu.a(paramString1, paramString2, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString);
      }
    }
    label85:
    while (qhb.a(this.jdField_a_of_type_Qhb) == null)
    {
      return;
      localqgu.j();
      return;
    }
    localqgu.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhc
 * JD-Core Version:    0.7.0.1
 */