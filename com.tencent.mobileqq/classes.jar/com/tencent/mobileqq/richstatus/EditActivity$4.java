package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.text.ClickableImageSpan;

class EditActivity$4
  implements RichStatusEditText.RichStatusEditListener
{
  EditActivity$4(EditActivity paramEditActivity) {}
  
  public void a(ClickableImageSpan paramClickableImageSpan)
  {
    if (EditActivity.a(this.a) == paramClickableImageSpan)
    {
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setClickListener(null);
      }
      EditActivity.a(this.a, null);
    }
  }
  
  public boolean a(ClickableImageSpan paramClickableImageSpan)
  {
    return paramClickableImageSpan != EditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.4
 * JD-Core Version:    0.7.0.1
 */