package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel$Configuration
{
  @Nullable
  public final String actionLabel;
  public final boolean autocorrect;
  @Nullable
  public final TextInputChannel.Configuration.Autofill autofill;
  public final boolean enableSuggestions;
  @Nullable
  public final Configuration[] fields;
  @Nullable
  public final Integer inputAction;
  @NonNull
  public final TextInputChannel.InputType inputType;
  public final boolean obscureText;
  @NonNull
  public final TextInputChannel.TextCapitalization textCapitalization;
  
  public TextInputChannel$Configuration(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NonNull TextInputChannel.TextCapitalization paramTextCapitalization, @NonNull TextInputChannel.InputType paramInputType, @Nullable Integer paramInteger, @Nullable String paramString, @Nullable TextInputChannel.Configuration.Autofill paramAutofill, @Nullable Configuration[] paramArrayOfConfiguration)
  {
    this.obscureText = paramBoolean1;
    this.autocorrect = paramBoolean2;
    this.enableSuggestions = paramBoolean3;
    this.textCapitalization = paramTextCapitalization;
    this.inputType = paramInputType;
    this.inputAction = paramInteger;
    this.actionLabel = paramString;
    this.autofill = paramAutofill;
    this.fields = paramArrayOfConfiguration;
  }
  
  public static Configuration fromJson(@NonNull JSONObject paramJSONObject)
  {
    Object localObject3 = null;
    Object localObject4 = paramJSONObject.getString("inputAction");
    if (localObject4 != null)
    {
      Object localObject2;
      if (!paramJSONObject.isNull("fields"))
      {
        localObject5 = paramJSONObject.getJSONArray("fields");
        localObject2 = new Configuration[((JSONArray)localObject5).length()];
        int i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localObject2.length) {
            break;
          }
          localObject2[i] = fromJson(((JSONArray)localObject5).getJSONObject(i));
          i += 1;
        }
      }
      Object localObject1 = null;
      localObject4 = inputActionFromTextInputAction((String)localObject4);
      boolean bool1 = paramJSONObject.optBoolean("obscureText");
      boolean bool2 = paramJSONObject.optBoolean("autocorrect", true);
      boolean bool3 = paramJSONObject.optBoolean("enableSuggestions");
      Object localObject5 = TextInputChannel.TextCapitalization.fromValue(paramJSONObject.getString("textCapitalization"));
      TextInputChannel.InputType localInputType = TextInputChannel.InputType.fromJson(paramJSONObject.getJSONObject("inputType"));
      if (paramJSONObject.isNull("actionLabel"))
      {
        localObject2 = null;
        if (!paramJSONObject.isNull("autofill")) {
          break label189;
        }
      }
      label189:
      for (paramJSONObject = localObject3;; paramJSONObject = TextInputChannel.Configuration.Autofill.fromJson(paramJSONObject.getJSONObject("autofill")))
      {
        return new Configuration(bool1, bool2, bool3, (TextInputChannel.TextCapitalization)localObject5, localInputType, (Integer)localObject4, (String)localObject2, paramJSONObject, localObject1);
        localObject2 = paramJSONObject.getString("actionLabel");
        break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration
 * JD-Core Version:    0.7.0.1
 */