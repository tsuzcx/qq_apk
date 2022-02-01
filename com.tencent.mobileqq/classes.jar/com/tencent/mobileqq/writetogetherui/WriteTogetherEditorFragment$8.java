package com.tencent.mobileqq.writetogetherui;

import com.tencent.mobileqq.writetogether.client.EditorController.OnEditorTextChangeListener;

class WriteTogetherEditorFragment$8
  implements EditorController.OnEditorTextChangeListener
{
  WriteTogetherEditorFragment$8(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0) && (WriteTogetherEditorFragment.a(this.a)) && (!WriteTogetherEditorFragment.b(this.a)))
    {
      this.a.i_(true);
      return;
    }
    this.a.i_(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.8
 * JD-Core Version:    0.7.0.1
 */