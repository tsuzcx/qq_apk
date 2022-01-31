package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel$Configuration
{
  @Nullable
  public final String actionLabel;
  public final boolean autocorrect;
  @Nullable
  public final Integer inputAction;
  @NonNull
  public final TextInputChannel.InputType inputType;
  public final boolean obscureText;
  @NonNull
  public final TextInputChannel.TextCapitalization textCapitalization;
  
  public TextInputChannel$Configuration(boolean paramBoolean1, boolean paramBoolean2, @NonNull TextInputChannel.TextCapitalization paramTextCapitalization, @NonNull TextInputChannel.InputType paramInputType, @Nullable Integer paramInteger, @Nullable String paramString)
  {
    this.obscureText = paramBoolean1;
    this.autocorrect = paramBoolean2;
    this.textCapitalization = paramTextCapitalization;
    this.inputType = paramInputType;
    this.inputAction = paramInteger;
    this.actionLabel = paramString;
  }
  
  public static Configuration fromJson(@NonNull JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getString("inputAction");
    if (localObject != null)
    {
      localObject = inputActionFromTextInputAction((String)localObject);
      boolean bool1 = paramJSONObject.optBoolean("obscureText");
      boolean bool2 = paramJSONObject.optBoolean("autocorrect", true);
      TextInputChannel.TextCapitalization localTextCapitalization = TextInputChannel.TextCapitalization.fromValue(paramJSONObject.getString("textCapitalization"));
      TextInputChannel.InputType localInputType = TextInputChannel.InputType.fromJson(paramJSONObject.getJSONObject("inputType"));
      if (paramJSONObject.isNull("actionLabel")) {}
      for (paramJSONObject = null;; paramJSONObject = paramJSONObject.getString("actionLabel")) {
        return new Configuration(bool1, bool2, localTextCapitalization, localInputType, (Integer)localObject, paramJSONObject);
      }
    }
    throw new JSONException("Configuration JSON missing 'inputAction' property.");
  }
  
  @NonNull
  private static Integer inputActionFromTextInputAction(@NonNull String paramString)
  {
    label88:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return Integer.valueOf(0);
        if (!paramString.equals("TextInputAction.previous")) {
          break label88;
        }
        i = 8;
        continue;
        if (!paramString.equals("TextInputAction.newline")) {
          break label88;
        }
        i = 0;
        continue;
        if (!paramString.equals("TextInputAction.go")) {
          break label88;
        }
        i = 4;
        continue;
        if (!paramString.equals("TextInputAction.search")) {
          break label88;
        }
        i = 5;
        continue;
        if (!paramString.equals("TextInputAction.send")) {
          break label88;
        }
        i = 6;
        continue;
        if (!paramString.equals("TextInputAction.none")) {
          break label88;
        }
        i = 1;
        continue;
        if (!paramString.equals("TextInputAction.next")) {
          break label88;
        }
        i = 7;
        continue;
        if (!paramString.equals("TextInputAction.done")) {
          break label88;
        }
        i = 3;
        continue;
        if (!paramString.equals("TextInputAction.unspecified")) {
          break label88;
        }
        i = 2;
      }
    }
    return Integer.valueOf(7);
    return Integer.valueOf(5);
    return Integer.valueOf(4);
    return Integer.valueOf(3);
    return Integer.valueOf(2);
    return Integer.valueOf(6);
    return Integer.valueOf(0);
    return Integer.valueOf(1);
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration
 * JD-Core Version:    0.7.0.1
 */