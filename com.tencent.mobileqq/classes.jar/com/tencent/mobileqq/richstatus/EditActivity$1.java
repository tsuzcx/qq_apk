package com.tencent.mobileqq.richstatus;

class EditActivity$1
  implements IActionListener
{
  EditActivity$1(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      ActionInfo localActionInfo = EditActivity.b(this.a).a(EditActivity.a(this.a).actionId);
      if (localActionInfo != null)
      {
        EditActivity.a(this.a).actionText = localActionInfo.f;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.1
 * JD-Core Version:    0.7.0.1
 */