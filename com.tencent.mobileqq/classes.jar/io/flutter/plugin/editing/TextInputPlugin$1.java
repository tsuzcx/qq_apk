package io.flutter.plugin.editing;

import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler;

class TextInputPlugin$1
  implements TextInputChannel.TextInputMethodHandler
{
  TextInputPlugin$1(TextInputPlugin paramTextInputPlugin) {}
  
  public void clearClient()
  {
    TextInputPlugin.access$400(this.this$0);
  }
  
  public void hide()
  {
    TextInputPlugin.access$200(this.this$0, TextInputPlugin.access$000(this.this$0));
  }
  
  public void setClient(int paramInt, TextInputChannel.Configuration paramConfiguration)
  {
    this.this$0.setTextInputClient(paramInt, paramConfiguration);
  }
  
  public void setEditingState(TextInputChannel.TextEditState paramTextEditState)
  {
    this.this$0.setTextInputEditingState(TextInputPlugin.access$000(this.this$0), paramTextEditState);
  }
  
  public void setPlatformViewClient(int paramInt)
  {
    TextInputPlugin.access$300(this.this$0, paramInt);
  }
  
  public void show()
  {
    TextInputPlugin.access$100(this.this$0, TextInputPlugin.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin.1
 * JD-Core Version:    0.7.0.1
 */