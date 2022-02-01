package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import org.json.JSONObject;

public class TextInputChannel$TextEditState
{
  public final int selectionEnd;
  public final int selectionStart;
  @NonNull
  public final String text;
  
  public TextInputChannel$TextEditState(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    this.text = paramString;
    this.selectionStart = paramInt1;
    this.selectionEnd = paramInt2;
  }
  
  public static TextEditState fromJson(@NonNull JSONObject paramJSONObject)
  {
    return new TextEditState(paramJSONObject.getString("text"), paramJSONObject.getInt("selectionBase"), paramJSONObject.getInt("selectionExtent"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState
 * JD-Core Version:    0.7.0.1
 */