package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.widget.EditText;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;

final class KeyBoardUtil$5
  implements Runnable
{
  KeyBoardUtil$5(ApolloRender paramApolloRender, String paramString) {}
  
  public void run()
  {
    if ((this.a.mEditorPop != null) && (this.a.mEditorPop.getText().toString().compareToIgnoreCase(this.b) != 0))
    {
      this.a.mEditorPop.setText(this.b);
      this.a.mEditorPop.setSelection(this.b.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.5
 * JD-Core Version:    0.7.0.1
 */