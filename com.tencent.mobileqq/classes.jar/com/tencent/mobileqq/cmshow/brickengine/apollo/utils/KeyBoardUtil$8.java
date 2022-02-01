package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

final class KeyBoardUtil$8
  implements View.OnClickListener
{
  KeyBoardUtil$8(ApolloRender paramApolloRender, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mEditorPop != null) && (this.b != null))
    {
      paramView = this.a.mEditorPop.getText().toString();
      this.a.mEditorPop.setText("");
      this.b.runRenderTask(new KeyBoardUtil.8.1(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.8
 * JD-Core Version:    0.7.0.1
 */