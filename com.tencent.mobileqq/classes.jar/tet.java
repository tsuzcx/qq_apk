import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

class tet
  extends akuo
{
  tet(tes paramtes, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ved.b("LbsManager", "onLocationFinish.");
    boolean bool;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      bool = true;
      if (!bool) {
        break label114;
      }
      this.a.b = ter.a(paramSosoLbsInfo.a);
      ved.a("LbsManager", "onLocationFinish success, [longitude=%s, latitude=%s]", Integer.valueOf(this.a.b.b), Integer.valueOf(this.a.b.a));
    }
    for (;;)
    {
      if (!tes.a(this.a)) {
        this.a.a(bool, this.a.b);
      }
      this.a.a = false;
      return;
      bool = false;
      break;
      label114:
      ved.d("LbsManager", "onLocationFinish errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tet
 * JD-Core Version:    0.7.0.1
 */