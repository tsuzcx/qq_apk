package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import org.json.JSONObject;

public class TextInputChannel$InputType
{
  public final boolean isDecimal;
  public final boolean isSigned;
  @NonNull
  public final TextInputChannel.TextInputType type;
  
  public TextInputChannel$InputType(@NonNull TextInputChannel.TextInputType paramTextInputType, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramTextInputType;
    this.isSigned = paramBoolean1;
    this.isDecimal = paramBoolean2;
  }
  
  @NonNull
  public static InputType fromJson(@NonNull JSONObject paramJSONObject)
  {
    return new InputType(TextInputChannel.TextInputType.fromValue(paramJSONObject.getString("name")), paramJSONObject.optBoolean("signed", false), paramJSONObject.optBoolean("decimal", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType
 * JD-Core Version:    0.7.0.1
 */