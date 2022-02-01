package io.flutter.plugin.editing;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.autofill.AutofillManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler;

class TextInputPlugin$1
  implements TextInputChannel.TextInputMethodHandler
{
  TextInputPlugin$1(TextInputPlugin paramTextInputPlugin) {}
  
  public void clearClient()
  {
    TextInputPlugin.access$700(this.this$0);
  }
  
  public void finishAutofillContext(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (TextInputPlugin.access$400(this.this$0) == null) {
        return;
      }
      if (paramBoolean)
      {
        TextInputPlugin.access$400(this.this$0).commit();
        return;
      }
      TextInputPlugin.access$400(this.this$0).cancel();
    }
  }
  
  public void hide()
  {
    TextInputPlugin localTextInputPlugin = this.this$0;
    TextInputPlugin.access$200(localTextInputPlugin, TextInputPlugin.access$000(localTextInputPlugin));
  }
  
  public void requestAutofill()
  {
    TextInputPlugin.access$300(this.this$0);
  }
  
  public void sendAppPrivateCommand(String paramString, Bundle paramBundle)
  {
    this.this$0.sendTextInputAppPrivateCommand(paramString, paramBundle);
  }
  
  public void setClient(int paramInt, TextInputChannel.Configuration paramConfiguration)
  {
    this.this$0.setTextInputClient(paramInt, paramConfiguration);
  }
  
  public void setEditableSizeAndTransform(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
  {
    TextInputPlugin.access$600(this.this$0, paramDouble1, paramDouble2, paramArrayOfDouble);
  }
  
  public void setEditingState(TextInputChannel.TextEditState paramTextEditState)
  {
    TextInputPlugin localTextInputPlugin = this.this$0;
    localTextInputPlugin.setTextInputEditingState(TextInputPlugin.access$000(localTextInputPlugin), paramTextEditState);
  }
  
  public void setPlatformViewClient(int paramInt)
  {
    TextInputPlugin.access$500(this.this$0, paramInt);
  }
  
  public void show()
  {
    TextInputPlugin localTextInputPlugin = this.this$0;
    TextInputPlugin.access$100(localTextInputPlugin, TextInputPlugin.access$000(localTextInputPlugin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin.1
 * JD-Core Version:    0.7.0.1
 */