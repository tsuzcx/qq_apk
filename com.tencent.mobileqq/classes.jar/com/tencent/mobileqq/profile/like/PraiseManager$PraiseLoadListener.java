package com.tencent.mobileqq.profile.like;

class PraiseManager$PraiseLoadListener
  implements PraiseManager.OnPraiseLoadListener
{
  public int a;
  public int b;
  public PraiseManager.OnPraiseLoadListener c;
  
  PraiseManager$PraiseLoadListener(PraiseManager paramPraiseManager) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    paramInt1 = this.a + 1;
    this.a = paramInt1;
    if (paramInt1 == this.b)
    {
      this.d.b(this);
      paramPraiseInfo = this.c;
      if (paramPraiseInfo != null) {
        paramPraiseInfo.a(0, null, 0, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager.PraiseLoadListener
 * JD-Core Version:    0.7.0.1
 */