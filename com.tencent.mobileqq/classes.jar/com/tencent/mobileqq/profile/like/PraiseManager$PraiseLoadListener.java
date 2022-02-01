package com.tencent.mobileqq.profile.like;

class PraiseManager$PraiseLoadListener
  implements PraiseManager.OnPraiseLoadListener
{
  public int a;
  public PraiseManager.OnPraiseLoadListener a;
  public int b;
  
  PraiseManager$PraiseLoadListener(PraiseManager paramPraiseManager) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    paramInt1 = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = paramInt1;
    if (paramInt1 == this.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
      paramPraiseInfo = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseLoadListener;
      if (paramPraiseInfo != null) {
        paramPraiseInfo.a(0, null, 0, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager.PraiseLoadListener
 * JD-Core Version:    0.7.0.1
 */